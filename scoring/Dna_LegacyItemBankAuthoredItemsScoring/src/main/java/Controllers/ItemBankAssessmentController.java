package Controllers;

import DataReaders.CSVDataReaderItemBankAssessment;
import DataReaders.CSVDataReaderScoring;
import Helpers.BrowserInitHelper;
import Helpers.DriverHelper;
import Helpers.JavascriptHelper;
import Pom.ItemBankAssessmentPage;
import Pom.OnlineTestingAdministrationPage;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.SourceType;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.lang.invoke.SwitchPoint;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import static Helpers.DriverHelper.refreshUntilElementAppears;

//controller class for ItemBank Assessment
public class ItemBankAssessmentController {
    public static ItemBankAssessmentPage itemBankAssessmentPage = new ItemBankAssessmentPage();
    JavascriptHelper helper = new JavascriptHelper();
    CSVDataReaderScoring csvDataReaderScoring=new CSVDataReaderScoring();
    CSVDataReaderItemBankAssessment csvDataReaderItemBankAssessment = new CSVDataReaderItemBankAssessment();
    ItemBankAssessmentPage itemBankAssessmentPagePOM = new ItemBankAssessmentPage();
    static OnlineTestingAdministrationPage onlineTestingAdministrationPage = new OnlineTestingAdministrationPage();
    public static String mainWindow;

    //ItemBankAssessmentController method
    public ItemBankAssessmentController() {


    }

    //method for get window handle
    public static void getWindowHandleAndSwitchWindow(WebDriver driver) {
        mainWindow = driver.getWindowHandle();
        Set<String> set = driver.getWindowHandles();

        Iterator<String> itr = set.iterator();
        while (itr.hasNext()) {
            String childWindow = itr.next();

            if (!mainWindow.equals(childWindow)) {
                driver.switchTo().window(childWindow);
            }
        }
    }

