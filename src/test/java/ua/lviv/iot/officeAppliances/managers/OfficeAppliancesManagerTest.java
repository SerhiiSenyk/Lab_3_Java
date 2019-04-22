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
import java.util.LinkedList;
import java.util.List;
import static junit.framework.Assert.*;
import org.junit.*;


import static ua.lviv.iot.officeAppliances.managers.SortType.*;
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
public class OfficeAppliancesManagerTest {
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

    @Test
    public void validateSettersAndGetters() {
        PojoClass officeAppliancesManagerPojo = PojoClassFactory.getPojoClass(OfficeAppliancesManager.class);
        PojoValidator pojoValidator = new PojoValidator(); 
        pojoValidator.addRule(new SetterMustExistRule());
        pojoValidator.addRule(new GetterMustExistRule());
        pojoValidator.addTester(new SetterTester());
        pojoValidator.addTester(new GetterTester());
        pojoValidator.runValidation(officeAppliancesManagerPojo);
    }

    /**
     * Test of findByColor method, of class OfficeAppliancesManager.
     */
    @Test
    public void testFindByColor() {
        Color color = new Color(128, 128, 128);
        List<OfficeAppliance> result = new LinkedList<>();
        OfficeAppliancesManager instance = new OfficeAppliancesManager(officeAppliances);
        result = instance.findByColor(color);
        result.forEach((officeAppliance) -> {
            assertTrue(officeAppliance.getColor().equals(color));
        });
       
    }

    /**
     * Test of sortByPrice method, of class OfficeAppliancesManager.
     */
    @Test
    public void testSortByPrice() {
        SortType sortType = ASCENDING;
        OfficeAppliancesManager instance = new OfficeAppliancesManager(officeAppliances);
        instance.sortByPrice(officeAppliances, sortType);
        for (int i = 0; i < officeAppliances.size() - 1; ++i) {
            assertTrue(officeAppliances.get(i).getPrice()
                    <= officeAppliances.get(i + 1).getPrice());
        }

        sortType = DESCENDING;
        instance.setOfficeAppliances(officeAppliances);
        instance.sortByPrice(officeAppliances, sortType);
        for (int i = 0; i < instance.getOfficeAppliances().size() - 1; ++i) {
            assertTrue(officeAppliances.get(i).getPrice()
                    >= officeAppliances.get(i + 1).getPrice());
        }

    }

    /**
     * Test of sortByWeight method, of class OfficeAppliancesManager.
     */
    @Test
    public void testSortByWeight() {
        SortType sortType = ASCENDING;
        OfficeAppliancesManager instance = new OfficeAppliancesManager(officeAppliances);
        instance.sortByWeight(officeAppliances, sortType);
        for (int i = 0; i < instance.getOfficeAppliances().size() - 1; ++i) {
            assertTrue(officeAppliances.get(i).getWeight()
                    <= officeAppliances.get(i + 1).getWeight());
        }
        sortType = DESCENDING;
        instance.setOfficeAppliances(officeAppliances);
        instance.sortByWeight(officeAppliances, sortType);
        for (int i = 0; i < instance.getOfficeAppliances().size() - 1; ++i) {
            assertTrue(officeAppliances.get(i).getWeight()
                    >= officeAppliances.get(i + 1).getWeight());
        }
    }

}
