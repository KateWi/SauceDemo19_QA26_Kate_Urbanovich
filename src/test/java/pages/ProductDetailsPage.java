package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductDetailsPage extends BasePage {
    private final static By BACK_TO_PRODUCTS = By.id("back-to-products");
    private final static By ITEM_DETAILS_PRICE = By.className("inventory_details_price");
    private final static By ITEM_DETAILS_DESCRIPTION = By.className("inventory_details_desc");

    public ProductDetailsPage(WebDriver driver) {
        super(driver);
    }
    @Step("click 'Back to products' Button")
    public void clickBackToProductsButton() {
        driver.findElement(BACK_TO_PRODUCTS).click();
    }
    @Step("get Details Product Price")
    public String getDetailsProductPrice() {
        return driver.findElement(ITEM_DETAILS_PRICE).getText();
    }

    @Step("get Details Product Description")
    public String getDetailsProductDescription() {
        return driver.findElement(ITEM_DETAILS_DESCRIPTION).getText();
    }

}

