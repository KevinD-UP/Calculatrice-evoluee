package Model.Fraction;

import Model.Double.OperatorDouble;
import org.junit.Test;

import static org.junit.Assert.*;

public class OperatorFractionTest {

    OperatorFraction plus      = OperatorFraction.PLUS;
    OperatorFraction moins     = OperatorFraction.MOINS;
    OperatorFraction multiplie = OperatorFraction.MULTIPLIE;
    OperatorFraction division  = OperatorFraction.DIVISION;

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
}