package com;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.mongodb.util.Util;
import com.pages.CartPage;
import com.pages.LoginPage;
import com.utils.BasicTest;
import com.utils.Utils;

public class CartTest extends BasicTest {


    @Test(enabled = true)
    public void cartTestSuccess() throws Exception {
        // Launch website
        String url = "https://bantheme.xyz/hathanhauto/tai-khoan/";
        driver.get(url);
        Assert.assertEquals(driver.getCurrentUrl(), url);


        LoginPage loginPage = new LoginPage(driver);
        CartPage cartPage = new CartPage(driver);
        loginPage.inputEmail("testtest@gmail.com");
        loginPage.inputPass("Testtest@1");
        loginPage.clickLogin();
        Assert.assertEquals(driver.getCurrentUrl(), "https://bantheme.xyz/hathanhauto/tai-khoan/");
        cartPage.searchInput("a");
        cartPage.searchFind();
        Assert.assertEquals(cartPage.tittleProduct(), "Lốc lạnh (máy nén) xe Mercedes E CLass, GLK Class, SLK Class");
        cartPage.clickAdd();
        Assert.assertEquals(cartPage.tittleCart(), "Giỏ hàng");
        cartPage.clickPay();
        Assert.assertEquals(cartPage.tittlePay(), "Thanh toán");
        
        // driver.findElement(By.xpath("//input[@id='username']")).sendKeys("testtest@gmail.com");
        // Utils.hardWait();

        // driver.findElement(By.xpath("//input[@id='password']")).sendKeys("Testtest@1");
        // Utils.hardWait();

        // driver.findElement(By.name("login")).click();
        // Utils.hardWait();

        // Assert.assertTrue(driver.findElement(By.name("login")).isDisplayed());
 
        
    }

    @Test(enabled = false)
    public void loginTestFailed() throws Exception {
        // Launch website
        String url = "https://bantheme.xyz/hathanhauto/tai-khoan/";
        driver.get(url);
        Assert.assertEquals(driver.getCurrentUrl(), url);

        LoginPage loginPage = new LoginPage(driver);
        // loginPage.inputEmail("testtesta@gmail.com");
        // loginPage.inputPass("Testtest@12");
        // loginPage.clickLogin();
        loginPage.login("testtesta@gmail.com", "Testtest@12");
        
        
        // driver.findElement(By.xpath("//input[@id='username']")).sendKeys("testtesta@gmail.com");
        // Utils.hardWait();

        // driver.findElement(By.xpath("//input[@id='password']")).sendKeys("Testtest@12");
        // Utils.hardWait();

        // driver.findElement(By.name("login")).click();
        // Utils.hardWait();


        // String errorMessage = driver.findElement(By.xpath("//ul[@class='woocommerce-error']/li")).getText();

        Assert.assertEquals(loginPage.getErrorMessage(), "Địa chỉ email không xác định. Kiểm tra lại hoặc thử tên người dùng của bạn.");
    
    }


}
