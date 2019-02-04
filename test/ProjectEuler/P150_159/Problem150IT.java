/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ProjectEuler.P150_159;

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
public class Problem150IT {
    
    public Problem150IT() {
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
     * Test of getRow method, of class Problem150.
     */
    @Test
    public void testGetRow() {
        System.out.println("getRow");
        long k = 0L;
        long expResult = 0L;
        long result = Problem150.getRow(k);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getMinSum method, of class Problem150.
     */
    @Test
    public void testGetMinSum() {
        System.out.println("getMinSum");
        long[] triangle = null;
        long TRIANGLE_ROWS = 0L;
        long k = 0L;
        long expResult = 0L;
        long result = Problem150.getMinSum(triangle, TRIANGLE_ROWS, k);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of problem150 method, of class Problem150.
     */
    @Test
    public void testProblem150() {
        System.out.println("problem150");
        Problem150.problem150();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
