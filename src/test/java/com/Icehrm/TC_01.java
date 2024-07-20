package com.Icehrm;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.mongodb.util.Util;
import com.pages.Icehrm.TC_001;
import com.utils.BasicTest;
import com.utils.Utils;

public class TC_01 extends BasicTest {


    @DataProvider(name = "testdata")
    public Object[][] testData() {
        Object[][] testDataFeed = new Object[4][2];  //4 row, 2 column
        testDataFeed[0][0] = "admin";
        testDataFeed[0][1] = "admin>";
        testDataFeed[1][0] = "manager";
        testDataFeed[1][1] = "demouserpwd";
        testDataFeed[2][0] = "user1";
        testDataFeed[2][1] = "demouserpwd";
        testDataFeed[3][0] = "user2";
        testDataFeed[3][1] = "demouserpwd";

        return testDataFeed;

    }


    @Test(enabled = true, dataProvider = "testdata")
    public void loginTestSuccess(String username, String password) throws Exception {
        // Launch website
        String url = "https://icehrm-open.gamonoid.com/login.php#";
        driver.get(url);
        Assert.assertEquals(driver.getCurrentUrl(), url);


        TC_001 loginPage = new TC_001(driver);
        // loginPage.inputEmail("testtest@gmail.com");
        // loginPage.inputPass("Testtest@1");
        loginPage.inputEmail(username);
        loginPage.inputPass(password);
        loginPage.clickLogin();

        
        // driver.findElement(By.xpath("//input[@id='username']")).sendKeys("testtest@gmail.com");
        // Utils.hardWait();

        // driver.findElement(By.xpath("//input[@id='password']")).sendKeys("Testtest@1");
        // Utils.hardWait();

        // driver.findElement(By.name("login")).click();
        // Utils.hardWait();

        // Assert.assertTrue(driver.findElement(By.name("login")).isDisplayed());
 
        Assert.assertEquals(driver.getCurrentUrl(), "https://bantheme.xyz/hathanhauto/tai-khoan/");
    }

    // @Test(enabled = true)
    // public void loginTestFailed() throws Exception {
    //     // Launch website
    //     String url = "https://bantheme.xyz/hathanhauto/tai-khoan/";
    //     driver.get(url);
    //     Assert.assertEquals(driver.getCurrentUrl(), url);

    //     LoginPage loginPage = new LoginPage(driver);
    //     // loginPage.inputEmail("testtesta@gmail.com");
    //     // loginPage.inputPass("Testtest@12");
    //     // loginPage.clickLogin();
    //     loginPage.login("testtesta@gmail.com", "Testtest@12");
        
        
    //     // driver.findElement(By.xpath("//input[@id='username']")).sendKeys("testtesta@gmail.com");
    //     // Utils.hardWait();

    //     // driver.findElement(By.xpath("//input[@id='password']")).sendKeys("Testtest@12");
    //     // Utils.hardWait();

    //     // driver.findElement(By.name("login")).click();
    //     // Utils.hardWait();


    //     // String errorMessage = driver.findElement(By.xpath("//ul[@class='woocommerce-error']/li")).getText();

    //     Assert.assertEquals(loginPage.getErrorMessage(), "Địa chỉ email không xác định. Kiểm tra lại hoặc thử tên người dùng của bạn.");
    
    // }


}
