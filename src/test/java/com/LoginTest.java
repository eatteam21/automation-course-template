package com;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.utils.BasicTest;
import pages.HomePage;
import pages.LoginPage;

public class LoginTest extends BasicTest {
    String username="linh@gmail.com";
    String password="Linhbap2911";
    String invalidUsername="linh2@gmail.com";
    String invalidPassword="Linhbap2912";
    @Test()
    public void loginTest() throws Exception {
        // Launch website
        String url = "https://bantheme.xyz/hathanhauto/tai-khoan/";
        driver.get(url);
        Assert.assertEquals(driver.getCurrentUrl(), url);

        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = new HomePage(driver);
        loginPage.enterEmail(username);
        loginPage.enterPassword(password);
        loginPage.clickLogin();
        Boolean display = homePage.isTrangQLDisplayed();
        Assert.assertTrue(display);
    }
    @Test()
    public void loginTestFailedWithInvalidEmail() throws Exception {
        // Launch website
        String url = "https://bantheme.xyz/hathanhauto/tai-khoan/";
        driver.get(url);
        Assert.assertEquals(driver.getCurrentUrl(), url);

        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = new HomePage(driver);

        loginPage.enterEmail(invalidUsername);
        loginPage.enterPassword(password);
        // Click login
        loginPage.clickLogin();
        String expectedError="Địa chỉ email không xác định. Kiểm tra lại hoặc thử tên người dùng của bạn.";
        String actualError=loginPage.getErrorMessage();
        Assert.assertEquals(actualError,expectedError);
    }

    @Test()
    public void loginTestFailedWithInvalidPassword() throws Exception {
        // Launch website
        String url = "https://bantheme.xyz/hathanhauto/tai-khoan/";
        driver.get(url);
        Assert.assertEquals(driver.getCurrentUrl(), url);

        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = new HomePage(driver);

        loginPage.enterEmail(username);
        loginPage.enterPassword(invalidPassword);
        loginPage.clickLogin();

        String actualError=loginPage.getErrorMessage();

        String expectedError="Lỗi: Mật khẩu bạn nhập cho địa chỉ email "+username+" không đúng. Bạn quên mật khẩu?";

        Assert.assertEquals(actualError,expectedError);

    }

}
