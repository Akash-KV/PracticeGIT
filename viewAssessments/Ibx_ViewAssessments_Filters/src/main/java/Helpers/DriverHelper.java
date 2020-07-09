package Helpers;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

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
     * Driver and Waiter MethodsclickXpath
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
}
