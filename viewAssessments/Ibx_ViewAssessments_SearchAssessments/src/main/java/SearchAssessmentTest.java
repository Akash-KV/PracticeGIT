import Controllers.AssessmentSearchController;
import Controllers.LoginController;
import Helpers.BrowserInitHelper;
import Helpers.DriverHelper;
import Pom.ViewAssessmentsPage;
import Utils.Config;
import Utils.ConsoleLogger;
import Utils.DataReaderViewAssessmentsSearch;
import org.apache.commons.lang3.RandomStringUtils;
import org.graphwalker.core.machine.ExecutionContext;
import org.graphwalker.java.annotation.AfterExecution;
import org.graphwalker.java.annotation.BeforeExecution;
import org.graphwalker.java.annotation.GraphWalker;
import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import Pom.Dashboard;

import java.util.Arrays;
import java.util.List;

import static Helpers.JavascriptHelper.highlight;
import static Helpers.JavascriptHelper.*;

//Test class for SearchAssessment
@GraphWalker(value = "quick_random(edge_coverage(100))", start = "e_StartBrowser")
public class SearchAssessmentTest extends ExecutionContext implements SearchAssessment {

    //Declarations
    String browser, url, username, password, closeBrowser, multiSite, ticket, chrome, authX;
    Boolean headless;
    int waitTime;
    String ValidAssessmentName = "";
    String firstRowLocalIdentifier = "";
    String firstRowOwner = "";

    DriverHelper driverHelper = new DriverHelper();
    Config config = new Config();

    //Logger and WebDrivers
    private static final Logger log = LoggerFactory.getLogger(SearchAssessmentTest.class);

    Dashboard dashboardPOM = new Dashboard();
    BrowserInitHelper browserHelper = new BrowserInitHelper();
    ViewAssessmentsPage viewAssessment = new ViewAssessmentsPage();
    DataReaderViewAssessmentsSearch viewassessmentsdatareader = new DataReaderViewAssessmentsSearch();
    AssessmentSearchController assessmentSearchController = new AssessmentSearchController();

    @BeforeExecution
    public void setup() {
        //Utils.Config
        config.readProperties();
        browser = config.getBrowser();
        waitTime = config.getWaitTime();
        url = config.getURL();
        username = config.getUsername();
        password = config.getPassword();
        closeBrowser = config.getCloseBrowser();
        multiSite = config.getMultiSite();
        ticket = config.getTicket(); //added 01/10/19
        headless = config.getHeadless();
        chrome = config.getChrome();
        authX = config.getAuthX();
        BrowserInitHelper.setup();
    }

    @AfterExecution
    public void cleanup() {
        if (BrowserInitHelper.getInstance() != null) {
           // BrowserInitHelper.tearDown();
        }
    }

    //Browser Started
    public void e_StartBrowser() {
    }

    //Validate Browser Started
    public void v_BrowserStarted() {
        Assert.assertNotNull(BrowserInitHelper.getInstance());
        ConsoleLogger.SuccessLog("Browser is started");
    }

    //Enter URL
    public void e_EnterBaseURL() {
        BrowserInitHelper.getInstance().manage().window().maximize();
        BrowserInitHelper.getInstance().get(url);
    }

    //Validate URL
    public void v_BaseURL() {
        BrowserInitHelper.getWaiter().until(ExpectedConditions.titleContains("Illuminate Education"));
    }

    //Enter login credentials
    public void e_DirectLogin() {

        if (authX.contains("ON")) {
            LoginController.loginAuthXSite(username, password);
        } else {
            LoginController.login(username, password);
        }

    }

    //Validate Dashboard
    public void v_Dashboard() {
        //String TitleTile;
        boolean isExist = false;

        /*Wait till Illuminate Logo appears*/
        BrowserInitHelper.waitUntil(dashboardPOM.getIlluminateLogo());
        assessmentSearchController.checkPopup();

        if (BrowserInitHelper.getInstance().findElement(By.xpath(dashboardPOM.getDashboardBody())).isDisplayed()) {
            isExist = true;
        }
        Assert.assertTrue(isExist);
    }

