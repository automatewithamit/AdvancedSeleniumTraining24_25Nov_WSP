package demo.advanced.framework;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class CustomRetry implements IRetryAnalyzer {

	int counter = 0;
	int retryLimit = 3;
	public boolean retry(ITestResult result) {
		
		//String retryLimit = Reporter.getCurrentTestResult().getTestContext().getCurrentXmlTest().getParameter("retry");
		if (counter < retryLimit) {
			counter++;
			return true;
		}
		return false;
	}

}
