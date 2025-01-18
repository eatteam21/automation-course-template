package com.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import io.github.bonigarcia.wdm.WebDriverManager;
import java.util.concurrent.TimeUnit;

import javax.swing.Action;


public abstract class BasicTest {
    
    public static final Logger logger = LogManager.getLogger();
    public static WebDriver driver;
    // private String driverPath;
    public static WebDriverWait wait;
    public static Actions action;

    @BeforeMethod //hook //beforeEach
    // @BeforeClass //beforeAll
    public void preCondition() {
        // Chromedriver path
        // driverPath = "src/main/resources/WebDrivers/chromedriver.exe";
        // ChromeOptions options = new ChromeOptions();
        // System.setProperty("webdriver.chrome.driver", driverPath);
        // driver = new ChromeDriver(options);
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        // Maximize the browser
        driver.manage().window().maximize();
        //driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        wait = new WebDriverWait(driver, 15);
        action = new Actions(driver);
    }

    @AfterMethod
    // @AfterClass
    public void postCondition(){
        // Quit the Browser
        driver.quit();
    }
}