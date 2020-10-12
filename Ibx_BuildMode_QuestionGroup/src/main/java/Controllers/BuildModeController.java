package Controllers;

import DataReaders.CSVDataReaderBuildModeQuestionGroups;
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

import static Helpers.JavascriptHelper.*;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Controllers class for BuildMode
 **/
public class BuildModeController {

    //Logger and WebDrivers
    private static final Logger log = LoggerFactory.getLogger(BrowserInitHelper.class);
    private static final Logger logger = LoggerFactory.getLogger(BuildModeController.class);

    BrowseModePage browseModePage = new BrowseModePage();
    BuildModePage buildModePage = new BuildModePage();
    CSVDataReaderBuildModeQuestionGroups csvDataReaderBuildModeQuestionGroups = new CSVDataReaderBuildModeQuestionGroups();

    boolean check_Create_Assessment_Button, check_Create_Assessment_Popup, check_Build_Mode_Navigation, check_Question_Groups,
            check_Question_Group_Selection, check_Question_Group_Multiple_Selection, check_Question_Group_Search,
            check_New_Question_Group_Add, check_SearchUsingEnter, check_SearchByCase, check_passage_Metadata, check_Hover = false;
    String toCheck_Case = "";

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

    //Get Current Time Stamp
    public String getCurrentTimeStamp() {
        String timestamp = "";

        DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
        Date date = new Date();
        timestamp = dateFormat.format(date);
        System.out.println(dateFormat.format(date));

        return timestamp;
    }

    //method to get add item
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

    //method to get size list
    public int getSize_List(String Xpath) {
        int i = 0;
        try {
            List<WebElement> List = BrowserInitHelper.getInstance().findElements(By.xpath(Xpath));
            i = List.size();
        } catch (Exception e) {
            log.info("Exception handled for method - getSize_List");
        }
        return i;
    }

    //method to select_QuestionGroups_Item
    public boolean select_QuestionGroups_Item(String listXpath, int position, String saveXpath) {
        boolean selection = false;

        try {
            DriverHelper.waitFluentByXPath(BrowserInitHelper.getInstance(), listXpath);
            BrowserInitHelper.getWaiter().until(ExpectedConditions.elementToBeClickable(By.xpath(listXpath)));
            List<WebElement> List = BrowserInitHelper.getInstance().findElements(By.xpath(listXpath));
            for (int i = 0; i < List.size(); i++) {
                if (i < position) {
                    WebElement list_item = List.get(i);

                    //Click Add Item for items
                    list_item.click();

                    waitTillInvisible(saveXpath);
                    selection = true;
                }
            }
        } catch (Exception e) {
            log.info("Exception handled for method - select_QuestionGroups_Item..");
        }

        return selection;
    }

    //method to unSelect question group item
    public boolean Un_select_QuestionGroups_Item(String listXpath, int position, String saveXpath) {
        boolean selection = false;

        List<String> list_Groups = new ArrayList<String>();

        try {
            DriverHelper.waitFluentByXPath(BrowserInitHelper.getInstance(), listXpath);
            BrowserInitHelper.getWaiter().until(ExpectedConditions.elementToBeClickable(By.xpath(listXpath)));
            List<WebElement> List = BrowserInitHelper.getInstance().findElements(By.xpath(listXpath));
            System.out.println("position ==>" + position);

            for (int i = 0; i < List.size(); i++) {
                list_Groups.add(List.get(i).getText().trim());
            }

            System.out.println("list_Groups ==>" + list_Groups);

            for (int i = 0; i < List.size(); i++) {

                if (i < position) {
                    WebElement list_item = List.get(i);
                    String Title = list_Groups.get(i);
                    System.out.println("Title ==>" + Title);

                    String xPath_List_Item = "//div[@class='v-menu__content theme--light menuable__content__active x-multiselect__menu']//span[@class='x-multiselect__item__label' and text()='" + Title + "']";

                    //Click Add Item for items
                    //list_item.click();
                    if (Title.contains("'")) {
                        String final_Title = Title.substring(0, 4);
                        String xPath_final = "//div[@class='v-menu__content theme--light menuable__content__active x-multiselect__menu']//span[@class='x-multiselect__item__label' and contains(text(),'" + final_Title + "')]";
                        BrowserInitHelper.getInstance().findElement(By.xpath(xPath_final)).click();
                    } else {
                        BrowserInitHelper.getInstance().findElement(By.xpath(xPath_List_Item)).click();
                    }

                    waitTillInvisible(saveXpath);
                    selection = true;
                }
            }
        } catch (Exception e) {
            log.info("Exception handled for method - select_QuestionGroups_Item..");
        }

        return selection;
    }

