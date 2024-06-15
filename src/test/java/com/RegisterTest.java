package com;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.mongodb.util.Util;
import com.utils.BasicTest;
import com.utils.Utils;

public class RegisterTest extends BasicTest {


    @Test(enabled = false)
    public void registerFailed1() throws Exception {
        // Launch website
        String url = "https://bantheme.xyz/hathanhauto/tai-khoan/";
        driver.get(url);
        Assert.assertEquals(driver.getCurrentUrl(), url);


        driver.findElement(By.xpath("//button[@name='register']")).click();
        Utils.hardWait();

        // Assert.assertTrue(driver.findElement(By.name("login")).isDisplayed());
        String failedMessage = driver.findElement(By.xpath("//ul[@class ='woocommerce-error']/li")).getText();

        
        Assert.assertEquals(failedMessage, "Lỗi: Vui lòng cung cấp địa chỉ email hợp lệ.");
    }

    @Test(enabled = true)
    public void registerFailed2() throws Exception {
        // Launch website
        String url = "https://bantheme.xyz/hathanhauto/tai-khoan/";
        driver.get(url);
        Assert.assertEquals(driver.getCurrentUrl(), url);


        driver.findElement(By.xpath("//input[@id='reg_email']")).sendKeys("minhphat3575@gmail.com");
        Utils.hardWait();

        driver.findElement(By.xpath("//button[@name='register']")).click();
        Utils.hardWait();

        // Assert.assertTrue(driver.findElement(By.name("login")).isDisplayed());
        String failedMessage = driver.findElement(By.xpath("//ul[@class ='woocommerce-error']/li")).getText();

        
        Assert.assertEquals(failedMessage, "Lỗi: An account is already registered with your email address. Please log in.");
    }


}
