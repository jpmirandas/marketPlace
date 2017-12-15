package pageObjects;

import static org.junit.Assert.assertTrue;

import java.util.Collections;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class CartPage extends BasePage {

	// locators
	By purchasedItensTitle = By.cssSelector("a.ty-cart-content__product-title");

	public CartPage() {
		super();
	}
	
	public void verifyPurchasedItens(List<String> titles){
		List<WebElement> elements = this.getWebDriver().findElements(purchasedItensTitle);
		
		Collections.reverse(elements);
		
		for (int i = 0; i < titles.size(); i++) {
			assertTrue("The added items are wrong!", titles.get(i).equals(elements.get(i).getText()));
		}
		
			
		
	}
	
}
