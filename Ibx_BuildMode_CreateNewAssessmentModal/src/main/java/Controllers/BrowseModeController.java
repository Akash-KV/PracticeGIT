package Controllers;

import DataReaders.CSVDataReaderBrowseModeCreateAssessmentModal;
import Helpers.BrowserInitHelper;
import Helpers.DriverHelper;
import Helpers.JavascriptHelper;
import Pom.BrowseModePage;
import Pom.BuildModePage;
import Utils.ConsoleLogger;
import Utils.LoggerUtility;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

/**
 * Controller class for BrowseMode
 **/
public class BrowseModeController {
    private static final Logger logger = LoggerFactory.getLogger(BrowseModeController.class);
    private static final Logger log = LoggerFactory.getLogger(BrowserInitHelper.class);

    BuildModeController buildModeController = new BuildModeController();
    BrowseModePage browseModePage = new BrowseModePage();
    BuildModePage buildModePage = new BuildModePage();
    CSVDataReaderBrowseModeCreateAssessmentModal csvDataReaderBrowseModeCreateAssessmentModal = new CSVDataReaderBrowseModeCreateAssessmentModal();

    boolean checkAddItem = false;
    int size_AddItem;
    boolean check_build_View_Duplicate_AssessmentName = false;
    boolean check_build_View_Alpha_Numeric_Name = false;
    boolean checkMaxLimit = false;

    // To Validate Browse Mode page
    public void verifyBrowseModePage() {
        boolean navigationBrowse = false;
        try {
            //Verify Navigation to Browse Item Bank
            BrowserInitHelper.getWaiter().until(ExpectedConditions.elementToBeClickable(By.xpath(browseModePage.getFilters())));
            UnSelect_InitialFilterSelection("Standard");
            UnSelect_InitialFilterSelection("Bank");
            UnSelect_InitialFilterSelection("Item Type");

            DriverHelper.waitFluentByXPath(BrowserInitHelper.getInstance(), browseModePage.getBrowse_ItemSection());
            selectItemBank("My Items");
            //  DriverHelper.waitTill(3);
            try {
                DriverHelper.awaitTillElementDisplayed(browseModePage.getBrowse_ItemSection(), "Browse item section");
                DriverHelper.waitFluentByXPath(BrowserInitHelper.getInstance(), browseModePage.getBrowse_ItemSection());
            } catch (Exception e) {
                System.out.println("Exception handled for page load");
            }

            navigationBrowse = true;
        } catch (Exception e) {
            ConsoleLogger.FailedTestCase("Test cases : Failed - Navigation to Browse Mode is unsuccessful....");
            LoggerUtility.LoggerCall("Test cases : Failed - Navigation to Browse Mode is unsuccessful....");
        }
        Assert.assertTrue(navigationBrowse);
    }

    // To Un select initial filter
    public void UnSelect_InitialFilterSelection(String FilterName) {
        try {
            String label_input = null;

            Arrow_Up(FilterName);

            //Select First Checkbox
            List<WebElement> BankList_FirstItem = BrowserInitHelper.getInstance().findElements(By.xpath("//div[@class='x-filter-header-title__label' and contains(text(),'" + FilterName + "')]/parent::div/parent::div/following::div[1]//input/parent::div/following::label[1]"));

            //Before click, unselect all checkboxes
            List<WebElement> input_filter = BrowserInitHelper.getInstance().findElements(By.xpath("//div[@class='x-filter-header-title__label' and  contains(text(),'" + FilterName + "')]/parent::div/parent::div/following::div[1]//input[@type='checkbox']"));
            for (int j = 0; j < input_filter.size(); j++) {
                String checked = input_filter.get(j).getAttribute("aria-checked");
                label_input = BankList_FirstItem.get(j).getText().trim();
                String instructionName = label_input;
                label_input = "\"" + instructionName + "\"";
                String path = "//div[contains(text(),'" + FilterName + "')]/parent::div/parent::div/following::div[1]//input/parent::div/following::label[.=" + label_input + " ]";
              //  System.out.println("path is" + path);
                if (checked.contains("true")) {
                    //click it
                    JavascriptHelper.clickXpath_JS(path);
                }
            }
        } catch (Exception e) {
            System.out.println("Exception Handled for unSelecting filters");
        }

    }

