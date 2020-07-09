package Controllers;

import Helpers.BrowserInitHelper;
import Helpers.DriverHelper;
import Helpers.JavascriptHelper;
import Pom.Dashboard;
import Pom.ViewAssessmentsPage;
import Pom.ViewAssessments_AddFilters;
import Utils.ConsoleLogger;
import Utils.DataReaderViewAssessmentsSearch;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static Helpers.JavascriptHelper.*;

// Controller Class for SharedtoOtherUser
public class SharedtoOtherUserController {

    ViewAssessmentsPage viewAssessment = new ViewAssessmentsPage();
    ViewAssessmentsPage viewAssessmentPOM = new ViewAssessmentsPage();
    ViewAssessments_AddFilters viewAssessmentsPage_AddFilters = new ViewAssessments_AddFilters();
    AddFilterController addFilterController = new AddFilterController();
    private static Dashboard dashboardPOM = new Dashboard();
    private static final Logger log = LoggerFactory.getLogger(BrowserInitHelper.class);

    // To validate ViewAssessmentSearch
    public void VerifyViewAssessmentSearch(String SearchText) {
        // Sending the value to the Search box
        DriverHelper.sendKeysId(viewAssessment.getViewAssessmentSearchtextbox(), SearchText, BrowserInitHelper.getWaiter(), BrowserInitHelper.getInstance());
        //clicking on the search button
        DriverHelper.clickId(viewAssessment.getViewAssessmentSearchtextboxButton(), BrowserInitHelper.getWaiter(), BrowserInitHelper.getInstance());
        //DriverHelper.getElementByXpath(viewAssessment.getloader());
        DriverHelper.waitUntilElementInvisible_ByXPath(viewAssessment.getloader());
    }

    //To validate Searched Valid ViewAssessment Title and Overview
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

    // to validate Searched ViewAssessment FirstRow
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

    // method to Select the filter required drop down option
    public boolean SelectFilterRequiredOption(String FilterSelection, String FilterOption) {
        boolean bvalue = false;

        //Clicking on the Add Filters
        try {
            JavascriptHelper.clickXpath_JS(viewAssessmentPOM.getAddFilterButton());

            //clicking on the Reset button
            clickID_JS(viewAssessmentsPage_AddFilters.getResetButton_AddFilters());
        }catch(TimeoutException e){
            JavascriptHelper.clickXpath_JS(viewAssessmentPOM.getAddEditFilterButton());
            //clicking on the Reset button
            clickID_JS(viewAssessmentsPage_AddFilters.getResetButton_AddFilters());
        }
        catch(JavascriptException e){
            JavascriptHelper.clickXpath_JS(viewAssessmentPOM.getAddEditFilterButton());
            //clicking on the Reset button
            clickID_JS(viewAssessmentsPage_AddFilters.getResetButton_AddFilters());
        }

        //selecting the Filter
        clickXpath_JS(FilterSelection);

        List<String> TypeList = addFilterController.getFilterValues(viewAssessmentsPage_AddFilters.getFilterValueList());
        for (String value : TypeList) {
            String finalTypeValue = value.trim();

            if (finalTypeValue.equalsIgnoreCase(FilterOption)) {
                //Set Value to Type Filter
                addFilterController.setFilterValue(viewAssessmentsPage_AddFilters.getTypeFilter(), finalTypeValue);

                //Click Search Button
                addFilterController.clickSearch();
                waitUntilAjaxLoaded();

                boolean checkEmptyTable = addFilterController.checkViewAssessments_EmptyTable(viewAssessmentPOM.getDataTableEmpty());
                if (checkEmptyTable) {
                    ConsoleLogger.SuccessLog("Test Case : Passed - No shared Assesment is present for the  Assessment type ----->" + FilterOption);
                } else {
                    bvalue = true;
                }

            }
        }
        return bvalue;
    }

    //Verifying the share icon and share current Permission popup
    public boolean VerifySharePopupDisplay(String AssessmenttypeText) {
        boolean bvalue = false;


        //taking the list of the type column
        List<WebElement> TypeColumnListElements = BrowserInitHelper.getInstance().findElements(By.xpath(viewAssessment.getTypeColumn()));

        for (int i = 0; i < TypeColumnListElements.size(); i++) {
            System.out.println("Filter text---->" + TypeColumnListElements.get(i).getText());
            if (TypeColumnListElements.get(i).getText().trim().equalsIgnoreCase(AssessmenttypeText)) {
                //clicking the share icon
                DriverHelper.clickXpath(viewAssessment.getShareIcon(i + 1));

                //checking for the model
                if (BrowserInitHelper.getWaiter().until(ExpectedConditions.elementToBeClickable(By.xpath(viewAssessmentPOM.getCurrentPermissionModelTitle()))).isDisplayed()) {
                    ConsoleLogger.SuccessLog("Test Case : Passed - Current Permission Model is displaying for the Assessment ---> " + AssessmenttypeText);
                } else {
                    ConsoleLogger.FailedTestCase("  Test Case : failed - Current Permission Model is not displaying for the Assessment ---> " + AssessmenttypeText);
                }

                JavascriptHelper.clickXpath_JS(viewAssessmentPOM.getCurrentPermissionModelcloseButton());
                waitUntilAjaxLoaded();

                break;
            }
        }
        return bvalue;
    }

    // To handle PopUp
    public void checkPopup() {
        try {
            BrowserInitHelper.getWaiter().until(ExpectedConditions.elementToBeClickable(By.xpath(viewAssessment.getPopup())));
            WebElement popup = BrowserInitHelper.getInstance().findElement(By.xpath(viewAssessment.getPopup()));
            Actions action = new Actions(BrowserInitHelper.getInstance());
            action.moveToElement(popup).click().perform();
            Thread.sleep(2000);
        } catch (Exception e) {
            System.out.println("Exception handled for alert popup.......");
        }
    }


}
