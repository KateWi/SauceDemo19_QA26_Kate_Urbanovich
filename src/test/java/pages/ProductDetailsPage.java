package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductDetailsPage extends BasePage {
    private final static By BACK_TO_PRODUCTS = By.id("back-to-products");
    private final static By ITEM_DETAILS_PRICE = By.className("inventory_details_price");
    private final static By ITEM_DETAILS_DESCRIPTION = By.className("inventory_details_desc");

    public ProductDetailsPage(WebDriver driver) {
        super(driver);
    }

    public void clickBackToProductsButton() {
        driver.findElement(BACK_TO_PRODUCTS).click();
    }
    public String getDetailsProductPrice() {
        return driver.findElement(ITEM_DETAILS_PRICE).getText();
    }

    public String getDetailsProductDescription() {
        return driver.findElement(ITEM_DETAILS_DESCRIPTION).getText();
    }

}