    // To click Arrow Up
    public static void Arrow_Up(String FilterName) {
        try {
            WebElement header = BrowserInitHelper.getInstance().findElement(By.xpath("//div[@class='x-filter-group__content']/div//div[@class='x-filter-header-title__label' and text()='" + FilterName + "']"));
            Actions actions = new Actions(BrowserInitHelper.getInstance());
            actions.moveToElement(header).build().perform();
            DriverHelper.awaitTillElementDisplayed("//div[contains(text(),'\" + FilterName + \"')]/parent::div/parent::div//div[@class='x-filter-header-title__right']//*[local-name() = 'svg']", "Filter name");
            BrowserInitHelper.getWaiter().until(ExpectedConditions.elementToBeClickable(By.xpath("//div[contains(text(),'" + FilterName + "')]/parent::div/parent::div//div[@class='x-filter-header-title__right']//*[local-name() = 'svg']")));
            WebElement ArrowCheck = BrowserInitHelper.getInstance().findElement(By.xpath("//div[contains(text(),'" + FilterName + "')]/parent::div/parent::div//div[@class='x-filter-header-title__right']//*[local-name() = 'svg']"));
            String ArrowUpDownCheck = ArrowCheck.getAttribute("data-icon");
            if (ArrowUpDownCheck.contains("up")) {
                //Click Arrow
                ArrowCheck.click();
                System.out.println("Up Arrow is Clicked for the filter -> " + FilterName);
            } else {
                System.out.println("Up Arrow is not Clicked for the filter -> " + FilterName);
            }
        } catch (Exception e) {
            log.info("Exception handled for method - Arrow_Up");
        }
    }

    //Method to select ItemBank
    public void selectItemBank(String itemBank) {
        try {
            boolean checkInputBox = false;

            //Send value to Item Bank
            try {
                BrowserInitHelper.getWaiter().until(ExpectedConditions.elementToBeClickable(By.xpath(browseModePage.getBankFilterFirstCheckbox())));
                BrowserInitHelper.getInstance().findElement(By.xpath(browseModePage.getBankFilterFirstCheckbox())).sendKeys(itemBank);
                // Thread.sleep(4000);
                DriverHelper.awaitTillElementDisplayed("//label[.='" + itemBank + "']/preceding::input[1]", "check input box");
                checkInputBox = true;
            } catch (Exception e) {
                System.out.println("Exception handled for input box");
            }

            //Check checkbox is checked or not
            if (checkInputBox) {
                String checked = BrowserInitHelper.getInstance().findElement(By.xpath("//label[.='" + itemBank + "']/preceding::input[1]")).getAttribute("aria-checked").trim();

                //If checked - unSelect
                if (checked.contains("false")) {
                    BrowserInitHelper.getInstance().findElement(By.xpath("//div[@class='v-input__slot']//label[.='" + itemBank + "']")).click();
                }

                //Clear input box
                BrowserInitHelper.getInstance().findElement(By.xpath(browseModePage.getBankFilterFirstCheckbox())).sendKeys(Keys.chord(Keys.CONTROL, "a"));
                BrowserInitHelper.getInstance().findElement(By.xpath(browseModePage.getBankFilterFirstCheckbox())).sendKeys(Keys.BACK_SPACE);
                DriverHelper.awaitTillElementDisplayed(browseModePage.getBrowse_ItemSection(), "Browse item Section");

            } else {
                //Check checkbox is checked or not
                String checked = BrowserInitHelper.getInstance().findElement(By.xpath("//label[.='" + itemBank + "']/preceding::input[1]")).getAttribute("aria-checked").trim();

                //If unchecked - select
                if (checked.contains("false")) {
                    BrowserInitHelper.getInstance().findElement(By.xpath("//div[@class='v-input__slot']//label[.='" + itemBank + "']")).click();
                }
            }
            BrowserInitHelper.getWaiter().until(ExpectedConditions.elementToBeClickable(By.xpath(browseModePage.getBrowse_ItemSection())));
        } catch (Exception e) {
            System.out.println("Exception handled");
        }
    }

