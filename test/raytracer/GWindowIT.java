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
public class GWindowIT {
    
    public GWindowIT() {
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
     * Test of set method, of class GWindow.
     */
    @Test
    public void testSet() {
        System.out.println("set");
        double nxMin = 0.0;
        double nyMin = 0.0;
        double nxMax = 0.0;
        double nyMax = 0.0;
        GWindow instance = new GWindow();
        instance.set(nxMin, nyMin, nxMax, nyMax);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getWidth method, of class GWindow.
     */
    @Test
    public void testGetWidth() {
        System.out.println("getWidth");
        GWindow instance = new GWindow();
        double expResult = 0.0;
        double result = instance.getWidth();
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getHeight method, of class GWindow.
     */
    @Test
    public void testGetHeight() {
        System.out.println("getHeight");
        GWindow instance = new GWindow();
        double expResult = 0.0;
        double result = instance.getHeight();
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getXMin method, of class GWindow.
     */
    @Test
    public void testGetXMin() {
        System.out.println("getXMin");
        GWindow instance = new GWindow();
        double expResult = 0.0;
        double result = instance.getXMin();
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getYMin method, of class GWindow.
     */
    @Test
    public void testGetYMin() {
        System.out.println("getYMin");
        GWindow instance = new GWindow();
        double expResult = 0.0;
        double result = instance.getYMin();
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getPercentY method, of class GWindow.
     */
    @Test
    public void testGetPercentY() {
        System.out.println("getPercentY");
        double y = 0.0;
        GWindow instance = new GWindow();
        double expResult = 0.0;
        double result = instance.getPercentY(y);
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getPercentX method, of class GWindow.
     */
    @Test
    public void testGetPercentX() {
        System.out.println("getPercentX");
        double x = 0.0;
        GWindow instance = new GWindow();
        double expResult = 0.0;
        double result = instance.getPercentX(x);
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of equals method, of class GWindow.
     */
    @Test
    public void testEquals() {
        System.out.println("equals");
        Object o = null;
        GWindow instance = new GWindow();
        boolean expResult = false;
        boolean result = instance.equals(o);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of hashCode method, of class GWindow.
     */
    @Test
    public void testHashCode() {
        System.out.println("hashCode");
        GWindow instance = new GWindow();
        int expResult = 0;
        int result = instance.hashCode();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of equalsX method, of class GWindow.
     */
    @Test
    public void testEqualsX() {
        System.out.println("equalsX");
        GWindow w = null;
        GWindow instance = new GWindow();
        boolean expResult = false;
        boolean result = instance.equalsX(w);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of equalsY method, of class GWindow.
     */
    @Test
    public void testEqualsY() {
        System.out.println("equalsY");
        GWindow w = null;
        GWindow instance = new GWindow();
        boolean expResult = false;
        boolean result = instance.equalsY(w);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of move method, of class GWindow.
     */
    @Test
    public void testMove() {
        System.out.println("move");
        double w = 0.0;
        double h = 0.0;
        GWindow instance = new GWindow();
        instance.move(w, h);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of toString method, of class GWindow.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        GWindow instance = new GWindow();
        String expResult = "";
        String result = instance.toString();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getXMax method, of class GWindow.
     */
    @Test
    public void testGetXMax() {
        System.out.println("getXMax");
        GWindow instance = new GWindow();
        double expResult = 0.0;
        double result = instance.getXMax();
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getYMax method, of class GWindow.
     */
    @Test
    public void testGetYMax() {
        System.out.println("getYMax");
        GWindow instance = new GWindow();
        double expResult = 0.0;
        double result = instance.getYMax();
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
