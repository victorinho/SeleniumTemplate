package stepsDefinitions;

import io.cucumber.java.en.When;
import pages.BaseTest;
import pages.TextBoxPage;

public class TextBoxSteps extends BaseTest {
    public TextBoxSteps() {
        super();
    }

    TextBoxPage textBoxPage = new TextBoxPage(driver);

    @When("The user type username: {}")
    public void selectTextBoxItem(String userName) {
        textBoxPage.setUsername(userName);
    }

}
