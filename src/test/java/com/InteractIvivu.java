package com;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.pages.IvivuInteractPage;
import com.utils.BasicTest;
import com.utils.Utils;
public class InteractIvivu extends BasicTest {
    @Test()
    public void InteractIvivuCheck() throws Exception{
        IvivuInteractPage interactIvivupage = new IvivuInteractPage(driver);
        String url = "https://www.ivivu.com/";
        driver.get(url);
        Assert.assertEquals(driver.getCurrentUrl(), url);
        Utils.hardWait();

        interactIvivupage.locationInput();
        Utils.hardWait();
        interactIvivupage.locationClick();
        Utils.hardWait();
        interactIvivupage.datePicker();
        Utils.hardWait();
        interactIvivupage.dateElement();
        Utils.hardWait();
        interactIvivupage.submitClick();
        Utils.hardWait();

        String testURL = "https://www.ivivu.com/khach-san-da-lat";
        Assert.assertEquals(driver.getCurrentUrl(), testURL);

        interactIvivupage.clickLink();
        List<String> windowHandles = new ArrayList<>(driver.getWindowHandles());
        // Switch to the new tab (assuming the new tab is the second one)
        driver.switchTo().window(windowHandles.get(1));
        Utils.hardWait();
        interactIvivupage.regRoom();
        Utils.hardWait();
        interactIvivupage.regRoomOrder();
        Utils.hardWait();

        String currentUrl = driver.getCurrentUrl();
        String urlForm = "https://pay.ivivu.com/thanh-toan-v2";
        
        Assert.assertTrue(currentUrl.contains(urlForm));

        
    }
}
