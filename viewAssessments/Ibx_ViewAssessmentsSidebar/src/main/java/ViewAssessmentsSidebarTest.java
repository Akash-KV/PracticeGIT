import Controllers.SidebarController;
import Controllers.ViewAssessmentsController;
import org.graphwalker.core.machine.ExecutionContext;
import org.graphwalker.java.annotation.GraphWalker;

@GraphWalker(value = "quick_random(edge_coverage(100))")
//Test Class for ViewAssessmentsSidebarSelectionTest
public class ViewAssessmentsSidebarTest extends ExecutionContext implements ViewAssessmentsSidebar {

    SidebarController sidebarController = new SidebarController();
    ViewAssessmentsController viewAssessmentsController = new ViewAssessmentsController();

    public void v_ViewAssessmentsPage() {

        sidebarController.verifyViewAssessmentsPage();
    }

    public void e_ClickAllAssessments() {
        //Click All Assessments Link
        sidebarController.clickAllAssessments();
    }

    public void v_AllAssessments() {
        //Verify Assessment Created by logged in User AND Other users
        //First Search Assessment created by logged in user
        sidebarController.verifyAllAssessments();
    }

    public void e_ClickMyAssessments() {
        //Click My Assessments Link
        sidebarController.clickMyAssessments();
    }


    public void v_MyAssessments() {
        sidebarController.verfyMyAssessments();
    }

    public void e_ClickCreatedByMe() {
        //Click Created By Me Link
        sidebarController.clickCreatedByMe();
    }

    public void v_CreatedByMe() {
        sidebarController.validateCreatedByMe();
    }

    public void e_ClickFavorites() {
        //Click Favorites Link
        sidebarController.clickOnFavorites();
    }

    public void v_Favorites() {
        sidebarController.validateFavorites();
    }

    public void e_ClickUnpublishedItemBank() {
        //Click Favorites Link
        sidebarController.clickUnPublishedItemBank();
    }

    public void v_UnpublishedItemBank() {
        sidebarController.verifyUnPublishedItemBank();
    }

    public void e_ClickTrash() {
    }

    public void v_Trash() {
        sidebarController.validateTrash();
    }

    public void e_AddMyFavorite() {
        //Search Flexible assessment and click My Favorite
        //Click all assessments
        sidebarController.addMyFavorite();
    }

    public void v_CheckMyFavorite() {
        //Search in all assessments to Verify assessment name
        //Click on Favorites
        sidebarController.checkMyFavorite();
        //Assert.assertTrue(checkUnFlagFavorite);
    }


    public void e_AddDistrictFavorite() {
        //Search Flexible assessment and click My Favorite
        //Click all assessments
        sidebarController.addDistrictFavorite();
    }

    public void v_CheckDistrictFavorite() {
        sidebarController.validateDistrictFavorite();
    }

    public void e_Publish() {
        //<< On hold , Step 6(Publish) not showing in QA Site for unpublished item bank assessments >>
    }

    public void v_CheckUnpublishedItemBankAssessments() {
        //<< On hold , Step 6(Publish) not showing in QA Site for unpublished item bank assessments >>
    }

    public void e_ChangeAuthor() {
        //Commented due to change author works only once because once author is changed, again assessment will not be visible for next test run
        sidebarController.changeAuthor();
    }

    public void v_CheckCreatedByMeAssessments() {
        //Commented due to change author works only once because once author is changed, again assessment will not be visible for next test run

        sidebarController.checkCreatedByMeAssessments();

        // To clear added filters ,search text box and toggle button
        viewAssessmentsController.clearAddedFilter();
        viewAssessmentsController.clearSearchTextBox();
        viewAssessmentsController.turnOFFToggleButton();
    }
}
