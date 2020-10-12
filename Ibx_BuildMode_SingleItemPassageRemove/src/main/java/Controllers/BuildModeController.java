package Controllers;

import DataReaders.CSVDataReaderBuildSingleItemPassageRemove;
import Helpers.BrowserInitHelper;
import Helpers.DriverHelper;
import Helpers.JavascriptHelper;
import Pom.BrowseModePage;
import Pom.BuildModePage;
import Utils.ConsoleLogger;
import Utils.LoggerUtility;
import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * Controller class for BuildMode
 **/
public class BuildModeController {

    /**
     * LoggerFactory
     */
    private static final Logger log = LoggerFactory.getLogger(BrowserInitHelper.class);

    boolean checkAddItem, removeItem = false;
    BuildModePage pom_BuildModePage = new BuildModePage();
    CSVDataReaderBuildSingleItemPassageRemove csv_BuildSingleItemPassageRemove = new CSVDataReaderBuildSingleItemPassageRemove();
    BrowseModePage pom_BrowseModePage = new BrowseModePage();

    //method to get Current Time Stamp
    public String getCurrentTimeStamp() {
        String timestamp = "";

        DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
        Date date = new Date();
        timestamp = dateFormat.format(date);
        System.out.println(dateFormat.format(date));

        return timestamp;
    }

