package Helpers;

import org.openqa.selenium.JavascriptException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

//Helper class for Javascript
public class JavascriptHelper {

    private static final Logger logger = LoggerFactory.getLogger(JavascriptHelper.class);

    //Method to highlight web Element
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

    //waitUntilAjaxLoaded Method
    public static void waitUntilAjaxLoaded() {
        while (true) {
            try {
                //Boolean ajaxIsComplete = (Boolean) ((JavascriptExecutor) BrowserInitHelper.getInstance()).executeScript("return jQuery.active == 0");
                Boolean ajaxIsComplete = (Boolean) ((JavascriptExecutor) BrowserInitHelper.getInstance()).executeScript("return window.jQuery != undefined && jQuery.active == 0");
                if (ajaxIsComplete) {
                    break;
                }
                Thread.sleep(1000);

            } catch (JavascriptException e) {
                logger.info("JavascriptException handled....");
            } catch (InterruptedException ie) {
                logger.info("InterruptedException handled....");
            }
        }
    }
}
