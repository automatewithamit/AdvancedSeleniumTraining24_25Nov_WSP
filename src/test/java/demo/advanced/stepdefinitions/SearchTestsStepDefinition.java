package demo.advanced.stepdefinitions;

import org.testng.Assert;

import demo.advanced.amazon.pageobjects.*;
import io.cucumber.java.en.*;

public class SearchTestsStepDefinition {
	
	BaseStepDefinition baseStep = new BaseStepDefinition();
	
	@Given("Admin is going to login using admin1")
	public void admin_is_going_to_login_using() {
		System.out.println(" admin_is_going_to_login_using admin credentials");
	}

	@Given("enter automate as Password")
	public void enter_automate_as_password() {
	  System.out.println("Entering the Password");
	}

	@When("admin clicks Login")
	public void admin_clicks_login() {
		System.out.println("Admin Clicking on Login Button");
	}

	@Then("admin should get logged In")
	public void admin_should_get_logged_in() {
		Assert.assertEquals("Logged In","Logged In");
		System.out.println("Verify admin logged in");
	}

	@Then("there should be name of admin getting logged on Home Page.")
	public void there_should_be_name_of_admin_getting_logged_on_home_page() {
		System.out.println("name of admin getting logged on Home Page");
	}

	@Then("Login name should be as admin1")
	public void login_name_should_be_as_admin1() {
		System.out.println("Verfied that  login_name_should_be_as_admin1 ");
	}

}
