package stepsDefinitions;

import java.util.Properties;

import org.junit.Assert;

import io.cucumber.java.en.*;
import pages.BasePage;
import scripts.Configuration;

public class CommonsSteps {

    @Given("^The user visit the '(.*)' page.$")
    public void navigateToPage(String URL) {
        BasePage.navigateTo(URL);
    }

}