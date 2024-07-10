package com.Tiki;

import java.util.NoSuchElementException;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.pages.Tiki.TC_01Page;
import com.utils.BasicTest;



public class TC_01 extends BasicTest{
   
    //Verify the product information loaded correctly
    @Test(enabled = true)
    public void TC_001() throws Exception {
        // Launch website
        logger.info("0. Lanuch brower'");
        String url = "https://tiki.vn/";
        driver.get(url);
        Assert.assertEquals(driver.getCurrentUrl(), url);

        TC_01Page tikiPage = new TC_01Page(driver);
        logger.info("1. Verify Search textbox and 'Tìm kiếm' button are displayed");
        Assert.assertTrue(tikiPage.searchIsDisplayed());
        
        logger.info("2. Fill 'Điện thoại' into search textbox");
        tikiPage.searchInput("Điện Thoại");
        
        logger.info("3. Click 'Tìm kiếm' and verfiy Breadcrumbs");
        tikiPage.clickFindButton();
        Assert.assertTrue(tikiPage.breadcrumbIsDisplay());
        
        logger.info("4. Verify the selected item is displayed correctly in details");
        try {
            tikiPage.Phone("iPhone 15 Plus");
            String productName = tikiPage.nameOfProduct();
            System.out.println("Tên sản phẩm đã chọn: " + productName);
        } catch (NoSuchElementException e) {
            System.out.println(e.getMessage());
        }
        
    }

    
}
