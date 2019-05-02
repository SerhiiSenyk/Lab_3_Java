/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ua.lviv.iot.officeAppliances.managers;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.List;
import ua.lviv.iot.officeAppliances.models.OfficeAppliance;

/**
 *
 * @author Serhii-PC
 */
public class WriteToCSVFileManager {

    private String fileName;
    private String coding;
    private boolean append;

    public WriteToCSVFileManager(String fileName, String coding, boolean append) {
        this.fileName = fileName;
        this.append = append;
        this.coding = coding;
    }

    private WriteToCSVFileManager() {
    }

    public void writeToFile(List<OfficeAppliance> officeAppliances) {
        File csvFile = null;
        try {
            csvFile = new File(fileName + ".csv");
            if (!csvFile.exists()){
                boolean bool = csvFile.createNewFile();
           }
        } catch (IOException exception) {
            System.out.println("Error : " + exception.getMessage());
        }
        try (OutputStreamWriter writer = new OutputStreamWriter(new FileOutputStream(csvFile, append), coding)) {
            for (OfficeAppliance officeAppliance : officeAppliances) {
                writer.write(officeAppliance.getHeaders() + "\n");
                writer.write(officeAppliance.toCSV() + "\n");
            }
        } catch (IOException exception) {
            System.out.println("Error : " + exception.getMessage());
        } finally {
            System.out.println("Done");
        }
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public boolean isAppend() {
        return append;
    }

    public void setAppend(boolean append) {
        this.append = append;
    }

    public String getCoding() {
        return coding;
    }

    public void setCoding(String coding) {
        this.coding = coding;
    }

}