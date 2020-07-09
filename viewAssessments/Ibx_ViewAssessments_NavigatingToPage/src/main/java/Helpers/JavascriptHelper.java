package Helpers;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

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
}
