import Controllers.ViewAssessmentsController;
import Helpers.BrowserInitHelper;
import Helpers.DriverHelper;
import Helpers.JavascriptHelper;
import Pom.*;
import org.graphwalker.core.machine.ExecutionContext;
import org.graphwalker.java.annotation.GraphWalker;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

@GraphWalker(value = "quick_random(edge_coverage(100))")
public class ViewAssessmentsFluenceDropDownOptionsTest extends ExecutionContext implements ViewAssessmentsFluenceDropDownOptions {
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

    boolean checkAfterSearch;
    boolean isAdminster = true;
    boolean isPreview, isScan, isViewResult, isShare, isDuplicate, isDelete = false;
    static boolean isTraversed = false;

    public void e_ClickViewAssessments() {
        // if(checkAfterSearch){  /*Click Assessments icon in Navigation sidebar*/
        DriverHelper.clickXpath(dashboardPOM.getAssessmentsIcon());

        /*Click View Assessments Link*/
        DriverHelper.clickXpath(dashboardPOM.getViewAssessmentsLink());

        /*Wait until View Assessments header appears*/
        BrowserInitHelper.waitUntil(dashboardPOM.getViewAssessmentsHeader());
    }
    // }

    public void v_VerifyFluenceTypeDataTable() {
        if (checkAfterSearch) {
            /*Validate the display of Assessment Data Table*/
            //WebElement Element = BrowserInitHelper.getInstance().findElement(By.xpath(viewAssessmentsPage.getAssessmentsDataTable()));
            //Assert.assertTrue(DriverHelper.elementExistence(Element, BrowserInitHelper.getInstance()));
        }
    }

