import Controllers.BrowseModeController;
import Controllers.BuildModeController;
import org.graphwalker.core.machine.ExecutionContext;
import org.graphwalker.java.annotation.GraphWalker;

/**
 * Test class for BuildModeBackButton
 **/
@GraphWalker(value = "quick_random(edge_coverage(100))")
public class BuildModeBackButtonTest extends ExecutionContext implements BuildModeBackButton {

    BuildModeController buildModeController = new BuildModeController();
    BrowseModeController browseModeController = new BrowseModeController();

    // To validate browse mode
    public void v_BrowseMode() {
        browseModeController.verifyNoItemsFound();
    }

    // To click back button
    public void e_ClickBackButtonInBuild() {
        buildModeController.clickBackButtonInBuild();
    }

    // To validate Back button from Build mode
    public void v_VerifyBackButtonFromBuildMode() {
        buildModeController.verifyBackButtonFromBuildMode();
    }

    // To validate build mode navigation
    public void v_VerifyBuildModeNavigation() {
        buildModeController.verifyBuildModeNavigation();
    }

    // To click create assessment
    public void e_ClickCreateAssessment() {
        buildModeController.clickCreateAssessment();
    }


}
