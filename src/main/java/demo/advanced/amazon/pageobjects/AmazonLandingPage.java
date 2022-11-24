package demo.advanced.amazon.pageobjects;

import org.openqa.selenium.By;

import demo.advanced.webelements.Button;
import demo.advanced.webelements.TextBox;

public class AmazonLandingPage extends BasePage {

	public TextBox searchBox;
	public Button searchIcon;

	public AmazonLandingPage() {
		searchBox = new TextBox(By.xpath("//input[@id='twotabsearchtextbox']"));
		searchIcon = new Button(By.xpath("//input[@id='nav-search-submit-button']"));
	}
	
	public void search(String textToSearch) {
		searchBox.setText(textToSearch);
		searchIcon.Click();
	}
	
	

}
