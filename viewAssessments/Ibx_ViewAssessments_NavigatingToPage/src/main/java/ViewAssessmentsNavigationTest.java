import Controllers.DashboardController;
import Controllers.ViewAssessmentsController;
import org.graphwalker.core.machine.ExecutionContext;
import org.graphwalker.java.annotation.GraphWalker;

// Test class for ViewAssessmentsNavigation
@GraphWalker(value = "quick_random(edge_coverage(100))")
public class ViewAssessmentsNavigationTest extends ExecutionContext implements ViewAssessmentsNavigation {

    DashboardController dashboardController = new DashboardController();
    ViewAssessmentsController viewAssessmentsController = new ViewAssessmentsController();

    //Validate Dashboard
    public void v_Dashboard() {
        dashboardController.dashboard();
    }

    //Click on ViewAssessments
    public void e_ClickViewAssessments() {
        viewAssessmentsController.clickViewAssessments();
    }

    //Validate ViewAssessments
    public void v_ValidateViewAssessments() {
        viewAssessmentsController.validateViewAssessments();

        // To clear added filters ,search text box and toggle button
        viewAssessmentsController.clearAddedFilter();
        viewAssessmentsController.clearSearchTextBox();
        viewAssessmentsController.turnOFFToggleButton();
    }

    // Click on Illuminate Logo
    public void e_ClickIlluminateLogo() {
        viewAssessmentsController.clickIlluminateLogo();
    }

    //Validate Assessments Dashboard
    public void v_ValidateAssessmentsDashboard() {
        dashboardController.validateAssessmentsDashboard();
    }

    //Click ViewAssessments Tile
    public void e_ClickViewAssessmentsTile() {
        viewAssessmentsController.clickViewAssessmentsTile();
    }

    //Validate View Assessments
    public void v_VerifyViewAssessments() {
        viewAssessmentsController.verifyViewAssessments();

        // To clear added filters ,search text box and toggle button
        viewAssessmentsController.clearAddedFilter();
        viewAssessmentsController.clearSearchTextBox();
        viewAssessmentsController.turnOFFToggleButton();
    }
}
