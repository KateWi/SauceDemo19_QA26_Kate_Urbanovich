package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutCompletePage extends BasePage {
    private static final By BACK_HOME_BUTTON = By.id("back-to-products");
    private static final By COMPLETE_TEXT = By.className("complete-header");

    public CheckoutCompletePage(WebDriver driver) {
        super(driver);
    }
    @Step("click 'Back Home' button")

    public void clickBackHomeButton() {
        driver.findElement(BACK_HOME_BUTTON).click();
    }
    public String getCompleteText() {
        return driver.findElement( COMPLETE_TEXT).getText();
    }
}
