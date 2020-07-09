package Utils;

import com.csvreader.CsvReader;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

//Utils class for DataReader
public class DataReader {
    private String val;
    private String showAssessmentsWithoutDataBackgroundColor;

    public String getData(String data) {

        Properties property = new Properties();
        InputStream input = null;

        try {
            String dir = System.getProperty("user.dir");

            dir = dir.replace("Ibx_ViewAssessments_ActionMenu", "");
            input = new FileInputStream(dir + "\\data.properties");

            //load the file
            property.load(input);

            //get the value of the data
            val = property.getProperty(data);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (input != null) {
                try {
                    input.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return val;
    }

    public Map<String, String> getCsv() {
        Map<String, String> Maprecords = new HashMap<String, String>();
        String path = System.getProperty("user.dir");
        String CSVPath = path + "/src/main/resources/ViewAssessmentsBlankStateData.csv";

        try {
            CsvReader readercsv = new CsvReader(CSVPath);
            readercsv.readHeaders();

            while (readercsv.readRecord()) {
                showAssessmentsWithoutDataBackgroundColor = readercsv.get("ShowAssessmentsWithoutDataBackgroundColor");

                Maprecords.put("ShowAssessmentsWithoutDataBackgroundColor", showAssessmentsWithoutDataBackgroundColor);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return Maprecords;
    }

    public String getShowAssessmentsWithoutDataBackgroundColor() {
        showAssessmentsWithoutDataBackgroundColor = getCsv().get("ShowAssessmentsWithoutDataBackgroundColor");
        return showAssessmentsWithoutDataBackgroundColor;
    }
}