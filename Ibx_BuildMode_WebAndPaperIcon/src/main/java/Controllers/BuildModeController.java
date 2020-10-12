package Controllers;

import Helpers.BrowserInitHelper;
import Helpers.DriverHelper;
import Helpers.JavascriptHelper;

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
 * Controllers class for BuildMode
 **/
public class BuildModeController {

    DataReader dataReader = new DataReader();
    BrowseModePage pom_BrowseModePage = new BrowseModePage();
    BuildModePage pom_BuildModePage = new BuildModePage();

    /**
     * LoggerFactory
     */
    private static final Logger log = LoggerFactory.getLogger(BrowserInitHelper.class);


    //Click on online item and click on create assessment
    public void OnlineItemClickCreateAssessment() {
        DriverHelper.waitFluentByXPath(BrowserInitHelper.getInstance(), pom_BrowseModePage.getCloseSearch());
        DriverHelper.clickXpath(pom_BrowseModePage.getCloseSearch());

        DriverHelper.waitFluentByXPath(BrowserInitHelper.getInstance(), pom_BrowseModePage.getSearchTextField());
        BrowserInitHelper.getInstance().findElement(By.xpath(pom_BrowseModePage.getSearchTextField())).sendKeys(dataReader.getItemIdOnline());

        DriverHelper.waitFluentByXPath(BrowserInitHelper.getInstance(), pom_BrowseModePage.getItemSearch());
        DriverHelper.clickXpath(pom_BrowseModePage.getItemSearch());
        try {
            DriverHelper.waitFluentByXPath(BrowserInitHelper.getInstance(), pom_BrowseModePage.getBrowse_ItemSection());
        } catch (Exception e) {
            System.out.println("Exception Handled for Page load ");
        }
        DriverHelper.waitFluentByXPath(BrowserInitHelper.getInstance(), pom_BrowseModePage.getWebIcon());
        WebElement element = BrowserInitHelper.getInstance().findElement(By.xpath(pom_BrowseModePage.getWebIcon()));
        Actions action = new Actions(BrowserInitHelper.getInstance());
        action.moveToElement(element).perform();

        DriverHelper.checkElementDisplayByXpath(pom_BrowseModePage.getWebIcon(), "WebIcon");
        DriverHelper.waitFluentByXPath(BrowserInitHelper.getInstance(), pom_BrowseModePage.getAddItem());
        DriverHelper.clickXpath(pom_BrowseModePage.getAddItem());
        DriverHelper.waitFluentByXPath(BrowserInitHelper.getInstance(), pom_BrowseModePage.getCreateAssessment());
        DriverHelper.clickXpath(pom_BrowseModePage.getCreateAssessment());
        DriverHelper.waitFluentByXPath(BrowserInitHelper.getInstance(), pom_BrowseModePage.getAssessmentName());
        String textField = pom_BrowseModePage.getAssessmentName();
        // String textField="//div[@class='v-input new-assessment-text-field v-text-field v-text-field--single-line v-text-field--enclosed v-text-field--outline v-input--has-state theme--light error--text']//input";
        WebElement element1 = BrowserInitHelper.getInstance().findElement(By.xpath(textField));
        Actions action1 = new Actions(BrowserInitHelper.getInstance());
        action1.click(element1).sendKeys(dataReader.getAssessment()).build().perform();

        System.out.println("dataReader" + dataReader.getAssessment());

        DriverHelper.waitFluentByXPath(BrowserInitHelper.getInstance(), pom_BrowseModePage.getAssessmentName());

        JavascriptHelper.sendValuesByXpath_JS(textField, dataReader.getAssessment());
        // DriverHelper.sendKeysXpath("//div[@class='v-input new-assessment-text-field v-text-field v-text-field--single-line v-text-field--enclosed v-text-field--outline v-input--has-state theme--light error--text']//input",dataReader.getAssessment());

        DriverHelper.waitFluentByXPath(BrowserInitHelper.getInstance(), pom_BrowseModePage.getCreateButton());
        DriverHelper.clickXpath(pom_BrowseModePage.getCreateButton());
        try {
            DriverHelper.waitFluentByXPath(BrowserInitHelper.getInstance(), pom_BuildModePage.getBuild_Item_Section());
        } catch (Exception e) {
            System.out.println("Exception handled for Build Mode Page");
        }
        JavascriptHelper.scrollBottomOfThePage();
        DriverHelper.waitFluentByXPath(BrowserInitHelper.getInstance(), pom_BuildModePage.getShowMore());
        DriverHelper.clickXpath(pom_BuildModePage.getShowMore());

        DriverHelper.waitFluentByXPath(BrowserInitHelper.getInstance(), pom_BuildModePage.getDetailedInformation());
    }

    //Validate Media type is web only
    public void verifyMediaType() {
        DriverHelper.clickXpath(pom_BuildModePage.getDetailedInformation());
        boolean mediaType = DriverHelper.checkElementDisplayByXpath(pom_BuildModePage.getDepthAboutItem(), "MediaType");
        if (mediaType) {
            ConsoleLogger.SuccessLog("Test cases : Passed - Media Type is Web only");
            LoggerUtility.LoggerCall("Test cases : Passed - Media Type is Web only");
        } else {
            ConsoleLogger.FailedTestCase("Test cases : Failed - Media type is not web");
            LoggerUtility.LoggerCall("Test cases : Failed - Media type is not web");
        }
        String media = BrowserInitHelper.getInstance().findElement(By.xpath(pom_BuildModePage.getDepthAboutItem())).getText();
        media.split(",");
        System.out.println("media" + media);
        if (media.contains("Media Type: Web Only")) {
            ConsoleLogger.SuccessLog("Test cases : Passed - Media type verified");
            LoggerUtility.LoggerCall("Test cases : Passed - Media type verified");
        } else {
            ConsoleLogger.FailedTestCase("Test cases : Failed - Media type not verified");
            LoggerUtility.LoggerCall("Test cases : Failed - Media type not verified");
        }
    }

