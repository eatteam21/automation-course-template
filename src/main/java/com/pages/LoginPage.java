package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LoginPage extends BasePage {
    
    public LoginPage(WebDriver givenDriver) {
        super(givenDriver);
        //TODO Auto-generated constructor stub
    }

    By usernameInput = By.xpath("//input[@id='username']");
    By passwordInput = By.xpath("//input[@id='password']");
    By loginButton = By.xpath("//button[contains(text(),'Đăng nhập')]");


    // @FindBy(xpath = "//input[@id='username']")
    // private WebElement usernameElement;

    // @FindBy(xpath = "//input[@id='pass']")
    // private WebElement passElement;

    public LoginPage enterEmail(String uname){
        //        this.driver.findElement(usernameInput).sendKeys(txt);
        // findElementByLocator(usernameInput).clear();
        // findElementByLocator(usernameInput).sendKeys(txt);
        // wait.until(ExpectedConditions.visibilityOfElementLocated(usernameInput)).sendKeys(uname);
        findElementByLocator(usernameInput).clear();
        findElementByLocator(usernameInput).sendKeys(uname);
        // usernameElement.sendKeys(uname);

        return this;
    }
        
    public LoginPage enterPassword(String passw){
        findElementByLocator(passwordInput).clear();
        findElementByLocator(passwordInput).sendKeys(passw);
        // wait.until(ExpectedConditions.visibilityOfElementLocated(passwordInput)).sendKeys(passw);
        // passElement.sendKeys(passw);

        return this;
    }


    public LoginPage clickLogin(){
        findElementByLocator(loginButton).click();
        // wait.until(ExpectedConditions.visibilityOfElementLocated(loginButton)).click();

        return this;
    }

}
