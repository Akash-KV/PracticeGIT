package org.graphwalker.PageObjectModels;

public class AssessmentsNavbar extends PageObjectModelBase {
    private String viewAssessment;
    private String itembankAssessment;

    public String getViewAssessment() {
        viewAssessment = reader.getData("viewAssessment");
        return viewAssessment;
    }

    public String getItembankAssessment() {
        itembankAssessment = reader.getData("createNewItembankLink");
        return itembankAssessment;
    }
}