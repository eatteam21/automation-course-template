package com.PractivePage;

import java.util.List;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.pages.PractivePage.HomePage;
import com.pages.PractivePage.ProductCategoriesPage;
import com.utils.BasicTest;
import com.utils.Utils;

// Test Case 1: Search for an Existing Product
// Objective: Verify that users can search for a product that exists on the platform.
// Preconditions: The product exists in the inventory.
// Steps:
// Enter a product name (e.g., "Laptop") in the search bar.
// Click on the "Search" button.
// Expected Result: The search results page displays products related to the keyword.

public class ProductCategoriesTest extends BasicTest {


    @Test(enabled = true)
    public void registerFailed1() throws Exception {
        // Launch website
        String url = "https://practice.automationtesting.in/";
        driver.get(url);
        Assert.assertEquals(driver.getCurrentUrl(), url);


        HomePage homePage = new HomePage(driver);
        ProductCategoriesPage productPage = new ProductCategoriesPage(driver);
        homePage.clickShop();
        Utils.hardWait();
        Assert.assertEquals(driver.getCurrentUrl(), "https://practice.automationtesting.in/shop/");
        productPage.clickProduct("HTML5 WebApp Develpment");
        
        productPage.compareNameOfProduct("HTML5 WebApp Develpment");
        //productPage.clickProduct("Android Quick Start Guide");
        //Assert.assertEquals(driver.getCurrentUrl(), "https://tiki.vn");
        //searchPage.nameOfProduct();

    }

}