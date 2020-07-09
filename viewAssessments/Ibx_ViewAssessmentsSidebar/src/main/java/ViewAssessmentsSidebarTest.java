import Controllers.LoginController;
import Controllers.ViewAssessmentsController;
import Helpers.BrowserInitHelper;
import Pom.AssessmentsNavbar;
import Pom.Dashboard;
import Pom.ViewAssessments;
import Utils.Config;
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
//Test Class for ViewAssessmentsSidebarTest
public class ViewAssessmentsSidebarTest extends ExecutionContext implements ViewAssessmentsSidebar {

    //Declarations
    Config config = new Config();
    String browser, url, username, password, closeBrowser, multiSite, ticket, chrome, firefox, authX;
    Boolean headless;
    int waitTime;
    DriverHelper Helper = new DriverHelper();
    Dashboard dashboard = new Dashboard();
    AssessmentsNavbar assessmentsNavbar = new AssessmentsNavbar();
    ViewAssessments viewAssessmentsPage = new ViewAssessments();
    ViewAssessmentsController controller = new ViewAssessmentsController();

    //Logger and WebDrivers
    private static final Logger logger = LoggerFactory.getLogger(ViewAssessmentsSidebarTest.class);

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
    //For closing the browser
    public void cleanup() {
        if (BrowserInitHelper.getInstance() != null) {
       //     BrowserInitHelper.tearDown();
        }
    }

    public void e_StartBrowser() {

    }

    public void v_BrowserStarted() {
        Assert.assertNotNull(BrowserInitHelper.getInstance());
    }
    //entering the URL
    public void e_EnterBaseURL() {
        BrowserInitHelper.getInstance().get(url);
    }

    public void v_BaseURL() {
        BrowserInitHelper.getWaiter().until(ExpectedConditions.titleContains("Illuminate Education"));
        BrowserInitHelper.getInstance().manage().window().maximize();
    }

    public void e_DirectLogin() {
        //When AuthX is ON
        if (authX.contains("ON")) {
            LoginController.loginAuthXSite(username, password);
        } else {
            //When AuthX is OFF
            LoginController.login(username, password);
        }
    }


    public void v_Dashboard() {

    }

    public void e_ClickNavbar() {
    DriverHelper.waitTill(5);
            controller.checkPopup();
            Helper.clickXpath(dashboard.getAssessmentsNav());

    }

    public void v_Navbar() {

    }

    public void e_ViewAssessments() {
        Helper.clickXpath(assessmentsNavbar.getViewAssessment());
        controller.checkPopup();
        waitUntilAjaxLoaded();
    }

    public void v_ViewAssessments() {
        String headerText = Helper.getText(viewAssessmentsPage.getViewAssessmentsHeader());
        Assert.assertEquals("View Assessments", headerText);
    }

    public void v_VerifyViewAssessmentsSidebar() {
        //DriverHelper.clickXpath(viewAssessmentsPage.getClearAllInViewAssessments());
        WebElement viewAssessmentsFilters = BrowserInitHelper.getInstance().findElement(By.xpath(viewAssessmentsPage.getViewAssessmentsFilters()));
        Assert.assertEquals(true, viewAssessmentsFilters.isDisplayed());
        logger.info("View Assessments Filters is displayed.......");
    }
}