package Controllers;

import Helpers.DriverHelper;
import Pom.AssessmentViewPage;
import Utils.ConsoleLogger;

//Controllers class for NavbarController
public class NavbarController {
    public static AssessmentViewPage assessmentViewPage = new AssessmentViewPage();

    //Method to get List of Assessments
    public static void getListAssessments() {
        try {
            DriverHelper.clickXpath(assessmentViewPage.getListAssessmentNavigation());
        } catch (Exception e) {
            ConsoleLogger.DebugLog("Navbar Assessments not found!" + e);
        }

        try {
            DriverHelper.clickXpath(assessmentViewPage.getListViewAssessmentsClick());
        } catch (Exception e) {
            ConsoleLogger.DebugLog("View Assessment Link in Navbar is not found!" + e);
        }
    }
}
