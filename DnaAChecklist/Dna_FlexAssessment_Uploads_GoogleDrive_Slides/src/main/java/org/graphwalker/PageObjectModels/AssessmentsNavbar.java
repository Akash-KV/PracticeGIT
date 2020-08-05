package org.graphwalker.PageObjectModels;

//Page object model class for AssessmentsNavbar
public class AssessmentsNavbar extends PageObjectModelBase {
    private String viewAssessment;
    private String itembankAssessment;

    /*
    Methods for assessment nav bar
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