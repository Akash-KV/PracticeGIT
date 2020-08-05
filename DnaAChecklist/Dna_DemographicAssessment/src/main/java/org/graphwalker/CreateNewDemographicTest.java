package org.graphwalker;

import io.github.bonigarcia.wdm.ChromeDriverManager;
import io.github.bonigarcia.wdm.DriverManagerType;
import io.github.bonigarcia.wdm.EdgeDriverManager;
import io.github.bonigarcia.wdm.FirefoxDriverManager;
import org.graphwalker.PageObjectModels.AssessmentViewPage;
import org.graphwalker.PageObjectModels.AssessmentsNavbar;
import org.graphwalker.PageObjectModels.Dashboard;
import org.graphwalker.PageObjectModels.ViewAssessmentsPage;
import org.graphwalker.core.machine.ExecutionContext;
import org.graphwalker.java.annotation.AfterExecution;
import org.graphwalker.java.annotation.BeforeExecution;
import org.graphwalker.java.annotation.GraphWalker;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.openqa.selenium.chrome.ChromeOptions;

@GraphWalker(value = "quick_random(edge_coverage(100))", start = "e_StartBrowser")
/** Test class for CreateNewDemographic **/
public class CreateNewDemographicTest extends ExecutionContext implements CreateNewDemographic {

    //Declarations
    Config config = new Config();
    String browser, url, username, password, closeBrowser, multiSite, ticket, chrome;
    Boolean headless;
    int waitTime;

    //Logger and WebDrivers
    private static final Logger logger = LoggerFactory.getLogger(CreateNewDemographicTest.class);
    WebDriver driver = null;
    WebDriverWait waiter = null;
    Dashboard dashboard = new Dashboard();
    AssessmentsNavbar assessmentsNavbar = new AssessmentsNavbar();
    ViewAssessmentsPage viewAssessmentsPage = new ViewAssessmentsPage();
    DataReader dataReader = new DataReader();
    AssessmentViewPage assessmentViewPage = new AssessmentViewPage();

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

    // To start browser
    public void e_StartBrowser() {
        if (!chrome.equals("")) {
            System.setProperty("webdriver.chrome.driver", chrome);
        }
        //Driver Instance
        if (browser.equals("chrome") && headless == true) {
            ChromeOptions options = new ChromeOptions();
            options.addArguments("window-size=1600,1600");
            options.addArguments("--headless");
            options.addArguments("--disable-gpu");
            options.addArguments("--disable-extensions");
            System.setProperty(ChromeDriverService.CHROME_DRIVER_SILENT_OUTPUT_PROPERTY, "true");
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

    // To validate browser started
    public void v_BrowserStarted() {
        Assert.assertNotNull(driver);
    }

    // To enter Url
    public void e_EnterBaseURL() {
        driver.get(url);
        Helper.screenshot(driver);
    }

    // To validate Url
    public void v_BaseURL() {
        waiter.until(ExpectedConditions.titleContains("Illuminate Education"));
        Helper.screenshot(driver);
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

    // To click NavBar
    public void e_ClickNavbar() {
        //Helper.clickXpath(navbarAssessments, waiter, driver);
        Helper.clickXpath(dashboard.getAssessmentsNav(), waiter, driver);
        Helper.screenshot(driver);
    }

    public void v_Navbar() {
    }

    // To create Demographic
    public void e_CreateDemographic() {
        //Click Create Assessment
        Helper.clickXpath(assessmentsNavbar.getCreateAssessment(), waiter, driver);

        //Click Other and Demographic
        waiter.until(ExpectedConditions.elementToBeClickable(By.xpath(viewAssessmentsPage.getOther())));
        Helper.clickXpath(viewAssessmentsPage.getOther(), waiter, driver);

        Helper.clickXpath(viewAssessmentsPage.getDemographic(), waiter, driver);
        Helper.screenshot(driver);
    }

    // To click ViewAssessments
    public void e_ViewAssessments() {
        Helper.clickXpath(assessmentsNavbar.getViewAssessment(), waiter, driver);
        Helper.screenshot(driver);
    }

    // To validate ViewAssessments
    public void v_ViewAssessments() {
        Helper.clickXpath(viewAssessmentsPage.getCreateButton(), waiter, driver);
        Helper.screenshot(driver);
    }

    // To Click Demographic
    public void e_DemographicClick() {
        //Click Other
        waiter.until(ExpectedConditions.elementToBeClickable(By.xpath(viewAssessmentsPage.getOther())));
        Helper.clickXpath(viewAssessmentsPage.getOther(), waiter, driver);

        Helper.clickXpath(viewAssessmentsPage.getDemographic(), waiter, driver);
        Helper.screenshot(driver);
    }

    // To validate NewDemographic
    public void v_CreateNewDemographic() {
        Helper.sendKeysId(viewAssessmentsPage.getDemographicTitle(), ticket + "demographic", waiter, driver);
        Helper.screenshot(driver);
    }

    // To click save
    public void e_Save() {
        Helper.clickId(viewAssessmentsPage.getDemographicSave(), waiter, driver);
        Helper.screenshot(driver);
    }

    // To validate Overview
    public void v_Overview() {
        waiter.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(assessmentViewPage.getDemographicOverview())));
        Helper.screenshot(driver);
    }
}
