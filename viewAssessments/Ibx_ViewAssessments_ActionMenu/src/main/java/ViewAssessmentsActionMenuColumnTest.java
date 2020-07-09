
import Controllers.LoginController;
import Controllers.ViewAssessmentsController;
import Helpers.DriverHelper;
import Helpers.BrowserInitHelper;
import Helpers.JavascriptHelper;
import Pom.*;
import Utils.ConsoleLogger;
import Utils.DataReader;
import org.graphwalker.core.machine.ExecutionContext;
import org.graphwalker.java.annotation.AfterExecution;
import org.graphwalker.java.annotation.BeforeExecution;
import org.graphwalker.java.annotation.GraphWalker;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import Utils.Config;

import java.util.List;

//Java Class for ViewAssessmentsActionMenuColumnTest
@GraphWalker(value = "quick_random(edge_coverage(100))", start = "e_StartBrowser")
public class ViewAssessmentsActionMenuColumnTest extends ExecutionContext implements ViewAssessmentsActionMenuColumn {

    //Declarations
    Config config = new Config();
    String browser, url, username, password, closeBrowser, multiSite, ticket, chrome, authX;
    Boolean headless;
    int waitTime;

    //Logger and WebDrivers
    private static final Logger logger = LoggerFactory.getLogger(ViewAssessmentsActionMenuColumnTest.class);

    LoginPage loginPOM = new LoginPage();
    Dashboard dashboardPOM = new Dashboard();
    BrowserInitHelper browserHelper = new BrowserInitHelper();
    DataReader reader = new DataReader();
    ViewAssessmentsPage viewAssessmentsPage = new ViewAssessmentsPage();
    ViewAssessmentsController viewAssessmentsController = new ViewAssessmentsController();
    ViewAssessments_AddFilters viewAssessments_AddFilters = new ViewAssessments_AddFilters();
    OnlineTestingAssessmentAdministrations onlineTesting = new OnlineTestingAssessmentAdministrations();
    OnlineAssessmentPreviewWindow onlineTestingPreviewWindow = new OnlineAssessmentPreviewWindow();
    CameraGraderPage cameraGraderPage = new CameraGraderPage();
    ViewStudentResponsesPage viewStudentsResponsesPage = new ViewStudentResponsesPage();
    AssessmentSharePage assessmentSharePage = new AssessmentSharePage();

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
        authX = config.getAuthX();
        ticket = config.getTicket();

        BrowserInitHelper.setup();
    }

    @AfterExecution
    public void cleanup() {
        if (BrowserInitHelper.getInstance() != null) {
            // BrowserInitHelper.tearDown();
        }
    }

    //Start Browser
    public void e_StartBrowser() {
        //Driver Instance
        System.out.println(browser);
    }

    //Validate Browser started
    public void v_BrowserStarted() {

    }

    //Enter Base URL
    public void e_EnterBaseURL() {
        BrowserInitHelper.getInstance().manage().window().maximize();
        BrowserInitHelper.getInstance().get(url);
    }

    //Validate Base URL
    public void v_BaseURL() {

    }

    //Method For Direct Login
    public void e_EnterCredentials() {
        // LoginController.login(username, password);
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

        /*Get all the Titles shown in Dashboard flip cards*/
        List<WebElement> TileTitleElement = BrowserInitHelper.getInstance().findElements(By.xpath(dashboardPOM.getDashboardTile()));

        for (int i = 0; i < TileTitleElement.size(); i++) {
            BrowserInitHelper.getWaiter().until(ExpectedConditions.elementToBeClickable(TileTitleElement.get(i)));
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

    //Method for Clicking on Assessments
    public void e_ClickViewAssessments() {
        /*Click Assessments icon in Navigation sidebar*/
        DriverHelper.clickXpath(dashboardPOM.getAssessmentsIcon());

        /*Click View Assessments Link*/
        DriverHelper.clickXpath(dashboardPOM.getViewAssessmentsLink());

        /*Wait until View Assessments header appears*/
        BrowserInitHelper.waitUntil(dashboardPOM.getViewAssessmentsHeader());
        DriverHelper.waitUntilLoaderInvisible();
    }

    //Validate View Assessments
    public void v_VerifyViewAssessments() {
        /*Wait until the display of View Assessments header*/
        BrowserInitHelper.waitUntil(dashboardPOM.getViewAssessmentsHeader());

        browserHelper.assertion(dashboardPOM.getViewAssessmentsHeader(), "View Assessments");
    }

    public void e_ClickCreatedByMe() {
        /*Click Created By Me link*/
        DriverHelper.clickXpath(viewAssessmentsPage.getCreatedByMe());
    }

    public void v_VerifyCreatedByMeHeader() {
        /*Validate Created By me Header*/
        browserHelper.assertion(viewAssessmentsPage.getCreatedByMeHeader(), "Created By Me");
    }

    public void e_ClickAddFilters() {
        /*Click Add Filter button*/
        DriverHelper.clickXpath(viewAssessmentsPage.getAddFilters());
    }

    public void v_VerifyFilterModal() {
        /*Validate the display of Filters Modal*/
        WebElement Element = BrowserInitHelper.getInstance().findElement(By.xpath(viewAssessments_AddFilters.getAddFilterPopup()));
        Assert.assertTrue(DriverHelper.elementExistence(Element, BrowserInitHelper.getInstance()));
    }

    public void e_SelectItemBankTypeAndSearch() {
        /*Click Type filter*/
        System.out.println(viewAssessments_AddFilters.getTypeFilter());
        DriverHelper.clickXpath(viewAssessments_AddFilters.getTypeFilter());

        /*Enter Item Bank in Type Filter*/
        DriverHelper.sendKeysXpath(viewAssessments_AddFilters.getTypeFilter(), "Item Bank", BrowserInitHelper.getWaiter(), BrowserInitHelper.getInstance());

        /*Select Item Bank option*/
        DriverHelper.clickXpath(viewAssessments_AddFilters.getTypeOption("Item Bank"));

        /*Click Search button*/
        JavascriptHelper.clickID_JS(viewAssessments_AddFilters.getSearchButton_AddFilters());

        setAttribute("itemBank", false);
        setAttribute("assessment", true);
    }

    public void v_VerifyAssessmentDataTable() {
        DriverHelper.waitUntilLoaderInvisible();
        ConsoleLogger.SuccessLog("Complete the ViewAssessmentsActionMenuColumnTest Java class");
    }
}
