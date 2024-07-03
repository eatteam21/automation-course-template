package com.pages.IviVu;

import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.pages.BasePage;
import com.utils.Utils;

public class BookRoomPage extends BasePage{
     WebDriver webdriver = new ChromeDriver();
    //private By chooseHotel = By.xpath("//div[@ng-hide='(!availableNo_897417 || availableNo_897417==0) && GetOnlyAL']");
    private By btnBookNow = By.xpath("//button[@id='datphongnay']");
    private By btnReservationRequired = By.xpath("(//button[@ng-disabled='!LoadingFinish ||(limitBuget && mealType.PriceAvgPlusTA > limitBuget)'])[1]");
    public BookRoomPage(WebDriver givenDriver) {
        super(givenDriver);
        //TODO Auto-generated constructor stub
    }
    

    public void clickBookNow(){
        waitForElementClickable(btnBookNow);
        findElementByLocator(btnBookNow).click();
    }
    
    
    public void bookingRoom(){
        waitForElementVisible(btnReservationRequired); 
        WebElement element = driver.findElement(btnReservationRequired);
        Utils.scrollToElement(element,driver);
        findElementByLocator(btnReservationRequired).click();
    }
}
