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
public class Problem001ThreadIT {
    
    private BigInteger a_ = new BigInteger("3");
    private BigInteger b_ = new BigInteger("5");
    private BigInteger from_ = new BigInteger("1");
    private BigInteger below_ = new BigInteger("1000");
    private BigInteger expResult_ = new BigInteger("233168");

    public Problem001ThreadIT() {
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
     * Test of set(ArrayList<BigInteger> _values, BigInteger _from, BigInteger _below, Problem001.Algorithm _algorithm) method, of class Problem001Thread.
     */
    @Test
    public void testSet() {
        System.out.println("set(ArrayList<BigInteger> _values, BigInteger _from, BigInteger _below, Problem001.Algorithm _algorithm)");
        for (Problem001.Algorithm algorithm : Problem001.Algorithm.values()) {
            ArrayList<BigInteger> v = new ArrayList<>(Arrays.asList(a_, b_));
            Problem001Thread instance = new Problem001Thread();
            instance.set(v, from_, below_, algorithm);
            instance.run();
            assertEquals(expResult_, instance.getResult());
            
            if (algorithm == Problem001.Algorithm.SOLUTION3) {
                // Check big value and from
                instance = new Problem001Thread();
                instance.set(v, new BigInteger("7000000000"), new BigInteger("10000000000"), algorithm);
                instance.run();
                assertEquals(new BigInteger("11899999999500000000"), instance.getResult());
            }
            
            // Check MCM
            v = new ArrayList<>(Arrays.asList(new BigInteger("10"), new BigInteger("14")));
            instance = new Problem001Thread();
            instance.set(v, new BigInteger("1"), new BigInteger("100"), algorithm);
            instance.run();
            assertEquals(new BigInteger("772"), instance.getResult());
            
            // Check MCM and from
            instance = new Problem001Thread();
            instance.set(v, new BigInteger("50"), new BigInteger("100"), algorithm);
            instance.run();
            assertEquals(new BigInteger("588"), instance.getResult());
        }
    }

    /**
     * Test of getResult method, of class Problem001Thread.
     */
    @Test
    public void testGetResult() {
        System.out.println("getResult()");
        for (Problem001.Algorithm algorithm : Problem001.Algorithm.values()) {
            ArrayList<BigInteger> v = new ArrayList<>(Arrays.asList(a_, b_));
            Problem001Thread instance = new Problem001Thread(v, from_, below_, algorithm);
            instance.run();
            assertEquals(expResult_, instance.getResult());
            
            if (algorithm == Problem001.Algorithm.SOLUTION3) {
                // Check big value and from
                instance = new Problem001Thread(v, new BigInteger("7000000000"), new BigInteger("10000000000"), algorithm);
                instance.run();
                assertEquals(new BigInteger("11899999999500000000"), instance.getResult());
            }
            
            // Check MCM
            v = new ArrayList<>(Arrays.asList(new BigInteger("10"), new BigInteger("14")));
            instance = new Problem001Thread(v, new BigInteger("1"), new BigInteger("100"), algorithm);
            instance.run();
            assertEquals(new BigInteger("772"), instance.getResult());
            
            // Check MCM and from
            instance = new Problem001Thread(v, new BigInteger("50"), new BigInteger("100"), algorithm);
            instance.run();
            assertEquals(new BigInteger("588"), instance.getResult());
        }
    }

    /**
     * Test of getMilliseconds method, of class Problem001Thread.
     */
    @Test
    public void testGetMilliseconds() {
        System.out.println("getMilliseconds()");
        BigInteger nBelow = new BigInteger("10000000");
        ArrayList<BigInteger> v = new ArrayList<>(Arrays.asList(a_, b_));
        Problem001Thread instance1 = new Problem001Thread(v, from_, nBelow, Problem001.Algorithm.SOLUTION1);
        instance1.run();

        Problem001Thread instance2 = new Problem001Thread(v, from_, nBelow, Problem001.Algorithm.SOLUTION2);
        instance2.run();
        
        Problem001Thread instance3 = new Problem001Thread(v, from_, nBelow, Problem001.Algorithm.SOLUTION3);
        instance3.run();
        
        assertTrue(instance1.getMilliseconds() >= instance2.getMilliseconds());
        assertTrue(instance2.getMilliseconds() >= instance3.getMilliseconds());
    }

    /**
     * Test of doStop method, of class Problem001Thread.
     */
    @Test
    public void testDoStop() throws InterruptedException {
        System.out.println("doStop()");
        ArrayList<BigInteger> v = new ArrayList<>(Arrays.asList(a_, b_));
        Problem001Thread instance = new Problem001Thread(v, from_, new BigInteger("100000000"), Problem001.Algorithm.SOLUTION1);
        instance.start();
        Thread.sleep(500);
        instance.doStop();
        while (instance.calculationInProgress())
            Thread.sleep(250);
        
        assertTrue(instance.getProgress() < 1.0);
    }

    /**
     * Test of getProgress method, of class Problem001Thread.
     */
    @Test
    public void testGetProgress() throws InterruptedException {
        System.out.println("getProgress()");
        ArrayList<BigInteger> v = new ArrayList<>(Arrays.asList(a_, b_));
        Problem001Thread instance1 = new Problem001Thread(v, from_, new BigInteger("100000000"), Problem001.Algorithm.SOLUTION1);
        instance1.start();
        Thread.sleep(1000);
        double progress1 = instance1.getProgress();
        instance1.interrupt();
        
        Problem001Thread instance2 = new Problem001Thread(v, from_, new BigInteger("100000000"), Problem001.Algorithm.SOLUTION2);
        instance2.start();
        Thread.sleep(1000);
        double progress2 = instance2.getProgress();
        instance2.interrupt();
        
        Problem001Thread instance3 = new Problem001Thread(v, from_, new BigInteger("100000000"), Problem001.Algorithm.SOLUTION3);
        instance3.start();
        Thread.sleep(250);
        double progress3 = instance3.getProgress();
        instance3.interrupt();

        assertTrue(progress1 < progress2 && progress2 <= progress3);
        assertTrue(progress3 == 1.0);
        
        Problem001Thread instance4 = new Problem001Thread(v, from_, new BigInteger("1000000000"), Problem001.Algorithm.SOLUTION1);
        instance4.start();
        Thread.sleep(1000);
        double progress4 = instance4.getProgress();
        instance4.interrupt();
        
        Problem001Thread instance5 = new Problem001Thread(v, from_, new BigInteger("1000000000"), Problem001.Algorithm.SOLUTION2);
        instance5.start();
        Thread.sleep(1000);
        double progress5 = instance5.getProgress();
        instance5.interrupt();
        
        Problem001Thread instance6 = new Problem001Thread(v, from_, new BigInteger("1000000000"), Problem001.Algorithm.SOLUTION3);
        instance6.start();
        Thread.sleep(250);
        double progress6 = instance6.getProgress();
        instance6.interrupt();

        assertTrue(progress4 < progress5 && progress5 <= progress6);
        assertTrue(progress6 == 1.0);
        assertTrue(progress4 < progress1 && progress5 <= progress2);
    }

    /**
     * Test of run method, of class Problem001Thread.
     */
    @Test
    public void testRun() {
        System.out.println("run()");
        for (Problem001.Algorithm algorithm : Problem001.Algorithm.values()) {
            ArrayList<BigInteger> v = new ArrayList<>(Arrays.asList(a_, b_));
            Problem001Thread instance = new Problem001Thread(v, from_, below_, algorithm);
            instance.run();
            assertEquals(expResult_, instance.getResult());
            
            if (algorithm == Problem001.Algorithm.SOLUTION3) {
                // Check big value and from
                instance = new Problem001Thread(v, new BigInteger("7000000000"), new BigInteger("10000000000"), algorithm);
                instance.run();
                assertEquals(new BigInteger("11899999999500000000"), instance.getResult());
            }
            
            // Check MCM
            v = new ArrayList<>(Arrays.asList(new BigInteger("10"), new BigInteger("14")));
            instance = new Problem001Thread(v, new BigInteger("1"), new BigInteger("100"), algorithm);
            instance.run();
            assertEquals(new BigInteger("772"), instance.getResult());
            
            // Check MCM and from
            instance = new Problem001Thread(v, new BigInteger("50"), new BigInteger("100"), algorithm);
            instance.run();
            assertEquals(new BigInteger("588"), instance.getResult());
        }
    }

    /**
     * Test of calculationInProgress method, of class Problem001Thread.
     */
    @Test
    public void testCalculationInProgress() throws InterruptedException {
        System.out.println("calculationInProgress()");
        ArrayList<BigInteger> v = new ArrayList<>(Arrays.asList(a_, b_));
        Problem001Thread instance1 = new Problem001Thread(v, from_, new BigInteger("100000000"), Problem001.Algorithm.SOLUTION1);
        boolean inProgress1a = instance1.calculationInProgress();
        assertFalse(inProgress1a);
        instance1.start();
        Thread.sleep(500);
        boolean inProgress1b = instance1.calculationInProgress();
        assertTrue(inProgress1b);
        instance1.interrupt();
        
        Problem001Thread instance2 = new Problem001Thread(v, from_, new BigInteger("100000000"), Problem001.Algorithm.SOLUTION3);
        boolean inProgress2a = instance2.calculationInProgress();
        assertFalse(inProgress2a);
        instance2.start();
        Thread.sleep(500);
        boolean inProgress2b = instance2.calculationInProgress();
        assertFalse(inProgress2b); 
        instance2.interrupt();
    }

    /**
     * Test of calculationIsDone method, of class Problem001Thread.
     */
    @Test
    public void testCalculationIsDone() throws InterruptedException {
        System.out.println("calculationIsDone()");
        ArrayList<BigInteger> v = new ArrayList<>(Arrays.asList(a_, b_));
        Problem001Thread instance1 = new Problem001Thread(v, from_, new BigInteger("100000000"), Problem001.Algorithm.SOLUTION1);
        boolean inProgress1a = instance1.calculationIsDone();
        assertFalse(inProgress1a);
        instance1.start();
        Thread.sleep(500);
        boolean inProgress1b = instance1.calculationIsDone();
        assertFalse(inProgress1b);
        instance1.interrupt();
        
        Problem001Thread instance2 = new Problem001Thread(v, from_, new BigInteger("100000000"), Problem001.Algorithm.SOLUTION3);
        boolean inProgress2a = instance2.calculationIsDone();
        assertFalse(inProgress2a);
        instance2.start();
        Thread.sleep(500);
        boolean inProgress2b = instance2.calculationIsDone();
        assertTrue(inProgress2b); 
        instance2.interrupt();
    }

    /**
     * Test of keepRunning method, of class Problem001Thread.
     */
    @Test
    public void testKeepRunning() throws InterruptedException {
        System.out.println("keepRunning()");
        ArrayList<BigInteger> v = new ArrayList<>(Arrays.asList(a_, b_));
        Problem001Thread instance1 = new Problem001Thread(v, from_, new BigInteger("100000000"), Problem001.Algorithm.SOLUTION1);
        boolean inProgress1a = instance1.keepRunning();
        assertTrue(inProgress1a);
        instance1.start();
        Thread.sleep(500);
        boolean inProgress1b = instance1.keepRunning();
        assertTrue(inProgress1b);
        instance1.interrupt();
        
        Problem001Thread instance2 = new Problem001Thread(v, from_, new BigInteger("100000000"), Problem001.Algorithm.SOLUTION3);
        boolean inProgress2a = instance2.keepRunning();
        assertTrue(inProgress2a);
        instance2.start();
        Thread.sleep(500);
        boolean inProgress2b = instance2.keepRunning();
        assertFalse(inProgress2b); 
        instance2.interrupt();
        
        Problem001Thread instance3 = new Problem001Thread(v, from_, new BigInteger("100000000"), Problem001.Algorithm.SOLUTION1);
        boolean inProgress3a = instance3.keepRunning();
        assertTrue(inProgress3a);
        instance3.start();
        instance3.doStop();
        while (instance3.calculationInProgress())
            Thread.sleep(250);
        boolean inProgress3b = instance3.keepRunning();
        assertFalse(inProgress3b); 
        instance3.interrupt();
    }
    
}
