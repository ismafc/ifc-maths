/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package raytracer;

import static org.testng.Assert.*;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 *
 * @author ismaf
 */
public class MatrixNxMNGTest {
    
    private double[][] m1; 
    private double[][] m2; 
    private double[][] m3;
    private double[][] m4;
    private double[][] m23;
    private MatrixNxM matrix1;
    private MatrixNxM matrix2;
    private MatrixNxM matrix3;
    private MatrixNxM matrix4;
    private MatrixNxM matrix23;
    
    public MatrixNxMNGTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @BeforeMethod
    public void setUpMethod() throws Exception {
        m1 = new double[][] { {1} }; 
        m2 = new double[][] { {-1, 0},
                              {-2, 5 } }; 
        m3 = new double[][] { {6,-1, 2}, 
                              {3, 1, 2},
                              {0, 1, 3} };
        m4 = new double[][] { {1, 0, 1, 2}, 
                              {0, 1, 2, 1},
                              {3, 1, 1, 0},
                              {1, 1, 2, 4} };
        m23 = new double[][] { {-1, -1, 2}, 
                               {3, 0, -2} };
        matrix1 = new MatrixNxM(m1);
        matrix2 = new MatrixNxM(m2);
        matrix3 = new MatrixNxM(m3);
        matrix4 = new MatrixNxM(m4);
        matrix23 = new MatrixNxM(m23);
    }

    @AfterMethod
    public void tearDownMethod() throws Exception {
    }

    /**
     * Test of getRows method, of class MatrixNxM.
     */
    @Test
    public void testGetRows() {
        System.out.println("getRows");
        assertEquals(1, matrix1.getRows());
        assertEquals(2, matrix2.getRows());
        assertEquals(3, matrix3.getRows());
        assertEquals(4, matrix4.getRows());
        assertEquals(2, matrix23.getRows());
    }

    /**
     * Test of getColumns method, of class MatrixNxM.
     */
    @Test
    public void testGetColumns() {
        System.out.println("getColumns");
        assertEquals(1, matrix1.getColumns());
        assertEquals(2, matrix2.getColumns());
        assertEquals(3, matrix3.getColumns());
        assertEquals(4, matrix4.getColumns());
        assertEquals(3, matrix23.getColumns());
    }

    /**
     * Test of equals method, of class MatrixNxM.
     */
    @Test
    public void testEquals() {
        System.out.println("equals");
        assertTrue(matrix1.equals(new MatrixNxM(m1)));
        m1[0][0] = -1;
        assertFalse(matrix1.equals(new MatrixNxM(m1)));

        assertTrue(matrix2.equals(new MatrixNxM(m2)));
        m2[1][1] = 0;
        assertFalse(matrix2.equals(new MatrixNxM(m2)));
        
        assertTrue(matrix3.equals(new MatrixNxM(m3)));
        m3[2][2] = 0;
        assertFalse(matrix3.equals(new MatrixNxM(m3)));

        assertTrue(matrix4.equals(new MatrixNxM(m4)));
        m4[3][3] = 0;
        assertFalse(matrix4.equals(new MatrixNxM(m4)));
        
        assertTrue(matrix23.equals(new MatrixNxM(m23)));
        m23[1][1] = 1;
        assertFalse(matrix23.equals(new MatrixNxM(m23)));
        
        assertFalse(matrix1.equals(matrix2));
        assertFalse(matrix1.equals(matrix3));
        assertFalse(matrix1.equals(matrix4));
        assertFalse(matrix1.equals(matrix23));
        
        assertFalse(matrix2.equals(matrix1));
        assertFalse(matrix2.equals(matrix3));
        assertFalse(matrix2.equals(matrix4));
        assertFalse(matrix2.equals(matrix23));
        
        assertFalse(matrix3.equals(matrix1));
        assertFalse(matrix3.equals(matrix2));
        assertFalse(matrix3.equals(matrix4));
        assertFalse(matrix3.equals(matrix23));

        assertFalse(matrix4.equals(matrix1));
        assertFalse(matrix4.equals(matrix2));
        assertFalse(matrix4.equals(matrix3));
        assertFalse(matrix4.equals(matrix23));

        assertFalse(matrix23.equals(matrix1));
        assertFalse(matrix23.equals(matrix2));
        assertFalse(matrix23.equals(matrix3));
        assertFalse(matrix23.equals(matrix4));
    }

