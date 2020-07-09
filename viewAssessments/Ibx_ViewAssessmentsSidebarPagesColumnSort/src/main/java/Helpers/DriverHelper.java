package Helpers;

import Utils.ConsoleLogger;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.io.PrintWriter;
import java.time.LocalDateTime;

import static Helpers.JavascriptHelper.highlight;
import static Helpers.LoggerHelper.logger;

/**** DriverHelper *****/

/****Test Class for DriverHelper *****/
public class DriverHelper {
    private static String dir = System.getProperty("user.dir");
    private static int screenshotCounter = 0;
    private static PrintWriter writer;


    /**
     * Driver and Waiter MethodsclickXpath
     */

    public static void clickXpath(String xpath) {
        logger(BrowserInitHelper.getInstance());
        highlight(BrowserInitHelper.getWaiter().until(ExpectedConditions.elementToBeClickable(By.xpath(xpath))));
        BrowserInitHelper.getWaiter().until(ExpectedConditions.elementToBeClickable(By.xpath(xpath))).click();
    }

    public static void clickId(String id) {
        logger(BrowserInitHelper.getInstance());
        highlight(BrowserInitHelper.getWaiter().until(ExpectedConditions.elementToBeClickable(By.id(id))));
        BrowserInitHelper.getWaiter().until(ExpectedConditions.elementToBeClickable(By.id(id))).click();
    }

    public static void sendKeysXpath(String xpath, String text) {
        logger(BrowserInitHelper.getInstance());
        highlight(BrowserInitHelper.getWaiter().until(ExpectedConditions.elementToBeClickable(By.xpath(xpath))));
        BrowserInitHelper.getWaiter().until(ExpectedConditions.elementToBeClickable(By.xpath(xpath))).clear();
        BrowserInitHelper.getWaiter().until(ExpectedConditions.elementToBeClickable(By.xpath(xpath))).sendKeys(text);
    }

    public static void sendKeysId(String id, String text) {
        logger(BrowserInitHelper.getInstance());
        highlight(BrowserInitHelper.getWaiter().until(ExpectedConditions.elementToBeClickable(By.id(id))));
        BrowserInitHelper.getWaiter().until(ExpectedConditions.elementToBeClickable(By.id(id))).clear();
        BrowserInitHelper.getWaiter().until(ExpectedConditions.elementToBeClickable(By.id(id))).sendKeys(text);
    }


    public static String getText(String xpath) {
        String text = BrowserInitHelper.getWaiter().until(ExpectedConditions.elementToBeClickable(By.xpath(xpath))).getText();
        return text;
    }

    public static void WaitUntilLoad(long s) {
        try {
            Thread.sleep(s);
        } catch (InterruptedException ie) {
            System.out.println("InterruptedException handled....");
        }
    }

    public static void WaitUntilLoad_Click(long s, String xpath) {
        try {
            Thread.sleep(s);
            BrowserInitHelper.getWaiter().until(ExpectedConditions.elementToBeClickable(By.xpath(xpath)));
            BrowserInitHelper.getInstance().findElement(By.xpath(xpath)).click();
        } catch (InterruptedException ie) {
            System.out.println("InterruptedException handled....");
        } catch (Exception e) {
            System.out.println("Exception handled....");
        }
    }

    public static String getPath(String path) {
        String regex = "\\\\";
        String subst = "/";
        String value;
        String os = System.getProperty("os.name");

        if (os.contains("Windows") || os.contains("windows")) {
            value = path;
            System.out.println("Os is Windows.....");
        } else {
            Pattern pattern = Pattern.compile(regex, Pattern.MULTILINE);
            Matcher matcher = pattern.matcher(path);
            value = matcher.replaceAll(subst);
            System.out.println("Os is Linux.....");
        }

        System.out.println("Result ==>" + value);

        return value;
    }

    public static void setPassword_JS(String value) {
        JavascriptExecutor js = (JavascriptExecutor) BrowserInitHelper.getInstance();
        js.executeScript("document.getElementsByName('password').item(0).value = '" + value + "';");
    }

