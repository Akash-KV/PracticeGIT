import Controllers.DashboardController;
import Controllers.ViewAssessmentsController;
import org.graphwalker.core.machine.ExecutionContext;
import org.graphwalker.java.annotation.GraphWalker;

@GraphWalker(value = "quick_random(edge_coverage(100))")
public class Ibx_ListAssessments_LocalIdentifierTest extends ExecutionContext implements Ibx_ListAssessments_LocalIdentifier {

    ViewAssessmentsController viewAssessmentsController = new ViewAssessmentsController();

    public void v_ViewAssessmentsPage() {
    }

    // To Search Manual Hybrid
    public void e_SelectManualHybridType() {
        viewAssessmentsController.selectManualHybridType();
    }

    // To Validate Manual Hybrid Assessment
    public void v_VerifyManualHybridLocalIdentifier() {
        viewAssessmentsController.verifyManualHybridLocalIdentifier();
    }

    // To search Flexible Assessment
    public void e_SelectFlexibleType() {
        viewAssessmentsController.selectFlexibleType();
    }

    // To validate Flexible Assessment
    public void v_VerifyFlexibleLocalIdentifier() {
        viewAssessmentsController.verifyFlexibleLocalIdentifier();

        // To clear added filters ,search text box and toggle button
        viewAssessmentsController.clearAddedFilter();
        viewAssessmentsController.clearSearchTextBox();
        viewAssessmentsController.turnOFFToggleButton();
    }
}
