import Controllers.DashboardController;
import Controllers.ViewAssessmentsController;
import org.graphwalker.core.machine.ExecutionContext;
import org.graphwalker.java.annotation.GraphWalker;

@GraphWalker(value = "quick_random(edge_coverage(100))")
public class DashboardPageTest extends ExecutionContext implements DashboardPage {

    DashboardController dashboardController = new DashboardController();
    ViewAssessmentsController viewAssessmentsController = new ViewAssessmentsController();
    public void e_ClickNavbar() {
        viewAssessmentsController.navigateToViewAssessments();
    }

    public void v_Navbar() {
        viewAssessmentsController.verifyViewAssessments();

    }

    public void v_VerifyDashboard() {
        dashboardController.verifyDashboard();
    }

    public void v_ViewAssessmentsPage() {
    }

}
