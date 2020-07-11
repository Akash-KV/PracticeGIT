import Controllers.DashboardController;
import org.graphwalker.core.machine.ExecutionContext;
import org.graphwalker.java.annotation.GraphWalker;

@GraphWalker(value = "quick_random(edge_coverage(100))")
public class DashboardPageTest extends ExecutionContext implements DashboardPage {


    DashboardController dashboardController = new DashboardController();

    // Validating Dashboard
    public void v_Dashboard() {
        dashboardController.validateDashboard();
    }

    // Clicking View_Assessment Tile
    public void e_ClickViewAssessmentsTile() {
        dashboardController.clickViewAssessmentsTile();
    }

    public void v_ViewAssessmentsPage() {
    }
}
