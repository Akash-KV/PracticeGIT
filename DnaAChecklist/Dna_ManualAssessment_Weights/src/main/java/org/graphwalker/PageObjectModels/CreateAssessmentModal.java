package org.graphwalker.PageObjectModels;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

//Page object model class
public class CreateAssessmentModal {
    private String modalManualRadioButton;
    private String modalManualNumberOfQuestions;
    private String okayButton;
    private String createAssessmentModelClickLegacyTab;
    private String createAssessmentModalCreateButton;
    private String createAssessmentModalNumberOfQuestions;
    private String createAssessmentModelClickManual;

    String dir = null;
    Properties properties = new Properties();
    InputStream input = null;
    private static String os = null;


    public CreateAssessmentModal() {
        try {
            dir = System.getProperty("user.dir");
            dir = dir.replace("Dna_ManualAssessment_Weights", "");
            os = System.getProperty("os.name");
            if (os.contains("Windows")) {
                input = new FileInputStream(dir + "\\Properties\\CreateAssessmentModal.properties");
            } else {
                input = new FileInputStream(dir + "/Properties/CreateAssessmentModal.properties");
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
    public String getCreateAssessmentModalCreateButton() {
        createAssessmentModalCreateButton = properties.getProperty("CREATEASSESSMENTMODEL_CREATEBUTTON");
        return createAssessmentModalCreateButton;
    }

    public String getCreateAssessmentModalNumberOfQuestions() {
        createAssessmentModalNumberOfQuestions = properties.getProperty("CREATEASSESSMENTMODEL_NUMBEROFQUESTIONS");
        return createAssessmentModalNumberOfQuestions;
    }

    public String getCreateAssessmentModelClickManual() {
        createAssessmentModelClickManual = properties.getProperty("CREATEASSESSMENTMODEL_CLICKMANUAL");
        return createAssessmentModelClickManual;
    }

    public String getCreateAssessmentModelClickLegacyTab() {
        createAssessmentModelClickLegacyTab = properties.getProperty("CREATEASSESSMENTMODEL_CLICKLEGACYTAB");
        return createAssessmentModelClickLegacyTab;
    }

    public String getModalManualRadioButton() {
        modalManualRadioButton = properties.getProperty("CREATEASSESSMENTMODEL_MODELMANUALRADIOBUTTON");
        return modalManualRadioButton;
    }

    public String getModalManualNumberOfQuestions() {
        modalManualNumberOfQuestions = properties.getProperty("CREATEASSESSMENTMODEL_MODELMANUALNUMBEROFQUESTIONS");
        return modalManualNumberOfQuestions;
    }

    public String getOkayButton() {
        okayButton = properties.getProperty("CREATEASSESSMENTMODEL_OKAYBUTTON");
        return okayButton;
    }

}
