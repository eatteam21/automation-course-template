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
// Form Đăng Nhập 
    By byEmail = By.xpath("//input[@id='username']");

    public LoginPage enterEmail(String uname) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(byEmail)).sendKeys(uname);
        return this;
    }

    By byPassword = By.xpath("//input[@id='password']");

    public LoginPage enterPassword(String pw) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(byPassword)).sendKeys(pw);
        return this;
    }

    By byLoginBtn = By.xpath("//button[@name='login']");

    public LoginPage enterLogin() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(byLoginBtn)).click();
        return this;
    }
}

// Form Đăng Ký:
// Box địa chỉ email đăng kí 
// Box mật khẩu 
// Button đăng kí 
