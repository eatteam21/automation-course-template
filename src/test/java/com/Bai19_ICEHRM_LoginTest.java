package com;

import org.testng.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
// import org.openqa.selenium.interactions.Actions;
// import org.testng.Assert;
// import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import com.utils.Utils;
import com.utils.BasicTest;
import org.testng.annotations.DataProvider;
// import org.testng.annotations.Test;

public class Bai19_ICEHRM_LoginTest extends BasicTest {
    @DataProvider(name = "testData")
    public Object[][] testDataFeed()  {
        // Create object array
        Object[][] account = new Object[2][2];
        // Enter 3 login account data
            account[0][0] = "admin";
            account[0][1] = "admin";
            account[1][0] = "admin";
            account[1][1] = "admin123";
        // return arrayobject
        return account;
    }
    @Test(dataProvider = "testData")
    public void loginTest(String username, String password) throws Exception {
        // Launch website
        String url = "https://icehrm-open.gamonoid.com/login.php";
        driver.get(url);
        Assert.assertEquals(driver.getCurrentUrl(), url);
        // Enter username
        driver.findElement(By.xpath("//input[@id='username']")).sendKeys(username);
        // Enter password
        driver.findElement(By.xpath("//input[@id='password']")).sendKeys(password);
        // Click login button
        driver.findElement(By.xpath("//button[contains(text(),'Log in')]")).click();
        Utils.hardWait();
        // Verify successful login;
        WebElement home = driver.findElement(By.xpath("//a[contains(text(), 'Home')]"));
        Assert.assertTrue(home.isDisplayed());
        // Verify the first test data login successfully
        if (username.equals("admin") && password.equals("admin")) {
        Assert.assertTrue(home.isDisplayed(), "Login failed");
    }
}
}

