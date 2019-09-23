package com.orangehrm.cucumber;

import org.junit.runner.RunWith;

import com.orangehrm.testbase.TestBase;

import cucumber.api.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(features = "src/test/resources/features/",
plugin = {"pretty", "html:target/cucumber"})
public class OrangeHrmRunner extends TestBase {

}
