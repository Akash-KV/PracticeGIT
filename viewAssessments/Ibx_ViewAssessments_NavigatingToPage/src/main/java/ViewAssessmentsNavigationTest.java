
import Controllers.LoginController;
import Helpers.DriverHelper;
import Helpers.BrowserInitHelper;
import Pom.Dashboard;
import Pom.LoginPage;
import Utils.ConsoleLogger;
import org.graphwalker.core.machine.ExecutionContext;
import org.graphwalker.java.annotation.AfterExecution;
import org.graphwalker.java.annotation.BeforeExecution;
import org.graphwalker.java.annotation.GraphWalker;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import Utils.Config;

import java.util.List;

@GraphWalker(value = "quick_random(edge_coverage(100))", start = "e_StartBrowser")
public class ViewAssessmentsNavigationTest extends ExecutionContext implements ViewAssessmentsNavigation {

    //Declarations
    Config config = new Config();
    String browser, url, username, password, closeBrowser, multiSite, ticket, chrome, authX;
    Boolean headless;
    int waitTime;
    DriverHelper driverHelper = new DriverHelper();

    //Logger and WebDrivers
    private static final Logger logger = LoggerFactory.getLogger(ViewAssessmentsNavigationTest.class);

    LoginPage loginPOM = new LoginPage();
    Dashboard dashboardPOM = new Dashboard();
    BrowserInitHelper browserHelper = new BrowserInitHelper();
    LoginController controller = new LoginController();

    @BeforeExecution
    public void setup() {
        //Config
        config.readProperties();
        browser = config.getBrowser();
        waitTime = config.getWaitTime();
        url = config.getURL();
        username = config.getUsername();
        password = config.getPassword();
        closeBrowser = config.getCloseBrowser();
        multiSite = config.getMultiSite();
        ticket = config.getTicket();
        authX = config.getAuthX();
        BrowserInitHelper.setup();
    }

    @AfterExecution
    public void cleanup() {
        if (BrowserInitHelper.getInstance() != null) {
           // BrowserInitHelper.tearDown();
        }
    }

    public void e_StartBrowser() {
        //Driver Instance
        System.out.println(browser);
    }

    //Validate Browser started
    public void v_BrowserStarted() {

    }

    //Enter URL
    public void e_EnterBaseURL() {
        BrowserInitHelper.getInstance().manage().window().maximize();
        BrowserInitHelper.getInstance().get(url);
    }

    //Validate URL
    public void v_BaseURL() {

    }

    //Enter valid credentials
    public void e_EnterCredentials() {
        if (authX.contains("ON")) {
            LoginController.loginAuthXSite(username, password);
        } else {
            LoginController.login(username, password);
        }
    }

    //Validate Dashboard
    public void v_Dashboard() {
        String TitleTile;
        boolean isExist = false;

        /*Wait till Illuminate Logo appears*/
        BrowserInitHelper.waitUntil(dashboardPOM.getIlluminateLogo());
        controller.checkPopup();

        /*Get all the Titles shown in Dashboard flip cards*/
        List<WebElement> TileTitleElement = BrowserInitHelper.getInstance().findElements(By.xpath("//ul[@id = 'tile-holder']/li//div[@class = 'tile-title']"));

        for (int i = 0; i < TileTitleElement.size(); i++) {
            TitleTile = TileTitleElement.get(i).getText().replaceAll("\n", " ");

            /*Validate if View Assessment tile is showing or not*/
            if (TitleTile.equalsIgnoreCase("View Assessments")) {
                isExist = true;
                break;
            }
        }
        TileTitleElement = null;
        Assert.assertTrue(isExist);
    }

    //Click on ViewAssessments
    public void e_ClickViewAssessments() {
        /*Click Assessments icon in Navigation sidebar*/
        driverHelper.clickXpath(dashboardPOM.getAssessmentsIcon());

        /*Click View Assessments Link*/
        driverHelper.clickXpath(dashboardPOM.getViewAssessmentsLink());
        controller.checkPopup();

        /*Wait until View Assessments header appears*/
        BrowserInitHelper.waitUntil(dashboardPOM.getViewAssessmentsHeader());
    }

    //Validate ViewAssessments
    public void v_ValidateViewAssessments() {
        browserHelper.assertion(dashboardPOM.getViewAssessmentsHeader(), "View Assessments");
        ConsoleLogger.SuccessLog("Navigated to View Assessments from View Assessments Link...");
    }

    // Click on Illuminate Logo
    public void e_ClickIlluminateLogo() {
        /*Click Illuminate Logo in Navigation sidebar*/
        driverHelper.clickXpath(dashboardPOM.getIlluminateLogo());
    }

    //Validate Assessments Dashboard
    public void v_ValidateAssessmentsDashboard() {
        String TitleTile;
        boolean isExist = false;

        /*Wait until Dashboard header appears*/
        BrowserInitHelper.waitUntil(dashboardPOM.getDasdhboardHeader());

        /*Get all the Titles shown in Dashboard flip cards*/
        List<WebElement> TileTitleElement = BrowserInitHelper.getInstance().findElements(By.xpath("//ul[@id = 'tile-holder']/li//div[@class = 'tile-title']"));

        for (int i = 0; i < TileTitleElement.size(); i++) {
            TitleTile = TileTitleElement.get(i).getText().replaceAll("\n", " ");

            /*Validate if View Assessment tile is showing or not*/
            if (TitleTile.equalsIgnoreCase("View Assessments")) {
                isExist = true;
                break;
            }
        }
        TileTitleElement = null;
        Assert.assertTrue(isExist);
    }

    //Click ViewAssessments Tile
    public void e_ClickViewAssessmentsTile() {
        String TitleTile;

        /*Get all the Titles shown in Dashboard flip cards*/
        List<WebElement> TileTitleElement = BrowserInitHelper.getInstance().findElements(By.xpath("//ul[@id = 'tile-holder']/li//div[@class = 'tile-title']"));

        for (int i = 0; i < TileTitleElement.size(); i++) {
            TitleTile = TileTitleElement.get(i).getText().replaceAll("\n", " ");

            /*Validate if View Assessment tile is showing or not*/
            if (TitleTile.equalsIgnoreCase("View Assessments")) {
                TileTitleElement.get(i).click();
                break;
            }
        }

        /*Wait until View Assessments header appears*/
        BrowserInitHelper.waitUntil(dashboardPOM.getViewAssessmentsHeader());
    }

    //Validate View Assessments
    public void v_VerifyViewAssessments() {
        browserHelper.assertion(dashboardPOM.getViewAssessmentsHeader(), "View Assessments");
        ConsoleLogger.SuccessLog("Navigated to View Assessments from Dashboard Tile...");
    }
}