    /**
     * Test of transpose method, of class MatrixNxM.
     */
    @Test
    public void testTranspose() {
        System.out.println("transpose");
        assertEquals(matrix1.transpose(), new MatrixNxM(new double[][] {{1}}));
        assertEquals(matrix2.transpose(), new MatrixNxM(new double[][] {{-1, -2}, {0, 5}}));
        assertEquals(matrix3.transpose(), new MatrixNxM(new double[][] {{6, 3, 0}, {-1, 1, 1}, {2, 2, 3}}));
        assertEquals(matrix4.transpose(), new MatrixNxM(new double[][] {{1, 0, 3, 1}, {0, 1, 1, 1}, {1, 2, 1, 2}, {2, 1, 0, 4}}));
        assertEquals(matrix23.transpose(), new MatrixNxM(new double[][] {{-1, 3}, {-1, 0}, {2, -2}}));
    }

    /**
     * Test of getInverse method, of class MatrixNxM.
     */
    @Test
    public void testGetInverse() {
        System.out.println("getInverse");
        assertEquals(matrix1.getInverse(), new MatrixNxM(new double[][] {{1}}));
        assertEquals(matrix2.getInverse(), new MatrixNxM(new double[][] {{-1, 0}, {-2.0 / 5.0, 1.0 / 5.0}}));
        assertEquals(matrix3.getInverse(), new MatrixNxM(new double[][] {{1.0 / 21.0, 5.0 / 21.0, -4.0 / 21.0}, 
                                                                         {-3.0 / 7.0, 6.0 / 7.0, -2.0 / 7.0}, 
                                                                         {1.0 / 7.0, -2.0 / 7.0, 3.0 / 7.0}}));
        assertEquals(matrix4.getInverse(), new MatrixNxM(new double[][] {{3.0 / 11.0, -2.0 / 11.0, 3.0 / 11.0, -1.0 / 11.0}, 
                                                                         {-19.0 / 11.0, -2.0 / 11.0, 3.0 / 11.0, 10.0 / 11.0}, 
                                                                         {10.0 / 11.0, 8.0 / 11.0, -1.0 / 11.0, -7.0 / 11.0}, 
                                                                         {-1.0 / 11.0, -3.0 / 11.0, -1.0 / 11.0, 4.0 / 11.0}}));
        assertNull(matrix23.getInverse());
    }

    /**
     * Test of invert method, of class MatrixNxM.
     */
    @Test
    public void testInvert() {
        System.out.println("invert");
        assertTrue(matrix1.invert());
        assertEquals(matrix1, new MatrixNxM(new double[][] {{1}}));
        
        assertTrue(matrix2.invert());
        assertEquals(matrix2, new MatrixNxM(new double[][] {{-1, 0}, {-2.0 / 5.0, 1.0 / 5.0}}));
        
        assertTrue(matrix3.invert());
        assertEquals(matrix3, new MatrixNxM(new double[][] {{1.0 / 21.0, 5.0 / 21.0, -4.0 / 21.0}, 
                                                            {-3.0 / 7.0, 6.0 / 7.0, -2.0 / 7.0}, 
                                                            {1.0 / 7.0, -2.0 / 7.0, 3.0 / 7.0}}));
        
        assertTrue(matrix4.invert());
        assertEquals(matrix4, new MatrixNxM(new double[][] {{3.0 / 11.0, -2.0 / 11.0, 3.0 / 11.0, -1.0 / 11.0}, 
                                                            {-19.0 / 11.0, -2.0 / 11.0, 3.0 / 11.0, 10.0 / 11.0}, 
                                                            {10.0 / 11.0, 8.0 / 11.0, -1.0 / 11.0, -7.0 / 11.0}, 
                                                            {-1.0 / 11.0, -3.0 / 11.0, -1.0 / 11.0, 4.0 / 11.0}}));
        assertFalse(matrix23.invert());
    }

    /**
     * Test of set method, of class MatrixNxM.
     */
    @Test
    public void testSet_3args() {
        System.out.println("set(int, int, double)");
        assertFalse(matrix1.set(0, 1, 0.0));
        assertFalse(matrix1.set(1, 0, 0.0));
        assertFalse(matrix1.set(-1, -1, 0.0));
        assertTrue(matrix1.set(0, 0, -1.0));
        assertEquals(-1.0, matrix1.get(0, 0), 0.0);

        assertFalse(matrix23.set(2, 0, 0.0));
        assertFalse(matrix23.set(0, 3, 0.0));
        assertFalse(matrix23.set(-1, -1, 0.0));
        assertTrue(matrix23.set(1, 2, -1.0));
        assertEquals(-1.0, matrix23.get(1, 2), 0.0);
    }

