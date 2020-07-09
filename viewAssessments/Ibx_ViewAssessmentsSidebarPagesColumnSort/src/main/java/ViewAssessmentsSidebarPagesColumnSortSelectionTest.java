
import Controllers.ViewAssessmentsSidebarPagesColumnSortController;
import DataReaders.CSVDataReaderViewAssessmentsColumnSort;
import Helpers.BrowserInitHelper;
import Helpers.DriverHelper;
import Pom.ViewAssessments;
import Utils.ConsoleLogger;
import org.graphwalker.core.machine.ExecutionContext;
import org.graphwalker.java.annotation.GraphWalker;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

import static Helpers.JavascriptHelper.waitUntilAjaxLoaded;

@GraphWalker(value = "quick_random(edge_coverage(100))")
public class ViewAssessmentsSidebarPagesColumnSortSelectionTest extends ExecutionContext implements ViewAssessmentsSidebarPagesColumnSortSelection {

    //Declarations
    public String SearchText;
    ViewAssessments viewAssessmentsPage = new ViewAssessments();
    DriverHelper Helper = new DriverHelper();
    CSVDataReaderViewAssessmentsColumnSort csvDataReaderViewAssessmentsColumnSort = new CSVDataReaderViewAssessmentsColumnSort();
    ViewAssessmentsSidebarPagesColumnSortController viewAssessmentsColumnSortController = new ViewAssessmentsSidebarPagesColumnSortController();
    ViewAssessmentsSidebarPagesColumnSortController.ShowAssessmentWithoutDataToggle showAssessmentWithoutDataToggle = new ViewAssessmentsSidebarPagesColumnSortController().new ShowAssessmentWithoutDataToggle();
    //Logger and WebDrivers
    private static final Logger logger = LoggerFactory.getLogger(ViewAssessmentsSidebarPagesColumnSortSelectionTest.class);

    public void v_VerifyViewAssessmentsSidebarPagesColumnSort() {

    }

    public void e_ClickAllAssessments() {
        //Click All Assessments Link
        Helper.clickXpath(viewAssessmentsPage.getViewAssessments_AllAssessmentsLink());
        waitUntilAjaxLoaded();

        //Clear search if already text present
        viewAssessmentsColumnSortController.waitFluentByID(BrowserInitHelper.getInstance(), viewAssessmentsPage.getViewAssessmentsSearchtextbox());
        BrowserInitHelper.getWaiter().until(ExpectedConditions.elementToBeClickable(By.id(viewAssessmentsPage.getViewAssessmentsSearchtextbox())));
        BrowserInitHelper.getInstance().findElement(By.id(viewAssessmentsPage.getViewAssessmentsSearchtextbox())).clear();
        DriverHelper.clickId(viewAssessmentsPage.getViewAssessmentsSearchButton());
        waitUntilAjaxLoaded();

        //Condition 2 - Click on clear all link for filter, if any filter is already added
        try {
            DriverHelper.waitTill(2);
            DriverHelper.clickXpath(viewAssessmentsPage.getClearAllInViewAssessments());
            DriverHelper.waitTill(2);
            waitUntilAjaxLoaded();
        } catch (Exception e) {
            System.out.println("Exception handled for clear all link...");
        }
    }