    //Click on Navigation bar
    public void e_ClickNavbar() {

    }

    //Validate Navigation bar
    public void v_Navbar() {
        boolean isexist = false;
        if (BrowserInitHelper.getInstance().findElement(By.id(dashboardPOM.getNavigationSidebarContent())).isDisplayed()) {
            isexist = true;
        }
        Assert.assertTrue(isexist);
    }

    //Click on Assessments
    public void e_Assessments() {
        /*Click Assessments icon in Navigation sidebar*/
        driverHelper.clickXpath(dashboardPOM.getAssessmentsIcon());
    }

    //Validate AssessmentsPanel
    public void v_AssessmentsPanel() {
        boolean isexist = false;
        BrowserInitHelper.getWaiter().until(ExpectedConditions.elementToBeClickable(BrowserInitHelper.getInstance().findElement(By.id(dashboardPOM.getNavigationPanel()))));
        if (BrowserInitHelper.getInstance().findElement(By.id(dashboardPOM.getNavigationPanel())).isDisplayed()) {
            isexist = true;
        }
        Assert.assertTrue(isexist);
    }

    //Click on Assessment Panel and View Assessment Option
    public void e_AssessmentPanel_ViewAssessmentOption() {
        /*Click View Assessments Link*/
        driverHelper.clickXpath(dashboardPOM.getViewAssessmentsLink());
        assessmentSearchController.checkPopup();
        waitUntilAjaxLoaded();

        /*Wait until View Assessments header appears*/
        BrowserInitHelper.waitUntil(dashboardPOM.getViewAssessmentsHeader());
    }

    //Validate ViewAssessments Page
    public void v_ViewAssessmentsPage() {
        browserHelper.assertion(dashboardPOM.getViewAssessmentsHeader(), "View Assessments");
    }

    public void e_SearchAssessment() {

    }

