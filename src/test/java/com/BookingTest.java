package com;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.pages.CompletePage;
import com.pages.HomePage;
import com.pages.Information;
import com.pages.LoginPage;
import com.pages.OverviewPage;
import com.pages.YourCart;
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
        LoginPage loginPage =new LoginPage(driver);
        HomePage homePage= new HomePage(driver);
        YourCart yourCart= new YourCart(driver);
        Information informationPage = new Information(driver);
        OverviewPage overviewPage = new OverviewPage(driver);
        CompletePage completePage= new CompletePage(driver);
        // Launch app
        driver.startActivity(new Activity(SAUCELABAPP_PACKAGE, SAUCELABAPP_ACTIVITY));
        //Assert.assertEquals(driver.getCurrentUrl(), url);
        Utils.hardWait(12000); // wait 5s

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
        //add to cart
        // driver.findElement(By.xpath("(//android.view.ViewGroup[@content-desc=\"test-ADD TO CART\"])[1]")).click();
        homePage.clickAddBtn();
        //go to cart
        // driver.findElement(By.xpath("//android.view.ViewGroup[@content-desc=\"test-Cart\"]/android.view.ViewGroup/android.widget.ImageView")).click();
        homePage.clickCartBtn();
        Utils.hardWait(9000);
        //checkout
        // driver.findElement(By.xpath("//android.widget.TextView[@text=\"CHECKOUT\"]")).click();
        yourCart.checkoutBtn();
        Utils.hardWait(9000);
        //FirstName
        // driver.findElement(By.xpath("//android.widget.EditText[@content-desc=\"test-First Name\"]")).sendKeys("Thanh");
        informationPage.inputFirstName("Duy");
        //LastName
        // driver.findElement(By.xpath("//android.widget.EditText[@content-desc=\"test-Last Name\"]")).sendKeys("Duy");
        informationPage.inputLastName("Thanh");
        //zip
        //driver.findElement(By.xpath("//android.widget.EditText[@content-desc=\"test-Zip/Postal Code\"]")).sendKeys("848484");
        informationPage.inputZipCode("848484");
        //Continue
        //driver.findElement(By.xpath("//android.view.ViewGroup[@content-desc=\"test-CONTINUE\"]")).click();
        informationPage.clickContinueBtn();
        Utils.hardWait(9000);
        MobileActions mobileActions = new MobileActions(driver);
        mobileActions.verticalSwipeByPercentages(0.7, 0.3, 0.5);
        Utils.hardWait(9000);
        //Finish
        // driver.findElement(By.xpath("//android.widget.TextView[@text=\"FINISH\"]")).click();
        overviewPage.clickFinishBtn();
        Utils.hardWait(9000);
        //Backhome
        // driver.findElement(By.xpath("//android.view.ViewGroup[@content-desc=\"test-BACK HOME\"]")).click();
        completePage.clickBackHomeBtn();
        //Wait
        Utils.hardWait(10000); // 3s  
     }

}
