package Controllers;

import org.graphwalker.Config;
import org.graphwalker.Helper;
import org.graphwalker.PageObjectModels.OnlineTestingAdministrationPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.text.SimpleDateFormat;

/**
 * Controllers class for Administration
 **/
public class AdministrationController {

    private static Config config = new Config();
    private static String environment, url, domain, tld;
    private static String quickRosterUrl, homeConnectionUrl;
    public static OnlineTestingAdministrationPage onlineTestingAdministrationPage = new OnlineTestingAdministrationPage();

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
        Helper.clickXpath(onlineTestingAdministrationPage.getOnlineTestingAdministrationportalButton(), waiter, driver);
        String rosterDate = new SimpleDateFormat("MM/dd/yyyy").format(new java.util.Date());
        WebElement element = driver.findElement(By.xpath(onlineTestingAdministrationPage.getWindowStart()));

        Actions actions = new Actions(driver);
        actions.moveToElement(element);
        actions.click();
        actions.sendKeys(rosterDate);
        actions.build().perform();

        Helper.clickXpath("//option[contains(text(),'" + student + "')]", waiter, driver);
        Helper.clickXpath(onlineTestingAdministrationPage.getPortalSave(), waiter, driver);
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
