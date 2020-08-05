// Generated by GraphWalker (http://www.graphwalker.org)
package org.graphwalker;

import org.graphwalker.java.annotation.Model;
import org.graphwalker.java.annotation.Vertex;
import org.graphwalker.java.annotation.Edge;

@Model(file = "org/graphwalker/CreateSummaryAssessment.graphml")
public interface CreateSummaryAssessment {

    @Edge()
    void e_ViewSummaryAssessmentClick();

    @Vertex()
    void v_Dashboard();

    @Edge()
    void e_ClickNavbar();

    @Edge()
    void e_ViewAssessments();

    @Edge()
    void e_StartBrowser();

    @Edge()
    void e_NavSummaryAssessmentClick();

    @Vertex()
    void v_BaseURL();

    @Edge()
    void e_Save();

    @Edge()
    void e_DirectLogin();

    @Vertex()
    void v_BrowserStarted();

    @Vertex()
    void v_SummaryAssessmentPage();

    @Edge()
    void e_EnterBaseURL();

    @Vertex()
    void v_Navbar();

    @Vertex()
    void v_OverviewPage();

    @Vertex()
    void v_ViewAssessments();
}
