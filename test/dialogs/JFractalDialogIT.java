/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dialogs;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import Library.Complex;
import raytracer.GWindow;

/**
 *
 * @author ismael.flores
 */
public class JFractalDialogIT {
    
    public JFractalDialogIT() {
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
     * Test of setWindow method, of class JFractalDialog.
     */
    @Test
    public void testSetWindow() {
        System.out.println("setWindow");
        GWindow w = null;
        JFractalDialog instance = null;
        instance.setWindow(w);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setDimensions method, of class JFractalDialog.
     */
    @Test
    public void testSetDimensions() {
        System.out.println("setDimensions");
        Dimension d = null;
        JFractalDialog instance = null;
        instance.setDimensions(d);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setInitialValue method, of class JFractalDialog.
     */
    @Test
    public void testSetInitialValue() {
        System.out.println("setInitialValue");
        Complex i = null;
        JFractalDialog instance = null;
        instance.setInitialValue(i);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of clearColors method, of class JFractalDialog.
     */
    @Test
    public void testClearColors() {
        System.out.println("clearColors");
        JFractalDialog instance = null;
        instance.clearColors();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of addColor method, of class JFractalDialog.
     */
    @Test
    public void testAddColor() {
        System.out.println("addColor");
        Color c = null;
        JFractalDialog instance = null;
        instance.addColor(c);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setAnimationFrameTime method, of class JFractalDialog.
     */
    @Test
    public void testSetAnimationFrameTime() {
        System.out.println("setAnimationFrameTime");
        int milis = 0;
        JFractalDialog instance = null;
        instance.setAnimationFrameTime(milis);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of createMandelbrot method, of class JFractalDialog.
     */
    @Test
    public void testCreateMandelbrot() {
        System.out.println("createMandelbrot");
        int steps = 0;
        JFractalDialog instance = null;
        instance.createMandelbrot(steps);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of GO method, of class JFractalDialog.
     */
    @Test
    public void testGO() {
        System.out.println("GO");
        JFractalDialog instance = null;
        instance.GO();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of paint method, of class JFractalDialog.
     */
    @Test
    public void testPaint() {
        System.out.println("paint");
        Graphics g = null;
        JFractalDialog instance = null;
        instance.paint(g);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of actionPerformed method, of class JFractalDialog.
     */
    @Test
    public void testActionPerformed() {
        System.out.println("actionPerformed");
        ActionEvent e = null;
        JFractalDialog instance = null;
        instance.actionPerformed(e);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setMandelbrotColor method, of class JFractalDialog.
     */
    @Test
    public void testSetMandelbrotColor() {
        System.out.println("setMandelbrotColor");
        Color c = null;
        JFractalDialog instance = null;
        instance.setMandelbrotColor(c);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of STOP method, of class JFractalDialog.
     */
    @Test
    public void testSTOP() {
        System.out.println("STOP");
        JFractalDialog instance = null;
        instance.STOP();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
