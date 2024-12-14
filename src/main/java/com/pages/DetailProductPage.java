package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

public class DetailProductPage extends BasePage {
    public DetailProductPage(WebDriver givenDriver) {
        super(givenDriver);
        String dynamicText = "Bơm nước xe Mercedes SLK200, SLK300, GLK200, E260, C350-2742000207"; // Văn bản động cần kiểm tra
        boolean isElementDisplayed = isElementPresent(dynamicText); // Kiểm tra sự hiện diện của phần tử
        Assert.assertTrue(isElementDisplayed);
    }

    public boolean isElementPresent(String dynamicText) {
        try {
            String breadcrumb= wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//nav[@class='woocommerce-breadcrumb']"))).getText();
          System.out.println(breadcrumb);
          boolean display=breadcrumb.contains(dynamicText);
            return display;
        } catch (Exception e) {
            return false;
        }
    }
By byXuatSu = By.xpath("//select[@id='pa_xuat-xu']/option[@value='germany']");
    public DetailProductPage enterXuatXu() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(byXuatSu)).click();
        return this;
    }

    By byButtonPlus = By.xpath("//button[@class='plus']");
    public DetailProductPage enterIconPlus() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(byButtonPlus)).click();
        return this;
    }

    By byButtonAdd = By.xpath("//button[contains(@class,'single_add_to_cart_button')]");
    public DetailProductPage enterAdd() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(byButtonAdd)).click();
        return this;
    }

    public By byIconCart2 = By.xpath("//div[@class='d-table-cell link-cart']//a/b[text()='2']");


   

       
}