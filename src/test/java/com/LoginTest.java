package com;

import org.openqa.selenium.By;
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

    //@Test()
    public void loginTestSucess() throws Exception {

        
        LoginPage loginPage =new LoginPage(driver);
        // Launch app
        driver.startActivity(new Activity(SAUCELABAPP_PACKAGE, SAUCELABAPP_ACTIVITY));
        //Assert.assertEquals(driver.getCurrentUrl(), url);
        Utils.hardWait(8000); // wait 5s

        // locator ->  sendkey -> click login
        // driver.findElement(By.xpath("//android.widget.EditText[@content-desc='test-Username']")).sendKeys("standard_user");
        loginPage.inputEmail("standrad_user");
        // enter password
        // driver.findElement(By.xpath("//android.widget.EditText[@content-desc=\"test-Password\"]")).sendKeys("secret_sauce");
        loginPage.inputPassword("secret_sauce");
        // click login
        // driver.findElement(By.xpath("//android.view.ViewGroup[@content-desc=\"test-LOGIN\"]")).click();
        loginPage.clickloginBtn();
        Utils.hardWait(9000);
        // verify login
        Utils.hardWait(10000); // 3s  
    }

    //@Test()
    public void loginTestFailedUser() throws Exception {
        LoginPage loginPage =new LoginPage(driver);
        // Launch app
        driver.startActivity(new Activity(SAUCELABAPP_PACKAGE, SAUCELABAPP_ACTIVITY));
        //Assert.assertEquals(driver.getCurrentUrl(), url);
        Utils.hardWait(8000); // wait 5s

        // locator ->  sendkey -> click login
        // driver.findElement(By.xpath("//android.widget.EditText[@content-desc='test-Username']")).sendKeys("");
        loginPage.inputEmail("standrad_user");
        // enter password
        // driver.findElement(By.xpath("//android.widget.EditText[@content-desc=\"test-Password\"]")).sendKeys("secret_sauce");
        loginPage.inputPassword("secret_sauce");
        // click login
        // driver.findElement(By.xpath("//android.view.ViewGroup[@content-desc=\"test-LOGIN\"]")).click();
        loginPage.clickloginBtn();
        Utils.hardWait(9000);
        // verify login
      Utils.hardWait(10000); // 3s
      String errorMessage;
        // verify login
        try {
            errorMessage = driver.findElement(By.xpath("//android.view.ViewGroup[@content-desc=\"test-Error message\"]//android.widget.TextView")).getText();
        
            System.out.println(errorMessage);
        } catch (Exception e) {
            errorMessage = "";
        }
        //Assert.assertEquals(errorMessage, "Username is required");
        //Assert.assertTrue(errorMessage.contains("Username is"));
        Assert.assertTrue(errorMessage.endsWith("is required"));
        Utils.hardWait();  
    }

    @Test()
    public void loginTestFailedPassword() throws Exception {
        LoginPage loginPage =new LoginPage(driver);
        // Launch app
        driver.startActivity(new Activity(SAUCELABAPP_PACKAGE, SAUCELABAPP_ACTIVITY));
        //Assert.assertEquals(driver.getCurrentUrl(), url);
        Utils.hardWait(8000); // wait 5s

        // locator ->  sendkey -> click login
        // driver.findElement(By.xpath("//android.widget.EditText[@content-desc='test-Username']")).sendKeys("standard_user");
        loginPage.inputEmail("standrad_user");
        // enter password
        // driver.findElement(By.xpath("//android.widget.EditText[@content-desc=\"test-Password\"]")).sendKeys("");
        loginPage.inputPassword("secret_sauce");
        // click login
        // driver.findElement(By.xpath("//android.view.ViewGroup[@content-desc=\"test-LOGIN\"]")).click();
        loginPage.clickloginBtn();
        Utils.hardWait(9000);
        // verify login
      Utils.hardWait(10000); // 3s
      String errorMessage;
        // verify login
        try {
            errorMessage = driver.findElement(By.xpath("//android.view.ViewGroup[@content-desc=\"test-Error message\"]//android.widget.TextView")).getText();
        
            System.out.println(errorMessage);
        } catch (Exception e) {
            errorMessage = "";
        }
        Assert.assertEquals(errorMessage, "Password is required");
        //Assert.assertTrue(errorMessage.contains("Username is"));
        //Assert.assertTrue(errorMessage.endsWith("is required"));
        Utils.hardWait();  
    }
}
