package tek.bdd.pages;

import org.openqa.selenium.By;

public class PlansPage {
    public static final By PLAN_ROWS_COUNT = By.xpath("//tbody/tr");
    public static final By CREATED_DATE = By.xpath("//tbody/tr/td[4]");
    public static final By EXPIRY_DATE = By.xpath("//tbody/tr/td[5]");
}
