package pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends BasePage {
    public HomePage(WebDriver givenDriver) {
        super(givenDriver);
        //TODO Auto-generated constructor stub
    }

    By trangql = By.xpath("//p[contains(text(),'Từ trang quản lý tài khoản bạn có thể xem')]");
    By search=By.xpath("//input[@id='s']");

    By result=By.className("tt-selectable");
    public Boolean isTrangQLDisplayed(){
        return findElementByLocator(trangql).isDisplayed();
    }

    public void enterSearch(String txt){
        findElementByLocator(search).clear();
        findElementByLocator(search).sendKeys(txt);
    }

    public void selectFirstResult(){
        waitForElementClickable(result);
        findElementByLocator(result).click();
    }

}
