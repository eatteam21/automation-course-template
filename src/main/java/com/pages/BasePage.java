package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.functions.ExpectedCondition;

public class BasePage {
    

    protected WebDriver driver1;
    public WebDriverWait wait1;

    public BasePage(WebDriver givenDriver) {
        this.driver1 = givenDriver;
        this.wait1 = new WebDriverWait(givenDriver, 30);
    }

    protected WebElement findElementByLocator(By locator) {
        wait1.until(ExpectedConditions.visibilityOfElementLocated(locator));
        return driver1.findElement(locator);
    }
}
