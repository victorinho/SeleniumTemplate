package stepsDefinitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.BaseTest;
import pages.ElementsPage;

public class ElementsSteps  extends BaseTest {

    public ElementsSteps() {
        super();
    }

    ElementsPage elementsPage = new ElementsPage(driver);

    @Then("The left panel is displayed")
    public void checkUserIsLogged() {
        elementsPage.checkLeftPanel();
    }

}
