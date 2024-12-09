package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class CartPage extends BasePage {
    public CartPage(WebDriver givenDriver) {
        super(givenDriver);
    }

    By byOptionOne = By.xpath("//a[text()='Bơm nước xe ']");
    By byXuatSu = By.xpath("//select[@id='pa_xuat-xu']/option[@value='germany']");
    By byBtnPlus = By.xpath("//button[@class='plus']");
    By byAdd = By.xpath("//button[contains(@class,'single_add_to_cart_button')]");
    By byIconCart2 = By.xpath("//div[@class='d-table-cell link-cart']//a/b[text()='2']");
    By byProductRemove = By.xpath("//td[@class='product-remove']");

    public By iconCart = By.xpath("//div[@class='d-table-cell link-cart']//a/b[text()='2']");
    public By successmessage = By.xpath("//a[@class='button wc-forward']");

    
    public CartPage clickOptionOne() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(byOptionOne)).click();
        return this;
    }

    public CartPage clickXuatXu() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(byXuatSu)).click();
        return this;
    }

    public CartPage clickIconPlus() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(byBtnPlus)).click();
        return this;
    }

    public CartPage clickAdd() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(byAdd)).click();
        return this;
    }

    // Element Card Page
    public CartPage removeProduct() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(byProductRemove)).click();
        return this;
    }

}
