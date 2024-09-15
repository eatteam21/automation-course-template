package com.pages;

import org.openqa.selenium.By;

import io.appium.java_client.android.AndroidDriver;

public class YourCart extends BasePage  {
    public YourCart(@SuppressWarnings("rawtypes") AndroidDriver driver) {
        super(driver);
        //TODO Auto-generated constructor stub
    } 
    //element
       private By checkoutBtn = By.xpath("//android.widget.TextView[@text=\"CHECKOUT\"]");
       
    //function
    public void checkoutBtn () {
        this.driver.findElement(checkoutBtn).click();
    }
}
