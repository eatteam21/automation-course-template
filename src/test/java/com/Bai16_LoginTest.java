package com;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.utils.Utils;
import com.utils.BasicTest;

public class Bai16_LoginTest extends BasicTest {

    @Test()
    public void loginTestSuccess() throws Exception {
        // Launch website
        String url = "https://bantheme.xyz/hathanhauto/tai-khoan/";
        driver.get(url);
        Assert.assertEquals(driver.getCurrentUrl(), url);
        // Enter email
        WebElement email =  driver.findElement (By.xpath("//input[@id='username']"));
        email.sendKeys("nhanvip124@gmail.com");
        // Enter password
        WebElement password =  driver.findElement (By.xpath("//input[@id='password']"));
        password.sendKeys("P@ssword1235678");
        // Click submit button
        WebElement submit = driver.findElement(By.xpath("//button[@name='login']"));
        submit.click();
        // Verify successful login
        WebElement accountName = driver.findElement(By.xpath("(//strong[contains(text(), 'nhanvip124')][1])"));
        Assert.assertEquals(accountName.getText(), "nhanvip124");
        Utils.hardWait();
    }
    @Test()
    public void loginTestFailed() throws Exception {
        // Launch website
        String url = "https://bantheme.xyz/hathanhauto/tai-khoan/";
        driver.get(url);
        Assert.assertEquals(driver.getCurrentUrl(), url);
        // Enter email
        WebElement email =  driver.findElement (By.xpath("//input[@id='username']"));
        email.sendKeys("nhanvip124@gmail.com");
        // Click submit button
        WebElement submit = driver.findElement(By.xpath("//button[@name='login']"));
        submit.click();
       // Verify unsuccessful login
       WebElement errorMessage = driver.findElement(By.xpath("//ul[@class='woocommerce-error']"));
       String actualErrorMessage = errorMessage.getText(); // Extract text content
       String expectedErrorMessage = "Lỗi: Mục nhập mật khẩu trống.";
       // Compare the actual and expected error messages
       Assert.assertEquals(actualErrorMessage, expectedErrorMessage);
       Utils.hardWait();
   }
 }


