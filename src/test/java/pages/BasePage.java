package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class BasePage {
    protected WebDriver driver;
    private static final By MENU = By.id("react-burger-menu-btn");
    private static final By LOGOUT = By.id("logout_sidebar_link");

    public BasePage(WebDriver driver) {
        this.driver = driver;

    }

    public void clickBurgerMenu() {
       driver.findElement(MENU).click();
    }

    public void clickLogout() {
        driver.findElement(LOGOUT).click();
    }

}
