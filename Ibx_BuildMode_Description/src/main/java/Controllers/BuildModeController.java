package Controllers;

import DataReaders.CSVDataReaderBuildItemDescription;
import Helpers.BrowserInitHelper;
import Helpers.DriverHelper;
import Pom.BrowseModePage;
import Pom.BuildModePage;
import Utils.ConsoleLogger;
import Utils.LoggerUtility;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Controllers class for BuildMode
 **/
public class BuildModeController {

    //Logger and WebDrivers
    private static final Logger logger = LoggerFactory.getLogger(BuildModeController.class);

    //Declarations
    BrowseModeController browseModeController = new BrowseModeController();
    CSVDataReaderBuildItemDescription csv_BuildItemDescription = new CSVDataReaderBuildItemDescription();
    BuildModePage buildModePage = new BuildModePage();
    BrowseModePage browseModePage = new BrowseModePage();
    boolean checkAddItem = false;
    boolean DescriptionPopupDisplay, description = false;
    boolean lessValue, deleteText, alphaNumeric, moreValue, exactValue, navigationValue, specialValue, CancelButton = false;
    String LessThanTwoFiftyFiveGeneratedString, MoreThanTwoFiftyFiveGeneratedString, twoFiftyFiveGeneratedString;


    // To create assessment
    public void createAssessment() {
        logger.info("UnSelecting all the Filters Selections");
        try {
            BrowserInitHelper.getWaiter().until(ExpectedConditions.elementToBeClickable(By.xpath(browseModePage.getBrowse_ItemSection())));
            //BrowserInitHelper.getWaiter().until(ExpectedConditions.elementToBeClickable(By.xpath(pom_BrowseModePage.getBrowse_First_Item_Content())));
            //Select Items and click on Create
            checkAddItem = browseModeController.getAddItem(browseModePage.getBrowse_AddItem_List(), 1);

            //If items displayed, then create assessment
            if (checkAddItem) {
                //Create Assessment
                boolean check_CreateAssessmentButton = browseModeController.checkDisplay(browseModePage.getCreateAssessmentButton());

                if (check_CreateAssessmentButton) {
                    ConsoleLogger.SuccessLog("Test cases : Passed - Create Assessment Button is displayed.....");
                    LoggerUtility.LoggerCall("Test cases : Passed - Create Assessment Button is displayed.....");
                    DriverHelper.waitFluentByXPath(BrowserInitHelper.getInstance(), browseModePage.getCreateAssessmentButton());
                    DriverHelper.clickXpath(browseModePage.getCreateAssessmentButton());

                    //Enter Assessment Name
                    BrowserInitHelper.getWaiter().until(ExpectedConditions.elementToBeClickable(By.xpath(browseModePage.getBrowse_Title_In_CreateAssessmentPopup())));
                    WebElement TitleInputBox = BrowserInitHelper.getInstance().findElement(By.xpath(browseModePage.getBrowse_Title_In_CreateAssessmentPopup()));
                    String assessmentName = csv_BuildItemDescription.getAssessment() + browseModeController.getCurrentTimeStamp();
                    TitleInputBox.sendKeys(assessmentName);

                    //Click on Create Button
                    DriverHelper.waitFluentByXPath(BrowserInitHelper.getInstance(), browseModePage.getBrowse_CreateButton_In_CreateAssessmentPopup());
                    DriverHelper.clickXpath(browseModePage.getBrowse_CreateButton_In_CreateAssessmentPopup());
                } else {
                    ConsoleLogger.FailedTestCase("Test cases : Failed - Create Assessment Button is NOT displayed.....!!!");
                    LoggerUtility.LoggerCall("Test cases : Failed - Create Assessment Button is NOT displayed.....!!!");
                }
            }
        } catch (Exception e) {
            logger.info("Exception Handled for the e_CreateAssessment");
        }

    }

    // To validate Build Mode navigation
    public void verifyBuildNavigation() {
        if (checkAddItem) {
            boolean check_BuildModeNavigation = browseModeController.checkDisplay(buildModePage.getBuild_Item_Section());
            if (check_BuildModeNavigation) {
                ConsoleLogger.SuccessLog("Test cases : Passed - Build Mode Page is displayed.....");
                LoggerUtility.LoggerCall("Test cases : Passed - Build Mode Page is displayed.....");
            } else {
                ConsoleLogger.FailedTestCase("Test cases : Failed - Build Mode Page is NOT displayed.....!!!");
                LoggerUtility.LoggerCall("Test cases : Failed - Build Mode Page is NOT displayed.....!!!");
            }
        }
    }

