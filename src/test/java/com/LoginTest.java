package com;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.pages.LoginPage;
import com.utils.BasicTest;
import com.utils.Utils;

public class LoginTest extends BasicTest {


    @Test()
    public void loginTestFailed() throws Exception {
        // Launch website
        String url = "https://bantheme.xyz/hathanhauto/tai-khoan/";
        driver.get(url);
        Assert.assertEquals(driver.getCurrentUrl(), url);
        Utils.hardWait(5000); // wait 5s


        LoginPage loginPage = new LoginPage(driver);


        // Enter username
        // driver.findElement(By.xpath("//input[@id='username']")).sendKeys("testtest@gmail.com");
        loginPage.inputEmail("testtest@gmail.com");

        // Enter password
        // driver.findElement(By.xpath("//input[@id='password']")).sendKeys("testtest");
        loginPage.inputPassword("testtest");

        // Click login
        // driver.findElement(By.xpath("//button[@name=\"login\"]")).click();
        loginPage.clickLoginBtn();
        Utils.hardWait();


        // Verify login failed
        // String errorMessage = driver.findElement(By.xpath("//ul[@class='woocommerce-error']")).getText();
        String errorMessage = loginPage.getErrorMessage();


        Assert.assertEquals(errorMessage, "Lỗi: Mật khẩu bạn nhập cho địa chỉ email testtest@gmail.com không đúng. Bạn quên mật khẩu?");
        Utils.hardWait();

    }


    // @Test()
    // public void loginTestFailedEmptyUser() throws Exception {
    //     // Launch website
    //     String url = "https://bantheme.xyz/hathanhauto/tai-khoan/";
    //     driver.get(url);
    //     Assert.assertEquals(driver.getCurrentUrl(), url);
    //     Utils.hardWait(5000); // wait 5s


    //     // Enter username
    //     driver.findElement(By.xpath("//input[@id='username']")).sendKeys("");

    //     // Enter password
    //     driver.findElement(By.xpath("//input[@id='password']")).sendKeys("testtest");

    //     // Click login
    //     driver.findElement(By.xpath("//button[@name=\"login\"]")).click();
        
    //     Utils.hardWait();


    //     // Verify login failed
    //     String errorMessage = driver.findElement(By.xpath("//ul[@class='woocommerce-error']")).getText();


    //     Assert.assertEquals(errorMessage, "Lỗi: Yêu cầu tên tài khoản.");
    //     Utils.hardWait();



    //     // Boolean display = driver.findElement(By.xpath("//button[@name=\"login\"]")).isDisplayed();

    //     // Assert.assertTrue(display);

    //     // BookingTest

    // }


    //loginTestSuccess

}
