package com;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.pages.IvivuLoginPage;
import com.pages.LoginPage;
import com.utils.BasicTest;
import com.utils.Utils;
public class LoginIvivu extends BasicTest {
    @Test()
    public void LoginSucessfully() throws Exception{
        IvivuLoginPage ivivuloginpage = new IvivuLoginPage(driver);
        String url = "https://www.ivivu.com/";
        driver.get(url);
        Assert.assertEquals(driver.getCurrentUrl(), url);
        Utils.hardWait();
        ivivuloginpage.usernameClick();
        ivivuloginpage.firstLogin();
        ivivuloginpage.enterEmail("tetakok687@lucvu.com");
        ivivuloginpage.enterPassword("$GA@%dMh]U@td7-");
        ivivuloginpage.clickLogin();
        ////span[contains(text(),'tetakok687@lucvucom')]
        Utils.hardWait();
        WebElement usernameCheck = ivivuloginpage.usernameCheck();
        Assert.assertTrue(usernameCheck.isDisplayed());
    }

}
