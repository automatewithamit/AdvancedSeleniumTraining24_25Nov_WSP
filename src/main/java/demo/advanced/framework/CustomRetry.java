package demo.advanced.framework;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;
import org.testng.Reporter;

public class CustomRetry implements IRetryAnalyzer {

	int counter = 0;

	public boolean retry(ITestResult result) {
		String retryLimit = Reporter.getCurrentTestResult().getTestContext().getCurrentXmlTest().getParameter("retry");
		if (counter < Integer.parseInt(retryLimit)) {
			counter++;
			return true;
		}
		return false;
	}

}
