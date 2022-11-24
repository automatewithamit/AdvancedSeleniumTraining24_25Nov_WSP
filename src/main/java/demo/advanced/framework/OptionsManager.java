package demo.advanced.framework;

import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;

public class OptionsManager {

	// Get Chrome Options
	public ChromeOptions getChromeOptions() {
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--start-maximized");
		options.addArguments("--ignore-certificate-errors");
		options.addArguments("--disable-popup-blocking");
		// options.addArguments("--incognito");
		return options;
	}

	// Get Firefox Options
	public FirefoxOptions getFirefoxOptions() {
		FirefoxOptions options = new FirefoxOptions();
		// Write Firefox related code here
		return options;
	}
	// Get Edge Options 
		public EdgeOptions getEdgeOptions() {
			EdgeOptions options = new EdgeOptions();
			// Write EdgeOptions related code here
			return options;
		}

}
