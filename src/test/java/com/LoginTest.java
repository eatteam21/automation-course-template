package com;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.utils.BasicTest;
import com.utils.Utils;

public class LoginTest extends BasicTest {
    @DataProvider(name = "loginTestData")
    public Object[][] testDataFeed() {
        Object[][] testdata = new Object[1][3];

        testdata[0][0] = "trongtuyen451@gmail.com";
        testdata[0][1] = "Admin@123456";
        testdata[0][2] = true;
        return testdata;
    }

    @DataProvider(name = "loginTestDataFalse")
    public Object[][] testDataFeedFalse() {
        Object[][] testdata = new Object[5][3];

        testdata[0][0] = "trongtuyen@gmail.com";
        testdata[0][1] = "Admin@123456";
        testdata[0][2] = true;

        testdata[1][0] = "trongtuyen123@gmail.com";
        testdata[1][1] = "Admin@123456";
        testdata[1][2] = true;

        testdata[2][0] = "";
        testdata[2][1] = "Admin@123456";
        testdata[2][2] = true;

        testdata[3][0] = "trongtuyen451@gmail.com";
        testdata[3][1] = "";
        testdata[3][2] = true;

        testdata[4][0] = "";
        testdata[4][1] = "";
        testdata[4][2] = true;

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

    @Test(dataProvider = "loginTestData")
    public void loginTestSuccess(String uname, String pw, boolean expectedLogoutDisplay) throws Exception {
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
        boolean logoutBtnDisplayed = isLogoutDisplayed();
        Assert.assertEquals(logoutBtnDisplayed, expectedLogoutDisplay);
    }



    public boolean isMessageErrorDisplayed() {
        try {
            WebElement messageError = driver.findElement(By.xpath("//ul[@class='woocommerce-error']"));
            return true;
        } catch (Exception e) {
            return false;
        }

    }
    @Test(dataProvider = "loginTestDataFalse")
    public void loginTestFalse(String unameFalse, String pwFalse, boolean expectedErrorMessageDisplay) throws Exception {
        String url = "https://bantheme.xyz/hathanhauto/tai-khoan/";
        driver.get(url);
        Assert.assertEquals(driver.getCurrentUrl(), url);
        Utils.hardWait(1000); // 3s

        WebElement emailInput = driver.findElement(By.xpath("//input[@id='username']"));
        emailInput.sendKeys(unameFalse);
        Utils.hardWait(1000); // 3s
        WebElement passInput = driver.findElement(By.xpath("//input[@id='password']"));
        passInput.sendKeys(pwFalse);
        Utils.hardWait(1000); // 3s

        WebElement loginBtn = driver.findElement(By.xpath("//button[@name='login']"));
        loginBtn.click();
        Utils.hardWait(1000); // 3s
        boolean messageErrorDisplayed = isMessageErrorDisplayed();
        Assert.assertEquals(messageErrorDisplayed, expectedErrorMessageDisplay);
    }
}
