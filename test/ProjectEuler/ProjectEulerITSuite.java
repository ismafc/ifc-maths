/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ProjectEuler;

import ProjectEuler.P001_009.P001_009ITSuite;
import ProjectEuler.P110_119.P110_119ITSuite;
import ProjectEuler.P120_129.P120_129ITSuite;
import ProjectEuler.P130_139.P130_139ITSuite;
import ProjectEuler.P140_149.P140_149ITSuite;
import ProjectEuler.P150_159.P150_159ITSuite;
import ProjectEuler.P160_169.P160_169ITSuite;
import ProjectEuler.P170_179.P170_179ITSuite;
import ProjectEuler.P180_189.P180_189ITSuite;
import ProjectEuler.P190_199.P190_199ITSuite;
import ProjectEuler.P200_209.P200_209ITSuite;
import ProjectEuler.P210_219.P210_219ITSuite;
import ProjectEuler.P230_239.P230_239ITSuite;
import ProjectEuler.P240_249.P240_249ITSuite;
import ProjectEuler.P350_359.P350_359ITSuite;
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
@Suite.SuiteClasses({TriangleIT.class, P160_169ITSuite.class, P230_239ITSuite.class, P240_249ITSuite.class, P180_189ITSuite.class, P130_139ITSuite.class, P110_119ITSuite.class, P150_159ITSuite.class, P350_359ITSuite.class, P140_149ITSuite.class, P210_219ITSuite.class, P190_199ITSuite.class, P170_179ITSuite.class, P001_009ITSuite.class, P120_129ITSuite.class, P200_209ITSuite.class})
public class ProjectEulerITSuite {

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
