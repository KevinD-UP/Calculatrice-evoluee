package Model.Boolean;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Classe de test de BooleanStack
 */
public class BooleanStackTest {

    private final BooleanStack stack = BooleanStack.generate();

    /**
     * Test l'opération ET de booléen
     */
    @Test
    public void doOperationEt() {
        stack.push(Boolean.generate("VRAI"));
        stack.push(Boolean.generate("VRAI"));
        assertEquals("VRAI", stack.doOperation("ET").getValue());
        stack.push(Boolean.generate("FAUX"));
        stack.push(Boolean.generate("VRAI"));
        assertEquals("FAUX", stack.doOperation("ET").getValue());
        stack.push(Boolean.generate("FAUX"));
        stack.push(Boolean.generate("FAUX"));
        assertEquals("FAUX", stack.doOperation("ET").getValue());
    }

    /**
     * Test l'opération OU de booléen
     */
    @Test
    public void doOperationOu() {
        stack.push(Boolean.generate("VRAI"));
        stack.push(Boolean.generate("VRAI"));
        assertEquals("VRAI", stack.doOperation("OU").getValue());
        stack.push(Boolean.generate("FAUX"));
        stack.push(Boolean.generate("VRAI"));
        assertEquals("VRAI", stack.doOperation("OU").getValue());
        stack.push(Boolean.generate("FAUX"));
        stack.push(Boolean.generate("FAUX"));
        assertEquals("FAUX", stack.doOperation("OU").getValue());
    }

    /**
     * Test l'opération NOT de booléen
     */
    @Test
    public void doOperationNot() {
        stack.push(Boolean.generate("VRAI"));
        assertEquals("FAUX", stack.doOperation("NOT").getValue());
        stack.push(Boolean.generate("FAUX"));
        assertEquals("VRAI", stack.doOperation("NOT").getValue());
    }

    /**
     * Reconnaît l'opérateur ET
     */
    @Test
    public void isOperatorEt() {
        assertTrue(stack.isOperator("ET"));
    }

    /**
     * Reconnaît l'opérateur OU
     */
    @Test
    public void isOperatorOu() {
        assertTrue(stack.isOperator("OU"));
    }

    /**
     * Reconnaît l'opérateur NOT
     */
    @Test
    public void isOperatorNot() {
        assertTrue(stack.isOperator("NOT"));
    }

    /**
     * Vérifie la conversion de la chaîne entré en bon type VRAI
     */
    @Test
    public void getValueVrai() {
        Boolean test = stack.getValue("VRAI");
        Boolean compare = Boolean.generate("VRAI");
        assertEquals(test.getValue(), compare.getValue());
    }

    /**
     * Vérifie la conversion de la chaîne entré en bon type FAUX
     */
    @Test
    public void getValueFaux() {
        Boolean test = stack.getValue("FAUX");
        Boolean compare = Boolean.generate("FAUX");
        assertEquals(test.getValue(), compare.getValue());
    }

    /**
     * Vérifie la conversion de la chaîne entré en bon type ERROR
     */
    @Test
    public void getValueError() {
        Boolean test = stack.getValue("EZLKjkbkjkKBKBKB515ZEF56D6Z1A65DZ65A");
        Boolean compare = Boolean.generate("ERROR");
        assertEquals(test.getValue(), compare.getValue());
    }
}