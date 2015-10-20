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
public class Box3DIT {
    
    public Box3DIT() {
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
     * Test of set method, of class Box3D.
     */
    @Test
    public void testSet() {
        System.out.println("set");
        Point3D p = null;
        Box3D instance = new Box3D();
        instance.set(p);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of union method, of class Box3D.
     */
    @Test
    public void testUnion_Object3D() {
        System.out.println("union");
        Object3D o = null;
        Box3D instance = new Box3D();
        instance.union(o);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of union method, of class Box3D.
     */
    @Test
    public void testUnion_Box3D() {
        System.out.println("union");
        Box3D b = null;
        Box3D instance = new Box3D();
        instance.union(b);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of overlaps method, of class Box3D.
     */
    @Test
    public void testOverlaps_Box3D() {
        System.out.println("overlaps");
        Box3D b = null;
        Box3D instance = new Box3D();
        boolean expResult = false;
        boolean result = instance.overlaps(b);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of inside method, of class Box3D.
     */
    @Test
    public void testInside_Object3D() {
        System.out.println("inside");
        Object3D o = null;
        Box3D instance = new Box3D();
        boolean expResult = false;
        boolean result = instance.inside(o);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of expand method, of class Box3D.
     */
    @Test
    public void testExpand() {
        System.out.println("expand");
        double delta = 0.0;
        Box3D instance = new Box3D();
        instance.expand(delta);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of volume method, of class Box3D.
     */
    @Test
    public void testVolume() {
        System.out.println("volume");
        Box3D instance = new Box3D();
        double expResult = 0.0;
        double result = instance.volume();
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of union method, of class Box3D.
     */
    @Test
    public void testUnion_Box3D_Object3D() {
        System.out.println("union");
        Box3D b = null;
        Object3D o = null;
        Box3D expResult = null;
        Box3D result = Box3D.union(b, o);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of union method, of class Box3D.
     */
    @Test
    public void testUnion_Box3D_Box3D() {
        System.out.println("union");
        Box3D b1 = null;
        Box3D b2 = null;
        Box3D expResult = null;
        Box3D result = Box3D.union(b1, b2);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of overlaps method, of class Box3D.
     */
    @Test
    public void testOverlaps_Box3D_Box3D() {
        System.out.println("overlaps");
        Box3D b1 = null;
        Box3D b2 = null;
        boolean expResult = false;
        boolean result = Box3D.overlaps(b1, b2);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of inside method, of class Box3D.
     */
    @Test
    public void testInside_Box3D_Object3D() {
        System.out.println("inside");
        Box3D b = null;
        Object3D o = null;
        boolean expResult = false;
        boolean result = Box3D.inside(b, o);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of equals method, of class Box3D.
     */
    @Test
    public void testEquals() {
        System.out.println("equals");
        Box3D b = null;
        Box3D instance = new Box3D();
        boolean expResult = false;
        boolean result = instance.equals(b);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of toString method, of class Box3D.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        Box3D instance = new Box3D();
        String expResult = "";
        String result = instance.toString();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
