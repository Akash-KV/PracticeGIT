package DataReaders;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import com.csvreader.CsvReader;

/**** CSV Reader for ViewAssessmentsFilters *****/
public class CSVDataReaderViewAssessmentsFilter {
    String path = System.getProperty("user.dir");
    String CSVPath = path + "/src/main/resources/ViewAssessmentsFilters.csv";
    private String createdByMe, previousYear, currentYear, followingYear, gradeFilter, scopeFilter, subjectFilter;
    private String beforeCurrentDate, currentDate, afterCurrentDate, sidebarLinkToClick;

    public Map<String, String> getCsv() {

        Map<String, String> Maprecords = new HashMap<String, String>();
        try {
            CsvReader readercsv = new CsvReader(CSVPath);
            readercsv.readHeaders();

            while (readercsv.readRecord()) {
                createdByMe = readercsv.get("CreatedByMe");
                previousYear = readercsv.get("PreviousYear");
                currentYear = readercsv.get("CurrentYear");
                followingYear = readercsv.get("FollowingYear");
                gradeFilter = readercsv.get("GradeFilter");
                scopeFilter = readercsv.get("ScopeFilter");
                subjectFilter = readercsv.get("SubjectFilter");
                beforeCurrentDate = readercsv.get("BeforeCurrentDate");
                currentDate = readercsv.get("CurrentDate");
                afterCurrentDate = readercsv.get("AfterCurrentDate");
                sidebarLinkToClick = readercsv.get("SidebarLinkToClick");

                Maprecords.put("CreatedByMe", createdByMe);
                Maprecords.put("PreviousYear", previousYear);
                Maprecords.put("CurrentYear", currentYear);
                Maprecords.put("FollowingYear", followingYear);
                Maprecords.put("GradeFilter", gradeFilter);
                Maprecords.put("ScopeFilter", scopeFilter);
                Maprecords.put("SubjectFilter", subjectFilter);
                Maprecords.put("BeforeCurrentDate", beforeCurrentDate);
                Maprecords.put("CurrentDate", currentDate);
                Maprecords.put("AfterCurrentDate", afterCurrentDate);
                Maprecords.put("SidebarLinkToClick", sidebarLinkToClick);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return Maprecords;
    }

    /**
     * Methods to read Csv Data
     **/

    public String getCreatedBy() {
        createdByMe = getCsv().get("CreatedByMe").trim();
        return createdByMe;
    }

    public String getPreviousYear() {
        previousYear = getCsv().get("PreviousYear").trim();
        return previousYear;
    }

    public String getCurrentYear() {
        currentYear = getCsv().get("CurrentYear").trim();
        return currentYear;
    }

    public String getFollowingYear() {
        followingYear = getCsv().get("FollowingYear").trim();
        return followingYear;
    }

    public String getGradeFilter() {
        gradeFilter = getCsv().get("GradeFilter").trim();
        return gradeFilter;
    }

    public String getScopeFilter() {
        scopeFilter = getCsv().get("ScopeFilter").trim();
        return scopeFilter;
    }

    public String getSubjectFilter() {
        subjectFilter = getCsv().get("SubjectFilter").trim();
        return subjectFilter;
    }

    public String getBeforeCurrentDate() {
        beforeCurrentDate = getCsv().get("BeforeCurrentDate").trim();
        return beforeCurrentDate;
    }

    public String getCurrentDate() {
        currentDate = getCsv().get("CurrentDate").trim();
        return currentDate;
    }

    public String getAfterCurrentDate() {
        afterCurrentDate = getCsv().get("AfterCurrentDate").trim();
        return afterCurrentDate;
    }

    public String getSidebarLinkToClick() {
        sidebarLinkToClick = getCsv().get("SidebarLinkToClick").trim();
        return sidebarLinkToClick;
    }
}