    public static boolean elementExistenceXpath(String xPath) {
        try {
            BrowserInitHelper.getWaiter().until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xPath)));
            if (BrowserInitHelper.getInstance().findElement(By.xpath(xPath)).isDisplayed()) {
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public static void waitUntilLoaderInvisible() {
        //BrowserInitHelper.getWaiter().until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@id='divPageLoading']")));
        BrowserInitHelper.getWaiter().until(ExpectedConditions.invisibilityOf(BrowserInitHelper.getInstance().findElement(By.xpath("//div[@id='divPageLoading']"))));
    }

    public static void assertion(String xpath, String expected) {
        Assert.assertEquals(BrowserInitHelper.getWaiter().until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath))).getText().trim(), expected);
    }

    public static void waitForPageLoadComplete() {
        ExpectedCondition<Boolean> pageLoadCondition = new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver driver) {
                return ((JavascriptExecutor) driver).executeScript("return document.readyState").equals("complete");
            }
        };
        WebDriverWait wait = new WebDriverWait(BrowserInitHelper.getInstance(), 30);
        wait.until(pageLoadCondition);
    }

    public String getClassName(WebElement element) {
        String className = "";
        BrowserInitHelper.getWaiter().until(ExpectedConditions.elementToBeClickable(element));
        className = element.getAttribute("class").trim();
        return className;
    }

    public static WebElement getElementByXpath(String elementXpath) {
        BrowserInitHelper.getWaiter().until(ExpectedConditions.visibilityOfElementLocated(By.xpath(elementXpath)));
        WebElement element = BrowserInitHelper.getInstance().findElement(By.xpath(elementXpath));
        return element;
    }

    public WebElement getElementByID(String elementID) {
        BrowserInitHelper.getWaiter().until(ExpectedConditions.visibilityOfElementLocated(By.id(elementID)));
        WebElement element = BrowserInitHelper.getInstance().findElement(By.id(elementID));
        return element;
    }

    public void clickCss(String css) {
        BrowserInitHelper.getWaiter().until(ExpectedConditions.elementToBeClickable(By.cssSelector(css))).click();
    }

    public String getAdminMethodCheckboxID(String checkboxName) {
        String ID = BrowserInitHelper.getInstance().findElement(By.xpath("//*[normalize-space(.) = '" + checkboxName + "']/parent::label")).getAttribute("id");
        JavascriptExecutor js = (JavascriptExecutor) BrowserInitHelper.getInstance();
        System.out.println("ID: " + ID);
        Object Val = js.executeScript("return document.getElementById(\"" + ID + "\").children[1].getAttribute(\"id\");");
        return Val.toString();
    }

    public String getOnlineToolsCheckboxID(String checkboxName) {
        String spanID = BrowserInitHelper.getInstance().findElement(By.xpath("//span[normalize-space(.) = '" + checkboxName + "']")).getAttribute("id");
        JavascriptExecutor js = (JavascriptExecutor) BrowserInitHelper.getInstance();
        System.out.println("spanID: " + spanID);
        Object Val = js.executeScript("return document.getElementById(\"" + spanID + "\").nextSibling.getAttribute(\"id\");");
        return Val.toString();
    }

    public Boolean getChecked(String id) {
        Boolean value = false;

        JavascriptExecutor js = (JavascriptExecutor) BrowserInitHelper.getInstance();
        System.out.println("instance-->" + BrowserInitHelper.getInstance());
        System.out.println("js-->" + js);
        Object Check = js.executeScript("return document.getElementById('" + id + "').checked;");

        if (Check.toString().equalsIgnoreCase("true")) {
            value = true;
        }

        return value;
    }

    public static void waitUntil(String xpath) {
        BrowserInitHelper.getWaiter().until(ExpectedConditions.elementToBeClickable(By.xpath(xpath)));
    }

    public static void waitUntilElementInvisible_ByXPath(String xpath) {
        BrowserInitHelper.getWaiter().until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(xpath)));
    }

    public void sendKeysCss(String css, String text) {
        BrowserInitHelper.getWaiter().until(ExpectedConditions.elementToBeClickable(By.cssSelector(css))).clear();
        BrowserInitHelper.getWaiter().until(ExpectedConditions.elementToBeClickable(By.cssSelector(css))).sendKeys(text);
    }

    public void clickCSSSelector(String css) {
        BrowserInitHelper.getWaiter().until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(css)));
        BrowserInitHelper.getWaiter().until(ExpectedConditions.elementToBeClickable(By.cssSelector(css))).click();
    }

    public static boolean verifyElementTextByXpath(String xpath, String text) {
        boolean res = false;
        try {
            BrowserInitHelper.getWaiter().until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
            if (BrowserInitHelper.getInstance().findElement(By.xpath(xpath)).getText().contains(text)) {
                res = true;
            } else {
                return res;
            }
        } catch (Exception e) {
            e.printStackTrace();
            ConsoleLogger.DebugLog("Specified element text doesn't match with  the actual value.");
        }
        return res;
    }

    public static boolean verifyDisplayByXpath(String xpath) {
        boolean res = false;
        try {
            BrowserInitHelper.getWaiter().until(ExpectedConditions.elementToBeClickable(By.xpath(xpath)));
            if (BrowserInitHelper.getInstance().findElement(By.xpath(xpath)).isDisplayed()) {
                res = true;
            } else
                return res;
        } catch (Exception e) {
            ConsoleLogger.DebugLog(xpath + " Unable to find the specified " + xpath + " element.");
        }
        return res;
    }

    public static String getReplacedLocator(String toReplace, String xpath) {
        String value = null;
        try {
            value = xpath;
            value = value.replace("TOREPLACE", toReplace);

        } catch (Exception e) {
            System.out.println("Exception handled for getReplacedLocator");
        }
        return value;
    }

    public static boolean replaceAndVerifyTextByXpath(String replaceValue, String xpath, String text) {
        boolean res = false;
        String str = null;
        try {
            BrowserInitHelper.getWaiter().until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
            str = text.replace(replaceValue, "");
            if (BrowserInitHelper.getInstance().findElement(By.xpath(xpath)).getText().contains(str)) {
                res = true;
            } else {
                return res;
            }
        } catch (Exception e) {
            e.printStackTrace();
            ConsoleLogger.ErrorLog("Specified element text doesn't match with  the actual value.");
        }
        return res;
    }

    public static void createTeacherRubric(String createTeacherRubricButton, String teacherRubricNameTextbox, String teacherRubricName,
                                           String teacherRubricCKEditor, String teacherRubric, String saveButton, String cancelButton, String rubricSavedAlert) {
        /*Click Teacher Create Button*/
        DriverHelper.clickXpath(createTeacherRubricButton);

        /*Enter the Teacher Rubric Name*/
        DriverHelper.sendKeysXpath(teacherRubricNameTextbox, teacherRubricName);

        /*Enter the Teacher Rubric in CK editor*/
        DriverHelper.sendKeysXpath(teacherRubricCKEditor, teacherRubric);

        /*Click Save button*/
        //DriverHelper.clickXpath(akoAssessmentSetupPage.getTeacherRubricSaveButton());
        JavascriptHelper.click_Xpath(saveButton);

        BrowserInitHelper.getWaiter().until(ExpectedConditions.visibilityOfElementLocated(By.xpath("" + rubricSavedAlert + "")));

        /*Click Cancel button*/
        //DriverHelper.clickXpath(akoAssessmentSetupPage.getTeacherRubricCancelButton());
        JavascriptHelper.click_Xpath(cancelButton);
    }

    public static void createStudentRubric(String expandIcon, String createStudentRubricButton, String studentRubricNameTextbox, String studentRubricName,
                                           String studentRubricCKEditor, String studentRubric, String saveButton, String cancelButton, String rubricSavedAlert) {
        //JavascriptHelper.scrollIntoView(expandIcon);

        /*Click Student Create Button*/
        DriverHelper.clickXpath(createStudentRubricButton);

        /*Enter the Student Rubric Name*/
        DriverHelper.sendKeysXpath(studentRubricNameTextbox, studentRubricName);

        /*Enter the Student Rubric in CK editor*/
        DriverHelper.sendKeysXpath(studentRubricCKEditor, studentRubric);

        /*Click Save button*/
        //DriverHelper.clickXpath(akoAssessmentSetupPage.getTeacherRubricSaveButton());
        JavascriptHelper.click_Xpath(saveButton);

        BrowserInitHelper.getWaiter().until(ExpectedConditions.visibilityOfElementLocated(By.xpath("" + rubricSavedAlert + "")));

        /*Click Cancel button*/
        //DriverHelper.clickXpath(akoAssessmentSetupPage.getTeacherRubricCancelButton());
        JavascriptHelper.click_Xpath(cancelButton);
    }

    //To Upload File
    public static void UploadFile(WebElement uploadElement, String uploadFilePath) {
        try {
            System.out.println("uploadFilePath: " + uploadFilePath);
            uploadElement.click();
            Thread.sleep(3000);
            //Store the location of the file in clipboard
            //Clipboard
            StringSelection strSel = new StringSelection(uploadFilePath);
            Toolkit.getDefaultToolkit().getSystemClipboard().setContents(strSel, null);

            //Create an object for robot class
            Robot robot = new Robot();
            //Control key in the keyboard
            //Ctrl+V
            robot.keyPress(KeyEvent.VK_CONTROL);
            robot.keyPress(KeyEvent.VK_V);
            robot.keyRelease(KeyEvent.VK_CONTROL);

            Thread.sleep(3000);
            robot.keyPress(KeyEvent.VK_ENTER);
            robot.keyRelease(KeyEvent.VK_ENTER);
        } catch (InterruptedException ie) {
            //log.info("InterruptedException handled.....");
        } catch (AWTException awt) {
            //log.info("AWTException handled");
        } catch (Exception e) {
            //log.info("Exception handled");
        }
    }

    public static void uploadRubric(String uploadButtonXpath, String rubricNameXpath, String uploadRubricDropZone, String rubricName,
                                    String uploadFilePath, String uploadSuccessIcon, String saveRubricXpath, String savedAlertXpath) {
        //Helper objHelper = new Helper();
        DriverHelper.clickXpath(uploadButtonXpath);

        waitUntilLoaderInvisible();

        DriverHelper.sendKeysXpath(rubricNameXpath, rubricName);

        //JavascriptHelper.scrollIntoView(uploadButtonXpath);

        WebElement uploadDropZone = BrowserInitHelper.getInstance().findElement(By.xpath(uploadRubricDropZone));

        //Call hepler method for File Upload
        UploadFile(uploadDropZone, uploadFilePath);

        waitUntil(uploadSuccessIcon);

        DriverHelper.clickXpath(saveRubricXpath);

        waitUntilLoaderInvisible();

        BrowserInitHelper.getWaiter().until(ExpectedConditions.visibilityOfElementLocated(By.xpath(savedAlertXpath)));
        //DriverHelper.clickXpath(closeAlertXpath);

        //DriverHelper.clickXpath(uploadButtonXpath);
    }

    public static void selectAvailableRubric(String selectAvailableRubricButton, String availableRubricsTextbox, String rubricName,
                                             String searchIcon, String selectRubricsButton, String exitButton, String saveButton, String savedAlertXpath) {
        try {
            //DriverHelper.clickXpath(selectAvailableRubricButton);
            JavascriptHelper.click_Xpath(selectAvailableRubricButton);

            waitUntilLoaderInvisible();

            Thread.sleep(3000);

            BrowserInitHelper.getWaiter().until(ExpectedConditions.elementToBeClickable(By.xpath(availableRubricsTextbox)));

            DriverHelper.sendKeysXpath(availableRubricsTextbox, rubricName);

            JavascriptHelper.click_Xpath(searchIcon);
            //DriverHelper.clickXpath(searchIcon);

            waitUntilLoaderInvisible();

            Thread.sleep(3000);

            BrowserInitHelper.getInstance().findElement(By.xpath("//a[text() = '" + rubricName + "']/parent::td/preceding-sibling::td/input")).click();

            Thread.sleep(2000);

            DriverHelper.clickXpath(selectRubricsButton);

            //DriverHelper.clickXpath(exitButton);

            JavascriptHelper.click_Xpath(saveButton);

            BrowserInitHelper.getWaiter().until(ExpectedConditions.visibilityOfElementLocated(By.xpath(savedAlertXpath)));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void waitTill(long timeToWait) {
        try {
            Thread.sleep(timeToWait * 1000);
        } catch (Exception e) {
            System.out.println("Exception handled for method - waitTill");
        }
    }

    public static boolean checkElementDisplayByXpath(String locator, String elementName) {
        boolean value = false;
        try {
            BrowserInitHelper.getWaiter().until(ExpectedConditions.elementToBeClickable(By.xpath(locator)));
            value = true;
            ConsoleLogger.SuccessLog("" + elementName + " is displayed.....");
        } catch (Exception e) {
            System.out.println("Exception handled for " + e);
            ConsoleLogger.FailedTestCase("" + elementName + " is NOT displayed.....!!!");
        }
        return value;
    }

    public static boolean checkElementDisplayByCSS(String locator, String elementName) {
        boolean value = false;
        try {
            BrowserInitHelper.getWaiter().until(ExpectedConditions.elementToBeClickable(By.cssSelector(locator)));
            value = true;
            ConsoleLogger.SuccessLog("" + elementName + " is displayed.....");
        } catch (Exception e) {
            System.out.println("Exception handled for " + e);
            ConsoleLogger.FailedTestCase("" + elementName + " is NOT displayed.....!!!");
        }
        return value;
    }
}

//package Helpers;
//
//import org.openqa.selenium.By;
//import org.openqa.selenium.TimeoutException;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.support.ui.ExpectedConditions;
//import org.openqa.selenium.support.ui.WebDriverWait;
//
//import java.io.PrintWriter;
//import java.time.LocalDateTime;
//
//import static Helpers.JavascriptHelper.highlight;
//import static Helpers.LoggerHelper.logger;
//
//public class DriverHelper {
//    private static String dir = System.getProperty("user.dir");
//    private static int screenshotCounter = 0;
//    private static LocalDateTime now = LocalDateTime.now();
//    private static PrintWriter writer;
//
//
//    /**
//     * Driver and Waiter MethodsclickXpath
//     */
//
//    public static void clickXpath(String xpath) {
//        logger(BrowserInitHelper.getInstance());
//        highlight(BrowserInitHelper.getWaiter().until(ExpectedConditions.elementToBeClickable(By.xpath(xpath))));
//        BrowserInitHelper.getWaiter().until(ExpectedConditions.elementToBeClickable(By.xpath(xpath))).click();
//    }
//
//    public static void clickId(String id) {
//        logger(BrowserInitHelper.getInstance());
//        highlight(BrowserInitHelper.getWaiter().until(ExpectedConditions.elementToBeClickable(By.id(id))));
//        BrowserInitHelper.getWaiter().until(ExpectedConditions.elementToBeClickable(By.id(id))).click();
//    }
//
//    public static void sendKeysXpath(String xpath, String text) {
//        logger(BrowserInitHelper.getInstance());
//        highlight(BrowserInitHelper.getWaiter().until(ExpectedConditions.elementToBeClickable(By.xpath(xpath))));
//        BrowserInitHelper.getWaiter().until(ExpectedConditions.elementToBeClickable(By.xpath(xpath))).clear();
//        BrowserInitHelper.getWaiter().until(ExpectedConditions.elementToBeClickable(By.xpath(xpath))).sendKeys(text);
//    }
//
//    public static void sendKeysId(String id, String text) {
//        logger(BrowserInitHelper.getInstance());
//        highlight(BrowserInitHelper.getWaiter().until(ExpectedConditions.elementToBeClickable(By.id(id))));
//        BrowserInitHelper.getWaiter().until(ExpectedConditions.elementToBeClickable(By.id(id))).clear();
//        BrowserInitHelper.getWaiter().until(ExpectedConditions.elementToBeClickable(By.id(id))).sendKeys(text);
//    }
//
//
//    public static String getText(String xpath) {
//        String text = BrowserInitHelper.getWaiter().until(ExpectedConditions.elementToBeClickable(By.xpath(xpath))).getText();
//        return text;
//    }
//
//    public static void waitTillElement(String xpath) {
//        boolean check = true;
//
//        while (check) {
//            try {
//                Thread.sleep(2000);
//                BrowserInitHelper.getInstance().findElement(By.xpath(xpath));
//                check = false;
//                break;
//            } catch (TimeoutException te) {
//                check = true;
//            } catch (InterruptedException e) {
//                check = true;
//            } catch (Exception e) {
//                check = true;
//            }
//        }
//    }
//}
