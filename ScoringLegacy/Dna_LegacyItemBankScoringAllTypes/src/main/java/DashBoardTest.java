import Controllers.DashBoardController;
import Controllers.ItemBankAssessmentController;
import org.graphwalker.core.machine.ExecutionContext;
import org.graphwalker.java.annotation.GraphWalker;

@GraphWalker(value = "quick_random(edge_coverage(100))")
public class DashBoardTest extends ExecutionContext implements DashBoardPage {
    DashBoardController dashBoardController = new DashBoardController();
    ItemBankAssessmentController itemBankAssessmentController = new ItemBankAssessmentController();

    public void v_Dashboard() {
        dashBoardController.validateDashBoard();
    }

    //Click Navbar
    public void e_ClickNavbar() {
        /*Click Assessments in left panel*/
        dashBoardController.clickNavBar();
    }

    //Validate Navbar
    public void v_Navbar() {
        /*Validate Assessments modal*/
        dashBoardController.validateNavBar();
    }

    //Click on ItemBankAssessment
    public void e_NavItemBankAssessmentClick() {
        /*Click Create Assessment*/
        dashBoardController.navigateToItemBankAssessment();
    }

    //Validate Title Page
    public void v_TitlePage() {
        /*Validate Create ItemBank Assessment modal*/
        itemBankAssessmentController.validateTitlePage();
    }

    public void v_TitlePageToCreateAssessment() {

        itemBankAssessmentController.validateTitlePageCreateAssessment();
    }

    //Create Assessment
    public void e_CreateAssessment() {
        itemBankAssessmentController.createAssessment();

    }

    //Validate create Aassessment
    public void v_CreateAssessment() {

    }

    //Click on PublishAndAdminister
    public void e_PublishAndAdministerClick() {

        itemBankAssessmentController.publishAndAdministerClick();

    }
    //validate AdministrationPagePortal
    public void v_AdministrationPagePortal() {

    }


}
