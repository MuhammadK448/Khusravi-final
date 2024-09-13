package tek.bdd.steps;

import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import tek.bdd.pages.PlansPage;
import tek.bdd.utilities.SeleniumUtility;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;

public class PlansSteps extends SeleniumUtility {

    @Then("Validate {int} row of data is present")
    public void validateRowOfDataIsPresent(int rowCount) {
        int actualCount = (getElementsList(PlansPage.PLAN_ROWS_COUNT)).size();
        Assert.assertEquals(rowCount, actualCount);
    }

    @Then("Verify Create Date is todays date")
    public void verifyCreateDateIsTodaysDate() {
        List<WebElement> actualCreatedDates = getElementsList(PlansPage.CREATED_DATE);
        for (WebElement eachRow : actualCreatedDates){
            Assert.assertEquals("Created date should be today's date",
                    LocalDate.now().format(DateTimeFormatter.ofPattern("MMMM d, yyyy")), eachRow.getText());
        }
    }

    @Then("Verify Expiry Date is the next day")
    public void verifyExpiryDateIsTheNextDay() {
        String expectedDate = LocalDate.now().plusDays(1).format(DateTimeFormatter.ofPattern("MMMM d, yyyy"));
        List<WebElement> actualExpiryDates = getElementsList(PlansPage.EXPIRY_DATE);
        for(WebElement expiryDate : actualExpiryDates){
            String temp = expiryDate.getText();
           Assert.assertEquals("Actual and expected dates should match for each row",expectedDate, expiryDate.getText());
        }
    }
}
