package Helpers;

import Utils.ConsoleLogger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.PrintWriter;
import java.time.LocalDateTime;

import static Helpers.JavascriptHelper.highlight;
import static Helpers.LoggerHelper.logger;

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
    }

    public static void clickId(String id, WebDriverWait waiter, WebDriver driver) {
        logger(driver);
        highlight(BrowserInitHelper.getWaiter().until(ExpectedConditions.elementToBeClickable(By.id(id))));
        waiter.until(ExpectedConditions.elementToBeClickable(By.id(id))).click();
    }

    public static void sendKeysXpath(String xpath, String text, WebDriverWait waiter, WebDriver driver) {
        logger(driver);
        highlight(BrowserInitHelper.getWaiter().until(ExpectedConditions.elementToBeClickable(By.xpath(xpath))));
        waiter.until(ExpectedConditions.elementToBeClickable(By.xpath(xpath))).clear();
        waiter.until(ExpectedConditions.elementToBeClickable(By.xpath(xpath))).sendKeys(text);
    }

    public static void sendKeysId(String id, String text, WebDriverWait waiter, WebDriver driver) {
        logger(driver);
        highlight(BrowserInitHelper.getWaiter().until(ExpectedConditions.elementToBeClickable(By.id(id))));
        waiter.until(ExpectedConditions.elementToBeClickable(By.id(id))).clear();
        waiter.until(ExpectedConditions.elementToBeClickable(By.id(id))).sendKeys(text);
    }

    public static boolean elementExistence(WebElement element, WebDriver driver) {
        logger(driver);
        try {
            if (element.isDisplayed()) {
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public static void waitTill(long timeToWait) {
        try {
            Thread.sleep(timeToWait * 1000);
        } catch (Exception e) {
            System.out.println("Exception handled for method - waitTill");
        }
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

    public static void waitUntilLoaderInvisible() {
        BrowserInitHelper.getWaiter().until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loading-overlay']//div[.='Loading']")));
    }

    public static void waitForPageLoadComplete() {
        ExpectedCondition<Boolean> pageLoadCondition = new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver driver) {
                return ((JavascriptExecutor) driver).executeScript("return document.readyState").equals("complete");
            }
        };
        WebDriverWait wait = new WebDriverWait(BrowserInitHelper.getInstance(), 30);
        wait.until(pageLoadCondition);
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

    public static boolean verifyDisplayByXpath(String xpath) {
        boolean res = false;
        try {
            BrowserInitHelper.getWaiter().until(ExpectedConditions.elementToBeClickable(By.xpath(xpath)));
            res = BrowserInitHelper.getInstance().findElement(By.xpath(xpath)).isDisplayed();
            if (res) {
                ConsoleLogger.SuccessLog("Specified element :- " + xpath + " -: is displayed successfully....");
                return res;
            } else {
                ConsoleLogger.FailedTestCase("Specified element :- " + xpath + " -: is NOT displayed....!!");
            }
        } catch (Exception e) {
            ConsoleLogger.DebugLog(xpath + " Unable to find the specified " + xpath + " element.");
        }
        return res;
    }

    public static void switchToAlert(WebDriverWait waiter) {
        try {
            waiter.until(ExpectedConditions.alertIsPresent());
            BrowserInitHelper.getInstance().switchTo().alert().accept();
        } catch (Exception e) {
            System.out.println("Exception handled for alert..." + e);
        }
    }
}
