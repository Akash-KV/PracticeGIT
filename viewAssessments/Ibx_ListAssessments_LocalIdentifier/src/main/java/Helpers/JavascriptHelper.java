package Helpers;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Helpers class for JavaScript
 **/

public class JavascriptHelper {

    //Logger and WebDrivers
    private static final Logger logger = LoggerFactory.getLogger(JavascriptHelper.class);

    /**
     * Methods of JavaScript
     **/

    public static void highlight(WebElement element) { // add int duration in parameters passed
        JavascriptExecutor js = (JavascriptExecutor) BrowserInitHelper.getInstance();
        String originalStyle = element.getAttribute("style");
        js.executeScript("arguments[0].setAttribute('style', 'background: yellow; border: 4px solid red;');", element);
        try {
            Thread.sleep(250);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        js.executeScript("arguments[0].setAttribute('style', 'background: white; border: 1px solid black;');", element);
    }

    public static void waitUntilAjaxLoaded() {
        while (true) {
            try {
                //Boolean ajaxIsComplete = (Boolean) ((JavascriptExecutor) BrowserInitHelper.getInstance()).executeScript("return jQuery.active == 0");
                Boolean ajaxIsComplete = (Boolean) ((JavascriptExecutor) BrowserInitHelper.getInstance()).executeScript("return window.jQuery != undefined && jQuery.active == 0");
                if (ajaxIsComplete) {
                    break;
                }
                Thread.sleep(3000);
            } catch (JavascriptException e) {
                logger.info("JavascriptException handled....");
            } catch (InterruptedException ie) {
                logger.info("InterruptedException handled....");
            }
        }
    }

    public static void clickID_JS(String ID) {
        ((JavascriptExecutor) BrowserInitHelper.getInstance()).executeScript("return !!jQuery(\"#" + ID + "\").click();");
    }

    public static void scrollintoView(String ID) {
        WebElement element = BrowserInitHelper.getInstance().findElement(By.id(ID));
        ((JavascriptExecutor) BrowserInitHelper.getInstance()).executeScript("arguments[0].scrollIntoView(true);", element);
    }

    public static void clickXpath_JS(String xpath) {
        boolean clicked = false;
        do {
            try {
                BrowserInitHelper.getWaiter().until(ExpectedConditions.elementToBeClickable(By.xpath(xpath)));
                WebElement Element = BrowserInitHelper.getInstance().findElement(By.xpath(xpath));
                ((JavascriptExecutor) BrowserInitHelper.getInstance()).executeScript("arguments[0].click();", Element);
            } catch (NoSuchElementException ne) {
                continue;
            } catch (WebDriverException e) {
                continue;
            } finally {
                clicked = true;
            }
        } while (!clicked);
    }

    public static void waitUntilDocumentIsReady() {
        ((JavascriptExecutor) BrowserInitHelper.getInstance()).executeScript("return document.readyState").equals("complete");
    }
}
