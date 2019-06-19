/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import Library.LibraryITSuite;
import OnlineJudge.OnlineJudgeITSuite;
import ProjectEuler.ProjectEulerITSuite;
import dialogs.DialogsITSuite;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import raytracer.RaytracerITSuite;

/**
 *
 * @author ismael.flores
 */
@RunWith(Suite.class)
@Suite.SuiteClasses({DialogsITSuite.class, DialogsITSuite.class, ProjectEulerITSuite.class, LibraryITSuite.class, RaytracerITSuite.class, OnlineJudgeITSuite.class})
public class RootSuite {

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
