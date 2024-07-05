package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import pages.*;

import java.time.Duration;

public abstract class BaseTest {
    protected WebDriver driver;
    protected LoginPage loginPage;
    protected ProductsPage productsPage;
    protected ProductDetailsPage productDetailsPage;
    protected BurgerMenuPage burgerMenuPage;
    protected ShoppingCartPage shoppingCartPage;
    protected CheckoutYourInfoPage checkoutYourInfoPage;
    protected CheckoutOverviewPage checkoutOverviewPage;
    protected CheckoutCompletePage checkoutCompletePage;


    @BeforeMethod(alwaysRun = true)
    public void setUp() {
        this.driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        this.loginPage = new LoginPage(driver);
        this.productsPage = new ProductsPage(driver);
        this.productDetailsPage = new ProductDetailsPage(driver);
        this.burgerMenuPage = new BurgerMenuPage(driver);
        this.shoppingCartPage = new ShoppingCartPage(driver);
        this.checkoutYourInfoPage = new CheckoutYourInfoPage(driver);
        this.checkoutOverviewPage = new CheckoutOverviewPage(driver);
        this.checkoutCompletePage = new CheckoutCompletePage(driver);

        loginPage.open();
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        this.driver.quit();
    }
}

