// package com.steps;

// import org.openqa.selenium.WebDriver;
// import org.openqa.selenium.chrome.ChromeDriver;
// import org.openqa.selenium.interactions.Actions;
// import org.openqa.selenium.support.ui.ExpectedConditions;
// import org.openqa.selenium.support.ui.WebDriverWait;
// import org.testng.Assert;

// import com.pages.CardPage;
// import com.pages.DetailProductPage;
// import com.pages.HomePage;
// import com.pages.LoginPage;
// import com.utils.Utils;

// import io.cucumber.java.After;
// import io.cucumber.java.Before;
// import io.cucumber.java.en.And;
// import io.cucumber.java.en.Given;
// import io.cucumber.java.en.Then;
// import io.cucumber.java.en.When;
// import io.github.bonigarcia.wdm.WebDriverManager;

// public class BookingSteps {
//     protected static WebDriver driver;
//     protected static WebDriverWait wait;

//     @Before
//     public void setUp() {
//         WebDriverManager.chromedriver().setup();
//         driver = new ChromeDriver();
//         driver.manage().window().maximize();
//         wait = new WebDriverWait(driver, 15);
//     }

//     @Given("the user is on the homepage to booking")
//     public void givenUserIsOnHomepage() {
//         String url = "https://bantheme.xyz/hathanhauto/tai-khoan/";
//         driver.get(url);
//         Assert.assertEquals(driver.getCurrentUrl(), url);
//         Utils.hardWait(1000);

//     }

//     @When("user enters email to booking {string}")
//     public void userEnterEmail(String email) {
//         LoginPage loginpage = new LoginPage(driver);
//         loginpage.enterEmail(email);
//         Utils.hardWait(1000);

//     }

//     @When("user enters password to booking {string}")
//     public void userEnterPass(String pass) {
//         LoginPage loginpage = new LoginPage(driver);
//         loginpage.enterPassword(pass);
//         Utils.hardWait(1000);
//     }

//     @When("user submit login to booking")
//     public void userSubmitLogin() {
//         LoginPage loginpage = new LoginPage(driver);
//         loginpage.enterLogin();
//         Utils.hardWait(1000);

//     }

//     public boolean isLogoutDisplayed() {
//         try {
//             HomePage homePage = new HomePage(driver);
//             wait.until(ExpectedConditions.visibilityOfElementLocated(homePage.byLogoutBtn));
//             return true;
//         } catch (Exception e) {
//             return false;
//         }

//     }

//     @Then("verify login successfully to booking {string}")
//     public void verifyLogin(String expectedLogoutDisplay) {
//         boolean expected = Boolean.parseBoolean(expectedLogoutDisplay); // Chuyển đổi string thành boolean
//         boolean logoutBtnDisplayed = isLogoutDisplayed();
//         Assert.assertEquals(logoutBtnDisplayed, expected);
//         Utils.hardWait(1000);
//     }

//     @When("user input seach value to booking {string}")
//     public void userInputValueSeach(String valueSeach) {
//         HomePage homePage = new HomePage(driver);
//         homePage.inputSeach(valueSeach);
//         Utils.hardWait(1000);
//     }

//     @When("user click first result seach to booking")
//     public void userClickFirstResultSeach() {
//         HomePage homePage = new HomePage(driver);
//         homePage.selectFirstSeachResult();
//         Utils.hardWait(1000);

//     }
//     @When("user click xuatxu to booking")
//     public void userClickXuatXu() {
//         DetailProductPage detailProductPage= new DetailProductPage(driver);
//         detailProductPage.enterXuatXu();
//         Utils.hardWait(1000);

//     }
//     @When("user click icon plus to booking")
//     public void userClickIconPlus() {
//         DetailProductPage detailProductPage= new DetailProductPage(driver);
//         detailProductPage.enterIconPlus();
//         Utils.hardWait(1000);
        
//     }
//     @When("user click icon add to booking")
//     public void userClickIconAdd() {
//         DetailProductPage detailProductPage= new DetailProductPage(driver);
//         detailProductPage.enterAdd();
//         Utils.hardWait(1000);
        
//     }
//     @When("user click icon remove produce")
//     public void userClickRemoveProduct() {
//         CardPage cardPage=new CardPage(driver);
//         cardPage.enterRemoveProduct();
//         Utils.hardWait(1000);
        
//     }

//     @After
//     public void tearDown() {
//         if (driver != null) {
//             driver.quit();
//         }
//     }
// }
