package org.graphwalker.PageObjectModels;

//Page object model class forAssessmentsNavbar
public class AssessmentsNavbar extends PageObjectModelBase {
    private String viewAssessment;
    private String itembankAssessment;

    /*
    Methods of assessments Nav Bar
    */
    public String getViewAssessment() {
        viewAssessment = reader.getData("viewAssessment");
        return viewAssessment;
    }

    public String getItembankAssessment() {
        itembankAssessment = reader.getData("createNewItembankLink");
        return itembankAssessment;
    }
}