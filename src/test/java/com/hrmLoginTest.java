package com;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.pages.hrmLoginPage;
import com.utils.BasicTest;
import com.utils.Utils;

public class hrmLoginTest extends BasicTest {


    @Test(dataProvider = "DemoLogins")
    public void loginTest(String username, String password) throws Exception {
        // Launch website
        String url = "https://icehrm-open.gamonoid.com/login.php";
        driver.get(url);
        Assert.assertEquals(driver.getCurrentUrl(), url);
        //Utils.hardWait(30000); // wait 5s


        hrmLoginPage hrmloginPage = new hrmLoginPage(driver);

        hrmloginPage.inputEmail(username);
        hrmloginPage.inputPassword(password);
        hrmloginPage.clickLoginBtn();

    }


    @DataProvider(name = "DemoLogins")
    public Object[][] testData() {
        Object[][] testDataFeed = new Object[4][2];  //4 row, 2 column
        testDataFeed[0][0] = "admin";
        testDataFeed[0][1] = "admin";
        testDataFeed[1][0] = "manager";
        testDataFeed[1][1] = "demouserpwd";
        testDataFeed[2][0] = "user1";
        testDataFeed[2][1] = "demouserpwd";
        testDataFeed[3][0] = "user2";
        testDataFeed[3][1] = "demouserpwd";
        return testDataFeed;

    }
}
