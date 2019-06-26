/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Library;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashMap;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import java.util.Arrays;

/**
 *
 * @author ismael.flores
 */
public class IFCMathIT {
    
    public IFCMathIT() {
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
     * Test of isPrime method, of class IFCMath.
     */
    @Test
    public void testIsPrime_long() {
        System.out.println("isPrime");
        long n = 0L;
        boolean expResult = false;
        boolean result = IFCMath.isPrime(n);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of isPrime method, of class IFCMath.
     */
    @Test
    public void testIsPrime_Long() {
        System.out.println("isPrime");
        Long n = null;
        boolean expResult = false;
        boolean result = IFCMath.isPrime(n);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of isSemiprime method, of class IFCMath.
     */
    @Test
    public void testIsSemiprime() {
        System.out.println("isSemiprime");
        long n = 0L;
        boolean expResult = false;
        boolean result = IFCMath.isSemiprime(n);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of divisors method, of class IFCMath.
     */
    @Test
    public void testDivisors() {
        System.out.println("divisors");
        long n = 0L;
        ArrayList<Long> expResult = null;
        ArrayList<Long> result = IFCMath.divisors(n);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of sqrt method, of class IFCMath.
     */
    @Test
    public void testSqrt() {
        System.out.println("sqrt");
        BigInteger n = null;
        BigInteger expResult = null;
        BigInteger result = IFCMath.sqrt(n);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of log method, of class IFCMath.
     */
    @Test
    public void testLog() {
        System.out.println("log");
        int base = 0;
        BigInteger x = null;
        int decimals = 0;
        BigDecimal expResult = null;
        BigDecimal result = IFCMath.log(base, x, decimals);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of primeFactors method, of class IFCMath.
     */
    @Test
    public void testPrimeFactors_long() {
        System.out.println("primeFactors");
        long n = 0L;
        ArrayList<Long> expResult = null;
        ArrayList<Long> result = IFCMath.primeFactors(n);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of primeFactors method, of class IFCMath.
     */
    @Test
    public void testPrimeFactors_BigInteger_BigInteger() {
        System.out.println("primeFactors");
        BigInteger n = null;
        BigInteger limit = null;
        ArrayList<BigInteger> expResult = null;
        ArrayList<BigInteger> result = IFCMath.primeFactors(n, limit);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of primeFactorization method, of class IFCMath.
     */
    @Test
    public void testPrimeFactorization_long() {
        System.out.println("primeFactorization");
        long n = 0L;
        HashMap<Long, Long> expResult = null;
        HashMap<Long, Long> result = IFCMath.primeFactorization(n);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of primeFactorization method, of class IFCMath.
     */
    @Test
    public void testPrimeFactorization_BigInteger() {
        System.out.println("primeFactorization");
        BigInteger n = null;
        HashMap<BigInteger, BigInteger> expResult = null;
        HashMap<BigInteger, BigInteger> result = IFCMath.primeFactorization(n);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of lpow method, of class IFCMath.
     */
    @Test
    public void testLpow() {
        System.out.println("lpow");
        long n = 0L;
        long e = 0L;
        long expResult = 0L;
        long result = IFCMath.lpow(n, e);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getNewPascalRow method, of class IFCMath.
     */
    @Test
    public void testGetNewPascalRow() {
        System.out.println("getNewPascalRow");
        ArrayList<Long> pascalRow = null;
        ArrayList<Long> expResult = null;
        ArrayList<Long> result = IFCMath.getNewPascalRow(pascalRow);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of totient method, of class IFCMath.
     */
    @Test
    public void testTotient() {
        System.out.println("totient");
        long n = 0L;
        long expResult = 0L;
        long result = IFCMath.totient(n);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of factorial method, of class IFCMath.
     */
    @Test
    public void testFactorial_long() {
        System.out.println("factorial");
        long n = 0L;
        long expResult = 0L;
        long result = IFCMath.factorial(n);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of factorial method, of class IFCMath.
     */
    @Test
    public void testFactorial_BigInteger() {
        System.out.println("factorial");
        BigInteger n = null;
        BigInteger expResult = null;
        BigInteger result = IFCMath.factorial(n);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of isPerfectSquare method, of class IFCMath.
     */
    @Test
    public void testIsPerfectSquare_long() {
        System.out.println("isPerfectSquare");
        long n = 0L;
        boolean expResult = false;
        boolean result = IFCMath.isPerfectSquare(n);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of isPerfectSquare method, of class IFCMath.
     */
    @Test
    public void testIsPerfectSquare_BigInteger() {
        System.out.println("isPerfectSquare");
        BigInteger n = null;
        boolean expResult = false;
        boolean result = IFCMath.isPerfectSquare(n);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of binomial method, of class IFCMath.
     */
    @Test
    public void testBinomial_long_long() {
        System.out.println("binomial");
        long x = 0L;
        long k = 0L;
        long expResult = 0L;
        long result = IFCMath.binomial(x, k);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of binomial method, of class IFCMath.
     */
    @Test
    public void testBinomial_BigInteger_BigInteger() {
        System.out.println("binomial");
        BigInteger x = null;
        BigInteger k = null;
        BigInteger expResult = null;
        BigInteger result = IFCMath.binomial(x, k);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of mandelbrot method, of class IFCMath.
     */
    @Test
    public void testMandelbrot() {
        System.out.println("mandelbrot");
        Complex i = null;
        Complex c = null;
        long steps = 0L;
        Complex expResult = null;
        Complex result = IFCMath.mandelbrot(i, c, steps);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of isMandelbrot method, of class IFCMath.
     */
    @Test
    public void testIsMandelbrot() {
        System.out.println("isMandelbrot");
        Complex i = null;
        Complex c = null;
        int maxSteps = 0;
        int expResult = 0;
        int result = IFCMath.isMandelbrot(i, c, maxSteps);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of max_sum_adjacent_numbers method, of class IFCMath.
     */
    @Test
    public void testMax_sum_adjacent_numbers() {
        System.out.println("max_sum_adjacent_numbers");
        long[] numbers = null;
        long expResult = 0L;
        long result = IFCMath.max_sum_adjacent_numbers(numbers);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of mcd(BigInteger a, BigInteger b) method, of class IFCMath.
     */
    @Test
    public void testMcd_BigInteger_BigInteger() {
        System.out.println("mcd(BigInteger a, BigInteger b)");
        BigInteger a = new BigInteger("10");
        BigInteger b = new BigInteger("14");
        BigInteger expResult = new BigInteger("2");
        BigInteger result = IFCMath.mcd(a, b);
        assertEquals(expResult, result);
        result = IFCMath.mcd(b, a);
        assertEquals(expResult, result);
        
        a = new BigInteger("14334219929839828974721");
        b = new BigInteger("10837403928334113411");
        expResult = new BigInteger("17");
        result = IFCMath.mcd(a, b);
        assertEquals(expResult, result);
        result = IFCMath.mcd(b, a);
        assertEquals(expResult, result);
    }

    /**
     * Test of mcd(long a, long b) method, of class IFCMath.
     */
    @Test
    public void testMcd_long_long() {
        System.out.println("mcd(long a, long b)");
        long a = 10L;
        long b = 14L;
        long expResult = 2L;
        long result = IFCMath.mcd(a, b);
        assertEquals(expResult, result);
        result = IFCMath.mcd(b, a);
        assertEquals(expResult, result);
    }

    /**
     * Test of mcm(long a, long b) method, of class IFCMath.
     */
    @Test
    public void testMcm_long_long() {
        System.out.println("mcm(long a, long b)");
        long a = 10L;
        long b = 14L;
        long expResult = 70L;
        long result = IFCMath.mcm(a, b);
        assertEquals(expResult, result);
        result = IFCMath.mcm(b, a);
        assertEquals(expResult, result);
    }

    /**
     * Test of mcm(BigInteger a, BigInteger b) method, of class IFCMath.
     */
    @Test
    public void testMcm_BigInteger_BigInteger() {
        System.out.println("mcm(BigInteger a, BigInteger b)");
        BigInteger a = new BigInteger("10");
        BigInteger b = new BigInteger("14");
        BigInteger expResult = new BigInteger("70");
        BigInteger result = IFCMath.mcm(a, b);
        assertEquals(expResult, result);
        result = IFCMath.mcm(b, a);
        assertEquals(expResult, result);
        
        a = new BigInteger("143342199298398289747");
        b = new BigInteger("10837403928334");
        expResult = new BigInteger("1553457313772496763978284954991498");
        result = IFCMath.mcm(a, b);
        assertEquals(expResult, result);
    }

    /**
     * Test of mod(long i, ArrayList<Long> values) method, of class IFCMath.
     */
    @Test
    public void testMod_long_ArrayList() {
        System.out.println("mod(long i, ArrayList<Long> values)");
        long i = 162921213L; // 3^4 * 7 * 13 * 23 * 31^2
        ArrayList<Long> V = new ArrayList<>(Arrays.asList(2L, 5L, 11L, 17L));
        boolean expResult = false;
        boolean result = IFCMath.mod(i, V);
        assertEquals(expResult, result);

        V = new ArrayList<>(Arrays.asList(2L, 5L, 7L, 11L, 17L, 31L));
        expResult = true;
        result = IFCMath.mod(i, V);
        assertEquals(expResult, result);
    }

    /**
     * Test of mod(BigInteger i, ArrayList<BigInteger> values) method, of class IFCMath.
     */
    @Test
    public void testMod_BigInteger_ArrayList() {
        System.out.println("mod(BigInteger i, ArrayList<BigInteger> values)");
        BigInteger i = new BigInteger("162921213"); // 3^4 * 7 * 13 * 23 * 31^2
        ArrayList<BigInteger> V = new ArrayList<>(Arrays.asList(new BigInteger("2"), 
                new BigInteger("5"), new BigInteger("11"), new BigInteger("17")));
        boolean expResult = false;
        boolean result = IFCMath.mod(i, V);
        assertEquals(expResult, result);

        V = new ArrayList<>(Arrays.asList(new BigInteger("2"), new BigInteger("5"), 
                new BigInteger("7"), new BigInteger("11"), 
                new BigInteger("17"), new BigInteger("31")));
        expResult = true;
        result = IFCMath.mod(i, V);
        assertEquals(expResult, result);
    }

    /**
     * Test of mcd_recursive(BigInteger a, BigInteger b) method, of class IFCMath.
     */
    @Test
    public void testMcd_recursive_BigInteger_BigInteger() {
        System.out.println("mcd_recursive(BigInteger a, BigInteger b)");
        BigInteger a = new BigInteger("10");
        BigInteger b = new BigInteger("14");
        BigInteger expResult = new BigInteger("2");
        BigInteger result = IFCMath.mcd_recursive(a, b);
        assertEquals(expResult, result);
        
        a = new BigInteger("14334219929839828974721");
        b = new BigInteger("10837403928334113411");
        expResult = new BigInteger("17");
        result = IFCMath.mcd(a, b);
        assertEquals(expResult, result);
    }

    /**
     * Test of mcd_recursive(long a, long b) method, of class IFCMath.
     */
    @Test
    public void testMcd_recursive_long_long() {
        System.out.println("mcd_recursive(long a, long b)");
        long a = 10L;
        long b = 14L;
        long expResult = 2L;
        long result = IFCMath.mcd_recursive(a, b);
        assertEquals(expResult, result);
    }

    /**
     * Test of mcm_recursive(long a, long b) method, of class IFCMath.
     */
    @Test
    public void testMcm_recursive_long_long() {
        System.out.println("mcm_recursive(long a, long b)");
        long a = 10L;
        long b = 14L;
        long expResult = 70L;
        long result = IFCMath.mcm_recursive(a, b);
        assertEquals(expResult, result);
        result = IFCMath.mcm_recursive(b, a);
        assertEquals(expResult, result);
    }

    /**
     * Test of mcm_recursive(BigInteger a, BigInteger b) method, of class IFCMath.
     */
    @Test
    public void testMcm_recursive_BigInteger_BigInteger() {
        System.out.println("mcm_recursive(BigInteger a, BigInteger b)");
        BigInteger a = new BigInteger("10");
        BigInteger b = new BigInteger("14");
        BigInteger expResult = new BigInteger("70");
        BigInteger result = IFCMath.mcm_recursive(a, b);
        assertEquals(expResult, result);
        result = IFCMath.mcm_recursive(b, a);
        assertEquals(expResult, result);

        a = new BigInteger("143342199298398289747");
        b = new BigInteger("10837403928334");
        expResult = new BigInteger("1553457313772496763978284954991498");
        result = IFCMath.mcm(a, b);
        assertEquals(expResult, result);
    }
    
}
