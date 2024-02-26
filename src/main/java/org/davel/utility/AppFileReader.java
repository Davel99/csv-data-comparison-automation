package org.davel.utility;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;

import java.io.IOException;
import java.util.Map;

public interface AppFileReader {
    Map<Integer, Double> read(CSVReader reader) throws CsvValidationException, IOException;
}
