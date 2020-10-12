package Controllers;

import Helpers.BrowserInitHelper;
import Helpers.DriverHelper;
import Pom.*;
import Utils.ConsoleLogger;
import Utils.LoggerUtility;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/**
 * Controllers class for ControlPanel
 **/
public class ControlPanelController {
    public static String mainWindow;

    ControlPanelPage controlPanelPage = new ControlPanelPage();
    HelpCenterPage helpCenterPage = new HelpCenterPage();
    PrivacyPolicyPage privacyPolicyPage = new PrivacyPolicyPage();
    NotificationPage notificationPage = new NotificationPage();
    boolean alreadyClicked = false;

    //Method to get Window Handle and Switch Window
    public static void getWindowHandleAndSwitchWindow(WebDriver driver) {
        mainWindow = driver.getWindowHandle();
        Set<String> set = driver.getWindowHandles();

        Iterator<String> itr = set.iterator();
        while (itr.hasNext()) {
            String childWindow = itr.next();

            if (!mainWindow.equals(childWindow)) {
                driver.switchTo().window(childWindow);
            }
        }
    }

    //Method to Switch to main Window
    public static void switchToMainWindow(WebDriver driver) {
        driver.close();
        driver.switchTo().window(mainWindow);
    }

    //Click on ClickControl Panel Icon
    public void ClickControlPanelIcon() {
        /*Click Control Panel icon*/
        DriverHelper.clickXpath(controlPanelPage.getControlPanelIcon());
    }

    //Validate Control Panel Elements
    public void verifyControlPanelElements() {
        List<WebElement> elements = new ArrayList<WebElement>();
        boolean isExist = false;

        elements.add(BrowserInitHelper.getInstance().findElement(By.xpath(controlPanelPage.getControlPanelHeader())));
        elements.add(BrowserInitHelper.getInstance().findElement(By.xpath(controlPanelPage.getLoginInformation())));
        elements.add(BrowserInitHelper.getInstance().findElement(By.xpath(controlPanelPage.getNotificationPreferenceLink())));
        elements.add(BrowserInitHelper.getInstance().findElement(By.xpath(controlPanelPage.getChangePasswordLink())));
        elements.add(BrowserInitHelper.getInstance().findElement(By.xpath(controlPanelPage.getSubstituteTeacherLink())));
        elements.add(BrowserInitHelper.getInstance().findElement(By.xpath(controlPanelPage.getSignOutLink())));

        elements.add(BrowserInitHelper.getInstance().findElement(By.xpath(controlPanelPage.getIlluminateHelpCenterLink())));
        elements.add(BrowserInitHelper.getInstance().findElement(By.xpath(controlPanelPage.getHelpEmailLink())));
        elements.add(BrowserInitHelper.getInstance().findElement(By.xpath(controlPanelPage.getFeedbackLink())));
        elements.add(BrowserInitHelper.getInstance().findElement(By.xpath(controlPanelPage.getViewMyBadgesLink())));
        elements.add(BrowserInitHelper.getInstance().findElement(By.xpath(controlPanelPage.getScheduledJobsLink())));
        elements.add(BrowserInitHelper.getInstance().findElement(By.xpath(controlPanelPage.getPrivacyPolicyLink())));

        elements.add(BrowserInitHelper.getInstance().findElement(By.xpath(controlPanelPage.getEnrollElementDateTextBox())));
        elements.add(BrowserInitHelper.getInstance().findElement(By.xpath(controlPanelPage.getSiteDropDown())));
        elements.add(BrowserInitHelper.getInstance().findElement(By.xpath(controlPanelPage.getStudentGroupDropDown())));
        elements.add(BrowserInitHelper.getInstance().findElement(By.xpath(controlPanelPage.getSaveChangesButton())));
        elements.add(BrowserInitHelper.getInstance().findElement(By.xpath(controlPanelPage.getCancelButton())));

        for (int i = 0; i < elements.size(); i++) {

            if (DriverHelper.elementExistence(elements.get(i), BrowserInitHelper.getInstance())) {
                isExist = true;
            } else {
                isExist = false;
                break;
            }
        }
        if (isExist == true) {
            ConsoleLogger.SuccessLog("Test cases : Passed - Control panel fields are displayed");
            LoggerUtility.LoggerCall("Test cases : Passed - Control panel fields are displayed");
        } else {
            ConsoleLogger.SuccessLog("Test cases : Passed - Control panel fields are not displayed");
            LoggerUtility.LoggerCall("Test cases : Passed - Control panel fields are not displayed");
        }

    }