    // To click create assessment button
    public void clickCreateAssessmentButton() {
        try {
            BrowserInitHelper.getWaiter().until(ExpectedConditions.elementToBeClickable(By.xpath(browseModePage.getBrowseMode_Items())));
        } catch (TimeoutException te) {
            ConsoleLogger.DebugLog("Content Not displayed inside items........");
        }
        boolean check_createAssessmentbutton = buildModeController.checkDisplay(browseModePage.getCreateAssessmentButton());
        if (check_createAssessmentbutton) {
            ConsoleLogger.SuccessLog("Test cases : Passed - Create Assessment Button is Displayed");
            LoggerUtility.LoggerCall("Test cases : Passed - Create Assessment Button is Displayed");
        } else {
            ConsoleLogger.FailedTestCase("Test cases : Failed - Create Assessment Button is NOT displayed.....!!!");
            LoggerUtility.LoggerCall("Test cases : Failed - Create Assessment Button is NOT displayed.....!!!");
        }
        Assert.assertTrue(check_createAssessmentbutton);
        buildModeController.clickAddItems(2);
        DriverHelper.awaitTillElementDisplayed(browseModePage.getCreateAssessmentButton(), "Create assessment button");
        DriverHelper.clickXpath(browseModePage.getCreateAssessmentButton());
    }

    // To validate create assessment popup
    public void verifyCreateAssessmentPopUp() {
        buildModeController.checkDisplay(browseModePage.getOverlay());
        //for checking Create Assessment Popup
        boolean check_assessmentPopup = buildModeController.checkDisplay(browseModePage.getCreateAssessmentButtonPopup());
        if (check_assessmentPopup) {
            ConsoleLogger.SuccessLog("Test cases : Passed - Create Assessment Button Popup is displayed.....");
            LoggerUtility.LoggerCall("Test cases : Passed - Create Assessment Button Popup is displayed.....");
        } else {
            ConsoleLogger.FailedTestCase("Test cases : Failed - Create Assessment Button Popup is NOT displayed.....!!!");
            LoggerUtility.LoggerCall("Test cases : Failed - Create Assessment Button Popup is NOT displayed.....!!!");
        }
//        Assert.assertTrue(check_assessmentPopup);

        //for checking Create Assessment TextBox
        boolean check_assessmentNameTextBox = buildModeController.checkDisplay(browseModePage.getTitleInCreateAssessmentPopup());
        if (check_assessmentNameTextBox) {
            ConsoleLogger.SuccessLog("Test cases : Passed - Create Assessment Button textBox is displayed.....");
            LoggerUtility.LoggerCall("Test cases : Passed - Create Assessment Button textBox is displayed.....");
        } else {
            ConsoleLogger.FailedTestCase("Test cases : Failed - Create Assessment Button textBox is NOT displayed.....!!!");
            LoggerUtility.LoggerCall("Test cases : Failed - Create Assessment Button textBox is NOT displayed.....!!!");
        }
//        Assert.assertTrue(check_assessmentNameTextBox);

        //for checking Create Assessment button
        boolean check_assessmentCreateButton = buildModeController.checkDisplay(browseModePage.getCreateButton_CreateAssessmentPopup());
        if (check_assessmentCreateButton) {
            ConsoleLogger.SuccessLog("Test cases : Passed - Create Assessment Button create button is displayed.....");
            LoggerUtility.LoggerCall("Test cases : Passed - Create Assessment Button create button is displayed.....");
        } else {
            ConsoleLogger.FailedTestCase("Test cases : Failed - Create Assessment Button create button is NOT displayed.....!!!");
            LoggerUtility.LoggerCall("Test cases : Failed - Create Assessment Button create button is NOT displayed.....!!!");
        }
//        Assert.assertTrue(check_assessmentCreateButton);

        //for checking Cancel Assessment button
        boolean check_assessmentCancelButton = buildModeController.checkDisplay(browseModePage.getCancelButton_CreateAssessmentPopup());
        if (check_assessmentCancelButton) {
            ConsoleLogger.SuccessLog("Test cases : Passed - Create Assessment Button cancel button is displayed.....");
            LoggerUtility.LoggerCall("Test cases : Passed - Create Assessment Button cancel button is displayed.....");
        } else {
            ConsoleLogger.FailedTestCase("Test cases : Failed - Create Assessment Button cancel button is NOT displayed.....!!!");
            LoggerUtility.LoggerCall("Test cases : Failed - Create Assessment Button cancel button is NOT displayed.....!!!");
        }
//        Assert.assertTrue(check_assessmentCancelButton);

    }