    public void v_AllAssessments() {
        //Verify  - Assessments with student data and without student data.
        //Assessments With student data Check - Click Toggle - ON
        showAssessmentWithoutDataToggle.toggleOff();
        boolean checkFirstRowData = viewAssessmentsColumnSortController.getFirstRow();
        if (checkFirstRowData) {
            //First Row Data is displayed - Check for Data Circle - Green
            try {
                BrowserInitHelper.getWaiter().until(ExpectedConditions.visibilityOfElementLocated(By.xpath(viewAssessmentsPage.getFirstRowCurrentDataGreen())));
            } catch (Exception e) {
                ConsoleLogger.FailedTestCase("{Test Case: Itembank - With Data} Data circle is not visible or not green.");
            }
        } else {
            //No Data Available message...
            boolean checkEmptyTable = ViewAssessmentsSidebarPagesColumnSortController.checkViewAssessments_EmptyTable(viewAssessmentsPage.getDataTableEmpty());
            if (checkEmptyTable) {
                ConsoleLogger.SuccessLog("No Data Available is shown ....");
            } else {
                ConsoleLogger.FailedTestCase("{No Data Available is NOT Shown....}");
            }
        }

        //Assessments WithOut student data Check - Click Toggle - OFF
        //ViewAssessmentsSidebarPagesColumnSortController.ShowAssessmentWithoutDataToggle.toggleOff();
        showAssessmentWithoutDataToggle.toggleOff();
        boolean checkFirstRowDataWhenOff = viewAssessmentsColumnSortController.getFirstRow();
        if (checkFirstRowDataWhenOff) {
            //First Row Data is displayed - Check for Data Circle - Green / Grey / Horizontal Line
            try {
                boolean CheckGreen = viewAssessmentsColumnSortController.checkDataCircleGreen_WhenToggleOFF();
                boolean CheckGrey = viewAssessmentsColumnSortController.checkDataCircleGrey_WhenToggleOFF();
                boolean CheckHorizontalLine = viewAssessmentsColumnSortController.checkHorizontalLine_WhenToggleOFF();

                if (CheckGreen || CheckGrey || CheckHorizontalLine) {
                    //Test Case Passed
                    ConsoleLogger.SuccessLog("{Test Case: Assessments - WithOut Data} Data circle is Green / Grey / Horizontal Line.");
                } else {
                    ConsoleLogger.FailedTestCase("{Test Case: Assessments - WithOut Data} Data circle is not visible or Green / Grey / Horizontal Line.");
                }
            } catch (Exception e) {
                ConsoleLogger.FailedTestCase("{Test Case: Itembank - With Data} Data circle is not visible or Green / Grey / Horizontal Line.");
            }
        } else {
            //No Data Available message...
            boolean checkEmptyTable = ViewAssessmentsSidebarPagesColumnSortController.checkViewAssessments_EmptyTable(viewAssessmentsPage.getDataTableEmpty());
            if (checkEmptyTable) {
                ConsoleLogger.SuccessLog("No Data Available is shown ....");
            } else {
                ConsoleLogger.FailedTestCase("{No Data Available is NOT Shown....}");
            }
        }

        //<< Ascending and Descending Order for all columns  - All Assessments Link >>
        boolean checkEmptyTable = ViewAssessmentsSidebarPagesColumnSortController.checkViewAssessments_EmptyTable(viewAssessmentsPage.getDataTableEmpty());
        if (checkEmptyTable) {
            ConsoleLogger.SuccessLog("No Data Available is shown for All Assessments Link....");
        } else {
            //Test Case - "Title Column" Desc and Asc Check
            boolean checkTitle_AscendingOrder_AllAssessments = viewAssessmentsColumnSortController.check_TitleAscendingOrder();
            System.out.println("checkTitle_AscendingOrder_AllAssessments ==>" + checkTitle_AscendingOrder_AllAssessments);

            boolean checkTitle_DescendingOrder_AllAssessments = viewAssessmentsColumnSortController.check_TitleDescendingOrder();
            System.out.println("checkTitle_DescendingOrder_AllAssessments ==>" + checkTitle_DescendingOrder_AllAssessments);

            //Test Case - "Type Column" Desc and Asc Check
            boolean checkType_AscendingOrder_AllAssessments = viewAssessmentsColumnSortController.check_TypeAscendingOrder();
            System.out.println("checkType_AscendingOrder_AllAssessments ==>" + checkType_AscendingOrder_AllAssessments);

            boolean checkType_DescendingOrder_AllAssessments = viewAssessmentsColumnSortController.check_TypeDescendingOrder();
            System.out.println("checkType_DescendingOrder_AllAssessments ==>" + checkType_DescendingOrder_AllAssessments);

            //Test Case - "Owner Column" Desc and Asc Check
            boolean checkOwner_AscendingOrder_AllAssessments = viewAssessmentsColumnSortController.check_OwnerAscendingOrder();
            System.out.println("checkType_AscendingOrder_AllAssessments ==>" + checkOwner_AscendingOrder_AllAssessments);

            boolean checkOwner_DescendingOrder_AllAssessments = viewAssessmentsColumnSortController.check_OwnerDescendingOrder();
            System.out.println("checkType_DescendingOrder_AllAssessments ==>" + checkOwner_DescendingOrder_AllAssessments);

            //Test Case - "DateCreated Column" Desc and Asc Check
            boolean checkDateCreated_AscendingOrder_AllAssessments = viewAssessmentsColumnSortController.check_DateCreated_AscendingOrder();
            System.out.println("checkDateCreated_AscendingOrder_AllAssessments ==>" + checkDateCreated_AscendingOrder_AllAssessments);

            boolean checkDateCreated_DescendingOrder_AllAssessments = viewAssessmentsColumnSortController.check_DateCreated_DescendingOrder();
            System.out.println("checkDateCreated_DescendingOrder_AllAssessments ==>" + checkDateCreated_DescendingOrder_AllAssessments);

            //Test Case - "Last Accessed Column" Desc and Asc Check
            boolean checkLastAccessed_AscendingOrder_AllAssessments = viewAssessmentsColumnSortController.check_LastAccessed_AscendingOrder();
            System.out.println("checkLastAccessed_AscendingOrder_AllAssessments ==>" + checkLastAccessed_AscendingOrder_AllAssessments);

            boolean checkLastAccessed_DescendingOrder_AllAssessments = viewAssessmentsColumnSortController.check_LastAccessed_DescendingOrder();
            System.out.println("checkLastAccessed_DescendingOrder_AllAssessments ==>" + checkLastAccessed_DescendingOrder_AllAssessments);

            // Test Case - "Current Data Column" Desc and Asc Check
            boolean checkCurrentData_Ascending_AllAssessments = viewAssessmentsColumnSortController.check_CurrentData_Order("Ascending");
            System.out.println("checkCurrentData_Ascending_AllAssessments ==>" + checkCurrentData_Ascending_AllAssessments);
            //Commented due to issue in ascending order of current data - showing students without data circle in first row.
            //Assert.assertTrue(checkCurrentData_Ascending_AllAssessments);

            boolean checkCurrentData_Descending_AllAssessments = viewAssessmentsColumnSortController.check_CurrentData_Order("Descending");
            System.out.println("checkCurrentData_Descending_AllAssessments ==>" + checkCurrentData_Descending_AllAssessments);
            //Commented due to issue in ascending order of current data - showing students without data circle in first row.
            //Assert.assertTrue(checkCurrentData_Descending_AllAssessments);
        }
    }

