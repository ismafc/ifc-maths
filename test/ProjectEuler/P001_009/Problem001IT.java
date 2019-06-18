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
     * Test of solve method, of class Problem001.
     */
    @Test
    public void testSolve() {
        System.out.println("solve");
        long expResult = 0L;
        long result = Problem001.solve();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of solve method, of class Problem001.
     */
    @Test
    public void testSolve_3args_1() {
        System.out.println("solve");
        long A = 0L;
        long B = 0L;
        long BELOW = 0L;
        long expResult = 0L;
        long result = Problem001.solve(A, B, BELOW);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of solve method, of class Problem001.
     */
    @Test
    public void testSolve_4args_1() {
        System.out.println("solve");
        long A = 0L;
        long B = 0L;
        long BELOW = 0L;
        int solution = 0;
        long expResult = 0L;
        long result = Problem001.solve(A, B, BELOW, solution);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of solve method, of class Problem001.
     */
    @Test
    public void testSolve_4args_2() {
        System.out.println("solve");
        long A = 0L;
        long B = 0L;
        long FROM = 0L;
        long BELOW = 0L;
        long expResult = 0L;
        long result = Problem001.solve(A, B, FROM, BELOW);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of solve method, of class Problem001.
     */
    @Test
    public void testSolve_5args_1() {
        System.out.println("solve");
        long A = 0L;
        long B = 0L;
        long FROM = 0L;
        long BELOW = 0L;
        int solution = 0;
        long expResult = 0L;
        long result = Problem001.solve(A, B, FROM, BELOW, solution);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of solve method, of class Problem001.
     */
    @Test
    public void testSolve_3args_2() {
        System.out.println("solve");
        BigInteger A = null;
        BigInteger B = null;
        BigInteger BELOW = null;
        BigInteger expResult = null;
        BigInteger result = Problem001.solve(A, B, BELOW);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of solve method, of class Problem001.
     */
    @Test
    public void testSolve_4args_3() {
        System.out.println("solve");
        BigInteger A = null;
        BigInteger B = null;
        BigInteger BELOW = null;
        int solution = 0;
        BigInteger expResult = null;
        BigInteger result = Problem001.solve(A, B, BELOW, solution);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of solve method, of class Problem001.
     */
    @Test
    public void testSolve_4args_4() {
        System.out.println("solve");
        BigInteger A = null;
        BigInteger B = null;
        BigInteger FROM = null;
        BigInteger BELOW = null;
        BigInteger expResult = null;
        BigInteger result = Problem001.solve(A, B, FROM, BELOW);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of solve method, of class Problem001.
     */
    @Test
    public void testSolve_5args_2() {
        System.out.println("solve");
        BigInteger A = null;
        BigInteger B = null;
        BigInteger FROM = null;
        BigInteger BELOW = null;
        int solution = 0;
        BigInteger expResult = null;
        BigInteger result = Problem001.solve(A, B, FROM, BELOW, solution);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of solve method, of class Problem001.
     */
    @Test
    public void testSolve_3args_3() {
        System.out.println("solve");
        ArrayList<Long> V = null;
        long FROM = 0L;
        long BELOW = 0L;
        long expResult = 0L;
        long result = Problem001.solve(V, FROM, BELOW);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of solve method, of class Problem001.
     */
    @Test
    public void testSolve_4args_5() {
        System.out.println("solve");
        ArrayList<Long> V = null;
        long FROM = 0L;
        long BELOW = 0L;
        int solution = 0;
        long expResult = 0L;
        long result = Problem001.solve(V, FROM, BELOW, solution);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of solve method, of class Problem001.
     */
    @Test
    public void testSolve_3args_4() {
        System.out.println("solve");
        ArrayList<BigInteger> V = null;
        BigInteger FROM = null;
        BigInteger BELOW = null;
        BigInteger expResult = null;
        BigInteger result = Problem001.solve(V, FROM, BELOW);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of solve method, of class Problem001.
     */
    @Test
    public void testSolve_4args_6() {
        System.out.println("solve");
        ArrayList<BigInteger> V = null;
        BigInteger FROM = null;
        BigInteger BELOW = null;
        int solution = 0;
        BigInteger expResult = null;
        BigInteger result = Problem001.solve(V, FROM, BELOW, solution);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of solve method, of class Problem001.
     */
    @Test
    public void testSolve_int() {
        System.out.println("solve");
        int solution = 0;
        long expResult = 0L;
        long result = Problem001.solve(solution);
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
        long A = 0L;
        long B = 0L;
        long BELOW = 0L;
        long expResult = 0L;
        long result = Problem001.solution1(A, B, BELOW);
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
        BigInteger A = null;
        BigInteger B = null;
        BigInteger BELOW = null;
        BigInteger expResult = null;
        BigInteger result = Problem001.solution1(A, B, BELOW);
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
        long A = 0L;
        long B = 0L;
        long BELOW = 0L;
        long expResult = 0L;
        long result = Problem001.solution2(A, B, BELOW);
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
        BigInteger A = null;
        BigInteger B = null;
        BigInteger BELOW = null;
        BigInteger expResult = null;
        BigInteger result = Problem001.solution2(A, B, BELOW);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
