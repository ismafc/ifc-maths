/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package raytracer;

import Library.Tree;
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
public class TreeIT {
    
    public TreeIT() {
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
     * Test of getValue method, of class Tree.
     */
    @Test
    public void testGetValue() {
        System.out.println("getValue");
        Tree instance = new Tree();
        Object expResult = null;
        Object result = instance.getValue();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setValue method, of class Tree.
     */
    @Test
    public void testSetValue() {
        System.out.println("setValue");
        Object v = null;
        Tree instance = new Tree();
        instance.setValue(v);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getParent method, of class Tree.
     */
    @Test
    public void testGetParent() {
        System.out.println("getParent");
        Tree instance = new Tree();
        Tree expResult = null;
        Tree result = instance.getParent();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setParent method, of class Tree.
     */
    @Test
    public void testSetParent() {
        System.out.println("setParent");
        Tree instance = new Tree();
        instance.setParent(null);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getBranch method, of class Tree.
     */
    @Test
    public void testGetBranch_int() {
        System.out.println("getBranch");
        int i = 0;
        Tree instance = new Tree();
        Tree expResult = null;
        Tree result = instance.getBranch(i);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getBranch method, of class Tree.
     */
    @Test
    public void testGetBranch_GenericType() {
        System.out.println("getBranch");
        Object v = null;
        Tree instance = new Tree();
        Tree expResult = null;
        Tree result = instance.getBranch(v);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getBranchIndex method, of class Tree.
     */
    @Test
    public void testGetBranchIndex() {
        System.out.println("getBranchIndex");
        Tree instance = new Tree();
        int expResult = 0;
        int result = instance.getBranchIndex(null);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of move method, of class Tree.
     */
    @Test
    public void testMove() {
        System.out.println("move");
        Tree instance = new Tree();
        instance.move(null, null);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getLevel method, of class Tree.
     */
    @Test
    public void testGetLevel() {
        System.out.println("getLevel");
        Tree instance = new Tree();
        int expResult = 0;
        int result = instance.getLevel();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of addBranch method, of class Tree.
     */
    @Test
    public void testAddBranch() {
        System.out.println("addBranch");
        Tree instance = new Tree();
        instance.addBranch(null);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of removeAllBranches method, of class Tree.
     */
    @Test
    public void testRemoveAllBranches() {
        System.out.println("removeAllBranches");
        Tree instance = new Tree();
        instance.removeAllBranches();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of removeBranch method, of class Tree.
     */
    @Test
    public void testRemoveBranch() {
        System.out.println("removeBranch");
        int i = 0;
        Tree instance = new Tree();
        Tree expResult = null;
        Tree result = instance.removeBranch(i);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of isRoot method, of class Tree.
     */
    @Test
    public void testIsRoot() {
        System.out.println("isRoot");
        Tree instance = new Tree();
        boolean expResult = false;
        boolean result = instance.isRoot();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of isLeaf method, of class Tree.
     */
    @Test
    public void testIsLeaf() {
        System.out.println("isLeaf");
        Tree instance = new Tree();
        boolean expResult = false;
        boolean result = instance.isLeaf();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getNumberOfBranches method, of class Tree.
     */
    @Test
    public void testGetNumberOfBranches() {
        System.out.println("getNumberOfBranches");
        Tree instance = new Tree();
        int expResult = 0;
        int result = instance.getNumberOfBranches();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
