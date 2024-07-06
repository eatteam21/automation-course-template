package com.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.config.Constants;

import io.github.bonigarcia.wdm.WebDriverManager;
import java.util.concurrent.TimeUnit;
import java.net.MalformedURLException;
import java.net.URL;


public abstract class BasicTest {
    
    public static final Logger logger = LogManager.getLogger();
    protected static WebDriver driver;
    // private String driverPath;

    @BeforeMethod
    public void preCondition() throws MalformedURLException {
        if (Constants.RUN_AT.equals("local")){
            // Chromedriver path
            // driverPath = "src/main/resources/WebDrivers/chromedriver.exe";
            // ChromeOptions options = new ChromeOptions();
            // options.addArguments("--headless");
            // System.setProperty("webdriver.chrome.driver", driverPath);
            // driver = new ChromeDriver(options);
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
            // Maximize the browser
            driver.manage().window().maximize();
            //driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        } else if (Constants.RUN_AT.equals("remote")){
            String username = System.getenv("LT_USERNAME") == null ? "minhphat3575" : System.getenv("LT_USERNAME");
            String authkey = System.getenv("LT_ACCESS_KEY") == null ? "CVFh6vKrkagNXKCYKnZ0KJsesHqCWyxhPsgy6VuHmbdPwm4f50" : System.getenv("LT_ACCESS_KEY");
            String hub = "@hub.lambdatest.com/wd/hub";

            DesiredCapabilities caps = new DesiredCapabilities();
            caps.setCapability("platform", "MacOS Catalina");
            caps.setCapability("browserName", "Safari");
            caps.setCapability("version", "latest");
            caps.setCapability("build", "Build 1");

            driver = new RemoteWebDriver(new URL("https://" + username + ":" + authkey + hub), caps);
            driver.manage().window().maximize();
        }
    }

    @AfterMethod
    public void postCondition(){
        // Quit the Browser
        driver.quit();
    }
}