package tests;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class ProductsTests extends BaseTest {
    @Test(retryAnalyzer = Retry.class, dataProvider = "itemTestData", groups = {"Smoke"})
    public void addToCartProductTest(String product_name, String product_desc, String product_price) {
        loginPage.login("standard_user", "secret_sauce");
        assertEquals(productsPage.getProductPrice(product_name), product_price);
        assertEquals(productsPage.getProductDescription(product_name), product_desc);
        productsPage.clickAddToCartButton(product_name);
        assertEquals(productsPage.getProductPrice(product_name), product_price);
    }

    @Test(dataProvider = "itemTestData", groups = {"Regression"})
    public void checkFromDetailsPageTest(String product_name, String product_desc, String product_price) {
        loginPage.login("standard_user", "secret_sauce");
        productsPage.clickAddToCartButton(product_name);
        productsPage.openProductDetials(product_name);
        assertEquals(productDetailsPage.getDetailsProductPrice(), product_price);
        assertEquals(productDetailsPage.getDetailsProductDescription(), product_desc);
        productDetailsPage.clickBackToProductsButton();
        assertTrue(productsPage.isRemoveButtonDisplayed());
    }

    @DataProvider
    public Object[][] itemTestData() {
        return new Object[][]{
                {"Sauce Labs Backpack", "carry.allTheThings() with the sleek, streamlined Sly Pack that melds uncompromising style with unequaled laptop and tablet protection.", "$29.99"},
                {"Sauce Labs Bike Light", "A red light isn't the desired state in testing but it sure helps when riding your bike at night. Water-resistant with 3 lighting modes, 1 AAA battery included.", "$9.99"},
                {"Sauce Labs Bolt T-Shirt", "Get your testing superhero on with the Sauce Labs bolt T-shirt. From American Apparel, 100% ringspun combed cotton, heather gray with red bolt.", "$15.99"},
                {"Sauce Labs Fleece Jacket", "It's not every day that you come across a midweight quarter-zip fleece jacket capable of handling everything from a relaxing day outdoors to a busy day at the office.", "$49.99"}
        };
    }
}

