package demo.advanced.tests;

import java.util.Map;
import java.util.TreeMap;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import demo.advanced.data.*;
import demo.advanced.framework.CustomListener;
import demo.advanced.helpers.ExcelHelper;

public class AmazonTest extends BaseTest {

	@Test(groups = TestGroups.AmazonSearch)
	public void AppleMobileSearch() {
		String expectedText = "Apple iPhone";
		landingPage.search("Apple Mobiles");
		String actualSearchedResult = searchResultPage.firstSearchResultFromSearchedText();
		Assert.assertTrue(actualSearchedResult.contains(expectedText),
				"Actual Text '" + actualSearchedResult + " 'does not Contains Expected Text '" + expectedText + "'");
		System.out.println("Actual Text '" + actualSearchedResult + " '\nExpected Text '" + expectedText + "'");
		Assert.assertTrue(true);
	}

	@Test(groups = TestGroups.AmazonSearch)
	public void WriteMobileNamesInExcel() {
		landingPage.search("Apple Mobiles");
		Map<Integer, Object[]> data = new TreeMap<Integer, Object[]>();

		Integer counter = 1;
		for (String mobile : searchResultPage.getSearchResults()) {
			data.put( counter , new Object[] { mobile });
			counter++;
		}
		ExcelHelper.writeExcelData(data);
		Assert.assertTrue(true);
	}

}
