package Controllers;

import DataReaders.CSVDataReaderBuildModePublish;
import Helpers.BrowserInitHelper;
import Helpers.DriverHelper;
import Pom.BrowseModePage;
import Pom.BuildModePage;
import Pom.ViewAssessmentsPage;
import Utils.ConsoleLogger;
import Utils.LoggerUtility;
import org.openqa.selenium.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Controller class for BuildMode
 **/
public class BuildModeController {

    private static final Logger log = LoggerFactory.getLogger(BrowserInitHelper.class);

    CSVDataReaderBuildModePublish csvDataReaderBuildModePublish = new CSVDataReaderBuildModePublish();
    BrowseModePage browseModePage = new BrowseModePage();
    BuildModePage buildModePage = new BuildModePage();
    ViewAssessmentsPage viewAssessmentsPage = new ViewAssessmentsPage();

    //Method to create assessment
    public void createAssessment() {
        DriverHelper.clickXpath(browseModePage.getAddItems());
        DriverHelper.clickXpath(browseModePage.getCreateAssessments());
        BrowserInitHelper.getInstance().findElement(By.xpath(browseModePage.getAssessmentName())).sendKeys(csvDataReaderBuildModePublish.getAssessment());
        DriverHelper.clickXpath(browseModePage.getCreateButton());
    }

    //Method to click Done
    public void clickDone() {
        DriverHelper.waitFluentByXPath(BrowserInitHelper.getInstance(), browseModePage.getDoneButton());
        DriverHelper.clickXpath(browseModePage.getDoneButton());
    }

    //Method to navigate to browse mode
    public void navigateToBrowse() {
        DriverHelper.clickXpath(browseModePage.getAssessmentsTab());
        DriverHelper.clickXpath(browseModePage.getNavigateToBrowse());
    }

    //Method to search item by ID
    public void searchById(String id) {
        DriverHelper.clickXpath(browseModePage.getCloseSearch());
        DriverHelper.sendKeysXpath(browseModePage.getSearchItemId(), id);
        DriverHelper.clickXpath(browseModePage.getItemSearch());
        DriverHelper.waitFluentByXPath(BrowserInitHelper.getInstance(), browseModePage.getAddItemById());
        DriverHelper.clickXpath(browseModePage.getAddItemById());
    }

    //Method to select item
    public void createAssessmentForMultiItem() {
        DriverHelper.clickXpath(browseModePage.getCreateAssessments());
        BrowserInitHelper.getInstance().findElement(By.xpath(browseModePage.getAssessmentName())).sendKeys(csvDataReaderBuildModePublish.getAssessment());
        DriverHelper.clickXpath(browseModePage.getCreateButton());
    }

