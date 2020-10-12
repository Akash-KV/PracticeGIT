import Controllers.BrowseModeController;
import Controllers.BuildModeController;
import org.graphwalker.core.machine.ExecutionContext;
import org.graphwalker.java.annotation.GraphWalker;

/**
 * Test class for BuildModeMassApply
 **/
@GraphWalker()
public class BuildModeMassApplyTest extends ExecutionContext implements BuildModeMassApply {

    BuildModeController buildMode_Controller = new BuildModeController();
    BrowseModeController browseModeController = new BrowseModeController();

    // To validate Browse Mode
    public void v_BrowseMode() {
        browseModeController.verifyNoItemsFound();
    }

    //Create Assessment in Browse Mode
    public void e_CreateAssessment() {
        buildMode_Controller.createAssessment();
    }

    //validate Build mode
    public void v_VerifyBuildMode() {
        buildMode_Controller.verifyBuildMode();
    }

    //click on select items
    public void e_SelectItems() {
        buildMode_Controller.selectItems();
    }

    //verify mass apply
    public void v_VerifyMassApplyElements() {
        buildMode_Controller.verifyMassApplyElements();
    }

    //click on remove item
    public void e_ClickRemoveItem() {
        buildMode_Controller.clickRemoveItem();
    }

    //validate remove item
    public void v_VerifyRemoveItem() {
        buildMode_Controller.verifyRemoveItem();
    }

    //validate item count
    public void v_VerifyItemCount() {
        buildMode_Controller.verifyItemCount();
    }

    //click on navigate to browse mode and select passage
    public void e_NavigateToBrowseModeAndSelectPassage() {
        buildMode_Controller.selectPassage();
    }

    //Verify ItemCountOnPassageRemove
    public void v_VerifyItemCountOnPassageRemove() {
        buildMode_Controller.verifyItemCountOnPassageRemove();
    }

}