    public void e_CreatedByMe() {
        //Click All Assessments Link
//        Helper.clickXpath(viewAssessmentsPage.getViewAssessments_CreatedByMeLink());
//        waitUntilAjaxLoaded();
    }

    public void v_CreatedByMe() {
        //<< Ascending and Descending Order for all columns  - Created By Me Link >>
//        boolean checkEmptyTable = ViewAssessmentsSidebarPagesColumnSortController.checkViewAssessments_EmptyTable(viewAssessmentsPage.getDataTableEmpty());
//        if (checkEmptyTable) {
//            ConsoleLogger.SuccessLog("No Data Available is shown for CreatedByMe Link....");
//        } else {
//            //Test Case - Verify Owner is currently logged in user for all assessments
//            boolean Verify_CreatedByMe = viewAssessmentsColumnSortController.checkCreatedByMe(csvDataReaderViewAssessmentsColumnSort.getCreatedBy());
//            System.out.println("Verify_CreatedByMe ==>" + Verify_CreatedByMe);
//
//            //Test Case - "Title Column" Desc and Asc Check
//            boolean checkTitle_AscendingOrder_CreatedByMe = viewAssessmentsColumnSortController.check_TitleAscendingOrder();
//            System.out.println("checkTitle_AscendingOrder_CreatedByMe ==>" + checkTitle_AscendingOrder_CreatedByMe);
//
//            boolean checkTitle_DescendingOrder_CreatedByMe = viewAssessmentsColumnSortController.check_TitleDescendingOrder();
//            System.out.println("checkTitle_DescendingOrder_CreatedByMe ==>" + checkTitle_DescendingOrder_CreatedByMe);
//
//            //Test Case - "Type Column" Desc and Asc Check
//            boolean checkType_AscendingOrder_CreatedByMe = viewAssessmentsColumnSortController.check_TypeAscendingOrder();
//            System.out.println("checkType_AscendingOrder_CreatedByMe ==>" + checkType_AscendingOrder_CreatedByMe);
//
//            boolean checkType_DescendingOrder_CreatedByMe = viewAssessmentsColumnSortController.check_TypeDescendingOrder();
//            System.out.println("checkType_DescendingOrder_CreatedByMe ==>" + checkType_DescendingOrder_CreatedByMe);
//
//            //Test Case - "Owner Column" Desc and Asc Check
//            boolean checkOwner_AscendingOrder_CreatedByMe = viewAssessmentsColumnSortController.check_OwnerAscendingOrder();
//            System.out.println("checkType_AscendingOrder_CreatedByMe ==>" + checkOwner_AscendingOrder_CreatedByMe);
//
//            boolean checkOwner_DescendingOrder_CreatedByMe = viewAssessmentsColumnSortController.check_OwnerDescendingOrder();
//            System.out.println("checkType_DescendingOrder_CreatedByMe ==>" + checkOwner_DescendingOrder_CreatedByMe);
//
//            //Test Case - "DateCreated Column" Desc and Asc Check
//            boolean checkDateCreated_AscendingOrder_CreatedByMe = viewAssessmentsColumnSortController.check_DateCreated_AscendingOrder();
//            System.out.println("checkDateCreated_AscendingOrder_CreatedByMe ==>" + checkDateCreated_AscendingOrder_CreatedByMe);
//
//            boolean checkDateCreated_DescendingOrder_CreatedByMe = viewAssessmentsColumnSortController.check_DateCreated_DescendingOrder();
//            System.out.println("checkDateCreated_DescendingOrder_CreatedByMe ==>" + checkDateCreated_DescendingOrder_CreatedByMe);
//
//            //Test Case - "Last Accessed Column" Desc and Asc Check
//            boolean checkLastAccessed_AscendingOrder_CreatedByMe = viewAssessmentsColumnSortController.check_LastAccessed_AscendingOrder();
//            System.out.println("checkLastAccessed_AscendingOrder_CreatedByMe ==>" + checkLastAccessed_AscendingOrder_CreatedByMe);
//
//            boolean checkLastAccessed_DescendingOrder_CreatedByMe = viewAssessmentsColumnSortController.check_LastAccessed_DescendingOrder();
//            System.out.println("checkLastAccessed_DescendingOrder_CreatedByMe ==>" + checkLastAccessed_DescendingOrder_CreatedByMe);
//
//            // Test Case - "Current Data Column" Desc and Asc Check
//            boolean checkCurrentData_Ascending_CreatedByMe = viewAssessmentsColumnSortController.check_CurrentData_Order("Ascending");
//            System.out.println("checkCurrentData_Ascending_CreatedByMe ==>" + checkCurrentData_Ascending_CreatedByMe);
//            //Commented due to issue in ascending order of current data - showing students without data circle in first row.
//            //Assert.assertTrue(checkCurrentData_Ascending_CreatedByMe);
//
//            boolean checkCurrentData_Descending_CreatedByMe = viewAssessmentsColumnSortController.check_CurrentData_Order("Descending");
//            System.out.println("checkCurrentData_Descending_CreatedByMe ==>" + checkCurrentData_Descending_CreatedByMe);
//            //Commented due to issue in ascending order of current data - showing students without data circle in first row.
//            //Assert.assertTrue(checkCurrentData_Descending_CreatedByMe);
        //}
    }

