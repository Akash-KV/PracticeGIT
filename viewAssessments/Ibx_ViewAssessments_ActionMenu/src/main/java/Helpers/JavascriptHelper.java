package Helpers;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.JavascriptExecutor;

public class JavascriptHelper {

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

    public static void click_Xpath(String xPath) {
        WebElement Element = BrowserInitHelper.getInstance().findElement(By.xpath(xPath));
        JavascriptExecutor js = (JavascriptExecutor) BrowserInitHelper.getInstance();
        js.executeScript("arguments[0].click();", Element);
    }

    public static void clickID_JS(String ID) {
        ((JavascriptExecutor) BrowserInitHelper.getInstance()).executeScript("return !!jQuery(\"#" + ID + "\").click();");
    }

    public static void scrollBy_JS(String xpath) {
        BrowserInitHelper.getWaiter().until(ExpectedConditions.elementToBeClickable(By.xpath(xpath)));
        WebElement Div_Element = BrowserInitHelper.getInstance().findElement(By.xpath(xpath));
        JavascriptExecutor jse = (JavascriptExecutor) BrowserInitHelper.getInstance();
        jse.executeScript("arguments[0].scrollIntoView(true)", Div_Element);
    }

    public static String getToggleButtonState(String ID) {
        return (((JavascriptExecutor) BrowserInitHelper.getInstance()).executeScript("return document.getElementById('" + ID + "').checked;")).toString();
    }

    public static void ClickByID_Javascript(String ID) {
        ((JavascriptExecutor) BrowserInitHelper.getInstance()).executeScript("return document.getElementById('" + ID + "').click();");
    }

    public static void closeBrowserPopup() {
        ((JavascriptExecutor) BrowserInitHelper.getInstance()).executeScript("window.onbeforeunload = function(e){};");
    }

    public static void ScrollTillElement_Javascript(String xpath) {
        WebElement element = BrowserInitHelper.getInstance().findElement(By.xpath(xpath));
        JavascriptExecutor js = (JavascriptExecutor) BrowserInitHelper.getInstance();
        js.executeScript("window.scrollTo(arguments[0],arguments[1])", element.getLocation().x, element.getLocation().y);
    }

    public static void scrollIntoView(WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) BrowserInitHelper.getInstance();
        js.executeScript("arguments[0].scrollIntoView()", element);
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

    public static void waitUntilDocumentIsReady() {
        ((JavascriptExecutor) BrowserInitHelper.getInstance()).executeScript("return document.readyState").equals("complete");
    }
}
