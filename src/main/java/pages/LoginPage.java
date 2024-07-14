package pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage {
    public LoginPage(WebDriver givenDriver) {
        super(givenDriver);
        //TODO Auto-generated constructor stub
    }

    By usernameInput = By.xpath("//input[@id='username']");
    By passwordInput = By.xpath("//input[@id='password']");
    By loginButton = By.xpath("//button[contains(text(),'Đăng nhập')]");

    By errorMessage=By.className("woocommerce-error");


    public void enterEmail(String txt){
//        this.driver.findElement(usernameInput).sendKeys(txt);
        findElementByLocator(usernameInput).clear();
        findElementByLocator(usernameInput).sendKeys(txt);
    }

    public void enterPassword(String txt){
        findElementByLocator(passwordInput).clear();
        findElementByLocator(passwordInput).sendKeys(txt);
    }


    public void clickLogin(){
        findElementByLocator(loginButton).click();
    }

    public String getErrorMessage(){
        return findElementByLocator(errorMessage).getText();
    }
}
