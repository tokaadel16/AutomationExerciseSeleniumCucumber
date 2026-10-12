package Runners;


import io.cucumber.junit.Cucumber;
import org.junit.runner.RunWith;
import io.cucumber.junit.CucumberOptions;


@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/java/Features", glue = "Steps", plugin = {"pretty", "html:target/reports/report.html"}, monochrome = true)
public class TestRunner {
}
