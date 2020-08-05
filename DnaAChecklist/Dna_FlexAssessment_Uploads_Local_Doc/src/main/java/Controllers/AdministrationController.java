package Controllers;

import org.graphwalker.Config;
import org.graphwalker.Helper;
import org.graphwalker.PageObjectModels.OnlineTestingAdministrationPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

/***********Controller Class For AdministrationController*************/
public class AdministrationController {
    private static Config config = new Config();
    private static String environment, url, domain, tld;
    private static String quickRosterUrl, homeConnectionUrl;

    public static OnlineTestingAdministrationPage onlineTestingAdministrationPage = new OnlineTestingAdministrationPage();


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

    public static String getPortal(String student, WebDriverWait waiter, WebDriver driver) {
        Helper.clickXpath(onlineTestingAdministrationPage.getOnlineTestingAdministrationportalButton(), waiter, driver);
        Helper.clickXpath("//option[contains(text(),'" + student + "')]", waiter, driver);
        Helper.clickXpath(onlineTestingAdministrationPage.getOnlineTestingAdministrationSave(), waiter, driver);
        String completeBar = Helper.getText(onlineTestingAdministrationPage.getOnlineTestingAdministrationcompleteBar(), waiter, driver);
        while (!completeBar.equals("Complete")) {
            // loop
            try {
                Helper.wait(1.0);
            } catch (Exception e) {
                e.printStackTrace();
            }
            completeBar = Helper.getText(onlineTestingAdministrationPage.getOnlineTestingAdministrationcompleteBar(), waiter, driver);
        }
        String administrationsPage = driver.getCurrentUrl();
        System.out.println("<mbt-output-url> " + administrationsPage);
        return administrationsPage;
    }
}
