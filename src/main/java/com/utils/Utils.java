package com.utils;



import java.util.ArrayList;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.github.dockerjava.api.model.Driver;
import com.pages.BasePage;
import com.pages.Driver.DriverManager;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Utils extends BasePage{
    public Utils(WebDriver givenDriver) {
        super(givenDriver);
        //TODO Auto-generated constructor stub
    }

    public static void hardWait(int timeout){
        try {
            Thread.sleep(timeout);
        } catch (Exception e) {
            // pass
        }
    }

    public static void hardWait(){
        hardWait(3000);
    }

    public static void newTab(){
        JavascriptExecutor jse = (JavascriptExecutor) DriverManager.getDriver();
        jse.executeScript("window.open()");
        hardWait(500);

        ArrayList<String> tabs = new ArrayList<String>(DriverManager.getDriver().getWindowHandles());
        DriverManager.getDriver().switchTo().window(tabs.get(1));
    }

    public static void scrollToElement(WebElement webElement, WebDriver driver) {
        WebDriver y = DriverManager.getDriver();       
        ((JavascriptExecutor) DriverManager.getDriver()).executeScript("arguments[0].scrollIntoView(true);", webElement);
        System.out.println(y);
        hardWait(500);
    }
}
