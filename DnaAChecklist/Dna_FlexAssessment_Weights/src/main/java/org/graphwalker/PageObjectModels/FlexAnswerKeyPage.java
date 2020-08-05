package org.graphwalker.PageObjectModels;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

//Page object model class
public class FlexAnswerKeyPage {
    private String flexAnswerKeyCloseButton, doneButton, create, createAssessment, flexible, addAssessmentTitle, editButton;

    String dir = null;
    Properties properties = new Properties();
    InputStream input = null;
    private static String os = null;

    public FlexAnswerKeyPage() {
        try {
            dir = System.getProperty("user.dir");
            dir = dir.replace("Dna_FlexAssessment_Weights", "");
            os = System.getProperty("os.name");
            if (os.contains("Windows")) {
                input = new FileInputStream(dir + "\\Properties\\FlexAnswerKeyPage.properties");
            } else {
                input = new FileInputStream(dir + "/Properties/FlexAnswerKeyPage.properties");
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

    /*
    Methods to read the data from Property file
    */

    public String getFlexAnswerKeyCloseButton() {
        flexAnswerKeyCloseButton = properties.getProperty("FLEXANSWERKEY_CANCELBUTTON");
        return flexAnswerKeyCloseButton;
    }

    public String getDoneButton() {
        doneButton = properties.getProperty("FLEXANSWERKEY_DONEBUTTON");
        return doneButton;
    }

    public String getCreate() {
        create = properties.getProperty("FLEXANSWERKEY_CREATE");
        return create;
    }

    public String getCreateAssessment() {
        createAssessment = properties.getProperty("FLEXANSWERKEY_CREATEASSESSMENT");
        return createAssessment;
    }

    public String getFlexible() {
        flexible = properties.getProperty("FLEXANSWERKEY_FLEXIBLE");
        return flexible;
    }

    public String getAddAssessmentTitle() {
        addAssessmentTitle = properties.getProperty("FLEXANSWERKEY_ADDASSESSMENTTITLE");
        return addAssessmentTitle;
    }

    public String getEditButton() {
        editButton = properties.getProperty("FLEXANSWERKEY_EDITBUTTON");
        return editButton;
    }
}
