package com;
import org.openqa.selenium.By;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.pages.LoginPage;
import com.pages.tikiFilterPage;
import com.pages.tikiLoginPage;
import com.utils.BasicTest;
import com.utils.Utils;
public class FilterTiki extends BasicTest{
    @Test()
    public void FilterSuccessfully() throws Exception {  
        tikiFilterPage tikiFilterPage = new tikiFilterPage(driver);

        // Launch website
        String url = "https://tiki.vn/";
        driver.get(url);
        Assert.assertEquals(driver.getCurrentUrl(), url);
        tikiFilterPage.leftSideBar();
        tikiFilterPage.miniLeftSide();
        tikiFilterPage.miniLeftSide_2();
        WebElement verifyBreadCrum = tikiFilterPage.verifyBreadCrum(); // Hien breadcrum trang chu
        Assert.assertTrue(verifyBreadCrum.isDisplayed());

        tikiFilterPage.filterButton();
        WebElement allFilter = tikiFilterPage.allFilter(); // hien thi tat ca bo loc
        Assert.assertTrue(allFilter.isDisplayed());

        tikiFilterPage.fillter("Ưu đãi","Siêu rẻ");
        tikiFilterPage.fillter_2("Nhà cung cấp","Tiki Trading");
        tikiFilterPage.fillterPrice("Từ","1000000");
        tikiFilterPage.fillterPrice("Đến","2000000");
        tikiFilterPage.CloseButton();
        WebElement topDealLabel = tikiFilterPage.topDealLabel();
        Assert.assertTrue(topDealLabel.isDisplayed());
    }
}
    