    //Method to add answers to questions
    public void addAnswersToQuestions() {
        // Question 1

        try {
            DriverHelper.awaitTillElementDisplayed("(//ie-word[contains(.,'"+csvDataReaderItemBankAssessment.getESRAnswerChoice()+"')])[1]", "First Answer");
            DriverHelper.clickXpath("(//ie-word[contains(.,'"+csvDataReaderItemBankAssessment.getESRAnswerChoice()+"')])[1]");

            DriverHelper.awaitTillElementDisplayed("(//ie-word[contains(.,'"+csvDataReaderItemBankAssessment.getESRSecondAnswerChoice()+"')])[2]", "First Answer");
            DriverHelper.clickXpath("(//ie-word[contains(.,'"+csvDataReaderItemBankAssessment.getESRSecondAnswerChoice()+"')])[2]");

            BrowserInitHelper.getWaiter().until(ExpectedConditions.visibilityOfElementLocated(By.xpath(itemBankAssessmentPage.getAnswerSavedMessage())));
            BrowserInitHelper.getWaiter().until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(itemBankAssessmentPage.getAnswerSavedMessage())));
        } catch (Exception e) {
            System.out.println("Exception handled for Question 1.....");
        }
        BrowserInitHelper.getWaiter().until(ExpectedConditions.elementToBeClickable(By.xpath(itemBankAssessmentPage.getItemBankAssessmentAddAnswers())));
        BrowserInitHelper.getInstance().findElement(By.xpath(itemBankAssessmentPage.getItemBankAssessmentAddAnswers())).click();
        //Question 2
        try {
            DriverHelper.awaitTillElementDisplayed("(//div[contains(@class,'lrn_tokenhighlight_text')]//span[contains(.,'While it is true that they are beautiful')])[1]", "Second Answer");
            String HighlightText=   BrowserInitHelper.getInstance().findElement(By.xpath("(//div[contains(@class,'lrn_tokenhighlight_text')]//span//span//span/span[contains(.,'While it is true that they are beautiful')])[1]")).getText();
            String[] questionTwo= HighlightText.split(",");
            System.out.println(questionTwo[0]+"before");
            CSVDataWriterScoringEvent.WriteCSV("HighlightSelectableText",questionTwo[0]);
            System.out.println(questionTwo[0]+"After");
            csvDataReaderScoring.getCsv();
            System.out.println(csvDataReaderScoring.getHighlettext());
            DriverHelper.clickXpath("(//div[contains(@class,'lrn_tokenhighlight_text')]//span//span//span/span[contains(.,'"+csvDataReaderScoring.getHighlettext()+"')])[1]");
            BrowserInitHelper.getWaiter().until(ExpectedConditions.visibilityOfElementLocated(By.xpath(itemBankAssessmentPage.getAnswerSavedMessage())));
            BrowserInitHelper.getWaiter().until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(itemBankAssessmentPage.getAnswerSavedMessage())));
        } catch (Exception e) {
            System.out.println("Exception handled for Question 2.....");
        }
        BrowserInitHelper.getWaiter().until(ExpectedConditions.elementToBeClickable(By.xpath(itemBankAssessmentPage.getItemBankAssessmentAddAnswers())));
        BrowserInitHelper.getInstance().findElement(By.xpath(itemBankAssessmentPage.getItemBankAssessmentAddAnswers())).click();
        //Question 3
        try {
            DriverHelper.awaitTillElementDisplayed(onlineTestingAdministrationPage.getOnlineTestingAdministrationMultiPart(), "Second Answer");
            String multiPart=   BrowserInitHelper.getInstance().findElement(By.xpath(onlineTestingAdministrationPage.getOnlineTestingAdministrationMultiPart())).getText();
        String[] thirdAnswer= multiPart.split(",");
            System.out.println(thirdAnswer[0]+"before");
            CSVDataWriterScoringEvent.WriteCSV("MultiPort",thirdAnswer[0]);
            System.out.println(thirdAnswer[0]+"after");
            DriverHelper.clickXpath("//div//div[@class='lrn_contentWrapper' and contains(.,'"+csvDataReaderScoring.getMultiPort()+"')]");
            BrowserInitHelper.getWaiter().until(ExpectedConditions.visibilityOfElementLocated(By.xpath(itemBankAssessmentPage.getAnswerSavedMessage())));
            BrowserInitHelper.getWaiter().until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(itemBankAssessmentPage.getAnswerSavedMessage())));
        } catch (Exception e) {
            System.out.println("Exception handled for Question 3.....");
        }
        BrowserInitHelper.getWaiter().until(ExpectedConditions.elementToBeClickable(By.xpath(itemBankAssessmentPage.getItemBankAssessmentAddAnswers())));
        BrowserInitHelper.getInstance().findElement(By.xpath(itemBankAssessmentPage.getItemBankAssessmentAddAnswers())).click();

        //Question 4
        try {
            DriverHelper.awaitTillElementDisplayed(onlineTestingAdministrationPage.getOnlineTestingAdministrationDragandDropClassifyAnswer(),"correct");
            WebElement ele1=BrowserInitHelper.getInstance().findElement(By.xpath(onlineTestingAdministrationPage.getOnlineTestingAdministrationDragandDropClassifyAnswer()));
            WebElement ele2=BrowserInitHelper.getInstance().findElement(By.xpath(onlineTestingAdministrationPage.getOnlineTestingAdministrationDragandDropClassifyCorrectAnswer()));
            Actions actions=new Actions(BrowserInitHelper.getInstance());
            actions.dragAndDrop(ele1,ele2).build().perform();
            BrowserInitHelper.getWaiter().until(ExpectedConditions.visibilityOfElementLocated(By.xpath(itemBankAssessmentPage.getAnswerSavedMessage())));
            BrowserInitHelper.getWaiter().until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(itemBankAssessmentPage.getAnswerSavedMessage())));
        } catch (Exception e) {
            System.out.println("Exception handled for Question 4.....");
        }
        BrowserInitHelper.getWaiter().until(ExpectedConditions.elementToBeClickable(By.xpath(itemBankAssessmentPage.getItemBankAssessmentAddAnswers())));
        BrowserInitHelper.getInstance().findElement(By.xpath(itemBankAssessmentPage.getItemBankAssessmentAddAnswers())).click();


        //Question 5
        try {
            DriverHelper.waitTill(2);
            DriverHelper.waitFluentByXPath(BrowserInitHelper.getInstance(),onlineTestingAdministrationPage.getOnlineTestingAdministrationDragAndDropFirstAnswer());
            WebElement from=BrowserInitHelper.getInstance().findElement(By.xpath(onlineTestingAdministrationPage.getOnlineTestingAdministrationDragAndDropFirstAnswer()));
            System.out.println(from);
            WebElement to=BrowserInitHelper.getInstance().findElement(By.xpath(onlineTestingAdministrationPage.getOnlineTestingAdministrationDragAndDropSecondAnswer()));
            System.out.println(to);
            Actions actions=new Actions(BrowserInitHelper.getInstance());
            System.out.println(from+"ele1");
            System.out.println(to+"ele2");
            actions.dragAndDrop(from,to).build().perform();
            System.out.println(from+"ele1"+to);

            DriverHelper.waitFluentByXPath(BrowserInitHelper.getInstance(),onlineTestingAdministrationPage.getOnlineTestingAdministrationDragAndDropSecondAnswer());
            WebElement fromele=BrowserInitHelper.getInstance().findElement(By.xpath(onlineTestingAdministrationPage.getOnlineTestingAdministrationDragAndDropSecondAnswer()));
            WebElement toele=BrowserInitHelper.getInstance().findElement(By.xpath(onlineTestingAdministrationPage.getOnlineTestingAdministrationDragAndDropThirdAnswer()));
            Actions actionsRepeate=new Actions(BrowserInitHelper.getInstance());
            actionsRepeate.dragAndDrop(fromele,toele).build().perform();
            BrowserInitHelper.getWaiter().until(ExpectedConditions.visibilityOfElementLocated(By.xpath(itemBankAssessmentPage.getAnswerSavedMessage())));

            BrowserInitHelper.getWaiter().until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(itemBankAssessmentPage.getAnswerSavedMessage())));

        } catch (Exception e) {
            System.out.println("Exception handled for Question 4.....");
        }



        //Review and Finish
        BrowserInitHelper.getWaiter().until(ExpectedConditions.elementToBeClickable(By.xpath(itemBankAssessmentPage.getTestReviewFinishButton())));
        DriverHelper.clickXpath(itemBankAssessmentPage.getTestReviewFinishButton());

        /*Click Finish in Confirmation page*/
        BrowserInitHelper.getWaiter().until(ExpectedConditions.elementToBeClickable(By.xpath(itemBankAssessmentPage.getConfirmFinishButton())));
        DriverHelper.clickXpath(itemBankAssessmentPage.getConfirmFinishButton());
        try
        {
            BrowserInitHelper.getWaiter().until(ExpectedConditions.elementToBeClickable(By.xpath(onlineTestingAdministrationPage.getOnlineTestingAdministrationConfirmFinish())));
            DriverHelper.clickXpath(onlineTestingAdministrationPage.getOnlineTestingAdministrationConfirmFinish());
        }
        catch(Exception e)
        {
            System.out.println("popup cleared");
        }

        /*Validate the display of Test Completed message*/
        BrowserInitHelper.getWaiter().until(ExpectedConditions.elementToBeClickable(By.xpath(itemBankAssessmentPage.getCompletedTestLabel())));
    }

    public void addAnswersToQuestionsforPartial() {
        // Question 1

        try {
            DriverHelper.awaitTillElementDisplayed("(//ie-word[contains(.,'"+csvDataReaderItemBankAssessment.getESRAnswerChoice()+"')])[1]", "First Answer");
            DriverHelper.clickXpath("(//ie-word[contains(.,'"+csvDataReaderItemBankAssessment.getESRAnswerChoice()+"')])[1]");

            DriverHelper.awaitTillElementDisplayed("(//ie-word[contains(.,'"+csvDataReaderItemBankAssessment.getESRSecondAnswerChoice()+"')])[2]", "First Answer");
            DriverHelper.clickXpath("(//ie-word[contains(.,'"+csvDataReaderItemBankAssessment.getESRSecondAnswerChoice()+"')])[2]");

            BrowserInitHelper.getWaiter().until(ExpectedConditions.visibilityOfElementLocated(By.xpath(itemBankAssessmentPage.getAnswerSavedMessage())));
            BrowserInitHelper.getWaiter().until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(itemBankAssessmentPage.getAnswerSavedMessage())));
        } catch (Exception e) {
            System.out.println("Exception handled for Question 1.....");
        }
        BrowserInitHelper.getWaiter().until(ExpectedConditions.elementToBeClickable(By.xpath(itemBankAssessmentPage.getItemBankAssessmentAddAnswers())));
        BrowserInitHelper.getInstance().findElement(By.xpath(itemBankAssessmentPage.getItemBankAssessmentAddAnswers())).click();

     //question 2
        try {
            DriverHelper.awaitTillElementDisplayed(onlineTestingAdministrationPage.getOnlineTestingAdministrationHighlightSelectableText(), "Second Answer");
            String HighlightText=   BrowserInitHelper.getInstance().findElement(By.xpath(onlineTestingAdministrationPage.getOnlineTestingAdministrationHighlightSelectableText())).getText();
        String[] questionTwo= HighlightText.split(",");
            System.out.println(questionTwo[0]+"before");
            CSVDataWriterScoringEvent.WriteCSV("HighlightSelectableText",questionTwo[0]);
            System.out.println(questionTwo[0]+"After");
            csvDataReaderScoring.getCsv();
            System.out.println(csvDataReaderScoring.getHighlettext());
            DriverHelper.clickXpath("(//div[contains(@class,'lrn_tokenhighlight_text')]//span//span//span/span[contains(.,'"+csvDataReaderScoring.getHighlettext()+"')])[1]");
            BrowserInitHelper.getWaiter().until(ExpectedConditions.visibilityOfElementLocated(By.xpath(itemBankAssessmentPage.getAnswerSavedMessage())));
            BrowserInitHelper.getWaiter().until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(itemBankAssessmentPage.getAnswerSavedMessage())));
        } catch (Exception e) {
            System.out.println("Exception handled for Question 2.....");
        }
        BrowserInitHelper.getWaiter().until(ExpectedConditions.elementToBeClickable(By.xpath(itemBankAssessmentPage.getItemBankAssessmentAddAnswers())));
        BrowserInitHelper.getInstance().findElement(By.xpath(itemBankAssessmentPage.getItemBankAssessmentAddAnswers())).click();


        //Question 3
        try {
            DriverHelper.awaitTillElementDisplayed(onlineTestingAdministrationPage.getOnlineTestingAdministrationMultiPart(), "Second Answer");
            String multiPart=   BrowserInitHelper.getInstance().findElement(By.xpath(onlineTestingAdministrationPage.getOnlineTestingAdministrationMultiPart())).getText();
            String[] thirdAnswer= multiPart.split(",");
            System.out.println(thirdAnswer[0]+"before");
            CSVDataWriterScoringEvent.WriteCSV("MultiPort",thirdAnswer[0]);
            System.out.println(thirdAnswer[0]+"after");
            DriverHelper.clickXpath("//div//div[@class='lrn_contentWrapper' and contains(.,'"+csvDataReaderScoring.getMultiPort()+"')]");
            BrowserInitHelper.getWaiter().until(ExpectedConditions.visibilityOfElementLocated(By.xpath(itemBankAssessmentPage.getAnswerSavedMessage())));
            BrowserInitHelper.getWaiter().until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(itemBankAssessmentPage.getAnswerSavedMessage())));
        } catch (Exception e) {
            System.out.println("Exception handled for Question 3.....");
        }
        BrowserInitHelper.getWaiter().until(ExpectedConditions.elementToBeClickable(By.xpath(itemBankAssessmentPage.getItemBankAssessmentAddAnswers())));
        BrowserInitHelper.getInstance().findElement(By.xpath(itemBankAssessmentPage.getItemBankAssessmentAddAnswers())).click();

        //Question 4
        try {

            DriverHelper.awaitTillElementDisplayed(onlineTestingAdministrationPage.getOnlineTestingAdministrationDragandDropClassifyAnswer(),"Question 4");
            WebElement ele1=BrowserInitHelper.getInstance().findElement(By.xpath(onlineTestingAdministrationPage.getOnlineTestingAdministrationDragandDropClassifyAnswer()));
            WebElement ele2=BrowserInitHelper.getInstance().findElement(By.xpath(onlineTestingAdministrationPage.getOnlineTestingAdministrationDragandDropClassifyIncorrect()));
            Actions actions=new Actions(BrowserInitHelper.getInstance());
            actions.dragAndDrop(ele1,ele2).build().perform();
            BrowserInitHelper.getWaiter().until(ExpectedConditions.visibilityOfElementLocated(By.xpath(itemBankAssessmentPage.getAnswerSavedMessage())));
            BrowserInitHelper.getWaiter().until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(itemBankAssessmentPage.getAnswerSavedMessage())));
        } catch (Exception e) {
            System.out.println("Exception handled for Question 4.....");
        }


        BrowserInitHelper.getWaiter().until(ExpectedConditions.elementToBeClickable(By.xpath(itemBankAssessmentPage.getItemBankAssessmentAddAnswers())));
        BrowserInitHelper.getInstance().findElement(By.xpath(itemBankAssessmentPage.getItemBankAssessmentAddAnswers())).click();
