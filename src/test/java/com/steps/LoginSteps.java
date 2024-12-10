package com.steps;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.pages.HomePage;
import com.pages.LoginPage;
import com.utils.Utils;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class LoginSteps {
    protected static WebDriver driver;
    protected static WebDriverWait wait;

   @Given("the user is on the homepage\"([^\"]*)\"$")
    public void givenUserIsOnHomepage() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, 15);

        String url = "https://bantheme.xyz/hathanhauto/tai-khoan/";
        driver.get(url);
        Assert.assertEquals(driver.getCurrentUrl(), url);
        Utils.hardWait(1000); 


    }

    @When("user enters email\"([^\"]*)\"$")
    public void userEnterEmail( String email) {
        LoginPage loginpage = new LoginPage(driver);
        loginpage.enterEmail("email");

        

    }

    @And("user enters password\"([^\"]*)\"$")
    public void userEnterPass(String pass) {
        LoginPage loginpage = new LoginPage(driver);
        loginpage.enterPassword("pass");
    }
   
    @And (" user submit login\"([^\"]*)\"$")
    public void userSubmitLogin() {
    LoginPage loginpage = new LoginPage(driver);
    loginpage.enterLogin() ;

    }
    public boolean isLogoutDisplayed() {
        try {
            HomePage homePage=new HomePage(driver);
            wait.until(ExpectedConditions.visibilityOfElementLocated(homePage.byLogoutBtn));
            return true;
        } catch (Exception e) {
            return false;
        }

    }

    @Then("verify login successfully\"([^\\\"]*)\\\"$")
    public void verifyLogin(boolean expectedLogoutDisplay) {
        boolean logoutBtnDisplayed = isLogoutDisplayed();
        Assert.assertEquals(logoutBtnDisplayed, expectedLogoutDisplay);
        Assert.assertTrue(false);
        driver.quit();
    }
    
}
