package Controllers;

import Helpers.BrowserInitHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static Helpers.JavascriptHelper.highlight;

//Controller class for LoginController
public class LoginController {
    //Login when AUTH off
    public static void login(String un, String pw) {
        //logger(BrowserInitHelper.getInstance());
        highlight(BrowserInitHelper.getWaiter().until(ExpectedConditions.elementToBeClickable(By.id("username"))));
        BrowserInitHelper.getWaiter().until(ExpectedConditions.elementToBeClickable(By.id("username"))).clear();
        BrowserInitHelper.getWaiter().until(ExpectedConditions.elementToBeClickable(By.id("username"))).sendKeys(un);
        highlight(BrowserInitHelper.getWaiter().until(ExpectedConditions.elementToBeClickable(By.id("password"))));
        BrowserInitHelper.getWaiter().until(ExpectedConditions.elementToBeClickable(By.id("password"))).clear();
        BrowserInitHelper.getWaiter().until(ExpectedConditions.elementToBeClickable(By.id("password"))).sendKeys(pw);
        BrowserInitHelper.getWaiter().until(ExpectedConditions.elementToBeClickable(By.id("button_next"))).click();
    }

    //Login when AUTH ON
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
