package com.utils;

import config.Constants;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import io.github.bonigarcia.wdm.WebDriverManager;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;


public abstract class BasicTest {
    
    public static final Logger logger = LogManager.getLogger();
    protected static WebDriver driver;
    protected static WebDriverWait wait;

    // private String driverPath;

    @BeforeMethod
    public void preCondition() throws MalformedURLException {
        // Chromedriver path
        // driverPath = "src/main/resources/WebDrivers/chromedriver.exe";
        // ChromeOptions options = new ChromeOptions();
        // System.setProperty("webdriver.chrome.driver", driverPath);
        // driver = new ChromeDriver(options);

        if (Constants.RUN_AT.equals("local")) {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
            ChromeOptions options = new ChromeOptions();
            if (Constants.HEADLESS) {
                options.addArguments("--headless");
            }

            options.addArguments("window-size=1920,1080");
            options.addArguments("--no-sanbox");
        } else  {
            String hubURL = "https://hub.lambdatest.com/wd/hub";
            DesiredCapabilities capabilities = new DesiredCapabilities();
            capabilities.setCapability("browserName", "Chrome");
            capabilities.setCapability("browserVersion", "95");
            HashMap<String, Object> ltOptions = new HashMap<String, Object>();
            ltOptions.put("user", "linhbap2911");
            ltOptions.put("accessKey", "XgH3dlUR8AtaRl3VjzYeG64L2fPAvcDk2hV8XcGb5Nh2VFFKZw");
            ltOptions.put("build", "Selenium 4");
            ltOptions.put("name", this.getClass().getName());
            ltOptions.put("platformName", "Windows 10");
            ltOptions.put("seCdp", true);
            ltOptions.put("selenium_version", "4.0.0");
            capabilities.setCapability("LT:Options", ltOptions);
            driver = new RemoteWebDriver(new URL(hubURL), capabilities);
        }



//        driver = new ChromeDriver(options);


        // Maximize the browser
        driver.manage().window().maximize();
        //driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        wait = new WebDriverWait(driver, 30);

    }

    @AfterMethod
    public void postCondition(){
        // Quit the Browser
        driver.quit();
    }
}