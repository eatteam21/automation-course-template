package com.pages;

import io.appium.java_client.android.AndroidDriver;

public class BasePage {
    @SuppressWarnings("rawtypes")
    protected AndroidDriver driver;
    public BasePage (@SuppressWarnings("rawtypes") AndroidDriver driver){
        this.driver=driver;
    }
    
}
