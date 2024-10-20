package com;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.utils.BasicTest;

public class LoginTest extends BasicTest {

    @Test()
    public void loginTest() throws Exception {
        // Launch website
        String url = "https://github.com/TrucMaiLe/TML-automation-course-template/tree/bai-15/src";
        driver.get(url);
        Assert.assertEquals(driver.getCurrentUrl(), url);
    }

}
