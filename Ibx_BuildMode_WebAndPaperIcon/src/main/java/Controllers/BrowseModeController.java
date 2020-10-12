package Controllers;

import Helpers.BrowserInitHelper;
import Helpers.DriverHelper;
import Helpers.JavascriptHelper;
import Pom.BrowseModePage;
import Utils.ConsoleLogger;
import Utils.LoggerUtility;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

/**
 * Controllers class for BrowseMode
 **/
public class BrowseModeController {

    private static final Logger log = LoggerFactory.getLogger(BrowserInitHelper.class);

    BrowseModePage browseModePage = new BrowseModePage();

    // To validate BrowseMode Page
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
               // System.out.println("path is" + path);
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

}
