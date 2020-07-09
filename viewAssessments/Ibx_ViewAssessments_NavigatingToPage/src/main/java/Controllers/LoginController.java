package Controllers;

import Helpers.BrowserInitHelper;
import Pom.ViewAssessmentsPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static Helpers.LoggerHelper.logger;

import static Helpers.JavascriptHelper.highlight;

public class LoginController {
    ViewAssessmentsPage viewAssessmentsPage = new ViewAssessmentsPage();

    //Login when AUTH is OFF
    public static void login(String un, String pw) {
        logger(BrowserInitHelper.getInstance());
        highlight(BrowserInitHelper.getWaiter().until(ExpectedConditions.elementToBeClickable(By.id("username"))));
        BrowserInitHelper.getWaiter().until(ExpectedConditions.elementToBeClickable(By.id("username"))).clear();
        BrowserInitHelper.getWaiter().until(ExpectedConditions.elementToBeClickable(By.id("username"))).sendKeys(un);
        highlight(BrowserInitHelper.getWaiter().until(ExpectedConditions.elementToBeClickable(By.id("password"))));
        BrowserInitHelper.getWaiter().until(ExpectedConditions.elementToBeClickable(By.id("password"))).clear();
        BrowserInitHelper.getWaiter().until(ExpectedConditions.elementToBeClickable(By.id("password"))).sendKeys(pw);
        BrowserInitHelper.getWaiter().until(ExpectedConditions.elementToBeClickable(By.id("button_next"))).click();
    }

    //Login when AUTH is ON
//    public static void loginAuthXSite(String un, String pw) {
//        // logger(BrowserInitHelper.getInstance());
//        highlight(BrowserInitHelper.getWaiter().until(ExpectedConditions.elementToBeClickable(By.name("username"))));
//        BrowserInitHelper.getWaiter().until(ExpectedConditions.elementToBeClickable(By.name("username"))).clear();
//        BrowserInitHelper.getWaiter().until(ExpectedConditions.elementToBeClickable(By.name("username"))).sendKeys(un);
//        highlight(BrowserInitHelper.getWaiter().until(ExpectedConditions.elementToBeClickable(By.name("password"))));
//        BrowserInitHelper.getWaiter().until(ExpectedConditions.elementToBeClickable(By.name("password"))).clear();
//        BrowserInitHelper.getWaiter().until(ExpectedConditions.elementToBeClickable(By.name("password"))).sendKeys(pw);
//        BrowserInitHelper.getWaiter().until(ExpectedConditions.elementToBeClickable(By.xpath("//button[.='Sign In']"))).click();
//    }
    public static void loginAuthXSite(String un, String pw) {
        highlight(BrowserInitHelper.getWaiter().until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@name='username']"))));
        BrowserInitHelper.getWaiter().until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@name='username']"))).clear();
        BrowserInitHelper.getWaiter().until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@name='username']"))).sendKeys(un);
        highlight(BrowserInitHelper.getWaiter().until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@name='password']"))));
        BrowserInitHelper.getWaiter().until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@name='password']"))).clear();
        BrowserInitHelper.getWaiter().until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@name='password']"))).sendKeys(pw);
        BrowserInitHelper.getWaiter().until(ExpectedConditions.elementToBeClickable(By.xpath("//span[normalize-space(text())='Sign In']"))).click();
    }

    //Check the Popup
    public void checkPopup() {
        try {
            BrowserInitHelper.getWaiter().until(ExpectedConditions.elementToBeClickable(By.xpath(viewAssessmentsPage.getPopup())));
            WebElement popup = BrowserInitHelper.getInstance().findElement(By.xpath(viewAssessmentsPage.getPopup()));
            Actions action = new Actions(BrowserInitHelper.getInstance());
            action.moveToElement(popup).click().perform();
            Thread.sleep(2000);
        } catch (Exception e) {
            System.out.println("Exception handled for alert popup.......");
        }
    }

}
