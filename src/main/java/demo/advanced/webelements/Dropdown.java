package demo.advanced.webelements;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import demo.advanced.framework.DriverManager;
import demo.advanced.data.DataHelper;

public class Dropdown {
	private By locator;
	//WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(DataHelper.TimeOut10));

	public Dropdown(By locator) {
		this.locator = locator;
	}

	public void Click() {

		//wait.until(ExpectedConditions.elementToBeClickable(locator));
		WebElement element = DriverManager.getDriver().findElement(locator);
		element.click();
	}

	public List<WebElement> getAllOptions() {
		List<WebElement> categoryList = new ArrayList<WebElement>();
		WebElement element = DriverManager.getDriver().findElement(locator);
		Select select = new Select(element);
		categoryList = select.getOptions();
		return categoryList;
	}

	public String GetText() {
		return null;
	}

}
