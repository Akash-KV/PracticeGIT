import Controllers.ViewAssessmentsController;
import Helpers.BrowserInitHelper;
import Helpers.DriverHelper;
import Helpers.JavascriptHelper;
import Pom.*;
import Utils.ConsoleLogger;
import org.graphwalker.core.machine.ExecutionContext;
import org.graphwalker.java.annotation.GraphWalker;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

@GraphWalker(value = "quick_random(edge_coverage(100))")
public class ViewAssessmentsDibelsDropDownOptionsTest extends ExecutionContext implements ViewAssessmentsDibelsAssessmentDropDownOptions {
    Dashboard dashboardPOM = new Dashboard();
    BrowserInitHelper browserHelper = new BrowserInitHelper();
    ViewAssessmentsPage viewAssessmentsPage = new ViewAssessmentsPage();
    ViewAssessmentsController viewAssessmentsController = new ViewAssessmentsController();
    ViewAssessments_AddFilters viewAssessments_AddFilters = new ViewAssessments_AddFilters();
    OnlineTestingAssessmentAdministrations onlineTesting = new OnlineTestingAssessmentAdministrations();
    OnlineAssessmentPreviewWindow onlineTestingPreviewWindow = new OnlineAssessmentPreviewWindow();
    CameraGraderPage cameraGraderPage = new CameraGraderPage();
    ViewStudentResponsesPage viewStudentsResponsesPage = new ViewStudentResponsesPage();
    AssessmentSharePage assessmentSharePage = new AssessmentSharePage();

    boolean isAdminster, searchElementExist = true;
    boolean isPreview, isScan, isViewResult, isShare, isDuplicate, isDelete = false;
    static boolean isTraversed = false;

    public void e_ClickViewAssessments() {
        /*Click Assessments icon in Navigation sidebar*/
        DriverHelper.clickXpath(dashboardPOM.getAssessmentsIcon());

        /*Click View Assessments Link*/
        DriverHelper.clickXpath(dashboardPOM.getViewAssessmentsLink());

        /*Wait until View Assessments header appears*/
        BrowserInitHelper.waitUntil(dashboardPOM.getViewAssessmentsHeader());
    }

    public void v_VerifyDibelsAssessmentTypeDataTable() {
        /*Validate the display of Assessment Data Table*/
        //WebElement Element = BrowserInitHelper.getInstance().findElement(By.xpath(viewAssessmentsPage.getAssessmentsDataTable()));
        //Assert.assertTrue(DriverHelper.elementExistence(Element, BrowserInitHelper.getInstance()));
    }

    public void v_VerifyDropDownOptions() {
        int dropdownCount = 0;
        BrowserInitHelper.getInstance().findElements(By.xpath(viewAssessmentsPage.getItemBankActionDropDownOptionsList()));
        List<WebElement> actualOptions = BrowserInitHelper.getInstance().findElements(By.xpath(viewAssessmentsPage.getItemBankActionList()));

        boolean isExist = false;
        try {
            for (int i = 0; i < actualOptions.size(); i++) {
                String dropdownText = actualOptions.get(i).getText();
                switch (dropdownText) {
                    case "Administer":
                    case "Preview":
                    case "Scan":
                    case "View Results":
                    case "Share":
                    case "Duplicate":
                    case "Delete":
                        dropdownCount++;
                        break;
                }
            }
            if (actualOptions.size() == dropdownCount) {
                isExist = true;
            }
            System.out.println(actualOptions.size() + "actualsize");
            System.out.println(dropdownCount + "dropdownCount");

        } catch (Exception e) {
            e.printStackTrace();
        }
        Assert.assertTrue(isExist);
    }

    public void e_ClickCreatedByMe() {
        /*Click Created By Me link*/
        DriverHelper.clickXpath(viewAssessmentsPage.getCreatedByMe());
    }

