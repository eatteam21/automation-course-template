package com;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
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
public class RunCucumberTest {
    
}