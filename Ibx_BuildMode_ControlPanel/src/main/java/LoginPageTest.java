import Controllers.*;
import Helpers.BrowserInitHelper;
import Helpers.DriverHelper;
import Utils.Dynamic;
import Utils.LoggerUtility;
import Utils.Secure;
import Utils.Static;
import org.graphwalker.core.machine.ExecutionContext;
import org.graphwalker.java.annotation.AfterExecution;
import org.graphwalker.java.annotation.BeforeExecution;
import org.graphwalker.java.annotation.GraphWalker;
import org.junit.Assert;

/**
 * Test class for LoginPage
 **/
@GraphWalker(value = "quick_random(edge_coverage(100))", start = "e_StartBrowser")
public class LoginPageTest extends ExecutionContext implements LoginPage {

    //Declarations
    Secure secure = new Secure();
    Dynamic dynamic = new Dynamic();
    Static aStatic = new Static();
    String browser, url, username, password, closeBrowser, multiSite, ticket, chrome, districtName, authX;
    Boolean headless;
    int waitTime;

    @BeforeExecution
    public void setup() {
        secure.readProperties();
        dynamic.readProperties();
        aStatic.readProperties();
        BrowserInitHelper.deleteFile(DriverHelper.getDeletePath());
        browser = dynamic.getBrowser();
        waitTime = dynamic.getWaitTime();
        url = dynamic.getURL();
        username = secure.getUsername();
        password = secure.getPassword();
        closeBrowser = aStatic.getCloseBrowser();
        multiSite = aStatic.getMultiSite();
        ticket = dynamic.getTicket(); //added 01/10/19
        headless = dynamic.getHeadless();
        chrome = aStatic.getChrome();
        BrowserInitHelper.setup();
        authX = dynamic.getAuthX();
    }

    @AfterExecution
    public void cleanup() {
        if (BrowserInitHelper.getInstance() != null) {
            BrowserInitHelper.tearDown();
        }
    }

    public void e_StartBrowser() {
    }

    // To validate Browser Started
    public void v_BrowserStarted() {
        Assert.assertNotNull(BrowserInitHelper.getInstance());
        LoggerUtility.LoggerCall("Browser Started...");
    }

    // To Enter Url
    public void e_EnterBaseURL() {
        BrowserInitHelper.getInstance().manage().window().maximize();
        BrowserInitHelper.getInstance().get(url);
    }

    public void v_BaseURL() {
    }

    // To enter credentials
    public void e_EnterCredentials() {
        if (Dynamic.getAuthX().equalsIgnoreCase("true")) {
            LoginController.loginAuthXSite(username, password);
        } else {
            LoginController.login(username, password);
        }
    }

    // To validate DashboardPage
    public void v_Dashboard() {
    }

    //Validate Control panel
    public void v_VerifyControlPanel() {
    }

}

