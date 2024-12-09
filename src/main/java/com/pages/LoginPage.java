package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LoginPage extends BasePage {
    public LoginPage(WebDriver givenDriver) {
        super(givenDriver);
    }

    By byEmail = By.xpath("//input[@id='username']");
    By byPassword = By.xpath("//input[@id='password']");
    By byLoginBtn = By.xpath("//button[@name='login']");

    // @FindBy(xpath="//input[@id='username']")
    // public WebElement emailElement;

    public LoginPage enterEmail(String uname) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(byEmail)).sendKeys(uname);
        // emailElement.sendKeys(uname);
        return this;
    }

    public LoginPage enterPassword(String pw) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(byPassword)).sendKeys(pw);
        return this;
    }

    public LoginPage enterLogin() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(byLoginBtn)).click();
        return this;
    }

    // public LoginPage loginAndSubmit(String uname, String pw) {
    //     this.enterEmail(null);
    //     this.enterPassword(pw);
    // }


    
}
