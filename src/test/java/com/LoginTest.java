package com;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.swing.plaf.synth.SynthTextAreaUI;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.pages.LoginPage;
import com.utils.BasicTest;
import com.utils.Utils;

import io.appium.java_client.android.Activity;
import io.appium.java_client.android.AndroidDriver;

public class LoginTest extends BasicTest {
    

    private final String SAUCELABAPP_ACTIVITY = "com.swaglabsmobileapp.MainActivity";
    private final String SAUCELABAPP_PACKAGE = "com.swaglabsmobileapp";

    @Test()
    public void loginTestSucess() throws Exception {

        LoginPage loginPage = new LoginPage(driver);


        // Launch app
        driver.startActivity(new Activity(SAUCELABAPP_PACKAGE, SAUCELABAPP_ACTIVITY));
        //Assert.assertEquals(driver.getCurrentUrl(), url);
        // Utils.hardWait(8000); // wait 5s
        // wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.EditText[@content-desc='test-Username']")));

        // locator ->  sendkey -> click login
        // driver.findElement(By.xpath("//android.widget.EditText[@content-desc='test-Username']")).sendKeys("standard_user");
        loginPage.inputEmail("standard_user");

        // enter password
        // driver.findElement(By.xpath("//android.widget.EditText[@content-desc=\"test-Password\"]")).sendKeys("secret_sauce");
        loginPage.inputPassword("secret_sauce");
        // click login
        // driver.findElement(By.xpath("//android.view.ViewGroup[@content-desc=\"test-LOGIN\"]")).click();
        loginPage.clickLoginBtn();
        // Utils.hardWait(9000);
        

        String errorMessage;
        // verify login
        try {
            String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime());
            System.out.print(timeStamp);
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.view.ViewGroup[@content-desc=\"test-Error message\"]//android.widget.TextView")));
            errorMessage = driver.findElement(By.xpath("//android.view.ViewGroup[@content-desc=\"test-Error message\"]//android.widget.TextView")).getText();
        
            System.out.println(errorMessage);
        } catch (Exception e) {
            errorMessage = "";
            String timeStamp1 = new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime());
            System.out.print(timeStamp1);
        }
        

        Assert.assertEquals(errorMessage, "");
        // Assert.assertTrue(errorMessage.contains("Username is"));



        Utils.hardWait(); // 3s  




    }


    // @Test()
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
        String errorMessage;
        // verify login
        try {
            errorMessage = driver.findElement(By.xpath("//android.view.ViewGroup[@content-desc=\"test-Error message\"]//android.widget.TextView")).getText();
        
            System.out.println(errorMessage);
        } catch (Exception e) {
            errorMessage = "";
        }
        

        Assert.assertEquals(errorMessage, "Username is required");

        // Assert.assertEquals(errorMessage, "Username is required");
        // Assert.assertTrue(errorMessage.contains("Username is"));

        Utils.hardWait(); // 3s  




    }

}