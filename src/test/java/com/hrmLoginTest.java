package com;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.pages.LoginPage;
import com.utils.BasicTest;
import com.utils.Utils;

public class hrmLoginTest extends BasicTest {


    @Test(dataProvider = "testdata123")
    public void loginTest(String username, String password, String errormessage) throws Exception {
        // Launch website
        String url = "https://bantheme.xyz/hathanhauto/tai-khoan/";
        driver.get(url);
        Assert.assertEquals(driver.getCurrentUrl(), url);
        //Utils.hardWait(30000); // wait 5s


        LoginPage loginPage = new LoginPage(driver);


        // Enter username
        // driver.findElement(By.xpath("//input[@id='username']")).sendKeys("testtest@gmail.com");

        //wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='username']"))); //maximum 30s
        loginPage.inputEmail(username);

        // Enter password
        // driver.findElement(By.xpath("//input[@id='password']")).sendKeys("testtest");
        loginPage.inputPassword(password);

        // Click login
        // driver.findElement(By.xpath("//button[@name=\"login\"]")).click();
        loginPage.clickLoginBtn();
        //Utils.hardWait();


        // Verify login failed
        // String errorMessage = driver.findElement(By.xpath("//ul[@class='woocommerce-error']")).getText();
        String errorMessage = loginPage.getErrorMessage();


        Assert.assertEquals(errorMessage, errormessage);
        Utils.hardWait();

    }


    @DataProvider(name = "testdata123")
    public Object[][] testData() {
        Object[][] testDataFeed = new Object[3][3];  //2 row, 3 column
        testDataFeed[0][0] = "testtest@gmail.com";
        testDataFeed[0][1] = "testtest";
        testDataFeed[0][2] = "Lỗi: Mật khẩu bạn nhập cho địa chỉ email testtest@gmail.com không đúng. Bạn quên mật khẩu?";
        testDataFeed[1][0] = "";
        testDataFeed[1][1] = "testtest";
        testDataFeed[1][2] = "Lỗi: Yêu cầu tên tài khoản.";
        testDataFeed[2][0] = "testtest@gmail.com";
        testDataFeed[2][1] = "";
        testDataFeed[2][2] = "Lỗi: xxxx";


        return testDataFeed;

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
