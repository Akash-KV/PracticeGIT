package Pom;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * Page object model class for BuildModePage
 **/

public class BuildModePage {


    private String build_Item_Section, showMore, detailedInformation, depthAboutItem, browseBuildToggle, closeSearch, searchTextBox;
    private String addItem, showMoreForBoth, detailedInformationForBoth, mediaTypeForBoth, navigateToBuild, searchItem, webAndPaper;

    String dir = null;
    Properties properties = new Properties();
    InputStream input = null;
    private static String os = null;

    public BuildModePage() {
        try {
            dir = System.getProperty("user.dir");
            dir = dir.replace("Ibx_BuildMode_WebAndPaperIcon", "");
            System.out.println("dir: " + dir);
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
     * Method to read data from property file
     **/

    public String getBuild_Item_Section() {
        build_Item_Section = properties.getProperty("BUILD_ITEM_SECTION");
        return build_Item_Section;
    }

    public String getShowMore() {
        showMore = properties.getProperty("BUILD_SHOW_MORE");
        return showMore;
    }

    public String getDetailedInformation() {
        detailedInformation = properties.getProperty("BUILD_DETAILED_INFORMATION");
        return detailedInformation;
    }

    public String getDepthAboutItem() {
        depthAboutItem = properties.getProperty("BUILD_DEPTH_ABOUT_ITEM");
        return depthAboutItem;
    }

    public String getBrowseBuildToggle() {
        browseBuildToggle = properties.getProperty("BUILD_BROWSE_TOGGLE_BUTTON");
        return browseBuildToggle;
    }

    public String getCloseSearch() {
        closeSearch = properties.getProperty("BUILD_CLOSE_SEARCH");
        return closeSearch;
    }

    public String getSearchTextBox() {
        searchTextBox = properties.getProperty("BUILD_SEARCH_TEXT_BOX");
        return searchTextBox;
    }

    public String getSearchItem() {
        searchItem = properties.getProperty("BUILD_SEARCH_ITEM");
        return searchItem;
    }

    public String getWebAndPaper() {
        webAndPaper = properties.getProperty("BUILD_WEB_AND_PAPER");
        return webAndPaper;
    }

    public String getAddItem() {
        addItem = properties.getProperty("BUILD_ADD_ITEM");
        return addItem;
    }

    public String getShowMoreForBoth() {
        showMoreForBoth = properties.getProperty("BUILD_SHOW_MORE_FOR_BOTH");
        return showMoreForBoth;
    }

    public String getDetailedInformationForBoth() {
        detailedInformationForBoth = properties.getProperty("BUILD_DETAILED_INFORMATION");
        return detailedInformationForBoth;
    }

    public String getMediaTypeForBoth() {
        mediaTypeForBoth = properties.getProperty("BUILD_MEDIA_TYPE_FOR_BOTH");
        return mediaTypeForBoth;
    }

    public String getNavigateToBuild() {
        navigateToBuild = properties.getProperty("BUILD_NAVIGATE_TO_BUILD");
        return navigateToBuild;
    }
}


