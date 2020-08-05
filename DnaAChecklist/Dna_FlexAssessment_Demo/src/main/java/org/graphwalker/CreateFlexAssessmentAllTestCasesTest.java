package org.graphwalker;

import Controllers.*;
import io.github.bonigarcia.wdm.ChromeDriverManager;
import io.github.bonigarcia.wdm.DriverManagerType;
import io.github.bonigarcia.wdm.EdgeDriverManager;
import io.github.bonigarcia.wdm.FirefoxDriverManager;
import org.graphwalker.PageObjectModels.*;
import org.graphwalker.core.machine.ExecutionContext;
import org.graphwalker.java.annotation.AfterExecution;
import org.graphwalker.java.annotation.BeforeExecution;
import org.graphwalker.java.annotation.GraphWalker;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.SimpleDateFormat;

@GraphWalker(value = "quick_random(edge_coverage(100))", start = "e_StartBrowser")
/** Test class for CreateFlexAssessmentAllTestCases **/
public class CreateFlexAssessmentAllTestCasesTest extends ExecutionContext implements CreateFlexAssessmentAllTestCases {

    // Local Declarations
    String timeStamp = new SimpleDateFormat("HH:mm:ss-MM/dd/yyyy").format(new java.util.Date());
    Config config = new Config();
    Dashboard dashboard = new Dashboard();
    AssessmentsNavbar assessmentsNavbar = new AssessmentsNavbar();
    ViewAssessmentsPage viewAssessmentsPage = new ViewAssessmentsPage();
    DataReader dataReader = new DataReader();
    AnswerKey answerKey = new AnswerKey();
    FlexAnswerKeyPage flexAnswerKeyPage = new FlexAnswerKeyPage();
    String browser, url, username, password, closeBrowser, multiSite, ticket, chrome;
    Boolean headless;
    int waitTime;

    // Site Variables
    String domain;
    String homeConnectionUrl;
    String administrationsPage;
    String quickRosterUrl;
    String title;

    //Logger and WebDrivers
    private static final Logger logger = LoggerFactory.getLogger(CreateFlexAssessmentAllTestCasesTest.class);
    WebDriver driver = null;
    WebDriverWait waiter = null;

    @BeforeExecution
    public void setup() {
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
        //Driver Instance
        if (browser.equals("chrome")) {
            ChromeDriverManager.getInstance(DriverManagerType.CHROME).setup();
        } else if (browser.equals("firefox")) {
            FirefoxDriverManager.getInstance(DriverManagerType.FIREFOX).setup();
        } else {
            EdgeDriverManager.getInstance(DriverManagerType.EDGE).setup();
        }
        String[] strArray = Config.getURL().split("/");
        domain = strArray[2];
        strArray = domain.split("\\.");
        domain = strArray[0];

        if (Config.getEnvironment().equals("prod") || Config.getEnvironment().equals("production")) {
            quickRosterUrl = "https://testing.illuminateed.com/auth/quick?access_code=";
            homeConnectionUrl = "https://" + domain + ".illuminatehc.com";
        } else {
            quickRosterUrl = "https://onlinetesting" + domain + ".illuminateed.io/auth/quick?access_code=";
            homeConnectionUrl = "https://" + domain + ".illuminatehc.io";
        }
        if (Config.getBrowser().equals("chrome")) {
            ChromeDriverManager.getInstance(DriverManagerType.CHROME).setup();
        } else if (Config.getBrowser().equals("firefox")) {
            FirefoxDriverManager.getInstance(DriverManagerType.FIREFOX).setup();
        } else {
            EdgeDriverManager.getInstance(DriverManagerType.EDGE).setup();
        }
    }

    @AfterExecution
    public void cleanup() {
        if (driver != null) {
            driver.quit();
        }
    }

    // To start browser
    public void e_StartBrowser() {
        if (!Config.getChrome().equals("")) {
            System.setProperty("webdriver.chrome.driver", Config.getChrome());
        }
        //Driver Instance
        System.out.println(Config.getBrowser());
        if (Config.getBrowser().equals("chrome") && Config.getHeadless() == true) {
            System.setProperty(ChromeDriverService.CHROME_DRIVER_SILENT_OUTPUT_PROPERTY, "true");
            ChromeOptions options = new ChromeOptions();
            options.addArguments("window-size=1600,1600");
            options.addArguments("--headless");
            options.addArguments("--disable-gpu");
            options.addArguments("--disable-extensions");
            driver = new ChromeDriver(options);
            Assert.assertNotNull(driver);
            waiter = new WebDriverWait(driver, Config.getWaitTime());
        } else if (Config.getBrowser().equals("chrome") && Config.getHeadless() != true) {
            System.setProperty(ChromeDriverService.CHROME_DRIVER_SILENT_OUTPUT_PROPERTY, "true");
            ChromeOptions options = new ChromeOptions();
            options.addArguments("window-size=1600,1600");
            driver = new ChromeDriver(options);
            Assert.assertNotNull(driver);
            waiter = new WebDriverWait(driver, Config.getWaitTime());
        } else if (Config.getBrowser().equals("firefox")) {
            driver = new FirefoxDriver();
            Assert.assertNotNull(driver);
            waiter = new WebDriverWait(driver, Config.getWaitTime());
        } else {
            driver = new EdgeDriver();
            Assert.assertNotNull(driver);
            waiter = new WebDriverWait(driver, Config.getWaitTime());
        }
    }

