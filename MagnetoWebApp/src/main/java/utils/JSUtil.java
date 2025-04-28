package utils;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class JSUtil {
	private WebDriver driver;
	private JavascriptExecutor jse;

	public JSUtil(WebDriver driver) {
		this.driver = driver;
		jse = (JavascriptExecutor) driver;

	}

	public void createBorder(WebElement element, String color) {
		jse.executeScript("arguments[0].style.border='3px solid + " + color + "'", element);
		try {
			Thread.sleep(20);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void flash(WebElement element) {
		String bgColor = element.getCssValue("backgroundColor");
		System.out.println(bgColor);
		for (int i = 0; i < 3; i++) {
			changeBGColor(element,"red");
			changeBGColor(element,bgColor);
		}
	}

	public void changeBGColor(WebElement element, String color) {
		jse.executeScript("arguments[0].style.backgroundColor = '" + color + "'",element);
		try {
			Thread.sleep(40);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}
}
