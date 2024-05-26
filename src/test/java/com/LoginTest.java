package com;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.utils.BasicTest;
import com.utils.Utils;

public class LoginTest extends BasicTest {


    @Test(enabled = true)
    public void loginTestSucessfully() throws Exception {
        // Launch website
        String url = "https://bantheme.xyz/hathanhauto/tai-khoan/";
        driver.get(url);
        Assert.assertEquals(driver.getCurrentUrl(), url);


        WebElement emailInput = driver.findElement(By.xpath("//input[@id='username']"));
        emailInput.sendKeys("panixap532@lucvu.com");
        
        WebElement passwordInput = driver.findElement(By.xpath("//input[@id='password']"));
        passwordInput.sendKeys(":KqCCNjmmy6wZ;>");
        
        WebElement loginButton = driver.findElement(By.xpath("//button[contains(text(),'Đăng nhập')]"));
        loginButton.click();

        Utils.hardWait(5000);

        Assert.assertEquals(driver.getCurrentUrl(),"https://bantheme.xyz/hathanhauto/tai-khoan/");

    }


    @Test()
    public void loginTestFailed() throws Exception {
        // Launch website
        String url = "https://bantheme.xyz/hathanhauto/tai-khoan/";
        driver.get(url);
        Assert.assertEquals(driver.getCurrentUrl(), url);


        WebElement emailInput = driver.findElement(By.xpath("//input[@id='username']"));
        emailInput.sendKeys("tetakok687@lucvu.com");
        
        WebElement passwordInput = driver.findElement(By.xpath("//input[@id='password']"));
        passwordInput.sendKeys(":KqCCNjmmy6wZ;>");
        
        WebElement loginButton = driver.findElement(By.xpath("//button[contains(text(),'Đăng nhập')]"));
        loginButton.click();

        Utils.hardWait(5000);
        WebElement errorMessage = driver.findElement(By.xpath("//ul[@class='woocommerce-error']"));

  
        Assert.assertTrue(errorMessage.isDisplayed());
        // Verify error message 

    }

}
