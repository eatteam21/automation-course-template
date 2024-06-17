package com.pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class tikiFilterPage extends BasePage {
    public tikiFilterPage(WebDriver givenDriver){
        super(givenDriver);
    }
    By leftSideBar = By.xpath("//div[@title='Điện Gia Dụng']");
    By miniLeftSide = By.xpath("//div[@title ='Điện Gia Dụng']");
    By miniLeftSide_2 = By.xpath("//a[normalize-space()='Lò vi sóng']");
    By verifyBreadCrum = By.xpath("//div[@class='breadcrumb']");
    By filterButton = By.xpath("//button[@class='styles__StyledButton-sc-kqbl3f-0 bQYwcw']");
    By allFilter = By.xpath("//div[@class='styles__StyledPopupTitle-sc-1fz54eb-3 bHQJJF']//div[2]");
    By topDealButton = By.xpath("//div[@class='styles__StyledPopupFilter-sc-1fz54eb-0 eHpOiq']//div[3]//div[1]//div[1]//div[1]//div[1]//span[1]//img[3]");
    By supplierButton = By.xpath("//div[@data-view-label='Nhà cung cấp']//a[@class='toggler'][normalize-space()='Xem thêm']");
     public void leftSideBar(){
          waitForElementClickable(leftSideBar);
          findElementByLocator(leftSideBar).click();
     }
     public void miniLeftSide(){
          waitForElementClickable(miniLeftSide);
          findElementByLocator(miniLeftSide).click();
     }
     public void miniLeftSide_2(){
          waitForElementClickable(miniLeftSide_2);
          findElementByLocator(miniLeftSide_2).click();
     }
     public WebElement verifyBreadCrum(){
          waitForElementVisible(verifyBreadCrum);
          return findElementByLocator(verifyBreadCrum);
     }
     public void filterButton(){
          waitForElementClickable(filterButton);
          findElementByLocator(filterButton).click();
     }
     public WebElement allFilter(){
          waitForElementVisible(allFilter);
          return findElementByLocator(allFilter);
     }
     public void topDealButton(){
          waitForElementClickable(topDealButton);
          findElementByLocator(topDealButton).click();
     }
     public void supplierButton(){
          waitForElementClickable(supplierButton);
          findElementByLocator(supplierButton).click();
     }

}

