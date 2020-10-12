import Controllers.BrowseModeController;
import Controllers.BuildModeController;
import org.graphwalker.core.machine.ExecutionContext;
import org.graphwalker.java.annotation.GraphWalker;

/**
 * Test  class for BuildModeWebAndPaperIcon
 **/
@GraphWalker(value = "quick_random(edge_coverage(100))")
public class BuildModeWebAndPaperIconTest extends ExecutionContext implements BuildModeWebAndPaperIcon {

    BuildModeController buildMode_Controller = new BuildModeController();
    BrowseModeController browseModeController = new BrowseModeController();

    // To validate BrowseMode page
    public void v_BrowseMode() {
        browseModeController.verifyNoItemsFound();
    }

    //Click on online item and click on create assessment
    public void e_OnlineItemClickCreateAssessment() {
        buildMode_Controller.OnlineItemClickCreateAssessment();
    }

    //Validate Media type is web only
    public void v_VerifyMediaType() {
        buildMode_Controller.verifyMediaType();
    }

    // click paper item
    public void e_ClickPaperItemClickCreateAssessment() {
    }

    //Validate Media type
    public void v_VerifyMediaTypePaper() {
    }

    //Click on online and paper icon item
    public void e_ClickOnlineAndPaper() {
        buildMode_Controller.clickOnlineAndPaper();
    }

    //Validate media type
    public void v_VerifyMediaTypeOnlineAndPaper() {
        buildMode_Controller.verifyMediaTypeOnlineAndPaper();
    }
}
