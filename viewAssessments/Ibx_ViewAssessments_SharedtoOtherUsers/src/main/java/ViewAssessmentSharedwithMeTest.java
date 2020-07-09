import Controllers.AddFilterController;
import Controllers.AssessmentSearchController;
import Controllers.LoginController;
import Controllers.SharedtoOtherUserController;
import Helpers.BrowserInitHelper;
import Helpers.DriverHelper;
import Helpers.JavascriptHelper;
import Pom.Dashboard;
import Pom.ViewAssessmentsPage;
import Pom.ViewAssessments_AddFilters;
import Utils.Config;
import Utils.ConsoleLogger;
import Utils.DataReaderViewAssessmentsSearch;
import org.graphwalker.core.machine.ExecutionContext;
import org.graphwalker.java.annotation.AfterExecution;
import org.graphwalker.java.annotation.BeforeExecution;
import org.graphwalker.java.annotation.GraphWalker;
import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

import static Helpers.JavascriptHelper.*;


@GraphWalker(value = "quick_random(edge_coverage(100))", start = "e_StartBrowser")
// Test Class for ViewAssessmentSharedwithMe
public class ViewAssessmentSharedwithMeTest extends ExecutionContext implements ViewAssessmentSharedwithMe {

    //Declarations
    Config config = new Config();
    String browser, url, username, password, shared_username, shared_password, closeBrowser, multiSite, ticket, chrome, authX;
    Boolean headless;
    int waitTime;

    DriverHelper driverHelper = new DriverHelper();
    JavascriptHelper javascriptHelper = new JavascriptHelper();
    AddFilterController addFilterController = new AddFilterController();
    ViewAssessments_AddFilters viewAssessmentsPage_AddFilters = new ViewAssessments_AddFilters();
    AssessmentSearchController assessmentSearchController = new AssessmentSearchController();
    SharedtoOtherUserController sharedtoOtherUserController = new SharedtoOtherUserController();


    //Logger and WebDrivers
    private static final Logger log = LoggerFactory.getLogger(ViewAssessmentSharedwithMeTest.class);

    Dashboard dashboardPOM = new Dashboard();
    BrowserInitHelper browserHelper = new BrowserInitHelper();
    ViewAssessmentsPage viewAssessmentPOM = new ViewAssessmentsPage();
    DataReaderViewAssessmentsSearch viewassessmentsdatareader = new DataReaderViewAssessmentsSearch();


