import Controllers.DashboardController;
import Controllers.LoginController;
import Controllers.ViewAssessmentsController;
import DataReaders.CSVDataReaderLocalIdentifier;
import Helpers.BrowserInitHelper;
import Helpers.DriverHelper;
import Helpers.JavascriptHelper;
import Pom.Dashboard;
import Pom.ViewAssessmentsPage;
import Utils.Config;
import org.graphwalker.core.machine.ExecutionContext;
import org.graphwalker.java.annotation.AfterExecution;
import org.graphwalker.java.annotation.BeforeExecution;
import org.graphwalker.java.annotation.GraphWalker;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


@GraphWalker(value = "quick_random(edge_coverage(100))", start = "e_EnterBaseUrl")
/** Test class for Ibx_ListAssessments_LocalIdentifier **/
public class LoginPageTest extends ExecutionContext implements LoginPage {

    LoginController loginController = new LoginController();

    //Declarations
    Config config = new Config();
    String browser, url, username, password, closeBrowser, multiSite, ticket, chrome, authX;
    Boolean headless;
    int waitTime;

    CSVDataReaderLocalIdentifier csvDataReaderLocalIdentifier = new CSVDataReaderLocalIdentifier();

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
        loginController.verifyLoginPage();
    }

    // To Enter Credentials
    public void e_DirectLogin() {
        if (config.getAuthX().equalsIgnoreCase("true")) {
            LoginController.loginAuthXSite(username, password);
        } else {
            LoginController.login(username, password);
        }
    }

    // To validate DashBoard page
    public void v_VerifyDashboard() {
    }
}
