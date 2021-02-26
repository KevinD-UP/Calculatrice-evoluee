package Model.Set;

import Model.Boolean.OperatorBoolean;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Classe de test d'OperatorSet
 */
public class OperatorSetTest {

    OperatorSet union      = OperatorSet.UNION;
    OperatorSet inter      = OperatorSet.INTERSECTION;
    OperatorSet difference = OperatorSet.DIFFERENCE;

    /**
     * Test de la récupération de l'opération UNION
     */
    @Test
    public void getOperatorUnion() { assertEquals("UNION", union.getOperator()); }

    /**
     * Test de la récupération de l'opération INTER
     */
    @Test
    public void getOperatorInter() { assertEquals("INTER", inter.getOperator()); }

    /**
     * Test de la récupération de l'opération COMPLEMENT
     */
    @Test
    public void getOperatorComple() {
        assertEquals("DIFFERENCE", difference.getOperator());
    }
}