    public void v_VerifyCreatedByMeHeader() {
        /*Validate Created By me Header*/
//        browserHelper.assertion(viewAssessmentsPage.getCreatedByMeHeader(), "Created By Me");
        browserHelper.assertion(viewAssessmentsPage.getCreatedByMeHeader(), "Created By Me");
    }

    public void e_ClickAddFilters() {
        /*Click Add Filter button*/
        DriverHelper.clickXpath(viewAssessmentsPage.getAddFilters());
    }

    public void v_VerifyFilterModal() {
        /*Validate the display of Filters Modal*/
        WebElement Element = BrowserInitHelper.getInstance().findElement(By.xpath(viewAssessments_AddFilters.getAddFilterPopup()));
        Assert.assertTrue(DriverHelper.elementExistence(Element, BrowserInitHelper.getInstance()));
    }

    public void e_SelectPoolAssessmentTypeAndSearch() {
        /*Click Type filter*/
        DriverHelper.clickXpath(viewAssessments_AddFilters.getTypeFilter());

        /*Enter Pool Assessment in Type Filter*/
        DriverHelper.sendKeysXpath(viewAssessments_AddFilters.getTypeFilter(), "Pool Assessment", BrowserInitHelper.getWaiter(), BrowserInitHelper.getInstance());

        /*Select Pool Assessment option*/
        DriverHelper.clickXpath(viewAssessments_AddFilters.getTypeOption("Pool Assessment"));

        /*Click Search button*/
        JavascriptHelper.clickID_JS(viewAssessments_AddFilters.getSearchButton_AddFilters());
        DriverHelper.waitForPageLoadComplete();
        DriverHelper.waitUntilLoaderInvisible();
        searchElementExist = DriverHelper.verifyDisplayByXpath(viewAssessmentsPage.getTypePoolAssessment());
        if (searchElementExist) {

        } else {
            v_VerifyViewAssessmentsPage();
            e_ClickCreatedByMe();
            v_VerifyCreatedByMeHeader();
            e_ClickAddFilters();
            v_VerifyFilterModal();
            e_SelectPoolAssessmentTypeAndSearch();
        }
        ConsoleLogger.SuccessLog("Completed the Pool Assessment");
    }

    public void e_SelectDibelsSixthAssessmentTypeAndSearch() {
        /*Click Type filter*/
        DriverHelper.clickXpath(viewAssessments_AddFilters.getTypeFilter());
//
//        /*Enter Survey in Type Filter*/
//        DriverHelper.sendKeysXpath(viewAssessments_AddFilters.getTypeFilter(), "DIBELS Sixth", BrowserInitHelper.getWaiter(), BrowserInitHelper.getInstance());
//
//        /*Select Item Bank option*/
//        DriverHelper.clickXpath(viewAssessments_AddFilters.getTypeOption("DIBELS Sixth"));
//
        /*Click Search button*/
        JavascriptHelper.clickID_JS(viewAssessments_AddFilters.getSearchButton_AddFilters());
        ConsoleLogger.DebugLog("Searching for DibelSixth is done");
    }

    public void e_SelectDibelsNextAssessmentTypeAndSearch() {
        /*Click Type filter*/
        DriverHelper.clickXpath(viewAssessments_AddFilters.getTypeFilter());
//
//        /*Enter Survey in Type Filter*/
//        DriverHelper.sendKeysXpath(viewAssessments_AddFilters.getTypeFilter(), "DIBELS Next", BrowserInitHelper.getWaiter(), BrowserInitHelper.getInstance());
//
//        /*Select Item Bank option*/
//        DriverHelper.clickXpath(viewAssessments_AddFilters.getTypeOption("DIBELS Next"));
//
        /*Click Search button*/
        JavascriptHelper.clickID_JS(viewAssessments_AddFilters.getSearchButton_AddFilters());
        ConsoleLogger.DebugLog("DibelsNextAssessment is done");
    }

