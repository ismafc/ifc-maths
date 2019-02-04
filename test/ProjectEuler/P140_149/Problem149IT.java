/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ProjectEuler.P140_149;

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
public class Problem149IT {
    
    public Problem149IT() {
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
     * Test of get method, of class Problem149.
     */
    @Test
    public void testGet() {
        System.out.println("get");
        int column = 0;
        int row = 0;
        long[] orig = null;
        long expResult = 0L;
        long result = Problem149.get(column, row, orig);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of s method, of class Problem149.
     */
    @Test
    public void testS() {
        System.out.println("s");
        long k = 0L;
        long[] dest = null;
        Problem149.s(k, dest);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of problem149 method, of class Problem149.
     */
    @Test
    public void testProblem149() {
        System.out.println("problem149");
        Problem149.problem149();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
