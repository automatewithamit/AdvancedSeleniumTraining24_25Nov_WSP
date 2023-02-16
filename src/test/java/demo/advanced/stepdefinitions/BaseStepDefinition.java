package demo.advanced.stepdefinitions;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import demo.advanced.amazon.pageobjects.AmazonLandingPage;
import demo.advanced.amazon.pageobjects.SearchResultPage;
import demo.advanced.framework.DriverManager;
import io.cucumber.java.After;
import io.cucumber.java.Before;

public class BaseStepDefinition {

	public BaseStepDefinition() {
		landingPage = new AmazonLandingPage();
		searchResultPage = new SearchResultPage();
		loadPropertyFile();
	}
	
	public Properties driverProperty;
	FileInputStream fis;
	public AmazonLandingPage landingPage;
	public SearchResultPage searchResultPage;
	
	@Before
	public void BeforeMethod() {
		System.out.println("Before coming from Cucumber");
		new DriverManager().startDriver(driverProperty);
		DriverManager.getDriver().navigate().to("https://www.amazon.in");
		System.out.println("Before Method..");
	}

	@After
	public void AfterMethod() {
		System.out.println("After coming from Cucumber");
		DriverManager.getDriver().quit();
		System.out.println("After Method..");
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
}
