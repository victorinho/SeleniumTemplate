package hooks;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import support.World;
import utils.Config;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class SeleniumHooks {
    private final World world;

    private static final boolean HEADLESS = Config.HEADLESS_MODE;
    private static final long WAIT_SECONDS = Long.parseLong(Config.WEB_DRIVER_WAIT);

    // Opcional: define aquí cómo elegir el modo (propiedad/env o lo que ya uses)
    // Valores ejemplo: "chrome" (por defecto), "docker", "safari"
    private static final String BROWSER_MODE =
            System.getProperty("browser", System.getenv().getOrDefault("BROWSER", "chrome")).toLowerCase();

    public SeleniumHooks(World world) {
        this.world = world;
    }

    @Before(order = 0)
    public void setUp() throws MalformedURLException {
        WebDriver driver;
        switch (BROWSER_MODE) {
            case "docker":
                driver = createDockerDriver();
                break;
            case "safari":
                driver = createSafariDriver();
                break;
            case "chrome":
            default:
                driver = createChromeDriver();
                break;
        }
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(WAIT_SECONDS));
        world.setDriver(driver);
        world.setWait(wait);
    }

    @After(order = 0)
    public void tearDown() {
        WebDriver driver = world.getDriver();
        if (driver != null) {
            System.out.println("-- Close driver");
            driver.quit();
        }
    }

    // === Implementaciones equivalentes a tus métodos en BaseTest ===

    private WebDriver createChromeDriver() {
        System.out.println("\n ------ ChromeDriver selected ------");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        if (HEADLESS) {
            options.addArguments("--headless=new"); // headless moderno
            System.out.println("\n ------ Headless mode selected ------");
        }
        // options.addArguments("--start-maximized"); // si lo prefieres
        return new ChromeDriver(options);
    }

    private WebDriver createDockerDriver() throws MalformedURLException {
        System.out.println("\n ------ RemoteWebDriver (Docker/Grid) selected ------");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        if (HEADLESS) {
            options.addArguments("--headless=new");
            System.out.println("\n ------ Headless mode selected ------");
        }
        // Permite sobreescribir la URL por prop/env; valor por defecto = tu hub
        String gridUrl = System.getProperty("gridUrl",
                System.getenv().getOrDefault("SELENIUM_GRID_URL", "http://selenium-hub:4444/wd/hub"));
        return new RemoteWebDriver(new URL(gridUrl), options);
    }

    private WebDriver createSafariDriver() {
        System.out.println("\n ------ SafariDriver selected ------");
        if (HEADLESS) {
            System.out.println("\n ------ Safari no soporta headless ------");
        }
        return new SafariDriver();
    }
}
