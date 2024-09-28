package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class BookingPage extends BasePage {

    By loginBtn = By.xpath("//button[@name=\"login\"]");
    By emailInp = By.xpath("//input[@id='username']");
    By passwordInp = By.xpath("//input[@id='password']");
    //By errorText = By.xpath("//ul[@class='woocommerce-error']");
    //By errorText = By.xpath("//div[@class='woocommerce-MyAccount-content']");
    // Verify booking successfully
    //String Message2 = driver.findElement(By.xpath("//div[@class='woocommerce-message']")).getText();
    By successText = By.xpath("//div[@class='woocommerce-message']");
    
    By productInp = By.xpath("(//input[@class='form-control js-typeahead tt-input'])[1]");
    By productLink = By.xpath("//a[@title='Bơm nước xe Mercedes SLK200, SLK300, GLK200, E260, C350-2742000207']");

    By optionDDL = By.xpath("//select[@id='pa_xuat-xu']");
    By option1 = By.xpath("//option[@value='england']");
    By cartBtn = By.xpath("//button[@class='single_add_to_cart_button button alt']");



    public BookingPage(WebDriver givenDriver) {
        super(givenDriver);
        //TODO Auto-generated constructor stub
    }

    public void inputProduct(String product) {
        findElementByLocator(productInp).sendKeys(product);
        findElementByLocator(productInp).sendKeys(Keys.ENTER);
    }

    public void selectOption() {

        //Select product
        findElementByLocator(productLink).click();

        //Select option in DDL
        findElementByLocator(optionDDL).click();
        findElementByLocator(option1).click();
        findElementByLocator(cartBtn).click();
    }

    public String getSuccessMessage() {
        return driver1.findElement(successText).getText();
    }

    
}
