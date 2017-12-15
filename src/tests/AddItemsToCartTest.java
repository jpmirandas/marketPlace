package tests;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import pageObjects.CartPage;
import pageObjects.HomePage;
import pageObjects.ItemDescriptionPage;

/**
 *          Steps:
 * 
 * 1.       Access o site: http://demo.cs-cart.com/.
 * 2.       No campo “Procurar Produtos” pesquise usando o valor “Batman”.
 * 3.       No resultado da pesquisa clique em um dos resultados apresentados.
 * 4.       Na tela do produto pressione o botão “Adicionar ao carrinho”.
 * 5.       Repita os passos 2 a 4, pesquisando pelo item “PS3”.
 * 6.       Valide no carrinho de compras se o produto foi adicionado com sucesso.
 *
 */

public class AddItemsToCartTest {

	private HomePage mainPage;
	private ItemDescriptionPage itemDescriptionPage;
	private CartPage cartPage;

	@Before
	public void setUp() throws Exception {
		this.mainPage = new HomePage();
		this.mainPage.open("/");
	}

	@Test
	public void addItems() {
		String searchItem = "Batman";
		
		this.mainPage.performSearch(searchItem);
		this.itemDescriptionPage = this.mainPage.chooseTheFirstItem();
		this.itemDescriptionPage.addItemToCart();
		
		searchItem = "PS3";
		this.itemDescriptionPage.performSearch(searchItem);
		this.itemDescriptionPage = this.mainPage.chooseTheFirstItem();
		this.itemDescriptionPage.addItemToCart();
		
		this.cartPage = this.itemDescriptionPage.accessCart();
		this.cartPage.verifyPurchasedItens(this.itemDescriptionPage.getAddedItemsTitle());
	}
	
	@After 
	public void tearDown() throws Exception {
		this.mainPage.close();
	}

}
