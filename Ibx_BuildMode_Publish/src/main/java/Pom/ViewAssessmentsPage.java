package Pom;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * Page object model class for ViewAssessmentsPage
 **/
public class ViewAssessmentsPage {

    private String viewAssessmentsTable;
    private String assessmentName;
    private String draftItemBank;

    String dir = null;
    Properties properties = new Properties();
    InputStream input = null;
    private static String os = null;

    public ViewAssessmentsPage() {
        try {
            dir = System.getProperty("user.dir");
            dir = dir.replace("Ibx_BuildMode_Publish", "");
            System.out.println("dir: " + dir);
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
     * Methods to read property file
     **/

    public String getDraftItemBank() {
        draftItemBank = properties.getProperty("VIEWASSESSMENT_DRAFT_ITEM_BANK");
        return draftItemBank;
    }

    public String getViewAssessmentsTable() {
        viewAssessmentsTable = properties.getProperty("VIEWASSESSMENT_TABLE");
        return viewAssessmentsTable;
    }

    public String getAssessmentsName() {
        assessmentName = properties.getProperty("VIEWASSESSMENT_ASSSESSMENT_NAME");
        return assessmentName;
    }

}