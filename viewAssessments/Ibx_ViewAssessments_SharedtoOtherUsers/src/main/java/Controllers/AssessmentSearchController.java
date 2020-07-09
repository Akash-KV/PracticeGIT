package Controllers;

import Helpers.BrowserInitHelper;
import Helpers.DriverHelper;
import Helpers.JavascriptHelper;
import Pom.Dashboard;
import Pom.ViewAssessmentsPage;
import Utils.DataReaderViewAssessmentsSearch;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static Helpers.JavascriptHelper.waitUntilAjaxLoaded;

// Controller class for Assessment Search
public class AssessmentSearchController {

    ViewAssessmentsPage viewAssessment = new ViewAssessmentsPage();
    JavascriptHelper JSHelper = new JavascriptHelper();
    private static Dashboard dashboardPOM = new Dashboard();
    private static final Logger log = LoggerFactory.getLogger(BrowserInitHelper.class);

    // To validate View assessments search
    public void VerifyViewAssessmentSearch(String SearchText) {
        // Sending the value to the Search box
        DriverHelper.sendKeysId(viewAssessment.getViewAssessmentSearchtextbox(), SearchText, BrowserInitHelper.getWaiter(), BrowserInitHelper.getInstance());
        //clicking on the search button
        DriverHelper.clickId(viewAssessment.getViewAssessmentSearchtextboxButton(), BrowserInitHelper.getWaiter(), BrowserInitHelper.getInstance());
        //DriverHelper.getElementByXpath(viewAssessment.getloader());
        DriverHelper.waitUntilElementInvisible_ByXPath(viewAssessment.getloader());
        waitUntilAjaxLoaded();
    }

    // To Validate SearchedValidViewAssessmentTitleandOverview
    public boolean verifySearchedValidViewAssessmentTitleandOverview(String SearchText) {
        boolean bvalue = false;
        if (BrowserInitHelper.getWaiter().until(ExpectedConditions.elementToBeClickable(BrowserInitHelper.getInstance().findElement(By.xpath(dashboardPOM.getFirstLinkInAssessments())))).getText().equalsIgnoreCase(SearchText)) {
            log.info("Title matched in View Assessment Page");
            //clikcing on the Assessment name
            BrowserInitHelper.getWaiter().until(ExpectedConditions.elementToBeClickable(BrowserInitHelper.getInstance().findElement(By.xpath(dashboardPOM.getFirstLinkInAssessments())))).click();

            //checking the Assessment name in the overview page
            if (BrowserInitHelper.getWaiter().until(ExpectedConditions.elementToBeClickable(BrowserInitHelper.getInstance().findElement(By.xpath(dashboardPOM.getTitleInOverview())))).getText().equalsIgnoreCase(SearchText)) {
                log.info("Title matched in Overview Page");
                bvalue = true;
            } else {
                log.info("Title matched is not matched in Overview Page ");
            }
            Assert.assertTrue(bvalue);

        }
        return bvalue;
    }

    // To Validate SearchedViewAssessmentFirstRow
    public boolean verifySearchedViewAssessmentFirstRow(String SearchText) {
        boolean bvalue = false;
        List<WebElement> rowelements = BrowserInitHelper.getInstance().findElements(By.xpath(dashboardPOM.getFirstRow()));
        log.info("Size of List: " + rowelements.size());

        for (WebElement element : rowelements) {
            if (element.getText().contains(SearchText)) {
                log.info("Matched sucessfully --> " + element.getText());
                bvalue = true;
            } else if (element.getText().equalsIgnoreCase("No data available in table")) {
                log.info("No data available in table is displaying for the search");
                bvalue = true;
            }
        }

        return bvalue;
    }

    // To click toggleOn
    public static void toggleOn() {
        // To enable toggleOn
        JavascriptHelper.waitUntilDocumentIsReady();
        waitUntilAjaxLoaded();
        if (!BrowserInitHelper.getInstance().findElement(By.xpath(dashboardPOM.getToggle())).isSelected()) {
            DriverHelper.clickXpath(dashboardPOM.getOnlyWithData());
            waitUntilAjaxLoaded();
        }
    }

    // To click toggleOff
    public static void toggleOff() {
        // To enable toggleOff
        JavascriptHelper.waitUntilDocumentIsReady();
        waitUntilAjaxLoaded();
        if (BrowserInitHelper.getInstance().findElement(By.xpath(dashboardPOM.getToggle())).isSelected()) {
            DriverHelper.clickXpath(dashboardPOM.getOnlyWithData());
            waitUntilAjaxLoaded();
        }
    }
}