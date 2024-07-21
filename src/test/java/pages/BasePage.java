package pages;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.Properties;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage extends BaseTest {

    public BasePage(WebDriver driver) {
        super();
    }
    private static final Duration MAX_TIME_WAITING_FOR = Duration.ofSeconds(60L);

    public static void navigateTo(String url) {
        driver.get(url);
    }

    ///////////////////////////////////////////////////////////////////////////////////////
    // WEB ELEMENT METHODS
    ///////////////////////////////////////////////////////////////////////////////////////
    public WebElement findElementWithWait(By by) {
        return (WebElement)(new WebDriverWait(driver, MAX_TIME_WAITING_FOR)).until(ExpectedConditions.visibilityOfElementLocated(by));
    }

    protected void clickWithWait(By by) {
        ((WebElement)(new WebDriverWait(driver, MAX_TIME_WAITING_FOR)).until(ExpectedConditions.visibilityOfElementLocated(by))).click();
    }

    public WebElement findElement(By by) {
        return driver.findElement(by);
    }

    public List<WebElement> findElements(By by) {
        return driver.findElements(by);
    }

    protected void click(By by) {
        driver.findElement(by).click();
    }

    protected void sendKeys(By by, String text) {
        driver.findElement(by).sendKeys(new CharSequence[]{text});
    }

    protected void sendKeysList(By by, String text, int cursor) {
        ((WebElement)driver.findElements(by).get(cursor)).click();
        (new Actions(driver)).sendKeys(new CharSequence[]{text}).perform();
    }

    public WebElement findElementByDataTestId(String dataTestId) {
        return driver.findElement(By.xpath(dataTestId));
    }

    protected void clickByDataTestId(String dataTestId) {
        driver.findElement(By.xpath(dataTestId)).click();
    }

    protected void sendKeysListEspecial(By by, String text1, String text2, int cursor) {
        ((WebElement)driver.findElements(by).get(cursor)).click();
        (new Actions(driver)).sendKeys(new CharSequence[]{text1}).perform();
        (new Actions(driver)).sendKeys(new CharSequence[]{text2}).perform();
    }

    public boolean checkAssert(By assertCheck) {
        java.util.logging.Logger.getLogger("proba assert");
        java.util.logging.Logger.getLogger(this.findElement(assertCheck).getText());
        return this.findElement(assertCheck).isDisplayed();
    }



    public void switchToFrame(By frame) {
        WebElement iFrame = driver.findElement(frame);
        driver.switchTo().frame(iFrame);
    }

    public void clickCenter() {
        Actions actions = new Actions(driver);
        int x = driver.manage().window().getSize().width;
        int y = driver.manage().window().getSize().height;
        actions.moveByOffset(x / 2, y / 2).build().perform();
        actions.click().build().perform();
    }

    ////////////////////////////////////////////////////////////////////////
    // PROPERTIES METHODS
    ////////////////////////////////////////////////////////////////////////
    public static Properties getProperties(String propertiesFileName) {
        Properties properties = new Properties();
        try {
            properties.load(new FileInputStream(propertiesFileName));
        } catch (FileNotFoundException exception) {
            Assert.fail("File not found: " + propertiesFileName + ".\n" + exception.getMessage());
        } catch (IOException exception) {
            Assert.fail("Exception while reading: " + propertiesFileName + ".\n" + exception.getMessage());
        }
        return properties;
    }
}
