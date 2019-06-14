/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ProjectEuler.P001_009;

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
public class Problem001IT {
    
    public Problem001IT() {
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
     * Test of problem001 method, of class Problem001.
     */
    @Test
    public void testProblem001_4args_1() {
        System.out.println("problem001");
        BigInteger A = null;
        BigInteger B = null;
        BigInteger M = null;
        BigInteger N = null;
        BigInteger expResult = null;
        BigInteger result = Problem001.problem001(A, B, M, N);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of problem001 method, of class Problem001.
     */
    @Test
    public void testProblem001_3args_1() {
        System.out.println("problem001");
        ArrayList<BigInteger> V = null;
        BigInteger FROM = null;
        BigInteger BELOW = null;
        BigInteger expResult = null;
        BigInteger result = Problem001.problem001(V, FROM, BELOW);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of problem001 method, of class Problem001.
     */
    @Test
    public void testProblem001_3args_2() {
        System.out.println("problem001");
        ArrayList<Long> V = null;
        long FROM = 0L;
        long BELOW = 0L;
        long expResult = 0L;
        long result = Problem001.problem001(V, FROM, BELOW);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of problem001 method, of class Problem001.
     */
    @Test
    public void testProblem001_4args_2() {
        System.out.println("problem001");
        long A = 0L;
        long B = 0L;
        long M = 0L;
        long N = 0L;
        long expResult = 0L;
        long result = Problem001.problem001(A, B, M, N);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of solution1 method, of class Problem001.
     */
    @Test
    public void testSolution1_4args_1() {
        System.out.println("solution1");
        long A = 0L;
        long B = 0L;
        long M = 0L;
        long N = 0L;
        long expResult = 0L;
        long result = Problem001.solution1(A, B, M, N);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of solution1 method, of class Problem001.
     */
    @Test
    public void testSolution1_4args_2() {
        System.out.println("solution1");
        BigInteger A = null;
        BigInteger B = null;
        BigInteger M = null;
        BigInteger N = null;
        BigInteger expResult = null;
        BigInteger result = Problem001.solution1(A, B, M, N);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of solution1 method, of class Problem001.
     */
    @Test
    public void testSolution1_3args_1() {
        System.out.println("solution1");
        ArrayList<BigInteger> V = null;
        BigInteger FROM = null;
        BigInteger BELOW = null;
        BigInteger expResult = null;
        BigInteger result = Problem001.solution1(V, FROM, BELOW);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of solution1 method, of class Problem001.
     */
    @Test
    public void testSolution1_3args_2() {
        System.out.println("solution1");
        ArrayList<Long> V = null;
        long M = 0L;
        long N = 0L;
        long expResult = 0L;
        long result = Problem001.solution1(V, M, N);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of solution2 method, of class Problem001.
     */
    @Test
    public void testSolution2_3args_1() {
        System.out.println("solution2");
        ArrayList<Long> V = null;
        long M = 0L;
        long N = 0L;
        long expResult = 0L;
        long result = Problem001.solution2(V, M, N);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of solution2 method, of class Problem001.
     */
    @Test
    public void testSolution2_3args_2() {
        System.out.println("solution2");
        ArrayList<BigInteger> V = null;
        BigInteger M = null;
        BigInteger N = null;
        BigInteger expResult = null;
        BigInteger result = Problem001.solution2(V, M, N);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of solution2 method, of class Problem001.
     */
    @Test
    public void testSolution2_4args_1() {
        System.out.println("solution2");
        long A = 0L;
        long B = 0L;
        long M = 0L;
        long N = 0L;
        long expResult = 0L;
        long result = Problem001.solution2(A, B, M, N);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of solution2 method, of class Problem001.
     */
    @Test
    public void testSolution2_4args_2() {
        System.out.println("solution2");
        BigInteger A = null;
        BigInteger B = null;
        BigInteger M = null;
        BigInteger N = null;
        BigInteger expResult = null;
        BigInteger result = Problem001.solution2(A, B, M, N);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of solution3 method, of class Problem001.
     */
    @Test
    public void testSolution3_3args_1() {
        System.out.println("solution3");
        BigInteger A = null;
        BigInteger B = null;
        BigInteger N = null;
        BigInteger expResult = null;
        BigInteger result = Problem001.solution3(A, B, N);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of solution3 method, of class Problem001.
     */
    @Test
    public void testSolution3_4args_1() {
        System.out.println("solution3");
        BigInteger A = null;
        BigInteger B = null;
        BigInteger M = null;
        BigInteger N = null;
        BigInteger expResult = null;
        BigInteger result = Problem001.solution3(A, B, M, N);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of solution3 method, of class Problem001.
     */
    @Test
    public void testSolution3_3args_2() {
        System.out.println("solution3");
        long A = 0L;
        long B = 0L;
        long N = 0L;
        long expResult = 0L;
        long result = Problem001.solution3(A, B, N);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of solution3 method, of class Problem001.
     */
    @Test
    public void testSolution3_4args_2() {
        System.out.println("solution3");
        long A = 0L;
        long B = 0L;
        long M = 0L;
        long N = 0L;
        long expResult = 0L;
        long result = Problem001.solution3(A, B, M, N);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of solution3 method, of class Problem001.
     */
    @Test
    public void testSolution3_3args_3() {
        System.out.println("solution3");
        ArrayList<Long> V = null;
        long M = 0L;
        long N = 0L;
        long expResult = 0L;
        long result = Problem001.solution3(V, M, N);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of solution3 method, of class Problem001.
     */
    @Test
    public void testSolution3_3args_4() {
        System.out.println("solution3");
        ArrayList<BigInteger> V = null;
        BigInteger M = null;
        BigInteger N = null;
        BigInteger expResult = null;
        BigInteger result = Problem001.solution3(V, M, N);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
