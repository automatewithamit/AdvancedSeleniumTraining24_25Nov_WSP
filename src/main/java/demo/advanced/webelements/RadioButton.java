package demo.advanced.webelements;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import demo.advanced.framework.DriverManager;
import demo.advanced.data.DataHelper;

public class RadioButton {
	private By locator;
	WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(DataHelper.TimeOut10));

	public RadioButton(By locator) {
		this.locator = locator;
	}

	public void Click() {
		wait.until(ExpectedConditions.elementToBeClickable(locator));
		WebElement element = DriverManager.getDriver().findElement(locator);
		element.click();
	}

	public String GetText() {
		return null;
	}

}
