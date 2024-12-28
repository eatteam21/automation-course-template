package com;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.utils.Utils;
import com.utils.BasicTest;
import com.Bai16_LoginTest;

public class Bai17_ShoppingCartTest extends BasicTest {
    @Test()
    public void shoppingCartTest() throws Exception {
        // Launch website
        String url = "https://bantheme.xyz/hathanhauto/tai-khoan/";
        driver.get(url);
        Assert.assertEquals(driver.getCurrentUrl(), url);
        // Login
        Bai16_LoginTest login = new Bai16_LoginTest();
        login.loginTestSuccess();
        // Search with keyword "merc"
        WebElement searchInput = driver.findElement(By.xpath("(//input[@id = 's'])[1]"));
        searchInput.sendKeys("merc");
        Utils.hardWait();
        // Select the first result "Bơm nước xe"
        WebElement result = driver.findElement(By.xpath("//a[contains(text(),'Bơm nước xe')]"));
        result.click();
        // Select option "England"
        WebElement select = driver.findElement(By.xpath("//select[@id='pa_xuat-xu']"));
        select.click();
        WebElement option = driver.findElement(By.xpath("//option[@value='england']"));
        option.click();
        Utils.hardWait(1000);
        // Click "Thêm vào giỏ hàng" button
        WebElement addToCart = driver.findElement(By.xpath("(//button[@type = 'submit'])[2]"));
        addToCart.click();
        Utils.hardWait(1000);
        // Verify item added to cart using Assert method
        WebElement productName = driver.findElement(By.xpath("//td[@class = 'product-name']"));
        Assert.assertEquals(productName.isDisplayed(), true);
        }
 }
