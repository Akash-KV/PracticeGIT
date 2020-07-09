
import Controllers.CSVDataWriterScoringEvent;
import Controllers.ItemBankAssessmentController;
import DataReaders.CSVDataReaderItemBankAssessment;
import Helpers.BrowserInitHelper;
import Helpers.DriverHelper;
import Helpers.JavascriptHelper;
import Pom.Dashboard;
import Pom.ItemBankAssessmentPage;
import Pom.OnlineTestingAdministrationPage;
import Utils.Config;
import Utils.ConsoleLogger;
import org.graphwalker.core.machine.ExecutionContext;
import org.graphwalker.java.annotation.AfterExecution;
import org.graphwalker.java.annotation.BeforeExecution;
import org.graphwalker.java.annotation.GraphWalker;
import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.List;
import java.util.Set;


@GraphWalker(value = "quick_random(edge_coverage(100))", start = "e_StartBrowser")
//Test class for Item Bank Assessment
public class ItemBankAssessmentTest extends ExecutionContext implements ScoringItemBankLegacy {
    //Declarations
    Config config = new Config();
    String browser, url, username, password, closeBrowser, multiSite, ticket, authX;
    int waitTime;

    boolean verifyAddedQuestionCount = false;
    boolean verifyAddedQuestionDisplay = false;
    boolean correctCheck = false, incorrectCheck = false;

    String dir = null;
    String parentWinHandle;
    String assessmentName = "ItemBankLegacy";
    String uploadPdf;
    String studentName;

    //Logger and WebDrivers
    private static final Logger logger = LoggerFactory.getLogger(ItemBankAssessmentTest.class);

    Dashboard dashboardPOM = new Dashboard();
    ItemBankAssessmentPage itemBankAssessmentPagePOM = new ItemBankAssessmentPage();
    OnlineTestingAdministrationPage onlineTestingAdministrationPage = new OnlineTestingAdministrationPage();
    CSVDataReaderItemBankAssessment csvDataReaderItemBankAssessment = new CSVDataReaderItemBankAssessment();
    ItemBankAssessmentController itemBankAssessmentController = new ItemBankAssessmentController();
    String highlightSelectableText=null;
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
        authX = config.getAuthX();
        BrowserInitHelper.setup();

