package demo.advanced.tests;

import java.util.*;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import demo.advanced.data.TestGroups;
import demo.advanced.framework.CustomListener;
import demo.advanced.helpers.ExcelHelper;

//@Listeners(CustomListener.class)
public class DemoTests extends BaseTest {

	@Test(priority = 1, groups = TestGroups.DemoGroup)
	public void Test1() {
		System.out.println("Executing Test 1");
		Assert.assertTrue(true);
		System.out.println("Passed Test 1");
	}

	@Test(priority = 2, groups = TestGroups.DemoGroup)
	public void Test2() {
		System.out.println("Executing Test 2");
		Assert.assertTrue(true);
		System.out.println("Passed Test 2");

	}

	@Test(priority = 3, groups = TestGroups.DemoGroup/*
														 * , dataProvider = "getCustomerNameAgeData", dataProviderClass
														 * = demo.advanced.data.DataProviders.class
														 */)
	public void Test3(/* Object[][] data */) {
		System.out.println("Executing Test 3");
//		for (Object c : data) {
//			System.out.println(c);
//		}
		Assert.assertTrue(true);
		System.out.println("Passed Test 3");
	}

	@Test(priority = 4, groups = TestGroups.DemoGroup)
	public void Test4() {
		System.out.println("Executing Test 4");
		Assert.assertTrue(true);
		System.out.println("Passed Test 4");

	}

	@Test(priority = 5, groups = TestGroups.DemoGroup)
	public void Test5() {
		System.out.println("Executing Test 5");
		Map<Integer, Object[]> data = new TreeMap<Integer, Object[]>();
		data.put(1, new Object[] { "ID", "NAME", "LASTNAME" });
		data.put(2, new Object[] { 1, "Amit", "Tripathi" });
		data.put(3, new Object[] { 2, "Lokesh", "Gupta" });
		data.put(4, new Object[] { 3, "John", "Adwards" });
		data.put(5, new Object[] { 4, "Brian", "Schultz" });
		ExcelHelper.writeExcelData(data);
		System.out.println("Passed Test 5");
	}

}
