package Model.Boolean;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Classe de test de Boolean
 */
public class BooleanTest {

    Boolean b;

    @Before
    public void init(){
        b = Boolean.generate("VRAI");
    }


    /**
     * Test la fabrication d'une instance
     */
    @Test
    public void getValue() { assertEquals("VRAI", b.getValue()); }
}