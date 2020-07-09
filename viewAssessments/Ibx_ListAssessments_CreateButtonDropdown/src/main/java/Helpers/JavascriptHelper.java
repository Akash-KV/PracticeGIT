package Helpers;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

public class JavascriptHelper {

    public static void highlight(WebElement element) { // add int duration in parameters passed
        JavascriptExecutor js = (JavascriptExecutor) BrowserInitHelper.getInstance();
        String originalStyle = element.getAttribute("style");
        js.executeScript("arguments[0].setAttribute('style', 'background: yellow; border: 4px solid red;');", element);
        DriverHelper.waitTill(1);
        js.executeScript("arguments[0].setAttribute('style', 'background: white; border: 1px solid black;');", element);
    }

    public static void scrolTop() {
        try {
            DriverHelper.waitTill(2);
            ((JavascriptExecutor) BrowserInitHelper.getInstance()).executeScript("window.scrollTo(0,0);");
            DriverHelper.waitTill(2);
        } catch (Exception e) {
            System.out.println("Exception handled for method - scrolTop");
        }
    }
}
