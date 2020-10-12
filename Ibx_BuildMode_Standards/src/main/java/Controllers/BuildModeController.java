package Controllers;

import DataReaders.CSVDataReaderBuildModeStandards;
import Helpers.BrowserInitHelper;
import Helpers.DriverHelper;
import Helpers.JavascriptHelper;
import Pom.BrowseModePage;
import Pom.BuildModePage;
import Utils.ConsoleLogger;
import Utils.LoggerUtility;
import org.assertj.core.api.SoftAssertions;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import static org.reflections.Reflections.log;

/**
 * Controller class for BuildMode
 **/
public class BuildModeController {

    //Logger and WebDrivers
    private static final Logger logger = LoggerFactory.getLogger(BuildModeController.class);
    private static final Logger log = LoggerFactory.getLogger(BrowserInitHelper.class);

    public int standard_modal_count, browse_standard_count, create_item_standard_count, base_standard_count, base_standard_checkbox_count, added_check_tick;
    BrowseModePage browseModePage = new BrowseModePage();
    BuildModePage buildModePage = new BuildModePage();
    public CSVDataReaderBuildModeStandards csvDataReaderBuildModeStandards = new CSVDataReaderBuildModeStandards();
    public String standardValueToSearch = "";
    private SoftAssertions softAssertions;


    //Check Element is displayed
    public boolean checkDisplay(String xpath) {
        boolean value = false;
        try {
            BrowserInitHelper.getWaiter().until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
            WebElement element = BrowserInitHelper.getInstance().findElement(By.xpath(xpath));
            if (element.isDisplayed()) {
                value = true;
            }
        } catch (Exception e) {
            System.out.println("Exception handled for Display");
        }
        return value;
    }

    // To select edit icon
    public void selectEditIcon() {
        addMore(buildModePage.getBuild_Mode_Standard_Plus());
        boolean icon = DriverHelper.checkElementDisplayByXpath(buildModePage.getBuild_Mode_Edit_Icon(), "Edit Icon");
        Assert.assertTrue(icon);
        DriverHelper.clickXpath(buildModePage.getBuild_Mode_Edit_Icon());
    }

    // To validate standard selector Modal
    public void verifyStandardSelectorModal() {
        boolean element = DriverHelper.checkElementDisplayByXpath(buildModePage.getBuild_Mode_Standard_Modal_Header(), "Standard Modal");
        Assert.assertTrue(element);
        DriverHelper.waitFluentByXPath(BrowserInitHelper.getInstance(), buildModePage.getBuild_Mode_Standard_Modal_Close());
        DriverHelper.clickXpath(buildModePage.getBuild_Mode_Standard_Modal_Close());
    }

    //  To check information icon
    public void checkInformationIcon() {
        DriverHelper.waitFluentByXPath(BrowserInitHelper.getInstance(), buildModePage.getBuild_Mode_Browse_Button());
        DriverHelper.clickXpath(buildModePage.getBuild_Mode_Browse_Button());

        DriverHelper.waitFluentByXPath(BrowserInitHelper.getInstance(), browseModePage.getBrowse_First_Item_Standards_Chip());
        DriverHelper.clickXpath(browseModePage.getBrowse_First_Item_Standards_Chip());
    }

    // To validate information icon
    public void verifyInformationIcon() {
        DriverHelper.waitFluentByXPath(BrowserInitHelper.getInstance(), buildModePage.getBuild_Info_Icon());
        verifyHover(buildModePage.getBuild_Mode_Icon_Hover(), "Build Mode");
        DriverHelper.waitFluentByXPath(BrowserInitHelper.getInstance(), buildModePage.getBuild_Mode_Build_Button());
        DriverHelper.clickXpath(buildModePage.getBuild_Mode_Build_Button());
    }

    // To select standards from modal
    public void selectStandardsFromModal() {
        addMore(buildModePage.getBuild_Mode_Standard_Chip());
        DriverHelper.waitFluentByXPath(BrowserInitHelper.getInstance(), buildModePage.getBuild_Mode_Edit_Icon());
        DriverHelper.clickXpath(buildModePage.getBuild_Mode_Edit_Icon());

        select_FirstValueFromAllFilters();
        try {
            DriverHelper.awaitTillElementDisplayed(buildModePage.getBuildModeFirstStandardsInModal(), "First Standard");
        } catch (Exception e) {
            System.out.println("Exception handled for Standard");
        }
        List<WebElement> lsStandards = BrowserInitHelper.getInstance().findElements(By.xpath("//div[@id='standardsApp']//div[contains(@class,'v-card__title standard-item-title')]"));
        List<WebElement> lsStandardsCheckboxes = BrowserInitHelper.getInstance().findElements(By.xpath("(//div[@class='standards-list-group-items'])[1]/div//div[contains(@class, 'select-check')]/*[name()='svg']"));

        for (int i = 0; i < lsStandards.size() / 2; i++) {
            String value = lsStandards.get(i).getText();
            if (!(standardValueToSearch.contains(value))) {
                BrowserInitHelper.getWaiter().until(ExpectedConditions.elementToBeClickable(lsStandardsCheckboxes.get(i)));
                if (!lsStandardsCheckboxes.get(i).getAttribute("data-icon").equalsIgnoreCase("check-circle")) {
                    JavascriptHelper.scrollElementIntoView(lsStandards.get(i));
                    lsStandardsCheckboxes = BrowserInitHelper.getInstance().findElements(By.xpath("(//div[@class='standards-list-group-items'])[1]/div//div[contains(@class, 'select-check')]/*[name()='svg']"));
                    /*Select the Standard*/
                    lsStandardsCheckboxes.get(i).click();
                }
            }
        }

        try {
            DriverHelper.waitFluentByXPath(BrowserInitHelper.getInstance(), buildModePage.getBuild_Mode_Selected_Standard());
            WebElement standardToSearch = BrowserInitHelper.getInstance().findElement(By.xpath(buildModePage.getBuild_Mode_Selected_Standard()));
            standardValueToSearch = standardToSearch.getText();

            this.standard_modal_count = standardCount(standard_modal_count, buildModePage.getBuild_Mode_Standard_Modal_List());

            DriverHelper.waitFluentByXPath(BrowserInitHelper.getInstance(), buildModePage.getBuild_Mode_Standard_Modal_Done());
            WebElement DoneButton = BrowserInitHelper.getInstance().findElement(By.xpath(buildModePage.getBuild_Mode_Standard_Modal_Done()));
            DoneButton.click();
        } catch (Exception e) {
            System.out.println("Exception handled");
        }
    }

