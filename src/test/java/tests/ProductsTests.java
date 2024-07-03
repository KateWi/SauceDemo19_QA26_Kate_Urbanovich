package tests;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class ProductsTests extends BaseTest {
    private static final String PRODUCT_NAME = "Sauce Labs Bike Light";
    private static final String PRODUCT_DESC = "A red light isn't the desired state in testing but it sure helps when riding your bike at night. Water-resistant with 3 lighting modes, 1 AAA battery included.";

    @Test
    public void addToCartProductTest() {
        //String productName = "Sauce Labs Fleece Jacket";
        loginPage.login("standard_user", "secret_sauce");
        assertEquals(productsPage.getProductPrice(PRODUCT_NAME), "$9.99");
        assertEquals(productsPage.getProductDescription(PRODUCT_NAME), PRODUCT_DESC);
        productsPage.clickAddToCartButton(PRODUCT_NAME);
        assertEquals(productsPage.getProductPrice(PRODUCT_NAME), "$9.99");
    }

    @Test
    public void checkFromDetailsPageTest() {
        loginPage.login("standard_user", "secret_sauce");
        productsPage.clickAddToCartButton(PRODUCT_NAME);
        assertEquals(productsPage.getProductPrice(PRODUCT_NAME), "$9.99");
        assertEquals(productsPage.getProductDescription(PRODUCT_NAME), PRODUCT_DESC);
        productsPage.getProductName(PRODUCT_NAME);
        assertEquals(productDetailsPage.getDetailsProductPrice(), "$9.99");
        assertEquals(productDetailsPage.getDetailsProductDescription(), PRODUCT_DESC);
        productDetailsPage.clickBackToProductsButton();
        assertTrue(productsPage.isRemoveButtonDisplayed());

    }
}
