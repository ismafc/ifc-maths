/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package raytracer;

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
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of set method, of class Complex.
     */
    @Test
    public void testSet() {
        System.out.println("set");
        double real = 5.0;
        double imag = 6.0;
        Complex instance = new Complex();
        instance.set(real, imag);
        assertTrue(instance.re() == 5.0 && instance.im() == 6.0);
    }

    /**
     * Test of equals method, of class Complex.
     */
    @Test
    public void testEquals() {
        System.out.println("equals");
        Object c1 = null;
        Complex instance = new Complex();
        boolean result = instance.equals(c1);
        assertFalse(result);
        result = instance.equals(instance);
        assertTrue(result);
        Complex c2 = new Complex(5.0, 6.0);
        result = instance.equals(c2);
        assertFalse(result);
        instance.set(5.0, 6.0);
        result = instance.equals(c2);
        assertTrue(result);
    }

    /**
     * Test of hashCode method, of class Complex.
     */
    @Test
    public void testHashCode() {
        System.out.println("hashCode");
        Complex instance = new Complex(5.0, 6.0);
        Complex instance1 = new Complex(5.0, 6.0);
        int expResult = instance1.hashCode();
        int result = instance.hashCode();
        assertEquals(expResult, result);
        instance1.set(5.0, 6.1);
        expResult = instance1.hashCode();
        assertTrue(expResult != result);
        instance1.set(4.9, 6.0);
        expResult = instance1.hashCode();
        assertTrue(expResult != result);
    }

    /**
     * Test of toString method, of class Complex.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        Complex instance = new Complex(5.0, 6.0);
        String result = instance.toString();
        assertEquals("5.0 + 6.0i", result);
        instance.set(0.0, 2.1);
        result = instance.toString();
        assertEquals("2.1i", result);
        instance.set(5, 0.0);
        result = instance.toString();
        assertEquals("5.0", result);
        instance.set(3.1, -2);
        result = instance.toString();
        assertEquals("3.1 - 2.0i", result);
    }

    /**
     * Test of abs method, of class Complex.
     */
    @Test
    public void testAbs() {
        System.out.println("abs");
        Complex instance = new Complex();
        double expResult = 0.0;
        double result = instance.abs();
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of phase method, of class Complex.
     */
    @Test
    public void testPhase() {
        System.out.println("phase");
        Complex instance = new Complex();
        double expResult = 0.0;
        double result = instance.phase();
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of add method, of class Complex.
     */
    @Test
    public void testAdd_Complex() {
        System.out.println("add");
        Complex b = null;
        Complex instance = new Complex();
        Complex expResult = null;
        Complex result = instance.add(b);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of subtract method, of class Complex.
     */
    @Test
    public void testSubtract_Complex() {
        System.out.println("subtract");
        Complex b = null;
        Complex instance = new Complex();
        Complex expResult = null;
        Complex result = instance.subtract(b);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of multiply method, of class Complex.
     */
    @Test
    public void testMultiply_Complex() {
        System.out.println("multiply");
        Complex b = null;
        Complex instance = new Complex();
        Complex expResult = null;
        Complex result = instance.multiply(b);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of multiply method, of class Complex.
     */
    @Test
    public void testMultiply_double() {
        System.out.println("multiply");
        double alpha = 0.0;
        Complex instance = new Complex();
        Complex expResult = null;
        Complex result = instance.multiply(alpha);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of conjugate method, of class Complex.
     */
    @Test
    public void testConjugate() {
        System.out.println("conjugate");
        Complex instance = new Complex();
        Complex expResult = null;
        Complex result = instance.conjugate();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of reciprocal method, of class Complex.
     */
    @Test
    public void testReciprocal_0args() {
        System.out.println("reciprocal");
        Complex instance = new Complex();
        Complex expResult = null;
        Complex result = instance.reciprocal();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of re method, of class Complex.
     */
    @Test
    public void testRe() {
        System.out.println("re");
        Complex instance = new Complex();
        double expResult = 0.0;
        double result = instance.re();
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of im method, of class Complex.
     */
    @Test
    public void testIm() {
        System.out.println("im");
        Complex instance = new Complex();
        double expResult = 0.0;
        double result = instance.im();
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of divide method, of class Complex.
     */
    @Test
    public void testDivide_Complex() {
        System.out.println("divide");
        Complex b = null;
        Complex instance = new Complex();
        Complex expResult = null;
        Complex result = instance.divide(b);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of add method, of class Complex.
     */
    @Test
    public void testAdd_Complex_Complex() {
        System.out.println("add");
        Complex a = null;
        Complex b = null;
        Complex expResult = null;
        Complex result = Complex.add(a, b);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of subtract method, of class Complex.
     */
    @Test
    public void testSubtract_Complex_Complex() {
        System.out.println("subtract");
        Complex a = null;
        Complex b = null;
        Complex expResult = null;
        Complex result = Complex.subtract(a, b);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of multiply method, of class Complex.
     */
    @Test
    public void testMultiply_Complex_Complex() {
        System.out.println("multiply");
        Complex a = null;
        Complex b = null;
        Complex expResult = null;
        Complex result = Complex.multiply(a, b);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of multiply method, of class Complex.
     */
    @Test
    public void testMultiply_Complex_double() {
        System.out.println("multiply");
        Complex a = null;
        double alpha = 0.0;
        Complex expResult = null;
        Complex result = Complex.multiply(a, alpha);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of reciprocal method, of class Complex.
     */
    @Test
    public void testReciprocal_Complex() {
        System.out.println("reciprocal");
        Complex a = null;
        Complex expResult = null;
        Complex result = Complex.reciprocal(a);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of divide method, of class Complex.
     */
    @Test
    public void testDivide_Complex_Complex() {
        System.out.println("divide");
        Complex a = null;
        Complex b = null;
        Complex expResult = null;
        Complex result = Complex.divide(a, b);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
