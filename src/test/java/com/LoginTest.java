package com;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.mongodb.util.Util;
import com.utils.BasicTest;
import com.utils.Utils;

public class LoginTest extends BasicTest {


    @Test()
    public void loginTestSuccess() throws Exception {
        // Launch website
        String url = "https://bantheme.xyz/hathanhauto/tai-khoan/";
        driver.get(url);
        Assert.assertEquals(driver.getCurrentUrl(), url);

        
        driver.findElement(By.xpath("//input[@id='username']")).sendKeys("testtest @gmail.com");
        Utils.hardWait();

        driver.findElement(By.xpath("//input[@id='password']")).sendKeys("Testtest@1");
        Utils.hardWait();

        driver.findElement(By.name("login")).click();
        Utils.hardWait();

        Assert.assertTrue(driver.findElement(By.name("login")).isDisplayed());
    }

    @Test()
    public void loginTestFailed() throws Exception {
        // Launch website
        String url = "https://bantheme.xyz/hathanhauto/tai-khoan/";
        driver.get(url);
        Assert.assertEquals(driver.getCurrentUrl(), url);

        
        driver.findElement(By.xpath("//input[@id='username']")).sendKeys("testtesta@gmail.com");
        Utils.hardWait();

        driver.findElement(By.xpath("//input[@id='password']")).sendKeys("Testtest@12");
        Utils.hardWait();

        driver.findElement(By.name("login")).click();
        Utils.hardWait();

        Assert.assertEquals("Địa chỉ email không xác định. Kiểm tra lại hoặc thử tên người dùng của bạn.", "Địa chỉ email không xác định. Kiểm tra lại hoặc thử tên người dùng của bạn.");
    }

}
