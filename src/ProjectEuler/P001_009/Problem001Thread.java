/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ProjectEuler.P001_009;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * This class encapsulates the calculation of problem 1 in a separated thread and
 * executes it in slots/blocks/steps if the computational cost can be long.
 * Process can be stopped between blocks externally calling {@link #doStop() doStop} method.
 * 
 * @author ismael.flores
 * @version 1.0
 */
public class Problem001Thread extends Thread implements Problem001Interface {

    /**
     * Object used to make partial calculations ({@link Problem001})
     */
    final private Problem001 problem001 = new Problem001();
    
    /**
     * List of values to check if divide to target value. So, to check if target
     * value is multiple of some vaue in this list.
     * Initialized to {3, 5} by default. Used to populate {@link #values}
     */
    final private List<BigInteger> lAux = Arrays.asList(new BigInteger("3"), new BigInteger("5"));

    /**
     * List of values to check if divide to target value. So, to check if target
     * value is multiple of some vaue in this list.
     * Initialized to {@link #lAux} by default.
     */
    protected ArrayList<BigInteger> values = new ArrayList<>(lAux);

    /**
     * First value in range (included) to check if it is multiple of some value in {@link #values}.
     * initialized to 1 by default
     */
    protected BigInteger from = BigInteger.ONE;
    
    /**
     * Last value in range (not included) to check if it is multiple of some value in {@link #values}.
     * Initialized to 1000 by default
     */
    protected BigInteger below = new BigInteger("1000");
    
    /**
     * Algorithm used to obtain final result.
     * Initialized to {@link Problem001.Algorithm#SOLUTION1 SOLUTION1} by default
     */
    protected Problem001.Algorithm algorithm = Problem001.Algorithm.SOLUTION1;

    /**
     * Current calculated value. It must be partial or final.
     * Initialized to 0 by default.
     */
    protected BigInteger result = BigInteger.ZERO;

    /**
     * Current time spent in calculation. It must be partial or final.
     * Initialized to 0 by default. Units in milliseconds.
     */
    protected long milliseconds = 0;
    
    /**
     * Current progress done in calculation. It must be partial or final.
     * Initialized to 0 by default. Range in [0..1]
     */
    protected double progress = 0.0;
    
    /**
     * Number of parts in which calculation is divided.
     * Initialized to 1 by default.
     */
    private BigInteger steps = BigInteger.ONE;

    /**
     * Size of each part in which calculation is divided.
     * Initialized to {@link #below}-{@link #from} by default (all values)
     */
    private BigInteger slot = below.subtract(from);
    
    /**
     * Current part being calculated.
     * Initialized to 0 by default.
     */
    private BigInteger step = BigInteger.ZERO;

    /**
     * Stores if a stop in current calculation is required (<b>true</b>) or not (<b>false</b>)
     * Initialized to <b>false</b> by default.
     */
    protected boolean doStop = false;

    /** 
     * Default constructor method. 
     * It calls {@link #set} method with default parameters.
     */
    public Problem001Thread() {
        set(values, from, below, algorithm);
    }

    /** 
     * Constructor method. It calls {@link #set} method.
     * @param _values List of values to check with all numbers in range [{@link #from}, {@link #below})
     * @param _from Lower bound (included). It defines range [{@link #from}, {@link #below}) to check with all values in {@link #values}
     * @param _below Upper bound (not included). It defines range [{@link #from}, {@link #below}) to check with all values in {@link #values}
     * @param _algorithm Algorithm we want to use to calculate the desired value
     */
    public Problem001Thread(ArrayList<BigInteger> _values, BigInteger _from, BigInteger _below, Problem001.Algorithm _algorithm) {
        set(_values, _from, _below, _algorithm);
    }
       
    /** 
     * Initializes variables needed to make calculations. Depending on these values
     * calculates steps and slot size needed to split calculations in pieces
     * @param _values List of values to check with all numbers in range [{@link #from}, {@link #below})
     * @param _from Lower bound (included). It defines range [{@link #from}, {@link #below}) to check with all values in {@link #values}
     * @param _below Upper bound (not included). It defines range [{@link #from}, {@link #below}) to check with all values in {@link #values}
     * @param _algorithm Algorithm we want to use to calculate the desired value
     */
    @Override
    public final void set(ArrayList<BigInteger> _values, BigInteger _from, BigInteger _below, Problem001.Algorithm _algorithm) {
        values = _values;
        from = _from;
        below = _below;
        algorithm = _algorithm;
        initializeSteps();
        milliseconds = 0;
        result = BigInteger.ZERO;
    }

    /** 
     * Calculates steps and slot size needed to split calculations in pieces based
     * on the interval [{@link #from}, {@link #below}) and {@link #algorithm}
     * if interval size es less than 2000000000 and {@link #algorithm} is {@link Problem001.Algorithm#SOLUTION3} slot will be 2000000000
     * if interval size es less than 200000 and {@link #algorithm} is {@link Problem001.Algorithm#SOLUTION1} or {@link Problem001.Algorithm#SOLUTION2} slot will be 200000
     */
    private void initializeSteps() {
        slot = (algorithm == Problem001.Algorithm.SOLUTION3 ? new BigInteger("2000000000") : new BigInteger("200000"));
        steps = below.subtract(from).divide(slot);
        if (steps.multiply(slot).compareTo(below.subtract(from)) == -1)
            steps = steps.add(BigInteger.ONE);
        step = BigInteger.ZERO;
    }

    /** 
     * Returns {@link #result} which contains actual calculation.
     * If {@link #step} = {@link #steps}, that is {@link #progress} = 1.0,  
     * result contains final result
     * @return <a href="https://docs.oracle.com/javase/10/docs/api/java/math/BigInteger.html" target="_blank"><b>BigInteger</b></a> with calculation already done
     */
    @Override
    public synchronized BigInteger getResult() {
        return result;
    }

    /** 
     * Returns {@link #milliseconds} which contains actual calculation time spent
     * If {@link #step} = {@link #steps}, that is {@link #progress} = 1.0,
     * milliseconds contains final time spent
     * @return <a href="https://docs.oracle.com/javase/10/docs/api/java/lang/Long.html" target="_blank"><b>Long</b></a> with time already spent in calculations
     */
    @Override
    public synchronized long getMilliseconds() {
        return milliseconds;
    }

    /** 
     * Sets variable {@link #doStop} to TRUE
     * This variable is checked each step in order to decide if calculation
     * must be stopped or not. 
     * It is checked throught method {@link #keepRunning() keepRunning} 
     */
    @Override
    public synchronized void doStop() {
        doStop = true;
    }

    /** 
     * Calculates progress of calculation.
     * It indicates amount of progress done, that is \(\frac{step}{steps}\) previously
     * updated in {@link #updateResult(BigInteger nFrom, BigInteger nBelow) updateResult} 
     * @return <a href="https://docs.oracle.com/javase/10/docs/api/java/lang/Double.html" target="_blank"><b>Double</b></a> value in range [0..1]
     */
    @Override
    public synchronized double getProgress() {
        return progress;
    }

    /** 
     * Returns boolean indicanting if calculation is in progress or not 
     * @return <a href="https://docs.oracle.com/javase/10/docs/api/java/lang/Boolean.html" target="_blank"><b>Boolean</b></a> indicating if calculation is in progress or not 
     */
    @Override
    public synchronized boolean calculationInProgress() {
        State state = getState();
        return (!state.equals(Thread.State.NEW) && !state.equals(Thread.State.TERMINATED));
    }

    /** 
     * Returns boolean indicanting if calculation is completed or not 
     * @return <a href="https://docs.oracle.com/javase/10/docs/api/java/lang/Boolean.html" target="_blank"><b>Boolean</b></a> indicanting if calculation is completed or not 
     */
    @Override
    public synchronized boolean calculationIsDone() {
        return (getState().equals(Thread.State.TERMINATED));
    }
    
    /** 
     * Finds the sum of all the multiples of any number in {@link #values} (values[0], values[1], ..., values[n-1] or values[n]) 
     * from <b><i>nFrom</i></b> and below <b><i>nBelow</i></b> using algorithm {@link #algorithm}.
     * Adds result to variable {@link #result} and actualize computational cost in variable {@link #milliseconds}
     * Actualizes {@link #step} to the next one (adding 1)
     * @param nFrom Lower bound (included). It defines range <b>[<i>nFrom</i>, <i>nBelow</i>)</b> to check with all values in {@link #values}
     * @param nBelow Upper bound (not included). It defines range <b>[<i>nFrom</i>, <i>nBelow</i>)</b> to check with all values in {@link #values}
     */
    private synchronized void updateResult(BigInteger nFrom, BigInteger nBelow) {
        long millis = System.currentTimeMillis();
        result = result.add(problem001.solve(values, nFrom, nBelow, algorithm));
        milliseconds += (System.currentTimeMillis() - millis);
        step = step.add(BigInteger.ONE);
        progress = step.doubleValue() / steps.doubleValue();
    }

    /** 
     * Calculates next below value according to actual {@link #slot} and
     * given parameter <b><i>_from</i></b> with first value
     * @param _from Lower bound (included)
     * @return <a href="https://docs.oracle.com/javase/10/docs/api/java/math/BigInteger.html" target="_blank"><b>BigInteger</b></a> with below value
     */
    private synchronized BigInteger getNewBelow(BigInteger _from) {
        BigInteger nBelow = _from.add(slot);
        if (nBelow.compareTo(below) >= 0)
            nBelow = below;
        return nBelow;
    }
    
    /** 
     * Check if calculation has to continue.  
     * Calculation is done if {@link #step} = {@link #steps} and 
     * calculation has to be stopped if {@link #doStop} = true
     * @return <a href="https://docs.oracle.com/javase/10/docs/api/java/lang/Boolean.html" target="_blank"><b>Boolean</b></a> with True if calculation has to continue. False if calculation has to be stopped or has finished
     */
    protected synchronized boolean keepRunning() {
        return doStop == false && step.compareTo(steps) != 0;
    }
    
    /** 
     * Calculates result in pieces of {@link #slot} values
     * Every {@link #step} we check if {@link #doStop} is true 
     * (someone wants to stop calculation) or calculation is done.
     * If another step is needed, we update {@link #result} and {@link #milliseconds}
     * with the calculation of interval <b>[<i>nFrom</i>, <i>nBelow</i>)</b> and
     * set new interval <b>[<i>nFrom</i>, <i>nBelow</i>)</b> and {@link #step}
     */
    @Override
    public void run() {
        BigInteger nFrom = from;
        BigInteger nBelow = getNewBelow(nFrom);
        while (keepRunning()) {
            updateResult(nFrom, nBelow);
            nFrom = nBelow;
            nBelow = getNewBelow(nFrom);
            try {
                Thread.sleep(10);
            } catch (InterruptedException ex) {
                String msg = "Sleep Exception in run (Problem001Thread)";
                String className = Problem001Thread.class.getName();
                Logger.getLogger(className).log(Level.SEVERE, msg, ex);
            }
        }
    }
}
