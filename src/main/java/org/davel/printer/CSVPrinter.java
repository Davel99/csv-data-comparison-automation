package org.davel.printer;

import com.opencsv.CSVWriter;

import java.io.FileWriter;
import java.util.Map;

public class CSVPrinter {
    String outputFilename;
    public CSVPrinter(){
        this.outputFilename = "output.csv";
    }
    public CSVPrinter(String path){
        this.outputFilename = path;
    }
    public boolean printCSV(Map<Integer, String> data){
        try(CSVWriter writer = new CSVWriter(new FileWriter(this.outputFilename))){
            writer.writeNext(new String[]{"Transaction ID", "Status"});
            data.forEach((key,value)->{
                String k = String.valueOf(key);
                String v = String.valueOf(value);
                String[] record = new String[]{k,v};
                writer.writeNext(record);
            });
            System.out.println("CSV created successfully");
            return true;
        } catch (Exception e){
            System.out.println("Exception occured while writting csv. " + e.getMessage());
            return false;
        }

    }
}
