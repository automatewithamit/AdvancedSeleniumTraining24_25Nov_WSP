package demo.advanced.framework;

import org.testng.ITestListener;
import org.testng.ITestResult;

import demo.advanced.helpers.Helper;

public class CustomListener implements ITestListener {

	/**
	 * Invoked each time a test fails.
	 *
	 * @param result <code>ITestResult</code> containing information about the run
	 *               test
	 * @see ITestResult#FAILURE
	 */

	@Override
	public void onTestFailure(ITestResult result) {
		System.out.println("FAILED ::");
		Helper.takeScreenshots(result.getMethod().getMethodName());
		// Helper.takeFullDesktopScreenshot(result.getMethod().getMethodName());
	}

}
