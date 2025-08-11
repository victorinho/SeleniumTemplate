package support;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class World {
    private WebDriver driver;
    private WebDriverWait wait;

    public WebDriver getDriver() { return driver; }
    public void setDriver(WebDriver driver) { this.driver = driver; }

    public WebDriverWait getWait() { return wait; }
    public void setWait(WebDriverWait wait) { this.wait = wait; }
}
