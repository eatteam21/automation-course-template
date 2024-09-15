package com.pages;

import org.openqa.selenium.By;

import io.appium.java_client.android.AndroidDriver;

public class LoginPage extends BasePage {

    public LoginPage(@SuppressWarnings("rawtypes") AndroidDriver driver) {
        super(driver);
        //TODO Auto-generated constructor stub
    } 
    // private By emailBtn = By.xpath(xpathExpression:"//android.widget.EditText[@content-desc='test-Username']");
    // private By passwordBtn = By.xpath(xpathExpression:"//android.widget.EditText[@content-desc=\"test-Password\"]");
    // private By LoginBtn = By.xpath(xpathExpression:"//android.view.ViewGroup[@content-desc=\"test-LOGIN\"]");
    
    //element
    private By emailBtn = By.xpath("//android.widget.EditText[@content-desc='test-Username']");
    private By passwordBtn = By.xpath("//android.widget.EditText[@content-desc='test-Password']");
    private By loginBtn = By.xpath("//android.view.ViewGroup[@content-desc='test-LOGIN']");

    //fuction
   
    public void inputEmail (String email) {
        driver.findElement(emailBtn).sendKeys(email);
    }
    public void inputPassword (String password) {
        driver.findElement(passwordBtn).sendKeys(password);
    }
    public void clickloginBtn () {
        this.driver.findElement(loginBtn).click();
    }
}
