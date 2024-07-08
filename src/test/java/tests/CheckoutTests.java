package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class CheckoutTests extends BaseTest {
    @Test(groups = {"Smoke"})
    public void checkInfoPositiveTest() {
        loginPage.login("standard_user", "secret_sauce");
        productsPage.clickAddToCartButton("Sauce Labs Backpack");
        productsPage.clickAddToCartButton("Sauce Labs Bike Light");
        productsPage.clickCartButton();
        shoppingCartPage.clickCheckoutButton();
        checkoutYourInfoPage.clickCancelButton();
        shoppingCartPage.clickContinueButton();
        productsPage.clickAddToCartButton("Test.allTheThings() T-Shirt (Red)");
        productsPage.clickCartButton();
        shoppingCartPage.clickRemoveButton("Sauce Labs Backpack");
        assertEquals(shoppingCartPage.getProductPriceFromCart("Test.allTheThings() T-Shirt (Red)"), "$15.99");
        assertEquals(shoppingCartPage.getProductPriceFromCart("Sauce Labs Bike Light"), "$9.99");
        shoppingCartPage.clickCheckoutButton();
        checkoutYourInfoPage.enterInfo("Ivan", "Ivanov", "12345");
        assertEquals(checkoutYourInfoPage.getCheckoutOverview(), "Checkout: Overview");
        checkoutOverviewPage.clickFinishButton();
        assertEquals(checkoutCompletePage.getCompleteText(), "Thank you for your order!");
        checkoutCompletePage.clickBackHomeButton();
        Assert.assertTrue(productsPage.isShoppingCartDisplayed());
    }
}
