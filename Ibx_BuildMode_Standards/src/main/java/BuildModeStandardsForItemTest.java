import Controllers.BuildModeController;
import org.graphwalker.core.machine.ExecutionContext;
import org.graphwalker.java.annotation.GraphWalker;

/**
 * Test class for BuildModeStandardsForItem
 **/
@GraphWalker(value = "quick_random(edge_coverage(100))")
public class BuildModeStandardsForItemTest extends ExecutionContext implements BuildModeStandardsForItem {

    BuildModeController buildModeController = new BuildModeController();

    public void v_VerifyBuildModeStandardsForItemTest() {
    }

    // To select edit icon
    public void e_SelectEditIcon() {
        buildModeController.selectEditIcon();
    }

    // To validate standard selector Modal
    public void v_VerifyStandardSelectorModal() {
        buildModeController.verifyStandardSelectorModal();
    }

    //  To check information icon
    public void e_CheckInformationIcon() {
        buildModeController.checkInformationIcon();
    }

    // To validate information icon
    public void v_VerifyInformationIcon() {
        buildModeController.verifyInformationIcon();
    }

    // To select standards from modal
    public void e_SelectStandardsFromModal() {
        buildModeController.selectStandardsFromModal();
    }

    // To validate selected standards
    public void v_VerifySelectedStandards() {
        buildModeController.verifySelectedStandards();
    }

    // To select standards from create item
    public void e_SelectStandardsFromCreateItem() {
        buildModeController.selectStandardsFromCreateItem();
    }

    // To validate newly added standards
    public void v_VerifyNewlyAddedStandards() {
        buildModeController.verifyNewlyAddedStandards();
    }

    // To uncheck Standard
    public void e_UncheckStandard() {
        buildModeController.uncheckStandard();
    }

    // To validate unchecked standards
    public void v_VerifyUncheckedStandards() {
        buildModeController.verifyUncheckedStandards();
    }

    // To check hover message on standards
    public void e_CheckHoverMessageOnStandards() {
        buildModeController.checkHoverMessageOnStandards();
    }

    // To validate hover message on standards
    public void v_VerifyHoverMessageOnStandards() {
        buildModeController.verifyHoverMessageOnStandards();
    }

    // To select base standard
    public void e_SelectBaseStandard() {
        buildModeController.selectBaseStandard();
    }

    // To validate selected base standards list
    public void v_VerifySelectedBaseStandardList() {
        buildModeController.verifySelectedBaseStandardList();
    }

    // To remove aligned standard
    public void e_RemoveAlignedStandard() {
        buildModeController.removeAlignedStandard();
    }

    // To validate base standard list for not aligned
    public void v_VerifyBaseStandardListForNotAligned() {
        buildModeController.verifyBaseStandardListForNotAligned();
    }

    // To reselect aligned standard
    public void e_ReselectAlignedStandard() {
        buildModeController.reselectAlignedStandard();
    }

    // To validate base standard list for aligned
    public void v_VerifyBaseStandardListForAligned() {
        buildModeController.verifyBaseStandardListForAligned();
    }

    // To check full standard name
    public void e_CheckFullStandardName() {
        buildModeController.checkFullStandardName();
    }

    // To validate full standard name
    public void v_VerifyFullStandardName() {
        buildModeController.verifyFullStandardName();
    }
}
