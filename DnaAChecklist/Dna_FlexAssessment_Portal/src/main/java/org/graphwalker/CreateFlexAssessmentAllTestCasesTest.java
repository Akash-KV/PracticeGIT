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
import org.openqa.selenium.By;
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
    Config config = new Config();
    Dashboard dashboard = new Dashboard();
    DataReader dataReader = new DataReader();
    ViewAssessmentsPage viewAssessmentsPage = new ViewAssessmentsPage();
    AnswerKey answerKey = new AnswerKey();
    FlexAnswerKeyPage flexAnswerKeyPage = new FlexAnswerKeyPage();
    OnlineTestingAdministrationPage onlineTestingAdministrationPage = new OnlineTestingAdministrationPage();
    AssessmentPanelPage assessmentPanelPage = new AssessmentPanelPage();
    String timeStamp = new SimpleDateFormat("HH:mm:ss-MM/dd/yyyy").format(new java.util.Date());
    String browser, url, username, password, closeBrowser, multiSite, ticket, chrome;
    Boolean headless;
    int waitTime;

    // Site Variables
    String domain;
    String homeConnectionUrl;
    String administrationsPage;
    String quickRosterUrl;
    String title;
    String studentName;

    //Logger and WebDrivers
    private static final Logger logger = LoggerFactory.getLogger(CreateFlexAssessmentAllTestCasesTest.class);
    WebDriver driver = null;
    WebDriverWait waiter = null;

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
        ticket = config.getTicket(); //added 01/10/19
        headless = config.getHeadless();
        chrome = config.getChrome();

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

    public void v_Navbar() {
    }

    // To validate Title Page
    public void v_TitlePage() {
        title = "flex_portal_" + timeStamp;
        Helper.sendKeysXpath(viewAssessmentsPage.getAddAssessmentTitle(), title, waiter, driver);
        Helper.screenshot(driver);
    }

    // To validate answer Key Page
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

    // To validate Landing page
    public void v_LandingPage() {
        Helper.clickXpath(flexAnswerKeyPage.getFlexAnswerKeyAdminister(), waiter, driver);
    }

    // To click Online testing
    public void e_ClickOnlineTesting() {
        Helper.clickXpath(flexAnswerKeyPage.getFlexAnswerKeyOnlineTesting(), waiter, driver);
    }

    // To validate Administration Page Portal
    public void v_AdministrationPagePortal() {
        administrationsPage = AdministrationController.getPortal(Config.getStudentLastFirst(), waiter, driver);
    }

    // To click NavFlexAssessment
    public void e_NavFlexAssessmentClick() {
        Helper.clickXpath(flexAnswerKeyPage.getFlexAnswerKeyCreateAssessment(), waiter, driver);
        Helper.clickXpath(flexAnswerKeyPage.getFlexAnswerKeyFlexible(), waiter, driver);
        Helper.screenshot(driver);
    }

    // To click create
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

    /**
     * Student Taking Assessment
     */

    // To click portal
    public void e_ClickPortal() {
        driver.get(AdministrationController.getPortalUrl());
        PortalController.login(Config.getStudentPortalUn(), Config.getStudentPortalPw(), waiter, driver);
        PortalController.clickOnPortalAssessment(title, waiter, driver);
    }

    // To validate Student Take Quick roster Assessment
    public void v_StudentTakeQuickrosterAssessment() {
        Helper.clickXpath(onlineTestingAdministrationPage.getOnlineTestingAdministrationSuccess(), waiter, driver);

        // Question 1 - Multiple Choice
        OnlineTestingController.setMultipleChoiceResponse(1, waiter, driver);
        OnlineTestingController.clickNextQuestion(waiter, driver);

        // Question 2 - Multiple Choice Partial Credit
        OnlineTestingController.setMultipleChoicePartialCredit(1, waiter, driver);
        OnlineTestingController.clickNextQuestion(waiter, driver);

        // Question 3 - Constructed Response
        OnlineTestingController.setConstructedResponse(OnlineTestingController.alphaString(), waiter, driver);
        OnlineTestingController.clickNextQuestion(waiter, driver);

        // Question 4 - Explicit Constructed Response
        OnlineTestingController.setExplicitConstructedResponse(OnlineTestingController.alphaString(), waiter, driver);
        OnlineTestingController.clickNextQuestion(waiter, driver);

        // Question 5 - Constructed Response Advanced
        OnlineTestingController.setConstructedResponseAdvanced(OnlineTestingController.alphaString(), waiter, driver);
        OnlineTestingController.clickNextQuestion(waiter, driver);

        // Question 6 - Multiple Choice Advanced
        OnlineTestingController.setMultipleChoiceAdvanced(1, waiter, driver);
        OnlineTestingController.clickNextQuestion(waiter, driver);

        // Review - Assertions
        try {
            Helper.wait(3.0);
            Helper.waitUntil("", waiter, driver);
            String value = driver.findElement(By.xpath("")).getText().trim();
            if (value.equalsIgnoreCase("A")) {
                Helper.assertionText(onlineTestingAdministrationPage.getOnlineTestingAdministrationTestFirstAnswer(), "A", waiter, driver);
                Helper.assertionText(onlineTestingAdministrationPage.getOnlineTestingAdministrationTestSecondAnswer(), "A", waiter, driver);
                Helper.assertionText(onlineTestingAdministrationPage.getOnlineTestingAdministrationTestThirdAnswer(), OnlineTestingController.alphaString(), waiter, driver);
                Helper.assertionText(onlineTestingAdministrationPage.getOnlineTestingAdministrationTestFourthAnswer(), OnlineTestingController.alphaString(), waiter, driver);
                Helper.assertionText(onlineTestingAdministrationPage.getOnlineTestingAdministrationTestFifthAnswer(), OnlineTestingController.alphaString(), waiter, driver);
                Helper.assertionText(onlineTestingAdministrationPage.getOnlineTestingAdministrationTestSixthAnswer(), "A", waiter, driver);
            } else if (value.equalsIgnoreCase("Answered")) {
                Helper.assertionText(onlineTestingAdministrationPage.getOnlineTestingAdministrationTestFirstAnswer(), "Answered", waiter, driver);
                Helper.assertionText(onlineTestingAdministrationPage.getOnlineTestingAdministrationTestSecondAnswer(), "Answered", waiter, driver);
                Helper.assertionText(onlineTestingAdministrationPage.getOnlineTestingAdministrationTestThirdAnswer(), "Answered", waiter, driver);
                Helper.assertionText(onlineTestingAdministrationPage.getOnlineTestingAdministrationTestFourthAnswer(), "Answered", waiter, driver);
                Helper.assertionText(onlineTestingAdministrationPage.getOnlineTestingAdministrationTestFifthAnswer(), "Answered", waiter, driver);
                Helper.assertionText(onlineTestingAdministrationPage.getOnlineTestingAdministrationTestSixthAnswer(), "Answered", waiter, driver);
            }
        } catch (Exception e) {
            System.out.println("Exception handled for assertion...." + e);
        }
    }

    // To click finish
    public void e_ClickFinish() {
        //---e_ClickFinish---
        Helper.clickXpath(onlineTestingAdministrationPage.getOnlineTestingAdministrationTestFinish(), waiter, driver);
        driver.get(administrationsPage);
    }

    // To validate Administration Page
    public void v_AdministrationPage() {
        driver.get(administrationsPage);
    }

    // To click Assessment Panel
    public void e_ClickAssessmentPanel() {
        //---e_ClickAssessmentPanel---
        studentName = Config.getProperties().getProperty("STUDENT_LAST_FIRST");
        if (Boolean.parseBoolean(Config.getProperties().getProperty("ASSESSMENT_PANEL_CHECK"))) {
            AssessmentPanelController.clickAssessmentPanel(waiter, driver);
            AssessmentPanelController.getFirstStudent(studentName, waiter, driver);
        }
    }

    // To validate Assessment Panel
    public void v_AssessmentPanel() {
        if (Boolean.parseBoolean(Config.getProperties().getProperty("ASSESSMENT_PANEL_CHECK"))) {
            Helper.clickXpath("//a/div[contains(text(),'" + studentName + "')]", waiter, driver);

            //---v_AssessmentPanel---
            //Helper.clickXpath("//table[@id='student-list']//a[@class='black-text list-item']", waiter, driver);
            Helper.refreshUntilElementAppears(assessmentPanelPage.getPage(), waiter, driver);
            try {
                Helper.wait(3.0);
                Helper.waitUntil(assessmentPanelPage.getAnswer(), waiter, driver);
                String value = driver.findElement(By.xpath(assessmentPanelPage.getAnswer())).getText().trim();
                if (value.equalsIgnoreCase("A")) {
                    Helper.assertionText(assessmentPanelPage.getFirstAnswer(), "A", waiter, driver);
                    Helper.assertionText(assessmentPanelPage.getSecondAnswer(), "A", waiter, driver);
                    Helper.assertionText(assessmentPanelPage.getThirdAnswer(), OnlineTestingController.alphaString(), waiter, driver);
                    Helper.assertionText(assessmentPanelPage.getFourthAnswer(), OnlineTestingController.alphaString(), waiter, driver);
                    Helper.assertionText(assessmentPanelPage.getFifthAnswer(), OnlineTestingController.alphaString(), waiter, driver);
                    Helper.assertionText(assessmentPanelPage.getSixthAnswer(), "A", waiter, driver);
                } else if (value.equalsIgnoreCase("Answered")) {
                    Helper.assertionText(assessmentPanelPage.getFirstAnswer(), "Answered", waiter, driver);
                    Helper.assertionText(assessmentPanelPage.getSecondAnswer(), "Answered", waiter, driver);
                    Helper.assertionText(assessmentPanelPage.getThirdAnswer(), "Answered", waiter, driver);
                    Helper.assertionText(assessmentPanelPage.getFourthAnswer(), "Answered", waiter, driver);
                    Helper.assertionText(assessmentPanelPage.getFifthAnswer(), "Answered", waiter, driver);
                    Helper.assertionText(assessmentPanelPage.getSixthAnswer(), "Answered", waiter, driver);
                }
            } catch (Exception e) {
                System.out.println("Exception handled for assertion...." + e);
            }
        }
    }

    // To click exit in Assessment Panel page
    public void e_ClickExitAssessmentPanel() {
        //---e_ClickExitAssessmentPanel---
        if (Boolean.parseBoolean(Config.getProperties().getProperty("ASSESSMENT_PANEL_CHECK"))) {
            //Helper.clickXpath("//i[contains(text(),'exit_to_app')]", waiter, driver);
            Helper.clickXpath(assessmentPanelPage.getExit(), waiter, driver);
        }
    }

    // To return to Administration Page
    public void v_ReturnToAdministrationPage() {
        //---v_ReturnToAdminstrationPage---
    }

    // To click Back to my assessment
    public void e_ClickBackToMyAssessment() {
        try {
            Helper.wait(2.0);
            //---e_ClickBackToMyAssessment---
            Helper.clickXpath(onlineTestingAdministrationPage.getBackToAssessmentButton(), waiter, driver);
        } catch (Exception e) {
            System.out.println("Exception handled for method - e_ClickBackToMyAssessment");
        }
    }

    // To validate Overview Page Before EnterEdit
    public void v_OverviewPageBeforeEnterEdit() {
        //---v_OverviewPageBeforeEnterEdit---
        FlexOverviewController.waitUntilDonutAppears("33.3%", waiter, driver);
    }

    // To click reports
    public void e_ClickReports() {
        //--e_ClickReports---
        Helper.clickXpath(flexAnswerKeyPage.getReport(), waiter, driver);
        Helper.clickXpath(flexAnswerKeyPage.getMiniReport(), waiter, driver);
    }

    // To validate Student Small Slips Before EnterEdit
    public void v_StudentSmallSlipsBeforeEnterEdit() {
        //---v_StudentSmallSlipsBeforeEnterEdit---
        Helper.clickXpath(flexAnswerKeyPage.getStudentSmallSlips(), waiter, driver);
        Helper.assertionText(flexAnswerKeyPage.getStudentSmallSlipsBeforeEnterEdit(), "3 / 9", waiter, driver);
    }

    // To click EnterEdit
    public void e_ClickEnterEdit() {
        //---e_ClickEnterEdit---
        Helper.clickXpath(onlineTestingAdministrationPage.getBackToAssessmentButton(), waiter, driver);
        Helper.clickXpath(flexAnswerKeyPage.getFlexAnswerKeyAdminister(), waiter, driver);
        Helper.clickXpath(flexAnswerKeyPage.getEnterEdit(), waiter, driver);
    }

    // To validate EnterEdit
    public void v_EnterEdit() {
        //---v_EnterEdit---
        EnterEditController.getStudentsWithData(waiter, driver);
        EnterEditController.setResponseScore(3, 3, waiter, driver);
        EnterEditController.setResponseScore(4, 3, waiter, driver);
        EnterEditController.setResponseScore(5, 6, waiter, driver);
        Helper.wait(0.25);
        Helper.clickXpath(flexAnswerKeyPage.getFlexAnswerKeyGridSave(), waiter, driver);
    }

    // To click EnterEdit Return To OverviewPage
    public void e_EnterEditReturnToOverviewPage() {
        Helper.clickXpath(onlineTestingAdministrationPage.getBackToAssessmentButton(), waiter, driver);
    }

    // To validate Overview Page After EnterEdit
    public void v_OverviewPageAfterEnterEdit() {
        Helper.assertionText(flexAnswerKeyPage.getFlexAnswerKeyAfterEnterEdit(), "100.0%", waiter, driver);
    }

    // To validate Student SmallSlips After EnterEdit
    public void v_StudentSmallSlipsAfterEnterEdit() {
        Helper.clickXpath(flexAnswerKeyPage.getStudentSmallSlips(), waiter, driver);
        Helper.assertionText(flexAnswerKeyPage.getStudentSmallSlipsAfterEnterEdit(), "9 / 9", waiter, driver);

        // Delete Assessment
        Helper.clickXpath(flexAnswerKeyPage.getStudentSmallSlips(), waiter, driver);
    }
}