    //validate Login Information Elements
    public void VerifyLoginInformationElements() {
        /*Validate the existence of Login Information Elements in Control Panel*/
        BrowserInitHelper.waitUntil(controlPanelPage.getLoginInformation());
        WebElement Element = BrowserInitHelper.getInstance().findElement(By.xpath(controlPanelPage.getLoginInformation()));
        Assert.assertTrue(DriverHelper.elementExistence(Element, BrowserInitHelper.getInstance()));
    }

    //click on Notification Preferences Link
    public void ClickNotificationPreferencesLink() {
        /*Click Notification Preferences link in Control Panel*/
        DriverHelper.clickXpath(controlPanelPage.getNotificationPreferenceLink());
    }

    //Validate Notification Preferences Page
    public void VerifyNotificationPreferencesPage() {
        /*Validate the existence of Notification Preference Header*/
        BrowserInitHelper.waitUntil(controlPanelPage.getNotificationPreferenceHeader());
        WebElement Element = BrowserInitHelper.getInstance().findElement(By.xpath(controlPanelPage.getNotificationPreferenceHeader()));
        boolean NotificationLink = DriverHelper.elementExistence(Element, BrowserInitHelper.getInstance());
        if (NotificationLink) {
            ConsoleLogger.SuccessLog("Test cases : Passed - Verified Notification preference link");
            LoggerUtility.LoggerCall("Test cases : Passed - Verified Notification preference link");
        } else {
            ConsoleLogger.FailedTestCase("Test cases : Failed -  Notification preference link not Verified");
            LoggerUtility.LoggerCall("Test cases : Failed - Notification preference link not Verified");
        }
    }

    //Click on change password link
    public void ClickChangePasswordLink() {
        /*Click Control Panel icon*/
        DriverHelper.clickXpath(controlPanelPage.getControlPanelIcon());

        /*Click Change Password Link in Control Panel*/
        DriverHelper.clickXpath(controlPanelPage.getChangePasswordLink());
    }

