package org.graphwalker;

import io.github.bonigarcia.wdm.ChromeDriverManager;
import io.github.bonigarcia.wdm.DriverManagerType;
import io.github.bonigarcia.wdm.EdgeDriverManager;
import io.github.bonigarcia.wdm.FirefoxDriverManager;
import org.graphwalker.PageObjectModels.AssessmentsNavbar;
import org.graphwalker.PageObjectModels.CreateAssessmentModal;
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
//Test Class For CreateSurveyAssessmentTest
public class CreateSurveyAssessmentTest extends ExecutionContext implements CreateSurveyAssessment {

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
    private static final Logger logger = LoggerFactory.getLogger(CreateSurveyAssessmentTest.class);
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
        ticket = config.getTicket();
        multiSite = config.getMultiSite();
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

    //Validate v_BaseURL
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
    }

    //Validate v_Navbar
    public void v_Navbar() {

    }

    //Clicking on e_CreateSurveyClick
    public void e_CreateSurveyClick() {
        try {
            Helper.clickXpath(assessmentsNavbar.getAssessmentNavBarCreateAssessmentNavBar(), waiter, driver);
            //Click Other
            waiter.until(ExpectedConditions.elementToBeClickable(By.xpath(createAssessmentModal.getLegacyTab())));
            Helper.clickXpath(createAssessmentModal.getLegacyTab(), waiter, driver);

            Helper.clickXpath(createAssessmentModal.getClickSurvey(), waiter, driver);
            Helper.screenshot(driver);
        } catch (Exception message) {
            System.out.println("Exception handled....");
        }
    }

    //Validate v_CreateSurvey
    public void v_CreateSurvey() {
        Helper.sendKeysXpath(createAssessmentModal.getCreateSurveyName(), "mbt_survey_" + ticket, waiter, driver);
    }

    //Clicking on e_Save
    public void e_Save() {
        Helper.clickXpath(createAssessmentModal.getCreateSurvey(), waiter, driver);
    }

    //Validate v_Overview
    public void v_Overview() {
        for (int i = 1; i <= 9; i += 2) {
            Helper.sendKeysXpath("//tr[" + Integer.toString(i) + "]/td[2]/input[1]", "Question text for " + Integer.toString(i), waiter, driver);
        }
        try {
            for (int i = 2; i <= 10; i += 2) {
                Thread.sleep(500);
                Helper.clickXpath("//tr[" + Integer.toString(i) + "]//td[2]//table[1]//tbody[1]//tr[1]//td[2]//a[1]", waiter, driver);
                Helper.sendKeysXpath("//tr[" + Integer.toString(i) + "]/td[2]/table[1]/tbody[1]/tr[1]/td[1]/input[2]", "A", waiter, driver);
                Helper.sendKeysXpath("//tr[" + Integer.toString(i) + "]/td[2]/table[1]/tbody[1]/tr[1]/td[2]/input[1]", "This is the answer for Answer Text " + Integer.toString(i), waiter, driver);
            }
        } catch (Exception e) {
            System.out.println("Exception handled....");
        }
        Helper.clickXpath(createAssessmentModal.getSaveChanges(), waiter, driver);
    }
}
