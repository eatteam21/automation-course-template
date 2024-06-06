package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import io.appium.java_client.functions.ExpectedCondition;


public class hrmloginPage extends BasePage {
    public hrmloginPage (WebDriver givenDriver){
        super(givenDriver);
    }
    By usernameInput = By.xpath("//input[@id='username']");
    By passwordInput = By.xpath("//input[@id='password']");
    By loginButton = By.xpath("//button[contains(text(),'Log in')]");
    By usernameCheck = By.xpath("//a[contains(text(),'IceHrm Employee')]");
    public void usernameInput(String txt){
        findElementByLocator(usernameInput).sendKeys(txt);
    }
    public void passwordInput(String txt){
        findElementByLocator(passwordInput).sendKeys(txt);
    }
    public void loginButton(){
        findElementByLocator(loginButton).click();
    }
    public WebElement usernameCheck(){
        return findElementByLocator(usernameCheck);
    }

}
