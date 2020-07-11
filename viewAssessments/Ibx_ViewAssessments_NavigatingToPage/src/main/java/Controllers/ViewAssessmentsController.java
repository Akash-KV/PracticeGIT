package Controllers;

import Helpers.BrowserInitHelper;
import Helpers.DriverHelper;
import Helpers.JavascriptHelper;
import Pom.Dashboard;
import Pom.ViewAssessmentsPage;
import Utils.ConsoleLogger;
import Utils.DataReader;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

import static Helpers.JavascriptHelper.waitUntilAjaxLoaded;

//Controller class for ViewAssessments controller
public class ViewAssessmentsController {

    Dashboard dashboardPOM = new Dashboard();
    DriverHelper driverHelper = new DriverHelper();
    ViewAssessmentsPage viewAssessmentsPage = new ViewAssessmentsPage();

    BrowserInitHelper browserHelper = new BrowserInitHelper();

    //Click on ViewAssessments
    public void clickViewAssessments() {
        /*Click Assessments icon in Navigation sidebar*/
        driverHelper.clickXpath(dashboardPOM.getAssessmentsIcon());

        /*Click View Assessments Link*/
        driverHelper.clickXpath(dashboardPOM.getViewAssessmentsLink());
        checkPopup();

        /*Wait until View Assessments header appears*/
        BrowserInitHelper.waitUntil(dashboardPOM.getViewAssessmentsHeader());
    }

    public void checkPopup() {
        try {
            BrowserInitHelper.getWaiter().until(ExpectedConditions.elementToBeClickable(By.xpath(viewAssessmentsPage.getPopup())));
            WebElement popup = BrowserInitHelper.getInstance().findElement(By.xpath(viewAssessmentsPage.getPopup()));
            Actions action = new Actions(BrowserInitHelper.getInstance());
            action.moveToElement(popup).click().perform();
            Thread.sleep(2000);
        } catch (Exception e) {
            System.out.println("Exception handled for alert popup.......");
        }
    }

    //Validate ViewAssessments
    public void validateViewAssessments() {
        browserHelper.assertion(dashboardPOM.getViewAssessmentsHeader(), "View Assessments");
        ConsoleLogger.SuccessLog("Navigated to View Assessments from View Assessments Link...");
    }

    // Click on Illuminate Logo
    public void clickIlluminateLogo() {
        /*Click Illuminate Logo in Navigation sidebar*/
        driverHelper.clickXpath(dashboardPOM.getIlluminateLogo());
    }

    //Click ViewAssessments Tile
    public void clickViewAssessmentsTile() {
        String TitleTile;

        /*Get all the Titles shown in Dashboard flip cards*/
        List<WebElement> TileTitleElement = BrowserInitHelper.getInstance().findElements(By.xpath("//ul[@id = 'tile-holder']/li//div[@class = 'tile-title']"));

        for (int i = 0; i < TileTitleElement.size(); i++) {
            TitleTile = TileTitleElement.get(i).getText().replaceAll("\n", " ");

            /*Validate if View Assessment tile is showing or not*/
            if (TitleTile.equalsIgnoreCase("View Assessments")) {
                TileTitleElement.get(i).click();
                break;
            }
        }

        /*Wait until View Assessments header appears*/
        BrowserInitHelper.waitUntil(dashboardPOM.getViewAssessmentsHeader());
    }

    //Validate View Assessments
    public void verifyViewAssessments() {
        browserHelper.assertion(dashboardPOM.getViewAssessmentsHeader(), "View Assessments");
        ConsoleLogger.SuccessLog("Navigated to View Assessments from Dashboard Tile...");
    }

    // To turn off toggle button
    public void turnOFFToggleButton() {
        if (JavascriptHelper.getToggleButtonState(viewAssessmentsPage.getShowAssessmentsWithoutDataToggleButton()).equalsIgnoreCase("true")) {
            /*Click Show Assessments Without Data toggle button*/
            JavascriptHelper.ClickByID_Javascript(viewAssessmentsPage.getShowAssessmentsWithoutDataToggleButton());
            DriverHelper.waitFluentByXPath(BrowserInitHelper.getInstance(), viewAssessmentsPage.getViewAssessmentPageHeader());

        }
    }

    // To clear added filter
    public void clearAddedFilter() {
        try {
            BrowserInitHelper.getWaiter().until(ExpectedConditions.elementToBeClickable(BrowserInitHelper.getInstance().findElement(By.xpath(viewAssessmentsPage.getClearAllFilters())))).click();
            waitUntilAjaxLoaded();
        } catch (Exception e) {
            System.out.println("Exception handled for clear all link...");
        }
    }

    // To clear search text box
    public void clearSearchTextBox() {
        try {
            BrowserInitHelper.getWaiter().until(ExpectedConditions.elementToBeClickable(By.id(viewAssessmentsPage.getViewAssessmentSearchTextBox()))).clear();
            BrowserInitHelper.getWaiter().until(ExpectedConditions.elementToBeClickable(By.id(viewAssessmentsPage.getViewAssessmentSearchtextboxButton()))).click();

            DriverHelper.waitFluentByXPath(BrowserInitHelper.getInstance(), viewAssessmentsPage.getViewAssessmentPageHeader());
        } catch (Exception e) {
            System.out.println("Exception handled for clearing search text box");
        }
    }

}
