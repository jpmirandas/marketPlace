package pageObjects;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import util.PropertyOptions;

public class ItemDescriptionPage extends BasePage {

	private static List<String> addedItemsName = new ArrayList<String>();
	
	// locators
	By addItemToCartButton = By.cssSelector(".ty-btn__add-to-cart");
	By addedItemName = By.cssSelector(".ty-product-block-title");
	By contineShoppingButton = By.cssSelector(".cm-notification-close");

	public ItemDescriptionPage() {
		super();
	}
	
	public void addItemToCart(){
		this.getWebDriver().findElement(addItemToCartButton).click();
		String itemTitle = this.getWebDriver().findElement(addedItemName).getText();
		this.addedItemsName.add(itemTitle);
		
		this.waitForElementToBeClickable(contineShoppingButton);
		this.getWebDriver().findElement(contineShoppingButton).click();
	}
	
	public List<String> getAddedItemsTitle(){
		return this.addedItemsName;
	}
}
