/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ProjectEuler.P001_009;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
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
public class Problem001ParallelIT {
    
    private BigInteger a_ = new BigInteger("3");
    private BigInteger b_ = new BigInteger("5");
    private BigInteger from_ = new BigInteger("1");
    private BigInteger below_ = new BigInteger("1000");
    private BigInteger expResult_ = new BigInteger("233168");
    
    public Problem001ParallelIT() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        a_ = new BigInteger("3");
        b_ = new BigInteger("5");
        from_ = new BigInteger("1");
        below_ = new BigInteger("1000");
        expResult_ = new BigInteger("233168");
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of setNumberOfThreads(long nNumberOfThreads) method, of class Problem001Parallel.
     */
    @Test
    public void testSetNumberOfThreads() throws InterruptedException {
        System.out.print("setNumberOfThreads(long nNumberOfThreads): ");
        ArrayList<BigInteger> v = new ArrayList<>(Arrays.asList(a_, b_));
        Problem001Parallel instance1 = new Problem001Parallel(v, from_, new BigInteger("100000000"), Problem001.Algorithm.SOLUTION1);
        instance1.setNumberOfThreads(1);
        instance1.start();
        Thread.sleep(1000);
        double progress1 = instance1.getProgress();
        instance1.doStop();
        while (instance1.calculationInProgress())
            Thread.sleep(100);
        
        Problem001Parallel instance2 = new Problem001Parallel(v, from_, new BigInteger("100000000"), Problem001.Algorithm.SOLUTION1);
        instance2.start();
        Thread.sleep(1000);
        double progress2 = instance2.getProgress();
        instance2.doStop();
        while (instance2.calculationInProgress())
            Thread.sleep(100);
        
        System.out.println("(" + progress1 + " <= " + progress2 + ")");
        assertTrue(progress1 <= progress2);
    }

    /**
     * Test of getProgress method, of class Problem001Parallel.
     */
    @Test
    public void testGetProgress() throws InterruptedException {
        System.out.print("getProgress(): ");
        ArrayList<BigInteger> v = new ArrayList<>(Arrays.asList(a_, b_));
        Problem001Parallel instance1 = new Problem001Parallel(v, from_, new BigInteger("100000000"), Problem001.Algorithm.SOLUTION1);
        instance1.start();
        Thread.sleep(1500);
        instance1.doStop();
        while (instance1.calculationInProgress())
            Thread.sleep(200);
        double progress1 = instance1.getProgress();
        
        Problem001Parallel instance2 = new Problem001Parallel(v, from_, new BigInteger("100000000"), Problem001.Algorithm.SOLUTION2);
        instance2.start();
        Thread.sleep(1500);
        instance2.doStop();
        while (instance2.calculationInProgress())
            Thread.sleep(200);
        double progress2 = instance2.getProgress();
        
        Problem001Parallel instance3 = new Problem001Parallel(v, from_, new BigInteger("100000000"), Problem001.Algorithm.SOLUTION3);
        instance3.start();
        Thread.sleep(500);
        instance3.doStop();
        while (instance3.calculationInProgress())
            Thread.sleep(200);
        double progress3 = instance3.getProgress();

        System.out.print("(" + progress1 + " < " + progress2 + " <= " + progress3 + " == 1.0) ");
        assertTrue(progress1 < progress2);
        assertTrue(progress2 <= progress3);
        assertTrue(progress3 == 1.0);
        
        Problem001Parallel instance4 = new Problem001Parallel(v, from_, new BigInteger("300000000"), Problem001.Algorithm.SOLUTION1);
        instance4.start();
        Thread.sleep(1500);
        instance4.doStop();
        while (instance4.calculationInProgress())
            Thread.sleep(200);
        double progress4 = instance4.getProgress();
        
        Problem001Parallel instance5 = new Problem001Parallel(v, from_, new BigInteger("300000000"), Problem001.Algorithm.SOLUTION2);
        instance5.start();
        Thread.sleep(1500);
        instance5.doStop();
        while (instance5.calculationInProgress())
            Thread.sleep(200);
        double progress5 = instance5.getProgress();
        
        Problem001Parallel instance6 = new Problem001Parallel(v, from_, new BigInteger("300000000"), Problem001.Algorithm.SOLUTION3);
        instance6.start();
        Thread.sleep(500);
        instance6.doStop();
        while (instance6.calculationInProgress())
            Thread.sleep(200);
        double progress6 = instance6.getProgress();

        System.out.print("(" + progress4 + " < " + progress5 + " <= " + progress6 + " == 1.0) ");
        assertTrue(progress4 < progress5);
        assertTrue(progress5 <= progress6);
        assertTrue(progress6 == 1.0);

        System.out.print("(" + progress4 + " < " + progress1 + ") ");
        System.out.println("(" + progress5 + " < " + progress2 + ") ");
        assertTrue(progress4 < progress1);
        assertTrue(progress5 < progress2);
    }

