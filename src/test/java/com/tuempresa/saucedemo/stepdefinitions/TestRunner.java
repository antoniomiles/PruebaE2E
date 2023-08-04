package com.tuempresa.saucedemo.stepdefinitions;

import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import net.thucydides.core.annotations.Managed;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;


@RunWith(CucumberWithSerenity.class)
@CucumberOptions(features = "src/test/java/com/tuempresa/saucedemo/features",

        glue = "com.tuempresa.saucedemo.stepdefinitions",
        plugin = {"pretty", "html:target/cucumber-reports"})
public class TestRunner {


}
