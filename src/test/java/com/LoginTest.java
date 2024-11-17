package com;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.utils.BasicTest;
import com.utils.Utils;

public class LoginTest extends BasicTest {


    @Test(dataProvider = "loginTestData")
    public void loginTestSuccess(String uname, String pw, boolean expectedLogoutDisplay) throws Exception { // Happy case
        // Launch website
        String url = "https://bantheme.xyz/hathanhauto/tai-khoan/";
        driver.get(url);
        Assert.assertEquals(driver.getCurrentUrl(), url);
        Utils.hardWait(1000); // 3s

        WebElement emailInput = driver.findElement(By.xpath("//input[@id='username']"));
        emailInput.sendKeys(uname);
        Utils.hardWait(1000); // 3s
        WebElement passInput = driver.findElement(By.xpath("//input[@id='password']"));
        passInput.sendKeys(pw);
        Utils.hardWait(1000); // 3s

        WebElement loginBtn = driver.findElement(By.xpath("//button[@name='login']"));
        loginBtn.click();
        Utils.hardWait(1000); // 3s


        // WebElement logoutBtn = driver.findElement(By.xpath("//li[contains(@class,'logout')]"));
        boolean logoutBtnDisplayed = isLogoutDisplayed();
        // Assert.assertTrue(logoutBtn.isDisplayed());
        // Assert.assertEquals(logoutBtnDisplayed, expectedLogoutDisplay);

        Assert.assertEquals(logoutBtnDisplayed, expectedLogoutDisplay);


    }

    // @Test(priority = 2)
    // public void loginTestFailure() throws Exception {
    //     // Launch website
    //     String url = "https://bantheme.xyz/hathanhauto/tai-khoan/";
    //     driver.get(url);
    //     Assert.assertEquals(driver.getCurrentUrl(), url);

    //     WebElement emailInput = driver.findElement(By.xpath("//input[@id='username']"));
    //     emailInput.sendKeys("trongtuyen451@gmail.com");
    //     WebElement passInput = driver.findElement(By.xpath("//input[@id='password']"));
    //     passInput.sendKeys("Admin@123456");

    //     WebElement loginBtn = driver.findElement(By.xpath("//button[@name='login']"));
    //     loginBtn.click();
    //     WebElement errorrMessageText = driver.findElement(By.xpath("//li[contains(@class,'logout')]"));
    //     Assert.assertTrue(errorrMessageText.isDisplayed());

    // }

    @DataProvider(name="loginTestData")
    public Object[][] testDataFeed() {
        Object[][] testdata = new Object[3][3];

        testdata[0][0] = "trongtuyen451@gmail.com";
        testdata[0][1] = "Admin@123456";
        testdata[0][2] = true;

        testdata[1][0] = "trongtuyen@gmail.com";
        testdata[1][1] = "Admin@123456";
        testdata[1][2] = false;

        testdata[2][0] = "trongtuyen123@gmail.com";
        testdata[2][1] = "Admin@123456";
        testdata[2][2] = false;


        return testdata;
    } 

    public boolean isLogoutDisplayed() {
        try {
            WebElement logoutBtn = driver.findElement(By.xpath("//li[contains(@class,'logout')]"));
            return true;
        } catch (Exception e) {
            return false;
        }
        
        

    } 

}
