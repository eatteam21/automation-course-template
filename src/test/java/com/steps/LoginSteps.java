package com.steps;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.pages.LoginPage;
import com.utils.Utils;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class LoginSteps {
    protected static WebDriver driver;

    protected static WebDriverWait wait;

   @Given("the user is on the homepage")
    public void givenUserIsOnHomepage() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        // Maximize the browser
        driver.manage().window().maximize();
        //driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        wait = new WebDriverWait(driver, 15);

        String url = "https://bantheme.xyz/hathanhauto/tai-khoan/";
        driver.get(url);
        Assert.assertEquals(driver.getCurrentUrl(), url);
        Utils.hardWait(1000); // 3s


    }

    @When("user enters email")
    public void userEnterEmail() {
        
        // WebElement emailInput = driver.findElement(By.xpath("//input[@id='username']"));
        // emailInput.sendKeys("testtest@gmail.com");
        // Utils.hardWait(1000); // 3s
        LoginPage loginpage = new LoginPage(driver);
        loginpage.enterEmail("trongtuyen451@gmail.com");

        

    }

    @When("user enters password")
    public void userEnterPass() {

        LoginPage loginpage = new LoginPage(driver);
        loginpage.enterPassword("Admin@123456");
        
        // WebElement emailInput = driver.findElement(By.xpath("//input[@id='password']"));
        // emailInput.sendKeys("testtest");
        // Utils.hardWait(1000); // 3s

    }
   
    @And ("user submit login")
    public void userSubmitLogin() {
    LoginPage loginpage = new LoginPage(driver);
    loginpage.enterLogin() ;

    }

    @When("verify login successfully")
    public void verifyLogin() {
        
       Assert.assertTrue(false);
        driver.quit();
    }
    
}
