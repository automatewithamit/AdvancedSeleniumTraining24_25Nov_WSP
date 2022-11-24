package demo.advanced.webelements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import demo.advanced.framework.DriverManager;

public class TextBox {
	private By locator;
	// WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(),
	// Duration.ofSeconds(DataHelper.TimeOut10));

	public TextBox(By locator) {
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

	public void setText(String text) {
		// wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
		// wait.until(ExpectedConditions.elementToBeClickable(locator));
		WebElement element = DriverManager.getDriver().findElement(locator);
		element.clear();
		element.sendKeys(text);

	}

}
