package Pom;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

//Page Object Model Class for ViewAssessments_AddFilters
public class ViewAssessments_AddFilters {
    private String addFilterPopup, filteredValue, searchButton_AddFilters, yearFilter, typeFilter, typeOption, gradeFilter;
    private String authorFilter, filterValueList, closeForSelectedOption, authorLabel, resetButton_AddFilters;
    private String scopeFilter, subjectFilter, dateCreated_Start, dateCreated_End, closeButton, searchButtonAddFilterXpath;

    String dir = null;
    Properties properties = new Properties();
    InputStream input = null;
    private static String os = null;

    public ViewAssessments_AddFilters() {
        try {
            dir = System.getProperty("user.dir");
            dir = dir.replace("Ibx_ViewAssessments_ActionMenu", "");
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

    public String getAddFilterPopup() {
        addFilterPopup = "//div[@id='list-assessment-filters-modal']";
        return addFilterPopup;
    }

    public String getFilteredValue(String Value) {
        filteredValue = properties.getProperty("FILTERED_VALUE");
        return filteredValue;
    }

    public String getAuthorLabel() {
        authorLabel = properties.getProperty("AUTHOR_LABLE");
        return authorLabel;
    }

    public String getSearchButtonAddFilterXpath() {
        searchButtonAddFilterXpath = properties.getProperty("SEARCH_BUTTON_ADD_FILTER");
        return searchButtonAddFilterXpath;
    }


    public String getFilterValueList() {
        filterValueList = properties.getProperty("FILTER_VALUE_LIST");
        return filterValueList;
    }

    //ID
    public String getSearchButton_AddFilters() {
        searchButton_AddFilters = properties.getProperty("SEARCHBUTTON_ADDFILTER");
        return searchButton_AddFilters;
    }

    public String getAuthorFilter() {
        //authorFilter = "//div[@id='s2id_author']//input[starts-with(@id,'s2id_autogen')]";
        authorFilter = properties.getProperty("ATHOUR_FILTER");
        return authorFilter;
    }

    public String getTypeFilter() {
        typeFilter = properties.getProperty("TYPE_FILTER");
        return typeFilter;
    }

    public String getTypeOption(String option) {
        typeOption = "//div[contains(@id,'drop')]//span[text() = '" + option + "']";
        return typeOption;
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
        resetButton_AddFilters = properties.getProperty("RESETBUTTON_ADDFILTER");
        return resetButton_AddFilters;
    }

    public String getDateCreated_Start() {
        dateCreated_Start = properties.getProperty("DATECREATED_START");
        return dateCreated_Start;
    }

    public String getDateCreated_End() {
        dateCreated_End = properties.getProperty("DATECREATED_END");
        return dateCreated_End;
    }

    public String getCloseButton() {
        closeButton = properties.getProperty("CLOSE_BUTTON");
        return closeButton;
    }
}
