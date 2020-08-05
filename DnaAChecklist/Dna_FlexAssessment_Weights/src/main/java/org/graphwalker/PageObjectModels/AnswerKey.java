package org.graphwalker.PageObjectModels;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

//Page object model class
public class AnswerKey {
    String dir = null;
    Properties properties = new Properties();
    InputStream input = null;
    private static String os = null;

    public AnswerKey() {
        try {
            dir = System.getProperty("user.dir");
            dir = dir.replace("Dna_FlexAssessment_Weights", "");
            os = System.getProperty("os.name");
            if (os.contains("Windows")) {
                input = new FileInputStream(dir + "\\Properties\\AnswerKey.properties");
            } else {
                input = new FileInputStream(dir + "/Properties/AnswerKey.properties");
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
    private String addQuestions, questionQuality, addButton, questionsSaved;


    public String getAddQuestions() {
        addQuestions = properties.getProperty("ANSWERKEY_ADDQUESTIONS");
        return addQuestions;
    }

    public String getQuestionQuality() {
        questionQuality = properties.getProperty("ANSWERKEY_QUESTIONQUANTITY");
        return questionQuality;
    }

    public String getAddButton() {
        addButton = properties.getProperty("ANSWERKEY_ADDBUTTON");
        return addButton;
    }

    public String getQuestionsSaved() {
        questionsSaved = properties.getProperty("ANSWERKEY_QUESTIONSSAVED");
        return questionsSaved;
    }
}
