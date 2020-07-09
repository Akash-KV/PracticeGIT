import Controllers.DashBoardController;
import Controllers.ItemBankAssessmentController;
import Controllers.LoginController;
import Controllers.OnlineTestingAdministrationController;
import Helpers.BrowserInitHelper;
import Pom.Dashboard;
import Utils.Config;
import org.graphwalker.core.machine.ExecutionContext;
import org.graphwalker.java.annotation.AfterExecution;
import org.graphwalker.java.annotation.BeforeExecution;
import org.graphwalker.java.annotation.GraphWalker;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@GraphWalker(value = "quick_random(edge_coverage(100))", start = "e_StartBrowser")
public class LoginPageTest extends ExecutionContext implements LoginPageModel {
    //Declarations
    Config config = new Config();
    String browser, url, username, password, closeBrowser, multiSite, ticket, authX;
    int waitTime;

    String dir = null;
    String uploadPdf;
    //Logger and WebDrivers
    DashBoardController dashBoardController = new DashBoardController();
    Dashboard dashboardPOM = new Dashboard();
    LoginController loginController = new LoginController();

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
        dashboardPOM.readProperties();
        dir = System.getProperty("user.dir");
        uploadPdf = System.getProperty("user.dir") + "/src/main/resources/StudentPDF.pdf";
    }

    @AfterExecution
    public void cleanup() {
        if (BrowserInitHelper.getInstance() != null) {
            //  BrowserInitHelper.tearDown();
        }
    }

    //Enter Start Browser
    public void e_StartBrowser() {
        //Driver Instance
        System.out.println(browser);
    }

    //Validate Browser Started
    public void v_BrowserStarted() {

    }

    //enter URL
    public void e_EnterBaseURL() {
        BrowserInitHelper.getInstance().manage().window().maximize();
        BrowserInitHelper.getInstance().get(url);
    }

    //validate URL
    public void v_BaseURL() {

    }

    //Click on Login
    public void e_DirectLogin() {
        try {
            if (authX.equalsIgnoreCase("true")) {
                LoginController.loginAuthXSite(username, password);
            } else {
                LoginController.login(username, password);
            }
        } catch (Exception e) {
            System.out.println("login through admin is not successfull");
        }
        loginController.adminLogin();

    }

    //Validate Dashboard
    public void v_Dashboard() {
        dashBoardController.validateDashBoard();
    }

}
