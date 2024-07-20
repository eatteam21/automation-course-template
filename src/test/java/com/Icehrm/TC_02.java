package com.Icehrm;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.mongodb.util.Util;
import com.pages.Icehrm.TC_001;
import com.pages.Icehrm.TC_002;
import com.utils.BasicTest;
import com.utils.Utils;

public class TC_02 extends BasicTest {

    @Test(enabled = true)
    public void loginTestSuccess() throws Exception {
        // Launch website
        String url = "https://icehrm-open.gamonoid.com/login.php#";
        driver.get(url);
        Assert.assertEquals(driver.getCurrentUrl(), url);


        TC_001 TC_001 = new TC_001(driver);
        TC_002 TC_002 = new TC_002(driver);
        TC_001.inputEmail("admin");
        TC_001.inputPass("admin");
        TC_001.clickLogin();
        Assert.assertEquals(driver.getCurrentUrl(), "https://icehrm-open.gamonoid.com/?g=admin&n=dashboard&m=admin_Admin");
        TC_002.clickEmployess("Employees");
        Assert.assertEquals(driver.getCurrentUrl(), "https://icehrm-open.gamonoid.com/?g=admin&n=employees&m=admin_Employees");
        TC_002.clickAddNew();
        TC_002.addEmployeeNumber("123");
        TC_002.addFirstName("a");
        TC_002.addLastName("a");
        TC_002.addNationnality("Vietnamese");
        TC_002.addDateOfBirth("2024-03-26");
        TC_002.addGender("Male");
        TC_002.addMaritalStatus("Single");
        TC_002.clickNext();
        TC_002.addEmploymentStatus("Full Time Contract");
        TC_002.addDepartment("QA Team");
        TC_002.addJobTitle("Software Engineer");
        TC_002.addJoinedDate("2024-07-01");
        TC_002.addCountry("Viet Nam");
        TC_002.clickSaveButton();
    }



}
