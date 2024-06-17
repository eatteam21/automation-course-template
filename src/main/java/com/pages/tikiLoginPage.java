package com.pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class tikiLoginPage extends BasePage {
    public tikiLoginPage(WebDriver givenDriver){
        super(givenDriver);
    }
    By searchText = By.xpath("//input[@data-view-id='main_search_form_input']");
    By searchIcon = By.xpath("//img[@alt='icon-search']");
    By searchButton = By.xpath("//button[@class='styles__ButtonRevamp-sc-6cbqeh-3 LdVUr']");
    By mainPage = By.xpath("//span[contains(text(),'Trang chủ')]");
    //By searchResult = By.xpath("//span[contains(@title, 'Kết quả tìm kiếm') and contains(@title, 'điện thoại')]"); //
    By productClick = By.xpath("//img[@alt='Điện thoại vivo Y03 (4GB+64GB) - Hàng chính hãng']");
    By productTitle = By.xpath("//h1[contains(text(),'Điện thoại vivo Y03 (4GB+64GB) - Hàng chính hãng')]");
    By productPrice = By.xpath("//div[@class='product-price__current-price']");
     public void searchText(String txt){
          findElementByLocator(searchText).clear();
          findElementByLocator(searchText).sendKeys(txt);
     }
     public WebElement searchIcon(){
          return findElementByLocator(searchIcon);
     }
     public void searchButton(){
          findElementByLocator(searchButton).click();
     }
     public WebElement mainPage(){
          waitForElementVisible(mainPage);
          return findElementByLocator(mainPage);
     }
     public void productClick(){
          findElementByLocator(productClick).click();
     }
     public WebElement productTitle(){
          waitForElementVisible(productTitle);
          return findElementByLocator(productTitle);
     }
     public WebElement productPrice(){
          waitForElementVisible(productPrice);
          return findElementByLocator(productPrice);
     }



    
}

