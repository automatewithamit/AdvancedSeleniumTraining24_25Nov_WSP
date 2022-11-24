package demo.advanced.tests;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import org.testng.annotations.*;

import demo.advanced.amazon.pageobjects.AmazonLandingPage;
import demo.advanced.amazon.pageobjects.SearchResultPage;
import demo.advanced.framework.DriverManager;

public class BaseTest {

	public Properties driverProperty;
	FileInputStream fis;
	public AmazonLandingPage landingPage;
	public SearchResultPage searchResultPage;

	public BaseTest() {

		landingPage = new AmazonLandingPage();
		searchResultPage = new SearchResultPage();
		loadPropertyFile();
	}

	private void loadPropertyFile() {
		try {
			String dir = System.getProperty("user.dir");
			fis = new FileInputStream(dir + "\\resources\\configs\\config.properties");
			driverProperty = new Properties();
			driverProperty.load(fis);

		} catch (FileNotFoundException e) {
			System.out.println("File not Found");
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("Error while reading the File");
			e.printStackTrace();
		}
	}

	@BeforeMethod
	public void BeforeMethod() {
		new DriverManager().startDriver(driverProperty);
		DriverManager.getDriver().navigate().to("https://www.amazon.in");
	}

	@AfterMethod
	public void AfterMethod() {
		DriverManager.getDriver().quit();
	}

}
