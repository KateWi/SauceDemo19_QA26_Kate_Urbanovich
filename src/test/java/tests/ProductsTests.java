package tests;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class ProductsTests extends BaseTest {
    @Test
    public void addToCartProductTest() {
        String productName = "Sauce Labs Fleece Jacket";
        loginPage.login("standard_user", "secret_sauce");
        assertEquals(productsPage.getProductPrice(productName), "$49.99");
        assertEquals(productsPage.getProductDescription(productName), "It's not every day that you come across a midweight quarter-zip fleece jacket capable of handling everything from a relaxing day outdoors to a busy day at the office.");
        productsPage.clickAddToCartButton(productName);
        assertEquals(productsPage.getProductPrice(productName), "$49.99");
    }

    @Test
    public void checkFromDetailsPageTest() {
        String productName = "Sauce Labs Bike Light";
        loginPage.login("standard_user", "secret_sauce");
        productsPage.clickAddToCartButton(productName);
        assertEquals(productsPage.getProductPrice(productName), "$9.99");
        assertEquals(productsPage.getProductDescription(productName), "A red light isn't the desired state in testing but it sure helps when riding your bike at night. Water-resistant with 3 lighting modes, 1 AAA battery included.");
        productsPage.getProductName(productName);
        assertEquals(productDetailsPage.getDetailsProductPrice(), "$9.99");
        assertEquals(productDetailsPage.getDetailsProductDescription(), "A red light isn't the desired state in testing but it sure helps when riding your bike at night. Water-resistant with 3 lighting modes, 1 AAA battery included.");
        productDetailsPage.clickBackToProductsButton();
        assertTrue(productsPage.isRemoveButtonDisplayed());

    }
}
