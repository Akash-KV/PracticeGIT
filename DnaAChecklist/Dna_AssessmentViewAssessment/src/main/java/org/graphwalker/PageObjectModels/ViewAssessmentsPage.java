package org.graphwalker.PageObjectModels;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * Page Object Model class for ViewAssessmentsPage
 **/
public class ViewAssessmentsPage {
    private String createButton, searchAssessmentInput, searchButton, loader, submitButton, newAssessmentView, alert;
    private String linkToAssessmentsModal, actionsDropdownSelect, addQuestionsButton, createButtonDropdownAssessmentView, flexible, addAssessmentTitle, createFlexibleButton, submitButtonAssessmentView;


    String dir = null;
    Properties properties = new Properties();
    InputStream input = null;
    private static String os = null;

    public ViewAssessmentsPage() {
        try {
            dir = System.getProperty("user.dir");
            dir = dir.replace("Dna_AssessmentViewAssessment", "");
            os = System.getProperty("os.name");
            if (os.contains("Windows")) {
                input = new FileInputStream(dir + "\\Properties\\ViewAssessmentsPage.properties");
            } else {
                input = new FileInputStream(dir + "/Properties/ViewAssessmentsPage.properties");
            }
            properties.load(input);
        } catch (IOException ex) {
            ex.printStackTrace();
        } finally {
            if (input != null) {
                try {
                    input.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /**
     * Methods to read locators from Property file
     **/

    public String getCreateButton() {
        createButton = properties.getProperty("VIEWASSESSMENTS_CREATEBUTTON");
        return createButton;
    }

    public String getFlexible() {
        flexible = properties.getProperty("VIEWASSESSMENTS_FLEXIBLE");
        return flexible;
    }

    public String getAddAssessmentTitle() {
        addAssessmentTitle = properties.getProperty("VIEWASSESSMENTS_ADDASSESSMENTTITLE");
        return addAssessmentTitle;
    }

    public String getCreateFlexibleButton() {
        createFlexibleButton = properties.getProperty("VIEWASSESSMENTS_CREATEFLEXIBLEBUTTON");
        return createFlexibleButton;
    }

    public String getSearchAssessmentInput() {
        searchAssessmentInput = properties.getProperty("VIEWASSESSMENTS_SEARCHASSESSMENTINPUT");
        return searchAssessmentInput;
    }

    public String getViewAssessmentSearchButton() {
        searchButton = properties.getProperty("VIEWASSESSMENTS_SEARCHBUTTON");
        return searchButton;
    }

    public String getLoader() {
        loader = properties.getProperty("VIEWASSESSMENTS_LOADER");
        return loader;
    }

    public String getSubmitButton() {
        submitButton = properties.getProperty("VIEWASSESSMENTS_SUBMITBUTTON");
        return submitButton;
    }

    public String getNewAssessmentView() {
        newAssessmentView = properties.getProperty("VIEWASSESSMENTS_NEWASSESSMENTVIEW");
        return newAssessmentView;
    }

    public String getSubmitButtonInAssessmentViewPopup() {
        submitButtonAssessmentView = properties.getProperty("VIEWASSESSMENTS_SUBMITBUTTONASSESSMENTVIEW");
        return submitButtonAssessmentView;
    }

    public String getAlert() {
        alert = properties.getProperty("VIEWASSESSMENTS_ALERT");
        return alert;
    }


    public String getAddQuestionsButton() {
        addQuestionsButton = properties.getProperty("VIEWASSESSMENTS_ADDQUESTIONSBUTTON");
        return addQuestionsButton;
    }

    public String getActionsDropdownSelect() {
        actionsDropdownSelect = properties.getProperty("VIEWASSESSMENTS_ACTIONSDROPDOWNSELECT");
        return actionsDropdownSelect;
    }

    public String getLinkToAssessmentsModal() {
        linkToAssessmentsModal = properties.getProperty("VIEWASSESSMENTS_LINKTOASSESSMENTSMODAL");
        return linkToAssessmentsModal;
    }
}
