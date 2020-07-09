package Helpers;

import Utils.Config;
import org.awaitility.Awaitility;
import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.PrintWriter;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static Helpers.JavascriptHelper.highlight;
import static Helpers.LoggerHelper.logger;

//Controller class for Driver
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

    public static void clickXpathWithStale(String xpath) {
        boolean click = false;
        while (!click) {
            try {
                logger(BrowserInitHelper.getInstance());
                highlight(BrowserInitHelper.getWaiter().until(ExpectedConditions.elementToBeClickable(By.xpath(xpath))));
                BrowserInitHelper.getWaiter().until(ExpectedConditions.elementToBeClickable(By.xpath(xpath))).click();
                click = true;
            } catch (StaleElementReferenceException e) {
                System.out.println("StaleElementReferenceException handled....");
            }
        }
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

    public static void assertionText(String xpath, String expected) {
        try {
            refreshUntilElementAppears(xpath);
            Thread.sleep(2000);
            Assert.assertEquals(BrowserInitHelper.getWaiter().until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath))).getText(), expected);
        } catch (Exception e) {
            System.out.println("Exception handled for assertionText...");
        }
    }

    public static void waitTill(long timeToWait) {
        try {
            Thread.sleep(timeToWait * 1000);
        } catch (Exception e) {
            System.out.println("Exception handled for method - waitTill");
        }
    }

    public static void sendKeysXpath(String xpath, String text) {
        logger(BrowserInitHelper.getInstance());
        highlight(BrowserInitHelper.getWaiter().until(ExpectedConditions.elementToBeClickable(By.xpath(xpath))));
        BrowserInitHelper.getWaiter().until(ExpectedConditions.elementToBeClickable(By.xpath(xpath))).clear();
        BrowserInitHelper.getWaiter().until(ExpectedConditions.elementToBeClickable(By.xpath(xpath))).sendKeys(text);
    }

    public static void waitFluentByXPath(WebDriver driver, final String xPath) {
        Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(Config.getWaitTime()))
                .pollingEvery(Duration.ofMillis(5000)).ignoring(Exception.class);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(xPath)));
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

    public static void clearTextbox(String xpath) {
        WebElement textBox = BrowserInitHelper.getInstance().findElement(By.xpath(xpath));
        textBox.clear();
    }

    public static boolean elementExistenceXpath(String xPath) {
        try {
            if (BrowserInitHelper.getInstance().findElement(By.xpath(xPath)).isDisplayed()) {
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public static String getPath(String path) {
        String regex = "\\\\";
        String subst = "/";
        String value;
        String os = System.getProperty("os.name");

        if (os.contains("Windows") || os.contains("windows")) {
            value = path;
            System.out.println("Os is Windows.....");
        } else {
            Pattern pattern = Pattern.compile(regex, Pattern.MULTILINE);
            Matcher matcher = pattern.matcher(path);
            value = matcher.replaceAll(subst);
        }

        System.out.println("Result ==>" + value);

        return value;
    }

    public static void refreshUntilElementAppears(String xpath) {
        int i = 0;
        int elements = BrowserInitHelper.getInstance().findElements(By.xpath(xpath)).size();
        while (elements == 0) {
            if (i == 70) {
                break;
            }
            BrowserInitHelper.getInstance().navigate().refresh();
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            elements = BrowserInitHelper.getInstance().findElements(By.xpath(xpath)).size();
            i++;
        }
    }

    public static void awaitTillElementDisplayed(String locator, String element) {
        Awaitility.await(element + " - is not showing....").atMost(Config.getWaitTime(), TimeUnit.SECONDS).with().pollDelay(2, TimeUnit.SECONDS).and().pollInterval(2, TimeUnit.SECONDS).ignoreException(NoSuchElementException.class).until(() -> BrowserInitHelper.getInstance().findElement(By.xpath(locator)).isDisplayed());
    }

    public static void awaitTillElementsDisplayed(String locator, String element) {
        Awaitility.await(element + " -is not showing....").atMost(Config.getWaitTime(), TimeUnit.SECONDS).pollDelay(2, TimeUnit.SECONDS).and().pollInterval(2, TimeUnit.SECONDS).ignoreException(NoSuchElementException.class).until(() -> BrowserInitHelper.getInstance().findElements(By.xpath(locator)).size() > 0);
    }


    public static void awaitTillElementDisplayedByID(String locator, String element) {
        Awaitility.await(element + " -is not showing....").atMost(Config.getWaitTime(), TimeUnit.SECONDS).pollDelay(2, TimeUnit.SECONDS).and().pollInterval(2, TimeUnit.SECONDS).ignoreException(NoSuchElementException.class).until(() -> BrowserInitHelper.getInstance().findElement(By.id(locator)).isDisplayed());
    }

    public static void awaitTillElementInvisibility(String locator, String element) {
        Awaitility.await(element + " - is not showing....").atMost(Config.getWaitTime(), TimeUnit.SECONDS).pollDelay(2, TimeUnit.SECONDS).and().pollInterval(2, TimeUnit.SECONDS).ignoreException(NoSuchElementException.class).until(() -> !(BrowserInitHelper.getInstance().findElement(By.xpath(locator)).isDisplayed()));
    }

    public static void acceptAlert() {
        try {
            BrowserInitHelper.getWaiter().until(ExpectedConditions.alertIsPresent());
            Alert Elementpopup = BrowserInitHelper.getInstance().switchTo().alert();
            Elementpopup.accept();
        } catch (Exception e) {
            System.out.println("Exception handled for acceptAlert");
        }
    }

}
