package Model.Double;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Classe de test de OperatorDouble
 */
public class OperatorDoubleTest {

    OperatorDouble plus      = OperatorDouble.PLUS;
    OperatorDouble moins     = OperatorDouble.MOINS;
    OperatorDouble multiplie = OperatorDouble.MULTIPLIE;
    OperatorDouble division  = OperatorDouble.DIVISION;
    OperatorDouble modulo    = OperatorDouble.MODULO;
    OperatorDouble puissance = OperatorDouble.PUISSANCE;

    /**
     * Test de la récupération de l'opérateur +
     */
    @Test
    public void getOperatorPlus() { assertEquals('+', (char) plus.getOperator()); }

    /**
     * Test de la récupération de l'opérateur -
     */
    @Test
    public void getOperatorMoins() { assertEquals('-', (char) moins.getOperator()); }

    /**
     * Test de la récupération de l'opérateur *
     */
    @Test
    public void getOperatorMultiplie() { assertEquals('*', (char) multiplie.getOperator()); }

    /**
     * Test de la récupération de l'opérateur /
     */
    @Test
    public void getOperatorDivision() { assertEquals('/', (char) division.getOperator()); }

    /**
     * Test de la récupération de l'opérateur %
     */
    @Test
    public void getOperatorModulo() {
        assertEquals('%', (char) modulo.getOperator());
    }

    /**
     * Test de la récupération de l'opérateur ^
     */
    @Test
    public void getOperatorPuissance() {
        assertEquals('^', (char) puissance.getOperator());
    }
}