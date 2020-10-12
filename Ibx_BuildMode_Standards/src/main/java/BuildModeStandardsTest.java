import Controllers.BrowseModeController;
import Controllers.BuildModeController;
import org.graphwalker.core.machine.ExecutionContext;
import org.graphwalker.java.annotation.GraphWalker;

/**
 * Test class for BuildModeStandards
 **/
@GraphWalker(value = "quick_random(edge_coverage(100))")
public class BuildModeStandardsTest extends ExecutionContext implements BuildModeStandards {

    // Declarations
    BrowseModeController browseModeController = new BrowseModeController();
    BuildModeController buildModeController = new BuildModeController();

    // To validate Browse Mode
    public void v_BrowseMode() {
        browseModeController.verifyNoItemsFound();
        buildModeController.buildModeStandardsTest();
    }

    // To click select more standards
    public void e_ClickSelectMoreStandards() {
        buildModeController.clickSelectMoreStandards();
    }

    public void v_VerifySelectMoreStandards() {
    }

    // To select standards
    public void e_SelectFilters() {
        buildModeController.selectFilters();
    }

    // To validate selected standards in filter selection
    public void v_VerifyStandardFiltersSelection() {
        buildModeController.verifyStandardFiltersSelection();
    }

    // To navigate build mode page
    public void e_NavigateBuildModeForItem() {
        buildModeController.navigateBuildModeForItem();
    }

    // To validate build mode page
    public void v_VerifyBuildModeStandardsForItemTest() {
        buildModeController.verifyBuildModeStandardsForItemTest();
    }
}
