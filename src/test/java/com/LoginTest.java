package com;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.pages.LoginPage;
import com.utils.BasicTest;
import com.utils.Utils;

public class LoginTest extends BasicTest {

    


    @Test(enabled = true)
    public void loginTestSucessfully() throws Exception {

        LoginPage loginPage = new LoginPage(driver);


        // Launch website
        String url = "https://bantheme.xyz/hathanhauto/tai-khoan/";
        driver.get(url);
        Assert.assertEquals(driver.getCurrentUrl(), url);


        // WebElement emailInput = driver.findElement(By.xpath("//input[@id='username']"));
        // emailInput.sendKeys("panixap532@lucvu.com");
        
        // WebElement passwordInput = driver.findElement(By.xpath("//input[@id='password']"));
        // passwordInput.sendKeys(":KqCCNjmmy6wZ;>");
        
        // WebElement loginButton = driver.findElement(By.xpath("//button[contains(text(),'Đăng nhập')]"));
        // loginButton.click();

        loginPage.enterEmail("panixap532@lucvu.com");
        loginPage.enterPassword(":KqCCNjmmy6wZ;>");
        loginPage.clickLogin();

        // Utils.hardWait(5000);

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[contains(text(),'Thoát')]")));



        Assert.assertEquals(driver.getCurrentUrl(),"https://bantheme.xyz/hathanhauto/tai-khoan1/");

    }


    @Test(dataProvider = "testdata")
    public void loginTestFailed(String uname, String pwd) throws Exception {

        LoginPage loginPage = new LoginPage(driver);

        
        // Launch website
        String url = "https://bantheme.xyz/hathanhauto/tai-khoan/";
        driver.get(url);
        Assert.assertEquals(driver.getCurrentUrl(), url);


        // WebElement emailInput = driver.findElement(By.xpath("//input[@id='username']"));
        // emailInput.sendKeys("tetakok687@lucvu.com");
        
        // WebElement passwordInput = driver.findElement(By.xpath("//input[@id='password']"));
        // passwordInput.sendKeys(":KqCCNjmmy6wZ;>");
        
        // WebElement loginButton = driver.findElement(By.xpath("//button[contains(text(),'Đăng nhập')]"));
        // loginButton.click();

        // loginPage.enterEmail("tetakok687@lucvu.com");
        // loginPage.enterPassword(":KqCCNjmmy6wZ;>");
        loginPage.enterEmail(uname);
        loginPage.enterPassword(pwd);
        loginPage.clickLogin();

        // Utils.hardWait(5000);
        // WebElement errorMessage = driver.findElement(By.xpath("//ul[@class='woocommerce-error']"));

        WebElement errorMessage = loginPage.getErrorMessageElement();

  
        Assert.assertTrue(errorMessage.isDisplayed());
        // Verify error message 

    }



    @DataProvider(name = "testdata")
    public Object[][] testData() {
        Object[][] testDataFeed = new Object[3][2];  //3 row, 2 column
        testDataFeed[0][0] = "tetakok687@lucvu.com";
        testDataFeed[0][1] = ":KqCCNjmmy6wZ;>";
        testDataFeed[1][0] = "tetakok6871@lucvu.com";
        testDataFeed[1][1] = "tetakok687com";
        testDataFeed[2][0] = "tetakok688@lucvu.com";
        testDataFeed[2][1] = "tetakok687@lucvu.com";


        return testDataFeed;

    }

}
