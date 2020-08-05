package org.graphwalker.PageObjectModels;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

//Page object model class
public class FlexAnswerKeyPage {
    String dir = null;
    Properties properties = new Properties();
    InputStream input = null;
    private static String os = null;

    public FlexAnswerKeyPage() {
        try {
            dir = System.getProperty("user.dir");
            dir = dir.replace("Dna_ItembankAssessment_QuickMode", "");
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
    private String createAssessment;

    public String getCreateAssessment() {
        createAssessment = properties.getProperty("FLEXANSWERKEY_CREATEASSESSMENT");
        return createAssessment;
    }
}
