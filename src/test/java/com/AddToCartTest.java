package com;

import com.utils.BasicTest;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class AddToCartTest extends BasicTest {
    String username="linh@gmail.com";
    String password="Linhbap2911";
    String invalidUsername="linh1@gmail.com";
    String invalidPassword="Linhbap2912";
    @Test()
    public void SearchTest() throws Exception {
        // Launch website
        String url = "https://bantheme.xyz/hathanhauto/tai-khoan/";
        driver.get(url);
        Assert.assertEquals(driver.getCurrentUrl(), url);

        // Enter username
        driver.findElement(By.xpath("//input[@id='username']")).sendKeys(username);

        // Enter password
        driver.findElement(By.xpath("//input[@id='password']")).sendKeys(password);

        // Click login
        driver.findElement(By.xpath("//button[contains(text(),'Đăng nhập')]")).click();

        // Verify login successful
        Boolean display = driver.findElement(By.xpath("//p[contains(text(),'Từ trang quản lý tài khoản bạn có thể xem')]")).isDisplayed();
        Assert.assertTrue(display);

        // Search
        driver.findElement(By.xpath("//input[@id='s']")).sendKeys("Mercedes");
        WebElement result = driver.findElement(By.className("fs-sresult"));
        String script = "arguments[0].style.display = 'block'";
        ((JavascriptExecutor) driver).executeScript(script, result);
        Thread.sleep(5000);

        // click first result
        result.findElement(By.className("tt-selectable")).click();
        Thread.sleep(5000);

        // Get product title
        String product_title= driver.findElement(By.xpath("//h1[@class='product_title entry-title']")).getText();
        System.out.println(product_title);

        // Select xuất xứ
        Select objSelect =new Select(driver.findElement(By.id("pa_xuat-xu")));
        objSelect.selectByVisibleText("Germany");
        Thread.sleep(2000);

        // get product price
        String price=driver.findElement(By.xpath("(//div[@class='woocommerce-variation single_variation']//span[@class='woocommerce-Price-amount amount'])[last()]")).getText();
        System.out.println(price);

        // click thêm vào giỏ hàng
        driver.findElement(By.xpath("//button[contains(text(),'Thêm vào giỏ hàng')]")).click();
        Thread.sleep(5000);

        // Verify thêm vào giỏ hàng thành công
        String message= driver.findElement(By.className("woocommerce-message")).getText();
        System.out.println(message);
        String successMessage="đã được thêm vào giỏ hàng";
        Assert.assertTrue(message.contains(product_title));
        Assert.assertTrue(message.contains(successMessage));

        // get all rows of product, verify pricexquality=subtotal
        List <WebElement> products=driver.findElements(By.xpath("//tr[@class='woocommerce-cart-form__cart-item cart_item']"));
        int totalPrice=0;
        for (WebElement product :products){
            // tính giá x số lượng của mỗi product
            String product_price = product.findElement(By.xpath("//td[@class='product-price']")).getText();
            product_price = product_price.substring(0,product_price.length()-1).replace(",","");
            String quality=product.findElement(By.xpath("//td[@class='product-quantity']//input[@title='SL']")).getAttribute("value");
            int actualSubtotal= Integer.parseInt(product_price)*Integer.parseInt(quality);
            // get tổng tạm tính của mỗi product
            String subtotal=product.findElement(By.xpath("//td[@class='product-subtotal']")).getText();
            int sub_total=Integer.parseInt(subtotal.substring(0,subtotal.length()-1).replace(",",""));
            Assert.assertEquals(actualSubtotal,sub_total);
            totalPrice=totalPrice+actualSubtotal;
        }
        // Verify Total
        String total=driver.findElement(By.xpath("//td[@class='product-subtotal']")).getText();
        total=total.substring(0,total.length()-1).replace(",","");
        Assert.assertEquals(totalPrice,Integer.parseInt(total));
    }

}
