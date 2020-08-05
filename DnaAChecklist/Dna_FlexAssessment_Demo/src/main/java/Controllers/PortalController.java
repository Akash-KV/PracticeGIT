package Controllers;

import org.graphwalker.Helper;
import org.graphwalker.PageObjectModels.OnlineTestingAdministrationPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Controllers class for Portal
 **/
public class PortalController {

    public static OnlineTestingAdministrationPage onlineTestingAdministrationPage = new OnlineTestingAdministrationPage();

    // To login
    public static void login(String username, String password, WebDriverWait waiter, WebDriver driver) {
        Helper.sendKeysXpath(onlineTestingAdministrationPage.getOnlineTestingAdministrationUsername(), username, waiter, driver);
        Helper.sendKeysXpath(onlineTestingAdministrationPage.getOnlineTestingAdministrationPassword(), password, waiter, driver);
        Helper.clickXpath(onlineTestingAdministrationPage.getOnlineTestingAdministrationLogin(), waiter, driver);
        if (driver.findElements(By.xpath(onlineTestingAdministrationPage.getOnlineTestingAdministrationResetPassword())).size() != 0) {
            Helper.sendKeysXpath(onlineTestingAdministrationPage.getOnlineTestingAdministrationResetPasswordFirst(), password, waiter, driver);
            Helper.sendKeysXpath(onlineTestingAdministrationPage.getOnlineTestingAdministrationResetPasswordSecond(), password, waiter, driver);
            Helper.clickXpath(onlineTestingAdministrationPage.getOnlineTestingAdministrationResetPasswordSubmit(), waiter, driver);
        }
    }

    // to click on Portal assessment
    public static void clickOnPortalAssessment(String title, WebDriverWait waiter, WebDriver driver) {
        Helper.clickXpath(onlineTestingAdministrationPage.getPortalAssessmentStudent(), waiter, driver);
        Helper.clickXpath(onlineTestingAdministrationPage.getPortalAssessment(), waiter, driver);
        for (int i = 0; i <= 75; i++) {
            if (driver.findElements(By.xpath("//a[contains(text(),'" + title + "')]")).size() != 0) {
                Helper.clickXpath("//a[contains(text(),'" + title + "')]", waiter, driver);
                break;
            }
            Helper.wait(1.0);
        }
    }
}