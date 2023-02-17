package demo.advanced.runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = { "src/test/java/demo/advanced/featurefiles" },
glue = {"demo.advanced.stepdefinitions" }, plugin = { "html: target/test-report.html" }, monochrome = true, publish = true)

public class TestRunner extends AbstractTestNGCucumberTests {
//Comments added again
}