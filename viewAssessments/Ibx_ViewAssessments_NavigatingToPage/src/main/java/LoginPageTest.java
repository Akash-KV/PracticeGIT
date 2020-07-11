
import Controllers.DashboardController;
import Controllers.LoginController;
import Controllers.ViewAssessmentsController;
import Helpers.DriverHelper;
import Helpers.BrowserInitHelper;
import Pom.Dashboard;
import org.graphwalker.core.machine.ExecutionContext;
import org.graphwalker.java.annotation.AfterExecution;
import org.graphwalker.java.annotation.BeforeExecution;
import org.graphwalker.java.annotation.GraphWalker;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import Utils.Config;

// Test class for LoginPage
@GraphWalker(value = "quick_random(edge_coverage(100))", start = "e_StartBrowser")
public class LoginPageTest extends ExecutionContext implements LoginPage {


    //Declarations
    Config config = new Config();
    String browser, url, username, password, closeBrowser, multiSite, ticket, chrome, authX;
    Boolean headless;
    int waitTime;

    //Logger and WebDrivers
    private static final Logger logger = LoggerFactory.getLogger(LoginPageTest.class);

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
            BrowserInitHelper.tearDown();
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
        if (config.getAuthX().equalsIgnoreCase("true")) {
            LoginController.loginAuthXSite(username, password);
        } else {
            LoginController.login(username, password);
        }
    }

    //Validate Dashboard
    public void v_Dashboard() {
    }
}
