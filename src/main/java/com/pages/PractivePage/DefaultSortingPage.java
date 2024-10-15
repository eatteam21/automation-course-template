package com.pages.PractivePage;

import java.util.List;

import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.pages.BasePage;


public class DefaultSortingPage extends BasePage {

    

    private By sortCombobox = By.xpath("//select[@class='orderby']");
    private By productPriceLocator = By.cssSelector(".price .woocommerce-Price-amount");

    public   DefaultSortingPage(WebDriver givenDriver) {
        super(givenDriver);
        
    }
    
    public void clickCombobox(){
       waitForElementClickable(sortCombobox);
       findElementByLocator(sortCombobox).click();
    }
    
    public void clickOption(String name){
        String locator = "//select[@class='orderby']//option[@value='"+ name +"']";
        By element = By.xpath(locator);
        findElementByLocator(element).click();
        
    }

    public void compareWithExpected(){
        List<WebElement> productPrices = driver.findElements(productPriceLocator);

        Boolean isSorted = false;

        for (int i = 1; i < productPrices.size(); i++) {
            // Lấy giá trị của sản phẩm hiện tại và sản phẩm trước đó, loại bỏ ký hiệu tiền tệ và dấu phẩy
            double previousPrice = Double.parseDouble(productPrices.get(i - 1).getText().replace("₹", "").replace(",", ""));
            double currentPrice = Double.parseDouble(productPrices.get(i).getText().replace("₹", "").replace(",", ""));

            // Nếu giá hiện tại nhỏ hơn giá trước đó, báo lỗi
            if (currentPrice < previousPrice) {
                isSorted = true;
                System.out.println("Sản phẩm sau có giá nhỏ hơn sản phẩm trước: " + previousPrice + " > " + currentPrice);
                break;
            }

        }
        if (isSorted) {
            System.out.println("Các sản phẩm đã được sắp xếp đúng theo thứ tự giá từ thấp đến cao.");
        } else {
            System.out.println("Các sản phẩm không được sắp xếp đúng.");
        }
        }
        
    }


