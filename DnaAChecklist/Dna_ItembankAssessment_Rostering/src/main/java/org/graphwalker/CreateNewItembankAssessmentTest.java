package org.graphwalker;

import io.github.bonigarcia.wdm.ChromeDriverManager;
import io.github.bonigarcia.wdm.DriverManagerType;
import io.github.bonigarcia.wdm.EdgeDriverManager;
import io.github.bonigarcia.wdm.FirefoxDriverManager;
import org.graphwalker.PageObjectModels.AssessmentsNavbar;
import org.graphwalker.PageObjectModels.Dashboard;
import org.graphwalker.PageObjectModels.ItembankAssessment;
import org.graphwalker.PageObjectModels.OnlineTestingAdministrationPage;
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
import java.util.concurrent.ExecutionException;

@GraphWalker(value = "quick_random(edge_coverage(100))", start = "e_StartBrowser")
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
    String quickRoster;
    String quickRosterUrl;
    String studentName;

    ItembankAssessment ItembankAssessment = new ItembankAssessment();
    Dashboard Dashboard = new Dashboard();
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

    // Validate v_BrowserStarted
    public void v_BrowserStarted() {
        Assert.assertNotNull(driver);
    }

    //Clicking on e_EnterBaseURL
    public void e_EnterBaseURL() {
        driver.get(url);
    }

    // Validate v_BaseURL
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

    // Validate v_StepOne
    public void v_Dashboard() {
        Helper.clickXpath(Dashboard.getAssessmentsNav(), waiter, driver);
    }

    //Clicking on e_CreateNewItembankAssessmentClick
    public void e_CreateNewItembankAssessmentClick() {
        Helper.clickXpath(ItembankAssessment.getCreateAssessmentRostering(), waiter, driver);
        Helper.clickXpath(ItembankAssessment.getItemBank(), waiter, driver);
        Helper.screenshot(driver);
    }

    // Validate v_StepOne
    public void v_CreateNewItembankAssessment() {
        Helper.clickXpath(ItembankAssessment.getNewItemBankAssessment(), waiter, driver);
    }

    //Clicking on e_NextClick
    public void e_NextClick() {
        WebElement element = driver.findElement(By.xpath(ItembankAssessment.getNextButton()));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
        Helper.clickXpath(ItembankAssessment.getNextButton(), waiter, driver);
    }

    // Validate v_StepOne
    public void v_StepOne() {
        Helper.sendKeysId(ItembankAssessment.getTitleInput(), title, waiter, driver);
    }

    //Clicking on e_CreateClick
    public void e_CreateClick() {
        Helper.clickXpath(ItembankAssessment.getCreateClick(), waiter, driver);
    }

    // Validate v_StepTwo
    public void v_StepTwo() {
        Helper.clickXpath(ItembankAssessment.getStandardDocument(), waiter, driver);
//        Select select = new Select(driver.findElement(By.xpath("//select[@id='standard_document']")));
//        select.selectByVisibleText("Content Standards");
        Helper.clickXpath(ItembankAssessment.getOptionOne(), waiter, driver);

        Helper.clickXpath(ItembankAssessment.getStandardSubject(), waiter, driver);
        Helper.clickXpath(ItembankAssessment.getOptionTwo(), waiter, driver);

        Helper.clickXpath(ItembankAssessment.getStandardCategory(), waiter, driver);
        Helper.clickXpath(ItembankAssessment.getGradeFour(), waiter, driver);

        Helper.clickXpath(ItembankAssessment.getStandardItems(), waiter, driver);
        // Helper.clickXpath(ItembankAssessment.getStandardItems(), waiter, driver);

        numberOfStandards = driver.findElement(By.xpath(ItembankAssessment.getNumberOfStandardsRostering())).getText();
        while (!numberOfStandards.equals("1")) {
            numberOfStandards = driver.findElement(By.xpath(ItembankAssessment.getNumberOfStandardsRostering())).getText();
        }
    }

    //Clicking on e_ContinueButton
    public void e_ContinueButton() {
        // e_ContinueButton
        Helper.clickXpath(ItembankAssessment.getContinueButtonRostering(), waiter, driver);
    }

    // Validate v_StepThree
    public void v_StepThree() {
        // v_StepThree
        Helper.clickXpath(ItembankAssessment.getStepThree(), waiter, driver);
        Helper.wait(5.0);
        try {
            if (!waiter.until(ExpectedConditions.presenceOfElementLocated(By.xpath(ItembankAssessment.getItemBankMyItems()))).isSelected()) {
                Helper.clickXpath(ItembankAssessment.getItemBankMyItems(), waiter, driver);
            }
        } catch (Exception e) {
            System.out.println("Exception handled for method - v_StepThree" + e);
        }
        Helper.clickXpath(ItembankAssessment.getSuccessButton(), waiter, driver);

        int i = 1;
        String numberOfItems = driver.findElement(By.xpath(ItembankAssessment.getNumberOfItems())).getText();

        Helper.wait(30.0);
        Helper.waitUntil(ItembankAssessment.getPassage(), waiter, driver);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("return document.getElementById(\"passages\").click();");
        Helper.wait(5.0);

        Helper.waitUntil(ItembankAssessment.getPassageSearchModal(), waiter, driver);
        Helper.clickXpath(ItembankAssessment.getWithoutPassageLabel(), waiter, driver);
        Helper.clickXpath(ItembankAssessment.getUpdatePassageModalFilteringButton(), waiter, driver);
        Helper.wait(15.0);
        Helper.waitUntil(ItembankAssessment.getItemSearchResult(), waiter, driver);

        Helper.waitUntil(ItembankAssessment.getItemTypes(), waiter, driver);
        Helper.wait(5.0);
        js.executeScript("return document.getElementById(\"itemtypes\").click();");

        //Wait till modal popup
        Helper.wait(3.0);
        Helper.waitUntil(ItembankAssessment.getItemTypesModal(), waiter, driver);
        Helper.waitUntil(ItembankAssessment.getMultipleChoice(), waiter, driver);

        //Select MC item type
        Helper.clickXpath(ItembankAssessment.getMultipleChoice(), waiter, driver);
        Helper.clickXpath(ItembankAssessment.getUpdatePassageModalFilteringButton(), waiter, driver);
        Helper.wait(10.0);

        //Items Load
        Helper.waitUntil(ItembankAssessment.getItemSearchResult(), waiter, driver);

        while (!numberOfStandards.equals("3") && i != 4) {
            Helper.clickXpath("//div[" + Integer.toString(i) + "]/div[2]/button[1]", waiter, driver);
            try {
                Helper.wait(4.0);
                Helper.clickXpath(ItembankAssessment.getAddItemsAndStandards(), waiter, driver);
                Helper.wait(2.0);
            } catch (Exception e) {
                System.out.println("Exception handled....");
            }
            numberOfStandards = driver.findElement(By.xpath(ItembankAssessment.getNumberOfItems())).getText();
            i++;
        }
    }

    //Clicking on e_NextButton
    public void e_NextButton() {
        // e_NextButton
        Helper.clickXpath(ItembankAssessment.getContinueButton(), waiter, driver);
    }

    // Validate v_StepFour
    public void v_StepFour() {
        // v_StepFour
        Helper.clickXpath(ItembankAssessment.getShuffleAnswerButton(), waiter, driver);
    }

    // Validate v_StepFive
    public void v_StepFive() {
        // v_StepFive
        waiter.until(ExpectedConditions.presenceOfElementLocated(By.xpath(ItembankAssessment.getPrintOptionHeader())));
    }

    // Validate v_StepSix
    public void v_StepSix() {
        // v_StepSix
    }

    //Clicking on e_PublishAndAdminister
    public void e_PublishAndAdminister() {
        // e_PublishAndAdminister
        Helper.clickXpath(ItembankAssessment.getPublishAdminister(), waiter, driver);
    }

    // Validate v_AdministrationPagePortal
    public void v_AdministrationPagePortal() {
        // Portal
        Helper.clickXpath(onlineTestingAdministrationPage.getPortalButton(), waiter, driver);
        //String rosterDate = new SimpleDateFormat("MM/dd/yyyy").format(new java.util.Date());
        DateFormat dateFormatYesterday = new SimpleDateFormat("MM/dd/yyyy");
        Date currentDate = new Date();
        Calendar c_old = Calendar.getInstance();
        c_old.setTime(currentDate);
        c_old.add(Calendar.DATE, -1);
        Date currentDateMinusOne = c_old.getTime();
        System.out.println(dateFormatYesterday.format(currentDateMinusOne));

        Helper.clickXpath(onlineTestingAdministrationPage.getStudentsSecondOption(), waiter, driver);
        WebElement element = driver.findElement(By.xpath(onlineTestingAdministrationPage.getWindowStart()));
        Actions actions = new Actions(driver);
        actions.moveToElement(element);
        actions.click();
        actions.sendKeys(dateFormatYesterday.format(currentDateMinusOne));
        actions.build().perform();
        System.out.println(dateFormatYesterday.format(currentDateMinusOne));

        DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
        Date current_Date = new Date();
        Calendar c = Calendar.getInstance();
        c.setTime(current_Date);
        c.add(Calendar.DATE, 3);
        Date currentDatePlusOne = c.getTime();
        System.out.println(dateFormat.format(currentDatePlusOne));

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

        //Select Student Name with Initial
        WebElement studentList = driver.findElement(By.id(onlineTestingAdministrationPage.getOnlineTestingAdministrationStudentId()));
        JavascriptExecutor je = (JavascriptExecutor) driver;
        je.executeScript("arguments[0].scrollIntoView(true);", studentList);
        Helper.wait(2.0);

        Select studentNameInList = new Select(driver.findElement(By.id(onlineTestingAdministrationPage.getOnlineTestingAdministrationStudentId())));
        String studentName = Config.getStudentLastFirstWithInitial();
        studentNameInList.selectByVisibleText(studentName);
        Helper.wait(2.0);

        Helper.clickXpath(onlineTestingAdministrationPage.getPortalSave(), waiter, driver);
        String completeBar = Helper.getText(onlineTestingAdministrationPage.getCompleteBar(), waiter, driver);
        while (!completeBar.equals("Complete")) {
            // loop
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            completeBar = Helper.getText(onlineTestingAdministrationPage.getCompleteBar(), waiter, driver);
        }
        administrationsPage = driver.getCurrentUrl();
        System.out.println("<mbt-output-url> " + administrationsPage);
    }

    //Clicking on e_ClickPortal
    public void e_ClickPortal() {
        driver.get(homeConnectionUrl);
        Helper.sendKeysXpath(onlineTestingAdministrationPage.getUsername(), studentPortalUn, waiter, driver);
        Helper.sendKeysXpath(onlineTestingAdministrationPage.getPassword(), studentPortalPw, waiter, driver);
        Helper.clickXpath(onlineTestingAdministrationPage.getLogin(), waiter, driver);
        if (driver.findElements(By.xpath(onlineTestingAdministrationPage.getResetPassword())).size() != 0) {
            Helper.sendKeysXpath(onlineTestingAdministrationPage.getResetPasswordFirst(), studentPortalPw, waiter, driver);
            Helper.sendKeysXpath(onlineTestingAdministrationPage.getResetPasswordSecond(), studentPortalPw, waiter, driver);
            Helper.clickXpath(onlineTestingAdministrationPage.getResetPasswordSubmit(), waiter, driver);
        }
        Helper.wait(5.0);
        Helper.clickXpath(onlineTestingAdministrationPage.getTakeAssessment(), waiter, driver);
        Helper.wait(3.0);

        WebElement element = driver.findElement(By.xpath("//a[contains(text(),'" + title + "')]"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
        Helper.wait(2.0);
        Helper.clickXpath("//a[contains(text(),'" + title + "')]", waiter, driver);
    }

    // Validate v_StudentTakeQuickrosterAssessment
    public void v_StudentTakeQuickrosterAssessment() {
        Helper.clickXpath(onlineTestingAdministrationPage.getSuccess(), waiter, driver);

        // Question 1 - Multiple Choice
        Helper.clickXpath(onlineTestingAdministrationPage.getFirstChoice(), waiter, driver);
        Helper.waitUntil(onlineTestingAdministrationPage.getStatusBox(), waiter, driver);
        Helper.clickXpath(onlineTestingAdministrationPage.getNextQuestionButton(), waiter, driver);

        // Question 2 - Multiple Choice
        Helper.clickXpath(onlineTestingAdministrationPage.getFirstChoice(), waiter, driver);
        Helper.waitUntil(onlineTestingAdministrationPage.getStatusBox(), waiter, driver);
        Helper.clickXpath(onlineTestingAdministrationPage.getNextQuestionButton(), waiter, driver);

        // Question 3 - Multiple Choice
        Helper.clickXpath(onlineTestingAdministrationPage.getFirstChoice(), waiter, driver);
        Helper.waitUntil(onlineTestingAdministrationPage.getStatusBox(), waiter, driver);
        Helper.clickXpath(onlineTestingAdministrationPage.getNextQuestionButton(), waiter, driver);

        // Review - Assertions
        try {
            Helper.wait(3.0);
            Helper.waitUntil(onlineTestingAdministrationPage.getFirstAnswer(), waiter, driver);
            String value = driver.findElement(By.xpath(onlineTestingAdministrationPage.getFirstAnswer())).getText().trim();
            if (value.equalsIgnoreCase("A")) {
                Helper.assertionText(onlineTestingAdministrationPage.getFirstAnswer(), "A", waiter, driver);
                Helper.assertionText(onlineTestingAdministrationPage.getSecondAnswer(), "A", waiter, driver);
                Helper.assertionText(onlineTestingAdministrationPage.getThirdAnswer(), "A", waiter, driver);
            } else if (value.equalsIgnoreCase("Answered")) {
                Helper.assertionText(onlineTestingAdministrationPage.getFirstAnswer(), "Answered", waiter, driver);
                Helper.assertionText(onlineTestingAdministrationPage.getSecondAnswer(), "Answered", waiter, driver);
                Helper.assertionText(onlineTestingAdministrationPage.getThirdAnswer(), "Answered", waiter, driver);
            }
        } catch (Exception e) {
            System.out.println("Exception handled for assertion...." + e);
        }
    }

    //Clicking on e_ClickFinish
    public void e_ClickFinish() {
        //---e_ClickFinish---
        Helper.clickXpath(onlineTestingAdministrationPage.getFinishButton(), waiter, driver);
        driver.get(administrationsPage);
    }

    // Validate v_AdministrationPage
    public void v_AdministrationPage() {
        driver.get(administrationsPage);
    }

    //Clicking on e_ClickAssessmentPanel
    public void e_ClickAssessmentPanel() {
        if (Boolean.parseBoolean(Config.getProperties().getProperty("ASSESSMENT_PANEL_CHECK"))) {
            //---e_ClickAssessmentPanel---
            studentName = Config.getProperties().getProperty("STUDENT_LAST_FIRST");
            try {
                Helper.clickXpath(onlineTestingAdministrationPage.getLiveProctoring(), waiter, driver);
            } catch (Exception e) {
                Helper.clickXpath(onlineTestingAdministrationPage.getAssessmentPanel(), waiter, driver);
            }
            Helper.refreshUntilElementAppears("//table[@id='student-list']//a[@class='black-text list-item']//div[.='" + studentName + "']", waiter, driver);
        }
    }

    // Validate v_AssessmentPanel
    public void v_AssessmentPanel() {
        if (Boolean.parseBoolean(Config.getProperties().getProperty("ASSESSMENT_PANEL_CHECK"))) {
            Helper.clickXpath("//a/div[contains(text(),'" + studentName + "')]", waiter, driver);

            Helper.wait(4.0);
            //---v_AssessmentPanel---
            //Helper.clickXpath("//table[@id='student-list']//a[@class='black-text list-item']", waiter, driver);
            try {
                Helper.wait(3.0);
                Helper.waitUntil(onlineTestingAdministrationPage.getAnswertext(), waiter, driver);
                String value = driver.findElement(By.xpath(onlineTestingAdministrationPage.getAnswertext())).getText().trim();
                if (value.equalsIgnoreCase("A")) {
                    Helper.assertionText(onlineTestingAdministrationPage.getFirstAnswerBox(), "A", waiter, driver);
                    Helper.assertionText(onlineTestingAdministrationPage.getSecondAnswerBox(), "A", waiter, driver);
                    Helper.assertionText(onlineTestingAdministrationPage.getThirdAnswerBox(), "A", waiter, driver);
                } else if (value.equalsIgnoreCase("Answered")) {
                    Helper.assertionText(onlineTestingAdministrationPage.getFirstAnswerBox(), "Answered", waiter, driver);
                    Helper.assertionText(onlineTestingAdministrationPage.getSecondAnswerBox(), "Answered", waiter, driver);
                    Helper.assertionText(onlineTestingAdministrationPage.getThirdAnswerBox(), "Answered", waiter, driver);
                }
            } catch (Exception e) {
                System.out.println("Exception handled for assertion...." + e);
            }
        }
    }

    //Clicking on e_ClickExitAssessmentPanel
    public void e_ClickExitAssessmentPanel() {
        if (Boolean.parseBoolean(Config.getProperties().getProperty("ASSESSMENT_PANEL_CHECK"))) {
            //---e_ClickExitAssessmentPanel---
            Helper.clickXpath(onlineTestingAdministrationPage.getExit(), waiter, driver);
        }
    }

    // Validate v_ReturnToAdministrationPage
    public void v_ReturnToAdministrationPage() {
        //---v_ReturnToAdminstrationPage---
    }
}
