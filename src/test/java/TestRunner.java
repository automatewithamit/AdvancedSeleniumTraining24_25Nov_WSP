import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;



@CucumberOptions(
		tags = "SmokeTest", 
		features = {"src/test/java/demo/advanced/featurefiles"}, 
		glue = {"src/test/java/demo/advanced/stepdefinitions"},
		plugin = {"html:target/test-report.html"},
		monochrome = true,
		publish = true)
public class TestRunner  extends AbstractTestNGCucumberTests {
	
	
	

}