//question 5
        try {
            DriverHelper.waitTill(2);
            DriverHelper.waitFluentByXPath(BrowserInitHelper.getInstance(),onlineTestingAdministrationPage.getOnlineTestingAdministrationDragAndDropFirstAnswer());
            WebElement from=BrowserInitHelper.getInstance().findElement(By.xpath(onlineTestingAdministrationPage.getOnlineTestingAdministrationDragAndDropFirstAnswer()));
            System.out.println(from);
            WebElement to=BrowserInitHelper.getInstance().findElement(By.xpath(onlineTestingAdministrationPage.getOnlineTestingAdministrationDragAndDropThirdAnswer()));
            System.out.println(to);
            Actions actions=new Actions(BrowserInitHelper.getInstance());
            System.out.println(from+"ele1");
            System.out.println(to+"ele2");
            actions.dragAndDrop(from,to).build().perform();
            System.out.println(from+"ele1"+to);

            DriverHelper.waitFluentByXPath(BrowserInitHelper.getInstance(),onlineTestingAdministrationPage.getOnlineTestingAdministrationDragAndDropThirdAnswer());
            WebElement fromele=BrowserInitHelper.getInstance().findElement(By.xpath(onlineTestingAdministrationPage.getOnlineTestingAdministrationDragAndDropThirdAnswer()));
            WebElement toele=BrowserInitHelper.getInstance().findElement(By.xpath(onlineTestingAdministrationPage.getOnlineTestingAdministrationDragAndDropSecondAnswer()));
            Actions actionsRepeate=new Actions(BrowserInitHelper.getInstance());
            actionsRepeate.dragAndDrop(fromele,toele).build().perform();
            BrowserInitHelper.getWaiter().until(ExpectedConditions.visibilityOfElementLocated(By.xpath(itemBankAssessmentPage.getAnswerSavedMessage())));

            BrowserInitHelper.getWaiter().until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(itemBankAssessmentPage.getAnswerSavedMessage())));

        } catch (Exception e) {
            System.out.println("Exception handled for Question 4.....");
        }

        //Answer and assert questions

        //Review and Finish
        BrowserInitHelper.getWaiter().until(ExpectedConditions.elementToBeClickable(By.xpath(itemBankAssessmentPage.getTestReviewFinishButton())));
        DriverHelper.clickXpath(itemBankAssessmentPage.getTestReviewFinishButton());

        /*Click Finish in Confirmation page*/
        BrowserInitHelper.getWaiter().until(ExpectedConditions.elementToBeClickable(By.xpath(itemBankAssessmentPage.getConfirmFinishButton())));
        DriverHelper.clickXpath(itemBankAssessmentPage.getConfirmFinishButton());
        try {
            DriverHelper.clickXpath(onlineTestingAdministrationPage.getOnlineTestingAdministrationOnlineTestingfinish());
        } catch (Exception e) {
            System.out.println("Exception handled");
        }
        /*Validate the display of Test Completed message*/
        BrowserInitHelper.getWaiter().until(ExpectedConditions.elementToBeClickable(By.xpath(itemBankAssessmentPage.getCompletedTestLabel())));
    }

    public void addAnswersToQuestionsforIncorrect() {
        // Question 1

        try {
            DriverHelper.awaitTillElementDisplayed("(//ie-word[contains(.,'"+csvDataReaderItemBankAssessment.getESRSecondAnswerChoice()+"')])[1]", "First Answer");
            DriverHelper.clickXpath("(//ie-word[contains(.,'"+csvDataReaderItemBankAssessment.getESRSecondAnswerChoice()+"')])[1]");

            DriverHelper.awaitTillElementDisplayed("(//ie-word[contains(.,'"+csvDataReaderItemBankAssessment.getESRAnswerChoice()+"')])[2]", "First Answer");
            DriverHelper.clickXpath("(//ie-word[contains(.,'"+csvDataReaderItemBankAssessment.getESRAnswerChoice()+"')])[2]");

            BrowserInitHelper.getWaiter().until(ExpectedConditions.visibilityOfElementLocated(By.xpath(itemBankAssessmentPage.getAnswerSavedMessage())));
            BrowserInitHelper.getWaiter().until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(itemBankAssessmentPage.getAnswerSavedMessage())));
        } catch (Exception e) {
            System.out.println("Exception handled for Question 1.....");
        }
        BrowserInitHelper.getWaiter().until(ExpectedConditions.elementToBeClickable(By.xpath(itemBankAssessmentPage.getItemBankAssessmentAddAnswers())));
        BrowserInitHelper.getInstance().findElement(By.xpath(itemBankAssessmentPage.getItemBankAssessmentAddAnswers())).click();
        //Question 2
        try {
            DriverHelper.awaitTillElementDisplayed("(//div[contains(@class,'lrn_tokenhighlight_text')]//span[contains(.,'While it is true that they are beautiful')])[1]", "Second Answer");
            String HighlightText=   BrowserInitHelper.getInstance().findElement(By.xpath("(//div[contains(@class,'lrn_tokenhighlight_text')]//span//span//span/span[contains(.,'While it is true that they are beautiful')])[1]")).getText();
            String[] questionTwo= HighlightText.split(",");
            System.out.println(questionTwo[0]+"before");
            CSVDataWriterScoringEvent.WriteCSV("HighlightSelectableText",questionTwo[0]);
            System.out.println(questionTwo[0]+"After");
            csvDataReaderScoring.getCsv();
            System.out.println(csvDataReaderScoring.getHighlettext());
            DriverHelper.clickXpath("(//div[contains(@class,'lrn_tokenhighlight_text')]//span//span//span/span[contains(.,'"+csvDataReaderScoring.getHighlettext()+"')])[1]");
            BrowserInitHelper.getWaiter().until(ExpectedConditions.visibilityOfElementLocated(By.xpath(itemBankAssessmentPage.getAnswerSavedMessage())));
            BrowserInitHelper.getWaiter().until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(itemBankAssessmentPage.getAnswerSavedMessage())));
        } catch (Exception e) {
            System.out.println("Exception handled for Question 2.....");
        }
        BrowserInitHelper.getWaiter().until(ExpectedConditions.elementToBeClickable(By.xpath(itemBankAssessmentPage.getItemBankAssessmentAddAnswers())));
        BrowserInitHelper.getInstance().findElement(By.xpath(itemBankAssessmentPage.getItemBankAssessmentAddAnswers())).click();

