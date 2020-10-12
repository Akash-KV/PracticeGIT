package Controllers;

import DataReaders.CSVDataReaderBuildItemTags;
import Helpers.BrowserInitHelper;
import Helpers.DriverHelper;
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
 * Controllers class for BuildMode
 **/
public class BuildModeController {

    /**
     * LoggerFactory
     */
    private static final Logger log = LoggerFactory.getLogger(BrowserInitHelper.class);
    private static final Logger logger = LoggerFactory.getLogger(BuildModeController.class);

    // Declarations
    CSVDataReaderBuildItemTags csv_BuildItemDescription = new CSVDataReaderBuildItemTags();
    BuildModePage buildModePage = new BuildModePage();
    public BrowseModePage browseModePage = new BrowseModePage();
    boolean checkAddItem, checkTagDisplay = false;


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

    // To add item
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


    // To create assessment
    public void createAssessment() {
        DriverHelper.waitFluentByXPath(BrowserInitHelper.getInstance(), browseModePage.getBrowse_ItemSection());
        BrowserInitHelper.getWaiter().until(ExpectedConditions.elementToBeClickable(By.xpath(browseModePage.getBrowse_ItemSection())));
        //BrowserInitHelper.getWaiter().until(ExpectedConditions.elementToBeClickable(By.xpath(pom_BrowseModePage.getBrowse_First_Item_Content())));
        //Select Items and click on Create
        checkAddItem = getAddItem(browseModePage.getBrowse_AddItem_List(), 1);

        //If items displayed, then create assessment
        if (checkAddItem) {
            //Create Assessment
            boolean check_CreateAssessmentButton = checkDisplay(browseModePage.getCreateAssessmentButton());

            if (check_CreateAssessmentButton) {
                ConsoleLogger.SuccessLog("Test Case - Passed - Create Assessment Button is displayed.....");
                LoggerUtility.LoggerCall("Test Case - Passed - Create Assessment Button is displayed.....");
                DriverHelper.waitFluentByXPath(BrowserInitHelper.getInstance(), browseModePage.getCreateAssessmentButton());
                DriverHelper.clickXpath(browseModePage.getCreateAssessmentButton());

                //Enter Assessment Name
                BrowserInitHelper.getWaiter().until(ExpectedConditions.elementToBeClickable(By.xpath(browseModePage.getBrowse_Title_In_CreateAssessmentPopup())));
                WebElement TitleInputBox = BrowserInitHelper.getInstance().findElement(By.xpath(browseModePage.getBrowse_Title_In_CreateAssessmentPopup()));
                String assessmentName = csv_BuildItemDescription.getAssessmentName() + getCurrentTimeStamp();
                TitleInputBox.sendKeys(assessmentName);

                //Click on Create Button
                DriverHelper.waitFluentByXPath(BrowserInitHelper.getInstance(), browseModePage.getBrowse_CreateButton_In_CreateAssessmentPopup());
                DriverHelper.clickXpath(browseModePage.getBrowse_CreateButton_In_CreateAssessmentPopup());
            } else {
                ConsoleLogger.FailedTestCase("Test Case - Failed - Create Assessment Button is NOT displayed.....!!!");
                LoggerUtility.LoggerCall("Test Case - Failed - Create Assessment Button is NOT displayed.....!!!");
            }
        }
    }

    // To validate Build Mode Navigation
    public void verifyBuildNavigation() {
        if (checkAddItem) {
            boolean check_BuildModeNavigation = checkDisplay(buildModePage.getBuild_Item_Section());
            if (check_BuildModeNavigation) {
                ConsoleLogger.SuccessLog("Test Case - Passed - Build Mode Page is displayed.....");
                LoggerUtility.LoggerCall("Test Case - Passed - Build Mode Page is displayed.....");
            } else {
                ConsoleLogger.FailedTestCase("Test Case - Failed - Build Mode Page is NOT displayed.....!!!");
                LoggerUtility.LoggerCall("Test Case - Failed - Build Mode Page is NOT displayed.....!!!");
            }
        }
    }

    // To validate tags option
    public void verifyTagsOption() {
        boolean check_BuildModeTagsLinkDisplay = checkDisplay(buildModePage.getBuild_TagsLink());
        if (check_BuildModeTagsLinkDisplay) {
            ConsoleLogger.SuccessLog("Test Case - Passed - Tags Link is Present in the Build Page");
            LoggerUtility.LoggerCall("Test Case - Passed - Tags Link is Present in the Build Page");
            checkTagDisplay = true;
        } else {
            ConsoleLogger.FailedTestCase("Test Case - Failed - Tags Link is not Present in the Build Page.....!!!");
            LoggerUtility.LoggerCall("Test Case - Failed - Tags Link is not Present in the Build Page.....!!!");
        }
        Assert.assertTrue(check_BuildModeTagsLinkDisplay);
    }

