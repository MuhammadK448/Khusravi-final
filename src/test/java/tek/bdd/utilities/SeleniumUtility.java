package tek.bdd.utilities;

import io.cucumber.java.ca.Cal;
import io.cucumber.java.sl.In;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import tek.bdd.base.BaseSetup;

import javax.swing.text.DateFormatter;
import java.time.Duration;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

public class SeleniumUtility extends BaseSetup {
    private static final Logger LOGGER = LogManager.getLogger(SeleniumUtility.class);

    private WebDriverWait getWait() {
        return new WebDriverWait(getDriver(), Duration.ofSeconds(20));
    }

    private WebElement waitForVisibility(By locator){
        return getWait().until(ExpectedConditions.visibilityOfElementLocated(locator));
    }
    //Create a method to click on a given locator
    public void clickOnElement(By locator) {
        LOGGER.info("Clicking on Element {}", locator);
        getWait().until(ExpectedConditions.elementToBeClickable(locator)).click();
    }
    public void clickOnElement(WebElement locator) {
        LOGGER.info("Clicking on Element {}", locator);
        getWait().until(ExpectedConditions.elementToBeClickable(locator)).click();
    }

    //Enter text to the located element
    public void sendText(By locator, String value) {
        LOGGER.info("Clearing And Sending text {} to locator {}", value, locator);
        WebElement element = waitForVisibility(locator);
        element.sendKeys(Keys.CONTROL + "a");
        element.sendKeys(Keys.DELETE);
        element.sendKeys(value);
    }

    //Create method for getting the text of a located element
    public String getElementText(By locator){
        LOGGER.info("Get Element text {}", locator);
       return waitForVisibility(locator).getText();
    }

    public boolean isElementEnabled(By locator){
        LOGGER.info("Checking element is Enabled {}", locator);
        return waitForVisibility(locator).isEnabled();
    }

    public boolean isElementDisplayed(By locator){
        LOGGER.info("Checking element is Displayed {}", locator);
        return waitForVisibility(locator).isDisplayed();
    }

    public byte[] takeScreenShot(){ // Used in After hook method of HooksSteps
        TakesScreenshot screenshot = (TakesScreenshot) getDriver();
        return screenshot.getScreenshotAs(OutputType.BYTES);
    }

    public List<WebElement> getElementsList(By locator){
        return getWait().until(ExpectedConditions.visibilityOfAllElementsLocatedBy(locator));
    }

    public void SelectByText(WebElement element, String text){
        Select select = new Select(element);
        select.selectByVisibleText(text);
    }

    public String randomDataOfBirth(int yearStart, int yearEnd)
    {
        GregorianCalendar gc = new GregorianCalendar();
        int year = randBetween(yearStart, yearEnd);
        gc.set(Calendar.YEAR, year);
        int dayOfYear = randBetween(1, gc.getActualMaximum(Calendar.DAY_OF_YEAR));

        gc.set(Calendar.DAY_OF_YEAR, dayOfYear);
        String date = null;
        if(gc.get(Calendar.MONTH) == 0)
        {
            date = gc.get(Calendar.YEAR) + "-" + 1 + "-" + gc.get(Calendar.DAY_OF_MONTH);
        }else
        {
            date = gc.get(Calendar.MONTH) + "/" + gc.get(Calendar.DAY_OF_MONTH) + "/" + gc.get(Calendar.YEAR);
        }
        return date;
    }

    private int randBetween(int start, int end) {
        return start + (int)Math.round(Math.random() * (end - start));
    }
}
