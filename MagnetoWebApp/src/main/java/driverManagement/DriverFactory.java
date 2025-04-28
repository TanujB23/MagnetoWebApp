package driverManagement;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

public class DriverFactory {
	private WebDriver driver;
	private BrowserOptions bo;
	public static boolean highlight = Boolean.parseBoolean(new DriverFactory().initProperties().getProperty("highlight"));
	public WebDriver initDriver(String browsersFromTDD) throws Exception {
		bo = new BrowserOptions();
		Properties prop  = initProperties();
		String browser = Boolean.parseBoolean(prop.getProperty("cross-browser"))?browsersFromTDD : prop.getProperty("browser");
		
		switch (browser.toLowerCase().trim()) {
		case "chrome":
			driver = new ChromeDriver(bo.getChromeOptions(prop));
			break;

		case "firefox":
			driver = new FirefoxDriver(bo.getFirefoxOptions(prop));
			break;

		case "safari":
			driver = new SafariDriver(bo.getSafariOptions(prop));
			break;

		case "edge":
			driver = new EdgeDriver(bo.getEdgeOptions(prop));
			break;

		default:
			System.out.println("please enter correct Browser");
			throw new Exception("No browser found to launch");

		}
		return driver;
	}

	public Properties initProperties() {
		FileReader reader;
		Properties prop = new Properties();
		
		try {
			reader = new FileReader("/Users/tanujbohra/eclipse-workspace/JAVA-testNG/src/test/resources/config.properties");
			prop.load(reader);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}catch (IOException ex) {
			ex.printStackTrace();
		}
		
		return prop;

	}
}
