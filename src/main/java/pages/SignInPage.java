package pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SignInPage extends BasePage {
    public SignInPage(WebDriver givenDriver) {
        super(givenDriver);
        //TODO Auto-generated constructor stub
    }

    By userLogin= By.id("UserLogin");

    By usernameInput=By.xpath("//input[@name='EmailPhoneDN']");
    By passwordInput = By.xpath("//input[@name='PasswordDN']");
    By loginBtn = By.xpath("//btn[contains(text(),'Đăng nhập')]");

    By loginButton=By.xpath("//button[contains(text(),'Đăng nhập')]");


    public void clickUserLogin(){
        findElementByLocator(userLogin).click();
    }


    public void enterEmail(String txt){
        findElementByLocator(usernameInput).clear();
        findElementByLocator(usernameInput).sendKeys(txt);
    }

    public void enterPassword(String txt){
        findElementByLocator(passwordInput).clear();
        findElementByLocator(passwordInput).sendKeys(txt);
    }

    public void clickLoginBtn(){
        waitForElementClickable(loginBtn);
        findElementByLocator(loginBtn).click();
    }
    public void clickLogin(){
        waitForElementClickable(loginButton);
        findElementByLocator(loginButton).click();
    }

    public String getValidationMessage(){
        return findElementByLocator(passwordInput).getAttribute("validationMessage");
    }
}
