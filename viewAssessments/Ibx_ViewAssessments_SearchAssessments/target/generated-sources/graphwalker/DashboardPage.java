// Generated by GraphWalker (http://www.graphwalker.org)
import org.graphwalker.java.annotation.Model;
import org.graphwalker.java.annotation.Vertex;
import org.graphwalker.java.annotation.Edge;

@Model(file = "DashboardPage.graphml")
public interface DashboardPage {

    @Vertex()
    void v_Dashboard();

    @Edge()
    void e_ClickNavbar();

    @Vertex()
    void v_Navbar();

    @Vertex()
    void v_ViewAssessmentsPage();
}
