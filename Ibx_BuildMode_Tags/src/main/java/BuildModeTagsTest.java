
import Controllers.BrowseModeController;
import Controllers.BuildModeController;
import org.graphwalker.core.machine.ExecutionContext;
import org.graphwalker.java.annotation.GraphWalker;

/**
 * Test class for BuildModeTags
 **/
@GraphWalker(value = "quick_random(edge_coverage(100))")
public class BuildModeTagsTest extends ExecutionContext implements BuildModeTags {

    BuildModeController buildModeController = new BuildModeController();
    BrowseModeController browseModeController = new BrowseModeController();

    // To validate browse mode
    public void v_BrowseMode() {
        browseModeController.verifyNoItemsFound();
    }

    // To create assessment
    public void e_CreateAssessment() {
        buildModeController.createAssessment();
    }

    // To validate Build Mode Navigation
    public void v_VerifyBuildNavigation() {
        buildModeController.verifyBuildNavigation();
    }

    // To validate tags option
    public void v_VerifyTagsOption() {
        buildModeController.verifyTagsOption();
    }

    // To click on Tags link
    public void e_ClickOnTagsLink() {
        buildModeController.clickOnTagsLink();
    }

    // To validate Tags General Settings Screen
    public void v_VerifyTagsGeneralSettingsScreen() {
        buildModeController.verifyTagsGeneralSettingsScreen();
    }

    // To select X icon
    public void e_Select_X_Icon() {
        buildModeController.select_X_Icon();
    }

    // To validate Tags General Settings Screen Closing
    public void v_VerifyTagsGeneralSettingsScreenClosing() {
        buildModeController.verifyTagsGeneralSettingsScreenClosing();
    }

    // To click on Tags General Settings Options
    public void e_ClickOnTagsGeneralSettingsOptions() {
        buildModeController.clickOnTagsGeneralSettingsOptions();
    }

    // To validate Selection of Tags General Settings Options
    public void v_VerifySelectionOfTagsGeneralSettingsOptions() {
        buildModeController.verifySelectionOfTagsGeneralSettingsOptions();
    }

    // To unSelect Tags General Settings Options
    public void e_UnSelectTagsGeneralSettingsOptions() {
        buildModeController.unSelectTagsGeneralSettingsOptions();
    }

    // To validate UnSelect of Tags General Settings Options
    public void v_VerifyUnSelectOfTagsGeneralSettingsOptions() {
        buildModeController.verifyUnSelectOfTagsGeneralSettingsOptions();
    }
}
