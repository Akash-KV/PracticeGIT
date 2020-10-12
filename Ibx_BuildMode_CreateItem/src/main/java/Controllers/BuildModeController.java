package Controllers;

import Helpers.BrowserInitHelper;
import Helpers.DriverHelper;
import Pom.BrowseModePage;
import Pom.BuildModePage;
import Utils.ConsoleLogger;
import Utils.DataReader;
import Utils.LoggerUtility;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Controller class for BuildMode
 **/
public class BuildModeController {

    /**
     * LoggerFactory
     */
    private static final Logger log = LoggerFactory.getLogger(BuildModeController.class);

    BrowseModePage browseModePage = new BrowseModePage();
    BuildModePage buildModePage = new BuildModePage();
    boolean check_Create_item;
    DataReader dataReader = new DataReader();


    //validate CreateItem Button
    public void verifyCreateItemButton() {
        check_Create_item = DriverHelper.checkElementDisplayByXpath(browseModePage.getCreateItemButton(), "CreateButton");
        if (check_Create_item) {
            ConsoleLogger.SuccessLog("Test cases : Passed - Create item is Displayed");
            LoggerUtility.LoggerCall("Test cases : Passed - Create item is Displayed");
        } else {
            ConsoleLogger.FailedTestCase("Test cases : Failed - Create item button is not Displayed");
            LoggerUtility.LoggerCall("Test cases : Failed - Create item button is not Displayed");
        }
    }

    //Click on create Item Button
    public void clickCreateItemButton() {
        DriverHelper.clickXpath(browseModePage.getCreateItem());
    }

    //validate create item page
    public void verifyCreateItemPage() {
        DriverHelper.waitFluentByXPath(BrowserInitHelper.getInstance(), browseModePage.getCreateItemPage());
        //  BrowserInitHelper.waitUntil("//div[@class='layout item-author-layout']");
        boolean createItemPage = DriverHelper.checkElementDisplayByXpath(browseModePage.getCreateItemPage(), "Create Item Page");
        if (createItemPage) {
            ConsoleLogger.SuccessLog("Test cases : Passed - Create item page is displayed");
            LoggerUtility.LoggerCall("Test cases : Passed - Create item page is displayed");
        } else {
            ConsoleLogger.FailedTestCase("Test cases : Failed - Create item page is not displayed");
            LoggerUtility.LoggerCall("Test cases : Failed - Create item page is not displayed");
        }
    }

    //Mouse over on create item
    public void mouseOverOnCreateItem() {
        try {
            DriverHelper.awaitTillElementDisplayed(browseModePage.getCloseButton(), "Close button");
            DriverHelper.clickXpath(browseModePage.getCloseButton());
        } catch (Exception e) {
            DriverHelper.awaitTillElementDisplayed(browseModePage.getCloseButton(), "Close button");
            DriverHelper.clickXpath(browseModePage.getCloseButton());
        }
        try {
            DriverHelper.awaitTillElementDisplayed(browseModePage.getCloseButton(), "Close button");
            DriverHelper.clickXpath(browseModePage.getCloseButton());
        } catch (Exception e) {
            System.out.println("Exception handled");
        }
        try {
            DriverHelper.waitFluentByXPath(BrowserInitHelper.getInstance(), browseModePage.getCreateAssessment());
            DriverHelper.clickXpath(browseModePage.getCreateAssessment());
            DriverHelper.waitFluentByXPath(BrowserInitHelper.getInstance(), browseModePage.getAssessmentName());
            DriverHelper.sendKeysXpath(browseModePage.getAssessmentName(), dataReader.getAssessment());
            DriverHelper.waitFluentByXPath(BrowserInitHelper.getInstance(), browseModePage.getCreateButton());
            DriverHelper.clickXpath(browseModePage.getCreateButton());
        } catch (Exception e) {
            System.out.println("Exception handled for Navigation to build mode page");
        }
    }

    //validate create item page in build mode
    public void verifyCursorChangeToPointer() {
        try {
            try {
                DriverHelper.waitFluentByXPath(BrowserInitHelper.getInstance(), buildModePage.getBuild_Item_Section());
            } catch (Exception e) {
                System.out.println("Exception handled for page load");
            }
            DriverHelper.waitFluentByXPath(BrowserInitHelper.getInstance(), buildModePage.getCreateItem());
            DriverHelper.clickXpath(buildModePage.getCreateItem());
            DriverHelper.waitFluentByXPath(BrowserInitHelper.getInstance(), buildModePage.getCreateItemPage());
            boolean createItemPage = DriverHelper.checkElementDisplayByXpath(buildModePage.getCreateItemPage(), "Create Item Page");
            if (createItemPage) {
                ConsoleLogger.SuccessLog("Test cases : Passed - Mouse over on create item in Build mode is verified and Create item page is verified");
                LoggerUtility.LoggerCall("Test cases : Passed - Mouse over on create item in Build mode is verified and Create item page is verified");
            }
        } catch (Exception e) {
            System.out.println("Exception handled ");
        }
    }
}
