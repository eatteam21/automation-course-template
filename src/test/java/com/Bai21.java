package com;

import javax.swing.Action;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.applitools.eyes.selenium.SeleniumEyes.WebDriverAction;
import com.utils.BasicTest;
import com.utils.Utils;

public class Bai21 extends BasicTest {
    @Test()
    public void loginTest() throws Exception {
        // Launch website
        String url = "https://zingmp3.vn/";
        driver.get(url);
        Assert.assertEquals(driver.getCurrentUrl(), url);

       //Find element and right click
       WebDriverWait wait = new WebDriverWait(driver, 10);
       Actions action = new Actions(driver);
       WebElement media = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class=\"media\"]")));
       action.moveToElement(media).contextClick().perform();
       Assert.assertTrue(driver.findElement(By.xpath("//*[@class=\"zm-contextmenu song-menu\"]")).isDisplayed());
       // Continue hover to "Share" option
       WebElement shareBtn = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'Chia sẻ')]")));
       action.moveToElement(shareBtn).perform();
       Assert.assertTrue(
        wait.until(ExpectedConditions.visibilityOfElementLocated(
            (By.xpath("//*[@class=\"menu share-content submenu-content\"]"))
            )
            ).isDisplayed());

       


    }
}