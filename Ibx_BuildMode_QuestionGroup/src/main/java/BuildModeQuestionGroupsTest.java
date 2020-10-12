
import Controllers.BrowseModeController;
import Controllers.BuildModeController;
import org.graphwalker.core.machine.ExecutionContext;
import org.graphwalker.java.annotation.GraphWalker;

/**
 * Test class for BuildModeQuestionGroups
 **/
@GraphWalker(value = "quick_random(edge_coverage(100))")
public class BuildModeQuestionGroupsTest extends ExecutionContext implements BuildModeQuestionGroups {

    BuildModeController buildModeController = new BuildModeController();
    BrowseModeController browseModeController = new BrowseModeController();

    //Validate Browse question group
    public void v_BuildModeQuestionGroupsTest() {
        browseModeController.verifyNoItemsFound();
    }

    //click on create assessment button
    public void e_ClickCreateAssessmentButton() {
        buildModeController.clickCreateAssessmentButton();
    }

    //validate create assessment popup
    public void v_VerifyCreateAssessmentPopup() {
        buildModeController.verifyCreateAssessmentPopup();
    }

    //create assessment
    public void e_CreateAssessment() {
        buildModeController.createAssessment();
    }

    //validate navigation to build mode
    public void v_VerifyNavigationToBuildPage() {
        buildModeController.verifyNavigationToBuildPage();
    }

    //Click on Question groups
    public void e_ClickQuestionGroups() {
        buildModeController.clickQuestionGroups();
    }

    //validate Question Group selection
    public void v_VerifyQuestionGroupSelection() {
        buildModeController.verifyQuestionGroupSelection();
    }

    //click on multiple question groups
    public void e_ClickMultipleQuestionGroups() {
        buildModeController.clickMultipleQuestionGroups();
    }

    //validate VerifyMultipleQuestionGroupSelection
    public void v_VerifyMultipleQuestionGroupSelection() {
        buildModeController.verifyMultipleQuestionGroupSelection();
    }

    //click on hover
    public void e_Hover() {
        buildModeController.hover();
    }

    //validate Hover
    public void v_VerifyHover() {
        buildModeController.verifyHover();
    }

    //click on searchQuestion group
    public void e_SearchQuestionGroups() {
        buildModeController.searchQuestionGroups();
    }

    //validate Search
    public void v_VerifySearch() {
        buildModeController.verifySearch();
    }

    //click search and add new
    public void e_SearchAndAddNew() {
        buildModeController.searchAndAddNew();
    }

    //validate add new question group
    public void v_VerifyAddNewQuestionGroup() {
        buildModeController.verifyAddNewQuestionGroup();
    }

    //click on UnSelect New QuestionGroup
    public void e_UnSelectNewQuestionGroup() {
        buildModeController.unSelectNewQuestionGroup();
    }

    //validate Question Group
    public void v_VerifyQuestionGroup() {
        buildModeController.verifyQuestionGroup();
    }

    //click search and enter
    public void e_SearchAndEnter() {
        buildModeController.searchAndEnter();
    }

    //validate Search Using EnterKey
    public void v_VerifySearchUsingEnterKey() {
        buildModeController.verifySearchUsingEnterKey();
    }

    //click on search selected
    public void e_SearchSelected() {
        //Already handled in previous methods....
    }

    //Validate UnSelect Using EnterKey
    public void v_VerifyUnSelectUsingEnterKey() {
        //Already handled in previous methods....
    }

    //search Upper And LowerCase
    public void e_SearchUpperAndLowerCase() {
        buildModeController.searchUpperAndLowerCase();
    }

    //validate search by case
    public void v_VerifySearchByCase() {
        buildModeController.verifySearchByCase();
    }

    //search on passage meta data
    public void e_SearchPassageMetadata() {
        buildModeController.searchPassageMetadata();
    }

    //validate meta data add
    public void v_VerifyMetadataAdd() {
    }

    //click on Dok
    public void e_RemoveDOKAlignmentForItem() {
        buildModeController.removeDOKAlignmentForItem();
    }

    //validate enable and disable
    public void v_VerifyEnableDisableQuestionGroups() {
        buildModeController.verifyEnableDisableQuestionGroups();
    }

    //click auto item enabled
    public void e_ClickItemWithAutoEnabledReportingCategory() {
    }

    //validate default label
    public void v_VerifyDefaultLabel() {
    }
}
