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

    private long A = 3L;
    BigInteger A_ = new BigInteger("3");
    private long B = 5L;
    BigInteger B_ = new BigInteger("5");
    long FROM = 1L;
    BigInteger FROM_ = new BigInteger("1");
    long BELOW = 1000L;
    BigInteger BELOW_ = new BigInteger("1000");
    long expResult = 233168L;
    BigInteger expResult_ = new BigInteger("233168");
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
        A = 3L;
        A_ = new BigInteger("3");
        B = 5L;
        B_ = new BigInteger("5");
        FROM = 1L;
        FROM_ = new BigInteger("1");
        BELOW = 1000L;
        BELOW_ = new BigInteger("1000");
        expResult = 233168L;
        expResult_ = new BigInteger("233168");
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
        long result = instance.solution1(A, B, BELOW);
        assertEquals(expResult, result);
    }

    /**
     * Test of solution1(BigInteger A, BigInteger B, BigInteger BELOW) method, of class Problem001.
     */
    @Test
    public void testSolution1_3args_2() {
        System.out.println("solution1(BigInteger A, BigInteger B, BigInteger BELOW)");
        BigInteger result = instance.solution1(A_, B_, BELOW_);
        assertEquals(expResult_, result);
    }

    /**
     * Test of solution1(long A, long B, long FROM, long BELOW) method, of class Problem001.
     */
    @Test
    public void testSolution1_4args_1() {
        System.out.println("solution1(long A, long B, long FROM, long BELOW)");
        long result = instance.solution1(A, B, FROM, BELOW);
        assertEquals(expResult, result);
    }

    /**
     * Test of solution1(BigInteger A, BigInteger B, BigInteger FROM, BigInteger BELOW) method, of class Problem001.
     */
    @Test
    public void testSolution1_4args_2() {
        System.out.println("solution1(BigInteger A, BigInteger B, BigInteger FROM, BigInteger BELOW)");
        BigInteger result = instance.solution1(A_, B_, FROM_, BELOW_);
        assertEquals(expResult_, result);
    }

    /**
     * Test of solution2(long A, long B, long BELOW) method, of class Problem001.
     */
    @Test
    public void testSolution2_3args_1() {
        System.out.println("solution2(long A, long B, long BELOW)");
        long result = instance.solution2(A, B, BELOW);
        assertEquals(expResult, result);
    }

    /**
     * Test of solution2(BigInteger A, BigInteger B, BigInteger BELOW) method, of class Problem001.
     */
    @Test
    public void testSolution2_3args_2() {
        System.out.println("solution2(BigInteger A, BigInteger B, BigInteger BELOW)");
        BigInteger result = instance.solution2(A_, B_, BELOW_);
        assertEquals(expResult_, result);
    }

    /**
     * Test of solution2(long A, long B, long FROM, long BELOW) method, of class Problem001.
     */
    @Test
    public void testSolution2_4args_1() {
        System.out.println("solution2(long A, long B, long FROM, long BELOW)");
        long result = instance.solution2(A, B, FROM, BELOW);
        assertEquals(expResult, result);
    }

    /**
     * Test of solution2(BigInteger A, BigInteger B, BigInteger FROM, BigInteger BELOW) method, of class Problem001.
     */
    @Test
    public void testSolution2_4args_2() {
        System.out.println("solution2(BigInteger A, BigInteger B, BigInteger FROM, BigInteger BELOW)");
        BigInteger result = instance.solution2(A_, B_, FROM_, BELOW_);
        assertEquals(expResult_, result);
    }

    /**
     * Test of solution3(long A, long B, long BELOW) method, of class Problem001.
     */
    @Test
    public void testSolution3_3args_1() {
        System.out.println("solution3(long A, long B, long BELOW)");
        long result = instance.solution3(A, B, BELOW);
        assertEquals(expResult, result);
    }

    /**
     * Test of solution3(long A, long B, long FROM, long BELOW) method, of class Problem001.
     */
    @Test
    public void testSolution3_4args_1() {
        System.out.println("solution3(long A, long B, long FROM, long BELOW)");
        long result = instance.solution3(A, B, FROM, BELOW);
        assertEquals(expResult, result);
    }

    /**
     * Test of solution3(BigInteger A, BigInteger B, BigInteger BELOW) method, of class Problem001.
     */
    @Test
    public void testSolution3_3args_2() {
        System.out.println("solution3(BigInteger A, BigInteger B, BigInteger BELOW)");
        BigInteger result = instance.solution3(A_, B_, BELOW_);
        assertEquals(expResult_, result);
    }

    /**
     * Test of solution3(BigInteger A, BigInteger B, BigInteger FROM, BigInteger BELOW) method, of class Problem001.
     */
    @Test
    public void testSolution3_4args_2() {
        System.out.println("solution3(BigInteger A, BigInteger B, BigInteger FROM, BigInteger BELOW)");
        BigInteger result = instance.solution3(A_, B_, FROM_, BELOW_);
        assertEquals(expResult_, result);
    }

    /**
     * Test of solve() method, of class Problem001.
     */
    @Test
    public void testSolve() {
        System.out.println("solve()");
        long result = instance.solve();
        assertEquals(expResult, result);
    }

    /**
     * Test of solve(int solution) method, of class Problem001.
     */
    @Test
    public void testSolve_int() {
        System.out.println("solve(int solution)");
        long result = instance.solve(Problem001.Algorithm.SOLUTION1);
        assertEquals(expResult, result);

        result = instance.solve(Problem001.Algorithm.SOLUTION2);
        assertEquals(expResult, result);

        result = instance.solve(Problem001.Algorithm.SOLUTION3);
        assertEquals(expResult, result);
    }

    /**
     * Test of solve(long A, long B, long BELOW) method, of class Problem001.
     */
    @Test
    public void testSolve_3args_1() {
        System.out.println("solve(long A, long B, long BELOW)");
        long result = instance.solve(A, B, BELOW);
        assertEquals(expResult, result);
    }

    /**
     * Test of solve(long A, long B, long BELOW, int solution) method, of class Problem001.
     */
    @Test
    public void testSolve_4args_1() {
        System.out.println("solve(long A, long B, long BELOW, int solution)");
        long result = instance.solve(A, B, BELOW, Problem001.Algorithm.SOLUTION1);
        assertEquals(expResult, result);

        result = instance.solve(A, B, BELOW, Problem001.Algorithm.SOLUTION2);
        assertEquals(expResult, result);
 
        result = instance.solve(A, B, BELOW, Problem001.Algorithm.SOLUTION3);
        assertEquals(expResult, result);
    }

    /**
     * Test of solve(long A, long B, long FROM, long BELOW) method, of class Problem001.
     */
    @Test
    public void testSolve_4args_2() {
        System.out.println("solve(long A, long B, long FROM, long BELOW)");
        long result = instance.solve(A, B, FROM, BELOW);
        assertEquals(expResult, result);
    }

    /**
     * Test of solve(long A, long B, long FROM, long BELOW, int solution) method, of class Problem001.
     */
    @Test
    public void testSolve_5args_1() {
        System.out.println("solve(long A, long B, long FROM, long BELOW, int solution)");
        long result = instance.solve(A, B, FROM, BELOW, Problem001.Algorithm.SOLUTION1);
        assertEquals(expResult, result);

        result = instance.solve(A, B, FROM, BELOW, Problem001.Algorithm.SOLUTION2);
        assertEquals(expResult, result);

        result = instance.solve(A, B, FROM, BELOW, Problem001.Algorithm.SOLUTION3);
        assertEquals(expResult, result);
    }

    /**
     * Test of solve(BigInteger A, BigInteger B, BigInteger BELOW) method, of class Problem001.
     */
    @Test
    public void testSolve_3args_2() {
        System.out.println("solve(BigInteger A, BigInteger B, BigInteger BELOW)");
        BigInteger result = instance.solve(A_, B_, BELOW_);
        assertEquals(expResult_, result);
    }

    /**
     * Test of solve(BigInteger A, BigInteger B, BigInteger BELOW, int solution) method, of class Problem001.
     */
    @Test
    public void testSolve_4args_3() {
        System.out.println("solve(BigInteger A, BigInteger B, BigInteger BELOW, int solution)");
        BigInteger result = instance.solve(A_, B_, BELOW_, Problem001.Algorithm.SOLUTION1);
        assertEquals(expResult_, result);

        result = instance.solve(A_, B_, BELOW_, Problem001.Algorithm.SOLUTION2);
        assertEquals(expResult_, result);

        result = instance.solve(A_, B_, BELOW_, Problem001.Algorithm.SOLUTION3);
        assertEquals(expResult_, result);
    }

    /**
     * Test of solve(BigInteger A, BigInteger B, BigInteger FROM, BigInteger BELOW) method, of class Problem001.
     */
    @Test
    public void testSolve_4args_4() {
        System.out.println("solve(BigInteger A, BigInteger B, BigInteger FROM, BigInteger BELOW)");
        BigInteger result = instance.solve(A_, B_, FROM_, BELOW_);
        assertEquals(expResult_, result);
    }

    /**
     * Test of solve(BigInteger A, BigInteger B, BigInteger FROM, BigInteger BELOW, int solution) method, of class Problem001.
     */
    @Test
    public void testSolve_5args_2() {
        System.out.println("solve(BigInteger A, BigInteger B, BigInteger FROM, BigInteger BELOW, int solution)");
        BigInteger result = instance.solve(A_, B_, FROM_, BELOW_, Problem001.Algorithm.SOLUTION1);
        assertEquals(expResult_, result);

        result = instance.solve(A_, B_, FROM_, BELOW_, Problem001.Algorithm.SOLUTION2);
        assertEquals(expResult_, result);

        result = instance.solve(A_, B_, FROM_, BELOW_, Problem001.Algorithm.SOLUTION3);
        assertEquals(expResult_, result);
    }

    /**
     * Test of solve(ArrayList&lt;Long&gt; V, long FROM, long BELOW) method, of class Problem001.
     */
    @Test
    public void testSolve_3args_3() {
        System.out.println("solve(ArrayList<Long> V, long FROM, long BELOW)");
        ArrayList<Long> V = new ArrayList<>(Arrays.asList(A, B));
        long result = instance.solve(V, FROM, BELOW);
        assertEquals(expResult, result);
    }

    /**
     * Test of solve(ArrayList&lt;Long&ht; V, long FROM, long BELOW, int solution) method, of class Problem001.
     */
    @Test
    public void testSolve_4args_5() {
        System.out.println("solve(ArrayList<Long> V, long FROM, long BELOW, int solution)");
        ArrayList<Long> V = new ArrayList<>(Arrays.asList(A, B));
        long result = instance.solve(V, FROM, BELOW, Problem001.Algorithm.SOLUTION1);
        assertEquals(expResult, result);
        
        result = instance.solve(V, FROM, BELOW, Problem001.Algorithm.SOLUTION2);
        assertEquals(expResult, result);

        result = instance.solve(V, FROM, BELOW, Problem001.Algorithm.SOLUTION3);
        assertEquals(expResult, result);
    }

    /**
     * Test of solve(ArrayList&lt;BigInteger&gt; V, BigInteger FROM, BigInteger BELOW) method, of class Problem001.
     */
    @Test
    public void testSolve_3args_4() {
        System.out.println("solve(ArrayList<BigInteger> V, BigInteger FROM, BigInteger BELOW)");
        ArrayList<BigInteger> V = new ArrayList<>(Arrays.asList(A_, B_));
        BigInteger result = instance.solve(V, FROM_, BELOW_);
        assertEquals(expResult_, result);
    }

    /**
     * Test of solve(ArrayList&lt;BigInteger&gt; V, BigInteger FROM, BigInteger BELOW, int solution) method, of class Problem001.
     */
    @Test
    public void testSolve_4args_6() {
        System.out.println("solve(ArrayList<BigInteger> V, BigInteger FROM, BigInteger BELOW, int solution)");
        ArrayList<BigInteger> V = new ArrayList<>(Arrays.asList(A_, B_));
        BigInteger result = instance.solve(V, FROM_, BELOW_, Problem001.Algorithm.SOLUTION1);
        assertEquals(expResult_, result);
        
        result = instance.solve(V, FROM_, BELOW_, Problem001.Algorithm.SOLUTION2);
        assertEquals(expResult_, result);
        
        result = instance.solve(V, FROM_, BELOW_, Problem001.Algorithm.SOLUTION3);
        assertEquals(expResult_, result);
    }
    
}
