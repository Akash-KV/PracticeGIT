import Controllers.ViewAssessmentsController;
import org.graphwalker.core.machine.ExecutionContext;
import org.graphwalker.java.annotation.GraphWalker;

@GraphWalker(value = "quick_random(edge_coverage(100))")
public class DashboardPageTest extends ExecutionContext implements DashboardPage {

    ViewAssessmentsController viewAssessmentsController = new ViewAssessmentsController();

    public void v_Dashboard() {
    }

    public void e_ClickNavbar() {
        viewAssessmentsController.clickNavbar();
    }

    public void v_Navbar() {
    }

    public void v_ViewAssessmentsPage() {
    }
}
