package org.graphwalker.PageObjectModels;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

//Page object model class
public class CreateAssessmentModal {
    String dir = null;
    Properties properties = new Properties();
    InputStream input = null;
    private static String os = null;

    public CreateAssessmentModal() {
        try {
            dir = System.getProperty("user.dir");
            dir = dir.replace("Dna_SummaryAssessment", "");
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
    private String othersTab, clickSummaryTab, summaryTitleTextField, saveButton, overViewPage;

    public String getOthersTab() {
        othersTab = properties.getProperty("CREATEASSESSMENTMODEL_OTHERSTAB");
        return othersTab;
    }

    public String getClickSummaryTab() {
        clickSummaryTab = properties.getProperty("CREATEASSESSMENTMODEL_CLICKSUMMARYTAB");
        return clickSummaryTab;
    }

    public String getSummaryTitleTextField() {
        summaryTitleTextField = properties.getProperty("CREATEASSESSMENTMODEL_SUMMARYTITLE_TEXTFIELD");
        return summaryTitleTextField;
    }

    public String getSaveButton() {
        saveButton = properties.getProperty("CREATEASSESSMENTMODEL_SAVE_BUTTON");
        return saveButton;
    }

    public String getOverViewPage() {
        overViewPage = properties.getProperty("CREATEASSESSMENTMODEL_OVERVIEWPAGE");
        return overViewPage;
    }
}
