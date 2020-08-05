package Controllers;

import org.graphwalker.Helper;
import org.graphwalker.PageObjectModels.OnlineTestingAdministrationPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

//Controller class for control panel
public class AssessmentPanelController {
    public static OnlineTestingAdministrationPage onlineTestingAdministrationPage = new OnlineTestingAdministrationPage();

    //method for clickAssessmentPanel
    public static void clickAssessmentPanel(WebDriverWait waiter, WebDriver driver) {
        Helper.clickXpath(onlineTestingAdministrationPage.getOnlineTestingAdministrationassessmentPanel(), waiter, driver);
    }

    //get First student method
    public static void getFirstStudent(WebDriverWait waiter, WebDriver driver) {
        Helper.refreshUntilElementAppears(onlineTestingAdministrationPage.getOnlineTestingAdministrationlistItem(), waiter, driver);
    }
}
