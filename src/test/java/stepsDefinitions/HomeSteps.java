package stepsDefinitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import pages.BaseTest;
import pages.HomePage;

public class HomeSteps extends BaseTest {


    public HomeSteps() {
        super();
    }

    HomePage homePage = new HomePage(driver);

    @When("^The user select elements$")
    public void checkUserIsLogged() {
        homePage.clickElementsButton();
    }
}
