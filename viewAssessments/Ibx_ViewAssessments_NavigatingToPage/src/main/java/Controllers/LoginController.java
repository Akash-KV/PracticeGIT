package Controllers;

import Helpers.BrowserInitHelper;
import Pom.LoginPage;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static Helpers.LoggerHelper.logger;

import static Helpers.JavascriptHelper.highlight;

//Controller class for login controller
public class LoginController {
    //Method to login
    public static LoginPage loginPage = new LoginPage();

    // When AuthX is off
    public static void login(String un, String pw) {
        logger(BrowserInitHelper.getInstance());
        highlight(BrowserInitHelper.getWaiter().until(ExpectedConditions.elementToBeClickable(By.id(loginPage.getUsernameAuthxOff()))));
        BrowserInitHelper.getWaiter().until(ExpectedConditions.elementToBeClickable(By.id(loginPage.getUsernameAuthxOff()))).clear();
        BrowserInitHelper.getWaiter().until(ExpectedConditions.elementToBeClickable(By.id(loginPage.getUsernameAuthxOff()))).sendKeys(un);
        highlight(BrowserInitHelper.getWaiter().until(ExpectedConditions.elementToBeClickable(By.id(loginPage.getPasswordAuthxOff()))));
        BrowserInitHelper.getWaiter().until(ExpectedConditions.elementToBeClickable(By.id(loginPage.getPasswordAuthxOff()))).clear();
        BrowserInitHelper.getWaiter().until(ExpectedConditions.elementToBeClickable(By.id(loginPage.getPasswordAuthxOff()))).sendKeys(pw);
        BrowserInitHelper.getWaiter().until(ExpectedConditions.elementToBeClickable(By.id(loginPage.getSignInAuthxOff()))).click();
    }

    //When AuthX is ON
    public static void loginAuthXSite(String un, String pw) {
        // logger(BrowserInitHelper.getInstance());
        highlight(BrowserInitHelper.getWaiter().until(ExpectedConditions.elementToBeClickable(By.xpath(loginPage.getUsernameAuthxOn()))));
        BrowserInitHelper.getWaiter().until(ExpectedConditions.elementToBeClickable(By.xpath(loginPage.getUsernameAuthxOn()))).clear();
        BrowserInitHelper.getWaiter().until(ExpectedConditions.elementToBeClickable(By.xpath(loginPage.getUsernameAuthxOn()))).sendKeys(un);
        highlight(BrowserInitHelper.getWaiter().until(ExpectedConditions.elementToBeClickable(By.xpath(loginPage.getPasswordAuthxOn()))));
        BrowserInitHelper.getWaiter().until(ExpectedConditions.elementToBeClickable(By.xpath(loginPage.getPasswordAuthxOn()))).clear();
        BrowserInitHelper.getWaiter().until(ExpectedConditions.elementToBeClickable(By.xpath(loginPage.getPasswordAuthxOn()))).sendKeys(pw);
        BrowserInitHelper.getWaiter().until(ExpectedConditions.elementToBeClickable(By.xpath(loginPage.getSignInAuthxOn()))).click();
    }
}
