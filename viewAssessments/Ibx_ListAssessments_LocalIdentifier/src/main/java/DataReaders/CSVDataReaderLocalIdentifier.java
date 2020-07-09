package DataReaders;

import com.csvreader.CsvReader;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * CSV DataReader class
 **/

public class CSVDataReaderLocalIdentifier {

    String path = System.getProperty("user.dir");
    String CSVPath = path + "/src/main/resources/Assessments.csv";
    private String manualHybridAssessment, flexibleAssessment;

    public Map<String, String> getCsv() {

        Map<String, String> Maprecords = new HashMap<String, String>();
        try {
            CsvReader readercsv = new CsvReader(CSVPath);
            readercsv.readHeaders();

            while (readercsv.readRecord()) {
                manualHybridAssessment = readercsv.get("ManualHybridAssessment");
                flexibleAssessment = readercsv.get("FlexibleAssessment");


                Maprecords.put("ManualHybridAssessment", manualHybridAssessment);
                Maprecords.put("FlexibleAssessment", flexibleAssessment);

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


    public String getManualHybridAssessment() {
        manualHybridAssessment = getCsv().get("ManualHybridAssessment").trim();
        return manualHybridAssessment;
    }

    public String getFlexibleAssessment() {
        flexibleAssessment = getCsv().get("FlexibleAssessment").trim();
        return flexibleAssessment;
    }


}
