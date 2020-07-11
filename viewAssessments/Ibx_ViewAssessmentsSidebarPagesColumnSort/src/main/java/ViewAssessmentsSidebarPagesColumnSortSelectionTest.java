
import Controllers.ViewAssessmentsController;
import org.graphwalker.core.machine.ExecutionContext;
import org.graphwalker.java.annotation.GraphWalker;

@GraphWalker(value = "quick_random(edge_coverage(100))")
public class ViewAssessmentsSidebarPagesColumnSortSelectionTest extends ExecutionContext implements ViewAssessmentsSidebarPagesColumnSortSelection {

    ViewAssessmentsController viewAssessmentsController = new ViewAssessmentsController();

    public void v_VerifyViewAssessmentsSidebarPagesColumnSort() {

    }

    public void e_ClickAllAssessments() {
        viewAssessmentsController.clickAllAssessments();
    }

    public void v_AllAssessments() {
        viewAssessmentsController.allAssessments();
    }

    public void e_CreatedByMe() {
        viewAssessmentsController.createdByMe();
    }

    public void v_CreatedByMe() {
        viewAssessmentsController.verifyCreatedByMe();
    }

    public void v_Favorites() {
        viewAssessmentsController.favorites();
    }

    public void e_ClickFavorites() {
        viewAssessmentsController.clickFavorites();
    }

    public void e_ClickUnpublishedItemBank() {
        viewAssessmentsController.clickUnpublishedItemBank();
    }

    public void v_UnpublishedItemBank() {
        viewAssessmentsController.unpublishedItemBank();
    }


    public void e_SharedwithMe() {
        viewAssessmentsController.sharedwithMe();
    }


    public void v_SharedwithMe() {
        viewAssessmentsController.verifySharedwithMe();
    }

    public void e_ClickTrash() {
        viewAssessmentsController.clickTrash();
    }

    public void v_Trash() {
        viewAssessmentsController.trash();

        // To clear added filters ,search text box and toggle button
        viewAssessmentsController.clearAddedFilter();
        viewAssessmentsController.clearSearchTextBox();
        viewAssessmentsController.turnOFFToggleButton();
    }
}
