package Model.Boolean;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Classe de test de OperatorBoolean
 */
public class OperatorBooleanTest {

    OperatorBoolean not = OperatorBoolean.NOT;
    OperatorBoolean et = OperatorBoolean.ET;
    OperatorBoolean ou = OperatorBoolean.OU;

    /**
     * Test la récupération de l'opérateur NOT
     */
    @Test
    public void getOperatorNot() { assertEquals("NOT", not.getOperator()); }

    /**
     * Test la récupération de l'opérateur ET
     */
    @Test
    public void getOperatorEt() {
        assertEquals("ET", et.getOperator());
    }

    /**
     * Test la récupération de l'opérateur OU
     */
    @Test
    public void getOperatorOu() {
        assertEquals("OU", ou.getOperator());
    }
}