    // To validate selected standards
    public void verifySelectedStandards() {
        BrowserInitHelper.getWaiter().until(ExpectedConditions.elementToBeClickable(By.xpath(buildModePage.getBuild_Mode_Browse_Button())));
        DriverHelper.clickXpath(buildModePage.getBuild_Mode_Browse_Button());

        /*Clear the Standard Search textBox*/
        DriverHelper.waitFluentByXPath(BrowserInitHelper.getInstance(), buildModePage.getBuild_Mode_Standard_Text_Box());
        BrowserInitHelper.getWaiter().until(ExpectedConditions.elementToBeClickable(By.xpath(buildModePage.getBuild_Mode_Standard_Text_Box()))).sendKeys(Keys.CONTROL + "a");
        BrowserInitHelper.getWaiter().until(ExpectedConditions.elementToBeClickable(By.xpath(buildModePage.getBuild_Mode_Standard_Text_Box()))).sendKeys(Keys.DELETE);

        // Again uncheck Standard
        DriverHelper.clickXpath("//label[.='" + standardValueToSearch + "']");

        DriverHelper.waitFluentByXPath(BrowserInitHelper.getInstance(), buildModePage.getBuild_Mode_Show_More());
        DriverHelper.clickXpath(buildModePage.getBuild_Mode_Show_More());

        this.browse_standard_count = standardCount(browse_standard_count, buildModePage.getBuild_Mode_Standard_List());
        verifyCount(standard_modal_count, browse_standard_count);
    }

