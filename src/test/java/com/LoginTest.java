package com;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.utils.BasicTest;

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

        // Enter username
        // find element
        driver.findElement(By.xpath("//input[@id='username']")).sendKeys(username);
        // Enter password

        driver.findElement(By.xpath("//input[@id='password']")).sendKeys(password);
        // Click login
        driver.findElement(By.xpath("//button[contains(text(),'Đăng nhập')]")).click();


        // Assertion
        Boolean display = driver.findElement(By.xpath("//p[contains(text(),'Từ trang quản lý tài khoản bạn có thể xem')]")).isDisplayed();

        Assert.assertTrue(display);
    }
    @Test()
    public void loginTestFailedWithInvalidEmail() throws Exception {
        // Launch website
        String url = "https://bantheme.xyz/hathanhauto/tai-khoan/";
        driver.get(url);
        Assert.assertEquals(driver.getCurrentUrl(), url);

        // Enter username
        // find element
        driver.findElement(By.xpath("//input[@id='username']")).sendKeys(invalidUsername);
        // Enter password

        driver.findElement(By.xpath("//input[@id='password']")).sendKeys(password);
        // Click login
        driver.findElement(By.xpath("//button[contains(text(),'Đăng nhập')]")).click();

        Boolean errorIsDisplay = driver.findElement(By.xpath("//li[contains(text(),'Địa chỉ email không xác định. Kiểm tra lại hoặc thử tên người dùng của bạn.')]")).isDisplayed();

        Assert.assertTrue(errorIsDisplay);
    }

    @Test()
    public void loginTestFailedWithInvalidPassword() throws Exception {
        // Launch website
        String url = "https://bantheme.xyz/hathanhauto/tai-khoan/";
        driver.get(url);
        Assert.assertEquals(driver.getCurrentUrl(), url);

        // Enter username
        // find element
        driver.findElement(By.xpath("//input[@id='username']")).sendKeys(username);
        // Enter password

        driver.findElement(By.xpath("//input[@id='password']")).sendKeys(invalidPassword);
        // Click login
        driver.findElement(By.xpath("//button[contains(text(),'Đăng nhập')]")).click();

        String errorText=driver.findElement(By.className("woocommerce-error")).getText();

        String expectedError="Lỗi: Mật khẩu bạn nhập cho địa chỉ email "+username+" không đúng. Bạn quên mật khẩu?";

        Assert.assertEquals(errorText,expectedError);

    }

}
