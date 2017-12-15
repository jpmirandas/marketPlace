package pageObjects;

import org.openqa.selenium.By;

public class HomePage extends BasePage {

	// locators
	By firstItem = By.cssSelector(".grid-list .ty-column3:first-child .ty-grid-list__image a");

	public HomePage() {
		super();
	}
	
	public ItemDescriptionPage chooseTheFirstItem(){
		this.getWebDriver().findElement(firstItem).click();
		this.waitForPageLoad();
		
		return new ItemDescriptionPage();
	}

}