    /**
     * Test of get method, of class MatrixNxM.
     */
    @Test
    public void testGet() {
        System.out.println("get(int, int)");
        assertTrue(Double.isNaN(matrix1.get(0, 1)));
        assertTrue(Double.isNaN(matrix1.get(1, 0)));
        assertTrue(Double.isNaN(matrix1.get(-1, -1)));
        assertEquals(1.0, matrix1.get(0, 0), 0.0);

        assertTrue(Double.isNaN(matrix23.get(2, 0)));
        assertTrue(Double.isNaN(matrix23.get(0, 3)));
        assertTrue(Double.isNaN(matrix23.get(-1, -1)));
        assertEquals(-2.0, matrix23.get(1, 2), 0.0);
    
        assertEquals(-1.0, matrix2.get(0, 0), 0.0);
        assertEquals(-2.0, matrix2.get(1, 0), 0.0);
        assertEquals(0.0, matrix2.get(0, 1), 0.0);
        assertEquals(5.0, matrix2.get(1, 1), 5.0);
    }

    /**
     * Test of set method, of class MatrixNxM.
     */
    @Test
    public void testSet_MatrixNxM() {
        System.out.println("set(MatrixNxM)");
        MatrixNxM maux = new MatrixNxM();
        maux.set(matrix1);
        assertEquals(maux, matrix1);
        maux.set(matrix2);
        assertEquals(maux, matrix2);
        maux.set(matrix3);
        assertEquals(maux, matrix3);
        maux.set(matrix4);
        assertEquals(maux, matrix4);
        maux.set(matrix23);
        assertEquals(maux, matrix23);
    }

    /**
     * Test of mul method, of class MatrixNxM.
     */
    @Test
    public void testMul_double() {
        System.out.println("mul(double)");
        matrix1.mul(4);
        assertEquals(matrix1, new MatrixNxM(new double[][] {{4}}));
        matrix2.mul(2);
        assertEquals(matrix2, new MatrixNxM(new double[][] {{-2, 0}, {-4, 10 }}));
        matrix23.mul(-3);
        assertEquals(matrix23, new MatrixNxM(new double[][] {{3, 3, -6}, {-9, 0, 6}}));
        matrix3.mul(-1);
        assertEquals(matrix3, new MatrixNxM(new double[][] {{-6, 1, -2}, {-3, -1, -2}, {0, -1, -3}}));
        matrix4.mul(1);
        assertEquals(matrix4, new MatrixNxM(new double[][] {{1, 0, 1, 2}, {0, 1, 2, 1}, {3, 1, 1, 0}, {1, 1, 2, 4}}));
    }

    /**
     * Test of mul method, of class MatrixNxM.
     */
    @Test
    public void testMul_MatrixNxM() {
        System.out.println("mul(MatrixNxM)");
        
        MatrixNxM instance = new MatrixNxM(matrix1);
        assertTrue(instance.mul(matrix1));
        assertEquals(instance, new MatrixNxM(new double[][] {{1}}));

        instance = new MatrixNxM(matrix2);
        assertTrue(instance.mul(matrix2));
        assertEquals(instance, new MatrixNxM(new double[][] {{1, 0}, {-8, 25}}));

        instance = new MatrixNxM(matrix3);
        assertTrue(instance.mul(matrix3));
        assertEquals(instance, new MatrixNxM(new double[][] {{33, -5, 16}, {21, 0, 14}, {3, 4, 11}}));

        instance = new MatrixNxM(matrix4);
        assertTrue(instance.mul(matrix4));
        assertEquals(instance, new MatrixNxM(new double[][] {{6, 3, 6, 10}, {7, 4, 6, 5}, {6, 2, 6, 7}, {11, 7, 13, 19}}));
        
        instance = new MatrixNxM(matrix23);
        assertTrue(instance.mul(matrix23.transpose()));
        assertEquals(instance, new MatrixNxM(new double[][] {{6, -7}, {-7, 13}}));

        instance = new MatrixNxM(matrix23);
        assertFalse(instance.mul(matrix23));
        assertFalse(matrix1.mul(matrix2));
        assertFalse(matrix3.mul(matrix4));
    }

