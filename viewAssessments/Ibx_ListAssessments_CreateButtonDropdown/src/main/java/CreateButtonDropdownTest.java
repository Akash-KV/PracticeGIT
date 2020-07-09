import Controllers.ListAssessmentsController;
import Controllers.LoginController;
import Controllers.NavbarController;
import Helpers.BrowserInitHelper;
import Helpers.DriverHelper;
import Pom.AssessmentsNavbar;
import Utils.Config;
import Utils.ConsoleLogger;
import org.graphwalker.core.machine.ExecutionContext;
import org.graphwalker.java.annotation.AfterExecution;
import org.graphwalker.java.annotation.BeforeExecution;
import org.graphwalker.java.annotation.GraphWalker;
import org.junit.Assert;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


//Test Class for Create Button Dropdown Test
@GraphWalker(value = "quick_random(edge_coverage(100))", start = "e_StartBrowser")
public class CreateButtonDropdownTest extends ExecutionContext implements CreateButtonDropdown {

    //Declarations
    Config config = new Config();
    String browser, url, username, password, closeBrowser, multiSite, ticket, chrome, authX;
    Boolean headless;
    int waitTime;

    //Logger and WebDrivers
    private static final Logger logger = LoggerFactory.getLogger(CreateButtonDropdownTest.class);

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
          //  BrowserInitHelper.tearDown();
        }
    }

    //Start Browser
    public void e_StartBrowser() {
    }

    //Validate Browser started
    public void v_BrowserStarted() {
        Assert.assertNotNull(BrowserInitHelper.getInstance());
    }

    //Enter Base URL
    public void e_EnterBaseURL() {

        BrowserInitHelper.getInstance().get(url);
        BrowserInitHelper.getInstance().manage().window().maximize();
    }

    //Validate Base URL
    public void v_BaseURL() {
        BrowserInitHelper.getWaiter().until(ExpectedConditions.titleContains("Illuminate Education"));
    }

    //Method For Direct Login
    public void e_DirectLogin() {
        if (authX.contains("ON")) {
            LoginController.loginAuthXSite(username, password);
        } else {
            LoginController.login(username, password);
        }
    }

    public void v_Dashboard() {

    }

    //Method for Clicking on Assessments
    public void e_ClickViewAssessments() {
        DriverHelper.waitTill(3);
        NavbarController.getListAssessments();
    }

    //Validate View Assessments
    public void v_ViewAssessments() {
        // e_ClickNavbarViewAssessments()
        ListAssessmentsController.CreateButton.clickCreateButton();
        ListAssessmentsController.CreateButton.clickAll();

        //Second Tab
        ListAssessmentsController.CreateButton.clickCreateButton();
        ListAssessmentsController.CreateButton.clickAllInOtherTab();

        //Third Tab
        ListAssessmentsController.CreateButton.clickAllInLegacyTab();
    }
}
