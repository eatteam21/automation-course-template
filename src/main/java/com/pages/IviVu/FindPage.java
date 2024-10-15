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

public class FindPage extends BasePage{
     
    //private By chooseHotel = By.xpath("//div[@ng-hide='(!availableNo_897417 || availableNo_897417==0) && GetOnlyAL']");
    private By btnBookNow = By.xpath("//button[@id='datphongnay']");
   
    public FindPage(WebDriver givenDriver) {
        super(givenDriver);
        //TODO Auto-generated constructor stub
    }
    

    public void clickChooseHotel(String name){
        String locator = "//div[@class='hotel-item']//*[contains(text(), '"+ name +"')]";
        By element = By.xpath(locator);
        waitForElementVisible(element);
        findElementByLocator(element).click();
        
        openNewTab();
        Utils.hardWait();

    }

    public void openNewTab(){
        ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(0));
        driver.close();
        driver.switchTo().window(tabs.get(1));
    }
    

}
