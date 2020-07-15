package Helpers;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

//Helper class for javascript
public class JavascriptHelper {

    //Logger and WebDrivers
    private static final Logger logger = LoggerFactory.getLogger(JavascriptHelper.class);

    //method to highlight webelement
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

    //Method to click
    public static void clickID_JS(String ID) {
        ((JavascriptExecutor) BrowserInitHelper.getInstance()).executeScript("return !!jQuery(\"#" + ID + "\").click();");
    }

    //Method to scroll
    public static void scrollintoView(String ID) {
        WebElement element = BrowserInitHelper.getInstance().findElement(By.id(ID));
        ((JavascriptExecutor) BrowserInitHelper.getInstance()).executeScript("arguments[0].scrollIntoView(true);", element);
    }

    //method to scrollbyXpath
    public static void scrollintoViewXpath(String xpath) {
        try {
            WebElement element = BrowserInitHelper.getInstance().findElement(By.xpath(xpath));
            ((JavascriptExecutor) BrowserInitHelper.getInstance()).executeScript("arguments[0].scrollIntoView(true);", element);
            Thread.sleep(2000);
        } catch (Exception e) {
            System.out.println("Exception handled....");
        }
    }

    public static void scrollUp() {
        try {
            JavascriptExecutor js = (JavascriptExecutor) BrowserInitHelper.getInstance();
            js.executeScript("window.scrollTo(0,0);");
            Thread.sleep(3000);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void scrollintoViewByXpath(String xpath) {
        try {
            WebElement element = BrowserInitHelper.getInstance().findElement(By.xpath(xpath));
            ((JavascriptExecutor) BrowserInitHelper.getInstance()).executeScript("arguments[0].scrollIntoView(true);", element);
            Thread.sleep(2000);
        } catch (Exception e) {
            System.out.println("Exception handled....");
        }
    }
    public static void scrolBottomOfThePage() {
        try {
            Thread.sleep(2000);
            ((JavascriptExecutor) BrowserInitHelper.getInstance()).executeScript("window.scrollTo(0, document.body.scrollHeight)");
            Thread.sleep(2000);
        } catch (Exception e) {
            System.out.println("Exception handled for method - scrolTop");
        }
    }
    public static void ScrollTillElement_Javascript(String xpath) {
        WebElement element = BrowserInitHelper.getInstance().findElement(By.xpath(xpath));
        JavascriptExecutor js = (JavascriptExecutor) BrowserInitHelper.getInstance();
        js.executeScript("window.scrollTo(arguments[0],arguments[1])", element.getLocation().x, element.getLocation().y);
    }

    public static void click_Xpath(String xPath) {
        WebElement Element = BrowserInitHelper.getInstance().findElement(By.xpath(xPath));
        JavascriptExecutor js = (JavascriptExecutor) BrowserInitHelper.getInstance();
        js.executeScript("arguments[0].click();", Element);
    }

    public static void sendValuesByXpath_JS(String xPath, String value) {
        WebElement Element = BrowserInitHelper.getInstance().findElement(By.xpath(xPath));
        JavascriptExecutor js = (JavascriptExecutor) BrowserInitHelper.getInstance();
        String str = "arguments[0].value='" + value + "';";
        System.out.println("Stringvalue" + str);
        js.executeScript(str, Element);
    }

    //method to click xpath
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

    public static String getToggleButtonState(String ID) {
        return (((JavascriptExecutor) BrowserInitHelper.getInstance()).executeScript("return document.getElementById('" + ID + "').checked;")).toString();
    }

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

    public static void ClickByID_Javascript(String ID) {
        ((JavascriptExecutor) BrowserInitHelper.getInstance()).executeScript("return document.getElementById('" + ID + "').click();");
    }

    //Method to wait untill ajax load
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

    public static void scrolBottom() {
        try {
            Thread.sleep(2000);
            ((JavascriptExecutor) BrowserInitHelper.getInstance()).executeScript("window.scrollTo(0,document.body.scrollHeight);");
            Thread.sleep(2000);
        } catch (Exception e) {
            System.out.println("Exception handled for method - scrolTop");
        }
    }

}
