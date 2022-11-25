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

	@BeforeSuite
	public void BeforeSuite() {
		System.out.println("Before Suite...");
	}

	@BeforeTest
	public void BeforeTest() {
		System.out.println("Before Test...");
	}

	@BeforeGroups
	public void BeforeGroups() {
		System.out.println("Before Groups...");
	}

	@BeforeClass
	public void BeforeClass() {
		System.out.println("Before Class...");
	}

	@BeforeMethod
	public void BeforeMethod() {
		new DriverManager().startDriver(driverProperty);
		// DriverManager.getDriver().navigate().to("https://www.amazon.in");
		System.out.println("Before Method..");
	}

	@AfterMethod
	public void AfterMethod() {
		DriverManager.getDriver().quit();
		System.out.println("After Method..");
	}

	@AfterClass
	public void AfterClass() {
		System.out.println("After Class...");
	}

	@AfterGroups
	public void AfterGroups() {
		System.out.println("After Groups...");
	}

	@AfterTest
	public void AfterTest() {
		System.out.println("After Test...");
	}

	@AfterSuite
	public void AfterSuite() {
		System.out.println("After Suite...");
	}
}
