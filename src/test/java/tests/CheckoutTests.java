package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class CheckoutTests extends BaseTest {
    @Test
    public void checkInfoPositiveTest() {
        loginPage.login("standard_user", "secret_sauce");
        productsPage.clickAddToCartButton("Sauce Labs Backpack");
        productsPage.clickAddToCartButton("Sauce Labs Bike Light");
        productsPage.clickCartButton();
        shoppingCartPage.CheckoutButton();
        checkoutYourInfoPage.clickCancelButton();
        shoppingCartPage.ContinueButton();
        productsPage.clickAddToCartButton("Test.allTheThings() T-Shirt (Red)");
        productsPage.clickCartButton();
        shoppingCartPage.removeButton("Sauce Labs Backpack");
        assertEquals(shoppingCartPage.getProductPriceFromCart("Test.allTheThings() T-Shirt (Red)"), "$15.99");
        assertEquals(shoppingCartPage.getProductPriceFromCart("Sauce Labs Bike Light"), "$9.99");
        shoppingCartPage.CheckoutButton();
        checkoutYourInfoPage.enterInfo("Ivan", "Ivanov", "12345");
        assertEquals(checkoutYourInfoPage.getCheckoutOverview(), "Checkout: Overview");
        checkoutOverviewPage.clickFinishButton();
        assertEquals(checkoutCompletePage.getCompleteText(), "Thank you for your order!");
        checkoutCompletePage.clickBackHomeButton();
        Assert.assertTrue(productsPage.isShoppingCartDisplayed());
    }
}
