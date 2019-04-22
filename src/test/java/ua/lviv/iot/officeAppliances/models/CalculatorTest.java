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
public class CalculatorTest {
    @Test
    public void validateSettersAndGetters() {
        PojoClass calculatorPojo = PojoClassFactory.getPojoClass(Calculator.class);
        PojoValidator pojoValidator = new PojoValidator();
        pojoValidator.addRule(new SetterMustExistRule());
        pojoValidator.addRule(new GetterMustExistRule()); 
        pojoValidator.addTester(new SetterTester());
        pojoValidator.addTester(new GetterTester());
        pojoValidator.runValidation(calculatorPojo);
    }
    @Test 
    public void testToStringNotNull(){
        Calculator calculator = new Calculator("engineering", 64,
                new Size(15.2, 5.0, 0.5), 35.0, new Color(128, 128, 128), 0.1,
                "Company", Material.PLASTIC);
        assertNotNull(calculator.toString());
    }
}
