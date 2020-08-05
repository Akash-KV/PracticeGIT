package org.graphwalker;

import Controllers.FlexAssessmentController;
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
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * Prerequisites:
 * - Portal Remote Authentication set to Portal
 * - Student Amy Chow enabled and username updated below
 * - Student Amy Chow enabled and password updated below
 * - Student Amy Chow id updated below
 * <p>
 * Assertions are:
 * - Question Type is Multiple Choice
 * - Question Weight is 1
 * - Question groups are equal to the standards chosen before hitting done
 */

@GraphWalker(value = "quick_random(edge_coverage(100))", start = "e_StartBrowser")
/** Test class for CreateFlexAssessmentAllTestCases **/
public class CreateFlexAssessmentAllTestCasesTest extends ExecutionContext implements CreateFlexAssessmentAllTestCases {

    //Declarations
    Config config = new Config();
    Dashboard dashboard = new Dashboard();
    ViewAssessmentsPage viewAssessmentsPage = new ViewAssessmentsPage();
    AnswerKey answerKey = new AnswerKey();
    FlexAnswerKeyPage flexAnswerKeyPage = new FlexAnswerKeyPage();
    OnlineTestingAdministrationPage onlineTestingAdministrationPage = new OnlineTestingAdministrationPage();
    AssessmentPanelPage assessmentPanelPage = new AssessmentPanelPage();
    String browser, url, username, password, closeBrowser, multiSite, ticket, studentQrId, studentPortalUn, studentPortalPw, environment, chrome;
    Boolean headless;
    int waitTime;
    String title;
    String studentName;

    // Site Variables
    String domain;
    String homeConnectionUrl;
    String administrationsPage;
    String quickRoster;
    String quickRosterUrl;
    String timeStamp = new SimpleDateFormat("HH:mm:ss-MM/dd/yyyy").format(new java.util.Date());
    long start, end, time;
    ArrayList<Long> times = new ArrayList<Long>();
    HashMap<String, Long> map = new HashMap<>();

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

    // To start browser
    public void e_StartBrowser() {
        if (!chrome.equals("")) {
            System.setProperty("webdriver.chrome.driver", chrome);
        }
        //Driver Instance
        System.out.println(browser);
        if (browser.equals("chrome") && headless == true) {
            System.setProperty(ChromeDriverService.CHROME_DRIVER_SILENT_OUTPUT_PROPERTY, "true");
            ChromeOptions options = new ChromeOptions();
            options.addArguments("window-size=1600,1600");
            options.addArguments("--headless");
            options.addArguments("--disable-gpu");
            options.addArguments("--disable-extensions");
            options.addArguments("disable-infobars");
            options.addArguments("--disable-dev-shm-usage");
            driver = new ChromeDriver(options);
            Assert.assertNotNull(driver);
        } else if (browser.equals("chrome") && headless != true) {
            System.setProperty(ChromeDriverService.CHROME_DRIVER_SILENT_OUTPUT_PROPERTY, "true");
            ChromeOptions options = new ChromeOptions();
            options.addArguments("window-size=1600,1600");
            driver = new ChromeDriver(options);
            Assert.assertNotNull(driver);
            waiter = new WebDriverWait(driver, waitTime);
        } else if (browser.equals("firefox")) {
            driver = new FirefoxDriver();
            Assert.assertNotNull(driver);
        } else {
            driver = new EdgeDriver();
            Assert.assertNotNull(driver);
        }
        waiter = new WebDriverWait(driver, waitTime);
    }

    // To validate browser started
    public void v_BrowserStarted() {
        Assert.assertNotNull(driver);
    }

