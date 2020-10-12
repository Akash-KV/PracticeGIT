package Utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * Utils class for DataReader
 **/
public class DataReader {
    private String val;

    public String getData(String data) {

        Properties property = new Properties();
        InputStream input = null;

        try {
            String dir = System.getProperty("user.dir");
            dir = dir.replace("Ibx_BuildMode_Standards", "");
            input = new FileInputStream(dir + "config.properties");

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
}