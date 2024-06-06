package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class RegisterPage extends BasePage{

    public RegisterPage(WebDriver givenDriver) {
        super(givenDriver);
        //TODO Auto-generated constructor stub
    }
    By emailInput = By.xpath("//input[@id='reg_email']");
    By regButton = By.xpath("//button[contains(text(),'Đăng ký')]");
    By errorMessage = By.xpath("//ul[@class='woocommerce-error']");
    By passwordInput = By.xpath("//input[@id='reg_password']");
    By errorMessagePass = By.xpath("//div[@class='woocommerce-password-strength short']");
    public void enterRegEmail(String txt){
        findElementByLocator(emailInput).clear();
        findElementByLocator(emailInput).sendKeys(txt);
    }
    public void regButton(){
        findElementByLocator(regButton).click();
    }
    public WebElement errorMessage(){
        return findElementByLocator(errorMessage);
    }
    public void enterRegPassword (String txt){
        findElementByLocator(passwordInput).clear();
        findElementByLocator(passwordInput).sendKeys(txt);
    }

    public WebElement errorMessagePass(){
        return findElementByLocator(errorMessagePass);
    }

}
