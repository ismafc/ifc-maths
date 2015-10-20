/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ProjectEuler.P160_169;

import java.math.BigInteger;
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
public class Problem169IT {
    
    public Problem169IT() {
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
     * Test of max method, of class Problem169.
     */
    @Test
    public void testMax_int() {
        System.out.println("max");
        int p = 0;
        BigInteger expResult = null;
        BigInteger result = Problem169.max(p);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of max method, of class Problem169.
     */
    @Test
    public void testMax_long() {
        System.out.println("max");
        long p = 0L;
        long expResult = 0L;
        long result = Problem169.max(p);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of expand method, of class Problem169.
     */
    @Test
    public void testExpand_4args() {
        System.out.println("expand");
        long v = 0L;
        long p = 0L;
        long[] nfst = null;
        long[] res = null;
        Problem169.expand(v, p, nfst, res);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of expand method, of class Problem169.
     */
    @Test
    public void testExpand_Problem169State_ArrayList() {
        System.out.println("expand");
        ArrayList lst = null;
        long expResult = 0L;
        long result = Problem169.expand(null, lst);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of problem169 method, of class Problem169.
     */
    @Test
    public void testProblem169() {
        System.out.println("problem169");
        BigInteger target = null;
        Problem169.problem169(target);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
