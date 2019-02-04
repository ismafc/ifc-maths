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
public class Problem147IT {
    
    public Problem147IT() {
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
     * Test of cross_hatched method, of class Problem147.
     */
    @Test
    public void testCross_hatched() {
        System.out.println("cross_hatched");
        long W = 0L;
        long H = 0L;
        long expResult = 0L;
        long result = Problem147.cross_hatched(W, H);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of problem147 method, of class Problem147.
     */
    @Test
    public void testProblem147() {
        System.out.println("problem147");
        Long W = null;
        Long H = null;
        Problem147.problem147(W, H);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
