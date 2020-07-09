package Helpers;

import org.openqa.selenium.JavascriptExecutor;

/**
 * Helpers class for JSExecutor
 **/

public class JSExecutorHelper {
    // To wait Untill the document is ready
    public static void waitUntilDocumentIsReady() {
        ((JavascriptExecutor) BrowserInitHelper.getInstance()).executeScript("return document.readyState").equals("complete");
    }
}
