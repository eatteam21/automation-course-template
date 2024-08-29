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


public class SearchPage extends BasePage {

    
    //private By slideSide = By.xpath("//div[contains(@class,'c_sub_row')]");
    // private By closeButton = By.xpath("null")
    @FindBy(xpath = "//span[contains(@class,'ui-slider-handle')][1]")
    private WebElement filterMin;

    @FindBy(xpath = "//span[contains(@class,'ui-slider-handle')][2]")
    private WebElement filterMax;

    @FindBy(xpath = "//button[@class='button']")
    private WebElement buttonFilter;

    @FindBy(css=".woocommerce-Price-amount.amount")
    private List<WebElement> priceElements;
    @FindBy(css = ".ui-slider-range.ui-corner-all.ui-widget-header")
    private WebElement filterSlide;
    
    Actions actions = new Actions(driver);
    public SearchPage(WebDriver givenDriver) {
        super(givenDriver);
        
    }
    

    public void clickFilterMin(int xOffset) {
        //waitUntilSliderIsVisible(filterMin);
        JavascriptExecutor js = (JavascriptExecutor)(driver);
        String leftStyle = (String) js.executeScript("return window.getComputedStyle(arguments[0]).left;", filterSlide);
        System.out.println("Number: " + leftStyle);
        actions.dragAndDropBy(filterMin, xOffset, 0).perform();
        System.out.println("Adjusted minimum price filter by offset: " + xOffset);
        
    }

    // Method to adjust maximum price filter
    public void clickFilterMax(int xOffset) {
        //waitUntilSliderIsVisible(filterMax);
        actions.dragAndDropBy(filterMax, xOffset, 0).perform();
        System.out.println("Adjusted maximum price filter by offset: " + xOffset);
    }

    public void clickButton(){
        buttonFilter.click();
    }

    public void assertPricesInRange(double minPrice, double maxPrice) {
        wait.until(ExpectedConditions.visibilityOfAllElements(priceElements));
        boolean allPricesWithinRange = true;

        for (WebElement priceElement : priceElements) {
            String priceText = priceElement.getText().replace("₹", "").replace(",", "").trim();
            double priceValue = Double.parseDouble(priceText);
            System.out.println("Found price: ₹" + priceValue);

            if (priceValue < minPrice || priceValue > maxPrice) {
                allPricesWithinRange = false;
                System.err.println("Test Failed: Found a book with price outside the range: ₹" + priceValue);
            }
        }

        if (allPricesWithinRange) {
            System.out.println("Test Passed: All books are within the price range of ₹" + minPrice + " to ₹" + maxPrice);
        } else {
            throw new AssertionError("Some books are outside the specified price range.");
        }
    }
    
}

