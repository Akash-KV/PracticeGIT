package Pom;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * Page object model class for BuildModePage
 **/
public class BuildModePage {

    private String build_Mode_Verify_Delete_Message, build_Mode_Delete_Submit_Button, build_Mode_Agree_Checkbox, build_Mode_Understand_Checkbox;
    private String build_Mode_Title_Editable, build_Mode_Deleted_Message_Close, build_Mode_File_Upload;
    private String build_Mode_Fourth_Uploaded_Material, build_Mode_Third_Uploaded_Material, build_Mode_Second_Uploaded_Material;
    private String build_Mode_Delete_Assessment, build_Mode_settings, build_Mode_Custom_Materials;
    private String build_Mode_Assessment_Page, build_Mode_Navigation_Page_Header, build_Mode_Overview_Page_View_Button;
    private String build_Mode_First_Uploaded_Material, build_Mode_Materials_Modal_Close, build_Mode_Materials_Upload;
    private String build_Mode_Overview_Page, build_Mode_Publish, build_Mode_Done,advancedTab;
    private String build_Mode_Materials_Modal, build_Mode_Materials, build_Item_Section, build_Question_Group_Hover;

    String dir = null;
    Properties properties = new Properties();
    InputStream input = null;
    private static String os = null;

    public BuildModePage() {
        try {
            dir = System.getProperty("user.dir");
            dir = dir.replace("Ibx_BuildMode_Materials", "");
            os = System.getProperty("os.name");
            if (os.contains("Windows")) {
                input = new FileInputStream(dir + "\\Properties\\BuildModePage.properties");
            } else {
                input = new FileInputStream(dir + "/Properties/BuildModePage.properties");
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
     * Methods to read locators from Property file
     **/

    public String getBuild_Item_Section() {
        build_Item_Section = properties.getProperty("BUILD_ITEM_SECTION");
        return build_Item_Section;
    }

    public String getBuild_Question_Group_Hover() {
        build_Question_Group_Hover = properties.getProperty("BUILD_QUESTION_GROUP_HOVER");
        return build_Question_Group_Hover;
    }

    public String getBuild_Mode_Materials() {
        build_Mode_Materials = properties.getProperty("BUILD_MATERIALS");
        return build_Mode_Materials;
    }

    public String getBuild_Mode_Materials_Modal() {
        build_Mode_Materials_Modal = properties.getProperty("BUILD_MATERIALS_MODAL");
        return build_Mode_Materials_Modal;
    }

    public String getBuild_Mode_Materials_Upload() {
        build_Mode_Materials_Upload = properties.getProperty("BUILD_MATERIALS_UPLOAD");
        return build_Mode_Materials_Upload;
    }

    public String getBuild_Mode_Materials_Modal_Close() {
        build_Mode_Materials_Modal_Close = properties.getProperty("BUILD_MATERIALS_MODAL_CLOSE");
        return build_Mode_Materials_Modal_Close;
    }

    public String getBuild_Mode_First_Uploaded_Material() {
        build_Mode_First_Uploaded_Material = properties.getProperty("BUILD_FIRST_UPLOADED_MATERIAL");
        return build_Mode_First_Uploaded_Material;
    }

    public String getBuild_Mode_Second_Uploaded_Material() {
        build_Mode_Second_Uploaded_Material = properties.getProperty("BUILD_SECOND_UPLOADED_MATERIAL");
        return build_Mode_Second_Uploaded_Material;
    }

    public String getBuild_Mode_Third_Uploaded_Material() {
        build_Mode_Third_Uploaded_Material = properties.getProperty("BUILD_THIRD_UPLOADED_MATERIAL");
        return build_Mode_Third_Uploaded_Material;
    }

    public String getBuild_Mode_Fourth_Uploaded_Material() {
        build_Mode_Fourth_Uploaded_Material = properties.getProperty("BUILD_FOURTH_UPLOADED_MATERIAL");
        return build_Mode_Fourth_Uploaded_Material;
    }

    public String getBuild_Mode_Done() {
        build_Mode_Done = properties.getProperty("BUILD_DONE");
        return build_Mode_Done;
    }

    public String getBuild_Mode_Publish() {
        build_Mode_Publish = properties.getProperty("BUILD_PUBLISH_MATERIALS");
        return build_Mode_Publish;
    }

    public String getBuild_Mode_Overview_Page() {
        build_Mode_Overview_Page = properties.getProperty("BUILD_OVERVIEW_PAGE");
        return build_Mode_Overview_Page;
    }

    public String getBuild_Mode_Overview_Page_View_Button() {
        build_Mode_Overview_Page_View_Button = properties.getProperty("BUILD_VIEW");
        return build_Mode_Overview_Page_View_Button;
    }

    public String getBuild_Mode_Navigation_Page_Header() {
        build_Mode_Navigation_Page_Header = properties.getProperty("BUILD_PAGE_HEADER");
        return build_Mode_Navigation_Page_Header;
    }

    public String getBuild_Mode_Assessment_Page() {
        build_Mode_Assessment_Page = properties.getProperty("BUILD_ASSESSMENT_PAGE_MATERIALS");
        return build_Mode_Assessment_Page;
    }

    public String getBuild_Mode_File_Upload() {
        build_Mode_File_Upload = properties.getProperty("BUILD_FILE_UPLOAD");
        return build_Mode_File_Upload;
    }

    public String getBuild_Mode_Deleted_Message_Close() {
        build_Mode_Deleted_Message_Close = properties.getProperty("BUILD_DELETED_MESSAGE_CLOSE");
        return build_Mode_Deleted_Message_Close;
    }

    public String getBuild_Mode_Custom_Materials() {
        build_Mode_Custom_Materials = properties.getProperty("BUILD_CUSTOM_MATERIALS");
        return build_Mode_Custom_Materials;
    }

    public String getBuild_Mode_settings() {
        build_Mode_settings = properties.getProperty("BUILD_SETTINGS");
        return build_Mode_settings;
    }

    public String getBuild_Mode_Delete_Assessment() {
        build_Mode_Delete_Assessment = properties.getProperty("BUILD_DELETE_ASSESSMENT");
        return build_Mode_Delete_Assessment;
    }

    public String getBuild_Mode_Understand_Checkbox() {
        build_Mode_Understand_Checkbox = properties.getProperty("BUILD_UNDERSTAND_CHECKBOX");
        return build_Mode_Understand_Checkbox;
    }

    public String getBuild_Mode_Agree_Checkbox() {
        build_Mode_Agree_Checkbox = properties.getProperty("BUILD_AGREE_CHECKBOX");
        return build_Mode_Agree_Checkbox;
    }

    public String getBuild_Mode_Delete_Submit_Button() {
        build_Mode_Delete_Submit_Button = properties.getProperty("BUILD_DELETE_SUBMIT_BUTTON");
        return build_Mode_Delete_Submit_Button;
    }

    public String getBuild_Mode_Verify_Delete_Message() {
        build_Mode_Verify_Delete_Message = properties.getProperty("BUILD_VERIFY_DELETE_MESSAGE");
        return build_Mode_Verify_Delete_Message;
    }

    public String getBuild_Mode_Title_Editable() {
        build_Mode_Title_Editable = properties.getProperty("BUILD_EDITABLE");
        return build_Mode_Title_Editable;
    }

    public String getAdvancedTab() {
        advancedTab = properties.getProperty("BUILD_ADVANCED_TAB");
        return advancedTab;
    }
}