    // To select create assessment
    public void clickCreateAssessment() {
        DriverHelper.clickXpath(browseModePage.getCreateAssessmentButton());
    }

    // To validate cancel button
    public void verifyCancelButton() {
        buildModeController.checkDisplay(browseModePage.getOverlay());
        boolean check_CancelButton = buildModeController.checkDisplay(browseModePage.getCancelButton_CreateAssessmentPopup());

        if (check_CancelButton) {
            ConsoleLogger.SuccessLog("Test cases : Passed - Cancel Button is displayed in Create Assessment Popup.....");
            LoggerUtility.LoggerCall("Test cases : Passed - Cancel Button is displayed in Create Assessment Popup.....");
        } else {
            ConsoleLogger.FailedTestCase("Test cases : Failed - Cancel Button is NOT displayed in Create Assessment Popup.....!!!");
            LoggerUtility.LoggerCall("Test cases : Failed - Cancel Button is NOT displayed in Create Assessment Popup.....!!!");
        }

        //Click on Cancel Button
        DriverHelper.clickXpath(browseModePage.getCancelButton_CreateAssessmentPopup());

        boolean check_BrowseModeNavigation = buildModeController.checkDisplay(browseModePage.getBrowseMode_Items());
        if (check_BrowseModeNavigation) {
            ConsoleLogger.SuccessLog("Test cases : Passed - Browse Mode Page is displayed after click of Cancel Button.....");
            LoggerUtility.LoggerCall("Test cases : Passed - Browse Mode Page is displayed after click of Cancel Button.....");
        } else {
            ConsoleLogger.FailedTestCase("Test cases : Failed - Browse Mode Page is NOT displayed after click of Cancel Button.....!!!");
            LoggerUtility.LoggerCall("Test cases : Failed - Browse Mode Page is NOT displayed after click of Cancel Button.....!!!");
        }
    }

    // To click add item button
    public void clickAddItemButton() {
        buildModeController.getAddItem(browseModePage.getBrowseAddItemList(), 2);
        try {
            List<WebElement> ItemsList_AddButton = BrowserInitHelper.getInstance().findElements(By.xpath(browseModePage.getBrowseAddItemList()));
            checkAddItem = true;

            size_AddItem = ItemsList_AddButton.size();
            for (int i = 0; i < size_AddItem; i++) {
                //Add two items
                if (i < 2) {
                    BrowserInitHelper.getWaiter().until(ExpectedConditions.elementToBeClickable(ItemsList_AddButton.get(i)));
                    WebElement add_item = ItemsList_AddButton.get(i);

                    //Click Add Item for n items
//                    add_item.click();
                    JavascriptHelper.clickWebElement_JS(add_item);
                }

            }
        } catch (Exception e) {
            logger.info("Exception handled for method - e_ClickAddItemButton...." + e);
        }
    }

    // To validate create assessment button after add
    public void verifyCreateAssessmentButtonCountAfterAdd() {
        if (checkAddItem) {
//            BrowserInitHelper.getWaiter().until(ExpectedConditions.visibilityOfElementLocated(By.xpath(browseModePage.getBrowseCreateAssessmentCount())));
            DriverHelper.awaitTillElementDisplayed(browseModePage.getBrowseCreateAssessmentCount(), "Assessment Count");
            WebElement check_AddCount = BrowserInitHelper.getInstance().findElement(By.xpath(browseModePage.getBrowseCreateAssessmentCount()));
            String add_Count = check_AddCount.getText().trim();
            int add_count = Integer.parseInt(add_Count);
            if (add_count == 2) {
                if (size_AddItem == 2) {
                    ConsoleLogger.SuccessLog("Test cases : Passed - Add Count is Verified after adding items.....2");
                    LoggerUtility.LoggerCall("Test cases : Passed - Add Count is Verified after adding items.....2");
                } else {
                    ConsoleLogger.FailedTestCase("Test cases : Failed - Add Count is NOT Verified after adding items.....!!");
                    LoggerUtility.LoggerCall("Test cases : Failed - Add Count is NOT Verified after adding items.....!!");
                }
            } else if (add_count == 1) {
                if (size_AddItem == 1) {
                    ConsoleLogger.SuccessLog("Test cases : Passed - Add Count is Verified after adding items.....1");
                    LoggerUtility.LoggerCall("Test cases : Passed - Add Count is Verified after adding items.....1");
                } else {
                    ConsoleLogger.FailedTestCase("Test cases : Failed - Add Count is NOT Verified after adding items.....!!");
                    LoggerUtility.LoggerCall("Test cases : Failed - Add Count is NOT Verified after adding items.....!!");
                }
            }
        }
    }

