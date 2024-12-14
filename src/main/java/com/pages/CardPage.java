package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class CardPage extends BasePage {
    public CardPage(WebDriver givenDriver) {
        super(givenDriver);
    }

By byProductRemove = By.xpath("//td[@class='product-remove']");
public CardPage enterRemoveProduct() {
    wait.until(ExpectedConditions.visibilityOfElementLocated(byProductRemove)).click();
    return this;
}

// message adđ product success
public By byMessageAddProductSuccess = By.xpath("//div[@class='woocommerce-message' and @role='alert']//a[@class='button wc-forward' and contains(text(),'Tiếp tục xem sản phẩm')]");

}
