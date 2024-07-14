package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class ProductPage extends BasePage {
    public ProductPage(WebDriver givenDriver) {
        super(givenDriver);
        //TODO Auto-generated constructor stub
    }

    By product_title=By.xpath("//h1[@class='product_title entry-title']");
    By xuatxu=By.id("pa_xuat-xu");

    By price=By.xpath("(//div[@class='woocommerce-variation single_variation']//span[@class='woocommerce-Price-amount amount'])[last()]");

    By addBtn=By.xpath("//button[contains(text(),'Thêm vào giỏ hàng')]");
    public String getProduct_title(){
        return findElementByLocator(product_title).getText();
    }
    public void selectCountry(String txt){
        Select objSelect =new Select(findElementByLocator(xuatxu));
        objSelect.selectByVisibleText(txt);
    }
    public String getProduct_price(){
        return findElementByLocator(price).getText();
    }
    public void clickAddBtn(){
        waitForElementClickable(addBtn);
        findElementByLocator(addBtn).click();
    }
}
