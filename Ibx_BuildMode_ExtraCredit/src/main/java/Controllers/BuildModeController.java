package Controllers;

import DataReaders.CSVDataReaderBuildModeExtraCredit;
import Helpers.BrowserInitHelper;
import Helpers.DriverHelper;
import Pom.BrowseModePage;
import Pom.BuildModePage;
import Utils.ConsoleLogger;
import Utils.LoggerUtility;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
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

    //Declarations
    BuildModePage buildModePage = new BuildModePage();
    BrowseModePage browseModePage = new BrowseModePage();
    CSVDataReaderBuildModeExtraCredit csv_BuildItemWeight = new CSVDataReaderBuildModeExtraCredit();
    boolean checkAddItem = false;
    boolean ExtraCreditSelection, ExtraCreditUnSelection, ExtraCreditSelectionNavigation, ExtraCreditUnselectionNavigation = false;
    boolean CompactView = false;


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


    //Click on create Assessment
    public void createAssessment() {
        //unSelect all checkboxes which is selected Bank , Standards and Item type
        try {
            DriverHelper.waitFluentByXPath(BrowserInitHelper.getInstance(), browseModePage.getBrowse_ItemSection());
            BrowserInitHelper.getWaiter().until(ExpectedConditions.visibilityOfElementLocated(By.xpath(browseModePage.getBrowse_ItemSection())));
        } catch (Exception e) {
            System.out.println("Exception handled for page load");
        }

        //Select Items and click on Create
        checkAddItem = getAddItem(browseModePage.getBrowse_AddItem_List(), 1);

        //If items displayed, then create assessment
        if (checkAddItem) {
            //Create Assessment
            boolean check_CreateAssessmentButton = checkDisplay(browseModePage.getCreateAssessmentButton());

            if (check_CreateAssessmentButton) {
                ConsoleLogger.SuccessLog("Test cases : Passed - Create Assessment Button is displayed.....");
                LoggerUtility.LoggerCall("Test cases : Passed - Create Assessment Button is displayed.....");
                DriverHelper.clickXpath(browseModePage.getCreateAssessmentButton());

                //Enter Assessment Name
                BrowserInitHelper.getWaiter().until(ExpectedConditions.elementToBeClickable(By.xpath(browseModePage.getBrowse_Title_In_CreateAssessmentPopup())));
                WebElement TitleInputBox = BrowserInitHelper.getInstance().findElement(By.xpath(browseModePage.getBrowse_Title_In_CreateAssessmentPopup()));
                String assessmentName = csv_BuildItemWeight.getAssessment() + getCurrentTimeStamp();
                TitleInputBox.sendKeys(assessmentName);

                //Click on Create Button
                DriverHelper.clickXpath(browseModePage.getBrowse_CreateButton_In_CreateAssessmentPopup());
            } else {
                ConsoleLogger.FailedTestCase("Test cases : Failed - Create Assessment Button is NOT displayed.....!!!");
                LoggerUtility.LoggerCall("Test cases : Failed - Create Assessment Button is NOT displayed.....!!!");
            }
        }
    }

    //Validate Build Navigation
    public void verifyBuildNavigation() {
        //try {
        if (checkAddItem) {
            boolean check_BuildModeNavigation = checkDisplay(buildModePage.getBuild_FirstItem_Section());
            if (check_BuildModeNavigation) {
                ConsoleLogger.SuccessLog("Test cases : Passed - Build Mode Page is displayed.....!!!");
                LoggerUtility.LoggerCall("Test cases : Passed - Build Mode Page is displayed.....!!!");
            } else {
                ConsoleLogger.FailedTestCase("Test cases : Failed - Build Mode Page is NOT displayed.....!!!");
                LoggerUtility.LoggerCall("Test cases : Failed - Build Mode Page is NOT displayed.....!!!");
            }
        }
    }

    //Validate Extra Credit Checkbox
    public void verifyExtraCreditCheckBox() {
        // try {
        //checking the Extra Credit option in the Build Mode Page
        boolean check_ExtraCredit_Checkbox = checkDisplay(buildModePage.getBuild_ExtraCredit_Checkbox());
        if (check_ExtraCredit_Checkbox) {
            ConsoleLogger.SuccessLog("Test Case : Passed - Extra Credit displaying properly");
            LoggerUtility.LoggerCall("Test Case : Passed - Extra Credit displaying properly");
        } else {
            ConsoleLogger.DebugLog(" Extra Credit is not displaying ");
        }
    }

    //click on Extra credit check box
    public void clickExtraCreditForItem() {
        //clicking on the Extra Credit option
        // try {
        checkDisplay(buildModePage.getBuild_FirstItemContentSection());
        DriverHelper.waitFluentByXPath(BrowserInitHelper.getInstance(), buildModePage.getBuildModeMoreVert());
        DriverHelper.clickXpath(buildModePage.getBuildModeMoreVert());
        ConsoleLogger.SuccessLog("Test Case : Passed - Extra Credit displaying properly");
        LoggerUtility.LoggerCall("Test Case : Passed - Extra Credit displaying properly");
        DriverHelper.waitFluentByXPath(BrowserInitHelper.getInstance(), buildModePage.getBuild_ExtraCredit_Checkbox());
        if (!(BrowserInitHelper.getInstance().findElement(By.xpath(buildModePage.getBuild_ExtraCredit_Checkbox())).isSelected())) {
            new Actions(BrowserInitHelper.getInstance()).moveToElement(BrowserInitHelper.getInstance().findElement(By.xpath(buildModePage.getBuild_ExtraCredit_Checkbox()))).click().perform();
            System.out.println("Extra Credit CheckBox is not Selected initially ... Hence Selected");
        } else if (BrowserInitHelper.getInstance().findElement(By.xpath(buildModePage.getBuild_ExtraCredit_Checkbox())).isSelected()) {
            System.out.println("Extra Credit CheckBox already Selected.. Hence Not Selected");
        }
        ExtraCreditSelection = true;
        BrowserInitHelper.getWaiter().until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(buildModePage.getBuild_SaveCheckMark())));
    }


    //Validate Selection of Extra Credit
    public void verifySelectionOfExtraCredit() {
        //  try {
        if (ExtraCreditSelection) {
            try {
                DriverHelper.waitFluentByXPath(BrowserInitHelper.getInstance(), buildModePage.getBuildModeMoreVert());
                DriverHelper.clickXpath(buildModePage.getBuildModeMoreVert());
                DriverHelper.waitFluentByXPath(BrowserInitHelper.getInstance(), buildModePage.getBuild_ExtraCredit_Checkbox());

                if (BrowserInitHelper.getInstance().findElement(By.xpath(buildModePage.getBuild_ExtraCredit_CheckboxStatus())).getAttribute("aria-checked").equals("true")) {
                    ConsoleLogger.SuccessLog("Test Case : Passed - Extra Credit checkbox is selected properly");
                    LoggerUtility.LoggerCall("Test Case : Passed - Extra Credit checkbox is selected properly");
                } else {
                    ConsoleLogger.FailedTestCase("Test Case : Failed -  Extra Credit checkbox is not selected");
                    LoggerUtility.LoggerCall("Test Case : Failed -  Extra Credit checkbox is not selected");
                }
            } catch (Exception e) {
                System.out.println("handled");
            }
        }
    }

    //Unselect ExtraCredit check box
    public void unSelectExtraCreditForItem() {
        //Unselecting on the Extra Credit option
        DriverHelper.waitFluentByXPath(BrowserInitHelper.getInstance(), buildModePage.getBuild_FirstItem_Section());
        DriverHelper.waitFluentByXPath(BrowserInitHelper.getInstance(), buildModePage.getBuildModeMoreVert());
        DriverHelper.clickXpath(buildModePage.getBuildModeMoreVert());
        if (BrowserInitHelper.getInstance().findElement(By.xpath(buildModePage.getBuild_ExtraCredit_CheckboxStatus())).getAttribute("aria-checked").equals("true")) {
            DriverHelper.waitFluentByXPath(BrowserInitHelper.getInstance(), buildModePage.getBuild_ExtraCredit_Checkbox());
            BrowserInitHelper.waitUntil(buildModePage.getBuild_ExtraCredit_Checkbox());
            DriverHelper.waitFluentByXPath(BrowserInitHelper.getInstance(), buildModePage.getBuild_ExtraCredit_Checkbox());
            new Actions(BrowserInitHelper.getInstance()).moveToElement(BrowserInitHelper.getInstance().findElement(By.xpath(buildModePage.getBuild_ExtraCredit_Checkbox()))).click().perform();
            System.out.println("Clicked : Extra Credit CheckBox is  Selected, Hence unchecked the Extra Credit CheckBox");
        } else if (!(BrowserInitHelper.getInstance().findElement(By.xpath(buildModePage.getBuild_ExtraCredit_Checkbox())).isSelected())) {
            System.out.println("Not Clicked : Extra Credit CheckBox is  Unchecked Initially Hence didn't unchecked");
        }
        ExtraCreditUnSelection = true;
        try {
            BrowserInitHelper.getWaiter().until(ExpectedConditions.visibilityOfElementLocated(By.xpath(buildModePage.getBuild_SaveCheckMark())));
            BrowserInitHelper.getWaiter().until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(buildModePage.getBuild_SaveCheckMark())));

        } catch (Exception e) {
            System.out.println("Exception handled for Saved message");
        }
    }


    //Validate UnSelect of the ExtraCredit
    public void verifyUnSelectExtraCredit() {
        // try {
        if (ExtraCreditUnSelection) {
            if (BrowserInitHelper.getInstance().findElement(By.xpath(buildModePage.getBuild_ExtraCredit_CheckboxStatus())).getAttribute("aria-checked").equals("false")) {
                ConsoleLogger.SuccessLog("Test Case : Passed - Extra Credit checkbox is Unselected properly");
                LoggerUtility.LoggerCall("Test Case : Passed - Extra Credit checkbox is Unselected properly");
            } else {
                ConsoleLogger.DebugLog("Test Case : Failed -  Extra Credit checkbox is not Unselected");
            }
        }
    }

    //Click on CompactView
    public void clickOnCompactView() {
        //clicking on the CompactView
        BrowserInitHelper.waitUntil((buildModePage.getBuild_FirstItem_Section()));
        DriverHelper.waitFluentByXPath(BrowserInitHelper.getInstance(), buildModePage.getBuildModeMoreVert());
        DriverHelper.clickXpath(buildModePage.getBuildModeMoreVert());
        DriverHelper.waitFluentByXPath(BrowserInitHelper.getInstance(), buildModePage.getBuild_FirstItem_Section());
        DriverHelper.waitFluentByXPath(BrowserInitHelper.getInstance(), buildModePage.getBuild_CompactView());
        new Actions(BrowserInitHelper.getInstance()).moveToElement(BrowserInitHelper.getInstance().findElement(By.xpath(buildModePage.getBuild_CompactView()))).click().perform();
        CompactView = true;
    }

    //Validate Extra Credit for Compact View
    public void verifyExtraCreditForCompactView() {
        if (CompactView) {
            boolean check_ExtraCredit_Checkbox = checkDisplay(buildModePage.getBuild_ExtraCredit_Checkbox());
            if (check_ExtraCredit_Checkbox) {
                ConsoleLogger.SuccessLog("Test Case : Passed - Compact View  - Extra Credit displaying properly");
                LoggerUtility.LoggerCall("Test Case : Passed - Compact View  - Extra Credit displaying properly");
            } else {
                ConsoleLogger.DebugLog("Compact View  - Extra Credit is not displaying ");
            }

            //clicking on the collapse View
            DriverHelper.clickXpath(buildModePage.getBuild_CollapseView());
        }
    }

    //click Navigate to BrowsePage ByS electing ExtraCredit
    public void navigateToBrowsePageBySelectingExtraCredit() {
        //clicking on the Extra Credit option
        // try {
        checkDisplay(buildModePage.getBuild_FirstItemContentSection());
        DriverHelper.waitFluentByXPath(BrowserInitHelper.getInstance(), buildModePage.getBuildModeMoreVert());
        DriverHelper.clickXpath(buildModePage.getBuildModeMoreVert());
        DriverHelper.waitFluentByXPath(BrowserInitHelper.getInstance(), buildModePage.getBuild_ExtraCredit_Checkbox());
        if (!(BrowserInitHelper.getInstance().findElement(By.xpath(buildModePage.getBuild_ExtraCredit_Checkbox())).isSelected())) {
            new Actions(BrowserInitHelper.getInstance()).moveToElement(BrowserInitHelper.getInstance().findElement(By.xpath(buildModePage.getBuild_ExtraCredit_Checkbox()))).click().perform();
            System.out.println(" Navigation - Extra Credit CheckBox is not Selected initially ... Hence Selected");
        } else if (BrowserInitHelper.getInstance().findElement(By.xpath(buildModePage.getBuild_ExtraCredit_Checkbox())).isSelected()) {
            System.out.println("Navigation - Extra Credit CheckBox already Selected.. Hence Not Selected");
        }
        ExtraCreditSelectionNavigation = true;

        //clicking on the Browse mode button
        DriverHelper.waitFluentByXPath(BrowserInitHelper.getInstance(), buildModePage.getBuild_BrowseButton());
        DriverHelper.clickXpath(buildModePage.getBuild_BrowseButton());
        BrowserInitHelper.getWaiter().until(ExpectedConditions.elementToBeClickable(By.xpath(browseModePage.getBrowse_ItemSection())));

        //Clicking on the Build Button
        DriverHelper.clickXpath(buildModePage.getBuild_BuildButton());
        boolean check_BuildModeNavigation = checkDisplay(buildModePage.getBuild_FirstItem_Section());
        if (check_BuildModeNavigation) {
            System.out.println("Navigation - Selection - Build Mode Page is displayed.....!!!");
        } else {
            System.out.println("Navigation - Selection - Build Mode Page is NOT displayed.....!!!");
        }
    }

    //Validate ExtraCredit Selection by Navigation
    public void verifyExtraCreditSelectionByNavigation() {
        // try {
        if (ExtraCreditSelectionNavigation) {
            checkDisplay(buildModePage.getBuild_FirstItemContentSection());
            DriverHelper.waitFluentByXPath(BrowserInitHelper.getInstance(), buildModePage.getBuildModeMoreVert());
            DriverHelper.clickXpath(buildModePage.getBuildModeMoreVert());
            DriverHelper.waitFluentByXPath(BrowserInitHelper.getInstance(), buildModePage.getBuild_ExtraCredit_Checkbox());
            if (BrowserInitHelper.getInstance().findElement(By.xpath(buildModePage.getBuild_ExtraCredit_CheckboxStatus())).getAttribute("aria-checked").equals("true")) {
                ConsoleLogger.SuccessLog("Test Case : Passed - Navigation - Extra Credit checkbox is selected properly");
                LoggerUtility.LoggerCall("Test Case : Passed - Navigation - Extra Credit checkbox is selected properly");
            }
        }


        Actions actions = new Actions(BrowserInitHelper.getInstance());
        try {
            actions.moveToElement(BrowserInitHelper.getInstance().findElement(By.xpath(buildModePage.getBuildModeMoreVert()))).doubleClick().build().perform();
            DriverHelper.waitFluentByXPath(BrowserInitHelper.getInstance(), buildModePage.getBuild_ExtraCredit_CheckboxStatus());
        } catch (Exception e) {
            actions.moveToElement(BrowserInitHelper.getInstance().findElement(By.xpath(buildModePage.getBuildModeMoreVert()))).doubleClick().build().perform();
            // DriverHelper.waitFluentByXPath(BrowserInitHelper.getInstance(), pom_BuildModePage.getBuild_ExtraCredit_CheckboxStatus());
        }
        //   DriverHelper.clickXpath(pom_BuildModePage.getBuildModeMoreVert());
        try {
            DriverHelper.waitFluentByXPath(BrowserInitHelper.getInstance(), buildModePage.getBuild_ExtraCredit_CheckboxStatus());
            if (BrowserInitHelper.getInstance().findElement(By.xpath(buildModePage.getBuild_ExtraCredit_CheckboxStatus())).getAttribute("aria-checked").equals("true")) {
                BrowserInitHelper.waitUntil(buildModePage.getBuild_ExtraCredit_Checkbox());
                DriverHelper.waitFluentByXPath(BrowserInitHelper.getInstance(), buildModePage.getBuild_ExtraCredit_Checkbox());
                new Actions(BrowserInitHelper.getInstance()).moveToElement(BrowserInitHelper.getInstance().findElement(By.xpath(buildModePage.getBuild_ExtraCredit_Checkbox()))).click().perform();
                System.out.println("Clicked : Navigation - Extra Credit CheckBox is  Selected, Hence unchecked the Extra Credit CheckBox");
            } else if (!(BrowserInitHelper.getInstance().findElement(By.xpath(buildModePage.getBuild_ExtraCredit_Checkbox())).isSelected())) {
                System.out.println("Not Clicked : Navigation - Extra Credit CheckBox is  Unselected Hence didn't unchecked");
            }
            ExtraCreditUnselectionNavigation = true;
        } catch (Exception e) {
            System.out.println("Exception handled");
        }

        //clicking on the Browse mode button
        DriverHelper.clickXpath(buildModePage.getBuild_BrowseButton());
        BrowserInitHelper.getWaiter().until(ExpectedConditions.elementToBeClickable(By.xpath(browseModePage.getBrowse_ItemSection())));

        //Clicking on the Build Button
        DriverHelper.clickXpath(buildModePage.getBuild_BuildButton());
        boolean check_BuildModeNavigation = checkDisplay(buildModePage.getBuild_FirstItem_Section());
        if (check_BuildModeNavigation) {
            System.out.println("Navigation - UnSelection - Build Mode Page is displayed.....!!!");
        } else {
            System.out.println("Navigation - UnSelection - Build Mode Page is NOT displayed.....!!!");
        }

        //verifying the uncheck of the extra credit after navigation
        //try {
        if (ExtraCreditUnselectionNavigation) {
            if (BrowserInitHelper.getInstance().findElement(By.xpath(buildModePage.getBuild_ExtraCredit_CheckboxStatus())).getAttribute("aria-checked").equals("false")) {
                ConsoleLogger.SuccessLog("Test Case : Passed - Navigation - Extra Credit checkbox is Unselected properly");
                LoggerUtility.LoggerCall("Test Case : Passed - Navigation - Extra Credit checkbox is Unselected properly");
            } else {
                ConsoleLogger.DebugLog(" Navigation - Extra Credit checkbox is not Unselected");
            }
        }

    }
}
