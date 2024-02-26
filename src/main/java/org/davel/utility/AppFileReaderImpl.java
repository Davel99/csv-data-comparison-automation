package org.davel.utility;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class AppFileReaderImpl implements AppFileReader {
    @Override
    public Map<Integer, Double> read(CSVReader reader) throws CsvValidationException, IOException {
        Map<Integer, Double> data = new HashMap<>();
        String[] record;
        reader.readNext(); //Getting rid of headers
        while( (record = reader.readNext()) != null ){
            Integer id = Integer.parseInt(record[0]);
            Double amount = Double.parseDouble((record[1]));
            data.put(id, amount);
        }
        return data;
    }
}
