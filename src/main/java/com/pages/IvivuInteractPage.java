package com.pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class IvivuInteractPage extends BasePage {
    public IvivuInteractPage(WebDriver givenDriver){
        super(givenDriver);
    }
    By locationInput = By.xpath("//input[@id='searchText']");
    By locationClick = By.xpath("//div[@class='media-body media-middle']//h4[@class ='media-heading'][contains(text(),'Đà Lạt')]");
    By datePicker = By.xpath("//span[@class = 't-day-check-in'][contains(text(),'21')]");
    By dateElement = By.xpath("(//div[contains(@class,'t-datepicker-day')]//td[contains(text(),'12')])[1]");
    By submitClick = By.xpath("(//button[@ng-click='SearchHotel()'])[2]");
    By clickLink = By.xpath("//p[@class = 'name limit-length'][contains(text(),'Khách sạn MerPerle Đà Lạt')]");
    By regRoom = By.xpath("//button[@id='datphongnay']");
    By regRoomOrder = By.xpath("//tr[@class='room-item ng-scope have-meal best-price']//b[@class='ng-scope'][contains(text(),'Yêu cầu đặt')]");
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

