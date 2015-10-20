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
public class Vector3DIT {
    
    public Vector3DIT() {
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
     * Test of dot method, of class Vector3D.
     */
    @Test
    public void testDot_Vector3D() {
        System.out.println("dot");
        Vector3D v = null;
        Vector3D instance = new Vector3D();
        double expResult = 0.0;
        double result = instance.dot(v);
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of cross method, of class Vector3D.
     */
    @Test
    public void testCross_Vector3D() {
        System.out.println("cross");
        Vector3D v = null;
        Vector3D instance = new Vector3D();
        Vector3D expResult = null;
        Vector3D result = instance.cross(v);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of resize method, of class Vector3D.
     */
    @Test
    public void testResize() {
        System.out.println("resize");
        double length = 0.0;
        Vector3D instance = new Vector3D();
        instance.resize(length);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of normalize method, of class Vector3D.
     */
    @Test
    public void testNormalize() {
        System.out.println("normalize");
        Vector3D instance = new Vector3D();
        boolean expResult = false;
        boolean result = instance.normalize();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of isNormalized method, of class Vector3D.
     */
    @Test
    public void testIsNormalized_0args() {
        System.out.println("isNormalized");
        Vector3D instance = new Vector3D();
        boolean expResult = false;
        boolean result = instance.isNormalized();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of isNormalized method, of class Vector3D.
     */
    @Test
    public void testIsNormalized_double() {
        System.out.println("isNormalized");
        double epsilon = 0.0;
        Vector3D instance = new Vector3D();
        boolean expResult = false;
        boolean result = instance.isNormalized(epsilon);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of angle method, of class Vector3D.
     */
    @Test
    public void testAngle_Vector3D() {
        System.out.println("angle");
        Vector3D v = null;
        Vector3D instance = new Vector3D();
        double expResult = 0.0;
        double result = instance.angle(v);
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of coordinateSystem method, of class Vector3D.
     */
    @Test
    public void testCoordinateSystem_Vector3D_Vector3D() {
        System.out.println("coordinateSystem");
        Vector3D v1 = null;
        Vector3D v2 = null;
        Vector3D instance = new Vector3D();
        instance.coordinateSystem(v1, v2);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of normal method, of class Vector3D.
     */
    @Test
    public void testNormal() {
        System.out.println("normal");
        Vector3D v1 = null;
        Vector3D v2 = null;
        Vector3D instance = new Vector3D();
        boolean expResult = false;
        boolean result = instance.normal(v1, v2);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of sub method, of class Vector3D.
     */
    @Test
    public void testSub() {
        System.out.println("sub");
        Object3D o1 = null;
        Object3D o2 = null;
        Vector3D expResult = null;
        Vector3D result = Vector3D.sub(o1, o2);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of add method, of class Vector3D.
     */
    @Test
    public void testAdd() {
        System.out.println("add");
        Object3D o1 = null;
        Object3D o2 = null;
        Vector3D expResult = null;
        Vector3D result = Vector3D.add(o1, o2);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of div method, of class Vector3D.
     */
    @Test
    public void testDiv() {
        System.out.println("div");
        Object3D o = null;
        double d = 0.0;
        Vector3D expResult = null;
        Vector3D result = Vector3D.div(o, d);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of mul method, of class Vector3D.
     */
    @Test
    public void testMul() {
        System.out.println("mul");
        Object3D o = null;
        double d = 0.0;
        Vector3D expResult = null;
        Vector3D result = Vector3D.mul(o, d);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of dot method, of class Vector3D.
     */
    @Test
    public void testDot_Vector3D_Vector3D() {
        System.out.println("dot");
        Vector3D v1 = null;
        Vector3D v2 = null;
        double expResult = 0.0;
        double result = Vector3D.dot(v1, v2);
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of cross method, of class Vector3D.
     */
    @Test
    public void testCross_Vector3D_Vector3D() {
        System.out.println("cross");
        Vector3D v1 = null;
        Vector3D v2 = null;
        Vector3D expResult = null;
        Vector3D result = Vector3D.cross(v1, v2);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of lengthSquared method, of class Vector3D.
     */
    @Test
    public void testLengthSquared() {
        System.out.println("lengthSquared");
        Vector3D v = null;
        double expResult = 0.0;
        double result = Vector3D.lengthSquared(v);
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of angle method, of class Vector3D.
     */
    @Test
    public void testAngle_Vector3D_Vector3D() {
        System.out.println("angle");
        Vector3D v1 = null;
        Vector3D v2 = null;
        double expResult = 0.0;
        double result = Vector3D.angle(v1, v2);
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of coordinateSystem method, of class Vector3D.
     */
    @Test
    public void testCoordinateSystem_3args() {
        System.out.println("coordinateSystem");
        Vector3D v1 = null;
        Vector3D v2 = null;
        Vector3D v3 = null;
        Vector3D.coordinateSystem(v1, v2, v3);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