    // To click on Tags link
    public void clickOnTagsLink() {
        try {
            if (checkTagDisplay) {
                //clicking tags Link
                DriverHelper.waitFluentByXPath(BrowserInitHelper.getInstance(), buildModePage.getBuild_TagsLink());
                DriverHelper.clickXpath(buildModePage.getBuild_TagsLink());
            }
        } catch (Exception e) {
            logger.info("Exception handled for clicking on the Tags Link");
            ConsoleLogger.FailedTestCase("Test cases : Failed - Selection - Clicking on the Tags Link");
            LoggerUtility.LoggerCall("Test cases : Failed - Selection - Clicking on the Tags Link");
        }
    }

    // To validate Tags General Settings Screen
    public void verifyTagsGeneralSettingsScreen() {
        boolean check_BuildModeTagsPopupHeader = checkDisplay(buildModePage.getBuild_TagsAssessmentSettingsPopupHeader());
        if (check_BuildModeTagsPopupHeader) {
            ConsoleLogger.SuccessLog("Test Case - Passed - Tags Assessment Settings PopupHeader is displaying");
            LoggerUtility.LoggerCall("Test Case - Passed - Tags Assessment Settings PopupHeader is displaying");
        } else {
            ConsoleLogger.FailedTestCase("Test Case - Failed - Tags Assessment Settings PopupHeader is not displaying.....!!!");
            LoggerUtility.LoggerCall("Test Case - Failed - Tags Assessment Settings PopupHeader is not displaying.....!!!");
        }

        boolean check_BuildModeTagsPopupCloseOption = checkDisplay(buildModePage.getBuild_TagsAssessmentSettingsPopupCloseIcon());
        if (check_BuildModeTagsPopupCloseOption) {
            ConsoleLogger.SuccessLog("Test Case - Passed - Tags Assessment Settings Close Icon is  displaying");
            LoggerUtility.LoggerCall("Test Case - Passed - Tags Assessment Settings Close Icon is  displaying");
        } else {
            ConsoleLogger.FailedTestCase("Test Case - Failed - Tags Assessment Settings Close Icon is not displaying.....!!!");
            LoggerUtility.LoggerCall("Test Case - Failed - Tags Assessment Settings Close Icon is not displaying.....!!!");
        }

        boolean check_BuildModeTagsAssessmentYear = checkDisplay(buildModePage.getBuild_TagsAssessmentSettingsPopupAssessmentYearInput());
        if (check_BuildModeTagsAssessmentYear) {
            ConsoleLogger.SuccessLog("Test Case - Passed - Tags Assessment Settings Year Input is  displaying");
            LoggerUtility.LoggerCall("Test Case - Passed - Tags Assessment Settings Year Input is  displaying");
            checkTagDisplay = true;
        } else {
            ConsoleLogger.FailedTestCase("Test Case - Failed - Tags Assessment Settings Year Input is not displaying.....!!!");
            LoggerUtility.LoggerCall("Test Case - Failed - Tags Assessment Settings Year Input is not displaying.....!!!");
        }

        boolean check_BuildModeTagsGradeLevels = checkDisplay(buildModePage.getBuild_TagsAssessmentSettingsPopupGradeLevelsInput());
        if (check_BuildModeTagsGradeLevels) {
            ConsoleLogger.SuccessLog("Test Case - Passed - Tags Assessment Settings Grade Level Input is  displaying");
            LoggerUtility.LoggerCall("Test Case - Passed - Tags Assessment Settings Grade Level Input is  displaying");
        } else {
            ConsoleLogger.FailedTestCase("Test Case - Failed - Tags Assessment Settings Grade Level Input is not displaying.....!!!");
            LoggerUtility.LoggerCall("Test Case - Failed - Tags Assessment Settings Grade Level Input is not displaying.....!!!");
        }
    }

    // To select X icon
    public void select_X_Icon() {
        //clicking x icon Link
        DriverHelper.waitFluentByXPath(BrowserInitHelper.getInstance(), buildModePage.getBuild_TagsAssessmentSettingsPopupCloseIcon());
        DriverHelper.clickXpath(buildModePage.getBuild_TagsAssessmentSettingsPopupCloseIcon());

        //wait until tags button clickable
        DriverHelper.waitFluentByXPath(BrowserInitHelper.getInstance(), buildModePage.getBuild_TagsLink());
    }

