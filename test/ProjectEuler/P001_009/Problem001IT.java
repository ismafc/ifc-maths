/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ProjectEuler.P001_009;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
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

    private final Problem001 instance = new Problem001();
    
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
     * Test of solution1(long A, long B, long BELOW) method, of class Problem001.
     */
    @Test
    public void testSolution1_3args_1() {
        System.out.println("solution1(long A, long B, long BELOW)");
        long A = 3L;
        long B = 5L;
        long BELOW = 1000L;
        long expResult = 233168L;
        long result = instance.solution1(A, B, BELOW);
        assertEquals(expResult, result);
    }

    /**
     * Test of solution1(BigInteger A, BigInteger B, BigInteger BELOW) method, of class Problem001.
     */
    @Test
    public void testSolution1_3args_2() {
        System.out.println("solution1(BigInteger A, BigInteger B, BigInteger BELOW)");
        BigInteger A = new BigInteger("3");
        BigInteger B = new BigInteger("5");
        BigInteger BELOW = new BigInteger("1000");
        BigInteger expResult = new BigInteger("233168");
        BigInteger result = instance.solution1(A, B, BELOW);
        assertEquals(expResult, result);
    }

    /**
     * Test of solution1(long A, long B, long FROM, long BELOW) method, of class Problem001.
     */
    @Test
    public void testSolution1_4args_1() {
        System.out.println("solution1(long A, long B, long FROM, long BELOW)");
        long A = 3L;
        long B = 5L;
        long FROM = 1L;
        long BELOW = 1000L;
        long expResult = 233168L;
        long result = instance.solution1(A, B, FROM, BELOW);
        assertEquals(expResult, result);
    }

    /**
     * Test of solution1(BigInteger A, BigInteger B, BigInteger FROM, BigInteger BELOW) method, of class Problem001.
     */
    @Test
    public void testSolution1_4args_2() {
        System.out.println("solution1(BigInteger A, BigInteger B, BigInteger FROM, BigInteger BELOW)");
        BigInteger A = new BigInteger("3");
        BigInteger B = new BigInteger("5");
        BigInteger FROM = new BigInteger("1");
        BigInteger BELOW = new BigInteger("1000");
        BigInteger expResult = new BigInteger("233168");
        BigInteger result = instance.solution1(A, B, FROM, BELOW);
        assertEquals(expResult, result);
    }

    /**
     * Test of solution2(long A, long B, long BELOW) method, of class Problem001.
     */
    @Test
    public void testSolution2_3args_1() {
        System.out.println("solution2(long A, long B, long BELOW)");
        long A = 3L;
        long B = 5L;
        long BELOW = 1000L;
        long expResult = 233168L;
        long result = instance.solution2(A, B, BELOW);
        assertEquals(expResult, result);
    }

    /**
     * Test of solution2(BigInteger A, BigInteger B, BigInteger BELOW) method, of class Problem001.
     */
    @Test
    public void testSolution2_3args_2() {
        System.out.println("solution2(BigInteger A, BigInteger B, BigInteger BELOW)");
        BigInteger A = new BigInteger("3");
        BigInteger B = new BigInteger("5");
        BigInteger BELOW = new BigInteger("1000");
        BigInteger expResult = new BigInteger("233168");
        BigInteger result = instance.solution2(A, B, BELOW);
        assertEquals(expResult, result);
    }

    /**
     * Test of solution2(long A, long B, long FROM, long BELOW) method, of class Problem001.
     */
    @Test
    public void testSolution2_4args_1() {
        System.out.println("solution2(long A, long B, long FROM, long BELOW)");
        long A = 3L;
        long B = 5L;
        long FROM = 1L;
        long BELOW = 1000L;
        long expResult = 233168L;
        long result = instance.solution2(A, B, FROM, BELOW);
        assertEquals(expResult, result);
    }

    /**
     * Test of solution2(BigInteger A, BigInteger B, BigInteger FROM, BigInteger BELOW) method, of class Problem001.
     */
    @Test
    public void testSolution2_4args_2() {
        System.out.println("solution2(BigInteger A, BigInteger B, BigInteger FROM, BigInteger BELOW)");
        BigInteger A = new BigInteger("3");
        BigInteger B = new BigInteger("5");
        BigInteger FROM = new BigInteger("1");
        BigInteger BELOW = new BigInteger("1000");
        BigInteger expResult = new BigInteger("233168");
        BigInteger result = instance.solution2(A, B, FROM, BELOW);
        assertEquals(expResult, result);
    }

    /**
     * Test of solution3(long A, long B, long BELOW) method, of class Problem001.
     */
    @Test
    public void testSolution3_3args_1() {
        System.out.println("solution3(long A, long B, long BELOW)");
        long A = 3L;
        long B = 5L;
        long BELOW = 1000L;
        long expResult = 233168L;
        long result = instance.solution3(A, B, BELOW);
        assertEquals(expResult, result);
    }

    /**
     * Test of solution3(long A, long B, long FROM, long BELOW) method, of class Problem001.
     */
    @Test
    public void testSolution3_4args_1() {
        System.out.println("solution3(long A, long B, long FROM, long BELOW)");
        long A = 3L;
        long B = 5L;
        long FROM = 1L;
        long BELOW = 1000L;
        long expResult = 233168L;
        long result = instance.solution3(A, B, FROM, BELOW);
        assertEquals(expResult, result);
    }

    /**
     * Test of solution3(BigInteger A, BigInteger B, BigInteger BELOW) method, of class Problem001.
     */
    @Test
    public void testSolution3_3args_2() {
        System.out.println("solution3(BigInteger A, BigInteger B, BigInteger BELOW)");
        BigInteger A = new BigInteger("3");
        BigInteger B = new BigInteger("5");
        BigInteger BELOW = new BigInteger("1000");
        BigInteger expResult = new BigInteger("233168");
        BigInteger result = instance.solution3(A, B, BELOW);
        assertEquals(expResult, result);
    }

    /**
     * Test of solution3(BigInteger A, BigInteger B, BigInteger FROM, BigInteger BELOW) method, of class Problem001.
     */
    @Test
    public void testSolution3_4args_2() {
        System.out.println("solution3(BigInteger A, BigInteger B, BigInteger FROM, BigInteger BELOW)");
        BigInteger A = new BigInteger("3");
        BigInteger B = new BigInteger("5");
        BigInteger FROM = new BigInteger("1");
        BigInteger BELOW = new BigInteger("1000");
        BigInteger expResult = new BigInteger("233168");
        BigInteger result = instance.solution3(A, B, FROM, BELOW);
        assertEquals(expResult, result);
    }

    /**
     * Test of solve() method, of class Problem001.
     */
    @Test
    public void testSolve() {
        System.out.println("solve()");
        long expResult = 233168L;
        long result = instance.solve();
        assertEquals(expResult, result);
    }

    /**
     * Test of solve(int solution) method, of class Problem001.
     */
    @Test
    public void testSolve_int() {
        System.out.println("solve(int solution)");
        int solution = Problem001.SOLUTION1;
        long expResult = 233168L;
        long result = instance.solve(solution);
        assertEquals(expResult, result);

        solution = Problem001.SOLUTION2;
        result = instance.solve(solution);
        assertEquals(expResult, result);

        solution = Problem001.SOLUTION3;
        result = instance.solve(solution);
        assertEquals(expResult, result);
    }

    /**
     * Test of solve(long A, long B, long BELOW) method, of class Problem001.
     */
    @Test
    public void testSolve_3args_1() {
        System.out.println("solve(long A, long B, long BELOW)");
        long A = 3L;
        long B = 5L;
        long BELOW = 1000L;
        long expResult = 233168L;
        long result = instance.solve(A, B, BELOW);
        assertEquals(expResult, result);
    }

    /**
     * Test of solve(long A, long B, long BELOW, int solution) method, of class Problem001.
     */
    @Test
    public void testSolve_4args_1() {
        System.out.println("solve(long A, long B, long BELOW, int solution)");
        long A = 3L;
        long B = 5L;
        long BELOW = 1000L;
        int solution = Problem001.SOLUTION1;
        long expResult = 233168L;
        long result = instance.solve(A, B, BELOW, solution);
        assertEquals(expResult, result);

        solution = Problem001.SOLUTION2;
        result = instance.solve(A, B, BELOW, solution);
        assertEquals(expResult, result);
 
        solution = Problem001.SOLUTION3;
        result = instance.solve(A, B, BELOW, solution);
        assertEquals(expResult, result);
    }

    /**
     * Test of solve(long A, long B, long FROM, long BELOW) method, of class Problem001.
     */
    @Test
    public void testSolve_4args_2() {
        System.out.println("solve(long A, long B, long FROM, long BELOW)");
        long A = 3L;
        long B = 5L;
        long FROM = 1L;
        long BELOW = 1000L;
        long expResult = 233168L;
        long result = instance.solve(A, B, FROM, BELOW);
        assertEquals(expResult, result);
    }

    /**
     * Test of solve(long A, long B, long FROM, long BELOW, int solution) method, of class Problem001.
     */
    @Test
    public void testSolve_5args_1() {
        System.out.println("solve(long A, long B, long FROM, long BELOW, int solution)");
        long A = 3L;
        long B = 5L;
        long FROM = 1L;
        long BELOW = 1000L;
        int solution = Problem001.SOLUTION1;
        long expResult = 233168L;
        long result = instance.solve(A, B, FROM, BELOW, solution);
        assertEquals(expResult, result);

        solution = Problem001.SOLUTION2;
        result = instance.solve(A, B, FROM, BELOW, solution);
        assertEquals(expResult, result);

        solution = Problem001.SOLUTION3;
        result = instance.solve(A, B, FROM, BELOW, solution);
        assertEquals(expResult, result);
    }

    /**
     * Test of solve(BigInteger A, BigInteger B, BigInteger BELOW) method, of class Problem001.
     */
    @Test
    public void testSolve_3args_2() {
        System.out.println("solve(BigInteger A, BigInteger B, BigInteger BELOW)");
        BigInteger A = new BigInteger("3");
        BigInteger B = new BigInteger("5");
        BigInteger BELOW = new BigInteger("1000");
        BigInteger expResult = new BigInteger("233168");
        BigInteger result = instance.solve(A, B, BELOW);
        assertEquals(expResult, result);
    }

    /**
     * Test of solve(BigInteger A, BigInteger B, BigInteger BELOW, int solution) method, of class Problem001.
     */
    @Test
    public void testSolve_4args_3() {
        System.out.println("solve(BigInteger A, BigInteger B, BigInteger BELOW, int solution)");
        BigInteger A = new BigInteger("3");
        BigInteger B = new BigInteger("5");
        BigInteger BELOW = new BigInteger("1000");
        int solution = Problem001.SOLUTION1;
        BigInteger expResult = new BigInteger("233168");
        BigInteger result = instance.solve(A, B, BELOW, solution);
        assertEquals(expResult, result);

        solution = Problem001.SOLUTION2;
        result = instance.solve(A, B, BELOW, solution);
        assertEquals(expResult, result);

        solution = Problem001.SOLUTION3;
        result = instance.solve(A, B, BELOW, solution);
        assertEquals(expResult, result);
    }

    /**
     * Test of solve(BigInteger A, BigInteger B, BigInteger FROM, BigInteger BELOW) method, of class Problem001.
     */
    @Test
    public void testSolve_4args_4() {
        System.out.println("solve(BigInteger A, BigInteger B, BigInteger FROM, BigInteger BELOW)");
        BigInteger A = new BigInteger("3");
        BigInteger B = new BigInteger("5");
        BigInteger FROM = new BigInteger("1");
        BigInteger BELOW = new BigInteger("1000");
        BigInteger expResult = new BigInteger("233168");
        BigInteger result = instance.solve(A, B, FROM, BELOW);
        assertEquals(expResult, result);
    }

    /**
     * Test of solve(BigInteger A, BigInteger B, BigInteger FROM, BigInteger BELOW, int solution) method, of class Problem001.
     */
    @Test
    public void testSolve_5args_2() {
        System.out.println("solve(BigInteger A, BigInteger B, BigInteger FROM, BigInteger BELOW, int solution)");
        BigInteger A = new BigInteger("3");
        BigInteger B = new BigInteger("5");
        BigInteger FROM = new BigInteger("1");
        BigInteger BELOW = new BigInteger("1000");
        int solution = Problem001.SOLUTION1;
        BigInteger expResult = new BigInteger("233168");
        BigInteger result = instance.solve(A, B, FROM, BELOW, solution);
        assertEquals(expResult, result);

        solution = Problem001.SOLUTION2;
        result = instance.solve(A, B, FROM, BELOW, solution);
        assertEquals(expResult, result);

        solution = Problem001.SOLUTION3;
        result = instance.solve(A, B, FROM, BELOW, solution);
        assertEquals(expResult, result);
    }

    /**
     * Test of solve(ArrayList&lt;Long&gt; V, long FROM, long BELOW) method, of class Problem001.
     */
    @Test
    public void testSolve_3args_3() {
        System.out.println("solve(ArrayList<Long> V, long FROM, long BELOW)");
        ArrayList<Long> V = new ArrayList<>(Arrays.asList(3L, 5L));
        long FROM = 1L;
        long BELOW = 1000L;
        long expResult = 233168L;
        long result = instance.solve(V, FROM, BELOW);
        assertEquals(expResult, result);
    }

    /**
     * Test of solve(ArrayList&lt;Long&ht; V, long FROM, long BELOW, int solution) method, of class Problem001.
     */
    @Test
    public void testSolve_4args_5() {
        System.out.println("solve(ArrayList<Long> V, long FROM, long BELOW, int solution)");
        ArrayList<Long> V = new ArrayList<>(Arrays.asList(3L, 5L));
        long FROM = 1L;
        long BELOW = 1000L;
        int solution = Problem001.SOLUTION1;
        long expResult = 233168L;
        long result = instance.solve(V, FROM, BELOW, solution);
        assertEquals(expResult, result);
        
        solution = Problem001.SOLUTION2;
        result = instance.solve(V, FROM, BELOW, solution);
        assertEquals(expResult, result);

        solution = Problem001.SOLUTION3;
        result = instance.solve(V, FROM, BELOW, solution);
        assertEquals(expResult, result);
    }

    /**
     * Test of solve(ArrayList&lt;BigInteger&gt; V, BigInteger FROM, BigInteger BELOW) method, of class Problem001.
     */
    @Test
    public void testSolve_3args_4() {
        System.out.println("solve(ArrayList<BigInteger> V, BigInteger FROM, BigInteger BELOW)");
        ArrayList<BigInteger> V = new ArrayList<>(Arrays.asList(new BigInteger("3"), new BigInteger("5")));
        BigInteger FROM = new BigInteger("1");
        BigInteger BELOW = new BigInteger("1000");
        BigInteger expResult = new BigInteger("233168");
        BigInteger result = instance.solve(V, FROM, BELOW);
        assertEquals(expResult, result);
    }

    /**
     * Test of solve(ArrayList&lt;BigInteger&gt; V, BigInteger FROM, BigInteger BELOW, int solution) method, of class Problem001.
     */
    @Test
    public void testSolve_4args_6() {
        System.out.println("solve(ArrayList<BigInteger> V, BigInteger FROM, BigInteger BELOW, int solution)");
        ArrayList<BigInteger> V = new ArrayList<>(Arrays.asList(new BigInteger("3"), new BigInteger("5")));
        BigInteger FROM = new BigInteger("1");
        BigInteger BELOW = new BigInteger("1000");
        int solution = Problem001.SOLUTION1;
        BigInteger expResult = new BigInteger("233168");
        BigInteger result = instance.solve(V, FROM, BELOW, solution);
        assertEquals(expResult, result);
        
        solution = Problem001.SOLUTION2;
        result = instance.solve(V, FROM, BELOW, solution);
        assertEquals(expResult, result);
        
        solution = Problem001.SOLUTION3;
        result = instance.solve(V, FROM, BELOW, solution);
        assertEquals(expResult, result);
    }
    
}
