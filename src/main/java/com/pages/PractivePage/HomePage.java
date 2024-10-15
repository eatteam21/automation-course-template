package com.pages.PractivePage;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.pages.BasePage;


public class HomePage extends BasePage {

    private By shopButton = By.xpath("//li[@id='menu-item-40']");
    private By logoButton = By.xpath("//div[@id='site-logo']");
    private By slideSide = By.xpath("//div[contains(@class,'themify_builder_sub_row clearfix gutter-default   sub_row_1-0-2')]//div[contains(@id,'text-22-sub_row')]");
    //private By slideSide = By.xpath("//div[contains(@class,'c_sub_row')]");
    // private By closeButton = By.xpath("null")
    
    public HomePage(WebDriver givenDriver) {
        super(givenDriver);
        
    }
    
    public void clickShop(){
        waitForElementVisible(shopButton);
        findElementByLocator(shopButton).click();
    }

    public void clickLogo(){
        waitForElementClickable(logoButton);
        findElementByLocator(logoButton).click();
    }

    public void numberSlide(){
        waitForElementClickable(slideSide);
        List<WebElement> slides = driver.findElements(slideSide);
        if (slides.size() == 3) {
            System.out.println("Test Passed: The Home page contains exactly three sliders.");
        } else {
            System.out.println("Test Failed: The Home page contains " + slides.size() + " sliders.");
        }
            //waitForElementClickable(slideSide);
    
    // // Adding an explicit wait to ensure all sliders are loaded
    // WebDriverWait wait = new WebDriverWait(driver, 10);
    // wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(slideSide));
    
    // // Find all the slider elements
    // List<WebElement> slides = driver.findElements(slideSide);
    
    // // Debugging: Print out the size and details of found sliders
    // System.out.println("Number of sliders found: " + slides.size());
    // for (WebElement slide : slides) {
    //     System.out.println("Slider HTML: " + slide.getAttribute("outerHTML"));
    // }
    
    // // Check if exactly 3 sliders are found
    // if (slides.size() == 3) {
    //     System.out.println("Test Passed: The Home page contains exactly three sliders.");
    // } else {
    //     System.out.println("Test Failed: The Home page contains " + slides.size() + " sliders.");
    // }
    // }

}
}
