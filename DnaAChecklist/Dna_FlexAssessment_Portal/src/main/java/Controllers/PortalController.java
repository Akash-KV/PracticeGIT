package Controllers;

import org.graphwalker.Helper;
import org.graphwalker.PageObjectModels.OnlineTestingAdministrationPage;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Controllers class for Portal
 **/
public class PortalController {
    public static OnlineTestingAdministrationPage onlineTestingAdministrationPage = new OnlineTestingAdministrationPage();

    // To login for Taking test
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
        try {
            Thread.sleep(3000);
            waiter.until(ExpectedConditions.elementToBeClickable(By.xpath(onlineTestingAdministrationPage.getOnlineTestingAdministrationportalAssessmentLink())));
            Helper.clickXpath(onlineTestingAdministrationPage.getOnlineTestingAdministrationportalAssessmentLink(), waiter, driver);
            Helper.clickXpath(onlineTestingAdministrationPage.getPortalAssessment(), waiter, driver);
            Thread.sleep(3000);
            for (int i = 0; i <= 200; i++) {
                if (driver.findElements(By.xpath("//a[contains(text(),'" + title + "')]")).size() != 0) {
                    //Scroll till element
                    WebElement element = driver.findElement(By.xpath("//a[contains(text(),'" + title + "')]"));
                    ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
                    Thread.sleep(2000);
                    Helper.clickXpath("//a[contains(text(),'" + title + "')]", waiter, driver);
                    break;
                }
                Helper.wait(1.0);
            }
        } catch (Exception e) {
            System.out.println("Exception handled for method - clickOnPortalAssessment" + e);
        }
    }
}
