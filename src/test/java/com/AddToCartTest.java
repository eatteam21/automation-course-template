package com;

import com.utils.BasicTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;
import pages.PaymentPage;
import pages.ProductPage;

import java.util.List;

public class AddToCartTest extends BasicTest {
    String username="linh@gmail.com";
    String password="Linhbap2911";
    String invalidUsername="linh1@gmail.com";
    String invalidPassword="Linhbap2912";
    @Test()
    public void SearchTest() throws Exception {
        // Launch website
        String url = "https://bantheme.xyz/hathanhauto/tai-khoan/";
        driver.get(url);
        Assert.assertEquals(driver.getCurrentUrl(), url);

        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = new HomePage(driver);
        ProductPage productPage=new ProductPage(driver);
        PaymentPage paymentPage=new PaymentPage(driver);

        // Login
        loginPage.enterEmail(username);
        loginPage.enterPassword(password);
        loginPage.clickLogin();
        Boolean display = homePage.isTrangQLDisplayed();
        Assert.assertTrue(display);

        // Search
        homePage.enterSearch("Mercedes");
        homePage.selectFirstResult();
        // Get product title
        String product_title= productPage.getProduct_title();
        // Select xuất xứ
        productPage.selectCountry("Germany");
        productPage.clickAddBtn();

        // Verify thêm vào giỏ hàng thành công
        String message= paymentPage.getMessage();
        String successMessage="đã được thêm vào giỏ hàng";
        Assert.assertTrue(message.contains(product_title));
        Assert.assertTrue(message.contains(successMessage));
        paymentPage.isTotalCorrect();
    }

}
