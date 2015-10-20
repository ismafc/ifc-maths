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
 * @author ismael.flores
 */
public class Object3DIT {
    
    public Object3DIT() {
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
     * Test of set method, of class Object3D.
     */
    @Test
    public void testSet_3args() {
        System.out.println("set");
        double nx = 0.0;
        double ny = 0.0;
        double nz = 0.0;
        Object3D instance = new Object3D();
        instance.set(nx, ny, nz);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of set method, of class Object3D.
     */
    @Test
    public void testSet_Object3D() {
        System.out.println("set");
        Object3D o = null;
        Object3D instance = new Object3D();
        boolean expResult = false;
        boolean result = instance.set(o);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of set method, of class Object3D.
     */
    @Test
    public void testSet_doubleArr() {
        System.out.println("set");
        double[] c = null;
        Object3D instance = new Object3D();
        boolean expResult = false;
        boolean result = instance.set(c);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setX method, of class Object3D.
     */
    @Test
    public void testSetX() {
        System.out.println("setX");
        double nx = 0.0;
        Object3D instance = new Object3D();
        instance.setX(nx);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getX method, of class Object3D.
     */
    @Test
    public void testGetX() {
        System.out.println("getX");
        Object3D instance = new Object3D();
        double expResult = 0.0;
        double result = instance.getX();
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setY method, of class Object3D.
     */
    @Test
    public void testSetY() {
        System.out.println("setY");
        double ny = 0.0;
        Object3D instance = new Object3D();
        instance.setY(ny);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getY method, of class Object3D.
     */
    @Test
    public void testGetY() {
        System.out.println("getY");
        Object3D instance = new Object3D();
        double expResult = 0.0;
        double result = instance.getY();
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setZ method, of class Object3D.
     */
    @Test
    public void testSetZ() {
        System.out.println("setZ");
        double nz = 0.0;
        Object3D instance = new Object3D();
        instance.setZ(nz);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getZ method, of class Object3D.
     */
    @Test
    public void testGetZ() {
        System.out.println("getZ");
        Object3D instance = new Object3D();
        double expResult = 0.0;
        double result = instance.getZ();
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of get method, of class Object3D.
     */
    @Test
    public void testGet() {
        System.out.println("get");
        double[] c = null;
        Object3D instance = new Object3D();
        boolean expResult = false;
        boolean result = instance.get(c);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of add method, of class Object3D.
     */
    @Test
    public void testAdd_Object3D() {
        System.out.println("add");
        Object3D o = null;
        Object3D instance = new Object3D();
        boolean expResult = false;
        Object3D result = instance.add(o);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of sub method, of class Object3D.
     */
    @Test
    public void testSub_Object3D() {
        System.out.println("sub");
        Object3D o = null;
        Object3D instance = new Object3D();
        boolean expResult = false;
        Object3D result = instance.sub(o);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of div method, of class Object3D.
     */
    @Test
    public void testDiv_double() {
        System.out.println("div");
        double d = 0.0;
        Object3D instance = new Object3D();
        boolean expResult = false;
        Object3D result = instance.div(d);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of div method, of class Object3D.
     */
    @Test
    public void testDiv_Object3D() {
        System.out.println("div");
        Object3D o = null;
        Object3D instance = new Object3D();
        boolean expResult = false;
        Object3D result = instance.div(o);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of mul method, of class Object3D.
     */
    @Test
    public void testMul_double() {
        System.out.println("mul");
        double d = 0.0;
        Object3D instance = new Object3D();
        instance.mul(d);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of mul method, of class Object3D.
     */
    @Test
    public void testMul_Object3D() {
        System.out.println("mul");
        Object3D o = null;
        Object3D instance = new Object3D();
        boolean expResult = false;
        Object3D result = instance.mul(o);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of add method, of class Object3D.
     */
    @Test
    public void testAdd_3args() {
        System.out.println("add");
        double nx = 0.0;
        double ny = 0.0;
        double nz = 0.0;
        Object3D instance = new Object3D();
        instance.add(nx, ny, nz);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of sub method, of class Object3D.
     */
    @Test
    public void testSub_3args() {
        System.out.println("sub");
        double nx = 0.0;
        double ny = 0.0;
        double nz = 0.0;
        Object3D instance = new Object3D();
        instance.sub(nx, ny, nz);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of mul method, of class Object3D.
     */
    @Test
    public void testMul_3args() {
        System.out.println("mul");
        double nx = 0.0;
        double ny = 0.0;
        double nz = 0.0;
        Object3D instance = new Object3D();
        instance.mul(nx, ny, nz);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of div method, of class Object3D.
     */
    @Test
    public void testDiv_3args() {
        System.out.println("div");
        double nx = 0.0;
        double ny = 0.0;
        double nz = 0.0;
        Object3D instance = new Object3D();
        boolean expResult = false;
        Object3D result = instance.div(nx, ny, nz);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of add method, of class Object3D.
     */
    @Test
    public void testAdd_doubleArr() {
        System.out.println("add");
        double[] c = null;
        Object3D instance = new Object3D();
        boolean expResult = false;
        Object3D result = instance.add(c);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of isNull method, of class Object3D.
     */
    @Test
    public void testIsNull_0args() {
        System.out.println("isNull");
        Object3D instance = new Object3D();
        boolean expResult = false;
        boolean result = instance.isNull();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of isNull method, of class Object3D.
     */
    @Test
    public void testIsNull_double() {
        System.out.println("isNull");
        double epsilon = 0.0;
        Object3D instance = new Object3D();
        boolean expResult = false;
        boolean result = instance.isNull(epsilon);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of isInvalid method, of class Object3D.
     */
    @Test
    public void testIsInvalid() {
        System.out.println("isInvalid");
        Object3D instance = new Object3D();
        boolean expResult = false;
        boolean result = instance.isInvalid();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of invalidate method, of class Object3D.
     */
    @Test
    public void testInvalidate() {
        System.out.println("invalidate");
        Object3D instance = new Object3D();
        instance.invalidate();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of equals method, of class Object3D.
     */
    @Test
    public void testEquals_Object() {
        System.out.println("equals");
        Object o = null;
        Object3D instance = new Object3D();
        boolean expResult = false;
        boolean result = instance.equals(o);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of hashCode method, of class Object3D.
     */
    @Test
    public void testHashCode() {
        System.out.println("hashCode");
        Object3D instance = new Object3D();
        int expResult = 0;
        int result = instance.hashCode();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of equals method, of class Object3D.
     */
    @Test
    public void testEquals_Object3D_double() {
        System.out.println("equals");
        Object3D o = null;
        double epsilon = 0.0;
        Object3D instance = new Object3D();
        boolean expResult = false;
        boolean result = instance.equals(o, epsilon);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of toString method, of class Object3D.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        Object3D instance = new Object3D();
        String expResult = "";
        String result = instance.toString();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of lengthSquared method, of class Object3D.
     */
    @Test
    public void testLengthSquared() {
        System.out.println("lengthSquared");
        Object3D instance = new Object3D();
        double expResult = 0.0;
        double result = instance.lengthSquared();
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of length method, of class Object3D.
     */
    @Test
    public void testLength_0args() {
        System.out.println("length");
        Object3D instance = new Object3D();
        double expResult = 0.0;
        double result = instance.length();
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of length method, of class Object3D.
     */
    @Test
    public void testLength_Object3D() {
        System.out.println("length");
        Object3D o = null;
        double expResult = 0.0;
        double result = Object3D.length(o);
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
