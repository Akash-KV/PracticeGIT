// Generated by GraphWalker (http://www.graphwalker.org)
import org.graphwalker.java.annotation.Model;
import org.graphwalker.java.annotation.Vertex;
import org.graphwalker.java.annotation.Edge;

@Model(file = "DashBoardPage.graphml")
public interface DashBoardPage {

    @Vertex()
    void v_TitlePage();

    @Vertex()
    void v_Dashboard();

    @Edge()
    void e_ClickNavbar();

    @Edge()
    void e_PublishAndAdministerClick();

    @Edge()
    void e_CreateAssessment();

    @Vertex()
    void v_TitlePageToCreateAssessment();

    @Vertex()
    void v_CreateAssessment();

    @Vertex()
    void v_Navbar();

    @Vertex()
    void v_AdministrationPagePortal();

    @Edge()
    void e_NavItemBankAssessmentClick();
}
