package tek.bdd.steps;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import tek.bdd.pages.UserProfilePage;
import tek.bdd.utilities.SeleniumUtility;

public class UserProfileSteps extends SeleniumUtility {
    @When("User clicks on profile icon") //Belongs to Primary account portal
    public void userClicksOnProfileIcon() {
        clickOnElement(UserProfilePage.PROFILE_ICON);
    }

    @Then("Verify {string} is displayed")
    public void verifyMuhammadKhusraviIsDisplayed(String expectedName) {
        isElementDisplayed(UserProfilePage.FULL_NAME);
        String fullName = getElementText(UserProfilePage.FULL_NAME);
        Assert.assertEquals(expectedName, fullName);

    }

    @Then("Verify sidebar is displayed")
    public void verifySidebarIsDisplayed() {
        isElementDisplayed(UserProfilePage.PROFILE_SIDEBAR_HEADER);
    }

    @Then("Validate {string} value is {string}")
    public void validateSTATUSValueIsActive(String key, String expectedValue) {
        String xpath = "//p[text()='" + key + "']/following-sibling::p";
        String actualValue = getElementText(By.xpath(xpath));
        Assert.assertEquals("Actual Value should match Expected one: ", expectedValue, actualValue);
    }


    @Then("Validate user status is {string}")
    public void validateUserStatusIsActive(String expectedValue) {
        String actualValue = getElementText(UserProfilePage.USER_STATUS);
        Assert.assertEquals("Actual Value should match Expected one: ", expectedValue, actualValue);
    }

    @Then("Validate Authorities is {string}")
    public void validateAuthoritiesIsAdmin(String expectedValue) {
        String actualValue = getElementText(UserProfilePage.USER_AUTHORITY);
        Assert.assertEquals("Actual Value should match Expected one: ", expectedValue, actualValue);
    }
}
