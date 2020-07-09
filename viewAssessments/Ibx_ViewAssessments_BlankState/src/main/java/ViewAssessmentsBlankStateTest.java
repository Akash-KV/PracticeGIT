
import Controllers.LoginController;
import Controllers.ViewAssessments;
import Helpers.DriverHelper;
import Helpers.BrowserInitHelper;
import Helpers.JavascriptHelper;
import Pom.Dashboard;
import Pom.LoginPage;
import Pom.ViewAssessmentsPage;
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
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import Utils.Config;

import java.io.IOException;
import java.util.List;

import static Helpers.BrowserInitHelper.getInstance;

@GraphWalker(value = "quick_random(edge_coverage(100))", start = "e_StartBrowser")

// Test Class for ViewAssessmentsBlankState
public class ViewAssessmentsBlankStateTest extends ExecutionContext implements ViewAssessmentsBlankState {

    //Declarations
    Config config = new Config();
    String browser, url, username, password, closeBrowser, multiSite, ticket, chrome, authX;
    Boolean headless;
    int waitTime;

    //Logger and WebDrivers
    private static final Logger logger = LoggerFactory.getLogger(ViewAssessmentsBlankStateTest.class);

    LoginPage loginPOM = new LoginPage();
    Dashboard dashboardPOM = new Dashboard();
    BrowserInitHelper browserHelper = new BrowserInitHelper();
    DataReader reader = new DataReader();
    ViewAssessmentsPage viewAssessmentsPage = new ViewAssessmentsPage();
    ViewAssessments viewAssessmentsController = new ViewAssessments();

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
    public void e_EnterCredentials() {
        if (authX.contains("ON")) {
            LoginController.loginAuthXSite(username, password);
        } else {
            LoginController.login(username, password);
        }
    }

    // Validating Dashboard
    public void v_Dashboard() {
        String TitleTile;
        boolean isExist = false;

        /*Wait till Illuminate Logo appears*/
        BrowserInitHelper.waitUntil(dashboardPOM.getIlluminateLogo());
        viewAssessmentsController.checkPopup();

        /*Get all the Titles shown in Dashboard flip cards*/
        List<WebElement> TileTitleElement = getInstance().findElements(By.xpath("//ul[@id = 'tile-holder']/li//div[@class = 'tile-title']"));

        for (int i = 0; i < TileTitleElement.size(); i++) {
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

    // Clicking View_Assessment Tile
    public void e_ClickViewAssessmentsTile() {
        String TitleTile;

        /*Get all the Titles shown in Dashboard flip cards*/

        List<WebElement> TileTitleElement = getInstance().findElements(By.xpath("//ul[@id = 'tile-holder']/li//div[@class = 'tile-title']"));

        for (int i = 0; i < TileTitleElement.size(); i++) {
            TitleTile = TileTitleElement.get(i).getText().replaceAll("\n", " ");

            /*Validate if View Assessment tile is showing or not*/
            if (TitleTile.equalsIgnoreCase("View Assessments")) {
                TileTitleElement.get(i).click();
                break;
            }
        }

        /*Wait until loading icon disappears*/
        viewAssessmentsController.checkPopup();
        DriverHelper.waitUntilLoaderInvisible();
    }

    // Validating View_Assessments
    public void v_VerifyViewAssessments() {
        browserHelper.assertion(dashboardPOM.getViewAssessmentsHeader(), "View Assessments");
    }

    /*Validate the existence of Add Filter label*/
    public void v_VerifyFilters() {
        BrowserInitHelper.getWaiter().until(ExpectedConditions.visibilityOfElementLocated(By.xpath(viewAssessmentsPage.getAddFilters())));
        WebElement element = getInstance().findElement(By.xpath(viewAssessmentsPage.getAddFilters()));
        Assert.assertTrue(DriverHelper.elementExistence(element, getInstance()));
        ConsoleLogger.SuccessLog("Add filter label is Present as per the test case");
    }

    /*Validate Search textbox is empty*/
    public void v_VerifySearchBar() {
        BrowserInitHelper.getWaiter().until(ExpectedConditions.visibilityOfElementLocated(By.xpath(viewAssessmentsPage.getSearchAssessmentsBar())));
        WebElement element = getInstance().findElement(By.xpath(viewAssessmentsPage.getSearchAssessmentsBar()));
        String searchText = element.getText();
        Assert.assertTrue(element.getText().equalsIgnoreCase(""));
        ConsoleLogger.SuccessLog("Search textbox is empty as per the test case");
    }

    // Clicking show Assessments without Data_Toggle Button
    public void e_ClickShowAssessmentsWithoutDataToggleButton() {
        //BrowserInitHelper.getWaiter().until(ExpectedConditions.elementToBeClickable(By.id(viewAssessmentsPage.getShowAssessmentsWithoutDataToggleButton())));

        if (!JavascriptHelper.getToggleButtonState(viewAssessmentsPage.getShowAssessmentsWithoutDataToggleButton()).equalsIgnoreCase("true")) {
            /*Click Show Assessments Without Data toggle button*/
            JavascriptHelper.ClickByID_Javascript(viewAssessmentsPage.getShowAssessmentsWithoutDataToggleButton());

            /*Wait until loading icon disappears*/
            DriverHelper.waitUntilLoaderInvisible();
        }
    }

    // Validating show Assessments without Data_Toggle Button
    public void v_VerifyShowAssessmentsWithoutDataToggleButton() {
        if (browser.equalsIgnoreCase("chrome")) {
            /*Validate the background color of Assessments Without Data toggle button when it is set to Show mode*/
            Assert.assertTrue(ViewAssessments.getElementBackgroundColor(viewAssessmentsPage.getShowAssessmentsWithoutDataToggleButton(),
                    getInstance(), reader.getShowAssessmentsWithoutDataBackgroundColorChrome()));
            ConsoleLogger.SuccessLog("Background color of Assessments Without Data toggle button is matching as per the test data");
        } else if (browser.equalsIgnoreCase("firefox")) {
            /*Validate the background color of Assessments Without Data toggle button when it is set to Show mode*/
            Assert.assertTrue(ViewAssessments.getElementBackgroundColor(viewAssessmentsPage.getShowAssessmentsWithoutDataToggleButton(),
                    getInstance(), reader.getShowAssessmentsWithoutDataBackgroundColorFirefox()));
            ConsoleLogger.SuccessLog("Background color of Assessments Without Data toggle button is matching as per the test data");
        }
    }

    @AfterExecution
    public void cleanup() {
        if (getInstance() != null) {
            BrowserInitHelper.tearDown();
        }
    }
}
