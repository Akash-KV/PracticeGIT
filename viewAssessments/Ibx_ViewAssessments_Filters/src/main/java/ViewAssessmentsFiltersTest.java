import Controllers.AddFilterController;
import Controllers.LoginController;
import DataReaders.CSVDataReaderViewAssessmentsFilter;
import Helpers.BrowserInitHelper;
import Helpers.JavascriptHelper;
import Pom.AssessmentsNavbar;
import Pom.Dashboard;
import Pom.ViewAssessmentsPage;
import Pom.ViewAssessments_AddFilters;
import Utils.Config;
import Utils.ConsoleLogger;
import org.graphwalker.core.machine.ExecutionContext;
import org.graphwalker.java.annotation.AfterExecution;
import org.graphwalker.java.annotation.BeforeExecution;
import org.graphwalker.java.annotation.GraphWalker;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import Helpers.DriverHelper;

import static Helpers.JavascriptHelper.clickXpath_JS;
import static Helpers.JavascriptHelper.waitUntilAjaxLoaded;

@GraphWalker(value = "quick_random(edge_coverage(100))", start = "e_StartBrowser")

/** Test class for ViewAssessmentsFilters **/
public class ViewAssessmentsFiltersTest extends ExecutionContext implements ViewAssessmentsFilters {

    //Declarations
    Config config = new Config();
    String browser, url, username, password, closeBrowser, multiSite, ticket, chrome, firefox, authX;
    Boolean headless;
    int waitTime;
    DriverHelper Helper = new DriverHelper();
    Dashboard dashboard = new Dashboard();
    AssessmentsNavbar assessmentsNavbar = new AssessmentsNavbar();
    ViewAssessmentsPage viewAssessmentsPage = new ViewAssessmentsPage();
    ViewAssessments_AddFilters viewAssessments_addFilters = new ViewAssessments_AddFilters();
    AddFilterController addFilterController = new AddFilterController();
    CSVDataReaderViewAssessmentsFilter csvDataReaderViewAssessmentsFilter = new CSVDataReaderViewAssessmentsFilter();

    //Logger and WebDrivers
    private static final Logger logger = LoggerFactory.getLogger(ViewAssessmentsFiltersTest.class);

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
        ticket = config.getTicket();
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

    // To Validate Browser started
    public void v_BrowserStarted() {
        Assert.assertNotNull(BrowserInitHelper.getInstance());
    }

    // To Enter Url
    public void e_EnterBaseURL() {
        BrowserInitHelper.getInstance().get(url);
    }

    // To Validate Url
    public void v_BaseURL() {
        BrowserInitHelper.getWaiter().until(ExpectedConditions.titleContains("Illuminate Education"));
    }

    // Entering Credentials
    public void e_DirectLogin() {
        if (authX.contains("ON")) {
            LoginController.loginAuthXSite(username, password);
        } else {
            LoginController.login(username, password);
        }
    }


    public void v_Dashboard() {

    }

    // To click Navbar
    public void e_ClickNavbar() {
        try {
            Thread.sleep(5000);
            addFilterController.checkPopup();
            Helper.clickXpath(dashboard.getAssessmentsNav());
        } catch (InterruptedException e) {
            logger.info("InterruptedException handled....");
        }
    }

    public void v_Navbar() {

    }

    // To Click View Assessments
    public void e_ViewAssessments() {
        Helper.clickXpath(assessmentsNavbar.getViewAssessment());
        addFilterController.checkPopup();
    }

    // To Validate ViewAssessments
    public void v_ViewAssessments() {
        String headerText = Helper.getText(viewAssessmentsPage.getViewAssessmentsHeader());
        Assert.assertEquals("View Assessments", headerText);

        //Clear Filters
        clickXpath_JS(viewAssessmentsPage.getClearAllInViewAssessments());
        waitUntilAjaxLoaded();
    }

    // To Click Add Filters
    public void e_AddFiltersClick() {
        //Condition 1 - Clear if any text is already present in search text box
        waitUntilAjaxLoaded();
        BrowserInitHelper.getInstance().findElement(By.xpath(viewAssessmentsPage.getSearchTextBox())).clear();

        //Click Search
        clickXpath_JS(viewAssessmentsPage.getSearchButtonInViewAssessments());
        waitUntilAjaxLoaded();

        //Condition 2 - Click on clear all link for filter, if any filter is already added
        try {
            Thread.sleep(2000);
            DriverHelper.clickXpath(viewAssessmentsPage.getClearAllInViewAssessments());
            Thread.sleep(2000);
            waitUntilAjaxLoaded();
        } catch (NoSuchElementException ne) {
            System.out.println("NoSuchElementException handled for Clear All link for filter...");
        } catch (Exception e) {
            System.out.println("Exception handled for Clear All link for filter...");
        }

        //Click on any link from sidebar based on csv value
        addFilterController.ClickSidebarLink(csvDataReaderViewAssessmentsFilter.getSidebarLinkToClick());

        //Wait
        waitUntilAjaxLoaded();
        Helper.clickXpath(viewAssessmentsPage.getAddFilterButton());
    }

    // To Validate Add filters
    public void v_VerifyAddFilters() {
        WebElement addFilterPopup = BrowserInitHelper.getInstance().findElement(By.xpath(viewAssessments_addFilters.getAddFilterPopup()));
        Assert.assertEquals(true, addFilterPopup.isDisplayed());
        logger.info("Add Filters is displayed.......");
    }

}
