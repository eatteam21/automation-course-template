package com.pages.Tiki;

import java.util.List;
import java.util.NoSuchElementException;

import org.apache.logging.log4j.core.util.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.pages.BasePage;
import com.utils.Utils;

public class TC_01Page extends BasePage {

    private By searchIpt = By.xpath("//input[@class='styles__InputRevamp-sc-6cbqeh-2 IXqBC']");
    private By findBtn = By.xpath("//button[@data-view-id='main_search_form_button']");
    private By textBreadcrumb = By.xpath("//div[@class='breadcrumb']");
    private By gridProduct = By.xpath("//div[@class='content']");
    private By nameOfProduct = By.xpath("//h1[@class='Title__TitledStyled-sc-c64ni5-0 iXccQY']");

    public TC_01Page(WebDriver givenDriver) {
        super(givenDriver);
        // TODO Auto-generated constructor stub
    }

    public boolean searchIsDisplayed() {
        waitForElementVisible(searchIpt);
        waitForElementClickable(findBtn);
        return findElementByLocator(searchIpt).isDisplayed() && findElementByLocator(findBtn).isDisplayed();

    }

    public void searchInput(String name) {
        waitForElementVisible(searchIpt);
        findElementByLocator(searchIpt).sendKeys(name);
    }

    public void clickFindButton() {
        waitForElementClickable(findBtn);
        findElementByLocator(findBtn).click();

    }

    public boolean breadcrumbIsDisplay() {
        waitForElementVisible(textBreadcrumb);
        return findElementByLocator(textBreadcrumb).isDisplayed();
    }

    public void findPhoneByName(String name) {
        waitForElementVisible(gridProduct);

        // Tìm tất cả sản phẩm trong lưới
        List<WebElement> products = driver.findElements(gridProduct);

        // Lặp qua từng sản phẩm và so sánh tên (không phân biệt chữ hoa chữ thường)
        for (WebElement product : products) {
            String productName = product.findElement(By.tagName("h3")).getText(); // Điều chỉnh selector nếu cần
            if (name.equalsIgnoreCase(productName)) {
                product.click();
                System.out.println("Tên: " + name);
                Utils.hardWait();
                return; // Thoát vòng lặp sau khi tìm thấy sản phẩm phù hợp
            }
        }

        // Nếu không tìm thấy sản phẩm, ném ngoại lệ hoặc xử lý phù hợp
        throw new NoSuchElementException("Phone with name '" + name + "' not found");
    }

    public void Phone(String name) {
        findPhoneByName(name);
    }

    public String nameOfProduct() {
        waitForElementVisible(nameOfProduct);
        return findElementByLocator(nameOfProduct).getText();
    }

}
