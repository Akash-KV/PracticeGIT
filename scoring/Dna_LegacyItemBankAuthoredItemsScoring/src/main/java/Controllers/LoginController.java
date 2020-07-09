package Controllers;

import Helpers.BrowserInitHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static Helpers.LoggerHelper.logger;

import static Helpers.JavascriptHelper.highlight;

//Controller class for login controller
public class LoginController {
    //Method to login
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

    //Method to Login in Authx
    public static void loginAuthXSite(String un, String pw) {
        // logger(BrowserInitHelper.getInstance());
        highlight(BrowserInitHelper.getWaiter().until(ExpectedConditions.elementToBeClickable(By.name("username"))));
        BrowserInitHelper.getWaiter().until(ExpectedConditions.elementToBeClickable(By.name("username"))).clear();
        BrowserInitHelper.getWaiter().until(ExpectedConditions.elementToBeClickable(By.name("username"))).sendKeys(un);
        highlight(BrowserInitHelper.getWaiter().until(ExpectedConditions.elementToBeClickable(By.name("password"))));
        BrowserInitHelper.getWaiter().until(ExpectedConditions.elementToBeClickable(By.name("password"))).clear();
        BrowserInitHelper.getWaiter().until(ExpectedConditions.elementToBeClickable(By.name("password"))).sendKeys(pw);
        BrowserInitHelper.getWaiter().until(ExpectedConditions.elementToBeClickable(By.xpath("//button[.='Sign In']"))).click();
    }
}
