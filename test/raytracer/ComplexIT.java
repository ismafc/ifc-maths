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
    
    private Complex instance1;
    private Complex instance2;
    
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
        instance2.set(3.0, 4.0);
        assertTrue(instance2.re() == 3.0 && instance2.im() == 4.0);
    }

    /**
     * Test of equals method, of class Complex.
     */
    @Test
    public void testEquals() {
        System.out.println("equals");
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
        System.out.println("add");
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
        System.out.println("subtract");
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
