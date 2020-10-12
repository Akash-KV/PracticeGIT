import Controllers.BrowseModeController;
import Controllers.BuildModeController;
import org.graphwalker.core.machine.ExecutionContext;
import org.graphwalker.java.annotation.GraphWalker;

/**
 * Test class for BuildModeCreateButton
 **/
@GraphWalker(value = "quick_random(edge_coverage(100))")
public class BuildModeCreateButtonTest extends ExecutionContext implements BuildModeCreateButton {

    BuildModeController buildModeController = new BuildModeController();
    BrowseModeController browseModeController = new BrowseModeController();

    // To validate browse mode
    public void v_BrowseMode() {
        browseModeController.verifyNoItemsFound();
    }

    //validate CreateItem Button
    public void v_VerifyCreateItemButton() {
        buildModeController.verifyCreateItemButton();
    }

    //Click on create Item Button
    public void e_ClickCreateItemButton() {
        buildModeController.clickCreateItemButton();
    }

    //validate create item page
    public void v_VerifyCreateItemPage() {
        buildModeController.verifyCreateItemPage();
    }

    //Mouse over on create item
    public void e_MouseOverOnCreateItem() {
        buildModeController.mouseOverOnCreateItem();
    }

    //validate create item page in build mode
    public void v_VerifyCursorChangeToPointer() {
        buildModeController.verifyCursorChangeToPointer();
    }
}
