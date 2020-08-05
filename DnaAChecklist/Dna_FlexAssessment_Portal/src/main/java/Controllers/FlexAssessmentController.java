package Controllers;

import org.graphwalker.Helper;
import org.graphwalker.PageObjectModels.AnswerKey;
import org.graphwalker.PageObjectModels.FlexAnswerKeyPage;
import org.graphwalker.PageObjectModels.OnlineTestingAdministrationPage;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Controllers class for FlexAssessment
 **/
public class FlexAssessmentController {

    public static AnswerKey answerKey = new AnswerKey();
    public static FlexAnswerKeyPage flexAnswerKeyPage = new FlexAnswerKeyPage();

    // To add questions
    public static void addQuestions(int numberOfQuestions, WebDriverWait waiter, WebDriver driver) {
        Helper.clickXpath(answerKey.getAnswerKeyAddQuestions(), waiter, driver);
        Helper.sendKeysXpath(answerKey.getAnswerKeyQuestionQuantity(), Integer.toString(numberOfQuestions), waiter, driver);
        Helper.clickXpath(answerKey.getAnswerKeyAddButton(), waiter, driver);
    }

    // To add multiple choice
    public static void addMultipleChoice(int questionNumber, String answerChoice, WebDriverWait waiter, WebDriver driver) {
        Helper.clickXpath("//tr[" + Integer.toString(questionNumber) + "]//td[1]//span[@class='choice'][contains(text(),'" + answerChoice + "')]", waiter, driver);
        Helper.clickXpath("//tr[" + Integer.toString(questionNumber) + "]/td[1]/tr[1]/td[5]/span[1]/div[1]/button[1]", waiter, driver);
        Helper.clickXpath("//tr[" + Integer.toString(questionNumber) + "]/td[1]/tr[1]/td[5]/span[1]/div[1]/div[1]/ul[1]/li[2]", waiter, driver);
        Helper.clickXpath("//tr[" + Integer.toString(questionNumber) + "]/td[1]/tr[1]/td[6]/span[1]/div[1]", waiter, driver);
        Helper.clickXpath("//tr[" + Integer.toString(questionNumber) + "]/td[1]/tr[1]/td[6]/span[1]/div[1]/div[1]/ul[1]/li[2]", waiter, driver);
    }

    // To add Multiple Choice Partial Credit
    public static void addMultipleChoicePartialCredit(int questionNumber, String answerChoice, WebDriverWait waiter, WebDriver driver) {
        Helper.clickXpath("//tr[" + Integer.toString(questionNumber) + "]//td[2]//button[1]//i", waiter, driver);
        Helper.clickXpath("//tr[" + Integer.toString(questionNumber) + "]//span[contains(text(),'Multiple Choice Partial Credit (MC Ptl)')]", waiter, driver);
        Helper.clickXpath("//tr[" + Integer.toString(questionNumber) + "]//td[1]//span[@class='choice'][contains(text(),'" + answerChoice + "')]", waiter, driver);
        Helper.clickXpath("//tr[" + Integer.toString(questionNumber) + "]/td[1]/tr[1]/td[5]/span[1]/div[1]", waiter, driver);
        Helper.clickXpath("//tr[" + Integer.toString(questionNumber) + "]/td[1]/tr[1]/td[5]/span[1]/div[1]/div[1]/ul[1]/li[2]", waiter, driver);
        Helper.clickXpath("//tr[" + Integer.toString(questionNumber) + "]/td[1]/tr[1]/td[6]/span[1]/div[1]", waiter, driver);
        Helper.clickXpath("//tr[" + Integer.toString(questionNumber) + "]/td[1]/tr[1]/td[6]/span[1]/div[1]/div[1]/ul[1]/li[2]", waiter, driver);
    }

    public static void clearPopUpInAnswerKeyPage(WebDriverWait waiter, WebDriver driver) {
        try {
            Helper.wait(5.0);
            Helper.clickXpath(flexAnswerKeyPage.getFlexAnswerKeyCloseButton(), waiter, driver);
        } catch (Exception e) {
            System.out.println("Exception handled add questions popup");
        }
    }

    // To add Constructed Response
    public static void addConstructedResponse(int questionNumber, WebDriverWait waiter, WebDriver driver) {
        Helper.clickXpath("//tr[" + Integer.toString(questionNumber) + "]//td[2]//button[1]//i", waiter, driver);
        Helper.clickXpath("//tr[" + Integer.toString(questionNumber) + "]//span[contains(text(),'Constructed Response (CR)')]", waiter, driver);
        Helper.clickXpath("//tr[" + Integer.toString(questionNumber) + "]/td[1]/tr[1]/td[5]/span[1]/div[1]", waiter, driver);
        Helper.clickXpath("//tr[" + Integer.toString(questionNumber) + "]/td[1]/tr[1]/td[5]/span[1]/div[1]/div[1]/ul[1]/li[2]", waiter, driver);
        Helper.clickXpath("//tr[" + Integer.toString(questionNumber) + "]/td[1]/tr[1]/td[6]/span[1]/div[1]", waiter, driver);
        Helper.clickXpath("//tr[" + Integer.toString(questionNumber) + "]/td[1]/tr[1]/td[6]/span[1]/div[1]/div[1]/ul[1]/li[2]", waiter, driver);
    }