    @BeforeExecution
    public void setup() {
        //Utils.Config
        config.readProperties();
        browser = config.getBrowser();
        waitTime = config.getWaitTime();
        url = config.getURL();
        username = config.getUsername();
        password = config.getPassword();
        shared_username = Config.getUser_Username();
        shared_password = Config.getUser_Password();
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
            BrowserInitHelper.tearDown();
        }
    }

    public void e_StartBrowser() {
    }

    // Validating Browser started
    public void v_BrowserStarted() {
        Assert.assertNotNull(BrowserInitHelper.getInstance());
    }

    // Entering Url
    public void e_EnterBaseURL() {
        BrowserInitHelper.getInstance().manage().window().maximize();
        BrowserInitHelper.getInstance().get(url);
    }

    // To validate Url
    public void v_BaseURL() {
        BrowserInitHelper.getWaiter().until(ExpectedConditions.titleContains("Illuminate Education"));
    }

    // Entering the credentials
    public void e_DirectLogin() {
        if (authX.contains("ON")) {
            LoginController.loginAuthXSite(username, password);
        } else {
            LoginController.login(username, password);
        }
    }

    // Validating Dashboard
    public void v_Dashboard() {
        //String TitleTile;
        boolean isExist = false;

        /*Wait till Illuminate Logo appears*/
        BrowserInitHelper.waitUntil(dashboardPOM.getIlluminateLogo());
        sharedtoOtherUserController.checkPopup();

        if (BrowserInitHelper.getInstance().findElement(By.xpath(dashboardPOM.getDashboardBody())).isDisplayed()) {
            //log.info("Dashboard is displaying properly");
            isExist = true;
        }
        Assert.assertTrue(isExist);
    }

    public void e_ClickNavbar() {

    }

    // Validating Navigation Bar
    public void v_Navbar() {
        boolean isexist = false;
        if (BrowserInitHelper.getInstance().findElement(By.id("navigation-sidebar-content")).isDisplayed()) {
            //log.info("Navigation side bar is displaying");
            isexist = true;
        }
        Assert.assertTrue(isexist);
    }


    /*Click Assessments icon in Navigation sidebar*/
    public void e_Assessments() {
        driverHelper.clickXpath(dashboardPOM.getAssessmentsIcon());
    }

    // Validating Assessments Panel
    public void v_AssessmentsPanel() {
        boolean isexist = false;
        BrowserInitHelper.getWaiter().until(ExpectedConditions.elementToBeClickable(BrowserInitHelper.getInstance().findElement(By.id("navigation-navigation-panel"))));
        if (BrowserInitHelper.getInstance().findElement(By.id("navigation-navigation-panel")).isDisplayed()) {
            //log.info("Assessment Panel is displaying");
            isexist = true;
        }
        Assert.assertTrue(isexist);
    }

    public void e_AssessmentPanel_ViewAssessmentOption() {
        /*Click View Assessments Link*/
        driverHelper.clickXpath(dashboardPOM.getViewAssessmentsLink());
        sharedtoOtherUserController.checkPopup();

        /*Wait until View Assessments header appears*/
        BrowserInitHelper.waitUntil(dashboardPOM.getViewAssessmentsHeader());
    }

    // Validate ViewAssessmentsPage
    public void v_ViewAssessmentsPage() {
        browserHelper.assertion(dashboardPOM.getViewAssessmentsHeader(), "View Assessments");
    }

    // Click SharedWithMe
    public void e_SharedwithMe() {
        driverHelper.clickXpath(viewAssessmentPOM.getSharedwithMeLink());
        waitUntilAjaxLoaded();
        BrowserInitHelper.waitUntil(dashboardPOM.getViewAssessmentsHeader());
    }

    //Validating SharedWithMePage
    public void v_SharedwithMePage() {
        System.out.println("Waiting for Shared with me");
        BrowserInitHelper.getWaiter().until(ExpectedConditions.visibilityOfElementLocated(By.xpath(viewAssessmentPOM.getSharedwithMeTitle())));
        browserHelper.assertion(viewAssessmentPOM.getSharedwithMeTitle(), "Shared with Me");
    }

    public void e_SelectAssessmentFilter() {


    }

    // Validating Share CurrentPermission model
    public void v_ShareCurrentPermissionmodel() {

        //******Test Case - To check for the share for the Assessment type*****//
        //**********************SHARE ASSESSMENT TYPE**************************//

        try {
            //Selecting the Assessment filter
            boolean assessmentTypeEmpty = sharedtoOtherUserController.SelectFilterRequiredOption(viewAssessmentsPage_AddFilters.getTypeFilter(), "Assessment");

            //Verifying the share popup display for the Assessment type
            if (assessmentTypeEmpty) {
                sharedtoOtherUserController.VerifySharePopupDisplay("Assessment");
            }
        } catch (Exception e) {
            e.printStackTrace();
            log.info("Exception handled for Assessment type..");
            ConsoleLogger.FailedTestCase("Test Case : Failed - Share for Assessment type is failed due to Exception -->" + e);
        }

        //******Test Case - To check for the share for the flexible type*****//
        //**********************SHARE FLEXIBLE TYPE**************************//

        try {
            //Selecting the flexible filter
            boolean flexibleTypeEmpty = sharedtoOtherUserController.SelectFilterRequiredOption(viewAssessmentsPage_AddFilters.getTypeFilter(), "Assessment");

            //Verifying the share popup display for the flexible type
            if (flexibleTypeEmpty) {
                sharedtoOtherUserController.VerifySharePopupDisplay("Flexible");
            }
        } catch (Exception e) {
            log.info("Exception handled for flexible type..");
            ConsoleLogger.FailedTestCase("Test Case : Failed - Share for flexible type is failed due to Exception -->" + e);
        }
        //******Test Case - To check for the share for the Item Bank type*****//
        //**********************SHARE ITEM BANK TYPE**************************//

        //Selecting the Item Bank filter
        try {
            boolean itemBankTypeEmpty = sharedtoOtherUserController.SelectFilterRequiredOption(viewAssessmentsPage_AddFilters.getTypeFilter(), "Item Bank");

            //Verifying the share popup display for the Item Bank type
            if (itemBankTypeEmpty) {
                sharedtoOtherUserController.VerifySharePopupDisplay("Item Bank");
            }
        } catch (Exception e) {
            e.printStackTrace();
            log.info("Exception handled for Item Bank type..");
            ConsoleLogger.FailedTestCase("Test Case : Failed - Share for Item Bank type is failed due to Exception -->" + e);
        }


        //******Test Case - Checking the share for the Assessment without data*****//

        try {
            //clicking on the All Assessment
            driverHelper.clickXpath(viewAssessmentPOM.getAllAssessmentLink());
            waitUntilAjaxLoaded();
            BrowserInitHelper.waitUntil(dashboardPOM.getViewAssessmentsHeader());

            //Clicking on the Add Filters
            JavascriptHelper.clickXpath_JS(viewAssessmentPOM.getAddFilterButton());
            //reset the type selection
            clickID_JS(viewAssessmentsPage_AddFilters.getResetButton_AddFilters());
            addFilterController.clickSearch();

            //toggle data
            AssessmentSearchController.toggleOff();

            //Searching the Assessment
            assessmentSearchController.VerifyViewAssessmentSearch(viewassessmentsdatareader.getAssessmentnametosharewithoutdata());

            //clicking on the Action and selection the share option
            driverHelper.clickXpath(viewAssessmentPOM.getActionButtonfortheFirstLink());
            driverHelper.clickXpath(viewAssessmentPOM.getShareOptioninActionButtonfortheFirstLink());
            waitUntilAjaxLoaded();
            BrowserInitHelper.waitUntil(viewAssessmentPOM.getShareCurrentPermissionHeader());

            //Selecting the share with option
            driverHelper.clickById(viewAssessmentPOM.getSharewithdropdown());

            //clicking on the Site option
            JavascriptHelper.clickXpath_JS("//select[@id='share_by']//option[.='" + viewassessmentsdatareader.getSharewithSelection() + "']");

            Select siteselection = new Select(BrowserInitHelper.getInstance().findElement(By.id("share_by")));
            siteselection.selectByVisibleText(viewassessmentsdatareader.getSharewithSelection());

            //scroll till the site selection and click
            JavascriptHelper.scrollintoViewByID(viewAssessmentPOM.getSiteSelectiondropdowntextbox());


            //sending text to the site option
            driverHelper.sendKeysByID(viewAssessmentPOM.getSiteSelectiondropdowntextbox(), viewassessmentsdatareader.getSiteSelection());

            //Clicking on the Enter Key
            WebElement SiteSelectiondropdowntextbox = BrowserInitHelper.getInstance().findElement(By.id(viewAssessmentPOM.getSiteSelectiondropdowntextbox()));
            SiteSelectiondropdowntextbox.sendKeys(Keys.ENTER);

            // clicking on the mask
            try {
                JavascriptHelper.clickID_JSJQuery(viewAssessmentPOM.getShareMask());
            } catch (ElementNotInteractableException e) {
                e.printStackTrace();
                log.info("ElementNotInteractableException handled for Popup...");
            } catch (NoSuchElementException e) {
                e.printStackTrace();
                log.info("NoSuchElementException handled for Popup ...");
            } catch (TimeoutException e) {
                e.printStackTrace();
                log.info("NoSuchElementException handled for Popup...");
            } catch (Exception e) {
                e.printStackTrace();
                log.info("Exception handled for Popup..");
            }

            JavascriptHelper.clickXpath_JS("//legend[@class='changing-area']");

            //scroll till the share button  and click
            JavascriptHelper.scrollintoViewByID(viewAssessmentPOM.getShareButton());
            driverHelper.clickById(viewAssessmentPOM.getShareButton());
            waitUntilAjaxLoaded();
            BrowserInitHelper.waitUntil(viewAssessmentPOM.getSharesuccessmessage());

            //change the control panel
            driverHelper.clickXpath(viewAssessmentPOM.getControlPanelSettingoption());
            driverHelper.clickById(viewAssessmentPOM.getControlPanelSitedropdown());
            driverHelper.sendKeysXpath(viewAssessmentPOM.getControlPanelSitedropdownsearchbox(), viewassessmentsdatareader.getSiteSelection());

            WebElement ControlPanelSiteSelectiondropdowntextbox = BrowserInitHelper.getInstance().findElement(By.xpath(viewAssessmentPOM.getControlPanelSitedropdownsearchbox()));
            ControlPanelSiteSelectiondropdowntextbox.sendKeys(Keys.ENTER);

            //clicking on the save changes button
            driverHelper.clickById(viewAssessmentPOM.getControlPanelSaveChangesbutton());
            driverHelper.waitUntilElementInvisible_ByID("navigation-tool-panel");
            waitUntilAjaxLoaded();
            JavascriptHelper.waitUntilDocumentIsReady();
            //BrowserInitHelper.waitUntil(viewAssessmentPOM.getSiteheader());

            if (driverHelper.getText(viewAssessmentPOM.getSiteheader().trim()).equalsIgnoreCase(viewassessmentsdatareader.getSiteSelection())) {
                log.info("Site changed correctly");
            } else {
                log.info("Site is not changed correctly");
            }

            // Checking the shared assessment by loging into Shared user
            driverHelper.clickXpath(viewAssessmentPOM.getControlPanelSettingoption());
            DriverHelper.clickXpath(dashboardPOM.getSignOut());

            BrowserInitHelper.getWaiter().until(ExpectedConditions.titleContains("Illuminate Education"));
            BrowserInitHelper.getInstance().get(url);
            if (authX.contains("ON")) {
                LoginController.loginAuthXSite(shared_username, shared_password);
            } else {
                LoginController.login(shared_username, shared_password);
            }
            ConsoleLogger.SuccessLog("Login for Shared user is successfull");

            //navigating to the view Assessment page and share with me page
            driverHelper.clickXpath(dashboardPOM.getAssessmentsIcon());
            driverHelper.clickXpath(dashboardPOM.getViewAssessmentsLink());

            /*Wait until View Assessments header appears*/
            BrowserInitHelper.waitUntil(dashboardPOM.getViewAssessmentsHeader());
            browserHelper.assertion(dashboardPOM.getViewAssessmentsHeader(), "View Assessments");
            driverHelper.clickXpath(viewAssessmentPOM.getSharedwithMeLink());
            waitUntilAjaxLoaded();
            BrowserInitHelper.waitUntil(dashboardPOM.getViewAssessmentsHeader());
            browserHelper.assertion(viewAssessmentPOM.getSharedwithMeTitle(), "Shared with Me");

            //searching the shared assessment
            assessmentSearchController.VerifyViewAssessmentSearch(viewassessmentsdatareader.getAssessmentnametosharewithoutdata());

            //verifying the shared search
            boolean checkEmptyTable = addFilterController.checkViewAssessments_EmptyTable(viewAssessmentPOM.getDataTableEmpty());
            if (checkEmptyTable) {
                ConsoleLogger.FailedTestCase("Test Case : Failed - Shared Assessment is not showing hence failing the test case");
            } else {
                waitUntilAjaxLoaded();
                BrowserInitHelper.getWaiter().until(ExpectedConditions.elementToBeClickable(By.xpath(viewAssessmentPOM.getFirstLinkAfterSearch())));
                WebElement FirstLinkShareAfterSearch = BrowserInitHelper.getInstance().findElement(By.xpath(viewAssessmentPOM.getFirstLinkShareIconAfterSearch()));

                //Verifying the Share Icon
                try {
                    if (BrowserInitHelper.getInstance().findElement(By.xpath(viewAssessmentPOM.getFirstLinkShareIconAfterSearch())).isDisplayed()) {

                    } else {
                        ConsoleLogger.FailedTestCase("TestCase - Failed Share icon for the Assessment is not showing for the filter.... Hence Failed");
                    }
                    //clicking on the share icon
                    highlight(BrowserInitHelper.getWaiter().until(ExpectedConditions.elementToBeClickable(BrowserInitHelper.getInstance().findElement(By.xpath(viewAssessmentPOM.getFirstLinkShareIconAfterSearch())))));
                    BrowserInitHelper.getWaiter().until(ExpectedConditions.elementToBeClickable(BrowserInitHelper.getInstance().findElement(By.xpath(viewAssessmentPOM.getFirstLinkShareIconAfterSearch())))).click();

                    //checking for the model
                    BrowserInitHelper.getWaiter().until(ExpectedConditions.elementToBeClickable(By.xpath(viewAssessmentPOM.getCurrentPermissionModelTitle())));
                    if (BrowserInitHelper.getWaiter().until(ExpectedConditions.elementToBeClickable(By.xpath(viewAssessmentPOM.getCurrentPermissionModelTitle()))).isDisplayed()) {
                        ConsoleLogger.SuccessLog("Testcase - Passed - For Shared Current Permission Model is displaying");
                    }

                    javascriptHelper.clickXpath_JS(viewAssessmentPOM.getCurrentPermissionModelcloseButton());
                    waitUntilAjaxLoaded();
                } catch (ElementNotInteractableException e) {
                    e.printStackTrace();
                    log.info("ElementNotInteractableException handled for Popup...");
                } catch (NoSuchElementException e) {
                    e.printStackTrace();
                    log.info("NoSuchElementException handled for Popup ...");
                } catch (TimeoutException e) {
                    e.printStackTrace();
                    log.info("NoSuchElementException handled for Popup...");
                } catch (Exception e) {
                    e.printStackTrace();
                    log.info("Exception handled for Popup..");
                }
                ConsoleLogger.SuccessLog("Test Case : Passed - Shared Assessment is  showing hence passing the test case");
            }

        } catch (ElementNotInteractableException e) {
            e.printStackTrace();
            log.info("Selection - ElementNotInteractableException handled for Popup...");
            ConsoleLogger.FailedTestCase("Test Case : Failed - Selection - Shared Assessment is not showing hence passing the test case");
        } catch (NoSuchElementException e) {
            e.printStackTrace();
            log.info("Selection - NoSuchElementException handled for Popup ...");
            ConsoleLogger.FailedTestCase("Test Case : Failed - Selection - Shared Assessment is  notshowing hence passing the test case");
        } catch (TimeoutException e) {
            e.printStackTrace();
            log.info("Selection - NoSuchElementException handled for Popup...");
            ConsoleLogger.FailedTestCase("Test Case : Failed - Selection - Shared Assessment is not showing hence passing the test case");
        } catch (Exception e) {
            e.printStackTrace();
            log.info("Selection - Exception handled for Popup..");
            ConsoleLogger.FailedTestCase("Test Case : Failed - Selection -  Shared Assessment is not  showing hence passing the test case");
        }
    }
}
