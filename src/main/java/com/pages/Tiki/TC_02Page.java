package com.pages.Tiki;

import java.util.List;
import java.util.NoSuchElementException;

import org.apache.logging.log4j.core.util.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.github.javafaker.Bool;
import com.pages.BasePage;
import com.utils.Utils;

public class TC_02Page extends BasePage {

    private By categoryTable = By.xpath("//div[@class='styles__StyledSideBar-sc-s7dkhn-0 jZosWU']");
    private By exploreCategories = By.xpath( "//div[contains(@class,'styles__SubCatesContainer')]");
    private By textBreadcrumb = By.xpath("//div[@class='breadcrumb']");
    private By allBtn = By.xpath("//button[@class='styles__StyledButton-sc-kqbl3f-0 bQYwcw']");
    private By allFilter = By.xpath("//div[@class='styles__StyledPopupContent-sc-1fz54eb-4 bTgOnH']");
    private By startPrice = By.xpath("//input[@placeholder='Từ']");
    private By endPrice = By.xpath("//input[@placeholder='Đến']");
    private By clickSeeMore = By.xpath("(//a[@class='toggler'])[3]");
    private By gridProduct = By.xpath("//div[contains(@class,'CatalogProducts__Wrapper')]//div[contains(@class,'styles__ProductItemContainerStyled')]");
    private By priceLocator =By.xpath("//div[@class='price-discount__price']");
    private By highLight = By.xpath("(//div[contains(@class,'styles__ChipList-sc-jnl489-4')])[3]");
    private By parentTopDeal = By.xpath("//span[contains(@class,'style__StyledItem')]");
    private By topDeal = By.xpath("//img[contains(@class,'styles__StyledImg-sc-p9s3t3-0')]");
    public TC_02Page(WebDriver givenDriver) {
        super(givenDriver);
        // TODO Auto-generated constructor stub
    }

    public void findCategoryByName(String name){
        waitForElementVisible(categoryTable);
        String locator = "//*[contains(text(),'" + name +"')]";
        By element = By.xpath(locator);
        findElementByLocator(element).click();
    }

    public void findExploreCategoriesByName(String name){
        waitForElementVisible(exploreCategories);
        String locator = "//*[contains(text(),'" + name +"')]";
        By element = By.xpath(locator);
        findElementByLocator(element).click();
    }

    public void findExploreCategories(String name){
        
        String locator = "//div[contains(@class,'styles__SubCatesList')]//*[contains(text(),'" + name +"')]";
        
        By element = By.xpath(locator);
        waitForElementVisible(element);
        findElementByLocator(element).click();
    }

    public boolean textBreadcrumbIsDisplayed(){
        waitForElementVisible(textBreadcrumb);
        findElementByLocator(textBreadcrumb).getText();
        return findElementByLocator(textBreadcrumb).isDisplayed();
    }

    public boolean allBtnIsDisplayed(){
        waitForElementVisible(allBtn);  
        return findElementByLocator(allBtn).isDisplayed();
    }

    public void allBtn(){
        waitForElementVisible(allBtn);
        findElementByLocator(allBtn).click();
    }

    public void clickSeeMore(){
        waitForElementVisible(clickSeeMore);
        findElementByLocator(clickSeeMore).click();
    }

    public void chooseAllFilter(String name){
        waitForElementVisible(allFilter);
        String locator = "//div[@class='styles__StyledPopupContent-sc-1fz54eb-4 bTgOnH']//*[contains(text(),'" + name +"')]";
        By element = By.xpath(locator);
        findElementByLocator(element).click();
    }

    public void chooseSupplier(String name){
        waitForElementVisible(allFilter);
        String locator = "//div[contains(@class, 'GroupFilterStyle__StyledListContent')]//*[contains(text(),'" + name +"')]";
        By element = By.xpath(locator);
        findElementByLocator(element).click();
    }

    public void choosePriceStart(String priceStart){
        waitForElementVisible(startPrice);
        findElementByLocator(startPrice).sendKeys(priceStart);
        
    }

