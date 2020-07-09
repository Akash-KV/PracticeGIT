package Controllers;

import Helpers.DriverHelper;
import Pom.AssessmentsNavbar;
import Utils.ConsoleLogger;

//Class for Navbar Controller
public class NavbarController {
    public static AssessmentsNavbar assessmentsNavbar = new AssessmentsNavbar();

    //Method for clicking on Assessments and View Assessments link
    public static void getListAssessments() {
        try {
            DriverHelper.waitTill(3);
            System.out.println(assessmentsNavbar.getListAssessment());
            DriverHelper.clickXpath(assessmentsNavbar.getListAssessment());
        } catch (Exception e) {
            ConsoleLogger.DebugLog("Navbar Assessments not found!" + e);
        }

        try {
            DriverHelper.waitTill(2);
            System.out.print(assessmentsNavbar.getAssessmentView());
            DriverHelper.clickXpath(assessmentsNavbar.getViewAssessment());
        } catch (Exception e) {
            ConsoleLogger.DebugLog("View Assessment Link in Navbar is not found!" + e);
            e.printStackTrace();
        }
    }
}
