package Controllers;

import org.graphwalker.Helper;
import org.graphwalker.PageObjectModels.OnlineTestingAdministrationPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class OnlineTestingController {
    public static OnlineTestingAdministrationPage onlineTestingAdministrationPage = new OnlineTestingAdministrationPage();
    private static Actions actions;

    public static void setMutltipleChoiceResponse(int responseIndex, WebDriverWait waiter, WebDriver driver) {
        Helper.clickXpath("//tr[" + Integer.toString(responseIndex) + "]/td[1]/label[1]/div[1]", waiter, driver);
        waitUntilResponseIsSaved(waiter, driver);
    }

    public static void setMultipleChoicePartialCredit(int responseIndex, WebDriverWait waiter, WebDriver driver) {
        Helper.clickXpath("//*[@id=\"item_choices\"]/table/tbody/tr[" + Integer.toString(responseIndex) + "]/td/label/div", waiter, driver);
        waitUntilResponseIsSaved(waiter, driver);
    }

    public static void setMultipleChoiceAdvanced(int responseIndex, WebDriverWait waiter, WebDriver driver) {
        Helper.clickXpath("//*[@id=\"item_choices\"]/table/tbody/tr[" + Integer.toString(responseIndex) + "]/td/label/div", waiter, driver);
        waitUntilResponseIsSaved(waiter, driver);
    }

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

    public static void setExplicitConstructedResponse(String response, WebDriverWait waiter, WebDriver driver) {
        Helper.sendKeysXpath(onlineTestingAdministrationPage.getOnlineTestingAdministrationAnswerChoice(), response, waiter, driver);
        waitUntilResponseIsSaved(waiter, driver);
    }

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

    public static void waitUntilResponseIsSaved(WebDriverWait waiter, WebDriver driver) {
        Helper.waitUntil(onlineTestingAdministrationPage.getOnlineTestingAdministrationStatusBox(), waiter, driver);
        Helper.waitUntilNotVisible(onlineTestingAdministrationPage.getOnlineTestingAdministrationStatusBox(), waiter, driver);
    }

    public static void clickNextQuestion(WebDriverWait waiter, WebDriver driver) {
        Helper.clickXpath(onlineTestingAdministrationPage.getOnlineTestingAdministrationForword(), waiter, driver);
    }

    public static String alphaString() {
        String alpha = "incorrect";
        return alpha;
    }
}