    // To enter Url
    public void e_EnterBaseURL() {
        driver.get(url);
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
        title = "flex_qr_" + timeStamp;
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
    public void v_AdministrationPageQuickroster() {
        Helper.wait(5.0);
        administrationsPage = driver.getCurrentUrl();
        System.out.println("<mbt-output-url> " + administrationsPage);

        // Quickroster
        Helper.clickXpath(onlineTestingAdministrationPage.getOnlineTestingAdministrationQuickRosterButton(), waiter, driver);
        Helper.clickXpath(onlineTestingAdministrationPage.getQuickRosterExit(), waiter, driver);
        while (driver.findElements(By.xpath(onlineTestingAdministrationPage.getOnlineTestingAdministrationAccessCode())).size() == 0) {
            // loop
            try {
                Helper.wait(2.0);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        quickRoster = Helper.getText(onlineTestingAdministrationPage.getOnlineTestingAdministrationAccessCode(), waiter, driver);
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
    public void e_ClickQuickroster() {
        //--e_ClickQuickRoster
        start = System.currentTimeMillis();
        driver.get(quickRosterUrl + quickRoster);
        end = System.currentTimeMillis();
        time = end - start;
        times.add(time);
        map.put("Go to OT Login", time);
    }

    // To validate Student Take Quick roster Assessment
    public void v_StudentTakeQuickrosterAssessment() {
        //---v_StudentTakeQuickRosterAssessment---
        Helper.sendKeysXpath(onlineTestingAdministrationPage.getOnlineTestingAdministrationStudentLogin(), studentQrId, waiter, driver);

        start = System.currentTimeMillis();
        Helper.clickXpath(onlineTestingAdministrationPage.getOnlineTestingAdministrationNextButton(), waiter, driver);
        end = System.currentTimeMillis();
        time = end - start;
        times.add(time);
        map.put("Login Initial", time);

        start = System.currentTimeMillis();
        Helper.clickXpath(onlineTestingAdministrationPage.getOnlineTestingAdministrationConfirmButton(), waiter, driver);
        end = System.currentTimeMillis();
        time = end - start;
        times.add(time);
        map.put("Login Confirm", time);

        Helper.clickXpath(onlineTestingAdministrationPage.getOnlineTestingAdministrationSuccess(), waiter, driver);

        // Question 1 - Multiple Choice
        Helper.clickXpath(onlineTestingAdministrationPage.getQuickRosterMc(), waiter, driver);

        start = System.currentTimeMillis();
        Helper.waitUntil(onlineTestingAdministrationPage.getOnlineTestingAdministrationStatusBox(), waiter, driver);
        end = System.currentTimeMillis();
        time = end - start;
        times.add(time);
        map.put("Save Answer", time);

        Helper.waitUntilNotVisible(onlineTestingAdministrationPage.getOnlineTestingAdministrationStatusBox(), waiter, driver);

        start = System.currentTimeMillis();
        Helper.clickXpath(onlineTestingAdministrationPage.getQuickRosterNext(), waiter, driver);
        end = System.currentTimeMillis();
        time = end - start;
        times.add(time);
        map.put("Next Question", time);

        // Question 2 - Multiple Choice Partial Credit
        Helper.clickXpath(onlineTestingAdministrationPage.getQuickRosterMcPtl(), waiter, driver);
        Helper.waitUntil(onlineTestingAdministrationPage.getOnlineTestingAdministrationStatusBox(), waiter, driver);
        Helper.waitUntilNotVisible(onlineTestingAdministrationPage.getOnlineTestingAdministrationStatusBox(), waiter, driver);
        Helper.clickXpath(onlineTestingAdministrationPage.getOnlineTestingAdministrationForward(), waiter, driver);

        // Question 3 - Constructed Response
        Helper.waitUntil(onlineTestingAdministrationPage.getQuickRosterCr(), waiter, driver);
        driver.switchTo().frame(driver.findElement(By.xpath(onlineTestingAdministrationPage.getQuickRosterCr())));
        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(By.xpath(onlineTestingAdministrationPage.getQuickRosterQuestion())));
        actions.click();
        actions.sendKeys("F");
        actions.build().perform();
        driver.switchTo().defaultContent();
        Helper.waitUntil(onlineTestingAdministrationPage.getOnlineTestingAdministrationStatusBox(), waiter, driver);
        Helper.waitUntilNotVisible(onlineTestingAdministrationPage.getOnlineTestingAdministrationStatusBox(), waiter, driver);
        Helper.clickXpath(onlineTestingAdministrationPage.getQuickRosterNext(), waiter, driver);

        // Question 4 - Explicit Constructed Response
        Helper.sendKeysXpath(onlineTestingAdministrationPage.getQuickRosterCrExp(), "F", waiter, driver);
        Helper.waitUntil(onlineTestingAdministrationPage.getOnlineTestingAdministrationStatusBox(), waiter, driver);
        Helper.waitUntilNotVisible(onlineTestingAdministrationPage.getOnlineTestingAdministrationStatusBox(), waiter, driver);
        Helper.clickXpath(onlineTestingAdministrationPage.getQuickRosterNext(), waiter, driver);

        // Question 5 - Constructed Response Advanced
        Helper.waitUntil(onlineTestingAdministrationPage.getQuickRosterCrAdv(), waiter, driver);
        driver.switchTo().frame(driver.findElement(By.xpath(onlineTestingAdministrationPage.getQuickRosterCrAdv())));
        actions = new Actions(driver);
        actions.moveToElement(driver.findElement(By.xpath(onlineTestingAdministrationPage.getQuickRosterQuestion())));
        actions.click();
        actions.sendKeys("F");
        actions.build().perform();
        driver.switchTo().defaultContent();
        Helper.waitUntil(onlineTestingAdministrationPage.getOnlineTestingAdministrationStatusBox(), waiter, driver);
        Helper.waitUntilNotVisible(onlineTestingAdministrationPage.getOnlineTestingAdministrationStatusBox(), waiter, driver);
        Helper.clickXpath(onlineTestingAdministrationPage.getQuickRosterNext(), waiter, driver);

        // Question 6 - Multiple Choice Advanced
        Helper.clickXpath(onlineTestingAdministrationPage.getQuickRosterMcAdv(), waiter, driver);
        Helper.waitUntil(onlineTestingAdministrationPage.getOnlineTestingAdministrationStatusBox(), waiter, driver);
        Helper.waitUntilNotVisible(onlineTestingAdministrationPage.getOnlineTestingAdministrationStatusBox(), waiter, driver);
        Helper.clickXpath(onlineTestingAdministrationPage.getQuickRosterNext(), waiter, driver);

        // Review - Assertions
        try {
            Helper.wait(3.0);
            Helper.waitUntil(onlineTestingAdministrationPage.getOnlineTestingAdministrationTestFirstAnswer(), waiter, driver);
            String value = driver.findElement(By.xpath(onlineTestingAdministrationPage.getOnlineTestingAdministrationTestFirstAnswer())).getText().trim();
            if (value.equalsIgnoreCase("A")) {
                Helper.assertionText(onlineTestingAdministrationPage.getOnlineTestingAdministrationTestFirstAnswer(), "A", waiter, driver);
                Helper.assertionText(onlineTestingAdministrationPage.getOnlineTestingAdministrationTestSecondAnswer(), "A", waiter, driver);
                Helper.assertionText(onlineTestingAdministrationPage.getOnlineTestingAdministrationTestThirdAnswer(), "F", waiter, driver);
                Helper.assertionText(onlineTestingAdministrationPage.getOnlineTestingAdministrationTestFourthAnswer(), "F", waiter, driver);
                Helper.assertionText(onlineTestingAdministrationPage.getOnlineTestingAdministrationTestFifthAnswer(), "F", waiter, driver);
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

        start = System.currentTimeMillis();
        Helper.clickXpath(onlineTestingAdministrationPage.getOnlineTestingAdministrationTestFinish(), waiter, driver);
        end = System.currentTimeMillis();
        time = end - start;
        times.add(time);
        map.put("Submit Test", time);

        driver.get(administrationsPage);
    }

    // To validate Administration Page
    public void v_AdministrationPage() {
        try {
            //driver.navigate().refresh();
            Helper.wait(5.0);

            //---v_AdminstrationPage---
            Helper.clickXpath(onlineTestingAdministrationPage.getQuickRosterExit(), waiter, driver);
        } catch (Exception e) {
            System.out.println("Exception handled for method - v_AdministrationPage" + e);
        }
    }

    // To click Assessment Panel
    public void e_ClickAssessmentPanel() {
        if (Boolean.parseBoolean(Config.getProperties().getProperty("ASSESSMENT_PANEL_CHECK"))) {
            //---e_ClickAssessmentPanel---
            studentName = Config.getProperties().getProperty("STUDENT_LAST_FIRST");
            try {
                Helper.clickXpath(onlineTestingAdministrationPage.getOnlineTestingAdministrationLiveProctoring(), waiter, driver);
            } catch (Exception e) {
                Helper.clickXpath(onlineTestingAdministrationPage.getOnlineTestingAdministrationassessmentPanel(), waiter, driver);
            }
            Helper.refreshUntilElementAppears("//table[@id='student-list']//a[@class='black-text list-item']//div[.='" + studentName + "']", waiter, driver);
        }
    }

    // To validate Assessment Panel
    public void v_AssessmentPanel() {
        if (Boolean.parseBoolean(Config.getProperties().getProperty("ASSESSMENT_PANEL_CHECK"))) {
            Helper.clickXpath("//a/div[contains(text(),'" + studentName + "')]", waiter, driver);

            //---v_AssessmentPanel---
            start = System.currentTimeMillis();
            Helper.refreshUntilElementAppears(assessmentPanelPage.getPage(), waiter, driver);
            end = System.currentTimeMillis();
            time = end - start;
            times.add(time);
            map.put("Responses Received: Assessment Panel", time);

            try {
                Helper.wait(3.0);
                Helper.waitUntil(assessmentPanelPage.getQuickRosterAnswer(), waiter, driver);
                String value = driver.findElement(By.xpath(assessmentPanelPage.getQuickRosterAnswer())).getText().trim();
                if (value.equalsIgnoreCase("A")) {
                    Helper.assertionText(assessmentPanelPage.getFirstAnswer(), "A", waiter, driver);
                    Helper.assertionText(assessmentPanelPage.getSecondAnswer(), "A", waiter, driver);
                    Helper.assertionText(assessmentPanelPage.getThirdAnswer(), "F", waiter, driver);
                    Helper.assertionText(assessmentPanelPage.getFourthAnswer(), "F", waiter, driver);
                    Helper.assertionText(assessmentPanelPage.getFifthAnswer(), "F", waiter, driver);
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
        if (Boolean.parseBoolean(Config.getProperties().getProperty("ASSESSMENT_PANEL_CHECK"))) {
            //---e_ClickExitAssessmentPanel---
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
            //---e_ClickBackToMyAssessment---
            Helper.wait(5.0);
            Actions actions = new Actions(driver);
            WebElement element = waiter.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(onlineTestingAdministrationPage.getBackToAssessmentButton())));
            actions.moveToElement(element);
            actions.click();
            actions.click();
            actions.build().perform();
            Helper.wait(2.0);
        } catch (Exception e) {
            System.out.println("Exception handled for method - e_ClickBackToMyAssessment" + e);
        }
    }

    // To validate Overview Page Before EnterEdit
    public void v_OverviewPageBeforeEnterEdit() {
        //---v_OverviewPageBeforeEnterEdit---
        String currentUrl = driver.getCurrentUrl();
        currentUrl = currentUrl.substring(0, currentUrl.length() - 6);

        start = System.currentTimeMillis();
        while (driver.findElements(By.xpath(flexAnswerKeyPage.getFlexAnswerKeyOverviewPageBeforeEnterEdit())).size() == 0) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            driver.navigate().refresh();
            driver.get(currentUrl);
        }
        end = System.currentTimeMillis();
        time = end - start;
        times.add(time);
        map.put("Responses Received: Overview Page", time);

        Helper.assertionText(flexAnswerKeyPage.getFlexAnswerKeyOverviewPageBeforeEnterEdit(), "33.3%", waiter, driver);
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
        WebElement element = driver.findElement(By.xpath(onlineTestingAdministrationPage.getOnlineTestingAdministrationviewType()));
        Select dropdown = new Select(element);
        dropdown.selectByVisibleText("Students With Data");
        Helper.clickXpath(onlineTestingAdministrationPage.getOnlineTestingAdministrationFindStudents(), waiter, driver);

        Actions actions = new Actions(driver);
        element = waiter.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(flexAnswerKeyPage.getFlexAnswerKeyEnterEditThirdAnswerModify())));
        actions.moveToElement(element);
        actions.click();
        actions.click();
        actions.build().perform();

        element = waiter.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(flexAnswerKeyPage.getFlexAnswerKeyEnterEditFirstListBox())));
        actions.moveToElement(element);
        actions.click();
        actions.build().perform();

        Helper.wait(0.25);
        element = waiter.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(flexAnswerKeyPage.getFlexAnswerKeyEnterEditFourthAnswerModify())));
        actions.moveToElement(element);
        actions.click();
        actions.click();
        actions.build().perform();

