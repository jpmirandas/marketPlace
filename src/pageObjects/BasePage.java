package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import util.FactoryWebDriver;
import util.PropertyOptions;
import util.PropertyReader;

public class BasePage {
	private WebDriver webdriver;
	private By searchField = By.cssSelector("#search_input");
	private By searchButton = By.cssSelector(".ty-search-magnifier");
	private By cartButton = By.cssSelector(".ty-minicart__icon");
	private By viewCartButton = By.cssSelector(".cm-popup-box .ty-float-left a");
	

	protected BasePage() {
		this.webdriver = FactoryWebDriver.getWebDriver();
	}

	public WebDriver getWebDriver() {
		return this.webdriver;
	}

	public void waitForPageLoad() {
		JavascriptExecutor js = (JavascriptExecutor) getWebDriver();
		js.executeScript("return jQuery.active == 0");
	}

	public void close() {
		this.webdriver.close();
	}

	public void open(String page) {
		String baseUrl = PropertyReader.getProperty(PropertyOptions.BASE_URL);
		getWebDriver().get(baseUrl + page);
	}

	
	public void waitForElementToBeClickable(By element){
		WebDriverWait wait = new WebDriverWait(this.getWebDriver(), PropertyOptions.SELENIUM_WAIT_IN_SECONDS);  
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}
	
	public void performSearch(String itemName){
		
		this.waitForElementToBeClickable(searchField);
		this.getWebDriver().findElement(searchField).sendKeys(itemName);
		this.getWebDriver().findElement(searchButton).click();
		this.waitForPageLoad();
	}
	
	public CartPage accessCart(){
		this.getWebDriver().findElement(cartButton).click();
		this.getWebDriver().findElement(viewCartButton).click();
		return new CartPage();
	}
}
