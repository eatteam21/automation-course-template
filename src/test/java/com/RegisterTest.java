package com;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.utils.BasicTest;
import com.utils.Utils;

public class RegisterTest extends BasicTest {


    //register emmpty username

    // register empty password

    //@Test()
    public void TC01_registerTestEmpltyUsername() throws Exception {
        // Launch website
        String url = "https://bantheme.xyz/hathanhauto/tai-khoan/";
        driver.get(url);
        Assert.assertEquals(driver.getCurrentUrl(), url);
        Utils.hardWait(5000); // wait 5s


        // Enter username
        driver.findElement(By.xpath("//input[@id='reg_email']")).sendKeys("");

        // Enter password
        driver.findElement(By.xpath("//input[@id='reg_password']")).sendKeys("Testtest123456@");

        // Click login
        driver.findElement(By.xpath("//button[@name='register']")).click();
        Utils.hardWait();


        // Verify login failed
        String errorMessage = driver.findElement(By.xpath("//ul[@class='woocommerce-error']")).getText();


        Assert.assertEquals(errorMessage, "Lỗi: Vui lòng cung cấp địa chỉ email hợp lệ.");
        Utils.hardWait();

    }

    //@Test()
    public void TC02_registerTestEmpltyPassword() throws Exception {
        // Launch website
        String url = "https://bantheme.xyz/hathanhauto/tai-khoan/";
        driver.get(url);
        Assert.assertEquals(driver.getCurrentUrl(), url);
        Utils.hardWait(5000); // wait 5s


        // Enter username
        driver.findElement(By.xpath("//input[@id='reg_email']")).sendKeys("testtest1@gmail.com");

        // Enter password
        driver.findElement(By.xpath("//input[@id='reg_password']")).sendKeys("");

        // Click login
        driver.findElement(By.xpath("//button[@name='register']")).click();
        Utils.hardWait();


        // Verify login failed
        String errorMessage = driver.findElement(By.xpath("//ul[@class='woocommerce-error']")).getText();


        Assert.assertEquals(errorMessage, "Lỗi: Vui lòng nhập mật khẩu tài khoản.");
        Utils.hardWait();
    }

    @Test()
    public void TC03_registerTestSuccessful() throws Exception {
        // Launch website
        String url = "https://bantheme.xyz/hathanhauto/tai-khoan/";
        driver.get(url);
        Assert.assertEquals(driver.getCurrentUrl(), url);
        Utils.hardWait(5000); // wait 5s


        // Enter username
        driver.findElement(By.xpath("//input[@id='username']")).sendKeys("ngttvi2022@gmail.com");

        // Enter password
        driver.findElement(By.xpath("//input[@id='password']")).sendKeys("Hoctestauto1805");

        // Click login
        driver.findElement(By.xpath("//button[@name=\"login\"]")).click();
        Utils.hardWait();


        // Verify login successfully
        String Message = driver.findElement(By.xpath("//div[@class='woocommerce-notices-wrapper']")).getText();


        Assert.assertEquals(Message, "Xin chào");
        Utils.hardWait();
    }

}
