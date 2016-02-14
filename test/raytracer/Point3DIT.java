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

    private Point3D p1;
    private Point3D p2;
    private Point3D p3;
    private double epsilon = 0.0000001;
    
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
        p1 = new Point3D(1.0, 2.0, 3.0);
        p2 = new Point3D(-1.0, 0.0, -1.0);
        p3 = new Point3D(0.0, -1.0, 0.0);
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of distance method, of class Point3D.
     */
    @Test
    public void testDistance_Point3D() {
        System.out.println("distance(Point3D)");
        assertTrue(0.0 == p1.distance(p1));
        assertTrue(Math.sqrt(24.0) == p1.distance(p2));
        assertTrue(Math.sqrt(19.0) == p1.distance(p3));
        assertTrue(Math.sqrt(3.0) == p2.distance(p3));
        assertTrue(1.0 == p3.distance(Point3D.ZERO));
    }

    /**
     * Test of distanceSquared method, of class Point3D.
     */
    @Test
    public void testDistanceSquared_Point3D() {
        System.out.println("distanceSquared(Point3D)");
        assertTrue(0.0 == p1.distanceSquared(p1));
        assertTrue(24.0 == p1.distanceSquared(p2));
        assertTrue(19.0 == p1.distanceSquared(p3));
        assertTrue(3.0 == p2.distanceSquared(p3));
        assertTrue(1.0 == p3.distanceSquared(Point3D.ZERO));
    }

    /**
     * Test of midpoint method, of class Point3D.
     */
    @Test
    public void testMidpoint_Point3D() {
        System.out.println("midpoint(Point3D)");
        assertEquals(p1, p1.midpoint(p1));
        assertEquals(new Point3D(0.0, 1.0, 1.0), p1.midpoint(p2));
        assertEquals(new Point3D(0.5, 0.5, 1.5), p1.midpoint(p3));
        assertEquals(new Point3D(-0.5, -0.5, -0.5), p2.midpoint(p3));
        assertEquals(new Point3D(0.5, 1.0, 1.5), p1.midpoint(Point3D.ZERO));
    }

    /**
     * Test of planeDistance method, of class Point3D.
     */
    @Test
    public void testPlaneDistance() {
        System.out.println("planeDistance(double, double, double, double)");
        assertEquals(Math.sqrt(3.0 / 2.0), p1.planeDistance(1.0, -1.0, 2.0, -2.0), epsilon);
        assertEquals(5.0 / Math.sqrt(6.0), p2.planeDistance(1.0, -1.0, 2.0, -2.0), epsilon);
        assertEquals(1.0 / Math.sqrt(6.0), p3.planeDistance(1.0, -1.0, 2.0, -2.0), epsilon);
        assertEquals(Math.sqrt(2.0 / 3.0), Point3D.ZERO.planeDistance(1.0, -1.0, 2.0, -2.0), epsilon);
        assertEquals(0.0, new Point3D(0.0, 0.0, 1.0).planeDistance(1.0, -1.0, 2.0, -2.0), epsilon);
        assertTrue(Double.isNaN(p1.planeDistance(0.0, 0.0, 0.0, -2.0)));
    }

    /**
     * Test of lineDistance method, of class Point3D.
     */
    @Test
    public void testLineDistance() {
        System.out.println("lineDistance(Vector3D, Point3D)");
        Vector3D v = new Vector3D(1.0, 2.0, 1.0);
        Point3D a = new Point3D(1.0, -1.0, 0.0);
        assertEquals(3.0 / Math.sqrt(2), p1.lineDistance(v, a), epsilon);
        assertEquals(Math.sqrt(35.0 / 6.0), p2.lineDistance(v, a), epsilon);
        assertEquals(Math.sqrt(5.0 / 6.0), p3.lineDistance(v, a), epsilon);
        assertEquals(Math.sqrt(11.0 / 6.0), Point3D.ZERO.lineDistance(v, a), epsilon);
    }

    /**
     * Test of rotateX method, of class Point3D.
     */
    @Test
    public void testRotateX() {
        System.out.println("rotateX(double)");
        assertTrue(new Point3D(1.0, -2.0, -3.0).equals(p1.rotateX(Math.PI), epsilon));
        assertTrue(new Point3D(1.0, -2.0, -3.0).equals(p1.rotateX(-Math.PI), epsilon));
        assertTrue(new Point3D(-1.0, 0.0, 1.0).equals(p2.rotateX(Math.PI), epsilon));
        assertTrue(new Point3D(0.0, 0.0, -1.0).equals(p3.rotateX(Math.PI / 2.0), epsilon));
        assertTrue(new Point3D(0.0, 0.0, 1.0).equals(p3.rotateX(-Math.PI / 2.0), epsilon));
        assertTrue(Point3D.ZERO.equals(Point3D.ZERO.rotateX(Math.PI), epsilon));
    }

    /**
     * Test of rotateY method, of class Point3D.
     */
    @Test
    public void testRotateY() {
        System.out.println("rotateY(double)");
        assertTrue(new Point3D(-1.0, 2.0, -3.0).equals(p1.rotateY(Math.PI), epsilon));
        assertTrue(new Point3D(-1.0, 2.0, -3.0).equals(p1.rotateY(-Math.PI), epsilon));
        assertTrue(new Point3D(1.0, 0.0, 1.0).equals(p2.rotateY(Math.PI), epsilon));
        assertTrue(new Point3D(0.0, -1.0, 0.0).equals(p3.rotateY(Math.PI / 2.0), epsilon));
        assertTrue(new Point3D(0.0, -1.0, 0.0).equals(p3.rotateY(-Math.PI / 2.0), epsilon));
        assertTrue(Point3D.ZERO.equals(Point3D.ZERO.rotateY(Math.PI), epsilon));
    }

    /**
     * Test of rotateZ method, of class Point3D.
     */
    @Test
    public void testRotateZ() {
        System.out.println("rotateZ(double)");
        assertTrue(new Point3D(-1.0, -2.0, 3.0).equals(p1.rotateZ(Math.PI), epsilon));
        assertTrue(new Point3D(-1.0, -2.0, 3.0).equals(p1.rotateZ(-Math.PI), epsilon));
        assertTrue(new Point3D(1.0, 0.0, -1.0).equals(p2.rotateZ(Math.PI), epsilon));
        assertTrue(new Point3D(1.0, 0.0, 0.0).equals(p3.rotateZ(Math.PI / 2.0), epsilon));
        assertTrue(new Point3D(-1.0, 0.0, 0.0).equals(p3.rotateZ(-Math.PI / 2.0), epsilon));
        assertTrue(Point3D.ZERO.equals(Point3D.ZERO.rotateZ(Math.PI), epsilon));
    }

    /**
     * Test of translate method, of class Point3D.
     */
    @Test
    public void testTranslate_Object3D() {
        System.out.println("translate(Object3D)");
        assertTrue(new Point3D(0.0, 2.0, 2.0).equals(p1.translate(p2)));
        assertTrue(new Point3D(1.0, 1.0, 3.0).equals(p1.translate(p3)));
        assertTrue(new Point3D(-1.0, -1.0, -1.0).equals(p2.translate(p3)));
        assertTrue(p1.equals(p1.translate(Point3D.ZERO)));
        assertTrue(p1.equals(Point3D.ZERO.translate(p1)));
        assertTrue(p1.translate((Object3D)null) == null);
    }

    /**
     * Test of translate method, of class Point3D.
     */
    @Test
    public void testTranslate_3args() {
        System.out.println("translate(double, double, double)");
        assertTrue(new Point3D(0.0, 2.0, 2.0).equals(p1.translate(p2.x, p2.y, p2.z)));
        assertTrue(new Point3D(1.0, 1.0, 3.0).equals(p1.translate(p3.x, p3.y, p3.z)));
        assertTrue(new Point3D(-1.0, -1.0, -1.0).equals(p2.translate(p3.x, p3.y, p3.z)));
        assertTrue(p1.equals(p1.translate(Point3D.ZERO)));
        assertTrue(p1.equals(Point3D.ZERO.translate(p1.x, p1.y, p1.z)));
    }

    /**
     * Test of translate method, of class Point3D.
     */
    @Test
    public void testTranslate_doubleArr() {
        System.out.println("translate(double [])");
        assertTrue(new Point3D(0.0, 2.0, 2.0).equals(p1.translate(new double[] {p2.x, p2.y, p2.z})));
        assertTrue(new Point3D(1.0, 1.0, 3.0).equals(p1.translate(new double[] {p3.x, p3.y, p3.z})));
        assertTrue(new Point3D(-1.0, -1.0, -1.0).equals(p2.translate(new double[] {p3.x, p3.y, p3.z})));
        assertTrue(p1.equals(p1.translate(new double[] {Point3D.ZERO.x, Point3D.ZERO.y, Point3D.ZERO.z})));
        assertTrue(p1.equals(Point3D.ZERO.translate(new double[] {p1.x, p1.y, p1.z})));
        assertTrue(p1.translate(new double[] {0.0, 0.0}) == null);
    }

    /**
     * Test of rotate method, of class Point3D.
     */
    @Test
    public void testRotate() {
        System.out.println("rotate(double, Point3D, Point3D)");
        assertTrue(new Point3D(-1.0 / 3.0, -14.0 / 3.0, -7.0 / 3.0).equals(p1.rotate(Math.PI, p2, p3), epsilon));
        assertTrue(new Point3D(0.8947368421052639, -2.315789473684208, 0.6842105263157916).equals(p2.rotate(Math.PI, p1, p3), epsilon));
        assertTrue(new Point3D(-4.0 / 3.0, 5.0 / 3.0, -2.0 / 3.0).equals(p3.rotate(Math.PI, p1, p2), epsilon));
        assertTrue(new Point3D(-1, 1, 0).equals(Point3D.ZERO.rotate(Math.PI, p1, p2), epsilon));
        assertTrue(p1.equals(p1.rotate(Math.PI, p1, p2), epsilon));
    }

    /**
     * Test of scale method, of class Point3D.
     */
    @Test
    public void testScale() {
        System.out.println("scale(double, double, double, Point3D)");
        assertTrue(new Point3D(0.5, 1.0, 1.5).equals(p1.scale(0.5, 0.5, 0.5, Point3D.ZERO), epsilon));
        assertTrue(p1.equals(p1.scale(0.5, 0.5, 0.5, p1), epsilon));
        assertTrue(new Point3D(1.25, 2.0, 3.0).equals(p1.scale(0.5, 0.5, 0.5, new Point3D(1.5, 2.0, 3.0)), epsilon));
        assertTrue(p1.equals(p1.scale(1.0, 1.0, 1.0, p2), epsilon));
        assertTrue(p1.equals(p1.scale(1.0, 1.0, 1.0, p3), epsilon));
        assertTrue(p1.scale(0.5, 0.5, 0.5, null) == null);
    }

    /**
     * Test of symmetry method, of class Point3D.
     */
    @Test
    public void testSymmetry() {
        System.out.println("symmetry(double, double, double, double)");
        assertTrue(new Point3D(2.0, -1.0, 1.0).equals(p1.symmetry(1.0, -3.0, -2.0, 4.0), 0.0000001));
        assertTrue(new Point3D(-3.0, -2.0, 0.0).equals(new Point3D(1.0, 2.0, 4.0).symmetry(1.0, 1.0, 1.0, -1.0), 0.0000001));
        assertTrue(new Point3D(4.0 / 3.0, 2.0 / 3.0, -1.0 / 3.0).equals(new Point3D(2.0, 0.0, 1.0).symmetry(-1.0, 1.0, -2.0, 2.0), 0.0000001));
        assertTrue(new Point3D(13.0 / 7.0, 4.0 / 7.0, 9.0 / 7.0).equals(new Point3D(1.0, -2.0, 3.0).symmetry(1.0, 3.0, -2.0, 5.0), 0.0000001));
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
        System.out.println("distance(Point3D, Point3D)");
        assertTrue(0.0 == Point3D.distance(p1, p1));
        assertTrue(Math.sqrt(24.0) == Point3D.distance(p1, p2));
        assertTrue(Math.sqrt(19.0) == Point3D.distance(p1, p3));
        assertTrue(Math.sqrt(3.0) == Point3D.distance(p2, p3));
        assertTrue(1.0 == Point3D.distance(p3, Point3D.ZERO));
    }

    /**
     * Test of distanceSquared method, of class Point3D.
     */
    @Test
    public void testDistanceSquared_Point3D_Point3D() {
        System.out.println("distanceSquared(Point3D, Point3D)");
        assertTrue(0.0 == Point3D.distanceSquared(p1, p1));
        assertTrue(24.0 == Point3D.distanceSquared(p1, p2));
        assertTrue(19.0 == Point3D.distanceSquared(p1, p3));
        assertTrue(3.0 == Point3D.distanceSquared(p2, p3));
        assertTrue(1.0 == Point3D.distanceSquared(p3, Point3D.ZERO));
    }

    /**
     * Test of midpoint method, of class Point3D.
     */
    @Test
    public void testMidpoint_Point3D_Point3D() {
        System.out.println("midpoint(Point3D, Point3D)");
        assertEquals(p1, Point3D.midpoint(p1, p1));
        assertEquals(new Point3D(0.0, 1.0, 1.0), Point3D.midpoint(p1, p2));
        assertEquals(new Point3D(0.5, 0.5, 1.5), Point3D.midpoint(p1, p3));
        assertEquals(new Point3D(-0.5, -0.5, -0.5), Point3D.midpoint(p2, p3));
        assertEquals(new Point3D(0.5, 1.0, 1.5), Point3D.midpoint(p1, Point3D.ZERO));
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

    /**
     * Test of isInPlane method, of class Point3D.
     */
    @Test
    public void testIsInPlane_4args() {
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
     * Test of isInPlane method, of class Point3D.
     */
    @Test
    public void testIsInPlane_5args() {
        System.out.println("isInPlane");
        double a = 0.0;
        double b = 0.0;
        double c = 0.0;
        double d = 0.0;
        double epsilon = 0.0;
        Point3D instance = new Point3D();
        boolean expResult = false;
        boolean result = instance.isInPlane(a, b, c, d, epsilon);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