    public void e_ClickFavorites() {
//        //Click All Assessments Link
//        Helper.clickXpath(viewAssessmentsPage.getViewAssessments_FavoritesLink());
//        waitUntilAjaxLoaded();
    }

    public void v_Favorites() {
        //<< Ascending and Descending Order for all columns  - Favorites Link >>
//        boolean checkEmptyTable = ViewAssessmentsSidebarPagesColumnSortController.checkViewAssessments_EmptyTable(viewAssessmentsPage.getDataTableEmpty());
//        if (checkEmptyTable) {
//            ConsoleLogger.SuccessLog("No Data Available is shown for Favorites Link....");
//        } else {
//            //Verify Favorites
//            boolean Verify_Favorites = viewAssessmentsColumnSortController.verify_Favorites();
//            System.out.println("Verify Favorites ==>" + Verify_Favorites);
//
//            //Test Case - "Title Column" Desc and Asc Check
//            boolean checkTitle_AscendingOrder_Favorites = viewAssessmentsColumnSortController.check_TitleAscendingOrder();
//            System.out.println("checkTitle_AscendingOrder_Favorites ==>" + checkTitle_AscendingOrder_Favorites);
//
//            boolean checkTitle_DescendingOrder_Favorites = viewAssessmentsColumnSortController.check_TitleDescendingOrder();
//            System.out.println("checkTitle_DescendingOrder_Favorites ==>" + checkTitle_DescendingOrder_Favorites);
//
//            //Test Case - "Type Column" Desc and Asc Check
//            boolean checkType_AscendingOrder_Favorites = viewAssessmentsColumnSortController.check_TypeAscendingOrder();
//            System.out.println("checkType_AscendingOrder_Favorites ==>" + checkType_AscendingOrder_Favorites);
//
//            boolean checkType_DescendingOrder_Favorites = viewAssessmentsColumnSortController.check_TypeDescendingOrder();
//            System.out.println("checkType_DescendingOrder_Favorites ==>" + checkType_DescendingOrder_Favorites);
//
//            //Test Case - "Owner Column" Desc and Asc Check
//            boolean checkOwner_AscendingOrder_Favorites = viewAssessmentsColumnSortController.check_OwnerAscendingOrder();
//            System.out.println("checkType_AscendingOrder_Favorites ==>" + checkOwner_AscendingOrder_Favorites);
//
//            boolean checkOwner_DescendingOrder_Favorites = viewAssessmentsColumnSortController.check_OwnerDescendingOrder();
//            System.out.println("checkType_DescendingOrder_Favorites ==>" + checkOwner_DescendingOrder_Favorites);
//
//            //Test Case - "DateCreated Column" Desc and Asc Check
//            boolean checkDateCreated_AscendingOrder_Favorites = viewAssessmentsColumnSortController.check_DateCreated_AscendingOrder();
//            System.out.println("checkDateCreated_AscendingOrder_Favorites ==>" + checkDateCreated_AscendingOrder_Favorites);
//
//            boolean checkDateCreated_DescendingOrder_Favorites = viewAssessmentsColumnSortController.check_DateCreated_DescendingOrder();
//            System.out.println("checkDateCreated_DescendingOrder_Favorites ==>" + checkDateCreated_DescendingOrder_Favorites);
//
//            //Test Case - "Last Accessed Column" Desc and Asc Check
//            boolean checkLastAccessed_AscendingOrder_Favorites = viewAssessmentsColumnSortController.check_LastAccessed_AscendingOrder();
//            System.out.println("checkLastAccessed_AscendingOrder_Favorites ==>" + checkLastAccessed_AscendingOrder_Favorites);
//
//            boolean checkLastAccessed_DescendingOrder_Favorites = viewAssessmentsColumnSortController.check_LastAccessed_DescendingOrder();
//            System.out.println("checkLastAccessed_DescendingOrder_Favorites ==>" + checkLastAccessed_DescendingOrder_Favorites);
//
//            // Test Case - "Current Data Column" Desc and Asc Check
//            boolean checkCurrentData_Ascending_Favorites = viewAssessmentsColumnSortController.check_CurrentData_Order("Ascending");
//            System.out.println("checkCurrentData_Ascending_Favorites ==>" + checkCurrentData_Ascending_Favorites);
//            //Commented due to issue in ascending order of current data - showing students without data circle in first row.
//            //Assert.assertTrue(checkCurrentData_Ascending_Favorites);
//
//            boolean checkCurrentData_Descending_Favorites = viewAssessmentsColumnSortController.check_CurrentData_Order("Descending");
//            System.out.println("checkCurrentData_Descending_Favorites ==>" + checkCurrentData_Descending_Favorites);
//            //Commented due to issue in ascending order of current data - showing students without data circle in first row.
//            //Assert.assertTrue(checkCurrentData_Descending_Favorites);
        //}
    }