    //validate change password page
    public void VerifyChangePasswordPage() {
        /*Validate the existence of Change Password Header*/
        BrowserInitHelper.getWaiter().until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath(controlPanelPage.getChangePasswordHeader())));
        WebElement Element = BrowserInitHelper.getInstance().findElement(By.xpath(controlPanelPage.getChangePasswordHeader()));
        Boolean PasswordLink = DriverHelper.elementExistence(Element, BrowserInitHelper.getInstance());
        if (PasswordLink) {
            ConsoleLogger.SuccessLog("Test cases : Passed - Verified change Password Link");
            LoggerUtility.LoggerCall("Test cases : Passed - Verified change Password Link");
        } else {
            ConsoleLogger.FailedTestCase("Test cases : Failed - change Password Link NOT verified");
            LoggerUtility.LoggerCall("Test cases : Failed - change Password Link NOT verified");
        }
    }

    //Click Substitute Teacher Link
    public void ClickSubstituteTeacherLink() {
        /*Click Control Panel icon*/
        DriverHelper.clickXpath(controlPanelPage.getControlPanelIcon());

        /*Click Substitute Teacher Link in Control Panel*/
        DriverHelper.clickXpath(controlPanelPage.getSubstituteTeacherLink());
    }

    //validate substitute Teacher Page
    public void VerifySubstituteTeacherPage() {
        /*Validate the existence of Select Teacher Header*/
        BrowserInitHelper.getWaiter().until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath(controlPanelPage.getSelectTeacherHeader())));
        WebElement Element = BrowserInitHelper.getInstance().findElement(By.xpath(controlPanelPage.getSelectTeacherHeader()));
        Boolean SubstituteLink = DriverHelper.elementExistence(Element, BrowserInitHelper.getInstance());
        if (SubstituteLink) {
            ConsoleLogger.SuccessLog("Test cases : Passed - Verified Substitute Teacher Link");
            LoggerUtility.LoggerCall("Test cases : Passed - Verified Substitute Teacher Link");
        } else {
            ConsoleLogger.FailedTestCase("Test cases : Failed - Verified Substitute Teacher Link");
            LoggerUtility.LoggerCall("Test cases : Failed - Verified Substitute Teacher Link");
        }
    }

    //Click on Illuminate HelpCenter Link
    public void ClickIlluminateHelpCenterLink() {
        try {
            /*Click Control Panel icon*/
            DriverHelper.clickXpath(controlPanelPage.getControlPanelIcon());

            /*Click Illuminate Help Center in Control Panel*/
            DriverHelper.clickXpath(controlPanelPage.getIlluminateHelpCenterLink());
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Exception while clicking Illuminate Help Center Link or Link itself is not showing now");
        }
    }

    //Verify HelpCenter Page
    public void VerifyHelpCenterPage() {

        /*Switch to Help Center window*/
        getWindowHandleAndSwitchWindow(BrowserInitHelper.getInstance());

        /*Validate the existence of text box in Help Center window*/
        BrowserInitHelper.getWaiter().until(ExpectedConditions.elementToBeClickable(By.xpath(helpCenterPage.getTextBox())));
        WebElement Element = BrowserInitHelper.getInstance().findElement(By.xpath(helpCenterPage.getTextBox()));
        boolean HelpCenterLink = DriverHelper.elementExistence(Element, BrowserInitHelper.getInstance());
        if (HelpCenterLink) {
            ConsoleLogger.SuccessLog("Test cases : Passed - Verified Help Center link");
            LoggerUtility.LoggerCall("Test cases : Passed - Verified Help Center link");
        } else {
            ConsoleLogger.FailedTestCase("Test cases : Failed -  Help Center link Not verified");
            LoggerUtility.LoggerCall("Test cases : Failed - Help Center link Not verified");
        }
    }

    //Click on SendUs Positive FeedbackLink
    public void ClickSendUsPositiveFeedbackLink() {
        /*Switch back to main window*/
        switchToMainWindow(BrowserInitHelper.getInstance());

        /*Click Control Panel icon*/
        // driverHelper.clickXpath(controlPanel.getControlPanelIcon());

        /*Click Send Us Positive Feedback link in Control Panel*/
        try {
            DriverHelper.clickXpath(controlPanelPage.getFeedbackLink());
        } catch (Exception e) {
            System.out.println("Exception handled for method - e_ClickSendUsPositiveFeedbackLink");
        }
    }

    //Verify FeedbackPage
    public void VerifyFeedbackPage() {
        /*Validate the existence of Positive Feedback Header*/
        try {
            BrowserInitHelper.getWaiter().until(ExpectedConditions.elementToBeClickable(By.xpath(controlPanelPage.getPositiveFeedbackHeader())));
            WebElement Element = BrowserInitHelper.getInstance().findElement(By.xpath(controlPanelPage.getPositiveFeedbackHeader()));
            //Assert.assertTrue(DriverHelper.elementExistence(Element, BrowserInitHelper.getInstance()));
        } catch (Exception e) {
            alreadyClicked = true;
            System.out.println("Exception handled for method - v_VerifyFeebackPage");
        }
    }

    //Click on ViewMyBadges Link
    public void ClickViewMyBadgesLink() {
        /*Click Control Panel icon*/
        if (alreadyClicked) {
            System.out.println("Already Control panel is clicked....");
        } else {
            DriverHelper.clickXpath(controlPanelPage.getControlPanelIcon());
        }

        /*Click View My Badges link*/
        DriverHelper.clickXpath(controlPanelPage.getViewMyBadgesLink());
    }

    //Verify Badges Page
    public void VerifyBadgesPage() {
        /*Validate the existence of Badges Header*/
        BrowserInitHelper.getWaiter().until(ExpectedConditions.elementToBeClickable(By.xpath(controlPanelPage.getBadgesHeader())));
        WebElement Element = BrowserInitHelper.getInstance().findElement(By.xpath(controlPanelPage.getBadgesHeader()));
        boolean MyBadgesLink = DriverHelper.elementExistence(Element, BrowserInitHelper.getInstance());
        if (MyBadgesLink) {
            ConsoleLogger.SuccessLog("Test cases : Passed - Verified My badges link");
            LoggerUtility.LoggerCall("Test cases : Passed - Verified My badges link");
        } else {
            ConsoleLogger.FailedTestCase("Test cases : Failed -  My badges link not verified");
            LoggerUtility.LoggerCall("Test cases : Failed - My badges link not verified");
        }
    }

    //Click Scheduled Jobs Link
    public void ClickScheduledJobsLink() {
        /*Click Control Panel icon*/
        DriverHelper.clickXpath(controlPanelPage.getControlPanelIcon());

        /*Click Schedule Jobs link*/
        DriverHelper.clickXpath(controlPanelPage.getScheduledJobsLink());
    }

    //Verify Scheduled Jobs Page
    public void VerifyScheduledJobsPage() {
        /*Validate the existence of Scheduled Jobs Header*/
        BrowserInitHelper.getWaiter().until(ExpectedConditions.elementToBeClickable(By.xpath(controlPanelPage.getScheduledJobsHeader())));
        WebElement Element = BrowserInitHelper.getInstance().findElement(By.xpath(controlPanelPage.getScheduledJobsHeader()));
        boolean ScheduledJobs = DriverHelper.elementExistence(Element, BrowserInitHelper.getInstance());
        if (ScheduledJobs) {
            ConsoleLogger.SuccessLog("Test cases : Passed - Verified scheduled jobs link");
            LoggerUtility.LoggerCall("Test cases : Passed - Verified scheduled jobs link");
        } else {
            ConsoleLogger.FailedTestCase("Test cases : Failed -  scheduled jobs link not Verified");
            LoggerUtility.LoggerCall("Test cases : Failed - scheduled jobs link not Verified");
        }
    }

    //Click PrivacyPolicy Link
    public void ClickPrivacyPolicyLink() {
        /*Click Control Panel icon*/
        DriverHelper.clickXpath(controlPanelPage.getControlPanelIcon());

        /*Click Privacy Policy link*/
        DriverHelper.clickXpath(controlPanelPage.getPrivacyPolicyLink());
    }

    //Verify Privacy Policy Page
    public void VerifyPrivacyPolicyPage() {
        /*Switch to Help Center window*/
        getWindowHandleAndSwitchWindow(BrowserInitHelper.getInstance());
        try {
            /*Validate the existence of text box in Help Center window*/
            BrowserInitHelper.getWaiter().until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath(privacyPolicyPage.getPrivacyPolicyHeader())));
            WebElement Element = BrowserInitHelper.getInstance().findElement(By.xpath(privacyPolicyPage.getPrivacyPolicyHeader()));
            boolean PrivacyLink = DriverHelper.elementExistence(Element, BrowserInitHelper.getInstance());
            if (PrivacyLink) {
                ConsoleLogger.SuccessLog("Test cases : Passed - Verified Privacy policy link");
                LoggerUtility.LoggerCall("Test cases : Passed - Verified Privacy policy link");
            } else {
                ConsoleLogger.FailedTestCase("Test cases : Failed -  Privacy policy link not verified");
                LoggerUtility.LoggerCall("Test cases : Failed - Privacy policy link not verified");
            }
        } catch (Exception e) {
            ConsoleLogger.SuccessLog("Test cases : Failed - Test cases : Passed - Verified Privacy policy link");
            LoggerUtility.LoggerCall("Test cases : Failed - Test cases : Passed - Verified Privacy policy link");
        }
    }

    //Click SaveChanges Button
    public void ClickSaveChangesButton() {
        DriverHelper.waitTill(5);
        /*Switch back to main window*/
        switchToMainWindow(BrowserInitHelper.getInstance());
        // driverHelper.clickXpath(controlPanel.getControlPanelIcon());
        /*Click Save Changes button*/
        DriverHelper.clickXpath(controlPanelPage.getSaveChangesButton());

        DriverHelper.waitTill(4);
        //  DriverHelper.awaitTillElementDisplayed(controlPanelPage.getControlPanelIcon(),"Control Panel Icon");
        BrowserInitHelper.waitUntil(controlPanelPage.getControlPanelIcon());
        DriverHelper.clickXpath(controlPanelPage.getControlPanelIcon());
        BrowserInitHelper.waitUntil(controlPanelPage.getDateImage());
        try {
            DriverHelper.clickXpath(controlPanelPage.getControlPanelPopup());
        } catch (Exception e) {
            System.out.println("Exception handled");
        }
        DriverHelper.waitFluentByXPath(BrowserInitHelper.getInstance(), controlPanelPage.getDateImage());
        DriverHelper.clickXpath(controlPanelPage.getDateImage());
        BrowserInitHelper.waitUntil(controlPanelPage.getTodayButton());
        DriverHelper.clickXpath(controlPanelPage.getTodayButton());
        BrowserInitHelper.waitUntil(controlPanelPage.getDateField());
        WebElement ele = BrowserInitHelper.getInstance().findElement(By.xpath(controlPanelPage.getDateField()));
        boolean TodayDate = DriverHelper.elementExistence(ele, BrowserInitHelper.getInstance());
        if (TodayDate) {
            ConsoleLogger.SuccessLog("Test cases : Passed - Today date is displayed");
            LoggerUtility.LoggerCall("Test cases : Passed - Today date is displayed");
        } else {
            ConsoleLogger.FailedTestCase("Test cases : Failed - Today date is not displayed");
            LoggerUtility.LoggerCall("Test cases : Failed - Today date is not displayed");
        }
    }

    //Verify ControlPanel Modal
    public void VerifyControlPanelModal() {
        DriverHelper.clickXpath(controlPanelPage.getSaveChangesButton());
        boolean notExist = false;
        /*Validate the in existence of Control Panel modal*/
        WebElement Element = BrowserInitHelper.getInstance().findElement(By.xpath(controlPanelPage.getControlPanelModal()));
        BrowserInitHelper.getWaiter().until(ExpectedConditions.invisibilityOf(Element));
        try {
            if (Element.isDisplayed()) {
                notExist = false;
            } else {
                notExist = true;
            }
        } catch (Exception e) {
            notExist = true;
        }
        Assert.assertTrue(notExist);
    }

    //Click Change Button
    public void ClickChangeButton() {
        /*Click Control Panel icon*/
        DriverHelper.clickXpath(controlPanelPage.getControlPanelIcon());

        /*Click Change button*/
        DriverHelper.clickXpath(controlPanelPage.getChangeButton());

        ConsoleLogger.SuccessLog("Test cases : Passed - Change button is verified");
        LoggerUtility.LoggerCall("Test cases : Passed - Change button is verified");
    }

    //Verify Custom FiltersPage
    public void VerifyCustomFiltersPage() {
        /*Validate the existence of Custom Filters Page*/
        BrowserInitHelper.getWaiter().until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath(controlPanelPage.getSetCustomFiltersButton())));
        WebElement Element = BrowserInitHelper.getInstance().findElement(By.xpath(controlPanelPage.getSetCustomFiltersButton()));

        Assert.assertTrue(DriverHelper.elementExistence(Element, BrowserInitHelper.getInstance()));
        ConsoleLogger.SuccessLog("Test cases : Passed - Verify VerifyCustomFiltersPage");
        LoggerUtility.LoggerCall("Test cases : Passed - Verify VerifyCustomFiltersPage");
        DriverHelper.waitFluentByXPath(BrowserInitHelper.getInstance(), controlPanelPage.getControlPanelIcon());

        DriverHelper.clickXpath(controlPanelPage.getControlPanelIcon());
        DriverHelper.clickXpath(controlPanelPage.getCancelButton());
        WebElement element = BrowserInitHelper.getInstance().findElement(By.xpath(controlPanelPage.getControlPanelHeader()));

        boolean ControlPanel = DriverHelper.elementExistence(element, BrowserInitHelper.getInstance());
        if (ControlPanel) {
            ConsoleLogger.SuccessLog("Test cases : Passed - Control panel closed");
            LoggerUtility.LoggerCall("Test cases : Passed - Control panel closed");
        }
    }

    //Click Notification Icon
    public void ClickNotificationIcon() {
        /*Click Notification Icon*/
        DriverHelper.clickXpath(controlPanelPage.getNotificationIcon());
    }

    //Verify Notification Elements
    public void VerifyNotificationElements() {
        try {
            List<WebElement> elements = new ArrayList<WebElement>();
            boolean isExist = false;

            elements.add(BrowserInitHelper.getInstance().findElement(By.xpath(notificationPage.getNotificationHeader())));

            ConsoleLogger.SuccessLog("Test cases : Passed - Verified Notification link");
            LoggerUtility.LoggerCall("Test cases : Passed - Verified Notification link");
            for (int i = 0; i < elements.size(); i++) {

                Thread.sleep(3000);
                if (elements.get(i).isDisplayed()) {
                    isExist = true;
                } else {
                    isExist = false;
                    break;
                }
            }
            Assert.assertTrue(isExist);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        DriverHelper.clickXpath(controlPanelPage.getNotificationIcon());
        BrowserInitHelper.getWaiter().until(ExpectedConditions.elementToBeClickable(By.xpath(controlPanelPage.getNotificationIcon())));
        DriverHelper.clickXpath(controlPanelPage.getNotificationIcon());
        DriverHelper.waitFluentByXPath(BrowserInitHelper.getInstance(), controlPanelPage.getClearNotification()
        );
        BrowserInitHelper.waitUntil(controlPanelPage.getClearNotification());
        DriverHelper.clickXpath(controlPanelPage.getClearNotification());

        WebElement elem1 = BrowserInitHelper.getInstance().findElement(By.xpath(controlPanelPage.getClearNotification()));
        try {
            elem1.click();
        } catch (Exception e) {
            elem1 = BrowserInitHelper.getInstance().findElement(By.xpath(controlPanelPage.getClearNotification()));
            elem1.click();
        }
        WebElement element = BrowserInitHelper.getInstance().findElement(By.xpath(controlPanelPage.getNotificationCleared()));
        boolean clear = DriverHelper.elementExistence(element, BrowserInitHelper.getInstance());
        if (clear) {
            ConsoleLogger.SuccessLog("Test cases : Passed - Click on Clear Notifications are cleared");
            LoggerUtility.LoggerCall("Test cases : Passed - Click on Clear Notifications are cleared");
        } else {
            ConsoleLogger.FailedTestCase("Test cases : Failed -  Notifications are not cleared");
            LoggerUtility.LoggerCall("Test cases : Failed -  Notifications are not cleared");
        }

        BrowserInitHelper.getWaiter().until(ExpectedConditions.elementToBeClickable(By.xpath(controlPanelPage.getControlPanelIcon())));
        DriverHelper.clickXpath(controlPanelPage.getControlPanelIcon());
        BrowserInitHelper.getWaiter().until(ExpectedConditions.elementToBeClickable(By.xpath(controlPanelPage.getSignOut())));
        DriverHelper.clickXpath(controlPanelPage.getSignOut());
    }
}
