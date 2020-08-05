package org.graphwalker;

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
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.FileReader;
import java.text.SimpleDateFormat;


@GraphWalker(value = "quick_random(edge_coverage(100))", start = "e_StartBrowser")
/*********Test Class for CreateManualAssessmentTest************/
public class CreateManualAssessmentTest extends ExecutionContext implements CreateManualAssessment {

    // Config Declarations
    Config config = new Config();
    String browser, url, username, password, closeBrowser, multiSite, ticket, studentQrId, studentPortalUn, studentPortalPw, environment, chrome;
    Boolean headless;
    String title;
    String studentName;

    // Site Variables
    String domain;
    String homeConnectionUrl = "http://demo.illuminatehc.com";
    String administrationsPage;
    String quickRoster;
    String quickRosterUrl;
    String timeStamp = new SimpleDateFormat("HH:mm:ss-MM/dd/yyyy").format(new java.util.Date());

    int waitTime;
    FileReader fileReader = null;
    boolean view = false;
    int numberOfQuestions = 3;

    private static final Logger logger = LoggerFactory.getLogger(CreateManualAssessmentTest.class);
    WebDriver driver = null;
    WebDriverWait waiter = null;

    // POMs
    Dashboard dashboard = new Dashboard();
    FlexAnswerKeyPage flexAnswerKeyPage = new FlexAnswerKeyPage();
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
            if (!chrome.equals("")) {
                System.setProperty("webdriver.chrome.driver", chrome);
            } else {
                ChromeDriverManager.getInstance(DriverManagerType.CHROME).setup();
            }
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
        System.out.println("chrome ==>" + chrome);
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


    public void v_BrowserStarted() {
        Assert.assertNotNull(driver);
    }

    @Override
    public void e_EnterBaseURL() {
        Helper.screenshot(driver);
        driver.get(url);
    }

    public void v_BaseURL() {
        Helper.screenshot(driver);
        waiter.until(ExpectedConditions.titleContains("Illuminate Education"));
    }

    public void e_DirectLogin() {
        if (config.getAuthX().equalsIgnoreCase("true")) {
            Helper.loginAuthX(username, password, waiter, driver);
        } else {
            Helper.login(username, password, waiter, driver);
        }
    }

    public void v_Dashboard() {
        view = false;
    }

    public void e_ClickNavbar() {
        title = "manual_qr_" + timeStamp;
        Helper.clickXpath(dashboard.getAssessmentsNav(), waiter, driver);
    }

    public void v_Navbar() {
    }

    public void e_CreateNewAssessmentClick() {
        Helper.clickXpath(flexAnswerKeyPage.getFlexAnswerKeyCreateAssessment(), waiter, driver);
        Helper.clickXpath(createAssessmentModal.getClickLegayTab(), waiter, driver);
    }

    public void v_CreateNewAssessment() {
        Helper.clickXpath(createAssessmentModal.getCreateAssessmentModalManual(), waiter, driver);
        Helper.sendKeysXpath(createAssessmentModal.getCreateAssessmentModalNumberOfQuestions(), Integer.toString(numberOfQuestions), waiter, driver);
    }

    public void e_OkayClick() {
        Helper.clickXpath(createAssessmentModal.getCreateAssessmentModalCreateButton(), waiter, driver);
    }

    public void v_StepOne() {
        Helper.sendKeysXpath(manualAssessmentPage.getStepOneTitle(), title, waiter, driver);
    }

