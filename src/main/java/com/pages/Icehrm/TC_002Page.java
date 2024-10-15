package com.pages.Icehrm;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.pages.BasePage;
import com.utils.Utils;

public class TC_002Page extends BasePage {

    private By clickEmployees = By.xpath("//ul[@id='admin_Employees']");
    private By btnAddNew = By.xpath("//button[@class='ant-btn ant-btn-primary']");
    private By employeeNumberIpt = By.xpath("//input[@id='employee_id']");
    private By firstNameIpt = By.xpath("//input[@id='first_name']");
    private By middleNameIpt = By.xpath("//input[@id='middle_name']");
    private By lastNameIpt = By.xpath("//input[@id='last_name']");
    private By nationalityIpt = By.xpath("(//input[@class='ant-select-selection-search-input'])[1]");
    private By DateofBirthIpt = By.xpath("//input[@id='birthday']");
    private By genderIpt = By.xpath("//input[@id='rc_select_1']");//(//input[@class='ant-select-selection-search-input'])[2]
    private By maritalStatusIpt = By.xpath("(//input[@class='ant-select-selection-search-input'])[3]");
    private By ethnicityIpt = By.xpath("(//input[@class='ant-select-selection-search-input'])[4]"); 
    private By ImmigrationStatuIpt = By.xpath("(//input[@class='ant-select-selection-search-input'])[5]"); 
    private By employmentStatusIpt = By.xpath("(//input[@class='ant-select-selection-search-input'])[6]"); 
    private By departmentIpt = By.xpath("(//input[@class='ant-select-selection-search-input'])[7]"); 
    private By jobTitleIpt = By.xpath("(//input[@class='ant-select-selection-search-input'])[8]"); 
    private By joinedDateIpt = By.xpath("(//input[@class='ant-select-selection-search-input'])[9]");
    private By countryIpt = By.xpath("(//input[@class='ant-select-selection-search-input'])[10]");
    private By nextBtn = By.xpath("(//button[@class='ant-btn ant-btn-primary'])[2]");
    private By saveBtn = By.xpath("(//button[@class='ant-btn ant-btn-primary'])[3]");
    
    public TC_002Page(WebDriver driver) { //constructors
        super(driver); //syntax
    }

    public void clickEmployess(String name) {
        By clickEmployes = By.partialLinkText(name);
        waitForElementVisible(clickEmployes);
        findElementByLocator(clickEmployes).click();
        findElementByLocator(clickEmployees).click();

    }

    public void clickAddNew(){
        waitForElementClickable(btnAddNew);
        findElementByLocator(btnAddNew).isDisplayed();
        findElementByLocator(btnAddNew).click();
    }

    public void addEmployeeNumber(String name){
        waitForElementVisible(employeeNumberIpt);
        findElementByLocator(employeeNumberIpt).sendKeys(name);
    }

    public void addFirstName(String name){
        waitForElementVisible(firstNameIpt);
        findElementByLocator(firstNameIpt).sendKeys(name);
    }

    public void addMiddleName(String name){
        waitForElementVisible(middleNameIpt);
        findElementByLocator(middleNameIpt).sendKeys(name);
    }

    public void addLastName(String name){
        waitForElementVisible(lastNameIpt);
        findElementByLocator(lastNameIpt).sendKeys(name);
    }

    public void addNationnality(String name){
        waitForElementVisible(nationalityIpt);
        Utils.hardWait();
        findElementByLocator(nationalityIpt).click();
        Utils.hardWait();
        String locator = "//div[@class='rc-virtual-list']//div[@title='Vietnamese']";
        By element = By.xpath(locator);
        findElementByLocator(nationalityIpt).sendKeys(name);
        Utils.hardWait();
        findElementByLocator(element).click();
        // WebElement inputElement = findElementByLocator(nationalityIpt);
        // // findElementByLocator(nationalityIpt).sendKeys(name);
        // // findElementByLocator(nationalityIpt).sendKeys(Keys.ENTER);
        // Actions actions = new Actions(driver);
        // actions.click(findElementByLocator(nationalityIpt))
        //        .sendKeys(name)
        //        .click(element)
        //        .build()
        //        .perform();
        
    }

    public void addDateOfBirth(String name){
        waitForElementVisible(DateofBirthIpt);
        findElementByLocator(DateofBirthIpt).sendKeys(name);
        String locator = "//table[@class='ant-picker-content']";
        By element = By.xpath(locator);
        waitForElementVisible(element);
        findElementByLocator(element).click();
        
    }

    public void addGender(String name){
        waitForElementVisible(genderIpt);
        findElementByLocator(genderIpt).click();
        String locator = "//div[@class='rc-virtual-list']//div[@title='" + name +"']";
        By element = By.xpath(locator);
        // findElementByLocator(genderIpt).sendKeys(name);
        findElementByLocator(element).click();
        // Actions actions = new Actions(driver);
        // actions.click(findElementByLocator(genderIpt))
        //        .sendKeys(name)
        //        .click(findElementByLocator(element))
        //        .build()
        //        .perform();
    }

    public void addMaritalStatus(String name){
        waitForElementVisible(maritalStatusIpt);
        findElementByLocator(maritalStatusIpt).click();
        String locator = "//div[@class='rc-virtual-list']//div[@title='" + name +"']";
        By element = By.xpath(locator);
        findElementByLocator(element).click();
    }

    public void addEthnicity(String name){
        waitForElementVisible(genderIpt);
        findElementByLocator(genderIpt).sendKeys(name);
    }

    public void clickNext(){
        waitForElementVisible(nextBtn);
        findElementByLocator(nextBtn).click();
    }

    public void addEmploymentStatus(String name){
        waitForElementVisible(employmentStatusIpt);
        findElementByLocator(employmentStatusIpt).sendKeys(name);
    }

    public void addDepartment(String name){
        waitForElementVisible(departmentIpt);
        findElementByLocator(departmentIpt).sendKeys(name);
    }

    public void addJobTitle(String name){
        waitForElementVisible(jobTitleIpt);
        findElementByLocator(jobTitleIpt).sendKeys(name);
    }
    
    public void addJoinedDate(String name){
        waitForElementVisible(joinedDateIpt);
        // String locator = String locator = "//*[contains(text(),'" + monthYear + "')]/../../..//*[contains(text(),'" + day + "')]";
        // By element = By.xpath(locator);
        // waitForElementVisible(element);
        findElementByLocator(joinedDateIpt).sendKeys(name);;
    }

    public void addCountry(String name){
        waitForElementVisible(countryIpt);
        findElementByLocator(countryIpt).sendKeys(name);
    }

    public void clickSaveButton(){
        waitForElementVisible(saveBtn);
        findElementByLocator(saveBtn).click();
    }

}