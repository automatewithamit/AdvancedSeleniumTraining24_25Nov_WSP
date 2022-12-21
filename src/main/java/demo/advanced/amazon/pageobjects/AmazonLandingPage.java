package demo.advanced.amazon.pageobjects;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import demo.advanced.framework.DriverManager;
import demo.advanced.webelements.Button;
import demo.advanced.webelements.Dropdown;
import demo.advanced.webelements.TextBox;

public class AmazonLandingPage extends BasePage {

	public TextBox searchBox;
	public Button searchIcon;
	public Dropdown categoryDropdown;

	public AmazonLandingPage() {
		searchBox = new TextBox(By.xpath("//input[@name='twotabsearchtextbox']"));
		searchIcon = new Button(By.xpath("//input[@id='nav-search-submit-button']"));
		categoryDropdown = new Dropdown(By.cssSelector("#searchDropdownBox"));
	}

	public void search(String textToSearch) {
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		WebElement searchTextBox = DriverManager.getDriver().findElement(By.xpath(getXPath("searchBox")));
		
		searchTextBox.click();
		searchTextBox.sendKeys(textToSearch);
//		searchBox.setText(textToSearch);
//		searchIcon.Click();
	}

	public List<String> getAllCategories() {
		List<String> categoryList = new ArrayList<String>();
		
		categoryDropdown.getAllOptions().forEach(element -> categoryList.add(element.getText()));
		
//		for(WebElement element : categoryDropdown.getAllOptions()) {
//			 categoryList.add(element.getText());
//		}		
		return categoryList;
	}
	
	

}
