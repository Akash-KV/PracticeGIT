package Helpers;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * Helpers class for Javascript
 **/
public class JavascriptHelper {

    //Logger and WebDrivers
    private static final Logger logger = LoggerFactory.getLogger(JavascriptHelper.class);

    // To highlight Web Element
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

    // To close browser popup
    public static void closeBrowserPopup() {
        ((JavascriptExecutor) BrowserInitHelper.getInstance()).executeScript("window.onbeforeunload = function(e){};");
    }

    // To send integer values using Xpath
    public static void SendKeysINTEGER_JS_xpath(String xpath, double textBoxValue) {
        WebElement searchField = BrowserInitHelper.getInstance().findElement(By.xpath(xpath));
        JavascriptExecutor js = (JavascriptExecutor) BrowserInitHelper.getInstance();
        js.executeScript("arguments[0].setAttribute('value', '" + textBoxValue + "')", searchField);
    }

    // To Wait until ajax load
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

    // To scroll top of the page
    public static void scrollUp() {
        try {
            JavascriptExecutor js = (JavascriptExecutor) BrowserInitHelper.getInstance();
            js.executeScript("window.scrollBy(0,0)");
            Thread.sleep(3000);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // To scroll down using pixels value
    public static void scrollDownByPixels(int pixels) {
        JavascriptExecutor js = (JavascriptExecutor) BrowserInitHelper.getInstance();
        js.executeScript("scroll(0, " + pixels + ");");
    }

    // To scroll into elements using Web Element
    public static void scrollElementIntoView(WebElement Element) {
        JavascriptExecutor js = (JavascriptExecutor) BrowserInitHelper.getInstance();
        js.executeScript("arguments[0].scrollIntoView()", Element);
    }

    // To check status of the checkbox
    public static String getCheckboxStatus(String checkBoxID) {
        Object val = null;
        JavascriptExecutor js = (JavascriptExecutor) BrowserInitHelper.getInstance();
        val = js.executeScript("return document.getElementById('" + checkBoxID + "').checked;");
        return val.toString();
    }

    // To clear text box using Xpath
    public static void Clear_JS_xpath(String xpath) {
        WebElement searchField = BrowserInitHelper.getInstance().findElement(By.xpath(xpath));
        ((JavascriptExecutor) BrowserInitHelper.getInstance()).executeScript("arguments[0].value = '';", searchField);
    }

    // To scroll till bottom of the page
    public static void scrollBottomOfThePage() {
        try {
            Thread.sleep(2000);
            ((JavascriptExecutor) BrowserInitHelper.getInstance()).executeScript("window.scrollTo(0, document.body.scrollHeight)");
            Thread.sleep(2000);
        } catch (Exception e) {
            System.out.println("Exception handled for method - scrolTop");
        }
    }

    // To get Toggle Button State
    public static String getToggleButtonState(String ID) {
        return (((JavascriptExecutor) BrowserInitHelper.getInstance()).executeScript("return document.getElementById('" + ID + "').checked;")).toString();
    }

    // To scroll till element using location
    public static void ScrollTillElement_Javascript(String xpath) {
        WebElement element = BrowserInitHelper.getInstance().findElement(By.xpath(xpath));
        JavascriptExecutor js = (JavascriptExecutor) BrowserInitHelper.getInstance();
        js.executeScript("window.scrollTo(arguments[0],arguments[1])", element.getLocation().x, element.getLocation().y);
    }

    // To compare and check element by Id
    public static boolean compareAndCheckElementById(String eleId, String reqStatus) {
        boolean res = false;
        try {
            String elementStatus = JavascriptHelper.getToggleButtonState(eleId);
            if (elementStatus.equalsIgnoreCase(reqStatus)) {
                System.out.println("For the element -- " + eleId + " -- default status -- " + reqStatus + " -- & Required status  -- " + reqStatus + " -- both are matching");
                res = true;
            } else {
                JavascriptHelper.ClickByID_Javascript(eleId);
                System.out.println("Required to change the -- " + eleId + " -- element from default status -- " + reqStatus + " -- to Required status  -- " + reqStatus + "");
            }
        } catch (Exception e) {
            System.out.println("Exception handled for verifyAndCheckElementById for the id :- " + eleId);
        }
        return res;
    }

    // To scroll in to element using Xpath
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

    // To Wait till page loads completely
    public static void waitTillPageLoad() {
        try {
            BrowserInitHelper.getInstance().manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
        } catch (TimeoutException te) {
        }
    }

    // To click using j Query
    public static void clickID_JS(String ID) {
        ((JavascriptExecutor) BrowserInitHelper.getInstance()).executeScript("return !!jQuery(\"#" + ID + "\").click();");
    }

    // To click using Xpath
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

    // To click using Id
    public static void ClickByID_Javascript(String id) {
        try {
            JavascriptExecutor js = (JavascriptExecutor) BrowserInitHelper.getInstance();
            js.executeScript("return document.getElementById('" + id + "').click();");
        } catch (JavascriptException je) {
            je.printStackTrace();
        }
    }

    // To send Values using Xpath
    public static void sendValuesByXpath_JS(String xPath, String value) {
        WebElement Element = BrowserInitHelper.getInstance().findElement(By.xpath(xPath));
        JavascriptExecutor js = (JavascriptExecutor) BrowserInitHelper.getInstance();
        String str = "arguments[0].value='" + value + "';";
        System.out.println("Stringvalue" + str);
        js.executeScript(str, Element);
    }

    // To send Values using Id
    public static void sendTextByID(String ID, String value) {
        JavascriptExecutor js = (JavascriptExecutor) BrowserInitHelper.getInstance();
        js.executeScript("return document.getElementById('" + ID + "').value = '" + value + "';");
    }

    // To click using Web Element
    public static void clickWebElement_JS(WebElement element) {
        try {
            if (element.isEnabled() && element.isDisplayed()) {
                System.out.println("Clicking on element with using java script click");
                ((JavascriptExecutor) BrowserInitHelper.getInstance()).executeScript("arguments[0].click();", element);
            } else {
                System.out.println("Unable to click on element");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Multiple click using Id
    public static void MultipleClickByID_Javascript(String value) {
        //split value by comma and add in list
        List<String> SplittedList = Arrays.asList(value.split(","));
        for (int i = 0; i < SplittedList.size(); i++) {
            JavascriptExecutor js = (JavascriptExecutor) BrowserInitHelper.getInstance();
            js.executeScript("return document.getElementById('" + SplittedList.get(i) + "').click();");
        }
    }


}
