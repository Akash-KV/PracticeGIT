import Controllers.AddFilterController;
import Controllers.LoginController;
import DataReaders.CSVDataReaderLocalIdentifier;
import Helpers.BrowserInitHelper;
import Helpers.DriverHelper;
import Helpers.JavascriptHelper;
import Pom.Dashboard;
import Pom.ViewAssessmentsPage;
import Utils.Config;
import Utils.ConsoleLogger;
import org.graphwalker.core.machine.ExecutionContext;
import org.graphwalker.java.annotation.AfterExecution;
import org.graphwalker.java.annotation.BeforeExecution;
import org.graphwalker.java.annotation.GraphWalker;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


@GraphWalker(value = "quick_random(edge_coverage(100))", start = "e_EnterBaseUrl")
/** Test class for Ibx_ListAssessments_LocalIdentifier **/
public class Ibx_ListAssessments_LocalIdentifierTest extends ExecutionContext implements Ibx_ListAssessments_LocalIdentifier {

    //Declarations
    Config config = new Config();
    String browser, url, username, password, shared_username, shared_password, closeBrowser, multiSite, ticket, chrome, authX;
    Boolean headless;
    int waitTime;

    DriverHelper driverHelper = new DriverHelper();
    JavascriptHelper javascriptHelper = new JavascriptHelper();


    //Logger and WebDrivers
    private static final Logger log = LoggerFactory.getLogger(Ibx_ListAssessments_LocalIdentifierTest.class);

    BrowserInitHelper browserHelper = new BrowserInitHelper();
    CSVDataReaderLocalIdentifier csvDataReaderLocalIdentifier = new CSVDataReaderLocalIdentifier();
    Dashboard dashboard = new Dashboard();
    ViewAssessmentsPage viewAssessmentsPage = new ViewAssessmentsPage();


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
        csvDataReaderLocalIdentifier.getCsv();
    }

    @AfterExecution
    public void cleanup() {
        if (BrowserInitHelper.getInstance() != null) {
            BrowserInitHelper.tearDown();
        }
    }

    // To Enter Url
    public void e_EnterBaseUrl() {
        BrowserInitHelper.getInstance().get(url);
        BrowserInitHelper.getInstance().manage().window().maximize();
    }

    // To Validate LoginPage
    public void v_VerifyLoginPage() {
        String title = BrowserInitHelper.getInstance().getTitle();
        if (title.equalsIgnoreCase("Illuminate Education")) {
            Assert.assertTrue(true);
            ConsoleLogger.SuccessLog("loginPage is displayed");
        } else {
            ConsoleLogger.FailedTestCase("LoginPage is not displayed");
            Assert.assertTrue(false);

        }

    }

    // To Enter Credentials
    public void e_DirectLogin() {
        if (authX.contains("ON")) {
            LoginController.loginAuthXSite(username, password);
        } else {
            LoginController.login(username, password);
        }

    }

    // To validate DashBoard page
    public void v_VerifyDashboard() {
        boolean page = DriverHelper.checkElementDisplayByXpath(dashboard.getIlluminateLogo(), "DashboardPage");
        Assert.assertTrue(page);
    }

    // To Navigate ViewAssessments Page
    public void e_NavigateToViewAssessments() {
        DriverHelper.clickXpath(dashboard.getAssessmentsNav());
        DriverHelper.clickXpath(dashboard.getViewAssessmentsLink());

    }

    // To validate Viewassessments page
    public void v_VerifyViewAssessments() {
        BrowserInitHelper.getWaiter().until(ExpectedConditions.visibilityOfElementLocated(By.xpath(dashboard.getViewAssessmentsHeader())));
        boolean header = DriverHelper.checkElementDisplayByXpath(dashboard.getViewAssessmentsHeader(), "ViewAssessment");
        Assert.assertTrue(header);
    }

    // To Search Manual Hybrid
    public void e_SelectManualHybridType() {
        AddFilterController.clearSearch(csvDataReaderLocalIdentifier.getManualHybridAssessment());
        AddFilterController.toggleOff();

    }

    // To Validate Manual Hybrid Assessment
    public void v_VerifyManualHybridLocalIdentifier() {
        boolean title = AddFilterController.isElementClickable(viewAssessmentsPage.getFirstLinkAfterSearch(), "Manualhybrid Assessment Title");
        Assert.assertTrue(title);
        boolean ID = AddFilterController.isElementNotClickable(viewAssessmentsPage.getLocalidentifierforfirstlink(), "Manualhybrid Assessment Local Identifier");
        Assert.assertTrue(ID);
    }

    // To search Flexible Assessment
    public void e_SelectFlexibleType() {
        AddFilterController.clearSearch(csvDataReaderLocalIdentifier.getFlexibleAssessment());
        AddFilterController.toggleOff();

    }

    // To validate Flexible Assessment
    public void v_VerifyFlexibleLocalIdentifier() {
        boolean title = AddFilterController.isElementClickable(viewAssessmentsPage.getFirstLinkAfterSearch(), "Flexible Assessment Title");
        Assert.assertTrue(title);
        boolean ID = AddFilterController.isElementNotClickable(viewAssessmentsPage.getLocalidentifierforfirstlink(), "Flexible Assessment Local Identifier");
        Assert.assertTrue(ID);
    }

}
