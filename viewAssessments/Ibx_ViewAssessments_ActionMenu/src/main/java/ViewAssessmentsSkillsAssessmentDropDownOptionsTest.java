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
public class ViewAssessmentsSkillsAssessmentDropDownOptionsTest extends ExecutionContext implements ViewAssessmentsSkillsAssessmentDropDownOptions {
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

    public void v_VerifySkillsAssessmentTypeDataTable() {
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
        DriverHelper.sendKeysXpath(viewAssessments_AddFilters.getTypeFilter(), "Skills Assessment", BrowserInitHelper.getWaiter(), BrowserInitHelper.getInstance());

        /*Select Item Bank option*/
        DriverHelper.clickXpath(viewAssessments_AddFilters.getTypeOption("Skills Assessment"));

        /*Click Search button*/
        JavascriptHelper.clickID_JS(viewAssessments_AddFilters.getSearchButton_AddFilters());

        DriverHelper.waitUntilLoaderInvisible();
        searchElementExist = DriverHelper.verifyDisplayByXpath(viewAssessmentsPage.getTypeSkillsAssessment());
        if (searchElementExist) {
//            WebElement Element = BrowserInitHelper.getInstance().findElement(By.xpath(viewAssessmentsPage.getAssessmentsDataTable()));
//            Assert.assertTrue( DriverHelper.elementExistence(Element, BrowserInitHelper.getInstance()));
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
        DriverHelper.clickXpath(viewAssessmentsPage.getSkillsAssessmentActionDropDown());
    }

    public void e_ClickActionDropDownAndSelectDuplicateOption() {
        /*Click Duplicate option*/
        viewAssessmentsController.clickSkillsAssessmentDuplicateOption("Duplicate");

    }

    public void v_VerifyAssessmentDuplication() {
//        /*Click Duplicate button*/
//        DriverHelper.clickXpath(viewAssessmentsPage.getSkillsAssessmentDuplicateButton());
//
//        /*Validate the existence of Duplicate alert message in Duplicate Skill Assessment page*/
        WebElement Element = BrowserInitHelper.getInstance().findElement(By.xpath(viewAssessmentsPage.getSkillsDuplicate()));
        Assert.assertTrue(DriverHelper.elementExistence(Element, BrowserInitHelper.getInstance()));
    }

    public void v_VerifyViewAssessmentsPage() {
        /*Wait until the display of View Assessments header*/
        BrowserInitHelper.waitUntil(dashboardPOM.getViewAssessmentsHeader());

        browserHelper.assertion(dashboardPOM.getViewAssessmentsHeader(), "View Assessments");
    }

    public void v_VerifyAssessmentTypeDataTable() {

    }

    public void v_VerifyPFTAssessmentTypeDataTable() {
        ConsoleLogger.SuccessLog("Completed the ViewAssessmentsSkillsAssessmentDropDownOptionsTest Java class");
    }
}
