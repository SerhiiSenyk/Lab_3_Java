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
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotSame;
import static org.junit.Assert.assertTrue;
import org.junit.Test;

/**
 *
 * @author Serhii-PC
 */
public class ColorTest {

    @Test
    public void validateSettersAndGetters() {
        PojoClass colorPojo = PojoClassFactory.getPojoClass(Color.class);
        PojoValidator pojoValidator = new PojoValidator(); 
        pojoValidator.addRule(new SetterMustExistRule());
        pojoValidator.addRule(new GetterMustExistRule());
        pojoValidator.addTester(new SetterTester());
        pojoValidator.addTester(new GetterTester());
        pojoValidator.runValidation(colorPojo);
    }

    @Test
    public void testEquals() {
    Color obj1 = new Color(128,0,256);
    Color obj2 = new Color(128,0,256);
    assertNotSame(obj1,obj2);
    assertTrue(obj1.equals(obj2));
    obj2.setColor(0, 0, 0);
    assertFalse(obj2.equals(1));
    assertTrue(obj1.equals(obj1));
    obj1 = obj2;
    assertTrue(obj1.equals(obj2));
    obj1 = null;
    assertFalse(obj2.equals(obj1));
    assertFalse(obj2.equals(1));   
    }

    /**
     * Test of hashCode method, of class Color.
     */
    @Test
    public void testHashCode() {
        int red = 0;
        int green = 0;
        int blue = 0;
        Color obj1 = new Color(red,green,blue);
        Color obj2 = new Color(red,green,blue);
        assertNotSame(obj1,obj2);
        assertEquals(obj1.hashCode(),obj2.hashCode()); 
        obj1.setColor(0,1,0);
        assertNotSame(obj1,obj2);
        assertNotEquals(obj1.hashCode(),obj2.hashCode());
        obj1 = obj2;
        assertEquals(obj1.hashCode(),obj2.hashCode());
    }
}
