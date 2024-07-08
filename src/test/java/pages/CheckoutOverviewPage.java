package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.AllureUtils;

public class CheckoutOverviewPage extends BasePage {

    private static final By FINISH_BUTTON = By.id("finish");

    public CheckoutOverviewPage(WebDriver driver) {
        super(driver);
    }

    @Step("click 'Finish' button")

    public void clickFinishButton() {
        AllureUtils.attachScreenshot(driver);
        driver.findElement(FINISH_BUTTON).click();
    }

}
