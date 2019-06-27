/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package raytracer;

import ProjectEuler.Triangle;
import java.math.BigDecimal;
import java.math.BigInteger;
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
public class MainIT {
    
    public MainIT() {
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
     * Test of get method, of class Main.
     */
    @Test
    public void testGet() {
        System.out.println("get");
        BigDecimal n = null;
        BigDecimal expResult = null;
        BigDecimal result = Main.get(n);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getSum method, of class Main.
     */
    @Test
    public void testGetSum() {
        System.out.println("getSum");
        ArrayList<Integer> set = null;
        int group = 0;
        boolean first = false;
        int expResult = 0;
        int result = Main.getSum(set, group, first);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of ObtenerAdyacencias method, of class Main.
     */
    @Test
    public void testObtenerAdyacencias() {
        System.out.println("ObtenerAdyacencias");
        ArrayList<Integer> network = null;
        int a = 0;
        ArrayList<Integer> expResult = null;
        ArrayList<Integer> result = Main.ObtenerAdyacencias(network, a);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of obtenerPeso method, of class Main.
     */
    @Test
    public void testObtenerPeso() {
        System.out.println("obtenerPeso");
        ArrayList<Integer> network = null;
        int expResult = 0;
        int result = Main.obtenerPeso(network);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of sonAdyacentes method, of class Main.
     */
    @Test
    public void testSonAdyacentes() {
        System.out.println("sonAdyacentes");
        ArrayList<Integer> network = null;
        int a = 0;
        int b = 0;
        boolean expResult = false;
        boolean result = Main.sonAdyacentes(network, a, b);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of chooseMinimumEdge method, of class Main.
     */
    @Test
    public void testChooseMinimumEdge() {
        System.out.println("chooseMinimumEdge");
        ArrayList<Integer> network = null;
        ArrayList<Integer> vnodes = null;
        Triangle expResult = null;
        Triangle result = Main.chooseMinimumEdge(network, vnodes);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of combinaciones method, of class Main.
     */
    @Test
    public void testCombinaciones() {
        System.out.println("combinaciones");
        long ltotal = 0L;
        long lmin = 0L;
        long expResult = 0L;
        long result = Main.combinaciones(ltotal, lmin);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of main method, of class Main.
     */
    @Test
    public void testMain() throws Exception {
        System.out.println("main");
        String[] args = null;
        Main.main(args);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getValue method, of class Main.
     */
    @Test
    public void testGetValue_3args_1() {
        System.out.println("getValue");
        String v = "";
        long default_value = 0L;
        String name = "";
        long expResult = 0L;
        long result = Main.getValue(v, default_value, name);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getValue method, of class Main.
     */
    @Test
    public void testGetValue_3args_2() {
        System.out.println("getValue");
        String v = "";
        BigInteger default_value = null;
        String name = "";
        BigInteger expResult = null;
        BigInteger result = Main.getValue(v, default_value, name);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getArgument method, of class Main.
     */
    @Test
    public void testGetArgument_3args_1() {
        System.out.println("getArgument");
        String[] args = null;
        long default_value = 0L;
        String name = "";
        long expResult = 0L;
        long result = Main.getArgument(args, default_value, name);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getArgument method, of class Main.
     */
    @Test
    public void testGetArgument_3args_2() {
        System.out.println("getArgument");
        String[] args = null;
        BigInteger default_value = null;
        String name = "";
        BigInteger expResult = null;
        BigInteger result = Main.getArgument(args, default_value, name);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
