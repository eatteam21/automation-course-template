package com.pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
public class IvivuLoginPage extends BasePage {
    public IvivuLoginPage(WebDriver givenDriver){
        super(givenDriver);
    }
    By emailInput = By.xpath("//input[@name ='EmailPhoneDN']");
    By passwordInput = By.xpath("//input[@name='PasswordDN']");
    By loginButton = By.xpath("//button[contains(text(),'Đăng nhập')]");
    By usernameCheck = By.xpath("//span[contains(text(),'tetakok687@lucvucom')]");
    By usernameClick = By.xpath("//a[@class='dropdown-toggle']//div[@class='img-wrapper']");
    By firstLogin = By.xpath("//ul[@role='menu']//btn[@type='button'][contains(text(),'Đăng nhập')]");
    public void usernameClick(){
        findElementByLocator(usernameClick).click();
    }
    public void enterEmail(String txt){
        findElementByLocator(emailInput).clear();
        findElementByLocator(emailInput).sendKeys(txt);
    }
    public void enterPassword(String txt){
        findElementByLocator(passwordInput).clear();
        findElementByLocator(passwordInput).sendKeys(txt);
    }
    public void firstLogin(){
        findElementByLocator(firstLogin).click();
    }
    public void clickLogin(){
        findElementByLocator(loginButton).click();
    }
    public WebElement usernameCheck(){
        return findElementByLocator(usernameCheck);
    }
}
