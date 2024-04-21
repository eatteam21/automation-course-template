package com.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import io.github.bonigarcia.wdm.WebDriverManager;
import java.util.concurrent.TimeUnit;


import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import java.net.URL;



public abstract class BasicTest {
    
    public static final Logger logger = LogManager.getLogger();
    protected static AndroidDriver  driver;
    // protected static WebDriver driver;
    // private String driverPath;

    @BeforeMethod
    public void preCondition() {
        // // Chromedriver path
        // // driverPath = "src/main/resources/WebDrivers/chromedriver.exe";
        // // ChromeOptions options = new ChromeOptions();
        // // System.setProperty("webdriver.chrome.driver", driverPath);
        // // driver = new ChromeDriver(options);
        // WebDriverManager.chromedriver().setup();
        // driver = new ChromeDriver();
        // // Maximize the browser
        // driver.manage().window().maximize();
        // //driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("platformName", "Android");
        // capabilities.setCapability("platformVersion", "8.1");
        // capabilities.setCapability("deviceName", "Pixel_2_XL_API_27");
        //capabilities.setCapability("app", appLocation);
        // //capabilities.setCapability("appPackage", "io.appium.android.apis");
        // //capabilities.setCapability("appActivity", ".view.TextFields");
        // capabilities.setCapability("appPackage", "com.swaglabsmobileapp");
        // capabilities.setCapability("appActivity", "com.swaglabsmobileapp.SplashActivity");
        // // capabilities.setCapability("appWaitActivity", "com.swaglabsmobileapp.MainActivity");
        // // capabilities.setCapability("appWaitForLaunch", false);
        capabilities.setCapability("automationName", "UiAutomator2");
        // // capabilities.setCapability("udid", "emulator-5554");

        try {
            driver = new AndroidDriver<>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
        } catch (Exception e) {
            // nothing
        }
    }

    @AfterMethod
    public void postCondition(){
        // Quit the Browser
        driver.quit();
    }
}