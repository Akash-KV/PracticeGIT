package org.graphwalker.PageObjectModels;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * Page Object Model Class for AssessmentPanelPage
 **/
public class AssessmentPanelPage {
    private String page, Answer, FirstAnswer, SecondAnswer, ThirdAnswer, FourthAnswer, FifthAnswer, SixthAnswer, exit, quickRosterAnswer;

    String dir = null;
    Properties properties = new Properties();
    InputStream input = null;
    private static String os = null;

    public AssessmentPanelPage() {
        try {
            dir = System.getProperty("user.dir");
            dir = dir.replace("Dna_FlexAssessment_QuickRoster", "");
            System.out.println("dir: " + dir);
            os = System.getProperty("os.name");
            if (os.contains("Windows")) {
                input = new FileInputStream(dir + "\\Properties\\AssessmentPanelPage.properties");
            } else {
                input = new FileInputStream(dir + "/Properties/AssessmentPanelPage.properties");
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

    public String getPage() {
        page = properties.getProperty("ASSESSMENTPANEL_PAGE");
        return page;
    }

    public String getFirstAnswer() {
        FirstAnswer = properties.getProperty("ASSESSMENTPANEL_FIRSTANSWER");
        return FirstAnswer;
    }

    public String getSecondAnswer() {
        SecondAnswer = properties.getProperty("ASSESSMENTPANEL_SECONDANSWER");
        return SecondAnswer;
    }

    public String getThirdAnswer() {
        ThirdAnswer = properties.getProperty("ASSESSMENTPANEL_THIRDANSWER");
        return ThirdAnswer;
    }

    public String getFourthAnswer() {
        FourthAnswer = properties.getProperty("ASSESSMENTPANEL_FOURTHANSWER");
        return FourthAnswer;
    }

    public String getFifthAnswer() {
        FifthAnswer = properties.getProperty("ASSESSMENTPANEL_FIFTHANSWER");
        return FifthAnswer;
    }

    public String getSixthAnswer() {
        SixthAnswer = properties.getProperty("ASSESSMENTPANEL_SIXTHANSWER");
        return SixthAnswer;
    }

    public String getExit() {
        exit = properties.getProperty("ASSESSMENTPANEL_EXIT");
        return exit;
    }

    public String getQuickRosterAnswer() {
        quickRosterAnswer = properties.getProperty("ASSESSMENTPANEL_QUICKROSTERANSWER");
        return quickRosterAnswer;
    }
}
