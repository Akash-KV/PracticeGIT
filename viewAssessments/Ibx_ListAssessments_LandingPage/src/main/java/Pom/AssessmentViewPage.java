package Pom;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

//Page object model class for AssessmentViewPage page
public class AssessmentViewPage {
    private String titleInputField;
    private String descriptionInputField;
    private String chooseAssessmentsButton;
    private String saveButton, onlyShowAsmtToggleInput, onlyShowAsmtToggleLable, createButton, filterModel, resetButton, assessmentType;
    private String numberOfAssessments, assessmentTypeClick, search, searchClick, ascDataColumn, ascDataColumnClick, desDataColumn, desDataColumnClick, firstRowClick, firstRow;
    private String visibalityOfAllElements, nextPageNumberOfElements, nextPageCurrentPage, flexibleElement;
    private String listAssessmentNavigation, listViewAssessmentsClick, scopeSelector, userButton, userGrantee, adminPermissinHeader, tbody, save;
    private String itembankWithoutLocated, itembankWithLocated, itembankWithStudentResponse, flexibleWithLocated, flexibleWithoutTitle;
    String dir = null;
    Properties properties = new Properties();
    InputStream input = null;
    private static String os = null;

    public AssessmentViewPage() {
        try {
            dir = System.getProperty("user.dir");
            dir = dir.replace("Ibx_ListAssessments_LandingPage", "");
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
    Methods to read the Locators from property file
    */
    public String getTitleInputField() {
        titleInputField = properties.getProperty("TITLE_INPUT_FIELD");
        return titleInputField;
    }

    public String getDescriptionInputField() {
        descriptionInputField = properties.getProperty("DESCRIPTION_INPUT_FIELD");
        return descriptionInputField;
    }

    public String getChooseAssessmentsButton() {
        chooseAssessmentsButton = properties.getProperty("CHOOSE_ASSESSMENTS_BUTTON");
        return chooseAssessmentsButton;
    }

    public String getSaveButton() {
        saveButton = properties.getProperty("SAVE_BUTTON");
        return saveButton;
    }

    public String getOnlyShowAsmtToggleInput() {
        onlyShowAsmtToggleInput = properties.getProperty("ONLY_SHOW_ASSESSMENT_WITH_DATA_TOGGLE_INPUT");
        return onlyShowAsmtToggleInput;
    }

    public String getOnlyShowAsmtToggleLable() {
        onlyShowAsmtToggleLable = properties.getProperty("ONLY_SHOW_ASSESSMENT_WITH_DATA_TOGGLE_LABLE");
        return onlyShowAsmtToggleLable;
    }

    public String getCreateButton() {
        createButton = properties.getProperty("CREATE_BUTTON");
        return createButton;
    }

    public String getFilterModel() {
        filterModel = properties.getProperty("FILTER_MODEL");
        return filterModel;
    }

    public String getResetButton() {
        resetButton = properties.getProperty("RESET_BUTTON");
        return resetButton;
    }

    public String getAssessmentType() {
        assessmentType = properties.getProperty("ASSESSMENT_TYPE");
        return assessmentType;
    }

    public String getnumberOfAssessments() {
        numberOfAssessments = properties.getProperty("NUMBER_OF_ASSESSMENTS");
        return numberOfAssessments;
    }

    public String getFlexibleElement() {
        flexibleElement = properties.getProperty("FLEXIBLE_ELEMENT");
        return flexibleElement;
    }

    public String getSearch() {
        search = properties.getProperty("SEARCH");
        return search;
    }

    public String getAscDataColumn() {
        ascDataColumn = properties.getProperty("ASC_DATA_COLUMN");
        return ascDataColumn;
    }

    public String getAscDataColumnClick() {
        ascDataColumnClick = properties.getProperty("ASC_DATA_COLUMN_CLICK");
        return ascDataColumnClick;
    }

    public String getDesDataColumn() {
        desDataColumn = properties.getProperty("DES_DATA_COLUMN");
        return desDataColumn;
    }

    public String getdesDataColumnClick() {
        desDataColumnClick = properties.getProperty("DES_DATA_COLUMN_CLICK");
        return desDataColumnClick;
    }

    public String getFirstRow() {
        firstRow = properties.getProperty("FIRST_ROW");
        return firstRow;
    }

    public String getFirstRowClick() {
        firstRowClick = properties.getProperty("FIRST_ROW_CLICK");
        return firstRowClick;
    }

    public String getVisibalityOfAllElements() {
        visibalityOfAllElements = properties.getProperty("VISIBALITY_OF_ALL_ELEMENTS_LOCATED");
        return visibalityOfAllElements;
    }

    public String getNextPageNumberOfElements() {
        nextPageNumberOfElements = properties.getProperty("NEXT_PAGE_NUMBER_OF_ELEMENTS");
        return nextPageNumberOfElements;
    }

    public String getNextPageCurrentPage() {
        nextPageCurrentPage = properties.getProperty("NEXT_PAGE_CURRENT_PAGE");
        return nextPageCurrentPage;
    }

    public String getListAssessmentNavigation() {
        listAssessmentNavigation = properties.getProperty("LIST_ASSESSMENTS_NAVIGATION_SIDEBAR");
        return listAssessmentNavigation;
    }

    public String getListViewAssessmentsClick() {
        listViewAssessmentsClick = properties.getProperty("LIST_VIEW_ASSESSMENTS_CLICK");
        return listViewAssessmentsClick;
    }

    public String getScopeSelector() {
        scopeSelector = properties.getProperty("SCOPE_SELECTOR");
        return scopeSelector;
    }

    public String getUserButton() {
        userButton = properties.getProperty("USER_BUTTON");
        return userButton;
    }


    public String getUserGrantee() {
        userGrantee = properties.getProperty("USER_GRANTEE");
        return userGrantee;
    }

    public String getAdminPermissinHeader() {
        adminPermissinHeader = properties.getProperty("ADMIN_PERMISSION_HEADER");
        return adminPermissinHeader;
    }

    public String getTbody() {
        tbody = properties.getProperty("T_BODY");
        return tbody;
    }

    public String getSave() {
        save = properties.getProperty("SAVE");
        return save;
    }

    public String getItembankWithoutLocated() {
        itembankWithoutLocated = properties.getProperty("ITEMBANK_WITHOUT_DATA_ELEMENT_LOCATED");
        return itembankWithoutLocated;
    }

    public String getItembankWithLocated() {
        itembankWithLocated = properties.getProperty("ITEMBANK_WITH_DATA_ELEMENT_LOCATED");
        return itembankWithLocated;
    }

    public String getItembankWithStudentResponse() {
        itembankWithStudentResponse = properties.getProperty("ITEMBANK_WITH_DATA_STUDENT_RESPONSE");
        return itembankWithStudentResponse;
    }

    public String getFlexibleWithLocated() {
        flexibleWithLocated = properties.getProperty("FLEXIBLE_WITH_DATA_ELEMENT_LOCATED");
        return flexibleWithLocated;
    }

    public String getFlexibleWithoutTitle() {
        flexibleWithoutTitle = properties.getProperty("FLEXIBLE_WITHOUT_DATA_TITLE");
        return flexibleWithoutTitle;
    }

    public String getAssessmentTypeclick() {
        assessmentTypeClick = properties.getProperty("ASSESSMENT_TYPE_CLICK");
        return assessmentTypeClick;
    }
}
