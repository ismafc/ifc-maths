/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Library;

import java.util.ArrayList;
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
public class SudokuIT {
    
    public SudokuIT() {
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
     * Test of solve method, of class Sudoku.
     */
    @Test
    public void testSolve_0args() {
        System.out.println("solve");
        Sudoku instance = new Sudoku();
        ArrayList<Sudoku> expResult = null;
        ArrayList<Sudoku> result = instance.solve();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of solve method, of class Sudoku.
     */
    @Test
    public void testSolve_boolean() {
        System.out.println("solve");
        boolean debug = false;
        Sudoku instance = new Sudoku();
        ArrayList<Sudoku> expResult = null;
        ArrayList<Sudoku> result = instance.solve(debug);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of isDone method, of class Sudoku.
     */
    @Test
    public void testIsDone() {
        System.out.println("isDone");
        Sudoku instance = new Sudoku();
        boolean expResult = false;
        boolean result = instance.isDone();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of set method, of class Sudoku.
     */
    @Test
    public void testSet() {
        System.out.println("set");
        int i = 0;
        int j = 0;
        int value = 0;
        Sudoku instance = new Sudoku();
        instance.set(i, j, value);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of get method, of class Sudoku.
     */
    @Test
    public void testGet() {
        System.out.println("get");
        int i = 0;
        int j = 0;
        Sudoku instance = new Sudoku();
        SudokuCell expResult = null;
        SudokuCell result = instance.get(i, j);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getFixedCells method, of class Sudoku.
     */
    @Test
    public void testGetFixedCells() {
        System.out.println("getFixedCells");
        Sudoku instance = new Sudoku();
        int expResult = 0;
        int result = instance.getFixedCells();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of increaseLevel method, of class Sudoku.
     */
    @Test
    public void testIncreaseLevel() {
        System.out.println("increaseLevel");
        int level = 0;
        int max = 0;
        Sudoku instance = new Sudoku();
        ArrayList<Sudoku> expResult = null;
        ArrayList<Sudoku> result = instance.increaseLevel(level, max);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of equals method, of class Sudoku.
     */
    @Test
    public void testEquals() {
        System.out.println("equals");
        Object o = null;
        Sudoku instance = new Sudoku();
        boolean expResult = false;
        boolean result = instance.equals(o);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of hashCode method, of class Sudoku.
     */
    @Test
    public void testHashCode() {
        System.out.println("hashCode");
        Sudoku instance = new Sudoku();
        int expResult = 0;
        int result = instance.hashCode();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of toString method, of class Sudoku.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        Sudoku instance = new Sudoku();
        String expResult = "";
        String result = instance.toString();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
