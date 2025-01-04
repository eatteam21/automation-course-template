package com;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.utils.BasicTest;
import com.utils.Utils;

public class RegisterTest extends BasicTest {


    @Test(enabled = true)
    public void loginTestSuccess() throws Exception {
        // Launch website
        String url = "https://bantheme.xyz/hathanhauto/tai-khoan/";
        driver.get(url);
        Assert.assertEquals(driver.getCurrentUrl(), url);

        Utils.hardWait(1000); // 3s

        // Enter email
        WebElement emailInput = driver.findElement(By.xpath("//input[@id='username']"));
        emailInput.sendKeys("nhanvip124@gmail.com");

        Utils.hardWait(1000); // 3s

        // Enter pasword
        WebElement passInput = driver.findElement(By.xpath("//input[@id='password']"));
        passInput.sendKeys("P@ssword1235678");

        // Click Login
        WebElement loginButton = driver.findElement(By.xpath("//button[@name=\"login\"]"));
        loginButton.click();

        Utils.hardWait(1000); // 3s

        // Verify login success
        // WebElement errorMessage = driver.findElement(By.xpath("//ul[@class='woocommerce-error']"));
        Boolean isDisplayed = isErrorMessageDisplayed("//ul[@class='woocommerce-error']");
        // Assert.assertEquals(errorMessage.isDisplayed(), false);
        Assert.assertFalse(isDisplayed);
        // Assert.assertEquals(errorMessage, "An account is already registered with your email address");

        Utils.hardWait(); // 3s

    }


    @Test()
    public void loginTestFailed() throws Exception {
        // Launch website
        String url = "https://bantheme.xyz/hathanhauto/tai-khoan/";
        driver.get(url);
        Assert.assertEquals(driver.getCurrentUrl(), url);

        Utils.hardWait(1000); // 3s

        // Enter email
        WebElement emailInput = driver.findElement(By.xpath("//input[@id='username']"));
        emailInput.sendKeys("testtest@gmail.com");

        Utils.hardWait(1000); // 3s

        // Enter pasword
        WebElement passInput = driver.findElement(By.xpath("//input[@id='password']"));
        passInput.sendKeys("testtest");

        // Click Login
        WebElement loginButton = driver.findElement(By.xpath("//button[@name=\"login\"]"));
        loginButton.click();

        Utils.hardWait(1000); // 3s

        // Verify login success
        // WebElement errorMessage = driver.findElement(By.xpath("//ul[@class='woocommerce-error']"));
        Boolean isDisplayed = isErrorMessageDisplayed("//ul[@class='woocommerce-error']");
        // Assert.assertEquals(errorMessage.isDisplayed(), false);
        Assert.assertTrue(isDisplayed);

        // Utils.hardWait(); // 3s


    }

    public boolean isErrorMessageDisplayed(String locator) {

        try {
            WebElement element = driver.findElement(By.xpath(locator)); // Exception

            return element.isDisplayed();
        } catch (Exception ex){
            return false;
        }
        
    }

}
