package tek.bdd.steps;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
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
}
