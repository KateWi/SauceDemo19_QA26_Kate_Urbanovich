package tests;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;
import pages.*;
import utils.DriveFactory;

import java.time.Duration;

@Listeners({TestListener.class})
public abstract class BaseTest {
    protected WebDriver driver;
    protected LoginPage loginPage;
    protected ProductsPage productsPage;
    protected ProductDetailsPage productDetailsPage;
    protected BasePage basePage;
    protected ShoppingCartPage shoppingCartPage;
    protected CheckoutYourInfoPage checkoutYourInfoPage;
    protected CheckoutOverviewPage checkoutOverviewPage;
    protected CheckoutCompletePage checkoutCompletePage;


    @BeforeMethod(alwaysRun = true)
    @Parameters("browserName")
    public void setUp(@Optional("chrome") String browser) throws Exception {
        driver = DriveFactory.getDriver(browser);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.get("https://www.saucedemo.com/");
        this.loginPage = new LoginPage(driver);
        this.productsPage = new ProductsPage(driver);
        this.productDetailsPage = new ProductDetailsPage(driver);
        this.shoppingCartPage = new ShoppingCartPage(driver);
        this.checkoutYourInfoPage = new CheckoutYourInfoPage(driver);
        this.checkoutOverviewPage = new CheckoutOverviewPage(driver);
        this.checkoutCompletePage = new CheckoutCompletePage(driver);
        this.basePage = new BasePage(driver);

    }

    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        this.driver.quit();
    }
}