    public void choosePriceEnd(String priceEnd){    
        waitForElementVisible(endPrice);  
        findElementByLocator(endPrice).sendKeys(priceEnd);
    }

    public boolean checkboxIsDisplay(String name){
        String locator = "//div[contains(@class, 'styles__StyledCheckboxFilter')]//*[contains(text(),'" + name +"')]";
        By element = By.xpath(locator);
        return findElementByLocator(element).isDisplayed();
    }

    public void clickCheckResult(String name){
        waitForElementVisible(allFilter);
        String locator = "//div[contains(@class, 'styles__StyledActionGroup')]//*[contains(text(),'" + name +"')]";
        By element = By.xpath(locator);
        findElementByLocator(element).click();
    }

    public Boolean gridProduct(String name) {

        Boolean result = true;
        System.out.println("11111");
        waitForElementVisible(gridProduct);
        System.out.println("111112");
        Utils.hardWait(5000);

        // Tìm tất cả sản phẩm trong lưới
        List<WebElement> products = driver.findElements(gridProduct); // 40 produtcs
        System.out.println("11113");

        // Lặp qua từng sản phẩm và so sánh tên (không phân biệt chữ hoa chữ thường)
        for (WebElement product : products) { 
            
            System.out.println("11114");
            // WebElement nameElement = product.findElement(By.tagName("h3"));  
            Utils.hardWait(5000);
            WebElement nameElement = product.findElement(By.xpath(".//h3"));

            
            System.out.println("11115");
            if (nameElement != null) {
                String productName = nameElement.getText();
                if (!productName.contains(name)) {
                    result = false;
                    return result;
                }
            }
        }

        return result;
    }
    public Boolean checkProductName(String name) {
        return gridProduct(name);
    }

    public String nameOfProduct() {
        String locator = "//div[contains(@class, 'style__StyledNameProduction')]//h3";
        By element = By.xpath(locator);
        waitForElementVisible(element);    
        return findElementByLocator(element).getText();
    }

    public Boolean verifyAllPricesInRange(int minPrice, int maxPrice) {
        waitForElementVisible(priceLocator);
        Boolean result = true;
        // Locate all price elements in the result grid
        List<WebElement> prices = driver.findElements(priceLocator);

        // Iterate over each price and check if it is within the specified range
        for (WebElement priceElement : prices) {
            //Phương thức này được sử dụng để thay thế các phần của chuỗi dựa trên biểu thức chính quy
            String priceText = priceElement.getText().replaceAll("[^\\d]", "").trim();
            try {
                int price = Integer.parseInt(priceText);
                if (price < minPrice || price > maxPrice) {
                    result = false;
                    return result;
                }
            } catch (NumberFormatException e) {
                System.out.println("Error parsing price: " + priceText);
                result = false;
                return result;
            }
        }
        return result;
    }
    public Boolean verifyHighLight(){
        waitForElementVisible(highLight);
        Boolean result = true;

        List<WebElement> productHighLight = driver.findElements(highLight);

        for(WebElement product: productHighLight){
            WebElement proElement = product.findElement(By.xpath("//button[contains(@class,'ksuoUg')]"));
            if (proElement == null) {
                // Log the text of the found element for debugging (optional)
                System.out.println("Highlight found: " + proElement.getText());
                
                // Set the result to false and return immediately
                result = false;
                return result;
            }
        }
        return result;
    }

    public Boolean verifyTopDeal(){
        waitForElementVisible(parentTopDeal);
        Boolean result = true;
        List<WebElement> products = driver.findElements(topDeal);
        for(WebElement product : products){
            WebElement titleElement = product.findElement(By.xpath("//img[contains(@class,'styles__StyledImg-sc-p9s3t3-0')]"));
            if(titleElement == null){
                String titleProduct = titleElement.getText();
                if(titleProduct == null){
                    result = false;
                    return result;
                }
                
            } 
        }
        return result;
    }
}
