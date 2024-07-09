package pages;


import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class LoginPage extends BasePage {
    private static final By EMAIL_INPUT = By.id("user-name");
    private static final By PASSWORD_INPUT = By.id("password");
    private static final By LOGIN_BUTTON = By.id("login-button");
    private static final By LOGIN_ERROR = By.cssSelector("[data-test='error']");


    public LoginPage(WebDriver driver) {
        super(driver);
    }

   @Step("set Email value")
    public void setEmailValue(String email) {
        driver.findElement(EMAIL_INPUT).sendKeys(email);

    }
    @Step("set password value")
    public void setPasswordValue(String password) {
        driver.findElement(PASSWORD_INPUT).sendKeys(password);
    }
    @Step("click Login button")
    public void clickLoginButton() {
        driver.findElement(LOGIN_BUTTON).click();
    }
    @Step("Login")
    public void login(String email, String password) {
        setEmailValue(email);
        setPasswordValue(password);
        clickLoginButton();
    }
    @Step("invalid login")
    public String getErrorMessageText() {
        return driver.findElement(LOGIN_ERROR).getText();
    }
}
