package com;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.utils.BasicTest;

public class RegisterTest extends BasicTest {
    // Đăng kí fails - để trống mật khẩu
    @Test(priority = 1)
    public void registerTestFaisePasswordEmty() throws Exception {
        String url = "https://bantheme.xyz/hathanhauto/tai-khoan/";
        driver.get(url);
        Assert.assertEquals(driver.getCurrentUrl(), url);
        WebElement emailInputReg = driver.findElement(By.xpath("//input[@id='reg_email']"));
        emailInputReg.sendKeys("trongtuyen451@gmail.com");
        WebElement passInputReg = driver.findElement(By.xpath("//input[@id='reg_password']"));
        passInputReg.sendKeys("");
        WebElement RegBtn = driver.findElement(By.xpath("//button[contains(@class,'register')]"));
        RegBtn.click();
        WebElement errorrMessageText = driver.findElement(By.xpath("//strong[contains(text(), 'Lỗi:')]"));
        Assert.assertTrue(errorrMessageText.isDisplayed());
    }

    // Dăng kí failse - để trống email
    @Test(priority = 2)
    public void registerTestFailseEmailEmty() throws Exception {
        String url = "https://bantheme.xyz/hathanhauto/tai-khoan/";
        driver.get(url);
        Assert.assertEquals(driver.getCurrentUrl(), url);
        WebElement emailInputReg = driver.findElement(By.xpath("//input[@id='reg_email']"));
        emailInputReg.sendKeys("");
        WebElement passInputReg = driver.findElement(By.xpath("//input[@id='reg_password']"));
        passInputReg.sendKeys("Admin@123456");
        WebElement RegBtn = driver.findElement(By.xpath("//button[contains(@class,'register')]"));
        RegBtn.click(); 
        //=> thêm asert
    }

    // Đăng kí thành công
    @Test(priority = 3)
    public void registerTestSuccess() throws Exception {
        String url = "https://bantheme.xyz/hathanhauto/tai-khoan/";
        driver.get(url);
        Assert.assertEquals(driver.getCurrentUrl(), url);
        WebElement emailInputReg = driver.findElement(By.xpath("//input[@id='reg_email']"));
        emailInputReg.sendKeys("trongtuyen453@gmail.com");
        WebElement passInputReg = driver.findElement(By.xpath("//input[@id='reg_password']"));
        passInputReg.sendKeys("Admin@123456");
        WebElement RegBtn = driver.findElement(By.xpath("//button[contains(@class,'register')]"));
        RegBtn.click();
        //=> thêm asert
    }
}
