package com;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.utils.Utils;

import com.utils.BasicTest;

public class BookingTest extends BasicTest {
// Booking thành công - khi giỏ hàng = 0
    @Test(priority = 1)
    public void BookingSuccess() throws Exception {
        String url = "https://bantheme.xyz/hathanhauto/tai-khoan/";
        driver.get(url);
        Assert.assertEquals(driver.getCurrentUrl(), url);
        WebElement emailInput = driver.findElement(By.xpath("//input[@id='username']"));
        emailInput.sendKeys("trongtuyen451@gmail.com");
        WebElement passInput = driver.findElement(By.xpath("//input[@id='password']"));
        passInput.sendKeys("Admin@123456");
        WebElement loginBtn = driver.findElement(By.xpath("//button[@name='login']"));
        loginBtn.click();
        Utils.hardWait();
        WebElement seachBox = driver.findElement(By.xpath("//input[@placeholder='Tìm kiếm...'][1]"));
        seachBox.sendKeys("Mercedes");
        Utils.hardWait();
        WebElement optionFirts = driver.findElement(By.xpath("//a[text()='Bơm nước xe ']"));
        optionFirts.click();
        WebElement selectOption = driver.findElement(By.xpath("//select[@id='pa_xuat-xu']/option[@value='germany']"));
        selectOption.click();
        WebElement btnPlus = driver.findElement(By.xpath("//button[@class='plus']"));
        btnPlus.click();
        WebElement btnAdd = driver.findElement(By.xpath("//button[contains(@class,'single_add_to_cart_button')]"));
        btnAdd.click();
        String urlCard = "https://bantheme.xyz/hathanhauto/gio-hang/";
        Assert.assertEquals(driver.getCurrentUrl(), urlCard);
        WebElement iconCard = driver.findElement(By.xpath("//div[@class='d-table-cell link-cart']//a/b[text()='2']"));
        Assert.assertTrue(iconCard.isDisplayed());
    }
}
