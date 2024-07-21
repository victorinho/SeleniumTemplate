package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class ElementsPage extends BasePage{

    By leftPanel = By.cssSelector(".left-pannel");
    By selectTextBoxItem = By.id("item-0");

    public ElementsPage(WebDriver driver) {
        super(driver);
    }

    //Actions
    public void selectTextBoxItem(){
        click(selectTextBoxItem);
    }


    //Assertions
    public void checkLeftPanel(){
        assertTrue(checkAssert(leftPanel));
    }

}
