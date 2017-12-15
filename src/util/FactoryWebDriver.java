package util;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

public class FactoryWebDriver {

	static WebDriver webdriver;
	final static String SAFARI = "safari";
	final static String FIREFOX = "firefox";
	final static String CHROME = "chrome";

	public static WebDriver getWebDriver() {

		String browserUT = PropertyReader.getProperty(PropertyOptions.BROWSER_NAME);

		if (webdriver == null) {
			try {
				switch (browserUT) {
				case SAFARI:
					
					webdriver = new SafariDriver();
					break;
				case FIREFOX:
					
					System.setProperty("webdriver.gecko.driver", new File("drivers/geckodriver").getCanonicalPath());
					webdriver = new FirefoxDriver();
					break;
				case CHROME:
					
					System.setProperty("webdriver.chrome.driver", new File("drivers/chromedriver").getCanonicalPath());
					ChromeOptions options = new ChromeOptions();
					options.addArguments("headless");
					options.addArguments("window-size=1200x600");
					webdriver = new ChromeDriver(options);
					break;
				default:
					System.err.println("The choosen driver is not valid!");
					break;
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		return webdriver;
	}
}