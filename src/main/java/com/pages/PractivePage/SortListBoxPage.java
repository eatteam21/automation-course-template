package com.pages.PractivePage;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.pages.BasePage;


public class SortListBoxPage extends BasePage {

    
    //private By slideSide = By.xpath("//div[contains(@class,'c_sub_row')]");
    // private By closeButton = By.xpath("null")
    @FindBy(xpath = "//select[@name='orderby']")
    private WebElement SortListBox;
    
    Select select = new Select(SortListBox);
   
    public SortListBoxPage(WebDriver givenDriver) {
        super(givenDriver);
        
    }
    
    public void clickSort(){
        waitForElementClickable2(SortListBox);
        SortListBox.click();
    }

    public void selectDropDown(String name){
        waitForElementClickable2(SortListBox);
        select.selectByValue(name);
    }
    
    public Boolean verifySelectDropDown(String name){
        Boolean result = true;
        String selectOption = select.getFirstSelectedOption().getText();
        if(selectOption.equals(name)){
            return result;
        }else{
            result = false;
        }
        return result;
    }
    
    
}