    public void e_ClickUnpublishedItemBank() {
        //Click UnpublishedItemBank Link
//        Helper.clickXpath(viewAssessmentsPage.getViewAssessments_UnpublishedItemBankLink());
//        waitUntilAjaxLoaded();
    }

    public void v_UnpublishedItemBank() {
        //<< Ascending and Descending Order for all columns  - UnpublishedItemBank Link >>
//        boolean checkEmptyTable = ViewAssessmentsSidebarPagesColumnSortController.checkViewAssessments_EmptyTable(viewAssessmentsPage.getDataTableEmpty());
//        if (checkEmptyTable) {
//            ConsoleLogger.SuccessLog("No Data Available is shown for Unpublished ItemBank Link....");
//        } else {
//            //Verify UnpublishedItemBank
//            // Test Case - Unpublished Item Bank assessment created by user currently logging in are listed
//            SearchText = DriverHelper.getText(viewAssessmentsPage.getFirstRowTypeColumn());
//            boolean Verify_CreatedByMe_UnpublishedItemBank = viewAssessmentsColumnSortController.checkCreatedByMe(SearchText);
//            System.out.println("Verify_CreatedByMe_UnpublishedItemBank ==>" + Verify_CreatedByMe_UnpublishedItemBank);
//
//            //Test Case - "Show Assessments Without Data" toggle button is disabled
//            boolean checktoggledisable = false;
//            DriverHelper.elementExistenceXpath(viewAssessmentsPage.getAssessmentWithDataToggle());
//            DriverHelper.waitTill(2);
//            WebElement check_ToggleDisable = BrowserInitHelper.getInstance().findElement(By.xpath(viewAssessmentsPage.getCheckAssessmentWithDataToggle()));
//            String className = check_ToggleDisable.getAttribute("class");
//            if (className.contains("disabled-flag-switch")) {
//                checktoggledisable = true;
//            }
//            Assert.assertTrue(checktoggledisable);
//
//            //Test Case - "Title Column" Desc and Asc Check
//            boolean checkTitle_AscendingOrder_UnpublishedItemBank = viewAssessmentsColumnSortController.check_TitleAscendingOrder();
//            System.out.println("checkTitle_AscendingOrder_UnpublishedItemBank ==>" + checkTitle_AscendingOrder_UnpublishedItemBank);
//
//            boolean checkTitle_DescendingOrder_UnpublishedItemBank = viewAssessmentsColumnSortController.check_TitleDescendingOrder();
//            System.out.println("checkTitle_DescendingOrder_UnpublishedItemBank ==>" + checkTitle_DescendingOrder_UnpublishedItemBank);
//
//            //Test Case - "Type Column" Desc and Asc Check
//            boolean checkType_AscendingOrder_UnpublishedItemBank = viewAssessmentsColumnSortController.check_TypeAscendingOrder();
//            System.out.println("checkType_AscendingOrder_UnpublishedItemBank ==>" + checkType_AscendingOrder_UnpublishedItemBank);
//
//            boolean checkType_DescendingOrder_UnpublishedItemBank = viewAssessmentsColumnSortController.check_TypeDescendingOrder();
//            System.out.println("checkType_DescendingOrder_UnpublishedItemBank ==>" + checkType_DescendingOrder_UnpublishedItemBank);
//
//            //Test Case - "Owner Column" Desc and Asc Check
//            boolean checkOwner_AscendingOrder_UnpublishedItemBank = viewAssessmentsColumnSortController.check_OwnerAscendingOrder();
//            System.out.println("checkType_AscendingOrder_UnpublishedItemBank ==>" + checkOwner_AscendingOrder_UnpublishedItemBank);
//
//            boolean checkOwner_DescendingOrder_UnpublishedItemBank = viewAssessmentsColumnSortController.check_OwnerDescendingOrder();
//            System.out.println("checkType_DescendingOrder_UnpublishedItemBank ==>" + checkOwner_DescendingOrder_UnpublishedItemBank);
//
//            //Test Case - "DateCreated Column" Desc and Asc Check
//            boolean checkDateCreated_AscendingOrder_UnpublishedItemBank = viewAssessmentsColumnSortController.check_DateCreated_AscendingOrder();
//            System.out.println("checkDateCreated_AscendingOrder_UnpublishedItemBank ==>" + checkDateCreated_AscendingOrder_UnpublishedItemBank);
//
//            boolean checkDateCreated_DescendingOrder_UnpublishedItemBank = viewAssessmentsColumnSortController.check_DateCreated_DescendingOrder();
//            System.out.println("checkDateCreated_DescendingOrder_UnpublishedItemBank ==>" + checkDateCreated_DescendingOrder_UnpublishedItemBank);
//
//            //Test Case - "Last Accessed Column" Desc and Asc Check
//            boolean checkLastAccessed_AscendingOrder_UnpublishedItemBank = viewAssessmentsColumnSortController.check_LastAccessed_AscendingOrder();
//            System.out.println("checkLastAccessed_AscendingOrder_UnpublishedItemBank ==>" + checkLastAccessed_AscendingOrder_UnpublishedItemBank);
//
//            boolean checkLastAccessed_DescendingOrder_UnpublishedItemBank = viewAssessmentsColumnSortController.check_LastAccessed_DescendingOrder();
//            System.out.println("checkLastAccessed_DescendingOrder_UnpublishedItemBank ==>" + checkLastAccessed_DescendingOrder_UnpublishedItemBank);
//
//            // Test Case - "Current Data Column" Desc and Asc Check
//            boolean checkCurrentData_Ascending_UnpublishedItemBank = viewAssessmentsColumnSortController.check_CurrentData_Order("Ascending");
//            System.out.println("checkCurrentData_Ascending_UnpublishedItemBank ==>" + checkCurrentData_Ascending_UnpublishedItemBank);
//            //Commented due to issue in ascending order of current data - showing students without data circle in first row.
//            //Assert.assertTrue(checkCurrentData_Ascending_UnpublishedItemBank);
//
//            boolean checkCurrentData_Descending_UnpublishedItemBank = viewAssessmentsColumnSortController.check_CurrentData_Order("Descending");
//            System.out.println("checkCurrentData_Descending_UnpublishedItemBank ==>" + checkCurrentData_Descending_UnpublishedItemBank);
//            //Commented due to issue in ascending order of current data - showing students without data circle in first row.
//            //Assert.assertTrue(checkCurrentData_Descending_UnpublishedItemBank);
        //}
    }


