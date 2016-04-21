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
    
    private Box3D small;
    private Box3D big;
    private Box3D external;
    
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
        Point3D p1 = new Point3D(-1.0, -1.0, -1.0);
        Point3D p2 = new Point3D(1.0, 2.0, 3.0);
        big = new Box3D(p1, p2);
        p1 = new Point3D(-0.5, 0.0, 1.0);
        p2 = new Point3D(0.5, 1.0, 2.0);
        small = new Box3D(p1, p2);
        p1 = new Point3D(-5.0, -4.0, -5.0);
        p2 = new Point3D(-4.0, -3.0, -3.0);
        external = new Box3D(p1, p2);
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of set method, of class Box3D.
     */
    @Test
    public void testSet() {
        System.out.println("set(Point3D)");
        big.set(Point3D.ZERO);
        assertEquals(0.0, big.volume(), 0.0);
        assertEquals(big.pMin, Point3D.ZERO);
        assertEquals(big.pMax, Point3D.ZERO);
        Point3D p = new Point3D(-1.0, 1.0, 3.0);
        big.set(p);
        assertEquals(0.0, big.volume(), 0.0);
        assertEquals(big.pMin, p);
        assertEquals(big.pMax, p);
    }

    /**
     * Test of union method, of class Box3D.
     */
    @Test
    public void testUnion_Object3D() {
        System.out.println("union(Object3D)");
        Box3D b = new Box3D(external);
        b = b.union(external.pMax);
        assertEquals(b, external);
        b = b.union(small.pMax);
        assertEquals(b, new Box3D(external.pMin, small.pMax));
        b = b.union(big.pMax);
        assertEquals(b, new Box3D(external.pMin, big.pMax));
        b = b.union(Point3D.ZERO);
        assertEquals(b, new Box3D(external.pMin, big.pMax));
        
        b = new Box3D(big);
        b = b.union(small.pMax);
        b = b.union(small.pMin);
        assertEquals(b, big);
        b = b.union(external.pMin);
        assertEquals(b, new Box3D(external.pMin, big.pMax));
        
        b = new Box3D(small);
        b = b.union(big.pMax);
        assertEquals(b, new Box3D(small.pMin, big.pMax));
        b = b.union(external.pMax);
        assertEquals(b, new Box3D(external.pMax, big.pMax));
    }

    /**
     * Test of union method, of class Box3D.
     */
    @Test
    public void testUnion_Box3D() {
        System.out.println("union(Box3D)");
        Box3D b = new Box3D(external);
        b = b.union(external);
        assertEquals(b, external);
        b = b.union(small);
        assertEquals(b, new Box3D(external.pMin, small.pMax));
        b = b.union(big);
        assertEquals(b, new Box3D(external.pMin, big.pMax));
        
        b = new Box3D(big);
        b = b.union(small);
        assertEquals(b, big);
        b = b.union(external);
        assertEquals(b, new Box3D(external.pMin, big.pMax));
        
        b = new Box3D(small);
        b = b.union(big);
        assertEquals(b, big);
        b = b.union(external);
        assertEquals(b, new Box3D(external.pMin, big.pMax));
    }

    /**
     * Test of overlaps method, of class Box3D.
     */
    @Test
    public void testOverlaps_Box3D() {
        System.out.println("overlaps(Box3D)");
        Box3D smallexternal = new Box3D(external);
        smallexternal = smallexternal.union(small);
        assertTrue(smallexternal.overlaps(big));
        assertTrue(big.overlaps(smallexternal));
        
        assertFalse(external.overlaps(big));
        assertFalse(external.overlaps(small));
        assertFalse(big.overlaps(external));
        assertFalse(small.overlaps(external));
        
        assertTrue(big.overlaps(small));        
        assertTrue(small.overlaps(big));
    }

    /**
     * Test of inside method, of class Box3D.
     */
    @Test
    public void testInside_Object3D() {
        System.out.println("inside(Object3D");
        
        Point3D p = new Point3D(-2, -2, -2);
        assertFalse(external.inside(p));
        assertFalse(big.inside(p));
        assertFalse(small.inside(p));
        
        p = new Point3D(-4, -4, -4);
        assertTrue(external.inside(p));
        assertFalse(big.inside(p));
        assertFalse(small.inside(p));
        
        p = new Point3D(0, 0, 2);
        assertFalse(external.inside(p));
        assertTrue(big.inside(p));
        assertTrue(small.inside(p));
        
        assertFalse(external.inside(Point3D.ZERO));
        assertTrue(big.inside(Point3D.ZERO));
        assertFalse(small.inside(Point3D.ZERO));
    }

    /**
     * Test of expand method, of class Box3D.
     */
    @Test
    public void testExpand() {
        System.out.println("expand(double)");
        double delta = 1.0;
        Box3D b1 = big.expand(delta);
        Box3D b2 = big.expand(-delta);
        assertEquals(b1, b2);
        assertEquals(b1, new Box3D(new Point3D(-2, -2, -2), new Point3D(2, 3, 4)));
        
        b1 = small.expand(delta);
        b2 = small.expand(-delta);
        assertEquals(b1, b2);
        assertEquals(b1, new Box3D(new Point3D(-1.5, -1, 0), new Point3D(1.5, 2, 3)));
        
        b1 = external.expand(delta);
        b2 = external.expand(-delta);
        assertEquals(b1, b2);
        assertEquals(b1, new Box3D(new Point3D(-6, -5, -6), new Point3D(-3, -2, -2)));
    }

    /**
     * Test of volume method, of class Box3D.
     */
    @Test
    public void testVolume() {
        System.out.println("volume");
        assertEquals(external.volume(), 2.0, 0.0);
        assertEquals(big.volume(), 24.0, 0.0);
        assertEquals(small.volume(), 1.0, 0.0);
        assertEquals(external.union(big).volume(), 288.0, 0.0);
        assertEquals(external.union(small).volume(), 192.5, 0.0);
    }

    /**
     * Test of union method, of class Box3D.
     */
    @Test
    public void testUnion_Box3D_Object3D() {
        System.out.println("union(Box3D, Object3D)");
        Box3D b = new Box3D(external);
        b = Box3D.union(b, external.pMax);
        assertEquals(b, external);
        b = Box3D.union(b, small.pMax);
        assertEquals(b, new Box3D(external.pMin, small.pMax));
        b = Box3D.union(b, big.pMax);
        assertEquals(b, new Box3D(external.pMin, big.pMax));
        assertEquals(Box3D.union(b, Point3D.ZERO), new Box3D(external.pMin, big.pMax));
        
        b = new Box3D(big);
        b = Box3D.union(b, small.pMax);
        b = Box3D.union(b, small.pMin);
        assertEquals(b, big);
        assertEquals(Box3D.union(b, external.pMin), new Box3D(external.pMin, big.pMax));
        
        b = new Box3D(small);
        b = Box3D.union(b, big.pMax);
        assertEquals(b, new Box3D(small.pMin, big.pMax));
        assertEquals(Box3D.union(b, external.pMax), new Box3D(external.pMax, big.pMax));
    }

    /**
     * Test of union method, of class Box3D.
     */
    @Test
    public void testUnion_Box3D_Box3D() {
        System.out.println("union(Box3D, Box3D)");
        Box3D b = new Box3D(external);
        b = Box3D.union(b, external);
        assertEquals(b, external);
        b = Box3D.union(b, small);
        assertEquals(b, new Box3D(external.pMin, small.pMax));
        assertEquals(Box3D.union(b, big), new Box3D(external.pMin, big.pMax));
        
        b = new Box3D(big);
        b = Box3D.union(b, small);
        assertEquals(b, big);
        assertEquals(Box3D.union(b, external), new Box3D(external.pMin, big.pMax));
        
        b = new Box3D(small);
        b = Box3D.union(b, big);
        assertEquals(b, big);
        assertEquals(Box3D.union(b, external), new Box3D(external.pMin, big.pMax));
    }

    /**
     * Test of overlaps method, of class Box3D.
     */
    @Test
    public void testOverlaps_Box3D_Box3D() {
        System.out.println("overlaps(Box3D, Box3D)");
        
        Box3D smallexternal = new Box3D(external);
        smallexternal = smallexternal.union(small);
        assertTrue(Box3D.overlaps(smallexternal, big));
        assertTrue(Box3D.overlaps(big, smallexternal));
        
        assertFalse(Box3D.overlaps(external, big));
        assertFalse(Box3D.overlaps(external, small));
        assertFalse(Box3D.overlaps(big, external));
        assertFalse(Box3D.overlaps(small, external));
        
        assertTrue(Box3D.overlaps(big, small));
        assertTrue(Box3D.overlaps(small, big));
    }

    /**
     * Test of inside method, of class Box3D.
     */
    @Test
    public void testInside_Box3D_Object3D() {
        System.out.println("inside(Box3D, Object3D)");
        
        Point3D p = new Point3D(-2, -2, -2);
        assertFalse(Box3D.inside(external, p));
        assertFalse(Box3D.inside(big, p));
        assertFalse(Box3D.inside(small, p));
        
        p = new Point3D(-4, -4, -4);
        assertTrue(Box3D.inside(external, p));
        assertFalse(Box3D.inside(big, p));
        assertFalse(Box3D.inside(small, p));
        
        p = new Point3D(0, 0, 2);
        assertFalse(Box3D.inside(external, p));
        assertTrue(Box3D.inside(big, p));
        assertTrue(Box3D.inside(small, p));
        
        assertFalse(Box3D.inside(external, Point3D.ZERO));
        assertTrue(Box3D.inside(big, Point3D.ZERO));
        assertFalse(Box3D.inside(small, Point3D.ZERO));
    }

    /**
     * Test of equals method, of class Box3D.
     */
    @Test
    public void testEquals() {
        System.out.println("equals(Object)");
        assertFalse(big.equals(small));
        assertFalse(small.equals(big));
        assertFalse(big.equals(external));
        assertFalse(external.equals(big));
        assertFalse(small.equals(external));
        assertFalse(external.equals(small));
        assertTrue(big.equals(small.union(big)));
        assertTrue(big.union(small).equals(big));
    }

    /**
     * Test of toString method, of class Box3D.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        assertEquals(big.toString(), "[(-1.0, -1.0, -1.0), (1.0, 2.0, 3.0)]");
        assertEquals(small.toString(), "[(-0.5, 0.0, 1.0), (0.5, 1.0, 2.0)]");
        assertEquals(external.toString(), "[(-5.0, -4.0, -5.0), (-4.0, -3.0, -3.0)]");
    }

    /**
     * Test of hashCode method, of class Box3D.
     */
    @Test
    public void testHashCode() {
        System.out.println("hashCode");
        assertEquals(big.hashCode(), -1609395485);
        assertEquals(small.hashCode(), -1561685277);
        assertEquals(external.hashCode(), -501050653);
    }
    
}
