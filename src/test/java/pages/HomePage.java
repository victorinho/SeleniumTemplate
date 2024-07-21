package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends BasePage {

    By selectElements = By.cssSelector(".card:nth-child(1) svg");

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public void clickElementsButton(){
        click(selectElements);
    }


}
