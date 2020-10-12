import Controllers.BrowseModeController;
import Controllers.BuildModeController;
import org.graphwalker.core.machine.ExecutionContext;
import org.graphwalker.java.annotation.GraphWalker;

/**
 * Test class for BuildModeExtraCredit
 **/
@GraphWalker(value = "quick_random(edge_coverage(100))")
public class BuildModeExtraCreditTest extends ExecutionContext implements BuildModeExtraCredit {

    BuildModeController buildModeController = new BuildModeController();
    BrowseModeController browseModeController = new BrowseModeController();

    //validate Browse Mode AddItem Test
    public void v_BrowseMode() {
        browseModeController.verifyNoItemsFound();
    }

    //Click on create Assessment
    public void e_CreateAssessment() {
        buildModeController.createAssessment();
    }

    //Validate Build Navigation
    public void v_VerifyBuildNavigation() {
        buildModeController.verifyBuildNavigation();
    }

    //Validate Extra Credit Checkbox
    public void v_VerifyExtraCreditCheckBox() {
        buildModeController.verifyExtraCreditCheckBox();
    }

    //click on Extra credit check box
    public void e_ClickExtraCreditForItem() {
        buildModeController.clickExtraCreditForItem();
    }

    //Validate Selection of Extra Credit
    public void v_VerifySelectionOfExtraCredit() {
        buildModeController.verifySelectionOfExtraCredit();
    }

    //UnSelect ExtraCredit check box
    public void e_UnSelectExtraCreditForItem() {
        buildModeController.unSelectExtraCreditForItem();
    }

    //Validate UnSelect of the ExtraCredit
    public void v_VerifyUnSelectOfExtraCredit() {
        buildModeController.verifyUnSelectExtraCredit();
    }

    //Click on CompactView
    public void e_ClickOnCompactView() {
        buildModeController.clickOnCompactView();
    }

    //Validate Extra Credit for Compact View
    public void v_VerifyExtraCreditForCompactView() {
        buildModeController.verifyExtraCreditForCompactView();
    }

    //click Navigate to BrowsePage ByS electing ExraCredit
    public void e_NavigateToBrowsePageBySelectingExtraCredit() {
        buildModeController.navigateToBrowsePageBySelectingExtraCredit();
    }

    //Validate ExtraCredit Selection by Navigation
    public void v_VerifyExtraCreditSelectionByNavigation() {
        buildModeController.verifyExtraCreditSelectionByNavigation();
    }
}
