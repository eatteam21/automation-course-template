package com.RevReply;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.mongodb.util.Util;
import com.pages.LoginPage;
import com.pages.IviVu.LoginPageIViVu;
import com.pages.RevReply.AddPage;
import com.pages.RevReply.LoginRevReplyPage;
import com.utils.BasicTest;
import com.utils.Utils;

public class AddTest extends BasicTest{
   

    @Test(enabled = true)
    public void loginTestFailed() throws Exception {
        // Launch website
        String url = "https://stg.revreply.com/login";
        driver.get(url);
        Assert.assertEquals(driver.getCurrentUrl(), url);

        LoginRevReplyPage loginPage = new LoginRevReplyPage(driver);
        AddPage addPage = new AddPage(driver);
        loginPage.inputEmail("minhphat3575@gmail.com");
        loginPage.inputPassword("Minhphat13575@.");
        loginPage.clickLogin();
        // Assert.assertEquals(driver.getCurrentUrl(), "https://stg.revreply.com/personas");
        Utils.hardWait();
        addPage.clickAdd();
        Utils.hardWait();
        addPage.clickProfileConfig();
        addPage.fillFirstName("Minh Phat");
        addPage.fillLastName("Nguyen Huynh");
        addPage.fillCompany("Hitachi");
        addPage.fillCompanyUrl("https://www.facebook.com/MinhPhat3101/");
        addPage.fillCompanyOverView();
        Utils.hardWait(10000);
        addPage.clickUpdate();
        Utils.hardWait();
        
        
        

    }

}
