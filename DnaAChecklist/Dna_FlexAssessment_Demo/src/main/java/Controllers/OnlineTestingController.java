package Controllers;

import org.graphwalker.Helper;
import org.graphwalker.PageObjectModels.OnlineTestingAdministrationPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Controllers class for OnlineTesting
 **/
public class OnlineTestingController {

    private static Actions actions;
    public static OnlineTestingAdministrationPage onlineTestingAdministrationPage = new OnlineTestingAdministrationPage();

    // To set Multiple Choice Response
    public static void setMultipleChoiceResponse(int responseIndex, WebDriverWait waiter, WebDriver driver) {
        Helper.clickXpath("//tr[" + Integer.toString(responseIndex) + "]/td[1]/label[1]/div[1]", waiter, driver);
        waitUntilResponseIsSaved(waiter, driver);
    }

    // To set Multiple Choice PartialCredit
    public static void setMultipleChoicePartialCredit(int responseIndex, WebDriverWait waiter, WebDriver driver) {
        Helper.clickXpath("//*[@id=\"item_choices\"]/table/tbody/tr[" + Integer.toString(responseIndex) + "]/td/label/div", waiter, driver);
        waitUntilResponseIsSaved(waiter, driver);
    }

    // To set Multiple Choice Advanced
    public static void setMultipleChoiceAdvanced(int responseIndex, WebDriverWait waiter, WebDriver driver) {
        Helper.clickXpath("//*[@id=\"item_choices\"]/table/tbody/tr[" + Integer.toString(responseIndex) + "]/td/label/div", waiter, driver);
        waitUntilResponseIsSaved(waiter, driver);
    }

    // To set Constructed Response
    public static void setConstructedResponse(String response, WebDriverWait waiter, WebDriver driver) {
        Helper.waitUntil(onlineTestingAdministrationPage.getOnlineTestingAdministrationResponse(), waiter, driver);
        driver.switchTo().frame(driver.findElement(By.xpath(onlineTestingAdministrationPage.getOnlineTestingAdministrationResponse())));
        actions = new Actions(driver);
        actions.moveToElement(driver.findElement(By.xpath(onlineTestingAdministrationPage.getOnlineTestingAdministrationContentType())));
        actions.click();
        actions.sendKeys(response);
        actions.build().perform();
        driver.switchTo().defaultContent();
        waitUntilResponseIsSaved(waiter, driver);
    }

    // To set Explicit Constructed Response
    public static void setExplicitConstructedResponse(String response, WebDriverWait waiter, WebDriver driver) {
        Helper.sendKeysXpath(onlineTestingAdministrationPage.getOnlineTestingAdministrationAnswerChoice(), response, waiter, driver);
        waitUntilResponseIsSaved(waiter, driver);
    }

    // To set Constructed Response Advanced
    public static void setConstructedResponseAdvanced(String response, WebDriverWait waiter, WebDriver driver) {
        Helper.waitUntil(onlineTestingAdministrationPage.getOnlineTestingAdministrationResponse(), waiter, driver);
        driver.switchTo().frame(driver.findElement(By.xpath(onlineTestingAdministrationPage.getOnlineTestingAdministrationResponse())));
        actions = new Actions(driver);
        actions.moveToElement(driver.findElement(By.xpath(onlineTestingAdministrationPage.getOnlineTestingAdministrationContentType())));
        actions.click();
        actions.sendKeys(response);
        actions.build().perform();
        driver.switchTo().defaultContent();
        waitUntilResponseIsSaved(waiter, driver);
    }

    // To wait Until Response IsSaved
    public static void waitUntilResponseIsSaved(WebDriverWait waiter, WebDriver driver) {
        Helper.waitUntil(onlineTestingAdministrationPage.getOnlineTestingAdministrationStatusBox(), waiter, driver);
        Helper.waitUntilNotVisible(onlineTestingAdministrationPage.getOnlineTestingAdministrationStatusBox(), waiter, driver);
    }

    // To click Next Question
    public static void clickNextQuestion(WebDriverWait waiter, WebDriver driver) {
        Helper.clickXpath(onlineTestingAdministrationPage.getOnlineTestingAdministrationForword(), waiter, driver);
    }

    // To validate alphaString
    public static String alphaString() {
        String alpha = "incorrect";
//        String alpha = "The quick brown fox jumps over a lazy dog. Pack my box with five dozen liquor jugs.";
        return alpha;
    }
}