package com.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {
    public WebDriver driver;
    public WebDriverWait wait;

    protected BasePage(WebDriver givenDriver) {
        this.driver = givenDriver;
        this.wait = new WebDriverWait(givenDriver, 15);
        PageFactory.initElements(this.driver, this);
    }
}