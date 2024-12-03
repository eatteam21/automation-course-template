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


    @Test()
    public void hoverTest() throws Exception { // Happy case
        // Launch website
        String url = "https://bantheme.xyz/hathanhauto/tai-khoan/";
        driver.get(url);
        Assert.assertEquals(driver.getCurrentUrl(), url);
        Utils.hardWait(1000); // 3s

        WebElement element1 = driver.findElement(By.xpath("//li[@id='menu-item-347']"));
        actions.moveToElement(element1).perform();
        Utils.hardWait(1000); // 3s


        String dynamicText = "Trải nghiệm kỳ nghỉ tuyệt vời";

        Boolean correct = isTitleCorrect(dynamicText);
        Assert.assertTrue(correct);

    }

    public boolean isTitleCorrect(String dynamicText) {
        try {
            String locator = "//h1[contains(text(),'" + dynamicText + "')]";
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locator)));
            return true;
        } catch (Exception e){
            return false;
        }
    }


}
