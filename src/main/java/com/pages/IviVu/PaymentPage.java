package com.pages.IviVu;

import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.pages.BasePage;
import com.utils.Utils;

public class PaymentPage extends BasePage{
     
    //private By chooseHotel = By.xpath("//div[@ng-hide='(!availableNo_897417 || availableNo_897417==0) && GetOnlyAL']");
    private By inputFullName = By.xpath("//input[@id='customername']");
    public PaymentPage(WebDriver givenDriver) {
        super(givenDriver);
        //TODO Auto-generated constructor stub
    }
    
    public void fillFullName(String fullname){
        waitForElementVisible(inputFullName);
        findElementByLocator(inputFullName).sendKeys(fullname);;
        System.out.println("Full name: " + fullname);
    }

}