    /**
     * Test of doStop method, of class Problem001Parallel.
     */
    @Test
    public void testDoStop() throws InterruptedException {
        System.out.print("doStop(): ");
        ArrayList<BigInteger> v = new ArrayList<>(Arrays.asList(a_, b_));
        Problem001Parallel instance = new Problem001Parallel(v, from_, new BigInteger("1000000000"), Problem001.Algorithm.SOLUTION1);
        instance.start();
        instance.doStop();
        while (instance.calculationInProgress())
            Thread.sleep(250);
        
        double progress = instance.getProgress();
        System.out.println("(" + progress + " < 1.0)");
        assertTrue(progress < 1.0);
    }

    /**
     * Test of run method, of class Problem001Parallel.
     */
    @Test
    public void testRun() {
        System.out.println("run()");
        for (long numberOfThreads = 0; numberOfThreads < Runtime.getRuntime().availableProcessors(); numberOfThreads++) {
            for (Problem001.Algorithm algorithm : Problem001.Algorithm.values()) {
                ArrayList<BigInteger> v = new ArrayList<>(Arrays.asList(a_, b_));
                Problem001Parallel instance = new Problem001Parallel(v, from_, below_, algorithm);
                instance.setNumberOfThreads(numberOfThreads);
                instance.run();
                assertEquals(expResult_, instance.getResult());

                if (algorithm == Problem001.Algorithm.SOLUTION3) {
                    // Check big value and from
                    instance = new Problem001Parallel(v, new BigInteger("7000000000"), new BigInteger("10000000000"), algorithm);
                    instance.setNumberOfThreads(numberOfThreads);
                    instance.run();
                    assertEquals(new BigInteger("11899999999500000000"), instance.getResult());
                }

                // Check MCM
                v = new ArrayList<>(Arrays.asList(new BigInteger("10"), new BigInteger("14")));
                instance = new Problem001Parallel(v, new BigInteger("1"), new BigInteger("100"), algorithm);
                instance.setNumberOfThreads(numberOfThreads);
                instance.run();
                assertEquals(new BigInteger("772"), instance.getResult());

                // Check MCM and from
                instance = new Problem001Parallel(v, new BigInteger("50"), new BigInteger("100"), algorithm);
                instance.setNumberOfThreads(numberOfThreads);
                instance.run();
                assertEquals(new BigInteger("588"), instance.getResult());
            }
        }
    }

    /**
     * Test of keepRunning method, of class Problem001Parallel.
     */
    @Test
    public void testKeepRunning() throws InterruptedException {
        System.out.println("keepRunning()");
        ArrayList<BigInteger> v = new ArrayList<>(Arrays.asList(a_, b_));
        Problem001Parallel instance1 = new Problem001Parallel(v, from_, new BigInteger("1000000000"), Problem001.Algorithm.SOLUTION1);
        boolean inProgress1a = instance1.keepRunning();
        assertFalse(inProgress1a);
        instance1.start();
        Thread.sleep(500);
        boolean inProgress1b = instance1.keepRunning();
        assertTrue(inProgress1b);
        instance1.doStop();
        while (instance1.calculationInProgress())
            Thread.sleep(100);
        
        Problem001Parallel instance2 = new Problem001Parallel(v, from_, new BigInteger("1000000000"), Problem001.Algorithm.SOLUTION3);
        boolean inProgress2a = instance2.keepRunning();
        assertFalse(inProgress2a);
        instance2.start();
        Thread.sleep(500);
        boolean inProgress2b = instance2.keepRunning();
        assertFalse(inProgress2b); 
        instance2.doStop();
        while (instance2.calculationInProgress())
            Thread.sleep(100);
        
        Problem001Parallel instance3 = new Problem001Parallel(v, from_, new BigInteger("1000000000"), Problem001.Algorithm.SOLUTION1);
        boolean inProgress3a = instance3.keepRunning();
        assertFalse(inProgress3a);
        instance3.start();
        instance3.doStop();
        while (instance3.calculationInProgress())
            Thread.sleep(250);
        boolean inProgress3b = instance3.keepRunning();
        assertFalse(inProgress3b); 
    }
    
}
