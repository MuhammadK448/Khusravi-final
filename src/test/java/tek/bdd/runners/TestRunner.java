package tek.bdd.runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class) //Annotation Interface
@CucumberOptions( // Annotation interface
        //features = "classpath:features/CreateAccount.feature",
        features = "classpath:features", // Directory for Feature file. classpath takes care of the rest of the address before feature
        glue = "tek.bdd.steps", //Package for all the steps
        dryRun = false, //set to true to scan features for unimplemented steps
        tags = "@Regression", //we can use "and" and "or" for running multiple tags eg. "@Smoke and @Regression"
        plugin = { //generate an html report in target folder by the name of index.html
                "html:target/cucumber_report/index.html",
                "json:target/jsonReport/report.json"
}
)
public class TestRunner {
}

//Running multiple tags => tags = "@Smoke or @Regression"