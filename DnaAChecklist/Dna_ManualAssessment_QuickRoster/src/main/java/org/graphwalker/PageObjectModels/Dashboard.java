package org.graphwalker.PageObjectModels;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/*******Page Object Model Class for Dashboard***********/
public class Dashboard {
    private String assessmentsNav;
    private String attendanceNav;
    private String behaviorNav;
    private String counselorNav;
    private String gradebookNav;
    private String gradesNav;
    private String healthNav;
    private String languageNav;
    private String reportsNav;
    private String schedulingNav;
    private String specEdNav;
    private String studentsNav;
    String dir = null;
    Properties properties = new Properties();
    InputStream input = null;
    private static String os = null;

    public Dashboard() {
        try {
            dir = System.getProperty("user.dir");
            dir = dir.replace("Dna_ManualAssessment_QuickRoster", "");
            System.out.println("dir: " + dir);
            os = System.getProperty("os.name");
            if (os.contains("Windows")) {
                input = new FileInputStream(dir + "\\Properties\\Dashboard.properties");
            } else {
                input = new FileInputStream(dir + "/Properties/Dashboard.properties");
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

    public String getAssessmentsNav() {
        assessmentsNav = properties.getProperty("DASHBOARD_ASSESSMENTS");
        return assessmentsNav;
    }

    public String getAttendanceNav() {
        return attendanceNav;
    }

    public String getCounselorNav() {
        return counselorNav;
    }

    public String getGradebookNav() {
        return gradebookNav;
    }

    public String getGradesNav() {
        return gradesNav;
    }

    public String getHealthNav() {
        return healthNav;
    }

    public String getLanguageNav() {
        return languageNav;
    }

    public String getReportsNav() {
        return reportsNav;
    }

    public String getSchedulingNav() {
        return schedulingNav;
    }

    public String getSpecEdNav() {
        return specEdNav;
    }

    public String getStudentsNav() {
        return studentsNav;
    }
}