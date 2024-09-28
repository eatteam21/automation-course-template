package com.steps;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import com.pages.BookingPage;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class BookingSteps {

    protected static WebDriver driver;
    
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
