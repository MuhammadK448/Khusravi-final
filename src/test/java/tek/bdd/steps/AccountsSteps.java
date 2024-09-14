package tek.bdd.steps;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import tek.bdd.pages.PlansPage;
import tek.bdd.utilities.SeleniumUtility;

public class AccountsSteps extends SeleniumUtility {

    @When("User selects {string} from show records per page dropdown")
    public void userSelectsFromShowRecordsPerPageDropdown(String value) {
        WebElement showPerPagedropdown = getDriver().findElement(By.tagName("select"));
        SelectByValue(showPerPagedropdown, value);
    }

    @Then("Validate {int} number of records displayed")
    public void validate_number_of_records_displayed(int value) {
        int actualCount = (getElementsList(PlansPage.PLAN_ROWS_COUNT)).size();
        Assert.assertEquals(value, actualCount);
    }
}
