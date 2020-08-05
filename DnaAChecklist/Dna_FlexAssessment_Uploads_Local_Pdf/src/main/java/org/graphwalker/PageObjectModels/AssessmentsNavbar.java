package org.graphwalker.PageObjectModels;

public class AssessmentsNavbar extends PageObjectModelBase {
    private String viewAssessment;
    private String flexAssessment;
    private String createAssessment;
    private String summaryAssessment;
    private String assessmentView;
    private String plainTextAssessment;
    private String surveyAssessment;
    private String itembankAssessment;
    private String visitItembank;
    private String performanceBand;

    public String getViewAssessment() {
        viewAssessment = reader.getData("viewAssessment");
        return viewAssessment;
    }

    public String getFlexAssessment() {
        return flexAssessment;
    }

    public String getCreateAssessment() {
        return createAssessment;
    }

    public String getSummaryAssessment() {
        return summaryAssessment;
    }

    public String getAssessmentView() {
        return assessmentView;
    }

    public String getPlainTextAssessment() {
        return plainTextAssessment;
    }

    public String getSurveyAssessment() {
        return surveyAssessment;
    }

    public String getItembankAssessment() {
        itembankAssessment = reader.getData("createNewItembankLink");
        return itembankAssessment;
    }

    public String getVisitItembank() {
        return visitItembank;
    }

    public String getPerformanceBand() {
        return performanceBand;
    }
}