package demo.advanced.webelements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import demo.advanced.framework.DriverManager;
import demo.advanced.interfaces.IButton;

public class Button implements IButton {
	private By locator;
	// WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(),
	// Duration.ofSeconds(DataHelper.TimeOut10));

	public Button(By locator) {
		this.locator = locator;
	}

	public void Click() {
		// wait.until(ExpectedConditions.elementToBeClickable(locator));
		WebElement element = DriverManager.getDriver().findElement(locator);
		element.click();
	}

	public void Click(String clickType) {
		// wait.until(ExpectedConditions.elementToBeClickable(locator));
		WebElement element = DriverManager.getDriver().findElement(locator);
		element.click();
	}

	public String GetText() {
		return null;
	}

}
