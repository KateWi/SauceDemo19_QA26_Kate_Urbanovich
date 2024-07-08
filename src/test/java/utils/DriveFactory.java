package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriveFactory {
    public static WebDriver getDriver(String browserName) throws Exception {
        WebDriver driver;
        if (browserName.equals("chrome")) {
            driver = new ChromeDriver();
        } else if (browserName.equals("firefox")) {
            driver = new FirefoxDriver();
        } else {
            throw new Exception("Unsupported browser");
        }
        return driver;
    }
}