    public void e_NextClick() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        WebElement element = driver.findElement(By.xpath(manualAssessmentPage.getNextButton()));
        js.executeScript("arguments[0].scrollIntoView(true);", element);
        Helper.wait(4.0);
        Helper.clickXpath(manualAssessmentPage.getNextButton(), waiter, driver);
    }

    public void v_StepTwo() {
        Helper.clickXpath(manualAssessmentPage.getStepTwoSubjectArea(), waiter, driver);
        Helper.clickXpath(manualAssessmentPage.getStepTwoSubjectAreaDropdownOptionChosen(), waiter, driver);
        Helper.clickXpath(manualAssessmentPage.getStepTwoSearch(), waiter, driver);
        Helper.clickXpath(manualAssessmentPage.getStepTwoSearchResultFirstOptionChosen(), waiter, driver);
        Helper.clickXpath(manualAssessmentPage.getStepTwoLinkSelectedStandardsButton(), waiter, driver);
    }

    public void v_StepThree() {
        // MC
        Actions actions = new Actions(driver);
        WebElement element = waiter.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(manualAssessmentPage.getStepThreeMultipleChoice())));
        actions.moveToElement(element);
        actions.click();
        actions.click();
        actions.sendKeys("A");
        actions.build().perform();

        // CR
        element = waiter.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(manualAssessmentPage.getStepThreeConstructedResponse())));
        actions.moveToElement(element);
        actions.click();
        actions.click();
        actions.build().perform();

        element = waiter.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(manualAssessmentPage.getStepThreeConstructedResponseNextOne())));
        actions.moveToElement(element);
        actions.click();
        actions.click();
        actions.sendKeys("1");
        actions.build().perform();

        // MC Adv
        element = waiter.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(manualAssessmentPage.getStepThreeMultipleChoiceAdvanced())));
        actions.moveToElement(element);
        actions.click();
        actions.click();
        actions.build().perform();

        element = waiter.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(manualAssessmentPage.getStepNext())));
        actions.moveToElement(element);
        actions.click();
        actions.click();
        actions.sendKeys("A:1,AB:2,ABC:3");
        actions.build().perform();

    }

    public void v_StepSeven() {
        Helper.clickXpath(manualAssessmentPage.getStepSevenTabButton(), waiter, driver);
    }

    public void e_ExitCreationMode() {
        Helper.clickXpath(manualAssessmentPage.getStepSevenExitCreationModeButton(), waiter, driver);
    }

    public void v_AdministerOnline() {
        Assert.assertEquals(title, waiter.until(ExpectedConditions.elementToBeClickable(By.xpath(manualAssessmentPage.getManualAssessmentInfo()))).getText());
        Helper.clickXpath(manualAssessmentOverviewPage.getAdministrationTabButton(), waiter, driver);
        Helper.clickXpath(manualAssessmentOverviewPage.getAdministrationTabDropdownOnlineTestingOption(), waiter, driver);
        // Quickroster
        Helper.clickXpath(onlineTestingAdministrationPage.getQuickRosterButton(), waiter, driver);
        Helper.clickXpath(onlineTestingAdministrationPage.getTestWithQuickCodeCreationModalExitButton(), waiter, driver);

        while (driver.findElements(By.xpath(onlineTestingAdministrationPage.getAccessCode())).size() == 0) {
            // loop
            try {
                Helper.wait(1.0);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        administrationsPage = driver.getCurrentUrl();
        System.out.println("<mbt-output-url> " + administrationsPage);
        quickRoster = Helper.getText(onlineTestingAdministrationPage.getAccessCode(), waiter, driver);
    }

    public void e_ClickQuickRoster() {
        // 1- e_ClickQuickRoster
        driver.get(quickRosterUrl + quickRoster);
    }

    public void v_StudentTakeQuickRosterAssessment() {
        // 2- v_StudentTakeQuickRosterAssessment
        Helper.sendKeysXpath(onlineTestingAdministrationPage.getOnlineAdministrationStudentLogin(), studentQrId, waiter, driver);
        Helper.clickXpath(onlineTestingAdministrationPage.getOlineTestingAdministrationNextButton(), waiter, driver);
        Helper.clickXpath(onlineTestingAdministrationPage.getOnlineTestingAdministrationConfirmButton(), waiter, driver);
        Helper.clickXpath(onlineTestingAdministrationPage.getOnlineTestingAdministrationSuccess(), waiter, driver);

        // 2- Question 1 - Multiple Choice
        Helper.clickXpath(onlineTestingAdministrationPage.getOnlineTestingAdministrationFirstChoice(), waiter, driver);
        Helper.waitUntil(onlineTestingAdministrationPage.getOnlineTestingAdministrationStatusBox(), waiter, driver);
        Helper.waitUntilNotVisible(onlineTestingAdministrationPage.getOnlineTestingAdministrationStatusBox(), waiter, driver);
        Helper.clickXpath(onlineTestingAdministrationPage.getOnlineTestingAdministrationNextQuestion(), waiter, driver);

        // 2- Question 2 - Constructed Response
        Helper.waitUntil(onlineTestingAdministrationPage.getOnlineTestingAdministrationConstructedResponseChangeFrame(), waiter, driver);
        driver.switchTo().frame(driver.findElement(By.xpath(onlineTestingAdministrationPage.getOnlineTestingAdministrationConstructedResponseChangeFrame())));
        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(By.xpath(onlineTestingAdministrationPage.getOnlineTestingAdministrationConstructedResponseAnswerFrame())));
        actions.click();
        actions.sendKeys("F");
        actions.build().perform();
        driver.switchTo().defaultContent();
        Helper.waitUntil(onlineTestingAdministrationPage.getOnlineTestingAdministrationStatusBox(), waiter, driver);
        Helper.waitUntilNotVisible(onlineTestingAdministrationPage.getOnlineTestingAdministrationStatusBox(), waiter, driver);
        Helper.clickXpath(onlineTestingAdministrationPage.getOnlineTestingAdministrationNextQuestion(), waiter, driver);

        // 2- Question 3 - Multiple Choice Advanced
        Helper.clickXpath(onlineTestingAdministrationPage.getOnlineTestingAdministrationMultipleChoiceAdvancedQuestion(), waiter, driver);
        Helper.waitUntil(onlineTestingAdministrationPage.getOnlineTestingAdministrationStatusBox(), waiter, driver);
        Helper.waitUntilNotVisible(onlineTestingAdministrationPage.getOnlineTestingAdministrationStatusBox(), waiter, driver);
        Helper.clickXpath(onlineTestingAdministrationPage.getOnlineTestingAdministrationNextQuestion(), waiter, driver);

        // 2- Review - Assertions
        try {
            Helper.wait(3.0);
            Helper.waitUntil(onlineTestingAdministrationPage.getOnlineTestingAdministrationFirstAnswer(), waiter, driver);
            String value = driver.findElement(By.xpath(onlineTestingAdministrationPage.getOnlineTestingAdministrationFirstAnswer())).getText().trim();
            if (value.equalsIgnoreCase("A")) {
                Helper.assertionText(onlineTestingAdministrationPage.getOnlineTestingAdministrationFirstAnswer(), "A", waiter, driver);
                Helper.assertionText(onlineTestingAdministrationPage.getOnlineTestingAdministrationSecondAnswer(), "F", waiter, driver);
                Helper.assertionText(onlineTestingAdministrationPage.getOnlineTestingAdministrationThirdAnswer(), "A", waiter, driver);
            } else if (value.equalsIgnoreCase("Answered")) {
                Helper.assertionText(onlineTestingAdministrationPage.getOnlineTestingAdministrationFirstAnswer(), "Answered", waiter, driver);
                Helper.assertionText(onlineTestingAdministrationPage.getOnlineTestingAdministrationSecondAnswer(), "Answered", waiter, driver);
                Helper.assertionText(onlineTestingAdministrationPage.getOnlineTestingAdministrationThirdAnswer(), "Answered", waiter, driver);
            }
        } catch (Exception e) {
            System.out.println("Exception handled for assertion...." + e);
        }
    }

    public void e_ClickFinish() {
        // 3- e_ClickFinish
        Helper.clickXpath(onlineTestingAdministrationPage.getOnlineTestingAdministrationFinishButton(), waiter, driver);
        driver.get(administrationsPage);
    }

    public void v_AdministrationPage() {
        // 4- v_AdministrationPage
        Helper.clickXpath(onlineTestingAdministrationPage.getTestWithQuickCodeCreationModalExitButton(), waiter, driver);
    }

    public void e_ClickAssessmentPanel() {
        if (Boolean.parseBoolean(Config.getProperties().getProperty("ASSESSMENT_PANEL_CHECK"))) {
            // 5- e_ClickAssessmentPanel
            studentName = Config.getProperties().getProperty("STUDENT_LAST_FIRST");
            try {
                Helper.clickXpath(onlineTestingAdministrationPage.getOnlineTestingAdministrationLiveProctoring(), waiter, driver);
            } catch (Exception e) {
                Helper.clickXpath(onlineTestingAdministrationPage.getOnlineTestingAdministrationassessmentPanel(), waiter, driver);
            }
            Helper.wait(3.0);
            Helper.refreshUntilElementAppears("//table[@id='student-list']//a[@class='black-text list-item']//div[.='" + studentName + "']", waiter, driver);
        }
    }

    public void v_AssessmnentPanel() {
        if (Boolean.parseBoolean(Config.getProperties().getProperty("ASSESSMENT_PANEL_CHECK"))) {
            // 6- v_AssessmnentPanel
            Helper.clickXpath("//a/div[contains(text(),'" + studentName + "')]", waiter, driver);
            Helper.wait(3.0);
            Helper.refreshUntilElementAppears(onlineTestingAdministrationPage.getOnlineTestingAdministrationAnswer(), waiter, driver);
            try {
                Helper.wait(3.0);
                Helper.waitUntil(onlineTestingAdministrationPage.getOnlineTestingAdministrationFirstAnswerBox(), waiter, driver);
                String value = driver.findElement(By.xpath(onlineTestingAdministrationPage.getOnlineTestingAdministrationFirstAnswerBox())).getText().trim();
                if (value.equalsIgnoreCase("A")) {
                    Helper.assertionText(onlineTestingAdministrationPage.getOnlineTestingAdministrationFirstAnswerBox(), "A", waiter, driver);
                    Helper.assertionText(onlineTestingAdministrationPage.getOnlineTestingAdministrationSecondAnswerBox(), "F", waiter, driver);
                    Helper.assertionText(onlineTestingAdministrationPage.getOnlineTestingAdministrationThirdAnswerBox(), "A", waiter, driver);
                } else if (value.equalsIgnoreCase("Answered")) {
                    Helper.assertionText(onlineTestingAdministrationPage.getOnlineTestingAdministrationFirstAnswerBox(), "Answered", waiter, driver);
                    Helper.assertionText(onlineTestingAdministrationPage.getOnlineTestingAdministrationSecondAnswerBox(), "Answered", waiter, driver);
                    Helper.assertionText(onlineTestingAdministrationPage.getOnlineTestingAdministrationThirdAnswerBox(), "Answered", waiter, driver);
                }
            } catch (Exception e) {
                System.out.println("Exception handled for assertion...." + e);
            }
        }
    }

    public void e_ClickExitAssessmentPanel() {
        if (Boolean.parseBoolean(Config.getProperties().getProperty("ASSESSMENT_PANEL_CHECK"))) {
            // 7- e_ClickExitAssessmentPanel
            Helper.clickXpath("//input[@value='Exit']", waiter, driver);
        }
    }


    public void v_ReturnToAdministrationPage() {
        // 8- v_ReturnToAdministrationPage
    }


    public void e_ClickOverviewPageBeforeEnterEdit() {
        // 9- e_ClickOverviewPageBegoreEnterEdit
        Helper.clickXpath(onlineTestingAdministrationPage.getOnlineTestingAdministrationOverview(), waiter, driver);
    }

    public void v_OverviewPageBeforeEnterEdit() {
        Helper.wait(1.0);
        if (driver.findElements(By.xpath(onlineTestingAdministrationPage.getOnlineTestingAdministrationOverviewAssessmentButton())).size() != 0) {
            Helper.clickXpath(onlineTestingAdministrationPage.getOnlineTestingAdministrationOverviewAssessmentButton(), waiter, driver);
        }
    }

    public void e_ClickReports() {
        // 10- e_ClickReports
        boolean checkOverview = true;
        while (checkOverview) {
            try {
                Helper.clickXpath(onlineTestingAdministrationPage.getOnlineTestingAdministrationOverview(), waiter, driver);
                Helper.waitUntil(onlineTestingAdministrationPage.getOnlineTestingAdministrationStudentResponse(), waiter, driver);
                checkOverview = false;
            } catch (Exception e) {
                System.out.println("Exception handled for quick code access - status bar...");
                driver.navigate().refresh();
                Helper.wait(4.0);
            }
        }
        Helper.refreshUntilElementAppears(manualAssessmentOverviewPage.getManualAssessmentOverviewReports(), waiter, driver);
        Helper.clickXpath(manualAssessmentOverviewPage.getManualAssessmentOverviewReports(), waiter, driver);
        Helper.clickXpath(manualAssessmentOverviewPage.getManualAssessmentOverviewReportsMessage(), waiter, driver);
    }

    public void v_StudentSmallSlipsBeforeEnterEdit() {
        // 11- v_StudentSmallSlipsBeforeEnterEdit
        Helper.clickXpath(manualAssessmentOverviewPage.getManualAssessmentOverviewViewInBrowser(), waiter, driver);
        Helper.assertionText(manualAssessmentOverviewPage.getManualAssessmentOverviewCorrectAnswer(), "2 / 5", waiter, driver);
    }

    public void e_ClickEnterEdit() {
        // 12- e_ClickEnterEdit
        Helper.clickXpath(manualAssessmentOverviewPage.getManualAssessmentOverviewAdministrationbutton(), waiter, driver);
        Helper.clickXpath(manualAssessmentOverviewPage.getManualAssessmentOverviewEdit(), waiter, driver);
    }

    public void v_EnterEdit() {
        // 13- v_EnterEdit
        WebElement element = driver.findElement(By.xpath(onlineTestingAdministrationPage.getOnlineTestingAdministrationviewType()));
        Select dropdown = new Select(element);
        dropdown.selectByVisibleText("Students With Data");
        Helper.clickXpath(onlineTestingAdministrationPage.getOnlineTestingAdministrationFindStudents(), waiter, driver);

        Actions actions = new Actions(driver);
        element = waiter.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(onlineTestingAdministrationPage.getOnlineTestingAdministrationEditFirstAnswer())));
        actions.moveToElement(element);
        actions.click();
        actions.click();
        actions.build().perform();

        element = waiter.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(onlineTestingAdministrationPage.getOnlineTestingAdministrationEditSecondAnswer())));
        actions.moveToElement(element);
        actions.click();
        actions.build().perform();

        Helper.wait(0.25);
        element = waiter.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(onlineTestingAdministrationPage.getOnlineTestingAdministrationEditThirdAnswer())));
        actions.moveToElement(element);
        actions.click();
        actions.click();
        actions.sendKeys("BC");
        actions.build().perform();
        Helper.clickXpath(onlineTestingAdministrationPage.getOnlineTestingAdministrationSaveEdited(), waiter, driver);
    }

    public void e_EnterEditReturnToOverviewPage() {
        // 14- e_EnterEditReturnToOverviewPage
        Helper.clickXpath(onlineTestingAdministrationPage.getOnlineTestingAdministrationOverview(), waiter, driver);
    }

    public void v_OverviewPageAfterEnterEdit() {
    }

    public void e_ClickReportsAfterEnterEdit() {
        Helper.refreshUntilElementAppears(manualAssessmentOverviewPage.getManualAssessmentOverviewReports(), waiter, driver);
        Helper.clickXpath(manualAssessmentOverviewPage.getManualAssessmentOverviewReports(), waiter, driver);
    }

    public void v_StudentSmallSlipsAfterEnterEdit() {
        // 16- v_StudentSmallSlipsAfterEnterEdit
        Helper.clickXpath(manualAssessmentOverviewPage.getManualAssessmentOverviewReportsMessage(), waiter, driver);
        Helper.clickXpath(manualAssessmentOverviewPage.getManualAssessmentOverviewViewInBrowser(), waiter, driver);
        Helper.assertionText(manualAssessmentOverviewPage.getManualAssessmentOverviewCorrectAnswer(), "5 / 5", waiter, driver);

        // Delete Assessment
        Helper.clickXpath(onlineTestingAdministrationPage.getOnlineTestingAdministrationAdvancedDropdown(), waiter, driver);
        Helper.clickXpath(onlineTestingAdministrationPage.getOnlineTestingAdministrationDeleteAssessment(), waiter, driver);
        Helper.clickXpath(onlineTestingAdministrationPage.getOnlineTestingAdministrationDeleteAlertPopup(), waiter, driver);
        Helper.clickXpath(onlineTestingAdministrationPage.onlineTestingAdministrationDeleteAgree(), waiter, driver);
        Helper.clickXpath(onlineTestingAdministrationPage.getOnlineTestingAdministrationDeleteSubmit(), waiter, driver);
    }
}
