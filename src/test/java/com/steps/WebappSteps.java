/*package com.steps;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import com.pages.BookingPage;
import com.pages.LoginPage;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class WebappSteps {

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
    }

    @When("enter product")
    public void enter_product() {
        BookingPage bookingPage = new BookingPage(driver);
        bookingPage.inputProduct("merc");
    }

    @When("select option")
    public void select_option() {
        BookingPage bookingPage = new BookingPage(driver);
        bookingPage.selectOption();
    }

    @Then("verify booking success")
    public void verify_booking_success() {
        String Message2 = driver.findElement(By.xpath("//div[@class='woocommerce-message']")).getText();
        Assert.assertTrue(Message2.contains("“Bơm nước xe Mercedes SLK200, SLK300, GLK200, E260, C350-2742000207” đã được thêm vào giỏ hàng."));

        Boolean display = driver.findElement(By.xpath("//a[contains(text(),'Bơm nước xe Mercedes')]")).isDisplayed();
        Assert.assertTrue(display);

        driver.quit();
    }

}
*/