    // To click add description button
    public void clickAddDescriptionButton() {
        try {
            if (checkAddItem) {
                boolean check_BuildModeNavigation = browseModeController.checkDisplay(buildModePage.getBuild_Item_Section());
                if (check_BuildModeNavigation) {
                    ConsoleLogger.SuccessLog("Test cases : Passed - Build Mode Page is displayed.....");
                    LoggerUtility.LoggerCall("Test cases : Passed - Build Mode Page is displayed.....");
                    //clicking on the Description button
                    DriverHelper.waitFluentByXPath(BrowserInitHelper.getInstance(), buildModePage.getBuild_Description_Button());
                    boolean descriptionButton = DriverHelper.checkElementDisplayByXpath(buildModePage.getBuild_Description_Button(), "Description Button");
                    if (descriptionButton) {
                        System.out.println("Description button is displayed");
                    }
                    BrowserInitHelper.getInstance().findElement(By.xpath(buildModePage.getBuild_Description_Button())).click();
                    description = true;
                } else {
                    ConsoleLogger.FailedTestCase("Test cases : Failed - Build Mode Page is NOT displayed.....!!!");
                    LoggerUtility.LoggerCall("Test cases : Failed - Build Mode Page is NOT displayed.....!!!");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            logger.info("Exception Handled for the e_ClickAddDescriptionButton");
        }
    }

    // To validate add description window
    public void verifyAddDescriptionWindow() {
        if (description) {
            //waiting till the Popup Window loading

            //Checking the display of the Description Popup Window header
            if (BrowserInitHelper.getWaiter().until(ExpectedConditions.visibilityOfElementLocated(By.xpath(buildModePage.getBuild_Description_Popuptitle()))).getText().trim().equalsIgnoreCase("Add Description")) {
                DescriptionPopupDisplay = true;
                ConsoleLogger.SuccessLog("Test cases : Passed - Description Popup Window Showing its Heading Properly");
                LoggerUtility.LoggerCall("Test cases : Passed - Description Popup Window Showing its Heading Properly");
            } else {
                ConsoleLogger.FailedTestCase("Test cases : Failed - Description Popup Window is not Showing its Heading Properly ");
                LoggerUtility.LoggerCall("Test cases : Failed - Description Popup Window is not Showing its Heading Properly");
            }

            //checking the save button display
            if (BrowserInitHelper.getWaiter().until(ExpectedConditions.visibilityOfElementLocated(By.xpath(buildModePage.getBuild_Description_SaveButton()))).isDisplayed()) {
                DescriptionPopupDisplay = true;
                ConsoleLogger.SuccessLog("Test cases : Passed - Save Button displaying in the Description Popup Window ");
                LoggerUtility.LoggerCall("Test cases : Passed - Save Button displaying in the Description Popup Window");
            } else {
                DescriptionPopupDisplay = false;
                ConsoleLogger.FailedTestCase("Test cases : Failed - Save Button is not displaying in the Description Popup Window");
                LoggerUtility.LoggerCall("Test cases : Failed - Save Button is not displaying in the Description Popup Window");
            }

            //checking the cancel button display
            if (BrowserInitHelper.getWaiter().until(ExpectedConditions.visibilityOfElementLocated(By.xpath(buildModePage.getBuild_Description_CancelButton()))).isDisplayed()) {
                DescriptionPopupDisplay = true;
                ConsoleLogger.SuccessLog("Test cases : Passed - Cancel Button displaying in the Description Popup Window ");
                LoggerUtility.LoggerCall("Test cases : Passed - Cancel Button displaying in the Description Popup Window");
            } else {
                DescriptionPopupDisplay = false;
                ConsoleLogger.FailedTestCase("Test cases : Failed - Cancel Button is not displaying in the Description Popup Window");
                LoggerUtility.LoggerCall("Test cases : Failed - Cancel Button is not displaying in the Description Popup Window");
            }
        }
    }

    // To click cancel button in add description
    public void clickCancelButtonInAddDescriptionWindow() {
        //waiting till the Popup Window loading
        try {
            DriverHelper.waitFluentByXPath(BrowserInitHelper.getInstance(), buildModePage.getBuild_Description_CancelButton());
            boolean cancelButton = DriverHelper.checkElementDisplayByXpath(buildModePage.getBuild_Description_CancelButton(), "Cancel Button");
            if (cancelButton) {
                System.out.println("Cancel button is displayed");
            }
            BrowserInitHelper.getInstance().findElement(By.xpath(buildModePage.getBuild_Description_CancelButton())).click();
            CancelButton = true;
        } catch (Exception e) {
            logger.info("Exception handled for Cancel Button in AddDescription Window");
            ConsoleLogger.FailedTestCase("Test cases : Failed - Description Popup window not closed by using close button due to Exception ");
            LoggerUtility.LoggerCall("Test cases : Failed - Description Popup window not closed by using close button due to Exception ");
        }
    }

    // To validate cancel button in add description
    public void verifyCancelButtonInAddDescriptionWindow() {
        if (CancelButton) {
            //waiting for description popup get closed
            BrowserInitHelper.getWaiter().until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(buildModePage.getBuild_Description_PopupWindow())));

            //verifying the description popup is closed by checking the Add description button is clickable
            if (BrowserInitHelper.getWaiter().until(ExpectedConditions.elementToBeClickable(By.xpath(buildModePage.getBuild_Description_Button()))).isDisplayed()) {
                ConsoleLogger.SuccessLog("Test cases : Passed - Description Popup window is closed by using close button ");
                LoggerUtility.LoggerCall("Test cases : Passed - Description Popup window is closed by using close button ");
            } else {
                ConsoleLogger.FailedTestCase("Test cases : Failed - Description Popup window not closed by using close button");
                LoggerUtility.LoggerCall("Test cases : Failed - Description Popup window not closed by using close button ");
            }
        }
    }

