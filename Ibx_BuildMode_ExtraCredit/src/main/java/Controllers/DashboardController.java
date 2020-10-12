package Controllers;

import Helpers.BrowserInitHelper;
import Pom.DashboardPage;
import Utils.ConsoleLogger;
import Utils.LoggerUtility;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

/**
 * Controller class for Dashboard
 **/
public class DashboardController {
    DashboardPage dashboardPagePOM = new DashboardPage();

    // To validate Dashboard Page
    public void VerifyDashboard() {
        BrowserInitHelper.getWaiter().until(ExpectedConditions.visibilityOfElementLocated(By.xpath(dashboardPagePOM.getIlluminateLogo())));
        if (BrowserInitHelper.getInstance().findElement(By.xpath(dashboardPagePOM.getIlluminateLogo())).isDisplayed()) {
            ConsoleLogger.SuccessLog("Test cases : Passed - DashboardPage Page is present");
            LoggerUtility.LoggerCall("Test cases : Passed - DashboardPage Page is present");
            Assert.assertTrue(true);
        } else {
            ConsoleLogger.FailedTestCase("Test cases : Failed - DashboardPage page is not present");
            LoggerUtility.LoggerCall("Test cases : Failed - DashboardPage page is not present");
            Assert.assertTrue(false);
        }
    }
}