    // To validate browser started
    public void v_BrowserStarted() {
        Assert.assertNotNull(driver);
    }

    // To enter Url
    public void e_EnterBaseURL() {
        driver.get(Config.getURL());
    }

    // To validate Url
    public void v_BaseURL() {
        waiter.until(ExpectedConditions.titleContains("Illuminate Education"));
    }

    // To enter credentials
    public void e_DirectLogin() {
        if (config.getAuthX().equalsIgnoreCase("true")) {
            Helper.loginAuthX(username, password, waiter, driver);
        } else {
            Helper.login(username, password, waiter, driver);
        }
    }

    public void v_Dashboard() {
    }

    /**
     * Assessment being created
     */

    // To click Navbar
    public void e_ClickNavbar() {
        Helper.clickXpath(dashboard.getAssessmentsNav(), waiter, driver);
        Helper.screenshot(driver);
    }

    public void e_ClickViewAssessments() {
    }

    public void v_Navbar() {
    }

    // To validate ViewAssessments
    public void v_ViewAssessments() {
        Helper.clickXpath(dashboard.getAssessmentsNav(), waiter, driver);
        Helper.clickXpath(assessmentsNavbar.getViewAssessment(), waiter, driver);
        Helper.clickXpath(viewAssessmentsPage.getCreateButton(), waiter, driver);
    }

    // To crate flex
    public void e_CreateFlexClick() {
        Helper.clickXpath(viewAssessmentsPage.getFlexible(), waiter, driver);
    }

    // To validate Title Page
    public void v_TitlePage() {
        title = "flex_portal_" + timeStamp;
        Helper.sendKeysXpath(viewAssessmentsPage.getAddAssessmentTitle(), title, waiter, driver);
        Helper.screenshot(driver);

    }

    // To validate AnswerKeyPage
    public void v_AnswerKeyPage() {
        FlexAssessmentController.clearPopUpInAnswerKeyPage(waiter, driver);

        FlexAssessmentController.addQuestions(6, waiter, driver);
        FlexAssessmentController.addMultipleChoice(1, "A", waiter, driver);
        FlexAssessmentController.addMultipleChoicePartialCredit(2, "A", waiter, driver);
        FlexAssessmentController.addConstructedResponse(3, waiter, driver);
        FlexAssessmentController.addExplicitConstructedResponse(4, waiter, driver);
        FlexAssessmentController.addConstructedResponseAdvanced(5, waiter, driver);
        FlexAssessmentController.addMultipleChoiceAdvanced(6, new String[]{"A", "B"}, waiter, driver);

        // Wait Until Save
        Helper.waitUntil(answerKey.getQuestionsSaved(), waiter, driver);
        Helper.screenshot(driver);
    }

    // To validate landing Page
    public void v_LandingPage() {
        Helper.clickXpath(flexAnswerKeyPage.FlexAnswerKeyAdminister(), waiter, driver);
    }

    public void e_ClickOnlineTesting() {
        Helper.clickXpath(flexAnswerKeyPage.getFlexAnswerKeyOnlineTesting(), waiter, driver);
    }

    public void v_AdministrationPagePortal() {
        administrationsPage = AdministrationController.getPortal(Config.getStudentLastFirst(), waiter, driver);
    }

    // To click Nav Flex Assessment
    public void e_NavFlexAssessmentClick() {
        Helper.clickXpath(flexAnswerKeyPage.getFlexAnswerKeyCreateAssessment(), waiter, driver);
        Helper.clickXpath(flexAnswerKeyPage.getFlexAnswerKeyFlexible(), waiter, driver);
        Helper.screenshot(driver);
    }

    // To click Create
    public void e_CreateClick() {
        Helper.clickXpath(flexAnswerKeyPage.getFlexAnswerKeyCreate(), waiter, driver);
        Helper.screenshot(driver);
    }

    // To click done
    public void e_DoneClick() {
        Helper.clickXpath(flexAnswerKeyPage.getFlexAnswerKeyDoneButton(), waiter, driver);
        Helper.screenshot(driver);

        Helper.clickXpath(flexAnswerKeyPage.getFlexAnswerKeyEditButton(), waiter, driver);
        Helper.assertionText(answerKey.getAnswerKeyMc(), "MC", waiter, driver);
        Helper.assertionText(answerKey.getAnswerKeyMcPtl(), "MC Ptl", waiter, driver);
        Helper.assertionText(answerKey.getAnswerKeyCr(), "CR", waiter, driver);
        Helper.assertionText(answerKey.getAnswerKeyCrExp(), "CR Exp", waiter, driver);
        Helper.assertionText(answerKey.getAnswerKeyCrAdv(), "CR Adv", waiter, driver);
        Helper.assertionText(answerKey.getAnswerKeyMcAdv(), "MC Adv", waiter, driver);
        Helper.clickXpath(flexAnswerKeyPage.getFlexAnswerKeyDoneButton(), waiter, driver);
    }

    // To return to dashboard
    public void e_ReturnToDashboard() {
        Helper.clickXpath(dashboard.getReturnToDashboard(), waiter, driver);
    }
}