    //Click on online and paper icon item
    public void clickOnlineAndPaper() {
        DriverHelper.waitFluentByXPath(BrowserInitHelper.getInstance(), pom_BuildModePage.getBrowseBuildToggle());
        DriverHelper.clickXpath(pom_BuildModePage.getBrowseBuildToggle());
        DriverHelper.waitFluentByXPath(BrowserInitHelper.getInstance(), pom_BuildModePage.getCloseSearch());

        DriverHelper.clickXpath(pom_BuildModePage.getCloseSearch());
        DriverHelper.waitFluentByXPath(BrowserInitHelper.getInstance(), pom_BuildModePage.getCloseSearch());

        DriverHelper.clickXpath(pom_BuildModePage.getCloseSearch());

        DriverHelper.waitFluentByXPath(BrowserInitHelper.getInstance(), pom_BuildModePage.getSearchTextBox());
        BrowserInitHelper.getInstance().findElement(By.xpath(pom_BuildModePage.getSearchTextBox())).sendKeys(dataReader.getItemOnlineAndPaper());
        DriverHelper.waitFluentByXPath(BrowserInitHelper.getInstance(), pom_BuildModePage.getSearchItem());
        DriverHelper.clickXpath(pom_BuildModePage.getSearchItem());
        try {
            DriverHelper.waitFluentByXPath(BrowserInitHelper.getInstance(), pom_BrowseModePage.getBrowse_ItemSection());
        } catch (Exception e) {
            System.out.println("Exception Handled for Page load ");
        }
        DriverHelper.waitFluentByXPath(BrowserInitHelper.getInstance(), pom_BuildModePage.getWebAndPaper());
        WebElement element = BrowserInitHelper.getInstance().findElement(By.xpath(pom_BuildModePage.getWebAndPaper()));
        Actions action = new Actions(BrowserInitHelper.getInstance());
        action.moveToElement(element).perform();
        DriverHelper.clickXpath(pom_BuildModePage.getAddItem());
        try {
            DriverHelper.waitFluentByXPath(BrowserInitHelper.getInstance(), pom_BrowseModePage.getSavingMessage());
        } catch (Exception e) {
            System.out.println("Exception Handled for Saving");
        }
        DriverHelper.waitFluentByXPath(BrowserInitHelper.getInstance(), pom_BuildModePage.getNavigateToBuild());
        DriverHelper.clickXpath(pom_BuildModePage.getNavigateToBuild());
        try {
            DriverHelper.waitFluentByXPath(BrowserInitHelper.getInstance(), pom_BuildModePage.getBuild_Item_Section());
        } catch (Exception e) {
            System.out.println("Exception handled for Build Mode Page");
        }
        JavascriptHelper.scrollBottomOfThePage();
        DriverHelper.waitFluentByXPath(BrowserInitHelper.getInstance(), pom_BuildModePage.getShowMoreForBoth());
        DriverHelper.clickXpath(pom_BuildModePage.getShowMoreForBoth());
        JavascriptHelper.scrollIntoView(pom_BuildModePage.getDetailedInformationForBoth());
    }

    //Validate media type
    public void verifyMediaTypeOnlineAndPaper() {
        DriverHelper.waitFluentByXPath(BrowserInitHelper.getInstance(), pom_BuildModePage.getDetailedInformationForBoth());
        DriverHelper.clickXpath(pom_BuildModePage.getDetailedInformationForBoth());
        DriverHelper.waitFluentByXPath(BrowserInitHelper.getInstance(), pom_BuildModePage.getMediaTypeForBoth());
        boolean elementDisplay = DriverHelper.checkElementDisplayByXpath(pom_BuildModePage.getMediaTypeForBoth(), "MediaTypeForBoth");
        if (elementDisplay) {
            ConsoleLogger.SuccessLog("Test cases : Passed - Media type is online and Paper");
            LoggerUtility.LoggerCall("Test cases : Passed - Media type is online and Paper");
        } else {
            ConsoleLogger.FailedTestCase("Test cases : Failed - Media Type is not Online and Paper");
            LoggerUtility.LoggerCall("Test cases : Failed - Media Type is not Online and Paper");
        }
        String media = BrowserInitHelper.getInstance().findElement(By.xpath(pom_BuildModePage.getMediaTypeForBoth())).getText();
        media.split(",");
        // if(media.contains())
        System.out.println("media" + media);
        if (media.contains("Media Type: Paper & Web")) {
            ConsoleLogger.SuccessLog("Test cases : Passed - item is both paper and web based");
            LoggerUtility.LoggerCall("Test cases : Passed - item is both paper and web based");
        } else {
            ConsoleLogger.FailedTestCase("Test cases : Failed - item is not paper and web based");
            LoggerUtility.LoggerCall("Test cases : Failed - item is not paper and web based");
        }
    }
}
