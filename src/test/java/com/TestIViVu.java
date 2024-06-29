package com;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.mongodb.util.Util;
import com.pages.IViVuPage;
import com.pages.LoginPage;
import com.pages.LoginPageIViVu;
import com.utils.BasicTest;
import com.utils.Utils;

public class TestIViVu extends BasicTest{
   

    @Test(enabled = true)
    public void loginTestFailed2() throws Exception {
        // Launch website
        String url = "https://www.ivivu.com/";
        driver.get(url);
        Assert.assertEquals(driver.getCurrentUrl(), url);

        IViVuPage pageIViVu = new IViVuPage(driver);
        
        pageIViVu.searchText();
        pageIViVu.chooseLocation("Đà Lạt");
        // pageIViVu.clickDateChecking();
        pageIViVu.pickDateChecking("Th 07 2024", "28");
        pageIViVu.pickDateOut("Th 07 2024", "29");
        pageIViVu.clickIncreaseRoom(3);
        
        pageIViVu.clickFind();
    }
}
