package tek.bdd.steps;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import tek.bdd.pages.HomePage;
import tek.bdd.utilities.SeleniumUtility;

public class HomeSteps extends SeleniumUtility {

    @When("User navigates to insurance app")
    public void user_navigates_to_insurance_app() {
        setupBrowser();
    }

    @Then("Validate home page title is {string}")
    public void validate_home_page_title_is(String expectedPageTitle) throws InterruptedException {

       String actualTitle = getDriver().getTitle();
        System.out.println("Actual Title: " + actualTitle);
        Assert.assertEquals("page title should match", expectedPageTitle, actualTitle);
    }
    @Then("Validate Create Primary Account button is present")
    public void validate_Primary_Account_Button_button_is_present() {
        boolean isDisplayed = isElementDisplayed(HomePage.CREATE_PRIMARY_ACCOUNT);
        Assert.assertTrue("is Primary Account Button Displayed", isDisplayed);
    }

    @Then("Close the browser")
    public void closeBrowser(){
        quitBrowser();
    }
}
