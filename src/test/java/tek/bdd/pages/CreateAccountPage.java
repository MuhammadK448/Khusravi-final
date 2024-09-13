package tek.bdd.pages;

import org.openqa.selenium.By;

public class CreateAccountPage {

    public static final By CREATE_PRIMARY_ACCOUNT_HOLDER_FORM_TITLE = By.xpath("//h2[text()='Create Primary Account Holder']");
    public static final By DATE_OF_BIRTH = By.id("dateOfBirth");
    public static final By CREATED_ACCOUNT_EMAIL = By.xpath("//h2[3]");
    public static final By ERROR_MESSAGE = By.xpath("(//div[@data-status='error'])[1]");
}
