/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ProjectEuler.P140_149;

import java.util.ArrayList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author ismael.flores
 */
public class Problem148IT {
    
    public Problem148IT() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of chainValue method, of class Problem148.
     */
    @Test
    public void testChainValue() {
        System.out.println("chainValue");
        ArrayList<Long> chain = null;
        long expResult = 0L;
        long result = Problem148.chainValue(chain);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of addChain method, of class Problem148.
     */
    @Test
    public void testAddChain() {
        System.out.println("addChain");
        ArrayList<Long> chain = null;
        Problem148.addChain(chain);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of problem148 method, of class Problem148.
     */
    @Test
    public void testProblem148() {
        System.out.println("problem148");
        Long ROWS = null;
        Problem148.problem148(ROWS);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
