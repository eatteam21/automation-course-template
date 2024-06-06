package com;
import org.bouncycastle.util.Exceptions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.pages.IvivuLoginPage;
import com.pages.LoginPage;
import com.pages.hrmloginPage;
import com.utils.BasicTest;
import com.utils.Utils;

public class hrmloginTest  extends BasicTest{
    @Test(dataProvider = "test-hrm")
    public void LoginSucessfully(String username, String password) throws Exception{
        hrmloginPage hrmlogin = new hrmloginPage(driver);
        String url = "https://icehrm-open.gamonoid.com/login.php#";
        driver.get(url);
        Assert.assertEquals(driver.getCurrentUrl(), url);
        
        hrmlogin.usernameInput(username);
        hrmlogin.passwordInput(password);
        hrmlogin.loginButton();
        String expectedurl = "https://icehrm-open.gamonoid.com/?g=admin&n=employees&m=admin_Employees";

        WebElement usernameCheck = hrmlogin.usernameCheck();
        Assert.assertTrue(usernameCheck.isDisplayed());
    }
    @DataProvider(name = "test-hrm")
    public Object [][] test_data(){
        Object [][] test_data_feed = new Object[4][2];
        test_data_feed[0][0] = "admin";
        test_data_feed[0][1] = "admin";
        test_data_feed[1][0] = "user1";
        test_data_feed[1][1] = "demouserpwd";
        return test_data_feed;
    }
}
