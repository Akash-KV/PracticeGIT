package org.graphwalker.PageObjectModels;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

//Page object model class for CreateAssessmentModal
public class CreateAssessmentModal {
    private String modalManualRadioButton;
    private String modalManualNumberOfQuestions;
    private String okayButton;

    /*
        Methods to read the data from Property file
        */
    public String getCreateAssessmentModelCreateButton() {
        createAssessmentModelCreateButton = properties.getProperty("CREATEASSESSMENTMODEL_CREATEBUTTON");
        return createAssessmentModelCreateButton;
    }

    private String createAssessmentModelCreateButton;

    public String getCreateAssessmentModelNumberOfQuestions() {
        createAssessmentModelNumberOfQuestions = properties.getProperty("CREATEASSESSMENTMODEL_NUMBEROFQUESTIONS");
        return createAssessmentModelNumberOfQuestions;
    }

    private String createAssessmentModelNumberOfQuestions;

    public String getCreateAssessmentModelClickManual() {
        createAssessmentModelClickManual = properties.getProperty("CREATEASSESSMENTMODEL_CLICKMANUAL");
        return createAssessmentModelClickManual;
    }

    private String createAssessmentModelClickManual;

    public String getCreateAssessmentModelClickLegacyTab() {
        createAssessmentModelClickLegacyTab = properties.getProperty("CREATEASSESSMENTMODEL_CLICKLEGACYTAB");
        return createAssessmentModelClickLegacyTab;
    }

    private String createAssessmentModelClickLegacyTab;
    String dir = null;
    Properties properties = new Properties();
    InputStream input = null;
    private static String os = null;

    public CreateAssessmentModal() {
        try {
            dir = System.getProperty("user.dir");
            dir = dir.replace("Dna_ManualAssessment_Uploads", "");
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
