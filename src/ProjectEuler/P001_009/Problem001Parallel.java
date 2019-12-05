/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ProjectEuler.P001_009;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * This class encapsulates the calculation of problem 1 in a separated thread that
 * creates several other threads depending on {@link #numberOfThreads} value in
 * order to take advantage of today multi-core CPUs.
 * Each secondary thread executes a partial calculation in slots/blocks/steps 
 * if the computational cost can be long.
 * Process can be stopped calling {@link #doStop() doStop} function.
 * 
 * @author ismael.flores
 * @version 1.0
 */
public class Problem001Parallel extends Problem001Thread {
    private final ArrayList<Problem001Thread> listThreads = new ArrayList<>(); 
    private long numberOfThreads = Runtime.getRuntime().availableProcessors();
    
    /** 
     * Default constructor method. 
     * It calls base class constructor {@link Problem001Thread#Problem001Thread Problem001Thread}
     * that calls {@link Problem001Thread#set set} method with default parameters.
     */
    public Problem001Parallel() {
        super();
    }
    
    /** 
     * Constructor method. It calls base constructor method that calls {@link Problem001Thread#set set} method.
     * @param _values List of values to check with all numbers in range [{@link Problem001Thread#from from}, {@link Problem001Thread#below below})
     * @param _from Lower bound (included). It defines range [{@link Problem001Thread#from from}, {@link Problem001Thread#below below}) to check with all values in {@link Problem001Thread#values values}
     * @param _below Upper bound (not included). It defines range [{@link Problem001Thread#from from}, {@link Problem001Thread#below below}) to check with all values in {@link Problem001Thread#values values}
     * @param _algorithm Algorithm we want to use to calculate the desired value
     */
    public Problem001Parallel(ArrayList<BigInteger> _values, BigInteger _from, BigInteger _below, Problem001.Algorithm _algorithm) {
        super(_values, _from, _below, _algorithm);
    }
    
    /** 
     * Sets number of threads we want to use to calculate value. 
     * If calculation is already in progress this value is not updatable so this
     * function must be called before thread is launched (<b>start()</b> is called).
     * Also, if <b><i>nNumberOfThreads</i></b> is less or equals zero, this value
     * is not updatable.
     * @param nNumberOfThreads number of threads we want to use
     * @return <a href="https://docs.oracle.com/javase/10/docs/api/java/lang/Boolean.html" target="_blank"><b>Boolean</b></a> with True if {@link #numberOfThreads} has been updated or False otherwise
     */
    public synchronized boolean setNumberOfThreads(long nNumberOfThreads) {
        boolean updated = false;
        if (!calculationInProgress()) {
            if (nNumberOfThreads > 0) {
                numberOfThreads = nNumberOfThreads;
                updated = true;
            }
        }
        return updated;
    }

    /** 
     * Calculates {@link #from} value of required thread.
     * @param i thread index, in [0, {@link #numberOfThreads}]) interval, to calculate {@link #from} value
     * @return <a href="https://docs.oracle.com/javase/10/docs/api/java/math/BigInteger.html" target="_blank"><b>BigInteger</b></a> with {@link #from} value of required thread
     */
    private synchronized BigInteger getFrom(long i) {
        if (numberOfThreads <= 0)
            return (i <= 0 ? from : below);
        BigInteger slots = BigInteger.valueOf(numberOfThreads);
        BigInteger islot = BigInteger.valueOf(i);
        BigInteger nValues = below.subtract(from);
        return from.add(nValues.multiply(islot).divide(slots));
    }
    
    /** 
     * Adjust {@link #numberOfThreads} to be consistent. 
     * This value cannot be less or equal to zero (in this case we adjust de value
     * to number of cores in this computer). Also, if {@link #numberOfThreads} is
     * greater than the number of values to check, we initialize this value to
     * the number of values to check (so, we will check only one value in each thread).
     */
    private synchronized void adjustNumberOfThreads() {
        if (numberOfThreads <= 0)
            numberOfThreads = Runtime.getRuntime().availableProcessors();
        BigInteger nof = BigInteger.valueOf(numberOfThreads);
        BigInteger nValues = below.subtract(from);
        if (nValues.compareTo(nof) <= 0)
            numberOfThreads = nValues.longValue();
    }
   
    /** 
     * Check if calculation has to continue.
     * Calculation has to continue if at least one thread is still running. 
     * @return <a href="https://docs.oracle.com/javase/10/docs/api/java/lang/Boolean.html" target="_blank"><b>Boolean</b></a> with True if calculation is in progress. False if calculation has been finished in all threads.
     */
    @Override
    protected synchronized boolean keepRunning() {
        if (doStop)
            return false;
        if (listThreads.isEmpty())
            return true;
        for (Problem001Thread p001thread : listThreads) {
            if (p001thread.keepRunning())
                return true;
        }
        return false;
    }
    
    /** 
     * Calculates progress of calculation.
     * It indicates amount of progress done (average progress of all threads)
     * @return <a href="https://docs.oracle.com/javase/10/docs/api/java/lang/Double.html" target="_blank"><b>Double</b></a> value in range [0..1]
     */
    @Override
    public synchronized double getProgress() {
        double progress = 0.0;
        for (Problem001Thread p001thread : listThreads)
            progress += p001thread.getProgress();
        int size = listThreads.size();
        return (size == 0 ? 0.0 : (progress / (double)size));
    }

    /** 
     * Requires all threads to stop. Is posible that threads are not still created
     * so we have to store this requirement in order to execute it later.
     */
    @Override
    public synchronized void doStop() {
        if (listThreads.isEmpty())
            doStop = true;
        else {
            for (Problem001Thread p001thread : listThreads)
                p001thread.doStop();
        }
    }
    
    /** 
     * Updates result in variable {@link #result} and actualize computational cost in variable {@link #milliseconds}
     * Result is the sum of threads partial results.
     * Computational cost is the average of all threads computational costs (because they run in parallel)
     */
    private synchronized void updateResult() {
        result = BigInteger.ZERO;
        milliseconds = 0;
        for (Problem001Thread p001thread : listThreads) {
            result = result.add(p001thread.getResult());
            milliseconds += p001thread.getMilliseconds();
        }
        milliseconds /= numberOfThreads;
    }
    
    /** 
     * Creating and starting {@link #numberOfThreads} threads and adding them
     * to {@link #listThreads}. Before start each thread we set it with 
     * correct parameters.
     */
    private synchronized void createAndStartThreads() {
        if (!doStop) {
            for (long i = 0; i < numberOfThreads; i++) {
                Problem001Thread p001thread = new Problem001Thread();
                p001thread.set(values, getFrom(i), getFrom(i + 1), algorithm);
                p001thread.start();
                listThreads.add(p001thread);
            }
        }
    }

    /** 
     * This method waits until all used threads have finished their calculations
     * due to an user stop or an efective final of calculation
     */
    private synchronized void waitForThreads() {
        for (Problem001Thread p001thread : listThreads) {
            while (p001thread.calculationInProgress()) {
                try {
                    Thread.sleep(100);
                } catch (InterruptedException ex) {
                    String msg = "Sleep Exception in waitForThreads (Problem001Parallel)";
                    String className = Problem001Parallel.class.getName();
                    Logger.getLogger(className).log(Level.SEVERE, msg, ex);
                }
            }
        }
    }
    
    /** 
     * Adjust number of threads to reality then creates {@link #numberOfThreads}
     * threads, each one initialized with a piece of calculation, and starts all of them.
     * Then updates result and computational cost while threads are in progress.
     * A sleep inside loop is needed because we don't need to update result continually.
     * Also final update is needed after main loop and waiting for used threads
     * to be finalized.
     */
    @Override
    public void run() {
        adjustNumberOfThreads();
        createAndStartThreads();
        while (keepRunning()) {
            updateResult();
            try {
                Thread.sleep(250);
            } catch (InterruptedException ex) {
                String msg = "Sleep Exception in run (Problem001Parallel)";
                String className = Problem001Parallel.class.getName();
                Logger.getLogger(className).log(Level.SEVERE, msg, ex);
            }
        }
        updateResult();
        waitForThreads();
    }
    
}
