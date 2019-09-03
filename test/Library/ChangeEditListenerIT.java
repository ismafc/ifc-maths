/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Library;

import javafx.beans.value.ObservableValue;
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
public class ChangeEditListenerIT {
    
    public ChangeEditListenerIT() {
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
     * Test of changed method, of class ChangeEditListener.
     */
    @Test
    public void testChanged() {
        System.out.println("changed");
        ObservableValue<? extends String> observable = null;
        String oldValue = "";
        String newValue = "";
        ChangeEditListener instance = null;
        instance.changed(observable, oldValue, newValue);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
