import Controllers.LoginController;
import Helpers.BrowserInitHelper;
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

//Test class for LoginPage
@GraphWalker(value = "quick_random(edge_coverage(100))", start = "e_StartBrowser")
public class LoginPageTest extends ExecutionContext implements LoginPage {

    //Declarations
    String browser, url, username, password, closeBrowser, multiSite, ticket, chrome, authX;
    Boolean headless;
    int waitTime;
    Config config = new Config();

    //Logger and WebDrivers
    private static final Logger log = LoggerFactory.getLogger(LoginPageTest.class);

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
        ConsoleLogger.SuccessLog("Browser is started");
    }

    //Enter URL
    public void e_EnterBaseURL() {
        BrowserInitHelper.getInstance().manage().window().maximize();
        BrowserInitHelper.getInstance().get(url);
    }

    //Validate URL
    public void v_BaseURL() {
        BrowserInitHelper.getWaiter().until(ExpectedConditions.titleContains("Illuminate Education"));
    }

    //Enter login credentials
    public void e_DirectLogin() {
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