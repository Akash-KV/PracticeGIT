package Pom;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

//Page object model for Assessment view page
public class AssessmentViewPage {
    private String titleInputField;
    private String descriptionInputField;
    private String chooseAssessmentsButton;
    private String saveButton;
    String dir = null;
    Properties properties = new Properties();
    InputStream input = null;
    private static String os = null;

    public AssessmentViewPage() {
        try {
            dir = System.getProperty("user.dir");
            dir = dir.replace("Dna_LegacyItemBankScoringAllTypes", "");
            System.out.println("dir: " + dir);
            os = System.getProperty("os.name");
            if (os.contains("Windows")) {
                input = new FileInputStream(dir + "\\Properties\\AssessmentViewPage.properties");
            } else {
                input = new FileInputStream(dir + "/Properties/AssessmentViewPage.properties");
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

    public String getTitleInputField() {
        titleInputField = properties.getProperty("ASSESSMENTVIEW_TITLEINPUTFIELD");
        return titleInputField;
    }

    public String getDescriptionInputField() {
        descriptionInputField = properties.getProperty("ASSESSMENTVIEW_DESCRIPTIONINPUTFIELD");
        return descriptionInputField;
    }

    public String getChooseAssessmentsButton() {
        chooseAssessmentsButton = properties.getProperty("ASSESSMENTVIEW_CHOOSEASSESSMENTSBUTTON");
        return chooseAssessmentsButton;
    }

    public String getSaveButton() {
        saveButton = properties.getProperty("ASSESSMENTVIEW_SAVEBUTTON");
        return saveButton;
    }
}
