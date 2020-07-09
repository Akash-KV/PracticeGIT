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
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.List;

@GraphWalker(value = "quick_random(edge_coverage(100))")
public class ViewAssessmentsSummaryDropDownOptionsTest extends ExecutionContext implements ViewAssessmentsSummaryDropDownOptions {
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

    boolean isAdminster, searchElementExist, checkToggleTable = true;
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

    public void v_VerifySummaryTypeDataTable() {
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

    public void e_SelectAssessmentTypeAndSearch() {
        /*Click Type filter*/
        DriverHelper.clickXpath(viewAssessments_AddFilters.getTypeFilter());

        /*Enter Survey in Type Filter*/
        DriverHelper.sendKeysXpath(viewAssessments_AddFilters.getTypeFilter(), "Summary Assessment", BrowserInitHelper.getWaiter(), BrowserInitHelper.getInstance());

        /*Select Item Bank option*/
        DriverHelper.clickXpath(viewAssessments_AddFilters.getTypeOption("Summary Assessment"));

        /*Click Search button*/
        JavascriptHelper.clickID_JS(viewAssessments_AddFilters.getSearchButton_AddFilters());

        DriverHelper.waitUntilLoaderInvisible();
        searchElementExist = DriverHelper.verifyDisplayByXpath(viewAssessmentsPage.getTypeSummaryAssessment());
        if (searchElementExist) {

        } else {
            v_VerifyViewAssessmentsPage();
            e_ClickCreatedByMe();
            v_VerifyCreatedByMeHeader();
            e_ClickAddFilters();
            v_VerifyFilterModal();
            e_SelectAssessmentTypeAndSearch();
        }
    }


    public void e_ClickActionDropDown() {
        /*Click Action drop down*/
        // DriverHelper.clickXpath(viewAssessmentsPage.getActionDropDown());
        BrowserInitHelper.getInstance().findElement(By.xpath(viewAssessmentsPage.getSearchText())).sendKeys(viewAssessmentsPage.getSummaryTitle());
        //DriverHelper.clickXpath(viewAssessmentsPage.getSearchButton());
        DriverHelper.clickId(viewAssessmentsPage.getSearchButton(), BrowserInitHelper.getWaiter(), BrowserInitHelper.getInstance());
        DriverHelper.clickXpath(viewAssessmentsPage.getSummaryActionDropDown());
    }

//    public void e_ClickActionDropDownAndSelectAdministerOption(){
//        /*Click Administer option*/
//        viewAssessmentsController.clickSummaryAdministerOption("Administer");
//    }
//
//    public void v_VerifyOnlineTestingAssessmentAdministrationsPage(){
//        isTraversed = true;
//        /*Validate the Online Testing - Assessment Administrations page header*/
//        WebElement Element = BrowserInitHelper.getInstance().findElement(By.xpath(onlineTesting.getOnlineTestingHeader()));
//        Assert.assertTrue(DriverHelper.elementExistence(Element, BrowserInitHelper.getInstance()));
//    }
//
//    public void e_ClickActionDropDownAndSelectScanOption(){
//        /*Click Scan option*/
//        viewAssessmentsController.clickSummaryScanOption("Scan");
//    }
//
//    public void v_VerifyCameraGraderPage(){
//        /*Validate the existence of Camera canvas in Scanning page*/
//        WebElement Element = BrowserInitHelper.getInstance().findElement(By.xpath(cameraGraderPage.getCameraCanvas()));
//        Assert.assertTrue(DriverHelper.elementExistence(Element, BrowserInitHelper.getInstance()));
//    }

    public void e_ClosePopupAndClickViewAssessments() {
        /*Click Assessments icon in Navigation sidebar*/
        DriverHelper.clickXpath(dashboardPOM.getAssessmentsIcon());

        /*Click View Assessments Link*/
        DriverHelper.clickXpath(dashboardPOM.getViewAssessmentsLink());

        /*Close Browser popup*/
        DriverHelper.switchToAlert(BrowserInitHelper.getWaiter());

        /*Wait until View Assessments header appears*/
        BrowserInitHelper.waitUntil(dashboardPOM.getViewAssessmentsHeader());

        //setAttribute("viewResults", true);
    }

    public void e_SetShowAssessmentsWithDataToggleButton() {
        /*Set Show Assessments Without Data Toggle Button to Show mode*/
        JavascriptHelper.ClickByID_Javascript(viewAssessmentsPage.getShowAssessmentsWithoutDataToggleButton());

        /*Wait until loading icon disappears*/
        DriverHelper.waitUntilLoaderInvisible();
    }

    public void v_VerifyAssessmentHavingStudentResponse() {
        /*Wait until the display of Assessment data table*/
        BrowserInitHelper.waitUntil(viewAssessmentsPage.getAssessmentsDataTable());

        /*Validate the Assessment which has Student data*/
        WebElement currentDataElement = BrowserInitHelper.getInstance().findElement(By.xpath(viewAssessmentsPage.getHasStudentResponse()));
        Assert.assertTrue(DriverHelper.elementExistence(currentDataElement, BrowserInitHelper.getInstance()));
    }

    public void e_ClickActionDropDownAndSelectViewResultsOption() {
        if (checkToggleTable) {
            DriverHelper.checkElementDisplayByXpath(viewAssessmentsPage.getNoDataAvailableInTable(), "checking Data table");
        } else {
            /*Click Action drop down*/
            DriverHelper.clickXpath(viewAssessmentsPage.getSummaryActionDropDown());

            /*Click View Results option*/
            viewAssessmentsController.clickSummaryViewResultOption("View Results");
        }
    }

    public void v_VerifyStudentResponsesPage() {
        //setAttribute("viewResults", false);
        //setAttribute("share", true);
        if (checkToggleTable) {
        } else {
            /*Validate the existence of Save button in Student Responses page*/
            WebElement Element = BrowserInitHelper.getInstance().findElement(By.xpath(viewStudentsResponsesPage.getSaveButton()));
            Assert.assertTrue(DriverHelper.elementExistence(Element, BrowserInitHelper.getInstance()));
        }
    }

    public void e_ClickActionDropDownAndSelectShareOption() {
        /*Scroll till Action drop down*/
        //JavascriptHelper.ScrollTillElement_Javascript(viewAssessmentsPage.getSummaryActionDropDown());

        /*Click Share option*/
        viewAssessmentsController.clickSummaryShareOption("Share");
    }

    public void v_VerifyAssessmentSharePage() {
        //setAttribute("share", false);
        //setAttribute("duplicate", true);

        /*Validate the existence of Share canvas in share Assessement page*/
        WebElement Element = BrowserInitHelper.getInstance().findElement(By.xpath(assessmentSharePage.getShareCanvas()));
        Assert.assertTrue(DriverHelper.elementExistence(Element, BrowserInitHelper.getInstance()));
    }

    public void e_ClickActionDropDownAndSelectDuplicateOption() {
        /*Scroll till Action drop down*/
        // JavascriptHelper.ScrollTillElement_Javascript(viewAssessmentsPage.getSummaryActionDropDown());

        /*Click Duplicate option*/
        viewAssessmentsController.clickSummaryDuplicateOption("Duplicate");

        /*Click OK in Duplicate alert popup*/
        DriverHelper.switchToAlert(BrowserInitHelper.getWaiter());
        BrowserInitHelper.getInstance().findElement(By.xpath(viewAssessmentsPage.getSearchText())).sendKeys(viewAssessmentsPage.getSummaryCopyTitle());
        //DriverHelper.clickXpath(viewAssessmentsPage.getSearchButton());
        DriverHelper.clickId(viewAssessmentsPage.getSearchButton(), BrowserInitHelper.getWaiter(), BrowserInitHelper.getInstance());
        DriverHelper.clickXpath(viewAssessmentsPage.getMassCheckBox());
        WebElement element = BrowserInitHelper.getInstance().findElement(By.xpath(viewAssessmentsPage.getMassDropdown()));
        Select select = new Select(element);
        select.selectByValue("delete");
        DriverHelper.clickXpath(viewAssessmentsPage.getMassSubmit());

        /*Check Yes, I am sure that the assessment is the one I want to delete checkbox*/
        DriverHelper.clickXpath(viewAssessmentsPage.getDeleteUnderstandCheckbox());

        /*Yes, Delete the assessment.*/
        DriverHelper.clickXpath(viewAssessmentsPage.getDeleteAgreeCheckbox());

        /*Click Delete Assessment button*/
        DriverHelper.clickXpath(viewAssessmentsPage.getDeleteAssessementButton());
    }

    public void v_VerifyAssessmentDuplication() {
        //setAttribute("duplicate", false);
        //setAttribute("deleteAssessment", true);
    }

    public void v_VerifyViewAssessmentsPage() {
        /*Wait until the display of View Assessments header*/
        BrowserInitHelper.waitUntil(dashboardPOM.getViewAssessmentsHeader());

        browserHelper.assertion(dashboardPOM.getViewAssessmentsHeader(), "View Assessments");
    }

    public void v_VerifyAssessmentTypeDataTable() {

    }

    public void v_VerifyAssessmentViewTypeDataTable() {
        ConsoleLogger.SuccessLog("Completed the ViewAssessmentsSummaryDropDownOptionsTest Java class");
    }
}
