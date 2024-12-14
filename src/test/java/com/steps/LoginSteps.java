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

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class LoginSteps {
    protected static WebDriver driver;
    protected static WebDriverWait wait;

    @Before
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, 15);
    }

    @Given("the user is on the homepage")
    public void givenUserIsOnHomepage() {
        String url = "https://bantheme.xyz/hathanhauto/tai-khoan/";
        driver.get(url);
        Assert.assertEquals(driver.getCurrentUrl(), url);
       // Utils.hardWait(1000);

    }

    @When("user enters email {string}")
    public void userEnterEmail(String email) {
        LoginPage loginpage = new LoginPage(driver);
        loginpage.enterEmail(email);

    }

    @When("user enters password {string}")
    public void userEnterPass(String pass) {
        LoginPage loginpage = new LoginPage(driver);
        loginpage.enterPassword(pass);
       
    }

    @When("user submit login")
    public void userSubmitLogin() {
        LoginPage loginpage = new LoginPage(driver);
        loginpage.enterLogin();
       

    }

    // thành công
    public boolean isLogoutDisplayed() {
        try {
            HomePage homePage = new HomePage(driver);
            wait.until(ExpectedConditions.visibilityOfElementLocated(homePage.byLogoutBtn));
            return true;
        } catch (Exception e) {
            return false;
        }

    }

    @Then("verify login successfully {string}")
    public void verifyLogin(String expectedLogoutDisplay) {
        boolean expected = Boolean.parseBoolean(expectedLogoutDisplay); // Chuyển đổi string thành boolean
        boolean logoutBtnDisplayed = isLogoutDisplayed();
        Assert.assertEquals(logoutBtnDisplayed, expected);
       
    }

    // sai email
    public boolean isMessageErroFailseEmailDisplayed() {
        try {
            LoginPage loginPage = new LoginPage(driver);
            wait.until(ExpectedConditions.visibilityOfElementLocated(loginPage.messageErroEmail));
            return true;
        } catch (Exception e) {
            return false;
        }

    }

    @Then("verify login erro email {string}")
    public void verifyLoginFailseEmail(String expectedMessageErroEmailDisplay) {
        boolean expectedMessageErroEmail = Boolean.parseBoolean(expectedMessageErroEmailDisplay);
        boolean messageErroEmailDisplayed = isMessageErroFailseEmailDisplayed();
        Assert.assertEquals(messageErroEmailDisplayed, expectedMessageErroEmail);
       
    }

    // Null email
    public boolean isMessageErroNullEmailDisplayed() {
        try {
            LoginPage loginPage = new LoginPage(driver);
            wait.until(ExpectedConditions.visibilityOfElementLocated(loginPage.messageNullAccount));
            return true;
        } catch (Exception e) {
            return false;
        }

    }

    @Then("verify login null mail {string}")
    public void verifyLoginNullAccount(String expectedMessageNullEmailDisplay) {
        boolean expectedMessageNullEmail = Boolean.parseBoolean(expectedMessageNullEmailDisplay);
        boolean messageNullEmailDisplayed = isMessageErroNullEmailDisplayed();
        Assert.assertEquals(messageNullEmailDisplayed, expectedMessageNullEmailDisplay);
       
    }

    // sai pass
    public boolean isMessageErroFailsePassDisplayed() {
        try {
            LoginPage loginPage = new LoginPage(driver);
            wait.until(ExpectedConditions.visibilityOfElementLocated(loginPage.messageFailsePass));
            return true;
        } catch (Exception e) {
            return false;
        }

    }

    @Then("verify login erro password {string}")
    public void verifyLoginErroPassl(String expectedMessageErroPassDisplay) {
        boolean expectedMessageErroPass = Boolean.parseBoolean(expectedMessageErroPassDisplay);
        boolean messageErroPassDisplayed = isMessageErroFailsePassDisplayed();
        Assert.assertEquals(messageErroPassDisplayed, expectedMessageErroPassDisplay);
       
    }

    // null pass
    public boolean isMessageErroNullPassDisplayed() {
        try {
            LoginPage loginPage = new LoginPage(driver);
            wait.until(ExpectedConditions.visibilityOfElementLocated(loginPage.messageNullPass));
            return true;
        } catch (Exception e) {
            return false;
        }

    }

    @Then("verify login null pass {string}")
    public void verifyLoginNullPassl(String expectedMessageNullPassDisplay) {
        boolean expectedMessageNullPass = Boolean.parseBoolean(expectedMessageNullPassDisplay);
        boolean messageNullPassDisplayed = isMessageErroNullPassDisplayed();
        Assert.assertEquals(messageNullPassDisplayed, expectedMessageNullPassDisplay);
       
    }

    // null email và pass
    public boolean isMessageErroNullAccountlDisplayed() {
        try {
            LoginPage loginPage = new LoginPage(driver);
            wait.until(ExpectedConditions.visibilityOfElementLocated(loginPage.messageNullAccount));
            return true;
        } catch (Exception e) {
            return false;
        }

    }

    @Then("verify login null email and pass {string}")
    public void verifyLoginNullEmailAndPassl(String expectedMessageNullEmailAndPassDisplay) {
        boolean expectedMessageNullEmailAndPass = Boolean.parseBoolean(expectedMessageNullEmailAndPassDisplay);
        boolean messageNullEmailAndPassDisplayed = isMessageErroNullAccountlDisplayed();
        Assert.assertEquals(messageNullEmailAndPassDisplayed, expectedMessageNullEmailAndPassDisplay);
       
    }

    @After
    public void tearDown() {
        if (driver != null) {
        driver.quit();
    }
}
}