    //Method to wait till invisible
    public void waitTillInvisible(String xpath) {
        try {
            DriverHelper.waitFluentByXPath(BrowserInitHelper.getInstance(), xpath);
            BrowserInitHelper.getWaiter().until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(xpath)));
        } catch (Exception e) {
            log.info("Exception handled for method - waitTillInvisible..");
        }
    }

    //Check data circle in Question groups after adding new question group
    public boolean check_DataCircle(String label_List) {
        boolean value = false;
        try {
            String label = "//span[@class='x-multiselect__item__label' and text()='" + label_List + "']/preceding::span/*[name()='svg']";
            DriverHelper.waitFluentByXPath(BrowserInitHelper.getInstance(), label);
            BrowserInitHelper.getWaiter().until(ExpectedConditions.elementToBeClickable(By.xpath(label)));
            String dataCircle = BrowserInitHelper.getInstance().findElement(By.xpath(label)).getAttribute("data-icon");
            if (dataCircle.equalsIgnoreCase("check-circle")) {
                value = true;
            }
        } catch (Exception e) {
            System.out.println("Exception handled....");
        }

        return value;
    }

    //method to Uncheck_DataCircle
    public boolean Uncheck_DataCircle(String label_List, String saveXpath) {
        boolean value = false;
        try {
            String label = "//span[@class='x-multiselect__item__label' and text()='" + label_List + "']/preceding::span/*[name()='svg']";
            DriverHelper.waitFluentByXPath(BrowserInitHelper.getInstance(), label);
            BrowserInitHelper.getWaiter().until(ExpectedConditions.elementToBeClickable(By.xpath(label)));
            String dataCircle = BrowserInitHelper.getInstance().findElement(By.xpath(label)).getAttribute("data-icon");
            if (dataCircle.equalsIgnoreCase("check-circle")) {
                BrowserInitHelper.getWaiter().until(ExpectedConditions.elementToBeClickable(By.xpath(label))).click();
                waitTillInvisible(saveXpath);
                value = true;
            }
        } catch (Exception e) {
            System.out.println("Exception handled....");
        }

        return value;
    }

    // Create Assessment Button
    public void createAssessmentButton() {
        try {
            DriverHelper.waitFluentByXPath(BrowserInitHelper.getInstance(), browseModePage.getBrowse_ItemSection());
            DriverHelper.waitFluentByXPath(BrowserInitHelper.getInstance(), browseModePage.getBrowse_First_Item_Content());
        } catch (TimeoutException te) {
            ConsoleLogger.DebugLog("Content Not displayed inside items........");
        }
    }

    //click on create assessment button
    public void clickCreateAssessmentButton() {
        createAssessmentButton();

        //Select Items and click on Create
        getAddItem(browseModePage.getBrowse_AddItem_List(), 1);
        check_Create_Assessment_Button = checkDisplay(browseModePage.getCreateAssessmentButton());
    }

    //validate create assessment popup
    public void verifyCreateAssessmentPopup() {
        if (check_Create_Assessment_Button) {
            ConsoleLogger.SuccessLog("Test cases : Passed - Create Assessment Button is displayed.....");
            LoggerUtility.LoggerCall("Test cases : Passed - Create Assessment Button is displayed.....");
            DriverHelper.waitFluentByXPath(BrowserInitHelper.getInstance(), browseModePage.getCreateAssessmentButton());
            DriverHelper.clickXpath(browseModePage.getCreateAssessmentButton());

            check_Create_Assessment_Popup = checkDisplay(browseModePage.getBrowse_Title_In_CreateAssessmentPopup());
            Assert.assertTrue(check_Create_Assessment_Popup);
        }
    }

    //create assessment
    public void createAssessment() {
        if (check_Create_Assessment_Popup) {
            //Enter Assessment Name
            BrowserInitHelper.getWaiter().until(ExpectedConditions.elementToBeClickable(By.xpath(browseModePage.getBrowse_Title_In_CreateAssessmentPopup())));
            WebElement TitleInputBox = BrowserInitHelper.getInstance().findElement(By.xpath(browseModePage.getBrowse_Title_In_CreateAssessmentPopup()));
            String assessmentName = csvDataReaderBuildModeQuestionGroups.getAssessment() + getCurrentTimeStamp();
            TitleInputBox.sendKeys(assessmentName);

            //Click on Create Button
            DriverHelper.waitFluentByXPath(BrowserInitHelper.getInstance(), browseModePage.getBrowse_CreateButton_In_CreateAssessmentPopup());
            DriverHelper.clickXpath(browseModePage.getBrowse_CreateButton_In_CreateAssessmentPopup());
        } else {
            ConsoleLogger.FailedTestCase("Test cases : Failed - Create Assessment Button is NOT displayed.....!!!");
            LoggerUtility.LoggerCall("Test cases : Failed - Create Assessment Button is NOT displayed.....!!!");
        }
    }

    //validate navigation to build mode
    public void verifyNavigationToBuildPage() {
        //Verify build mode navigation
        check_Build_Mode_Navigation = checkDisplay(buildModePage.getBuild_Item_Section());
        if (check_Build_Mode_Navigation) {
            ConsoleLogger.SuccessLog("Test cases : Passed - Build Mode Page is displayed.....");
            LoggerUtility.LoggerCall("Test cases : Passed - Build Mode Page is displayed.....");
            checkDisplay(buildModePage.getBuild_First_Item_Content());
        } else {
            ConsoleLogger.FailedTestCase("Test cases : Failed - Build Mode Page is NOT displayed.....!!");
            LoggerUtility.LoggerCall("Test cases : Failed - Build Mode Page is NOT displayed.....!!");
        }
    }

    //Click on Question groups
    public void clickQuestionGroups() {
        if (check_Build_Mode_Navigation) {
            check_Question_Groups = checkDisplay(buildModePage.getBuild_First_Item_Question_Groups_Button());
            if (check_Question_Groups) {
                ConsoleLogger.SuccessLog("Test cases : Passed - Question Groups Button in Build Mode Page is displayed.....");
                LoggerUtility.LoggerCall("Test cases : Passed - Question Groups Button in Build Mode Page is displayed.....");
                //Click on Question group button
                DriverHelper.waitFluentByXPath(BrowserInitHelper.getInstance(), buildModePage.getBuild_First_Item_Question_Groups_Button());
                DriverHelper.clickXpath(buildModePage.getBuild_First_Item_Question_Groups_Button());

                //Select first question group
                check_Question_Group_Selection = select_QuestionGroups_Item(buildModePage.getBuild_First_Item_Question_Groups_List(), 1, buildModePage.getBuild_Save_CheckMark());

            } else {
                ConsoleLogger.FailedTestCase("Test cases : Failed - Question Groups Button in Build Mode Page is NOT displayed.....!!");
                LoggerUtility.LoggerCall("Test cases : Failed - Question Groups Button in Build Mode Page is NOT displayed.....!!");
            }
        }
    }

    //validate Question Group selection
    public void verifyQuestionGroupSelection() {
        if (check_Question_Group_Selection) {
            ConsoleLogger.SuccessLog("Test cases : Passed - Question Group selection is successful for first option.....");
            LoggerUtility.LoggerCall("Test cases : Passed - Question Group selection is successful for first option.....");
            //Verify Tick Mark
            boolean check_Tick_Mark = checkDisplay(buildModePage.getBuild_Question_Group_Tick_Mark());
            if (check_Tick_Mark) {
                ConsoleLogger.SuccessLog("Test cases : Passed - Tick Mark is displayed after selecting Question Group...");
                LoggerUtility.LoggerCall("Test cases : Passed - Tick Mark is displayed after selecting Question Group...");
            } else {
                ConsoleLogger.SuccessLog("Test cases : Passed - Tick Mark is NOT displayed after selecting Question Group...!!");
                LoggerUtility.LoggerCall("Test cases : Passed - Tick Mark is NOT displayed after selecting Question Group...!!");
            }

            //Verify Count after Selection
            waitTillInvisible(buildModePage.getBuild_Save_CheckMark());
            String count = BrowserInitHelper.getInstance().findElement(By.xpath(buildModePage.getBuild_First_Item_Question_Groups_Count())).getText().trim();
            int final_count = Integer.parseInt(count);

            if (final_count == 1) {
                ConsoleLogger.SuccessLog("Test cases : Passed - Count is verified after selecting first question group......");
                LoggerUtility.LoggerCall("Test cases : Passed - Count is verified after selecting first question group......");
            } else {
                ConsoleLogger.FailedTestCase("Test cases : Failed - Count is NOT verified after selecting first question group....!!");
                LoggerUtility.LoggerCall("Test cases : Failed - Count is NOT verified after selecting first question group....!!");
            }

            //Again unSelect same group
            check_Question_Group_Selection = select_QuestionGroups_Item(buildModePage.getBuild_First_Item_Question_Groups_List(), 1, buildModePage.getBuild_Save_CheckMark());
            waitTillInvisible(buildModePage.getBuild_Save_CheckMark());
        } else {
            ConsoleLogger.FailedTestCase("Test cases : Failed - Question Group selection is NOT successful for first option.....!!");
            LoggerUtility.LoggerCall("Test cases : Failed - Question Group selection is NOT successful for first option.....!!");
        }
    }

    //click on multiple question groups
    public void clickMultipleQuestionGroups() {
        // << Commented this code because it will consume more time to check all options when running test continuously >>
        /*
            //Click all list options
            List<WebElement> list_Question_Groups = BrowserInitHelper.getInstance().findElements(By.xpath(pom_Buildmode.getBuild_First_Item_Question_Groups_List()));
            int size = list_Question_Groups.size();

            check_Question_Group_Selection = buildModeQuestionGroupsController.select_QuestionGroups_Item(pom_Buildmode.getBuild_First_Item_Question_Groups_List(), size, pom_Buildmode.getBuild_Save_CheckMark());
            if (check_Question_Group_Selection) {
                ConsoleLogger.SuccessLog("Test cases : Passed - Question Group selection is successful for all options.....");

                //Verify tick mark for all options
                boolean check_Tick_Mark = buildModeQuestionGroupsController.checkDisplay(pom_Buildmode.getBuild_Question_Group_Tick_Mark());
                List<WebElement> tick_Mark_List = BrowserInitHelper.getInstance().findElements(By.xpath(pom_Buildmode.getBuild_Question_Group_Tick_Mark()));
                int tick_mark_count = tick_Mark_List.size();

                if ((check_Tick_Mark) && (tick_mark_count == size)) {
                    ConsoleLogger.SuccessLog("Test cases : Passed - Tick Mark is displayed after selecting ALL - Question Group options...");
                    check_Question_Group_Multiple_Selection = true;

                    //Un-select all options
                    //buildModeQuestionGroupsController.select_QuestionGroups_Item(pom_Buildmode.getBuild_First_Item_Question_Groups_List(), size, pom_Buildmode.getBuild_Save_CheckMark());
                    buildModeQuestionGroupsController.Un_select_QuestionGroups_Item(pom_Buildmode.getBuild_First_Item_Question_Groups_List(), size, pom_Buildmode.getBuild_Save_CheckMark());
                } else {
                    ConsoleLogger.FailedTestCase("Test cases : Failed - Tick Mark is NOT displayed after selecting ALL - Question Group options...!!");
                }
            } else {
                ConsoleLogger.FailedTestCase("Test cases : Failed - Question Group selection is NOT successful for all options.....!!");
            }
        }
        }*/
    }

    //validate VerifyMultipleQuestionGroupSelection
    public void verifyMultipleQuestionGroupSelection() {
        if (check_Question_Group_Multiple_Selection) {
            ConsoleLogger.SuccessLog("Test cases : Passed - Multiple Question Group Selection is successful...");
            LoggerUtility.LoggerCall("Test cases : Passed - Multiple Question Group Selection is successful...");
        } else {
            ConsoleLogger.SuccessLog("Test cases : Passed - Multiple Question Group Selection is NOT successful...!!");
            LoggerUtility.LoggerCall("Test cases : Passed - Multiple Question Group Selection is NOT successful...!!");
        }
    }

    //click on hover
    public void hover() {
        //Hover any item and check
        List<WebElement> list_Question_Groups = BrowserInitHelper.getInstance().findElements(By.xpath(buildModePage.getBuild_First_Item_Question_Groups_List()));

        for (int i = 0; i < list_Question_Groups.size(); i++) {
            WebElement item = list_Question_Groups.get(i);
            String text = list_Question_Groups.get(i).getText().trim();

            //Hover item
            Actions action = new Actions(BrowserInitHelper.getInstance());
            action.moveToElement(item).build().perform();

            //Verify Hover

            BrowserInitHelper.getWaiter().until(ExpectedConditions.visibilityOfElementLocated(By.xpath(buildModePage.getBuild_Question_Group_Hover())));
            String hoverText = BrowserInitHelper.getInstance().findElement(By.xpath(buildModePage.getBuild_Question_Group_Hover())).getText().trim();
            System.out.println("hoverText ==>" + hoverText);
            if (hoverText.equalsIgnoreCase(text)) {
                check_Hover = true;
                break;
            }

        }

    }

    //validate Hover
    public void verifyHover() {
        if (check_Hover) {
            ConsoleLogger.SuccessLog("Test cases : Passed - Hover Text is verified for Question Group.....");
            LoggerUtility.LoggerCall("Test cases : Passed - Hover Text is verified for Question Group.....");
        } else {
            ConsoleLogger.FailedTestCase("Test cases : Failed - Test cases : Passed - Hover Text is NOT verified for Question Group.....!!");
            LoggerUtility.LoggerCall("Test cases : Failed - Test cases : Passed - Hover Text is NOT verified for Question Group.....!!");
        }
    }

    //click on searchQuestion group
    public void searchQuestionGroups() {
        List<WebElement> list_Question_Groups = BrowserInitHelper.getInstance().findElements(By.xpath(buildModePage.getBuild_First_Item_Question_Groups_List()));

        for (int i = 0; i < list_Question_Groups.size(); i++) {
            if (i < 1) {
                //Get First Option Text and search it and click
                String Question_Group = list_Question_Groups.get(i).getText().trim();

                //Search
                scrollIntoView(buildModePage.getBuild_First_Item_Question_Groups_Search());
                DriverHelper.sendKeysXpath(buildModePage.getBuild_First_Item_Question_Groups_Search(), Question_Group);
                check_Question_Group_Selection = select_QuestionGroups_Item(buildModePage.getBuild_First_Item_Question_Groups_List(), 1, buildModePage.getBuild_Save_CheckMark());

                //Get First Value in list
                List<WebElement> list_Question_Groups_after_search = BrowserInitHelper.getInstance().findElements(By.xpath(buildModePage.getBuild_First_Item_Question_Groups_List()));
                for (int j = 0; j < list_Question_Groups_after_search.size(); j++) {
                    if (j < 1) {
                        String first_element_after_search = list_Question_Groups_after_search.get(j).getText().trim();
                        if (first_element_after_search.equalsIgnoreCase(Question_Group)) {
                            ConsoleLogger.SuccessLog("Test cases : Passed - Question Group selection After Search - is successful.....!!");
                            LoggerUtility.LoggerCall("Test cases : Passed - Question Group selection After Search - is successful.....!!");
                            check_Question_Group_Search = true;
                            select_QuestionGroups_Item(buildModePage.getBuild_First_Item_Question_Groups_List(), 1, buildModePage.getBuild_Save_CheckMark());
                        } else {
                            ConsoleLogger.FailedTestCase("Test cases : Failed - Question Group selection After Search - is NOT successful.....!!");
                            LoggerUtility.LoggerCall("Test cases : Failed - Question Group selection After Search - is NOT successful.....!!");
                        }
                    }
                }
            }
            break;
        }

        //BrowserInitHelper.getInstance().findElement(By.xpath(pom_Buildmode.getBuild_First_Item_Question_Groups_Search())).clear();
        DriverHelper.waitFluentByXPath(BrowserInitHelper.getInstance(), buildModePage.getBuild_First_Item_Question_Groups_Button());
        DriverHelper.clickXpath(buildModePage.getBuild_First_Item_Question_Groups_Button());
        DriverHelper.clickXpath(buildModePage.getBuild_First_Item_Question_Groups_Button());

    }

    //validate Search
    public void verifySearch() {
        if (check_Question_Group_Search) {
            ConsoleLogger.SuccessLog("Test cases : Passed - Question Group Search - is successful.....!!");
            LoggerUtility.LoggerCall("Test cases : Passed - Question Group Search - is successful.....!!");
        } else {
            ConsoleLogger.FailedTestCase("Test cases : Failed - Question Group Search - is NOT successful.....!!");
            LoggerUtility.LoggerCall("Test cases : Failed - Question Group Search - is NOT successful.....!!");
        }
    }

    //click search and add new
    public void searchAndAddNew() {
        try {
            DriverHelper.waitFluentByXPath(BrowserInitHelper.getInstance(), buildModePage.getBuild_First_Item_Question_Groups_Search());
        } catch (Exception e) {
            System.out.println("Exception Handled ");
        }

        scrollIntoView(buildModePage.getBuild_First_Item_Question_Groups_Search());
        String questionGroupName = csvDataReaderBuildModeQuestionGroups.getNew_Question_Group() + getCurrentTimeStamp();
        //DriverHelper.sendKeysXpath(pom_Buildmode.getBuild_First_Item_Question_Groups_Search(), csvDataReaderBuildModeQuestionGroups.getNew_Question_Group());
        DriverHelper.sendKeysXpath(buildModePage.getBuild_First_Item_Question_Groups_Search(), questionGroupName);

        int size = 0;


        List<WebElement> list_Question_Groups = BrowserInitHelper.getInstance().findElements(By.xpath(buildModePage.getBuild_First_Item_Question_Groups_List()));
        size = list_Question_Groups.size();

        for (int i = 0; i < list_Question_Groups.size(); i++) {
            String question_Group = list_Question_Groups.get(i).getText().trim();

            //if (question_Group.equalsIgnoreCase(csvDataReaderBuildModeQuestionGroups.getNew_Question_Group())) {
            if (question_Group.equalsIgnoreCase(questionGroupName)) {
                logger.info("Text searched is already present in list.....");
                break;
            } else {
                check_New_Question_Group_Add = true;
            }
        }

        if (size == 0) {
            logger.info("No value present in list, can proceed to create new question group.....");
            check_New_Question_Group_Add = true;
        }

        System.out.println("check_New_Question_Group_Add ==>" + check_New_Question_Group_Add);
        if (check_New_Question_Group_Add) {
            //Press Enter Key
            BrowserInitHelper.getInstance().findElement(By.xpath(buildModePage.getBuild_First_Item_Question_Groups_Search())).sendKeys(Keys.ENTER);
            check_New_Question_Group_Add = check_DataCircle(csvDataReaderBuildModeQuestionGroups.getNew_Question_Group());
        }

        logger.info("Exception handled for method - e_SearchAndAddNew");

    }

    //validate add new question group
    public void verifyAddNewQuestionGroup() {
        if (check_New_Question_Group_Add) {
            ConsoleLogger.SuccessLog("Test cases : Passed - New Question Group is added......");
            LoggerUtility.LoggerCall("Test cases : Passed - New Question Group is added......");
        } else {
            ConsoleLogger.FailedTestCase("Test cases : Failed - New Question Group is NOT added......!!");
            LoggerUtility.LoggerCall("Test cases : Failed - New Question Group is NOT added......!!");
        }
    }

    //click on UnSelect New QuestionGroup
    public void unSelectNewQuestionGroup() {
        if (check_New_Question_Group_Add) {
            //UnSelect New Question Group
            boolean uncheck_New_Question_Group = Uncheck_DataCircle(csvDataReaderBuildModeQuestionGroups.getNew_Question_Group(), buildModePage.getBuild_Save_CheckMark());
            if (uncheck_New_Question_Group) {
                ConsoleLogger.SuccessLog("Test cases : Passed - New Question Group is unselected......");
                LoggerUtility.LoggerCall("Test cases : Passed - New Question Group is unselected......");
            } else {
                ConsoleLogger.FailedTestCase("Test cases : Failed - New Question Group is NOT unselected......");
                LoggerUtility.LoggerCall("Test cases : Failed - New Question Group is NOT unselected......");
            }
        } else {
            ConsoleLogger.FailedTestCase("Test cases : Failed - New Question Group is NOT added......!!");
            LoggerUtility.LoggerCall("Test cases : Failed - New Question Group is NOT added......!!");
        }
    }

    //validate Question Group
    public void verifyQuestionGroup() {
        DriverHelper.waitFluentByXPath(BrowserInitHelper.getInstance(), buildModePage.getBuild_First_Item_Question_Groups_Button());
        DriverHelper.clickXpath(buildModePage.getBuild_First_Item_Question_Groups_Button());
        DriverHelper.clickXpath(buildModePage.getBuild_First_Item_Question_Groups_Button());
        DriverHelper.sendKeysXpath(buildModePage.getBuild_First_Item_Question_Groups_Search(), csvDataReaderBuildModeQuestionGroups.getNew_Question_Group());
        BrowserInitHelper.getInstance().findElement(By.xpath(buildModePage.getBuild_First_Item_Question_Groups_Search())).sendKeys(Keys.ENTER);

        //Check List size after pressing Enter Key
        List<WebElement> list_Question_Groups = BrowserInitHelper.getInstance().findElements(By.xpath(buildModePage.getBuild_First_Item_Question_Groups_List()));
        int size = list_Question_Groups.size();
        boolean check_group = false;

        for (int i = 0; i < list_Question_Groups.size(); i++) {
            String question_Group = list_Question_Groups.get(i).getText().trim();
            int count = 0;

            if (question_Group.equalsIgnoreCase(csvDataReaderBuildModeQuestionGroups.getNew_Question_Group())) {
                count++;
            }

            if (count > 1) {
                check_group = true;
            }

            if (size > 1 && check_group) {
                ConsoleLogger.FailedTestCase("Test cases : Failed - Duplicate Question group is displayed....!!!");
                LoggerUtility.LoggerCall("Test cases : Failed - Duplicate Question group is displayed....!!!");
            } else {
                ConsoleLogger.SuccessLog("Test cases : Passed - Duplicate Question group is NOT displayed....");
                LoggerUtility.LoggerCall("Test cases : Passed - Duplicate Question group is NOT displayed....");
            }
        }
        logger.info("Exception handled for method - v_VerifyQuestionGroup");

    }

    //click search and enter
    public void searchAndEnter() {
        //Search Existing question group
        DriverHelper.waitFluentByXPath(BrowserInitHelper.getInstance(), buildModePage.getBuild_First_Item_Question_Groups_Button());
        DriverHelper.clickXpath(buildModePage.getBuild_First_Item_Question_Groups_Button());
        DriverHelper.clickXpath(buildModePage.getBuild_First_Item_Question_Groups_Button());
        DriverHelper.sendKeysXpath(buildModePage.getBuild_First_Item_Question_Groups_Search(), csvDataReaderBuildModeQuestionGroups.getNew_Question_Group());

        //Check tick mark before
        check_New_Question_Group_Add = check_DataCircle(csvDataReaderBuildModeQuestionGroups.getNew_Question_Group());
        BrowserInitHelper.getInstance().findElement(By.xpath(buildModePage.getBuild_First_Item_Question_Groups_Search())).sendKeys(Keys.ENTER);

        //Check tick mark after pressing Enter
        //Check Data Circle again
        boolean check_After_EnterKey = check_DataCircle(csvDataReaderBuildModeQuestionGroups.getNew_Question_Group());
        if (check_New_Question_Group_Add == check_After_EnterKey) {
            ConsoleLogger.DebugLog("On Press of Enter Key, Question group is NOT Selected or UnSelected...!!");
        } else {
            check_SearchUsingEnter = true;
            ConsoleLogger.SuccessLog("Test cases : Passed - On Press of Enter Key, Question group is Selected or UnSelected...!!");
            LoggerUtility.LoggerCall("Test cases : Passed - On Press of Enter Key, Question group is Selected or UnSelected...!!");
        }

        logger.info("Exception handled for method - e_SearchAndEnter");
    }

    //validate Search Using EnterKey
    public void verifySearchUsingEnterKey() {
        if (check_SearchUsingEnter) {
            ConsoleLogger.SuccessLog("Test cases : Passed - Search Using Enter Key is successful...");
            LoggerUtility.LoggerCall("Test cases : Passed - Search Using Enter Key is successful...");
        } else {
            ConsoleLogger.DebugLog("Search Using Enter Key is NOT successful...!!");
        }
    }

    //search Upper And LowerCase
    public void searchUpperAndLowerCase() {
        //Search existing question group using Lower case
        DriverHelper.waitFluentByXPath(BrowserInitHelper.getInstance(), buildModePage.getBuild_First_Item_Question_Groups_Button());
        DriverHelper.clickXpath(buildModePage.getBuild_First_Item_Question_Groups_Button());
        DriverHelper.clickXpath(buildModePage.getBuild_First_Item_Question_Groups_Button());

        BrowserInitHelper.getWaiter().until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath(buildModePage.getBuild_First_Item_Question_Groups_List())));
        List<WebElement> list_Question_Groups = BrowserInitHelper.getInstance().findElements(By.xpath(buildModePage.getBuild_First_Item_Question_Groups_List()));
        System.out.println("list_Question_Groups SIZE ==>" + list_Question_Groups.size());

        for (int i = 0; i < list_Question_Groups.size(); i++) {
            String question_Group = list_Question_Groups.get(i).getText().trim();
            System.out.println("question_Group ==>" + question_Group);
            System.out.println("i - Value ==>" + i);

            int length = question_Group.length();
            boolean check = false;

            for (int j = 0; j < length; j++) {
                if (Character.isUpperCase(question_Group.charAt(j))) {
                    logger.info("Value has upper case letter");
                    toCheck_Case = question_Group;
                    check = true;
                    break;
                }
            }
            if (check) {
                break;
            }
        }

        String Lowercase = toCheck_Case.toLowerCase();
        System.out.println("Lowercase ==>" + Lowercase);
        DriverHelper.sendKeysXpath(buildModePage.getBuild_First_Item_Question_Groups_Search(), Lowercase);

        //Check display of toCheck_Case
        check_SearchByCase = checkDisplay("//div[@class='v-menu__content theme--light menuable__content__active x-multiselect__menu']//span[@class='x-multiselect__item__label' and text()='" + toCheck_Case + "']");

        logger.info("Exception handled for method - e_SearchUpperAndLowerCase");
    }

    //validate search by case
    public void verifySearchByCase() {
        if (check_SearchByCase) {
            ConsoleLogger.SuccessLog("Test cases : Passed - Search By Case is successful.....");
            LoggerUtility.LoggerCall("Test cases : Passed - Search By Case is successful.....");
        } else {
            ConsoleLogger.SuccessLog("Test cases : Passed - Search By Case is NOT successful.....!!");
            LoggerUtility.LoggerCall("Test cases : Passed - Search By Case is NOT successful.....!!");
        }
    }

    //search on passage meta data
    public void searchPassageMetadata() {
        //Search by Passage Metadata
        DriverHelper.waitFluentByXPath(BrowserInitHelper.getInstance(), buildModePage.getBuild_First_Item_Question_Groups_Button());
        DriverHelper.clickXpath(buildModePage.getBuild_First_Item_Question_Groups_Button());
        DriverHelper.clickXpath(buildModePage.getBuild_First_Item_Question_Groups_Button());

        //Passage MetaData
        DriverHelper.sendKeysXpath(buildModePage.getBuild_First_Item_Question_Groups_Search(), csvDataReaderBuildModeQuestionGroups.getPassage_MetaData());
        BrowserInitHelper.getInstance().findElement(By.xpath(buildModePage.getBuild_First_Item_Question_Groups_Search())).sendKeys(Keys.ENTER);

        //Check display of added passage metadata
        check_passage_Metadata = checkDisplay("//div[@class='v-menu__content theme--light menuable__content__active x-multiselect__menu']//span[@class='x-multiselect__item__label' and text()='" + csvDataReaderBuildModeQuestionGroups.getPassage_MetaData() + "']");
        if (check_passage_Metadata) {
            ConsoleLogger.SuccessLog("Test cases : Passed - Passage MetaData is added in Question Group...!!");
            LoggerUtility.LoggerCall("Test cases : Passed - Passage MetaData is added in Question Group...!!");
        } else {
            //Pass test case here
            ConsoleLogger.SuccessLog("Test cases : Passed - Passage MetaData is NOT added in Question Group and verified....");
            LoggerUtility.LoggerCall("Test cases : Passed - Passage MetaData is NOT added in Question Group and verified....");
        }

    }

    //click on Dok
    public void removeDOKAlignmentForItem() {
        try {
            DriverHelper.waitFluentByXPath(BrowserInitHelper.getInstance(), buildModePage.getNavigateToBrowse());
            DriverHelper.clickXpath(buildModePage.getNavigateToBrowse());
            DriverHelper.waitFluentByXPath(BrowserInitHelper.getInstance(), browseModePage.getBrowse_ItemSection());
        } catch (Exception e) {
            System.out.println("Exception handled for Page load");
        }

        try {
            DriverHelper.waitFluentByXPath(BrowserInitHelper.getInstance(), buildModePage.getCloseSearch());
            DriverHelper.clickXpath(buildModePage.getCloseSearch());
            DriverHelper.waitFluentByXPath(BrowserInitHelper.getInstance(), buildModePage.getSearchById());
            DriverHelper.sendKeysXpath(buildModePage.getSearchById(), csvDataReaderBuildModeQuestionGroups.getItemID());
            DriverHelper.waitFluentByXPath(BrowserInitHelper.getInstance(), buildModePage.getItemSearch());
            DriverHelper.clickXpath(buildModePage.getItemSearch());
            DriverHelper.waitFluentByXPath(BrowserInitHelper.getInstance(), buildModePage.getAddItems());
            DriverHelper.clickXpath(buildModePage.getAddItems());
            try {
                DriverHelper.waitFluentByXPath(BrowserInitHelper.getInstance(), browseModePage.getSavingMessage());
            } catch (Exception e) {
                System.out.println("Exception Handled for Saving");
            }
            DriverHelper.waitFluentByXPath(BrowserInitHelper.getInstance(), buildModePage.getNavigateToBuild());
            DriverHelper.clickXpath(buildModePage.getNavigateToBuild());
            JavascriptHelper.scrollBottomOfThePage();
            DriverHelper.waitFluentByXPath(BrowserInitHelper.getInstance(), buildModePage.getQuestionGrp());
            DriverHelper.clickXpath(buildModePage.getQuestionGrp());

            DriverHelper.waitFluentByXPath(BrowserInitHelper.getInstance(), buildModePage.getSettingsIcon());
            DriverHelper.clickXpath(buildModePage.getSettingsIcon());
        } catch (
                Exception e) {
            System.out.println("Exception Handled for removeDOKAlignmentForItem ");
        }
        // DriverHelper.clickXpath("//div[@class='v-menu__content theme--light menuable__content__active x-multiselect__menu']//div[@class='x-multiselect__search']//*[local-name()='svg']//*[name()='path' and contains(@fill,'currentCol')]");
    }

    //validate enable and disable
    public void verifyEnableDisableQuestionGroups() {
        try {
            DriverHelper.waitFluentByXPath(BrowserInitHelper.getInstance(), buildModePage.getDisabled());
            boolean disableButton = DriverHelper.checkElementDisplayByXpath(buildModePage.getDisabled(), "DisableButton");
            if (disableButton) {
                ConsoleLogger.SuccessLog("Test cases : Passed - Disabled is verified");
                LoggerUtility.LoggerCall("Test cases : Passed - Disabled is verified");
            } else {
                ConsoleLogger.FailedTestCase("Test cases : Failed - Disabled is not verified");
                LoggerUtility.LoggerCall("Test cases : Failed - Disabled is not verified");
            }
            //BrowserInitHelper.getInstance().findElement(By.cssSelector())
            DriverHelper.waitFluentByXPath(BrowserInitHelper.getInstance(), buildModePage.getToggle());
            DriverHelper.clickXpath(buildModePage.getToggle());
            DriverHelper.waitFluentByXPath(BrowserInitHelper.getInstance(), buildModePage.getEnabled());

            boolean enableButton = DriverHelper.checkElementDisplayByXpath(buildModePage.getDisabled(), "DisableButton");
            if (enableButton) {
                ConsoleLogger.SuccessLog("Test cases : Passed - Enabled is verified");
                LoggerUtility.LoggerCall("Test cases : Passed - Enabled is verified");
            } else {
                ConsoleLogger.FailedTestCase("Test cases : Failed - Enabled is not verified");
                LoggerUtility.LoggerCall("Test cases : Failed - Enabled is not verified");
            }

        } catch (Exception e) {
            System.out.println("Exception handled for Enable and Disable QuestionGroups Button");
        }
    }

}