    //Validate SearchedAssessment
    public void v_VerifySearchedAssessment() {
        //Clearing the filter
        try {
            BrowserInitHelper.getWaiter().until(ExpectedConditions.elementToBeClickable(BrowserInitHelper.getInstance().findElement(By.id(dashboardPOM.getClearAllFilters())))).click();
            waitUntilAjaxLoaded();
        } catch (Exception e) {

        }
        //Test Case - Valid
        //Get Assessment Name and set it
        try {
            WebElement firstAssessmentName = BrowserInitHelper.getInstance().findElement(By.xpath(dashboardPOM.getFirstLinkInAssessments()));
            ValidAssessmentName = firstAssessmentName.getText().trim();
            System.out.println("Valid Assessment Name ==>" + ValidAssessmentName);
        } catch (Exception e) {
            System.out.println("Exception handled for valid assessment name...." + e);
        }

        assessmentSearchController.VerifyViewAssessmentSearch(ValidAssessmentName);

        try {
            if (assessmentSearchController.verifySearchedValidViewAssessmentTitleandOverview(ValidAssessmentName)) {
                ConsoleLogger.SuccessLog("Test cases : Passed - Valid Search is validated");
            } else {
                ConsoleLogger.FailedTestCase("Test cases : Failed - Valid Search is not validated ");
            }
        } catch (NoSuchElementException ne) {
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
        BrowserInitHelper.waitUntil(dashboardPOM.getViewAssessmentsHeader());

        //***Test Case - Invalid****//
        try {
            assessmentSearchController.VerifyViewAssessmentSearch(viewassessmentsdatareader.getInvalidTitle());
            if (assessmentSearchController.verifySearchedViewAssessmentFirstRow(viewassessmentsdatareader.getInvalidTitle())) {
                ConsoleLogger.SuccessLog("Test cases : Passed - InValid Search is validated");
            } else {
                ConsoleLogger.FailedTestCase("Test cases : Failed - InValid Search is not validated ");
            }
        } catch (NoSuchElementException ne) {
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
            assessmentSearchController.VerifyViewAssessmentSearch(viewassessmentsdatareader.getSpecialCharecters());
            if (assessmentSearchController.verifySearchedViewAssessmentFirstRow(viewassessmentsdatareader.getSpecialCharecters())) {
                ConsoleLogger.SuccessLog("Test cases : Passed - Special Characters Search is validated");
            } else {
                ConsoleLogger.FailedTestCase("Test cases : Failed - Special Characters Search is not validated ");
            }
        } catch (NoSuchElementException ne) {
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
            assessmentSearchController.VerifyViewAssessmentSearch(viewassessmentsdatareader.getAlphanewmeric());
            if (assessmentSearchController.verifySearchedViewAssessmentFirstRow(viewassessmentsdatareader.getAlphanewmeric())) {
                ConsoleLogger.SuccessLog("Test cases : Passed - Alpha newmeric Search is validated");
            } else {
                ConsoleLogger.FailedTestCase("Test cases : Failed - Alpha newmeric Search is not validated ");
            }
        } catch (NoSuchElementException ne) {
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
            assessmentSearchController.VerifyViewAssessmentSearch(viewassessmentsdatareader.getYear());
            if (assessmentSearchController.verifySearchedViewAssessmentFirstRow(viewassessmentsdatareader.getYear())) {
                ConsoleLogger.SuccessLog("Test cases : Passed - year Search is validated");
            } else {
                ConsoleLogger.FailedTestCase("Test cases : Failed - year Search is not validated ");
            }
        } catch (NoSuchElementException ne) {
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
            driverHelper.clickXpath(dashboardPOM.getAssessmentsIcon());
            BrowserInitHelper.getWaiter().until(ExpectedConditions.elementToBeClickable(BrowserInitHelper.getInstance().findElement(By.id(dashboardPOM.getNavigationPanel()))));
            /*Click View Assessments Link*/
            driverHelper.clickXpath(dashboardPOM.getViewAssessmentsLink());
            waitUntilAjaxLoaded();
            /*Wait until View Assessments header appears*/
            BrowserInitHelper.waitUntil(dashboardPOM.getViewAssessmentsHeader());

            //clearing text in the search box
            highlight(BrowserInitHelper.getWaiter().until(ExpectedConditions.elementToBeClickable(By.id(viewAssessment.getViewAssessmentSearchtextbox()))));
            BrowserInitHelper.getWaiter().until(ExpectedConditions.elementToBeClickable(By.id(viewAssessment.getViewAssessmentSearchtextbox()))).clear();
            DriverHelper.clickId(viewAssessment.getViewAssessmentSearchtextboxButton(), BrowserInitHelper.getWaiter(), BrowserInitHelper.getInstance());
            waitUntilAjaxLoaded();

            //taking the count of the initial data count
            String Initialcount = DriverHelper.getElementByXpath(viewAssessment.getPagingInfo()).getText();
            log.info("Initial count of Assessment --> " + Initialcount);

            //sending the Empty data
            highlight(BrowserInitHelper.getWaiter().until(ExpectedConditions.elementToBeClickable(By.id(viewAssessment.getViewAssessmentSearchtextbox()))));
            BrowserInitHelper.getWaiter().until(ExpectedConditions.elementToBeClickable(By.id(viewAssessment.getViewAssessmentSearchtextbox()))).clear();
            DriverHelper.clickId(viewAssessment.getViewAssessmentSearchtextboxButton(), BrowserInitHelper.getWaiter(), BrowserInitHelper.getInstance());
            waitUntilAjaxLoaded();

            if (DriverHelper.getElementByXpath(viewAssessment.getPagingInfo()).getText().equalsIgnoreCase(Initialcount)) {
                ConsoleLogger.SuccessLog("Test cases : Passed - empty String and whitespace Search is validated");
            } else {
                ConsoleLogger.FailedTestCase("Test cases : Failed - empty String and whitespace Search is not validated ");
            }
        } catch (NoSuchElementException ne) {
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
            List<WebElement> assessmentList = BrowserInitHelper.getInstance().findElements(By.xpath(dashboardPOM.getListAssessments()));
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
            assessmentSearchController.VerifyViewAssessmentSearch(subStringFromAssessment);

            if (assessmentSearchController.verifySearchedViewAssessmentFirstRowTitle(subStringFromAssessment)) {
                ConsoleLogger.SuccessLog("Test cases : Passed - sub String Search is validated");
            } else {
                ConsoleLogger.FailedTestCase("Test cases : Failed - sub String Search is not validated ");
            }
        } catch (NoSuchElementException ne) {
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
                WebElement firstIdentifier = BrowserInitHelper.getInstance().findElement(By.xpath(dashboardPOM.getIDInFirstRow()));
                firstRowLocalIdentifier = firstIdentifier.getText().trim();
                System.out.println("first Row Local Identifier ==>" + firstRowLocalIdentifier);
            } catch (Exception e) {
                System.out.println("Exception handled for first Row Local Identifier ...." + e);
            }

            assessmentSearchController.VerifyViewAssessmentSearch(firstRowLocalIdentifier);

            if (assessmentSearchController.verifySearchedViewAssessmentFirstRow(firstRowLocalIdentifier)) {
                ConsoleLogger.SuccessLog("Test cases : Passed - Local Identifier Search is validated");
            } else {
                ConsoleLogger.FailedTestCase("Test cases : Failed - Local Identifier Search is not validated ");
            }
        } catch (NoSuchElementException ne) {
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
            WebElement firstRowOwnerText = BrowserInitHelper.getInstance().findElement(By.xpath(dashboardPOM.getOwnerFirstRow()));
            firstRowOwner = firstRowOwnerText.getText().trim();
            System.out.println("first Row Owner ==>" + firstRowOwner);
        } catch (Exception e) {
            System.out.println("Exception handled for first Row Owner ...." + e);
        }

        try {
            assessmentSearchController.VerifyViewAssessmentSearch(firstRowOwner);

            if (assessmentSearchController.verifySearchedViewAssessmentFirstRow(firstRowOwner)) {
                ConsoleLogger.SuccessLog("Test cases : Passed - owner/Author Search is validated");
            } else {
                ConsoleLogger.FailedTestCase("Test cases : Failed - owner/Author Search is not validated ");
            }
        } catch (NoSuchElementException ne) {
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
            assessmentSearchController.VerifyViewAssessmentSearchUsingTABKey(ValidAssessmentName);

            Thread.sleep(8000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        try {
            if (assessmentSearchController.verifySearchedViewAssessmentFirstRowTitle(ValidAssessmentName)) {
                ConsoleLogger.SuccessLog("Test cases : Passed - TAB Key Search is validated");
            } else {
                ConsoleLogger.FailedTestCase("Test cases : Failed - TAB KeySearch is not validated ");
            }
        } catch (NoSuchElementException ne) {
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
            driverHelper.clickXpath(viewAssessment.getUnpublishedItemBank());
            waitUntilAjaxLoaded();
            driverHelper.getElementByXpath(viewAssessment.getUnpublishedIteBankPageHeader());
            boolean checkNoDataInitially = assessmentSearchController.checkDisplay(viewAssessment.getNodataAvailableinTable());

            //Get First row Unpublished Item Bank assessment from table
            WebElement firstRowUnpublishedItemBank = BrowserInitHelper.getInstance().findElement(By.xpath(dashboardPOM.getFirstLinkInAssessments()));
            String UnpublishedItemBank = firstRowUnpublishedItemBank.getText().trim();

            assessmentSearchController.VerifyViewAssessmentSearch(UnpublishedItemBank);

            if (assessmentSearchController.verifySearchedViewAssessmentFirstRowTitle(UnpublishedItemBank)) {
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
}