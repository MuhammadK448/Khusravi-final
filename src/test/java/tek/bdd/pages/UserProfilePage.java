package tek.bdd.pages;

import org.openqa.selenium.By;

public class UserProfilePage {
    public static final By PROFILE_ICON = By.xpath("//button[@aria-label='profile']");
    public static final By FULL_NAME = By.xpath("//p[text()='FULL NAME']/following-sibling::p");
    public static final By PROFILE_SIDEBAR_HEADER = By.xpath("//header[text()='Profile']");
    public static final By USER_AUTHORITY = By.xpath("//p[text()='AUTHORITIES']/following-sibling::ul/li");
    public static final By USER_STATUS = By.xpath("//p[text()='STATUS']/following-sibling::p");
}
