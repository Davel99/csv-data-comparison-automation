package org.davel;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;
import org.davel.comparatorApp.ComparatorApp;
import org.davel.printer.CSVPrinter;
import org.davel.utility.AppFileReader;
import org.davel.utility.AppFileReaderImpl;

import java.io.FileReader;
import java.io.IOException;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        String filenameOne = "file1.csv";
        String filenameTwo = "file2.csv";
        try (
                CSVReader csvOne = new CSVReader(new FileReader(filenameOne));
                CSVReader csvTwo = new CSVReader(new FileReader(filenameTwo))
        ){
            start(csvOne, csvTwo);
        } catch (Exception e){
            System.out.println("Couldn't read the csv file");
            System.out.println(e.getMessage());

        }

    }

    public static void start(CSVReader csvOne, CSVReader csvTwo) throws CsvValidationException, IOException {
        ComparatorApp app = new ComparatorApp();
        AppFileReader loader = new AppFileReaderImpl();
        app.setOriginalValues(loader.read(csvOne));
        app.setCopyValues(loader.read(csvTwo));

        app.compare();

        Map<Integer, String> comparison = app.getComparison();

        CSVPrinter printer = new CSVPrinter();
        printer.printCSV(comparison);
    }
}