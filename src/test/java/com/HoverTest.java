package com;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.utils.BasicTest;
import com.utils.Utils;

public class HoverTest extends BasicTest {
    @DataProvider(name = "loginTestData")
    public Object[][] testDataFeed() {
        Object[][] testdata = new Object[1][3];
        testdata[0][0] = "trantuyen991127@gmail.com";
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
        Utils.hardWait(5000);
        boolean logoutBtnDisplayed = isLogoutDisplayed();
        Assert.assertEquals(logoutBtnDisplayed, expectedLogoutDisplay);

        WebElement menuItem = driver.findElement(By.xpath("//li[@id='menu-item-347']"));
        actions.moveToElement(menuItem).perform();
        Utils.hardWait(3000);

        WebElement menuItem1 = driver.findElement(By.xpath("//li[@id='menu-item-465']"));
        actions.moveToElement(menuItem1).perform();
        Utils.hardWait(3000);

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[@id='menu-item-468']"))).click();

        String dynamicText = "Phanh tay ô tô"; // Văn bản động cần kiểm tra
        boolean isElementDisplayed = isElementPresent(dynamicText); // Kiểm tra sự hiện diện của phần tử
        Assert.assertTrue(isElementDisplayed);
    }

    public boolean isElementPresent(String dynamicText) {
        try {
            String breadcrumb= wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//nav[@class='woocommerce-breadcrumb']"))).getText();
          System.out.println(breadcrumb);
          boolean display=breadcrumb.contains(dynamicText);
            return display;
        } catch (Exception e) {
            return false;
        }
    }
}