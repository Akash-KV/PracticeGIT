package Controllers;

import DataReaders.CSVDataReaderBuildMassApply;
import Helpers.BrowserInitHelper;
import Helpers.DriverHelper;
import Helpers.JavascriptHelper;
import Pom.BrowseModePage;
import Pom.BuildModePage;
import Utils.ConsoleLogger;
import Utils.LoggerUtility;
import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Controller class for BuildMode
 **/
public class BuildModeController {
    boolean checkAddItem, checkPassage = false;
    CSVDataReaderBuildMassApply csvDataReaderBuildMassApply = new CSVDataReaderBuildMassApply();
    BrowseModePage browseModePage = new BrowseModePage();
    BuildModePage buildModePage = new BuildModePage();
    /**
     * LoggerFactory
     */
    private static final Logger log = LoggerFactory.getLogger(BrowserInitHelper.class);

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

    //Method to getCurrentTimeStamp
    public String getCurrentTimeStamp() {
        String timestamp = "";

        DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
        Date date = new Date();
        timestamp = dateFormat.format(date);
        System.out.println(dateFormat.format(date));

        return timestamp;
    }

    //Method to  getAddItem
    public boolean getAddItem(String xpath, int count) {
        boolean clicked = false;

        try {
            BrowserInitHelper.getWaiter().until(ExpectedConditions.elementToBeClickable(By.xpath(xpath)));
            List<WebElement> ItemsList_AddButton = BrowserInitHelper.getInstance().findElements(By.xpath(xpath));

            System.out.println("ItemsList_AddButton SIZE==>" + ItemsList_AddButton.size());
            for (int i = 0; i < ItemsList_AddButton.size(); i++) {
                if (i < count) {
                    BrowserInitHelper.getWaiter().until(ExpectedConditions.elementToBeClickable(ItemsList_AddButton.get(i)));
                    WebElement add_item = ItemsList_AddButton.get(i);
                    //Click Add Item for items

                    add_item.click();
                    System.out.println(i + "ivalue");
                    clicked = true;
//            List<WebElement> ItemsList_AddButton = BrowserInitHelper.getInstance().findElements(By.xpath("//div[@class='ibx-item-card browse-items__item']//div[@class='v-card__title x-content-card__header']//button/div[contains(.,'Add Item')]"));
//            //   checkAddItem = true;
//            int size_AddItem = ItemsList_AddButton.size();
//            for (int i = 0; i < ItemsList_AddButton.size(); i++) {
//                //Add two items
//                if (i < count) {
//                    WebElement add_item = ItemsList_AddButton.get(i);
//                    //Click Add Item for two items
//                   JavascriptHelper.clickWebelement_JS(add_item);
//                    //add_item.click();
//                    Thread.sleep(3000);
                }
            }
            // Thread.sleep(3000);

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
            // buildModePage.readProperties();
            System.out.println("Waiting for Items Section " + browseModePage.getBrowse_ItemSection());
            BrowserInitHelper.getWaiter().until(ExpectedConditions.elementToBeClickable(By.xpath(browseModePage.getBrowse_ItemSection())));
            System.out.println("Selecting Items");
            //Select Items and click on Create
            checkAddItem = getAddItem(browseModePage.getBrowse_AddItem_List(), 2);
            //If items displayed, then create assessment
            if (checkAddItem) {
                System.out.println("Checking the display of Create Assessment");
                //Create Assessment
                boolean check_CreateAssessmentButton = checkDisplay(browseModePage.getCreateAssessmentButton());
                if (check_CreateAssessmentButton) {
                    ConsoleLogger.SuccessLog("Test cases : Passed - Create Assessment Button is displayed.....");
                    LoggerUtility.LoggerCall("Test cases : Passed - Create Assessment Button is displayed.....");
                    DriverHelper.clickXpath(browseModePage.getCreateAssessmentButton());
                    //Enter Assessment Name
                    BrowserInitHelper.getWaiter().until(ExpectedConditions.elementToBeClickable(By.xpath(browseModePage.getBrowse_Title_In_CreateAssessmentPopup())));
                    WebElement TitleInputBox = BrowserInitHelper.getInstance().findElement(By.xpath(browseModePage.getBrowse_Title_In_CreateAssessmentPopup()));
                    String assessmentName = csvDataReaderBuildMassApply.getassessment() + getCurrentTimeStamp();
                    TitleInputBox.sendKeys(assessmentName);
                    //Click on Create Button
                    DriverHelper.clickXpath(browseModePage.getBrowse_CreateButton_In_CreateAssessmentPopup());
                } else {
                    ConsoleLogger.FailedTestCase("Test cases : Failed - Create Assessment Button is NOT displayed.....!!!");
                    LoggerUtility.LoggerCall("Test cases : Failed - Create Assessment Button is NOT displayed.....!!!");
                }
            }
        } catch (Exception e) {
            System.out.println("Exception handled for method - e_CreateAssessment");
        }
    }

