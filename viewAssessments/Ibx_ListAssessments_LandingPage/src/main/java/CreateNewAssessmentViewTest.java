import Controllers.ListAssessmentsController;
import Controllers.LoginController;
import Controllers.NavbarController;
import Helpers.BrowserInitHelper;
import Helpers.DriverHelper;
import Helpers.JSExecutorHelper;
import Pom.AssessmentViewPage;
import Utils.Config;
import Utils.ConsoleLogger;
import org.graphwalker.core.machine.ExecutionContext;
import org.graphwalker.java.annotation.AfterExecution;
import org.graphwalker.java.annotation.BeforeExecution;
import org.graphwalker.java.annotation.GraphWalker;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

//Test class for CreateNewAssessment View Test
@GraphWalker(value = "quick_random(edge_coverage(100))", start = "e_StartBrowser")
public class CreateNewAssessmentViewTest extends ExecutionContext implements CreateNewAssessmentView {
    public static AssessmentViewPage assessmentViewPage = new AssessmentViewPage();

    //Declarations
    Config config = new Config();
    String browser, url, username, password, closeBrowser, multiSite, ticket, chrome, authX;
    Boolean headless;
    int waitTime;

    //Logger and WebDrivers
    private static final Logger logger = LoggerFactory.getLogger(CreateNewAssessmentViewTest.class);
    // private WebDriver driver;

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

    //Browser Started
    public void e_StartBrowser() {
    }

    //Validate Browser Started
    public void v_BrowserStarted() {
        Assert.assertNotNull(BrowserInitHelper.getInstance());
    }

    //Enter URL
    public void e_EnterBaseURL() {
        BrowserInitHelper.getInstance().get(url);
    }

    //Validate URL
    public void v_BaseURL() {
        BrowserInitHelper.getWaiter().until(ExpectedConditions.titleContains("Illuminate Education"));
    }

    //Enter login credentials
    public void e_DirectLogin() {
        //LoginController.login(username, password);
        if (authX.contains("ON")) {
            LoginController.loginAuthXSite(username, password);
        } else {
            LoginController.login(username, password);
        }
    }

    //Validate Dashboard
    public void v_Dashboard() {

    }

    //Click on ViewAssessments
    public void e_ClickViewAssessments() {
        NavbarController.getListAssessments();
        JSExecutorHelper.waitUntilDocumentIsReady();
    }

