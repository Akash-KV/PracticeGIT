import Controllers.AssessmentSearchController;
import Controllers.DashboardController;
import org.graphwalker.core.machine.ExecutionContext;
import org.graphwalker.java.annotation.GraphWalker;

//Test class for SearchAssessment
@GraphWalker(value = "quick_random(edge_coverage(100))")
public class SearchAssessmentTest extends ExecutionContext implements SearchAssessment {

    AssessmentSearchController assessmentSearchController = new AssessmentSearchController();

    //Click on Assessments
    public void e_Assessments() {
        assessmentSearchController.assessments();
    }

    //Validate AssessmentsPanel
    public void v_AssessmentsPanel() {
        assessmentSearchController.assessmentsPanel();
    }

    //Click on Assessment Panel and View Assessment Option
    public void e_AssessmentPanel_ViewAssessmentOption() {
        assessmentSearchController.assessmentPanel_ViewAssessmentOption();
    }

    public void v_ViewAssessmentsPage() {
    }

    //Validate ViewAssessments Page
    public void v_ViewAssessmentPage() {
        assessmentSearchController.viewAssessmentsPage();
    }

    public void e_SearchAssessment() {
    }

    //Validate SearchedAssessment
    public void v_VerifySearchedAssessment() {
        assessmentSearchController.verifySearchedAssessment();

        // To clear added filters ,search text box and toggle button
        assessmentSearchController.clearAddedFilter();
        assessmentSearchController.clearSearchTextBox();
        assessmentSearchController.turnOFFToggleButton();
    }
}