    // To select standards from create item
    public void selectStandardsFromCreateItem() {
        DriverHelper.waitFluentByXPath(BrowserInitHelper.getInstance(), buildModePage.getBuild_Mode_Build_Button());
        DriverHelper.clickXpath(buildModePage.getBuild_Mode_Build_Button());
        createItemStandard();

        select_FirstValueFromAllFilters();
        try {
            DriverHelper.awaitTillElementDisplayed(buildModePage.getBuildModeFirstStandardsInModal(), "First Standard");
        } catch (Exception e) {
            System.out.println("Exception handled for First standard");
        }
        List<WebElement> lsStandards = BrowserInitHelper.getInstance().findElements(By.xpath("//div[@id='standardsApp']//div[contains(@class,'v-card__title standard-item-title')]"));
        List<WebElement> lsStandardsCheckboxes = BrowserInitHelper.getInstance().findElements(By.xpath("(//div[@class='standards-list-group-items'])[1]/div//div[contains(@class, 'select-check')]/*[name()='svg']"));

        standardValueToSearch = "";
        for (int i = 0; i < lsStandards.size() / 2; i++) {
            String value = lsStandards.get(i).getText();
            if (!(standardValueToSearch.contains(value))) {
                BrowserInitHelper.getWaiter().until(ExpectedConditions.elementToBeClickable(lsStandardsCheckboxes.get(i)));
                if (!lsStandardsCheckboxes.get(i).getAttribute("data-icon").equalsIgnoreCase("check-circle")) {
                    JavascriptHelper.scrollElementIntoView(lsStandards.get(i));
                    lsStandardsCheckboxes = BrowserInitHelper.getInstance().findElements(By.xpath("(//div[@class='standards-list-group-items'])[1]/div//div[contains(@class, 'select-check')]/*[name()='svg']"));
                    /*Select the Standard*/
                    lsStandardsCheckboxes.get(i).click();
                }
            }
        }

        try {
            DriverHelper.waitFluentByXPath(BrowserInitHelper.getInstance(), buildModePage.getBuild_Mode_Selected_Standard());
            WebElement standardToSearch = BrowserInitHelper.getInstance().findElement(By.xpath(buildModePage.getBuild_Mode_Selected_Standard()));
            standardValueToSearch = standardToSearch.getText();

            this.create_item_standard_count = standardCount(create_item_standard_count, buildModePage.getBuild_Mode_Standard_Modal_List());
        } catch (Exception e) {
            System.out.println("Exception handled");
        }
        try {
            DriverHelper.waitFluentByXPath(BrowserInitHelper.getInstance(), buildModePage.getBuild_Mode_Standard_Modal_Close());
            DriverHelper.clickXpath(buildModePage.getBuild_Mode_Standard_Modal_Close());
            BrowserInitHelper.getWaiter().until(ExpectedConditions.elementToBeClickable(By.xpath(buildModePage.getBuild_Mode_Create_Item_Close())));
            DriverHelper.waitFluentByXPath(BrowserInitHelper.getInstance(), buildModePage.getBuild_Mode_Create_Item_Close());
            DriverHelper.clickXpath(buildModePage.getBuild_Mode_Create_Item_Close());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // To validate newly added standards
    public void verifyNewlyAddedStandards() {
        addMore(buildModePage.getBuild_Mode_Standard_Plus());
        this.base_standard_count = standardCount(base_standard_count, buildModePage.getBuild_Mode_Base_Standard_List());
        verifyCount(create_item_standard_count, base_standard_count);
        DriverHelper.waitFluentByXPath(BrowserInitHelper.getInstance(), buildModePage.getBuild_Mode_Build_Button());
        DriverHelper.clickXpath(buildModePage.getBuild_Mode_Build_Button());
    }

    // To uncheck Standard
    public void uncheckStandard() {
        addMore(buildModePage.getBuild_Mode_Standard_Chip());
        List<WebElement> standards_AddStandardList = BrowserInitHelper.getInstance().findElements(By.xpath("//div[@class='build-stds-add__item']//input"));
        List<WebElement> list = BrowserInitHelper.getInstance().findElements(By.xpath("//div[@class='build-stds-add__item']//label[contains(@class,'v-label')]"));

        for (int i = 0; i < standards_AddStandardList.size(); i++) {
            //Click First Value and check green Tick mark and count

            String check_GreenTick = standards_AddStandardList.get(i).getAttribute("aria-checked");
            System.out.println("checkGreenTick ==> " + check_GreenTick);

            if (check_GreenTick.equalsIgnoreCase("true")) {
                ConsoleLogger.SuccessLog("Test cases : Passed - Green Tick is shown on click of Standard inside Add Standard List.....");
                LoggerUtility.LoggerCall("Test cases : Passed - Green Tick is shown on click of Standard inside Add Standard List.....");

                //Uncheck it
                list.get(i).click();
            } else {
                ConsoleLogger.FailedTestCase("Test cases : Failed - Green Tick is NOT shown on click of Standard inside Add Standard List.....");
                LoggerUtility.LoggerCall("Test cases : Failed - Green Tick is NOT shown on click of Standard inside Add Standard List.....");

            }
            break;
        }
        DriverHelper.waitFluentByXPath(BrowserInitHelper.getInstance(), buildModePage.getBuild_Mode_Back_Chevron_Button());
        DriverHelper.clickXpath(buildModePage.getBuild_Mode_Back_Chevron_Button());
    }

    // To validate unchecked standards
    public void verifyUncheckedStandards() {
        try {
            //Verify Count
            DriverHelper.waitFluentByXPath(BrowserInitHelper.getInstance(), buildModePage.getBuild_Mode_Green_Tick());
            WebElement count_Remove_Initial = BrowserInitHelper.getInstance().findElement(By.xpath(buildModePage.getBuild_Mode_Green_Tick()));
            if (count_Remove_Initial.isDisplayed()) {
                ConsoleLogger.FailedTestCase("Test cases : Failed - Count is still shown after removal of Standard from List.....");
                LoggerUtility.LoggerCall("Test cases : Failed - Count is still shown after removal of Standard from List.....");

            }
        } catch (Exception e) {
            ConsoleLogger.SuccessLog("Test cases : Passed - Count is NOT shown after removal of Standard from List.....");
            LoggerUtility.LoggerCall("Test cases : Passed - Count is NOT shown after removal of Standard from List.....");
        }
        DriverHelper.waitFluentByXPath(BrowserInitHelper.getInstance(), buildModePage.getBuildModeStandardsHeader());
        DriverHelper.waitFluentByXPath(BrowserInitHelper.getInstance(), buildModePage.getBuild_Mode_Aligned_Standard());
        DriverHelper.clickXpath(buildModePage.getBuild_Mode_Aligned_Standard());
    }

    // To check hover message on standards
    public void checkHoverMessageOnStandards() {
        DriverHelper.waitFluentByXPath(BrowserInitHelper.getInstance(), buildModePage.getBuild_Mode_Build_Button());
        DriverHelper.clickXpath(buildModePage.getBuild_Mode_Build_Button());
        addMore(buildModePage.getBuild_Mode_Standard_Plus());
    }

    // To validate hover message on standards
    public void verifyHoverMessageOnStandards() {
        verifyHover(buildModePage.getBuild_Mode_Standard_Hover(), "Base standard list");
        DriverHelper.waitFluentByXPath(BrowserInitHelper.getInstance(), buildModePage.getBuild_Mode_Build_Button());
        DriverHelper.clickXpath(buildModePage.getBuild_Mode_Build_Button());
    }

    // To select base standard
    public void selectBaseStandard() {
        addMore(buildModePage.getBuild_Mode_Standard_Chip());

        DriverHelper.waitFluentByXPath(BrowserInitHelper.getInstance(), buildModePage.getBuild_Mode_Base_Standard_Select());
        DriverHelper.clickXpath(buildModePage.getBuild_Mode_Base_Standard_Select());

        List<WebElement> standards_AddStandardList = BrowserInitHelper.getInstance().findElements(By.xpath("//div[@class='build-stds-add__item']//input"));

        for (int i = 0; i < standards_AddStandardList.size(); i++) {
            //Click First Value and check green Tick mark and count

            String check_GreenTick = standards_AddStandardList.get(i).getAttribute("aria-checked");
            if (check_GreenTick.equalsIgnoreCase("true")) {
                base_standard_checkbox_count++;
            }
        }
        System.out.println(base_standard_checkbox_count);

        DriverHelper.waitFluentByXPath(BrowserInitHelper.getInstance(), buildModePage.getBuild_Mode_Back_Chevron_Button());
        DriverHelper.clickXpath(buildModePage.getBuild_Mode_Back_Chevron_Button());
    }

    // To validate selected base standards list
    public void verifySelectedBaseStandardList() {
        this.added_check_tick = standardCount(added_check_tick, buildModePage.getBuild_Mode_Green_Tick());
        verifyCount(base_standard_checkbox_count, added_check_tick);
        DriverHelper.waitFluentByXPath(BrowserInitHelper.getInstance(), buildModePage.getBuild_Mode_New_Aligned_Standard());
        DriverHelper.clickXpath(buildModePage.getBuild_Mode_New_Aligned_Standard());
    }

    // To remove aligned standard
    public void removeAlignedStandard() {
        DriverHelper.waitFluentByXPath(BrowserInitHelper.getInstance(), buildModePage.getBuild_Mode_Build_Button());
        DriverHelper.clickXpath(buildModePage.getBuild_Mode_Build_Button());
        DriverHelper.waitFluentByXPath(BrowserInitHelper.getInstance(), buildModePage.getBuild_Mode_Standard_Chip());
        DriverHelper.clickXpath(buildModePage.getBuild_Mode_Standard_Chip());
        DriverHelper.waitFluentByXPath(BrowserInitHelper.getInstance(), buildModePage.getBuild_Mode_Aligned_Standard());
        DriverHelper.clickXpath(buildModePage.getBuild_Mode_Aligned_Standard());

        DriverHelper.waitFluentByXPath(BrowserInitHelper.getInstance(), buildModePage.getBuildModeStandardsHeader());
        BrowserInitHelper.getInstance().findElement(By.xpath(buildModePage.getBuildModeStandardsHeader())).click();

        JavascriptHelper.scrollBottomOfThePage();
        DriverHelper.waitFluentByXPath(BrowserInitHelper.getInstance(), buildModePage.getBuild_Mode_Add_More());
        DriverHelper.clickXpath(buildModePage.getBuild_Mode_Add_More());

        DriverHelper.waitFluentByXPath(BrowserInitHelper.getInstance(), buildModePage.getBuildModeBaseStandardsHeader());
        BrowserInitHelper.getInstance().findElement(By.xpath(buildModePage.getBuildModeBaseStandardsHeader())).click();
    }

    // To validate base standard list for not aligned
    public void verifyBaseStandardListForNotAligned() {
        boolean value = false;
        List<WebElement> standards_AddStandardList = BrowserInitHelper.getInstance().findElements(By.xpath("//div[@class='build-stds-add__item']//input"));

        for (int i = 0; i < standards_AddStandardList.size(); i++) {
            //Click First Value and check green Tick mark and count

            String check_GreenTick = standards_AddStandardList.get(i).getAttribute("aria-checked");
            if (check_GreenTick.equalsIgnoreCase("true")) {
            } else {
                value = true;
            }
        }
        if (value) {
            ConsoleLogger.SuccessLog("Test cases : Passed - Removed align is not displaying");
            LoggerUtility.LoggerCall("Test cases : Passed - Removed align is not displaying");
            Assert.assertTrue(value);
        } else {
            ConsoleLogger.FailedTestCase("Test cases : Failed - Removed align is displaying");
            LoggerUtility.LoggerCall("Test cases : Failed - Removed align is displaying");
            Assert.assertTrue(value);
        }
        DriverHelper.waitFluentByXPath(BrowserInitHelper.getInstance(), buildModePage.getBuild_Mode_Back_Chevron_Button());
        DriverHelper.clickXpath(buildModePage.getBuild_Mode_Back_Chevron_Button());
    }

    // To reselect aligned standard
    public void reselectAlignedStandard() {
        try {
            DriverHelper.waitFluentByXPath(BrowserInitHelper.getInstance(), buildModePage.getBuildModeStandardsHeader());
            BrowserInitHelper.getInstance().findElement(By.xpath(buildModePage.getBuildModeStandardsHeader())).click();

            DriverHelper.waitFluentByXPath(BrowserInitHelper.getInstance(), buildModePage.getBuild_Mode_Aligned_Standard());
            DriverHelper.clickXpath(buildModePage.getBuild_Mode_Aligned_Standard());

            DriverHelper.waitFluentByXPath(BrowserInitHelper.getInstance(), buildModePage.getBuildModeStandardsHeader());
            BrowserInitHelper.getInstance().findElement(By.xpath(buildModePage.getBuildModeStandardsHeader())).click();

            JavascriptHelper.scrollBottomOfThePage();
            BrowserInitHelper.getWaiter().until(ExpectedConditions.elementToBeClickable(By.xpath(buildModePage.getBuild_Mode_Add_More())));
            DriverHelper.clickXpath(buildModePage.getBuild_Mode_Add_More());

            DriverHelper.waitFluentByXPath(BrowserInitHelper.getInstance(), buildModePage.getBuildModeBaseStandardsHeader());
            BrowserInitHelper.getInstance().findElement(By.xpath(buildModePage.getBuildModeBaseStandardsHeader())).click();
        } catch (Exception e) {
            System.out.println("Exception handled");
        }
    }

    // To validate base standard list for aligned
    public void verifyBaseStandardListForAligned() {
        List<WebElement> standards_AddStandardList = BrowserInitHelper.getInstance().findElements(By.xpath("//div[@class='build-stds-add__item']//input"));

        for (int i = 0; i < standards_AddStandardList.size(); i++) {
            String check_GreenTick = standards_AddStandardList.get(i).getAttribute("aria-checked");
            if (check_GreenTick.equalsIgnoreCase("true")) {
                ConsoleLogger.SuccessLog("Test cases : Passed - Reselected align is displaying");
                LoggerUtility.LoggerCall("Test cases : Passed - Reselected align is displaying");
                Assert.assertTrue(true);
                break;
            }
        }
        DriverHelper.waitFluentByXPath(BrowserInitHelper.getInstance(), buildModePage.getBuild_Mode_Back_Chevron_Button());
        DriverHelper.clickXpath(buildModePage.getBuild_Mode_Back_Chevron_Button());
    }

    // To check full standard name
    public void checkFullStandardName() {
        try {
            DriverHelper.waitFluentByXPath(BrowserInitHelper.getInstance(), buildModePage.getBuild_Mode_Build_Button());
            DriverHelper.clickXpath(buildModePage.getBuild_Mode_Build_Button());
            DriverHelper.waitFluentByXPath(BrowserInitHelper.getInstance(), buildModePage.getBuild_Mode_Standard_Chip());
            DriverHelper.clickXpath(buildModePage.getBuild_Mode_Standard_Chip());
        } catch (Exception e) {
            System.out.println("Exception handled...");
        }
    }

    // To validate full standard name
    public void verifyFullStandardName() {
        try {
            softAssertions = new SoftAssertions();
            WebElement element = BrowserInitHelper.getInstance().findElement(By.xpath(buildModePage.getBuild_Mode_Aligned_Standard()));
            System.out.println(standardValueToSearch);
            String text = element.getText();
            if (text.equalsIgnoreCase(standardValueToSearch)) {
                ConsoleLogger.SuccessLog("Test cases : Passed - Full Standard name is present");
                LoggerUtility.LoggerCall("Test cases : Passed - Full Standard name is present");
                softAssertions.assertThat(true);
            } else {
                ConsoleLogger.FailedTestCase("Test cases : Failed - Full standard name is not present");
                LoggerUtility.LoggerCall("Test cases : Failed -  Full standard name is not present");
                softAssertions.assertThat(false);
            }
        } catch (Exception e) {
            System.out.println("Exception handled for full standard name");
        }
    }

    //Get Current Time Stamp
    public String getCurrentTimeStamp() {
        String timestamp = "";

        DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
        Date date = new Date();
        timestamp = dateFormat.format(date);
        System.out.println(dateFormat.format(date));

        return timestamp;
    }

    // To click Show More Standards
    public boolean clickShowMoreStandards() {
        boolean value = false;
        try {
            DriverHelper.clickXpath(browseModePage.getShow_More_Standards_link());
            BrowserInitHelper.getWaiter().until(ExpectedConditions.visibilityOfElementLocated(By.xpath(browseModePage.getShow_More_Standards_Popup_Overlay())));
            BrowserInitHelper.getWaiter().until(ExpectedConditions.elementToBeClickable(By.xpath(browseModePage.getStandards_Selector_Header())));
            value = true;
        } catch (Exception e) {
            log.info("Exception handled for Show More Standards.....");
        }
        return value;
    }

    // To select First value from all filters
    public boolean select_FirstValueFromAllFilters() {
        boolean selected = false;

        try {
            try {
                DriverHelper.waitFluentByXPath(BrowserInitHelper.getInstance(), buildModePage.getBuild_Standards_MyStandards());
                DriverHelper.waitFluentByXPath(BrowserInitHelper.getInstance(), buildModePage.getBuildModeSelectedStandardsHeader());
                List<WebElement> ele = BrowserInitHelper.getInstance().findElements(By.xpath("//div[@class='container selected-container fluid']//*[local-name()='svg']"));
                for (WebElement standards : ele) {
                    standards.click();
                }
            } catch (Exception e) {
                System.out.println("Exception handled for removing already selected standards");
            }

            /*Click on My Standards header*/
            DriverHelper.waitUntil(buildModePage.getBuild_Standards_MyStandards());
            BrowserInitHelper.getInstance().findElement(By.xpath(buildModePage.getBuild_Standards_MyStandards())).click();

            /*Click on Providers drop down*/
            DriverHelper.clickXpath(buildModePage.getBuild_Standard_Providers());
            DriverHelper.waitFluentByXPath(BrowserInitHelper.getInstance(), buildModePage.getBuild_Standard_Clear());
            JavascriptHelper.scrollElementIntoView(BrowserInitHelper.getInstance().findElement(By.xpath(buildModePage.getBuild_Standard_Clear())));
            DriverHelper.waitFluentByXPath(BrowserInitHelper.getInstance(), buildModePage.getBuild_Standard_Clear());
            DriverHelper.clickXpath(buildModePage.getBuild_Standard_Clear());

            // To click common core standard
            try {
                DriverHelper.waitFluentByXPath(BrowserInitHelper.getInstance(), buildModePage.getBuild_Common_Core_Standard());
                JavascriptHelper.scrollElementIntoView(BrowserInitHelper.getInstance().findElement(By.xpath(buildModePage.getBuild_Common_Core_Standard())));
                DriverHelper.clickXpath(buildModePage.getBuild_Common_Core_Standard());
            } catch (Exception e) {
                DriverHelper.waitFluentByXPath(BrowserInitHelper.getInstance(), buildModePage.getBuild_Common_Core_Standard());
                JavascriptHelper.scrollElementIntoView(BrowserInitHelper.getInstance().findElement(By.xpath(buildModePage.getBuild_Common_Core_Standard())));
                DriverHelper.clickXpath(buildModePage.getBuild_Common_Core_Standard());
            }

            /*Click on Selected Standards header*/
            DriverHelper.waitFluentByXPath(BrowserInitHelper.getInstance(), buildModePage.getBuildModeSelectedStandardsHeader());
            BrowserInitHelper.getInstance().findElement(By.xpath(buildModePage.getBuildModeSelectedStandardsHeader())).click();

            try {
                BrowserInitHelper.getWaiter().until(ExpectedConditions.visibilityOfElementLocated(By.xpath(buildModePage.getBuildModeStandardsSaved())));
                BrowserInitHelper.getWaiter().until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(buildModePage.getBuildModeStandardsSaved())));
            } catch (Exception e) {
                System.out.println("Exception handled for saving");
            }
            /*Click on Subjects drop down*/
            DriverHelper.waitUntil(buildModePage.getBuild_Standard_Subject());
            DriverHelper.clickXpath(buildModePage.getBuild_Standard_Subject());

            DriverHelper.waitUntil(buildModePage.getBuild_Standard_Subject_Clear());
            DriverHelper.clickXpath(buildModePage.getBuild_Standard_Subject_Clear());

            DriverHelper.waitUntil(buildModePage.getBuild_Standard_First_Subject());
            DriverHelper.clickXpath(buildModePage.getBuild_Standard_First_Subject());

            /*Click on My Standards header*/
            DriverHelper.waitFluentByXPath(BrowserInitHelper.getInstance(), buildModePage.getBuild_Standards_MyStandards());
            BrowserInitHelper.getInstance().findElement(By.xpath(buildModePage.getBuild_Standards_MyStandards())).click();

            try {
                BrowserInitHelper.getWaiter().until(ExpectedConditions.visibilityOfElementLocated(By.xpath(buildModePage.getBuildModeStandardsSaved())));
                BrowserInitHelper.getWaiter().until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(buildModePage.getBuildModeStandardsSaved())));
            } catch (Exception e) {
                System.out.println("Exception handled for saving");
            }

