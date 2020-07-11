package Helpers;

import Utils.Config;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.PrintWriter;
import java.time.Duration;
import java.time.LocalDateTime;

import static Helpers.JavascriptHelper.highlight;
import static Helpers.LoggerHelper.logger;

//Helper class for Driver
public class DriverHelper {
    private static String dir = System.getProperty("user.dir");
    private static int screenshotCounter = 0;
    private static LocalDateTime now = LocalDateTime.now();
    private static PrintWriter writer;


    /**
     * Driver and Waiter Methods
     **/

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

    public static void waitUntilLoaderInvisible() {
        BrowserInitHelper.getWaiter().until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loading-overlay']//div[.='Loading']")));
    }

    public static void waitFluentByXPath(WebDriver driver, final String xPath) {
        Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(Config.getWaitTime()))
                .pollingEvery(Duration.ofMillis(5000)).ignoring(Exception.class);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(xPath)));
    }
}
