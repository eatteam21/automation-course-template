package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RegisterPage extends BasePage {
    By registerBtn = By.xpath("//button[@name='register']");
    By emailInp = By.xpath("//input[@id='reg_email']");
    By passwordInp = By.xpath("//input[@id='reg_password']");
    By errorText = By.xpath("//ul[@class='woocommerce-error']");
    By Text = By.xpath("//p[contains(text(),'Xin chào')]");

    public RegisterPage(WebDriver givenDriver) {
        super(givenDriver);
        //TODO Auto-generated constructor stub
    }

    public void clickRegisterBtn(){
        findElementByLocator(registerBtn).click();
    }

    public void inputEmail(String email){
        findElementByLocator(emailInp).sendKeys(email);
    }
    
    public void inputPassword(String password){
        findElementByLocator(passwordInp).sendKeys(password);
    }

    public String getErrorMessage(){
        return driver1.findElement(errorText).getText();
    }

    public String getMessage(){
        return driver1.findElement(Text).getText();
    }
}
