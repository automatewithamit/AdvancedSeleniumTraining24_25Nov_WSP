package demo.advanced.webelements;

import java.util.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import demo.advanced.framework.DriverManager;

public class Label {
	private By locator;
	// WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(),
	// Duration.ofSeconds(DataHelper.TimeOut10));

	public Label(By locator) {
		this.locator = locator;
	}

	public void click() {
		// wait.until(ExpectedConditions.elementToBeClickable(locator));
		WebElement element = DriverManager.getDriver().findElement(locator);
		element.click();
	}

	public String getText() {
		// wait.until(ExpectedConditions.elementToBeClickable(locator));
		WebElement element = DriverManager.getDriver().findElement(locator);
		return element.getText();
	}

	public List<String> getTexts() {
		// wait.until(ExpectedConditions.elementToBeClickable(locator));
		List<String> elementTextList = new ArrayList<String>();
		List<WebElement> elements = DriverManager.getDriver().findElements(locator);
		for (WebElement element : elements) {
			elementTextList.add(element.getText());
		}
		return elementTextList;
	}

}
