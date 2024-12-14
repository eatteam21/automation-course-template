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
// input email
    By byEmail = By.xpath("//input[@id='username']");

    public LoginPage enterEmail(String uname) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(byEmail)).sendKeys(uname);
        return this;
    }
// input pass
    By byPassword = By.xpath("//input[@id='password']");

    public LoginPage enterPassword(String pw) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(byPassword)).sendKeys(pw);
        return this;
    }
// button login 
    By byLoginBtn = By.xpath("//button[@name='login']");

    public LoginPage enterLogin() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(byLoginBtn)).click();
        return this;
    }

    // button quên mâtk khẩu 
    By byButtonForgetPassword = By.xpath("//a[text()='Quên mật khẩu?']");

    public LoginPage clickForgetPassword() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(byButtonForgetPassword)).click();
        return this;
    }
    // check box ghi nhớ mật khẩu 
    By byCheckboxRememberPassword= By.xpath("//input[@id='rememberme']");

    public LoginPage clickCheckboxRememberPassword() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(byCheckboxRememberPassword)).click();
        return this;
    }
// email không đúng 
 public By messageErroEmail= By.xpath("//ul[@class='woocommerce-error']/li[contains(text(), 'Địa chỉ email không xác định')]");
// null email + nulll email  pass 
 public By messageNullAccount= By.xpath("//ul[@class='woocommerce-error']/li[strong[text()='Lỗi:']]");
 // sai pass
 public By messageNullPass = By.xpath("//ul[@class='woocommerce-error']//a[contains(@href, 'lost-password')]");
 // null pass 
 public By messageFailsePass = By.xpath("//ul[@class='woocommerce-error']/li/a[contains(text(), 'Bạn quên mật khẩu?')]");
 
}
