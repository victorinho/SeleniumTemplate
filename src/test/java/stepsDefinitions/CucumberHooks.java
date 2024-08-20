package stepsDefinitions;

import io.cucumber.java.*;
import pages.BaseTest;
import utils.BrowserUtils;
import utils.Config;

import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

import static pages.BaseTest.driver;
import static pages.BaseTest.setUpDriver;

public class CucumberHooks {
    String featureTag;
    long start = System.currentTimeMillis();

    public static final String WINDOW_SIZE_REF = Config.WINDOW_SIZE;
    public static final Boolean FULL_STEPS_REF = Config.FULL_STEPS;

    @Before
    public void setUp() throws MalformedURLException {
        setUpDriver();
        BrowserUtils.maximizeWindow(driver);
    }

    @Before
    public void beforeFeature(Scenario scenario) {
        featureTag = scenario.getSourceTagNames().toString();
        System.out.println("\n---------- Start of Scenario: " + featureTag + " -----------------------");
    }

    @After
    public void afterScenario() {
        long stop = System.currentTimeMillis();
        long actualTimeMinutes = (TimeUnit.MILLISECONDS.toSeconds(stop - start)) / 60;
        long actualTimeSeconds = (TimeUnit.MILLISECONDS.toSeconds(stop - start)) % 60;
        System.out.println("---------- End of Scenario: " + featureTag + " - Execution time: " + actualTimeMinutes + "min " + actualTimeSeconds + "s -----------------------");
        driver.manage().deleteAllCookies();
        BaseTest.closeBrowser();
    }

    @AfterAll
    public static void tearDown() {
        BaseTest.closeBrowser();
    }
}