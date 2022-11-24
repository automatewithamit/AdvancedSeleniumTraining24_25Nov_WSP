/**
 * 
 */
package demo.advanced.framework;

import java.util.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

/**
 * @author DragonWarrior-PC
 *
 */
public class DriverManager {
	 

	public Properties driverProp;
	public static String highlight;
	public OptionsManager optionsManager = new OptionsManager();
	private static ThreadLocal<WebDriver> localDriverThread = new ThreadLocal<WebDriver>();
//	private static final Logger LOG = Logger.getLogger(DriverManager.class);

	public WebDriver startDriver(Properties driverProp) {
		
		String browserName = driverProp.getProperty("browserName").toLowerCase();
		//String highlight = driverProp.getProperty("highlight").toLowerCase();

		if (browserName.equals("chrome")) {

			if (Boolean.parseBoolean(driverProp.getProperty("remote"))) {
				// remote run
				createRemoteDriver(browserName);
			} else {
				// local run
				WebDriverManager.chromedriver().setup();
				localDriverThread.set(new ChromeDriver(optionsManager.getChromeOptions()));
			}
		} else if (browserName.equals("firefox")) {

			if (Boolean.parseBoolean(driverProp.getProperty("remote"))) {
				// remote run
				createRemoteDriver(browserName);
			} else {
				// local run
				WebDriverManager.firefoxdriver().setup();
				localDriverThread.set(new FirefoxDriver(optionsManager.getFirefoxOptions()));
			}

		} else if (browserName.equals("edge")) {

			if (Boolean.parseBoolean(driverProp.getProperty("remote"))) {
				// remote run
				createRemoteDriver(browserName);
			} else {
				// local run
				WebDriverManager.edgedriver().setup();
				localDriverThread.set(new EdgeDriver(optionsManager.getEdgeOptions()));
			}

		}
		getDriver().manage().deleteAllCookies();

		return getDriver();
	}

	public static WebDriver getDriver() {
		return localDriverThread.get();
	}

	private void createRemoteDriver(String browserName) {
		// TODO Auto-generated method stub

	}

}
