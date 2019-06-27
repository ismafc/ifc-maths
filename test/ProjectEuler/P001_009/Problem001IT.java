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

    private long a = 3L;
    private BigInteger a_ = new BigInteger("3");
    private long b = 5L;
    private BigInteger b_ = new BigInteger("5");
    private long from = 1L;
    private BigInteger from_ = new BigInteger("1");
    private long below = 1000L;
    private BigInteger below_ = new BigInteger("1000");
    private long expResult = 233168L;
    private BigInteger expResult_ = new BigInteger("233168");
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
        a = 3L;
        a_ = new BigInteger("3");
        b = 5L;
        b_ = new BigInteger("5");
        from = 1L;
        from_ = new BigInteger("1");
        below = 1000L;
        below_ = new BigInteger("1000");
        expResult = 233168L;
        expResult_ = new BigInteger("233168");
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of solution1(long a, long b, long below) method, of class Problem001.
     */
    @Test
    public void testSolution1_3args_1() {
        System.out.println("solution1(long a, long b, long below)");
        long result = instance.solution1(a, b, below);
        assertEquals(expResult, result);

        // Check MCM
        result = instance.solution1(10L, 14L, 100L);
        assertEquals(772L, result);
    }

    /**
     * Test of solution1(BigInteger a, BigInteger b, BigInteger below) method, of class Problem001.
     */
    @Test
    public void testSolution1_3args_2() {
        System.out.println("solution1(BigInteger a, BigInteger b, BigInteger below)");
        BigInteger result = instance.solution1(a_, b_, below_);
        assertEquals(expResult_, result);

        // Check MCM
        result = instance.solution1(new BigInteger("10"), new BigInteger("14"), new BigInteger("100"));
        assertEquals(new BigInteger("772"), result);
    }

    /**
     * Test of solution1(long a, long b, long from, long below) method, of class Problem001.
     */
    @Test
    public void testSolution1_4args_1() {
        System.out.println("solution1(long a, long b, long from, long below)");
        long result = instance.solution1(a, b, from, below);
        assertEquals(expResult, result);

        // Check MCM
        result = instance.solution1(10L, 14L, 1L, 100L);
        assertEquals(772L, result);

        // Check MCM and from
        result = instance.solution1(10L, 14L, 50L, 100L);
        assertEquals(588L, result);
    }

    /**
     * Test of solution1(BigInteger a, BigInteger b, BigInteger from, BigInteger below) method, of class Problem001.
     */
    @Test
    public void testSolution1_4args_2() {
        System.out.println("solution1(BigInteger a, BigInteger b, BigInteger from, BigInteger below)");
        BigInteger result = instance.solution1(a_, b_, from_, below_);
        assertEquals(expResult_, result);

        // Check MCM
        result = instance.solution1(new BigInteger("10"), new BigInteger("14"), 
                                    new BigInteger("1"), new BigInteger("100"));
        assertEquals(new BigInteger("772"), result);

        // Check MCM and from
        result = instance.solution1(new BigInteger("10"), new BigInteger("14"), 
                                    new BigInteger("50"), new BigInteger("100"));
        assertEquals(new BigInteger("588"), result);
    }

    /**
     * Test of solution2(long a, long b, long below) method, of class Problem001.
     */
    @Test
    public void testSolution2_3args_1() {
        System.out.println("solution2(long a, long b, long below)");
        long result = instance.solution2(a, b, below);
        assertEquals(expResult, result);

        // Check MCM
        result = instance.solution2(10L, 14L, 100L);
        assertEquals(772L, result);
    }

    /**
     * Test of solution2(BigInteger a, BigInteger b, BigInteger below) method, of class Problem001.
     */
    @Test
    public void testSolution2_3args_2() {
        System.out.println("solution2(BigInteger a, BigInteger b, BigInteger below)");
        BigInteger result = instance.solution2(a_, b_, below_);
        assertEquals(expResult_, result);

        // Check MCM
        result = instance.solution2(new BigInteger("10"), new BigInteger("14"), new BigInteger("100"));
        assertEquals(new BigInteger("772"), result);
    }

    /**
     * Test of solution2(long a, long b, long from, long below) method, of class Problem001.
     */
    @Test
    public void testSolution2_4args_1() {
        System.out.println("solution2(long a, long b, long from, long below)");
        long result = instance.solution2(a, b, from, below);
        assertEquals(expResult, result);

        // Check MCM
        result = instance.solution2(10L, 14L, 1L, 100L);
        assertEquals(772L, result);

        // Check MCM and from
        result = instance.solution2(10L, 14L, 50L, 100L);
        assertEquals(588L, result);
    }

    /**
     * Test of solution2(BigInteger a, BigInteger b, BigInteger from, BigInteger below) method, of class Problem001.
     */
    @Test
    public void testSolution2_4args_2() {
        System.out.println("solution2(BigInteger a, BigInteger b, BigInteger from, BigInteger below)");
        BigInteger result = instance.solution2(a_, b_, from_, below_);
        assertEquals(expResult_, result);

        // Check MCM
        result = instance.solution2(new BigInteger("10"), new BigInteger("14"), 
                                    new BigInteger("1"), new BigInteger("100"));
        assertEquals(new BigInteger("772"), result);

        // Check MCM and from
        result = instance.solution2(new BigInteger("10"), new BigInteger("14"), 
                                    new BigInteger("50"), new BigInteger("100"));
        assertEquals(new BigInteger("588"), result);
    }

    /**
     * Test of solution3(long a, long b, long below) method, of class Problem001.
     */
    @Test
    public void testSolution3_3args_1() {
        System.out.println("solution3(long a, long b, long below)");
        long result = instance.solution3(a, b, below);
        assertEquals(expResult, result);

        // Check MCM
        result = instance.solution3(10L, 14L, 100L);
        assertEquals(772L, result);
    }

    /**
     * Test of solution3(long a, long b, long from, long below) method, of class Problem001.
     */
    @Test
    public void testSolution3_4args_1() {
        System.out.println("solution3(long a, long b, long from, long below)");
        long result = instance.solution3(a, b, from, below);
        assertEquals(expResult, result);
        
        // Check MCM
        result = instance.solution3(10L, 14L, 1L, 100L);
        assertEquals(772L, result);

        // Check MCM and from
        result = instance.solution3(10L, 14L, 50L, 100L);
        assertEquals(588L, result);
    }

    /**
     * Test of solution3(BigInteger a, BigInteger b, BigInteger below) method, of class Problem001.
     */
    @Test
    public void testSolution3_3args_2() {
        System.out.println("solution3(BigInteger a, BigInteger b, BigInteger below)");
        BigInteger result = instance.solution3(a_, b_, below_);
        assertEquals(expResult_, result);

        // Check big value
        result = instance.solution3(a_, b_, new BigInteger("10000000000"));
        assertEquals(new BigInteger("23333333331666666668"), result);
        
        // Check MCM
        result = instance.solution3(new BigInteger("10"), new BigInteger("14"), new BigInteger("100"));
        assertEquals(new BigInteger("772"), result);
    }

    /**
     * Test of solution3(BigInteger a, BigInteger b, BigInteger from, BigInteger below) method, of class Problem001.
     */
    @Test
    public void testSolution3_4args_2() {
        System.out.println("solution3(BigInteger a, BigInteger b, BigInteger from, BigInteger below)");
        BigInteger result = instance.solution3(a_, b_, from_, below_);
        assertEquals(expResult_, result);

        // Check big value and from
        result = instance.solution3(a_, b_, new BigInteger("7000000000"), new BigInteger("10000000000"));
        assertEquals(new BigInteger("11899999999500000000"), result);
        
        // Check MCM
        result = instance.solution3(new BigInteger("10"), new BigInteger("14"), 
                                    new BigInteger("1"), new BigInteger("100"));
        assertEquals(new BigInteger("772"), result);

        // Check MCM and from
        result = instance.solution3(new BigInteger("10"), new BigInteger("14"), 
                                    new BigInteger("50"), new BigInteger("100"));
        assertEquals(new BigInteger("588"), result);
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
     * Test of solve(long a, long b, long below) method, of class Problem001.
     */
    @Test
    public void testSolve_3args_1() {
        System.out.println("solve(long a, long b, long below)");
        long result = instance.solve(a, b, below);
        assertEquals(expResult, result);

        // Check MCM
        result = instance.solve(10L, 14L, 100L);
        assertEquals(772L, result);
    }

    /**
     * Test of solve(long a, long b, long below, Algorithm algorithm) method, of class Problem001.
     */
    @Test
    public void testSolve_4args_1() {
        System.out.println("solve(long a, long b, long below, Algorithm algorithm)");
        for (Problem001.Algorithm algorithm : Problem001.Algorithm.values()) {
            long result = instance.solve(a, b, below, algorithm);
            assertEquals(expResult, result);

            // Check MCM
            result = instance.solve(10L, 14L, 100L, algorithm);
            assertEquals(772L, result);
        }
    }

    /**
     * Test of solve(long a, long b, long from, long below) method, of class Problem001.
     */
    @Test
    public void testSolve_4args_2() {
        System.out.println("solve(long a, long b, long from, long below)");
        long result = instance.solve(a, b, from, below);
        assertEquals(expResult, result);

        // Check MCM
        result = instance.solve(10L, 14L, 1L, 100L);
        assertEquals(772L, result);

        // Check MCM and from
        result = instance.solve(10L, 14L, 50L, 100L);
        assertEquals(588L, result);
    }

    /**
     * Test of solve(long a, long b, long from, long below, Algorithm algorithm) method, of class Problem001.
     */
    @Test
    public void testSolve_5args_1() {
        System.out.println("solve(long a, long b, long from, long below, Algorithm algorithm)");
        for (Problem001.Algorithm algorithm : Problem001.Algorithm.values()) {
            long result = instance.solve(a, b, from, below, algorithm);
            assertEquals(expResult, result);

            // Check MCM
            result = instance.solve(10L, 14L, 1L, 100L, algorithm);
            assertEquals(772L, result);

            // Check MCM and from
            result = instance.solve(10L, 14L, 50L, 100L, algorithm);
            assertEquals(588L, result);
        }
    }

    /**
     * Test of solve(BigInteger a, BigInteger b, BigInteger below) method, of class Problem001.
     */
    @Test
    public void testSolve_3args_2() {
        System.out.println("solve(BigInteger a, BigInteger b, BigInteger below)");
        BigInteger result = instance.solve(a_, b_, below_);
        assertEquals(expResult_, result);
        
        // Check big value
        result = instance.solve(a_, b_, new BigInteger("10000000000"));
        assertEquals(new BigInteger("23333333331666666668"), result);

        // Check MCM
        result = instance.solve(new BigInteger("10"), new BigInteger("14"), new BigInteger("100"));
        assertEquals(new BigInteger("772"), result);
    }

    /**
     * Test of solve(BigInteger a, BigInteger b, BigInteger below, Algorithm algorithm) method, of class Problem001.
     */
    @Test
    public void testSolve_4args_3() {
        System.out.println("solve(BigInteger a, BigInteger b, BigInteger below, Algorithm algorithm)");
        for (Problem001.Algorithm algorithm : Problem001.Algorithm.values()) {
            BigInteger result = instance.solve(a_, b_, below_, algorithm);
            assertEquals(expResult_, result);

            if (algorithm == Problem001.Algorithm.SOLUTION3) {
                // Check big value
                result = instance.solve(a_, b_, new BigInteger("10000000000"), algorithm);
                assertEquals(new BigInteger("23333333331666666668"), result);
            }
            
            // Check MCM
            result = instance.solve(new BigInteger("10"), new BigInteger("14"), 
                                    new BigInteger("100"), algorithm);
            assertEquals(new BigInteger("772"), result);
        }
    }

    /**
     * Test of solve(BigInteger a, BigInteger b, BigInteger from, BigInteger below) method, of class Problem001.
     */
    @Test
    public void testSolve_4args_4() {
        System.out.println("solve(BigInteger a, BigInteger b, BigInteger from, BigInteger below)");
        BigInteger result = instance.solve(a_, b_, from_, below_);
        assertEquals(expResult_, result);
        
        // Check big value and from
        result = instance.solve(a_, b_, new BigInteger("7000000000"), new BigInteger("10000000000"));
        assertEquals(new BigInteger("11899999999500000000"), result);

        // Check MCM
        result = instance.solve(new BigInteger("10"), new BigInteger("14"), 
                                new BigInteger("1"), new BigInteger("100"));
        assertEquals(new BigInteger("772"), result);
        
        // Check MCM and from
        result = instance.solve(new BigInteger("10"), new BigInteger("14"), 
                                new BigInteger("50"), new BigInteger("100"));
        assertEquals(new BigInteger("588"), result);
    }

    /**
     * Test of solve(BigInteger a, BigInteger b, BigInteger from, BigInteger below, Algorithm algorithm) method, of class Problem001.
     */
    @Test
    public void testSolve_5args_2() {
        System.out.println("solve(BigInteger a, BigInteger b, BigInteger from, BigInteger below, Algorithm algorithm)");
        for (Problem001.Algorithm algorithm : Problem001.Algorithm.values()) {
            BigInteger result = instance.solve(a_, b_, from_, below_, algorithm);
            assertEquals(expResult_, result);
            
            if (algorithm == Problem001.Algorithm.SOLUTION3) {
                // Check big value and from
                result = instance.solve(a_, b_, new BigInteger("7000000000"), new BigInteger("10000000000"), algorithm);
                assertEquals(new BigInteger("11899999999500000000"), result);
            }
            
            // Check MCM
            result = instance.solve(new BigInteger("10"), new BigInteger("14"), 
                                    new BigInteger("1"), new BigInteger("100"), algorithm);
            assertEquals(new BigInteger("772"), result);

            // Check MCM and from
            result = instance.solve(new BigInteger("10"), new BigInteger("14"), 
                                    new BigInteger("50"), new BigInteger("100"), algorithm);
            assertEquals(new BigInteger("588"), result);
        }
    }

    /**
     * Test of solve(ArrayList&lt;Long&gt; values, long from, long below) method, of class Problem001.
     */
    @Test
    public void testSolve_3args_3() {
        System.out.println("solve(ArrayList<Long> values, long from, long below)");
        ArrayList<Long> v = new ArrayList<>(Arrays.asList(a, b));
        long result = instance.solve(v, from, below);
        assertEquals(expResult, result);

        // Check MCM
        v = new ArrayList<>(Arrays.asList(10L, 14L));
        result = instance.solve(v, 1L, 100L);
        assertEquals(772L, result);

        // Check MCM and from
        result = instance.solve(v, 50L, 100L);
        assertEquals(588L, result);
    }

    /**
     * Test of solve(ArrayList&lt;Long&ht; values, long from, long below, Algorithm algorithm) method, of class Problem001.
     */
    @Test
    public void testSolve_4args_5() {
        System.out.println("solve(ArrayList<Long> values, long from, long below, Algorithm algorithm)");
        for (Problem001.Algorithm algorithm : Problem001.Algorithm.values()) {
            ArrayList<Long> v = new ArrayList<>(Arrays.asList(a, b));
            long result = instance.solve(v, from, below, algorithm);
            assertEquals(expResult, result);
            
            // Check MCM
            v = new ArrayList<>(Arrays.asList(10L, 14L));
            result = instance.solve(v, 1L, 100L, algorithm);
            assertEquals(772L, result);
            
            // Check MCM and from
            result = instance.solve(v, 50L, 100L, algorithm);
            assertEquals(588L, result);
        }        
    }

    /**
     * Test of solve(ArrayList&lt;BigInteger&gt; values, BigInteger from, BigInteger below) method, of class Problem001.
     */
    @Test
    public void testSolve_3args_4() {
        System.out.println("solve(ArrayList<BigInteger> values, BigInteger from, BigInteger below)");
        ArrayList<BigInteger> v = new ArrayList<>(Arrays.asList(a_, b_));
        BigInteger result = instance.solve(v, from_, below_);
        assertEquals(expResult_, result);
        
        // Check big value and from
        result = instance.solve(v, new BigInteger("7000000000"), new BigInteger("10000000000"));
        assertEquals(new BigInteger("11899999999500000000"), result);
                
        // Check MCM
        v = new ArrayList<>(Arrays.asList(new BigInteger("10"), new BigInteger("14")));
        result = instance.solve(v, new BigInteger("1"), new BigInteger("100"));
        assertEquals(new BigInteger("772"), result);
        
        // Check MCM and from
        result = instance.solve(v, new BigInteger("50"), new BigInteger("100"));
        assertEquals(new BigInteger("588"), result);
    }

    /**
     * Test of solve(ArrayList&lt;BigInteger&gt; values, BigInteger from, BigInteger below, Algorithm algorithm) method, of class Problem001.
     */
    @Test
    public void testSolve_4args_6() {
        System.out.println("solve(ArrayList<BigInteger> values, BigInteger from, BigInteger below, Algorithm algorithm)");
        for (Problem001.Algorithm algorithm : Problem001.Algorithm.values()) {
            ArrayList<BigInteger> v = new ArrayList<>(Arrays.asList(a_, b_));
            BigInteger result = instance.solve(v, from_, below_, algorithm);
            assertEquals(expResult_, result);
        
            if (algorithm == Problem001.Algorithm.SOLUTION3) {
                // Check big value and from
                result = instance.solve(v, new BigInteger("7000000000"), new BigInteger("10000000000"), algorithm);
                assertEquals(new BigInteger("11899999999500000000"), result);
            }
            
            // Check MCM
            v = new ArrayList<>(Arrays.asList(new BigInteger("10"), new BigInteger("14")));
            result = instance.solve(v, new BigInteger("1"), new BigInteger("100"), algorithm);
            assertEquals(new BigInteger("772"), result);
            
            // Check MCM and from
            result = instance.solve(v, new BigInteger("50"), new BigInteger("100"), algorithm);
            assertEquals(new BigInteger("588"), result);
        }
    }

    /**
     * Test of solve(Algorithm algorithm) method, of class Problem001.
     */
    @Test
    public void testSolve_Problem001Algorithm() {
        System.out.println("solve(Algorithm algorithm)");
        for (Problem001.Algorithm algorithm : Problem001.Algorithm.values()) {
            assertEquals(expResult, instance.solve(algorithm));
        }
    }
    
}