    // To give description text less than 255 words
    public void descriptionTextLessThanTwoHundredFiftyFive() {
        try {
            //Generating less than 255 characters and Entering characters in the Description
            LessThanTwoFiftyFiveGeneratedString = RandomStringUtils.randomAlphabetic(Integer.parseInt(csv_BuildItemDescription.getLessThanTwoHundredFiftyFiveCount()));

            System.out.println("characters 255(LessThan) ---->" + LessThanTwoFiftyFiveGeneratedString);
            //clicking on the Description button
            DriverHelper.waitFluentByXPath(BrowserInitHelper.getInstance(), buildModePage.getBuild_Description_Button());
            boolean descriptionButton = DriverHelper.checkElementDisplayByXpath(buildModePage.getBuild_Description_Button(), "Description Button");
            if (descriptionButton) {
                System.out.println("Description button is displayed");
            }
            BrowserInitHelper.getInstance().findElement(By.xpath(buildModePage.getBuild_Description_Button())).click();

            //sending less than 255 characters
            DriverHelper.sendKeysXpath(buildModePage.getBuild_Description_TextBox(), LessThanTwoFiftyFiveGeneratedString);

            //Clicking on the save button
            DriverHelper.waitFluentByXPath(BrowserInitHelper.getInstance(), buildModePage.getBuild_Description_SaveButton());
            DriverHelper.clickXpath(buildModePage.getBuild_Description_SaveButton());

            //waiting for description popup get closed
            BrowserInitHelper.getWaiter().until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(buildModePage.getBuild_Description_PopupWindow())));

