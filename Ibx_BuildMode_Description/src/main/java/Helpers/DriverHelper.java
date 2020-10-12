package Helpers;

import Utils.ConsoleLogger;
import Utils.Dynamic;
import org.awaitility.Awaitility;
import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.*;

import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.PrintWriter;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
    public static String mainWindow;

    /**
     * Driver and Waiter MethodsClickXpath
     */

    // To click using Xpath
    public static void clickXpath(String xpath) {
        logger(BrowserInitHelper.getInstance());
        highlight(BrowserInitHelper.getWaiter().until(ExpectedConditions.elementToBeClickable(By.xpath(xpath))));
        BrowserInitHelper.getWaiter().until(ExpectedConditions.elementToBeClickable(By.xpath(xpath))).click();
    }

    // Awaitility wait using Xpath
    public static void awaitTillElementDisplayed(String locator, String element) {
        Awaitility.await(element + " - is not showing....").atMost(Dynamic.getWaitTime(), TimeUnit.SECONDS).with().pollDelay(2, TimeUnit.SECONDS).and().pollInterval(2, TimeUnit.SECONDS).ignoreException(NoSuchElementException.class).until(() -> BrowserInitHelper.getInstance().findElement(By.xpath(locator)).isDisplayed());
    }

    // To click using Id
    public static void clickId(String id) {
        logger(BrowserInitHelper.getInstance());
        highlight(BrowserInitHelper.getWaiter().until(ExpectedConditions.elementToBeClickable(By.id(id))));
        BrowserInitHelper.getWaiter().until(ExpectedConditions.elementToBeClickable(By.id(id))).click();
    }

    // To click using CSS selector
    public void clickCss(String css) {
        BrowserInitHelper.getWaiter().until(ExpectedConditions.elementToBeClickable(By.cssSelector(css))).click();
    }

    // Send Keys using Xpath
    public static void sendKeysXpath(String xpath, String text) {
        logger(BrowserInitHelper.getInstance());
        highlight(BrowserInitHelper.getWaiter().until(ExpectedConditions.elementToBeClickable(By.xpath(xpath))));
        BrowserInitHelper.getWaiter().until(ExpectedConditions.elementToBeClickable(By.xpath(xpath))).clear();
        BrowserInitHelper.getWaiter().until(ExpectedConditions.elementToBeClickable(By.xpath(xpath))).sendKeys(text);
    }

    // Send Keys using CSS Selector
    public void sendKeysCss(String css, String text) {
        BrowserInitHelper.getWaiter().until(ExpectedConditions.elementToBeClickable(By.cssSelector(css))).clear();
        BrowserInitHelper.getWaiter().until(ExpectedConditions.elementToBeClickable(By.cssSelector(css))).sendKeys(text);
    }

    // Send Keys using Id
    public static void sendKeysId(String id, String text) {
        logger(BrowserInitHelper.getInstance());
        highlight(BrowserInitHelper.getWaiter().until(ExpectedConditions.elementToBeClickable(By.id(id))));
        BrowserInitHelper.getWaiter().until(ExpectedConditions.elementToBeClickable(By.id(id))).clear();
        BrowserInitHelper.getWaiter().until(ExpectedConditions.elementToBeClickable(By.id(id))).sendKeys(text);
    }

    // To clear Text Box
    public static void clearTextBox(String xpath) {
        WebElement textBox = BrowserInitHelper.getInstance().findElement(By.xpath(xpath));
        textBox.clear();
    }

    // To get text of Web Element using Xpath
    public static String getText(String xpath) {
        String text = BrowserInitHelper.getWaiter().until(ExpectedConditions.elementToBeClickable(By.xpath(xpath))).getText();
        return text;
    }

    // To Fetch the path
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

    // Fluent wait using Xpath
    public static void waitFluentByXPath(WebDriver driver, final String xPath) {
        Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(Dynamic.getWaitTime()))
                .pollingEvery(Duration.ofMillis(5000)).ignoring(Exception.class);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(xPath)));
    }

    // Awaitility wait using Id
    public static void awaitTillElementDisplayedByID(String locator, String element) {
        Awaitility.await(element + " -is not showing....").atMost(Dynamic.getWaitTime(), TimeUnit.SECONDS).pollDelay(2, TimeUnit.SECONDS).and().pollInterval(2, TimeUnit.SECONDS).ignoreException(NoSuchElementException.class).until(() -> BrowserInitHelper.getInstance().findElement(By.id(locator)).isDisplayed());
    }

    // To check element display by using Xpath
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

    // To check element display by using CSS Selector
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

    // To validate Web Element display using Xpath
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

    // To click using xpath by handling stale element exception
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

    // To replace and validate text using Xpath.
    public static boolean replaceAndVerifyTextByXpath(String replaceValue, String xpath, String text) {
        boolean res = false;
        String str = null;
        try {
            BrowserInitHelper.getWaiter().until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
            str = text.replace(replaceValue, "");
            if (BrowserInitHelper.getInstance().findElement(By.xpath(xpath)).getText().contains(str)) {
                res = true;
            } else {
                return res;
            }
        } catch (Exception e) {
            e.printStackTrace();
            ConsoleLogger.ErrorLog("Specified element text doesn't match with  the actual value.");
        }
        return res;
    }

    // To validate element existence using webElement
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

    // To get Web Element using Xpath for click
    public static WebElement getElementByXpathToClick(String elementXpath) {
        BrowserInitHelper.getWaiter().until(ExpectedConditions.elementToBeClickable(By.xpath(elementXpath)));
        WebElement element = BrowserInitHelper.getInstance().findElement(By.xpath(elementXpath));
        return element;
    }

    // To assert using text
    public static void assertionText(String xpath, String expected) {
        try {
            refreshUntilElementAppears(xpath);
            Thread.sleep(2000);
            Assert.assertEquals(BrowserInitHelper.getWaiter().until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath))).getText(), expected);
        } catch (Exception e) {
            System.out.println("Exception handled for assertionText...");
        }
    }

    // To validate element text using Xpath
    public static boolean verifyElementTextByXpath(String xpath, String text) {
        boolean res = false;
        try {
            BrowserInitHelper.getWaiter().until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
            if (BrowserInitHelper.getInstance().findElement(By.xpath(xpath)).getText().contains(text)) {
                res = true;
            } else {
                return res;
            }
        } catch (Exception e) {
            e.printStackTrace();
            ConsoleLogger.DebugLog("Specified element text doesn't match with  the actual value.");
        }
        return res;
    }

    // To check Element not exists using xpath
    public static boolean elementNotExistenceXpath(String xPath) {
        try {
            if (BrowserInitHelper.getInstance().findElement(By.xpath(xPath)).isDisplayed()) {
                return false;
            } else {
                return true;
            }
        } catch (Exception e) {
            System.out.println("Element not exist");
            return true;
        }
    }

    // To check element existence using xpath
    public static boolean elementExistenceXpath(String xPath) {
        try {
            BrowserInitHelper.getWaiter().until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xPath)));
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

    // Wait until the Web Element loads using Id
    public static void waitAndClickID(String ID) throws InterruptedException {
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

    // Waiter for pausing execution
    public static void waitTill(long timeToWait) {
        try {
            Thread.sleep(timeToWait * 1000);
        } catch (Exception e) {
            System.out.println("Exception handled for method - waitTill");
        }
    }

    // Wait until the Web Element loads using Xpath
    public static void waitAndClickXpath(String xpath) throws InterruptedException {
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

    // Explicit wait for invisibility of Web Element using Id
    public static void waitUntilElementInvisible_ByID(String ID) {
        BrowserInitHelper.getWaiter().until(ExpectedConditions.invisibilityOfElementLocated(By.id(ID)));
    }

    // Explicit wait for invisibility of Web Element using Xpath
    public static void waitUntilElementInvisible_ByXPath(String xpath) {
        BrowserInitHelper.getWaiter().until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(xpath)));
    }

    // Waiter for loader Invisible
    public static void waitUntilLoaderInvisible() {
        //BrowserInitHelper.getWaiter().until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@id='divPageLoading']")));
        BrowserInitHelper.getWaiter().until(ExpectedConditions.invisibilityOf(BrowserInitHelper.getInstance().findElement(By.xpath("//div[@id='divPageLoading']"))));
    }

    // Explicit wait using Xpath
    public static void waitUntil(String xpath) {
        BrowserInitHelper.getWaiter().until(ExpectedConditions.elementToBeClickable(By.xpath(xpath)));
    }

    // Waiter for the complete page load
    public static void waitForPageLoadComplete() {
        ExpectedCondition<Boolean> pageLoadCondition = new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver driver) {
                return ((JavascriptExecutor) driver).executeScript("return document.readyState").equals("complete");
            }
        };
        WebDriverWait wait = new WebDriverWait(BrowserInitHelper.getInstance(), 50);
        wait.until(pageLoadCondition);
    }

    // To fetch class attribute in Xpath
    public String getClassName(WebElement element) {
        String className = "";
        BrowserInitHelper.getWaiter().until(ExpectedConditions.elementToBeClickable(element));
        className = element.getAttribute("class").trim();
        return className;
    }

    // To Validate checked or not using Id
    public Boolean getChecked(String id) {
        Boolean value = false;

        JavascriptExecutor js = (JavascriptExecutor) BrowserInitHelper.getInstance();
        System.out.println("instance-->" + BrowserInitHelper.getInstance());
        System.out.println("js-->" + js);
        Object Check = js.executeScript("return document.getElementById('" + id + "').checked;");

        if (Check.toString().equalsIgnoreCase("true")) {
            value = true;
        }

        return value;
    }

    // To replace locator
    public static String getReplacedLocator(String toReplace, String xpath) {
        String value = null;
        try {
            value = xpath;
            value = value.replace("TOREPLACE", toReplace);

        } catch (Exception e) {
            System.out.println("Exception handled for getReplacedLocator");
        }
        return value;
    }

    // To clear using Send keys with backspace
    public static void clearWithBackspace(String elementXpath) {
        WebElement input = BrowserInitHelper.getInstance().findElement(By.xpath(elementXpath));
        while (input.getAttribute("value").length() > 0) {
            input.sendKeys(Keys.BACK_SPACE);
        }
    }

    // To refresh until the element appears
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

    // To handle alert Pop Up
    public static void switchToAlert(WebDriverWait waiter) {
//        if(action.equalsIgnoreCase("Accept")){
//            BrowserInitHelper.getInstance().switchTo().alert().accept();
//        }
//        else{
//            BrowserInitHelper.getInstance().switchTo().alert().dismiss();
//        }
        try {
            waiter.until(ExpectedConditions.alertIsPresent());
            BrowserInitHelper.getInstance().switchTo().alert().accept();
        } catch (Exception e) {
            System.out.println("Exception handled for alert..." + e);
        }
    }

    // To switch to child window
    public static void getWindowHandleAndSwitchWindow(WebDriver driver) {
        try {
            System.out.println("try switch to window");
            DriverHelper.waitTill(5);
            mainWindow = driver.getWindowHandle();
            Set<String> set = driver.getWindowHandles();
            Iterator<String> itr = set.iterator();
            while (itr.hasNext()) {
                String childWindow = itr.next();
                if (!mainWindow.equals(childWindow)) {
                    driver.switchTo().window(childWindow);
                }
            }
        } catch (Exception e) {
            System.out.println("Exception handled for switching tab");
        }
    }

    //controller method for switchToMainWindow
    public static void switchToMainWindow(WebDriver driver) {
        try {
            driver.close();
            driver.switchTo().window(mainWindow);
        } catch (Exception e) {
            System.out.println("Exception handled for switching tab");
        }
    }

    // To validate assertion
    public static void assertion(String xpath, String expected) {
        Assert.assertEquals(BrowserInitHelper.getWaiter().until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath))).getText().trim(), expected);
    }

    //To Upload File
    public static void UploadFile(WebElement uploadElement, String uploadFilePath) {
        try {
            System.out.println("uploadFilePath: " + uploadFilePath);
            uploadElement.click();
            Thread.sleep(3000);
            //Store the location of the file in clipboard
            //Clipboard
            StringSelection strSel = new StringSelection(uploadFilePath);
            Toolkit.getDefaultToolkit().getSystemClipboard().setContents(strSel, null);

            //Create an object for robot class
            Robot robot = new Robot();
            //Control key in the keyboard
            //Ctrl+V
            robot.keyPress(KeyEvent.VK_CONTROL);
            robot.keyPress(KeyEvent.VK_V);
            robot.keyRelease(KeyEvent.VK_CONTROL);

            Thread.sleep(3000);
            robot.keyPress(KeyEvent.VK_ENTER);
            robot.keyRelease(KeyEvent.VK_ENTER);
        } catch (InterruptedException ie) {
            //log.info("InterruptedException handled.....");
        } catch (AWTException awt) {
            //log.info("AWTException handled");
        } catch (Exception e) {
            //log.info("Exception handled");
        }
    }

    // To delete files
    public static String getDeletePath() {
        String os = null;
        String dir = System.getProperty("user.dir");
        String deletePath = null;

        os = System.getProperty("os.name");
        try {
            if (os.contains("Windows")) {
                deletePath = dir + "\\log";
            } else {
                deletePath = dir + "/log";
            }
        } catch (Exception e) {
            System.out.println("Exception handled for method - getDownloadsPath...");
        }
        ConsoleLogger.DebugLog("deletePath ==>" + deletePath);
        return deletePath;
    }

}
