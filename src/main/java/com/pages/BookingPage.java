package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class BookingPage extends BasePage {

    By loginBtn = By.xpath("//button[@name=\"login\"]");
    By emailInp = By.xpath("//input[@id='username']");
    By passwordInp = By.xpath("//input[@id='password']");
    By errorText = By.xpath("//ul[@class='woocommerce-error']");
    By productInp = By.xpath("(//input[@class='form-control js-typeahead tt-input'])[1]");


    public BookingPage(WebDriver givenDriver) {
        super(givenDriver);
        //TODO Auto-generated constructor stub
    }

    // public void clickLoginBtn() {
    //     // driver.findElement(By.xpath("//button[@name=\"login\"]")).click();
    //     findElementByLocator(loginBtn).click();
    // }

    // public void inputEmail(String email) {
    //     //driver.findElement(emailInp).sendKeys(email);
    //     findElementByLocator(emailInp).sendKeys(email);
    // }

    // public void inputPassword(String password) {
    //     driver1.findElement(passwordInp).sendKeys(password);
    // }

    // public String getErrorMessage() {
    //     return driver1.findElement(errorText).getText();
    // }

    public void inputProduct(String product) {
        findElementByLocator(productInp).sendKeys(product);
    }

    public void selectOption(String product) {

        //Select product
        driver1.findElement(By.xpath("//a[@title='Bơm nước xe Mercedes SLK200, SLK300, GLK200, E260, C350-2742000207']")).click();

        //Select option in DDL
        driver1.findElement(By.xpath("//select[@id='pa_xuat-xu']")).click();
        driver1.findElement(By.xpath("//option[@value='england']")).click();
        driver1.findElement(By.xpath("//button[@class='single_add_to_cart_button button alt']")).click();


    }

    
}
