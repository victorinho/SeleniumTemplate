package pages;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.Config;

public class BaseTest {

    public static WebDriver driver;
    protected static WebDriverWait wait;
    private static final boolean HEADLESS_MODE_REF = Config.HEADLESS_MODE;
    private static final String WEB_DRIVER_WAIT_REF = Config.WEB_DRIVER_WAIT;

    public static void setUpDriver() {
        System.out.println("\n ------ ChromeDriver selected ------");
        safariDriver();
    }

    public static void chromeDriver() {
        //String ruta_chromedriver = "../driver/chromedriver";
        //System.setProperty("webdriver.chrome.driver", ruta_chromedriver);
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        //options.addArguments("--start-maximized");
        if (HEADLESS_MODE_REF) {
            options.addArguments("--headless");
            System.out.println("\n ------ Headless mode selected ------");
        }
        driver = new ChromeDriver(options);
        wait = new WebDriverWait(driver, Duration.ofSeconds(Long.parseLong(WEB_DRIVER_WAIT_REF)));
    }

    public static void safariDriver() {
        if (HEADLESS_MODE_REF) {
            System.out.println("\n ------ Safari no soporta el modo headless ------");
        }
        driver = new SafariDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(Long.parseLong(WEB_DRIVER_WAIT_REF)));
    }


    public BaseTest() {
        BaseTest.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public static void closeBrowser() {
        if (driver != null) {
            System.out.println("-- Close driver");
            driver.quit();
        }
    }
}