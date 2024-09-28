package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class hrmLoginPage extends BasePage {


    By loginBtn = By.xpath("//button[@onclick='submitLogin();return false;']");
    By emailInp = By.xpath("//input[@id='username']");
    By passwordInp = By.xpath("//input[@id='password']");


    public hrmLoginPage(WebDriver givenDriver) {
        super(givenDriver);
        //TODO Auto-generated constructor stub
    }

    public void clickLoginBtn() {
        // driver.findElement(By.xpath("//button[@name=\"login\"]")).click();
        findElementByLocator(loginBtn).click();
    }

    public void inputEmail(String email) {
        //driver.findElement(emailInp).sendKeys(email);
        findElementByLocator(emailInp).sendKeys(email);
    }
    public void inputPassword(String password) {
        driver1.findElement(passwordInp).sendKeys(password);
    }
  
}
