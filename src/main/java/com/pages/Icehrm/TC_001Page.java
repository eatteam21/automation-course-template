package com.pages.Icehrm;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.pages.BasePage;
import com.utils.Utils;

public class TC_001Page extends BasePage {

    private By submitButton = By.xpath("//button[@onclick='submitLogin();return false;']");
    private By errorText = By.xpath("//ul[@class='woocommerce-error']/li");
    private By emailInput = By.xpath("//input[@id='username']");
    private By passwordInput = By.xpath("//input[@id='password']");
    
    public TC_001Page(WebDriver driver) { //constructors
        super(driver); //syntax
    }

    public void clickLogin() {
        waitForElementVisible(submitButton);
        findElementByLocator(submitButton).click();
        // Utils.hardWait();
    }

    public void inputEmail(String email) {
        waitForElementVisible(emailInput);
        findElementByLocator(emailInput).clear();
        findElementByLocator(emailInput).sendKeys(email);
        // Utils.hardWait();
    }

    public void inputPass(String password) {
        waitForElementVisible(passwordInput);
        findElementByLocator(passwordInput).clear();
        findElementByLocator(passwordInput).sendKeys(password,Keys.ENTER);
        // Utils.hardWait();
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