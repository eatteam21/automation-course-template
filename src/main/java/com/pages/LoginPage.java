package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;


public class LoginPage extends BasePage {
    // public WebDriver driver;

    public LoginPage(WebDriver givenDriver){
        // this.driver = givenDriver;
        super(givenDriver);
    }


    // @FindBy(xpath = "//input[@id='username']")
    // public WebElement emailElement;

    By byEmail = By.xpath("//input[@id='username']");

    By byPassword = By.xpath("//input[@id='password']");

    By byLoginBtn = By.xpath("//button[@name='login']");

    public LoginPage enterEmail(String uname) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(byEmail)).sendKeys(uname);
        // emailElement.sendKeys(uname);

        return this;
    }

    public LoginPage enterPassword(String pass) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(byPassword)).sendKeys(pass);

        return this;
    }

    public LoginPage clickLogin() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(byLoginBtn)).click();
        return this;
    }


    
}
