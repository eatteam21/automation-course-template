package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CartPage extends BasePage {

    
    By productCheck = By.xpath("//a[contains(text(),'Bơm nước xe Mercedes')]");


    public CartPage(WebDriver givenDriver) {
        super(givenDriver);
        //TODO Auto-generated constructor stub
    }

    public boolean checkOption() {

    //Check product
    return findElementByLocator(productCheck).isDisplayed();
    }
    
}