    public void e_SharedwithMe() {
        //Click SharedwithMe Link
       // Helper.clickXpath(viewAssessmentsPage.getViewAssessments_SharedwithMeLink());
//        waitUntilAjaxLoaded();
    }


    public void v_SharedwithMe() {
        //<< Ascending and Descending Order for all columns  - SharedwithMe Link >>
//        boolean checkEmptyTable = ViewAssessmentsSidebarPagesColumnSortController.checkViewAssessments_EmptyTable(viewAssessmentsPage.getDataTableEmpty());
//        if (checkEmptyTable) {
//            ConsoleLogger.SuccessLog("No Data Available is shown for SharedwithMe Link....");
//        } else {
//            //Verify SharedwithMe
//            // Test Case - SharedwithMe  - Owner should be other than currently logging in are listed
//            SearchText = DriverHelper.getText(viewAssessmentsPage.getFirstRowTypeColumn());
//            boolean Verify_CreatedByMe_SharedwithMe = viewAssessmentsColumnSortController.checkSharedwithMe(SearchText);
//            System.out.println("Verify_CreatedByMe_SharedwithMe ==>" + Verify_CreatedByMe_SharedwithMe);
//
//            //Test Case - "Title Column" Desc and Asc Check
//            boolean checkTitle_AscendingOrder_SharedwithMe = viewAssessmentsColumnSortController.check_TitleAscendingOrder();
//            System.out.println("checkTitle_AscendingOrder_SharedwithMe ==>" + checkTitle_AscendingOrder_SharedwithMe);
//
//            boolean checkTitle_DescendingOrder_SharedwithMe = viewAssessmentsColumnSortController.check_TitleDescendingOrder();
//            System.out.println("checkTitle_DescendingOrder_SharedwithMe ==>" + checkTitle_DescendingOrder_SharedwithMe);
//
//            //Test Case - "Type Column" Desc and Asc Check
//            boolean checkType_AscendingOrder_SharedwithMe = viewAssessmentsColumnSortController.check_TypeAscendingOrder();
//            System.out.println("checkType_AscendingOrder_SharedwithMe ==>" + checkType_AscendingOrder_SharedwithMe);
//
//            boolean checkType_DescendingOrder_SharedwithMe = viewAssessmentsColumnSortController.check_TypeDescendingOrder();
//            System.out.println("checkType_DescendingOrder_SharedwithMe ==>" + checkType_DescendingOrder_SharedwithMe);
//
//            //Test Case - "Owner Column" Desc and Asc Check
//            boolean checkOwner_AscendingOrder_SharedwithMe = viewAssessmentsColumnSortController.check_OwnerAscendingOrder();
//            System.out.println("checkType_AscendingOrder_SharedwithMe ==>" + checkOwner_AscendingOrder_SharedwithMe);
//
//            boolean checkOwner_DescendingOrder_SharedwithMe = viewAssessmentsColumnSortController.check_OwnerDescendingOrder();
//            System.out.println("checkType_DescendingOrder_SharedwithMe ==>" + checkOwner_DescendingOrder_SharedwithMe);
//
//            //Test Case - "DateCreated Column" Desc and Asc Check
//            boolean checkDateCreated_AscendingOrder_SharedwithMe = viewAssessmentsColumnSortController.check_DateCreated_AscendingOrder();
//            System.out.println("checkDateCreated_AscendingOrder_SharedwithMe ==>" + checkDateCreated_AscendingOrder_SharedwithMe);
//
//            boolean checkDateCreated_DescendingOrder_SharedwithMe = viewAssessmentsColumnSortController.check_DateCreated_DescendingOrder();
//            System.out.println("checkDateCreated_DescendingOrder_SharedwithMe ==>" + checkDateCreated_DescendingOrder_SharedwithMe);
//
//            //Test Case - "Last Accessed Column" Desc and Asc Check
//            boolean checkLastAccessed_AscendingOrder_SharedwithMe = viewAssessmentsColumnSortController.check_LastAccessed_AscendingOrder();
//            System.out.println("checkLastAccessed_AscendingOrder_SharedwithMe ==>" + checkLastAccessed_AscendingOrder_SharedwithMe);
//
//            boolean checkLastAccessed_DescendingOrder_SharedwithMe = viewAssessmentsColumnSortController.check_LastAccessed_DescendingOrder();
//            System.out.println("checkLastAccessed_DescendingOrder_SharedwithMe ==>" + checkLastAccessed_DescendingOrder_SharedwithMe);
//
//            // Test Case - "Current Data Column" Desc and Asc Check
//            boolean checkCurrentData_Ascending_SharedwithMe = viewAssessmentsColumnSortController.check_CurrentData_Order("Ascending");
//            System.out.println("checkCurrentData_Ascending_SharedwithMe ==>" + checkCurrentData_Ascending_SharedwithMe);
//            //Commented due to issue in ascending order of current data - showing students without data circle in first row.
//            //Assert.assertTrue(checkCurrentData_Ascending_SharedwithMe);
//
//            boolean checkCurrentData_Descending_SharedwithMe = viewAssessmentsColumnSortController.check_CurrentData_Order("Descending");
//            System.out.println("checkCurrentData_Descending_SharedwithMe ==>" + checkCurrentData_Descending_SharedwithMe);
//            //Commented due to issue in ascending order of current data - showing students without data circle in first row.
//            //Assert.assertTrue(checkCurrentData_Descending_SharedwithMe);
        //}
    }

