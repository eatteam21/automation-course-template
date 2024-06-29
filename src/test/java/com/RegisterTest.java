package com;

import com.utils.BasicTest;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;

public class RegisterTest extends BasicTest {
    String username="linh3@gmail.com";
    String password="Linhbap2912";
    String invalidUsername="linh@com";
    String invalidPassword="Linh";
    @Test()
    public void registerFailedTestInvalidEmail() throws Exception {
        // Launch website
        String url = "https://bantheme.xyz/hathanhauto/tai-khoan/";
        driver.get(url);
        Assert.assertEquals(driver.getCurrentUrl(), url);

        // Enter username
        // find element
        driver.findElement(By.xpath("//input[@id='reg_email']")).sendKeys(invalidUsername);
        // Enter password

        driver.findElement(By.xpath("//input[@id='reg_password']")).sendKeys(password);
        // Click login
        driver.findElement(By.xpath("//button[contains(text(),'Đăng ký')]")).click();

        // Assertion
        String errorText=driver.findElement(By.className("woocommerce-error")).getText();
        String expectedError="Lỗi: Vui lòng cung cấp địa chỉ email hợp lệ.";
        Assert.assertEquals(errorText,expectedError);
    }
    @Test()
    public void registerFailedTestInvalidPassword() throws Exception {
        // Launch website
        String url = "https://bantheme.xyz/hathanhauto/tai-khoan/";
        driver.get(url);
        Assert.assertEquals(driver.getCurrentUrl(), url);

        // Enter username
        // find element
        driver.findElement(By.xpath("//input[@id='reg_email']")).sendKeys(username);
        // Enter password

        driver.findElement(By.xpath("//input[@id='reg_password']")).sendKeys(invalidPassword);
        driver.findElement(By.xpath("//html")).click();
        Thread.sleep(10000);

        Boolean errorIsDisplay = driver.findElement(By.xpath("//div[contains(text(),'Vui lòng nhập mật khẩu khó hơn')]")).isDisplayed();

        Assert.assertTrue(errorIsDisplay);
    }

    @Test()
    public void registerFailedTestBlankEmail() throws Exception {
        // Launch website
        String url = "https://bantheme.xyz/hathanhauto/tai-khoan/";
        driver.get(url);
        Assert.assertEquals(driver.getCurrentUrl(), url);

        // Enter password

        driver.findElement(By.xpath("//input[@id='reg_password']")).sendKeys(password);
        // Click login
        driver.findElement(By.xpath("//button[contains(text(),'Đăng ký')]")).click();
        Thread.sleep(5000);
        String errorText=driver.findElement(By.className("woocommerce-error")).getText();
        String expectedError="Lỗi: Vui lòng cung cấp địa chỉ email hợp lệ.";
        Assert.assertEquals(errorText,expectedError);

    }
    @Test()
    public void registerFailedTestBlankPasswordl() throws Exception {
        // Launch website
        String url = "https://bantheme.xyz/hathanhauto/tai-khoan/";
        driver.get(url);
        Assert.assertEquals(driver.getCurrentUrl(), url);

        // Enter username
        // find element
        driver.findElement(By.xpath("//input[@id='reg_email']")).sendKeys(username);
        // Click login
        driver.findElement(By.xpath("//button[contains(text(),'Đăng ký')]")).click();
        Thread.sleep(5000);
        // verify error message
        String errorText=driver.findElement(By.className("woocommerce-error")).getText();
        String expectedError="Lỗi: Vui lòng nhập mật khẩu tài khoản.";
        Assert.assertEquals(errorText,expectedError);

    }

}
