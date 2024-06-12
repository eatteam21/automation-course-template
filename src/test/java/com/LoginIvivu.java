package com;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.pages.IvivuLoginPage;
import com.pages.LoginPage;
import com.utils.BasicTest;
import com.utils.Utils;
public class LoginIvivu extends BasicTest {
    @Test(dataProvider = "test-data-ivivu")
    public void LoginSucessfully(String name, String password) throws Exception{
        IvivuLoginPage ivivuloginpage = new IvivuLoginPage(driver);
        String url = "https://www.ivivu.com/";
        driver.get(url);
        Assert.assertEquals(driver.getCurrentUrl(), url);
        
        ivivuloginpage.usernameClick();
        ivivuloginpage.firstLogin();
        ivivuloginpage.enterEmail(name);
        ivivuloginpage.enterPassword(password);
        ivivuloginpage.clickLogin();
        ////span[contains(text(),'tetakok687@lucvucom')]
        WebElement usernameCheck = ivivuloginpage.usernameCheck();
        Assert.assertTrue(usernameCheck.isDisplayed());
    }

    @DataProvider(name ="test-data-ivivu")
    public Object[][] testData() {
    Object [][] test_data_ivivu = new Object [1][2];
    test_data_ivivu[0][0] = "tetakok687@lucvu.com";
    test_data_ivivu[0][1] = "$GA@%dMh]U@td7-";
    return test_data_ivivu;
}
}
