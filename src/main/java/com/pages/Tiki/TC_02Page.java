package com.pages.Tiki;

import java.util.List;
import java.util.NoSuchElementException;

import org.apache.logging.log4j.core.util.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.pages.BasePage;
import com.utils.Utils;

public class TC_02Page extends BasePage {

    private By categoryTable = By.xpath("//div[@class='styles__StyledSideBar-sc-s7dkhn-0 jZosWU']");
    private By exploreCategories = By.xpath("//div[@class='styles__SubCatesContainer-sc-rb1auh-0 ixlXIm']");
    private By textBreadcrumb = By.xpath("//div[@class='breadcrumb']");
    private By allBtn = By.xpath("//button[@class='styles__StyledButton-sc-kqbl3f-0 bQYwcw']");
    private By allFilter = By.xpath("//div[@class='styles__StyledPopupContent-sc-1fz54eb-4 bTgOnH']");
    public TC_02Page(WebDriver givenDriver) {
        super(givenDriver);
        // TODO Auto-generated constructor stub
    }

    public void findCategoryByName(String name){
        waitForElementVisible(categoryTable);
        String locator = "//*[contains(text(),'" + name +"')]";
        By element = By.xpath(locator);
        findElementByLocator(element).click();
    }

    public void findExploreCategoriesByName(String name){
        waitForElementVisible(exploreCategories);
        String locator = "//*[contains(text(),'" + name +"')]";
        By element = By.xpath(locator);
        findElementByLocator(element).click();
    }

    public void findExploreCategories(String name){
        waitForElementVisible(exploreCategories);
        String locator = "//*[contains(text(),'" + name +"')]";
        By element = By.xpath(locator);
        findElementByLocator(element).click();
    }

    public boolean textBreadcrumbIsDisplayed(){
        waitForElementVisible(textBreadcrumb);
        findElementByLocator(textBreadcrumb).getText();
        return findElementByLocator(textBreadcrumb).isDisplayed();
    }

    public boolean allBtnIsDisplayed(){
        waitForElementVisible(allBtn);
        return findElementByLocator(allBtn).isDisplayed();
    }

    public void allBtn(){
        waitForElementVisible(allBtn);
        findElementByLocator(allBtn).click();
    }

    public void chooseAllFilter(String name){
        waitForElementVisible(allFilter);
        String locator = "//div[@class='styles__StyledPopupContent-sc-1fz54eb-4 bTgOnH']//*[contains(text(),'" + name +"')]";
        By element = By.xpath(locator);
        findElementByLocator(element).click();
    }

    public void chooseSupplier(String name){
        waitForElementVisible(allFilter);
        String locator = "//div[@class='styles__StyledPopupContent-sc-1fz54eb-4 bTgOnH']//*[contains(text(),'" + name +"')]";
        By element = By.xpath(locator);
        findElementByLocator(element).click();
    }

}
