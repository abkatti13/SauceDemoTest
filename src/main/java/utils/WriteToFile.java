package utils;


import pageObjects.ProductCatalogue;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class WriteToFile {
    public static void WriteToTextFile(String firstProductName, String firstProductPrice) {
        String data = "Data retrieved from UI";
        ProductCatalogue productCatalogue = new ProductCatalogue();
//        String firstProductName = ProductCatalogue.getFirstProductName();
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("resources/outputFile/output.txt"))) {
            writer.write("Productname: "+firstProductName);
            writer.write(", ");
            writer.write("Productprice: "+firstProductPrice);
            writer.newLine();
            System.out.println("Data has been written to the file.");
        } catch (IOException e) {
            System.err.println("An error occurred: " + e.getMessage());
        }
    }
    public static void writeMultipleLinesToFile(String filePath, List<String> data) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath, true))) {
            writer.write("====================Record================");
            for (String line : data) {
                writer.write(System.lineSeparator());
                writer.write(line);
                writer.write(System.lineSeparator());
            }
            System.out.println("Data has been written to the file.");
        } catch (IOException e) {
            System.err.println("An error occurred while writing to the file: " + e.getMessage());
        }
    }
}
