package com;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.mongodb.util.Util;
import com.pages.LoginPage;
import com.utils.BasicTest;
import com.utils.Utils;

public class LoginTest extends BasicTest {


    @Test(enabled = false)
    public void loginTestSuccess() throws Exception {
        // Launch website
        String url = "https://bantheme.xyz/hathanhauto/tai-khoan/";
        driver.get(url);
        Assert.assertEquals(driver.getCurrentUrl(), url);


        LoginPage loginPage = new LoginPage(driver);
        loginPage.inputEmail("testtest@gmail.com");
        loginPage.inputPass("Testtest@1");
        loginPage.clickLogin();

        
        // driver.findElement(By.xpath("//input[@id='username']")).sendKeys("testtest@gmail.com");
        // Utils.hardWait();

        // driver.findElement(By.xpath("//input[@id='password']")).sendKeys("Testtest@1");
        // Utils.hardWait();

        // driver.findElement(By.name("login")).click();
        // Utils.hardWait();

        // Assert.assertTrue(driver.findElement(By.name("login")).isDisplayed());





        
        Assert.assertEquals(driver.getCurrentUrl(), "https://bantheme.xyz/hathanhauto/tai-khoan/");
    }

    @Test(enabled = true)
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