        element = waiter.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(flexAnswerKeyPage.getFlexAnswerKeyEnterEditFirstListBox())));
        actions.moveToElement(element);
        actions.click();
        actions.build().perform();

        Helper.wait(0.25);
        element = waiter.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(flexAnswerKeyPage.getFlexAnswerKeyEnterEditFifthAnswerModify())));
        actions.moveToElement(element);
        actions.click();
        actions.click();
        actions.build().perform();

        element = waiter.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(flexAnswerKeyPage.getFlexAnswerKeyEnterEditLastListBox())));
        actions.moveToElement(element);
        actions.click();
        actions.build().perform();
        Helper.wait(0.25);
        Helper.clickXpath(flexAnswerKeyPage.getFlexAnswerKeyGridSave(), waiter, driver);
    }

    // To click EnterEdit Return To OverviewPage
    public void e_EnterEditReturnToOverviewPage() {
        Helper.clickXpath(onlineTestingAdministrationPage.getBackToAssessmentButton(), waiter, driver);
    }

    // To validate Overview Page After EnterEdit
    public void v_OverviewPageAfterEnterEdit() {
        start = System.currentTimeMillis();
        Helper.assertionText(flexAnswerKeyPage.getFlexAnswerKeyAfterEnterEdit(), "100.0%", waiter, driver);
        end = System.currentTimeMillis();
        time = end - start;
        times.add(time);
        map.put("Enter/Edit Scored", time);
    }

    // To validate Student SmallSlips After EnterEdit
    public void v_StudentSmallSlipsAfterEnterEdit() {
        Helper.clickXpath(flexAnswerKeyPage.getStudentSmallSlips(), waiter, driver);
        Helper.assertionText(flexAnswerKeyPage.getStudentSmallSlipsAfterEnterEdit(), "9 / 9", waiter, driver);

        // Delete Assessment
        Helper.clickXpath(onlineTestingAdministrationPage.getBackToAssessmentButton(), waiter, driver);

        /**
         * Additional Test Cases
         */

        // Advanced Settings
        Helper.clickXpath(flexAnswerKeyPage.getAdvancedSettings(), waiter, driver);
    }
}