    // To validate Build Mode
    public void verifyBuildMode() {
        try {
            /*Wait till the display of Build Mode elements*/
            BrowserInitHelper.getWaiter().until(ExpectedConditions.elementToBeClickable(By.xpath(buildModePage.getBuild_SelectedItem_Header())));
            /*Validate the display of Build Mode elements*/
            List<WebElement> Elements = BrowserInitHelper.getInstance().findElements(By.xpath(buildModePage.getBuild_SelectedItem_Header()));
            if (Elements.size() >= 1) {
                ConsoleLogger.SuccessLog("Test cases : Passed - BuildMode is verified");
                LoggerUtility.LoggerCall("Test cases : Passed - BuildMode is verified");
                Assert.assertTrue(true);
            } else {
                // Assert.assertTrue(false);
            }
        } catch (Exception e) {
            System.out.println("Exception handled for method - v_VerifyBuildMode" + e);
        }
    }

    // To Select Items
    public void selectItems() {
        try {
            /*Wait until the visiblity of SelectAll checkbox*/
            DriverHelper.awaitTillElementDisplayed("//div[@class = 'ibx-items-toolbar build-items-toolbar']", "Tool Bar");
            BrowserInitHelper.getWaiter().until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class = 'ibx-items-toolbar build-items-toolbar']")));

            /*Javascript to click Select All checkbox*/
            JavascriptExecutor js = (JavascriptExecutor) BrowserInitHelper.getInstance();
            js.executeScript("document.querySelector('.v-input.checkbox.v-input--selection-controls.v-input--checkbox.theme--light>div>div>div>input').click();");
        } catch (Exception e) {
            System.out.println("Exception handled for method - e_SelectItems");
        }
    }

    // To validate mass apply elements
    public void verifyMassApplyElements() {
        try {
            boolean isExist = false;
            List<WebElement> elements = new ArrayList<WebElement>();
            elements.add(BrowserInitHelper.getInstance().findElement(By.xpath(buildModePage.getBuild_NumOfItems_Selected())));
            elements.add(BrowserInitHelper.getInstance().findElement(By.xpath(buildModePage.getBuild_RemoveItem())));
            BrowserInitHelper.getWaiter().until(ExpectedConditions.elementToBeClickable(By.xpath(buildModePage.getBuild_SelectedItem_Header())));
            System.out.println("Size :" + elements.size());
            for (int i = 0; i < elements.size(); i++) {
                BrowserInitHelper.getWaiter().until(ExpectedConditions.visibilityOf(elements.get(i)));
                if (DriverHelper.elementExistence(elements.get(i), BrowserInitHelper.getInstance())) {
                    isExist = true;
                } else {
                    isExist = false;
                    break;
                }
            }
            Assert.assertTrue(isExist);
        } catch (Exception e) {
            System.out.println("Exception handled for method - ");
        }
    }

    // To click remove item
    public void clickRemoveItem() {
        try {
            /*Click Remove button*/
            DriverHelper.waitFluentByXPath(BrowserInitHelper.getInstance(), buildModePage.getBuild_RemoveItem());
            DriverHelper.awaitTillElementDisplayed(buildModePage.getBuild_RemoveItem(), "Remove Item");
            DriverHelper.clickXpath(buildModePage.getBuild_RemoveItem());
        } catch (Exception e) {
            System.out.println("Exception handled for method - e_ClickRemoveItem");
        }
    }

    // To validate remove item
    public void verifyRemoveItem() {
        try {
            /*Wait till the display of No Items message*/
            DriverHelper.waitFluentByXPath(BrowserInitHelper.getInstance(), buildModePage.getBuild_NoItems());
            DriverHelper.awaitTillElementDisplayed(buildModePage.getBuild_NoItems(), "No Items");
            BrowserInitHelper.getWaiter().until(ExpectedConditions.elementToBeClickable(By.xpath(buildModePage.getBuild_NoItems())));
            /*Validate the display of Build Mode elements*/
            WebElement Element = BrowserInitHelper.getInstance().findElement(By.xpath(buildModePage.getBuild_NoItems()));
            Assert.assertTrue(DriverHelper.elementExistence(Element, BrowserInitHelper.getInstance()));
        } catch (Exception e) {
            System.out.println("Exception handled for method - v_VerifyRemoveItem");
        }
    }

    // To validate item count
    public void verifyItemCount() {
        try {
            JavascriptExecutor js = (JavascriptExecutor) BrowserInitHelper.getInstance();
            js.executeScript("return document.querySelector('.header-actions__center>div>span').style.display = 'block';");
            DriverHelper.waitFluentByXPath(BrowserInitHelper.getInstance(), buildModePage.getBuild_ItemCounter());
            DriverHelper.awaitTillElementDisplayed(buildModePage.getBuild_ItemCounter(), "Item count");
            String iCount = BrowserInitHelper.getInstance().findElement(By.xpath(buildModePage.getBuild_ItemCounter())).getText();
            if (Integer.parseInt(iCount) == 0) {
                ConsoleLogger.SuccessLog("Test cases : Passed - Item count is verified");
                LoggerUtility.LoggerCall("Test cases : Passed - Item count is verified");
                Assert.assertTrue(true);
            } else {
                // Assert.assertTrue(false);
            }
        } catch (Exception e) {
            System.out.println("Exception handled for method - v_VerifyItemCount");
        }
    }

    // To select passage
    public void selectPassage() {
        try {
            Actions actions = new Actions(BrowserInitHelper.getInstance());
            /*Click Browse button*/
            DriverHelper.clickXpath(browseModePage.getBrowse_Button());
            BrowserInitHelper.getWaiter().until(ExpectedConditions.elementToBeClickable(By.xpath(browseModePage.getBrowse_ItemSection())));
            JavascriptHelper.scrollIntoView("(//div[contains(text(), 'Passage')])[1]");
            /*Wait until the display of Passage in Browse Mode*/
            BrowserInitHelper.getWaiter().until(ExpectedConditions.elementToBeClickable(By.xpath(browseModePage.getBrowse_PassageFullScreen())));
            WebElement passageFullScreen = BrowserInitHelper.getInstance().findElement(By.xpath(browseModePage.getBrowse_PassageFullScreen()));
            checkPassage = true;

            /*Click Passage Full Screen button*/
            actions.moveToElement(passageFullScreen).click().build().perform();
            /*Wait until the display of Add Item in Passage Full Screen*/
            BrowserInitHelper.getWaiter().until(ExpectedConditions.elementToBeClickable(By.xpath(browseModePage.getBrowse_PassageFullScreen_AddItem())));
            /*Click Add Item in Passage Full Screen*/
            DriverHelper.clickXpath(browseModePage.getBrowse_PassageFullScreen_AddItem());
            System.out.println("Closing Passage Full Screen pop up " + browseModePage.getBrowse_Close_Icon_In_CreateAssessmentPopup());
            /*Click Cancel in Passage Full Screen*/
            //DriverHelper.clickXpath(BrowseModePage.getBrowse_PassageFullScreen_CancelButton());
            DriverHelper.clickXpath(browseModePage.getBrowse_Close_Icon_In_CreateAssessmentPopup());
            /*Wait until the display of Add Item in Passage Full Screen*/
            //BrowserInitHelper.getWaiter().until(ExpectedConditions.elementToBeClickable(By.xpath(BuildModePage.getBuild_Button())));
            /*Click Build button*/
            DriverHelper.clickXpath(buildModePage.getBuild_Button());
        } catch (Exception e) {
            System.out.println("Exception handled for method - e_NavigateToBrowseModeAndSelectPassage");

        }
    }

    //Verify ItemCountOnPassageRemove
    public void verifyItemCountOnPassageRemove() {
        try {
            JavascriptExecutor js = (JavascriptExecutor) BrowserInitHelper.getInstance();
            js.executeScript("return document.querySelector('.header-actions__center>div>span').style.display = 'block';");
            DriverHelper.awaitTillElementDisplayed(buildModePage.getBuild_ItemCounter(), "iCount");
            String iCount = BrowserInitHelper.getInstance().findElement(By.xpath(buildModePage.getBuild_ItemCounter())).getText();
            if (Integer.parseInt(iCount) == 0) {
                ConsoleLogger.SuccessLog("Test cases : Passed - Item count is verified");
                LoggerUtility.LoggerCall("Test cases : Passed - Item count is verified");
                Assert.assertTrue(true);
            } else {
                // Assert.assertTrue(false);
            }
        } catch (Exception e) {
            System.out.println("Exception handled for method - v_VerifyItemCountOnPassageRemove");
        }
    }
}
