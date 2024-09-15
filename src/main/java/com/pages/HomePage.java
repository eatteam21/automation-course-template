package com.pages;

import org.openqa.selenium.By;

import io.appium.java_client.android.AndroidDriver;

public class HomePage extends BasePage {
    public HomePage(@SuppressWarnings("rawtypes") AndroidDriver driver) {
        super(driver);
        //TODO Auto-generated constructor stub
    }
    //element
    private By addBtn = By.xpath("(//android.view.ViewGroup[@content-desc=\"test-ADD TO CART\"])[1]");
    private By cartBtn = By.xpath("//android.view.ViewGroup[@content-desc=\"test-Cart\"]/android.view.ViewGroup/android.widget.ImageView");
    //function
    public void clickAddBtn () {
        this.driver.findElement(addBtn).click();
    }
    public void clickCartBtn () {
        this.driver.findElement(cartBtn).click();
    }
}
