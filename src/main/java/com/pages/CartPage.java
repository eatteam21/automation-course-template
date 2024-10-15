package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.mongodb.util.Util;
import com.utils.Utils;

public class CartPage extends BasePage{

    private By inputSearch = By.xpath("//input[@id ='s']");
    private By findSearch = By.xpath("//span[@class='twitter-typeahead']/div/div/a[1]");
    private By buttonAdd = By.xpath("//button[@name='add-to-cart']");
    private By buttonPay = By.xpath("//a[@class='checkout-button button alt wc-forward']");
    private By tittleProduct = By.xpath("//h1[@class='product_title entry-title']");
    private By tittleCart = By.xpath("//h1[@class='avo-b font18 red mb20 entry-title']");
    private By tittlePay = By.xpath("//h1[@class='avo-b font18 red mb20 entry-title']");
    public CartPage(WebDriver givenDriver) {
        super(givenDriver);
        //TODO Auto-generated constructor stub
    }

    public void searchInput(String search){
        waitForElementVisible(inputSearch);
        findElementByLocator(inputSearch).clear();
        findElementByLocator(inputSearch).sendKeys(search);
         //Utils.hardWait();
    }

    public void searchFind(){
        waitForElementVisible(findSearch);
        waitForElementClickable(findSearch);
        findElementByLocator(findSearch).click();
        //Utils.hardWait();
    }

    public void clickAdd(){
        waitForElementVisible(buttonAdd);
        waitForElementClickable(buttonAdd);
        findElementByLocator(buttonAdd).click();
        //Utils.hardWait();
    }

    public void clickPay(){waitForElementVisible(buttonPay);
        waitForElementClickable(buttonPay);
        findElementByLocator(buttonPay).click();
        //Utils.hardWait();
    }

    public String tittleProduct(){
        return findElementByLocator(tittleProduct).getText();  
    }

    public String tittleCart(){
        return findElementByLocator(tittleCart).getText();
    }
    public String tittlePay(){
        return findElementByLocator(tittlePay).getText();
    }
    
}
