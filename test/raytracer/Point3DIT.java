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
public class Point3DIT {
    
    public Point3DIT() {
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
     * Test of distance method, of class Point3D.
     */
    @Test
    public void testDistance_Point3D() {
        System.out.println("distance");
        Point3D p = null;
        Point3D instance = new Point3D();
        double expResult = 0.0;
        double result = instance.distance(p);
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of distanceSquared method, of class Point3D.
     */
    @Test
    public void testDistanceSquared_Point3D() {
        System.out.println("distanceSquared");
        Point3D p = null;
        Point3D instance = new Point3D();
        double expResult = 0.0;
        double result = instance.distanceSquared(p);
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of midpoint method, of class Point3D.
     */
    @Test
    public void testMidpoint_Point3D() {
        System.out.println("midpoint");
        Point3D p = null;
        Point3D instance = new Point3D();
        Point3D expResult = null;
        Point3D result = instance.midpoint(p);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of planeDistance method, of class Point3D.
     */
    @Test
    public void testPlaneDistance() {
        System.out.println("planeDistance");
        double a = 0.0;
        double b = 0.0;
        double c = 0.0;
        double d = 0.0;
        Point3D instance = new Point3D();
        double expResult = 0.0;
        double result = instance.planeDistance(a, b, c, d);
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of lineDistance method, of class Point3D.
     */
    @Test
    public void testLineDistance() {
        System.out.println("lineDistance");
        Vector3D v = null;
        Point3D a = null;
        Point3D instance = new Point3D();
        double expResult = 0.0;
        double result = instance.lineDistance(v, a);
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of rotateX method, of class Point3D.
     */
    @Test
    public void testRotateX() {
        System.out.println("rotateX");
        double r = 0.0;
        Point3D instance = new Point3D();
        instance.rotateX(r);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of rotateY method, of class Point3D.
     */
    @Test
    public void testRotateY() {
        System.out.println("rotateY");
        double r = 0.0;
        Point3D instance = new Point3D();
        instance.rotateY(r);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of rotateZ method, of class Point3D.
     */
    @Test
    public void testRotateZ() {
        System.out.println("rotateZ");
        double r = 0.0;
        Point3D instance = new Point3D();
        instance.rotateZ(r);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of translate method, of class Point3D.
     */
    @Test
    public void testTranslate_Object3D() {
        System.out.println("translate");
        Object3D o = null;
        Point3D instance = new Point3D();
        instance.translate(o);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of translate method, of class Point3D.
     */
    @Test
    public void testTranslate_3args() {
        System.out.println("translate");
        double nx = 0.0;
        double ny = 0.0;
        double nz = 0.0;
        Point3D instance = new Point3D();
        instance.translate(nx, ny, nz);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of translate method, of class Point3D.
     */
    @Test
    public void testTranslate_doubleArr() {
        System.out.println("translate");
        double[] p = null;
        Point3D instance = new Point3D();
        boolean expResult = false;
        Point3D result = instance.translate(p);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of rotate method, of class Point3D.
     */
    @Test
    public void testRotate() {
        System.out.println("rotate");
        double r = 0.0;
        Point3D p1 = null;
        Point3D p2 = null;
        Point3D instance = new Point3D();
        boolean expResult = false;
        boolean result = instance.rotate(r, p1, p2);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of scale method, of class Point3D.
     */
    @Test
    public void testScale() {
        System.out.println("scale");
        double ex = 0.0;
        double ey = 0.0;
        double ez = 0.0;
        Point3D p = null;
        Point3D instance = new Point3D();
        instance.scale(ex, ey, ez, p);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of symmetry method, of class Point3D.
     */
    @Test
    public void testSymmetry() {
        System.out.println("symmetry");
        double a = 0.0;
        double b = 0.0;
        double c = 0.0;
        double d = 0.0;
        Point3D instance = new Point3D();
        boolean expResult = false;
        boolean result = instance.symmetry(a, b, c, d);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of isInPlane method, of class Point3D.
     */
    @Test
    public void testIsInPlane() {
        System.out.println("isInPlane");
        double a = 0.0;
        double b = 0.0;
        double c = 0.0;
        double d = 0.0;
        Point3D instance = new Point3D();
        boolean expResult = false;
        boolean result = instance.isInPlane(a, b, c, d);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of freeBaseChange method, of class Point3D.
     */
    @Test
    public void testFreeBaseChange() {
        System.out.println("freeBaseChange");
        Vector3D e1 = null;
        Vector3D e2 = null;
        Vector3D e3 = null;
        Point3D w = null;
        Point3D instance = new Point3D();
        instance.freeBaseChange(e1, e2, e3, w);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of barycenter method, of class Point3D.
     */
    @Test
    public void testBarycenter() {
        System.out.println("barycenter");
        Point3D p1 = null;
        Point3D p2 = null;
        Point3D p3 = null;
        Point3D expResult = null;
        Point3D result = Point3D.barycenter(p1, p2, p3);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of distance method, of class Point3D.
     */
    @Test
    public void testDistance_Point3D_Point3D() {
        System.out.println("distance");
        Point3D p1 = null;
        Point3D p2 = null;
        double expResult = 0.0;
        double result = Point3D.distance(p1, p2);
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of distanceSquared method, of class Point3D.
     */
    @Test
    public void testDistanceSquared_Point3D_Point3D() {
        System.out.println("distanceSquared");
        Point3D p1 = null;
        Point3D p2 = null;
        double expResult = 0.0;
        double result = Point3D.distanceSquared(p1, p2);
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of midpoint method, of class Point3D.
     */
    @Test
    public void testMidpoint_Point3D_Point3D() {
        System.out.println("midpoint");
        Point3D p1 = null;
        Point3D p2 = null;
        Point3D expResult = null;
        Point3D result = Point3D.midpoint(p1, p2);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of add method, of class Point3D.
     */
    @Test
    public void testAdd() {
        System.out.println("add");
        Object3D p1 = null;
        Object3D p2 = null;
        Point3D expResult = null;
        Point3D result = Point3D.add(p1, p2);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of sub method, of class Point3D.
     */
    @Test
    public void testSub() {
        System.out.println("sub");
        Object3D o1 = null;
        Object3D o2 = null;
        Point3D expResult = null;
        Point3D result = Point3D.sub(o1, o2);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of div method, of class Point3D.
     */
    @Test
    public void testDiv() {
        System.out.println("div");
        Object3D o = null;
        double d = 0.0;
        Point3D expResult = null;
        Point3D result = Point3D.div(o, d);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of mul method, of class Point3D.
     */
    @Test
    public void testMul() {
        System.out.println("mul");
        Object3D o = null;
        double d = 0.0;
        Point3D expResult = null;
        Point3D result = Point3D.mul(o, d);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
