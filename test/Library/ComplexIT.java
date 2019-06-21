/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package raytracer;

import Library.Complex;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Isma
 */
public class ComplexIT {
    
    private Complex instance1;
    private Complex instance2;
    private Complex zero;
    private Complex one;
    private Complex i;
    
    public ComplexIT() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        instance1 = new Complex(5.0, 6.0);
        instance2 = new Complex(-1.0, -2.0);
        zero = new Complex(0.0, 0.0);
        one = new Complex(1.0, 0.0);
        i = new Complex(0.0, 1.0);
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of set method, of class Complex.
     */
    @Test
    public void testSet() {
        System.out.println("set(double, double)");
        instance2.set(3.0, 4.0);
        assertTrue(instance2.re() == 3.0 && instance2.im() == 4.0);
    }

    /**
     * Test of equals method, of class Complex.
     */
    @Test
    public void testEquals() {
        System.out.println("equals(Complex)");
        Object c1 = null;
        boolean result = instance1.equals(c1);
        assertFalse(result);
        result = instance1.equals(instance1);
        assertTrue(result);
        result = instance1.equals(instance2);
        assertFalse(result);
        instance2.set(5.0, 6.0);
        result = instance1.equals(instance2);
        assertTrue(result);
    }

    /**
     * Test of hashCode method, of class Complex.
     */
    @Test
    public void testHashCode() {
        System.out.println("hashCode");
        int expResult = instance1.hashCode();
        instance2.set(5.0, 6.0);
        int result = instance2.hashCode();
        assertEquals(expResult, result);
        instance2.set(5.0, 6.1);
        expResult = instance2.hashCode();
        assertTrue(expResult != result);
        instance2.set(4.9, 6.0);
        expResult = instance2.hashCode();
        assertTrue(expResult != result);
    }

    /**
     * Test of toString method, of class Complex.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        String result = instance1.toString();
        assertEquals("5.0 + 6.0i", result);
        instance1.set(0.0, 2.1);
        result = instance1.toString();
        assertEquals("2.1i", result);
        instance1.set(5, 0.0);
        result = instance1.toString();
        assertEquals("5.0", result);
        instance1.set(3.1, -2);
        result = instance1.toString();
        assertEquals("3.1 - 2.0i", result);
    }

    /**
     * Test of abs method, of class Complex.
     */
    @Test
    public void testAbs() {
        System.out.println("abs");
        double expResult = 7.810249675906654;
        double result = instance1.abs();
        assertEquals(expResult, result, 0.0);
        result = instance2.abs();
        expResult = 2.23606797749979;
        assertEquals(expResult, result, 0.0);
    }

    /**
     * Test of phase method, of class Complex.
     */
    @Test
    public void testPhase() {
        System.out.println("phase");
        double expResult = 0.8760580505981934;
        double result = instance1.phase();
        assertEquals(expResult, result, 0.0);
        result = instance2.phase();
        expResult = -2.0344439357957027;
        assertEquals(expResult, result, 0.0);
    }

    /**
     * Test of add method, of class Complex.
     */
    @Test
    public void testAdd_Complex() {
        System.out.println("add(Complex)");
        Complex expResult = new Complex(4.0, 4.0);
        Complex result = instance1.add(instance2);
        assertEquals(expResult, result);
        result = instance2.add(instance1);
        assertEquals(expResult, result);
    }

    /**
     * Test of subtract method, of class Complex.
     */
    @Test
    public void testSubtract_Complex() {
        System.out.println("subtract(Complex)");
        Complex expResult = new Complex(6.0, 8.0);
        Complex result = instance1.subtract(instance2);
        assertEquals(expResult, result);
        expResult = new Complex(-6.0, -8.0);
        result = instance2.subtract(instance1);
        assertEquals(expResult, result);
    }

    /**
     * Test of multiply method, of class Complex.
     */
    @Test
    public void testMultiply_Complex() {
        System.out.println("multiply(Complex)");
        Complex expResult = new Complex(7.0, -16.0);
        Complex result = instance1.multiply(instance2);
        assertEquals(expResult, result);
        result = instance2.multiply(instance1);
        assertEquals(expResult, result);
        assertEquals(one, instance1.multiply(instance1.reciprocal()));
        assertEquals(one, instance2.multiply(instance2.reciprocal()));
    }

    /**
     * Test of multiply method, of class Complex.
     */
    @Test
    public void testMultiply_double() {
        System.out.println("multiply(double)");
        Complex result = instance1.multiply(-1.0);
        Complex expResult = new Complex(-5.0, -6.0);
        assertEquals(expResult, result);
        result = instance2.multiply(0.0);
        assertEquals(zero, result);
    }

    /**
     * Test of conjugate method, of class Complex.
     */
    @Test
    public void testConjugate() {
        System.out.println("conjugate");
        Complex expResult = new Complex(5.0, -6.0);
        Complex result = instance1.conjugate();
        assertEquals(expResult, result);
        expResult = new Complex(61.0, 0.0);
        result = instance1.multiply(result);
        assertEquals(expResult, result);
        expResult = new Complex(-1.0, 2.0);
        result = instance2.conjugate();
        assertEquals(expResult, result);
        expResult = new Complex(5.0, 0.0);
        result = instance2.multiply(result);
        assertEquals(expResult, result);
    }

    /**
     * Test of reciprocal method, of class Complex.
     */
    @Test
    public void testReciprocal_0args() {
        System.out.println("reciprocal");
        Complex expResult = new Complex(5.0 / (5.0 * 5.0 + 6.0 * 6.0), - 6.0 / (5.0 * 5.0 + 6.0 * 6.0));
        Complex result = instance1.reciprocal();
        assertEquals(expResult, result);
        result = instance1.multiply(result);
        assertEquals(one, result);
        expResult = new Complex(-1.0 / (-1.0 * -1.0 + -2.0 * -2.0), - (-2.0) / (-1.0 * -1.0 + -2.0 * -2.0));
        result = instance2.reciprocal();
        assertEquals(expResult, result);
        result = instance2.multiply(result);
        assertEquals(one, result);
        assertNull(zero.reciprocal());
    }

