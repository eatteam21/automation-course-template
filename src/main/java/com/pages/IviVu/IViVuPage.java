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

public class IViVuPage extends BasePage{
     
    private By searchText = By.xpath("//input[@id='searchText']");
    private By chooseLocation = By.partialLinkText("Đà Lạt");
    private By clickDateChecking = By.xpath("//div[@class='t-dates col-xs-12 v_field t-date-check-in']");
    private By clickDateCheckout = By.xpath("//div[@class='t-dates col-xs-12 v_field t-date-check-out']");
    //private By clickDateOfDepartment = By.xpath("//div[@class='col-xs-6 no-padding check-in  t-check-in']");
    private By clickRoom = By.xpath("//div[@class='col-xs-12 v_field']");
    private By clickIncrease = By.xpath("//span[@ng-click=\"PlusOrMinusObject('room','+',1,RoomConfig.length)\"]");
    private By buttonFind = By.xpath("(//button[@ng-click='SearchHotel()'])[2]");
    private By numberChild = By.xpath("//div[@class='col-xs-12 room-popover__item deline'][2]//*[@class='quantity ng-binding']");
    private By addChildBtn = By.xpath("//div[@class='col-xs-12 room-popover__item deline'][2]//*[contains(@ng-click,'+')]//span");
   
    public IViVuPage(WebDriver givenDriver) {
        super(givenDriver);
        //TODO Auto-generated constructor stub
    }
    
    

    public void searchText(){
        waitForElementVisible(searchText);
        findElementByLocator(searchText).click();
        
        Utils.hardWait();
    }

    public void chooseLocation(String location){
        waitForElementVisible(chooseLocation);
        String Locator = "//h4[contains(text(),'"+ location +"')]";
        By element = By.xpath(Locator);
        findElementByLocator(element).click();
        System.out.println("0000000000000");
        Utils.hardWait();
    }

    // public void clickDateChecking(){
    //     waitForElementVisible(clickDateChecking);
    //     System.out.println("111111111111111111111111111111111111111111111111111111111");
    //     findElementByLocator(clickDateChecking).click();
    //     System.out.println("222222222222222222222222222222222222222222222222222222222");
    //     //Utils.hardWait();
    // }
    
    public void clickRoom(){
        waitForElementVisible(clickRoom);
        findElementByLocator(clickRoom).click();
        // findElementByLocator(clickIncrease).click();
        //Utils.hardWait();
    }
    

    public void clickIncreaseRoom(int numberOfClicks){
        // System.out.println("==================================");
        // waitForElementVisible(clickIncrease);
        // for(int i = 1; i < 2; i++){
        //     findElementByLocator(clickIncrease).click();
        // }
        
        //waitForElementClickable(clickIncrease);
        for (int i = 1; i < numberOfClicks; i++) {
            try {
                
                findElementByLocator(clickIncrease).click();
                System.out.println("Clicked button " + (i + 1) + " times.");
            } catch (Exception e) {
                System.err.println("Error clicking button: " + e.getMessage());
                // Consider adding more robust error handling here
                // (e.g., retrying the click with a short wait in between)
            }
        }
        Utils.hardWait();
    }


    public void clickFind(){
        waitForElementClickable(buttonFind);
        WebElement x = findElementByLocator(buttonFind);
        x.click();
        // findElementByLocator(buttonLogin).click();
        //Utils.hardWait();
    }

    public void chooseHotel(String name){
        String locator =  "//div[@class='hotel-item']//*[contains(text(), '"+ name +"')]";
        By element = By.xpath(locator);
        findElementByLocator(element).click();
        ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));
    }

    public void pickDateChecking(String monthYear, String day){

        try {
            waitForElementVisible(clickDateChecking);
            findElementByLocator(clickDateChecking);

            String locator = "//*[contains(text(),'" + monthYear + "')]/../../..//*[contains(text(),'" + day + "')]";
            By element = By.xpath(locator);
            findElementByLocator(element).click();
        } catch (Exception e) {
            System.out.println("Failed to pick date: " + e.getMessage());
        }
        System.out.println("Pick year: " + monthYear + " Pick date: " + day);
    }

    public void pickDateOut(String monthYear, String day){
        
        try {
            waitForElementVisible(clickDateCheckout);
            findElementByLocator(clickDateCheckout);

            String locator = "//*[contains(text(),'" + monthYear + "')]/../../..//*[contains(text(),'" + day + "')]";
            By element = By.xpath(locator);
            findElementByLocator(element).click();
        } catch (Exception e) {
            System.out.println("Failed to pick date: " + e.getMessage());
        }
        System.out.println("Pick year: " + monthYear + " Pick date: " + day);
    }

}
