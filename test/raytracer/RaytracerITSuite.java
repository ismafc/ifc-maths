/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package raytracer;

import Library.TreeIT;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 *
 * @author ismael.flores
 */
@RunWith(Suite.class)
@Suite.SuiteClasses({GWindowIT.class, IFCMathIT.class, Object3DIT.class, Point3DIT.class, Ray3DIT.class, MainIT.class, Vector3DIT.class, ComplexIT.class, MatrixNxMIT.class, Box3DIT.class, Normal3DIT.class})
public class RaytracerITSuite {

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }
    
}
