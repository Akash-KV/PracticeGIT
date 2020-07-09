package Utils;

import com.csvreader.CsvReader;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


//Data Reader to read values from CSV for LaunchpadData
public class DataReaderViewAssessmentsSearch {

    String path = System.getProperty("user.dir");
    String CSVPath = path + "/src/main/resources/ViewAssessmentsSharetoOthers.csv";


    private String assessmentnametosharewithoutdata;
    private String sharewithSelection, siteSelection;

    public Map<String, String> getCsv() {
        Map<String, String> Maprecords = new HashMap<String, String>();
        try {
            CsvReader readercsv = new CsvReader(CSVPath);
            readercsv.readHeaders();

            while (readercsv.readRecord()) {


                assessmentnametosharewithoutdata = readercsv.get("Assessmentnametosharewithoutdata");
                sharewithSelection = readercsv.get("SharewithSelection");
                siteSelection = readercsv.get("SiteSelection");


                Maprecords.put("Assessmentnametosharewithoutdata", assessmentnametosharewithoutdata);
                Maprecords.put("SharewithSelection", sharewithSelection);
                Maprecords.put("SiteSelection", siteSelection);


            }
            readercsv.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return Maprecords;
    }

    /**
     * methods to read from CSv file
     **/

    public String getAssessmentnametosharewithoutdata() {
        assessmentnametosharewithoutdata = getCsv().get("Assessmentnametosharewithoutdata");
        return assessmentnametosharewithoutdata;
    }

    public String getSharewithSelection() {
        sharewithSelection = getCsv().get("SharewithSelection");
        return sharewithSelection;
    }

    public String getSiteSelection() {
        siteSelection = getCsv().get("SiteSelection");
        return siteSelection;
    }
}
