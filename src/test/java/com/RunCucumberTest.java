package com;


import io.cucumber.testng.CucumberOptions;
import io.cucumber.testng.AbstractTestNGCucumberTests;


@CucumberOptions(
        features = "src/test/resources/features",
        monochrome = true,
        tags = "not @Ignore",
        glue = "com.steps",
        plugin = {
                "pretty",
                "html:target/cucumber-reports/cucumber.html" ,
                "json:target/cucumber-reports/cucumber.json" ,
        }
)
public class RunCucumberTest extends AbstractTestNGCucumberTests{
    
}
