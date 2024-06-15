package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.utils.Utils;

public class LoginPage extends BasePage {

    private By submitButton = By.name("login");
    private By errorText = By.xpath("//ul[@class='woocommerce-error']/li");
    private By emailInput = By.xpath("//input[@id='username']");
    private By passwordInput = By.xpath("//input[@id='password']");

    public LoginPage(WebDriver driver) { //constructors
        super(driver); //syntax
    }

    public void clickLogin() {
        findElementByLocator(submitButton).click();
        Utils.hardWait();
    }

    public void inputEmail(String email) {
        findElementByLocator(emailInput).clear();
        findElementByLocator(emailInput).sendKeys(email);
        Utils.hardWait();
    }

    public void inputPass(String password) {
        findElementByLocator(passwordInput).clear();
        findElementByLocator(passwordInput).sendKeys(password);
        Utils.hardWait();
    }


    public void login(String username, String password) {
        this.inputEmail(username);
        this.inputPass(password);
        this.clickLogin();
    }


    public String getErrorMessage() {
        return findElementByLocator(errorText).getText();
    }

}