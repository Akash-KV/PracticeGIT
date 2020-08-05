package org.graphwalker;

import io.github.bonigarcia.wdm.ChromeDriverManager;
import io.github.bonigarcia.wdm.DriverManagerType;
import io.github.bonigarcia.wdm.EdgeDriverManager;
import io.github.bonigarcia.wdm.FirefoxDriverManager;
import org.graphwalker.PageObjectModels.AssessmentsNavbar;
import org.graphwalker.PageObjectModels.Dashboard;
import org.graphwalker.PageObjectModels.FlexAnswerKeyPage;
import org.graphwalker.PageObjectModels.ItembankAssessment;
import org.graphwalker.core.machine.ExecutionContext;
import org.graphwalker.java.annotation.AfterExecution;
import org.graphwalker.java.annotation.BeforeExecution;
import org.graphwalker.java.annotation.GraphWalker;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.FileReader;


@GraphWalker(value = "quick_random(edge_coverage(100))", start = "e_StartBrowser")
public class CreateNewItembankAssessmentTest extends ExecutionContext implements CreateNewItembankAssessment {

    // Config Declarations
    Config config = new Config();
    String browser, url, username, password, closeBrowser, multiSite, ticket, chrome;
    Boolean headless;
    String title;
    int waitTime;
    FileReader fileReader = null;
    boolean view = false;

    ItembankAssessment ItembankAssessment = new ItembankAssessment();
    AssessmentsNavbar AssessmentsNavbar = new AssessmentsNavbar();
    FlexAnswerKeyPage flexAnswerKeyPage = new FlexAnswerKeyPage();
    Dashboard Dashboard = new Dashboard();

    private static final Logger logger = LoggerFactory.getLogger(CreateNewItembankAssessmentTest.class);
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
        chrome = config.getChrome();
        headless = config.getHeadless();
        title = "mbt_itembank_quickmode_" + ticket;
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
        Helper.clickXpath(Dashboard.getAssessmentsNav(), waiter, driver);
    }

    //Clicking on e_CreateNewItembankAssessmentClick
    public void e_CreateNewItembankAssessmentClick() {
        Helper.clickXpath(flexAnswerKeyPage.getCreateAssessment(), waiter, driver);
        Helper.clickXpath(ItembankAssessment.getItemBank(), waiter, driver);
        Helper.screenshot(driver);
    }

    //Validate v_CreateNewItembankAssessment
    public void v_CreateNewItembankAssessment() {
        Helper.clickXpath(ItembankAssessment.getQuickMode(), waiter, driver);
    }

    //Clicking on e_NextClick
    public void e_NextClick() {
        Helper.clickXpath(ItembankAssessment.getNextButton(), waiter, driver);
    }

    //Validate v_StepOne
    public void v_StepOne() {
        Helper.sendKeysId(ItembankAssessment.getTitleInput(), title, waiter, driver);
    }

    //Clicking on e_CreateClick
    public void e_CreateClick() {
        Helper.clickXpath(ItembankAssessment.getCreateButton(), waiter, driver);
    }

    //Validate v_StepTwo
    public void v_StepTwo() {
        Helper.clickXpath(ItembankAssessment.getStandardDocument(), waiter, driver);
//        Select select = new Select(driver.findElement(By.xpath("//select[@id='standard_document']")));
//        select.selectByVisibleText("Content Standards");
        Helper.clickXpath(ItembankAssessment.getOptionOne(), waiter, driver);

        Helper.clickXpath(ItembankAssessment.getStandardSubject(), waiter, driver);
        Helper.clickXpath(ItembankAssessment.getOptionTwo(), waiter, driver);

        Helper.clickXpath(ItembankAssessment.getStandardCategory(), waiter, driver);
        Helper.clickXpath(ItembankAssessment.getOptionFive(), waiter, driver);

        String numberOfStandards = driver.findElement(By.xpath(ItembankAssessment.getNumberOfStandards())).getText();
        int i = 1;
        while (!numberOfStandards.equals("1") && i != 4) {
            Helper.clickXpath(ItembankAssessment.getStepTwoStandards(), waiter, driver);
            numberOfStandards = driver.findElement(By.xpath(ItembankAssessment.getNumberOfStandards())).getText();
            i++;
        }
    }

    //Clicking on e_GoToStepFour
    public void e_GoToStepFour() {
        Helper.clickXpath(ItembankAssessment.getGotoStepFour(), waiter, driver);
    }

    //Validate v_StepFour
    public void v_StepFour() {
        Helper.clickXpath(ItembankAssessment.getGenerateQuestions(), waiter, driver);
        int elements = driver.findElements(By.xpath(ItembankAssessment.getQuickQuestions())).size();
        while (elements == 0) {
            Helper.wait(10.0);
            elements = driver.findElements(By.xpath(ItembankAssessment.getQuickQuestions())).size();
            driver.navigate().refresh();
            System.out.println(elements);
        }

        try {
            Helper.clickXpath(ItembankAssessment.getGenerateQuestionsForAll(), waiter, driver);
        } catch (Exception e) {
            System.out.println("Exception handled...");
        }
        waiter.until(ExpectedConditions.elementToBeClickable(By.xpath(ItembankAssessment.getReadyToPublishItemBnak())));

        Helper.clickXpath(ItembankAssessment.getReadyToPublishItemBnak(), waiter, driver);
        Helper.clickXpath(ItembankAssessment.getPublishAdminister(), waiter, driver);
    }

    @Test
    //Validate v_Verify
    public void v_Verify() {
        Helper.assertion(ItembankAssessment.getSubActions(), title, waiter, driver);
    }
}