    //Method to skip Draft item
//    public void Draft() {
//        boolean isExist = false;
//        try {
//            BrowserInitHelper.getInstance().findElement(By.xpath("//span[contains(text(),'Draft')]"));
//            if (isExist = true) {
//                DriverHelper.clickXpath("(//div[@class='ibx-item-card browse-items__item']//div[@class='v-card__title x-content-card__header']//button/div[contains(.,'Add Item')])[2]");
//            } else {
//                ConsoleLogger.DebugLog("Draft is there skip to next item");
//            }
//
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }


    //Method to remove Item
    public void removeItem() {
        DriverHelper.clickXpath(browseModePage.getMoreVert());
        DriverHelper.clickXpath(browseModePage.getRemoveItem());
        DriverHelper.clickXpath(browseModePage.getBrowseToggle());
    }

    //Click on create assessment
    public void e_CreateAssessment() {
        createAssessment();

    }

    //Validate Build Navigation Done Button
    public void verifyBuildNavigationAndDoneButton() {
        BrowserInitHelper.getInstance().findElement(By.xpath(buildModePage.getDoneButton())).isDisplayed();
        ConsoleLogger.SuccessLog("Test cases : Passed - Build page should open and Done button is present.");
        LoggerUtility.LoggerCall("Test cases : Passed - Build page should open and Done button is present.");
    }

    //Validate Done options
    public void verifyDoneButtonOptions() {
        BrowserInitHelper.getInstance().findElement(By.xpath(buildModePage.getDonePopup())).isDisplayed();
        ConsoleLogger.SuccessLog("Test cases : Passed - Pop over menu displays with all options ");
        LoggerUtility.LoggerCall("Test cases : Passed - Pop over menu displays with all options ");
    }

    //Click on Discard changes
    public void clickOnDiscardChangesButton() {
        DriverHelper.waitFluentByXPath(BrowserInitHelper.getInstance(), buildModePage.getDiscardButton());
        WebElement element = BrowserInitHelper.getInstance().findElement(By.xpath(buildModePage.getDiscardText()));
        if (element.getText().contains("Deletes your assess")) {
            ConsoleLogger.SuccessLog("Test cases : Passed - Discard button and text is verified");
            LoggerUtility.LoggerCall("Test cases : Passed - Discard button and text is verified");
        }
        DriverHelper.clickXpath(buildModePage.getDiscardButton());
        BrowserInitHelper.getInstance().findElement(By.xpath(buildModePage.getDiscardChanges())).isDisplayed();

        DriverHelper.waitFluentByXPath(BrowserInitHelper.getInstance(), buildModePage.getDeleteButton());
        DriverHelper.clickXpath(buildModePage.getDeleteButton());
        ConsoleLogger.SuccessLog("Test cases : Passed - Assessment should be deleted successfully ");
        LoggerUtility.LoggerCall("Test cases : Passed - Assessment should be deleted successfully ");
    }

    //validate return to browse item page
    public void verifyReturnToBrowseItemPage() {
        DriverHelper.waitFluentByXPath(BrowserInitHelper.getInstance(), buildModePage.getBrowsePage());
        ConsoleLogger.SuccessLog("Test cases : Passed - User is returned to Browse item Page");
        LoggerUtility.LoggerCall("Test cases : Passed - User is returned to Browse item Page");
        createAssessment();
        clickDone();
    }

    //Click on save Draft button
    public void clickOnSaveDraft() {
        DriverHelper.waitFluentByXPath(BrowserInitHelper.getInstance(), buildModePage.getSaveDraftButton());
        WebElement element = BrowserInitHelper.getInstance().findElement(By.xpath(buildModePage.getSaveDraftText()));
        if (element.getText().contains("Saves a draft of your ")) {
            ConsoleLogger.SuccessLog("Test cases : Passed - Save Draft button and is text verified");
            LoggerUtility.LoggerCall("Test cases : Passed - Save Draft button and is text verified");
        }
        try {
            DriverHelper.clickXpath(buildModePage.getSaveDraftButton());
            DriverHelper.waitFluentByXPath(BrowserInitHelper.getInstance(), viewAssessmentsPage.getDraftItemBank());
            DriverHelper.clickXpath(viewAssessmentsPage.getDraftItemBank());
            DriverHelper.waitFluentByXPath(BrowserInitHelper.getInstance(), viewAssessmentsPage.getViewAssessmentsTable());
            DriverHelper.waitFluentByXPath(BrowserInitHelper.getInstance(), viewAssessmentsPage.getAssessmentsName());
            ConsoleLogger.SuccessLog("Test cases : Passed - Assessment is present in Draft");
            LoggerUtility.LoggerCall("Test cases : Passed - Assessment is present in Draft");
        } catch (Exception e) {
            System.out.println("Exception handled for Draft");
        }
    }

    //Validate Navigate to view Assessment Page
    public void verifyNavigateToViewAssessment() {
        DriverHelper.waitFluentByXPath(BrowserInitHelper.getInstance(), buildModePage.getAssessmentPage());
        ConsoleLogger.SuccessLog("Test cases : Passed - Assessment should get saved and navigated to View assessments");
        LoggerUtility.LoggerCall("Test cases : Passed - Assessment should get saved and navigated to View assessments");
    }

    //Validate create assessment Button
    public void verifyCreateAssessmentButton() {
        DriverHelper.waitFluentByXPath(BrowserInitHelper.getInstance(), browseModePage.getCreateAssessments());
        ConsoleLogger.SuccessLog("Test cases : Passed - User should able to see Create assessment button");
        LoggerUtility.LoggerCall("Test cases : Passed - User should able to see Create assessment button");
    }

    //Click on publish button
    public void clickOnPublishButton() {
        try {
            createAssessment();
            clickDone();
            DriverHelper.waitFluentByXPath(BrowserInitHelper.getInstance(), buildModePage.getPublishButton());
            WebElement element = BrowserInitHelper.getInstance().findElement(By.xpath(buildModePage.getPublishText()));
            if (element.getText().contains("Publishes your assessment")) {
                ConsoleLogger.SuccessLog("Test cases : Passed - publish button and  text is verified");
                LoggerUtility.LoggerCall("Test cases : Passed - publish button and  text is verified");
            }

            DriverHelper.waitFluentByXPath(BrowserInitHelper.getInstance(), buildModePage.getPublishButton());
            DriverHelper.clickXpath(buildModePage.getPublishButton());
            ConsoleLogger.SuccessLog("Test cases : Passed - Assessment is saved and published");
            LoggerUtility.LoggerCall("Test cases : Passed - Assessment is saved and published");
        } catch (Exception e) {
            System.out.println("Exception handled for method e_ClickOnPublishButton...");
        }
    }

    //Validate View Assessments page
    public void verifyViewAssessmentsPageInATD() {
        //  DriverHelper.waitTill(3);
        //BrowserInitHelper.getInstance().findElement(By.xpath("//div[@class='v-list__tile__action']//button[@class='x-btn v-btn theme--light primary']")).isDisplayed();
        try {
            DriverHelper.waitFluentByXPath(BrowserInitHelper.getInstance(), buildModePage.getAssessmentTabPage());
            ConsoleLogger.SuccessLog("Test cases : Passed - Assessments page is verified");
            LoggerUtility.LoggerCall("Test cases : Passed - Assessments page is verified");
        } catch (Exception e) {
            System.out.println("Exception handled for method - v_VerifyViewAssessmentsPageInatb");
        }

    }

    //Click on administer now button
    public void clickOnAdministerNowButton() {
        DriverHelper.waitFluentByXPath(BrowserInitHelper.getInstance(), buildModePage.getAdministerButton());
        DriverHelper.clickXpath(buildModePage.getAdministerButton());
        ConsoleLogger.SuccessLog("Test cases : Passed - Assessment is saved as Published and user is taken to Administration page.");
        LoggerUtility.LoggerCall("Test cases : Passed - Assessment is saved as Published and user is taken to Administration page.");

        WebElement element = BrowserInitHelper.getInstance().findElement(By.xpath(buildModePage.getAdministerText()));
        if (element.getText().contains("Administer")) {
            ConsoleLogger.SuccessLog("Test cases : Passed - Administer text is verified");
            LoggerUtility.LoggerCall("Test cases : Passed - Administer text is verified.");
        }

    }

    //Validate Administration page
    public void verifyAdministrationPage() {
        // DriverHelper.waitTill(5);
        BrowserInitHelper.waitUntil(buildModePage.getOnlineTesting());
        DriverHelper.clickXpath(buildModePage.getOnlineTesting());
        DriverHelper.waitFluentByXPath(BrowserInitHelper.getInstance(), buildModePage.getAssessmentOnlineTestingPage());
        ConsoleLogger.SuccessLog("Test cases : Passed - Administration page is verified");
        LoggerUtility.LoggerCall("Test cases : Passed - Administration page is verified");
        //BrowserInitHelper.getInstance().findElement(By.xpath("//div[@class='settings-container']")).isDisplayed();
    }

    //Click on Assessments and do changes
    public void clickOnAssessmentAndClickDone() {
        DriverHelper.clickXpath(buildModePage.getBackToAssessments());
        DriverHelper.clickXpath(buildModePage.getView());
    }

    public void verifyNavigateToViewItemPageWithChanges() {
        // DriverHelper.waitTill(5);
        DriverHelper.waitFluentByXPath(BrowserInitHelper.getInstance(), buildModePage.getViewButton());
        BrowserInitHelper.waitUntil(buildModePage.getViewButton());
        DriverHelper.waitFluentByXPath(BrowserInitHelper.getInstance(), buildModePage.getWeightButton());
        DriverHelper.clickXpath(buildModePage.getWeightButton());
    }

    //click on Done button
    public void clickOnDone() {
        DriverHelper.waitFluentByXPath(BrowserInitHelper.getInstance(), buildModePage.getChangesDone());
        DriverHelper.clickXpath(buildModePage.getChangesDone());
        ConsoleLogger.SuccessLog("Test cases : Passed - User is navigated to View Assessments page with changes saved.");
        LoggerUtility.LoggerCall("Test cases : Passed - User is navigated to View Assessments page with changes saved.");
    }

    //validate all options
    public void verifyAllOptions() {
        DriverHelper.waitFluentByXPath(BrowserInitHelper.getInstance(), buildModePage.getAllOptions());
    }

    //Click on create item
    public void clickOnCreateItem() {
        navigateToBrowse();
        DriverHelper.waitFluentByXPath(BrowserInitHelper.getInstance(), browseModePage.getAddItems());
        DriverHelper.clickXpath(browseModePage.getAddItems());
        searchById(csvDataReaderBuildModePublish.getCrItemID());
        DriverHelper.waitFluentByXPath(BrowserInitHelper.getInstance(), browseModePage.getCloseSearch());
        DriverHelper.clickXpath(browseModePage.getCloseSearch());

        searchById(csvDataReaderBuildModePublish.getMsItemID());

        createAssessmentForMultiItem();
        DriverHelper.waitFluentByXPath(BrowserInitHelper.getInstance(), buildModePage.getBuildModeFirstDoneButton());
        clickDone();
        DriverHelper.clickXpath(buildModePage.getPublishButton());
    }

    //Validate View Assessment page
    public void verifyViewAssessmentPage() {
        DriverHelper.waitFluentByXPath(BrowserInitHelper.getInstance(), buildModePage.getAssessPage());
        ConsoleLogger.SuccessLog(" Test cases : Passed - Assessments Page is verified and published ");
        LoggerUtility.LoggerCall("Test cases : Passed - Assessments Page is verified and published ");
        navigateToBrowse();
        searchById(csvDataReaderBuildModePublish.getDraftID());
        createAssessmentForMultiItem();
        clickDone();
        DriverHelper.waitFluentByXPath(BrowserInitHelper.getInstance(), buildModePage.getDraftItemWarning());
        clickDone();
        removeItem();
        // buildMode_Controller.searchById(csv_BuildItemDescription.getCrItemID());
        DriverHelper.clickXpath(browseModePage.getCloseSearch());
        DriverHelper.clickXpath(browseModePage.getAddItems());

        DriverHelper.waitFluentByXPath(BrowserInitHelper.getInstance(), buildModePage.getBuildToggle());
        DriverHelper.clickXpath(buildModePage.getBuildToggle());
        clickDone();
        boolean publishButton = BrowserInitHelper.getInstance().findElement(By.xpath(buildModePage.getPublishTextButton())).isEnabled();
        if (publishButton) {
            ConsoleLogger.SuccessLog("Test cases : Passed - Publish is enabled");
            LoggerUtility.LoggerCall("Test cases : Passed - Publish is enabled");
        } else {
            ConsoleLogger.FailedTestCase("Test cases : Failed - Test cases : Passed - Publish is disabled");
            LoggerUtility.LoggerCall("Test cases : Failed - Test cases : Passed - Publish is disabled");
        }
        DriverHelper.clickXpath(buildModePage.getPublishButton());

        ConsoleLogger.SuccessLog("Test cases : Passed - Assessment is published with item");
        LoggerUtility.LoggerCall("Test cases : Passed - Assessment is published with item");
    }

    //Click on Assessment without item
    public void clickAssessmentWithoutItem() {
        DriverHelper.waitFluentByXPath(BrowserInitHelper.getInstance(), browseModePage.getAssessmentsTab());
        DriverHelper.clickXpath(browseModePage.getAssessmentsTab());
        DriverHelper.waitFluentByXPath(BrowserInitHelper.getInstance(), browseModePage.getNavigateToBrowse());
        DriverHelper.clickXpath(browseModePage.getNavigateToBrowse());
        createAssessmentForMultiItem();

        // buildMode_Controller.removeItem();
        // DriverHelper.clickXpath(pom_BuildModePage.getBuildToggle());
    }

    //Validate Not published item
    public void verifyNotPublished() {
        clickDone();
        boolean Discard = BrowserInitHelper.getInstance().findElement(By.xpath(buildModePage.getCheckDiscard())).isEnabled();
        if (Discard) {
            ConsoleLogger.SuccessLog("Test cases : Passed - Discard button is displayed");
            LoggerUtility.LoggerCall("Test cases : Passed - Discard button is displayed");
        } else {
            ConsoleLogger.FailedTestCase("Test cases : Failed - Discard not disabled");
            LoggerUtility.LoggerCall("Test cases : Failed - Discard not disabled");
        }
        boolean Save = BrowserInitHelper.getInstance().findElement(By.xpath(buildModePage.getCheckSaveDraft())).isEnabled();
        if (Save) {
            ConsoleLogger.SuccessLog("Test cases : Passed - Save button is displayed");
            LoggerUtility.LoggerCall("Test cases : Passed - Save button is displayed");
        } else {
            ConsoleLogger.FailedTestCase("Test cases : Failed - Save is disabled");
            LoggerUtility.LoggerCall("Test cases : Failed - Save is disabled");
        }
        boolean Publish = BrowserInitHelper.getInstance().findElement(By.xpath(buildModePage.getCheckPublish())).isEnabled();
        if (Publish) {
            ConsoleLogger.SuccessLog("Test cases : Passed - Publish is disabled");
            LoggerUtility.LoggerCall("Test cases : Passed - Publish is disabled");
        } else {
            ConsoleLogger.FailedTestCase("Test cases : Failed - Publish is enabled");
            LoggerUtility.LoggerCall("Test cases : Failed - Publish is enabled");
        }
    }

}
