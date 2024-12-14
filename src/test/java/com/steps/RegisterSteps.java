// package com.steps;

// import org.openqa.selenium.WebDriver;
// import org.openqa.selenium.chrome.ChromeDriver;
// import org.openqa.selenium.interactions.Actions;
// import org.openqa.selenium.support.ui.ExpectedConditions;
// import org.openqa.selenium.support.ui.WebDriverWait;
// import org.testng.Assert;

// import com.pages.HomePage;
// import com.pages.LoginPage;
// import com.pages.RegisterPage;
// import com.utils.Utils;

// import io.cucumber.java.After;
// import io.cucumber.java.Before;
// import io.cucumber.java.en.And;
// import io.cucumber.java.en.Given;
// import io.cucumber.java.en.Then;
// import io.cucumber.java.en.When;
// import io.github.bonigarcia.wdm.WebDriverManager;

// public class RegisterSteps {
//     protected static WebDriver driver;
//     protected static WebDriverWait wait;

//     @Before
//     public void setUp() {
//         WebDriverManager.chromedriver().setup();
//         driver = new ChromeDriver();
//         driver.manage().window().maximize();
//         wait = new WebDriverWait(driver, 15);
//     }

//     @Given("the user is on the homepage to register")
//     public void givenUserIsOnHomepage() {
//         String url = "https://bantheme.xyz/hathanhauto/tai-khoan/";
//         driver.get(url);
//         Assert.assertEquals(driver.getCurrentUrl(), url);
//         Utils.hardWait(1000);

//     }

//     @When("user enters email register to register {string}")
//     public void userEnterEmailRegister(String EmailRegister) {
//         RegisterPage registerPage = new RegisterPage(driver);
//         registerPage.enterEmailRegister(EmailRegister);
//         Utils.hardWait(1000);

//     }

//     @When("user enters password register to register {string}")
//     public void userEnterPassRegister(String PasswordRegister) {
//         RegisterPage registerPage = new RegisterPage(driver);
//         registerPage.enterPasswordRegister(PasswordRegister);
//         Utils.hardWait(1000);
//     }

//     @When("user submit register to register")
//     public void userSubmitRegister() {
//         RegisterPage registerPage = new RegisterPage(driver);
//         registerPage.enterRegister();
//         Utils.hardWait(1000);

//     }
//     // public boolean isLogoutDisplayed() {
//     // try {
//     // HomePage homePage=new HomePage(driver);
//     // wait.until(ExpectedConditions.visibilityOfElementLocated(homePage.byLogoutBtn));
//     // return true;
//     // } catch (Exception e) {
//     // return false;
//     // }

//     // }

//     // @Then("verify login successfully {string}")
//     // public void verifyLogin(String expectedLogoutDisplay) {
//     // boolean expected = Boolean.parseBoolean(expectedLogoutDisplay); // Chuyển đổi
//     // string thành boolean
//     // boolean logoutBtnDisplayed = isLogoutDisplayed();
//     // Assert.assertEquals(logoutBtnDisplayed, expected);
//     // Utils.hardWait(1000);
//     // }
//     @After
//     public void tearDown() {
//         if (driver != null) {
//             driver.quit();
//         }
//     }
// }
