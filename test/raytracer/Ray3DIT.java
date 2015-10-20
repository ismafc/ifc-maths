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
public class Ray3DIT {
    
    public Ray3DIT() {
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
     * Test of setOrigin method, of class Ray3D.
     */
    @Test
    public void testSetOrigin() {
        System.out.println("setOrigin");
        Point3D no = null;
        Ray3D instance = new Ray3D();
        instance.setOrigin(no);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setDirection method, of class Ray3D.
     */
    @Test
    public void testSetDirection() {
        System.out.println("setDirection");
        Vector3D nd = null;
        Ray3D instance = new Ray3D();
        instance.setDirection(nd);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setMint method, of class Ray3D.
     */
    @Test
    public void testSetMint() {
        System.out.println("setMint");
        double nmint = 0.0;
        Ray3D instance = new Ray3D();
        instance.setMint(nmint);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setMaxt method, of class Ray3D.
     */
    @Test
    public void testSetMaxt() {
        System.out.println("setMaxt");
        double nmaxt = 0.0;
        Ray3D instance = new Ray3D();
        instance.setMaxt(nmaxt);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setTime method, of class Ray3D.
     */
    @Test
    public void testSetTime() {
        System.out.println("setTime");
        double ntime = 0.0;
        Ray3D instance = new Ray3D();
        instance.setTime(ntime);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getPoint method, of class Ray3D.
     */
    @Test
    public void testGetPoint() {
        System.out.println("getPoint");
        double t = 0.0;
        Ray3D instance = new Ray3D();
        Point3D expResult = null;
        Point3D result = instance.getPoint(t);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of equals method, of class Ray3D.
     */
    @Test
    public void testEquals() {
        System.out.println("equals");
        Ray3D r = null;
        Ray3D instance = new Ray3D();
        boolean expResult = false;
        boolean result = instance.equals(r);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of isIn method, of class Ray3D.
     */
    @Test
    public void testIsIn() {
        System.out.println("isIn");
        Object3D p = null;
        Ray3D instance = new Ray3D();
        boolean expResult = false;
        boolean result = instance.isIn(p);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of toString method, of class Ray3D.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        Ray3D instance = new Ray3D();
        String expResult = "";
        String result = instance.toString();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