    // To add items
    public void AddItems() {
        DriverHelper.awaitTillElementDisplayed(browseModePage.getBrowseMode_Items(), "Browse Mode Items");
        JavascriptHelper.scrollIntoView(browseModePage.getBrowseFilterItemType());
        //  buildModeController.selectItemBank("Multiple Choice");
        try {
            //To add Items
            List<WebElement> ItemsList_AddButton = BrowserInitHelper.getInstance().findElements(By.xpath(browseModePage.getBrowseAddItemList()));
            checkAddItem = true;

            size_AddItem = ItemsList_AddButton.size();
            System.out.println(size_AddItem);
            for (int i = 0; i < size_AddItem; i++) {
                //Add two items
                if (i < 5) {
                    BrowserInitHelper.getWaiter().until(ExpectedConditions.elementToBeClickable(ItemsList_AddButton.get(i)));
                    WebElement add_item = ItemsList_AddButton.get(i);

                    //Click Add Item for n items
//                    add_item.click();
                    JavascriptHelper.clickWebElement_JS(add_item);
                }

            }
        } catch (Exception e) {
            logger.info("Exception handled for method - e_ClickAddItemButton....");
        }
    }

    // To validate no items found
    public void verifyNoItemsFound() {
        try {
            DriverHelper.waitFluentByXPath(BrowserInitHelper.getInstance(), browseModePage.getBrowse_ItemSection());
            DriverHelper.waitFluentByXPath(BrowserInitHelper.getInstance(), browseModePage.getBrowseModeFirstItem());
            if (BrowserInitHelper.getInstance().findElement(By.xpath(browseModePage.getBrowseModeFirstItem())).isDisplayed()) {
                ConsoleLogger.DebugLog("Items are present in My items bank");
                LoggerUtility.LoggerCall("Items are present in My items bank");
                Assert.assertTrue(true);
            }
        } catch (Exception e) {
            ConsoleLogger.ErrorLog("Items are not present in My items bank");
            LoggerUtility.LoggerCall("Items are not present in My items bank");
            Assert.assertTrue(false);
        }
    }

    // To validate add items
    public void verifyAddItems() {
        //Clicking Create Assessment Button
        DriverHelper.clickXpath(browseModePage.getCreateAssessmentButton());
        //Enter Assessment Name
        BrowserInitHelper.getWaiter().until(ExpectedConditions.elementToBeClickable(By.xpath(browseModePage.getTitleInCreateAssessmentPopup())));
        WebElement TitleInputBox = BrowserInitHelper.getInstance().findElement(By.xpath(browseModePage.getTitleInCreateAssessmentPopup()));
        String assessmentName = csvDataReaderBrowseModeCreateAssessmentModal.getassessment() + buildModeController.getCurrentTimeStamp();
        TitleInputBox.sendKeys(assessmentName);

        //Click on Create Button
        DriverHelper.clickXpath(browseModePage.getCreateButton_CreateAssessmentPopup());

        //Check display of Build mode page
        boolean check_buildView = buildModeController.checkDisplay(buildModePage.getBuildViewPage());
        if (check_buildView) {
            ConsoleLogger.SuccessLog("Test cases : Passed - Build View Page is displayed.....");
            LoggerUtility.LoggerCall("Test cases : Passed - Build View Page is displayed.....");
        } else {
            ConsoleLogger.FailedTestCase("Test cases : Failed - Build View Page is NOT displayed.....!!!");
            LoggerUtility.LoggerCall("Test cases : Failed - Build View Page is NOT displayed.....!!!");
        }
        Assert.assertTrue(check_buildView);
        //Check for added
        boolean check_Build_Mode_Navigation = buildModeController.checkDisplay(buildModePage.getItemHeader());
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

    }

