package org.graphwalker;

import io.github.bonigarcia.wdm.ChromeDriverManager;
import io.github.bonigarcia.wdm.DriverManagerType;
import io.github.bonigarcia.wdm.EdgeDriverManager;
import io.github.bonigarcia.wdm.FirefoxDriverManager;
import org.graphwalker.PageObjectModels.AnswerKey;
import org.graphwalker.PageObjectModels.AssessmentsNavbar;
import org.graphwalker.PageObjectModels.FlexAnswerKeyPage;
import org.graphwalker.core.machine.ExecutionContext;
import org.graphwalker.java.annotation.AfterExecution;
import org.graphwalker.java.annotation.BeforeExecution;
import org.graphwalker.java.annotation.GraphWalker;
import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@GraphWalker(value = "quick_random(edge_coverage(100))", start = "e_StartBrowser")
//Test Class for CreateNewAssessmentViewTest
public class CreateNewAssessmentViewTest extends ExecutionContext implements CreateNewAssessmentView {

    AssessmentsNavbar assessmentsNavbar = new AssessmentsNavbar();
    AnswerKey answerKey = new AnswerKey();
    FlexAnswerKeyPage flexAnswerKeyPage = new FlexAnswerKeyPage();

    //Declarations
    Config config = new Config();
    String browser, url, username, password, closeBrowser, multiSite, ticket, chrome;
    int waitTime;
    String title, domain, environment, quickRosterUrl, homeConnectionUrl;
    String[] permutations = new String[]{"11.5", "11", "1", "0", "-1", "0.5", "101"};
    int numberOfQuestions = permutations.length;
    Boolean headless;

    //NavBar
    String navbarAssessments = assessmentsNavbar.getAssessmentNavBarNavBarAssessments();
    String navBarAssessmentsLink = assessmentsNavbar.getAssessmentNavBarAssessmentViewPage();
    String viewAssessmentsLink = assessmentsNavbar.getAssessmentNavBarViewAssessment();
    String createButton = assessmentsNavbar.getAssessmentNavBarCreateButton();
    String viewAssessmentView = assessmentsNavbar.getAssessmentNavBarViewAssessmentView();

    //Logger and WebDrivers
    private static final Logger logger = LoggerFactory.getLogger(CreateNewAssessmentViewTest.class);
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
        chrome = config.getChrome();
        environment = config.getEnvironment();
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
            driver = new ChromeDriver(options);
            Assert.assertNotNull(driver);
            waiter = new WebDriverWait(driver, waitTime);
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
            waiter = new WebDriverWait(driver, waitTime);
        } else {
            driver = new EdgeDriver();
            Assert.assertNotNull(driver);
            waiter = new WebDriverWait(driver, waitTime);
        }
    }

    //Validate v_BrowserStarted
    public void v_BrowserStarted() {
        Assert.assertNotNull(driver);
    }

    //Clicking on e_EnterBaseURL
    public void e_EnterBaseURL() {
        driver.get(url);
    }

    //Validate v_Dashboard
    public void v_BaseURL() {
        waiter.until(ExpectedConditions.titleContains("Illuminate Education"));
    }

    //Clicking on e_DirectLogin
    public void e_DirectLogin() {
        if (config.getAuthX().equalsIgnoreCase("true")) {
            Helper.loginAuthX(username, password, waiter, driver);
        } else {
            Helper.login(username, password, waiter, driver);
        }
    }

    //Validate v_Dashboard
    public void v_Dashboard() {

    }

    //Clicking on e_ClickNavbar
    public void e_ClickNavbar() {
        Helper.clickXpath(navbarAssessments, waiter, driver);
        Helper.screenshot(driver);
    }

    //Validate v_Navbar
    public void v_Navbar() {

    }

    //Validate v_TitlePage
    public void v_TitlePage() {
        Helper.sendKeysXpath(flexAnswerKeyPage.getAddAssessmentTitle(), title, waiter, driver);
        Helper.screenshot(driver);
    }

    //Validate v_AnswerKeyPage
    public void v_AnswerKeyPage() {
        try {
            Thread.sleep(5000);
            Helper.clickXpath(flexAnswerKeyPage.getFlexAnswerKeyCloseButton(), waiter, driver);
        } catch (Exception e) {
            System.out.println("Exception handled add questions popup");
        }
        Helper.clickXpath(answerKey.getAddQuestions(), waiter, driver);
        Helper.sendKeysXpath(answerKey.getQuestionQuality(), Integer.toString(numberOfQuestions), waiter, driver);
        //Helper.clickXpath("//*[@id=\"add-questions-modal___BV_modal_footer_\"]/div/div/button[1]", waiter, driver);
        Helper.clickXpath(answerKey.getAddButton(), waiter, driver);

        int i = 1;
        while (i <= numberOfQuestions) {
            Helper.sendKeysXpath("//span[@class='question-transition']//tr[" + Integer.toString(i) + "]//td[1]//tr[1]//td[4]//div[1]//div[1]//input[1]", permutations[i - 1], waiter, driver);
            i++;
        }
        Helper.waitUntil(answerKey.getQuestionsSaved(), waiter, driver);
        Helper.screenshot(driver);
    }

    //Validate v_LandingPage
    public void v_LandingPage() {
        Helper.clickXpath(flexAnswerKeyPage.getEditButton(), waiter, driver);
        Helper.screenshot(driver);

    }

    //Clicking on e_NavFlexAssessmentClick
    public void e_NavFlexAssessmentClick() {
        Helper.clickXpath(flexAnswerKeyPage.getCreateAssessment(), waiter, driver);
        Helper.clickXpath(flexAnswerKeyPage.getFlexible(), waiter, driver);
        Helper.screenshot(driver);
    }

    //Clicking on e_CreateClick
    public void e_CreateClick() {
        Helper.clickXpath(flexAnswerKeyPage.getCreate(), waiter, driver);
        Helper.screenshot(driver);
    }

    //Clicking on e_DoneClick
    public void e_DoneClick() {
        Helper.clickXpath(flexAnswerKeyPage.getDoneButton(), waiter, driver);
        Helper.screenshot(driver);
    }

}
