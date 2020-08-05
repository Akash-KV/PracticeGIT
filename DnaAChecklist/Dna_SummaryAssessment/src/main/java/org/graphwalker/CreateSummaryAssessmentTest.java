package org.graphwalker;

import io.github.bonigarcia.wdm.ChromeDriverManager;
import io.github.bonigarcia.wdm.DriverManagerType;
import io.github.bonigarcia.wdm.EdgeDriverManager;
import io.github.bonigarcia.wdm.FirefoxDriverManager;
import org.checkerframework.checker.units.qual.C;
import org.graphwalker.PageObjectModels.AssessmentsNavbar;
import org.graphwalker.PageObjectModels.CreateAssessmentModal;
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

@GraphWalker(value = "quick_random(edge_coverage(100))", start = "e_StartBrowser")
public class CreateSummaryAssessmentTest extends ExecutionContext implements CreateSummaryAssessment {
    AssessmentsNavbar assessmentsNavbar = new AssessmentsNavbar();
    CreateAssessmentModal createAssessmentModal = new CreateAssessmentModal();

    //Declarations
    Config config = new Config();
    String browser, url, username, password, closeBrowser, multiSite, ticket, chrome;
    Boolean headless;
    int waitTime;

    //NavBar
    String navbarAssessments = assessmentsNavbar.getAssessmentNavBarNavBarAssessments();

    //Logger and WebDrivers
    private static final Logger logger = LoggerFactory.getLogger(CreateSummaryAssessmentTest.class);
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

    // Validate v_BrowserStarted
    public void v_BrowserStarted() {
        Assert.assertNotNull(driver);
    }

    // clicking on e_EnterBaseURL
    public void e_EnterBaseURL() {
        driver.get(url);
    }

    // Validate v_BaseURL
    public void v_BaseURL() {
    }

    // clicking on e_DirectLogin
    public void e_DirectLogin() {
        if (config.getAuthX().equalsIgnoreCase("true")) {
            Helper.loginAuthX(username, password, waiter, driver);
        } else {
            Helper.login(username, password, waiter, driver);
        }
    }

    // Validate v_Dashboard
    public void v_Dashboard() {

    }

    // clicking on e_ClickNavbar
    public void e_ClickNavbar() {
        Helper.clickXpath(navbarAssessments, waiter, driver);
        Helper.screenshot(driver);
    }

    // Validate v_Navbar
    public void v_Navbar() {

    }

    // clicking on e_NavSummaryAssessmentClick
    public void e_NavSummaryAssessmentClick() {
        try {
            Helper.clickXpath(assessmentsNavbar.getAssessmentNavBarCreateAssessmentNavBar(), waiter, driver);
            //Click Other
            waiter.until(ExpectedConditions.elementToBeClickable(By.xpath(createAssessmentModal.getOthersTab())));
            Helper.clickXpath(createAssessmentModal.getOthersTab(), waiter, driver);

            Helper.clickXpath(createAssessmentModal.getClickSummaryTab(), waiter, driver);
            Helper.screenshot(driver);
        } catch (Exception message) {
            System.out.println("Exception handled....");
        }
    }

    // clicking on e_ViewSummaryAssessmentClick
    public void e_ViewSummaryAssessmentClick() {
        //Click Other
        waiter.until(ExpectedConditions.elementToBeClickable(By.xpath(createAssessmentModal.getOthersTab())));
        Helper.clickXpath(createAssessmentModal.getOthersTab(), waiter, driver);

        Helper.clickXpath(createAssessmentModal.getClickSummaryTab(), waiter, driver);
        Helper.screenshot(driver);
    }

    // Validate v_SummaryAssessmentPage
    public void v_SummaryAssessmentPage() {
        Helper.sendKeysXpath(createAssessmentModal.getSummaryTitleTextField(), ticket + "summary", waiter, driver);
        Helper.screenshot(driver);
    }

    // clicking on e_Save
    public void e_Save() {
        Helper.clickXpath(createAssessmentModal.getSaveButton(), waiter, driver);
        Helper.screenshot(driver);
    }

    // Validate v_OverviewPage
    public void v_OverviewPage() {
        Helper.assertion(createAssessmentModal.getOverViewPage(), ticket + "summary", waiter, driver);
        Helper.screenshot(driver);
    }

    // clicking on e_ViewAssessments
    public void e_ViewAssessments() {
        Helper.clickXpath(assessmentsNavbar.getAssessmentNavBarViewAssessment(), waiter, driver);
        Helper.screenshot(driver);
    }

    // Validate v_ViewAssessments
    public void v_ViewAssessments() {
        Helper.clickXpath(assessmentsNavbar.getAssessmentNavBarCreateButton(), waiter, driver);
        Helper.screenshot(driver);
    }
}
