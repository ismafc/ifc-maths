/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package raytracer;

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
     * Test of MCD method, of class IFCMath.
     */
    @Test
    public void testMCD() {
        System.out.println("MCD");
        long n1 = 0L;
        long n2 = 0L;
        long expResult = 0L;
        long result = IFCMath.MCD(n1, n2);
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
     * Test of MCM method, of class IFCMath.
     */
    @Test
    public void testMCM() {
        System.out.println("MCM");
        long n1 = 0L;
        long n2 = 0L;
        long expResult = 0L;
        long result = IFCMath.MCM(n1, n2);
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
     * Test of MCD method, of class IFCMath.
     */
    @Test
    public void testMCD_BigInteger_BigInteger() {
        System.out.println("MCD");
        BigInteger n1 = null;
        BigInteger n2 = null;
        BigInteger expResult = null;
        BigInteger result = IFCMath.MCD(n1, n2);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of MCD1 method, of class IFCMath.
     */
    @Test
    public void testMCD1() {
        System.out.println("MCD1");
        long n1 = 0L;
        long n2 = 0L;
        long expResult = 0L;
        long result = IFCMath.MCD1(n1, n2);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of MCD method, of class IFCMath.
     */
    @Test
    public void testMCD_long_long() {
        System.out.println("MCD");
        long n1 = 0L;
        long n2 = 0L;
        long expResult = 0L;
        long result = IFCMath.MCD(n1, n2);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of MCM method, of class IFCMath.
     */
    @Test
    public void testMCM_long_long() {
        System.out.println("MCM");
        long n1 = 0L;
        long n2 = 0L;
        long expResult = 0L;
        long result = IFCMath.MCM(n1, n2);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of MCM1 method, of class IFCMath.
     */
    @Test
    public void testMCM1() {
        System.out.println("MCM1");
        long n1 = 0L;
        long n2 = 0L;
        long expResult = 0L;
        long result = IFCMath.MCM1(n1, n2);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of MCM method, of class IFCMath.
     */
    @Test
    public void testMCM_BigInteger_BigInteger() {
        System.out.println("MCM");
        BigInteger n1 = null;
        BigInteger n2 = null;
        BigInteger expResult = null;
        BigInteger result = IFCMath.MCM(n1, n2);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of mod method, of class IFCMath.
     */
    @Test
    public void testMod_long_ArrayList() {
        System.out.println("mod");
        long i = 0L;
        ArrayList<Long> V = null;
        boolean expResult = false;
        boolean result = IFCMath.mod(i, V);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of mod method, of class IFCMath.
     */
    @Test
    public void testMod_BigInteger_ArrayList() {
        System.out.println("mod");
        BigInteger i = null;
        ArrayList<BigInteger> V = null;
        boolean expResult = false;
        boolean result = IFCMath.mod(i, V);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
