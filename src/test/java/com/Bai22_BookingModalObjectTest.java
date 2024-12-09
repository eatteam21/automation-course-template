package com;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
//import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.google.gson.annotations.Until;
import com.pages.CartPage;
import com.pages.HomePage;
import com.pages.LoginPage;
//import com.utils.Utils;
import com.utils.BasicTest;

public class Bai22_BookingModalObjectTest extends BasicTest {
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
           HomePage homePage=new HomePage(driver);
           wait.until(ExpectedConditions.visibilityOfElementLocated(homePage.byLogoutBtn));
        //   wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[contains(@class,'logout')]")));
            return true;
        } catch (Exception e) {
            return false;
        }
    }


    String searchKey = "Mercedes";
    @Test(dataProvider = "loginTestData")
    public void loginTestSuccess(String uname, String pw, boolean expectedLogoutDisplay) throws Exception {
        String url = "https://bantheme.xyz/hathanhauto/tai-khoan/";
        driver.get(url);
        Assert.assertEquals(driver.getCurrentUrl(), url);
        // Login

        LoginPage loginPage = new LoginPage(driver);
        loginPage.enterEmail(uname)
                .enterPassword(pw)
                .enterLogin();
        boolean logoutBtnDisplayed = isLogoutDisplayed();
        Assert.assertEquals(logoutBtnDisplayed, expectedLogoutDisplay);
        // SEARCH -> ADD CARD
        HomePage homePage = new HomePage(driver);
        homePage.inputSeach(searchKey);
        CartPage cartPage = new CartPage(driver);
        cartPage.clickOptionOne()
                .clickXuatXu()
                .clickIconPlus()
                .clickAdd();
        // .removeProduct();
        // verify get url card
        String urlCard = "https://bantheme.xyz/hathanhauto/gio-hang/";
        Assert.assertEquals(driver.getCurrentUrl(), urlCard);
        // verify số lượng sản phẩm =2
        WebElement iconCard = driver.findElement(cartPage.iconCart);
        Assert.assertTrue(iconCard.isDisplayed());
        // Cart Page - verify add to cart successfully
        WebElement successmessage = driver.findElement(cartPage.successmessage);
        Assert.assertTrue(successmessage.isDisplayed());
        // => Remove product
        cartPage.removeProduct();
        // Chưa verify được sau khi xoá sản phẩm khỏi giỏ hàng
        // WebElement messCardNull = driver.findElement(By.xpath("//p[text()='Chưa có
        // sản phẩm nào trong giỏ hàng.']"));
        // Assert.assertTrue(messCardNull.isDisplayed());

    }
}
