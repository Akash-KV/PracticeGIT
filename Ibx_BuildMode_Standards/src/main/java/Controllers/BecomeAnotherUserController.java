package Controllers;

import Helpers.BrowserInitHelper;
import Helpers.DriverHelper;
import Pom.BecomeAnotherUserPage;
import Pom.DashboardPage;
import Utils.Dynamic;
import Utils.LoggerUtility;
import Utils.Secure;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

/**
 * Controllers class for BecomeAnotherUser
 **/
public class BecomeAnotherUserController {
    DashboardPage dashboardPage = new DashboardPage();
    BecomeAnotherUserPage becomeAnotherUserPage = new BecomeAnotherUserPage();
    public String anotherUser;
    Secure secure = new Secure();

    public BecomeAnotherUserController() {
        secure.readProperties();
        anotherUser = secure.getAnotherUser();
    }

    // To Become another user
    public void navigateToBecomeAnotherUser() {
        if (Dynamic.getAdminUser().equalsIgnoreCase("true")) {
            //First click on settings to become another user
            String settings_Icon = dashboardPage.getSettingsIcon();
            BrowserInitHelper.getWaiter().until(ExpectedConditions.elementToBeClickable(By.xpath(settings_Icon)));
            DriverHelper.clickXpath(settings_Icon);

            BrowserInitHelper.getWaiter().until(ExpectedConditions.elementToBeClickable(By.xpath(becomeAnotherUserPage.getAnotherUser())));
            DriverHelper.clickXpath(becomeAnotherUserPage.getAnotherUser());

            String findUser = becomeAnotherUserPage.getFindUser();
            BrowserInitHelper.getWaiter().until(ExpectedConditions.elementToBeClickable(By.xpath(findUser)));
            DriverHelper.clickXpath(findUser);

            String findUser_Input = becomeAnotherUserPage.getFindUserInput();
            BrowserInitHelper.getWaiter().until(ExpectedConditions.elementToBeClickable(By.xpath(findUser_Input)));
            DriverHelper.sendKeysXpath(findUser_Input, anotherUser);

            String findUser_Value = "//span[.='" + anotherUser + "' and @class='select2-match']";
            BrowserInitHelper.getWaiter().until(ExpectedConditions.elementToBeClickable(By.xpath(findUser_Value)));
            DriverHelper.clickXpath(findUser_Value);

            BrowserInitHelper.getWaiter().until(ExpectedConditions.elementToBeClickable(By.xpath(becomeAnotherUserPage.getNext())));
            DriverHelper.clickXpath(becomeAnotherUserPage.getNext());

            BrowserInitHelper.getWaiter().until(ExpectedConditions.elementToBeClickable(By.xpath(dashboardPage.getAssessmentsNav())));
            DriverHelper.clickXpath(dashboardPage.getAssessmentsNav());

            DriverHelper.waitFluentByXPath(BrowserInitHelper.getInstance(), dashboardPage.getBrowseItemBank());
            DriverHelper.clickXpath(dashboardPage.getBrowseItemBank());
            System.out.println("Navigated to Browse Mode.......!!!!");
            LoggerUtility.LoggerCall("Navigated to Browse Mode.......!!!!");

        } else {
            BrowserInitHelper.getWaiter().until(ExpectedConditions.elementToBeClickable(By.xpath(dashboardPage.getAssessmentsNav())));
            DriverHelper.clickXpath(dashboardPage.getAssessmentsNav());

            DriverHelper.waitFluentByXPath(BrowserInitHelper.getInstance(), dashboardPage.getBrowseItemBank());
            DriverHelper.clickXpath(dashboardPage.getBrowseItemBank());
            System.out.println("Navigated to Browse Mode.......!!!!");
            LoggerUtility.LoggerCall("Navigated to Browse Mode.......!!!!");
        }

    }

}
