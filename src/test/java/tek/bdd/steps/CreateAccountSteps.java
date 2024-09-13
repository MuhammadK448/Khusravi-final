package tek.bdd.steps;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import tek.bdd.pages.CreateAccountPage;
import tek.bdd.utilities.RandomGenerator;
import tek.bdd.utilities.SeleniumUtility;

public class CreateAccountSteps extends SeleniumUtility {

    private static String emailToUse;
    @Then("Validate form title is {string}")
    public void validate_form_title_isCreatePrimaryAccountHolder(String expectedTitle) {
        String actualTitle = getElementText(CreateAccountPage.CREATE_PRIMARY_ACCOUNT_HOLDER_FORM_TITLE);
        Assert.assertEquals("Expected Text is Create Primary Account Holder", expectedTitle, actualTitle);
    }

    @When("User selects {string} from {string} dropdown")
    public void user_selects_from_dropdown(String option, String ddTitle) {
        WebElement ddElement = getDriver().findElement(By.xpath("//option[text()='Select "+ddTitle+"']/.."));
        SelectByText(ddElement, option);

    }
    @When("User enters DOB on date of birth field")
    public void user_enters_dob_on_date_of_birth_field() {
        String datOfBirth = randomDataOfBirth(1970, 2004);
        System.out.println("Date of Birth: " + datOfBirth);
        sendText(CreateAccountPage.DATE_OF_BIRTH, datOfBirth);
    }

    @When("User enters {string} value on {string} field")
    public void userEnterRandomEmailOrUsernameValueOnEmailAddressField(String randomText, String fieldName) {
        String xpath = "//label[text()='"+fieldName+"']/..//input";
        if(randomText.equalsIgnoreCase("random email")){
            emailToUse = RandomGenerator.generateRandomEmail();
        } else if (randomText.equalsIgnoreCase("random username")){
            emailToUse = RandomGenerator.generateRandomUserName();
        }else{
            emailToUse = randomText;
        }
        sendText(By.xpath(xpath), emailToUse);
    }
    @Then("Validate email is matching {string}")
    public void validate_email_is_matching(String expectedEmail) {
        String email = expectedEmail.equalsIgnoreCase("random email") ? emailToUse : expectedEmail;
        String actualEmail = getElementText(CreateAccountPage.CREATED_ACCOUNT_EMAIL);
        Assert.assertEquals("Expected and actual email should match", email, actualEmail);
    }

    @Then("Verify error message {string} is displayed")
    public void verify_error_message_is_displayed(String expectedMessage) throws InterruptedException {
        //String errorTxt = getElementText(CreateAccountPage.ERROR_MESSAGE);
        String errorTxt = getDriver().findElement(By.xpath("(//div[@data-status='error'])[1]")).getText();
        Thread.sleep(1000);
        String actualErrorMessage = errorTxt.split("\n")[1]; //Account with email khusravi_987@email.com is exist
        Assert.assertEquals("Error Message should match expected", expectedMessage, actualErrorMessage);
    }

    @When("User enters newly created {string} value on {string} field")
    public void userEntersNewlyCreatedRandomUsernameValueOnUsernameField(String randomText, String fieldName) {
        String xpath = "//label[text()='"+fieldName+"']/..//input";
        sendText(By.xpath(xpath), emailToUse);
    }


}
