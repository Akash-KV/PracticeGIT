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
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

//import org.testng.annotations.DataProvider;
//import org.testng.annotations.Test;

@GraphWalker(value = "quick_random(edge_coverage(100))", start = "e_StartBrowser")
/*****Test Class for CreateNewItembankAssessmentTest*****/
public class CreateNewItembankAssessmentTest extends ExecutionContext implements CreateNewItembankAssessment {

    // Config Declarations
    Config config = new Config();
    String browser, url, username, password, closeBrowser, multiSite, ticket, studentQrId, studentPortalUn, studentPortalPw, environment, chrome;
    Boolean headless;
    String title;
    int waitTime;
    FileReader fileReader = null;
    boolean view = false;
    String numberOfStandards;
    String timeStamp = new SimpleDateFormat("HH:mm:ss-MM/dd/yyyy").format(new java.util.Date());

    // Site Variables
    String domain;
    String homeConnectionUrl;
    String administrationsPage;
    String quickRosterUrl;
    String studentName;

    ItembankAssessment itembankAssessment = new ItembankAssessment();
    Dashboard dashboard = new Dashboard();
    FlexAnswerKeyPage flexAnswerKeyPage = new FlexAnswerKeyPage();
    LoginPage loginPage = new LoginPage();
    OnlineTestingAdministrationPage onlineTestingAdministrationPage = new OnlineTestingAdministrationPage();

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
            homeConnectionUrl = "https://" + domain + ".illuminatehc.com";
        } else {
            quickRosterUrl = "https://onlinetesting" + domain + ".illuminateed.io/auth/quick?access_code=";
            homeConnectionUrl = "https://" + domain + ".illuminatehc.io";
        }
        title = "ib_" + timeStamp;
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


    public void v_BrowserStarted() {
        Assert.assertNotNull(driver);
    }

    public void e_EnterBaseURL() {
        driver.get(url);
    }

    public void v_BaseURL() {
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
        Helper.clickXpath(dashboard.getAssessmentsNav(), waiter, driver);
    }

    public void e_CreateNewItembankAssessmentClick() {
        Helper.clickXpath(flexAnswerKeyPage.getFlexAnswerKeyCreateAssessment(), waiter, driver);
        Helper.clickXpath(itembankAssessment.getItemBankCreateAssessmentTab(), waiter, driver);

        while (true) {
            if (driver.findElements(By.xpath(loginPage.getLoginButton())).size() != 0) {
                Helper.clickXpath(loginPage.getLoginButton(), waiter, driver);
                Helper.sendKeysXpath(LoginPage.getLoginEmail(), Config.getEmailID(), waiter, driver);
                Helper.sendKeysXpath(LoginPage.getLoginPassword(), Config.getEmailPassword(), waiter, driver);
                Helper.clickXpath(LoginPage.getSignInButton(), waiter, driver);
                break;
            }
            if (driver.findElements(By.xpath(itembankAssessment.getItemBankStandardAssessmentCheckbox())).size() != 0) {
                break;
            }
        }
    }

    public void v_CreateNewItembankAssessment() {
        Helper.clickXpath(itembankAssessment.getItemBankStandardAssessmentCheckbox(), waiter, driver);
    }

    public void e_NextClick() {
        Helper.clickXpath(itembankAssessment.getNextButton(), waiter, driver);
    }

    public void v_StepOne() {
        Helper.sendKeysId(itembankAssessment.getTitleInput(), title, waiter, driver);
    }

    public void e_CreateClick() {
        Helper.clickXpath(itembankAssessment.getStepOnecreateAssessmentButton(), waiter, driver);
    }

    public void v_StepTwo() {
        Helper.clickXpath(itembankAssessment.getStandardDocument(), waiter, driver);
//        Select select = new Select(driver.findElement(By.xpath("//select[@id='standard_document']")));
//        select.selectByVisibleText("Content Standards");
        Helper.clickXpath(itembankAssessment.getItemBankStandardDocumentOption(), waiter, driver);

        Helper.clickXpath(itembankAssessment.getStandardSubject(), waiter, driver);
        Helper.clickXpath(itembankAssessment.getItemBankAssessmentStandardSubjectOption(), waiter, driver);

        Helper.clickXpath(itembankAssessment.getStandardCategory(), waiter, driver);
        Helper.clickXpath(itembankAssessment.getItemBankAssessmentStandardCategoryOption(), waiter, driver);

        Helper.clickXpath(itembankAssessment.getStandardItems(), waiter, driver);

        numberOfStandards = driver.findElement(By.xpath(itembankAssessment.getItemBankAssessmentNumberOfStandards())).getText();
        while (!numberOfStandards.equals("1")) {
            numberOfStandards = driver.findElement(By.xpath(itembankAssessment.getItemBankAssessmentNumberOfStandards())).getText();
        }
    }

    public void e_ContinueButton() {
        // e_ContinueButton
        Helper.clickXpath(itembankAssessment.getItemBankAssessmentStepTwoContinueButton(), waiter, driver);
    }


    public void v_StepThree() {
        // v_StepThree
        Helper.clickXpath(itembankAssessment.getItemBankAssessmentItemBanks(), waiter, driver);
        if (!waiter.until(ExpectedConditions.presenceOfElementLocated(By.xpath(itembankAssessment.getItemBankAssessmentItemBankMyItemFilter()))).isSelected()) {
            Helper.clickXpath(itembankAssessment.getItemBankAssessmentItemBankMyItemFilter(), waiter, driver);
        }
        Helper.clickXpath(itembankAssessment.getItemBankAssessmentUpdatefilterButton(), waiter, driver);

        int i = 1;
        String numberOfItems = driver.findElement(By.xpath(itembankAssessment.getItemBankAssessmentNumberOfItems())).getText();

        Helper.wait(20.0);
        Helper.waitUntil(itembankAssessment.getItemBankAssessmentPassage(), waiter, driver);
        ((JavascriptExecutor) driver).executeScript(itembankAssessment.getItemBankAssessmentReturnPassage());

        Helper.wait(15.0);
        Helper.waitUntil(itembankAssessment.getItemBankAssessmentPassageSearchModal(), waiter, driver);
        Helper.clickXpath(itembankAssessment.getItemBankAssessmentWithoutPassageLabel(), waiter, driver);
        Helper.clickXpath(itembankAssessment.getItemBankAssessmentPassageUpdateFilter(), waiter, driver);
        Helper.wait(5.0);
        Helper.waitUntil(itembankAssessment.getItemBankAssessmentItemSearchResult(), waiter, driver);

        Helper.waitUntil(itembankAssessment.getItemBankAssessmentItemTypes(), waiter, driver);
        Helper.clickXpath(itembankAssessment.getItemBankAssessmentItemTypes(), waiter, driver);

        //Wait till modal popup
        Helper.wait(5.0);
        Helper.waitUntil(itembankAssessment.getItemBankAssessmentItemTypesModal(), waiter, driver);
        Helper.waitUntil(itembankAssessment.getItemBankAssessmentItemTypesMultipleChoice(), waiter, driver);

        //Select MC item type
        Helper.clickXpath(itembankAssessment.getItemBankAssessmentItemTypesMultipleChoice(), waiter, driver);
        Helper.clickXpath(itembankAssessment.getItemBankAssessmentPassageUpdateFilter(), waiter, driver);
        Helper.wait(5.0);

        //Items Load
        Helper.waitUntil(itembankAssessment.getItemBankAssessmentItemSearchResult(), waiter, driver);

        while (!numberOfStandards.equals("3") && i != 4) {
            Helper.clickXpath("//div[" + Integer.toString(i) + "]/div[2]/button[1]", waiter, driver);
            try {
                Helper.wait(4.0);
                Helper.clickXpath(itembankAssessment.getItemBankAssessmentItemAndStandards(), waiter, driver);
                Helper.wait(2.0);
            } catch (Exception e) {
                System.out.println("Exception handled....");
            }
            numberOfStandards = driver.findElement(By.xpath(itembankAssessment.getItemBankAssessmentNumberOfItems())).getText();
            i++;
        }
    }

    public void e_NextButton() {
        // e_NextButton
        Helper.clickXpath(itembankAssessment.getContinueButton(), waiter, driver);
    }

    public void v_StepFour() {
        // v_StepFour
        Helper.clickXpath(itembankAssessment.getItemBankAssessmentShuffleAnswerButton(), waiter, driver);
    }

    public void v_StepFive() {
        // v_StepFive
        waiter.until(ExpectedConditions.presenceOfElementLocated(By.xpath(itembankAssessment.getItemBankAssessmentPrintOptionHeader())));
    }


    public void v_StepSix() {
        // v_StepSix
    }

    public void e_PublishAndAdminister() {
        // e_PublishAndAdminister
        Helper.clickXpath(itembankAssessment.getItemBankAssessmentPublishAndAdministerButton(), waiter, driver);
    }

    public void v_AdministrationPagePortal() {
        // Portal
        Helper.clickXpath(onlineTestingAdministrationPage.getOnlineTestingAdministrationportalButton(), waiter, driver);
        //String rosterDate = new SimpleDateFormat("MM/dd/yyyy").format(new java.util.Date());
        DateFormat dateFormatYesterday = new SimpleDateFormat("MM/dd/yyyy");
        Date current_Date = new Date();
        Calendar c_Old = Calendar.getInstance();
        c_Old.setTime(current_Date);
        c_Old.add(Calendar.DATE, -1);
        Date currentDateMinusOne = c_Old.getTime();
        System.out.println(dateFormatYesterday.format(currentDateMinusOne));

        Helper.clickXpath(onlineTestingAdministrationPage.getOnlineTestingAdministrationSecondStudentOption(), waiter, driver);
        WebElement element = driver.findElement(By.xpath(onlineTestingAdministrationPage.getOnlineTestingAdministrationWindowStart()));
        Actions actions = new Actions(driver);
        actions.moveToElement(element);
        actions.click();
        actions.sendKeys(dateFormatYesterday.format(currentDateMinusOne));
        actions.build().perform();
        System.out.println(dateFormatYesterday.format(currentDateMinusOne));

        DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
        Date currentDate = new Date();
        Calendar c = Calendar.getInstance();
        c.setTime(currentDate);
        c.add(Calendar.DATE, 3);
        Date currentDatePlusOne = c.getTime();
        System.out.println(dateFormat.format(currentDatePlusOne));

        element = driver.findElement(By.xpath(onlineTestingAdministrationPage.getOnlineTestingAdministrationWindowEnd()));
        actions = new Actions(driver);
        actions.moveToElement(element);
        actions.click();
        actions.sendKeys(dateFormat.format(currentDatePlusOne));
        actions.build().perform();

        //Change date and time
        Helper.sendKeysXpath(onlineTestingAdministrationPage.getOnlineTestingAdministrationStartDateHour(), "12", waiter, driver);
        Helper.sendKeysXpath(onlineTestingAdministrationPage.getOnlineTestingAdministrationStartDateHourMin(), "00", waiter, driver);
        Select startTime = new Select(driver.findElement(By.id(onlineTestingAdministrationPage.getOnlineTestingAdministrationStartDateHourTime())));
        startTime.selectByVisibleText("AM");

        element = driver.findElement(By.xpath(onlineTestingAdministrationPage.getWindowEnd()));
        actions = new Actions(driver);
        actions.moveToElement(element);
        actions.click();
        actions.sendKeys(dateFormat.format(currentDatePlusOne));
        actions.build().perform();

        Helper.sendKeysXpath(onlineTestingAdministrationPage.getOnlineTestingAdministrationEndDateHour(), "12", waiter, driver);
        Helper.sendKeysXpath(onlineTestingAdministrationPage.getOnlineTestingAdministrationEndDateHourMin(), "00", waiter, driver);
        Select endTime = new Select(driver.findElement(By.id(onlineTestingAdministrationPage.getOnlineTestingAdministrationEndDateHourTime())));
        endTime.selectByVisibleText("PM");

        WebElement studentList = driver.findElement(By.id(onlineTestingAdministrationPage.getOnlineTestingAdministrationStudentId()));
        JavascriptExecutor je = (JavascriptExecutor) driver;
        je.executeScript("arguments[0].scrollIntoView(true);", studentList);
        Helper.wait(2.0);

        Select studentNameInList = new Select(driver.findElement(By.id(onlineTestingAdministrationPage.getOnlineTestingAdministrationStudentId())));
        String studentName = Config.getStudentLastFirstWithInitial();
        studentNameInList.selectByVisibleText(studentName);
        Helper.wait(2.0);

        Helper.clickXpath(onlineTestingAdministrationPage.getOnlineTestingAdministrationSave(), waiter, driver);
        String completeBar = Helper.getText(onlineTestingAdministrationPage.getOnlineTestingAdministrationcompleteBar(), waiter, driver);
        while (!completeBar.equals("Complete")) {
            // loop
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            completeBar = Helper.getText(onlineTestingAdministrationPage.getOnlineTestingAdministrationcompleteBar(), waiter, driver);
        }
        administrationsPage = driver.getCurrentUrl();
        System.out.println("<mbt-output-url> " + administrationsPage);
    }

    public void e_ClickPortal() {
        driver.get(homeConnectionUrl);
        Helper.sendKeysXpath(onlineTestingAdministrationPage.getOnlineTestingAdministrationUsername(), studentPortalUn, waiter, driver);
        Helper.sendKeysXpath(onlineTestingAdministrationPage.getOnlineTestingAdministrationPassword(), studentPortalPw, waiter, driver);
        Helper.clickXpath(onlineTestingAdministrationPage.getOnlineTestingAdministrationLogin(), waiter, driver);
        if (driver.findElements(By.xpath(onlineTestingAdministrationPage.getOnlineTestingAdministrationFillingFormMessage())).size() != 0) {
            Helper.sendKeysXpath(onlineTestingAdministrationPage.getOnlineTestingAdministrationResetPasswordFirst(), studentPortalPw, waiter, driver);
            Helper.sendKeysXpath(onlineTestingAdministrationPage.getOnlineTestingAdministrationResetPasswordSecond(), studentPortalPw, waiter, driver);
            Helper.clickXpath(onlineTestingAdministrationPage.getOnlineTestingAdministrationResetPasswordSubmit(), waiter, driver);
        }
        try {
            Helper.wait(4.0);
            Helper.clickXpath(onlineTestingAdministrationPage.getOnlineTestingAdministrationResetPasswordTakeAssessment(), waiter, driver);
            Helper.wait(3.0);
        } catch (Exception e) {
            System.out.println("Exception handled.....");
        }
        WebElement element = driver.findElement(By.xpath("//a[contains(text(),'" + title + "')]"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
        Helper.wait(2.0);
        Helper.clickXpath("//a[contains(text(),'" + title + "')]", waiter, driver);
    }

    public void v_StudentTakeQuickrosterAssessment() {
        Helper.clickXpath(onlineTestingAdministrationPage.getOnlineTestingAdministrationSuccess(), waiter, driver);

        // Question 1 - Multiple Choice
        Helper.clickXpath(onlineTestingAdministrationPage.getOnlineTestingAdministrationFirstChoice(), waiter, driver);
        Helper.waitUntil(onlineTestingAdministrationPage.getOnlineTestingAdministrationStatusBox(), waiter, driver);
        Helper.clickXpath(onlineTestingAdministrationPage.getOnlineTestingAdministrationNextQuestion(), waiter, driver);

        // Question 2 - Multiple Choice
        Helper.clickXpath(onlineTestingAdministrationPage.getOnlineTestingAdministrationFirstChoice(), waiter, driver);
        Helper.waitUntil(onlineTestingAdministrationPage.getOnlineTestingAdministrationStatusBox(), waiter, driver);
        Helper.clickXpath(onlineTestingAdministrationPage.getOnlineTestingAdministrationNextQuestion(), waiter, driver);

        // Question 3 - Multiple Choice
        Helper.clickXpath(onlineTestingAdministrationPage.getOnlineTestingAdministrationFirstChoice(), waiter, driver);
        Helper.waitUntil(onlineTestingAdministrationPage.getOnlineTestingAdministrationStatusBox(), waiter, driver);
        Helper.clickXpath(onlineTestingAdministrationPage.getOnlineTestingAdministrationNextQuestion(), waiter, driver);

        // Review - Assertions
        try {
            Helper.wait(3.0);
            Helper.waitUntil(onlineTestingAdministrationPage.getOnlineTestingAdministrationFirstAnswer(), waiter, driver);
            String value = driver.findElement(By.xpath(onlineTestingAdministrationPage.getOnlineTestingAdministrationFirstAnswer())).getText().trim();
            if (value.equalsIgnoreCase("A")) {
                Helper.assertionText(onlineTestingAdministrationPage.getOnlineTestingAdministrationFirstAnswer(), "A", waiter, driver);
                Helper.assertionText(onlineTestingAdministrationPage.getOnlineTestingAdministrationSecondAnswer(), "A", waiter, driver);
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
        //---e_ClickFinish---
        Helper.clickXpath(onlineTestingAdministrationPage.getOnlineTestingAdministrationFinishButton(), waiter, driver);
        driver.get(administrationsPage);
    }

    public void v_AdministrationPage() {
        driver.get(administrationsPage);
    }

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

    public void v_AssessmentPanel() {
        if (Boolean.parseBoolean(Config.getProperties().getProperty("ASSESSMENT_PANEL_CHECK"))) {
            Helper.clickXpath("//a/div[contains(text(),'" + studentName + "')]", waiter, driver);
            Helper.wait(4.0);

            //---v_AssessmentPanel---
            Helper.clickXpath(onlineTestingAdministrationPage.getOnlineTestingAdministrationlistItem(), waiter, driver);
            try {
                Helper.wait(3.0);
                Helper.waitUntil(onlineTestingAdministrationPage.getOnlineTestingAdministrationFirstAnswerBox(), waiter, driver);
                String value = driver.findElement(By.xpath(onlineTestingAdministrationPage.getOnlineTestingAdministrationFirstAnswerBox())).getText().trim();
                if (value.equalsIgnoreCase("A")) {
                    Helper.assertionText(onlineTestingAdministrationPage.getOnlineTestingAdministrationFirstAnswerBox(), "A", waiter, driver);
                    Helper.assertionText(onlineTestingAdministrationPage.getOnlineTestingAdministrationSecondAnswerBox(), "A", waiter, driver);
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
            //---e_ClickExitAssessmentPanel---
            Helper.clickXpath(onlineTestingAdministrationPage.getOnlineTestingAdministrationExit(), waiter, driver);
        }
    }

    public void v_ReturnToAdministrationPage() {
        //---v_ReturnToAdminstrationPage---
    }
}
