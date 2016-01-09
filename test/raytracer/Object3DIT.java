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

    private Object3D o1;
    private Object3D o2;
    private Object3D o3;
    
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
        o1 = new Object3D(1.0, 2.0, 3.0);
        o2 = new Object3D(-1.0, 0.0, -1.0);
        o3 = new Object3D(0.0, -1.0, 0.0);
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of set method, of class Object3D.
     */
    @Test
    public void testSet_3args() {
        System.out.println("set(double, double, double)");
        o2.set(-4.0, -3.0, -2.0);
        assertTrue(o2.x == -4.0 && o2.y == -3.0 && o2.z == -2.0);
        o3.set(1.0, 2.0, 3.0);
        assertTrue(o1.equals(o3));
    }

    /**
     * Test of set method, of class Object3D.
     */
    @Test
    public void testSet_Object3D() {
        System.out.println("set(Object3D)");
        Object3D o = new Object3D(1.0, 2.0, 3.0);
        o2.set(o);
        assertTrue(o2.equals(o1));
        o3.set(o1);
        assertTrue(o3.x == 1.0 && o3.y == 2.0 && o3.z == 3.0);
    }

    /**
     * Test of set method, of class Object3D.
     */
    @Test
    public void testSet_doubleArr() {
        System.out.println("set(double [])");
        double[] o = {1.0, 2.0, 3.0};
        o2.set(o);
        assertTrue(o2.equals(o1));
        o3.set(o);
        assertTrue(o3.x == 1.0 && o3.y == 2.0 && o3.z == 3.0);
    }

    /**
     * Test of setX method, of class Object3D.
     */
    @Test
    public void testSetX() {
        System.out.println("setX");
        o3.setX(1.0);
        assertTrue(o3.x == o1.x);
        o3.setX(-1.0);
        assertTrue(o3.x == o2.x);
    }

    /**
     * Test of getX method, of class Object3D.
     */
    @Test
    public void testGetX() {
        System.out.println("getX");
        assertTrue(o1.x == 1.0);
        assertTrue(o2.x == -1.0);
        assertTrue(o3.x == 0.0);
    }

    /**
     * Test of setY method, of class Object3D.
     */
    @Test
    public void testSetY() {
        System.out.println("setY");
        o3.setY(2.0);
        assertTrue(o3.y == o1.y);
        o3.setY(0.0);
        assertTrue(o3.y == o2.y);
    }

    /**
     * Test of getY method, of class Object3D.
     */
    @Test
    public void testGetY() {
        System.out.println("getY");
        assertTrue(o1.y == 2.0);
        assertTrue(o2.y == 0.0);
        assertTrue(o3.y == -1.0);
    }

    /**
     * Test of setZ method, of class Object3D.
     */
    @Test
    public void testSetZ() {
        System.out.println("setZ");
        o3.setZ(3.0);
        assertTrue(o3.z == o1.z);
        o3.setZ(-1.0);
        assertTrue(o3.z == o2.z);
    }

    /**
     * Test of getZ method, of class Object3D.
     */
    @Test
    public void testGetZ() {
        System.out.println("getZ");
        assertTrue(o1.z == 3.0);
        assertTrue(o2.z == -1.0);
        assertTrue(o3.z == 0.0);
    }

    /**
     * Test of get method, of class Object3D.
     */
    @Test
    public void testGet() {
        System.out.println("get(double [])");
        double[] c = new double [3];
        assertTrue(o1.get(c));
        assertTrue(c[0] == 1.0 && c[1] == 2.0 && c[2] == 3.0);
        c = new double [2];
        assertFalse(o1.get(c));
        c = new double [5];
        assertTrue(o2.get(c));
        assertTrue(c[0] == -1.0 && c[1] == 0.0 && c[2] == -1.0);
        c = null;
        assertFalse(o1.get(c));
    }

    /**
     * Test of add method, of class Object3D.
     */
    @Test
    public void testAdd_Object3D() {
        System.out.println("add(Object3D)");
        assertEquals(new Object3D(0.0, 2.0, 2.0), o1.add(o2));
        assertEquals(new Object3D(1.0, 1.0, 3.0), o1.add(o3));
        assertEquals(new Object3D(-1.0, -1.0, -1.0), o2.add(o3));
        assertEquals(o1, o1.add(Object3D.ZERO));
    }

    /**
     * Test of sub method, of class Object3D.
     */
    @Test
    public void testSub_Object3D() {
        System.out.println("sub(Object3D)");
        assertEquals(new Object3D(2.0, 2.0, 4.0), o1.sub(o2));
        assertEquals(new Object3D(-2.0, -2.0, -4.0), o2.sub(o1));
        assertEquals(o1, o1.sub(Object3D.ZERO));
    }

    /**
     * Test of div method, of class Object3D.
     */
    @Test
    public void testDiv_double() {
        System.out.println("div(double)");
        assertEquals(new Object3D(0.5, 1.0, 1.5), o1.div(2.0));
        assertEquals(null, o1.div(0.0));
        assertEquals(o1, o1.div(1.0));
        assertEquals(new Object3D(-1.0 / 3.0, 0.0, -1.0 / 3.0), o2.div(3.0));
        assertEquals(new Object3D(0.0, -1.0 / 4.0, 0.0), o3.div(4.0));
    }

    /**
     * Test of div method, of class Object3D.
     */
    @Test
    public void testDiv_Object3D() {
        System.out.println("div(Object3D)");
        assertEquals(new Object3D(-1.0, 0.0, -1.0 / 3.0), o2.div(o1));
        assertEquals(new Object3D(0.0, -1.0 / 2.0, 0.0), o3.div(o1));
        assertEquals(null, o1.div(o2));
        assertEquals(null, o1.div(o3));
        assertEquals(null, o1.div(Object3D.ZERO));
    }

    /**
     * Test of mul method, of class Object3D.
     */
    @Test
    public void testMul_double() {
        System.out.println("mul(double)");
        assertEquals(new Object3D(2.0, 4.0, 6.0), o1.mul(2.0));
        assertEquals(o1, o1.mul(1.0));
        assertEquals(new Object3D(-3.0, 0.0, -3.0), o2.mul(3.0));
        assertEquals(new Object3D(0.0, -4.0, 0.0), o3.mul(4.0));
        assertEquals(Object3D.ZERO, o1.mul(Object3D.ZERO));
    }

    /**
     * Test of mul method, of class Object3D.
     */
    @Test
    public void testMul_Object3D() {
        System.out.println("mul(Object3D)");
        assertEquals(new Object3D(1.0, 4.0, 9.0), o1.mul(o1));
        assertEquals(new Object3D(-1.0, 0.0, -3.0), o1.mul(o2));
        assertEquals(new Object3D(0.0, -2.0, 0.0), o1.mul(o3));
        assertEquals(o2.mul(o1), o1.mul(o2));
        assertEquals(Object3D.ZERO, o1.mul(Object3D.ZERO));
    }

    /**
     * Test of add method, of class Object3D.
     */
    @Test
    public void testAdd_3args() {
        System.out.println("add(double, double, double)");
        assertEquals(new Object3D(0.0, 2.0, 2.0), o1.add(o2.x, o2.y, o2.z));
        assertEquals(new Object3D(1.0, 1.0, 3.0), o1.add(o3.x, o3.y, o3.z));
        assertEquals(new Object3D(-1.0, -1.0, -1.0), o2.add(o3.x, o3.y, o3.z));
        assertEquals(o1, o1.add(0.0, 0.0, 0.0));
    }

    /**
     * Test of sub method, of class Object3D.
     */
    @Test
    public void testSub_3args() {
        System.out.println("sub(double, double, double)");
        assertEquals(new Object3D(2.0, 2.0, 4.0), o1.sub(o2.x, o2.y, o2.z));
        assertEquals(new Object3D(-2.0, -2.0, -4.0), o2.sub(o1.x, o1.y, o1.z));
        assertEquals(o1, o1.sub(0.0, 0.0, 0.0));
    }

    /**
     * Test of mul method, of class Object3D.
     */
    @Test
    public void testMul_3args() {
        System.out.println("mul(double, double, double)");
        assertEquals(new Object3D(1.0, 4.0, 9.0), o1.mul(o1.x, o1.y, o1.z));
        assertEquals(new Object3D(-1.0, 0.0, -3.0), o1.mul(o2.x, o2.y, o2.z));
        assertEquals(new Object3D(0.0, -2.0, 0.0), o1.mul(o3.x, o3.y, o3.z));
        assertEquals(o2.mul(o1.x, o1.y, o1.z), o1.mul(o2.x, o2.y, o2.z));
        assertEquals(Object3D.ZERO, o1.mul(0.0, 0.0, 0.0));
    }

    /**
     * Test of div method, of class Object3D.
     */
    @Test
    public void testDiv_3args() {
        System.out.println("div(double, double, double");
        assertEquals(new Object3D(-1.0, 0.0, -1.0 / 3.0), o2.div(o1.x, o1.y, o1.z));
        assertEquals(new Object3D(0.0, -1.0 / 2.0, 0.0), o3.div(o1.x, o1.y, o1.z));
        assertEquals(null, o1.div(o2.x, o2.y, o2.z));
        assertEquals(null, o1.div(o3.x, o3.y, o3.z));
        assertEquals(null, o1.div(0.0, 0.0, 0.0));
    }

    /**
     * Test of add method, of class Object3D.
     */
    @Test
    public void testAdd_doubleArr() {
        System.out.println("add(double [])");
        assertEquals(new Object3D(0.0, 2.0, 2.0), o1.add(new double[] {o2.x, o2.y, o2.z}));
        assertEquals(new Object3D(1.0, 1.0, 3.0), o1.add(new double[] {o3.x, o3.y, o3.z}));
        assertEquals(new Object3D(-1.0, -1.0, -1.0), o2.add(new double[] {o3.x, o3.y, o3.z}));
        assertEquals(o1, o1.add(new double[] {0.0, 0.0, 0.0}));
    }

    /**
     * Test of isNull method, of class Object3D.
     */
    @Test
    public void testIsNull_0args() {
        System.out.println("isNull");
        assertTrue(Object3D.ZERO.isNull());
        assertFalse(o1.isNull());
        assertFalse(o2.isNull());
        assertFalse(o3.isNull());
    }

    /**
     * Test of isNull method, of class Object3D.
     */
    @Test
    public void testIsNull_double() {
        System.out.println("isNull(double)");
        assertTrue(Object3D.ZERO.isNull(0.0));
        assertTrue(Object3D.ZERO.isNull(0.1));
        assertTrue(Object3D.ZERO.isNull(-0.1));
        assertFalse(o1.isNull(0.1));
        assertFalse(o2.isNull(0.1));
        assertFalse(o3.isNull(0.1));
        assertFalse(o1.isNull(1.0));
        assertTrue(o2.isNull(1.0));
        assertTrue(o3.isNull(-1.0));
    }

    /**
     * Test of isInvalid method, of class Object3D.
     */
    @Test
    public void testIsInvalid() {
        System.out.println("isInvalid");
        assertFalse(Object3D.ZERO.isInvalid());
        assertFalse(o1.isInvalid());
        assertFalse(o2.isInvalid());
        assertFalse(o3.isInvalid());
        assertTrue(new Object3D(Double.NaN, Double.NaN, Double.NaN).isInvalid());
        o1.invalidate();
        assertTrue(o1.isInvalid());
    }

    /**
     * Test of invalidate method, of class Object3D.
     */
    @Test
    public void testInvalidate() {
        System.out.println("invalidate");
        o1.invalidate();
        assertTrue(o1.isInvalid());
    }

    /**
     * Test of equals method, of class Object3D.
     */
    @Test
    public void testEquals_Object() {
        System.out.println("equals(Object3D)");
        assertTrue(o1.equals(o1));
        assertTrue(o1.equals(new Object3D(1.0, 2.0, 3.0)));
        assertFalse(o1.equals(o2));
        assertFalse(o1.equals(o3));
        assertFalse(o2.equals(o3));
        assertFalse(o1.equals(Object3D.ZERO));
    }

    /**
     * Test of hashCode method, of class Object3D.
     */
    @Test
    public void testHashCode() {
        System.out.println("hashCode");
        int expResult = o1.hashCode();
        o2.set(1.0, 2.0, 3.0);
        int result = o2.hashCode();
        assertEquals(expResult, result);
        o2.set(1.1, 2.0, 3.0);
        expResult = o2.hashCode();
        assertTrue(expResult != result);
        o2.set(1.0, 2.1, 3.0);
        expResult = o2.hashCode();
        assertTrue(expResult != result);
        o2.set(1.0, 2.0, 3.1);
        expResult = o2.hashCode();
        assertTrue(expResult != result);
    }

    /**
     * Test of equals method, of class Object3D.
     */
    @Test
    public void testEquals_Object3D_double() {
        System.out.println("equals(Object3D, double)");
        assertTrue(o1.equals(o1, 0.1));
        assertTrue(o1.equals(new Object3D(0.9, 2.1, 3.04), 0.1));
        assertFalse(o1.equals(o2, 0.1));
        assertFalse(o1.equals(o3, -0.5));
        assertFalse(o2.equals(o3, 0.9));
        assertTrue(o2.equals(o3, 1.0));
        assertFalse(o1.equals(Object3D.ZERO, 2.5));
    }

    /**
     * Test of toString method, of class Object3D.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        assertEquals("(1.0, 2.0, 3.0)", o1.toString());
        assertEquals("(-1.0, 0.0, -1.0)", o2.toString());
        assertEquals("(0.0, -1.0, 0.0)", o3.toString());
        assertEquals("(0.0, 0.0, 0.0)", Object3D.ZERO.toString());
    }

    /**
     * Test of lengthSquared method, of class Object3D.
     */
    @Test
    public void testLengthSquared() {
        System.out.println("lengthSquared");
        assertTrue(14.0 == o1.lengthSquared());
        assertTrue(2.0 == o2.lengthSquared());
        assertTrue(1.0 == o3.lengthSquared());
        assertTrue(0.0 == Object3D.ZERO.lengthSquared());
    }

    /**
     * Test of length method, of class Object3D.
     */
    @Test
    public void testLength_0args() {
        System.out.println("length");
        assertTrue(Math.sqrt(14.0) == o1.length());
        assertTrue(Math.sqrt(2.0) == o2.length());
        assertTrue(1.0 == o3.length());
        assertTrue(0.0 == Object3D.ZERO.length());
    }

    /**
     * Test of length method, of class Object3D.
     */
    @Test
    public void testLength_Object3D() {
        System.out.println("length(Object3D)");
        assertTrue(Math.sqrt(14.0) == Object3D.length(o1));
        assertTrue(Math.sqrt(2.0) == Object3D.length(o2));
        assertTrue(1.0 == Object3D.length(o3));
        assertTrue(0.0 == Object3D.length(Object3D.ZERO));
    }
    
}
