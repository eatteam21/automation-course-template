package com;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.pages.BookingPage;
import com.pages.LoginPage;
import com.utils.BasicTest;
import com.utils.Utils;

public class BookingTest extends BasicTest {

    @Test()
    public void bookingTestSuccessful() throws Exception {
        String url = "https://bantheme.xyz/hathanhauto/tai-khoan/";
        driver.get(url);
        Assert.assertEquals(driver.getCurrentUrl(), url);
        //Utils.hardWait(5000); // wait 5s

        BookingPage bookingPage = new BookingPage(driver);
        LoginPage loginPage = new LoginPage(driver);
        //CartPage cartPage = new CartPage(driver);

        // Enter username
        // driver.findElement(By.xpath("//input[@id='username']")).sendKeys("ngttvi2022@gmail.com");
        loginPage.inputEmail("ngttvi2022@gmail.com");

        // Enter password
        // driver.findElement(By.xpath("//input[@id='password']")).sendKeys("Hoctestauto1805");
        loginPage.inputPassword("Hoctestauto1805");

        // Click login
        // driver.findElement(By.xpath("//button[@name=\"login\"]")).click();
        //Utils.hardWait();
        loginPage.clickLoginBtn();

        // Verify login successfully
        // String Message = driver.findElement(By.xpath("//div[@class='woocommerce-MyAccount-content']")).getText();
        String Message = loginPage.getErrorMessage1();
        Assert.assertTrue(Message.contains("Xin chào"));
        //Utils.hardWait();
        
        //Enter product

        // Booking Page
        // driver.findElement(By.xpath("(//input[@class='form-control js-typeahead tt-input'])[1]")).sendKeys("merc");
        bookingPage.inputProduct("merc");

        //Presses Enter Key
        //driver.findElement(By.xpath("(//input[@class='form-control js-typeahead tt-input'])[1]")).sendKeys(Keys.ENTER);

        //Select product
        //driver.findElement(By.xpath("//a[@title='Bơm nước xe Mercedes SLK200, SLK300, GLK200, E260, C350-2742000207']")).click();

        //Select option in DDL
        //driver.findElement(By.xpath("//select[@id='pa_xuat-xu']")).click();
        //driver.findElement(By.xpath("//option[@value='england']")).click();
        //driver.findElement(By.xpath("//button[@class='single_add_to_cart_button button alt']")).click();

        bookingPage.selectOption();

        // Verify booking successfully
        String Message2 = driver.findElement(By.xpath("//div[@class='woocommerce-message']")).getText();

        // Cart Page
        Assert.assertTrue(Message2.contains("“Bơm nước xe Mercedes SLK200, SLK300, GLK200, E260, C350-2742000207” đã được thêm vào giỏ hàng."));
        Utils.hardWait();

        Boolean display = driver.findElement(By.xpath("//a[contains(text(),'Bơm nước xe Mercedes')]")).isDisplayed();
        Assert.assertTrue(display);
        Utils.hardWait();
    }

}
