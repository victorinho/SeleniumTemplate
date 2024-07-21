package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class TextBoxPage extends BasePage {

    By username = By.id("userName");
    By userEmail= By.id("userEmail");
    By currentAdress = By.id("currentAddress");
    By permanentAdress = By.id("permanentAddress");
    By submitButton = By.id("submit");

    public TextBoxPage(WebDriver driver) {
        super(driver);
    }

    public void setUsername(String text){
        sendKeys(username,text);
    }

    public void setUserEmail(String text){
        sendKeys(userEmail,text);
    }

    public void setCurrentAdress(String text){
        sendKeys(currentAdress,text);
    }

    public void setPermanentAdress(String text){
        sendKeys(permanentAdress,text);
    }

    public void clickSubmitButton(){
        click(submitButton);
    }



}
