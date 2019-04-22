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
public class BoardTest {

    @Test
    public void validateSettersAndGetters() {
        PojoClass boardPojo = PojoClassFactory.getPojoClass(Board.class);
        PojoValidator pojoValidator = new PojoValidator();
        pojoValidator.addRule(new SetterMustExistRule());
        pojoValidator.addRule(new GetterMustExistRule());
        pojoValidator.addTester(new SetterTester());
        pojoValidator.addTester(new GetterTester());
        pojoValidator.runValidation(boardPojo);
    }
    @Test 
    public void testToStringNotNull(){
        Board board = new Board("chalky", new Size(100.0, 80.0, 5.0),
                "aluminum", 250.0, new Color(0, 128, 128), 25.0, "Economix",
                Material.METAL);
        assertNotNull(board.toString());
    }
}