    // To add Explicit Constructed Response
    public static void addExplicitConstructedResponse(int questionNumber, WebDriverWait waiter, WebDriver driver) {
        Helper.clickXpath("//tr[" + Integer.toString(questionNumber) + "]//td[2]//button[1]//i", waiter, driver);
        Helper.clickXpath("//tr[" + Integer.toString(questionNumber) + "]//span[contains(text(),'Explicit Constructed Response (CR Exp)')]", waiter, driver);
        Helper.clickXpath(answerKey.getExplicitConstructedResponseAddIcon(), waiter, driver);
        Helper.sendKeysXpath(answerKey.getExplicitConstructedResponseFirstInput(), "co", waiter, driver);
        Helper.sendKeysXpath(answerKey.getExplicitConstructedResponseSecondInput(), "in", waiter, driver);
        Helper.clickXpath("//tr[" + Integer.toString(questionNumber) + "]/td[1]/tr[1]/td[5]/span[1]/div[1]", waiter, driver);
        Helper.clickXpath("//tr[" + Integer.toString(questionNumber) + "]/td[1]/tr[1]/td[5]/span[1]/div[1]/div[1]/ul[1]/li[2]", waiter, driver);
        Helper.clickXpath("//tr[" + Integer.toString(questionNumber) + "]/td[1]/tr[1]/td[6]/span[1]/div[1]", waiter, driver);
        Helper.clickXpath("//tr[" + Integer.toString(questionNumber) + "]/td[1]/tr[1]/td[6]/span[1]/div[1]/div[1]/ul[1]/li[2]", waiter, driver);
    }

    // To add Constructed Response Advanced
    public static void addConstructedResponseAdvanced(int questionNumber, WebDriverWait waiter, WebDriver driver) {
        WebElement element = driver.findElement(By.xpath("//tr[" + Integer.toString(questionNumber) + "]//td[2]//button[1]//i"));
        Actions actions = new Actions(driver);
        actions.moveToElement(element);
        actions.click();
        actions.build().perform();

        JavascriptExecutor js = ((JavascriptExecutor) driver);
        js.executeScript("window.scrollTo(0, document.body.scrollHeight)");

        element = driver.findElement(By.xpath("//tr[" + Integer.toString(questionNumber) + "]//span[contains(text(),'Constructed Response (CR Adv)')]"));
        actions.moveToElement(element);
        actions.click();
        actions.build().perform();

        Helper.clickXpath("//tr[" + Integer.toString(questionNumber) + "]/td[1]/tr[1]/td[5]/span[1]/div[1]", waiter, driver);
        Helper.clickXpath("//tr[" + Integer.toString(questionNumber) + "]/td[1]/tr[1]/td[5]/span[1]/div[1]/div[1]/ul[1]/li[2]", waiter, driver);
        Helper.clickXpath("//tr[" + Integer.toString(questionNumber) + "]/td[1]/tr[1]/td[6]/span[1]/div[1]", waiter, driver);
        Helper.clickXpath("//tr[" + Integer.toString(questionNumber) + "]/td[1]/tr[1]/td[6]/span[1]/div[1]/div[1]/ul[1]/li[2]", waiter, driver);
    }

    // To add Multiple Choice Advanced
    public static void addMultipleChoiceAdvanced(int questionNumber, String[] answerChoices, WebDriverWait waiter, WebDriver driver) {
        WebElement element = driver.findElement(By.xpath("//tr[" + Integer.toString(questionNumber) + "]//td[2]//button[1]//i"));
        Actions actions = new Actions(driver);
        actions.moveToElement(element);
        actions.click();
        actions.build().perform();

        JavascriptExecutor js = ((JavascriptExecutor) driver);
        js.executeScript("window.scrollTo(0, document.body.scrollHeight)");

        element = driver.findElement(By.xpath("//tr[" + Integer.toString(questionNumber) + "]//span[contains(text(),'Multiple Choice Advanced (MC Adv)')]"));
        actions.moveToElement(element);
        actions.click();
        actions.build().perform();

        Helper.clickXpath(answerKey.getMultipleChoiceAdvanced(), waiter, driver);

        for (int i = 0; i <= answerChoices.length - 1; i++) {
            Helper.clickXpath("//tr[" + Integer.toString(questionNumber) + "]//td[1]//div[@class='wrapper']//div[" + Integer.toString(i + 1) + "]//div[1]//span[@class='choice'][contains(text(),'" + answerChoices[i].toString() + "')]", waiter, driver);
        }
        Helper.clickXpath("//tr[" + Integer.toString(questionNumber) + "]/td[1]/tr[1]/td[5]/span[1]/div[1]", waiter, driver);
        Helper.clickXpath("//tr[" + Integer.toString(questionNumber) + "]/td[1]/tr[1]/td[5]/span[1]/div[1]/div[1]/ul[1]/li[2]", waiter, driver);
        Helper.clickXpath("//tr[" + Integer.toString(questionNumber) + "]/td[1]/tr[1]/td[6]/span[1]/div[1]", waiter, driver);
        Helper.clickXpath("//tr[" + Integer.toString(questionNumber) + "]/td[1]/tr[1]/td[6]/span[1]/div[1]/div[1]/ul[1]/li[2]", waiter, driver);
    }
}
