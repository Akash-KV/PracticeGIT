package org.graphwalker;

import Controllers.FlexAssessmentController;
import io.github.bonigarcia.wdm.ChromeDriverManager;
import io.github.bonigarcia.wdm.DriverManagerType;
import io.github.bonigarcia.wdm.EdgeDriverManager;
import io.github.bonigarcia.wdm.FirefoxDriverManager;
import org.graphwalker.PageObjectModels.Dashboard;
import org.graphwalker.PageObjectModels.FlexAnswerKeyPage;
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
//Test class for Create FlexAssessment AllTestCases
public class CreateFlexAssessmentAllTestCasesTest extends ExecutionContext implements CreateFlexAssessmentAllTestCases {

    // Local Declarations
    String timeStamp = new SimpleDateFormat("HH:mm:ss-MM/dd/yyyy").format(new java.util.Date());

    // Site Variables
    String domain;
    String homeConnectionUrl;
    String administrationsPage;
    String quickRosterUrl;
    String title;
    String uploadPdf, uploadDoc, uploadPpt;
    String currentUrl;
    Boolean isPdf;
    String studentQrId, studentPortalUn, studentPortalPw, environment, chrome;

    //Logger and WebDrivers
    private static final Logger logger = LoggerFactory.getLogger(CreateFlexAssessmentAllTestCasesTest.class);
    WebDriver driver = null;
    WebDriverWait waiter = null;

    //Declarations
    Config config = new Config();
    Dashboard dashboard = new Dashboard();
    FlexAnswerKeyPage flexAnswerKeyPage = new FlexAnswerKeyPage();
    FlexAssessmentController flexAssessmentController = new FlexAssessmentController();
    String browser, url, username, password, closeBrowser, multiSite, ticket;
    Boolean headless;
    int waitTime;

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
        headless = config.getHeadless();
        studentQrId = config.getStudentQrId();
        studentPortalUn = config.getStudentPortalUn();
        studentPortalPw = config.getStudentPortalPw();
        environment = config.getEnvironment();
        chrome = config.getChrome();
        title = "mbt_flex_qr_" + ticket;
        String[] strArray = url.split("/");
        domain = strArray[2];
        strArray = domain.split("\\.");
        domain = strArray[0];

        if (environment.equals("prod") || environment.equals("production")) {
            quickRosterUrl = "https://testing.illuminateed.com/auth/quick?access_code=";
            homeConnectionUrl = "https://" + domain + ".illuminatehc.com";
        } else {
            quickRosterUrl = "https://onlinetesting" + domain + ".illuminateed.io/auth/quick?access_code=";
            homeConnectionUrl = "https://" + domain + ".illuminatehc.io";
        }

        //Driver Instance
        if (browser.equals("chrome")) {
            ChromeDriverManager.getInstance(DriverManagerType.CHROME).setup();
        } else if (browser.equals("firefox")) {
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

    //Enter start Browser
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

    //Validate Browser Started
    public void v_BrowserStarted() {
        Assert.assertNotNull(driver);
    }

    //Enter Base URL
    public void e_EnterBaseURL() {
        driver.get(Config.getURL());
    }

    //Validate URL
    public void v_BaseURL() {
        waiter.until(ExpectedConditions.titleContains("Illuminate Education"));
    }

    //Click on Login
    public void e_DirectLogin() {
        if (config.getAuthX().equalsIgnoreCase("true")) {
            Helper.loginAuthX(username, password, waiter, driver);
        } else {
            Helper.login(username, password, waiter, driver);
        }
    }

    //Validate Dashboard
    public void v_Dashboard() {
    }

    //Click Navbar
    public void e_ClickNavbarPdf() {
        isPdf = true;
        Helper.clickXpath(dashboard.getAssessmentNav(), waiter, driver);
        uploadPdf = System.getProperty("user.dir") + "/src/main/resources/org/graphwalker/upload_pdf.pdf";
        uploadDoc = System.getProperty("user.dir") + "/src/main/resources/org/graphwalker/upload_doc.doc";
        uploadPpt = System.getProperty("user.dir") + "/src/main/resources/org/graphwalker/upload_ppt.pptx";
        Helper.screenshot(driver);
    }

    //Validate Navbar
    public void v_Navbar() {

    }

    //Validate Title Page
    public void v_TitlePage() {
        title = "flex_pdf_" + timeStamp;
        Helper.sendKeysXpath(flexAnswerKeyPage.getFlexAnswerKeyAssessmentTitle(), title, waiter, driver);
        Helper.screenshot(driver);
    }

    //validate Answer key page
    public void v_AnswerKeyPage() {
        FlexAssessmentController.clearPopUpInAnswerKeyPage(waiter, driver);

        currentUrl = driver.getCurrentUrl();
        FlexAssessmentController.addQuestions(1, waiter, driver);
        FlexAssessmentController.addMultipleChoiceNoStandards(1, "A", waiter, driver);

        // pdf
        FlexAssessmentController.Uploads.uploadGoogleDrive("test_google_pdf", waiter, driver);
    }

    //Click on create
    public void e_CreateClick() {
        Helper.clickXpath(flexAnswerKeyPage.getFlexAnswerKeyCreate(), waiter, driver);
        Helper.screenshot(driver);
    }

    //Click Done
    public void e_DoneClick() {
        Helper.clickXpath(flexAnswerKeyPage.getFlexAnswerKeyDoneButton(), waiter, driver);
    }

    //Validate Landing Page
    public void v_LandingPage() {
        Helper.clickXpath(flexAnswerKeyPage.getFlexAnswerKeyAdministerButton(), waiter, driver);
    }

    //Click on Online Testing
    public void e_ClickOnlineTesting() {
        Helper.clickXpath(flexAnswerKeyPage.getFlexAnswerKeyOnlineTesting(), waiter, driver);
    }

    //Validate Administration Page Portal
    public void v_AdministrationPagePortal() {
        administrationsPage = driver.getCurrentUrl();
        FlexAssessmentController.Uploads.checkPreviewOnlineTestingFromAdministrationPage(isPdf, waiter, driver);
        FlexAssessmentController.Uploads.checkOnlineTesting(isPdf, quickRosterUrl, waiter, driver);
    }

    //Click on Flex Assessment
    public void e_NavFlexAssessmentClick() {
        Helper.clickXpath(flexAnswerKeyPage.getFlexAnswerKeyCreateAssessment(), waiter, driver);
        Helper.clickXpath(flexAnswerKeyPage.getFlexAnswerKeyFlexible(), waiter, driver);
        Helper.screenshot(driver);
    }
}
