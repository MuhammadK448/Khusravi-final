package tek.bdd.steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import tek.bdd.utilities.RandomGenerator;
import tek.bdd.utilities.SeleniumUtility;

public class CommonSteps extends SeleniumUtility {

    @When("User clicks on {string} link")
    public void userClicksOnLinks(String linkText){
        clickOnElement(By.linkText(linkText));
    }

    @When("User clicks on {string} button")
    public void userClicksOnButton(String buttonText){
        try {
            String buttonXpath = "//button[text()='" + buttonText + "']";
            clickOnElement(By.xpath(buttonXpath));
        } catch (TimeoutException ex) {
            String buttonXpath = "//*[text()='" + buttonText + "']/..";
                                    //*[text()='Add to Cart']/..
            clickOnElement(By.xpath(buttonXpath));
        }
    }

    //Insurance page
    @Then("Verify {string} page is displayed")
    public void verify_page_title_is_displayed(String titleText) {
         String pageTitleXpath = "//h2[contains(text(),'" + titleText + "')]";
        isElementDisplayed(By.xpath(pageTitleXpath));
    }

    @When("User enters {string} on {string} field")
    public void user_enters_on_field(String text, String fieldName) {
        String xpath = "//label[text()='"+fieldName+"']/..//input";
        sendText(By.xpath(xpath), text);
    }

    @When("wait for {int} seconds")
    public void wait_for_seconds(Integer seconds) {
        try {
            Thread.sleep(seconds * 1000);
        }catch (InterruptedException ex) {
            Thread.currentThread().interrupt();
        }
    }


}
