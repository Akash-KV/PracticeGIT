package Controllers;

import Helpers.BrowserInitHelper;
import Helpers.DriverHelper;
import Helpers.JavascriptHelper;
import Pom.Dashboard;
import Pom.ViewAssessmentsPage;
import Utils.ConsoleLogger;
import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static Helpers.JavascriptHelper.*;

/**
 * Controller class for AddFilter
 **/

public class AddFilterController {
    public static ViewAssessmentsPage viewAssessmentsPage = new ViewAssessmentsPage();
    public static Dashboard dashboard = new Dashboard();

    // To Clear and Search
    public static void clearSearch(String value) {
        waitUntilAjaxLoaded();
        try {
            DriverHelper.clickXpath(viewAssessmentsPage.getClearAllInViewAssessments());
            BrowserInitHelper.getWaiter().until(ExpectedConditions.elementToBeClickable(By.id(viewAssessmentsPage.getViewAssessmentSearchtextbox()))).clear();
            BrowserInitHelper.getWaiter().until(ExpectedConditions.elementToBeClickable(By.id(viewAssessmentsPage.getViewAssessmentSearchtextbox()))).sendKeys(value);
            BrowserInitHelper.getWaiter().until(ExpectedConditions.elementToBeClickable(By.id(viewAssessmentsPage.getViewAssessmentSearchtextboxButton()))).click();
        } catch (Exception e) {
            BrowserInitHelper.getWaiter().until(ExpectedConditions.elementToBeClickable(By.id(viewAssessmentsPage.getViewAssessmentSearchtextbox()))).clear();
            BrowserInitHelper.getWaiter().until(ExpectedConditions.elementToBeClickable(By.id(viewAssessmentsPage.getViewAssessmentSearchtextbox()))).sendKeys(value);
            BrowserInitHelper.getWaiter().until(ExpectedConditions.elementToBeClickable(By.id(viewAssessmentsPage.getViewAssessmentSearchtextboxButton()))).click();
        }
    }

    // To toggle On
    public static void toggleOn() {
        JavascriptHelper.waitUntilDocumentIsReady();
        waitUntilAjaxLoaded();
        if (!BrowserInitHelper.getInstance().findElement(By.xpath(dashboard.getToggle())).isSelected()) {
            DriverHelper.clickXpath(dashboard.getOnlyWithData());
            waitUntilAjaxLoaded();
        }
    }

    // To toggleOff
    public static void toggleOff() {
        JavascriptHelper.waitUntilDocumentIsReady();
        waitUntilAjaxLoaded();
        if (BrowserInitHelper.getInstance().findElement(By.xpath(dashboard.getToggle())).isSelected()) {
            DriverHelper.clickXpath(dashboard.getOnlyWithData());
            waitUntilAjaxLoaded();
        }
    }

    // To check Element is clickable
    public static boolean isElementClickable(String xpath, String name) {
        boolean value = false;
        waitUntilAjaxLoaded();
        if (BrowserInitHelper.getInstance().findElement(By.xpath(xpath)).isDisplayed()) {
            ConsoleLogger.SuccessLog("" + name + " is present");
            Assert.assertTrue(true);
            WebElement link = BrowserInitHelper.getInstance().findElement(By.xpath(xpath));
            String text = link.getAttribute("href");
            if (text != null) {
                ConsoleLogger.SuccessLog("" + name + " is Clikable");
                value = true;
            } else {
                ConsoleLogger.FailedTestCase("" + name + " is not Clikable");
            }
        } else {
            ConsoleLogger.FailedTestCase("" + name + " is not present");
            Assert.assertTrue(false);
        }
        return value;

    }

    // To check element is not Clickable
    public static boolean isElementNotClickable(String xpath, String name) {
        boolean value = false;
        waitUntilAjaxLoaded();
        if (BrowserInitHelper.getInstance().findElement(By.xpath(xpath)).isDisplayed()) {
            ConsoleLogger.SuccessLog("" + name + " is present");
            Assert.assertTrue(true);
            WebElement link = BrowserInitHelper.getInstance().findElement(By.xpath(xpath));
            String text = link.getAttribute("href");
            if (text == null) {
                ConsoleLogger.SuccessLog("" + name + " is NotClikable");
                value = true;
            } else {
                ConsoleLogger.FailedTestCase("" + name + " is Clikable");
            }
        } else {
            ConsoleLogger.FailedTestCase("" + name + " is not present");
            Assert.assertTrue(false);
        }
        return value;
    }


}
