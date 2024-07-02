package com.pages.IviVu;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.pages.BasePage;
import com.utils.Utils;

public class LoginPageIViVu extends BasePage{
     
    private By buttonAccount = By.xpath("//li[@id='UserLogin']");
    private By buttonLogin = By.xpath("//ul[@class='dropdown-menu member-dropdown-menu user-menu-list']/li/btn");
    private By validationMessageEmail = By.xpath("//input[@name='EmailPhoneDN']");
    private By validationMessagePassword = By.xpath("//input[@name='PasswordDN']");
    private By loginButton = By.xpath("//button[@type='submit'][contains(text(),'Đăng nhập')]");
   
    public LoginPageIViVu(WebDriver givenDriver) {
        super(givenDriver);
        //TODO Auto-generated constructor stub
    }
    
    

    public void clickButtonAccount(){
        waitForElementVisible(buttonLogin);
        findElementByLocator(buttonAccount).click();
        //Utils.hardWait();
    }

    public void clickButtonLogin(){
        waitForElementVisible(buttonLogin);
        findElementByLocator(buttonLogin).click();
        //Utils.hardWait();
    }
    
    public void inputEmail(String email){
        waitForElementVisible(validationMessageEmail);
        findElementByLocator(validationMessageEmail).clear();
        findElementByLocator(validationMessageEmail).sendKeys(email);
        //Utils.hardWait();
    }
    public String getEmailValidation(){
        return findElementByLocator(validationMessageEmail).getAttribute("validationMessage");
        
    }

    public String getPasswordValidation(){
        return findElementByLocator(validationMessagePassword).getAttribute("validationMessage");
    }


    public void clickLoginButton(){
        waitForElementVisible(loginButton);
        findElementByLocator(loginButton).click();
        // findElementByLocator(buttonLogin).click();
        //Utils.hardWait();
    }
}