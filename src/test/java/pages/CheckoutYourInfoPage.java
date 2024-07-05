package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutYourInfoPage extends BasePage {
    private static final By FIRST_NAME_INPUT = By.id("first-name");
    private static final By LAST_NAME_INPUT = By.id("last-name");
    private static final By ZIP_CODE_INPUT = By.id("postal-code");
    private static final By CONTINUE_BUTTON = By.id("continue");
    private static final By CANCEL_BUTTON = By.id("cancel");
    private static final By CHECKOUT_OVERVIEW = By.className("title");

    public CheckoutYourInfoPage(WebDriver driver) {
        super(driver);
    }

    public void setFirstNameValue(String first_name) {
        driver.findElement(FIRST_NAME_INPUT).sendKeys(first_name);
    }

    public void setLastNameValue(String last_name) {
        driver.findElement(LAST_NAME_INPUT).sendKeys(last_name);
    }

    public void zipCodeValue(String zip_code) {
        driver.findElement(ZIP_CODE_INPUT).sendKeys(zip_code);
    }

    public void clickContinueButton() {
        driver.findElement(CONTINUE_BUTTON).click();
    }

    public void clickCancelButton() {
        driver.findElement(CANCEL_BUTTON).click();
    }

    public void enterInfo(String first_name, String last_name, String zip_code) {
        setFirstNameValue(first_name);
        setLastNameValue(last_name);
        zipCodeValue(zip_code);
        clickContinueButton();
    }

    public String getCheckoutOverview() {
        return driver.findElement(CHECKOUT_OVERVIEW).getText();
    }
}

