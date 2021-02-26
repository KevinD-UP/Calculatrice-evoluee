package Model.Fraction;

import Model.Double.DoubleStack;
import com.github.kiprobinson.bigfraction.BigFraction;
import org.junit.Test;

import static org.junit.Assert.*;

public class FractionStackTest {

    private final FractionStack stack = FractionStack.generate();

    /**
     * Test de l'opération +
     */
    @Test
    public void doOperationPlus() {
        stack.push(BigFraction.valueOf("1/2"));
        stack.push(BigFraction.valueOf("1/2"));
        assertEquals(BigFraction.valueOf("1/1"), stack.doOperation("+"));
        stack.push(BigFraction.valueOf("1/4"));
        stack.push(BigFraction.valueOf("1/2"));
        assertEquals(BigFraction.valueOf("3/4"), stack.doOperation("+"));
    }

    /**
     * Test de l'opération -
     */
    @Test
    public void doOperationMoins(){
        stack.push(BigFraction.valueOf("2/2"));
        stack.push(BigFraction.valueOf("1/2"));
        assertEquals(BigFraction.valueOf("1/2"), stack.doOperation("-"));
    }

    /**
     * Test de l'opération *
     */
    @Test
    public void doOperationFois(){
        stack.push(BigFraction.valueOf("1/2"));
        stack.push(BigFraction.valueOf("1/2"));
        assertEquals(BigFraction.valueOf("1/4"), stack.doOperation("*"));
        stack.push(BigFraction.valueOf("1/4"));
        stack.push(BigFraction.valueOf("1/2"));
        assertEquals(BigFraction.valueOf("1/8"), stack.doOperation("*"));
        stack.push(BigFraction.valueOf("2/4"));
        stack.push(BigFraction.valueOf("1/2"));
        assertEquals(BigFraction.valueOf("1/4"), stack.doOperation("*"));
    }

    /**
     * Test de l'opération /
     */
    @Test
    public void doOperationDivision(){
        stack.push(BigFraction.valueOf("4/5"));
        stack.push(BigFraction.valueOf("6/7"));
        assertEquals(BigFraction.valueOf("28/30"), stack.doOperation("/"));
        stack.push(BigFraction.valueOf("3/2"));
        stack.push(BigFraction.valueOf("8/3"));
        assertEquals(BigFraction.valueOf("9/16"), stack.doOperation("/"));
    }

    /**
     * Test la reconnaissance de l'opérateur +
     */
    @Test
    public void isOperatorPlus() {
        assertTrue("Opérateur + non reconnu", stack.isOperator("+"));
    }

    /**
     * Test la reconnaissance de l'opérateur -
     */
    @Test
    public void isOperatorMoins(){
        assertTrue("Opérateur - non reconnu", stack.isOperator("-"));
    }

    /**
     * Test la reconnaissance de l'opérateur *
     */
    @Test
    public void isOperatorFois(){
        assertTrue("Opérateur * non reconnu", stack.isOperator("*"));
    }

    /**
     * Test la reconnaissance de l'opérateur /
     */
    @Test
    public void isOperatorDivision(){
        assertTrue("Opérateur / non reconnu", stack.isOperator("/"));
    }
}