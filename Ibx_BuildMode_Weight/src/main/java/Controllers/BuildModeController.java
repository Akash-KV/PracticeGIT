package Controllers;

import DataReaders.CSVDataReaderBuildItemWeight;
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
    private static final Logger logger = LoggerFactory.getLogger(BrowserInitHelper.class);

    DriverHelper Helper = new DriverHelper();
    BrowseModePage browseModePage = new BrowseModePage();
    BuildModePage buildModePage = new BuildModePage();
    CSVDataReaderBuildItemWeight csvDataReaderBuildItemWeight = new CSVDataReaderBuildItemWeight();
    boolean checkAddItem, buildPage = false;

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

    //Check Element is displayed
    public boolean checkForClicking(String xpath) {
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

    // To Get the Current Time Stamp
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

    // To enter value in weight
    public void EnterValueInWeight(String WeightElement, String valueToSend) {
        try {
            //Entering the  Value In Weight
            new Actions(BrowserInitHelper.getInstance()).moveToElement(BrowserInitHelper.getInstance().findElement(By.xpath(WeightElement))).click().perform();
            //JavascriptHelper.Clear_JS_xpath(pom_BuildModePage.getBuild_First_Item_Weight());
            DriverHelper.waitFluentByXPath(BrowserInitHelper.getInstance(), WeightElement);
            BrowserInitHelper.getWaiter().until(ExpectedConditions.elementToBeClickable(By.xpath(WeightElement))).sendKeys(Keys.CONTROL + "a");
            BrowserInitHelper.getWaiter().until(ExpectedConditions.elementToBeClickable(By.xpath(WeightElement))).sendKeys(Keys.DELETE);

            Helper.sendKeysXpath(WeightElement, valueToSend);
            BrowserInitHelper.getWaiter().until(ExpectedConditions.visibilityOfElementLocated(By.xpath(buildModePage.getBuild_SaveCheckMark())));
            BrowserInitHelper.getWaiter().until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(buildModePage.getBuild_SaveCheckMark())));
        } catch (Exception e) {
            logger.info("Selection - Weight Data is not entered for the Value---> " + valueToSend);
        }
    }

    // To create assessment
    public void createAssessment() {
        try {
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
                    ConsoleLogger.SuccessLog("Test cases : Passed - Create Assessment Button is displayed.....");
                    LoggerUtility.LoggerCall("Test cases : Passed - Create Assessment Button is displayed.....");
                    DriverHelper.waitFluentByXPath(BrowserInitHelper.getInstance(), browseModePage.getCreateAssessmentButton());
                    DriverHelper.clickXpath(browseModePage.getCreateAssessmentButton());

                    //Enter Assessment Name
                    BrowserInitHelper.getWaiter().until(ExpectedConditions.elementToBeClickable(By.xpath(browseModePage.getBrowse_Title_In_CreateAssessmentPopup())));
                    WebElement TitleInputBox = BrowserInitHelper.getInstance().findElement(By.xpath(browseModePage.getBrowse_Title_In_CreateAssessmentPopup()));
                    String assessmentName = csvDataReaderBuildItemWeight.getassessment() + getCurrentTimeStamp();
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
            logger.info("Exception handled for Assessment Creation of e_CreateAssessment method ");
            ConsoleLogger.FailedTestCase("Test cases : Failed -  Assessment Creation of e_CreateAssessment method ");
            LoggerUtility.LoggerCall("Test cases : Failed -  Assessment Creation of e_CreateAssessment method ");
        }
    }

    // To validate build mode navigation
    public void verifyBuildModeNavigation() {
        try {
            if (checkAddItem) {
                boolean check_BuildModeNavigation = checkDisplay(buildModePage.getBuild_Item_Section());
                if (check_BuildModeNavigation) {
                    ConsoleLogger.SuccessLog("Test cases : Passed - Build Mode Page is displayed.....");
                    LoggerUtility.LoggerCall("Test cases : Passed - Build Mode Page is displayed.....");
                    buildPage = true;

                } else {
                    ConsoleLogger.FailedTestCase("Test cases : Failed - Build Mode Page is NOT displayed.....!!!");
                    LoggerUtility.LoggerCall("Test cases : Failed - Build Mode Page is NOT displayed.....!!!");
                }
            }
        } catch (Exception e) {
            logger.info("Exception handled for Build Navigation");
            ConsoleLogger.FailedTestCase("Test cases : Failed - Test cases : Failed - Build Navigation ");
            LoggerUtility.LoggerCall("Test cases : Failed - Test cases : Failed - Build Navigation ");
        }
    }

    // To validate default value weight
    public void verifyWeightDefaultValue() {
        try {
            if (buildPage) {
                // checking for the Weight display

                boolean check_WeightDisplay = checkForClicking(buildModePage.getBuild_First_Item_Weight());
                if (check_WeightDisplay) {
                    ConsoleLogger.SuccessLog("Test cases : Passed - Weight is displaying for the first Item.....");
                    LoggerUtility.LoggerCall("Test cases : Passed - Weight is displaying for the first Item.....");
                } else {
                    ConsoleLogger.FailedTestCase("Test cases : Failed - Weight is not displaying for the first Item.....!!!");
                    LoggerUtility.LoggerCall("Test cases : Failed - Weight is not displaying for the first Item.....!!!");
                }

                // checking the default value in the Weight

                if (BrowserInitHelper.getInstance().findElement(By.xpath(buildModePage.getBuild_First_Item_Weight())).getAttribute("value").equalsIgnoreCase("1")) {
                    ConsoleLogger.SuccessLog("Test cases : Passed - Weight default value is 1 displaying for the first Item.....");
                    LoggerUtility.LoggerCall("Test cases : Passed - Weight default value is 1 displaying for the first Item.....");
                } else {
                    ConsoleLogger.FailedTestCase("Test cases : Failed - Weight default value is 1 not displaying for the first Item.....");
                    LoggerUtility.LoggerCall("Test cases : Failed - Weight default value is 1 not displaying for the first Item.....");
                }
            }
        } catch (NoSuchElementException ne) {
            logger.info("NoSuchElementException handled for Weight default value is 1 not displaying for the first Item....");
            ConsoleLogger.FailedTestCase("Test cases : Failed - Weight default value is 1 not displaying for the first Item.... due to NoSuchElementException");
            LoggerUtility.LoggerCall("Test cases : Failed - Weight default value is 1 not displaying for the first Item.... due to NoSuchElementException");
        } catch (TimeoutException te) {
            logger.info("TimeoutException handled for Weight default value is 1 not displaying for the first Item.....");
            ConsoleLogger.FailedTestCase("Test cases : Failed - Weight default value is 1 not displaying for the first Item..... due to TimeoutException ");
            LoggerUtility.LoggerCall("Test cases : Failed - Weight default value is 1 not displaying for the first Item..... due to TimeoutException ");
        } catch (WebDriverException we) {
            logger.info("WebDriverException handled for Weight default value is 1 not displaying for the first Item.....");
            ConsoleLogger.FailedTestCase("Test cases : Failed - Weight default value is 1 not displaying for the first Item..... due to WebDriverException");
            LoggerUtility.LoggerCall("Test cases : Failed - Weight default value is 1 not displaying for the first Item..... due to WebDriverException");
        } catch (Exception e) {
            logger.info("Exception handled for Weight default value is 1 not displaying for the first Item.....");
            ConsoleLogger.FailedTestCase("Test cases : Failed - Weight default value is 1 not displaying for the first Item..... due to Exception ");
            LoggerUtility.LoggerCall("Test cases : Failed - Weight default value is 1 not displaying for the first Item..... due to Exception ");
        }
    }

    // To enter alphabet value weight
    public void enterAlphabetValueWeight() {
        //Entering the  Alphabet Value In Weight
        try {
            EnterValueInWeight(buildModePage.getBuild_First_Item_Weight(), csvDataReaderBuildItemWeight.getAlphabetValue());
        } catch (Exception e) {
            logger.info("Selection - Weight Data is not entered for the Value---> Alphabet Value In Weight ");
        }
    }

    // To validate alphabet value in weight
    public void verifyAlphabetValueInWeight() {
        try {
            //verifying the Alphabet Value In Weight
            System.out.println(BrowserInitHelper.getInstance().findElement(By.xpath(buildModePage.getBuild_First_Item_Weight())).getAttribute("value"));
            if (BrowserInitHelper.getInstance().findElement(By.xpath(buildModePage.getBuild_First_Item_Weight())).getAttribute("value").equalsIgnoreCase("1")) {

                ConsoleLogger.SuccessLog("Test cases : Passed - Alphabet value is not taking in Weight .....");
                LoggerUtility.LoggerCall("Test cases : Passed - Alphabet value is not taking in Weight .....");
            } else {
                ConsoleLogger.FailedTestCase("Test cases : Failed - Alphabet value is taking in Weight .....");
                LoggerUtility.LoggerCall("Test cases : Failed - Alphabet value is taking in Weight .....");
            }
        } catch (NoSuchElementException ne) {
            logger.info("NoSuchElementException handled for Alphabet value is taking in Weight .....");
            ConsoleLogger.FailedTestCase("Test cases : Failed - Alphabet value is taking in Weight ..... due to NoSuchElementException");
            LoggerUtility.LoggerCall("Test cases : Failed - Alphabet value is taking in Weight ..... due to NoSuchElementException");
        } catch (TimeoutException te) {
            logger.info("TimeoutException handled for Alphabet value is taking in Weight .....");
            ConsoleLogger.FailedTestCase("Test cases : Failed - Alphabet value is taking in Weight ..... due to TimeoutException ");
            LoggerUtility.LoggerCall("Test cases : Failed - Alphabet value is taking in Weight ..... due to TimeoutException ");
        } catch (WebDriverException we) {
            logger.info("WebDriverException handled for Alphabet value is taking in Weight .....");
            ConsoleLogger.FailedTestCase("Test cases : Failed - Alphabet value is taking in Weight ..... due to WebDriverException");
            LoggerUtility.LoggerCall("Test cases : Failed - Alphabet value is taking in Weight ..... due to WebDriverException");
        } catch (Exception e) {
            logger.info("Exception handled for Alphabet value is taking in Weight .....");
            ConsoleLogger.FailedTestCase("Test cases : Failed - Alphabet value is taking in Weight ..... due to Exception ");
            LoggerUtility.LoggerCall("Test cases : Failed - Alphabet value is taking in Weight ..... due to Exception ");
        }
    }

    // To enter special characters in weight
    public void enterSpecialCharactersInWeight() {
        //Entering the  Special character Value In Weight
        try {
            EnterValueInWeight(buildModePage.getBuild_First_Item_Weight(), csvDataReaderBuildItemWeight.getSpecialcharacterValue());
        } catch (Exception e) {
            logger.info("Selection - Weight Data is not entered for the Value---> Special character Value In Weight ");
        }
    }

    // To validate special characters in weight
    public void verifySpecialCharactersInWeight() {
        try {
            //verifying the Special character Value In Weight
            System.out.println(BrowserInitHelper.getInstance().findElement(By.xpath(buildModePage.getBuild_First_Item_Weight())).getAttribute("value"));
            if (BrowserInitHelper.getInstance().findElement(By.xpath(buildModePage.getBuild_First_Item_Weight())).getAttribute("value").equalsIgnoreCase("1")) {
                ConsoleLogger.SuccessLog("Test cases : Passed - Special character value is not taking in Weight .....");
                LoggerUtility.LoggerCall("Test cases : Passed - Special character value is not taking in Weight .....");
            } else {
                ConsoleLogger.FailedTestCase("Test cases : Failed - Special character value is taking in Weight .....");
                LoggerUtility.LoggerCall("Test cases : Failed - Special character value is taking in Weight .....");
            }
        } catch (NoSuchElementException ne) {
            logger.info("NoSuchElementException handled for Special character value is taking in Weight .....");
            ConsoleLogger.FailedTestCase("Test cases : Failed - Special character value is taking in Weight ..... due to NoSuchElementException");
            LoggerUtility.LoggerCall("Test cases : Failed - Special character value is taking in Weight ..... due to NoSuchElementException");
        } catch (TimeoutException te) {
            logger.info("TimeoutException handled for Special character value is taking in Weight .....");
            ConsoleLogger.FailedTestCase("Test cases : Failed - Special character value is taking in Weight ..... due to TimeoutException ");
            LoggerUtility.LoggerCall("Test cases : Failed - Special character value is taking in Weight ..... due to TimeoutException ");
        } catch (WebDriverException we) {
            logger.info("WebDriverException handled for Special character value is taking in Weight .....");
            ConsoleLogger.FailedTestCase("Test cases : Failed - Special character value is taking in Weight ..... due to WebDriverException");
            LoggerUtility.LoggerCall("Test cases : Failed - Special character value is taking in Weight ..... due to WebDriverException");
        } catch (Exception e) {
            logger.info("Exception handled for Special character value is taking in Weight .....");
            ConsoleLogger.FailedTestCase("Test cases : Failed - Special character value is taking in Weight ..... due to Exception ");
            LoggerUtility.LoggerCall("Test cases : Failed - Special character value is taking in Weight ..... due to Exception");
        }
    }

    // To enter number with plus minus symbol
    public void enterNumberWithPlusMinusSymbol() {
        try {
            String PlusValue = "+" + csvDataReaderBuildItemWeight.getPlusSymbolValue();
            EnterValueInWeight(buildModePage.getBuild_First_Item_Weight(), PlusValue);
        } catch (Exception e) {
            logger.info("Selection - Weight Data is not entered for the Value---> Plus Value In Weight ");
        }
    }

    // To validate number with plus minus symbol
    public void verifyNumberWithPlusMinusSymbol() {
        try {
            System.out.println(BrowserInitHelper.getInstance().findElement(By.xpath(buildModePage.getBuild_First_Item_Weight())).getAttribute("value"));
            if (BrowserInitHelper.getInstance().findElement(By.xpath(buildModePage.getBuild_First_Item_Weight())).getAttribute("value").equals(csvDataReaderBuildItemWeight.getPlusSymbolValue())) {
                ConsoleLogger.SuccessLog("Test cases : Passed - Plus Value is taking in the  Weight .....");
                LoggerUtility.LoggerCall("Test cases : Passed - Plus Value is taking in the  Weight .....");
            } else {
                ConsoleLogger.FailedTestCase("Test cases : Failed - Plus Value is not taking in the  Weight .....");
                LoggerUtility.LoggerCall("Test cases : Failed - Plus Value is not taking in the  Weight .....");
            }
        } catch (NoSuchElementException ne) {
            logger.info("NoSuchElementException handled for Plus Value is not taking in the  Weight .....");
            ConsoleLogger.FailedTestCase("Test cases : Failed - Plus Value is not taking in the  Weight .....due to NoSuchElementException");
            LoggerUtility.LoggerCall("Test cases : Failed - Plus Value is not taking in the  Weight .....due to NoSuchElementException");
        } catch (TimeoutException te) {
            logger.info("TimeoutException handled for Plus Value is not taking in the  Weight .....");
            ConsoleLogger.FailedTestCase("Test cases : Failed - SPlus Value is not taking in the  Weight ..... due to TimeoutException ");
            LoggerUtility.LoggerCall("Test cases : Failed - SPlus Value is not taking in the  Weight ..... due to TimeoutException ");
        } catch (WebDriverException we) {
            logger.info("WebDriverException handled for Plus Value is not taking in the  Weight .....");
            ConsoleLogger.FailedTestCase("Test cases : Failed - Plus Value is not taking in the  Weight ..... due to WebDriverException");
            LoggerUtility.LoggerCall("Test cases : Failed - Plus Value is not taking in the  Weight ..... due to WebDriverException");
        } catch (Exception e) {
            logger.info("Exception handled for Plus Value is not taking in the  Weight .....");
            ConsoleLogger.FailedTestCase("Test cases : Failed - Plus Value is not taking in the  Weight ..... due to Exception ");
            LoggerUtility.LoggerCall("Test cases : Failed - Plus Value is not taking in the  Weight ..... due to Exception ");
        }
    }

    // To enter less than number in weight
    public void enterLessThanNumberInWeight() {
        try {
            EnterValueInWeight(buildModePage.getBuild_First_Item_Weight(), csvDataReaderBuildItemWeight.getLessThanZeroValue());
        } catch (Exception e) {
            logger.info("Selection - Weight Data is not entered for the Value---> Less than Zero Value In Weight ");
        }
    }

    // To validate less than zero in weight
    public void verifyLessThanZeroInWeight() {
        try {
            System.out.println(BrowserInitHelper.getInstance().findElement(By.xpath(buildModePage.getBuild_First_Item_Weight())).getAttribute("value"));
            if (BrowserInitHelper.getInstance().findElement(By.xpath(buildModePage.getBuild_First_Item_Weight())).getAttribute("value").equalsIgnoreCase(csvDataReaderBuildItemWeight.getPlusSymbolValue())) {
                ConsoleLogger.SuccessLog("Test cases : Passed - Less than Zero value is not taking in Weight .....");
                LoggerUtility.LoggerCall("Test cases : Passed - Less than Zero value is not taking in Weight .....");
            } else {
                ConsoleLogger.FailedTestCase("Test cases : Failed - Less than Zero value is taking in Weight .....");
                LoggerUtility.LoggerCall("Test cases : Failed - Less than Zero value is taking in Weight .....");
            }
        } catch (NoSuchElementException ne) {
            logger.info("NoSuchElementException handled for Less than Zero Value is not taking in the  Weight .....");
            ConsoleLogger.FailedTestCase("Test cases : Failed - Less than Zero Value is not taking in the  Weight .....due to NoSuchElementException");
            LoggerUtility.LoggerCall("Test cases : Failed - Less than Zero Value is not taking in the  Weight .....due to NoSuchElementException");
        } catch (TimeoutException te) {
            logger.info("TimeoutException handled for Less than Zero Value is not taking in the  Weight .....");
            ConsoleLogger.FailedTestCase("Test cases : Failed - Less than Zero Value is not taking in the  Weight ..... due to TimeoutException ");
            LoggerUtility.LoggerCall("Test cases : Failed - Less than Zero Value is not taking in the  Weight ..... due to TimeoutException ");
        } catch (WebDriverException we) {
            logger.info("WebDriverException handled for Less than Zero Value is not taking in the  Weight .....");
            ConsoleLogger.FailedTestCase("Test cases : Failed - Less than Zero Value is not taking in the  Weight ..... due to WebDriverException");
            LoggerUtility.LoggerCall("Test cases : Failed - Less than Zero Value is not taking in the  Weight ..... due to WebDriverException");
        } catch (Exception e) {
            logger.info("Exception handled for Less than Zero Value is not taking in the  Weight .....");
            ConsoleLogger.FailedTestCase("Test cases : Failed - Less than Zero Value is not taking in the  Weight ..... due to Exception ");
            LoggerUtility.LoggerCall("Test cases : Failed - Less than Zero Value is not taking in the  Weight ..... due to Exception ");
        }
    }

    // To enter more than hundred in weight
    public void enterMoreThanHundredInWeight() {
        try {
            EnterValueInWeight(buildModePage.getBuild_First_Item_Weight(), csvDataReaderBuildItemWeight.getMorethanHundredValue());
        } catch (Exception e) {
            logger.info("Selection - Weight Data is not entered for the Value---> More than Hundred Value In Weight ");
        }
    }

    // To validate more than hundred in weight
    public void validateMoreThanHundredInWeight() {
        try {
            System.out.println(BrowserInitHelper.getInstance().findElement(By.xpath(buildModePage.getBuild_First_Item_Weight())).getAttribute("value"));
            if (BrowserInitHelper.getInstance().findElement(By.xpath(buildModePage.getBuild_First_Item_Weight())).getAttribute("value").equalsIgnoreCase("100")) {
                ConsoleLogger.SuccessLog("Test cases : Passed - More tha nHundred value is not taking in Weight .....");
                LoggerUtility.LoggerCall("Test cases : Passed - More tha nHundred value is not taking in Weight .....");
            } else {
                ConsoleLogger.FailedTestCase("Test cases : Failed - More than Hundred value is taking in Weight .....");
                LoggerUtility.LoggerCall("Test cases : Failed - More than Hundred value is taking in Weight ....");
            }
        } catch (NoSuchElementException ne) {
            logger.info("NoSuchElementException handled for More than Hundred Value is not taking in the  Weight .....");
            ConsoleLogger.FailedTestCase("Test cases : Failed - More than Hundred Value is not taking in the  Weight .....due to NoSuchElementException");
            LoggerUtility.LoggerCall("Test cases : Failed - More than Hundred Value is not taking in the  Weight .....due to NoSuchElementException");
        } catch (TimeoutException te) {
            logger.info("TimeoutException handled for More than Hundred Value is not taking in the  Weight .....");
            ConsoleLogger.FailedTestCase("Test cases : Failed - More than Hundred Value is not taking in the  Weight ..... due to TimeoutException ");
            LoggerUtility.LoggerCall("Test cases : Failed - More than Hundred Value is not taking in the  Weight ..... due to TimeoutException ");
        } catch (WebDriverException we) {
            logger.info("WebDriverException handled for More than Hundred Value is not taking in the  Weight .....");
            ConsoleLogger.FailedTestCase("Test cases : Failed - More than Hundred Value is not taking in the  Weight ..... due to WebDriverException");
            LoggerUtility.LoggerCall("Test cases : Failed - More than Hundred Value is not taking in the  Weight ..... due to WebDriverException");
        } catch (Exception e) {
            logger.info("Exception handled for More than Hundred Value is not taking in the  Weight .....");
            ConsoleLogger.FailedTestCase("Test cases : Failed - More than Hundred Value is not taking in the  Weight ..... due to Exception ");
            LoggerUtility.LoggerCall("Test cases : Failed - More than Hundred Value is not taking in the  Weight ..... due to Exception ");
        }
    }

    // To enter decimal value in weight
    public void enterDecimalValueInWeight() {
        try {
            EnterValueInWeight(buildModePage.getBuild_First_Item_Weight(), csvDataReaderBuildItemWeight.getDecimalValueOne());
        } catch (Exception e) {
            logger.info("Selection - Weight Data is not entered for the Value---> Decimal Value Eg: 5.5 In Weight ");
        }
    }

    // To validate decimal value in weight
    public void verifyDecimalValueInWeight() {
        try {
            System.out.println(BrowserInitHelper.getInstance().findElement(By.xpath(buildModePage.getBuild_First_Item_Weight())).getAttribute("value"));
            if (BrowserInitHelper.getInstance().findElement(By.xpath(buildModePage.getBuild_First_Item_Weight())).getAttribute("value").equalsIgnoreCase(csvDataReaderBuildItemWeight.getDecimalValueOne())) {
                ConsoleLogger.SuccessLog("Test cases : Passed - Decimal value is taking in Weight .....Eg: 5.5");
                LoggerUtility.LoggerCall("Test cases : Passed - Decimal value is taking in Weight .....Eg: 5.5");
            } else {
                ConsoleLogger.FailedTestCase("Test cases : Failed - Decimal value is not taking in Weight .....Eg: 5.5");
                LoggerUtility.LoggerCall("Test cases : Failed - Decimal value is not taking in Weight .....Eg: 5.5");
            }
        } catch (NoSuchElementException ne) {
            logger.info("NoSuchElementException handled for Decimal value is not taking in Weight .....Eg: 5.5");
            ConsoleLogger.FailedTestCase("Test cases : Failed - Decimal value is not taking in Weight .....Eg: 5.5 due to NoSuchElementException");
            LoggerUtility.LoggerCall("Test cases : Failed - Decimal value is not taking in Weight .....Eg: 5.5 due to NoSuchElementException");
        } catch (TimeoutException te) {
            logger.info("TimeoutException handled for Decimal value is not taking in Weight .....Eg: 5.5");
            ConsoleLogger.FailedTestCase("Test cases : Failed - Decimal value is not taking in Weight .....Eg: 5.5 due to TimeoutException ");
            LoggerUtility.LoggerCall("Test cases : Failed - Decimal value is not taking in Weight .....Eg: 5.5 due to TimeoutException ");
        } catch (WebDriverException we) {
            logger.info("WebDriverException handled for Decimal value is not taking in Weight .....Eg: 5.5");
            ConsoleLogger.FailedTestCase("Test cases : Failed - Decimal value is not taking in Weight .....Eg: 5.5 due to WebDriverException");
            LoggerUtility.LoggerCall("Test cases : Failed - Decimal value is not taking in Weight .....Eg: 5.5 due to WebDriverException");
        } catch (Exception e) {
            logger.info("Exception handled for Decimal value is not taking in Weight .....Eg: 5.5");
            ConsoleLogger.FailedTestCase("Test cases : Failed - Decimal value is not taking in Weight .....Eg: 5.5 due to Exception ");
            LoggerUtility.LoggerCall("Test cases : Failed - Decimal value is not taking in Weight .....Eg: 5.5 due to Exception ");
        }

        //Decimal Value Eg: 5.55
        //Entering the  Decimal Value In Weight

        try {
            EnterValueInWeight(buildModePage.getBuild_First_Item_Weight(), csvDataReaderBuildItemWeight.getDecimalValueTwo());
        } catch (Exception e) {
            logger.info("Selection - Weight Data is not entered for the Value---> Decimal Value Eg: 5.55 In Weight ");
        }

        //verifying the Decimal Value In Weight
        try {
            System.out.println(BrowserInitHelper.getInstance().findElement(By.xpath(buildModePage.getBuild_First_Item_Weight())).getAttribute("value"));
            if (BrowserInitHelper.getInstance().findElement(By.xpath(buildModePage.getBuild_First_Item_Weight())).getAttribute("value").equalsIgnoreCase(csvDataReaderBuildItemWeight.getDecimalValueTwo())) {
                ConsoleLogger.SuccessLog("Test cases : Passed - Decimal value is taking in Weight .....Eg: 5.55");
                LoggerUtility.LoggerCall("Test cases : Passed - Decimal value is taking in Weight .....Eg: 5.55");
            } else {
                ConsoleLogger.FailedTestCase("Test cases : Failed - Decimal value is not taking in Weight .....Eg: 5.55");
                LoggerUtility.LoggerCall("Test cases : Failed - Decimal value is not taking in Weight .....Eg: 5.55");
            }
        } catch (NoSuchElementException ne) {
            logger.info("NoSuchElementException handled for Decimal value is not taking in Weight .....Eg: 5.55");
            ConsoleLogger.FailedTestCase("Test cases : Failed - Decimal value is not taking in Weight .....Eg: 5.55 due to NoSuchElementException");
            LoggerUtility.LoggerCall("Test cases : Failed - Decimal value is not taking in Weight .....Eg: 5.55 due to NoSuchElementException");
        } catch (TimeoutException te) {
            logger.info("TimeoutException handled for Decimal value is not taking in Weight .....Eg: 5.55");
            ConsoleLogger.FailedTestCase("Test cases : Failed - Decimal value is not taking in Weight .....Eg: 5.55 due to TimeoutException ");
            LoggerUtility.LoggerCall("Test cases : Failed - Decimal value is not taking in Weight .....Eg: 5.55 due to TimeoutException ");
        } catch (WebDriverException we) {
            logger.info("WebDriverException handled for Decimal value is not taking in Weight .....Eg: 5.55");
            ConsoleLogger.FailedTestCase("Test cases : Failed - Decimal value is not taking in Weight .....Eg: 5.55 due to WebDriverException");
            LoggerUtility.LoggerCall("Test cases : Failed - Decimal value is not taking in Weight .....Eg: 5.55 due to WebDriverException");
        } catch (Exception e) {
            logger.info("Exception handled for Decimal value is not taking in Weight .....Eg: 5.55");
            ConsoleLogger.FailedTestCase("Test cases : Failed - Decimal value is not taking in Weight .....Eg: 5.55 due to Exception ");
            LoggerUtility.LoggerCall("Test cases : Failed - Decimal value is not taking in Weight .....Eg: 5.55 due to Exception");
        }

        //Decimal Value Eg: 55.5
        //Entering the  Decimal Value In Weight
        try {
            EnterValueInWeight(buildModePage.getBuild_First_Item_Weight(), csvDataReaderBuildItemWeight.getDecimalValueThree());
        } catch (Exception e) {
            logger.info("Selection - Weight Data is not entered for the Value---> Decimal Value Eg: 55.5 In Weight ");
        }

        //verifying the Decimal Value In Weight
        try {
            System.out.println(BrowserInitHelper.getInstance().findElement(By.xpath(buildModePage.getBuild_First_Item_Weight())).getAttribute("value"));
            if (BrowserInitHelper.getInstance().findElement(By.xpath(buildModePage.getBuild_First_Item_Weight())).getAttribute("value").equalsIgnoreCase(csvDataReaderBuildItemWeight.getDecimalValueThree())) {
                ConsoleLogger.SuccessLog("Test cases : Passed - Decimal value is taking in Weight .....Eg: 55.5");
                LoggerUtility.LoggerCall("Test cases : Passed - Decimal value is taking in Weight .....Eg: 55.5");
            } else {
                ConsoleLogger.FailedTestCase("Test cases : Failed - Decimal value is not taking in Weight .....Eg: 55.5");
                LoggerUtility.LoggerCall("Test cases : Failed - Decimal value is not taking in Weight .....Eg: 55.5");
            }
        } catch (NoSuchElementException ne) {
            logger.info("NoSuchElementException handled for Decimal value is not taking in Weight .....Eg: 55.5");
            ConsoleLogger.FailedTestCase("Test cases : Failed - Decimal value is not taking in Weight .....Eg: 55.5 due to NoSuchElementException");
            LoggerUtility.LoggerCall("Test cases : Failed - Decimal value is not taking in Weight .....Eg: 55.5 due to NoSuchElementException");
        } catch (TimeoutException te) {
            logger.info("TimeoutException handled for Decimal value is not taking in Weight .....Eg: 55.5");
            ConsoleLogger.FailedTestCase("Test cases : Failed - Decimal value is not taking in Weight .....Eg: 55.5 due to TimeoutException ");
            LoggerUtility.LoggerCall("Test cases : Failed - Decimal value is not taking in Weight .....Eg: 55.5 due to TimeoutException ");
        } catch (WebDriverException we) {
            logger.info("WebDriverException handled for Decimal value is not taking in Weight .....Eg: 55.5");
            ConsoleLogger.FailedTestCase("Test cases : Failed - Decimal value is not taking in Weight .....Eg: 55.5 due to WebDriverException");
            LoggerUtility.LoggerCall("Test cases : Failed - Decimal value is not taking in Weight .....Eg: 55.5 due to WebDriverException");
        } catch (Exception e) {
            logger.info("Exception handled for Decimal value is not taking in Weight .....Eg: 55.5");
            ConsoleLogger.FailedTestCase("Test cases : Failed - Decimal value is not taking in Weight .....Eg: 55.5 due to Exception ");
            LoggerUtility.LoggerCall("Test cases : Failed - Decimal value is not taking in Weight .....Eg: 55.5 due to Exception ");
        }

        //Decimal Value Eg: 55.55
        //Entering the  Decimal Value In Weight

        try {
            EnterValueInWeight(buildModePage.getBuild_First_Item_Weight(), csvDataReaderBuildItemWeight.getDecimalValueFour());
        } catch (Exception e) {
            logger.info("Selection - Weight Data is not entered for the Value---> Decimal Value Eg: 55.55 In Weight ");
        }

        //verifying the Decimal Value In Weight
        try {
            System.out.println(BrowserInitHelper.getInstance().findElement(By.xpath(buildModePage.getBuild_First_Item_Weight())).getAttribute("value"));
            if (BrowserInitHelper.getInstance().findElement(By.xpath(buildModePage.getBuild_First_Item_Weight())).getAttribute("value").equalsIgnoreCase(csvDataReaderBuildItemWeight.getDecimalValueFour())) {
                ConsoleLogger.SuccessLog("Test cases : Passed - Decimal value is taking in Weight .....Eg: 55.55");
                LoggerUtility.LoggerCall("Test cases : Passed - Decimal value is taking in Weight .....Eg: 55.55");
            } else {
                ConsoleLogger.FailedTestCase("Test cases : Failed - Decimal value is not taking in Weight .....Eg: 55.55");
                LoggerUtility.LoggerCall("Test cases : Failed - Decimal value is not taking in Weight .....Eg: 55.55");
            }
        } catch (NoSuchElementException ne) {
            logger.info("NoSuchElementException handled for Decimal value is not taking in Weight .....Eg: 55.55");
            ConsoleLogger.FailedTestCase("Test cases : Failed - Decimal value is not taking in Weight .....Eg: 55.55 due to NoSuchElementException");
            LoggerUtility.LoggerCall("Test cases : Failed - Decimal value is not taking in Weight .....Eg: 55.55 due to NoSuchElementException");
        } catch (TimeoutException te) {
            logger.info("TimeoutException handled for Decimal value is not taking in Weight .....Eg: 55.55");
            ConsoleLogger.FailedTestCase("Test cases : Failed - Decimal value is not taking in Weight .....Eg: 55.55 due to TimeoutException ");
            LoggerUtility.LoggerCall("Test cases : Failed - Decimal value is not taking in Weight .....Eg: 55.55 due to TimeoutException ");
        } catch (WebDriverException we) {
            logger.info("WebDriverException handled for Decimal value is not taking in Weight .....Eg: 55.55");
            ConsoleLogger.FailedTestCase("Test cases : Failed - Decimal value is not taking in Weight .....Eg: 55.55 due to WebDriverException");
            LoggerUtility.LoggerCall("Test cases : Failed - Decimal value is not taking in Weight .....Eg: 55.55 due to WebDriverException");
        } catch (Exception e) {
            logger.info("Exception handled for Decimal value is not taking in Weight .....Eg: 55.55");
            ConsoleLogger.FailedTestCase("Test cases : Failed - Decimal value is not taking in Weight .....Eg: 55.55 due to Exception ");
            LoggerUtility.LoggerCall("Test cases : Failed - Decimal value is not taking in Weight .....Eg: 55.55 due to Exception ");
        }

        //Decimal Value Eg: 0.5
        //Entering the  Decimal Value In Weight
        try {
            EnterValueInWeight(buildModePage.getBuild_First_Item_Weight(), csvDataReaderBuildItemWeight.getDecimalValueFive());
        } catch (Exception e) {
            logger.info("Selection - Weight Data is not entered for the Value---> Decimal Value Eg: 0.5 In Weight ");
        }

        //verifying the Decimal Value In Weight
        try {
            System.out.println(BrowserInitHelper.getInstance().findElement(By.xpath(buildModePage.getBuild_First_Item_Weight())).getAttribute("value"));
            if (BrowserInitHelper.getInstance().findElement(By.xpath(buildModePage.getBuild_First_Item_Weight())).getAttribute("value").equalsIgnoreCase(csvDataReaderBuildItemWeight.getDecimalValueFive())) {
                ConsoleLogger.SuccessLog("Test cases : Passed - Decimal value is taking in Weight .....Eg: 0.5");
                LoggerUtility.LoggerCall("Test cases : Passed - Decimal value is taking in Weight .....Eg: 0.5");
            } else {
                ConsoleLogger.FailedTestCase("Test cases : Failed - Decimal value is not taking in Weight .....Eg: 0.5");
                LoggerUtility.LoggerCall("Test cases : Failed - Decimal value is not taking in Weight .....Eg: 0.5");
            }
        } catch (NoSuchElementException ne) {
            logger.info("NoSuchElementException handled for Decimal value is not taking in Weight .....Eg: 0.5");
            ConsoleLogger.FailedTestCase("Test cases : Failed - Decimal value is not taking in Weight .....Eg: 0.5 due to NoSuchElementException");
            LoggerUtility.LoggerCall("Test cases : Failed - Decimal value is not taking in Weight .....Eg: 0.5 due to NoSuchElementException");
        } catch (TimeoutException te) {
            logger.info("TimeoutException handled for Decimal value is not taking in Weight .....Eg: 0.5");
            ConsoleLogger.FailedTestCase("Test cases : Failed - Decimal value is not taking in Weight .....Eg: 0.5 due to TimeoutException ");
            LoggerUtility.LoggerCall("Test cases : Failed - Decimal value is not taking in Weight .....Eg: 0.5 due to TimeoutException ");
        } catch (WebDriverException we) {
            logger.info("WebDriverException handled for Decimal value is not taking in Weight .....Eg: 0.5");
            ConsoleLogger.FailedTestCase("Test cases : Failed - Decimal value is not taking in Weight .....Eg: 0.5 due to WebDriverException");
            LoggerUtility.LoggerCall("Test cases : Failed - Decimal value is not taking in Weight .....Eg: 0.5 due to WebDriverException");
        } catch (Exception e) {
            logger.info("Exception handled for Decimal value is not taking in Weight .....Eg: 0.5");
            ConsoleLogger.FailedTestCase("Test cases : Failed - Decimal value is not taking in Weight .....Eg: 0.5 due to Exception ");
            LoggerUtility.LoggerCall("Test cases : Failed - Decimal value is not taking in Weight .....Eg: 0.5 due to Exception");
        }

        //Decimal Value Eg: 0.55
        //Entering the  Decimal Value In Weight
        try {
            EnterValueInWeight(buildModePage.getBuild_First_Item_Weight(), csvDataReaderBuildItemWeight.getDecimalValueSix());
        } catch (Exception e) {
            logger.info("Selection - Weight Data is not entered for the Value---> Decimal Value Eg: 0.55 In Weight ");
        }

        //verifying the Decimal Value In Weight
        try {
            System.out.println(BrowserInitHelper.getInstance().findElement(By.xpath(buildModePage.getBuild_First_Item_Weight())).getAttribute("value"));
            if (BrowserInitHelper.getInstance().findElement(By.xpath(buildModePage.getBuild_First_Item_Weight())).getAttribute("value").equalsIgnoreCase(csvDataReaderBuildItemWeight.getDecimalValueSix())) {
                ConsoleLogger.SuccessLog("Test cases : Passed - Decimal value is taking in Weight .....Eg: 0.55");
                LoggerUtility.LoggerCall("Test cases : Passed - Decimal value is taking in Weight .....Eg: 0.55 ");
            } else {
                ConsoleLogger.FailedTestCase("Test cases : Failed - Decimal value is not taking in Weight .....Eg: 0.55");
                LoggerUtility.LoggerCall("Test cases : Failed - Decimal value is not taking in Weight .....Eg: 0.55");
            }
        } catch (NoSuchElementException ne) {
            logger.info("NoSuchElementException handled for Decimal value is not taking in Weight .....Eg: 0.55");
            ConsoleLogger.FailedTestCase("Test cases : Failed - Decimal value is not taking in Weight .....Eg: 0.55 due to NoSuchElementException");
            LoggerUtility.LoggerCall("Test cases : Failed - Decimal value is not taking in Weight .....Eg: 0.55 due to NoSuchElementException ");
        } catch (TimeoutException te) {
            logger.info("TimeoutException handled for Decimal value is not taking in Weight .....Eg: 0.55");
            ConsoleLogger.FailedTestCase("Test cases : Failed - Decimal value is not taking in Weight .....Eg: 0.55 due to TimeoutException ");
            LoggerUtility.LoggerCall("Test cases : Failed - Decimal value is not taking in Weight .....Eg: 0.55 due to TimeoutException ");
        } catch (WebDriverException we) {
            logger.info("WebDriverException handled for Decimal value is not taking in Weight .....Eg: 0.55");
            ConsoleLogger.FailedTestCase("Test cases : Failed - Decimal value is not taking in Weight .....Eg: 0.55 due to WebDriverException");
            LoggerUtility.LoggerCall("Test cases : Failed - Decimal value is not taking in Weight .....Eg: 0.55 due to WebDriverException ");
        } catch (Exception e) {
            logger.info("Exception handled for Decimal value is not taking in Weight .....Eg: 0.55");
            ConsoleLogger.FailedTestCase("Test cases : Failed - Decimal value is not taking in Weight .....Eg: 0.55 due to Exception ");
            LoggerUtility.LoggerCall("Test cases : Failed - Decimal value is not taking in Weight .....Eg: 0.55 due to Exception ");
        }

        //Decimal Value Eg: .5
        //Entering the  Decimal Value In Weight
        try {
            String DotValueOne = "." + csvDataReaderBuildItemWeight.getDecimalValueSeven();
            EnterValueInWeight(buildModePage.getBuild_First_Item_Weight(), DotValueOne);
        } catch (Exception e) {
            logger.info("Selection - Weight Data is not entered for the Value---> Decimal Value Eg: .5 In Weight ");
        }

        //verifying the Decimal Value In Weight
        try {
            System.out.println(BrowserInitHelper.getInstance().findElement(By.xpath(buildModePage.getBuild_First_Item_Weight())).getAttribute("value"));
            String dotValueVerifyOne = "0." + csvDataReaderBuildItemWeight.getDecimalValueSeven();
            if (BrowserInitHelper.getInstance().findElement(By.xpath(buildModePage.getBuild_First_Item_Weight())).getAttribute("value").equalsIgnoreCase(dotValueVerifyOne)) {
                ConsoleLogger.SuccessLog("Test cases : Passed - Decimal value is taking in Weight .....Eg: .5");
                LoggerUtility.LoggerCall("Test cases : Passed - Decimal value is taking in Weight .....Eg: .5 ");
            } else {
                ConsoleLogger.FailedTestCase("Test cases : Failed - Decimal value is not taking in Weight .....Eg: .5");
                LoggerUtility.LoggerCall("Test cases : Failed - Decimal value is not taking in Weight .....Eg: .5 ");
            }
        } catch (NoSuchElementException ne) {
            logger.info("NoSuchElementException handled for Decimal value is not taking in Weight .....Eg: .5");
            ConsoleLogger.FailedTestCase("Test cases : Failed - Decimal value is not taking in Weight .....Eg: .5 due to NoSuchElementException");
            LoggerUtility.LoggerCall("Test cases : Failed - Decimal value is not taking in Weight .....Eg: .5 due to NoSuchElementException ");
        } catch (TimeoutException te) {
            logger.info("TimeoutException handled for Decimal value is not taking in Weight .....Eg: .5");
            ConsoleLogger.FailedTestCase("Test cases : Failed - Decimal value is not taking in Weight .....Eg: .5 due to TimeoutException ");
            LoggerUtility.LoggerCall("Test cases : Failed - Decimal value is not taking in Weight .....Eg: .5 due to TimeoutException ");
        } catch (WebDriverException we) {
            logger.info("WebDriverException handled for Decimal value is not taking in Weight .....Eg: .5");
            ConsoleLogger.FailedTestCase("Test cases : Failed - Decimal value is not taking in Weight .....Eg: .5 due to WebDriverException");
            LoggerUtility.LoggerCall("Test cases : Failed - Decimal value is not taking in Weight .....Eg: .5 due to WebDriverException ");
        } catch (Exception e) {
            logger.info("Exception handled for Decimal value is not taking in Weight .....Eg: .5");
            ConsoleLogger.FailedTestCase("Test cases : Failed - Decimal value is not taking in Weight .....Eg: .5 due to Exception ");
            LoggerUtility.LoggerCall("Test cases : Failed - Decimal value is not taking in Weight .....Eg: .5 due to Exception");
        }

        //Decimal Value Eg: .55
        //Entering the  Decimal Value In Weight
        try {
            String dotValueTwo = "." + csvDataReaderBuildItemWeight.getDecimalValueEight();
            EnterValueInWeight(buildModePage.getBuild_First_Item_Weight(), dotValueTwo);
        } catch (Exception e) {
            logger.info("Selection - Weight Data is not entered for the Value---> Decimal Value Eg: .55 In Weight ");
        }

        //verifying the Decimal Value In Weight
        try {
            System.out.println(BrowserInitHelper.getInstance().findElement(By.xpath(buildModePage.getBuild_First_Item_Weight())).getAttribute("value"));

            String dotValueVerifyTwo = "0." + csvDataReaderBuildItemWeight.getDecimalValueEight();
            if (BrowserInitHelper.getInstance().findElement(By.xpath(buildModePage.getBuild_First_Item_Weight())).getAttribute("value").equalsIgnoreCase(dotValueVerifyTwo)) {
                ConsoleLogger.SuccessLog("Test cases : Passed - Decimal value is taking in Weight .....Eg: .55");
                LoggerUtility.LoggerCall("Test cases : Passed - Decimal value is taking in Weight .....Eg: .55\" ");
            } else {
                ConsoleLogger.FailedTestCase("Test cases : Failed - Decimal value is not taking in Weight .....Eg: .55");
                LoggerUtility.LoggerCall("Test cases : Failed - Decimal value is not taking in Weight .....Eg: .55");
            }
        } catch (NoSuchElementException ne) {
            logger.info("NoSuchElementException handled for Decimal value is not taking in Weight .....Eg: .55");
            ConsoleLogger.FailedTestCase("Test cases : Failed - Decimal value is not taking in Weight .....Eg: .55 due to NoSuchElementException");
            LoggerUtility.LoggerCall("Test cases : Failed - Decimal value is not taking in Weight .....Eg: .55 due to NoSuchElementException ");
        } catch (TimeoutException te) {
            logger.info("TimeoutException handled for Decimal value is not taking in Weight .....Eg: .55");
            ConsoleLogger.FailedTestCase("Test cases : Failed - Decimal value is not taking in Weight .....Eg: .55 due to TimeoutException ");
            LoggerUtility.LoggerCall("Test cases : Failed - Decimal value is not taking in Weight .....Eg: .55 due to TimeoutException ");
        } catch (WebDriverException we) {
            logger.info("WebDriverException handled for Decimal value is not taking in Weight .....Eg: .55");
            ConsoleLogger.FailedTestCase("Test cases : Failed - Decimal value is not taking in Weight .....Eg: .55 due to WebDriverException");
            LoggerUtility.LoggerCall("Test cases : Failed - Decimal value is not taking in Weight .....Eg: .55 due to WebDriverException ");
        } catch (Exception e) {
            logger.info("Exception handled for Decimal value is not taking in Weight .....Eg: .5");
            ConsoleLogger.FailedTestCase("Test cases : Failed - Decimal value is not taking in Weight .....Eg: .55 due to Exception ");
            LoggerUtility.LoggerCall("Test cases : Failed - Decimal value is not taking in Weight .....Eg: .55 due to Exception ");
        }
    }
}


