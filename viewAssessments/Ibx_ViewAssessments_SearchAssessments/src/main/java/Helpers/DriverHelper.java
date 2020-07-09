package Helpers;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.PrintWriter;
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

    public static void waitUntilElementInvisible_ByXPath(String xpath) {
        BrowserInitHelper.getWaiter().until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(xpath)));
    }

    public static String getElementTextByXpath(String elementXpath) {
        BrowserInitHelper.getWaiter().until(ExpectedConditions.elementToBeClickable(By.xpath(elementXpath)));
        WebElement element = BrowserInitHelper.getInstance().findElement(By.xpath(elementXpath));
        String ElementText = element.getText();
        return ElementText;
    }

    public static WebElement getElementByXpath(String elementXpath) {
        BrowserInitHelper.getWaiter().until(ExpectedConditions.visibilityOfElementLocated(By.xpath(elementXpath)));
        WebElement element = BrowserInitHelper.getInstance().findElement(By.xpath(elementXpath));
        return element;
    }

    public static void waitUntilElementInvisible_ByID(String ID) {
        BrowserInitHelper.getWaiter().until(ExpectedConditions.invisibilityOfElementLocated(By.id(ID)));
    }

    public static void waitandclickxpath(String xpath) throws InterruptedException {
        boolean clickable = true;
        while (clickable) {
            try {
                BrowserInitHelper.getInstance().findElement(By.xpath(xpath));
                clickable = false;
                break;
            } catch (NoSuchElementException e) {
                Thread.sleep(3000);
            } catch (Exception e) {
                Thread.sleep(3000);
            }
        }
    }

    public static void waitandclickID(String ID) throws InterruptedException {
        boolean clickable = true;
        while (clickable) {
            try {
                BrowserInitHelper.getInstance().findElement(By.id(ID));
                clickable = false;
                break;
            } catch (NoSuchElementException e) {
                Thread.sleep(3000);
            } catch (Exception e) {
                Thread.sleep(3000);
            }
        }
    }

}