    // To validate Tags General Settings Screen Closing
    public void verifyTagsGeneralSettingsScreenClosing() {
        if (BrowserInitHelper.getInstance().findElement(By.xpath(buildModePage.getBuild_TagsLink())).isDisplayed()) {
            ConsoleLogger.SuccessLog("Test Case - Passed - Tags Popup closed Properly using x icon");
            LoggerUtility.LoggerCall("Test Case - Passed - Tags Popup closed Properly using x icon");
        } else {
            ConsoleLogger.FailedTestCase("Test Case - Failed - Tags Popup is not closed Properly using x icon.....!!!");
            LoggerUtility.LoggerCall("Test Case - Failed - Tags Popup is not closed Properly using x icon.....!!!");
        }
    }

    // To click on Tags General Settings Options
    public void clickOnTagsGeneralSettingsOptions() {
        try {
            //clicking tags Link
//            Actions actions = new Actions(BrowserInitHelper.getInstance());
//            actions.moveToElement(BrowserInitHelper.getInstance().findElement(By.xpath(buildModePage.getBuild_TagsLink()))).doubleClick().build().perform();
            DriverHelper.waitFluentByXPath(BrowserInitHelper.getInstance(), buildModePage.getBuild_TagsLink());
            DriverHelper.clickXpath(buildModePage.getBuild_TagsLink());
        } catch (Exception e) {
            logger.info("Exception handled for clicking on the Tags Link after close");
            ConsoleLogger.FailedTestCase("Test cases : Failed - Selection - Clicking on the Tags Link after close");
            LoggerUtility.LoggerCall("Test cases : Failed - Selection - Clicking on the Tags Link after close");
        }
    }

    // To validate Selection of Tags General Settings Options
    public void verifySelectionOfTagsGeneralSettingsOptions() {
        try {
            DriverHelper.waitFluentByXPath(BrowserInitHelper.getInstance(), buildModePage.getBuild_TagsAssessmentSettingsPopupAssessmentYearInput());
            BrowserInitHelper.getWaiter().until(ExpectedConditions.elementToBeClickable(By.xpath(buildModePage.getBuild_TagsAssessmentSettingsPopupAssessmentYearInput())));

            //clicking Assessment Year drop down
            DriverHelper.clickXpath(buildModePage.getBuild_TagsAssessmentSettingsPopupAssessmentYearInput());

            BrowserInitHelper.getWaiter().until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='v-list__tile__content']/div[contains(.,'" + csv_BuildItemDescription.getAssessmentYear() + "')]")));
            WebElement yearOption = BrowserInitHelper.getInstance().findElement(By.xpath("//div[@class='v-list__tile__content']/div[contains(.,'" + csv_BuildItemDescription.getAssessmentYear() + "')]"));
            yearOption.click();

            //clicking Subject drop down
            DriverHelper.waitFluentByXPath(BrowserInitHelper.getInstance(), buildModePage.getBuild_TagsAssessmentSettingsPopupSubjectsInput());
            DriverHelper.clickXpath(buildModePage.getBuild_TagsAssessmentSettingsPopupSubjectsInput());

            BrowserInitHelper.getWaiter().until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='v-list__tile__content']/div[contains(.,'" + csv_BuildItemDescription.getSubject() + "')]")));
            WebElement subjectOption = BrowserInitHelper.getInstance().findElement(By.xpath("//div[@class='v-list__tile__content']/div[contains(.,'" + csv_BuildItemDescription.getSubject() + "')]"));
            subjectOption.click();

            //clicking Grade drop down
            DriverHelper.waitFluentByXPath(BrowserInitHelper.getInstance(), buildModePage.getBuild_TagsAssessmentSettingsPopupGradeLevelsInput());
            DriverHelper.clickXpath(buildModePage.getBuild_TagsAssessmentSettingsPopupGradeLevelsInput());

            BrowserInitHelper.getWaiter().until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='v-list__tile__content']/div[contains(.,'" + csv_BuildItemDescription.getGradeLevels() + "')]")));
            WebElement gradeOption = BrowserInitHelper.getInstance().findElement(By.xpath("//div[@class='v-list__tile__content']/div[contains(.,'" + csv_BuildItemDescription.getGradeLevels() + "')]"));
            gradeOption.click();

            DriverHelper.waitFluentByXPath(BrowserInitHelper.getInstance(), buildModePage.getBuild_TagsAssessmentSettingsPopupHeader());
            DriverHelper.clickXpath(buildModePage.getBuild_TagsAssessmentSettingsPopupHeader());

            DriverHelper.waitFluentByXPath(BrowserInitHelper.getInstance(), buildModePage.getBuild_TagsAssessmentSettingsPopupFirstDateAdministeredInput());
            DriverHelper.clickXpath(buildModePage.getBuild_TagsAssessmentSettingsPopupFirstDateAdministeredInput());

            //Enter the First Date Administered
            WebElement dateWidgetFrom = BrowserInitHelper.getInstance().findElement(By.xpath(buildModePage.getBuild_Mode_Tags_First_Date_Administer()));

            //This are the columns of the from date picker table
            List<WebElement> columns = dateWidgetFrom.findElements(By.tagName("td"));

            //DatePicker is a table. Thus we can navigate to each cell
            //and if a cell matches with the current date then we will click it.
            for (WebElement cell : columns) {
            /*
            //If you want to click 18th Date
            if (cell.getText().equals("18")) {
            */
                //Select Today's Date
                if (cell.getText().equals(csv_BuildItemDescription.getFirstDateAdministered())) {
                    cell.click();
                    break;
                }
            }

            //Wait for 4 Seconds to see Today's date selected.
