package Controllers;

import DataReaders.CSVDataReaderBuildBackButton;
import Helpers.BrowserInitHelper;
import Helpers.DriverHelper;
import Helpers.JavascriptHelper;
import Pom.BrowseModePage;
import Pom.BuildModePage;
import Utils.ConsoleLogger;
import Utils.LoggerUtility;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * Controllers class for BuildMode
 **/
public class BuildModeController {
    /**
     * LoggerFactory
     */
    private static final Logger log = LoggerFactory.getLogger(BrowserInitHelper.class);

    BrowseModePage browseModePage = new BrowseModePage();
    BuildModePage buildModePage = new BuildModePage();
    CSVDataReaderBuildBackButton csvDataReaderBuildBackButton = new CSVDataReaderBuildBackButton();
    boolean checkAddItem, check_BuildModeNavigation, check_Build_Back_Button = false;

    //Check Element is displayed
    public boolean checkDisplay(String xpath) {
        boolean value = false;
        try {
            BrowserInitHelper.getWaiter().until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
            WebElement element = BrowserInitHelper.getInstance().findElement(By.xpath(xpath));
            if (element.isDisplayed()) {
                value = true;
            }
        } catch (TimeoutException te) {
            log.info("{checkDisplay method failed....}");
        } catch (Exception e) {
            log.info("{checkDisplay method failed....}");
        }
        return value;
    }

    // To get current time stamp
    public String getCurrentTimeStamp() {
        String timestamp = "";
        DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
        Date date = new Date();
        timestamp = dateFormat.format(date);
        System.out.println(dateFormat.format(date));
        return timestamp;
    }

    // To add item for creating assessments
    public boolean getAddItem(String xpath, int count) {
        boolean clicked = false;
        try {
            BrowserInitHelper.getWaiter().until(ExpectedConditions.elementToBeClickable(By.xpath(xpath)));
            List<WebElement> ItemsList_AddButton = BrowserInitHelper.getInstance().findElements(By.xpath(xpath));

            System.out.println("ItemsList_AddButton SIZE==>" + ItemsList_AddButton.size());
            for (int i = 0; i <= ItemsList_AddButton.size(); i++) {
                if (i < count) {
                    BrowserInitHelper.getWaiter().until(ExpectedConditions.elementToBeClickable(ItemsList_AddButton.get(i)));
                    WebElement add_item = ItemsList_AddButton.get(i);
                    //Click Add Item for items
                    add_item.click();
                    clicked = true;
                }
            }
        } catch (NoSuchElementException ne) {
            log.info("NoSuchElementException handled for method - e_CreateAssessment....");
        } catch (TimeoutException te) {
            log.info("TimeoutException handled for method - e_CreateAssessment....");
        } catch (WebDriverException we) {
            log.info("WebDriverException handled for method - e_CreateAssessment....");
        } catch (Exception e) {
            log.info("Exception handled for method - e_CreateAssessment....");
        }
        return clicked;
    }

    // To Click create assessment
    public void clickCreateAssessment() {
        //Click on Create Assessment Button
        //Select Items and click on Create
        checkAddItem = getAddItem(browseModePage.getBrowse_AddItem_List(), 1);

        //If items displayed, then create assessment
        if (checkAddItem) {
            //Create Assessment
            boolean check_CreateAssessmentButton = checkDisplay(browseModePage.getCreateAssessmentButton());

            if (check_CreateAssessmentButton) {
                ConsoleLogger.SuccessLog("Test cases : Passed - Create Assessment Button is displayed.....");
                LoggerUtility.LoggerCall("Test cases : Passed - Create Assessment Button is displayed.....");
                DriverHelper.waitFluentByXPath(BrowserInitHelper.getInstance(), browseModePage.getCreateAssessmentButton());
                DriverHelper.clickXpath(browseModePage.getCreateAssessmentButton());

                //Enter Assessment Name
                BrowserInitHelper.getWaiter().until(ExpectedConditions.elementToBeClickable(By.xpath(browseModePage.getBrowse_Title_In_CreateAssessmentPopup())));
                WebElement TitleInputBox = BrowserInitHelper.getInstance().findElement(By.xpath(browseModePage.getBrowse_Title_In_CreateAssessmentPopup()));
                String assessmentName = csvDataReaderBuildBackButton.getAssessment() + getCurrentTimeStamp();
                TitleInputBox.sendKeys(assessmentName);

                //Click on Create Button
                DriverHelper.waitFluentByXPath(BrowserInitHelper.getInstance(), browseModePage.getBrowse_CreateButton_In_CreateAssessmentPopup());
                DriverHelper.clickXpath(browseModePage.getBrowse_CreateButton_In_CreateAssessmentPopup());
            } else {
                ConsoleLogger.FailedTestCase("Test cases : Failed - Create Assessment Button is NOT displayed.....!!!");
                LoggerUtility.LoggerCall("Test cases : Failed - Create Assessment Button is NOT displayed.....!!!");
            }
        }
    }

