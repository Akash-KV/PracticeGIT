
import Controllers.ViewAssessmentsController;
import Helpers.DriverHelper;
import Pom.DashboardPage;
import Pom.ViewAssessmentsPage;
import Utils.Config;
import Utils.ConsoleLogger;
import Utils.DataReader;
import org.graphwalker.core.machine.ExecutionContext;
import org.graphwalker.java.annotation.GraphWalker;
import org.junit.Assert;

import static Helpers.BrowserInitHelper.getInstance;

@GraphWalker(value = "quick_random(edge_coverage(100))")
// Test Class for ViewAssessmentsBlankState
public class ViewAssessmentsBlankStateTest extends ExecutionContext implements ViewAssessmentsBlankState {

    //Declarations
    ViewAssessmentsController viewAssessmentsController = new ViewAssessmentsController();

    // Validate viewAssessments Page
    public void v_ViewAssessmentsPage() {
        viewAssessmentsController.validatePage("View Assessments");
    }

    /*Validate the existence of Add Filter label*/
    public void v_VerifyFilters() {
        viewAssessmentsController.validateFilters();
    }

    /*Validate Search text box is empty*/
    public void v_VerifySearchBar() {
        viewAssessmentsController.validateSearchBar();
    }

    // Clicking show Assessments without Data_Toggle Button
    public void e_ClickShowAssessmentsWithoutDataToggleButton() {
        viewAssessmentsController.selectDataToggleButton();
    }

    // Validating show Assessments without Data_Toggle Button
    public void v_VerifyShowAssessmentsWithoutDataToggleButton() {
        viewAssessmentsController.validateSelectedDataToggleButton();

        // To clear added filters ,search text box and toggle button
        viewAssessmentsController.clearAddedFilter();
        viewAssessmentsController.clearSearchTextBox();
        viewAssessmentsController.turnOFFToggleButton();
    }
}
