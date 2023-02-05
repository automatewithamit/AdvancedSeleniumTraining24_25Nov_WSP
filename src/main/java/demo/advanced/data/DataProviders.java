package demo.advanced.data;

import org.testng.annotations.DataProvider;

public class DataProviders {

//	@DataProvider(name = "getCustomerNameAgeData")
//	public static Object[][] getCustomerNameAgeData() {
//
//		return new Object[][] { { new Customer("Amit Tripathi", 29), "Automation" },
//				{ new Customer("Joe Biden", 30), "Developer" }, { new Customer("Atul Singh", 34), "QA" },
//				{ new Customer("Piyush Saxena", 26), "Developer" } };
//	}
//	
//	@DataProvider(name = "getConfiguration")
//	public Object[][] getConfiguration() {
//		String configuration = "This is Configurations";
//		return new Object[] { configuration };
//	}

}

class Customer {

	String customerName;
	Integer customerAge;

	public Customer(String cName, Integer cAge) {
		this.customerName = cName;
		this.customerAge = cAge;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public Integer getCustomerAge() {
		return customerAge;
	}

	public void setCustomerAge(Integer customerAge) {
		this.customerAge = customerAge;
	}

}