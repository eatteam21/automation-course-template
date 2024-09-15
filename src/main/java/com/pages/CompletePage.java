package com.pages;

import org.openqa.selenium.By;

import io.appium.java_client.android.AndroidDriver;

public class CompletePage extends BasePage {
       public CompletePage(@SuppressWarnings("rawtypes") AndroidDriver driver) {
        super(driver);
        //TODO Auto-generated constructor stub
    } 
    //element
     private By backHomeBtn = By.xpath("//android.view.ViewGroup[@content-desc=\"test-BACK HOME\"]");

    //function
    public void clickBackHomeBtn () {
        this.driver.findElement(backHomeBtn).click();
    }

}
