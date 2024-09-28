package com.steps;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import com.pages.LoginPage;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class LoginSteps {

    protected static WebDriver driver;
    

    @Given("open browser")
    public void open_browser() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        String url ="https://bantheme.xyz/hathanhauto/tai-khoan/";
        driver.get(url);
    }
    
    @When("enter username")
    public void enter_username() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.inputEmail("ngttvi2022@gmail.com");
    }
    
    @When("enter passpord")
    public void enter_password() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.inputPassword("Hoctestauto1805");
    }

    @When("click login")
    public void click_login() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.clickLoginBtn();
    }

    @Then("verify login success")
    public void verify_login_success() {
        LoginPage loginPage = new LoginPage(driver);
        String Message = loginPage.getErrorMessage1();
        Assert.assertTrue(Message.contains("Xin chào"));

        driver.quit();
    }

}
