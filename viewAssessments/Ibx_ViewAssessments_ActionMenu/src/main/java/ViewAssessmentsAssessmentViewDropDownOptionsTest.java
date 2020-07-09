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

import java.util.ArrayList;
import java.util.List;

//Java Class for ViewAssessmentsAssessmentViewDropDownOptionsTest
@GraphWalker(value = "quick_random(edge_coverage(100))")
public class ViewAssessmentsAssessmentViewDropDownOptionsTest extends ExecutionContext implements ViewAssessmentsAssessmentsViewDropDownOptions {
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

    public void v_VerifyAssessmentViewTypeDataTable() {
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
        DriverHelper.waitForPageLoadComplete();
        DriverHelper.clickXpath(viewAssessmentsPage.getCreatedByMe());
    }

    public void v_VerifyCreatedByMeHeader() {
        /*Validate Created By me Header*/
        browserHelper.assertion(viewAssessmentsPage.getCreatedByMeHeader(), "Created By Me");
    }

    public void e_ClickAddFilters() {
        /*Click Add Filter button*/
        DriverHelper.waitForPageLoadComplete();
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
        DriverHelper.sendKeysXpath(viewAssessments_AddFilters.getTypeFilter(), "Assessment View", BrowserInitHelper.getWaiter(), BrowserInitHelper.getInstance());

        /*Select Item Bank option*/
        DriverHelper.clickXpath(viewAssessments_AddFilters.getTypeOption("Assessment View"));

        /*Click Search button*/
        JavascriptHelper.clickID_JS(viewAssessments_AddFilters.getSearchButton_AddFilters());
        DriverHelper.waitUntilLoaderInvisible();

        searchElementExist = DriverHelper.verifyDisplayByXpath(viewAssessmentsPage.getTypeAssessmentView());
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
        BrowserInitHelper.getInstance().findElement(By.xpath(viewAssessmentsPage.getSearchText())).sendKeys(viewAssessmentsPage.getAssessmentViewTitle());
        //DriverHelper.clickXpath(viewAssessmentsPage.getSearchButton());
        DriverHelper.clickId(viewAssessmentsPage.getSearchButton(), BrowserInitHelper.getWaiter(), BrowserInitHelper.getInstance());
        /*Click Action drop down*/
        DriverHelper.clickXpath(viewAssessmentsPage.getAssessmentViewActionDropDown());
    }

    public void e_ClickActionDropDownAndSelectShareOption() {
        /*Click Share option*/
        viewAssessmentsController.clickAssessmentViewShareOption("Share");
    }

    public void v_VerifyAssessmentSharePage() {
        //setAttribute("share", false);
        //setAttribute("duplicate", true);

        /*Validate the existence of Share canvas in share Assessement page*/
        WebElement Element = BrowserInitHelper.getInstance().findElement(By.xpath(assessmentSharePage.getShareCanvas()));
        Assert.assertTrue(DriverHelper.elementExistence(Element, BrowserInitHelper.getInstance()));
    }

    public void e_ClickActionDropDownAndSelectDuplicateOption() {
        /*Click Duplicate option*/
        viewAssessmentsController.clickAssessmentViewDuplicateOption("Duplicate");

        /*Click OK in Duplicate alert popup*/
        DriverHelper.switchToAlert(BrowserInitHelper.getWaiter());
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

    public void e_ClickActionDropDownAndSelectDeleteOption() {
        /*Click Delete option*/
        viewAssessmentsController.clickAssessmentViewDeleteOption("Delete");
    }

    public void v_VerifyAssessmentDeleteModal() {
        /*Validate the existence of Assessment Delete alert*/
        WebElement Element = BrowserInitHelper.getInstance().findElement(By.xpath(viewAssessmentsPage.getDeleteAlertMessage()));
        Assert.assertTrue(DriverHelper.elementExistence(Element, BrowserInitHelper.getInstance()));
    }

    public void e_ClickDeleteButton() {
        /*Check Yes, I am sure that the assessment is the one I want to delete checkbox*/
        DriverHelper.clickXpath(viewAssessmentsPage.getDeleteUnderstandCheckbox());

        /*Yes, Delete the assessment.*/
        DriverHelper.clickXpath(viewAssessmentsPage.getDeleteAgreeCheckbox());

        /*Click Delete Assessment button*/
        DriverHelper.clickXpath(viewAssessmentsPage.getDeleteAssessementButton());
//        viewAssessmentsController.clickAssessmentsDeleteOption("Delete");
    }

    public void v_VerifyAssessmentDelete() {
        //setAttribute("deleteAssessment", false);
        //setAttribute("functionDropDown", true);
        /*Validate the existence of Assessment Delete success message*/
        WebElement Element = BrowserInitHelper.getInstance().findElement(By.xpath(viewAssessmentsPage.getAlertSuccess()));
        Assert.assertTrue(DriverHelper.elementExistence(Element, BrowserInitHelper.getInstance()));
        //WebElement Element = BrowserInitHelper.getInstance().findElement(By.xpath(viewAssessmentsPage.getDeleteAlertMessage()));
        //Assert.assertTrue(DriverHelper.elementExistence(Element, BrowserInitHelper.getInstance()));
    }


    public void v_VerifyAssessmentTypeDataTable() {

    }

    public void v_VerifySkillsAssessmentTypeDataTable() {
        ConsoleLogger.SuccessLog("Complete the ViewAssessmentsAssessmentViewDropDownOptionsTest Java class");
    }
}
