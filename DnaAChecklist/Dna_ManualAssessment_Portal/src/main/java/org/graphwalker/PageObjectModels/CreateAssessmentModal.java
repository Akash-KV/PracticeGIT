package org.graphwalker.PageObjectModels;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/*******Page Object Model Class for CreateAssessmentModal***********/
public class CreateAssessmentModal {
    private String clickLegayTab, createAssessmentModalCreateButton;
    private String createAssessmentModalManual, createAssessmentModalNumberOfQuestions;

    String dir = null;
    Properties properties = new Properties();
    InputStream input = null;
    private static String os = null;

    public CreateAssessmentModal() {
        try {
            dir = System.getProperty("user.dir");
            dir = dir.replace("Dna_ManualAssessment_Portal", "");
            System.out.println("dir: " + dir);
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

    public String getClickLegayTab() {
        clickLegayTab = properties.getProperty("CREATEASSESSMENTMODEL_CLICKLEGACYTAB");
        return clickLegayTab;
    }

    public String getCreateAssessmentModalManual() {
        createAssessmentModalManual = properties.getProperty("CREATEASSESSMENTMODEL_CLICKMANUAL");
        return createAssessmentModalManual;
    }

    public String getCreateAssessmentModalNumberOfQuestions() {
        createAssessmentModalNumberOfQuestions = properties.getProperty("CREATEASSESSMENTMODEL_NUMBEROFQUESTIONS");
        return createAssessmentModalNumberOfQuestions;
    }

    public String getCreateAssessmentModalCreateButton() {
        createAssessmentModalCreateButton = properties.getProperty("CREATEASSESSMENTMODEL_CREATEBUTTON");
        return createAssessmentModalCreateButton;
    }
}