    /**
     * Test of isReal method, of class Complex.
     */
    @Test
    public void testIsReal() {
        System.out.println("isReal");
        assertEquals(false, instance1.isReal());
        assertEquals(false, instance2.isReal());
        assertEquals(true, one.isReal());
        assertEquals(true, zero.isReal());
        assertEquals(false, i.isReal());
        assertEquals(true, instance1.reciprocal().multiply(instance1).isReal());
        assertEquals(true, instance2.reciprocal().multiply(instance2).isReal());
    }

    /**
     * Test of isImaginary method, of class Complex.
     */
    @Test
    public void testIsImaginary() {
        System.out.println("isImaginary");
        assertEquals(false, instance1.isImaginary());
        assertEquals(false, instance2.isImaginary());
        assertEquals(false, one.isImaginary());
        assertEquals(true, zero.isImaginary());
        assertEquals(true, i.isImaginary());
    }
    
    /**
     * Test of re method, of class Complex.
     */
    @Test
    public void testRe() {
        System.out.println("re");
        assertEquals(5.0, instance1.re(), 0.0);
        assertEquals(-1.0, instance2.re(), 0.0);
    }

    /**
     * Test of im method, of class Complex.
     */
    @Test
    public void testIm() {
        System.out.println("im");
        assertEquals(6.0, instance1.im(), 0.0);
        assertEquals(-2.0, instance2.im(), 0.0);
    }

    /**
     * Test of divide method, of class Complex.
     */
    @Test
    public void testDivide_Complex() {
        System.out.println("divide(Complex)");
        Complex result = instance1.divide(instance2);
        assertEquals(-17.0 / 5.0, result.re(), 0.0000001);
        assertEquals(4.0 / 5.0, result.im(), 0.0000001);
        result = instance2.divide(instance1);
        assertEquals(-17.0 / 61.0, result.re(), 0.0000001);
        assertEquals(-4.0 / 61.0, result.im(), 0.0000001);
        assertNull(instance1.divide(zero));
    }

    /**
     * Test of add method, of class Complex.
     */
    @Test
    public void testAdd_Complex_Complex() {
        System.out.println("add(Complex,Complex)");
        Complex expResult = new Complex(4.0, 4.0);
        assertEquals(expResult, Complex.add(instance1, instance2));
        assertEquals(expResult, Complex.add(instance2, instance1));
        assertEquals(instance1, Complex.add(instance1, zero));
    }

    /**
     * Test of subtract method, of class Complex.
     */
    @Test
    public void testSubtract_Complex_Complex() {
        System.out.println("subtract(Complex,Complex)");
        Complex expResult = new Complex(6.0, 8.0);
        assertEquals(expResult, Complex.subtract(instance1, instance2));
        expResult = new Complex(-6.0, -8.0);
        assertEquals(expResult, Complex.subtract(instance2, instance1));
        assertEquals(instance1, Complex.subtract(instance1, zero));
    }

    /**
     * Test of multiply method, of class Complex.
     */
    @Test
    public void testMultiply_Complex_Complex() {
        System.out.println("multiply(Complex,Complex)");
        Complex expResult = new Complex(7.0, -16.0);
        assertEquals(expResult, Complex.multiply(instance1, instance2));
        assertEquals(expResult, Complex.multiply(instance2, instance1));
        assertEquals(one, Complex.multiply(instance1, instance1.reciprocal()));
        assertEquals(one, Complex.multiply(instance2, instance2.reciprocal()));
    }

    /**
     * Test of multiply method, of class Complex.
     */
    @Test
    public void testMultiply_Complex_double() {
        System.out.println("multiply(Complex,double)");
        Complex result = Complex.multiply(instance1, -1.0);
        Complex expResult = new Complex(-5.0, -6.0);
        assertEquals(expResult, result);
        result = Complex.multiply(instance2, 0.0);
        assertEquals(zero, result);
    }

    /**
     * Test of reciprocal method, of class Complex.
     */
    @Test
    public void testReciprocal_Complex() {
        System.out.println("reciprocal(Complex)");
        Complex expResult = new Complex(5.0 / (5.0 * 5.0 + 6.0 * 6.0), - 6.0 / (5.0 * 5.0 + 6.0 * 6.0));
        assertEquals(expResult, Complex.reciprocal(instance1));
        assertEquals(one, Complex.multiply(instance1, Complex.reciprocal(instance1)));
        expResult = new Complex(-1.0 / (-1.0 * -1.0 + -2.0 * -2.0), - (-2.0) / (-1.0 * -1.0 + -2.0 * -2.0));
        assertEquals(expResult, Complex.reciprocal(instance2));
        assertEquals(one, Complex.multiply(instance2, Complex.reciprocal(instance2)));
        assertNull(zero.reciprocal());
    }

    /**
     * Test of divide method, of class Complex.
     */
    @Test
    public void testDivide_Complex_Complex() {
        System.out.println("divide(Complex,Complex)");
        Complex result = Complex.divide(instance1, instance2);
        assertEquals(-17.0 / 5.0, result.re(), 0.0000001);
        assertEquals(4.0 / 5.0, result.im(), 0.0000001);
        result = Complex.divide(instance2, instance1);
        assertEquals(-17.0 / 61.0, result.re(), 0.0000001);
        assertEquals(-4.0 / 61.0, result.im(), 0.0000001);
        assertNull(Complex.divide(instance1, zero));
    }
    
}
