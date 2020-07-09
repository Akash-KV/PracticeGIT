package Helpers;

import Utils.ConsoleLogger;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.io.PrintWriter;
import java.time.LocalDateTime;

import static Helpers.JavascriptHelper.highlight;
import static Helpers.LoggerHelper.logger;

/**
 * Helpers class for Driver
 **/

public class DriverHelper {
    private static String dir = System.getProperty("user.dir");
    private static int screenshotCounter = 0;
    private static LocalDateTime now = LocalDateTime.now();
    private static PrintWriter writer;


    /**
     * Driver and Waiter Methods
     */

    public static void clickXpath(String xpath) {
        logger(BrowserInitHelper.getInstance());
        highlight(BrowserInitHelper.getWaiter().until(ExpectedConditions.elementToBeClickable(By.xpath(xpath))));
        BrowserInitHelper.getWaiter().until(ExpectedConditions.elementToBeClickable(By.xpath(xpath))).click();
        System.out.println("xpath Clicked.....-->" + xpath);
    }

    public static void clickId(String id) {
        logger(BrowserInitHelper.getInstance());
        highlight(BrowserInitHelper.getWaiter().until(ExpectedConditions.elementToBeClickable(By.id(id))));
        BrowserInitHelper.getWaiter().until(ExpectedConditions.elementToBeClickable(By.id(id))).click();
    }

    public static void sendKeysXpath(String xpath, String text) {
        logger(BrowserInitHelper.getInstance());
        highlight(BrowserInitHelper.getWaiter().until(ExpectedConditions.elementToBeClickable(By.xpath(xpath))));
        BrowserInitHelper.getWaiter().until(ExpectedConditions.elementToBeClickable(By.xpath(xpath))).clear();
        BrowserInitHelper.getWaiter().until(ExpectedConditions.elementToBeClickable(By.xpath(xpath))).sendKeys(text);
    }

    public static void sendKeysId(String id, String text) {
        logger(BrowserInitHelper.getInstance());
        highlight(BrowserInitHelper.getWaiter().until(ExpectedConditions.elementToBeClickable(By.id(id))));
        BrowserInitHelper.getWaiter().until(ExpectedConditions.elementToBeClickable(By.id(id))).clear();
        BrowserInitHelper.getWaiter().until(ExpectedConditions.elementToBeClickable(By.id(id))).sendKeys(text);
    }


    public static String getText(String xpath) {
        String text = BrowserInitHelper.getWaiter().until(ExpectedConditions.elementToBeClickable(By.xpath(xpath))).getText();
        return text;
    }

    public static boolean checkTextOfElementByxpath(String Locator, String Elementname, String csvData) {
        boolean value = false;
        BrowserInitHelper.getWaiter().until(ExpectedConditions.visibilityOfElementLocated(By.xpath(Locator)));
        String text = BrowserInitHelper.getInstance().findElement(By.xpath(Locator)).getText();
        System.out.println(text);
        if (csvData.equalsIgnoreCase(text)) {
            ConsoleLogger.SuccessLog(Elementname + " is matching as per the test data");
            value = true;
        } else {
            ConsoleLogger.FailedTestCase(" is not matching as per the test data");
        }
        return value;
    }

    public static boolean checkElementDisplayByXpath(String locator, String elementName) {
        boolean value = false;
        try {
            BrowserInitHelper.getWaiter().until(ExpectedConditions.elementToBeClickable(By.xpath(locator)));
            value = true;
            ConsoleLogger.SuccessLog("" + elementName + " is displayed.....");
        } catch (Exception e) {
            System.out.println("Exception handled for " + e);
            ConsoleLogger.FailedTestCase("" + elementName + " is NOT displayed.....!!!");
        }
        return value;
    }

    public static boolean checkElementDisplayByCSS(String locator, String elementName) {
        boolean value = false;
        try {
            BrowserInitHelper.getWaiter().until(ExpectedConditions.elementToBeClickable(By.cssSelector(locator)));
            value = true;
            ConsoleLogger.SuccessLog("" + elementName + " is displayed.....");
        } catch (Exception e) {
            System.out.println("Exception handled for " + e);
            ConsoleLogger.FailedTestCase("" + elementName + " is NOT displayed.....!!!");
        }
        return value;
    }
}
