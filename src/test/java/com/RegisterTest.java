package com;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.pages.RegisterPage;
import com.utils.BasicTest;
import com.utils.Utils;

public class RegisterTest extends BasicTest {
    @Test()
    public void noEmail() throws Exception{
        String url = "https://bantheme.xyz/hathanhauto/tai-khoan/";
        driver.get(url);
        Assert.assertEquals(driver.getCurrentUrl(), url);
        RegisterPage registerPage = new RegisterPage(driver);

        registerPage.enterRegEmail("abc@gmail.com");
        registerPage.regButton();
        
        WebElement errorMessage = registerPage.errorMessage();
        Assert.assertTrue(errorMessage.isDisplayed());

    }
    @Test()
    public void noPassword() throws Exception{
        String url = "https://bantheme.xyz/hathanhauto/tai-khoan/";
        driver.get(url);
        Assert.assertEquals(driver.getCurrentUrl(), url);

        // WebElement passwordInput = driver.findElement(By.xpath("//input[@id='reg_password']"));
        // passwordInput.sendKeys("123");
        // Utils.hardWait();

        // WebElement errorMessage = driver.findElement(By.xpath("//div[@class='woocommerce-password-strength short']"));

        // Assert.assertTrue(errorMessage.isDisplayed());

        RegisterPage registerPage = new RegisterPage(driver);

        registerPage.enterRegPassword("aaa");
        WebElement errorMessagePass = registerPage.errorMessagePass();
        Assert.assertTrue(errorMessagePass.isDisplayed());


    }
}
