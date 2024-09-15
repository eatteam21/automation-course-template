package com;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.utils.BasicTest;
import com.utils.MobileActions;
import com.utils.Utils;

import io.appium.java_client.android.Activity;
import io.appium.java_client.android.AndroidDriver;
public class BookingTest extends BasicTest {
    

    private final String SAUCELABAPP_ACTIVITY = "com.swaglabsmobileapp.MainActivity";
    private final String SAUCELABAPP_PACKAGE = "com.swaglabsmobileapp";

    @Test()
    public void loginTest() throws Exception {
        // Launch app
        driver.startActivity(new Activity(SAUCELABAPP_PACKAGE, SAUCELABAPP_ACTIVITY));
        //Assert.assertEquals(driver.getCurrentUrl(), url);
        Utils.hardWait(8000); // wait 5s

        // locator ->  sendkey -> click login
        driver.findElement(By.xpath("//android.widget.EditText[@content-desc='test-Username']")).sendKeys("standard_user");

        // enter password
        driver.findElement(By.xpath("//android.widget.EditText[@content-desc=\"test-Password\"]")).sendKeys("secret_sauce");
        // click login
        driver.findElement(By.xpath("//android.view.ViewGroup[@content-desc=\"test-LOGIN\"]")).click();
        Utils.hardWait(9000);
        //add to cart
        driver.findElement(By.xpath("(//android.view.ViewGroup[@content-desc=\"test-ADD TO CART\"])[1]")).click();
        //go to cart
        driver.findElement(By.xpath("//android.view.ViewGroup[@content-desc=\"test-Cart\"]/android.view.ViewGroup/android.widget.ImageView")).click();
        Utils.hardWait(9000);
        //checkout
        driver.findElement(By.xpath("//android.widget.TextView[@text=\"CHECKOUT\"]")).click();
        Utils.hardWait(9000);
        //FirstName
        driver.findElement(By.xpath("//android.widget.EditText[@content-desc=\"test-First Name\"]")).sendKeys("Thanh");
        //LastName
        driver.findElement(By.xpath("//android.widget.EditText[@content-desc=\"test-Last Name\"]")).sendKeys("Duy");
        //zip
        driver.findElement(By.xpath("//android.widget.EditText[@content-desc=\"test-Zip/Postal Code\"]")).sendKeys("848484");
        //Continue
        driver.findElement(By.xpath("//android.view.ViewGroup[@content-desc=\"test-CONTINUE\"]")).click();
        Utils.hardWait(9000);


        MobileActions mobileActions = new MobileActions(driver);
        mobileActions.verticalSwipeByPercentages(0.25, 0.75, 0.5);
        Utils.hardWait(9000);


        //Finish
        driver.findElement(By.xpath("//android.widget.TextView[@text=\"FINISH\"]")).click();
        Utils.hardWait(9000);
        //Backhome
        driver.findElement(By.xpath("//android.view.ViewGroup[@content-desc=\"test-BACK HOME\"]")).click();
        //Wait

        Utils.hardWait(10000); // 3s  




    }

}
