package com;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.utils.Utils;
import com.utils.BasicTest;
public class Bai16_RegisterTest extends BasicTest {
    @Test()
    public void registerTest() throws Exception {
        // Launch website
        String url = "https://bantheme.xyz/hathanhauto/tai-khoan/";
        driver.get(url);
        Assert.assertEquals(driver.getCurrentUrl(), url);

        // Enter email
        WebElement email = driver.findElement(By.xpath("//input[@id=\"reg_email\"]"));
        email.sendKeys("testtest@gmail.com");

        // Click submit button
        WebElement submit = driver.findElement(By.xpath("//button[@name=\"register\"]"));
        submit.click();
        Utils.hardWait();

        // Verify unsuccessful register
        WebElement errorMessage = driver.findElement(By.xpath("//ul[@class='woocommerce-error']"));
        String actualErrorMessage = errorMessage.getText(); // Extract text content
        String expectedErrorMessage = "Lỗi: An account is already registered with your email address. Please log in.";

        // Compare the actual and expected error messages
        Assert.assertEquals(actualErrorMessage, expectedErrorMessage);
    }
    
}