    // To validate build mode page
    public void verifyBuildModeNavigation() {
        //Verify Build Mode Navigation
        if (checkAddItem) {
            check_BuildModeNavigation = checkDisplay(buildModePage.getBuild_Item_Section());
            if (check_BuildModeNavigation) {
                ConsoleLogger.SuccessLog("Test cases : Passed - Build Mode Page is displayed and Navigation is successful.....");
                LoggerUtility.LoggerCall("Test cases : Passed - Build Mode Page is displayed and Navigation is successful.....");
            } else {
                ConsoleLogger.FailedTestCase("Test cases : Failed - Build Mode Page is NOT displayed.....");
                LoggerUtility.LoggerCall("Test cases : Failed - Build Mode Page is NOT displayed.....");
            }
        }
    }

    // To click back button
    public void clickBackButtonInBuild() {
        //Verify Back button display and Click on it.
        //{Test Case -- Verify Back button display and Click on it}
        if (check_BuildModeNavigation) {
            check_Build_Back_Button = checkDisplay(buildModePage.getBuild_Back_Button());
            if (check_BuildModeNavigation) {
                ConsoleLogger.SuccessLog("Test cases : Passed - BACK BUTTON is displayed inside Build Mode Page...");
                LoggerUtility.LoggerCall("Test cases : Passed - BACK BUTTON is displayed inside Build Mode Page...");
                //Click on Back Button
                DriverHelper.waitFluentByXPath(BrowserInitHelper.getInstance(), buildModePage.getBuild_Back_Button());
                JavascriptHelper.clickXpath_JS(buildModePage.getBuild_Back_Button());
            } else {
                ConsoleLogger.FailedTestCase("Test cases : Failed - BACK BUTTON is NOT displayed inside Build Mode Page.....");
                LoggerUtility.LoggerCall("Test cases : Failed - BACK BUTTON is NOT displayed inside Build Mode Page.....");
            }
        }
    }

    // To validate Back button from Build mode
    public void verifyBackButtonFromBuildMode() {
        //Verify Navigation to Browse Mode Page
        if (check_Build_Back_Button) {
            boolean check_Navigation_To_BrowseAssessments = checkDisplay(browseModePage.getBrowse_ItemSection());
            try {
                DriverHelper.waitFluentByXPath(BrowserInitHelper.getInstance(), browseModePage.getBrowse_First_Item_Content());
            } catch (Exception te) {
                System.out.println("Content Not displayed inside items........");
            }

            if (check_Navigation_To_BrowseAssessments) {
                ConsoleLogger.SuccessLog("Test cases : Passed - Navigation is successful from Build Mode Page to Browse Page...");
                LoggerUtility.LoggerCall("Test cases : Passed - Navigation is successful from Build Mode Page to Browse Page...");
                //Check Back button in Browse Mode
                //Click on Back
                check_Build_Back_Button = checkDisplay(buildModePage.getBuild_Back_Button());
                DriverHelper.waitFluentByXPath(BrowserInitHelper.getInstance(), buildModePage.getBuild_Back_Button());
                JavascriptHelper.clickXpath_JS(buildModePage.getBuild_Back_Button());

                boolean check_Navigation_To_ViewAssessments = checkDisplay(browseModePage.getBrowse_ViewAssessments_Navigation());
                if (check_Navigation_To_ViewAssessments) {
                    ConsoleLogger.SuccessLog("Test cases : Passed - Navigation is successful from Browse Mode Page to View Assessments Page...");
                    LoggerUtility.LoggerCall("Test cases : Passed - Navigation is successful from Browse Mode Page to View Assessments Page...");
                } else {
                    ConsoleLogger.FailedTestCase("Test cases : Failed - Navigation is NOT successful from Browse Mode Page to View Assessments Page...!!");
                    LoggerUtility.LoggerCall("Test cases : Failed - Navigation is NOT successful from Browse Mode Page to View Assessments Page...!!");
                }
            } else {
                ConsoleLogger.FailedTestCase("Test cases : Failed - Navigation is NOT successful from Build Mode Page to Browse Mode Page...!!");
                LoggerUtility.LoggerCall("Test cases : Failed - Navigation is NOT successful from Build Mode Page to Browse Mode Page...!!");
            }
        }
    }
}
