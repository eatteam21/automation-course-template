package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class RegisterPage extends BasePage {

    private By emailInput = By.xpath("//input[@id='reg_email']");
    private By registerClick = By.xpath("//button[@name='register']") ;
    private By errorMessage = By.xpath("//ul[@class ='woocommerce-error']/li");
    
    public RegisterPage(WebDriver givenDriver) {
        super(givenDriver);
        
    }
    
    public void inputEmail(String email){
        findElementByLocator(emailInput).clear();
        findElementByLocator(emailInput).sendKeys(email);
    }
    
    public void clickResgister(){
        findElementByLocator(registerClick).click();
    }

    public String getMessageError(){
        return findElementByLocator(errorMessage).getText();

    }
}
