package tests;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class ShoppingCartTests extends BaseTest {
    @Test
    public void addRemoveToCartProductTest() {
        loginPage.login("standard_user", "secret_sauce");
        productsPage.clickAddToCartButton("Sauce Labs Backpack");
        productsPage.clickAddToCartButton("Sauce Labs Bike Light");
        productsPage.clickAddToCartButton("Sauce Labs Bolt T-Shirt");
        burgerMenuPage.clickBurgerMenu();
        burgerMenuPage.clickLogout();
        loginPage.login("standard_user", "secret_sauce");
        productsPage.clickCartButton();
        assertEquals(shoppingCartPage.getProductDescriptionFromCart("Sauce Labs Backpack"), "carry.allTheThings() with the sleek, streamlined Sly Pack that melds uncompromising style with unequaled laptop and tablet protection.");
        assertEquals(shoppingCartPage.getProductPriceFromCart("Sauce Labs Backpack"), "$29.99");
        assertEquals(shoppingCartPage.getProductDescriptionFromCart("Sauce Labs Bike Light"), "A red light isn't the desired state in testing but it sure helps when riding your bike at night. Water-resistant with 3 lighting modes, 1 AAA battery included.");
        assertEquals(shoppingCartPage.getProductPriceFromCart("Sauce Labs Bike Light"), "$9.99");
        assertEquals(shoppingCartPage.getProductDescriptionFromCart("Sauce Labs Bolt T-Shirt"), "Get your testing superhero on with the Sauce Labs bolt T-shirt. From American Apparel, 100% ringspun combed cotton, heather gray with red bolt.");
        assertEquals(shoppingCartPage.getProductPriceFromCart("Sauce Labs Bolt T-Shirt"), "$15.99");
        shoppingCartPage.removeButton("Sauce Labs Bike Light");
        assertEquals(shoppingCartPage.getShoppingCartBadge(), "2");
        shoppingCartPage.removeButton("Sauce Labs Backpack");
        assertEquals(shoppingCartPage.getShoppingCartBadge(), "1");
    }
}
