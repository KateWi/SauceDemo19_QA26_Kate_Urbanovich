package tests;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;


public class LoginTests extends BaseTest {
    @Test(retryAnalyzer = Retry.class)
    public void positiveLoginTest() {
        loginPage.login("standard_user", "secret_sauce");
        Assert.assertTrue(productsPage.isShoppingCartDisplayed());
    }

    @Test(dataProvider = "negativeLoginTestData")
    public void negativeLoginTest(String email, String password, String expectedErrorMessage) {
        loginPage.login(email, password);
        assertEquals(loginPage.getErrorMessageText(), expectedErrorMessage);
    }
    @DataProvider
    public Object[][] negativeLoginTestData(){
        return new Object[][] {
                {"", "secret_sauce", "Epic sadface: Username is required"},
                {"standard_user", "", "Epic sadface: Password is required"},
                {"qwe", "qwe", "Epic sadface: Username and password do not match any user in this service"}
        };
    }
}
