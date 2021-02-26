package Model.Double;

import Model.Double.DoubleStack;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Classe de test de DoubleStack
 */
public class DoubleStackTest {

    private final DoubleStack stack = DoubleStack.generate();

    /**
     * Test de l'opération +
     */
    @Test
    public void doOperationPlus() {
        stack.push(5.0);
        stack.push(6.0);
        assertEquals(5.0+6.0, stack.doOperation("+"), 0.0);
    }

    /**
     * Test de l'opération -
     */
    @Test
    public void doOperationMoins(){
        stack.push(18.0);
        stack.push(11.0);
        assertEquals(18.0-11.0, stack.doOperation("-"), 0.0);
    }

    /**
     * Test de l'opération *
     */
    @Test
    public void doOperationFois(){
        stack.push(9.0);
        stack.push(8.0);
        assertEquals(9.0*8.0, stack.doOperation("*"), 0.0);
    }

    /**
     * Test de l'opération /
     */
    @Test
    public void doOperationDivision(){
        stack.push(32.0);
        stack.push(4.0);
        assertEquals(32.0/4.0, stack.doOperation("/"), 0.0);
    }

    /**
     * Test de l'opération %
     */
    @Test
    public void doOperationModulo(){
        stack.push(50.0);
        stack.push(5.0);
        assertEquals(50.0%5.0, stack.doOperation("%"), 0.0);
    }

    /**
     * Test de l'opération ^
     */
    @Test
    public void doOperationPuissance(){
        stack.push(9.0);
        stack.push(2.0);
        assertEquals(Math.pow(9.0, 2.0), stack.doOperation("^"), 0.0);
    }

    /**
     * Test la reconnaissance de l'opérateur +
     */
    @Test
    public void isOperatorPlus() {
        assertTrue("Opérateur + non reconnu",stack.isOperator("+"));
    }

    /**
     * Test la reconnaissance de l'opérateur -
     */
    @Test
    public void isOperatorMoins(){
        assertTrue("Opérateur - non reconnu",stack.isOperator("-"));
    }

    /**
     * Test la reconnaissance de l'opérateur *
     */
    @Test
    public void isOperatorFois(){
        assertTrue("Opérateur * non reconnu",stack.isOperator("*"));
    }

    /**
     * Test la reconnaissance de l'opérateur /
     */
    @Test
    public void isOperatorDivision(){
        assertTrue("Opérateur / non reconnu",stack.isOperator("/"));
    }

    /**
     * Test la reconnaissance de l'opérateur %
     */
    @Test
    public void isOperatorModulo(){
        assertTrue("Opérateur % non reconnu",stack.isOperator("%"));
    }

    /**
     * Test la reconnaissance de l'opérateur ^
     */
    @Test
    public void isOperatorPuissance(){
        assertTrue("Opérateur ^ non reconnu",stack.isOperator("^"));
    }

    /**
     * Test de la conversion de la chaîne entré en Double
     */
    @Test
    public void getValue() {
        Double test = stack.getValue("100");
        Double compare = 100.0;
        assertEquals(test, compare);
    }

}
