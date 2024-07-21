package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class ElementsPage extends BasePage{

    By leftPanel = By.cssSelector(".left-pannel");

    public ElementsPage(WebDriver driver) {
        super(driver);
    }

    public void checkLeftPanel(){
        assertTrue(checkAssert(leftPanel));
    }



}