    //Validate View Assessments
    public void v_ViewAssessments() {

        String currentUrl = BrowserInitHelper.getInstance().getCurrentUrl();
        JavascriptExecutor js = (JavascriptExecutor) BrowserInitHelper.getInstance();

        // DriverHelper.waitTill(5);
        DriverHelper.waitForPageLoadComplete();

        // Itembank - Without Data


        ListAssessmentsController.FilterModalController.getFilterModal();
        ListAssessmentsController.FilterModalController.getAssessmentType("Item");
        // DriverHelper.waitTill(2);
        DriverHelper.waitForPageLoadComplete();
        ListAssessmentsController.ShowAssessmentWithDataToggle.toggleOff();
        // DriverHelper.waitTill(5);
        DriverHelper.waitForPageLoadComplete();
        ListAssessmentsController.ResultsTableController.getFirstRow();
        try {
            //  BrowserInitHelper.getWaiter().until((ExpectedConditions.elementToBeClickable(By.xpath(assessmentViewPage.getItembankWithoutLocated()))));
            // DriverHelper.waitTill(5);
            DriverHelper.waitForPageLoadComplete();
            BrowserInitHelper.getWaiter().until(ExpectedConditions.visibilityOfElementLocated(By.xpath(assessmentViewPage.getItembankWithoutLocated())));
            ConsoleLogger.SuccessLog("Landing page of published Itembank assessment without student data is verified");
        } catch (Exception e) {
            ConsoleLogger.DebugLog("{Test Case: Itembank - Without Data} Assessment listed as assessment without student data contains data.");
        }

        // Itembank - With Data
        //BrowserInitHelper.getInstance().get(currentUrl);
        js.executeScript("window.history.back()", "");
        //DriverHelper.waitTill(5);
        DriverHelper.waitForPageLoadComplete();
        ListAssessmentsController.FilterModalController.getFilterModal();
        ListAssessmentsController.FilterModalController.getAssessmentType("Item");
        //DriverHelper.waitTill(2);
        DriverHelper.waitForPageLoadComplete();
        ListAssessmentsController.ShowAssessmentWithDataToggle.toggleOn();
        //  DriverHelper.waitTill(5);
        DriverHelper.waitForPageLoadComplete();
        try {
            BrowserInitHelper.getWaiter().until(ExpectedConditions.visibilityOfElementLocated(By.xpath(assessmentViewPage.getItembankWithLocated())));
            ConsoleLogger.SuccessLog("Landing page of published Itembank assessment with student data is verified");
        } catch (Exception e) {
            ConsoleLogger.FailedTestCase("{Test Case: Itembank - With Data} Data circle is not visible or not green.");
        }
        ListAssessmentsController.ResultsTableController.getFirstRow();
        try {
            BrowserInitHelper.getWaiter().until(ExpectedConditions.visibilityOfElementLocated(By.xpath(assessmentViewPage.getItembankWithStudentResponse())));
        } catch (Exception e) {
            ConsoleLogger.FailedTestCase("{Test Case: Itembank - With Data} Assessment listed as assessment with student data contains no student responses.");
        }

        // Flexible - With Data
        //BrowserInitHelper.getInstance().get(currentUrl);
        js.executeScript("window.history.back()", "");
        //  DriverHelper.waitTill(5);
        DriverHelper.waitForPageLoadComplete();

        ListAssessmentsController.FilterModalController.getFilterModal();
        ListAssessmentsController.FilterModalController.getAssessmentType("Assessment");
        DriverHelper.waitForPageLoadComplete();
        ListAssessmentsController.ShowAssessmentWithDataToggle.toggleOn();
        DriverHelper.waitForPageLoadComplete();
        boolean match = ListAssessmentsController.ResultsTableController.getFlexibleAssessment();
        if (match) {
            try {
                //BrowserInitHelper.getWaiter().until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='pb-highchart']")));
                // DriverHelper.waitTill(5);
                DriverHelper.waitForPageLoadComplete();
                BrowserInitHelper.getWaiter().until(ExpectedConditions.visibilityOfElementLocated(By.xpath(assessmentViewPage.getFlexibleWithLocated())));
                ConsoleLogger.SuccessLog("\"Landing page of flexible assesment with student data is verified\"");
            } catch (Exception e) {
                ConsoleLogger.DebugLog("{Test Case: Flexible - With Data} Assessment listed as assessment with student data contains no student responses.");
            }
        } else {
            ConsoleLogger.DebugLog("{Test Case: Flexible - With Data} No assessment found in results table");
        }
        // Flexible - Without Data
        //BrowserInitHelper.getInstance().get(currentUrl);
        js.executeScript("window.history.back()", "");
        //  DriverHelper.waitTill(5);
        DriverHelper.waitForPageLoadComplete();

        ListAssessmentsController.FilterModalController.getFilterModal();
        ListAssessmentsController.FilterModalController.getAssessmentType("Assessment");
        // DriverHelper.waitTill(2);
        DriverHelper.waitForPageLoadComplete();
        ListAssessmentsController.ShowAssessmentWithDataToggle.toggleOff();
        // DriverHelper.waitTill(5);
        DriverHelper.waitForPageLoadComplete();
        match = ListAssessmentsController.ResultsTableController.getFlexibleAssessment();
        if (match) {
            try {
                BrowserInitHelper.getWaiter().until(ExpectedConditions.visibilityOfElementLocated(By.xpath(assessmentViewPage.getFlexibleWithoutTitle())));
                ConsoleLogger.SuccessLog("Landing page of flexible assesment without student data is verified");
            } catch (Exception e) {
                ConsoleLogger.FailedTestCase("{Test Case: Flexible - Without Data} Assessment listed as assessment without student data contains data.");
            }
        } else {
            ConsoleLogger.FailedTestCase("{Test Case: Flexible - Without Data} No assessment found in results table");
        }

        // M/H Assessment - With Data
        //BrowserInitHelper.getInstance().get(currentUrl);
        js.executeScript("window.history.back()", "");
        DriverHelper.waitTill(5);
        //DriverHelper.waitForPageLoadComplete();

        ListAssessmentsController.FilterModalController.getFilterModal();
        ListAssessmentsController.FilterModalController.getAssessmentType("Assessment");
        DriverHelper.waitTill(2);
        // WebDriverWait wait = new WebDriverWait(BrowserInitHelper.getInstance(), 10);
        // wait.until(ExpectedConditions.visibilityOf(BrowserInitHelper.getInstance().findElement(By.xpath(assessmentViewPage.getOnlyShowAsmtToggleInput()))));
        DriverHelper.waitForPageLoadComplete();
//DriverHelper.waitFluentByXpath(BrowserInitHelper.getInstance(),assessmentViewPage.getOnlyShowAsmtToggleInput());
        ListAssessmentsController.ShowAssessmentWithDataToggle.toggleOn();
        // DriverHelper.waitFluentByXpath(BrowserInitHelper.getInstance(),assessmentViewPage.getOnlyShowAsmtToggleInput());
        // DriverHelper.waitTill(5);
        //  DriverHelper.waitUntilElementInvisible_ByXPath(assessmentViewPage.getOnlyShowAsmtToggleInput());
        DriverHelper.waitForPageLoadComplete();
        match = ListAssessmentsController.ResultsTableController.getManualHybridAssessmentWithData();
        if (match) {
            try {
                BrowserInitHelper.getWaiter().until(ExpectedConditions.visibilityOfElementLocated(By.xpath(assessmentViewPage.getItembankWithStudentResponse())));
                ConsoleLogger.SuccessLog("Landing page of M/H assesment with student data is verified");
            } catch (Exception e) {
                ConsoleLogger.FailedTestCase("{Test Case: M/H - With Data} Assessment listed as assessment with student data contains no student responses.");
            }
        } else {
            ConsoleLogger.FailedTestCase("{Test Case: M/H - With Data} No assessment found in results table");
        }

        // M/H Assessment - Without Data
        //BrowserInitHelper.getInstance().get(currentUrl);
        js.executeScript("window.history.back()", "");
        DriverHelper.waitTill(5);
        // DriverHelper.waitForPageLoadComplete();
        JSExecutorHelper.waitUntilAjaxLoaded();
        ListAssessmentsController.FilterModalController.getFilterModal();
        ListAssessmentsController.FilterModalController.getAssessmentType("Assessment");
        DriverHelper.waitTill(5);
        //JSExecutorHelper.waitUntilAjaxLoaded();
        //DriverHelper.waitForPageLoadComplete();
        ListAssessmentsController.ShowAssessmentWithDataToggle.toggleOff();
        // DriverHelper.waitTill(5);
        DriverHelper.waitForPageLoadComplete();
        match = ListAssessmentsController.ResultsTableController.getManualHybridAssessmentWithoutData();
        if (match) {
            try {
                BrowserInitHelper.getWaiter().until(ExpectedConditions.visibilityOfElementLocated(By.xpath(assessmentViewPage.getItembankWithoutLocated())));
                ConsoleLogger.SuccessLog("Landing page of M/H assesment without student data is verified");
            } catch (Exception e) {
                ConsoleLogger.FailedTestCase("{Test Case: M/H - Without Data} Assessment listed as assessment without student data contains data.");
            }
        } else {
            ConsoleLogger.FailedTestCase("{Test Case: M/H - Without Data} No assessment found in results table");
        }

        //System.exit(0);
    }
}
