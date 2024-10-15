package com.pages.PractivePage;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.pages.BasePage;


public class ProductCategoriesPage extends BasePage {

    
    private By productName = By.xpath("//h3");
    // private By closeButton = By.xpath("null")
    
    
    Actions actions = new Actions(driver);
    public ProductCategoriesPage(WebDriver givenDriver) {
        super(givenDriver);
        
    }
    
    public void clickProduct(String name){
       waitForElementClickable(productName);
       findElementByLocator(productName).click();
    }
    
    public void compareNameOfProduct(String name){
        String expectedProductTitle = name;
        WebElement productTitle = driver.findElement(By.tagName("h1")); // Assuming the title is in an <h1> tag
            if (productTitle.getText().equals(expectedProductTitle)) {
                System.out.println("Test Passed: Product is displayed correctly.");
            } else {
                System.out.println("Test Failed: Product is not displayed correctly.");
            }
        
    }
    
    
}

