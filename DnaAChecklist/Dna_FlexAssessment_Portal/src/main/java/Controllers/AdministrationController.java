package Controllers;

import org.graphwalker.Config;
import org.graphwalker.Helper;
import org.graphwalker.PageObjectModels.Dashboard;
import org.graphwalker.PageObjectModels.OnlineTestingAdministrationPage;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Controllers class for Administration
 **/
public class AdministrationController {
    private static Config config = new Config();
    public static Dashboard dashboard = new Dashboard();
    public static OnlineTestingAdministrationPage onlineTestingAdministrationPage = new OnlineTestingAdministrationPage();
    private static String environment, url, domain, tld;
    private static String quickRosterUrl, homeConnectionUrl;

    // To get Portal Url
    public static String getPortalUrl() {
        config.readProperties();
        environment = config.getEnvironment();
        url = config.getURL();

        String[] strArray = url.split("/");
        domain = strArray[2];
        strArray = domain.split("\\.");
        domain = strArray[0];
        tld = strArray[2];

        if (environment.equals("prod") || environment.equals("production")) {
            quickRosterUrl = "https://testing.illuminateed." + tld + "/auth/quick?access_code=";
            homeConnectionUrl = "https://" + domain + ".illuminatehc." + tld;
        } else {
            quickRosterUrl = "https://onlinetesting" + domain + ".illuminateed." + tld + "/auth/quick?access_code=";
            homeConnectionUrl = "https://" + domain + ".illuminatehc." + tld;
        }
        return homeConnectionUrl;
    }

    // To get Portal
    public static String getPortal(String student, WebDriverWait waiter, WebDriver driver) {
        try {
            Helper.wait(3.0);
            Helper.clickXpath(onlineTestingAdministrationPage.getPopup(), waiter, driver);
        } catch (Exception e) {
            System.out.println("Exception handled for popup.....");
        }
        Helper.clickXpath(onlineTestingAdministrationPage.getOnlineTestingAdministrationportalButton(), waiter, driver);
        //String rosterDate = new SimpleDateFormat("MM/dd/yyyy").format(new java.util.Date());
        DateFormat dateFormatMinus = new SimpleDateFormat("MM/dd/yyyy");
        Date currentDateToMinus = new Date();
        Calendar cal = Calendar.getInstance();
        cal.setTime(currentDateToMinus);
        cal.add(Calendar.DATE, -1);
        Date rosterDate = cal.getTime();
        System.out.println(" Yesterdays date -->" + dateFormatMinus.format(rosterDate));

        WebElement element = driver.findElement(By.xpath(onlineTestingAdministrationPage.getWindowStart()));
        Actions actions = new Actions(driver);
        actions.moveToElement(element);
        actions.click();
        actions.sendKeys(dateFormatMinus.format(rosterDate));
        actions.build().perform();

        DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
        Date currentDate = new Date();
        Calendar c = Calendar.getInstance();
        c.setTime(currentDate);
        c.add(Calendar.DATE, 3);
        Date currentDatePlusOne = c.getTime();
        System.out.println(dateFormat.format(currentDatePlusOne));

        element = driver.findElement(By.xpath(onlineTestingAdministrationPage.getWindowEnd()));
        actions = new Actions(driver);
        actions.moveToElement(element);
        actions.click();
        actions.sendKeys(dateFormat.format(currentDatePlusOne));
        actions.build().perform();

        //Change date and time
        Helper.sendKeysXpath(onlineTestingAdministrationPage.getOnlineTestingAdministrationStartDateHour(), "12", waiter, driver);
        Helper.sendKeysXpath(onlineTestingAdministrationPage.getOnlineTestingAdministrationStartDateHourMin(), "00", waiter, driver);
        Select startTime = new Select(driver.findElement(By.id(onlineTestingAdministrationPage.getOnlineTestingAdministrationStartDateHourTime())));
        startTime.selectByVisibleText("AM");

        element = driver.findElement(By.xpath(onlineTestingAdministrationPage.getWindowEnd()));
        actions = new Actions(driver);
        actions.moveToElement(element);
        actions.click();
        actions.sendKeys(dateFormat.format(currentDatePlusOne));
        actions.build().perform();

        Helper.sendKeysXpath(onlineTestingAdministrationPage.getOnlineTestingAdministrationEndDateHour(), "12", waiter, driver);
        Helper.sendKeysXpath(onlineTestingAdministrationPage.getOnlineTestingAdministrationEndDateHourMin(), "00", waiter, driver);
        Select endTime = new Select(driver.findElement(By.id(onlineTestingAdministrationPage.getOnlineTestingAdministrationEndDateHourTime())));
        endTime.selectByVisibleText("PM");

       // driver.navigate().refresh();

        try {
            Helper.wait(2.0);
            WebElement studentList = driver.findElement(By.id(onlineTestingAdministrationPage.getOnlineTestingAdministrationStudentId()));
            JavascriptExecutor je = (JavascriptExecutor) driver;
            je.executeScript("arguments[0].scrollIntoView(true);", studentList);
            Helper.wait(2.0);

            Select studentNameInList = new Select(driver.findElement(By.id(onlineTestingAdministrationPage.getOnlineTestingAdministrationStudentId())));
            String studentName = Config.getStudentLastFirstWithInitial();
            studentNameInList.selectByVisibleText(studentName);
            Helper.wait(2.0);
        } catch (Exception e) {
            System.out.println("Exception handled for student list");
        }
        Helper.clickXpath(onlineTestingAdministrationPage.getPortalSave(), waiter, driver);

        try {
            Helper.wait(3.0);
            Helper.clickXpath(onlineTestingAdministrationPage.getPopup(), waiter, driver);
        } catch (Exception e) {
            System.out.println("Exception handled for popup.....");
        }
        String completeBar = Helper.getText(onlineTestingAdministrationPage.getOnlineTestingAdministrationcompleteBar(), waiter, driver);
        while (!completeBar.equals("Complete")) {
            // loop
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            completeBar = Helper.getText(onlineTestingAdministrationPage.getOnlineTestingAdministrationcompleteBar(), waiter, driver);
        }
        String administrationsPage = driver.getCurrentUrl();
        System.out.println("<mbt-output-url> " + administrationsPage);
        return administrationsPage;
    }
}
