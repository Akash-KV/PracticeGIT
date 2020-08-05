package org.graphwalker;

import Utils.Helper;
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
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.FileReader;


@GraphWalker(value = "quick_random(edge_coverage(100))", start = "e_StartBrowser")
//Test Class for CreateManualAssessmentTest
public class CreateManualAssessmentTest extends ExecutionContext implements CreateManualAssessment {

    // Config Declarations
    Config config = new Config();
    String browser, url, username, password, closeBrowser, multiSite, ticket, studentQrId, studentPortalUn, studentPortalPw, environment, chrome;
    Boolean headless;
    String title;

    // Site Variables
    String domain;
    String homeConnectionUrl = "http://demo.illuminatehc.com";
    String administrationsPage;
    String quickRoster;
    String quickRosterUrl;

    int waitTime;
    FileReader fileReader = null;
    boolean view = false;
    String[] permutations = new String[]{"11.5", "11", "1", "0", "0.5", "101"};
    int numberOfQuestions = permutations.length;

    private static final Logger logger = LoggerFactory.getLogger(CreateManualAssessmentTest.class);
    WebDriver driver = null;
    WebDriverWait waiter = null;

    // POMs
    Dashboard dashboard = new Dashboard();
    AssessmentsNavbar assessmentsNavbar = new AssessmentsNavbar();
    CreateAssessmentModal createAssessmentModal = new CreateAssessmentModal();
    ManualAssessmentPage manualAssessmentPage = new ManualAssessmentPage();
    ManualAssessmentOverviewPage manualAssessmentOverviewPage = new ManualAssessmentOverviewPage();
    OnlineTestingAdministrationPage onlineTestingAdministrationPage = new OnlineTestingAdministrationPage();

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
        String[] strArray = url.split("/");
        domain = strArray[2];
        strArray = domain.split("\\.");
        domain = strArray[0];

        if (environment.equals("prod") || environment.equals("production")) {
            quickRosterUrl = "https://testing.illuminateed.com/auth/quick?access_code=";
            homeConnectionUrl = "https://" + domain + "illuminatehc.com";
        } else {
            quickRosterUrl = "https://onlinetesting" + domain + ".illuminateed.io/auth/quick?access_code=";
            homeConnectionUrl = "https://" + domain + "illuminatehc.io";
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

    //Login
    public void e_StartBrowser() {
        if (!chrome.equals("")) {
            System.setProperty("webdriver.chrome.driver", chrome);
        }
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
        } else {
            driver = new EdgeDriver();
        }
        Assert.assertNotNull(driver);
        waiter = new WebDriverWait(driver, waitTime);
    }

    //Validate v_BrowserStarted
    public void v_BrowserStarted() {
        Assert.assertNotNull(driver);
    }

    @Override
    //Clicking on e_EnterBaseURL
    public void e_EnterBaseURL() {
        Helper.screenshot(driver);
        try {
            driver.get(url);
        } catch (Exception message) {
            Helper.exception("URL does not exists" + url);
        }
    }

    //Validate v_BaseURL
    public void v_BaseURL() {
        Helper.screenshot(driver);
        try {
            waiter.until(ExpectedConditions.titleContains("Illuminate Education"));
        } catch (Exception message) {
            Helper.exception("Illuminate Education title was not rendered");
        }
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
        view = false;
    }

    //Clicking on e_ClickNavbar
    public void e_ClickNavbar() {
        title = "";
        title = "mbt_manual_all";
        try {
            Helper.clickXpath(dashboard.getAssessmentsNav(), waiter, driver);
        } catch (Exception message) {
            Helper.exception("Could not click on Assessments Navbar Icon");
        }
    }

    //Validate v_Navbar
    public void v_Navbar() {
    }

    //Clicking on e_CreateNewAssessmentClick
    public void e_CreateNewAssessmentClick() {
        try {
            Helper.clickXpath(assessmentsNavbar.getCreateAssessment(), waiter, driver);
            Helper.clickXpath(createAssessmentModal.getCreateAssessmentModelClickLegacyTab(), waiter, driver);
        } catch (Exception message) {
            Helper.exception("Create Manual Assessment is not clickable");
        }
    }

    //Validate v_CreateNewAssessment
    public void v_CreateNewAssessment() {
        Helper.clickXpath(createAssessmentModal.getCreateAssessmentModelClickManual(), waiter, driver);
        Helper.sendKeysXpath(createAssessmentModal.getCreateAssessmentModalNumberOfQuestions(), Integer.toString(numberOfQuestions), waiter, driver);
    }

    //Clicking on e_OkayClick
    public void e_OkayClick() {
        Helper.clickXpath(createAssessmentModal.getCreateAssessmentModalCreateButton(), waiter, driver);

    }

    //Validate v_StepOne
    public void v_StepOne() {
        Helper.sendKeysXpath(manualAssessmentPage.getStepOneTitle(), title, waiter, driver);
    }

    //Clicking on e_NextClick
    public void e_NextClick() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        WebElement element = driver.findElement(By.xpath(manualAssessmentPage.getNextButton()));
        js.executeScript("arguments[0].scrollIntoView(true);", element);
        Helper.wait(4.0);
        Helper.clickXpath(manualAssessmentPage.getNextButton(), waiter, driver);
    }

    //Validate v_StepTwo
    public void v_StepTwo() {
        Helper.clickXpath(manualAssessmentPage.getStepTwoSubjectArea(), waiter, driver);
        Helper.clickXpath(manualAssessmentPage.getStepTwoSubjectAreaDropdownOptionChosen(), waiter, driver);
        Helper.clickXpath(manualAssessmentPage.getStepTwoSearch(), waiter, driver);
        Helper.clickXpath(manualAssessmentPage.getStepTwoSearchResultFirstOptionChosen(), waiter, driver);
        Helper.clickXpath(manualAssessmentPage.getStepTwoLinkSelectedStandardsButton(), waiter, driver);
    }

    //Validate v_StepThree
    public void v_StepThree() {
        // 1 - MC
        Actions actions = new Actions(driver);
        WebElement element;
        int i = 1;

        while (i <= numberOfQuestions) {
            element = waiter.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//tbody//tr[" + Integer.toString(i) + "]//td[3]")));
            actions.moveToElement(element);
            actions.click();
            actions.click();
            actions.sendKeys("A");
            actions.build().perform();

            element = waiter.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//table[1]/tbody[1]/tr[" + Integer.toString(i) + "]/td[4]")));
            actions.moveToElement(element);
            actions.click();
            actions.sendKeys(permutations[i - 1]);
            actions.build().perform();
            i++;
        }
    }

    //Validate v_StepSeven
    public void v_StepSeven() {
        Helper.clickXpath(manualAssessmentPage.getStepSevenTabButton(), waiter, driver);
    }

    //Clicking on e_GoBackToStepThree
    public void e_GoBackToStepThree() {
        Helper.clickXpath(manualAssessmentPage.getManualAssessmentPageGoBackToStepThree(), waiter, driver);
    }

    //Validate v_StepThreeValidation
    public void v_StepThreeValidation() {
        int i = 1;

        while (i <= numberOfQuestions) {
            String weight = "//table[1]/tbody[1]/tr[" + Integer.toString(i) + "]/td[4]";
            Helper.assertionText(weight, permutations[i - 1], waiter, driver);
            i++;
        }
    }
}
