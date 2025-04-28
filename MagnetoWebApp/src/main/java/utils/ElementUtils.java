package utils;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import driverManagement.DriverFactory;

public class ElementUtils {
	private WebDriver driver;

	public ElementUtils(WebDriver driver) {
		this.driver = driver;
	}

	private WebElement getElement(By locator) {
		WebElement element = driver.findElement(locator);
		if(DriverFactory.highlight) {
			new JSUtil(driver).flash(element);
		}
		return element;
	}
	
	public List<WebElement> getElements(By locator) {
		return driver.findElements(locator);
	}
	
	public List<String> getTextsFromElements(By locator){
		List<String> elements = new ArrayList<String>();
		for(WebElement ele : getElements(locator)) {
			elements.add(ele.getText());
		}
		return elements;
	}

	public void fill(By locator, String value) {
		getElement(locator).clear();
		getElement(locator).sendKeys(value);
	}

	public void clickOn(By locator) {
		getElement(locator).click();
	}
	
	public String getElementText(By locator) {
		return getElement(locator).getText();
	}
}
