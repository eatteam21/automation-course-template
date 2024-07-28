import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.utils.BasicTest;
import pages.SignInPage;

public class SigninTest extends BasicTest {
    @Test()
    public void signInTest() throws Exception {
        // Launch website
        String url = "https://www.ivivu.com/";
        driver.get(url);
        Assert.assertEquals(driver.getCurrentUrl(), url);

        SignInPage signInPage=new SignInPage(driver);
        signInPage.clickUserLogin();
        signInPage.clickLoginBtn();
        signInPage.enterEmail("linh@mail.com");
        signInPage.clickLogin();
        String valationMessage=signInPage.getValidationMessage();
        String expectMessage="Please fill out this field.";
        Assert.assertEquals(valationMessage,expectMessage);
    }

}