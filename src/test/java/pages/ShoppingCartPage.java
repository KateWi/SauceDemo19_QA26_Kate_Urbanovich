package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ShoppingCartPage extends BasePage {
    private final static By CHECKOUT_BUTTON = By.id("checkout");
    private final static By CONTINUE_SHOPPING_BUTTON = By.id("continue-shopping");
    private final static By ITEM_DESCRIPTION_CART = By.className("inventory_item_desc");
    private final static String ITEM_CONTAINER_CART = "//div[text()='%s']/ancestor::div[@class='cart_item']";
    private final static By ITEM_PRICE_CART = By.className("inventory_item_price");
    private final static By REMOVE_BUTTON_CART = By.cssSelector("button[id^=remove]");
    private final static By SHOPPING_CART_BADGE = By.className("shopping_cart_badge");

    public ShoppingCartPage(WebDriver driver) {
        super(driver);
    }

    @Step("click 'Checkout' button")
    public void clickCheckoutButton() {
        driver.findElement(CHECKOUT_BUTTON).click();
    }

    @Step("click 'Continue' button")
    public void clickContinueButton() {
        driver.findElement(CONTINUE_SHOPPING_BUTTON).click();
    }

    public String getProductPriceFromCart(String productNameCart) {
        return this.getProductCartByNameFromCart(productNameCart).findElement(ITEM_PRICE_CART).getText();
    }

    public String getProductDescriptionFromCart(String productNameCart) {
        return this.getProductCartByNameFromCart(productNameCart).findElement(ITEM_DESCRIPTION_CART).getText();

    }

    private WebElement getProductCartByNameFromCart(String productNameCart) {
        return driver.findElement(By.xpath(String.format(ITEM_CONTAINER_CART, productNameCart)));
    }

    @Step("click remove button")
    public void clickRemoveButton(String productNameCart) {
        driver.findElement(REMOVE_BUTTON_CART).click();
    }


    public String getShoppingCartBadge() {
        return driver.findElement(SHOPPING_CART_BADGE).getText();
    }

}
