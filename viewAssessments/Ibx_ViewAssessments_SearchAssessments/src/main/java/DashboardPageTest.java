import Controllers.AssessmentSearchController;
import Controllers.DashboardController;
import org.graphwalker.core.machine.ExecutionContext;
import org.graphwalker.java.annotation.GraphWalker;

//Test class for DashboardPage
@GraphWalker(value = "quick_random(edge_coverage(100))")
public class DashboardPageTest extends ExecutionContext implements DashboardPage {

    DashboardController dashboardController = new DashboardController();
    AssessmentSearchController assessmentSearchController = new AssessmentSearchController();

    //Validate Dashboard
    public void v_Dashboard() {
        dashboardController.dashboard();
    }

    //Click on Navigation bar
    public void e_ClickNavbar() {
    }

    //Validate Navigation bar
    public void v_Navbar() {
        assessmentSearchController.navbar();
    }

    public void v_ViewAssessmentsPage() {
    }
}