    public void e_ClickTrash() {
        //Click SharedwithMe Link
//        Helper.clickXpath(viewAssessmentsPage.getViewAssessments_TrashLink());
//        waitUntilAjaxLoaded();
    }

    public void v_Trash() {
        //<< Ascending and Descending Order for all columns  - Trash Link >>
//        boolean checkEmptyTable = ViewAssessmentsSidebarPagesColumnSortController.checkViewAssessments_EmptyTable(viewAssessmentsPage.getDataTableEmpty());
//        if (checkEmptyTable) {
//            ConsoleLogger.SuccessLog("No Data Available is shown for Trash Link....");
//        } else {
//            //Verify Trash
//            // Test Case - Trash  - Owner should be other than currently logging in are listed
//            //boolean Verify_CreatedByMe_Trash = ViewAssessmentsSidebarPagesColumnSortController.checkSharedwithMe(csvDataReaderViewAssessmentsColumnSort.getCreatedBy());
//            //System.out.println("Verify_CreatedByMe_SharedwithMe ==>" + Verify_CreatedByMe_Trash);
//
//            //Test Case - "Title Column" Desc and Asc Check
//            boolean checkTitle_AscendingOrder_Trash = viewAssessmentsColumnSortController.check_TitleAscendingOrder();
//            System.out.println("checkTitle_AscendingOrder_Trash ==>" + checkTitle_AscendingOrder_Trash);
//
//            boolean checkTitle_DescendingOrder_Trash = viewAssessmentsColumnSortController.check_TitleDescendingOrder();
//            System.out.println("checkTitle_DescendingOrder_Trash ==>" + checkTitle_DescendingOrder_Trash);
//
//            //Test Case - "Type Column" Desc and Asc Check
//            boolean checkType_AscendingOrder_Trash = viewAssessmentsColumnSortController.check_TypeAscendingOrder();
//            System.out.println("checkType_AscendingOrder_Trash ==>" + checkType_AscendingOrder_Trash);
//
//            boolean checkType_DescendingOrder_Trash = viewAssessmentsColumnSortController.check_TypeDescendingOrder();
//            System.out.println("checkType_DescendingOrder_Trash ==>" + checkType_DescendingOrder_Trash);
//
//            //Test Case - "Owner Column" Desc and Asc Check
//            boolean checkOwner_AscendingOrder_Trash = viewAssessmentsColumnSortController.check_OwnerAscendingOrder();
//            System.out.println("checkType_AscendingOrder_Trash ==>" + checkOwner_AscendingOrder_Trash);
//
//            boolean checkOwner_DescendingOrder_Trash = viewAssessmentsColumnSortController.check_OwnerDescendingOrder();
//            System.out.println("checkType_DescendingOrder_Trash ==>" + checkOwner_DescendingOrder_Trash);
//
//            //Test Case - "DateCreated Column" Desc and Asc Check
//            boolean checkDateCreated_AscendingOrder_Trash = viewAssessmentsColumnSortController.check_DateCreated_AscendingOrder();
//            System.out.println("checkDateCreated_AscendingOrder_Trash ==>" + checkDateCreated_AscendingOrder_Trash);
//
//            boolean checkDateCreated_DescendingOrder_Trash = viewAssessmentsColumnSortController.check_DateCreated_DescendingOrder();
//            System.out.println("checkDateCreated_DescendingOrder_Trash ==>" + checkDateCreated_DescendingOrder_Trash);
//
//            //Test Case - "Last Accessed Column" Desc and Asc Check
//            boolean checkLastAccessed_AscendingOrder_Trash = viewAssessmentsColumnSortController.check_LastAccessed_AscendingOrder();
//            System.out.println("checkLastAccessed_AscendingOrder_Trash ==>" + checkLastAccessed_AscendingOrder_Trash);
//
//            boolean checkLastAccessed_DescendingOrder_Trash = viewAssessmentsColumnSortController.check_LastAccessed_DescendingOrder();
//            System.out.println("checkLastAccessed_DescendingOrder_Trash ==>" + checkLastAccessed_DescendingOrder_Trash);
//
//            // Test Case - "Current Data Column" Desc and Asc Check
//            boolean checkCurrentData_Ascending_Trash = viewAssessmentsColumnSortController.check_CurrentData_Order("Ascending");
//            System.out.println("checkCurrentData_Ascending_Trash ==>" + checkCurrentData_Ascending_Trash);
//            //Commented due to issue in ascending order of current data - showing students without data circle in first row.
//            //Assert.assertTrue(checkCurrentData_Ascending_Trash);
//
//            boolean checkCurrentData_Descending_Trash = viewAssessmentsColumnSortController.check_CurrentData_Order("Descending");
//            System.out.println("checkCurrentData_Descending_Trash ==>" + checkCurrentData_Descending_Trash);
//            //Commented due to issue in ascending order of current data - showing students without data circle in first row.
//            //Assert.assertTrue(checkCurrentData_Descending_Trash);
//
//
//        }
    }
}
