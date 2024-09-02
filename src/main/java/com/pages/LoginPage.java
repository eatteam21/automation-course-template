package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage {


    By loginBtn = By.xpath("//button[@name=\"login\"]");
    By emailInp = By.xpath("//input[@id='username']");
    By passwordInp = By.xpath("//input[@id='password']");
    By errorText = By.xpath("//ul[@class='woocommerce-error']");


    public LoginPage(WebDriver givenDriver) {
        super(givenDriver);
        //TODO Auto-generated constructor stub
    }

    public void clickLoginBtn() {
        // driver.findElement(By.xpath("//button[@name=\"login\"]")).click();
        findElementByLocator(loginBtn).click();
    }

    public void inputEmail(String email) {
        driver.findElement(emailInp).sendKeys(email);
    }
    public void inputPassword(String password) {
        driver.findElement(passwordInp).sendKeys(password);
    }

    public String getErrorMessage() {
        return driver.findElement(errorText).getText();
    }
    
    
}
