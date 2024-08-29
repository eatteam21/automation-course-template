package com.pages.RevReply;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.pages.BasePage;

public class LoginRevReplyPage extends BasePage {

    private By emailInput = By.xpath("//input[@type='email']");
    private By passwordInput = By.xpath("//input[@type='password']");
    private By loginButton = By.xpath("//button[@type='submit']") ;
    private By errorMessage = By.xpath("//h6");
    
    public LoginRevReplyPage(WebDriver givenDriver) {
        super(givenDriver);
        
    }
    
    public void inputEmail(String email){
        waitForElementVisible(emailInput);
        findElementByLocator(emailInput).clear();
        findElementByLocator(emailInput).sendKeys(email);
    }
    public void inputPassword(String password){
        waitForElementVisible(passwordInput);
        findElementByLocator(passwordInput).clear();
        findElementByLocator(passwordInput).sendKeys(password);
    }
    
    public void clickLogin(){
        waitForElementVisible(loginButton);
        findElementByLocator(loginButton).click();
    }

    public String getMessageError(){
        return findElementByLocator(errorMessage).getText();

    }
}
