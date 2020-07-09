package DataReaders;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import com.csvreader.CsvReader;

/**** CSV Reader for View Assessment Sidebar *****/
public class CSVDataReaderViewAssessmentsSidebar {
    String path = System.getProperty("user.dir");
    String CSVPath = path + "/src/main/resources/ViewAssessmentsSidebar.csv";
    private String createdByMe, createdByOthers, assessmentToDeleteANDRestore, flexibleAssessmenttoCheckFavorite;
    private String flexibleAssessmenttoChangeAuthor, newAuthorName;

    public Map<String, String> getCsv() {

        Map<String, String> Maprecords = new HashMap<String, String>();
        try {
            CsvReader readercsv = new CsvReader(CSVPath);
            readercsv.readHeaders();

            while (readercsv.readRecord()) {
                createdByMe = readercsv.get("CreatedByMe");
                createdByOthers = readercsv.get("CreatedByOthers");
                assessmentToDeleteANDRestore = readercsv.get("AssessmentToDeleteANDRestore");
                assessmentToDeleteANDRestore = readercsv.get("FlexibleAssessmenttoCheckFavorite");
                flexibleAssessmenttoChangeAuthor = readercsv.get("FlexibleAssessmenttoChangeAuthor");
                newAuthorName = readercsv.get("NewAuthorName");

                Maprecords.put("CreatedByMe", createdByMe);
                Maprecords.put("CreatedByOthers", createdByOthers);
                Maprecords.put("AssessmentToDeleteANDRestore", assessmentToDeleteANDRestore);
                Maprecords.put("FlexibleAssessmenttoCheckFavorite", assessmentToDeleteANDRestore);
                Maprecords.put("FlexibleAssessmenttoChangeAuthor", flexibleAssessmenttoChangeAuthor);
                Maprecords.put("NewAuthorName", newAuthorName);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return Maprecords;
    }

    public String getCreatedBy() {
        createdByMe = getCsv().get("CreatedByMe").trim();
        return createdByMe;
    }

    public String getCreatedByOthers() {
        createdByOthers = getCsv().get("CreatedByOthers").trim();
        return createdByOthers;
    }

    public String getAssessmentToDeleteANDRestore() {
        assessmentToDeleteANDRestore = getCsv().get("AssessmentToDeleteANDRestore");
        return assessmentToDeleteANDRestore;
    }

    public String getFlexibleAssessmenttoCheckFavorite() {
        flexibleAssessmenttoCheckFavorite = getCsv().get("FlexibleAssessmenttoCheckFavorite");
        return flexibleAssessmenttoCheckFavorite;
    }

    public String getFlexibleAssessmenttoChangeAuthor() {
        flexibleAssessmenttoChangeAuthor = getCsv().get("FlexibleAssessmenttoChangeAuthor");
        return flexibleAssessmenttoChangeAuthor;
    }

    public String getNewAuthorName() {
        newAuthorName = getCsv().get("NewAuthorName");
        return newAuthorName;
    }
}
