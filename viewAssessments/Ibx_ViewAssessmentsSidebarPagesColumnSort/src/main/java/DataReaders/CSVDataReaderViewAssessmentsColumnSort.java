package DataReaders;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import com.csvreader.CsvReader;

/**** CSV Reader for ViewAssessmentsSidebar ColumnSort *****/
public class CSVDataReaderViewAssessmentsColumnSort {
    String path = System.getProperty("user.dir");
    String CSVPath = path + "/src/main/resources/ViewAssessmentsSidebarColumnSort.csv";
    private String createdByMe, createdByOthers, assessmentToDeleteANDRestore, flexibleAssessmenttoCheckFavorite;
    private String flexibleAssessmenttoChangeAuthor, newAuthorName;

    public Map<String, String> getCsv() {

        Map<String, String> Maprecords = new HashMap<String, String>();
        try {
            CsvReader readercsv = new CsvReader(CSVPath);
            readercsv.readHeaders();

            while (readercsv.readRecord()) {
                createdByMe = readercsv.get("CreatedByMe");
                Maprecords.put("CreatedByMe", createdByMe);
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


}


//package DataReaders;
//
//import java.io.FileNotFoundException;
//import java.io.IOException;
//import java.util.HashMap;
//import java.util.Map;
//
//import com.csvreader.CsvReader;
//
///**** CSV Reader for ViewAssessmentsSidebarPagesColumnSort *****/
//public class CSVDataReaderViewAssessmentsColumnSort {
//    String path = System.getProperty("user.dir");
//    String CSVPath = path + "/src/main/resources/ViewAssessmentsSidebarPagesColumnSort.csv";
//    private String createdByMe, createdByOthers, assessmentToDeleteANDRestore;
//
//    public Map<String, String> getCsv() {
//
//        Map<String, String> Maprecords = new HashMap<String, String>();
//        try {
//            CsvReader readercsv = new CsvReader(CSVPath);
//            readercsv.readHeaders();
//
//            while (readercsv.readRecord()) {
//                createdByMe = readercsv.get("CreatedByMe");
//                createdByOthers = readercsv.get("v_UnpublishedItemBank");
//                assessmentToDeleteANDRestore = readercsv.get("AssessmentToDeleteANDRestore");
//
//                Maprecords.put("CreatedByMe", createdByMe);
//                Maprecords.put("v_UnpublishedItemBank", createdByOthers);
//                Maprecords.put("AssessmentToDeleteANDRestore", assessmentToDeleteANDRestore);
//            }
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        return Maprecords;
//    }
//
//    public String getCreatedBy() {
//        createdByMe = getCsv().get("CreatedByMe").trim();
//        return createdByMe;
//    }
//
//    public String getCsvDraftItemBank() {
//        createdByOthers = getCsv().get("v_UnpublishedItemBank").trim();
//        return createdByOthers;
//    }
//
//    public String getAssessmentToDeleteANDRestore() {
//        assessmentToDeleteANDRestore = getCsv().get("AssessmentToDeleteANDRestore").trim();
//        return assessmentToDeleteANDRestore;
//    }
//}