    public void e_SelectDibelsIdelAssessmentTypeAndSearch() {
        /*Click Type filter*/
        DriverHelper.clickXpath(viewAssessments_AddFilters.getTypeFilter());
//
//        /*Enter Survey in Type Filter*/
//        DriverHelper.sendKeysXpath(viewAssessments_AddFilters.getTypeFilter(), "DIBELS IDEL", BrowserInitHelper.getWaiter(), BrowserInitHelper.getInstance());
//
//        /*Select Item Bank option*/
//        DriverHelper.clickXpath(viewAssessments_AddFilters.getTypeOption("DIBELS IDEL"));
//
        /*Click Search button*/
        JavascriptHelper.clickID_JS(viewAssessments_AddFilters.getSearchButton_AddFilters());
        ConsoleLogger.DebugLog("DibelsIdeAssessment is Done");
    }

    public void e_SelectStateAssessmentTypeAndSearch() {
        /*Click Type filter*/
        DriverHelper.clickXpath(viewAssessments_AddFilters.getTypeFilter());

        /*Enter Survey in Type Filter*/
        DriverHelper.sendKeysXpath(viewAssessments_AddFilters.getTypeFilter(), "State & National Publisher Assessment", BrowserInitHelper.getWaiter(), BrowserInitHelper.getInstance());

        /*Select Item Bank option*/
        DriverHelper.clickXpath(viewAssessments_AddFilters.getTypeOption("State & National Publisher Assessment"));

        /*Click Search button*/
        JavascriptHelper.clickID_JS(viewAssessments_AddFilters.getSearchButton_AddFilters());
        DriverHelper.waitUntilLoaderInvisible();
        DriverHelper.waitForPageLoadComplete();

        searchElementExist = DriverHelper.verifyDisplayByXpath(viewAssessmentsPage.getTypeStateAndNationalPublisher());
        if (searchElementExist) {

        } else {
            v_VerifyViewAssessmentsPage();
            e_ClickCreatedByMe();
            v_VerifyCreatedByMeHeader();
            e_ClickAddFilters();
            v_VerifyFilterModal();
            e_SelectPoolAssessmentTypeAndSearch();
        }
        ConsoleLogger.SuccessLog("Completed the State & National Publisher Assessment");
    }

    public void v_VerifyViewAssessmentsPage() {
        /*Wait until the display of View Assessments header*/
        BrowserInitHelper.waitUntil(dashboardPOM.getViewAssessmentsHeader());

        browserHelper.assertion(dashboardPOM.getViewAssessmentsHeader(), "View Assessments");
    }

    public void v_VerifyAssessmentTypeDataTable() {

    }

    public void v_VerifyInExistenceofActionDropDown() {
        boolean notExist = false;

        try {
            WebElement Element = BrowserInitHelper.getInstance().findElement(By.xpath(viewAssessmentsPage.getActionDropDown()));
            if (Element.isDisplayed()) {
                notExist = false;
            } else {
                notExist = true;
            }
        } catch (NoSuchElementException e) {
            notExist = true;
        } catch (TimeoutException e) {
            notExist = true;
        } catch (Exception e) {
            notExist = true;
        }
        Assert.assertTrue(notExist);
    }

    public void v_VerifyUnpublishedItemBankHeader() {
//        /*Wait until Unpublished Item Bank header is visible*/
//        BrowserInitHelper.waitUntil(viewAssessmentsPage.getUnpublishedItemBankHeader());
//
//        /*Validate the existence of Assessement Change Author modal*/
//        WebElement Element = BrowserInitHelper.getInstance().findElement(By.xpath(viewAssessmentsPage.getUnpublishedItemBankHeader()));
//        Assert.assertTrue(DriverHelper.elementExistence(Element, BrowserInitHelper.getInstance()));
        ConsoleLogger.SuccessLog("Completed the ViewAssessmentsDibelsDropDownOptionsTest Java class");
    }
}