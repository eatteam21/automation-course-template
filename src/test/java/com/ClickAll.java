package com;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.utils.Utils;
import com.utils.MobileActions;
import com.utils.BasicTest;


import io.appium.java_client.android.Activity;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class ClickAll extends BasicTest {

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
        usernameBox.sendKeys("standard_user");

        AndroidElement passwordBox = (AndroidElement) driver.findElementByXPath("//*[contains(@text,'Password')]");
        passwordBox.clear();
        passwordBox.sendKeys("secret_sauce");

        AndroidElement loginBtn = (AndroidElement) driver.findElementByXPath("//*[@content-desc='test-LOGIN']");
        loginBtn.click();
        Utils.hardWait();

        AndroidElement notif = (AndroidElement) driver.findElementByXPath("(//*[@class='android.widget.TextView'])[3]");
        Assert.assertTrue(notif.isDisplayed());

//viet scrip flow add to cart - checkout - verify msg mua hang thanh cong
//add to cart

        for(int i=1;i<=4;i++){
                String locator = "//*[contains(@text,'ADD TO CART')][1]";
                
               // System.out.println(locator);

                AndroidElement addToCartBtn = (AndroidElement) driver.findElementByXPath(locator);
                addToCartBtn.click();
                Utils.hardWait();
                if(i==2 || i==3){
                        MobileActions mobileActions = new MobileActions(driver);
                        mobileActions.verticalSwipeByPercentages(0.7, 0.3, 0.5);
                        Utils.hardWait(1000); 

                        AndroidElement addToCartBtn1 = (AndroidElement) driver.findElementByXPath(locator);
                        addToCartBtn1.click();
                        Utils.hardWait();
                }
               // System.out.println(i);
        }
        AndroidElement checkoutSuccess = (AndroidElement) driver.findElementByXPath("//android.widget.TextView[@text='6']");
        Assert.assertTrue(checkoutSuccess.isDisplayed());


    }

}
