package pages;

import org.openqa.selenium.WebDriver;

public abstract class BasePage {
    protected static WebDriver driver;

    public BasePage(WebDriver driver) {
        BasePage.driver = driver;

    }
}
