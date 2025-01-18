package com.featureB;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.utils.BasicTest;
import com.utils.Utils;

public class featureBTest extends BasicTest {


    @Test(enabled = true, priority = 1, dataProvider = "abcxyz")
    public void loginTest(String uname, String passw, boolean expectedLogin) throws Exception {
        // Launch website
        String url = "https://bantheme.xyz/hathanhauto/tai-khoan/";
        driver.get(url);
        Assert.assertEquals(driver.getCurrentUrl(), url);

        // Utils.hardWait(1000); // 3s

        // Enter email
        // WebElement emailInput = driver.findElement(By.xpath("//input[@id='username']"));
        // emailInput.sendKeys(uname);

        // Utils.hardWait(1000); // 3s
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='username']"))).sendKeys(uname);


        // Enter pasword
        // WebElement passInput = driver.findElement(By.xpath("//input[@id='password']"));
        // passInput.sendKeys(passw);

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='password']"))).sendKeys(passw);

        // Click Login
        // WebElement loginButton = driver.findElement(By.xpath("//button[@name=\"login\"]"));
        // loginButton.click();
        
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@name=\"login\"]"))).click();


        // Utils.hardWait(1000); // 3s

        // Verify login success
        // WebElement errorMessage = driver.findElement(By.xpath("//ul[@class='woocommerce-error']"));
        Boolean isDisplayed = isErrorMessageDisplayed("//ul[@class='woocommerce-error']");
        // Assert.assertEquals(errorMessage.isDisplayed(), false);
        if (expectedLogin){
            Assert.assertTrue(isDisplayed);
        } else {
            Assert.assertFalse(isDisplayed);
        }
        // Assert.assertFalse(isDisplayed);
        // Assert.assertEquals(errorMessage, "An account is already registered with your email address");
        // Assert.assertEquals(isDisplayed, expectedLogin);
        // Assert.assertEquals(isDisplayed, "123");

        Utils.hardWait(); // 3s

    }


    // @Test(priority = 2)
    // public void loginTestFailed() throws Exception {
    //     // Launch website
    //     String url = "https://bantheme.xyz/hathanhauto/tai-khoan/";
    //     driver.get(url);
    //     Assert.assertEquals(driver.getCurrentUrl(), url);

    //     Utils.hardWait(1000); // 3s

    //     // Enter email
    //     WebElement emailInput = driver.findElement(By.xpath("//input[@id='username123']"));
    //     emailInput.sendKeys("testtest@gmail.com");

    //     Utils.hardWait(1000); // 3s

    //     // Enter pasword
    //     WebElement passInput = driver.findElement(By.xpath("//input[@id='password']"));
    //     passInput.sendKeys("testtest");

    //     // Click Login
    //     WebElement loginButton = driver.findElement(By.xpath("//button[@name=\"login\"]"));
    //     loginButton.click();

    //     Utils.hardWait(1000); // 3s

    //     // Verify login success
    //     // WebElement errorMessage = driver.findElement(By.xpath("//ul[@class='woocommerce-error']"));
    //     Boolean isDisplayed = isErrorMessageDisplayed("//ul[@class='woocommerce-error']");
    //     // Assert.assertEquals(errorMessage.isDisplayed(), false);
    //     Assert.assertTrue(isDisplayed);

    //     // Utils.hardWait(); // 3s


    // }

    public boolean isErrorMessageDisplayed(String locator) {

        try {
            // WebElement element = driver.findElement(By.xpath(locator)); // Exception
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locator)));

            // return element.isDisplayed();
            return true;
        } catch (Exception ex){
            return false;
        }
        
    }

    @DataProvider(name = "abcxyz")
    public Object[][] testdata(){
        Object[][] loginTestData = new Object[2][3];
        
        loginTestData[0][0] = "nhanvip124@gmail.com";
        loginTestData[0][1] = "1234";
        loginTestData[0][2] = true;

        loginTestData[1][0] = "testtest@gmail.com";
        loginTestData[1][1] = "testtes";
        loginTestData[1][2] = false;

        return loginTestData;
    }

}
