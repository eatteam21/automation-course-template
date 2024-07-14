package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class RegisterPage extends BasePage {
    public RegisterPage(WebDriver givenDriver) {
        super(givenDriver);
        //TODO Auto-generated constructor stub
    }

    By usernameInput = By.xpath("//input[@id='reg_email']");
    By passwordInput = By.xpath("//input[@id='reg_password']");
    By registerButton = By.xpath("//button[contains(text(),'Đăng ký')]");

    By errorMessage=By.className("woocommerce-error");
    By passError=By.xpath("//div[contains(text(),'Vui lòng nhập mật khẩu khó hơn')]");


    public void enterRegEmail(String txt){
//        this.driver.findElement(usernameInput).sendKeys(txt);
        waitForElementVisible(usernameInput);
        findElementByLocator(usernameInput).clear();
        findElementByLocator(usernameInput).sendKeys(txt);
    }

    public void enterRegPassword(String txt){
        waitForElementVisible(passwordInput);
        findElementByLocator(passwordInput).clear();
        findElementByLocator(passwordInput).sendKeys(txt);
    }


    public void clickRegister(){
        findElementByLocator(registerButton).click();
    }

    public String getErrorMessage(){
        return findElementByLocator(errorMessage).getText();
    }
    public boolean passErrorMessage(){
        return findElementByLocator(passError).isDisplayed();
    }
}
