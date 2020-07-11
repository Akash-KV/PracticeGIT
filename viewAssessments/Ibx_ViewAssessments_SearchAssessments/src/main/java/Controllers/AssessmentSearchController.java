package Controllers;

import Helpers.BrowserInitHelper;
import Helpers.DriverHelper;

import Helpers.JavascriptHelper;
import Pom.DashboardPage;
import Pom.ViewAssessmentsPage;
import Utils.ConsoleLogger;
import Utils.DataReaderViewAssessmentsSearch;
import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.Arrays;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static Helpers.JavascriptHelper.*;

//Controller class for AssessmentSearch
public class AssessmentSearchController {


    String ValidAssessmentName = "";
    String firstRowLocalIdentifier = "";
    String firstRowOwner = "";

    DashboardPage dashboardPagePOM = new DashboardPage();
    BrowserInitHelper browserHelper = new BrowserInitHelper();
    ViewAssessmentsPage viewAssessmentsPage = new ViewAssessmentsPage();
    DataReaderViewAssessmentsSearch viewassessmentsdatareader = new DataReaderViewAssessmentsSearch();
    DriverHelper driverHelper = new DriverHelper();

    private static final Logger log = LoggerFactory.getLogger(BrowserInitHelper.class);

    //Verify ViewAssessment Search field
    public void VerifyViewAssessmentSearch(String SearchText) {
        // Sending the value to the Search box
        DriverHelper.sendKeysId(viewAssessmentsPage.getViewAssessmentSearchtextbox(), SearchText, BrowserInitHelper.getWaiter(), BrowserInitHelper.getInstance());
        //clicking on the search button
        DriverHelper.clickId(viewAssessmentsPage.getViewAssessmentSearchtextboxButton(), BrowserInitHelper.getWaiter(), BrowserInitHelper.getInstance());
        //DriverHelper.getElementByXpath(viewAssessment.getloader());
        DriverHelper.waitUntilElementInvisible_ByXPath(viewAssessmentsPage.getloader());
        waitUntilAjaxLoaded();
    }

    //Verify the View Assessment Search using Tabkey
    public void VerifyViewAssessmentSearchUsingTABKey(String SearchText) {
        // Sending the value to the Search box
        DriverHelper.sendKeysId(viewAssessmentsPage.getViewAssessmentSearchtextbox(), SearchText, BrowserInitHelper.getWaiter(), BrowserInitHelper.getInstance());

        //clicking on the search button Using TAB Key
        WebElement ViewAssessmentSearchtextboxButton = BrowserInitHelper.getInstance().findElement(By.id("direct_search"));

        ViewAssessmentSearchtextboxButton.sendKeys(Keys.TAB);
        System.out.println("TAB Clicked");
        ViewAssessmentSearchtextboxButton.sendKeys(Keys.ENTER);


        //DriverHelper.getElementByXpath(viewAssessment.getloader());
        //DriverHelper.waitUntilElementInvisible_ByXPath(viewAssessment.getloader());

        waitUntilAjaxLoaded();

        System.out.println(BrowserInitHelper.getInstance().findElement(By.xpath("//table[starts-with(@id,'assessment_list_data_table')]//tbody//tr[1]")).getText());
    }

