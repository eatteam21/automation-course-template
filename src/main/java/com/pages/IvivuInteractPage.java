package com.pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class IvivuInteractPage extends BasePage {
    public IvivuInteractPage(WebDriver givenDriver){
        super(givenDriver);
    }
    By locationInput = By.xpath("//input[@id='searchText']");
    By locationClick = By.xpath("//div[@class='tt-dataset tt-dataset-hots']//div[2]//div[1]//div[1]//div[1]");
    By datePicker = By.xpath("//td[@data-t-date='1720656000000']");
    By dateElement = By.xpath("//td[@data-t-date='1721433600000']");
    By submitClick = By.xpath("(//button[@ng-click='SearchHotel()'])[2]");
    By clickLink = By.xpath("/html/body/div[2]/div[2]/div[3]/div[2]/div[2]/div/div[5]/div[1]/a/div[2]/div[2]/div[1]/p[1]");
    By regRoom = By.xpath("//button[@id='datphongnay']");
    By regRoomOrder = By.xpath("/html/body/section/section/aside[1]/div[16]/div/div/div/table/tbody[1]/tr[1]/td[4]/div[2]/div/button/b");
    public void locationInput(){
         waitForElementVisible(locationInput);
        findElementByLocator(locationInput).click();
    }
    public void locationClick(){
          waitForElementClickable(locationClick);
        findElementByLocator(locationClick).click();
    }
    public void dateElement(){
          waitForElementClickable(dateElement);
         findElementByLocator(dateElement).click();;
    }
    
    public void datePicker(){
          waitForElementVisible(datePicker);
        findElementByLocator(datePicker).click();
   }
   public void submitClick(){
          waitForElementVisible(submitClick);
        findElementByLocator(submitClick).click();
   }
   public void clickLink(){
          waitForElementClickable(clickLink);
        findElementByLocator(clickLink).click();
   }
   public void regRoom(){
          waitForElementVisible(regRoom);
        findElementByLocator(regRoom).click();
   }
   public void regRoomOrder(){
          waitForElementVisible(regRoomOrder);
        findElementByLocator(regRoomOrder).click();
   }
}

