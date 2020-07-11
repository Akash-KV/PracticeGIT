import Controllers.LoginController;
import DataReaders.CSVDataReaderViewAssessmentsColumnSort;
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

@GraphWalker(value = "quick_random(edge_coverage(100))", start = "e_StartBrowser")
/*Test Class for LoginPageTest*/
public class LoginPageTest extends ExecutionContext implements LoginPage {


    //Declarations
    Config config = new Config();
    String browser, url, username, password, closeBrowser, multiSite, ticket, chrome, firefox, authX;
    Boolean headless;
    int waitTime;

    CSVDataReaderViewAssessmentsColumnSort csvDataReaderViewAssessmentsColumnSort = new CSVDataReaderViewAssessmentsColumnSort();

    //Logger and WebDrivers
    private static final Logger logger = LoggerFactory.getLogger(LoginPageTest.class);

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
        authX = config.getAuthx();
        BrowserInitHelper.setup();
        BrowserInitHelper.getInstance().manage().window().maximize();
    }

    @AfterExecution
    //for closing the browser
    public void cleanup() {
        if (BrowserInitHelper.getInstance() != null) {
            BrowserInitHelper.tearDown();
        }
    }


    public void e_StartBrowser() {
        //checking for csv datd
        ConsoleLogger.SuccessLog(csvDataReaderViewAssessmentsColumnSort.getCreatedBy());
    }

    public void v_BrowserStarted() {
        Assert.assertNotNull(BrowserInitHelper.getInstance());
    }

    public void e_EnterBaseURL() {
        BrowserInitHelper.getInstance().get(url);
    }

    public void v_BaseURL() {
        BrowserInitHelper.getWaiter().until(ExpectedConditions.titleContains("Illuminate Education"));
    }

    public void e_DirectLogin() {
        //if AuthX is ON
        if (config.getAuthx().equalsIgnoreCase("true")) {
            LoginController.loginAuthXSite(username, password);
        } else {
            LoginController.login(username, password);
        }
    }


    public void v_Dashboard() {
    }
}