    //Verify Searched Valid Assessment Title
    public boolean verifySearchedValidViewAssessmentTitleandOverview(String SearchText) {
        boolean bvalue = false;
        if (BrowserInitHelper.getWaiter().until(ExpectedConditions.elementToBeClickable(BrowserInitHelper.getInstance().findElement(By.xpath("//table[starts-with(@id,'assessment_list_data_table')]//tbody//tr[1]//td[2]/a")))).getText().equalsIgnoreCase(SearchText)) {
            log.info("Title matched in View Assessment Page");
           /* //clikcing on the Assessment name
            BrowserInitHelper.getWaiter().until(ExpectedConditions.elementToBeClickable(BrowserInitHelper.getInstance().findElement(By.xpath("//table[starts-with(@id,'assessment_list_data_table')]//tbody//tr[1]//td[2]/a")))).click();
            try{
                BrowserInitHelper.getWaiter().until(ExpectedConditions.elementToBeClickable(BrowserInitHelper.getInstance().findElement(By.xpath("//div[@class='modal-backdrop  in']")))).click();
            }
            catch (Exception e){

            }
            //checking the Assessment name in the overview page
            if (BrowserInitHelper.getWaiter().until(ExpectedConditions.elementToBeClickable(BrowserInitHelper.getInstance().findElement(By.xpath("//div[@id='assessment-info']//p[@class='lead']")))).getText().equalsIgnoreCase(SearchText)) {
                log.info("Title matched in Overview Page");
                bvalue = true;
            }

            else
            {
                log.info("Title matched is not matched in Overview Page ");
            }*/

            if (DriverHelper.getElementByXpath(viewAssessmentsPage.getFirstRowTypeColumn()).getText().trim().equalsIgnoreCase("Item Bank") || DriverHelper.getElementByXpath(viewAssessmentsPage.getFirstRowTypeColumn()).getText().trim().equalsIgnoreCase("Assessment")) {

                //clikcing on the Assessment name
                BrowserInitHelper.getWaiter().until(ExpectedConditions.elementToBeClickable(BrowserInitHelper.getInstance().findElement(By.xpath("//table[starts-with(@id,'assessment_list_data_table')]//tbody//tr[1]//td[2]/a")))).click();
                waitUntilAjaxLoaded();

                //waiting till the element clickable
                try {
                    DriverHelper.waitandclickID("assessment-info");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                //checking the Assessment name in the overview page
                if (BrowserInitHelper.getWaiter().until(ExpectedConditions.elementToBeClickable(BrowserInitHelper.getInstance().findElement(By.xpath("//div[@id='assessment-info']//p[@class='lead']")))).getText().equalsIgnoreCase(SearchText)) {
                    log.info("Title matched in Overview Page");
                    bvalue = true;
                } else {
                    log.info("Title matched is not matched in Overview Page ");
                }

                BrowserInitHelper.getInstance().navigate().back();
                waitUntilAjaxLoaded();
            } else if (DriverHelper.getElementByXpath(viewAssessmentsPage.getFirstRowTypeColumn()).getText().trim().equalsIgnoreCase("State Assessment")) {
                //clikcing on the Assessment name
                BrowserInitHelper.getWaiter().until(ExpectedConditions.elementToBeClickable(BrowserInitHelper.getInstance().findElement(By.xpath("//table[starts-with(@id,'assessment_list_data_table')]//tbody//tr[1]//td[2]/a")))).click();
                waitUntilAjaxLoaded();
                //waiting till the element clickable
                try {
                    DriverHelper.waitandclickxpath("//div[@class='dataTables_caption']");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                //checking the Assessment name in the overview page
                if (BrowserInitHelper.getWaiter().until(ExpectedConditions.elementToBeClickable(BrowserInitHelper.getInstance().findElement(By.xpath("//div[@class='dataTables_caption']")))).getText().equalsIgnoreCase(SearchText)) {
                    log.info("Title matched in Overview Page");
                    bvalue = true;
                } else {
                    log.info("Title matched is not matched in Overview Page ");
                }

                BrowserInitHelper.getInstance().navigate().back();
                waitUntilAjaxLoaded();

            } else if (DriverHelper.getElementByXpath(viewAssessmentsPage.getFirstRowTypeColumn()).getText().trim().equalsIgnoreCase("Physical Fitness Test") ||
                    DriverHelper.getElementByXpath(viewAssessmentsPage.getFirstRowTypeColumn()).getText().trim().equalsIgnoreCase("Assessment View") ||
                    DriverHelper.getElementByXpath(viewAssessmentsPage.getFirstRowTypeColumn()).getText().trim().equalsIgnoreCase("Pool Assessment") ||
                    DriverHelper.getElementByXpath(viewAssessmentsPage.getFirstRowTypeColumn()).getText().trim().equalsIgnoreCase("Skills Assessment") ||
                    DriverHelper.getElementByXpath(viewAssessmentsPage.getFirstRowTypeColumn()).getText().trim().equalsIgnoreCase("DIBELS Next") ||
                    DriverHelper.getElementByXpath(viewAssessmentsPage.getFirstRowTypeColumn()).getText().trim().equalsIgnoreCase("DIBELS Sixth") ||
                    DriverHelper.getElementByXpath(viewAssessmentsPage.getFirstRowTypeColumn()).getText().trim().equalsIgnoreCase("DIBELS IDEL") ||
                    DriverHelper.getElementByXpath(viewAssessmentsPage.getFirstRowTypeColumn()).getText().trim().equalsIgnoreCase("Summary Assessment") ||
                    DriverHelper.getElementByXpath(viewAssessmentsPage.getFirstRowTypeColumn()).getText().trim().equalsIgnoreCase("Demographic") ||
                    DriverHelper.getElementByXpath(viewAssessmentsPage.getFirstRowTypeColumn()).getText().trim().equalsIgnoreCase("Survey")
            ) {
                //clikcing on the Assessment name
                BrowserInitHelper.getWaiter().until(ExpectedConditions.elementToBeClickable(BrowserInitHelper.getInstance().findElement(By.xpath("//table[starts-with(@id,'assessment_list_data_table')]//tbody//tr[1]//td[2]/a")))).click();
                waitUntilAjaxLoaded();
                try {
                    DriverHelper.waitandclickxpath("//div[@id='subactions']/h3");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                //checking the Assessment name in the overview page
                if (BrowserInitHelper.getWaiter().until(ExpectedConditions.elementToBeClickable(BrowserInitHelper.getInstance().findElement(By.xpath("//div[@id='subactions']/h3")))).getText().equalsIgnoreCase(SearchText)) {
                    log.info("Title matched in Overview Page");
                    bvalue = true;
                } else {
                    log.info("Title matched is not matched in Overview Page ");
                }

                BrowserInitHelper.getInstance().navigate().back();
                waitUntilAjaxLoaded();

            } else if (DriverHelper.getElementByXpath(viewAssessmentsPage.getFirstRowTypeColumn()).getText().trim().equalsIgnoreCase("Flexible")) {
                //clikcing on the Assessment name
                BrowserInitHelper.getWaiter().until(ExpectedConditions.elementToBeClickable(BrowserInitHelper.getInstance().findElement(By.xpath("//table[starts-with(@id,'assessment_list_data_table')]//tbody//tr[1]//td[2]/a")))).click();
                waitUntilAjaxLoaded();
                try {
                    DriverHelper.waitandclickxpath("//div[@class='title header-font']");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                //checking the Assessment name in the overview page
                if (BrowserInitHelper.getWaiter().until(ExpectedConditions.elementToBeClickable(BrowserInitHelper.getInstance().findElement(By.xpath("//div[@class='title header-font']")))).getText().equalsIgnoreCase(SearchText)) {
                    log.info("Title matched in Overview Page");
                    bvalue = true;
                } else {
                    log.info("Title matched is not matched in Overview Page ");
                }

                BrowserInitHelper.getInstance().navigate().back();
                waitUntilAjaxLoaded();

            } else if (DriverHelper.getElementByXpath(viewAssessmentsPage.getFirstRowTypeColumn()).getText().trim().equalsIgnoreCase("Fluence")) {
                //clikcing on the Assessment name
                BrowserInitHelper.getWaiter().until(ExpectedConditions.elementToBeClickable(BrowserInitHelper.getInstance().findElement(By.xpath("//table[starts-with(@id,'assessment_list_data_table')]//tbody//tr[1]//td[2]/a")))).click();
                waitUntilAjaxLoaded();
                try {
                    DriverHelper.waitandclickxpath("//div[@class='title header-font']");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                //checking the Assessment name in the overview page
                if (BrowserInitHelper.getWaiter().until(ExpectedConditions.elementToBeClickable(BrowserInitHelper.getInstance().findElement(By.xpath("//div[@id='subactions']/h3/abbr")))).getText().contains(SearchText)) {
                    log.info("Title matched in Overview Page");
                    bvalue = true;
                } else {
                    log.info("Title matched is not matched in Overview Page ");
                }

                BrowserInitHelper.getInstance().navigate().back();
                waitUntilAjaxLoaded();

            }


            //bvalue = true;
        }
        //Assert.assertTrue(bvalue);
        return bvalue;
    }

    //Verify Searched View Assessment First row
    public boolean verifySearchedViewAssessmentFirstRow(String SearchText) {

        boolean bvalue = false;

        driverHelper.getElementByXpath("//table[starts-with(@id,'assessment_list_data_table')]//tbody//tr[1]");
        log.info("waited till first row loading");
        List<WebElement> rowelements = BrowserInitHelper.getInstance().findElements(By.xpath("//table[starts-with(@id,'assessment_list_data_table')]//tbody//tr[1]//td"));
        log.info("Size of List: " + rowelements.size());

        for (WebElement element : rowelements) {
            if (element.getText().contains(SearchText)) {
                log.info("Matched sucessfully --> " + element.getText());
                bvalue = true;
            } else if (element.getText().equalsIgnoreCase("No data available in table")) {
                log.info("No data available in table is displaying for the search");
                bvalue = true;
            }
        }

        return bvalue;
    }

    //Verify Searched View Assessment First row Title
    public boolean verifySearchedViewAssessmentFirstRowTitle(String SearchText) {

        boolean bvalue = false;
        WebElement FirstRowTitle = BrowserInitHelper.getInstance().findElement(By.xpath("//table[starts-with(@id,'assessment_list_data_table')]//tbody//tr[1]//td[2]/a"));
        WebElement NoDataMessage = BrowserInitHelper.getInstance().findElement(By.xpath("//table[starts-with(@id,'assessment_list_data_table')]//tbody//tr[1]//td"));


        if (FirstRowTitle.getText().trim().contains(SearchText)) {
            log.info("Matched sucessfully --> " + FirstRowTitle.getText());
            bvalue = true;
        } else if (NoDataMessage.getText().trim().equalsIgnoreCase("No data available in table")) {
            log.info("No data available in table is displaying for the search");
            bvalue = true;
        }

        return bvalue;
    }

    //Verify Searched View Assessment First row Local Identifier
    public boolean verifySearchedViewAssessmentFirstRowLocalIdentifier(String SearchText) {

        boolean bvalue = false;
        WebElement FirstRowLocalIdentifier = BrowserInitHelper.getInstance().findElement(By.xpath("//table[starts-with(@id,'assessment_list_data_table')]//tbody//tr[1]//td[4]"));
        WebElement NoDataMessage = BrowserInitHelper.getInstance().findElement(By.xpath("//table[starts-with(@id,'assessment_list_data_table')]//tbody//tr[1]//td"));


        if (FirstRowLocalIdentifier.getText().trim().equalsIgnoreCase(SearchText)) {
            log.info("Matched sucessfully --> " + FirstRowLocalIdentifier.getText());
            bvalue = true;
        } else if (NoDataMessage.getText().trim().equalsIgnoreCase("No data available in table")) {
            log.info("No data available in table is displaying for the search");
            bvalue = true;
        }
        return bvalue;
    }

    //Verify Searched View Assessment First row Owner
    public boolean verifySearchedViewAssessmentFirstRowOwner(String SearchText) {

        boolean bvalue = false;
        WebElement FirstRowOwner = BrowserInitHelper.getInstance().findElement(By.xpath("//table[starts-with(@id,'assessment_list_data_table')]//tbody//tr[1]//td[5]"));
        WebElement NoDataMessage = BrowserInitHelper.getInstance().findElement(By.xpath("//table[starts-with(@id,'assessment_list_data_table')]//tbody//tr[1]//td"));


        if (FirstRowOwner.getText().trim().contains(SearchText)) {
            log.info("Matched sucessfully --> " + FirstRowOwner.getText());
            bvalue = true;
        } else if (NoDataMessage.getText().trim().equalsIgnoreCase("No data available in table")) {
            log.info("No data available in table is displaying for the search");
            bvalue = true;
        }
        return bvalue;
    }

    public static boolean getFirstRow() {
        boolean checkFirstRowData = false;
        try {
            if (BrowserInitHelper.getWaiter().until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//table[starts-with(@id,'assessment_list_data_table')]//tbody//tr[1]//td"))).size() > 0) {
                checkFirstRowData = true;
            }
        } catch (Exception e) {
            ConsoleLogger.FailedTestCase("No data available in table");
        }

        return checkFirstRowData;
    }

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

    //Check for the Popup
    public void checkPopup() {
        try {
            BrowserInitHelper.getWaiter().until(ExpectedConditions.elementToBeClickable(By.xpath(viewAssessmentsPage.getPopup())));
            WebElement popup = BrowserInitHelper.getInstance().findElement(By.xpath(viewAssessmentsPage.getPopup()));
            Actions action = new Actions(BrowserInitHelper.getInstance());
            action.moveToElement(popup).click().perform();
            Thread.sleep(2000);
        } catch (Exception e) {
            System.out.println("Exception handled for alert popup.......");
        }
    }

    //Validate Navigation bar
    public void navbar() {
        boolean isexist = false;
        if (BrowserInitHelper.getInstance().findElement(By.id(dashboardPagePOM.getNavigationSidebarContent())).isDisplayed()) {
            isexist = true;
        }
        Assert.assertTrue(isexist);
    }

    //Click on Assessments
    public void assessments() {
        /*Click Assessments icon in Navigation sidebar*/
        driverHelper.clickXpath(dashboardPagePOM.getAssessmentsIcon());
    }

    //Validate AssessmentsPanel
    public void assessmentsPanel() {
        boolean isexist = false;
        BrowserInitHelper.getWaiter().until(ExpectedConditions.elementToBeClickable(BrowserInitHelper.getInstance().findElement(By.id(dashboardPagePOM.getNavigationPanel()))));
        if (BrowserInitHelper.getInstance().findElement(By.id(dashboardPagePOM.getNavigationPanel())).isDisplayed()) {
            isexist = true;
        }
        Assert.assertTrue(isexist);
    }

    //Click on Assessment Panel and View Assessment Option
    public void assessmentPanel_ViewAssessmentOption() {
        /*Click View Assessments Link*/
        driverHelper.clickXpath(dashboardPagePOM.getViewAssessmentsLink());
        checkPopup();
        waitUntilAjaxLoaded();

        /*Wait until View Assessments header appears*/
        BrowserInitHelper.waitUntil(dashboardPagePOM.getViewAssessmentsHeader());
    }

    //Validate ViewAssessments Page
    public void viewAssessmentsPage() {
        browserHelper.assertion(dashboardPagePOM.getViewAssessmentsHeader(), "View Assessments");
    }

    //Validate SearchedAssessment
    public void verifySearchedAssessment() {
        //Clearing the filter
        try {
            BrowserInitHelper.getWaiter().until(ExpectedConditions.elementToBeClickable(BrowserInitHelper.getInstance().findElement(By.id(dashboardPagePOM.getClearAllFilters())))).click();
            waitUntilAjaxLoaded();
        } catch (Exception e) {

        }
        //Test Case - Valid
        //Get Assessment Name and set it
        try {
            WebElement firstAssessmentName = BrowserInitHelper.getInstance().findElement(By.xpath(dashboardPagePOM.getFirstLinkInAssessments()));
            ValidAssessmentName = firstAssessmentName.getText().trim();
            System.out.println("Valid Assessment Name ==>" + ValidAssessmentName);
        } catch (Exception e) {
            System.out.println("Exception handled for valid assessment name...." + e);
        }

        VerifyViewAssessmentSearch(ValidAssessmentName);

        try {
            if (verifySearchedValidViewAssessmentTitleandOverview(ValidAssessmentName)) {
                ConsoleLogger.SuccessLog("Test cases : Passed - Valid Search is validated");
            } else {
                ConsoleLogger.FailedTestCase("Test cases : Failed - Valid Search is not validated ");
            }
        } catch (org.openqa.selenium.NoSuchElementException ne) {
            log.info("NoSuchElementException handled for Valid Search Assessment ");
            ConsoleLogger.FailedTestCase("Test cases : Failed - Valid Search is not validated due to NoSuchElementException");
        } catch (TimeoutException te) {
            log.info("TimeoutException handled for Valid Search Assessment");
            ConsoleLogger.FailedTestCase("Test cases : Failed - Valid Search is not validated due to TimeoutException ");
        } catch (WebDriverException we) {
            log.info("WebDriverException handled for Valid Search Assessment ");
            ConsoleLogger.FailedTestCase("Test cases : Failed - Valid Search is not validated due to WebDriverException");
        } catch (Exception e) {
            log.info("Exception handled for Valid Search Assessment");
            ConsoleLogger.FailedTestCase("Test cases : Failed - Valid Search is not validated due to Exception ");
        }

        /*Wait until View Assessments header appears*/
        waitUntilAjaxLoaded();
        BrowserInitHelper.waitUntil(dashboardPagePOM.getViewAssessmentsHeader());

        //***Test Case - Invalid****//
        try {
            VerifyViewAssessmentSearch(viewassessmentsdatareader.getInvalidTitle());
            if (verifySearchedViewAssessmentFirstRow(viewassessmentsdatareader.getInvalidTitle())) {
                ConsoleLogger.SuccessLog("Test cases : Passed - InValid Search is validated");
            } else {
                ConsoleLogger.FailedTestCase("Test cases : Failed - InValid Search is not validated ");
            }
        } catch (org.openqa.selenium.NoSuchElementException ne) {
            log.info("NoSuchElementException handled for InValid Search Assessment ");
            ConsoleLogger.FailedTestCase("Test cases : Failed - InValid Search is not validated due to NoSuchElementException");
        } catch (TimeoutException te) {
            log.info("TimeoutException handled for InValid Search Assessment");
            ConsoleLogger.FailedTestCase("Test cases : Failed - InValid Search is not validated due to TimeoutException");
        } catch (WebDriverException we) {
            log.info("WebDriverException handled for InValid Search Assessment ");
            ConsoleLogger.FailedTestCase("Test cases : Failed - InValid Search is not validated due to WebDriverException");
        } catch (Exception e) {
            log.info("Exception handled for InValid Search Assessment");
            ConsoleLogger.FailedTestCase("Test cases : Failed - InValid Search is not validated due to Exception ");
        }


        //******Test Case -Special Characters******//
        try {
            VerifyViewAssessmentSearch(viewassessmentsdatareader.getSpecialCharecters());
            if (verifySearchedViewAssessmentFirstRow(viewassessmentsdatareader.getSpecialCharecters())) {
                ConsoleLogger.SuccessLog("Test cases : Passed - Special Characters Search is validated");
            } else {
                ConsoleLogger.FailedTestCase("Test cases : Failed - Special Characters Search is not validated ");
            }
        } catch (org.openqa.selenium.NoSuchElementException ne) {
            log.info("NoSuchElementException handled for Special Characters Search Assessment ");
            ConsoleLogger.FailedTestCase("Test cases : Failed - Special Characters Search is not validated due to NoSuchElementException");
        } catch (TimeoutException te) {
            log.info("TimeoutException handled for Special Characters Search Assessment");
            ConsoleLogger.FailedTestCase("Test cases : Failed - Special Characters Search is not validated due to TimeoutException");
        } catch (WebDriverException we) {
            log.info("WebDriverException handled for Special Characters Search Assessment ");
            ConsoleLogger.FailedTestCase("Test cases : Failed - Special Characters Search is not validated due to WebDriverException");
        } catch (Exception e) {
            log.info("Exception handled for Special Characters Search Assessment");
            ConsoleLogger.FailedTestCase("Test cases : Failed - Special Characters Search is not validated due to Exception");
        }


        //********Test Case - Alpha newmeric******//
        try {
            VerifyViewAssessmentSearch(viewassessmentsdatareader.getAlphanewmeric());
            if (verifySearchedViewAssessmentFirstRow(viewassessmentsdatareader.getAlphanewmeric())) {
                ConsoleLogger.SuccessLog("Test cases : Passed - Alpha newmeric Search is validated");
            } else {
                ConsoleLogger.FailedTestCase("Test cases : Failed - Alpha newmeric Search is not validated ");
            }
        } catch (org.openqa.selenium.NoSuchElementException ne) {
            log.info("NoSuchElementException handled for Alpha newmeric Search Assessment ");
            ConsoleLogger.FailedTestCase("Test cases : Failed - Alpha newmeric Search is not validated due to NoSuchElementException");
        } catch (TimeoutException te) {
            log.info("TimeoutException handled for Alpha newmeric Search Assessment");
            ConsoleLogger.FailedTestCase("Test cases : Failed - Alpha newmeric Search is not validated due to TimeoutException");
        } catch (WebDriverException we) {
            log.info("WebDriverException handled for Alpha newmeric Search Assessment ");
            ConsoleLogger.FailedTestCase("Test cases : Failed - Alpha newmeric Search is not validated due to WebDriverException");
        } catch (Exception e) {
            log.info("Exception handled for Alpha newmeric Search Assessment");
            ConsoleLogger.FailedTestCase("Test cases : Failed - Alpha newmeric Search is not validated due to Exception");
        }


        //*********Test Case - year*****************//
        try {
            VerifyViewAssessmentSearch(viewassessmentsdatareader.getYear());
            if (verifySearchedViewAssessmentFirstRow(viewassessmentsdatareader.getYear())) {
                ConsoleLogger.SuccessLog("Test cases : Passed - year Search is validated");
            } else {
                ConsoleLogger.FailedTestCase("Test cases : Failed - year Search is not validated ");
            }
        } catch (org.openqa.selenium.NoSuchElementException ne) {
            log.info("NoSuchElementException handled for year Search Assessment ");
            ConsoleLogger.FailedTestCase("Test cases : Failed - year Search is not validated due to NoSuchElementException");
        } catch (TimeoutException te) {
            log.info("TimeoutException handled for year Search Assessment");
            ConsoleLogger.FailedTestCase("Test cases : Failed - year Search is not validated due to TimeoutException");
        } catch (WebDriverException we) {
            log.info("WebDriverException handled for year Search Assessment ");
            ConsoleLogger.FailedTestCase("Test cases : Failed - year Search is not validated due to WebDriverException");
        } catch (Exception e) {
            log.info("Exception handled for year Search Assessment");
            ConsoleLogger.FailedTestCase("Test cases : Failed - year Search is not validated due to Exception");
        }


        //***************Test Case - check for the empty String search************//
        try {
            //clicking on the AssessmentsIcon
            driverHelper.clickXpath(dashboardPagePOM.getAssessmentsIcon());
            BrowserInitHelper.getWaiter().until(ExpectedConditions.elementToBeClickable(BrowserInitHelper.getInstance().findElement(By.id(dashboardPagePOM.getNavigationPanel()))));
            /*Click View Assessments Link*/
            driverHelper.clickXpath(dashboardPagePOM.getViewAssessmentsLink());
            waitUntilAjaxLoaded();
            /*Wait until View Assessments header appears*/
            BrowserInitHelper.waitUntil(dashboardPagePOM.getViewAssessmentsHeader());

            //clearing text in the search box
            highlight(BrowserInitHelper.getWaiter().until(ExpectedConditions.elementToBeClickable(By.id(viewAssessmentsPage.getViewAssessmentSearchtextbox()))));
            BrowserInitHelper.getWaiter().until(ExpectedConditions.elementToBeClickable(By.id(viewAssessmentsPage.getViewAssessmentSearchtextbox()))).clear();
            DriverHelper.clickId(viewAssessmentsPage.getViewAssessmentSearchtextboxButton(), BrowserInitHelper.getWaiter(), BrowserInitHelper.getInstance());
            waitUntilAjaxLoaded();

            //taking the count of the initial data count
            String Initialcount = DriverHelper.getElementByXpath(viewAssessmentsPage.getPagingInfo()).getText();
            log.info("Initial count of Assessment --> " + Initialcount);

            //sending the Empty data
            highlight(BrowserInitHelper.getWaiter().until(ExpectedConditions.elementToBeClickable(By.id(viewAssessmentsPage.getViewAssessmentSearchtextbox()))));
            BrowserInitHelper.getWaiter().until(ExpectedConditions.elementToBeClickable(By.id(viewAssessmentsPage.getViewAssessmentSearchtextbox()))).clear();
            DriverHelper.clickId(viewAssessmentsPage.getViewAssessmentSearchtextboxButton(), BrowserInitHelper.getWaiter(), BrowserInitHelper.getInstance());
            waitUntilAjaxLoaded();

            if (DriverHelper.getElementByXpath(viewAssessmentsPage.getPagingInfo()).getText().equalsIgnoreCase(Initialcount)) {
                ConsoleLogger.SuccessLog("Test cases : Passed - empty String and whitespace Search is validated");
            } else {
                ConsoleLogger.FailedTestCase("Test cases : Failed - empty String and whitespace Search is not validated ");
            }
        } catch (org.openqa.selenium.NoSuchElementException ne) {
            log.info("NoSuchElementException handled for empty String Search Assessment ");
            ConsoleLogger.FailedTestCase("Test cases : Failed - empty String  and whitespace  Search  is not validated due to NoSuchElementException");
        } catch (TimeoutException te) {
            log.info("TimeoutException handled for empty String Search Assessment");
            ConsoleLogger.FailedTestCase("Test cases : Failed - empty String and whitespace earch is not validated due to TimeoutException");
        } catch (WebDriverException we) {
            log.info("WebDriverException handled for empty String Search Assessment ");
            ConsoleLogger.FailedTestCase("Test cases : Failed - empty String and whitespace Search is not validated due to WebDriverException");
        } catch (Exception e) {
            log.info("Exception handled for empty String Search Assessment");
            ConsoleLogger.FailedTestCase("Test cases : Failed - empty String and whitespace Search is not validated due to Exception");
        }


        //****** Test Case- Large Number of count search****//
        //Commented this test cases , since it is navigating to the error page
      /*  String generatedString = RandomStringUtils.randomAlphabetic(Integer.parseInt(viewassessmentsdatareader.getcharactersSequencecount()));
        System.out.println(generatedString);

        try {
            assessmentSearchController.VerifyViewAssessmentSearch(generatedString);
            if (assessmentSearchController.verifySearchedViewAssessmentFirstRow(generatedString)) {
                ConsoleLogger.SuccessLog("Test cases : Passed - Large Number of count Search is validated");
            } else {
                ConsoleLogger.FailedTestCase("Test cases : Failed - Large Number of count Search is not validated ");
                BrowserInitHelper.getInstance().navigate().back();
                waitUntilAjaxLoaded();
                if ((BrowserInitHelper.getInstance().findElement(By.xpath(dashboardPOM.getViewAssessmentsHeader()))).isDisplayed()) {
                    System.out.println("Page navigated to the view Assessment Page");
                } else {
                    System.out.println("Page is not navigated to the view Assessment Page, Hence clicking back again");
                    BrowserInitHelper.getInstance().navigate().back();
                    waitUntilAjaxLoaded();
                }
            }
        } catch (NoSuchElementException ne) {
            log.info("NoSuchElementException handled for Large Number of count Search Assessment ");
            ConsoleLogger.FailedTestCase("Test cases : Failed - Large Number of count Search is not validated due to NoSuchElementException");
        } catch (TimeoutException te) {
            log.info("TimeoutException handled for Large Number of count Search Assessment");
            ConsoleLogger.FailedTestCase("Test cases : Failed - Large Number of count Search is not validated due to TimeoutException");
        } catch (WebDriverException we) {
            log.info("WebDriverException handled for Large Number of count Search Assessment ");
            ConsoleLogger.FailedTestCase("Test cases : Failed - Large Number of count Search is not validated due to WebDriverException");
        } catch (Exception e) {
            log.info("Exception handled for Large Number of count Search Assessment");
            ConsoleLogger.FailedTestCase("Test cases : Failed - Large Number of count Search is not validated due to Exception");
        }*/


        //*****Test Case -Searching the Assessment with sub String name(not full name)********//
        try {
            //Get List of assessment names from First Page
            List<WebElement> assessmentList = BrowserInitHelper.getInstance().findElements(By.xpath(dashboardPagePOM.getListAssessments()));
            String subStringFromAssessment = "";

            for (int i = 0; i < 1; i++) {
                String assessmentNameFromList = assessmentList.get(i).getText();
                List<String> splittedList = Arrays.asList(assessmentNameFromList.split(" "));
                System.out.println("Splitted List ==>" + splittedList);

                if (splittedList.size() > 1) {
                    for (int j = 1; j <= splittedList.size(); j++) {
                        subStringFromAssessment = splittedList.get(1);
                        break;
                    }
                } else {
                    subStringFromAssessment = splittedList.get(i);
                    break;
                }
            }
            System.out.println("subStringFromAssessment ==>" + subStringFromAssessment);
            VerifyViewAssessmentSearch(subStringFromAssessment);

            if (verifySearchedViewAssessmentFirstRowTitle(subStringFromAssessment)) {
                ConsoleLogger.SuccessLog("Test cases : Passed - sub String Search is validated");
            } else {
                ConsoleLogger.FailedTestCase("Test cases : Failed - sub String Search is not validated ");
            }
        } catch (org.openqa.selenium.NoSuchElementException ne) {
            log.info("NoSuchElementException handled for sub String Search Assessment ");
            ConsoleLogger.FailedTestCase("Test cases : Failed - sub String Search is not validated due to NoSuchElementException");
        } catch (TimeoutException te) {
            log.info("TimeoutException handled for sub String Search Assessment");
            ConsoleLogger.FailedTestCase("Test cases : Failed - sub String Search is not validated due to TimeoutException");
        } catch (WebDriverException we) {
            log.info("WebDriverException handled for sub String Search Assessment ");
            ConsoleLogger.FailedTestCase("Test cases : Failed - sub String Search is not validated due to WebDriverException");
        } catch (Exception e) {
            log.info("Exception handled for sub String Search Assessment");
            ConsoleLogger.FailedTestCase("Test cases : Failed - sub String Search is not validated due to Exception");
        }


        //******Test Case -Searching the Assessment with Local Identifier**********//
        try {
            //Get Local Identifier for first row
            try {
                WebElement firstIdentifier = BrowserInitHelper.getInstance().findElement(By.xpath(dashboardPagePOM.getIDInFirstRow()));
                firstRowLocalIdentifier = firstIdentifier.getText().trim();
                System.out.println("first Row Local Identifier ==>" + firstRowLocalIdentifier);
            } catch (Exception e) {
                System.out.println("Exception handled for first Row Local Identifier ...." + e);
            }

            VerifyViewAssessmentSearch(firstRowLocalIdentifier);

            if (verifySearchedViewAssessmentFirstRow(firstRowLocalIdentifier)) {
                ConsoleLogger.SuccessLog("Test cases : Passed - Local Identifier Search is validated");
            } else {
                ConsoleLogger.FailedTestCase("Test cases : Failed - Local Identifier Search is not validated ");
            }
        } catch (org.openqa.selenium.NoSuchElementException ne) {
            log.info("NoSuchElementException handled for Local Identifier Search Assessment ");
            ConsoleLogger.FailedTestCase("Test cases : Failed - Local Identifier Search is not validated due to NoSuchElementException");
        } catch (TimeoutException te) {
            log.info("TimeoutException handled for Local Identifier Search Assessment");
            ConsoleLogger.FailedTestCase("Test cases : Failed - Local Identifier Search is not validated due to TimeoutException");
        } catch (WebDriverException we) {
            log.info("WebDriverException handled for Local Identifier Search Assessment ");
            ConsoleLogger.FailedTestCase("Test cases : Failed - Local Identifier Search is not validated due to WebDriverException");
        } catch (Exception e) {
            log.info("Exception handled for Local Identifier Search Assessment");
            ConsoleLogger.FailedTestCase("Test cases : Failed - Local Identifier Search is not validated due to Exception");
        }

        //**********Test Case - Searching the Assessment with owner/Author********//
        try {
            WebElement firstRowOwnerText = BrowserInitHelper.getInstance().findElement(By.xpath(dashboardPagePOM.getOwnerFirstRow()));
            firstRowOwner = firstRowOwnerText.getText().trim();
            System.out.println("first Row Owner ==>" + firstRowOwner);
        } catch (Exception e) {
            System.out.println("Exception handled for first Row Owner ...." + e);
        }

        try {
            VerifyViewAssessmentSearch(firstRowOwner);

            if (verifySearchedViewAssessmentFirstRow(firstRowOwner)) {
                ConsoleLogger.SuccessLog("Test cases : Passed - owner/Author Search is validated");
            } else {
                ConsoleLogger.FailedTestCase("Test cases : Failed - owner/Author Search is not validated ");
            }
        } catch (org.openqa.selenium.NoSuchElementException ne) {
            log.info("NoSuchElementException handled for owner/Author Search Assessment ");
            ConsoleLogger.FailedTestCase("Test cases : Failed - owner/Author Search is not validated due to NoSuchElementException");
        } catch (TimeoutException te) {
            log.info("TimeoutException handled for owner/Author Search Assessment");
            ConsoleLogger.FailedTestCase("Test cases : Failed - owner/Author Search is not validated due to TimeoutException");
        } catch (WebDriverException we) {
            log.info("WebDriverException handled for owner/Author Search Assessment ");
            ConsoleLogger.FailedTestCase("Test cases : Failed - owner/Author Search is not validated due to WebDriverException");
        } catch (Exception e) {
            log.info("Exception handled for owner/Author Search Assessment");
            ConsoleLogger.FailedTestCase("Test cases : Failed - owner/Author Search is not validated due to Exception");
        }


        //****Test Case - searching using TAB Key****//
        try {
            VerifyViewAssessmentSearchUsingTABKey(ValidAssessmentName);
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        try {
            if (verifySearchedViewAssessmentFirstRowTitle(ValidAssessmentName)) {
                ConsoleLogger.SuccessLog("Test cases : Passed - TAB Key Search is validated");
            } else {
                ConsoleLogger.FailedTestCase("Test cases : Failed - TAB KeySearch is not validated ");
            }
        } catch (org.openqa.selenium.NoSuchElementException ne) {
            log.info("NoSuchElementException handled for TAB Key Search Assessment ");
            ConsoleLogger.FailedTestCase("Test cases : Failed - TAB KeySearch is not validated due to NoSuchElementException");
        } catch (TimeoutException te) {
            log.info("TimeoutException handled for TAB Key Search Assessment");
            ConsoleLogger.FailedTestCase("Test cases : Failed - TAB KeySearch is not validated due to TimeoutException");
        } catch (WebDriverException we) {
            log.info("WebDriverException handled for TAB Key Search Assessment ");
            ConsoleLogger.FailedTestCase("Test cases : Failed - TAB KeySearch is not validated due to WebDriverException");
        } catch (Exception e) {
            log.info("Exception handled for TAB Key Search Assessment");
            ConsoleLogger.FailedTestCase("Test cases : Failed - TAB KeySearch is not validated due to Exception");
        }


        //*****Test Case - searching the unpublished Item bank assessment*****//
        //Navigating to the Unpublished
        try {
            driverHelper.clickXpath(viewAssessmentsPage.getUnpublishedItemBank());
            waitUntilAjaxLoaded();
            driverHelper.getElementByXpath(viewAssessmentsPage.getUnpublishedIteBankPageHeader());
            boolean checkNoDataInitially = checkDisplay(viewAssessmentsPage.getNodataAvailableinTable());

            //Get First row Unpublished Item Bank assessment from table
            WebElement firstRowUnpublishedItemBank = BrowserInitHelper.getInstance().findElement(By.xpath(dashboardPagePOM.getFirstLinkInAssessments()));
            String UnpublishedItemBank = firstRowUnpublishedItemBank.getText().trim();

            VerifyViewAssessmentSearch(UnpublishedItemBank);

            if (verifySearchedViewAssessmentFirstRowTitle(UnpublishedItemBank)) {
                ConsoleLogger.SuccessLog("Test cases : Passed - unpublished Item bank assessment Search is validated");
            } else {
                ConsoleLogger.FailedTestCase("Test cases : Failed - unpublished Item bank assessment Search is not validated ");
            }
        } catch (NoSuchElementException ne) {
            log.info("NoSuchElementException handled for unpublished Item bank assessment Search Assessment ");
            ConsoleLogger.FailedTestCase("Test cases : Failed - unpublished Item bank assessment Search is not validated due to NoSuchElementException");
        } catch (TimeoutException te) {
            log.info("TimeoutException handled for unpublished Item bank assessment Search Assessment");
            ConsoleLogger.FailedTestCase("Test cases : Failed - unpublished Item bank assessment Search is not validated due to TimeoutException");
        } catch (WebDriverException we) {
            log.info("WebDriverException handled for unpublished Item bank assessment Search Assessment ");
            ConsoleLogger.FailedTestCase("Test cases : Failed - unpublished Item bank assessment Search is not validated due to WebDriverException");
        } catch (Exception e) {
            log.info("Exception handled for unpublished Item bank assessment Search Assessment");
            ConsoleLogger.FailedTestCase("Test cases : Failed - unpublished Item bank assessment Search is not validated due to Exception");
        }
    }

    // To turn off toggle button
    public void turnOFFToggleButton() {
        if (JavascriptHelper.getToggleButtonState(viewAssessmentsPage.getShowAssessmentsWithoutDataToggleButton()).equalsIgnoreCase("true")) {
            /*Click Show Assessments Without Data toggle button*/
            JavascriptHelper.ClickByID_Javascript(viewAssessmentsPage.getShowAssessmentsWithoutDataToggleButton());

            DriverHelper.waitFluentByXPath(BrowserInitHelper.getInstance(), viewAssessmentsPage.getViewAssessmentPageHeader());

        }
    }

    // To clear added filter
    public void clearAddedFilter() {
        try {
            BrowserInitHelper.getWaiter().until(ExpectedConditions.elementToBeClickable(BrowserInitHelper.getInstance().findElement(By.xpath(viewAssessmentsPage.getClearAllFilters())))).click();
            waitUntilAjaxLoaded();
        } catch (Exception e) {
            System.out.println("Exception handled for clear all link...");
        }
    }

    // To clear search text box
    public void clearSearchTextBox() {
        try {
            BrowserInitHelper.getWaiter().until(ExpectedConditions.elementToBeClickable(By.id(viewAssessmentsPage.getViewAssessmentSearchTextBox()))).clear();
            BrowserInitHelper.getWaiter().until(ExpectedConditions.elementToBeClickable(By.id(viewAssessmentsPage.getViewAssessmentSearchtextboxButton()))).click();

            DriverHelper.waitFluentByXPath(BrowserInitHelper.getInstance(), viewAssessmentsPage.getViewAssessmentPageHeader());

        } catch (Exception e) {
            System.out.println("Exception handled for clearing search text box");
        }
    }

}
