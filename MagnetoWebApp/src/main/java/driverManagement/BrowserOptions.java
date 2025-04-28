package driverManagement;

import java.util.Properties;

import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.safari.SafariOptions;

public class BrowserOptions {
	
	ChromeOptions co;
	FirefoxOptions fo;
	SafariOptions so;
	EdgeOptions eo;
	
	public ChromeOptions getChromeOptions(Properties prop) {
		co = new ChromeOptions();
		if(Boolean.parseBoolean(prop.getProperty("incognito"))) co.addArguments("--incognito");
		if(Boolean.parseBoolean(prop.getProperty("headless"))) co.addArguments("--headless");
		return co;
	}
	
	public FirefoxOptions getFirefoxOptions(Properties prop) {
		fo = new FirefoxOptions();
		if(Boolean.parseBoolean(prop.getProperty("incognito"))) fo.addArguments("--incognito");
		if(Boolean.parseBoolean(prop.getProperty("headless"))) fo.addArguments("--headless");
		return fo;
	}
	
	public EdgeOptions getEdgeOptions(Properties prop) {
		eo = new EdgeOptions();
		if(Boolean.parseBoolean(prop.getProperty("incognito"))) eo.addArguments("--incognito");
		if(Boolean.parseBoolean(prop.getProperty("headless"))) eo.addArguments("--headless");
		return eo;
	}
	
	public SafariOptions getSafariOptions(Properties prop) {
		so = new SafariOptions();
		//if(Boolean.parseBoolean(prop.getProperty("incognito"))) so.("--incognito");
		//if(Boolean.parseBoolean(prop.getProperty("headless"))) so.addArguments("--headless");
		return so;
	}
	
	
}
