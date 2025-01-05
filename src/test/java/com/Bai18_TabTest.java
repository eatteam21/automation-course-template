package com;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.utils.Utils;
import com.utils.BasicTest;


public class Bai18_TabTest extends BasicTest {
    @Test()
    public void tabTest() throws Exception {
       // Launch website
    String url = "https://bantheme.xyz/hathanhauto/tai-khoan/";
    driver.get(url);
    Assert.assertEquals(driver.getCurrentUrl(), url);

    // Login
    Bai16_LoginTest login = new Bai16_LoginTest();
    login.loginTestSuccess();

    // Open new tab and Navigate to the new URL
    ((JavascriptExecutor) driver).executeScript("window.open()");
    String newWindowHandle = driver.getWindowHandles().stream().skip(1).findFirst().orElse(null);
    driver.switchTo().window(newWindowHandle);
    driver.get("https://bantheme.xyz/hathanhauto");

    //fetch handles of all windows, there will be two, [0]- default, [1] - new window
    Object[] windowHandles=driver.getWindowHandles().toArray();
    driver.switchTo().window((String) windowHandles[0]);

    // Close the old tab and switch back to the new tab
    String originalWindowHandle = driver.getWindowHandle();
    driver.switchTo().window(originalWindowHandle);
    driver.switchTo().window((String) windowHandles[0]);
    Utils.hardWait(2000);
    driver.close();
    Utils.hardWait(2000);
    driver.switchTo().window((String) windowHandles[1]);

    // Login in new tab
    WebElement elementToHover = driver.findElement(By.xpath("//strong[contains(text(), 'Đăng nhập')]"));
    Actions action = new Actions(driver);
    action.moveToElement(elementToHover).build().perform();
    WebElement loginAgain = driver.findElement(By.xpath("//a[contains(text(), 'Đăng nhập')]"));
    loginAgain.click();
    Utils.hardWait(2000);
    // Verify user is still logged in
    WebElement accountName = driver.findElement(By.xpath("(//strong[contains(text(), 'nhanvip124')][1])"));
    Assert.assertEquals(accountName.getText(), "nhanvip124");
    // Search with keyword "merc"
    WebElement searchInput = driver.findElement(By.xpath("(//input[@id = 's'])[1]"));
    searchInput.sendKeys("merc");
    Utils.hardWait();
    // Select the first result "Bơm nước xe"
    WebElement result = driver.findElement(By.xpath("//a[contains(text(),'Bơm nước xe')]"));
    result.click();
    // Select option "England"
    WebElement select = driver.findElement(By.xpath("//select[@id='pa_xuat-xu']"));
    select.click();
    WebElement option = driver.findElement(By.xpath("//option[@value='england']"));
    option.click();
    Utils.hardWait(1000);
    // Click "Thêm vào giỏ hàng" button
    WebElement addToCartAgain = driver.findElement(By.xpath("(//button[@type = 'submit'])[2]"));
    addToCartAgain.click();
    Utils.hardWait(1000);
}
}
