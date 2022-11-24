package demo.advanced.amazon.pageobjects;

import java.util.List;

import org.openqa.selenium.By;

import demo.advanced.webelements.Label;

public class SearchResultPage {

	public Label searchResult;

	public SearchResultPage() {
		searchResult = new Label(By.xpath(
				"//span[.='RESULTS']/ancestor::div[contains(@class,'s-result-item')]/following-sibling::div//h2//span"));

	}

	public String firstSearchResultFromSearchedText() {
		return searchResult.getText();
	}

	public List<String> getSearchResults() {
		return searchResult.getTexts();
	}
}