            /*Click on Grade Level drop down*/
            DriverHelper.waitUntil(buildModePage.getBuild_Standard_Grade_Level());
            DriverHelper.clickXpath(buildModePage.getBuild_Standard_Grade_Level());

            DriverHelper.waitUntil(buildModePage.getBuild_Standard_Grade_Clear());
            DriverHelper.clickXpath(buildModePage.getBuild_Standard_Grade_Clear());

            DriverHelper.waitUntil(buildModePage.getBuild_Standard_First_Grade());
            DriverHelper.clickXpath(buildModePage.getBuild_Standard_First_Grade());

            /*Click on My Standards header*/
            DriverHelper.waitFluentByXPath(BrowserInitHelper.getInstance(), buildModePage.getBuild_Standards_MyStandards());
            BrowserInitHelper.getInstance().findElement(By.xpath(buildModePage.getBuild_Standards_MyStandards())).click();


            try {
                BrowserInitHelper.getWaiter().until(ExpectedConditions.visibilityOfElementLocated(By.xpath(buildModePage.getBuildModeStandardsSaved())));
                BrowserInitHelper.getWaiter().until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(buildModePage.getBuildModeStandardsSaved())));
            } catch (Exception e) {
                System.out.println("Exception handled for saving");
            }

            try {
                DriverHelper.awaitTillElementDisplayed(buildModePage.getBuildModeFirstStandardsInModal(), "First standard");
            } catch (Exception e) {
                System.out.println("Exception Handled");
            }
            selected = true;
        } catch (Exception e) {
            log.info("Exception handled for method - select_FirstValueFromAllFilters..." + e);
        }

        return selected;
    }

    // To create assessment for navigating build mode page
    public void creatingAssessment() {
        // Clicking on Create assessment
        boolean check_CreateAssessmentButton = checkDisplay(browseModePage.getCreateAssessmentButton());
        if (check_CreateAssessmentButton) {
            ConsoleLogger.SuccessLog("Test cases : Passed - Create Assessment Button is displayed.....");
            LoggerUtility.LoggerCall("Test cases : Passed - Create Assessment Button is displayed.....");
            DriverHelper.clickXpath(browseModePage.getCreateAssessmentButton());

            //Enter Assessment Name
            BrowserInitHelper.getWaiter().until(ExpectedConditions.elementToBeClickable(By.xpath(browseModePage.getBrowse_Title_In_CreateAssessmentPopup())));
            WebElement TitleInputBox = BrowserInitHelper.getInstance().findElement(By.xpath(browseModePage.getBrowse_Title_In_CreateAssessmentPopup()));
            String assessmentName = csvDataReaderBuildModeStandards.getassessment() + getCurrentTimeStamp();
            TitleInputBox.sendKeys(assessmentName);

            //Click on Create Button
            DriverHelper.clickXpath(browseModePage.getBrowse_CreateButton_In_CreateAssessmentPopup());
        } else {
            ConsoleLogger.FailedTestCase("Test cases : Failed - Create Assessment Button is NOT displayed.....!!!");
            LoggerUtility.LoggerCall("Test cases : Failed - Create Assessment Button is NOT displayed.....!!!");
        }
    }

    // To validate hover message
    public void verifyHover(String xPath, String name) {
        WebElement ele = BrowserInitHelper.getInstance().findElement(By.xpath(xPath));

        //Verify Hover
        Actions action = new Actions(BrowserInitHelper.getInstance());
        action.moveToElement(ele).build().perform();
        DriverHelper.waitFluentByXPath(BrowserInitHelper.getInstance(), buildModePage.getBuild_Question_Group_Hover());
        BrowserInitHelper.getWaiter().until(ExpectedConditions.visibilityOfElementLocated(By.xpath(buildModePage.getBuild_Question_Group_Hover())));
        ConsoleLogger.SuccessLog("Test cases : Passed - Hover Message is displayed for standards in " + name + "");
        LoggerUtility.LoggerCall("Test cases : Passed - Hover Message is displayed for standards in " + name + "");
        Assert.assertTrue(true);
    }

    // To select standard from Create item
    public void createItemStandard() {
        DriverHelper.waitFluentByXPath(BrowserInitHelper.getInstance(), browseModePage.getBrowse_Create_Item_Button());
        DriverHelper.clickXpath(browseModePage.getBrowse_Create_Item_Button());
        try {
            DriverHelper.awaitTillElementDisplayed(buildModePage.getAlign_Standards_Icon(), "Standards Icon");
            DriverHelper.clickXpath(buildModePage.getAlign_Standards_Icon());
        } catch (Exception e) {
            DriverHelper.awaitTillElementDisplayed(buildModePage.getAlign_Standards_Icon(), "Standards Icon");
            DriverHelper.clickXpath(buildModePage.getAlign_Standards_Icon());
        }
        try {
            DriverHelper.awaitTillElementDisplayed(buildModePage.getAlign_Standards_Icon(), "Standards Icon");
            DriverHelper.clickXpath(buildModePage.getAlign_Standards_Icon());
        } catch (Exception e) {
            System.out.println("Exception handled");
        }

        //Clicking standards
        try {
            DriverHelper.waitFluentByXPath(BrowserInitHelper.getInstance(), buildModePage.getCreate_Item_Edit_Base_Standard());
            JavascriptHelper.scrollIntoView(buildModePage.getCreate_Item_Edit_Base_Standard());
            DriverHelper.clickXpath(buildModePage.getCreate_Item_Edit_Base_Standard());
        } catch (Exception e) {
            DriverHelper.waitFluentByXPath(BrowserInitHelper.getInstance(), buildModePage.getCreate_Item_Edit_Base_Standard());
            JavascriptHelper.scrollIntoView(buildModePage.getCreate_Item_Edit_Base_Standard());
            DriverHelper.clickXpath(buildModePage.getCreate_Item_Edit_Base_Standard());
        }
    }


    // To validate selected standards count
    public static void verifyCount(int standard_modal_count, int browse_standard_count) {
        if (standard_modal_count == browse_standard_count) {
            ConsoleLogger.SuccessLog("Test cases : Passed - Newly added Standards are displaying");
            LoggerUtility.LoggerCall("Test cases : Passed - Newly added Standards are displaying");
            Assert.assertTrue(true);
        } else {
            ConsoleLogger.FailedTestCase("Test cases : Failed - Newly added standards are not displaying");
            LoggerUtility.LoggerCall("Test cases : Failed - Newly added standards are not displaying");
            Assert.assertTrue(false);
        }
    }

    // To count selected standards
    public static int standardCount(int countName, String xPath) {
        List<WebElement> list = BrowserInitHelper.getInstance().findElements(By.xpath(xPath));
        for (WebElement ele : list) {
            if (ele.isDisplayed()) {
                countName++;
            }
        }
        System.out.println(countName);
        return countName;
    }

    // To click add more button in build mode standards
    public void addMore(String standard) {
        DriverHelper.waitFluentByXPath(BrowserInitHelper.getInstance(), standard);
        DriverHelper.clickXpath(standard);
        DriverHelper.waitFluentByXPath(BrowserInitHelper.getInstance(), buildModePage.getBuildModeStandardsHeader());
        BrowserInitHelper.getInstance().findElement(By.xpath(buildModePage.getBuildModeStandardsHeader())).click();
        BrowserInitHelper.getWaiter().until(ExpectedConditions.elementToBeClickable(By.xpath(buildModePage.getBuild_Mode_Add_More())));
        JavascriptHelper.scrollBottomOfThePage();
        DriverHelper.waitFluentByXPath(BrowserInitHelper.getInstance(), buildModePage.getBuild_Mode_Add_More());
        DriverHelper.clickXpath(buildModePage.getBuild_Mode_Add_More());
        DriverHelper.waitFluentByXPath(BrowserInitHelper.getInstance(), buildModePage.getBuildModeBaseStandardsHeader());
        BrowserInitHelper.getInstance().findElement(By.xpath(buildModePage.getBuildModeBaseStandardsHeader())).click();
    }

    // To validate Browse mode page
    public void buildModeStandardsTest() {
        DriverHelper.waitFluentByXPath(BrowserInitHelper.getInstance(), browseModePage.getBrowse_ItemSection());
        BrowserInitHelper.getWaiter().until(ExpectedConditions.elementToBeClickable(By.xpath(browseModePage.getBrowse_ItemSection())));
        try {
            BrowserInitHelper.getWaiter().until(ExpectedConditions.elementToBeClickable(By.xpath(browseModePage.getBrowse_First_Item_Content())));
        } catch (Exception te) {
            System.out.println("Exception handled for v_BuildModeStandardsTest...");
        }
    }

    // To click select more standards
    public void clickSelectMoreStandards() {
        BrowserInitHelper.getWaiter().until(ExpectedConditions.elementToBeClickable(By.xpath(browseModePage.getBrowse_ItemSection())));
        //Click on Select More Standards in Browse Mode
        clickShowMoreStandards();
    }

    // To select standards
    public void selectFilters() {
        JavascriptExecutor js = (JavascriptExecutor) BrowserInitHelper.getInstance();

        //Select Filters
        boolean check1 = select_FirstValueFromAllFilters();
        System.out.println("check1 ==>" + check1);
        try {
            DriverHelper.awaitTillElementDisplayed(buildModePage.getBuildModeFirstStandardsInModal(), "First standard");
        } catch (Exception e) {
            System.out.println("Exception handled for First standard");
        }
        List<WebElement> lsStandards = BrowserInitHelper.getInstance().findElements(By.xpath("//div[@id='standardsApp']//div[contains(@class,'v-card__title standard-item-title')]"));
        List<WebElement> lsStandardsCheckboxes = BrowserInitHelper.getInstance().findElements(By.xpath("(//div[@class='standards-list-group-items'])[1]/div//div[contains(@class, 'select-check')]/*[name()='svg']"));

        for (int i = 0; i < lsStandards.size() / 2; i++) {
            String value = lsStandards.get(i).getText();
            if (!(standardValueToSearch.contains(value))) {
                BrowserInitHelper.getWaiter().until(ExpectedConditions.elementToBeClickable(lsStandardsCheckboxes.get(i)));
                if (!lsStandardsCheckboxes.get(i).getAttribute("data-icon").equalsIgnoreCase("check-circle")) {
                    JavascriptHelper.scrollElementIntoView(lsStandards.get(i));
                    //DriverHelper.waitTill(1);
                    lsStandardsCheckboxes = BrowserInitHelper.getInstance().findElements(By.xpath("(//div[@class='standards-list-group-items'])[1]/div//div[contains(@class, 'select-check')]/*[name()='svg']"));
                    /*Select the Standard*/
                    lsStandardsCheckboxes.get(i).click();
                }
            }
        }

        try {
            DriverHelper.waitFluentByXPath(BrowserInitHelper.getInstance(), buildModePage.getBuild_Mode_Selected_Standard());
            WebElement standardToSearch = BrowserInitHelper.getInstance().findElement(By.xpath(buildModePage.getBuild_Mode_Selected_Standard()));
            standardValueToSearch = standardToSearch.getText();
            System.out.println("StandardValueToSearch-->" + standardValueToSearch);

            DriverHelper.waitFluentByXPath(BrowserInitHelper.getInstance(), buildModePage.getBuild_Mode_Standard_Modal_Done());
            WebElement DoneButton = BrowserInitHelper.getInstance().findElement(By.xpath(buildModePage.getBuild_Mode_Standard_Modal_Done()));
            DoneButton.click();
        } catch (Exception e) {
            System.out.println("Exception handled");
        }
        try {
            /*Validate the existence of Standards Search bar*/
            DriverHelper.waitFluentByXPath(BrowserInitHelper.getInstance(), buildModePage.getBuild_Mode_Standard_Text_Box());
            WebElement Element = BrowserInitHelper.getInstance().findElement(By.xpath(buildModePage.getBuild_Mode_Standard_Text_Box()));
            ConsoleLogger.SuccessLog("Test cases : Passed - Verified Standard search bar");
            LoggerUtility.LoggerCall("Test cases : Passed - Verified Standard search bar");
        } catch (Exception e) {
            System.out.println("Exception handled");
        }

    }

    // To validate selected standards in filter selection
    public void verifyStandardFiltersSelection() {
        try {
            DriverHelper.sendKeysXpath(browseModePage.getBrowse_Search_Standard(), standardValueToSearch);
        } catch (Exception e) {
            logger.info("Search for Standard is Not displayed....");
        }

        BrowserInitHelper.getWaiter().until(ExpectedConditions.elementToBeClickable(By.xpath("//label[.='" + standardValueToSearch + "']")));
        DriverHelper.clickXpath("//label[.='" + standardValueToSearch + "']");
        try {
            DriverHelper.waitFluentByXPath(BrowserInitHelper.getInstance(), browseModePage.getBrowse_ItemSection());
        } catch (Exception e) {
            System.out.println("Exception handled for page load ");
        }
        //Wait until item load
        boolean check_NoItemsMessage = checkDisplay(browseModePage.getBrowse_No_Items_Message());
        if (check_NoItemsMessage) {
            ConsoleLogger.FailedTestCase("Test cases : Failed - Sorry, we couldn't find any items! -- MESSAGE -- is displayed.......Create items with Required Standard");
            LoggerUtility.LoggerCall("Test cases : Failed - Sorry, we couldn't find any items! -- MESSAGE -- is displayed.......Create items with Required Standard");
        } else {
            //Verify display of Items and Standard Chips - Verify in Standards
            DriverHelper.waitFluentByXPath(BrowserInitHelper.getInstance(), browseModePage.getBrowse_First_Item_Standards_Chip());
            DriverHelper.clickXpath(browseModePage.getBrowse_First_Item_Standards_Chip());
            DriverHelper.waitFluentByXPath(BrowserInitHelper.getInstance(), browseModePage.getBrowse_Items_Standards_List());
            BrowserInitHelper.getWaiter().until(ExpectedConditions.elementToBeClickable(By.xpath(browseModePage.getBrowse_Items_Standards_List())));

            List<WebElement> itemStandardList = BrowserInitHelper.getInstance().findElements(By.xpath(browseModePage.getBrowse_Items_Standards_List()));
            System.out.println("itemStandardList size ==>" + itemStandardList.size());

            for (int i = 0; i < itemStandardList.size(); i++) {
                String itemStandardText = itemStandardList.get(i).getText().trim();
                System.out.println("itemStandardText ==>" + itemStandardText);
                System.out.println("standard ==>" + standardValueToSearch);

                if (itemStandardText.equalsIgnoreCase(standardValueToSearch)) {
                    ConsoleLogger.SuccessLog("Test cases : Passed - Standard is displayed in Item Standard List in Browse Mode Page...");
                    LoggerUtility.LoggerCall("Test cases : Passed - Standard is displayed in Item Standard List in Browse Mode Page...");
                    break;
                } else {
                    ConsoleLogger.FailedTestCase("Test cases : Failed - Standard is NOT displayed in Item Standard List in Browse Mode Page...!!");
                    LoggerUtility.LoggerCall("Test cases : Failed - Standard is NOT displayed in Item Standard List in Browse Mode Page...!!");
                }
            }
        }
    }

    // To navigate build mode page
    public void navigateBuildModeForItem() {
        boolean standardPresent = false;

        // Again uncheck Standard
        DriverHelper.waitFluentByXPath(BrowserInitHelper.getInstance(), "//label[.='" + standardValueToSearch + "']");
        DriverHelper.clickXpath("//label[.='" + standardValueToSearch + "']");

        // DriverHelper.waitTill(30);
        try {
            DriverHelper.waitFluentByXPath(BrowserInitHelper.getInstance(), browseModePage.getBrowse_ItemSection());
        } catch (Exception e) {
            System.out.println("Exception handled for page load ");
        }
        BrowserInitHelper.getWaiter().until(ExpectedConditions.elementToBeClickable(By.xpath(browseModePage.getBrowse_ItemSection())));
        try {
            DriverHelper.awaitTillElementDisplayed(browseModePage.getBrowseModeFirstItem(), "First item");
        } catch (Exception e) {
            System.out.println("Exception handled for first item");
        }
        try {
            DriverHelper.waitFluentByXPath(BrowserInitHelper.getInstance(), browseModePage.getBrowseModeFirstItem());
        } catch (Exception e) {
            System.out.println("Exception handled for first item");
        }

        List<WebElement> list = BrowserInitHelper.getInstance().findElements(By.xpath("//span[@class='v-chip__content']/span"));

        List<WebElement> list1 = BrowserInitHelper.getInstance().findElements(By.xpath("//div[text() = 'Add Item']"));
        for (int i = 0; i < list.size(); i++) {
            String text = list.get(i).getText();
            if (text.contains("0 Standards")) {
                //  DriverHelper.waitTill(10);
                JavascriptHelper.scrollElementIntoView(list1.get(i));
                list1.get(i).click();
                break;
            }
        }
        try {
            DriverHelper.waitFluentByXPath(BrowserInitHelper.getInstance(), "//label[.='" + standardValueToSearch + "']");
        } catch (Exception e) {
            System.out.println("Exception handled for Page Load");
        }
        BrowserInitHelper.getWaiter().until(ExpectedConditions.elementToBeClickable(By.xpath("//label[.='" + standardValueToSearch + "']")));
        DriverHelper.clickXpath("//label[.='" + standardValueToSearch + "']");

        DriverHelper.waitFluentByXPath(BrowserInitHelper.getInstance(), buildModePage.getBuild_Mode_Add_Item());

        for (int i = 0; i < list.size(); i++) {
            list = BrowserInitHelper.getInstance().findElements(By.xpath("//span[@class='v-chip__content']/span"));
            list1 = BrowserInitHelper.getInstance().findElements(By.xpath("//div[text() = 'Add Item']"));
            String text = list.get(i).getText();
            if (text.contains("1 Standard")) {
                //  DriverHelper.waitTill(10);
                JavascriptHelper.scrollElementIntoView(list1.get(i));
                list1.get(i).click();
                standardPresent = true;
                break;
            }

            // DriverHelper.clickXpath(buildModePage.getBuild_Mode_Add_Item());
        }
        if (standardPresent) {
            ConsoleLogger.SuccessLog("Test cases : Passed - Item consists of required single " + standardValueToSearch + " Standard type");
            LoggerUtility.LoggerCall("Test cases : Passed - Item consists of required single " + standardValueToSearch + " Standard type");
            Assert.assertTrue(true);
        } else {
            ConsoleLogger.FailedTestCase("Test cases : Failed - There are no items with single " + standardValueToSearch + " Standards type");
            LoggerUtility.LoggerCall("Test cases : Failed - There are no items with single " + standardValueToSearch + " Standards type");
            Assert.assertTrue(false);
        }
        creatingAssessment();
    }

    // To validate build mode page
    public void verifyBuildModeStandardsForItemTest() {
        DriverHelper.waitFluentByXPath(BrowserInitHelper.getInstance(), buildModePage.getBuild_Mode_Page_Header());
        boolean element = DriverHelper.checkElementDisplayByXpath(buildModePage.getBuild_Mode_Page_Header(), "Build Mode Page");
        Assert.assertTrue(element);
    }
}
