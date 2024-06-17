package com;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.pages.LoginPage;
import com.pages.tikiLoginPage;
import com.utils.BasicTest;
import com.utils.Utils;
public class TikiTest extends BasicTest {
    @Test()
    public void NavigateSuccessfully() throws Exception {

        tikiLoginPage loginTikiPage = new tikiLoginPage(driver);


        // Launch website
        String url = "https://tiki.vn/";
        driver.get(url);
        Assert.assertEquals(driver.getCurrentUrl(), url);


        WebElement searchIcon = loginTikiPage.searchIcon(); // Kiem tra search Icon
        Assert.assertTrue(searchIcon.isDisplayed());
        
        loginTikiPage.searchText("Điện thoại");
        loginTikiPage.searchButton();

        WebElement mainPage = loginTikiPage.mainPage(); // Hien breadcrum trang chu
        Assert.assertTrue(mainPage.isDisplayed());
        
        loginTikiPage.productClick();

        WebElement productTitle = loginTikiPage.productTitle(); //ten san pham
        Assert.assertTrue(productTitle.isDisplayed());

        WebElement productPrice = loginTikiPage.productPrice(); // gia san pham
        Assert.assertTrue(productPrice.isDisplayed());
           
    }
}
