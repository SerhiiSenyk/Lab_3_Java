/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ua.lviv.iot.officeAppliances.models;


 /*
 * @author Serhii-PC
 */

import com.openpojo.reflection.PojoClass;
import com.openpojo.reflection.impl.PojoClassFactory;
import com.openpojo.validation.PojoValidator;
import com.openpojo.validation.rule.impl.GetterMustExistRule;
import com.openpojo.validation.rule.impl.SetterMustExistRule;
import com.openpojo.validation.test.impl.GetterTester;
import com.openpojo.validation.test.impl.SetterTester;
import static org.junit.Assert.assertNotNull;
import org.junit.Test;


public class StaplerTest {
    @Test
    public void validateSettersAndGetters() {
        PojoClass staplerPojo = PojoClassFactory.getPojoClass(Stapler.class);
        PojoValidator pojoValidator = new PojoValidator();
        pojoValidator.addRule(new SetterMustExistRule());
        pojoValidator.addRule(new GetterMustExistRule());
        pojoValidator.addTester(new SetterTester());
        pojoValidator.addTester(new GetterTester());
        pojoValidator.runValidation(staplerPojo);
    }
    @Test 
    public void testToStringNotNull(){
        Stapler stapler = new Stapler(0.7, 2, 26.0, new Color(0, 0, 0), 100.0,
                "Buromax", Material.METAL_PLUS_PLASTIC);
        assertNotNull(stapler.toString());
    }
}
