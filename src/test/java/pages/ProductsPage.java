package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ProductsPage extends BasePage {
    private final static String ITEM_CONTAINER = "//div[text()='%s']/ancestor::div[@class='inventory_item']";
    private final static By SHOPPING_CART = By.className("shopping_cart_link");
    private final static By ADD_TO_CART_BUTTON = By.cssSelector("button[id^=add-to-cart]");
    private final static By ITEM_PRICE = By.className("inventory_item_price");
    private final static By ITEM_DESCRIPTION = By.className("inventory_item_desc");
    private final static By ITEM_NAME = By.className("inventory_item_name");
    private final static By REMOVE_BUTTON = By.cssSelector("button[id^=remove]");
    private final static By CART_BUTTON = By.id("shopping_cart_container");


    public ProductsPage(WebDriver driver) {
        super(driver);
    }

    public boolean isShoppingCartDisplayed() {
        return driver.findElement(SHOPPING_CART).isDisplayed();
    }

    @Step("click add to cart button")
    public void clickAddToCartButton(String productName) {
        this.getProductCartByName(productName).findElement(ADD_TO_CART_BUTTON).click();
    }

    @Step("click cart button")
    public void clickCartButton() {
        driver.findElement(CART_BUTTON).click();
    }

    @Step("get product price")
    public String getProductPrice(String productName) {
        return this.getProductCartByName(productName).findElement(ITEM_PRICE).getText();
    }

    @Step("get product description")
    public String getProductDescription(String productName) {
        return this.getProductCartByName(productName).findElement(ITEM_DESCRIPTION).getText();

    }

    @Step("get product cart by name")
    private WebElement getProductCartByName(String productName) {
        return driver.findElement(By.xpath(String.format(ITEM_CONTAINER, productName)));
    }

    @Step("open Product Detials")
    public void openProductDetials(String productName) {
        this.getProductCartByName(productName).findElement(ITEM_NAME).click();
    }

    public boolean isRemoveButtonDisplayed() {
        return driver.findElement(REMOVE_BUTTON).isDisplayed();
    }
}
