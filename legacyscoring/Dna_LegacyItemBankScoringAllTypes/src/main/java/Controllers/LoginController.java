package Controllers;

import Helpers.BrowserInitHelper;
import Helpers.DriverHelper;
import Pom.LoginPage;
import Utils.Config;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static Helpers.LoggerHelper.logger;

import static Helpers.JavascriptHelper.highlight;

//Controller class for login controller
public class LoginController {
//Config config=new Config();
   public static LoginPage loginPage=new LoginPage();
public  LoginController()
{
loginPage.readProperties();
   // config.readProperties();
}
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
    public static void adminLogin()
    {
      try {
        DriverHelper.waitFluentByXPath(BrowserInitHelper.getInstance(), loginPage.getLoginIlluminateLogoForDemo());
        DriverHelper.clickXpath(loginPage.getLoginIlluminateLogoForDemo());
    } catch (Exception e) {
        DriverHelper.waitFluentByXPath(BrowserInitHelper.getInstance(), loginPage.getLoginIlluminateLogoForIBXon());
        DriverHelper.clickXpath(loginPage.getLoginIlluminateLogoForIBXon());
    }
        try {
        DriverHelper.awaitTillElementDisplayed(loginPage.getLoginGoogleEmail(), "email");
        DriverHelper.sendKeysXpath(loginPage.getLoginGoogleEmail(), Config.getEmailID());
        WebElement ele= BrowserInitHelper.getInstance().findElement(By.xpath(loginPage.getLoginGoogleEmail()));
        Actions actions=new Actions(BrowserInitHelper.getInstance());
        actions.moveToElement(ele).sendKeys(Keys.ENTER);
        actions.build().perform();
        DriverHelper.awaitTillElementDisplayed(loginPage.getLoginGooglePassword(), "password");
        DriverHelper.sendKeysXpath(loginPage.getLoginGooglePassword(), Config.getEmailPassword());
        WebElement pass= BrowserInitHelper.getInstance().findElement(By.xpath(loginPage.getLoginGooglePassword()));
        Actions actionsPass=new Actions(BrowserInitHelper.getInstance());
        actionsPass.moveToElement(pass).sendKeys(Keys.ENTER);
        actionsPass.build().perform();

    } catch (Exception e) {
        e.printStackTrace();
    }
}
}
