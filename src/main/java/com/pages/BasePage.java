package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.pages.Driver.DriverManager;

public class BasePage {
    protected WebDriver driver;
    protected WebDriverWait wait;


    public BasePage(WebDriver givenDriver) { //constructor
        this.driver = givenDriver;
        wait = new WebDriverWait(driver, 10); // explicitwait
        PageFactory.initElements(this.driver, this);
    }


    protected WebElement findElementByLocator(By locator) {
        return this.driver.findElement(locator);
    }



    protected void waitForElementVisible(By locator) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    protected void waitForElementClickable(By locator) {
        wait.until(ExpectedConditions.elementToBeClickable(locator));
    }

    protected void waitForElementClickable2(WebElement locator) {
        wait.until(ExpectedConditions.elementToBeClickable(locator));
    }
}