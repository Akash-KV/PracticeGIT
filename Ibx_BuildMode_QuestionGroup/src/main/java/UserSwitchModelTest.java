import Controllers.BecomeAnotherUserController;
import Controllers.BrowseModeController;
import Controllers.DashboardController;
import org.graphwalker.core.machine.ExecutionContext;
import org.graphwalker.java.annotation.GraphWalker;

/**
 * Test class for UserSwitchModel
 **/
@GraphWalker(value = "quick_random(edge_coverage(100))")
public class UserSwitchModelTest extends ExecutionContext implements UserSwitchModel {

    BecomeAnotherUserController becomeAnotherUserController = new BecomeAnotherUserController();
    DashboardController dashboardController = new DashboardController();
    BrowseModeController browseModeController = new BrowseModeController();

    // To validate Dashboard
    public void v_Dashboard() {
        dashboardController.VerifyDashboard();
    }

    // To navigate to become another user
    public void e_NavigateToBecomeAnotherUser() {
        becomeAnotherUserController.navigateToBecomeAnotherUser();
    }

    public void v_NavigateToBecomeAnotherUser() {
    }

    // To validate browse mode
    public void v_BrowseMode() {
        browseModeController.verifyBrowseModePage();
    }

    public void v_BuildModeQuestionGroupsTest() {
    }

}
