package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {
    

    protected WebDriver driver;
    // public WebDriverWait webDriverWait ;

    public BasePage(WebDriver givenDriver) {
        this.driver = givenDriver;
    }

    protected WebElement findElementByLocator(By locator) {
        return driver.findElement(locator);
    }
}
