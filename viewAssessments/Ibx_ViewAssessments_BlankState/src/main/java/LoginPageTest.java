import Controllers.LoginController;
import Helpers.BrowserInitHelper;
import Utils.Config;
import org.graphwalker.core.machine.ExecutionContext;
import org.graphwalker.java.annotation.AfterExecution;
import org.graphwalker.java.annotation.BeforeExecution;
import org.graphwalker.java.annotation.GraphWalker;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static Helpers.BrowserInitHelper.getInstance;

@GraphWalker(value = "quick_random(edge_coverage(100))", start = "e_StartBrowser")
public class LoginPageTest extends ExecutionContext implements LoginPage {

    Config config = new Config();
    String browser, url, username, password, closeBrowser, multiSite, ticket, chrome, authX;
    Boolean headless;
    int waitTime;

    //Logger and WebDrivers
    private static final Logger logger = LoggerFactory.getLogger(ViewAssessmentsBlankStateTest.class);

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
        if (getInstance() != null) {
            BrowserInitHelper.tearDown();
        }
    }

    // Starting the browser
    public void e_StartBrowser() {
        //Driver Instance
        System.out.println(browser);
    }

    public void v_BrowserStarted() {
    }

    // Entering the Url
    public void e_EnterBaseURL() {
        BrowserInitHelper.getInstance().manage().window().maximize();
        BrowserInitHelper.getInstance().navigate().to(url);
    }

    public void v_BaseURL() {
    }

    // Entering the Credentials
    public void e_DirectLogin() {
        if (config.getAuthX().equalsIgnoreCase("true")) {
            LoginController.loginAuthXSite(username, password);
        } else {
            LoginController.login(username, password);
        }
    }

    public void v_Dashboard() {
    }
}
