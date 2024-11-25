package com;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
//import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
//import com.utils.Utils;
import com.utils.BasicTest;

public class BookingTest extends BasicTest {
    @DataProvider(name = "loginTestData")
    public Object[][] testDataFeed() {
        Object[][] testdata = new Object[1][3];
        testdata[0][0] = "trongtuyen451@gmail.com";
        testdata[0][1] = "Admin@123456";
        testdata[0][2] = true;
        return testdata;
    }

    public boolean isLogoutDisplayed() {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[contains(@class,'logout')]")));
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Test(dataProvider = "loginTestData")
    public void loginTestSuccess(String uname, String pw, boolean expectedLogoutDisplay) throws Exception {
        String url = "https://bantheme.xyz/hathanhauto/tai-khoan/";
        driver.get(url);
        Assert.assertEquals(driver.getCurrentUrl(), url);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='username']"))).sendKeys(uname);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='password']"))).sendKeys(pw);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@name='login']"))).click();

        boolean logoutBtnDisplayed = isLogoutDisplayed();
        Assert.assertEquals(logoutBtnDisplayed, expectedLogoutDisplay);
        // nhập text
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@placeholder='Tìm kiếm...'][1]")))
                .sendKeys("Mercedes");
        // chọn option 1
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[text()='Bơm nước xe ']"))).click();
        // select xuất xứ xứ
        WebElement selectOption = driver.findElement(By.xpath("//select[@id='pa_xuat-xu']/option[@value='germany']"));
        selectOption.click();
        // click icon + số lương
        WebElement btnPlus = driver.findElement(By.xpath("//button[@class='plus']"));
        btnPlus.click();
        // click add
        WebElement btnAdd = driver.findElement(By.xpath("//button[contains(@class,'single_add_to_cart_button')]"));
        btnAdd.click();
        // verify get url card
        String urlCard = "https://bantheme.xyz/hathanhauto/gio-hang/";
        Assert.assertEquals(driver.getCurrentUrl(), urlCard);
        // verify số lượng sản phẩm =2
        WebElement iconCard = driver.findElement(By.xpath("//div[@class='d-table-cell link-cart']//a/b[text()='2']"));
        Assert.assertTrue(iconCard.isDisplayed());
    }
}