    /**
     * Test of mul method, of class MatrixNxM.
     */
    @Test
    public void testMul_MatrixNxM_MatrixNxM() {
        System.out.println("mul(MatrixNxM, MatrixNxM)");
        MatrixNxM instance = MatrixNxM.mul(matrix1, matrix1);
        assertNotNull(instance);
        assertEquals(instance, new MatrixNxM(new double[][] {{1}}));

        instance = MatrixNxM.mul(matrix2, matrix2);
        assertNotNull(instance);
        assertEquals(instance, new MatrixNxM(new double[][] {{1, 0}, {-8, 25}}));

        instance = MatrixNxM.mul(matrix3, matrix3);
        assertNotNull(instance);
        assertEquals(instance, new MatrixNxM(new double[][] {{33, -5, 16}, {21, 0, 14}, {3, 4, 11}}));

        instance = MatrixNxM.mul(matrix4, matrix4);
        assertNotNull(instance);
        assertEquals(instance, new MatrixNxM(new double[][] {{6, 3, 6, 10}, {7, 4, 6, 5}, {6, 2, 6, 7}, {11, 7, 13, 19}}));
        
        instance = MatrixNxM.mul(matrix23, matrix23.transpose());
        assertNotNull(instance);
        assertEquals(instance, new MatrixNxM(new double[][] {{6, -7}, {-7, 13}}));

        instance = MatrixNxM.mul(matrix23, matrix23);
        assertNull(instance);
        assertNull(MatrixNxM.mul(matrix1,matrix2));
        assertNull(MatrixNxM.mul(matrix3,matrix4));
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
        System.out.println("div(double)");
        matrix1.div(4);
        assertEquals(matrix1, new MatrixNxM(new double[][] {{0.25}}));
        matrix2.div(2);
        assertEquals(matrix2, new MatrixNxM(new double[][] {{-0.5, 0}, {-1, 2.5}}));
        matrix23.div(-3);
        assertEquals(matrix23, new MatrixNxM(new double[][] {{1.0 / 3.0, 1.0 / 3.0, -2.0 / 3.0}, {-1, 0, 2.0 / 3.0}}));
        matrix3.div(-1);
        assertEquals(matrix3, new MatrixNxM(new double[][] {{-6, 1, -2}, {-3, -1, -2}, {0, -1, -3}}));
        matrix4.div(1);
        assertEquals(matrix4, new MatrixNxM(new double[][] {{1, 0, 1, 2}, {0, 1, 2, 1}, {3, 1, 1, 0}, {1, 1, 2, 4}}));
    }

    /**
     * Test of add method, of class MatrixNxM.
     */
    @Test
    public void testAdd() {
        System.out.println("add");       
        MatrixNxM instance = new MatrixNxM(matrix1);
        assertTrue(instance.add(matrix1));
        assertEquals(instance, new MatrixNxM(new double[][] {{2}}));
        instance = new MatrixNxM(matrix2);
        assertTrue(instance.add(matrix2));
        assertEquals(instance, new MatrixNxM(new double[][] {{-2, 0}, {-4, 10}}));
        instance = new MatrixNxM(matrix3);
        assertTrue(instance.add(matrix3));
        assertEquals(instance, new MatrixNxM(new double[][] {{12, -2, 4}, {6, 2, 4}, {0, 2, 6}}));
        instance = new MatrixNxM(matrix4);
        assertTrue(instance.add(matrix4));
        assertEquals(instance, new MatrixNxM(new double[][] {{2, 0, 2, 4}, {0, 2, 4, 2}, {6, 2, 2, 0}, {2, 2, 4, 8}}));
        instance = new MatrixNxM(matrix23);
        assertTrue(instance.add(matrix23));
        assertEquals(instance, new MatrixNxM(new double[][] {{-2, -2, 4}, {6, 0, -4}}));
        assertFalse(instance.add(matrix1));
        assertFalse(matrix2.add(matrix3));
        assertFalse(matrix4.add(matrix23));
    }

