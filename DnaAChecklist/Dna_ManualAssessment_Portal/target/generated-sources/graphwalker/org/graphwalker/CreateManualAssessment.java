// Generated by GraphWalker (http://www.graphwalker.org)
package org.graphwalker;

import org.graphwalker.java.annotation.Model;
import org.graphwalker.java.annotation.Vertex;
import org.graphwalker.java.annotation.Edge;

@Model(file = "org/graphwalker/CreateManualAssessment.graphml")
public interface CreateManualAssessment {

    @Vertex()
    void v_StepTwo();

    @Edge()
    void e_ClickFinish();

    @Vertex()
    void v_Dashboard();

    @Edge()
    void e_ClickNavbar();

    @Vertex()
    void v_OverviewPageAfterEnterEdit();

    @Vertex()
    void v_AdministerOnline();

    @Edge()
    void e_StartBrowser();

    @Edge()
    void e_ClickAssessmentPanel();

    @Edge()
    void e_ClickOverviewPageBeforeEnterEdit();

    @Edge()
    void e_ClickEnterEdit();

    @Edge()
    void e_ClickReportsAfterEnterEdit();

    @Edge()
    void e_CreateNewAssessmentClick();

    @Vertex()
    void v_BaseURL();

    @Edge()
    void e_OkayClick();

    @Vertex()
    void v_AssessmnentPanel();

    @Edge()
    void e_ClickReports();

    @Vertex()
    void v_AdministrationPage();

    @Edge()
    void e_EnterBaseURL();

    @Edge()
    void e_ClickExitAssessmentPanel();

    @Vertex()
    void v_StepThree();

    @Vertex()
    void v_StepSeven();

    @Vertex()
    void v_StepOne();

    @Vertex()
    void v_StudentSmallSlipsAfterEnterEdit();

    @Vertex()
    void v_ReturnToAdministrationPage();

    @Vertex()
    void v_EnterEdit();

    @Edge()
    void e_DirectLogin();

    @Vertex()
    void v_BrowserStarted();

    @Vertex()
    void v_StudentSmallSlipsBeforeEnterEdit();

    @Edge()
    void e_ClickPortal();

    @Edge()
    void e_ExitCreationMode();

    @Vertex()
    void v_CreateNewAssessment();

    @Edge()
    void e_NextClick();

    @Vertex()
    void v_StudentTakePortalAssessment();

    @Vertex()
    void v_Navbar();

    @Vertex()
    void v_OverviewPageBeforeEnterEdit();

    @Edge()
    void e_EnterEditReturnToOverviewPage();
}
