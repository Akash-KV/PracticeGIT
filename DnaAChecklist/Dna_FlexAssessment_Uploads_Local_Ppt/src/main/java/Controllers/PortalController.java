package Controllers;

import org.graphwalker.Helper;
import org.graphwalker.PageObjectModels.OnlineTestingAdministrationPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PortalController {

    public static OnlineTestingAdministrationPage onlineTestingAdministrationPage = new OnlineTestingAdministrationPage();

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

    public static void clickOnPortalAssessment(String title, WebDriverWait waiter, WebDriver driver) {
        Helper.clickXpath(onlineTestingAdministrationPage.getOnlineTestingAdministrationResetPasswordTakeAssessment(), waiter, driver);
        Helper.clickXpath("//a[contains(text(),'" + title + "')]", waiter, driver);
    }
}
