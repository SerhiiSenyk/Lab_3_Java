/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ua.lviv.iot.officeAppliances.managers;

import com.openpojo.reflection.PojoClass;
import com.openpojo.reflection.impl.PojoClassFactory;
import com.openpojo.validation.PojoValidator;
import com.openpojo.validation.rule.impl.GetterMustExistRule;
import com.openpojo.validation.rule.impl.SetterMustExistRule;
import com.openpojo.validation.test.impl.GetterTester;
import com.openpojo.validation.test.impl.SetterTester;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import ua.lviv.iot.officeAppliances.models.Board;
import ua.lviv.iot.officeAppliances.models.Calculator;
import ua.lviv.iot.officeAppliances.models.Color;
import ua.lviv.iot.officeAppliances.models.Material;
import ua.lviv.iot.officeAppliances.models.OfficeAppliance;
import ua.lviv.iot.officeAppliances.models.Size;
import ua.lviv.iot.officeAppliances.models.Stapler;
import ua.lviv.iot.officeAppliances.models.StationeryKnife;

/**
 *
 * @author Serhii-PC
 */
public class WriteToCSVFileManagerTest {
    List<OfficeAppliance> officeAppliances = new LinkedList<>();
    Board board = new Board("chalky", new Size(100.0, 80.0, 5.0),
            "aluminum", 250.0, new Color(0, 128, 128), 25.0, "Economix",
            Material.METAL);

    Stapler stapler = new Stapler(0.7, 2, 26.0, new Color(0, 0, 0), 100.0,
            "Buromax", Material.METAL_PLUS_PLASTIC);

    StationeryKnife stationeryKnife = new StationeryKnife(2.0, 50.0,
            new Color(128, 128, 128), 0.2, "ABC", Material.METAL);

    Calculator calculator = new Calculator("engineering", 64,
            new Size(15.2, 5.0, 0.5), 35.0, new Color(128, 128, 128), 0.1,
            "Company", Material.PLASTIC);

    public WriteToCSVFileManagerTest() {
    }

    @Before
    public void setUp() {
        officeAppliances.add(board);
        officeAppliances.add(stapler);
        officeAppliances.add(stationeryKnife);
        officeAppliances.add(calculator);
    }

    @After
    public void tearDown() {
        officeAppliances.clear();
    }

    /**
     * Test of writeToFile method, of class WriteToCSVFileManager.
     */
    @Test
    public void testWriteToFile() {
        String csvFile = "testFile";
        String coding = "UTF-8";
        WriteToCSVFileManager writer = new WriteToCSVFileManager(csvFile,coding, false);
        writer.writeToFile(officeAppliances);
        try (FileInputStream fstream = new FileInputStream(csvFile + ".csv");
               InputStreamReader reader =  new InputStreamReader(fstream,coding);
                BufferedReader buffer = new BufferedReader(reader)) {
            for (OfficeAppliance officeAppliance : officeAppliances) {
                assertEquals(buffer.readLine(), officeAppliance.getHeaders());
                assertEquals(buffer.readLine(), officeAppliance.toCSV());
            }
            assertNull(buffer.readLine());
        } catch (IOException exception) {
            System.out.println("Error : " + exception.getMessage());
        } finally {
            System.out.println("Done");
        }
    }

    @Test
    public void validateSettersAndGetters() {
        PojoClass writeToCSVFileManagerPojo = PojoClassFactory.getPojoClass(WriteToCSVFileManager.class);
        PojoValidator pojoValidator = new PojoValidator();
        pojoValidator.addRule(new SetterMustExistRule());
        pojoValidator.addRule(new GetterMustExistRule());
        pojoValidator.addTester(new SetterTester());
        pojoValidator.addTester(new GetterTester());
        pojoValidator.runValidation(writeToCSVFileManagerPojo);
    }
}
