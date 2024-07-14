package com;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.utils.BasicTest;
import pages.HomePage;
import pages.LoginPage;

public class SignInTest extends BasicTest {
    String username="linh@gmail.com";
    String password="Linhbap2911";
    String invalidUsername="linh2@gmail.com";
    String invalidPassword="Linhbap2912";
    @Test()
    public void loginTest() throws Exception {
        // Launch website
        String url = "https://www.ivivu.com/";
        driver.get(url);
        Assert.assertEquals(driver.getCurrentUrl(), url);
        driver.findElement(By.id("UserLogin")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//btn[contains(text(),'Đăng nhập')]")));
        driver.findElement(By.xpath("//btn[contains(text(),'Đăng nhập')]")).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("//input[@name='EmailPhoneDN']")).sendKeys("linh@gmail.com");
        driver.findElement(By.xpath("//button[contains(text(),'Đăng nhập')]")).click();
        WebElement inputPassword= driver.findElement(By.xpath("//input[@name='PasswordDN']"));
        String validationMessage = inputPassword.getAttribute("validationMessage");
        String expectedMessage="Please fill out this field.";
        Assert.assertEquals(validationMessage,expectedMessage);
    }

}
