package com.pages.RevReply;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.pages.BasePage;
import com.utils.Utils;

public class AddPage extends BasePage {

    private By addButton = By.xpath("//button[contains(@class,'justify-center')]");
    private By profileConfigButton = By.xpath("//button[@id='button-0']") ;
    private By firstNameInput = By.xpath("//input[@name='first_name']");
    private By lastNameInput = By.xpath("//input[@name='last_name']");
    private By companyInput = By.xpath("//input[@name='company']");
    private By company_urlInput = By.xpath("//input[@name='company_url']");
    private By companyOverViewInput = By.xpath("//button[contains(@class,'align-bottom')]");
    private By updateButton = By.xpath("//button[contains(@class,'inline-flex')]");

    public AddPage(WebDriver givenDriver) {
        super(givenDriver);
        
    }
    
    public void clickAdd(){
        waitForElementClickable(addButton);
        findElementByLocator(addButton).click();
        
    }
    
    public void clickProfileConfig(){ 
        waitForElementVisible(profileConfigButton);
        findElementByLocator(profileConfigButton).click();
        
    }

    public void fillFirstName(String firstName){
        waitForElementVisible(firstNameInput);
        findElementByLocator(firstNameInput).sendKeys(firstName);

    }

    public void fillLastName(String lastName){
        waitForElementVisible(lastNameInput);
        findElementByLocator(firstNameInput).sendKeys(lastName);

    }

    public void fillCompany(String company){
        waitForElementVisible(companyInput);
        findElementByLocator(companyInput).sendKeys(company);

    }

    public void fillCompanyUrl(String companyUrl){
        waitForElementVisible(company_urlInput);
        findElementByLocator(company_urlInput).sendKeys(companyUrl);
    }

    public void fillCompanyOverView(){
        waitForElementVisible(companyOverViewInput);
        findElementByLocator(companyOverViewInput).click();

    }

    public void clickUpdate(){
        waitForElementVisible(updateButton);
        findElementByLocator(updateButton).click();

    }
    
}
