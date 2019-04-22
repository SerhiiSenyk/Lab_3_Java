/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ua.lviv.iot.officeAppliances.models;

import com.openpojo.reflection.PojoClass;
import com.openpojo.reflection.impl.PojoClassFactory;
import com.openpojo.validation.PojoValidator;
import com.openpojo.validation.rule.impl.GetterMustExistRule;
import com.openpojo.validation.rule.impl.SetterMustExistRule;
import com.openpojo.validation.test.impl.GetterTester;
import com.openpojo.validation.test.impl.SetterTester;
import static org.junit.Assert.assertNotNull;
import org.junit.Test;



/**
 *
 * @author Serhii-PC
 */
public class StationeryKnifeTest {
    @Test
    public void validateSettersAndGetters() {
        PojoClass stationeryKnifePojo = PojoClassFactory.getPojoClass(StationeryKnife.class);
        PojoValidator pojoValidator = new PojoValidator();
        pojoValidator.addRule(new SetterMustExistRule());
        pojoValidator.addRule(new GetterMustExistRule());
        pojoValidator.addTester(new SetterTester());
        pojoValidator.addTester(new GetterTester());
        pojoValidator.runValidation(stationeryKnifePojo);
    }
    @Test 
    public void testToStringNotNull(){
        StationeryKnife stationeryKnife = new StationeryKnife(2.0, 50.0,
                new Color(128, 128, 128), 0.2, "ABC", Material.METAL);
        assertNotNull( stationeryKnife.toString());
    }
}
