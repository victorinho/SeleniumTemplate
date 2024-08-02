package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class ElementsPage extends BasePage{

    By leftPanel = By.cssSelector(".left-pannel");
    By selectTextBoxItem = By.id("item-0");
    By selectCheckTextItem = By.id("item-1");
    By selectRadioButtonItem = By.id("item-2");

    public ElementsPage(WebDriver driver) {
        super(driver);
    }

    //Actions
    public void selectTextBoxItem(){
        click(selectTextBoxItem);
    }
    public void selectCheckTextItem(){
        click(selectCheckTextItem);
    }
    public void selectRadioButtonItem(){
        click(selectRadioButtonItem);
    }


    //Assertions
    public void checkLeftPanel(){
        assertTrue(checkAssert(leftPanel));
    }

}
