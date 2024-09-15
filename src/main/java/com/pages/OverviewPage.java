package com.pages;

import org.openqa.selenium.By;

import io.appium.java_client.android.AndroidDriver;

public class OverviewPage extends BasePage {
    public OverviewPage(@SuppressWarnings("rawtypes") AndroidDriver driver) {
        super(driver);
        //TODO Auto-generated constructor stub
    } 
    //element
     private By finishBtn = By.xpath("//android.widget.TextView[@text=\"FINISH\"]");

    //function
    public void clickFinishBtn () {
        this.driver.findElement(finishBtn).click();
    }
}
