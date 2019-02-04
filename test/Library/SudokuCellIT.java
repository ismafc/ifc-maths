/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Library;

import java.util.ArrayList;
import java.util.Iterator;
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
public class SudokuCellIT {
    
    public SudokuCellIT() {
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
     * Test of setPosibles method, of class SudokuCell.
     */
    @Test
    public void testSetPosibles_int() {
        System.out.println("setPosibles");
        int posibilities = 0;
        SudokuCell instance = new SudokuCell();
        instance.setPosibles(posibilities);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of fixTo method, of class SudokuCell.
     */
    @Test
    public void testFixTo() {
        System.out.println("fixTo");
        int value = 0;
        SudokuCell instance = new SudokuCell();
        instance.fixTo(value);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of isFixed method, of class SudokuCell.
     */
    @Test
    public void testIsFixed() {
        System.out.println("isFixed");
        SudokuCell instance = new SudokuCell();
        boolean expResult = false;
        boolean result = instance.isFixed();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of toString method, of class SudokuCell.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        SudokuCell instance = new SudokuCell();
        String expResult = "";
        String result = instance.toString();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of numberOfPosibilities method, of class SudokuCell.
     */
    @Test
    public void testNumberOfPosibilities() {
        System.out.println("numberOfPosibilities");
        SudokuCell instance = new SudokuCell();
        int expResult = 0;
        int result = instance.numberOfPosibilities();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getPosibility method, of class SudokuCell.
     */
    @Test
    public void testGetPosibility() {
        System.out.println("getPosibility");
        int i = 0;
        SudokuCell instance = new SudokuCell();
        int expResult = 0;
        int result = instance.getPosibility(i);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getValue method, of class SudokuCell.
     */
    @Test
    public void testGetValue() {
        System.out.println("getValue");
        SudokuCell instance = new SudokuCell();
        int expResult = 0;
        int result = instance.getValue();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of isPosible method, of class SudokuCell.
     */
    @Test
    public void testIsPosible() {
        System.out.println("isPosible");
        int value = 0;
        SudokuCell instance = new SudokuCell();
        boolean expResult = false;
        boolean result = instance.isPosible(value);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of removePosibility method, of class SudokuCell.
     */
    @Test
    public void testRemovePosibility() {
        System.out.println("removePosibility");
        int value = 0;
        SudokuCell instance = new SudokuCell();
        boolean expResult = false;
        boolean result = instance.removePosibility(value);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of equals method, of class SudokuCell.
     */
    @Test
    public void testEquals() {
        System.out.println("equals");
        Object o = null;
        SudokuCell instance = new SudokuCell();
        boolean expResult = false;
        boolean result = instance.equals(o);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of hashCode method, of class SudokuCell.
     */
    @Test
    public void testHashCode() {
        System.out.println("hashCode");
        SudokuCell instance = new SudokuCell();
        int expResult = 0;
        int result = instance.hashCode();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of clone method, of class SudokuCell.
     */
    @Test
    public void testClone() {
        System.out.println("clone");
        SudokuCell instance = new SudokuCell();
        SudokuCell expResult = null;
        SudokuCell result = instance.clone();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of iterator method, of class SudokuCell.
     */
    @Test
    public void testIterator() {
        System.out.println("iterator");
        SudokuCell instance = new SudokuCell();
        Iterator<Integer> expResult = null;
        Iterator<Integer> result = instance.iterator();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setPosibles method, of class SudokuCell.
     */
    @Test
    public void testSetPosibles_ArrayList() {
        System.out.println("setPosibles");
        ArrayList<Integer> ps = null;
        SudokuCell instance = new SudokuCell();
        instance.setPosibles(ps);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
