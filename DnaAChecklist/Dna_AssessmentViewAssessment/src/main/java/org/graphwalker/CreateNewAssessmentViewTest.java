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
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

@GraphWalker(value = "quick_random(edge_coverage(100))", start = "e_StartBrowser")
/** Test class for CreateNewAssessmentView **/
public class CreateNewAssessmentViewTest extends ExecutionContext implements CreateNewAssessmentView {

    //Declarations
    Config config = new Config();
    String browser, url, username, password, closeBrowser, multiSite, ticket, chrome, userFullName;
    Boolean headless;
    int waitTime;

    Dashboard dashboard = new Dashboard();
    AssessmentsNavbar assessmentsNavbar = new AssessmentsNavbar();
    ViewAssessmentsPage viewAssessmentsPage = new ViewAssessmentsPage();
    AssessmentViewPage assessmentViewPage = new AssessmentViewPage();
    DataReader dataReader = new DataReader();


    //Logger and WebDrivers
    //private static final Logger logger = LoggerFactory.getLogger(CreateNewAssessmentViewTest.class);
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
        userFullName = config.getUserFullName();
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

    // To start Browser
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
    }

    // To validate Url
    public void v_BaseURL() {
        waiter.until(ExpectedConditions.titleContains("Illuminate Education"));
    }

    // To enter Credentials
    public void e_DirectLogin() {
        if (config.getAuthX().equalsIgnoreCase("true")) {
            Helper.loginAuthX(username, password, waiter, driver);
        } else {
            Helper.login(username, password, waiter, driver);
        }
    }

    // To validate Dashboard
    public void v_Dashboard() {
        //Check popup
        try {
            Helper.clickXpath(dashboard.getPopup(), waiter, driver);
        } catch (Exception e) {
            System.out.println("Exception handled for popup....");
        }
    }

    // To click Navbar
    public void e_ClickNavbar() {
        Helper.clickXpath(dashboard.getAssessmentsNav(), waiter, driver);
    }

    public void v_Navbar() {
    }

    // To click CreateAssessmentView
    public void e_CreateAssessmentView() {
        Helper.clickXpath(assessmentsNavbar.getAssessmentView(), waiter, driver);
    }

    // To click ViewAssessment
    public void e_ViewAssessments() {
        Helper.clickXpath(assessmentsNavbar.getViewAssessment(), waiter, driver);
    }

    // To validate ViewAssessment
    public void v_ViewAssessments() {
        Helper.clickXpath(viewAssessmentsPage.getCreateButton(), waiter, driver);
    }

    // To validate CreateNewAssessmentView
    public void v_CreateNewAssessmentView() {
        Helper.sendKeysXpath(assessmentViewPage.getTitleInputFieldNew(), ticket + "assessmentview", waiter, driver);
    }

    // To click save
    public void e_Save() {
        //Handle Select Assessment - Added on 01/06/2020
        try {
            Helper.clickXpath(assessmentViewPage.getSelectAssessmentsButton(), waiter, driver);
            waiter.until(ExpectedConditions.elementToBeClickable(By.xpath(assessmentViewPage.getAddAssessmentsSearchBox())));
            Helper.sendKeysXpath(assessmentViewPage.getAddAssessmentsSearchBox(), userFullName, waiter, driver);
            Helper.clickXpath(assessmentViewPage.getAddAssessmentsSearchButton(), waiter, driver);
            waiter.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(assessmentViewPage.getAddAssessmentsLoading())));
            Thread.sleep(10000);
            waiter.until(ExpectedConditions.elementToBeClickable(By.xpath(assessmentViewPage.getAddAssessmentsFirstCheckbox())));