//            DriverHelper.waitTill(5);
            DriverHelper.waitFluentByXPath(BrowserInitHelper.getInstance(), buildModePage.getBuild_TagsAssessmentSettingsPopupHeader());

            DriverHelper.clickXpath(buildModePage.getBuild_TagsAssessmentSettingsPopupHeader());

            //clicking x icon Link
            DriverHelper.waitFluentByXPath(BrowserInitHelper.getInstance(), buildModePage.getBuild_TagsAssessmentSettingsPopupCloseIcon());
            DriverHelper.clickXpath(buildModePage.getBuild_TagsAssessmentSettingsPopupCloseIcon());

            //wait until tags button clickable
            DriverHelper.waitFluentByXPath(BrowserInitHelper.getInstance(), buildModePage.getBuild_TagsLink());
            BrowserInitHelper.getWaiter().until(ExpectedConditions.elementToBeClickable(By.xpath(buildModePage.getBuild_TagsLink())));

            String strValue = BrowserInitHelper.getInstance().findElement(By.xpath(buildModePage.getBuild_TagsLink())).getText();
            if (strValue.contains("3")) {
                Assert.assertTrue(true);
            } else {
                Assert.assertTrue(false);
            }
        } catch (Exception e) {
            e.printStackTrace();
            logger.info("Exception handled for Selection of Tags in Assessment Settings pop-up");
            ConsoleLogger.FailedTestCase("Test cases : Failed - Selection - Selection of Tags in Assessment Settings pop-up");
            LoggerUtility.LoggerCall("Test cases : Failed - Selection - Selection of Tags in Assessment Settings pop-up");
        }
    }

    // To unSelect Tags General Settings Options
    public void unSelectTagsGeneralSettingsOptions() {
        try {
            DriverHelper.clickXpath(buildModePage.getBuild_TagsLink());

            BrowserInitHelper.getWaiter().until(ExpectedConditions.elementToBeClickable(By.xpath(buildModePage.getBuild_TagsAssessmentSettingsPopupAssessmentYearInput())));

            List<WebElement> clearTags = BrowserInitHelper.getInstance().findElements(By.xpath("//div[contains(@class,'v-input__icon--clear')]"));

            for (int i = 0; i < clearTags.size(); i++) {
                clearTags.get(i).click();
            }

            //clicking x icon Link
            DriverHelper.waitFluentByXPath(BrowserInitHelper.getInstance(), buildModePage.getBuild_TagsAssessmentSettingsPopupCloseIcon());
            DriverHelper.clickXpath(buildModePage.getBuild_TagsAssessmentSettingsPopupCloseIcon());
        } catch (Exception e) {
            e.printStackTrace();
            logger.info("Exception handled for UnSelection of Tags in Assessment Settings pop-up");
            ConsoleLogger.FailedTestCase("Test cases : Failed - UnSelection - UnSelection of Tags in Assessment Settings pop-up");
            LoggerUtility.LoggerCall("Test cases : Failed - UnSelection - UnSelection of Tags in Assessment Settings pop-up");
        }
    }

    // To validate UnSelect of Tags General Settings Options
    public void verifyUnSelectOfTagsGeneralSettingsOptions() {
        //wait until tags button clickable
        DriverHelper.waitFluentByXPath(BrowserInitHelper.getInstance(), buildModePage.getBuild_TagsLink());
        BrowserInitHelper.getWaiter().until(ExpectedConditions.elementToBeClickable(By.xpath(buildModePage.getBuild_TagsLink())));

        String strValue = BrowserInitHelper.getInstance().findElement(By.xpath(buildModePage.getBuild_TagsLink())).getText();
        if (!strValue.contains(csv_BuildItemDescription.getFirstDateAdministered())) {
            Assert.assertTrue(true);
        } else {
            Assert.assertTrue(false);
        }
    }
}
