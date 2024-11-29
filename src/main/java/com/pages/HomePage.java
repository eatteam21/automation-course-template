package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class HomePage extends BasePage {
    public HomePage(WebDriver givenDriver) {
        super(givenDriver);
    }

    // Element Home Page
    By bySeachBox = By.xpath("//input[@placeholder='Tìm kiếm...'][1]");

    public HomePage inputSeach(String valueSeach) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(bySeachBox)).sendKeys(valueSeach);
        return this;
    }
}
