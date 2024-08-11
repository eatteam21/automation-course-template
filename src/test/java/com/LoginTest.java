package com;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.utils.BasicTest;
import com.utils.Utils;

import io.appium.java_client.android.Activity;
import io.appium.java_client.android.AndroidDriver;

public class LoginTest extends BasicTest {
    

    private final String SAUCELABAPP_ACTIVITY = "com.swaglabsmobileapp.MainActivity";
    private final String SAUCELABAPP_PACKAGE = "com.swaglabsmobileapp";

    //@Test()
    public void loginTestSucess() throws Exception {
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


        // verify login

        Utils.hardWait(10000); // 3s  




    }


    @Test()
    public void loginTestFailedUser() throws Exception {
        // Launch app
        driver.startActivity(new Activity(SAUCELABAPP_PACKAGE, SAUCELABAPP_ACTIVITY));
        //Assert.assertEquals(driver.getCurrentUrl(), url);
        Utils.hardWait(8000); // wait 5s

        // locator ->  sendkey -> click login
        driver.findElement(By.xpath("//android.widget.EditText[@content-desc='test-Username']")).sendKeys("");

        // enter password
        driver.findElement(By.xpath("//android.widget.EditText[@content-desc=\"test-Password\"]")).sendKeys("secret_sauce");
        // click login
        driver.findElement(By.xpath("//android.view.ViewGroup[@content-desc=\"test-LOGIN\"]")).click();
        Utils.hardWait(9000);


        // verify login

        Utils.hardWait(10000); // 3s  




    }

}
