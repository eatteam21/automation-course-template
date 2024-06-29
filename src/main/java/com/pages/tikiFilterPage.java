package com.pages;
import org.apache.logging.log4j.core.util.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.NoSuchElementException;
public class tikiFilterPage extends BasePage {
    public tikiFilterPage(WebDriver givenDriver){
        super(givenDriver);
    }
    By leftSideBar = By.xpath("//div[@title='Điện Gia Dụng']");
    By miniLeftSide = By.xpath("//div[@title ='Điện Gia Dụng']");
    By miniLeftSide_2 = By.xpath("//a[normalize-space()='Lò vi sóng']");
    By verifyBreadCrum = By.xpath("//div[@class='breadcrumb']");
    By filterButton = By.xpath("//button[@class='styles__StyledButton-sc-kqbl3f-0 bQYwcw']/div[text() = 'Tất cả']");
    By allFilter = By.xpath("//div[@class='styles__StyledPopupTitle-sc-1fz54eb-3 bHQJJF']//div[2]");
    By supplierButton = By.xpath("//div[@data-view-label='Nhà cung cấp']//a[@class='toggler'][normalize-space()='Xem thêm']");
    By topDealLabel = By.xpath("//div[@class='styles__Name-sc-9p5afw-2 whUud']/span[contains(text(),'Siêu rẻ')]");
    By CloseButton = By.xpath("//div[@class='btn-close']");

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
     public void supplierButton(){
          waitForElementClickable(supplierButton);
          findElementByLocator(supplierButton).click();
     }
     public void fillter(String section, String option){
          String locator = "//div[@data-view-id='search_filter_container']//*[contains(text(),'" + section + "')]/..//*[contains(text(),'" + option + "')]";
          waitForElementClickable(By.xpath(locator));
          findElementByLocator(By.xpath(locator)).click();
     }
     public void fillter_2(String section, String option){
          String locator = "//div[@data-view-id='search_filter_container']//*[contains(text(),'" + section + "')]/..//*[contains(text(),'" + option + "')]";
          String buttonXPath = "//div[@data-view-id='search_filter_container']//*[contains(text(),'Nhà cung cấp')]/..//*[contains(text(),'Xem thêm')]";
          WebElement button = driver.findElement(By.xpath(buttonXPath));
          waitForElementVisible(By.xpath(buttonXPath));
          button.click();
          waitForElementClickable(By.xpath(locator));
          findElementByLocator(By.xpath(locator)).click();
     }
     public void fillterPrice(String priceFrom,String txt){
          //div[@class='group']/input[@placeholder='Từ']
          String locator = "//div[@class='group']/input[@placeholder='" + priceFrom + "']";
          waitForElementClickable(By.xpath(locator));
          findElementByLocator(By.xpath(locator)).click();
          findElementByLocator(By.xpath(locator)).sendKeys(txt);
     }
     public WebElement topDealLabel(){
          waitForElementVisible(topDealLabel);
          return findElementByLocator(topDealLabel);
     }
     public void CloseButton(){
          waitForElementVisible(CloseButton);
          findElementByLocator(CloseButton).click();
     }
     
}