    // To validate creation of duplicate assessment
    public void verifyCreationOfDuplicateAssessment() {
        //Now navigate back to Browse Page
        BrowserInitHelper.getInstance().navigate().back();
        BrowserInitHelper.getInstance().navigate().refresh();
        BrowserInitHelper.getWaiter().until(ExpectedConditions.elementToBeClickable(By.xpath(browseModePage.getBrowseMode_Items())));

        //Again click on Create Assessment Button and send same assessment name
        clickAddItemButton();
        DriverHelper.clickXpath(browseModePage.getCreateAssessmentButton());
        BrowserInitHelper.getWaiter().until(ExpectedConditions.elementToBeClickable(By.xpath(browseModePage.getTitleInCreateAssessmentPopup())));
        String current_Time_Stamp = buildModeController.getCurrentTimeStamp();
        String assessmentName = csvDataReaderBrowseModeCreateAssessmentModal.getassessment() + current_Time_Stamp;
        WebElement Title_InputBox = BrowserInitHelper.getInstance().findElement(By.xpath(browseModePage.getTitleInCreateAssessmentPopup()));
        Title_InputBox.sendKeys(assessmentName);

        //Click on Create Button
        DriverHelper.clickXpath(browseModePage.getCreateButton_CreateAssessmentPopup());
        check_build_View_Duplicate_AssessmentName = buildModeController.checkDisplay(buildModePage.getBuildViewPage());
        if (check_build_View_Duplicate_AssessmentName) {
            ConsoleLogger.SuccessLog("Test cases : Passed - Duplicate Assessment is created with existing assessment Name...");
            LoggerUtility.LoggerCall("Test cases : Passed - Duplicate Assessment is created with existing assessment Name...");
        } else {
            ConsoleLogger.FailedTestCase("Test cases : Failed - Duplicate Assessment is created with existing assessment Name...");
            LoggerUtility.LoggerCall("Test cases : Failed - Duplicate Assessment is created with existing assessment Name...");
        }
    }

    // To enter assessment name
    public void enterAssessmentName() {
        //Navigate Back and refresh to create new assessment
        BrowserInitHelper.getInstance().navigate().back();
        BrowserInitHelper.getInstance().navigate().refresh();
        BrowserInitHelper.getWaiter().until(ExpectedConditions.elementToBeClickable(By.xpath(browseModePage.getBrowseMode_Items())));

        e_ClickAddItemButton();
        DriverHelper.clickXpath(browseModePage.getCreateAssessmentButton());
        BrowserInitHelper.getWaiter().until(ExpectedConditions.elementToBeClickable(By.xpath(browseModePage.getTitleInCreateAssessmentPopup())));

        //Enter Assessment Name with More than 255 characters
        String assessmentName = buildModeController.randomString(256);

        //Again click on Create Assessment Button and send same assessment name
        WebElement TitleInputBox = BrowserInitHelper.getInstance().findElement(By.xpath(browseModePage.getTitleInCreateAssessmentPopup()));
        TitleInputBox.sendKeys(assessmentName);

        //Now get size of entered text in input box
        DriverHelper.awaitTillElementDisplayed(browseModePage.getTitleInCreateAssessmentPopup(), "Popup");
        WebElement TitleInputBox_AfterText = BrowserInitHelper.getInstance().findElement(By.xpath(browseModePage.getTitleInCreateAssessmentPopup()));
        System.out.println("Text _After_Input ==>" + TitleInputBox_AfterText.getAttribute("value"));
        int size_After_Input = TitleInputBox_AfterText.getAttribute("value").length();

        try {
            System.out.println("Warning msg locator" + browseModePage.getWarningCharacterLimitMessage());
            BrowserInitHelper.getWaiter().until(ExpectedConditions.visibilityOfElementLocated(By.xpath(browseModePage.getWarningCharacterLimitMessage())));
            if (BrowserInitHelper.getWaiter().until(ExpectedConditions.visibilityOfElementLocated(By.xpath(browseModePage.getWarningCharacterLimitMessage()))).isDisplayed()) {
                ConsoleLogger.SuccessLog("Test cases : Passed - Title must be less than 255 characters is displayed.....");
                LoggerUtility.LoggerCall("Test cases : Passed - Title must be less than 255 characters is displayed.....");
            }
            checkMaxLimit = true;
        } catch (Exception e) {
            ConsoleLogger.FailedTestCase("Test cases : Failed - Title must be less than 255 characters is NOT displayed.....");
            LoggerUtility.LoggerCall("Test cases : Failed - Title must be less than 255 characters is NOT displayed.....");
        }

        DriverHelper.clickXpath(browseModePage.getCancelButton_CreateAssessmentPopup());
        BrowserInitHelper.getInstance().navigate().refresh();

        System.out.println("size_After_Input ==>" + size_After_Input);
    }

