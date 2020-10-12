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
        //Verify DashboardPage Page
        BrowserInitHelper.getWaiter().until(ExpectedConditions.visibilityOfElementLocated(By.xpath(dashboardPagePOM.getIlluminateLogo())));
        if (BrowserInitHelper.getInstance().findElement(By.xpath(dashboardPagePOM.getIlluminateLogo())).isDisplayed()) {
            ConsoleLogger.SuccessLog("DashboardPage Page is present");
            LoggerUtility.LoggerCall("DashboardPage Page is present");
            Assert.assertTrue(true);
        } else {
            ConsoleLogger.FailedTestCase("DashboardPage page is not present");
            LoggerUtility.LoggerCall("DashboardPage page is not present");
            Assert.assertTrue(false);
        }
    }
}
