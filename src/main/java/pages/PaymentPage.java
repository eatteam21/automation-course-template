package pages;

import pages.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import java.util.List;

public class PaymentPage extends BasePage {
    public PaymentPage(WebDriver givenDriver) {
        super(givenDriver);
        //TODO Auto-generated constructor stub
    }

    By message=By.className("woocommerce-message");

    By product=By.xpath("//tr[@class='woocommerce-cart-form__cart-item cart_item']");

    By price=By.xpath("//td[@class='product-price']");

    By quanlity=By.xpath("//td[@class='product-quantity']//input[@title='SL']");

    By sub_total=By.xpath("//td[@class='product-subtotal']");

    By total_price=By.xpath("//td[@class='product-subtotal']");

    public String getMessage(){
        waitForElementVisible(message);
        return findElementByLocator(message).getText();
    }

    public void isTotalCorrect(){
        List <WebElement> products=driver.findElements(product);
        int totalPrice=0;
        for (WebElement product :products){
            // tính giá x số lượng của mỗi product
            String product_price = product.findElement(price).getText();
            product_price = product_price.substring(0,product_price.length()-1).replace(",","");
            String quality=product.findElement(quanlity).getAttribute("value");
            int actualSubtotal= Integer.parseInt(product_price)*Integer.parseInt(quality);
            // get tổng tạm tính của mỗi product
            String subtotal=product.findElement(sub_total).getText();
            int sub_total=Integer.parseInt(subtotal.substring(0,subtotal.length()-1).replace(",",""));
            Assert.assertEquals(actualSubtotal,sub_total);
            totalPrice=totalPrice+actualSubtotal;
        }
        // Verify Total
        String total=driver.findElement(total_price).getText();
        total=total.substring(0,total.length()-1).replace(",","");
        Assert.assertEquals(totalPrice,Integer.parseInt(total));
    }
}
