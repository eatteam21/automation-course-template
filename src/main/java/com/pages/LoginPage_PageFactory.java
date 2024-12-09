package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LoginPage_PageFactory extends BasePage {
    public LoginPage_PageFactory(WebDriver givenDriver) {
        super(givenDriver);
    }

    // By byEmail = By.xpath("//input[@id='username']");
    // By byPassword = By.xpath("//input[@id='password']");
    // By byLoginBtn = By.xpath("//button[@name='login']");

    @FindBy(xpath = "//input[@id='username']")
    public WebElement emailElement;

    @FindBy(xpath = "//input[@id='password']")
    public WebElement passwordElement;

    @FindBy(xpath = "//button[@name='login']")
    public WebElement loginBtnElement;

    public void enterEmail(String uname) {
        // wait.until(ExpectedConditions.visibilityOfElementLocated(byEmail)).sendKeys(uname);
        emailElement.sendKeys(uname);
        // return this;
    }

    public void enterPassword(String pw) {
        // wait.until(ExpectedConditions.visibilityOfElementLocated(byPassword)).sendKeys(pw);
        passwordElement.click();
        // return this;
    }

    public void enterLogin() {
        // wait.until(ExpectedConditions.visibilityOfElementLocated(byLoginBtn)).click();
        loginBtnElement.click();
        // return this;
    }

    // public LoginPage enterLogin() {
    // wait.until(ExpectedConditions.visibilityOfElementLocated(byLoginBtn)).click();
    // return this;
    // }
}
