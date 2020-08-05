package org.graphwalker;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/*****DataReader Class for Dna_ManualAssessment_QuickRoster*******/
public class DataReader {
    private String val;

    public String getData(String data) {

        Properties property = new Properties();
        InputStream input = null;

        try {
            String dir = System.getProperty("user.home");
            input = new FileInputStream(dir + "/data.properties");

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