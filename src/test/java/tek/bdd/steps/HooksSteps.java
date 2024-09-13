package tek.bdd.steps;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import tek.bdd.utilities.SeleniumUtility;

public class HooksSteps extends SeleniumUtility {
    @Before
    public void beforeEachScenario(){
        setupBrowser();
    }

    @After
    public void afterEachScenario(Scenario scenario){
        // if the test fails then take the screenshot
        if (scenario.isFailed()) {
            byte[] screenshot = takeScreenShot();
            //takes a png-Type image of failed scenario with the failed_scenario
            scenario.attach(screenshot, "image/png", "failed_scenario");
        }
        quitBrowser();
    }

}