            //clicking on the Description button
            DriverHelper.waitFluentByXPath(BrowserInitHelper.getInstance(), buildModePage.getBuild_Description_Button());
            boolean descriptionButton1 = DriverHelper.checkElementDisplayByXpath(buildModePage.getBuild_Description_Button(), "Description Button");
            if (descriptionButton1) {
                System.out.println("Description button is displayed");
            }
            BrowserInitHelper.getInstance().findElement(By.xpath(buildModePage.getBuild_Description_Button())).click();
            lessValue = true;
        } catch (Exception e) {
            logger.info("Exception handled for Description text lessThan TwoHundredFiftyFive");
            ConsoleLogger.FailedTestCase("Test cases : Failed - Less than 255 characters is not entered properly");
            LoggerUtility.LoggerCall("Test cases : Failed - Less than 255 characters is not entered properly ");
        }
    }

    // To validate Description text less than 255 words
    public void verifyDescriptionTextLessThanTwoHundredFiftyFive() {
        if (lessValue) {
            DriverHelper.waitFluentByXPath(BrowserInitHelper.getInstance(), buildModePage.getBuild_Description_TextBox());
            boolean descriptionTextBox = DriverHelper.checkElementDisplayByXpath(buildModePage.getBuild_Description_TextBox(), "Description TextBox");
            if (descriptionTextBox) {
                System.out.println("Description TextBox is displayed");
            }
            //checking the text
            if (BrowserInitHelper.getInstance().findElement(By.xpath(buildModePage.getBuild_Description_TextBox())).getAttribute("value").equalsIgnoreCase(LessThanTwoFiftyFiveGeneratedString)) {
                ConsoleLogger.SuccessLog("Test cases : Passed - Less than 255 characters entered is saved properly and text is validated");
                LoggerUtility.LoggerCall("Test cases : Passed - Less than 255 characters entered is saved properly and text is validated ");
            } else {
                ConsoleLogger.FailedTestCase("Test cases : Failed - Less than 255 characters is not saved properly and text is not validated");
                LoggerUtility.LoggerCall("Test cases : Failed - Less than 255 characters is not saved properly and text is not validated ");
            }

            //checking the count

            if (BrowserInitHelper.getInstance().findElement(By.xpath(buildModePage.getBuild_Description_TextBox())).getAttribute("value").trim().length() < 255) {
                ConsoleLogger.SuccessLog("Test cases : Passed - Less than 255 characters is taking in the Description Popup window");
                LoggerUtility.LoggerCall("Test cases : Passed - Less than 255 characters is taking in the Description Popup window ");
            } else {
                ConsoleLogger.FailedTestCase("Test cases : Failed - Less than 255 characters is not taking in the Description Popup window");
                LoggerUtility.LoggerCall("Test cases : Failed - Less than 255 characters is not taking in the Description Popup window");
            }
        }
    }

    // To delete description text
    public void deleteDescriptionText() {
        try {
            // clearing the Description Text
            DriverHelper.waitFluentByXPath(BrowserInitHelper.getInstance(), buildModePage.getBuild_Description_TextBox());
            BrowserInitHelper.getWaiter().until(ExpectedConditions.elementToBeClickable(By.xpath(buildModePage.getBuild_Description_TextBox()))).sendKeys(Keys.CONTROL + "a");
            BrowserInitHelper.getWaiter().until(ExpectedConditions.elementToBeClickable(By.xpath(buildModePage.getBuild_Description_TextBox()))).sendKeys(Keys.DELETE);

            //Clicking on the save button
            DriverHelper.waitFluentByXPath(BrowserInitHelper.getInstance(), buildModePage.getBuild_Description_SaveButton());
            DriverHelper.clickXpath(buildModePage.getBuild_Description_SaveButton());

            //waiting for description popup get closed
            BrowserInitHelper.getWaiter().until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(buildModePage.getBuild_Description_PopupWindow())));

            //clicking on the Description button
            DriverHelper.waitFluentByXPath(BrowserInitHelper.getInstance(), buildModePage.getBuild_Description_Button());
            boolean descriptionButton = DriverHelper.checkElementDisplayByXpath(buildModePage.getBuild_Description_Button(), "Description Button");
            if (descriptionButton) {
                System.out.println("Description button is displayed");
            }
            DriverHelper.waitFluentByXPath(BrowserInitHelper.getInstance(), buildModePage.getBuild_Description_Button());
            BrowserInitHelper.getInstance().findElement(By.xpath(buildModePage.getBuild_Description_Button())).click();

            deleteText = true;
        } catch (Exception e) {
            e.printStackTrace();
            logger.info("Exception handled for Delete Description Text selection");
            ConsoleLogger.FailedTestCase("Test cases : Failed - Deletion can't happening im the Add description text ");
            LoggerUtility.LoggerCall("Test cases : Failed - Deletion can't happening im the Add description text ");
        }

    }

    // To validate deleted description text
    public void verifyDeleteDescriptionText() {
        if (deleteText) {
            DriverHelper.waitFluentByXPath(BrowserInitHelper.getInstance(), buildModePage.getBuild_Description_TextBox());
            boolean descriptionTextBox = DriverHelper.checkElementDisplayByXpath(buildModePage.getBuild_Description_TextBox(), "Description TextBox");
            if (descriptionTextBox) {
                System.out.println("Description TextBox is displayed");
            }

            //checking the count

            if (BrowserInitHelper.getInstance().findElement(By.xpath(buildModePage.getBuild_Description_TextBox())).getAttribute("value").trim().length() == 0) {
                ConsoleLogger.SuccessLog("Test cases : Passed - Empty data - Deleting all the description text working");
                LoggerUtility.LoggerCall("Test cases : Passed - Empty data - Deleting all the description text working ");
            } else {
                ConsoleLogger.FailedTestCase("Test cases : Failed - Empty data - Deleting all the description text is not working");
                LoggerUtility.LoggerCall("Test cases : Failed - Empty data - Deleting all the description text is not working ");
            }
        }
    }

    // To enter Alphanumeric in Description
    public void alphanumericInDescription() {
        try {
            // clearing the Description Text
            DriverHelper.waitFluentByXPath(BrowserInitHelper.getInstance(), buildModePage.getBuild_Description_TextBox());
            BrowserInitHelper.getWaiter().until(ExpectedConditions.elementToBeClickable(By.xpath(buildModePage.getBuild_Description_TextBox()))).sendKeys(Keys.CONTROL + "a");
            BrowserInitHelper.getWaiter().until(ExpectedConditions.elementToBeClickable(By.xpath(buildModePage.getBuild_Description_TextBox()))).sendKeys(Keys.DELETE);

            //sending less than Alphanumeric
            DriverHelper.sendKeysXpath(buildModePage.getBuild_Description_TextBox(), csv_BuildItemDescription.getAlphanumeric());

            //Clicking on the save button
            DriverHelper.waitFluentByXPath(BrowserInitHelper.getInstance(), buildModePage.getBuild_Description_SaveButton());
            DriverHelper.clickXpath(buildModePage.getBuild_Description_SaveButton());

            //waiting for description popup get closed
            BrowserInitHelper.getWaiter().until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(buildModePage.getBuild_Description_PopupWindow())));

            //clicking on the Description button
            DriverHelper.waitFluentByXPath(BrowserInitHelper.getInstance(), buildModePage.getBuild_Description_Button());
            boolean descriptionButton = DriverHelper.checkElementDisplayByXpath(buildModePage.getBuild_Description_Button(), "Description Button");
            if (descriptionButton) {
                System.out.println("Description button is displayed");
            }
            BrowserInitHelper.getInstance().findElement(By.xpath(buildModePage.getBuild_Description_Button())).click();
            alphaNumeric = true;
        } catch (Exception e) {
            logger.info("Exception handled for Alphanumeric in Description Selection");
            ConsoleLogger.FailedTestCase("Test cases : Failed - AlphaNumeric value is not entering in Add Description ");
            LoggerUtility.LoggerCall("Test cases : Failed - AlphaNumeric value is not entering in Add Description");
        }
    }

    // To validate Alphanumeric in Description
    public void verifyAlphanumericInDescription() {
        if (alphaNumeric) {
            DriverHelper.waitFluentByXPath(BrowserInitHelper.getInstance(), buildModePage.getBuild_Description_TextBox());
            boolean descriptionTextBox = DriverHelper.checkElementDisplayByXpath(buildModePage.getBuild_Description_TextBox(), "Description TextBox");
            if (descriptionTextBox) {
                System.out.println("Description TextBox is displayed");
            }
            //checking the text
            if (BrowserInitHelper.getInstance().findElement(By.xpath(buildModePage.getBuild_Description_TextBox())).getAttribute("value").equalsIgnoreCase(csv_BuildItemDescription.getAlphanumeric())) {
                ConsoleLogger.SuccessLog("Test cases : Passed - AlphaNumeric value is saved properly and text validated");
                LoggerUtility.LoggerCall("Test cases : Passed - AlphaNumeric value is saved properly and text validated");
            } else {
                ConsoleLogger.FailedTestCase("Test cases : Failed - AlphaNumeric value is not saved properly and text is not validated");
                LoggerUtility.LoggerCall("Test cases : Failed - AlphaNumeric value is not saved properly and text is not validated");
            }
        }
    }

    // To enter description text More than 255 words
    public void descriptionTextMoreThanTwoHundredFiftyFive() {
        try {
            // clearing the Description Text
            DriverHelper.waitFluentByXPath(BrowserInitHelper.getInstance(), buildModePage.getBuild_Description_TextBox());
            BrowserInitHelper.getWaiter().until(ExpectedConditions.elementToBeClickable(By.xpath(buildModePage.getBuild_Description_TextBox()))).sendKeys(Keys.CONTROL + "a");
            BrowserInitHelper.getWaiter().until(ExpectedConditions.elementToBeClickable(By.xpath(buildModePage.getBuild_Description_TextBox()))).sendKeys(Keys.DELETE);

            //Generating less than 255 characters and Entering characters in the Description
            MoreThanTwoFiftyFiveGeneratedString = RandomStringUtils.randomAlphabetic(Integer.parseInt(csv_BuildItemDescription.getMoreThanTwoHundredFiftyFiveCountString()));

            System.out.println("characters 255(MoreThan) ---->" + MoreThanTwoFiftyFiveGeneratedString);
            //sending less than moreThan 255
            DriverHelper.sendKeysXpath(buildModePage.getBuild_Description_TextBox(), MoreThanTwoFiftyFiveGeneratedString);

            //Clicking on the save button
            DriverHelper.waitFluentByXPath(BrowserInitHelper.getInstance(), buildModePage.getBuild_Description_SaveButton());
            DriverHelper.clickXpath(buildModePage.getBuild_Description_SaveButton());

            //waiting for description popup get closed
            BrowserInitHelper.getWaiter().until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(buildModePage.getBuild_Description_PopupWindow())));

            //clicking on the Description button
            DriverHelper.waitFluentByXPath(BrowserInitHelper.getInstance(), buildModePage.getBuild_Description_Button());
            boolean descriptionButton = DriverHelper.checkElementDisplayByXpath(buildModePage.getBuild_Description_Button(), "Description Button");
            if (descriptionButton) {
                System.out.println("Description button is displayed");
            }

            BrowserInitHelper.getInstance().findElement(By.xpath(buildModePage.getBuild_Description_Button())).click();
            moreValue = true;
        } catch (Exception e) {
            logger.info("Exception handled for Description text MoreThan TwoHundredFiftyFive in Description Selection");
            ConsoleLogger.SuccessLog("Test cases : Passed - More than 255 characters is not taking in the Description Popup window ");
            LoggerUtility.LoggerCall("Test cases : Passed - More than 255 characters is not taking in the Description Popup window ");
        }

    }

    // To validate Description text More than 255 words
    public void verifyDescriptionTextMoreThanTwoHundredFiftyFive() {
        if (moreValue) {
            DriverHelper.waitFluentByXPath(BrowserInitHelper.getInstance(), buildModePage.getBuild_Description_TextBox());
            boolean descriptionTextBox = DriverHelper.checkElementDisplayByXpath(buildModePage.getBuild_Description_TextBox(), "Description TextBox");
            if (descriptionTextBox) {
                System.out.println("Description TextBox is displayed");
            }
            //checking the count
            if (BrowserInitHelper.getInstance().findElement(By.xpath(buildModePage.getBuild_Description_TextBox())).getAttribute("value").trim().length() <= 255) {
                ConsoleLogger.SuccessLog("Test cases : Passed - More than 255 characters is not taking in the Description Popup window");
                LoggerUtility.LoggerCall("Test cases : Passed - More than 255 characters is not taking in the Description Popup window");
            } else {
                ConsoleLogger.FailedTestCase("Test cases : Failed - More than 255 characters is taking in the Description Popup window");
                LoggerUtility.LoggerCall("Test cases : Failed - More than 255 characters is taking in the Description Popup window");
            }
        }
    }

    // To enter Description text Exact 255 words
    public void descriptionTextExactTwoHundredFiftyFive() {
        try {
            // clearing the Description Text
            DriverHelper.waitFluentByXPath(BrowserInitHelper.getInstance(), buildModePage.getBuild_Description_TextBox());
            BrowserInitHelper.getWaiter().until(ExpectedConditions.elementToBeClickable(By.xpath(buildModePage.getBuild_Description_TextBox()))).sendKeys(Keys.CONTROL + "a");
            BrowserInitHelper.getWaiter().until(ExpectedConditions.elementToBeClickable(By.xpath(buildModePage.getBuild_Description_TextBox()))).sendKeys(Keys.DELETE);

            //Generating less than 255 characters and Entering characters in the Description
            twoFiftyFiveGeneratedString = RandomStringUtils.randomAlphabetic(Integer.parseInt(csv_BuildItemDescription.getTwoHundredFiftyFiveCountString()));

            System.out.println("characters 255(MoreThan) ---->" + twoFiftyFiveGeneratedString);
            //sending less than moreThan 255
            DriverHelper.sendKeysXpath(buildModePage.getBuild_Description_TextBox(), twoFiftyFiveGeneratedString);

            //Clicking on the save button
            DriverHelper.waitFluentByXPath(BrowserInitHelper.getInstance(), buildModePage.getBuild_Description_SaveButton());
            DriverHelper.clickXpath(buildModePage.getBuild_Description_SaveButton());

            //waiting for description popup get closed
            BrowserInitHelper.getWaiter().until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(buildModePage.getBuild_Description_PopupWindow())));

            //clicking on the Description button
            DriverHelper.waitFluentByXPath(BrowserInitHelper.getInstance(), buildModePage.getBuild_Description_Button());
            boolean descriptionButton = DriverHelper.checkElementDisplayByXpath(buildModePage.getBuild_Description_Button(), "Description Button");
            if (descriptionButton) {
                System.out.println("Description button is displayed");
            }

            BrowserInitHelper.getInstance().findElement(By.xpath(buildModePage.getBuild_Description_Button())).click();
            exactValue = true;
        } catch (Exception e) {
            logger.info("Exception handled for Description text Exact TwoHundredFiftyFive in Description Selection");
            ConsoleLogger.SuccessLog("Test cases :Passed- Exact 255 characters is not taking in the Description Popup window ");
            LoggerUtility.LoggerCall("Test cases :Passed- Exact 255 characters is not taking in the Description Popup window ");
        }

    }

    // To validate Description text Exact 255 words
    public void verifyDescriptionTextExactTwoHundredFiftyFive() {
        if (exactValue) {
            DriverHelper.waitFluentByXPath(BrowserInitHelper.getInstance(), buildModePage.getBuild_Description_TextBox());

            boolean descriptionTextBox = DriverHelper.checkElementDisplayByXpath(buildModePage.getBuild_Description_TextBox(), "Description TextBox");
            if (descriptionTextBox) {
                System.out.println("Description TextBox is displayed");
            }

            //checking the text
            if (BrowserInitHelper.getInstance().findElement(By.xpath(buildModePage.getBuild_Description_TextBox())).getAttribute("value").equalsIgnoreCase(twoFiftyFiveGeneratedString)) {
                ConsoleLogger.SuccessLog("Test cases : Passed -  255 characters entered is saved properly and text is validated");
                LoggerUtility.LoggerCall("Test cases : Passed -  255 characters entered is saved properly and text is validated ");
            } else {
                ConsoleLogger.FailedTestCase("Test cases : Failed -  255 characters is not saved properly and text is not validated");
                LoggerUtility.LoggerCall("Test cases : Failed -  255 characters is not saved properly and text is not validated");
            }

            //checking the count

            if (BrowserInitHelper.getInstance().findElement(By.xpath(buildModePage.getBuild_Description_TextBox())).getAttribute("value").trim().length() == 255) {
                ConsoleLogger.SuccessLog("Test cases : Passed -  255 characters count is taking in the Description Popup window");
                LoggerUtility.LoggerCall("Test cases : Passed -  255 characters count is taking in the Description Popup window");
            } else {
                ConsoleLogger.FailedTestCase("Test cases : Failed -  255 characters count is not taking in the Description Popup window");
                LoggerUtility.LoggerCall("Test cases : Failed -  255 characters count is not taking in the Description Popup window");
            }
        }
    }

    // To enter SpecialCharacters For DescriptionText
    public void specialCharactersForDescriptionText() {
        try {
            // clearing the Description Text
            DriverHelper.waitFluentByXPath(BrowserInitHelper.getInstance(), buildModePage.getBuild_Description_TextBox());
            BrowserInitHelper.getWaiter().until(ExpectedConditions.elementToBeClickable(By.xpath(buildModePage.getBuild_Description_TextBox()))).sendKeys(Keys.CONTROL + "a");
            BrowserInitHelper.getWaiter().until(ExpectedConditions.elementToBeClickable(By.xpath(buildModePage.getBuild_Description_TextBox()))).sendKeys(Keys.DELETE);

            DriverHelper.sendKeysXpath(buildModePage.getBuild_Description_TextBox(), csv_BuildItemDescription.getSpecialCharactersString());

            //Clicking on the save button
            DriverHelper.waitFluentByXPath(BrowserInitHelper.getInstance(), buildModePage.getBuild_Description_SaveButton());
            DriverHelper.clickXpath(buildModePage.getBuild_Description_SaveButton());

            //waiting for description popup get closed
            BrowserInitHelper.getWaiter().until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(buildModePage.getBuild_Description_PopupWindow())));

            //clicking on the Description button
            DriverHelper.waitFluentByXPath(BrowserInitHelper.getInstance(), buildModePage.getBuild_Description_Button());
            boolean descriptionButton = DriverHelper.checkElementDisplayByXpath(buildModePage.getBuild_Description_Button(), "Description Button");
            if (descriptionButton) {
                System.out.println("Description button is displayed");
            }

            BrowserInitHelper.getInstance().findElement(By.xpath(buildModePage.getBuild_Description_Button())).click();
            specialValue = true;
        } catch (Exception e) {
            logger.info("Exception handled for SpecialCharacters in Description Selection");
            ConsoleLogger.FailedTestCase("Test cases : Failed - SpecialCharacters Selection is not taking in the Description Popup window ");
            LoggerUtility.LoggerCall("Test cases : Failed - SpecialCharacters Selection is not taking in the Description Popup window ");
        }

    }

    // To validate SpecialCharacters For Description Text
    public void verifySpecialCharactersForDescriptionText() {
        if (specialValue) {
            DriverHelper.waitFluentByXPath(BrowserInitHelper.getInstance(), buildModePage.getBuild_Description_TextBox());
            boolean descriptionTextBox = DriverHelper.checkElementDisplayByXpath(buildModePage.getBuild_Description_TextBox(), "Description TextBox");
            if (descriptionTextBox) {
                System.out.println("Description TextBox is displayed");

                //checking the text
                if (BrowserInitHelper.getInstance().findElement(By.xpath(buildModePage.getBuild_Description_TextBox())).getAttribute("value").equalsIgnoreCase(csv_BuildItemDescription.getSpecialCharactersString())) {
                    ConsoleLogger.SuccessLog("Test cases : Passed - SpecialCharacters value is saved properly and text validated");
                    LoggerUtility.LoggerCall("Test cases : Passed - SpecialCharacters value is saved properly and text validated ");
                } else {
                    ConsoleLogger.FailedTestCase("Test cases : Failed - SpecialCharacters value is not saved properly and text is not validated");
                    LoggerUtility.LoggerCall("Test cases : Failed - SpecialCharacters Selection is not taking in the Description Popup window ");
                }
            }
        }
    }

    // To navigate Browse Page and Check Description Saved
    public void navigateToBrowsePageAndCheckDescriptionSaved() {
        try {
            // clearing the Description Text
            DriverHelper.waitFluentByXPath(BrowserInitHelper.getInstance(), buildModePage.getBuild_Description_TextBox());
            BrowserInitHelper.getWaiter().until(ExpectedConditions.elementToBeClickable(By.xpath(buildModePage.getBuild_Description_TextBox()))).sendKeys(Keys.CONTROL + "a");
            BrowserInitHelper.getWaiter().until(ExpectedConditions.elementToBeClickable(By.xpath(buildModePage.getBuild_Description_TextBox()))).sendKeys(Keys.DELETE);

            DriverHelper.sendKeysXpath(buildModePage.getBuild_Description_TextBox(), csv_BuildItemDescription.getValidStringForNavigationSave());

            //Clicking on the save button
            DriverHelper.waitFluentByXPath(BrowserInitHelper.getInstance(), buildModePage.getBuild_Description_SaveButton());
            DriverHelper.clickXpath(buildModePage.getBuild_Description_SaveButton());

            //waiting for description popup get closed
            BrowserInitHelper.getWaiter().until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(buildModePage.getBuild_Description_PopupWindow())));

            //clicking on the Browse mode button
            DriverHelper.waitFluentByXPath(BrowserInitHelper.getInstance(), buildModePage.getBuild_BrowseButton());
            DriverHelper.clickXpath(buildModePage.getBuild_BrowseButton());
            BrowserInitHelper.getWaiter().until(ExpectedConditions.elementToBeClickable(By.xpath(browseModePage.getBrowse_ItemSection())));

            //Clicking on the Build Button
            DriverHelper.waitFluentByXPath(BrowserInitHelper.getInstance(), buildModePage.getBuild_BuildButton());
            DriverHelper.clickXpath(buildModePage.getBuild_BuildButton());
            browseModeController.checkDisplay(buildModePage.getBuild_Item_Section());

            //clicking on the Description button
            DriverHelper.waitFluentByXPath(BrowserInitHelper.getInstance(), buildModePage.getBuild_Description_Button());
            boolean descriptionButton = DriverHelper.checkElementDisplayByXpath(buildModePage.getBuild_Description_Button(), "Description Button");
            if (descriptionButton) {
                System.out.println("Description button is displayed");
            }

            BrowserInitHelper.getInstance().findElement(By.xpath(buildModePage.getBuild_Description_Button())).click();
            navigationValue = true;
        } catch (Exception e) {
            logger.info("Exception handled for  Selection - Navigation  to BrowsePage an dCheck Description Saved");
            ConsoleLogger.FailedTestCase("Test cases : Failed - Selection - Navigation  to BrowsePage and Check Description Saved ");
            LoggerUtility.LoggerCall("Test cases : Failed - Selection - Navigation  to BrowsePage and Check Description Saved");
        }
    }

    // To validate Navigate to Browse and Check Description Saved
    public void verifyNavigateToBrowseAndCheckDescriptionSaved() {
        if (navigationValue) {
            DriverHelper.waitFluentByXPath(BrowserInitHelper.getInstance(), buildModePage.getBuild_Description_TextBox());
            boolean descriptionTextBox = DriverHelper.checkElementDisplayByXpath(buildModePage.getBuild_Description_TextBox(), "Description TextBox");
            if (descriptionTextBox) {
                System.out.println("Description TextBox is displayed");

                //checking the text
                if (BrowserInitHelper.getInstance().findElement(By.xpath(buildModePage.getBuild_Description_TextBox())).getAttribute("value").equalsIgnoreCase(csv_BuildItemDescription.getValidStringForNavigationSave())) {
                    ConsoleLogger.SuccessLog("Test cases : Passed - After navigation from browse page value is saved properly and text validated");
                    LoggerUtility.LoggerCall("Test cases : Passed - After navigation from browse page value is saved properly and text validated");
                } else {
                    ConsoleLogger.FailedTestCase("Test cases : Failed - After navigation from browse page value is not saved properly and text is not validated");
                    LoggerUtility.LoggerCall("Test cases : Failed - After navigation from browse page value is not saved properly and text is not validated");
                }
            }
        }
    }
}

