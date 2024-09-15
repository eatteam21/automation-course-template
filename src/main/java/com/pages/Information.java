package com.pages;

import org.openqa.selenium.By;

import io.appium.java_client.android.AndroidDriver;

public class Information extends BasePage {
    public Information(@SuppressWarnings("rawtypes") AndroidDriver driver) {
        super(driver);
        //TODO Auto-generated constructor stub
    } 
      //element
    private By firstNameBtn = By.xpath("//android.widget.EditText[@content-desc=\"test-First Name\"]");
    private By lastNameBtn = By.xpath("//android.widget.EditText[@content-desc=\"test-Last Name\"]");
    private By zipBtn = By.xpath("//android.widget.EditText[@content-desc=\"test-Zip/Postal Code\"]");
    private By ContinueBtn = By.xpath("//android.view.ViewGroup[@content-desc=\"test-CONTINUE\"]");

    //fuction
   
    public void inputFirstName (String firstName) {
        driver.findElement(firstNameBtn).sendKeys(firstName);
    }
    public void inputLastName (String lastName) {
        driver.findElement(lastNameBtn).sendKeys(lastName);
    }
    public void inputZipCode (String zipCode) {
        driver.findElement(zipBtn).sendKeys(zipCode);
    }
    public void clickContinueBtn () {
        this.driver.findElement(ContinueBtn).click();
    }
}
