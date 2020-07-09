package Controllers;

import Helpers.BrowserInitHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static Helpers.JavascriptHelper.highlight;

/**** Test Class for Login Controller *****/
public class LoginController {

    public static void login(String un, String pw) {
        // logger(BrowserInitHelper.getInstance());
        highlight(BrowserInitHelper.getWaiter().until(ExpectedConditions.elementToBeClickable(By.id("username"))));
        BrowserInitHelper.getWaiter().until(ExpectedConditions.elementToBeClickable(By.id("username"))).clear();
        BrowserInitHelper.getWaiter().until(ExpectedConditions.elementToBeClickable(By.id("username"))).sendKeys(un);
        highlight(BrowserInitHelper.getWaiter().until(ExpectedConditions.elementToBeClickable(By.id("password"))));
        BrowserInitHelper.getWaiter().until(ExpectedConditions.elementToBeClickable(By.id("password"))).clear();
        BrowserInitHelper.getWaiter().until(ExpectedConditions.elementToBeClickable(By.id("password"))).sendKeys(pw);
        BrowserInitHelper.getWaiter().until(ExpectedConditions.elementToBeClickable(By.id("button_next"))).click();
    }

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
}
