package com;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.google.gson.annotations.Until;
import com.utils.BasicTest;
import com.utils.Utils;

public class LoginTestBasic extends BasicTest {
    @DataProvider(name = "loginTestData")
    

    public boolean isLogoutDisplayed() {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[contains(@class,'logout')]")));
            return true;
        } catch (Exception e) {
            return false;
        }

    }


    public void loginTestSuccess() throws Exception {
        String url = "https://bantheme.xyz/hathanhauto/tai-khoan/";
        driver.get(url);
        Assert.assertEquals(driver.getCurrentUrl(), url);
        WebElement emailInput=driver.findElement(By.xpath("//input[@id='username']"));
        emailInput.sendKeys("trongtuyen451@gmail.com");
        Utils.hardWait(1000);
        // boolean logoutBtnDisplayed = isLogoutDisplayed();
        // Assert.assertEquals(logoutBtnDisplayed, expectedLogoutDisplay);
        WebElement passwordInput=driver.findElement(By.xpath("//input[@id='password']"));
        passwordInput.sendKeys("Admin@123456");
        Utils.hardWait(1000);
        WebElement loginBtn = driver.findElement(By.xpath("//button[@name='login']"));
        loginBtn.click();
        Utils.hardWait(1000); // 3s
    }
}