    public void v_VerifyDropDownOptions() {
        if (checkAfterSearch) {
            int dropdownCount = 0;
            //getting all Dropdown options one by one
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
    }

    public void e_ClickCreatedByMe() {
        if (checkAfterSearch) {
            /*Click Created By Me link*/
            DriverHelper.clickXpath(viewAssessmentsPage.getCreatedByMe());
        }
    }

    public void v_VerifyCreatedByMeHeader() {
        if (checkAfterSearch) {
            /*Validate Created By me Header*/
            browserHelper.assertion(viewAssessmentsPage.getCreatedByMeHeader(), "Created By Me");
        }
    }

    public void e_ClickAddFilters() {
        // if(checkAfterSearch){
        /*Click Add Filter button*/

        DriverHelper.waitForPageLoadComplete();
        //DriverHelper.clickXpath(viewAssessmentsPage.getCreatedByMe());
        DriverHelper.clickXpath(viewAssessmentsPage.getAddFilters());
        // }
    }

    public void v_VerifyFilterModal() {
        if (checkAfterSearch) {
            /*Validate the display of Filters Modal*/
            WebElement Element = BrowserInitHelper.getInstance().findElement(By.xpath(viewAssessments_AddFilters.getAddFilterPopup()));
            Assert.assertTrue(DriverHelper.elementExistence(Element, BrowserInitHelper.getInstance()));
        }
    }

    public void e_SelectAssessmentTypeAndSearch() {
        try {/*Click Type filter*/
            DriverHelper.clickXpath(viewAssessments_AddFilters.getTypeFilter());

            /*Enter Fluence in Type Filter*/
            DriverHelper.sendKeysXpath(viewAssessments_AddFilters.getTypeFilter(), "Fluence", BrowserInitHelper.getWaiter(), BrowserInitHelper.getInstance());

            /*Select Item Bank option*/
            DriverHelper.clickXpath(viewAssessments_AddFilters.getTypeOption("Fluence"));

            /*Click Search button*/
            JavascriptHelper.clickID_JS(viewAssessments_AddFilters.getSearchButton_AddFilters());
            checkAfterSearch = true;
        } catch (Exception e) {
            checkAfterSearch = false;
            e.printStackTrace();
            System.out.println("Cancel button xpath:-->" + viewAssessmentsPage.getCancelAddFilter());
            JavascriptHelper.click_Xpath(viewAssessmentsPage.getCancelAddFilter());
            DriverHelper.waitUntilLoaderInvisible();
            BrowserInitHelper.getInstance().navigate().refresh();
        }
    }

    public void e_ClickActionDropDown() {
        if (checkAfterSearch) {
            /*Click Action drop down*/
            DriverHelper.clickXpath(viewAssessmentsPage.getFluenceActionDropDown());
        }
    }

    public void e_ClickActionDropDownAndSelectAdministerOption() {
        if (checkAfterSearch) {
            /*Click Administer option*/
            viewAssessmentsController.clickFluenceActionOption("Administer");
        }
    }

    public void v_VerifyOnlineTestingAssessmentAdministrationsPage() {
        if (checkAfterSearch) {
            isTraversed = true;
            /*Validate the Online Testing - Assessment Administrations page header*/
            WebElement Element = BrowserInitHelper.getInstance().findElement(By.xpath(onlineTesting.getOnlineTestingHeader()));
            Assert.assertTrue(DriverHelper.elementExistence(Element, BrowserInitHelper.getInstance()));
        }
    }

    public void e_ClickActionDropDownAndSelectPreviewOption() {
        if (checkAfterSearch) {
            /*Click Preview option*/
            viewAssessmentsController.clickFluenceActionOption("Preview");
        }
    }

    public void v_VerifyOnlineAssessmentPreviewModal() {
        if (checkAfterSearch) {
            /*Validate the Online Assessment Preview - Administration Options modal header*/
            //WebElement Element = BrowserInitHelper.getInstance().findElement(By.xpath(viewAssessmentsPage.getOnlineAssessmentPreviewHeader()));
            //Assert.assertTrue(DriverHelper.elementExistence(Element, BrowserInitHelper.getInstance()));
            browserHelper.assertion(viewAssessmentsPage.getOnlineAssessmentPreviewHeader(), "Online Assessment Preview - Administration Options");
        }
    }

    public void e_ClickPreviewButton() {
        if (checkAfterSearch) {
            /*Click Preview button*/
            DriverHelper.clickXpath(viewAssessmentsPage.getPreviewButton());
        }
    }

    public void v_VerifyOnlineAssessmentPreviewWindow() {
        if (checkAfterSearch) {
            /*Switch to Online Assessment Testing -Preview window*/
            ViewAssessmentsController.getWindowHandleAndSwitchWindow(BrowserInitHelper.getInstance());

            /*Validate the existence of Begin Test button in Online Assessment - Testing Preview window*/
            WebElement Element = BrowserInitHelper.getInstance().findElement(By.xpath(onlineTestingPreviewWindow.getBeginTestButton()));
            Assert.assertTrue(DriverHelper.elementExistence(Element, BrowserInitHelper.getInstance()));
        }
    }

    public void e_CloseOnlineAssessmentPreviewWindow() {
        if (checkAfterSearch) {
            /*Close the Online Assessment Preview Window and Switch back to main window*/
            ViewAssessmentsController.switchToMainWindow(BrowserInitHelper.getInstance());
            this.e_ClickViewAssessments();
        }
    }

    public void e_ClickActionDropDownAndSelectScanOption() {
        if (checkAfterSearch) {
            /*Click Scan option*/
            viewAssessmentsController.clickFluenceActionOption("Scan");
        }
    }

    public void v_VerifyCameraGraderPage() {
        if (checkAfterSearch) {
            DriverHelper.waitForPageLoadComplete();
            //first popup
            DriverHelper.switchToAlert(BrowserInitHelper.getWaiter());
            /*Validate the existence of Camera canvas in Scanning page*/
            WebElement Element = BrowserInitHelper.getInstance().findElement(By.xpath(cameraGraderPage.getCameraCanvas()));
            Assert.assertTrue(DriverHelper.elementExistence(Element, BrowserInitHelper.getInstance()));
        }
    }

    public void e_ClosePopupAndClickViewAssessments() {
        if (checkAfterSearch) {
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
    }

    public void e_SetShowAssessmentsWithDataToggleButton() {
        if (checkAfterSearch) { /*Set Show Assessments Without Data Toggle Button to Show mode*/
            JavascriptHelper.ClickByID_Javascript(viewAssessmentsPage.getShowAssessmentsWithoutDataToggleButton());

            /*Wait until loading icon disappears*/
            DriverHelper.waitUntilLoaderInvisible();
        }
    }

    public void v_VerifyAssessmentHavingStudentResponse() {
        if (checkAfterSearch) { /*Wait until the display of Assessment data table*/
            BrowserInitHelper.waitUntil(viewAssessmentsPage.getAssessmentsDataTable());

            /*Validate the Assessment which has Student data*/
            //WebElement currentDataElement = BrowserInitHelper.getInstance().findElement(By.xpath(viewAssessmentsPage.getHasStudentResponse()));
            //Assert.assertTrue(DriverHelper.elementExistence(currentDataElement, BrowserInitHelper.getInstance()));
        }
    }

    public void e_ClickActionDropDownAndSelectViewResultsOption() {
        if (checkAfterSearch) {
            /*Click Action drop down*/
            DriverHelper.clickXpath(viewAssessmentsPage.getFluenceActionDropDown());

            /*Click View Results option*/
            viewAssessmentsController.clickFluenceActionOption("View Results");
        }
    }

    public void v_VerifyStudentResponsesPage() {
        if (checkAfterSearch) {
            //setAttribute("viewResults", false);
            //setAttribute("share", true);

            /*Validate the existence of Save button in Student Responses page*/
            WebElement Element = BrowserInitHelper.getInstance().findElement(By.xpath(viewStudentsResponsesPage.getSaveButton()));
            Assert.assertTrue(DriverHelper.elementExistence(Element, BrowserInitHelper.getInstance()));
        }
    }

    public void e_ClickActionDropDownAndSelectViewShareOption() {
        if (checkAfterSearch) {
            /*Scroll till Action drop down*/
            JavascriptHelper.ScrollTillElement_Javascript(viewAssessmentsPage.getFluenceActionDropDown());

            /*Click Share option*/
            viewAssessmentsController.clickFluenceActionOption("Share");
        }
    }

    public void v_VerifyAssessmentSharePage() {
        if (checkAfterSearch) {
            //setAttribute("share", false);
            //setAttribute("duplicate", true);

            /*Validate the existence of Share canvas in share Assessement page*/
            WebElement Element = BrowserInitHelper.getInstance().findElement(By.xpath(assessmentSharePage.getShareCanvas()));
            Assert.assertTrue(DriverHelper.elementExistence(Element, BrowserInitHelper.getInstance()));
        }
    }

    public void e_ClickActionDropDownAndSelectDuplicateOption() {
        if (checkAfterSearch) {
            /*Scroll till Action drop down*/
            JavascriptHelper.ScrollTillElement_Javascript(viewAssessmentsPage.getFluenceActionDropDown());

            /*Click Duplicate option*/
            viewAssessmentsController.clickFluenceActionOption("Duplicate");

            /*Click OK in Duplicate alert popup*/
            DriverHelper.switchToAlert(BrowserInitHelper.getWaiter());
        }
    }

    public void v_VerifyAssessmentDuplication() {
        if (checkAfterSearch) {
            //setAttribute("duplicate", false);
            //setAttribute("deleteAssessment", true);
        }
    }

    public void e_ClickActionDropDownAndSelectDeleteOption() {
        if (checkAfterSearch) {
            /*Scroll till Action drop down*/
            JavascriptHelper.ScrollTillElement_Javascript(viewAssessmentsPage.getFluenceActionDropDown());

            /*Click Delete option*/
            viewAssessmentsController.clickFluenceActionOption("Delete");
        }
    }

    public void v_VerifyAssessmentDeleteModal() {
        if (checkAfterSearch) {
            /*Validate the existence of Assessment Delete alert*/
            WebElement Element = BrowserInitHelper.getInstance().findElement(By.xpath(viewAssessmentsPage.getDeleteAlertMessage()));
            Assert.assertTrue(DriverHelper.elementExistence(Element, BrowserInitHelper.getInstance()));
        }

    }

    public void e_ClickDeleteButton() {
        if (checkAfterSearch) {
            /*Check Yes, I am sure that the assessment is the one I want to delete checkbox*/
            DriverHelper.clickXpath(viewAssessmentsPage.getDeleteUnderstandCheckbox());

            /*Yes, Delete the assessment.*/
            DriverHelper.clickXpath(viewAssessmentsPage.getDeleteAgreeCheckbox());

            /*Click Delete Assessment button*/
            DriverHelper.clickXpath(viewAssessmentsPage.getDeleteAssessementButton());
        }
    }

    public void v_VerifyAssessmentDelete() {
        if (checkAfterSearch) {
            //setAttribute("deleteAssessment", false);

            //setAttribute("functionDropDown", true);
            /*Validate the existence of Assessment Delete success message*/
            WebElement Element = BrowserInitHelper.getInstance().findElement(By.xpath(viewAssessmentsPage.getAlertSuccess()));
            Assert.assertTrue(DriverHelper.elementExistence(Element, BrowserInitHelper.getInstance()));
        }
    }

    public void v_VerifyViewAssessmentsPage() {
        if (checkAfterSearch) {  //System.out.println("ViewAssessmentsFluenceDropDownOptionsTest==>v_VerifyViewAssessments");

            /*Wait until the display of View Assessments header*/
            BrowserInitHelper.waitUntil(dashboardPOM.getViewAssessmentsHeader());

            browserHelper.assertion(dashboardPOM.getViewAssessmentsHeader(), "View Assessments");
        }
    }


    public void v_VerifyAssessmentDataTable() {
        if (checkAfterSearch) {

        }
    }

    public void v_VerifySurveyTypeDataTable() {
        if (checkAfterSearch) {
        }
    }
}
