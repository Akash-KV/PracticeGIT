package DataReaders;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import com.csvreader.CsvReader;

/**
 * CSV Reader for BuildItemTags
 **/
public class CSVDataReaderBuildItemTags {
    String path = System.getProperty("user.dir");
    String CSVPath = path + "/src/main/resources/BuildModeTags.csv";
    private String assessmentName;
    private String assessmentYear, subject, gradeLevels, firstDateAdministered;

    public Map<String, String> getCsv() {

        Map<String, String> Maprecords = new HashMap<String, String>();
        try {
            CsvReader readercsv = new CsvReader(CSVPath);
            readercsv.readHeaders();

            while (readercsv.readRecord()) {
                assessmentName = readercsv.get("AssessmentName");
                assessmentYear = readercsv.get("AssessmentYear");
                subject = readercsv.get("Subject");
                gradeLevels = readercsv.get("GradeLevels");
                firstDateAdministered = readercsv.get("FirstDateAdministered");

                Maprecords.put("AssessmentName", assessmentName);
                Maprecords.put("AssessmentYear", assessmentYear);
                Maprecords.put("Subject", subject);
                Maprecords.put("GradeLevels", gradeLevels);
                Maprecords.put("FirstDateAdministered", firstDateAdministered);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return Maprecords;
    }

    /**
     * Methods to read CSV Data
     **/

    public String getAssessmentName() {
        assessmentName = getCsv().get("AssessmentName").trim();
        return assessmentName;
    }

    public String getAssessmentYear() {
        assessmentYear = getCsv().get("AssessmentYear").trim();
        return assessmentYear;
    }

    public String getSubject() {
        subject = getCsv().get("Subject").trim();
        return subject;
    }

    public String getGradeLevels() {
        gradeLevels = getCsv().get("GradeLevels").trim();
        return gradeLevels;
    }

    public String getFirstDateAdministered() {
        firstDateAdministered = getCsv().get("FirstDateAdministered").trim();
        return firstDateAdministered;
    }
}
