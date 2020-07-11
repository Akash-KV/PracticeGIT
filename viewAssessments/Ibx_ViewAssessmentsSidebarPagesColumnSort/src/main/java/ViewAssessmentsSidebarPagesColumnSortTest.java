import Controllers.ViewAssessmentsController;
import org.graphwalker.core.machine.ExecutionContext;
import org.graphwalker.java.annotation.GraphWalker;

@GraphWalker(value = "quick_random(edge_coverage(100))")
public class ViewAssessmentsSidebarPagesColumnSortTest extends ExecutionContext implements ViewAssessmentsSidebarPagesColumnSort {

    ViewAssessmentsController viewAssessmentsController = new ViewAssessmentsController();

    public void v_ViewAssessmentsPage() {

    }

    public void e_ViewAssessments() {
        viewAssessmentsController.viewAssessments();
    }

    public void v_ViewAssessments() {
        viewAssessmentsController.verifyViewAssessments();
    }

    public void v_VerifyViewAssessmentsSidebarPagesColumnSort() {

    }
}