    //method to get add item
    public boolean getAddItem(String xpath, int count) {
        boolean clicked = false;

        try {
            BrowserInitHelper.getWaiter().until(ExpectedConditions.elementToBeClickable(By.xpath(xpath)));
            List<WebElement> ItemsList_AddButton = BrowserInitHelper.getInstance().findElements(By.xpath(xpath));

            System.out.println("ItemsList_AddButton SIZE==>" + ItemsList_AddButton.size());
            for (int i = 0; i <= ItemsList_AddButton.size(); i++) {
                if (i < count) {
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

    // To create assessment
    public void createAssessment() {
        try {
            DriverHelper.waitFluentByXPath(BrowserInitHelper.getInstance(), pom_BrowseModePage.getBrowse_ItemSection());
            BrowserInitHelper.getWaiter().until(ExpectedConditions.elementToBeClickable(By.xpath(pom_BrowseModePage.getBrowse_ItemSection())));
        } catch (Exception e) {
            System.out.println("Exception handled for page load");
        }
        try {
            BrowserInitHelper.getWaiter().until(ExpectedConditions.elementToBeClickable(By.xpath(pom_BrowseModePage.getBrowse_First_Item_Content())));
        } catch (TimeoutException te) {
            ConsoleLogger.DebugLog("Content Not displayed inside items........");
        }

        //Select Items and click on Create
        checkAddItem = getAddItem(pom_BrowseModePage.getBrowse_AddItem_List(), 1);

        //If items displayed, then create assessment
        if (checkAddItem) {
            //Create Assessment
            boolean check_CreateAssessmentButton = checkDisplay(pom_BrowseModePage.getCreateAssessmentButton());

            if (check_CreateAssessmentButton) {
                ConsoleLogger.SuccessLog("Test cases : Passed - Create Assessment Button is displayed.....");
                LoggerUtility.LoggerCall("Test cases : Passed - Create Assessment Button is displayed.....");
                DriverHelper.clickXpath(pom_BrowseModePage.getCreateAssessmentButton());

                //Enter Assessment Name
                BrowserInitHelper.getWaiter().until(ExpectedConditions.elementToBeClickable(By.xpath(pom_BrowseModePage.getBrowse_Title_In_CreateAssessmentPopup())));
                WebElement TitleInputBox = BrowserInitHelper.getInstance().findElement(By.xpath(pom_BrowseModePage.getBrowse_Title_In_CreateAssessmentPopup()));
                String assessmentName = csv_BuildSingleItemPassageRemove.getassessment() + getCurrentTimeStamp();
                TitleInputBox.sendKeys(assessmentName);

                //Click on Create Button
                DriverHelper.clickXpath(pom_BrowseModePage.getBrowse_CreateButton_In_CreateAssessmentPopup());
            } else {
                ConsoleLogger.FailedTestCase("Test cases : Failed - Create Assessment Button is NOT displayed.....!!!");
                LoggerUtility.LoggerCall("Test cases : Failed - Create Assessment Button is NOT displayed.....!!!");
            }
        }
    }

    // To validate remove item display
    public void verifyRemoveItemDisplay() {
        if (checkAddItem) {
            boolean check_BuildModeNavigation = checkDisplay(pom_BuildModePage.getBuild_Item_Section());
            if (check_BuildModeNavigation) {
                ConsoleLogger.SuccessLog("Test cases : Passed - Build Mode Page is displayed.....");
                LoggerUtility.LoggerCall("Test cases : Passed - Build Mode Page is displayed.....");
                //{Test Case - Verify all item and passage having vertical ellipsis}
                boolean check_Ellipsis_BuildMode = checkDisplay(pom_BuildModePage.getBuild_First_Item_More_Button());
                if (check_Ellipsis_BuildMode) {
                    ConsoleLogger.SuccessLog("Test cases : Passed - Vertical Ellipsis is displayed.....");
                    LoggerUtility.LoggerCall("Test cases : Passed - Vertical Ellipsis is displayed.....");
                } else {
                    ConsoleLogger.FailedTestCase("Test cases : Failed - Vertical Ellipsis is NOT displayed.....!!!");
                    LoggerUtility.LoggerCall("Test cases : Failed - Vertical Ellipsis is NOT displayed.....!!!");
                }
            } else {
                ConsoleLogger.FailedTestCase("Test cases : Failed - Build Mode Page is NOT displayed.....!!!");
                LoggerUtility.LoggerCall("Test cases : Failed - Build Mode Page is NOT displayed.....!!!");
            }
        }
    }

    // To click remove item
    public void clickRemoveItem() {
        if (checkAddItem) {
            //Remove Item
            checkDisplay(pom_BuildModePage.getBuild_First_Item_Content());
            //BrowserInitHelper.getWaiter().until(ExpectedConditions.elementToBeClickable(By.xpath(pom_BuildModePage.getBuild_First_Item_Content())));
            DriverHelper.clickXpath(pom_BuildModePage.getBuild_First_Item_More_Button());
            BrowserInitHelper.getWaiter().until(ExpectedConditions.elementToBeClickable(By.xpath(pom_BuildModePage.getBuild_First_Item_Remove_Button())));
            DriverHelper.clickXpath(pom_BuildModePage.getBuild_First_Item_Remove_Button());

            //Verify No Items message
            boolean check_NoItems = checkDisplay(pom_BuildModePage.getBuild_No_Items_Message());
            if (check_NoItems) {
                ConsoleLogger.SuccessLog("Test cases : Passed - No Items message is displayed.....");
                LoggerUtility.LoggerCall("Test cases : Passed - No Items message is displayed.....");
                removeItem = true;
            } else {
                ConsoleLogger.FailedTestCase("Test cases : Failed - No Items message is NOT displayed.....!!!");
                LoggerUtility.LoggerCall("Test cases : Failed - No Items message is NOT displayed.....!!!");
            }

            //Navigate To Browse
            DriverHelper.waitFluentByXPath(BrowserInitHelper.getInstance(), pom_BrowseModePage.getBrowse_ToggleButton());
            DriverHelper.clickXpath(pom_BrowseModePage.getBrowse_ToggleButton());
        }
    }

    // To validate remove item
    public void verifyRemoveItem() {
        Assert.assertTrue(removeItem);
    }

    // To expand item
    public void ExpandItem() {
        //Now Select item again
        BrowserInitHelper.getWaiter().until(ExpectedConditions.elementToBeClickable(By.xpath(pom_BrowseModePage.getBrowse_ItemSection())));

        //Select Items and click on Create
        checkAddItem = getAddItem(pom_BrowseModePage.getBrowse_AddItem_List(), 1);
        try {
            DriverHelper.waitFluentByXPath(BrowserInitHelper.getInstance(), pom_BrowseModePage.getBrowseSavingMessage());
        } catch (Exception e) {
            System.out.println("Exception handled for saving");
        }
        //Navigate To Build
        DriverHelper.waitFluentByXPath(BrowserInitHelper.getInstance(), pom_BuildModePage.getBuild_Toggle_Button());
        DriverHelper.clickXpath(pom_BuildModePage.getBuild_Toggle_Button());
        BrowserInitHelper.getWaiter().until(ExpectedConditions.elementToBeClickable(By.xpath(pom_BuildModePage.getBuild_Item_Section())));

        //Click Expand Button
        checkDisplay(pom_BuildModePage.getBuild_First_Item_Content());
        //BrowserInitHelper.getWaiter().until(ExpectedConditions.elementToBeClickable(By.xpath(pom_BuildModePage.getBuild_First_Item_Content())));
        DriverHelper.clickXpath(pom_BuildModePage.getBuild_Expand_Button());
    }

    // To validate remove item when expanded
    public void verifyRemoveItemWhenExpanded() {
        if (checkAddItem) {
            //Remove item after Expand
            DriverHelper.clickXpath(pom_BuildModePage.getBuild_First_Item_More_Button());
            BrowserInitHelper.getWaiter().until(ExpectedConditions.elementToBeClickable(By.xpath(pom_BuildModePage.getBuild_First_Item_Remove_Button())));
            DriverHelper.clickXpath(pom_BuildModePage.getBuild_First_Item_Remove_Button());

            //Verify No Items message
            boolean check_NoItems = checkDisplay(pom_BuildModePage.getBuild_No_Items_Message());
            if (check_NoItems) {
                ConsoleLogger.SuccessLog("Test cases : Passed - No Items message is displayed after deleting item in Expand state.....");
                LoggerUtility.LoggerCall("Test cases : Passed - No Items message is displayed after deleting item in Expand state.....");
                removeItem = true;
            } else {
                ConsoleLogger.FailedTestCase("Test cases : Failed - No Items message is NOT displayed after deleting item in Expand state.....!!!");
                LoggerUtility.LoggerCall("Test cases : Failed - No Items message is NOT displayed after deleting item in Expand state.....!!!");
            }

            //Navigate To Browse
            DriverHelper.clickXpath(pom_BrowseModePage.getBrowse_ToggleButton());
        }
    }

    // To collapse item
    public void collapseItem() {
        //Now Select item again
        BrowserInitHelper.getWaiter().until(ExpectedConditions.elementToBeClickable(By.xpath(pom_BrowseModePage.getBrowse_ItemSection())));

        //Select Items and click on Create
        checkAddItem = getAddItem(pom_BrowseModePage.getBrowse_AddItem_List(), 1);
        try {
            DriverHelper.waitFluentByXPath(BrowserInitHelper.getInstance(), pom_BrowseModePage.getBrowseSavingMessage());
        } catch (Exception e) {
            System.out.println("Exception handled for saving");
        }
        //Navigate To Build
        DriverHelper.waitFluentByXPath(BrowserInitHelper.getInstance(), pom_BuildModePage.getBuild_Toggle_Button());
        DriverHelper.clickXpath(pom_BuildModePage.getBuild_Toggle_Button());
        BrowserInitHelper.getWaiter().until(ExpectedConditions.elementToBeClickable(By.xpath(pom_BuildModePage.getBuild_Item_Section())));

        //Click Expand Button
        checkDisplay(pom_BuildModePage.getBuild_First_Item_Content());
        //BrowserInitHelper.getWaiter().until(ExpectedConditions.elementToBeClickable(By.xpath(pom_BuildModePage.getBuild_First_Item_Content())));
        DriverHelper.clickXpath(pom_BuildModePage.getBuild_Expand_Button());

        //Click Collapse Button
        JavascriptHelper.scrollIntoView(pom_BuildModePage.getBuild_Collapse_Button());
        // DriverHelper.WaitUntilLoad(2000);
        DriverHelper.waitFluentByXPath(BrowserInitHelper.getInstance(), pom_BuildModePage.getBuild_Collapse_Button());
        BrowserInitHelper.getWaiter().until(ExpectedConditions.elementToBeClickable(By.xpath(pom_BuildModePage.getBuild_Collapse_Button())));
        JavascriptHelper.clickXpath_JS(pom_BuildModePage.getBuild_Collapse_Button());
    }

    // To validate collapse item when remove
    public void verifyCollapseItemWhenRemove() {
        if (checkAddItem) {
            //Remove item after Expand
            DriverHelper.clickXpath(pom_BuildModePage.getBuild_First_Item_More_Button());
            BrowserInitHelper.getWaiter().until(ExpectedConditions.elementToBeClickable(By.xpath(pom_BuildModePage.getBuild_First_Item_Remove_Button())));
            DriverHelper.clickXpath(pom_BuildModePage.getBuild_First_Item_Remove_Button());

            //Verify No Items message
            boolean check_NoItems = checkDisplay(pom_BuildModePage.getBuild_No_Items_Message());
            if (check_NoItems) {
                ConsoleLogger.SuccessLog("Test cases : Passed - No Items message is displayed after deleting item in Collapse state.....");
                LoggerUtility.LoggerCall("Test cases : Passed - No Items message is displayed after deleting item in Collapse state.....");
                removeItem = true;
            } else {
                ConsoleLogger.FailedTestCase("Test cases : Failed - No Items message is NOT displayed after deleting item in Collapse state.....!!!");
                LoggerUtility.LoggerCall("Test cases : Failed - No Items message is NOT displayed after deleting item in Collapse state.....!!!");
            }
        }
    }

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

}
