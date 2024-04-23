package com;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.utils.Utils;
import com.utils.MobileActions;
import com.utils.BasicTest;


import io.appium.java_client.android.Activity;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class VerifyLogin extends BasicTest {

    private final String SAUCELABAPP_ACTIVITY = "com.swaglabsmobileapp.MainActivity";
    private final String SAUCELABAPP_PACKAGE = "com.swaglabsmobileapp";


    @Test()
    public void loginTest() throws Exception {
        // Launch website
        // String url = "https://automationtestpro.com/";
        // driver.get(url);
        // Assert.assertEquals(driver.getCurrentUrl(), url);

        driver.startActivity(new Activity(SAUCELABAPP_PACKAGE, SAUCELABAPP_ACTIVITY));
        Utils.hardWait(5000);

        
        AndroidElement usernameBox = (AndroidElement) driver.findElementByXPath("//*[contains(@text,'Username')]");
        usernameBox.clear();
        usernameBox.sendKeys("locked_out_user");

        AndroidElement passwordBox = (AndroidElement) driver.findElementByXPath("//*[contains(@text,'Password')]");
        passwordBox.clear();
        passwordBox.sendKeys("secret_sauce");

        AndroidElement loginBtn = (AndroidElement) driver.findElementByXPath("//*[@content-desc='test-LOGIN']");
        loginBtn.click();
        Utils.hardWait();

        AndroidElement notif = (AndroidElement) driver.findElementByXPath("//*[contains(@text, 'Sorry, this user has been locked out.')]");
        Assert.assertTrue(notif.isDisplayed());


    }

}
