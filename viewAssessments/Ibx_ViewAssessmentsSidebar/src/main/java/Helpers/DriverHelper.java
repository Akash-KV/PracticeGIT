package Helpers;

import Utils.Config;
import Utils.ConsoleLogger;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.PrintWriter;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.function.Function;

import static Helpers.JavascriptHelper.highlight;
import static Helpers.LoggerHelper.logger;
import static java.util.concurrent.TimeUnit.SECONDS;

/*Test Class for Driver helper*/
public class DriverHelper {
    private static String dir = System.getProperty("user.dir");
    private static int screenshotCounter = 0;
    private static LocalDateTime now = LocalDateTime.now();
    private static PrintWriter writer;


    /**
     * Driver and Waiter MethodsclickXpath
     */
    //for clicking Xpath
    public static void clickXpath(String xpath) {
        logger(BrowserInitHelper.getInstance());
        highlight(BrowserInitHelper.getWaiter().until(ExpectedConditions.elementToBeClickable(By.xpath(xpath))));
        BrowserInitHelper.getWaiter().until(ExpectedConditions.elementToBeClickable(By.xpath(xpath))).click();
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

    public static void waitFluentByXPath(WebDriver driver, final String xPath) {
        Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(Config.getWaitTime()))
                .pollingEvery(Duration.ofMillis(5000)).ignoring(Exception.class);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(xPath)));
    }

    public static void waitUntilLoaderInvisible() {
        BrowserInitHelper.getWaiter().until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loading-overlay']//div[.='Loading']")));
    }

    //for clicking ID
    public static void clickId(String id) {
        logger(BrowserInitHelper.getInstance());
        highlight(BrowserInitHelper.getWaiter().until(ExpectedConditions.elementToBeClickable(By.id(id))));
        BrowserInitHelper.getWaiter().until(ExpectedConditions.elementToBeClickable(By.id(id))).click();
    }

    //Send Keys using Xpath
    public static void sendKeysXpath(String xpath, String text) {
        logger(BrowserInitHelper.getInstance());
        highlight(BrowserInitHelper.getWaiter().until(ExpectedConditions.elementToBeClickable(By.xpath(xpath))));
        BrowserInitHelper.getWaiter().until(ExpectedConditions.elementToBeClickable(By.xpath(xpath))).clear();
        BrowserInitHelper.getWaiter().until(ExpectedConditions.elementToBeClickable(By.xpath(xpath))).sendKeys(text);
    }

    //Send Keys using ID
    public static void sendKeysId(String id, String text) {
        logger(BrowserInitHelper.getInstance());
        highlight(BrowserInitHelper.getWaiter().until(ExpectedConditions.elementToBeClickable(By.id(id))));
        BrowserInitHelper.getWaiter().until(ExpectedConditions.elementToBeClickable(By.id(id))).clear();
        BrowserInitHelper.getWaiter().until(ExpectedConditions.elementToBeClickable(By.id(id))).sendKeys(text);
    }

    //For applying wait
    public static void waitTill(long timeToWait) {
        try {
            Thread.sleep(timeToWait * 1000);
        } catch (Exception e) {
            System.out.println("Exception handled for method - waitTill");
        }
    }

    //getText using Xpath
    public static String getText(String xpath) {
        String text = BrowserInitHelper.getWaiter().until(ExpectedConditions.elementToBeClickable(By.xpath(xpath))).getText();
        return text;
    }

    //wait method
    public static void waitTillElement(String xpath) {
        boolean check = true;

        while (check) {
            try {
                Thread.sleep(2000);
                BrowserInitHelper.getInstance().findElement(By.xpath(xpath));
                check = false;
                break;
            } catch (TimeoutException te) {
                check = true;
            } catch (InterruptedException e) {
                check = true;
            } catch (Exception e) {
                check = true;
            }
        }
    }
}
