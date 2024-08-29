package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

// ### Test Case 1: Search for a Product
// **Title:** Verify search functionality  
// **Precondition:** User is on the Amazon homepage  
// **Steps:**
// 1. Open Amazon homepage.
// 2. Enter "Laptop" in the search bar.
// 3. Click on the search button.
// 4. Verify that the search results page displays products related to "Laptop".
 
// **Expected Result:** Search results related to "Laptop" are displayed.
public class SearchPage extends BasePage {

    private By searchInput = By.xpath("//input[@id='twotabsearchtextbox']");
    private By searchButton = By.xpath("//input[@id='nav-search-submit-button']");
    
    public SearchPage(WebDriver givenDriver) {
        super(givenDriver);
        
    }
    
    public void inputsearch(String product){
        waitForElementVisible(searchInput);
        findElementByLocator(searchInput).clear();
        findElementByLocator(searchInput).sendKeys(product);
    }

    public void clickSearch(){
        waitForElementClickable(searchButton);
        findElementByLocator(searchButton).click();
    }
    
}
