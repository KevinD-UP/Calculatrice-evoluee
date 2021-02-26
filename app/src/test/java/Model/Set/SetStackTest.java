package Model.Set;

import org.junit.Test;

import java.util.HashSet;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.Assert.*;

/**
 * Classe de test de SetStack
 */
public class SetStackTest {

    private final SetStack stack = SetStack.generate();

    /**
     * Test de l'opération d'union des ensembles
     */
    @Test
    public void doOperationUnion() {
        stack.push(Stream.of(1.0, 2.0, 3.0).collect(Collectors.toCollection(HashSet::new)));
        stack.push(Stream.of(3.0, 4.0, 5.0).collect(Collectors.toCollection(HashSet::new)));
        HashSet<Double> test = Stream.of(1.0, 2.0, 3.0, 4.0, 5.0).collect(Collectors.toCollection(HashSet::new));
        assertEquals(test, stack.doOperation("UNION"));
    }

    /**
     * Test de l'opération d'intersection des ensembles
     */
    @Test
    public void doOperationInter() {
        stack.push(Stream.of(1.0, 2.0, 3.0).collect(Collectors.toCollection(HashSet::new)));
        stack.push(Stream.of(3.0, 4.0, 5.0).collect(Collectors.toCollection(HashSet::new)));
        HashSet<Double> test = Stream.of(3.0).collect(Collectors.toCollection(HashSet::new));
        assertEquals(test, stack.doOperation("INTER"));
    }

    /**
     * Test de l'opération de complémentaire des ensembles
     */
    @Test
    public void doOperationDiff() {
        stack.push(Stream.of(0.0, 1.0, 2.0, 3.0, 4.0, 5.0, 6.0, 7.0).collect(Collectors.toCollection(HashSet::new)));
        stack.push(Stream.of(5.0, 6.0, 7.0).collect(Collectors.toCollection(HashSet::new)));
        HashSet<Double> test = Stream.of(0.0, 1.0, 2.0, 3.0, 4.0).collect(Collectors.toCollection(HashSet::new));
        assertEquals(test, stack.doOperation("DIFFERENCE"));
    }

    /**
     * Test de la reconnaissance de l'opérateur UNION
     */
    @Test
    public void isOperatorUnion() { assertTrue(stack.isOperator("UNION")); }

    /**
     * Test de la reconnaissance de l'opérateur INTER
     */
    @Test
    public void isOperatorInter() {
        assertTrue(stack.isOperator("INTER"));
    }

    /**
     * Test de la reconnaissance de l'opérateur DIFFERENCE
     */
    @Test
    public void isOperatorDiff() {
        assertTrue(stack.isOperator("DIFFERENCE"));
    }

    /**
     * Test de la conversion de la chaîne entrée en ensemble
     */
    @Test
    public void getValue() {
        HashSet<Double> test = stack.getValue("[1,2,3]");
        HashSet<Double> compare = Stream.of(1.0, 2.0, 3.0).collect(Collectors.toCollection(HashSet::new));
        assertEquals(compare, test);
    }
}