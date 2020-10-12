package Controllers;

import DataReaders.CSVDataReaderBrowseModeCreateAssessmentModal;
import Helpers.BrowserInitHelper;
import Helpers.DriverHelper;
import Helpers.JavascriptHelper;
import Pom.BrowseModePage;
import Pom.BuildModePage;
import Utils.ConsoleLogger;
import Utils.LoggerUtility;
import org.apache.commons.lang3.RandomStringUtils;
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
 * Controller class for BrowseMode
 **/
public class BuildModeController {

    private static final Logger logger = LoggerFactory.getLogger(BuildModeController.class);
    private static final Logger log = LoggerFactory.getLogger(BrowserInitHelper.class);

    DriverHelper Helper = new DriverHelper();
    BrowseModePage browseModePage = new BrowseModePage();
    BuildModePage buildModePage = new BuildModePage();
    CSVDataReaderBrowseModeCreateAssessmentModal csvDataReaderBrowseModeCreateAssessmentModal = new CSVDataReaderBrowseModeCreateAssessmentModal();

    boolean checkAddItem = false;
    boolean checkRemoveItem = false;
    int size_RemoveItem;

    //Check Element is displayed
    public boolean checkDisplay(String xpath) {
        boolean value = false;

        try {
            BrowserInitHelper.getWaiter().until(ExpectedConditions.elementToBeClickable(By.xpath(xpath)));
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

    // To random string
    public String randomString(final int length) {
        String value = RandomStringUtils.randomAlphabetic(length);
        return value;
    }

    // To click add items
    public void clickAddItems(int n) {
        try {
            List<WebElement> ItemsList_AddButton = BrowserInitHelper.getInstance().findElements(By.xpath(browseModePage.getBrowseAddItemList()));
            boolean checkAddItem = true;

            int size_AddItem = ItemsList_AddButton.size();
            for (int i = 0; i < ItemsList_AddButton.size(); i++) {
                //Add two items
                if (i <= n - 1) {
                    WebElement add_item = ItemsList_AddButton.get(i);

                    //Click Add Item for n items
//                    add_item.click();
                    JavascriptHelper.clickWebElement_JS(add_item);
                }

            }
        } catch (NoSuchElementException ne) {
            logger.info("NoSuchElementException handled for method - e_ClickAddItemButton....");
        } catch (TimeoutException te) {
            logger.info("TimeoutException handled for method - e_ClickAddItemButton....");
        } catch (WebDriverException we) {
            logger.info("WebDriverException handled for method - e_ClickAddItemButton....");
        } catch (Exception e) {
            logger.info("Exception handled for method - e_ClickAddItemButton....");
        }

    }

    // To get add item
    public boolean getAddItem(String xpath, int count) {
        boolean clicked = false;
        try {
            BrowserInitHelper.getWaiter().until(ExpectedConditions.elementToBeClickable(By.xpath(xpath)));
            List<WebElement> ItemsList_AddButton = BrowserInitHelper.getInstance().findElements(By.xpath(xpath));
            System.out.println("ItemsList_AddButton SIZE==>" + ItemsList_AddButton.size());
            for (int i = 0; i < ItemsList_AddButton.size(); i++) {
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
        //Enter Assessment Name
        BrowserInitHelper.getWaiter().until(ExpectedConditions.elementToBeClickable(By.xpath(browseModePage.getTitleInCreateAssessmentPopup())));
        WebElement TitleInputBox = BrowserInitHelper.getInstance().findElement(By.xpath(browseModePage.getTitleInCreateAssessmentPopup()));
        String assessmentName = csvDataReaderBrowseModeCreateAssessmentModal.getassessment() + getCurrentTimeStamp();
        TitleInputBox.sendKeys(assessmentName);

        //Click on Create Button
        DriverHelper.clickXpath(browseModePage.getCreateButton_CreateAssessmentPopup());
    }

    // To validate navigation to build mode
    public void verifyNavigateToBuild() {
        //Check display of Build mode page
        boolean check_buildView = checkDisplay(buildModePage.getBuildViewPage());
        if (check_buildView) {
            ConsoleLogger.SuccessLog("Test cases : Passed - Build View Page is displayed.....");
            LoggerUtility.LoggerCall("Test cases : Passed - Build View Page is displayed.....");
        } else {
            ConsoleLogger.FailedTestCase("Test cases : Failed - Build View Page is NOT displayed.....!!!");
            LoggerUtility.LoggerCall("Test cases : Failed - Build View Page is NOT displayed.....!!!");
        }
        Assert.assertTrue(check_buildView);
        //Check for added
        boolean check_Build_Mode_Navigation = checkDisplay(buildModePage.getItemHeader());
        if (check_Build_Mode_Navigation) {
            ConsoleLogger.SuccessLog("Test cases : Passed - Build Mode Page Item Section is displayed.....");
            LoggerUtility.LoggerCall("Test cases : Passed - Build Mode Page Item Section is displayed.....");
//            buildModeNewAssessmentModalController.checkDisplay(browseModePage.getBuild_First_Item_Content());
        } else {
            ConsoleLogger.FailedTestCase("Test cases : Failed - Build Mode Page is NOT displayed.....!!");
            LoggerUtility.LoggerCall("Test cases : Failed - Build Mode Page is NOT displayed.....!!");
        }

        //Check Assessment Name in Header
        BrowserInitHelper.getWaiter().until(ExpectedConditions.elementToBeClickable(By.xpath(buildModePage.getAssessmentName_BuildMode_Header())));
        String HeaderName = BrowserInitHelper.getInstance().findElement(By.xpath(buildModePage.getAssessmentName_BuildMode_Header())).getAttribute("value").trim();

        System.out.println("HeaderName ==>" + HeaderName);
        if (HeaderName.contains(csvDataReaderBrowseModeCreateAssessmentModal.getassessment())) {
            ConsoleLogger.SuccessLog("Test cases : Passed - Assessment Name is validated in build mode header.....");
            LoggerUtility.LoggerCall("Test cases : Passed - Assessment Name is validated in build mode header.....");
        } else {
            ConsoleLogger.FailedTestCase("Test cases : Failed - Assessment Name is NOT validated in build mode header.....!!!");
            LoggerUtility.LoggerCall("Test cases : Failed - Assessment Name is NOT validated in build mode header.....!!!");
        }

        //Go to Browse Mode from build mode
        DriverHelper.clickXpath(browseModePage.getBrowseModeToggleButton());
        boolean check_filters = checkDisplay(browseModePage.getBrowseFilters());
        if (check_filters) {
            ConsoleLogger.SuccessLog("Test cases : Passed - Navigated to Browse Mode Successful.....");
            LoggerUtility.LoggerCall("Test cases : Passed - Navigated to Browse Mode Successful.....");
        } else {
            ConsoleLogger.FailedTestCase("Test cases : Failed - Navigated to Browse Mode is Unsuccessful....!!!");
            LoggerUtility.LoggerCall("Test cases : Failed - Navigated to Browse Mode is Unsuccessful....!!!");
        }

        DriverHelper.clickXpath(buildModePage.getBuildModeToggleButton());
        boolean check_BuildView = checkDisplay(buildModePage.getBuildViewPage());
        if (check_BuildView) {
            ConsoleLogger.SuccessLog("Test cases : Passed - Build View Page is displayed.....");
            LoggerUtility.LoggerCall("Test cases : Passed - Build View Page is displayed.....");
        } else {
            ConsoleLogger.FailedTestCase("Test cases : Failed - Build View Page is NOT displayed.....!!!");
            LoggerUtility.LoggerCall("Test cases : Failed - Build View Page is NOT displayed.....!!!");
        }
        Assert.assertTrue(check_BuildView);

        BrowserInitHelper.getWaiter().until(ExpectedConditions.elementToBeClickable(By.xpath(buildModePage.getAssessmentName_BuildMode_Header())));
        HeaderName = BrowserInitHelper.getInstance().findElement(By.xpath(buildModePage.getAssessmentName_BuildMode_Header())).getAttribute("value").trim();

        System.out.println("HeaderName ==>" + HeaderName);
        if (HeaderName.contains(csvDataReaderBrowseModeCreateAssessmentModal.getassessment())) {
            ConsoleLogger.SuccessLog("Test cases : Passed - Assessment Name is validated in build mode header.....");
            LoggerUtility.LoggerCall("Test cases : Passed - Assessment Name is validated in build mode header.....");
        } else {
            ConsoleLogger.FailedTestCase("Test cases : Failed - Assessment Name is NOT validated in build mode header.....!!!");
            LoggerUtility.LoggerCall("Test cases : Failed - Assessment Name is NOT validated in build mode header.....!!!");
        }

    }

    // To select close
    public void close() {
        //Navigate to Browse Mode page --> To be handled in proper later when browse mode is integrated in application
        BrowserInitHelper.getInstance().navigate().back();
        BrowserInitHelper.getInstance().navigate().refresh();
    }

    // To validate build mode
    public void verifyBuildMode() {
        try {
            DriverHelper.awaitTillElementDisplayed(browseModePage.getBrowseMode_Items(), "Browse items");
            boolean check_BrowseModeNavigation = checkDisplay(browseModePage.getBrowseMode_Items());
            if (check_BrowseModeNavigation) {
                ConsoleLogger.SuccessLog("Test cases : Passed - Test cases : Passed - Browse Mode Page is displayed.....");
                LoggerUtility.LoggerCall("Test cases : Passed - Test cases : Passed - Browse Mode Page is displayed.....");
            } else {
                ConsoleLogger.FailedTestCase("Test cases : Failed - Browse Mode Page is NOT displayed.....!!!");
                LoggerUtility.LoggerCall("Test cases : Failed - Browse Mode Page is NOT displayed.....!!!");
            }
            Assert.assertTrue(check_BrowseModeNavigation);
        } catch (Exception e) {
            System.out.println("Exception handled for build mode");
        }
    }

    // To click remove item button
    public void clickRemoveItemButton() {
        if (checkAddItem) {
            try {
                List<WebElement> ItemsList_RemoveButton = BrowserInitHelper.getInstance().findElements(By.xpath(browseModePage.getBrowseRemoveItemList()));
                checkRemoveItem = true;
                size_RemoveItem = ItemsList_RemoveButton.size();

                for (int i = 0; i < size_RemoveItem; i++) {
                    //Remove ONE item
                    if (i <= 0) {
                        WebElement remove_item = ItemsList_RemoveButton.get(0);
                        System.out.println(size_RemoveItem);
                        //Click Remove Item
                        JavascriptHelper.clickWebElement_JS(remove_item);
                    }

                }
            } catch (Exception e) {
                logger.info("Exception handled for method - e_ClickRemoveItemButton...." + e);
            }
        }
    }

    // To create assessment button count after remove
    public void createAssessmentButtonCountAfterRemove() {
        if (checkRemoveItem) {
            BrowserInitHelper.getWaiter().until(ExpectedConditions.visibilityOfElementLocated(By.xpath(browseModePage.getBrowseCreateAssessmentCount())));
            WebElement check_RemoveCount = BrowserInitHelper.getInstance().findElement(By.xpath(browseModePage.getBrowseCreateAssessmentCount()));
            String Remove_count = check_RemoveCount.getText().trim();
            int remove_count = Integer.parseInt(Remove_count);
            if (remove_count == 1) {
                ConsoleLogger.SuccessLog("Test cases : Passed - Remove Count is Verified after removing items.....");
                LoggerUtility.LoggerCall("Test cases : Passed - Remove Count is Verified after removing items.....");
            } else {
                ConsoleLogger.FailedTestCase("Test cases : Failed - Remove Count is NOT Verified after removing items.....!!");
                LoggerUtility.LoggerCall("Test cases : Failed - Remove Count is NOT Verified after removing items.....!!");
            }
        }
//       }
    }

    // To make change in build mode
    public void makeChangesInBuildMode() {
        DriverHelper.awaitTillElementDisplayed(buildModePage.getBuildViewPage(), "Build Mode View Page");
        BrowserInitHelper.getWaiter().until(ExpectedConditions.elementToBeClickable(By.xpath(buildModePage.getBuildViewPage())));
        DriverHelper.awaitTillElementDisplayed(buildModePage.getItemHeader(), "Item Header");
        BrowserInitHelper.getWaiter().until(ExpectedConditions.elementToBeClickable(By.xpath(buildModePage.getItemHeader())));

        DriverHelper.awaitTillElementDisplayed(buildModePage.getBuildModeFirstItemCheckBox(), "CheckBoxes");
        DriverHelper.waitFluentByXPath(BrowserInitHelper.getInstance(), buildModePage.getBuildModeFirstItemCheckBox());
        BrowserInitHelper.getWaiter().until(ExpectedConditions.elementToBeClickable(By.xpath((buildModePage.getBuildModeFirstItemCheckBox())))).click();
        DriverHelper.awaitTillElementDisplayed(buildModePage.getBuildModeRemoveButton(), "Remove Item");
        BrowserInitHelper.getWaiter().until(ExpectedConditions.elementToBeClickable(By.xpath(buildModePage.getBuildModeRemoveButton()))).click();

        //for checking Autosave

        BrowserInitHelper.getWaiter().until(ExpectedConditions.visibilityOfElementLocated(By.xpath(buildModePage.getBuildSaveCheckMark())));
        boolean autosave = BrowserInitHelper.getWaiter().until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(buildModePage.getBuildSaveCheckMark())));
        if (autosave) {
            ConsoleLogger.SuccessLog("Test cases : Passed - AutoSave verified");
            LoggerUtility.LoggerCall("Test cases : Passed - AutoSave verified");
        } else {
            ConsoleLogger.FailedTestCase("Test cases : Failed - AutoSave verification un-successful");
            LoggerUtility.LoggerCall("Test cases : Failed - AutoSave verification un-successful");
        }

        //checking count number
        try {
            DriverHelper.awaitTillElementDisplayed(buildModePage.getBuildModeTotalItems(), "Total items");
            String count = BrowserInitHelper.getInstance().findElement(By.xpath(buildModePage.getBuildModeTotalItems())).getText().trim();
            int totalItems = Integer.parseInt(count);
            if (totalItems == 8) {
                ConsoleLogger.SuccessLog("Test cases : Passed - Changes made in Build Mode is successful---Total Items Now===>" + totalItems);
                LoggerUtility.LoggerCall("Test cases : Passed - Changes made in Build Mode is successful---Total Items Now===>" + totalItems);
            } else {
                System.out.println("Changes made in Build Mode is not successful");
            }
        } catch (Exception e) {
            System.out.println("Exception handled");
        }
    }


}

