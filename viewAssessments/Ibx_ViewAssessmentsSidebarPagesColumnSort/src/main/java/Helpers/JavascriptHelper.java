
//
package Helpers;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.Time;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

/****Test Class for JavascriptHelper *****/
public class JavascriptHelper {

    //Logger and WebDrivers
    private static final Logger logger = LoggerFactory.getLogger(JavascriptHelper.class);

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

    public static void clickID_JS(String ID) {
        try {
            ((JavascriptExecutor) BrowserInitHelper.getInstance()).executeScript("return !!jQuery(\"#" + ID + "\").click();");
        } catch (JavascriptException je) {
            logger.info("JavascriptException handled for method - clickID_JS");
        }
    }

    public static void clickXpath_JS(String xpath) {
        System.out.println("Clicking " + xpath);
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

    public static void scrollBy_JS(String xpath) {
        BrowserInitHelper.getWaiter().until(ExpectedConditions.elementToBeClickable(By.xpath(xpath)));
        WebElement Div_Element = BrowserInitHelper.getInstance().findElement(By.xpath(xpath));

        JavascriptExecutor jse = (JavascriptExecutor) BrowserInitHelper.getInstance();
        jse.executeScript("arguments[0].scrollIntoView(true)", Div_Element);
    }

    public static void scrollBy_JSWithValue(int value) {
        try {
            JavascriptExecutor jse = (JavascriptExecutor) BrowserInitHelper.getInstance();
            jse.executeScript("window.scrollBy(0,-" + value + ");");
            DriverHelper.WaitUntilLoad(1000);
        } catch (Exception e) {
            System.out.println("Exception handled for method - scrollBy_JSWithValue");
        }
    }

    public static void waitTillPageLoad() {
        try {
            BrowserInitHelper.getInstance().manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
        } catch (TimeoutException te) {

        }
    }

    public static void scrollIntoView(String xpath) {
        try {
            WebElement element = BrowserInitHelper.getInstance().findElement(By.xpath(xpath));
            ((JavascriptExecutor) BrowserInitHelper.getInstance()).executeScript("arguments[0].scrollIntoView(true);", element);
            Thread.sleep(2000);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Exception handled....");
        }
    }

    public static void scrollUp() {
        try {
            JavascriptExecutor js = (JavascriptExecutor) BrowserInitHelper.getInstance();
            js.executeScript("window.scrollBy(0,0)");
            Thread.sleep(3000);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static String getItemCountValue() {
        try {
            JavascriptExecutor js = (JavascriptExecutor) BrowserInitHelper.getInstance();
            Object val = js.executeScript("return document.querySelector('#questions-list>div>div>input').value;");
            return val.toString();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static void MultipleClickByID_Javascript(String value) {
        //split value by comma and add in list
        List<String> SplittedList = Arrays.asList(value.split(","));

        for (int i = 0; i < SplittedList.size(); i++) {
            JavascriptExecutor js = (JavascriptExecutor) BrowserInitHelper.getInstance();
            js.executeScript("return document.getElementById('" + SplittedList.get(i) + "').click();");
        }
    }

    public static void ClickByID_Javascript(String id) {
        try {
            JavascriptExecutor js = (JavascriptExecutor) BrowserInitHelper.getInstance();
            js.executeScript("return document.getElementById('" + id + "').click();");
        } catch (JavascriptException je) {
            je.printStackTrace();
        }
    }

    public static void click_Xpath(String xPath) {
        WebElement Element = BrowserInitHelper.getInstance().findElement(By.xpath(xPath));
        JavascriptExecutor js = (JavascriptExecutor) BrowserInitHelper.getInstance();
        js.executeScript("arguments[0].click();", Element);
    }

    public static void sendTextByID(String ID, String value) {
        JavascriptExecutor js = (JavascriptExecutor) BrowserInitHelper.getInstance();
        js.executeScript("return document.getElementById('" + ID + "').value = '" + value + "';");
    }

    public static void scrollDownByPixels(int pixels) {
        JavascriptExecutor js = (JavascriptExecutor) BrowserInitHelper.getInstance();
        js.executeScript("scroll(0, " + pixels + ");");
    }

    public static String getCheckboxStatus(String checkBoxID) {
        Object val = null;
        JavascriptExecutor js = (JavascriptExecutor) BrowserInitHelper.getInstance();
        val = js.executeScript("return document.getElementById('" + checkBoxID + "').checked;");
        return val.toString();
    }

    public static void scrollIntoViewById(String id) {
        WebElement Element = BrowserInitHelper.getInstance().findElement(By.id(id));
        JavascriptExecutor js = (JavascriptExecutor) BrowserInitHelper.getInstance();
        js.executeScript("arguments[0].scrollIntoView()", Element);
    }

    public static String getToggleButtonState(String ID) {
        return (((JavascriptExecutor) BrowserInitHelper.getInstance()).executeScript("return document.getElementById('" + ID + "').checked;")).toString();
    }



}