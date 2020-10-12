import Controllers.BrowseModeController;
import Controllers.BuildModeController;

import org.graphwalker.core.machine.ExecutionContext;
import org.graphwalker.java.annotation.GraphWalker;

/**
 * Test class for BuildModeSingleItemPassageRemove
 **/
@GraphWalker(value = "quick_random(edge_coverage(100))")
public class BuildModeSingleItemPassageRemoveTest extends ExecutionContext implements BuildModeSingleItemPassageRemove {

    BuildModeController buildMode_Controller = new BuildModeController();
    BrowseModeController browseModeController = new BrowseModeController();

    // To validate browse mode
    public void v_BrowseMode() {
        browseModeController.verifyNoItemsFound();
    }

    //Create Assessment in Browse Mode
    public void e_CreateAssessment() {
        buildMode_Controller.createAssessment();
    }

    //Validate Removed item display
    public void v_VerifyRemoveItemDisplay() {
        buildMode_Controller.verifyRemoveItemDisplay();
    }

    //click on remove item
    public void e_ClickRemoveItem() {
        buildMode_Controller.clickRemoveItem();
    }

    //Validate remove item
    public void v_VerifyRemoveItem() {
        buildMode_Controller.verifyRemoveItem();
    }

    //Click on expand item
    public void e_ExpandItem() {
        buildMode_Controller.ExpandItem();
    }

    //Validate remove item when expand
    public void v_VerifyRemoveItemWhenExpand() {
        buildMode_Controller.verifyRemoveItemWhenExpanded();
    }

    //Click on collapse item
    public void e_CollapseItem() {
        buildMode_Controller.collapseItem();
    }

    //validate Remove Item when Collapse
    public void v_VerifyRemoveItemWhenCollapse() {
        buildMode_Controller.verifyCollapseItemWhenRemove();
    }
}