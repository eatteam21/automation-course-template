package com;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.mongodb.util.Util;
import com.pages.SearchPage;
import com.utils.BasicTest;
import com.utils.Utils;

public class SearchTest extends BasicTest {


    @Test(enabled = false)
    public void registerFailed1() throws Exception {
        // Launch website
        String url = "https://www.amazon.com/";
        driver.get(url);
        Assert.assertEquals(driver.getCurrentUrl(), url);


        SearchPage searchPage = new SearchPage(driver);
        searchPage.inputsearch("Laptop");
        searchPage.clickSearch();

        // driver.findElement(By.xpath("//button[@name='register']")).click();
        // Utils.hardWait();

        // // Assert.assertTrue(driver.findElement(By.name("login")).isDisplayed());
        // String failedMessage = driver.findElement(By.xpath("//ul[@class ='woocommerce-error']/li")).getText();

        
        Assert.assertEquals(driver.getCurrentUrl(), "https://www.amazon.com/s?k=Laptop&crid=4GNSW31EIFUU&sprefix=laptop%2Caps%2C648&ref=nb_sb_noss_1");
    }

}