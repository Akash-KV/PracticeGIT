package Helpers;

import org.openqa.selenium.JavascriptExecutor;

//Test Class for JSExecutorHelper
public class JSExecutorHelper {
    public static void waitUntilDocumentIsReady() {
        ((JavascriptExecutor) BrowserInitHelper.getInstance()).executeScript("return document.readyState").equals("complete");
    }
}
