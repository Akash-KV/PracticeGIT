import Controllers.LoginController;
import Controllers.ViewAssessmentsSidebarPagesColumnSortController;
import DataReaders.CSVDataReaderViewAssessmentsColumnSort;
import Helpers.BrowserInitHelper;
import Pom.AssessmentsNavbar;
import Pom.Dashboard;
import Pom.ViewAssessments;
import Utils.Config;
import Utils.ConsoleLogger;
import org.graphwalker.core.machine.ExecutionContext;
import org.graphwalker.java.annotation.AfterExecution;
import org.graphwalker.java.annotation.BeforeExecution;
import org.graphwalker.java.annotation.GraphWalker;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import Helpers.DriverHelper;

import static Helpers.JavascriptHelper.waitUntilAjaxLoaded;

@GraphWalker(value = "quick_random(edge_coverage(100))", start = "e_StartBrowser")
/*Test Class for ViewAssessmentsSidebarPagesColumnSortTest*/
public class ViewAssessmentsSidebarPagesColumnSortTest extends ExecutionContext implements ViewAssessmentsSidebarPagesColumnSort {

    //Declarations
    Config config = new Config();
    String browser, url, username, password, closeBrowser, multiSite, ticket, chrome, firefox, authX;
    Boolean headless;
    int waitTime;
    DriverHelper Helper = new DriverHelper();
    Dashboard dashboard = new Dashboard();
    AssessmentsNavbar assessmentsNavbar = new AssessmentsNavbar();
    ViewAssessments viewAssessments = new ViewAssessments();
    ViewAssessmentsSidebarPagesColumnSortController controller = new ViewAssessmentsSidebarPagesColumnSortController();
    CSVDataReaderViewAssessmentsColumnSort csvDataReaderViewAssessmentsColumnSort = new CSVDataReaderViewAssessmentsColumnSort();


    //Logger and WebDrivers
    private static final Logger logger = LoggerFactory.getLogger(ViewAssessmentsSidebarPagesColumnSortTest.class);

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
        authX = config.getAuthx();
        BrowserInitHelper.setup();
        BrowserInitHelper.getInstance().manage().window().maximize();
    }

    @AfterExecution
    //for closing the browser
    public void cleanup() {
        if (BrowserInitHelper.getInstance() != null) {
            BrowserInitHelper.tearDown();
        }
    }


    public void e_StartBrowser() {
        //checking for csv datd
    ConsoleLogger.SuccessLog(csvDataReaderViewAssessmentsColumnSort.getCreatedBy());
    }

    public void v_BrowserStarted() {
        Assert.assertNotNull(BrowserInitHelper.getInstance());
    }

    public void e_EnterBaseURL() {
        BrowserInitHelper.getInstance().get(url);
    }

    public void v_BaseURL() {
        BrowserInitHelper.getWaiter().until(ExpectedConditions.titleContains("Illuminate Education"));
    }

    public void e_DirectLogin() {
        //if AuthX is ON
        if (authX.contains("ON")) {
            LoginController.loginAuthXSite(username, password);
        } else {
            //if AuthX is OFF
            LoginController.login(username, password);
        }
    }


    public void v_Dashboard() {

    }

    public void e_ClickNavbar() {
        DriverHelper.waitTill(5);
        Helper.clickXpath(assessmentsNavbar.getClickAssessment());

    }

    public void v_Navbar() {

    }

    public void e_ViewAssessments() {
        Helper.clickXpath(assessmentsNavbar.getViewAssessment());
        controller.checkPopup();
        waitUntilAjaxLoaded();
    }

    public void v_ViewAssessments() {
        String headerText = Helper.getText(viewAssessments.getViewAssessmentsHeader());
        Assert.assertEquals("View Assessments", headerText);
    }

    public void v_VerifyViewAssessmentsSidebarPagesColumnSort() {

    }

}
