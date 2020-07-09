package Controllers;

import DataReaders.CSVDataReaderItemBankAssessment;
import Helpers.BrowserInitHelper;
import Helpers.DriverHelper;
import Helpers.JavascriptHelper;
import Pom.ItemBankAssessmentPage;
import Pom.OnlineTestingAdministrationPage;
import Utils.Config;
import Utils.ConsoleLogger;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

import java.util.Set;

public class OnlineTestingAdministrationController {
    Config config = new Config();
    String browser, url, username, password, closeBrowser, multiSite, ticket, authX;
    int waitTime;
    boolean verifyAddedQuestionCount = false;
    boolean verifyAddedQuestionDisplay = false;
    boolean correctCheck = false, incorrectCheck = false;
    String parentWinHandle;
    ItemBankAssessmentPage itemBankAssessmentPagePOM=new ItemBankAssessmentPage();
    CSVDataReaderItemBankAssessment csvDataReaderItemBankAssessment=new CSVDataReaderItemBankAssessment();
    ItemBankAssessmentController itemBankAssessmentController=new ItemBankAssessmentController();
   OnlineTestingAdministrationPage onlineTestingAdministrationPage=new OnlineTestingAdministrationPage();
    public void clickOnQuickRoster()
    {
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
                    //Enter answers from 1 to 5th question
                    itemBankAssessmentController.addAnswersToQuestionsforPartial();


                    /*Switch to PARENT Window*/
                    BrowserInitHelper.getInstance().switchTo().window(parentWinHandle);
                    BrowserInitHelper.getWaiter().until(ExpectedConditions.elementToBeClickable(By.xpath(itemBankAssessmentPagePOM.getCloseAccessPopup())));
                    BrowserInitHelper.getInstance().findElement(By.xpath(itemBankAssessmentPagePOM.getCloseAccessPopup())).click();

                }
            }
        }
    }

    public  void refresh()
    {
        BrowserInitHelper.getInstance().navigate().refresh();
    }
    public void validateAdministrationPage()
    {
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
    }
    public void clickOnEnterEdit()
    {
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
    public void validateEnterEditForCorrectAnswers()
    {
        itemBankAssessmentController.setResponseScoreforMultiPort();
       // itemBankAssessmentController.setResponseScoreforDragAndDrop();
      //  itemBankAssessmentController.setResponseScoreforDragAndDropOrder();
       // itemBankAssessmentController.setResponseScoreforSelectHighlight();
    }
    public void validateEnterEditForInvalidAnswers()
    {
       // itemBankAssessmentController.setResponseScoreforForWrongAnswer();
       // itemBankAssessmentController.setResponseScoreforForWrongAnswerDrag();
//            itemBankAssessmentController.setResponseScoreforHighlight();
    }
    public void validEnterEditForPartialAnswers()
    {
        itemBankAssessmentController.setResponseScoreforMultiPort();
        itemBankAssessmentController.setResponseScoreforDragAndDropPartial();
    }
    public void validateEnterEdit()
    {
        try {
            DriverHelper.waitFluentByXPath(BrowserInitHelper.getInstance(), onlineTestingAdministrationPage.getOnlineTestingAdministrationGridSave());
            DriverHelper.clickXpath(onlineTestingAdministrationPage.getOnlineTestingAdministrationGridSave());
        } catch (Exception e) {
            System.out.println("Exception handled for save...");
        }
    }
    public void clickOnOverview()
    {
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
    public void validateScoreForCorrectAnswers()
    {
        DriverHelper.assertionText(onlineTestingAdministrationPage.getOnlineTestingAdministrationHundredPercent(), "100.0%");
        ConsoleLogger.SuccessLog("Verified for correct answers");
    }
    public void validateScoreForIncorrectAnswers()
    {
        DriverHelper.assertionText(onlineTestingAdministrationPage.getOnlineTestingAdministrationZeroPercent(), "0.0%");
        ConsoleLogger.SuccessLog("Verified for Wrong answer");
    }
    public void validateScoreForPartialAnswers()
    {
        DriverHelper.assertionText(onlineTestingAdministrationPage.getOnlineTestingAdministrationParcialPercent(), "57.1%");
        ConsoleLogger.SuccessLog("Verified for Partial answer");
    }
    public void removeStudentResponse()
    {
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
    public void clickOnOnlineTesting()
    {
        BrowserInitHelper.getWaiter().until(ExpectedConditions.elementToBeClickable(By.xpath(onlineTestingAdministrationPage.getOnlineTestingAdministrationAdministrationButton())));
        DriverHelper.clickXpath(onlineTestingAdministrationPage.getOnlineTestingAdministrationAdministrationButton());
        BrowserInitHelper.getWaiter().until(ExpectedConditions.elementToBeClickable(By.xpath(onlineTestingAdministrationPage.getOnlineTestingAdministrationOnlineTesting())));
        DriverHelper.clickXpath(onlineTestingAdministrationPage.getOnlineTestingAdministrationOnlineTesting());
    }
    public void validateOnlineTesting()
    {
        DriverHelper.awaitTillElementDisplayed(itemBankAssessmentPagePOM.getTestWithQuickCodeButton(), "TestWithQuickCodeButton");
        BrowserInitHelper.getWaiter().until(ExpectedConditions.elementToBeClickable(By.xpath(itemBankAssessmentPagePOM.getTestWithQuickCodeButton())));
    }
    public void clickFinishForCorrectAnswers()
    {
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
            //Enter answers from 1 to 5th question
            //Partial Answers
            itemBankAssessmentController.addAnswersToQuestions();
            // verifyAddedQuestionDisplay = true;



            /*Switch to PARENT Window*/
            BrowserInitHelper.getInstance().switchTo().window(parentWinHandle);
            BrowserInitHelper.getWaiter().until(ExpectedConditions.elementToBeClickable(By.xpath(itemBankAssessmentPagePOM.getCloseAccessPopup())));
            BrowserInitHelper.getInstance().findElement(By.xpath(itemBankAssessmentPagePOM.getCloseAccessPopup())).click();

        }
    }
    public  void clickFinishForWrongAnswers()
    {
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
}
