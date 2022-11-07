package com.shopforhome.ekart.service.impl;

import com.shopforhome.ekart.entities.Product;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.springframework.web.multipart.MultipartFile;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class CsvHelper {

    public static String TYPE = "text/csv";
    static String[] HEADERs = {"Name", "Price", "Category", "Description", "Quantity", "Rating", "Review"};

    public static boolean hasCSVFormat(MultipartFile file) {

        if (!TYPE.equals(file.getContentType())) {
            return false;
        }

        return true;
    }

    public static List<Product> csvToTutorials(InputStream is) {
        try (BufferedReader fileReader = new BufferedReader(new InputStreamReader(is, "UTF-8"));
             CSVParser csvParser = new CSVParser(fileReader,
                     CSVFormat.DEFAULT.withFirstRecordAsHeader().withIgnoreHeaderCase().withTrim());) {

            List<Product> products = new ArrayList<Product>();

            Iterable<CSVRecord> csvRecords = csvParser.getRecords();

            for (CSVRecord csvRecord : csvRecords) {
                Product product = new Product(
                        csvRecord.get("Category"),
                        csvRecord.get("Name"),
                        Float.parseFloat(csvRecord.get("Price")),
                        csvRecord.get("Description"),
                        Integer.parseInt(csvRecord.get("Quantity")),
                        Float.parseFloat(csvRecord.get("Rating")),
                        csvRecord.get("Review")
                );
                products.add(product);
            }

            return products;
        } catch (IOException e) {
            throw new RuntimeException("fail to parse CSV file: " + e.getMessage());
        }
    }
}
