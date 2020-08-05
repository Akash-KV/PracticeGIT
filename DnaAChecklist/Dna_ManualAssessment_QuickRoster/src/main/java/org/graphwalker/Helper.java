package org.graphwalker;

import org.apache.commons.io.FileUtils;
import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.*;
import java.time.LocalDateTime;
import java.util.logging.Level;

/*****Helper Class for Dna_ManualAssessment_QuickRoster*******/
public class Helper {
    private static String dir = System.getProperty("user.dir");
    private static int screenshotCounter = 0;
    private static LocalDateTime now = LocalDateTime.now();
    private static PrintWriter writer;

    public static void clickXpath(String xpath, WebDriverWait waiter, WebDriver driver) {
        logger(driver);
        highlight(waiter.until(ExpectedConditions.elementToBeClickable(By.xpath(xpath))), driver);
        waiter.until(ExpectedConditions.elementToBeClickable(By.xpath(xpath))).click();
    }

    public static void clickId(String id, WebDriverWait waiter, WebDriver driver) {
        logger(driver);
        highlight(waiter.until(ExpectedConditions.elementToBeClickable(By.id(id))), driver);
        waiter.until(ExpectedConditions.elementToBeClickable(By.id(id))).click();
    }

    public static void sendKeysXpath(String xpath, String text, WebDriverWait waiter, WebDriver driver) {
        logger(driver);
        highlight(waiter.until(ExpectedConditions.elementToBeClickable(By.xpath(xpath))), driver);
        waiter.until(ExpectedConditions.elementToBeClickable(By.xpath(xpath))).clear();
        waiter.until(ExpectedConditions.elementToBeClickable(By.xpath(xpath))).sendKeys(text);
    }

    public static void sendKeysId(String id, String text, WebDriverWait waiter, WebDriver driver) {
        logger(driver);
        highlight(waiter.until(ExpectedConditions.elementToBeClickable(By.id(id))), driver);
        waiter.until(ExpectedConditions.elementToBeClickable(By.id(id))).clear();
        waiter.until(ExpectedConditions.elementToBeClickable(By.id(id))).sendKeys(text);
    }

    public static void wait(double ms) {
        try {
            Thread.sleep((long) (ms * 1000));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void waitUntil(String xpath, WebDriverWait waiter, WebDriver driver) {
        waiter.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
    }

    public static void waitUntilNotVisible(String xpath, WebDriverWait waiter, WebDriver driver) {
        waiter.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(xpath)));
    }

    public static void refreshUntilElementAppears(String xpath, WebDriverWait waiter, WebDriver driver) {
        int i = 0;
        int elements = driver.findElements(By.xpath(xpath)).size();
        while (elements == 0) {
            if (i == 70) {
                break;
            }
            driver.navigate().refresh();
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            elements = driver.findElements(By.xpath(xpath)).size();
            i++;
        }
    }

    public static void assertionText(String xpath, String expected, WebDriverWait waiter, WebDriver driver) {
        refreshUntilElementAppears(xpath, waiter, driver);
        Assert.assertEquals(waiter.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath))).getText(), expected);
    }

    public static String getText(String xpath, WebDriverWait waiter, WebDriver driver) {
        String text = waiter.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath))).getText();
        return text;
    }

    public static void highlight(WebElement element, WebDriver driver) { // add int duration in parameters passed
        JavascriptExecutor js = (JavascriptExecutor) driver;
        String originalStyle = element.getAttribute("style");
        js.executeScript("arguments[0].setAttribute('style', 'outline: 8px dashed red;');", element);
        try {
            Thread.sleep(250);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        js.executeScript("arguments[0].setAttribute('style', 'outline: 1px solid black;');", element);
    }

    public static void logger(WebDriver driver) {
        LogEntries logs = driver.manage().logs().get(LogType.BROWSER);
        logs.filter(Level.SEVERE);
        if (logs != null && !logs.iterator().toString().contains("openqa") && !logs.iterator().toString().contains("java")) {
            try {
                screenshotJavascriptErrors("js_error_" + Integer.toString(screenshotCounter) + ".png", driver);
                logWriter(logs);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void logWriter(LogEntries entries) throws FileNotFoundException, UnsupportedEncodingException {
        String filePath = dir + "/target/javascript-logs/" + now + "_js_log.txt";
        File file = new File(filePath);
        if (file.exists() && !file.isDirectory()) {
            writer.append("==> " + entries.iterator().toString() + "\n");
            writer.close();
        } else {
            writer = new PrintWriter(dir + "/target/javascript-logs/" + now + "_js_log.txt", "UTF-8");
            writer.append("==> " + entries.iterator().toString() + "\n");


        }
    }

    public static void screenshot(WebDriver driver) {
        try {
            if (Config.getScreenshots().equals("true")) {
                String fileName = "screenshot_" + Integer.toString(screenshotCounter) + ".png";
                screenshotCounter++;
                String screenshotPath = "/target/screenshots/";
                File file = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
                FileUtils.copyFile(file, new File(dir + screenshotPath + fileName));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void screenshotJavascriptErrors(String fileName, WebDriver driver) throws IOException {
        screenshotCounter++;
        String screenshotPath = "/target/screenshots/";
        File file = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(file, new File(dir + screenshotPath + fileName));
    }

    public static void login(String un, String pw, WebDriverWait waiter, WebDriver driver) {
        logger(driver);
        highlight(waiter.until(ExpectedConditions.elementToBeClickable(By.id("username"))), driver);
        waiter.until(ExpectedConditions.elementToBeClickable(By.id("username"))).clear();
        waiter.until(ExpectedConditions.elementToBeClickable(By.id("username"))).sendKeys(un);
        highlight(waiter.until(ExpectedConditions.elementToBeClickable(By.id("password"))), driver);
        waiter.until(ExpectedConditions.elementToBeClickable(By.id("password"))).clear();
        waiter.until(ExpectedConditions.elementToBeClickable(By.id("password"))).sendKeys(pw);
        waiter.until(ExpectedConditions.elementToBeClickable(By.id("button_next"))).click();
    }

    public static void loginAuthX(String un, String pw, WebDriverWait waiter, WebDriver driver) {
        if (Config.getLocal().equalsIgnoreCase("true")) {
            highlight(waiter.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@name='username']"))), driver);
            waiter.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@name='username']"))).clear();
            waiter.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@name='username']"))).sendKeys(un);
            highlight(waiter.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@name='password']"))), driver);
            waiter.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@name='password']"))).clear();
            waiter.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@name='password']"))).sendKeys(pw);
            waiter.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[normalize-space(text()) = 'Local']/img"))).click();
            waiter.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[normalize-space(text())='Sign In']"))).click();

        } else {
            highlight(waiter.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@name='username']"))), driver);
            waiter.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@name='username']"))).clear();
            waiter.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@name='username']"))).sendKeys(un);
            highlight(waiter.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@name='password']"))), driver);
            waiter.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@name='password']"))).clear();
            waiter.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@name='password']"))).sendKeys(pw);
            waiter.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[normalize-space(text())='Sign In']"))).click();

        }
    }
}