    // To click add item button
    public void e_ClickAddItemButton() {
        clickAddItemButton();
    }

    // To validate creation with more items
    public void verifyCreationWithMoreItems() {
        //Verify when - Enter More than 255 characters
        if (checkMaxLimit) {
            ConsoleLogger.SuccessLog("Test cases : Passed - Assessment is NOT created with more than 255 characters in assessment name...");
            LoggerUtility.LoggerCall("Test cases : Passed - Assessment is NOT created with more than 255 characters in assessment name...");
        } else {
            ConsoleLogger.FailedTestCase("Test cases : Failed - Assessment is created with 255 characters in assessment Name...");
            LoggerUtility.LoggerCall("Test cases : Failed - Assessment is created with 255 characters in assessment Name...");
        }
    }

    // To enter alphanumeric name
    public void enterAlphaNumericName() {
        //Enter Alpha Numeric Assessment Name
        BrowserInitHelper.getWaiter().until(ExpectedConditions.elementToBeClickable(By.xpath(browseModePage.getBrowseMode_Items())));

        e_ClickAddItemButton();
        DriverHelper.clickXpath(browseModePage.getCreateAssessmentButton());
        BrowserInitHelper.getWaiter().until(ExpectedConditions.elementToBeClickable(By.xpath(browseModePage.getTitleInCreateAssessmentPopup())));
        WebElement TitleInputBox = BrowserInitHelper.getInstance().findElement(By.xpath(browseModePage.getTitleInCreateAssessmentPopup()));
        TitleInputBox.sendKeys(csvDataReaderBrowseModeCreateAssessmentModal.getAssessmentAlphaNumericName());

        DriverHelper.awaitTillElementDisplayed(browseModePage.getCreateButton_CreateAssessmentPopup(), "Create Assessment PopUp");
        DriverHelper.clickXpath(browseModePage.getCreateButton_CreateAssessmentPopup());

        //  DriverHelper.awaitTillElementDisplayed(browseModePage.getBuild_Item_Section(), "Build Mode Item Section");
        boolean check_Build_Mode_Navigation = buildModeController.checkDisplay(buildModePage.getBuild_Item_Section());
        if (check_Build_Mode_Navigation) {
            ConsoleLogger.SuccessLog("Test cases : Passed - Build Mode Page is displayed.....");
            LoggerUtility.LoggerCall("Test cases : Passed - Build Mode Page is displayed.....");
            try {
                DriverHelper.awaitTillElementDisplayed(buildModePage.getBuild_First_Item_Content(), "First Item");
                buildModeController.checkDisplay(buildModePage.getBuild_First_Item_Content());
            } catch (Exception e) {
                System.out.println("Exception handled for first item");
            }
        } else {
            ConsoleLogger.FailedTestCase("Test cases : Failed - Build Mode Page is NOT displayed.....!!");
            LoggerUtility.LoggerCall("Test cases : Failed - Build Mode Page is NOT displayed.....!!");
        }

        DriverHelper.awaitTillElementDisplayed(buildModePage.getBuildViewPage(), "BuildViewPage");
        check_build_View_Alpha_Numeric_Name = buildModeController.checkDisplay(buildModePage.getBuildViewPage());
    }

    // To validate creation with alphanumeric
    public void verifyCreationWithAlphanumeric() {
        //Verify Alpha Numeric Assessment
        if (check_build_View_Alpha_Numeric_Name) {
            ConsoleLogger.SuccessLog("Test cases : Passed - Assessment with Alpha Numeric Assessment Name is created and Build View Page is displayed.....");
            LoggerUtility.LoggerCall("Test cases : Passed - Assessment with Alpha Numeric Assessment Name is created and Build View Page is displayed.....");
        } else {
            ConsoleLogger.FailedTestCase("Test cases : Failed - Assessment with Alpha Numeric Assessment Name is NOT created and Build View Page is NOT displayed..........!!!");
            LoggerUtility.LoggerCall("Test cases : Failed - Assessment with Alpha Numeric Assessment Name is NOT created and Build View Page is NOT displayed..........!!!");
        }
    }
}
