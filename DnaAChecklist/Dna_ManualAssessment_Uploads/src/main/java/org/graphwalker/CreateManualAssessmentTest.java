package org.graphwalker;

import Controllers.ManualAssessmentController;
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
import java.text.SimpleDateFormat;


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
    String timeStamp = new SimpleDateFormat("HH:mm:ss-MM/dd/yyyy").format(new java.util.Date());
    String uploadPdf, uploadPdf2, uploadDoc, uploadPpt;
    Boolean isPdf;

    int waitTime;
    FileReader fileReader = null;
    boolean view = false;
    int numberOfQuestions = 3;

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

    //validate v_BrowserStarted
    public void v_BrowserStarted() {
        Assert.assertNotNull(driver);
    }

    @Override
    // clicking on EnterBaseUrl
    public void e_EnterBaseURL() {
        Helper.screenshot(driver);
        driver.get(url);
    }

    //validate v_BaseURL
    public void v_BaseURL() {
        Helper.screenshot(driver);
        waiter.until(ExpectedConditions.titleContains("Illuminate Education"));
    }

    //clicking on e_DirectLogin
    public void e_DirectLogin() {
        if (config.getAuthX().equalsIgnoreCase("true")) {
            Helper.loginAuthX(username, password, waiter, driver);
        } else {
            Helper.login(username, password, waiter, driver);
        }
    }

    //validate v_Dashboard
    public void v_Dashboard() {
        view = false;
    }

    // clicking on e_ClickNavbar
    public void e_ClickNavbar() {
        isPdf = true;
        title = "manual_uploads_" + timeStamp;
        uploadPdf = System.getProperty("user.dir") + "/src/main/resources/org/graphwalker/upload_pdf.pdf";
        uploadPdf2 = System.getProperty("user.dir") + "/src/main/resources/org/graphwalker/upload_pdf_2.pdf";
        uploadDoc = System.getProperty("user.dir") + "/src/main/resources/org/graphwalker/upload_doc.doc";
        uploadPpt = System.getProperty("user.dir") + "/src/main/resources/org/graphwalker/upload_ppt.pptx";
        Helper.clickXpath(dashboard.getAssessmentsNav(), waiter, driver);
    }

    // validate v_navBar
    public void v_Navbar() {
    }

    // clicking on e_CreateNewAssessmentClick
    public void e_CreateNewAssessmentClick() {
        Helper.clickXpath(assessmentsNavbar.getCreateAssessment(), waiter, driver);
        Helper.clickXpath(createAssessmentModal.getCreateAssessmentModelClickLegacyTab(), waiter, driver);
    }

    //validate v_CreateNewAssessment
    public void v_CreateNewAssessment() {
        Helper.clickXpath(createAssessmentModal.getCreateAssessmentModelClickManual(), waiter, driver);
        Helper.sendKeysXpath(createAssessmentModal.getCreateAssessmentModelNumberOfQuestions(), Integer.toString(numberOfQuestions), waiter, driver);
    }

    // clicking on e_OkayClick
    public void e_OkayClick() {
        Helper.clickXpath(createAssessmentModal.getCreateAssessmentModelCreateButton(), waiter, driver);
    }

    //validate v_StepOne
    public void v_StepOne() {
        Helper.sendKeysXpath(manualAssessmentPage.getStepOneTitle(), title, waiter, driver);
    }

    // clicking on e_NextClick
    public void e_NextClick() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        WebElement element = driver.findElement(By.xpath(manualAssessmentPage.getNextButton()));
        js.executeScript("arguments[0].scrollIntoView(true);", element);
        Helper.wait(4.0);
        Helper.clickXpath(manualAssessmentPage.getNextButton(), waiter, driver);
    }

    //validate v_StepTwo
    public void v_StepTwo() {
        Helper.clickXpath(manualAssessmentPage.getStepTwoSubjectArea(), waiter, driver);
        Helper.clickXpath(manualAssessmentPage.getStepTwoSubjectAreaDropdownOptionChosen(), waiter, driver);
        Helper.clickXpath(manualAssessmentPage.getStepTwoSearch(), waiter, driver);
        Helper.clickXpath(manualAssessmentPage.getStepTwoSearchResultFirstOptionChosen(), waiter, driver);
        Helper.clickXpath(manualAssessmentPage.getStepTwoLinkSelectedStandardsButton(), waiter, driver);
    }

    // validate v_StepThree
    public void v_StepThree() {
        // MC
        Actions actions = new Actions(driver);
        WebElement element = waiter.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(manualAssessmentPage.getManualAssessmentStepThree())));
        actions.moveToElement(element);
        actions.click();
        actions.click();
        actions.sendKeys("A");
        actions.build().perform();

        element = waiter.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(manualAssessmentPage.getManualAssessmentNextOne())));
        actions.moveToElement(element);
        actions.click();
        actions.click();
        actions.sendKeys("1");
        actions.build().perform();

        element = waiter.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(manualAssessmentPage.getManualAssessmentStepNext())));
        actions.moveToElement(element);
        actions.click();
        actions.click();
        actions.sendKeys("A:1,AB:2,ABC:3");
        actions.build().perform();
    }

    // validate v_StepFour
    public void v_StepFour() {
        ManualAssessmentController.Uploads.upload(uploadPdf, waiter, driver);
    }

    // validate v_StepSeven
    public void v_StepSeven() {
        Helper.clickXpath(manualAssessmentPage.getStepSevenTabButton(), waiter, driver);
    }

    //clicking on e_ExitCreationMode
    public void e_ExitCreationMode() {
        Helper.clickXpath(manualAssessmentPage.getStepSevenExitCreationModeButton(), waiter, driver);
    }

    // validate v_AssessmentDetailsAndMaterials
    public void v_AssessmentDetailsAndMaterials() {
        Assert.assertEquals(title, waiter.until(ExpectedConditions.elementToBeClickable(By.xpath(manualAssessmentPage.getManualAssessmentAssessmentInfo()))).getText());
        ManualAssessmentController.Uploads.uploadFromDetails(uploadDoc, waiter, driver);
        ManualAssessmentController.Uploads.uploadFromSetupTabMaterialsDrodown(uploadPpt, waiter, driver);

    }

    //clicking on e_GoToAdministrationPage
    public void e_GoToAdministrationPage() {
        Helper.clickXpath(manualAssessmentOverviewPage.getAdministrationTabButton(), waiter, driver);
        Helper.clickXpath(manualAssessmentOverviewPage.getAdministrationTabDropdownOnlineTestingOption(), waiter, driver);
    }

    //validate v_AdministrationPage
    public void v_AdministrationPage() {
        // checkPreviewOnlineTestingFromAdministrationPage
        ManualAssessmentController.Uploads.uploadPreviewOnlineTestingFromAdministrationPage("upload_pdf_2", uploadPdf2, true, waiter, driver);
        ManualAssessmentController.Uploads.checkPreviewOnlineTestingFromAdministrationPage("upload_doc", false, waiter, driver);
        ManualAssessmentController.Uploads.checkPreviewOnlineTestingFromAdministrationPage("upload_ppt", false, waiter, driver);
        ManualAssessmentController.Uploads.checkPreviewOnlineTestingFromAdministrationPage("upload_pdf", true, waiter, driver);

        // Quickroster
        Helper.clickXpath(onlineTestingAdministrationPage.getTestWithQuickCodeButton(), waiter, driver);
        if (driver.findElements(By.xpath(onlineTestingAdministrationPage.getTestWithQuickCodePostCreationModalExitButton())).size() != 0) {
            Helper.clickXpath(onlineTestingAdministrationPage.getTestWithQuickCodePostCreationModalExitButton(), waiter, driver);
        }

        try {
            String completeBar = Helper.getText(onlineTestingAdministrationPage.getOnlineTestingAdministrationCompleteBarText(), waiter, driver);
            while (!completeBar.equals("Complete")) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                completeBar = Helper.getText(onlineTestingAdministrationPage.getOnlineTestingAdministrationCompleteBarText(), waiter, driver);
            }
        } catch (Exception e) {
            System.out.println("Exception handled for complete bar...");
        }

        administrationsPage = driver.getCurrentUrl();
        System.out.println("<mbt-output-url> " + administrationsPage);
        quickRoster = Helper.getText(onlineTestingAdministrationPage.getOnlineTestingAdministrationQuickRoster(), waiter, driver);

        // checkOnlineTesting
        ManualAssessmentController.Uploads.checkOnlineTesting("upload_doc", administrationsPage, quickRosterUrl, false, waiter, driver);
        ManualAssessmentController.Uploads.checkOnlineTesting("upload_ppt", administrationsPage, quickRosterUrl, false, waiter, driver);
        ManualAssessmentController.Uploads.checkOnlineTesting("upload_pdf", administrationsPage, quickRosterUrl, true, waiter, driver);
    }
}
