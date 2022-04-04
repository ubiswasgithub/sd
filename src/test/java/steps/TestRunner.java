package steps;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features="src/test/resources/features", glue={"steps"}, 
//tags ="@smoke",
//tags = "@toolbox",
monochrome = true,  plugin = {
        "pretty",
        "json:target/cucumber-report/cucumber.json",
        "junit:target/cucumber-report/cucumber.xml",
        "html:target/cucumber-report/cucumber.html"})
public class TestRunner {

}