        dashboardPOM.readProperties();
        dir = System.getProperty("user.dir");
        uploadPdf = System.getProperty("user.dir") + "/src/main/resources/StudentPDF.pdf";
    }

    @AfterExecution
    public void cleanup() {
        if (BrowserInitHelper.getInstance() != null) {
            //  BrowserInitHelper.tearDown();
        }
    }

    //Enter Start Browser
    public void e_StartBrowser() {
        //Driver Instance
        System.out.println(browser);
    }

    //Validate Browser Started
    public void v_BrowserStarted() {

    }

    public void e_EnterBaseURL() {
        BrowserInitHelper.getInstance().manage().window().maximize();
        BrowserInitHelper.getInstance().get(url);
    }

    public void v_BaseURL() {

    }

    //Click on Login
    public void e_DirectLogin() {
//        if (authX.equalsIgnoreCase("true")) {
//            LoginController.loginAuthXSite(username, password);
//        } else {
//            LoginController.login(username, password);
//        }


        String highlightSelectableText = "hii";
        try {
            CSVDataWriterScoringEvent.WriteCSV("HighlightSelectableText", highlightSelectableText);
        } catch (IOException e) {
            e.printStackTrace();
        }


        try {
            DriverHelper.waitFluentByXPath(BrowserInitHelper.getInstance(), "//a/img[contains(@class,'illuminate-logo ied-login-logo')]");
            DriverHelper.clickXpath("//a/img[contains(@class,'illuminate-logo ied-login-logo')]");
        } catch (Exception e) {
            DriverHelper.waitFluentByXPath(BrowserInitHelper.getInstance(), "//div[contains(@class,'d-flex image-container')]//a/img[contains(@class,'ie-logo')]");
            DriverHelper.clickXpath("//div[contains(@class,'d-flex image-container')]//a/img[contains(@class,'ie-logo')]");
        }
        try {
            //DriverHelper.waitTill(5);
            System.out.println("came to page");
            DriverHelper.awaitTillElementDisplayed("//input[@type='email']", "email");
           // BrowserInitHelper.getWaiter().until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@aria-label='Email or phone']")));

           // DriverHelper.sendKeysXpath("//input[@aria-label='Email or phone']", "akv@illuminateed.net");
           DriverHelper.sendKeysXpath("//input[@type='email']","akv@illuminateed.net");

            System.out.println("came to page1");
           // BrowserInitHelper.getInstance().switchTo().parentFrame();
            System.out.println("adithya");
WebElement ele= BrowserInitHelper.getInstance().findElement(By.xpath("//input[@type='email']"));
            Actions actions=new Actions(BrowserInitHelper.getInstance());
            actions.moveToElement(ele).sendKeys(Keys.ENTER);
            actions.build().perform();

          //  DriverHelper.awaitTillElementDisplayed("//div//span/span[contains(.,'Next')]","Next");
            //DriverHelper.waitFluentByXPath(BrowserInitHelper.getInstance(), "//div//span/span[contains(.,'Next')]");
           // DriverHelper.waitTill(5);
          //  DriverHelper.clickXpath("//div//span/span[contains(.,'Next')]");
            System.out.println("Next1");
          //  DriverHelper.waitTill(5);
            DriverHelper.awaitTillElementDisplayed("//input[@type='password']", "password");

            System.out.println("password");
            //BrowserInitHelper.getWaiter().until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@type='password']")));
            DriverHelper.sendKeysXpath("//input[@type='password']", "Akash@123");
            System.out.println("password1");
           // DriverHelper.waitFluentByXPath(BrowserInitHelper.getInstance(), "//div[@id='view_container']//span/span[contains(.,'Next')]");
          //  System.out.println("Next2");
            WebElement pass= BrowserInitHelper.getInstance().findElement(By.xpath("//input[@type='password']"));
            Actions actionsPass=new Actions(BrowserInitHelper.getInstance());
            actionsPass.moveToElement(pass).sendKeys(Keys.ENTER);
            actionsPass.build().perform();

           // DriverHelper.clickXpath("//div[@id='view_container']//span/span[contains(.,'Next')]");
            System.out.println("Next3");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    //Validate Dashboard
    public void v_Dashboard() {
        String TitleTile;
        boolean isExist = false;

        /*Wait till Illuminate Logo appears*/
        BrowserInitHelper.waitUntil(dashboardPOM.getIlluminateLogo());

        /*Get all the Titles shown in Dashboard flip cards*/
        List<WebElement> TileTitleElement = BrowserInitHelper.getInstance().findElements(By.xpath(dashboardPOM.getDashboardTileTitleElement()));

        for (int i = 0; i < TileTitleElement.size(); i++) {
            TitleTile = TileTitleElement.get(i).getText().replaceAll("\n", " ");

            /*Validate if View Assessment tile is showing or not*/
            if (TitleTile.equalsIgnoreCase("View Assessments")) {
                isExist = true;
                ConsoleLogger.SuccessLog("View Assessments displayed in dashboard...");
                break;
            }
        }
        TileTitleElement = null;
        //Assert.assertTrue(isExist);
    }

    //Click Navbar
    public void e_ClickNavbar() {
        /*Click Assessments in left panel*/
        DriverHelper.clickXpath(dashboardPOM.getAssessmentsIcon());
    }

    //Validate Navbar
    public void v_Navbar() {
        /*Validate Assessments modal*/
        BrowserInitHelper.getWaiter().until(ExpectedConditions.elementToBeClickable(By.xpath(dashboardPOM.getAssessmentsModal())));
        Assert.assertTrue(DriverHelper.elementExistenceXpath(dashboardPOM.getAssessmentsModal()));
    }

    //Click on ItemBankAssessment
    public void e_NavItemBankAssessmentClick() {
        /*Click Create Assessment*/
        BrowserInitHelper.getWaiter().until(ExpectedConditions.elementToBeClickable(By.xpath(dashboardPOM.getCreateAssessmentLink())));
        DriverHelper.clickXpath(dashboardPOM.getCreateAssessmentLink());

        /*Click Item Bank*/
        BrowserInitHelper.getWaiter().until(ExpectedConditions.elementToBeClickable(By.xpath(dashboardPOM.getCreateItemBankLink())));
        DriverHelper.clickXpath(dashboardPOM.getCreateItemBankLink());
    }

    //Validate Title Page
    public void v_TitlePage() {
        /*Validate Create ItemBank Assessment modal*/
        BrowserInitHelper.getWaiter().until(ExpectedConditions.elementToBeClickable(By.xpath(itemBankAssessmentPagePOM.getCreateItemBankPopup())));
        Assert.assertTrue(DriverHelper.elementExistenceXpath(itemBankAssessmentPagePOM.getCreateItemBankPopup()));
    }

    public void e_CreateItems() {

    }


    public void v_TitlePageToCreateAssessment() {

        DriverHelper.waitFluentByXPath(BrowserInitHelper.getInstance(), itemBankAssessmentPagePOM.getCreateItemBankPopupNextButton());
        BrowserInitHelper.getInstance().findElement(By.xpath(itemBankAssessmentPagePOM.getCreateItemBankPopupNextButton())).click();
        BrowserInitHelper.getWaiter().until(ExpectedConditions.elementToBeClickable(By.xpath(itemBankAssessmentPagePOM.getItemBankAssessmentName())));

    }

    public void e_CreateAssessment() {
        //<< STEP - 1 >>
        /*Enter ItemBank Assessment Name & Click Create*/
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        assessmentName = assessmentName + timestamp.toString();
        assessmentName = assessmentName.replace(" ", "_");
        DriverHelper.sendKeysXpath(itemBankAssessmentPagePOM.getItemBankAssessmentName(), assessmentName);

        //Assessment Description
        DriverHelper.sendKeysXpath(itemBankAssessmentPagePOM.getAssessmentDescription(), csvDataReaderItemBankAssessment.getAssessmentDescription());

        //Academic Year
        DriverHelper.clickXpath(itemBankAssessmentPagePOM.getItemBankAssessmentYear());
        String yearInputBox = itemBankAssessmentPagePOM.getItemBankAssessmentYearInputBox();
        DriverHelper.sendKeysXpath(yearInputBox, csvDataReaderItemBankAssessment.getAcademicYear());
        BrowserInitHelper.getWaiter().until(ExpectedConditions.elementToBeClickable(By.xpath("//span[.='" + csvDataReaderItemBankAssessment.getAcademicYear() + "']")));
        BrowserInitHelper.getInstance().findElement(By.xpath("//span[.='" + csvDataReaderItemBankAssessment.getAcademicYear() + "']")).click();

        //Scroll till academic year
        JavascriptHelper.scrollintoViewXpath(itemBankAssessmentPagePOM.getItemBankAssessmentAcademicYear());
        DriverHelper.sendKeysXpath(itemBankAssessmentPagePOM.getAssessmentDescription(), csvDataReaderItemBankAssessment.getAssessmentDescription());

        //Grade
        DriverHelper.sendKeysXpath(itemBankAssessmentPagePOM.getGrade(), csvDataReaderItemBankAssessment.getGrade());
        BrowserInitHelper.getWaiter().until(ExpectedConditions.elementToBeClickable(By.xpath("//span[.='" + csvDataReaderItemBankAssessment.getGrade() + "']")));
        BrowserInitHelper.getInstance().findElement(By.xpath("//span[.='" + csvDataReaderItemBankAssessment.getGrade() + "']")).click();

        //Subject
        DriverHelper.clickXpath(itemBankAssessmentPagePOM.getSubject());
        String subjectInputBox = itemBankAssessmentPagePOM.getItemBankAssessmentSubjectInputBox();
        DriverHelper.sendKeysXpath(subjectInputBox, csvDataReaderItemBankAssessment.getSubject());
        BrowserInitHelper.getWaiter().until(ExpectedConditions.elementToBeClickable(By.xpath("//span[.='" + csvDataReaderItemBankAssessment.getSubject() + "']")));
        BrowserInitHelper.getInstance().findElement(By.xpath("//span[.='" + csvDataReaderItemBankAssessment.getSubject() + "']")).click();

        //Click on Create Button
        DriverHelper.clickXpath(itemBankAssessmentPagePOM.getCreateButtonStep1());
        //Verify Step 1
        BrowserInitHelper.getWaiter().until(ExpectedConditions.elementToBeClickable(By.xpath(itemBankAssessmentPagePOM.getItemBankAssessmentStepOne())));
        try {
            //<< STEP - 2 >>
            //Type
            BrowserInitHelper.getWaiter().until(ExpectedConditions.elementToBeClickable(By.xpath(itemBankAssessmentPagePOM.getItemBankAssessmentStandardDocument())));
            WebElement typeSelect = BrowserInitHelper.getInstance().findElement(By.xpath(itemBankAssessmentPagePOM.getItemBankAssessmentStandardDocument()));
            Select type = new Select(typeSelect);
            type.selectByVisibleText(csvDataReaderItemBankAssessment.getType());

            //All Subjects
            BrowserInitHelper.getWaiter().until(ExpectedConditions.elementToBeClickable(By.xpath(itemBankAssessmentPagePOM.getitemBankAssessmentStandardSubject())));
            WebElement subjectSelect = BrowserInitHelper.getInstance().findElement(By.xpath(itemBankAssessmentPagePOM.getitemBankAssessmentStandardSubject()));
            Select subject = new Select(subjectSelect);
            subject.selectByVisibleText(csvDataReaderItemBankAssessment.getSubjectStep2());

            //Grade
            BrowserInitHelper.getWaiter().until(ExpectedConditions.elementToBeClickable(By.xpath(itemBankAssessmentPagePOM.getitemBankAssessmentStandardCategory())));
            WebElement gradeSelect = BrowserInitHelper.getInstance().findElement(By.xpath(itemBankAssessmentPagePOM.getitemBankAssessmentStandardCategory()));
            Select grade = new Select(gradeSelect);
            grade.selectByVisibleText(csvDataReaderItemBankAssessment.getGradeStep2());

            //Select Standards
            BrowserInitHelper.getWaiter().until(ExpectedConditions.elementToBeClickable(By.xpath("(//label[@class='standard standard_text']//span[@class='standard_state_num' and text()='" + csvDataReaderItemBankAssessment.getStandardStep2() + "'])[1]")));
            BrowserInitHelper.getInstance().findElement(By.xpath("(//label[@class='standard standard_text']//span[@class='standard_state_num' and text()='" + csvDataReaderItemBankAssessment.getStandardStep2() + "'])[1]")).click();
            DriverHelper.awaitTillElementDisplayed(itemBankAssessmentPagePOM.getItemBankAssessmentNext(), "ItemBank Assessment Next");
            DriverHelper.waitTill(2);
            BrowserInitHelper.getWaiter().until(ExpectedConditions.elementToBeClickable(By.xpath(itemBankAssessmentPagePOM.getItemBankAssessmentNext())));
            BrowserInitHelper.getInstance().findElement(By.xpath(itemBankAssessmentPagePOM.getItemBankAssessmentNext())).click();

        } catch (Exception e) {
            System.out.println("Exception handled...." + e);
        }
        BrowserInitHelper.getWaiter().until(ExpectedConditions.elementToBeClickable(By.xpath(itemBankAssessmentPagePOM.getItemBankAssessmentAddItems())));

        //Select Without Passage
        DriverHelper.waitTill(5);
        BrowserInitHelper.getWaiter().until(ExpectedConditions.elementToBeClickable(By.xpath(itemBankAssessmentPagePOM.getItemBankAssessmentPassages())));
        WebElement passages = BrowserInitHelper.getInstance().findElement(By.xpath(itemBankAssessmentPagePOM.getItemBankAssessmentPassages()));
        Actions action = new Actions(BrowserInitHelper.getInstance());
        action.moveToElement(passages).click().perform();

        DriverHelper.waitTill(3);
        DriverHelper.awaitTillElementDisplayed(itemBankAssessmentPagePOM.getItemBankAssessmentItemSearchModel(), "ItemBank Assessment Item Search Model");
        BrowserInitHelper.getWaiter().until(ExpectedConditions.elementToBeClickable(By.xpath(itemBankAssessmentPagePOM.getItemBankAssessmentItemSearchModel())));
        BrowserInitHelper.getInstance().findElement(By.xpath(itemBankAssessmentPagePOM.getItemBankAssessmentFilterPassages())).click();
        BrowserInitHelper.getInstance().findElement(By.xpath(itemBankAssessmentPagePOM.getItemBankAssessmentUpdatefilters())).click();
//standers
        DriverHelper.waitTill(3);
        DriverHelper.waitFluentByXPath(BrowserInitHelper.getInstance(),itemBankAssessmentPagePOM.getItemBankAssessmentStanderds());
        DriverHelper.clickXpath(itemBankAssessmentPagePOM.getItemBankAssessmentStanderds());
        DriverHelper.waitFluentByXPath(BrowserInitHelper.getInstance(),itemBankAssessmentPagePOM.getItemBankAssessmentStanderdHeader());
        DriverHelper.waitFluentByXPath(BrowserInitHelper.getInstance(),itemBankAssessmentPagePOM.getItemBankAssessmentUnselectStaderds());
        DriverHelper.clickXpath(itemBankAssessmentPagePOM.getItemBankAssessmentUnselectStaderds());
        DriverHelper.clickXpath(itemBankAssessmentPagePOM.getItemBankAssessmentUpdateStanderds());
        //item banks
//        DriverHelper.waitTill(5);
//        DriverHelper.awaitTillElementDisplayed(itemBankAssessmentPagePOM.getCreateItemItemBanks(), "Create Item Banks");
//        BrowserInitHelper.getWaiter().until(ExpectedConditions.elementToBeClickable(By.xpath(itemBankAssessmentPagePOM.getCreateItemItemBanks())));
//
//        DriverHelper.waitTill(5);
//        DriverHelper.clickXpath(itemBankAssessmentPagePOM.getCreateItemItemBanks());
//      itemBankAssessmentController.itemBankSelect();
//
//
//       DriverHelper.waitFluentByXPath(BrowserInitHelper.getInstance(), itemBankAssessmentPagePOM.getItemBankUpdateFilters());
//       DriverHelper.clickXpath(itemBankAssessmentPagePOM.getItemBankUpdateFilters());
//        DriverHelper.waitTill(5);
//       DriverHelper.awaitTillElementDisplayed(itemBankAssessmentPagePOM.getCreateItemItemBanks(),"itembank");
//        DriverHelper.clickXpath(itemBankAssessmentPagePOM.getCreateItemItemBanks());
//        DriverHelper.waitFluentByXPath(BrowserInitHelper.getInstance(),"(//label[contains(.,'Inspect Plus')])[1]");
//        JavascriptHelper.scrollintoViewByXpath("(//label[contains(.,'Inspect Plus')])[1]");
//        DriverHelper.clickXpath("(//label[contains(.,'Inspect Plus')])[1]");

//        DriverHelper.waitFluentByXPath(BrowserInitHelper.getInstance(), itemBankAssessmentPagePOM.getItemBankUpdateFilters());
//        DriverHelper.clickXpath(itemBankAssessmentPagePOM.getItemBankUpdateFilters());
        try {
            BrowserInitHelper.getWaiter().until(ExpectedConditions.visibilityOfElementLocated(By.xpath(itemBankAssessmentPagePOM.getItemBankAssessmentItemSearchResults())));
        } catch (Exception e) {
            BrowserInitHelper.getWaiter().until(ExpectedConditions.visibilityOfElementLocated(By.xpath(itemBankAssessmentPagePOM.getCreateItemNoItemsFound())));
        }

        //item type
        DriverHelper.awaitTillElementDisplayed(itemBankAssessmentPagePOM.getItemBankAssessmentItemType(), "ItemBank Assessment Item Type");
        BrowserInitHelper.getInstance().findElement(By.xpath(itemBankAssessmentPagePOM.getItemBankAssessmentItemType())).click();
        DriverHelper.waitFluentByXPath(BrowserInitHelper.getInstance(),itemBankAssessmentPagePOM.getItemBankAssessmentSelectItem());

//select evidence based selected response
        BrowserInitHelper.getWaiter().until(ExpectedConditions.elementToBeClickable(By.xpath(itemBankAssessmentPagePOM.getItemBankAssessmenentEBSR())));

        //select Highlet
        BrowserInitHelper.getInstance().findElement(By.xpath(itemBankAssessmentPagePOM.getItemBankAssessmenentEBSR())).click();
        itemBankAssessmentController.updateFilterSearchItem();

        JavascriptHelper.scrollintoViewXpath("(//p[contains(.,'"+csvDataReaderItemBankAssessment.geteBSRItemName()+"')]//following::button[.='Add'])[1]");
        DriverHelper.waitFluentByXPath(BrowserInitHelper.getInstance(), "(//p[contains(.,'"+csvDataReaderItemBankAssessment.geteBSRItemName()+"')]//following::button[.='Add'])[1]");
        JavascriptHelper.clickXpath_JS("(//p[contains(.,'"+csvDataReaderItemBankAssessment.geteBSRItemName()+"')]//following::button[.='Add'])[1]");
        try {
            DriverHelper.waitFluentByXPath(BrowserInitHelper.getInstance(), itemBankAssessmentPagePOM.getItemBankAssessmenAddStanderds());
            BrowserInitHelper.getWaiter().until(ExpectedConditions.elementToBeClickable(By.xpath(itemBankAssessmentPagePOM.getItemBankAssessmentStanderdsAdded())));
            DriverHelper.clickXpath(itemBankAssessmentPagePOM.getItemBankAssessmentStanderdsAdded());
        }
        catch(Exception e)
        {
            System.out.println("no standerds added");
        }



        //item type multi port
        JavascriptHelper.scrollUp();
        DriverHelper.awaitTillElementDisplayed(itemBankAssessmentPagePOM.getItemBankAssessmentItemType(), "ItemBank Assessment Item Type");
        BrowserInitHelper.getInstance().findElement(By.xpath(itemBankAssessmentPagePOM.getItemBankAssessmentItemType())).click();
        DriverHelper.waitFluentByXPath(BrowserInitHelper.getInstance(),itemBankAssessmentPagePOM.getItemBankAssessmenentEBSR());
        DriverHelper.waitFluentByXPath(BrowserInitHelper.getInstance(), itemBankAssessmentPagePOM.getItemBankAssessmenentEBSR());
        DriverHelper.waitFluentByXPath(BrowserInitHelper.getInstance(), itemBankAssessmentPagePOM.getItemBankAssessmenentEBSR());
        BrowserInitHelper.getWaiter().until(ExpectedConditions.elementToBeClickable(By.xpath(itemBankAssessmentPagePOM.getItemBankAssessmenentEBSR())));

        BrowserInitHelper.getInstance().findElement(By.xpath(itemBankAssessmentPagePOM.getItemBankAssessmenentEBSR())).click();
        //select Highlet
        BrowserInitHelper.getWaiter().until(ExpectedConditions.elementToBeClickable(By.xpath(itemBankAssessmentPagePOM.getItemBankAssessmentHSTItem())));

        //select Highlet
        BrowserInitHelper.getInstance().findElement(By.xpath(itemBankAssessmentPagePOM.getItemBankAssessmentHSTItem())).click();
        itemBankAssessmentController.updateFilterSearchItem();

        JavascriptHelper.scrollintoViewXpath("(//p[contains(.,'"+csvDataReaderItemBankAssessment.gethSTItemName()+"')]//following::button[.='Add'])[1]");

        DriverHelper.waitFluentByXPath(BrowserInitHelper.getInstance(), "(//p[contains(.,'"+csvDataReaderItemBankAssessment.gethSTItemName()+"')]//following::button[.='Add'])[1]");
        JavascriptHelper.clickXpath_JS("(//p[contains(.,'"+csvDataReaderItemBankAssessment.gethSTItemName()+"')]//following::button[.='Add'])[1]");
        try {
            DriverHelper.waitFluentByXPath(BrowserInitHelper.getInstance(), itemBankAssessmentPagePOM.getItemBankAssessmenAddStanderds());
            BrowserInitHelper.getWaiter().until(ExpectedConditions.elementToBeClickable(By.xpath(itemBankAssessmentPagePOM.getItemBankAssessmentStanderdsAdded())));
            DriverHelper.clickXpath(itemBankAssessmentPagePOM.getItemBankAssessmentStanderdsAdded());
        }
        catch(Exception e)
        {
            System.out.println("no standerds added");
        }



        //item type multi port
        JavascriptHelper.scrollUp();
        DriverHelper.awaitTillElementDisplayed(itemBankAssessmentPagePOM.getItemBankAssessmentItemType(), "ItemBank Assessment Item Type");
        BrowserInitHelper.getInstance().findElement(By.xpath(itemBankAssessmentPagePOM.getItemBankAssessmentItemType())).click();
        DriverHelper.waitFluentByXPath(BrowserInitHelper.getInstance(),itemBankAssessmentPagePOM.getItemBankAssessmentSelectItem());
        DriverHelper.waitFluentByXPath(BrowserInitHelper.getInstance(), itemBankAssessmentPagePOM.getItemBankAssessmentHSTItem());
        DriverHelper.waitFluentByXPath(BrowserInitHelper.getInstance(), itemBankAssessmentPagePOM.getItemBankAssessmentHSTItem());
        BrowserInitHelper.getWaiter().until(ExpectedConditions.elementToBeClickable(By.xpath(itemBankAssessmentPagePOM.getItemBankAssessmentHSTItem())));

        BrowserInitHelper.getInstance().findElement(By.xpath(itemBankAssessmentPagePOM.getItemBankAssessmentHSTItem())).click();
        DriverHelper.waitFluentByXPath(BrowserInitHelper.getInstance(), itemBankAssessmentPagePOM.getItemBankAssessmentMultiport());
        BrowserInitHelper.getWaiter().until(ExpectedConditions.elementToBeClickable(By.xpath(itemBankAssessmentPagePOM.getItemBankAssessmentMultiport())));
        DriverHelper.clickXpath(itemBankAssessmentPagePOM.getItemBankAssessmentMultiport());
        JavascriptHelper.scrollintoViewByXpath(itemBankAssessmentPagePOM.getItemBankAssessmentSelectItemTypes());
        itemBankAssessmentController.updateFilterSearchItem();

        JavascriptHelper.scrollintoViewXpath("(//p[contains(.,'"+csvDataReaderItemBankAssessment.getMultiPortItemName()+"')]//following::button[.='Add'])[1]");
        BrowserInitHelper.getWaiter().until(ExpectedConditions.elementToBeClickable(By.xpath("(//p[contains(.,'"+csvDataReaderItemBankAssessment.getMultiPortItemName()+"')]//following::button[.='Add'])[1]")));
        JavascriptHelper.clickXpath_JS("(//p[contains(.,'"+csvDataReaderItemBankAssessment.getMultiPortItemName()+"')]//following::button[.='Add'])[1]");
        try {
            DriverHelper.waitFluentByXPath(BrowserInitHelper.getInstance(), itemBankAssessmentPagePOM.getItemBankAssessmenAddStanderds());
            BrowserInitHelper.getWaiter().until(ExpectedConditions.elementToBeClickable(By.xpath(itemBankAssessmentPagePOM.getItemBankAssessmentStanderdsAdded())));
            DriverHelper.clickXpath(itemBankAssessmentPagePOM.getItemBankAssessmentStanderdsAdded());
        }
        catch(Exception e)
        {
            System.out.println("no standerds added");
        }


        //item type Drag and drop
        JavascriptHelper.scrollUp();
        DriverHelper.awaitTillElementDisplayed(itemBankAssessmentPagePOM.getItemBankAssessmentItemType(), "ItemBankAssessment ItemType");
        BrowserInitHelper.getInstance().findElement(By.xpath(itemBankAssessmentPagePOM.getItemBankAssessmentItemType())).click();
        DriverHelper.waitFluentByXPath(BrowserInitHelper.getInstance(), itemBankAssessmentPagePOM.getItemBankAssessmentMultiport());
        BrowserInitHelper.getWaiter().until(ExpectedConditions.elementToBeClickable(By.xpath(itemBankAssessmentPagePOM.getItemBankAssessmentMultiport())));

        BrowserInitHelper.getInstance().findElement(By.xpath(itemBankAssessmentPagePOM.getItemBankAssessmentMultiport())).click();
        DriverHelper.waitFluentByXPath(BrowserInitHelper.getInstance(), itemBankAssessmentPagePOM.getItemBankAssessmentDragAndDropclassify());
        BrowserInitHelper.getWaiter().until(ExpectedConditions.elementToBeClickable(By.xpath(itemBankAssessmentPagePOM.getItemBankAssessmentDragAndDropclassify())));
        DriverHelper.clickXpath(itemBankAssessmentPagePOM.getItemBankAssessmentDragAndDropclassify());
        JavascriptHelper.scrollintoViewByXpath(itemBankAssessmentPagePOM.getItemBankAssessmentSelectItemTypes());
        itemBankAssessmentController.updateFilterSearchItem();

        JavascriptHelper.scrollintoViewXpath("(//p[contains(.,'"+csvDataReaderItemBankAssessment.getDragAndDropClassifyItemName()+"')]//following::button[.='Add'])[1]");
        BrowserInitHelper.getWaiter().until(ExpectedConditions.elementToBeClickable(By.xpath("(//p[contains(.,'"+csvDataReaderItemBankAssessment.getDragAndDropClassifyItemName()+"')]//following::button[.='Add'])[1]")));
        JavascriptHelper.clickXpath_JS("(//p[contains(.,'"+csvDataReaderItemBankAssessment.getDragAndDropClassifyItemName()+"')]//following::button[.='Add'])[1]");
        try {
            DriverHelper.waitFluentByXPath(BrowserInitHelper.getInstance(), itemBankAssessmentPagePOM.getItemBankAssessmenAddStanderds());
            BrowserInitHelper.getWaiter().until(ExpectedConditions.elementToBeClickable(By.xpath(itemBankAssessmentPagePOM.getItemBankAssessmentStanderdsAdded())));
            DriverHelper.clickXpath(itemBankAssessmentPagePOM.getItemBankAssessmentStanderdsAdded());
        }
        catch(Exception e)
        {
            System.out.println("no standerds added");
        }


        //Select drag and drop order
        JavascriptHelper.scrollUp();
        DriverHelper.awaitTillElementDisplayed(itemBankAssessmentPagePOM.getItemBankAssessmentItemType(), "ItemBankAssessment ItemType");
        BrowserInitHelper.getInstance().findElement(By.xpath(itemBankAssessmentPagePOM.getItemBankAssessmentItemType())).click();
        DriverHelper.waitFluentByXPath(BrowserInitHelper.getInstance(), itemBankAssessmentPagePOM.getItemBankAssessmentDragAndDropclassify());
        BrowserInitHelper.getWaiter().until(ExpectedConditions.elementToBeClickable(By.xpath(itemBankAssessmentPagePOM.getItemBankAssessmentDragAndDropclassify())));

        BrowserInitHelper.getInstance().findElement(By.xpath(itemBankAssessmentPagePOM.getItemBankAssessmentDragAndDropclassify())).click();
        DriverHelper.waitFluentByXPath(BrowserInitHelper.getInstance(), itemBankAssessmentPagePOM.getItemBankAssessmentDragAndDropOrder());
        BrowserInitHelper.getWaiter().until(ExpectedConditions.elementToBeClickable(By.xpath(itemBankAssessmentPagePOM.getItemBankAssessmentDragAndDropOrder())));
        DriverHelper.clickXpath(itemBankAssessmentPagePOM.getItemBankAssessmentDragAndDropOrder());
        JavascriptHelper.scrollintoViewByXpath(itemBankAssessmentPagePOM.getItemBankAssessmentSelectItemTypes());
        itemBankAssessmentController.updateFilterSearchItem();

        JavascriptHelper.scrollintoViewXpath("(//p[contains(.,'"+csvDataReaderItemBankAssessment.getDragAndDropOrderItemName()+"')]//following::button[.='Add'])[1]");
        BrowserInitHelper.getWaiter().until(ExpectedConditions.elementToBeClickable(By.xpath("(//p[contains(.,'"+csvDataReaderItemBankAssessment.getDragAndDropOrderItemName()+"')]//following::button[.='Add'])[1]")));
        JavascriptHelper.clickXpath_JS("(//p[contains(.,'"+csvDataReaderItemBankAssessment.getDragAndDropOrderItemName()+"')]//following::button[.='Add'])[1]");
        try {
            DriverHelper.waitFluentByXPath(BrowserInitHelper.getInstance(), itemBankAssessmentPagePOM.getItemBankAssessmenAddStanderds());
            BrowserInitHelper.getWaiter().until(ExpectedConditions.elementToBeClickable(By.xpath(itemBankAssessmentPagePOM.getItemBankAssessmentStanderdsAdded())));
            DriverHelper.clickXpath(itemBankAssessmentPagePOM.getItemBankAssessmentStanderdsAdded());
        }
        catch(Exception e)
        {
            System.out.println("no standerds added");
        }


//
        BrowserInitHelper.getWaiter().until(ExpectedConditions.elementToBeClickable(By.xpath(itemBankAssessmentPagePOM.getItemBankAssessmentNext())));
        BrowserInitHelper.getInstance().findElement(By.xpath(itemBankAssessmentPagePOM.getItemBankAssessmentNext())).click();
        BrowserInitHelper.getWaiter().until(ExpectedConditions.elementToBeClickable(By.xpath(itemBankAssessmentPagePOM.getitemBankAssessmentStepQuestions())));

        //Click Next
        BrowserInitHelper.getWaiter().until(ExpectedConditions.elementToBeClickable(By.xpath(itemBankAssessmentPagePOM.getItemBankAssessmentNext())));
        BrowserInitHelper.getInstance().findElement(By.xpath(itemBankAssessmentPagePOM.getItemBankAssessmentNext())).click();
        BrowserInitHelper.getWaiter().until(ExpectedConditions.elementToBeClickable(By.xpath(itemBankAssessmentPagePOM.getitemBankAssessmentPrintOptions())));
        BrowserInitHelper.getWaiter().until(ExpectedConditions.elementToBeClickable(By.xpath(itemBankAssessmentPagePOM.getItemBankAssessmentNext())));
        BrowserInitHelper.getInstance().findElement(By.xpath(itemBankAssessmentPagePOM.getItemBankAssessmentNext())).click();


    }

    public void v_CreateAssessment() {

    }

    public void e_PublishAndAdministerClick() {

        BrowserInitHelper.getWaiter().until(ExpectedConditions.elementToBeClickable(By.xpath(itemBankAssessmentPagePOM.getItemBankAssessmentPublishyourAssessment())));
        DriverHelper.clickXpath(itemBankAssessmentPagePOM.getitemBankAssessmentPublihAdminButton());
        //Take test Quick Roster

    }


    public void v_AdministrationPagePortal() {

    }

    public void e_ClickQuickRoster() {
        //Quick code button
        DriverHelper.waitFluentByXPath(BrowserInitHelper.getInstance(), itemBankAssessmentPagePOM.getTestWithQuickCodeButton());
        BrowserInitHelper.getWaiter().until(ExpectedConditions.elementToBeClickable(By.xpath(itemBankAssessmentPagePOM.getTestWithQuickCodeButton())));
        BrowserInitHelper.getInstance().findElement(By.xpath(itemBankAssessmentPagePOM.getTestWithQuickCodeButton())).click();

        //Click on access code
        DriverHelper.waitFluentByXPath(BrowserInitHelper.getInstance(), itemBankAssessmentPagePOM.getAccessCode());
        BrowserInitHelper.getWaiter().until(ExpectedConditions.elementToBeClickable(By.xpath(itemBankAssessmentPagePOM.getAccessCode())));
        BrowserInitHelper.getInstance().findElement(By.xpath(itemBankAssessmentPagePOM.getAccessCode())).click();

        //Click on link and switch to window
        BrowserInitHelper.getWaiter().until(ExpectedConditions.elementToBeClickable(By.xpath(itemBankAssessmentPagePOM.getQuickRosterPopup())));
        BrowserInitHelper.getWaiter().until(ExpectedConditions.elementToBeClickable(By.xpath(itemBankAssessmentPagePOM.getIlluminateLink())));
        BrowserInitHelper.getInstance().findElement(By.xpath(itemBankAssessmentPagePOM.getIlluminateLink())).click();

        //Enter student id and login
        parentWinHandle = BrowserInitHelper.getInstance().getWindowHandle();
        Set<String> winHandles = BrowserInitHelper.getInstance().getWindowHandles();

        for (String handle : winHandles) {
            if (!handle.equals(parentWinHandle)) {
                try {
                    Thread.sleep(5000);
                    BrowserInitHelper.getInstance().switchTo().window(handle);

                    Thread.sleep(5000);
                    DriverHelper.awaitTillElementDisplayed(itemBankAssessmentPagePOM.getStudentIDLoginInput(), "StudentID Login Input");

                    //Enter student id
                    Thread.sleep(5000);
                    BrowserInitHelper.getWaiter().until(ExpectedConditions.elementToBeClickable(By.xpath(itemBankAssessmentPagePOM.getStudentIDLoginInput())));
                    BrowserInitHelper.getInstance().findElement(By.xpath(itemBankAssessmentPagePOM.getStudentIDLoginInput())).sendKeys(Config.getStudentUserName());

                    //Click Next
                    BrowserInitHelper.getWaiter().until(ExpectedConditions.elementToBeClickable(By.xpath(itemBankAssessmentPagePOM.getNextButton())));
                    BrowserInitHelper.getInstance().findElement(By.xpath(itemBankAssessmentPagePOM.getNextButton())).click();

                    //Click on Confirm button
                    BrowserInitHelper.getWaiter().until(ExpectedConditions.elementToBeClickable(By.xpath(itemBankAssessmentPagePOM.getConfirmButton())));
                    BrowserInitHelper.getInstance().findElement(By.xpath(itemBankAssessmentPagePOM.getConfirmButton())).click();

                    //Verify for total number of questions
                    if (csvDataReaderItemBankAssessment.getDeleteQuestion().equalsIgnoreCase("ON")) {
                        int value = Integer.parseInt(csvDataReaderItemBankAssessment.getNumberOfQuestions());
                        BrowserInitHelper.getWaiter().until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//td[.='" + value + "']")));
                        verifyAddedQuestionCount = true;
                    } else {
                        int addedValue = Integer.parseInt(csvDataReaderItemBankAssessment.getNumberOfQuestions()) + 1;
                        BrowserInitHelper.getWaiter().until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//td[.='" + addedValue + "']")));
                        verifyAddedQuestionCount = true;
                    }

                    /*Click Begin Test*/
                    BrowserInitHelper.getWaiter().until(ExpectedConditions.elementToBeClickable(By.xpath(itemBankAssessmentPagePOM.getBeginTestButton())));
                    DriverHelper.clickXpath(itemBankAssessmentPagePOM.getBeginTestButton());

                    /*Take Online Test*/
                    BrowserInitHelper.getWaiter().until(ExpectedConditions.elementToBeClickable(By.xpath(itemBankAssessmentPagePOM.getQuestionContainer())));

                    //Enter Answers when question is deleted at first, middle or last position
                    if (csvDataReaderItemBankAssessment.getDeleteQuestion().equalsIgnoreCase("ON")) {
                        itemBankAssessmentController.addAnswersToQuestionsWhenDeleted();
                        verifyAddedQuestionDisplay = true;
                    } else {
                        //Enter answers from 1 to 4th question
                        //Partial Answers
                        itemBankAssessmentController.addAnswersToQuestionsforPartial();
                        verifyAddedQuestionDisplay = true;
                    }

                } catch (Exception e) {
                    System.out.println("Exception handled...");
                }
                //click on begin test
                BrowserInitHelper.getWaiter().until(ExpectedConditions.elementToBeClickable(By.xpath(itemBankAssessmentPagePOM.getBeginTestButton())));
                DriverHelper.clickXpath(itemBankAssessmentPagePOM.getBeginTestButton());

                /*Take Online Test*/
                BrowserInitHelper.getWaiter().until(ExpectedConditions.elementToBeClickable(By.xpath(itemBankAssessmentPagePOM.getQuestionContainer())));

                //Enter Answers when question is deleted at first, middle or last position
                if (csvDataReaderItemBankAssessment.getDeleteQuestion().equalsIgnoreCase("ON")) {
                    itemBankAssessmentController.addAnswersToQuestionsWhenDeleted();
                    verifyAddedQuestionDisplay = true;
                } else {
                    //Enter answers from 1 to 7th question
                    itemBankAssessmentController.addAnswersToQuestionsforPartial();


                    /*Switch to PARENT Window*/
                    BrowserInitHelper.getInstance().switchTo().window(parentWinHandle);
                    BrowserInitHelper.getWaiter().until(ExpectedConditions.elementToBeClickable(By.xpath(itemBankAssessmentPagePOM.getCloseAccessPopup())));
                    BrowserInitHelper.getInstance().findElement(By.xpath(itemBankAssessmentPagePOM.getCloseAccessPopup())).click();

                }
            }
        }
    }


    public void v_StudentTakeQuickrosterAssessment() {

    }

    public void e_ClickFinishForPartialAnswers() {
        BrowserInitHelper.getInstance().navigate().refresh();
    }

    public void v_AdministrationPage() {
        //Validate Administration page
        ConsoleLogger.SuccessLog("Administration page is verified");
        itemBankAssessmentController.refreshPageUntilStudentListAppears();

        try {
            DriverHelper.waitFluentByXPath(BrowserInitHelper.getInstance(), onlineTestingAdministrationPage.getOnlineTestingAdministrationLiveProctoring());
            DriverHelper.clickXpath(onlineTestingAdministrationPage.getOnlineTestingAdministrationLiveProctoring());
        } catch (Exception e) {
            DriverHelper.clickXpath(onlineTestingAdministrationPage.getOnlineTestingAdministrationassessmentPanel());
        }

        DriverHelper.refreshUntilElementAppears("//table[@id='student-list']//a[@class='black-text list-item']//div[.='" + Config.getStudentLastName() + "']");
        DriverHelper.waitFluentByXPath(BrowserInitHelper.getInstance(), onlineTestingAdministrationPage.getOnlineTestingAdministrationNumberOfQuestions());
        DriverHelper.clickXpath("//table[@id='student-list']//a[@class='black-text list-item']//div[.='" + Config.getStudentLastName() + "']");

        BrowserInitHelper.getWaiter().until(ExpectedConditions.elementToBeClickable(By.xpath(itemBankAssessmentPagePOM.getItemBankAssessmentExit())));
        DriverHelper.waitFluentByXPath(BrowserInitHelper.getInstance(), itemBankAssessmentPagePOM.getItemBankAssessmentExit());
        DriverHelper.clickXpath(itemBankAssessmentPagePOM.getItemBankAssessmentExit());
        BrowserInitHelper.getWaiter().until(ExpectedConditions.elementToBeClickable(By.xpath(onlineTestingAdministrationPage.getOnlineTestingAdministrationOverview())));
        DriverHelper.waitFluentByXPath(BrowserInitHelper.getInstance(), onlineTestingAdministrationPage.getOnlineTestingAdministrationOverview());
        DriverHelper.clickXpath(onlineTestingAdministrationPage.getOnlineTestingAdministrationOverview());
        correctCheck = (boolean) getAttribute("correctCheck");
        incorrectCheck = (boolean) getAttribute("incorrectCheck");
    }


    public void e_ClickOnEnterEdit() {
        boolean click = false;
        while (!click) {
            try {
                BrowserInitHelper.getWaiter().until(ExpectedConditions.visibilityOfElementLocated(By.xpath(onlineTestingAdministrationPage.getOnlineTestingAdministrationAdministration())));
                DriverHelper.clickXpath(onlineTestingAdministrationPage.getOnlineTestingAdministrationAdministration());
                click = true;
            } catch (ElementClickInterceptedException e) {
                BrowserInitHelper.getInstance().navigate().refresh();
                DriverHelper.waitTill(2);
            }
        }

        //click
        BrowserInitHelper.getWaiter().until(ExpectedConditions.visibilityOfElementLocated(By.xpath(itemBankAssessmentPagePOM.getItemBankAssessmentEnter())));
        DriverHelper.clickXpath(itemBankAssessmentPagePOM.getItemBankAssessmentEnter());
        //---v_EnterEdit---
        WebElement element = BrowserInitHelper.getInstance().findElement(By.xpath(itemBankAssessmentPagePOM.getItemBankAssessmentViewType()));
        Select dropdown = new Select(element);
        dropdown.selectByVisibleText("Students With Data");
        DriverHelper.clickXpath(itemBankAssessmentPagePOM.getItemBankAssessmentFindStudents());


    }

    public void v_VerifyEnterEdit() {
        //set The response score for constructed response
        if (correctCheck) {
            itemBankAssessmentController.setResponseScoreforMultiPort();
            itemBankAssessmentController.setResponseScoreforDragAndDrop();
            itemBankAssessmentController.setResponseScoreforDragAndDropOrder();
            itemBankAssessmentController.setResponseScoreforSelectHighlight();


        } else if (incorrectCheck) {
            itemBankAssessmentController.setResponseScoreforForWrongAnswer();
            itemBankAssessmentController.setResponseScoreforForWrongAnswerDrag();
//            itemBankAssessmentController.setResponseScoreforHighlight();
        } else {
            itemBankAssessmentController.setResponseScoreforMultiPort();
            itemBankAssessmentController.setResponseScoreforDragAndDropPartial();
        }

        try {
            DriverHelper.waitFluentByXPath(BrowserInitHelper.getInstance(), onlineTestingAdministrationPage.getOnlineTestingAdministrationGridSave());
            DriverHelper.clickXpath(onlineTestingAdministrationPage.getOnlineTestingAdministrationGridSave());
        } catch (Exception e) {
            System.out.println("Exception handled for save...");
        }
    }

    public void e_ClickOnOverview() {
        //click on overview
        BrowserInitHelper.getWaiter().until(ExpectedConditions.elementToBeClickable(By.xpath(onlineTestingAdministrationPage.getOnlineTestingAdministrationOverview())));
        DriverHelper.clickXpath(onlineTestingAdministrationPage.getOnlineTestingAdministrationOverview());
        try {
            JavascriptHelper.scrolBottomOfThePage();
            JavascriptHelper.ScrollTillElement_Javascript(onlineTestingAdministrationPage.getOnlineTestingAdministrationDismiss());
            System.out.println("Scrolling till Element");
            JavascriptHelper.click_Xpath(onlineTestingAdministrationPage.getOnlineTestingAdministrationDismiss());
            System.out.println("Clicking on Dismiss");
            JavascriptHelper.scrollUp();

        }
        //button[contains(.,'Dismiss')]
        catch (Exception e) {
            System.out.println("Exception handled");
        }
    }

    public void v_VerifyScore() {
        //validate score
        // for correct answer assertion code
        if (correctCheck) {
            DriverHelper.assertionText(onlineTestingAdministrationPage.getOnlineTestingAdministrationHundredPercent(), "100.0%");
            ConsoleLogger.SuccessLog("Verified for correct answers");
        }

        // for wrong answer assertion code
        else if (incorrectCheck) {
            DriverHelper.assertionText(onlineTestingAdministrationPage.getOnlineTestingAdministrationZeroPercent(), "0.0%");
            ConsoleLogger.SuccessLog("Verified for Wrong answer");
        }

        // for partial answer assertion code
        else {
            DriverHelper.assertionText(onlineTestingAdministrationPage.getOnlineTestingAdministrationParcialPercent(), "57.1%");
            ConsoleLogger.SuccessLog("Verified for Partial answer");
        }

        //Remove Student Responses
        JavascriptHelper.scrollUp();
        BrowserInitHelper.getWaiter().until(ExpectedConditions.elementToBeClickable(By.xpath(onlineTestingAdministrationPage.getOnlineTestingAdministrationAdvanced())));
        DriverHelper.clickXpath(onlineTestingAdministrationPage.getOnlineTestingAdministrationAdvanced());
        BrowserInitHelper.getWaiter().until(ExpectedConditions.elementToBeClickable(By.xpath(onlineTestingAdministrationPage.getOnlineTestingAdministrationRemoveAllResponses())));
        DriverHelper.clickXpath(onlineTestingAdministrationPage.getOnlineTestingAdministrationRemoveAllResponses());
        BrowserInitHelper.getWaiter().until(ExpectedConditions.elementToBeClickable(By.xpath(onlineTestingAdministrationPage.getOnlineTestingAdministrationRemoveButton())));
        DriverHelper.clickId(onlineTestingAdministrationPage.getOnlineTestingAdministrationAgreeRemove(), BrowserInitHelper.getWaiter(), BrowserInitHelper.getInstance());
        DriverHelper.clickId(onlineTestingAdministrationPage.getOnlineTestingAdministrationConfirmRemove(), BrowserInitHelper.getWaiter(), BrowserInitHelper.getInstance());
        BrowserInitHelper.getWaiter().until(ExpectedConditions.elementToBeClickable(By.xpath(onlineTestingAdministrationPage.getOnlineTestingAdministrationRemoveStudentResponses())));
        DriverHelper.clickId(onlineTestingAdministrationPage.getOnlineTestingAdministrationRemoveStudentResponseButton(), BrowserInitHelper.getWaiter(), BrowserInitHelper.getInstance());
        BrowserInitHelper.getWaiter().until(ExpectedConditions.visibilityOfElementLocated(By.xpath(onlineTestingAdministrationPage.getOnlineTestingAdministrationRemoveMessage())));
        DriverHelper.waitTill(5);
    }

    public void e_ClickOnOnlineTesting() {
        BrowserInitHelper.getWaiter().until(ExpectedConditions.elementToBeClickable(By.xpath(onlineTestingAdministrationPage.getOnlineTestingAdministrationAdministrationButton())));
        DriverHelper.clickXpath(onlineTestingAdministrationPage.getOnlineTestingAdministrationAdministrationButton());
        BrowserInitHelper.getWaiter().until(ExpectedConditions.elementToBeClickable(By.xpath(onlineTestingAdministrationPage.getOnlineTestingAdministrationOnlineTesting())));
        DriverHelper.clickXpath(onlineTestingAdministrationPage.getOnlineTestingAdministrationOnlineTesting());
    }

    public void v_OnlineTestingPage() {
        DriverHelper.awaitTillElementDisplayed(itemBankAssessmentPagePOM.getTestWithQuickCodeButton(), "TestWithQuickCodeButton");
        BrowserInitHelper.getWaiter().until(ExpectedConditions.elementToBeClickable(By.xpath(itemBankAssessmentPagePOM.getTestWithQuickCodeButton())));
    }

    public void e_ClickFinishForCorrectAnswers() {
        //Quick code button
        BrowserInitHelper.getWaiter().until(ExpectedConditions.elementToBeClickable(By.xpath(itemBankAssessmentPagePOM.getTestWithQuickCodeButton())));
        BrowserInitHelper.getInstance().findElement(By.xpath(itemBankAssessmentPagePOM.getTestWithQuickCodeButton())).click();

        //Click on access code
        DriverHelper.waitFluentByXPath(BrowserInitHelper.getInstance(), itemBankAssessmentPagePOM.getAccessCode());
        BrowserInitHelper.getWaiter().until(ExpectedConditions.elementToBeClickable(By.xpath(itemBankAssessmentPagePOM.getAccessCode())));
        BrowserInitHelper.getInstance().findElement(By.xpath(itemBankAssessmentPagePOM.getAccessCode())).click();

        //Click on link and switch to window
        BrowserInitHelper.getWaiter().until(ExpectedConditions.elementToBeClickable(By.xpath(itemBankAssessmentPagePOM.getQuickRosterPopup())));
        BrowserInitHelper.getWaiter().until(ExpectedConditions.elementToBeClickable(By.xpath(itemBankAssessmentPagePOM.getIlluminateLink())));
        BrowserInitHelper.getInstance().findElement(By.xpath(itemBankAssessmentPagePOM.getIlluminateLink())).click();

        itemBankAssessmentController.getWindowHandleAndSwitchWindow(BrowserInitHelper.getInstance());
        DriverHelper.awaitTillElementDisplayed(itemBankAssessmentPagePOM.getStudentIDLoginInput(), "StudentID Login Input");

        //Enter student id
        BrowserInitHelper.getWaiter().until(ExpectedConditions.elementToBeClickable(By.xpath(itemBankAssessmentPagePOM.getStudentIDLoginInput())));
        BrowserInitHelper.getInstance().findElement(By.xpath(itemBankAssessmentPagePOM.getStudentIDLoginInput())).sendKeys(Config.getStudentUserName());

        //Click Next
        BrowserInitHelper.getWaiter().until(ExpectedConditions.elementToBeClickable(By.xpath(itemBankAssessmentPagePOM.getNextButton())));
        BrowserInitHelper.getInstance().findElement(By.xpath(itemBankAssessmentPagePOM.getNextButton())).click();

        //Click on Confirm button
        BrowserInitHelper.getWaiter().until(ExpectedConditions.elementToBeClickable(By.xpath(itemBankAssessmentPagePOM.getConfirmButton())));
        BrowserInitHelper.getInstance().findElement(By.xpath(itemBankAssessmentPagePOM.getConfirmButton())).click();

        /*Click Begin Test*/
        BrowserInitHelper.getWaiter().until(ExpectedConditions.elementToBeClickable(By.xpath(itemBankAssessmentPagePOM.getBeginTestButton())));
        DriverHelper.clickXpath(itemBankAssessmentPagePOM.getBeginTestButton());

        /*Take Online Test*/
        BrowserInitHelper.getWaiter().until(ExpectedConditions.elementToBeClickable(By.xpath(itemBankAssessmentPagePOM.getQuestionContainer())));

        //Enter Answers when question is deleted at first, middle or last position
        if (csvDataReaderItemBankAssessment.getDeleteQuestion().equalsIgnoreCase("ON")) {
            itemBankAssessmentController.addAnswersToQuestionsWhenDeleted();
            verifyAddedQuestionDisplay = true;
        } else {
            //Enter answers from 1 to 7th question
            //Partial Answers
            itemBankAssessmentController.addAnswersToQuestions();
            // verifyAddedQuestionDisplay = true;



            /*Switch to PARENT Window*/
            BrowserInitHelper.getInstance().switchTo().window(parentWinHandle);
            BrowserInitHelper.getWaiter().until(ExpectedConditions.elementToBeClickable(By.xpath(itemBankAssessmentPagePOM.getCloseAccessPopup())));
            BrowserInitHelper.getInstance().findElement(By.xpath(itemBankAssessmentPagePOM.getCloseAccessPopup())).click();

        }
    }
    public void e_ClickFinishForWrongAnswer() {
        //Quick code button
        BrowserInitHelper.getWaiter().until(ExpectedConditions.elementToBeClickable(By.xpath(itemBankAssessmentPagePOM.getTestWithQuickCodeButton())));
        BrowserInitHelper.getInstance().findElement(By.xpath(itemBankAssessmentPagePOM.getTestWithQuickCodeButton())).click();

        //Click on access code
        BrowserInitHelper.getWaiter().until(ExpectedConditions.elementToBeClickable(By.xpath(itemBankAssessmentPagePOM.getAccessCode())));
        BrowserInitHelper.getInstance().findElement(By.xpath(itemBankAssessmentPagePOM.getAccessCode())).click();

        //Click on link and switch to window
        BrowserInitHelper.getWaiter().until(ExpectedConditions.elementToBeClickable(By.xpath(itemBankAssessmentPagePOM.getQuickRosterPopup())));
        BrowserInitHelper.getWaiter().until(ExpectedConditions.elementToBeClickable(By.xpath(itemBankAssessmentPagePOM.getIlluminateLink())));
        BrowserInitHelper.getInstance().findElement(By.xpath(itemBankAssessmentPagePOM.getIlluminateLink())).click();

        itemBankAssessmentController.getWindowHandleAndSwitchWindow(BrowserInitHelper.getInstance());
        DriverHelper.awaitTillElementDisplayed(itemBankAssessmentPagePOM.getStudentIDLoginInput(), "StudentID Login Input");

        //Enter student id
        BrowserInitHelper.getWaiter().until(ExpectedConditions.elementToBeClickable(By.xpath(itemBankAssessmentPagePOM.getStudentIDLoginInput())));
        BrowserInitHelper.getInstance().findElement(By.xpath(itemBankAssessmentPagePOM.getStudentIDLoginInput())).sendKeys(Config.getStudentUserName());

        //Click Next
        BrowserInitHelper.getWaiter().until(ExpectedConditions.elementToBeClickable(By.xpath(itemBankAssessmentPagePOM.getNextButton())));
        BrowserInitHelper.getInstance().findElement(By.xpath(itemBankAssessmentPagePOM.getNextButton())).click();

        //Click on Confirm button
        BrowserInitHelper.getWaiter().until(ExpectedConditions.elementToBeClickable(By.xpath(itemBankAssessmentPagePOM.getConfirmButton())));
        BrowserInitHelper.getInstance().findElement(By.xpath(itemBankAssessmentPagePOM.getConfirmButton())).click();

        /*Click Begin Test*/
        BrowserInitHelper.getWaiter().until(ExpectedConditions.elementToBeClickable(By.xpath(itemBankAssessmentPagePOM.getBeginTestButton())));
        DriverHelper.clickXpath(itemBankAssessmentPagePOM.getBeginTestButton());

        /*Take Online Test*/
        BrowserInitHelper.getWaiter().until(ExpectedConditions.elementToBeClickable(By.xpath(itemBankAssessmentPagePOM.getQuestionContainer())));

        //Enter Answers when question is deleted at first, middle or last position
        if (csvDataReaderItemBankAssessment.getDeleteQuestion().equalsIgnoreCase("ON")) {
            itemBankAssessmentController.addAnswersToQuestionsWhenDeleted();
            verifyAddedQuestionDisplay = true;
        } else {
            //Enter answers from 1 to 5th question
            //Partial Answers
            itemBankAssessmentController.addAnswersToQuestionsforIncorrect();
            verifyAddedQuestionDisplay = true;
        }

        /*Switch to PARENT Window*/
        BrowserInitHelper.getInstance().switchTo().window(parentWinHandle);
        BrowserInitHelper.getWaiter().until(ExpectedConditions.elementToBeClickable(By.xpath(itemBankAssessmentPagePOM.getCloseAccessPopup())));
        BrowserInitHelper.getInstance().findElement(By.xpath(itemBankAssessmentPagePOM.getCloseAccessPopup())).click();
    }

    public void e_ClickExit() {

    }
}