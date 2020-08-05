package Controllers;

import org.graphwalker.Helper;
import org.graphwalker.PageObjectModels.OnlineTestingAdministrationPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Controllers class for AssessmentPanel
 **/
public class AssessmentPanelController {

    public static OnlineTestingAdministrationPage onlineTestingAdministrationPage = new OnlineTestingAdministrationPage();

    // To click Assessment Panel
    public static void clickAssessmentPanel(WebDriverWait waiter, WebDriver driver) {
        Helper.clickXpath(onlineTestingAdministrationPage.getOnlineTestingAdministrationassessmentPanel(), waiter, driver);
    }

    // To get First student
    public static void getFirstStudent(WebDriverWait waiter, WebDriver driver) {
        Helper.refreshUntilElementAppears(onlineTestingAdministrationPage.getOnlineTestingAdministrationlistItem(), waiter, driver);
    }
}
