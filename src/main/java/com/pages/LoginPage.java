package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.fasterxml.jackson.databind.JsonSerializable.Base;

import io.appium.java_client.android.AndroidDriver;

@SuppressWarnings("rawtypes") 
public class LoginPage extends BasePage {

    public LoginPage(AndroidDriver driver) {
        super(driver);
        //TODO Auto-generated constructor stub
    }

    private By emailTxt = By.xpath("//android.widget.EditText[@content-desc='test-Username']");
    private By passwordTxt = By.xpath("//android.widget.EditText[@content-desc=\"test-Password\"]");
    private By loginBtn  = By.xpath("//android.view.ViewGroup[@content-desc=\"test-LOGIN\"]");

    public void clickLoginBtn() {
        // driver.findElement(loginBtn).click();
        findElementByLocator(loginBtn).click();
    }

    public void inputEmail(String email) {
        // wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.EditText[@content-desc='test-Username']")));
        // driver.findElement(emailTxt).sendKeys(email);
        findElementByLocator(emailTxt).sendKeys(email);
    }

    public void inputPassword(String password) {
        // driver.findElement(passwordTxt).sendKeys(password);
        findElementByLocator(passwordTxt).sendKeys(password);
    }

    
}