//            Actions actions = new Actions(driver);
//            actions.doubleClick(driver.findElement(By.xpath(assessmentViewPage.getAddAssessmentsFirstCheckbox()))).click().build().perform();
            Helper.clickXpath(assessmentViewPage.getAddAssessmentsFirstCheckbox(), waiter, driver);
            waiter.until(ExpectedConditions.elementToBeClickable(By.xpath(assessmentViewPage.getAddAssessmentsAddButton())));
            Helper.waitUntilAjaxLoaded(driver);
            waiter.until(ExpectedConditions.elementToBeClickable(By.xpath(assessmentViewPage.getAddAssessmentsAddButton())));
            Helper.clickXpath(assessmentViewPage.getAddAssessmentsAddButton(), waiter, driver);
            waiter.until(ExpectedConditions.elementToBeClickable(By.xpath(assessmentViewPage.getAssessmentsShowLink())));
            System.out.println("Assessment added for assessment view....");
            Helper.clickXpath(assessmentViewPage.getSaveButton(), waiter, driver);
        } catch (Exception e) {
            System.out.println("Exception handled for method - e_Save" + e);
        }
    }

    // To validate Overview
    public void v_Overview() {
        //waiter.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(assessmentViewPage.getOverview())));
    }

    // To click AssessmentView
    public void e_AssessmentViewClick_ViewAssessment() {
        String assessmentName = ticket + "QAFlexibleTest";

        //Create Flex Assessment
        try {
            Helper.clickXpath(dashboard.getPopup(), waiter, driver);
        } catch (Exception e) {
            System.out.println("Exception handled for popup....");
        }
        Helper.clickXpath(viewAssessmentsPage.getFlexible(), waiter, driver);
        Helper.sendKeysXpath(viewAssessmentsPage.getAddAssessmentTitle(), assessmentName, waiter, driver);
        Helper.clickXpath(viewAssessmentsPage.getCreateFlexibleButton(), waiter, driver);
        waiter.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(viewAssessmentsPage.getAddQuestionsButton())));

        Helper.clickXpath(dashboard.getAssessmentsNav(), waiter, driver);
        Helper.clickXpath(assessmentsNavbar.getViewAssessment(), waiter, driver);

        //Search Created Flex Assessment
        Helper.sendKeysXpath(viewAssessmentsPage.getSearchAssessmentInput(), assessmentName, waiter, driver);

        Helper.clickId(viewAssessmentsPage.getViewAssessmentSearchButton(), waiter, driver);
        waiter.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(viewAssessmentsPage.getLoader())));
        Helper.waitUntilAjaxLoaded(driver);

        //Link to assessment view
        Helper.clickXpath("//a[.='" + assessmentName + "']/preceding::td[1]//input[1]", waiter, driver);
        Select option = new Select(driver.findElement(By.id(viewAssessmentsPage.getActionsDropdownSelect())));
        option.selectByVisibleText("Link to Assessment View(s)");
        Helper.clickXpath(viewAssessmentsPage.getSubmitButton(), waiter, driver);
        waiter.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(viewAssessmentsPage.getLinkToAssessmentsModal())));
    }

    // To validate CreateNewAssessmentView
    public void v_CreateNewAssessmentView_ViewAssessments() {
        Helper.clickXpath(viewAssessmentsPage.getNewAssessmentView(), waiter, driver);
        Helper.sendKeysXpath(assessmentViewPage.getTitleInputField(), ticket + "assessmentview", waiter, driver);
    }

    // To save ViewAssessments
    public void e_Save_ViewAssessments() {
        String viewName = ticket + "assessmentview";

        //Submit
        Helper.clickXpath(viewAssessmentsPage.getSubmitButtonInAssessmentViewPopup(), waiter, driver);
        waiter.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(viewAssessmentsPage.getAlert())));

        //Search and Verify
        Helper.sendKeysXpath(viewAssessmentsPage.getSearchAssessmentInput(), viewName, waiter, driver);
        Helper.clickId(viewAssessmentsPage.getViewAssessmentSearchButton(), waiter, driver);
        waiter.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(viewAssessmentsPage.getLoader())));
        Helper.waitUntilAjaxLoaded(driver);

        waiter.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[.='" + viewName + "']")));
    }
}