//question 3
        try {
            DriverHelper.awaitTillElementDisplayed(onlineTestingAdministrationPage.getOnlineTestingAdministrationMultiPartWrongAnswer(), "Second Answer");
            String multiPart=   BrowserInitHelper.getInstance().findElement(By.xpath(onlineTestingAdministrationPage.getOnlineTestingAdministrationMultiPartWrongAnswer())).getText();
            String[] thirdAnswer= multiPart.split(",");
            System.out.println(thirdAnswer[0]+"before");
            CSVDataWriterScoringEvent.WriteCSV("MultiPartWrongAnswer",thirdAnswer[0]);
            System.out.println(thirdAnswer[0]+"after");
            DriverHelper.clickXpath("//div//div[@class='lrn_contentWrapper' and contains(.,'"+csvDataReaderScoring.getMultiPortWrongAnswer()+"')]");
            BrowserInitHelper.getWaiter().until(ExpectedConditions.visibilityOfElementLocated(By.xpath(itemBankAssessmentPage.getAnswerSavedMessage())));
            BrowserInitHelper.getWaiter().until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(itemBankAssessmentPage.getAnswerSavedMessage())));
        } catch (Exception e) {
            System.out.println("Exception handled for Question 3.....");
        }
        BrowserInitHelper.getWaiter().until(ExpectedConditions.elementToBeClickable(By.xpath(itemBankAssessmentPage.getItemBankAssessmentAddAnswers())));
        BrowserInitHelper.getInstance().findElement(By.xpath(itemBankAssessmentPage.getItemBankAssessmentAddAnswers())).click();

        //Question 4
        try {
            DriverHelper.awaitTillElementDisplayed(onlineTestingAdministrationPage.getOnlineTestingAdministrationDragandDropClassifyAnswer(),"Question 4");
            Actions actions=new Actions(BrowserInitHelper.getInstance());
            WebElement ele1=BrowserInitHelper.getInstance().findElement(By.xpath(onlineTestingAdministrationPage.getOnlineTestingAdministrationDragandDropClassifyAnswer()));
            WebElement ele2=BrowserInitHelper.getInstance().findElement(By.xpath(onlineTestingAdministrationPage.getOnlineTestingAdministrationDragandDropClassifyIncorrect()));
            actions.dragAndDrop(ele1,ele2).build().perform();
            BrowserInitHelper.getWaiter().until(ExpectedConditions.visibilityOfElementLocated(By.xpath(itemBankAssessmentPage.getAnswerSavedMessage())));
            BrowserInitHelper.getWaiter().until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(itemBankAssessmentPage.getAnswerSavedMessage())));
        } catch (Exception e) {
            System.out.println("Exception handled for Question 4.....");
        }

        BrowserInitHelper.getWaiter().until(ExpectedConditions.elementToBeClickable(By.xpath(itemBankAssessmentPage.getItemBankAssessmentAddAnswers())));
        BrowserInitHelper.getInstance().findElement(By.xpath(itemBankAssessmentPage.getItemBankAssessmentAddAnswers())).click();

        //Question 5
        //question 5
        try {
            DriverHelper.awaitTillElementDisplayed(onlineTestingAdministrationPage.getOnlineTestingAdministrationDragAndDropFirstAnswer(),"Question 5");
            DriverHelper.waitFluentByXPath(BrowserInitHelper.getInstance(),onlineTestingAdministrationPage.getOnlineTestingAdministrationDragAndDropFirstAnswer());
            WebElement from=BrowserInitHelper.getInstance().findElement(By.xpath(onlineTestingAdministrationPage.getOnlineTestingAdministrationDragAndDropFirstAnswer()));
            System.out.println(from);
            WebElement to=BrowserInitHelper.getInstance().findElement(By.xpath(onlineTestingAdministrationPage.getOnlineTestingAdministrationDragAndDropThirdAnswer()));
            System.out.println(to);
            Actions actions=new Actions(BrowserInitHelper.getInstance());
            System.out.println(from+"ele1");
            System.out.println(to+"ele2");
            actions.dragAndDrop(from,to).build().perform();
            System.out.println(from+"ele1"+to);

            DriverHelper.waitFluentByXPath(BrowserInitHelper.getInstance(),onlineTestingAdministrationPage.getOnlineTestingAdministrationDragAndDropThirdAnswer());
            WebElement fromele=BrowserInitHelper.getInstance().findElement(By.xpath(onlineTestingAdministrationPage.getOnlineTestingAdministrationDragAndDropThirdAnswer()));
            WebElement toele=BrowserInitHelper.getInstance().findElement(By.xpath(onlineTestingAdministrationPage.getOnlineTestingAdministrationDragAndDropSecondAnswer()));
            Actions actionsRepeate=new Actions(BrowserInitHelper.getInstance());
            actionsRepeate.dragAndDrop(fromele,toele).build().perform();
            BrowserInitHelper.getWaiter().until(ExpectedConditions.visibilityOfElementLocated(By.xpath(itemBankAssessmentPage.getAnswerSavedMessage())));

            BrowserInitHelper.getWaiter().until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(itemBankAssessmentPage.getAnswerSavedMessage())));

        } catch (Exception e) {
            System.out.println("Exception handled for Question 4.....");
        }

        //Answer and assert questions

        //Review and Finish
        BrowserInitHelper.getWaiter().until(ExpectedConditions.elementToBeClickable(By.xpath(itemBankAssessmentPage.getTestReviewFinishButton())));
        DriverHelper.clickXpath(itemBankAssessmentPage.getTestReviewFinishButton());

        /*Click Finish in Confirmation page*/
        BrowserInitHelper.getWaiter().until(ExpectedConditions.elementToBeClickable(By.xpath(itemBankAssessmentPage.getConfirmFinishButton())));
        DriverHelper.clickXpath(itemBankAssessmentPage.getConfirmFinishButton());
        try {
            DriverHelper.clickXpath(onlineTestingAdministrationPage.getOnlineTestingAdministrationOnlineTestingfinish());
        } catch (Exception e) {
            System.out.println("Exception handled");
        }
        /*Validate the display of Test Completed message*/
        BrowserInitHelper.getWaiter().until(ExpectedConditions.elementToBeClickable(By.xpath(itemBankAssessmentPage.getCompletedTestLabel())));
    }

    //method to add answers to questions when Deleted
    public void addAnswersToQuestionsWhenDeleted() {
        //Answer and assert questions
        //Question - 1
        try {
            String question1 = "(//h4[contains(text(), 'Question 1')]/following::input[@id='answer_choice_multi_0']/following::ie-word[.='" + csvDataReaderItemBankAssessment.getAnswerChoice() + "'])[1]";
            DriverHelper.awaitTillElementDisplayed(question1, "Question 1 - method addAnswersToQuestionsWhenDeleted");
            BrowserInitHelper.getInstance().findElement(By.xpath(question1)).click();
            BrowserInitHelper.getWaiter().until(ExpectedConditions.visibilityOfElementLocated(By.xpath(itemBankAssessmentPage.getAnswerSavedMessage())));
            BrowserInitHelper.getWaiter().until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(itemBankAssessmentPage.getAnswerSavedMessage())));
        } catch (Exception e) {
            System.out.println("Exception handled.....");
        }

        BrowserInitHelper.getWaiter().until(ExpectedConditions.elementToBeClickable(By.xpath(itemBankAssessmentPage.getItemBankAssessmentAddAnswers())));
        BrowserInitHelper.getInstance().findElement(By.xpath(itemBankAssessmentPage.getItemBankAssessmentAddAnswers())).click();

        //Question - 2
        try {
            String question2 = "(//h4[contains(text(), 'Question 2')]/following::input[@id='answer_choice_multi_0']/following::ie-word[.='" + csvDataReaderItemBankAssessment.getSecondAnswer() + "'])[1]";
            DriverHelper.awaitTillElementDisplayed(question2, "Question 2 - method addAnswersToQuestionsWhenDeleted");
            BrowserInitHelper.getInstance().findElement(By.xpath(question2)).click();
            BrowserInitHelper.getWaiter().until(ExpectedConditions.visibilityOfElementLocated(By.xpath(itemBankAssessmentPage.getAnswerSavedMessage())));
            BrowserInitHelper.getWaiter().until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(itemBankAssessmentPage.getAnswerSavedMessage())));
        } catch (Exception e) {
            System.out.println("Exception handled.....");
        }

        //Review and Finish
        BrowserInitHelper.getWaiter().until(ExpectedConditions.elementToBeClickable(By.xpath(itemBankAssessmentPage.getTestReviewFinishButton())));
        DriverHelper.clickXpath(itemBankAssessmentPage.getTestReviewFinishButton());

        /*Click Finish in Confirmation page*/
        BrowserInitHelper.getWaiter().until(ExpectedConditions.elementToBeClickable(By.xpath(itemBankAssessmentPage.getConfirmFinishButton())));
        DriverHelper.clickXpath(itemBankAssessmentPage.getConfirmFinishButton());

        /*Validate the display of Test Completed message*/
        BrowserInitHelper.getWaiter().until(ExpectedConditions.elementToBeClickable(By.xpath(itemBankAssessmentPage.getCompletedTestLabel())));
    }

    public void updateFilterSearchItem() {

        BrowserInitHelper.getInstance().findElement(By.xpath(itemBankAssessmentPagePOM.getItemBankAssessmentUpdatefilters())).click();

        //Items Load
        try {
            DriverHelper.awaitTillElementDisplayed(itemBankAssessmentPagePOM.getItemBankAssessmentItemSearchResults(), "ItemBankAssessment Item Search Results");
        } catch (Exception e) {
            BrowserInitHelper.getWaiter().until(ExpectedConditions.visibilityOfElementLocated(By.xpath(itemBankAssessmentPage.getCreateItemNoItemsFound())));
        }
        BrowserInitHelper.getWaiter().until(ExpectedConditions.visibilityOfElementLocated(By.xpath(itemBankAssessmentPagePOM.getItemBankAssessmentItemSearchResults())));
        JavascriptHelper.scrollintoViewXpath(itemBankAssessmentPagePOM.getItemBankAssessmentSearchResults());
    }

    public static void setResponseScoreforMultiPort() {
        DriverHelper.waitTill(2);
        Actions actions = new Actions(BrowserInitHelper.getInstance());
        WebElement element = BrowserInitHelper.getWaiter().until(ExpectedConditions.visibilityOfElementLocated(By.xpath(onlineTestingAdministrationPage.getOnlineTestingAdministrationMultiPort())));
        actions.moveToElement(element);
        actions.click();
        actions.click();
        actions.build().perform();

        element = BrowserInitHelper.getWaiter().until(ExpectedConditions.visibilityOfElementLocated(By.xpath(onlineTestingAdministrationPage.getOnlineTestingAdministrationMultiPortCorrect())));
        actions.moveToElement(element);
        actions.click();
        actions.build().perform();
    }

    public static void setResponseScoreforDragAndDrop() {
        DriverHelper.waitTill(2);
        Actions actions = new Actions(BrowserInitHelper.getInstance());
        WebElement element = BrowserInitHelper.getWaiter().until(ExpectedConditions.visibilityOfElementLocated(By.xpath(onlineTestingAdministrationPage.getOnlineTestingAdministrationDragAndDrop())));
        actions.moveToElement(element);
        actions.click();
        actions.click();
        actions.build().perform();

        element = BrowserInitHelper.getWaiter().until(ExpectedConditions.visibilityOfElementLocated(By.xpath(onlineTestingAdministrationPage.getOnlineTestingAdministrationDragAndDropCorrect())));
        actions.moveToElement(element);
        actions.click();
        actions.build().perform();
    }
    public static void setResponseScoreforDragAndDropPartial() {
        DriverHelper.waitTill(2);
        Actions actions = new Actions(BrowserInitHelper.getInstance());
        WebElement element = BrowserInitHelper.getWaiter().until(ExpectedConditions.visibilityOfElementLocated(By.xpath(onlineTestingAdministrationPage.getOnlineTestingAdministrationWrongAnswerDragClassify())));
        actions.moveToElement(element);
        actions.click();
        actions.click();
        actions.build().perform();

        element = BrowserInitHelper.getWaiter().until(ExpectedConditions.visibilityOfElementLocated(By.xpath(onlineTestingAdministrationPage.getOnlineTestingAdministrationWrongAnswerDragPartial())));
        actions.moveToElement(element);
        actions.click();
        actions.build().perform();
    }
    public void refreshPageUntilStudentListAppears() {
        refreshUntilElementAppears("(//a[@title='Student List']//span[contains(.,'1')])[1]");
    }
    public static void setResponseScoreforDragAndDropOrder() {
        DriverHelper.waitTill(2);
        Actions actions = new Actions(BrowserInitHelper.getInstance());
        WebElement element = BrowserInitHelper.getWaiter().until(ExpectedConditions.visibilityOfElementLocated(By.xpath(onlineTestingAdministrationPage.getOnlineTestingAdministrationDragAndDropOrder())));
        actions.moveToElement(element);
        actions.click();
        actions.click();
        actions.build().perform();

        element = BrowserInitHelper.getWaiter().until(ExpectedConditions.visibilityOfElementLocated(By.xpath(onlineTestingAdministrationPage.getOnlineTestingAdministrationDragAndDropOrderCorrect())));
        actions.moveToElement(element);
        actions.click();
        actions.build().perform();
    }
    public static void setResponseScoreforSelectHighlight() {
        DriverHelper.waitTill(2);
        Actions actions = new Actions(BrowserInitHelper.getInstance());
        WebElement element = BrowserInitHelper.getWaiter().until(ExpectedConditions.visibilityOfElementLocated(By.xpath(onlineTestingAdministrationPage.getOnlineTestingAdministrationSelectHighlight())));
        actions.moveToElement(element);
        actions.click();
        actions.click();
        actions.build().perform();

        element = BrowserInitHelper.getWaiter().until(ExpectedConditions.visibilityOfElementLocated(By.xpath(onlineTestingAdministrationPage.getOnlineTestingAdministrationSelectHighlightCorrect())));
        actions.moveToElement(element);
        actions.click();
        actions.build().perform();
    }
    public static void setResponseScoreforForWrongAnswer() {
        DriverHelper.waitTill(2);
        Actions actions = new Actions(BrowserInitHelper.getInstance());
        WebElement element = BrowserInitHelper.getWaiter().until(ExpectedConditions.visibilityOfElementLocated(By.xpath(onlineTestingAdministrationPage.getOnlineTestingAdministrationWrongAnswer())));
        actions.moveToElement(element);
        actions.click();
        actions.click();
        actions.build().perform();

        element = BrowserInitHelper.getWaiter().until(ExpectedConditions.visibilityOfElementLocated(By.xpath(onlineTestingAdministrationPage.getOnlineTestingAdministrationWrongAnswerForExplicitConstructiveResponse())));
        actions.moveToElement(element);
        actions.click();
        actions.build().perform();
    }

    public static void setResponseScoreforForWrongAnswerDrag() {
        DriverHelper.waitTill(2);
        Actions actions = new Actions(BrowserInitHelper.getInstance());
        WebElement element = BrowserInitHelper.getWaiter().until(ExpectedConditions.visibilityOfElementLocated(By.xpath(onlineTestingAdministrationPage.getOnlineTestingAdministrationWrongAnswerDrag())));
        actions.moveToElement(element);
        actions.click();
        actions.click();
        actions.build().perform();

        element = BrowserInitHelper.getWaiter().until(ExpectedConditions.visibilityOfElementLocated(By.xpath(onlineTestingAdministrationPage.getOnlineTestingAdministrationWrongAnswerForExplicitConstructiveResponse())));
        actions.moveToElement(element);
        actions.click();
        actions.build().perform();
    }
    public static void setResponseScoreforECRForWrongAnswer() {
        DriverHelper.waitTill(2);
        Actions actions = new Actions(BrowserInitHelper.getInstance());
        WebElement element = BrowserInitHelper.getWaiter().until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div//div[@id='grid-container']//tr//td[10]")));
        actions.moveToElement(element);
        actions.click();
        actions.click();
        actions.build().perform();

        element = BrowserInitHelper.getWaiter().until(ExpectedConditions.visibilityOfElementLocated(By.xpath(onlineTestingAdministrationPage.getOnlineTestingAdministrationWrongAnswerForExplicitConstructiveResponse())));
        actions.moveToElement(element);
        actions.click();
        actions.build().perform();
    }
    public static void setResponseScoreforHighlight() {
        DriverHelper.waitTill(2);
        Actions actions = new Actions(BrowserInitHelper.getInstance());
        WebElement element = BrowserInitHelper.getWaiter().until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div//div[@id='grid-container']//tr//td[6]")));
        actions.moveToElement(element);
        actions.click();
        actions.click();
        actions.build().perform();
        actions.sendKeys(Keys.BACK_SPACE);
        actions.sendKeys("AB");
    }
    public void fillUpStem(String text) {
        BrowserInitHelper.getWaiter().until(ExpectedConditions.elementToBeClickable(By.xpath(itemBankAssessmentPagePOM.getCreateItemStemFrame())));
        WebElement stemframe = BrowserInitHelper.getInstance().findElement(By.xpath(itemBankAssessmentPagePOM.getCreateItemStemFrame()));
        BrowserInitHelper.getInstance().switchTo().frame(stemframe);
        DriverHelper.sendKeysXpath(itemBankAssessmentPagePOM.getCreateItemStemBody(), text);
        BrowserInitHelper.getInstance().switchTo().defaultContent();
        //Click on Save & Continue
        DriverHelper.clickXpath(itemBankAssessmentPagePOM.getCreateItemSaveandContinue());
    }

    public void putAnswerChoices(int frameNo, String answer) {
        try {
            //correct answer choice
            WebElement answerFrame = BrowserInitHelper.getInstance().findElement(By.xpath("(//table[starts-with(@id,'choice_text')]//tbody//tr//iframe)[" + frameNo + "]"));
            String frameID = answerFrame.getAttribute("id");
            System.out.println("frameID-->" + frameID);
            BrowserInitHelper.getInstance().switchTo().frame(frameID);
            WebElement firstAnswerEditor = BrowserInitHelper.getInstance().findElement(By.xpath("//body"));
            JavascriptExecutor executor = (JavascriptExecutor) BrowserInitHelper.getInstance();
            executor.executeScript("arguments[0].click();", firstAnswerEditor);
            System.out.println("firstAnswerEditor is clicked...");
            firstAnswerEditor.sendKeys(answer);
            BrowserInitHelper.getInstance().switchTo().defaultContent();
        } catch (Exception e) {
            System.out.println("Exception Handled for item choice" + e);
        }
    }

    public void ItemCreationStep3() {
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
        DriverHelper.waitTill(2);
    }

    public void ItemCreationStep6() {
        DriverHelper.clickXpath(itemBankAssessmentPagePOM.getCreateItemStepSix());
        DriverHelper.clickXpath(itemBankAssessmentPagePOM.getCreateItemPublish());
    }

    public void constructedResponseChoiceCreation(int frameNo, String answer) {
        //Wait
        DriverHelper.waitFluentByXPath(BrowserInitHelper.getInstance(), "(//table[starts-with(@id,'rubric_level_text')])[" + frameNo + "]");
        System.out.println("After table is loaded......");
        WebElement answerFrame = BrowserInitHelper.getInstance().findElement(By.xpath("(//table[starts-with(@id,'rubric_level_text')]//tbody//iframe)[" + frameNo + "]"));
        String frameID = answerFrame.getAttribute("id");
        System.out.println("frameID-->" + frameID);
        BrowserInitHelper.getInstance().switchTo().frame(frameID);
        WebElement firstAnswerEditor = BrowserInitHelper.getInstance().findElement(By.xpath("//body"));
        JavascriptExecutor executor = (JavascriptExecutor) BrowserInitHelper.getInstance();
        executor.executeScript("arguments[0].click();", firstAnswerEditor);
        System.out.println("firstAnswerEditor is clicked...");
        firstAnswerEditor.sendKeys(answer);
        BrowserInitHelper.getInstance().switchTo().defaultContent();
    }

    public void removeRubricOption(int no) {
        DriverHelper.clickXpath(itemBankAssessmentPagePOM.getCreateItemRubricArrowUp());
        //for removing rubric option
        DriverHelper.clickXpath("(//div[@title='Remove Rubric Level'])[" + no + "]");
        DriverHelper.acceptAlert();
        DriverHelper.clickXpath("(//div[@title='Remove Rubric Level'])[" + no + "]");
        DriverHelper.acceptAlert();
    }

    public void selectItemBankCheckboxes() {
        JavascriptHelper.compareAndCheckElementById("filter_itembank_myitems", "TRUE");
        JavascriptHelper.compareAndCheckElementById("filter_itembank_1", "FALSE");
        JavascriptHelper.compareAndCheckElementById("filter_itembank_1502", "FALSE");
        JavascriptHelper.compareAndCheckElementById("filter_itembank_2", "FALSE");
        JavascriptHelper.compareAndCheckElementById("filter_itembank_976", "FALSE");
        JavascriptHelper.compareAndCheckElementById("filter_itembank_219", "FALSE");
    }

    public void createitem() {
        DriverHelper.clickXpath(itemBankAssessmentPagePOM.getCreateItemRadioButton());
        BrowserInitHelper.getInstance().findElement(By.xpath(itemBankAssessmentPagePOM.getCreateItemBankPopupNextButton())).click();
    }

    public void itemBankSelect() {
        List<WebElement> banks = BrowserInitHelper.getInstance().findElements(By.xpath("//label[@for='filter[itembank]']//following::input"));
        List<WebElement> label = BrowserInitHelper.getInstance().findElements(By.xpath("//label[@for='filter[itembank]']//following::label"));
        for (int i = 0; i < banks.size(); i++) {
            String elementID = banks.get(i).getAttribute("id");
            String elementValue = banks.get(i).getAttribute("value");
            System.out.println("elementID-->>" + elementID);
            String labelName = label.get(i).getText().trim();
            System.out.println("LabelName-->>" + labelName);

            //Unselect All
            JavascriptExecutor js = (JavascriptExecutor) BrowserInitHelper.getInstance();
            Object checkbox = js.executeScript("return !!jQuery(\"#" + elementID + "\").prop('checked');");

            if (checkbox.toString().equalsIgnoreCase("true")) {
                js.executeScript("return !!jQuery(\"#" + elementID + "\").click();");
                JavascriptHelper.scrolBottom();
                if (checkbox.toString().equalsIgnoreCase("true")) {
                    js.executeScript("return !!jQuery(\"#" + elementID + "\").click();");
                }
            }
            //Select public
            if (elementValue.equalsIgnoreCase("1") ) {
                js.executeScript("return !!jQuery(\"#" + elementID + "\").click();");

            }

        }

    }

    public void itemType(String itemType) {
        DriverHelper.awaitTillElementDisplayedByID(itemBankAssessmentPagePOM.getCreateItemItemtype(), "");
        WebElement itemtype = BrowserInitHelper.getInstance().findElement(By.id(itemBankAssessmentPagePOM.getCreateItemItemtype()));
        Select select = new Select(itemtype);
        select.selectByVisibleText(itemType);
    }
}
