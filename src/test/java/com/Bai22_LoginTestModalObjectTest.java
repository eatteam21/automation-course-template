package com;

import java.sql.Driver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.pages.LoginPage;
import com.utils.BasicTest;
import com.utils.Utils;

public class Bai22_LoginTestModalObjectTest extends BasicTest {
    @DataProvider(name = "loginTestData")
    public Object[][] testDataFeed() {
        Object[][] testdata = new Object[1][3];

        testdata[0][0] = "trongtuyen451@gmail.com";
        testdata[0][1] = "Admin@123456";
        testdata[0][2] = true;
        return testdata;
    }

    public boolean isLogoutDisplayed() {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[contains(@class,'logout')]")));
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
        LoginPage loginPage = new LoginPage(driver);
        loginPage.enterEmail(uname)
                .enterPassword(pw)
                .enterLogin();
        boolean logoutBtnDisplayed = isLogoutDisplayed();
        Assert.assertEquals(logoutBtnDisplayed, expectedLogoutDisplay);
    }

}
