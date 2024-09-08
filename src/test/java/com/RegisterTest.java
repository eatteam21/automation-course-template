package com;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.pages.RegisterPage;
import com.utils.BasicTest;
import com.utils.Utils;

public class RegisterTest extends BasicTest {

    @Test()
    public void TC01_registerTestEmpltyUsername() throws Exception {
        // Launch website
        String url = "https://bantheme.xyz/hathanhauto/tai-khoan/";
        driver.get(url);
        Assert.assertEquals(driver.getCurrentUrl(), url);
        Utils.hardWait(5000); // wait 5s

        RegisterPage registerPage = new RegisterPage(driver);
         


        // Enter username
        // driver.findElement(By.xpath("//input[@id='reg_email']")).sendKeys("");

        registerPage.inputEmail("");

        // Enter password
        // driver.findElement(By.xpath("//input[@id='reg_password']")).sendKeys("Testtest123456@");

        registerPage.inputPassword("Testtest123456@");

        // Click login
        // driver.findElement(By.xpath("//button[@name='register']")).click();
        // Utils.hardWait();

        registerPage.clickRegisterBtn();

        // Verify login failed
        //String errorMessage = driver.findElement(By.xpath("//ul[@class='woocommerce-error']")).getText();
        String errorMessage = registerPage.getErrorMessage();


        Assert.assertEquals(errorMessage, "Lỗi: Vui lòng cung cấp địa chỉ email hợp lệ.");
        Utils.hardWait();

    }

    @Test()
    public void TC02_registerTestEmpltyPassword() throws Exception {
        // Launch website
        String url = "https://bantheme.xyz/hathanhauto/tai-khoan/";
        driver.get(url);
        Assert.assertEquals(driver.getCurrentUrl(), url);
        Utils.hardWait(5000); // wait 5s

        RegisterPage registerPage = new RegisterPage(driver);
        // Enter username
        // driver.findElement(By.xpath("//input[@id='reg_email']")).sendKeys("testtest1@gmail.com");
        registerPage.inputEmail("testtest1@gmail.com");

        // Enter password
        // driver.findElement(By.xpath("//input[@id='reg_password']")).sendKeys("");
        registerPage.inputPassword("");

        // Click login
        // driver.findElement(By.xpath("//button[@name='register']")).click();
        // Utils.hardWait();
        registerPage.clickRegisterBtn();


        // Verify login failed
        // String errorMessage = driver.findElement(By.xpath("//ul[@class='woocommerce-error']")).getText();
        String errorMessage = registerPage.getErrorMessage();

        Assert.assertEquals(errorMessage, "Lỗi: Vui lòng nhập mật khẩu tài khoản.");
        Utils.hardWait();
    }

    // @Test()
    // public void TC03_registerTestSuccessful() throws Exception {
    //     // Launch website
    //     String url = "https://bantheme.xyz/hathanhauto/tai-khoan/";
    //     driver.get(url);
    //     Assert.assertEquals(driver.getCurrentUrl(), url);
    //     Utils.hardWait(5000); // wait 5s

    //     RegisterPage registerPage = new RegisterPage(driver);

    //     // Enter username
    //     // driver.findElement(By.xpath("//input[@id='username']")).sendKeys("ngttvi2022@gmail.com");
    //     registerPage.inputEmail("vinguyen101010@gmail.com");

    //     // Enter password
    //     // driver.findElement(By.xpath("//input[@id='password']")).sendKeys("Hoctestauto1805");
    //     registerPage.inputPassword("Hoctestauto1805");

    //     // Click login
    //     //driver.findElement(By.xpath("//button[@name=\"login\"]")).click();
    //     //Utils.hardWait();
    //     registerPage.clickRegisterBtn();

    //     // Verify login successfully
    //     //String Message = driver.findElement(By.xpath("//div[@class='woocommerce-notices-wrapper']")).getText();
    //     String Message = registerPage.getMessage(); // message = ""

    //     Assert.assertTrue(Message.contains("Xin chào"));
    //     //Utils.hardWait();
    //     // Assert.assertTrue(Message.contains("Xin chào"));
    //     // Assert.assertTrue(Message);
    //     //Assert.assertEquals(Message, "Xin chào");
    //     Utils.hardWait(50000);
    // }

}
