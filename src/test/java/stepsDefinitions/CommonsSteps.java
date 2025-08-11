package stepsDefinitions;



import io.cucumber.java.en.*;
import pages.BasePage;

import static pages.BaseTest.driver;


public class CommonsSteps {

    public BasePage basePage = new BasePage();

    @Given("The user visit the {} page")
    public void navigateToPage(String URL) {
        basePage.navigateTo(URL);
    }

}