package Pom;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * Page Object Model class for ViewAssessments_AddFilters
 **/

public class ViewAssessments_AddFilters {
    private String addFilterPopup, filteredValue, searchButton_AddFilters, yearFilter, typeFilter, gradeFilter;
    private String authorFilter, filterValueList, closeForSelectedOption, authorLabel, resetButton_AddFilters;
    private String scopeFilter, subjectFilter, dateCreated_Start, dateCreated_End, closeButton;
    private String typeLabel, yearLabel, gradeLabel, scopeLabel, subjectLabel;


    String dir = null;
    Properties properties = new Properties();
    InputStream input = null;
    private static String os = null;

    public ViewAssessments_AddFilters() {
        try {
            dir = System.getProperty("user.dir");
            dir = dir.replace("Ibx_ViewAssessments_Filters", "");
            os = System.getProperty("os.name");
            if (os.contains("Windows")) {
                input = new FileInputStream(dir + "\\Properties\\ViewAssessments_AddFilters.properties");
            } else {
                input = new FileInputStream(dir + "/Properties/ViewAssessments_AddFilters.properties");
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
     * Methods to read Locators from Property file
     **/


    public String getAddFilterPopup() {
        addFilterPopup = properties.getProperty("ADD_FILTER_POPUP");
        return addFilterPopup;
    }

    public String getFilteredValue(String Value) {
        filteredValue = "//div[@id='select2-drop']//ul//li/div[.='" + Value + "']";
        return filteredValue;
    }

    public String getAuthorLabel() {
        authorLabel = properties.getProperty("AUTHOR_LABEL");
        return authorLabel;
    }


    public String getFilterValueList() {
        filterValueList = properties.getProperty("FILTER_VALUE_LIST");
        return filterValueList;
    }

    //ID
    public String getSearchButton_AddFilters() {
        searchButton_AddFilters = "search-btn";
        return searchButton_AddFilters;
    }

    public String getAuthorFilter() {
        authorFilter = properties.getProperty("AUTHOR_FILTER");
        return authorFilter;
    }

    public String getTypeFilter() {
        typeFilter = properties.getProperty("TYPE_FILTER");
        return typeFilter;
    }

    public String getYearFilter() {
        yearFilter = properties.getProperty("YEAR_FILTER");
        return yearFilter;
    }

    public String getGradeFilter() {
        gradeFilter = properties.getProperty("GRADE_FILTER");
        return gradeFilter;
    }

    public String getScopeFilterInput() {
        scopeFilter = properties.getProperty("SCOPE_FILTER");
        return scopeFilter;
    }

    public String getSubjectFilterInput() {
        subjectFilter = properties.getProperty("SUBJECT_FILTER");
        return subjectFilter;
    }

    public String getCloseForSelectedOption() {
        closeForSelectedOption = properties.getProperty("CLOSE_FOR_SELECTED_OPTION");
        return closeForSelectedOption;
    }

    public String getResetButton_AddFilters() {
        resetButton_AddFilters = "reset-btn";
        return resetButton_AddFilters;
    }

    public String getDateCreated_Start() {
        dateCreated_Start = properties.getProperty("DATE_CREATED_START");
        return dateCreated_Start;
    }

    public String getDateCreated_End() {
        dateCreated_End = properties.getProperty("DATE_CREATED_END");
        return dateCreated_End;
    }

    public String getCloseButton() {
        closeButton = properties.getProperty("CLOSE_BUTTON");
        return closeButton;
    }

    public String getTypeLabel() {
        typeLabel = properties.getProperty("TYPE_LABEL");
        return typeLabel;
    }

    public String getYearLabel() {
        yearLabel = properties.getProperty("YEAR_LABEL");
        return yearLabel;
    }

    public String getGradeLabel() {
        gradeLabel = properties.getProperty("GRADE_LABEL");
        return gradeLabel;
    }

    public String getScopeLabel() {
        scopeLabel = properties.getProperty("SCOPE_LABEL");
        return scopeLabel;
    }

    public String getSubjectLabel() {
        subjectLabel = properties.getProperty("SUBJECT_LABEL");
        return subjectLabel;
    }
}
