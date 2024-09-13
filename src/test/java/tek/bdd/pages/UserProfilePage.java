package tek.bdd.pages;

import org.openqa.selenium.By;

public class UserProfilePage {
    public static final By PROFILE_ICON = By.xpath("//button[@aria-label='profile']");
    public static final By FULL_NAME = By.xpath("//p[text()='FULL NAME']/following-sibling::p");
}
