package com;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.mongodb.util.Util;
import com.pages.LoginPage;
import com.pages.LoginPageIViVu;
import com.utils.BasicTest;
import com.utils.Utils;

public class LoginTestIViVu extends BasicTest{
   

    @Test(enabled = true)
    public void loginTestFailed() throws Exception {
        // Launch website
        String url = "https://www.ivivu.com/";
        driver.get(url);
        Assert.assertEquals(driver.getCurrentUrl(), url);

        LoginPageIViVu loginPageIViVu = new LoginPageIViVu(driver);
        
        loginPageIViVu.clickButtonAccount();
        loginPageIViVu.clickButtonLogin();
        loginPageIViVu.clickLoginButton();
       
         Assert.assertEquals(loginPageIViVu.getEmailValidation(), "Please fill out this field.");
        // driver.findElement(By.xpath("//input[@name='EmailPhoneDN']")).getAttribute("validationMessage")
        
        System.out.println("Validation Message is: " + loginPageIViVu.getEmailValidation());

    }

    @Test(enabled = false)
    public void loginTestFailed2() throws Exception {
        // Launch website
        String url = "https://www.ivivu.com/";
        driver.get(url);
        Assert.assertEquals(driver.getCurrentUrl(), url);

        LoginPageIViVu loginPageIViVu = new LoginPageIViVu(driver);
        
        loginPageIViVu.clickButtonAccount();
        loginPageIViVu.clickButtonLogin();
        loginPageIViVu.inputEmail("minhphat3575@gmail.com");
        WebDriverWait wait = new WebDriverWait(driver, 10);
        loginPageIViVu.clickLoginButton();
       
         Assert.assertEquals(loginPageIViVu.getPasswordValidation(), "Please fill out this field.");
        // driver.findElement(By.xpath("//input[@name='EmailPhoneDN']")).getAttribute("validationMessage")
        
        System.out.println("Validation Message is: " + loginPageIViVu.getPasswordValidation());

    }
}
