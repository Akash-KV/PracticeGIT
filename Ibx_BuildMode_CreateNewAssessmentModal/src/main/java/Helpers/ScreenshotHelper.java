package Helpers;

import Utils.Static;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;

/**
 * Test Class for ScreenshotHelper
 */
public class ScreenshotHelper {
    public static void screenshot(WebDriver driver) {
        try {
            String dir = null;
            dir = System.getProperty("user.dir");
            int screenshotCounter = 1;
            if (Static.getScreenshots().equals("true")) {
                String fileName = "screenshot_" + Integer.toString(screenshotCounter) + ".png";
                screenshotCounter++;
                String screenshotPath = "/target/screenshots/";
                File file = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
                FileUtils.copyFile(file, new File(dir + screenshotPath + fileName));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}