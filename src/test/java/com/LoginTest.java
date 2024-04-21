package com;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.utils.Utils;

import com.utils.BasicTest;


import io.appium.java_client.android.Activity;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class LoginTest extends BasicTest {

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
        AndroidElement addToCartBtn = (AndroidElement) driver.findElementByXPath("//*[contains(@text,'ADD TO CART')][1]");
        addToCartBtn.click();
        Utils.hardWait();
//view cart
        AndroidElement viewCartBtn = (AndroidElement) driver.findElementByXPath("//android.view.ViewGroup[@content-desc='test-Cart']/android.view.ViewGroup/android.widget.ImageView");
        viewCartBtn.click();
        Utils.hardWait();
//checkout
        AndroidElement checkOutBtn = (AndroidElement) driver.findElementByXPath("//*[contains(@text,'CHECKOUT')]");
        checkOutBtn.click();
        Utils.hardWait();
//input text
        AndroidElement firtNameBox = (AndroidElement) driver.findElementByXPath("//*[contains(@text,'First Name')]");
        firtNameBox.clear();
        firtNameBox.sendKeys("Lan");

        AndroidElement lastNameBox = (AndroidElement) driver.findElementByXPath("//*[contains(@text,'Last Name')]");
        lastNameBox.clear();
        lastNameBox.sendKeys("Nguyen");

        AndroidElement zipCodeBox = (AndroidElement) driver.findElementByXPath("//*[contains(@text,'Zip/Postal Code')]");
        zipCodeBox.clear();
        zipCodeBox.sendKeys("1807");

        AndroidElement continueBtn = (AndroidElement) driver.findElementByXPath("//*[contains(@text,'CONTINUE')]");
        continueBtn.click();
        Utils.hardWait();
//finish
        AndroidElement finishBtn = (AndroidElement) driver.findElementByXPath("//android.view.ViewGroup[@content-desc='test-FINISH']");
        finishBtn.click();
        Utils.hardWait();
//verify
        AndroidElement checkoutSuccess = (AndroidElement) driver.findElementByXPath("//*[contains(@text,'CHECKOUT: COMPLETE!')]");
        Assert.assertTrue(checkoutSuccess.isDisplayed());


    }

}
