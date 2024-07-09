package tests;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.annotations.*;
import pages.*;
import utils.DriveFactory;
import utils.InvokedListener;

import java.time.Duration;

@Listeners({InvokedListener.class, TestListener.class})
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
    public void setUp(@Optional("chrome") String browser, ITestContext testContext) throws Exception {
        driver = DriveFactory.getDriver(browser);
        testContext.setAttribute("driver", driver);
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

