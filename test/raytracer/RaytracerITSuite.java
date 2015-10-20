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
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 *
 * @author ismael.flores
 */
@RunWith(Suite.class)
@Suite.SuiteClasses({raytracer.Ray3DIT.class, raytracer.Object3DIT.class, raytracer.MainIT.class, raytracer.Point3DIT.class, raytracer.ComplexIT.class, raytracer.Vector3DIT.class, raytracer.TreeIT.class, raytracer.IFCMathIT.class, raytracer.MatrixNxMIT.class, raytracer.Box3DIT.class, raytracer.Normal3DIT.class, raytracer.GWindowIT.class})
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
