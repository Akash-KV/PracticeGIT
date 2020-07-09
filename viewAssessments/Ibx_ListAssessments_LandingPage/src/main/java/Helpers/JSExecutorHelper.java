package Helpers;

import org.openqa.selenium.JavascriptExecutor;

//Helpers class for JSexecutorHelper
public class JSExecutorHelper {
    /*
    Methods of JavaScriptExecutor
    */
    public static void waitUntilDocumentIsReady() {
        ((JavascriptExecutor) BrowserInitHelper.getInstance()).executeScript("return document.readyState").equals("complete");
    }

    public static void waitUntilAjaxLoaded() {
        while (true) {
            Object value = ((JavascriptExecutor) BrowserInitHelper.getInstance()).executeScript("return jQuery.active == 0");
            if (value.toString().equalsIgnoreCase("true")) {
                break;
            }
        }
    }
}
