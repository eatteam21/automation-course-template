package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage extends BasePage {

    public LoginPage(WebDriver givenDriver) {
        super(givenDriver);
        //TODO Auto-generated constructor stub
    }


    By emailInput = By.xpath("//input[@id='username']");
    By passwordInput = By.xpath("//input[@id='password']");
    By loginButton = By.xpath("//button[contains(text(),'Đăng nhập')]");
    By errorMessagae = By.xpath("//ul[@class='woocommerce-error']");


    public void enterEmail(String txt){
        findElementByLocator(emailInput).clear();
        findElementByLocator(emailInput).sendKeys(txt);
    }

    public void enterPassword(String txt){
        findElementByLocator(passwordInput).clear();
        findElementByLocator(passwordInput).sendKeys(txt);
    }


    public void clickLogin(){
        findElementByLocator(loginButton).click();
    }

    public WebElement getErrorMessageElement(){
        return findElementByLocator(errorMessagae);
    }

    
}
