package com;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.utils.BasicTest;
import com.utils.Utils;

public class LoginIceHrmTest extends BasicTest {
    @DataProvider(name = "loginTestData")
    public Object[][] testDataFeed() {
        Object[][] testdata = new Object[3][3];
        // true admin
        testdata[0][0] = "admin";
        testdata[0][1] = "admin";
        testdata[0][2] = false;
        // true manager
        testdata[1][0] = "manager";
        testdata[1][1] = "demouserpwd";
        testdata[1][2] = false;
        // true user 1
        testdata[2][0] = "user1";
        testdata[2][1] = "demouserpwd";
        testdata[2][2] = false;

        return testdata;
    }
    @DataProvider(name = "loginTestDataFalse")
    public Object[][] testDataFeedFalse() {
        Object[][] testdata = new Object[3][3];
     
        // false Admin
        testdata[0][0] = "admin";
        testdata[0][1] = "1234567";
        testdata[0][2] = true;
        // false manager
        testdata[1][0] = "manager";
        testdata[1][1] = "1234567";
        testdata[1][2] = true;
        // false user
        testdata[2][0] = "user1";
        testdata[2][1] = "1234567";
        testdata[2][2] = true;

        return testdata;
    }
    public boolean isMessgageDisplayed() {
        try {
            WebElement messageError = driver.findElement(By.xpath("//div[@class='alert alert-danger']"));
            return true;
        } catch (Exception e) {
            return false;
        }
    }
    @Test(dataProvider = "loginTestData")
    public void loginTestSuccess(String uname, String pw, boolean expectedMesageErrorDisplay) throws Exception {
        String url = "https://icehrm-open.gamonoid.com/login.php";
        driver.get(url);
        Assert.assertEquals(driver.getCurrentUrl(), url);
        Utils.hardWait(1000);

        WebElement emailInput = driver.findElement(By.xpath("//input[@id='username']"));
        emailInput.sendKeys(uname);
        Utils.hardWait(1000);
        WebElement passInput = driver.findElement(By.xpath("//input[@id='password']"));
        passInput.sendKeys(pw);
        Utils.hardWait(1000);

        WebElement loginBtn = driver.findElement(By.xpath("//button[@class='btn btn-info btn-medium w-100 text-uppercase'][1]"));
        // WebElement loginButton = driver.findElement(By.xpath("//button[contains(text(),'Log in')]"));
        loginBtn.click();
        Utils.hardWait(1000);
        // boolean MessgageDisplayed = isMessgageDisplayed();
        Assert.assertEquals(isMessgageDisplayed(), expectedMesageErrorDisplay);
    }
    @Test(dataProvider = "loginTestDataFalse")
    public void loginTestFalse(String unamefalse, String pwfalse, boolean expectedMesageErrorDisplay) throws Exception {
        String url = "https://icehrm-open.gamonoid.com/login.php";
        driver.get(url);
        Assert.assertEquals(driver.getCurrentUrl(), url);
        Utils.hardWait(1000);

        WebElement emailInput = driver.findElement(By.xpath("//input[@id='username']"));
        emailInput.sendKeys(unamefalse);
        Utils.hardWait(1000);
        WebElement passInput = driver.findElement(By.xpath("//input[@id='password']"));
        passInput.sendKeys(pwfalse);
        Utils.hardWait(1000);

        WebElement loginBtn = driver.findElement(By.xpath("//button[@class='btn btn-info btn-medium w-100 text-uppercase'][1]"));
        // WebElement loginButton = driver.findElement(By.xpath("//button[contains(text(),'Log in')]"));
        loginBtn.click();
        Utils.hardWait(1000);
        // boolean MessgageDisplayed = isMessgageDisplayed();
        Assert.assertEquals(isMessgageDisplayed(), expectedMesageErrorDisplay);
    }
}
