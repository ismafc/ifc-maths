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
public class MatrixNxMIT {
    
    public MatrixNxMIT() {
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
     * Test of getRows method, of class MatrixNxM.
     */
    @Test
    public void testGetRows() {
        System.out.println("getRows");
        MatrixNxM instance = new MatrixNxM();
        int expResult = 0;
        int result = instance.getRows();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getColumns method, of class MatrixNxM.
     */
    @Test
    public void testGetColumns() {
        System.out.println("getColumns");
        MatrixNxM instance = new MatrixNxM();
        int expResult = 0;
        int result = instance.getColumns();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of equals method, of class MatrixNxM.
     */
    @Test
    public void testEquals() {
        System.out.println("equals");
        MatrixNxM m = null;
        MatrixNxM instance = new MatrixNxM();
        boolean expResult = false;
        boolean result = instance.equals(m);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of transpose method, of class MatrixNxM.
     */
    @Test
    public void testTranspose() {
        System.out.println("transpose");
        MatrixNxM instance = new MatrixNxM();
        instance.transpose();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getInverse method, of class MatrixNxM.
     */
    @Test
    public void testGetInverse() {
        System.out.println("getInverse");
        MatrixNxM instance = new MatrixNxM();
        MatrixNxM expResult = null;
        MatrixNxM result = instance.getInverse();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of invert method, of class MatrixNxM.
     */
    @Test
    public void testInvert() {
        System.out.println("invert");
        MatrixNxM instance = new MatrixNxM();
        boolean expResult = false;
        boolean result = instance.invert();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of set method, of class MatrixNxM.
     */
    @Test
    public void testSet_3args() {
        System.out.println("set");
        int i = 0;
        int j = 0;
        double v = 0.0;
        MatrixNxM instance = new MatrixNxM();
        instance.set(i, j, v);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of get method, of class MatrixNxM.
     */
    @Test
    public void testGet() {
        System.out.println("get");
        int row = 0;
        int column = 0;
        MatrixNxM instance = new MatrixNxM();
        double expResult = 0.0;
        double result = instance.get(row, column);
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of set method, of class MatrixNxM.
     */
    @Test
    public void testSet_MatrixNxM() {
        System.out.println("set");
        MatrixNxM m = null;
        MatrixNxM instance = new MatrixNxM();
        instance.set(m);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of mul method, of class MatrixNxM.
     */
    @Test
    public void testMul_double() {
        System.out.println("mul");
        double v = 0.0;
        MatrixNxM instance = new MatrixNxM();
        instance.mul(v);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of mul method, of class MatrixNxM.
     */
    @Test
    public void testMul_MatrixNxM() {
        System.out.println("mul");
        MatrixNxM m = null;
        MatrixNxM instance = new MatrixNxM();
        boolean expResult = false;
        boolean result = instance.mul(m);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of mul method, of class MatrixNxM.
     */
    @Test
    public void testMul_MatrixNxM_MatrixNxM() {
        System.out.println("mul");
        MatrixNxM m1 = null;
        MatrixNxM m2 = null;
        MatrixNxM expResult = null;
        MatrixNxM result = MatrixNxM.mul(m1, m2);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of toNull method, of class MatrixNxM.
     */
    @Test
    public void testToNull() {
        System.out.println("toNull");
        MatrixNxM instance = new MatrixNxM();
        instance.toNull();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of toIdentity method, of class MatrixNxM.
     */
    @Test
    public void testToIdentity() {
        System.out.println("toIdentity");
        MatrixNxM instance = new MatrixNxM();
        boolean expResult = false;
        boolean result = instance.toIdentity();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of toTranslation method, of class MatrixNxM.
     */
    @Test
    public void testToTranslation() {
        System.out.println("toTranslation");
        Object3D o = null;
        MatrixNxM instance = new MatrixNxM();
        boolean expResult = false;
        boolean result = instance.toTranslation(o);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of toScale method, of class MatrixNxM.
     */
    @Test
    public void testToScale() {
        System.out.println("toScale");
        Object3D o = null;
        MatrixNxM instance = new MatrixNxM();
        boolean expResult = false;
        boolean result = instance.toScale(o);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of toRotationX method, of class MatrixNxM.
     */
    @Test
    public void testToRotationX() {
        System.out.println("toRotationX");
        double r = 0.0;
        MatrixNxM instance = new MatrixNxM();
        boolean expResult = false;
        boolean result = instance.toRotationX(r);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of toRotationY method, of class MatrixNxM.
     */
    @Test
    public void testToRotationY() {
        System.out.println("toRotationY");
        double r = 0.0;
        MatrixNxM instance = new MatrixNxM();
        boolean expResult = false;
        boolean result = instance.toRotationY(r);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of toRotationZ method, of class MatrixNxM.
     */
    @Test
    public void testToRotationZ() {
        System.out.println("toRotationZ");
        double r = 0.0;
        MatrixNxM instance = new MatrixNxM();
        boolean expResult = false;
        boolean result = instance.toRotationZ(r);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of toRotation method, of class MatrixNxM.
     */
    @Test
    public void testToRotation() {
        System.out.println("toRotation");
        double r = 0.0;
        Object3D o = null;
        MatrixNxM instance = new MatrixNxM();
        boolean expResult = false;
        boolean result = instance.toRotation(r, o);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of lookAt method, of class MatrixNxM.
     */
    @Test
    public void testLookAt() {
        System.out.println("lookAt");
        Point3D pos = null;
        Point3D look = null;
        Vector3D up = null;
        MatrixNxM instance = new MatrixNxM();
        boolean expResult = false;
        boolean result = instance.lookAt(pos, look, up);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of transform method, of class MatrixNxM.
     */
    @Test
    public void testTransform_Object3D() {
        System.out.println("transform");
        Object3D o = null;
        MatrixNxM instance = new MatrixNxM();
        boolean expResult = false;
        boolean result = instance.transform(o);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of transform method, of class MatrixNxM.
     */
    @Test
    public void testTransform_Ray3D() {
        System.out.println("transform");
        Ray3D r = null;
        MatrixNxM instance = new MatrixNxM();
        boolean expResult = false;
        boolean result = instance.transform(r);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of transform method, of class MatrixNxM.
     */
    @Test
    public void testTransform_Box3D() {
        System.out.println("transform");
        Box3D b = null;
        MatrixNxM instance = new MatrixNxM();
        instance.transform(b);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of swapsHandedness method, of class MatrixNxM.
     */
    @Test
    public void testSwapsHandedness() {
        System.out.println("swapsHandedness");
        MatrixNxM instance = new MatrixNxM();
        boolean expResult = false;
        boolean result = instance.swapsHandedness();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of div method, of class MatrixNxM.
     */
    @Test
    public void testDiv() {
        System.out.println("div");
        double v = 0.0;
        MatrixNxM instance = new MatrixNxM();
        instance.div(v);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of add method, of class MatrixNxM.
     */
    @Test
    public void testAdd() {
        System.out.println("add");
        MatrixNxM m = null;
        MatrixNxM instance = new MatrixNxM();
        boolean expResult = false;
        boolean result = instance.add(m);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of sub method, of class MatrixNxM.
     */
    @Test
    public void testSub() {
        System.out.println("sub");
        MatrixNxM m = null;
        MatrixNxM instance = new MatrixNxM();
        boolean expResult = false;
        boolean result = instance.sub(m);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of determinant method, of class MatrixNxM.
     */
    @Test
    public void testDeterminant_0args() {
        System.out.println("determinant");
        MatrixNxM instance = new MatrixNxM();
        double expResult = 0.0;
        double result = instance.determinant();
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of determinant method, of class MatrixNxM.
     */
    @Test
    public void testDeterminant_doubleArrArr() {
        System.out.println("determinant");
        double[][] v = null;
        double expResult = 0.0;
        double result = MatrixNxM.determinant(v);
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of toString method, of class MatrixNxM.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        MatrixNxM instance = new MatrixNxM();
        String expResult = "";
        String result = instance.toString();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
