package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class RegisterPage extends BasePage {
    public RegisterPage(WebDriver givenDriver) {
        super(givenDriver);
    }
// Form Đăng Nhập 
// input email
    By byEmailRegister = By.xpath("//input[@id='reg_email']");

    public RegisterPage enterEmailRegister(String EmailRegister) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(byEmailRegister)).sendKeys(EmailRegister);
        return this;
    }
// input pass
    By byPasswordRegister = By.xpath("//input[@id='reg_password']");

    public RegisterPage enterPasswordRegister(String PasswordRegister) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(byPasswordRegister)).sendKeys(PasswordRegister);
        return this;
    }
// button login 
    By byButtonRegister = By.xpath("//button[@name='register']");

    public RegisterPage enterRegister() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(byButtonRegister)).click();
        return this;
    }

  
}
