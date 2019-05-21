/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ProjectEuler.P001_010;

import ProjectEuler.P001_009.Problem001;
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
public class Problem001IT {
    
    public Problem001IT() {
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
     * Test of problem001 method, of class Problem001.
     */
    @Test
    public void testProblem001() {
        System.out.println("problem001");
        assertTrue(Problem001.problem001(3, 5, 1, 1000) == 233168);
        assertTrue(Problem001.problem001(10, 14, 1, 100) == 772);
        assertTrue(Problem001.problem001(10, 14, 71, 100) == 352);
    }
    
}