    /**
     * Test of sub method, of class MatrixNxM.
     */
    @Test
    public void testSub() {
        System.out.println("sub");
        MatrixNxM instance = new MatrixNxM(matrix1);
        assertTrue(instance.sub(matrix1));
        assertEquals(instance, new MatrixNxM(new double[][] {{0}}));
        instance = new MatrixNxM(matrix2);
        assertTrue(instance.sub(matrix2));
        assertEquals(instance, new MatrixNxM(new double[][] {{0, 0}, {0, 0}}));
        instance = new MatrixNxM(matrix3);
        assertTrue(instance.sub(matrix3));
        assertEquals(instance, new MatrixNxM(new double[][] {{0, 0, 0}, {0, 0, 0}, {0, 0, 0}}));
        instance = new MatrixNxM(matrix4);
        assertTrue(instance.sub(matrix4));
        assertEquals(instance, new MatrixNxM(new double[][] {{0, 0, 0, 0}, {0, 0, 0, 0}, {0, 0, 0, 0}, {0, 0, 0, 0}}));
        instance = new MatrixNxM(matrix23);
        assertTrue(instance.sub(matrix23));
        assertEquals(instance, new MatrixNxM(new double[][] {{0, 0, 0}, {0, 0, 0}}));

        instance = new MatrixNxM(matrix23);
        assertTrue(instance.sub(new MatrixNxM(new double[][] {{12, -2, 4}, {6, 2, 4}})));
        assertEquals(instance, new MatrixNxM(new double[][] {{-13, 1, -2}, {-3, -2, -6}}));

        instance = new MatrixNxM(new MatrixNxM(new double[][] {{12, -2, 4}, {6, 2, 4}}));
        assertTrue(instance.sub(matrix23));
        assertEquals(instance, new MatrixNxM(new double[][] {{13, -1, 2}, {3, 2, 6}}));

        assertFalse(instance.sub(matrix1));
        assertFalse(matrix2.sub(matrix3));
        assertFalse(matrix4.sub(matrix23));
    }

    /**
     * Test of determinant method, of class MatrixNxM.
     */
    @Test
    public void testDeterminant_0args() {
        System.out.println("determinant");
        assertEquals(matrix1.determinant(), 1.0);
        assertEquals(matrix2.determinant(), -5.0);
        assertEquals(matrix3.determinant(), 21.0);
        assertEquals(matrix4.determinant(), -11.0);
        assertEquals(matrix23.determinant(), Double.NaN);
    }

    /**
     * Test of isSquare method, of class MatrixNxM.
     */
    @Test
    public void testIsSquare_0args() {
        System.out.println("isSquare");
        assertEquals(true, matrix1.isSquare());
        assertEquals(true, matrix2.isSquare());
        assertEquals(true, matrix3.isSquare());
        assertEquals(true, matrix4.isSquare());
        assertEquals(false, matrix23.isSquare());
    }

    /**
     * Test of isSquare method, of class MatrixNxM.
     */
    @Test
    public void testIsSquare_MatrixNxM() {
        System.out.println("isSquare(MatrixNxM)");
        assertEquals(true, MatrixNxM.isSquare(matrix1));
        assertEquals(true, MatrixNxM.isSquare(matrix2));
        assertEquals(true, MatrixNxM.isSquare(matrix3));
        assertEquals(true, MatrixNxM.isSquare(matrix4));
        assertEquals(false, MatrixNxM.isSquare(matrix23));
    }

    /**
     * Test of isSquare method, of class MatrixNxM.
     */
    @Test
    public void testIsSquare_doubleArrArr() {
        System.out.println("isSquare(double[][] v)");
        assertEquals(true, MatrixNxM.isSquare(matrix1.values));
        assertEquals(true, MatrixNxM.isSquare(matrix2.values));
        assertEquals(true, MatrixNxM.isSquare(matrix3.values));
        assertEquals(true, MatrixNxM.isSquare(matrix4.values));
        assertEquals(false, MatrixNxM.isSquare(matrix23.values));
    }
    
    /**
     * Test of determinant method, of class MatrixNxM.
     */
    @Test
    public void testDeterminant_doubleArrArr() {
        System.out.println("determinant");
        assertEquals(MatrixNxM.determinant(matrix1.values), 1.0);
        assertEquals(MatrixNxM.determinant(matrix2.values), -5.0);
        assertEquals(MatrixNxM.determinant(matrix3.values), 21.0);
        assertEquals(MatrixNxM.determinant(matrix4.values), -11.0);
        assertEquals(MatrixNxM.determinant(matrix23.values), Double.NaN);
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

    /**
     * Test of toScale method, of class MatrixNxM.
     */
    @Test
    public void testToScale_3args() {
        System.out.println("toScale");
        double sx = 0.0;
        double sy = 0.0;
        double sz = 0.0;
        MatrixNxM instance = new MatrixNxM();
        boolean expResult = false;
        boolean result = instance.toScale(sx, sy, sz);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of toScale method, of class MatrixNxM.
     */
    @Test
    public void testToScale_Object3D() {
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
     * Test of hashCode method, of class MatrixNxM.
     */
    @Test
    public void testHashCode() {
        System.out.println("hashCode");
        assertEquals(matrix1.hashCode(), 1073312987);
        assertEquals(matrix2.hashCode(), 68025938);
        assertEquals(matrix3.hashCode(), -722114269);
        assertEquals(matrix4.hashCode(), 913968602);
        assertEquals(matrix23.hashCode(), 1545605709);
    }
    
}
