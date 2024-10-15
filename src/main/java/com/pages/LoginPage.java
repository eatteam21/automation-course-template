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
    private By hyperlinkAccount = By.xpath("//a[@class='pos-login']");
    private By hyperlinkBack = By.partialLinkText("Thoát");
    public LoginPage(WebDriver driver) { //constructors
        super(driver); //syntax
    }

    public void clickLogin() {
        waitForElementVisible(submitButton);
        findElementByLocator(submitButton).click();
        // Utils.hardWait();
    }
    public boolean displayedLogin() {
        waitForElementVisible(submitButton);
        return findElementByLocator(submitButton).isDisplayed();
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
        findElementByLocator(passwordInput).sendKeys(password);
        // Utils.hardWait();
    }


    public void login(String username, String password) {
        this.inputEmail(username);
        this.inputPass(password);
        this.clickLogin();
    }

    public void clickHyperlinkAccount(){
        waitForElementVisible(hyperlinkAccount);
        findElementByLocator(hyperlinkAccount).click();
    }

    public void clickHyperlinkBack(){
        waitForElementVisible(hyperlinkBack);
        findElementByLocator(hyperlinkBack).click();
    }

    public String getErrorMessage() {
        return findElementByLocator(errorText).getText();
    }

}