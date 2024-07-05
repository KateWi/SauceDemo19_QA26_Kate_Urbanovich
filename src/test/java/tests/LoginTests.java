package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;


public class LoginTests extends BaseTest {
    @Test
    public void positiveLoginTest() {
        loginPage.login("standard_user", "secret_sauce");
        Assert.assertTrue(productsPage.isShoppingCartDisplayed());
    }

    @Test
    public void negativeLoginTest() {
        loginPage.login("qwq", "ewq");
        assertEquals(loginPage.getErrorMessageText(), "Epic sadface: Username and password do not match any user in this service");

    }
}
