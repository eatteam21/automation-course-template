package com.Tiki;

import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.mongodb.util.Util;
import com.pages.LoginPage;
import com.pages.IviVu.LoginPageIViVu;
import com.pages.Tiki.TC_01Page;
import com.pages.Tiki.TC_02Page;
import com.utils.BasicTest;
import com.utils.Utils;


public class TC_02 extends BasicTest{
   
    //Verify the product information loaded correctly
    @Test(enabled = true)
    public void TC_002() throws Exception {
        // Launch website
        logger.info("0. Lanuch brower'");
        String url = "https://tiki.vn/";
        driver.get(url);
        Assert.assertEquals(driver.getCurrentUrl(), url);

       TC_02Page tc_02Page = new TC_02Page(driver);
        tc_02Page.findCategoryByName("Điện Gia Dụng");
        tc_02Page.findExploreCategoriesByName("Đồ dùng nhà bếp");
        tc_02Page.findExploreCategories("Lò vi sóng");
        Assert.assertTrue(tc_02Page.textBreadcrumbIsDisplayed());
        Assert.assertTrue(tc_02Page.allBtnIsDisplayed());
        tc_02Page.allBtn();
        tc_02Page.chooseAllFilter("Siêu rẻ");
        tc_02Page.chooseSupplier("Tiki Trading");
        
    }

    
}
