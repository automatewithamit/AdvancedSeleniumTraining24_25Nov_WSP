package demo.advanced.tests;

import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

public class AmazonSearchTests extends BaseTest {
	
	
	@Test
	public void ExcelXPathTest() {

		try {
			String expectedText = "Apple iPhone";
			landingPage.search("Apple Mobiles");

		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {

		}

	}

	@Test
	public void verifyCategories() {

		List<String> categories = landingPage.getAllCategories();

		categories.forEach(category -> System.out.println(category));

	}

}
