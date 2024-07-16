package com;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.mongodb.util.Util;
import com.pages.LoginPage;
import com.utils.BasicTest;
import com.utils.ExcelUtils;
import com.utils.Utils;

public class LoginTest extends BasicTest {


    @DataProvider(name = "testdata")
    public Object[][] testData() {


        ExcelUtils excelUtils = new ExcelUtils("src/test/resources/testdata/", "TestData.xlsx");




        Object[][] testDataFeed = new Object[2][2];  //4 row, 2 column

        testDataFeed[0][0] = excelUtils.getData(0, 1, 1);
        testDataFeed[0][1] = excelUtils.getData(0, 1, 2);

        testDataFeed[1][0] = excelUtils.getData(0, 2, 1);
        testDataFeed[1][1] = excelUtils.getData(0, 2, 2);




        // testDataFeed[0][0] = "tetakok687@lucvu.com";
        // testDataFeed[0][1] = ":KqCCNjmmy6wZ;>";
        // testDataFeed[1][0] = "tetakok6871@lucvu.com";
        // testDataFeed[1][1] = "tetakok687com";
        // testDataFeed[2][0] = "tetakok688@lucvu.com";
        // testDataFeed[2][1] = "tetakok687@lucvu.com";
        // testDataFeed[3][0] = "tetakok681@lucvu.com";
        // testDataFeed[3][1] = "tetakok687";

        return testDataFeed;

    }


    @Test(enabled = true, dataProvider = "testdata")
    public void loginTestSuccess(String username, String password) throws Exception {
        // Launch website
        String url = "https://bantheme.xyz/hathanhauto/tai-khoan/";
        driver.get(url);
        Assert.assertEquals(driver.getCurrentUrl(), url);


        LoginPage loginPage = new LoginPage(driver);
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

    // @Test(enabled = false)
    // public void loginTestFailed() throws Exception {
    //     // Launch website
    //     String url = "https://bantheme.xyz/hathanhauto/tai-khoan/";
    //     driver.get(url);
    //     Assert.assertEquals(driver.getCurrentUrl(), url);

    //     LoginPage loginPage = new LoginPage(driver);
    //     // loginPage.inputEmail("testtesta@gmail.com");
    //     // loginPage.inputPass("Testtest@12");
    //     // loginPage.clickLogin();
    //     loginPage.login("testtest@gmail.com", "Testtest@1");
    //     loginPage.clickHyperlinkAccount();
    //     loginPage.clickHyperlinkBack();
    //     Assert.assertTrue(loginPage.displayedLogin());
    
    // }
}
