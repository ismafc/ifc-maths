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

/**
 * This class encapsulates the calculation of problem 1 in a separated thread and
 * executes it in slots/blocks/steps if the computational cost can be long.
 * Process can be stopped between blocks externally calling <b>doStop</b> function.
 * 
 * @author ismael.flores
 * @version 1.0
 */
public class Problem001Thread extends Thread {

    final private Problem001 problem001 = new Problem001();
    final private List<BigInteger> lAux = Arrays.asList(new BigInteger("3"), new BigInteger("5"));
    private ArrayList<BigInteger> values = new ArrayList<>(lAux);
    private BigInteger from = BigInteger.ONE;
    private BigInteger below = new BigInteger("1000");
    private Problem001.Algorithm algorithm = Problem001.Algorithm.SOLUTION1;
    private BigInteger result = null;
    private long milliseconds = 0;
    
    private BigInteger steps = null;
    private BigInteger slot = null;
    private BigInteger step = null;

    private boolean doStop = false;

    public Problem001Thread() {
        set(values, from, below, algorithm);
    }

    public Problem001Thread(ArrayList<BigInteger> _values, BigInteger _from, BigInteger _below, Problem001.Algorithm _algorithm) {
        set(_values, _from, _below, _algorithm);
    }
       
    /** 
     * Initializes variables needed to make calculations. Depending on these values
     * calculates steps and slot size needed to split calculations in pieces
     * @param _values List of values to check with all numbers in range <b>[<i>from</i>, <i>below</i>)</b>
     * @param _from Lower bound (included). It defines range <b>[<i>from</i>, <i>below</i>)</b> to check with all values in <b><i>values</i></b>
     * @param _below Upper bound (not included). It defines range <b>[<i>from</i>, <i>below</i>)</b> to check with all values in <b><i>values</i></b>
     * @param _algorithm Algorithm we want to use to calculate the desired value
     */
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
     * on the interval <b>[<i>from</i>, <i>below</i>)</b> and <b><i>algorithm</i></b>
     * if interval size es less than 2000000000 and <b><i>algorithm</i></b> is <b>SOLUTION3</b> slot will be 2000000000
     * if interval size es less than 200000 and <b><i>algorithm</i></b> is <b>SOLUTION1</b> or <b>SOLUTION2</b> slot will be 200000
     */
    private void initializeSteps() {
        slot = (algorithm == Problem001.Algorithm.SOLUTION3 ? new BigInteger("2000000000") : new BigInteger("200000"));
        steps = below.subtract(from).divide(slot);
        if (steps.multiply(slot).compareTo(below.subtract(from)) == -1)
            steps = steps.add(BigInteger.ONE);
        step = BigInteger.ZERO;
    }

    /** 
     * Returns <b><i>result</i></b> which contains actual calculation
     * If <b><i>step</i></b> = <b><i>steps</i></b> result contains final result
     * @return <a href="https://docs.oracle.com/javase/10/docs/api/java/math/BigInteger.html" target="_blank"><b>BigInteger</b></a> with calculation already done
     */
    public synchronized BigInteger getResult() {
        return result;
    }

    /** 
     * Returns <b><i>milliseconds</i></b> which contains actual calculation time spent
     * If <b><i>step</i></b> = <b><i>steps</i></b> milliseconds contains final time spent
     * @return <a href="https://docs.oracle.com/javase/10/docs/api/java/lang/Long.html" target="_blank"><b>Long</b></a> with time already spent in calculations
     */
    public synchronized long getMilliseconds() {
        return milliseconds;
    }

    /** 
     * Sets variable <b><i>doStop</i></b> to TRUE
     * This variable is checked each step in order to decide if calculation
     * must be stopped or not. 
     * It is checked throught method {@link #keepRunning() keepRunning} 
     * 
     */
    public synchronized void doStop() {
        doStop = true;
    }

    /** 
     * Calculates progress of calculation.
     * It indicates progress done, that is \(\frac{step}{steps}\)
     * @return <a href="https://docs.oracle.com/javase/10/docs/api/java/lang/Double.html" target="_blank"><b>Double</b></a> value in range [0..1]
     */
    public synchronized double getProgress() {
        return step.doubleValue() / steps.doubleValue();
    }

    /** 
     * Returns boolean indicanting if calculation is in progress or not 
     * @return <a href="https://docs.oracle.com/javase/10/docs/api/java/lang/Boolean.html" target="_blank"><b>Boolean</b></a> indicating if calculation is in progress or not 
     */
    public synchronized boolean calculationInProgress() {
        State state = getState();
        return (!state.equals(Thread.State.NEW) && !state.equals(Thread.State.TERMINATED));
    }

    /** 
     * Returns boolean indicanting if calculation is completed or not 
     * @return <a href="https://docs.oracle.com/javase/10/docs/api/java/lang/Boolean.html" target="_blank"><b>Boolean</b></a> indicanting if calculation is completed or not 
     */
    public synchronized boolean calculationIsDone() {
        return (getState().equals(Thread.State.TERMINATED));
    }
    
    /** 
     * Finds the sum of all the multiples of any number in <b><i>values</i></b> (values[0], values[1], ..., values[n-1] or values[n]) 
     * from <b><i>nFrom</i></b> and below <b><i>nBelow</i></b> using algorithm <b><i>algorithm</i></b>.
     * Adds result to variable <b><i>result</i></b> and actualize computational cost in variable <b><i>milliseconds</i></b>
     * Actualizes <b><i>step</i></b> to the next one (adding 1)
     * @param nFrom Lower bound (included). It defines range <b>[<i>nFrom</i>, <i>nBelow</i>)</b> to check with all values in <b><i>values</i></b>
     * @param nBelow Upper bound (not included). It defines range <b>[<i>nFrom</i>, <i>nBelow</i>)</b> to check with all values in <b><i>values</i></b>
     */
    private synchronized void updateResult(BigInteger nFrom, BigInteger nBelow) {
        long millis = System.currentTimeMillis();
        result = result.add(problem001.solve(values, nFrom, nBelow, algorithm));
        milliseconds += (System.currentTimeMillis() - millis);
        step = step.add(BigInteger.ONE);
    }
           
    /** 
     * Calculates next below value according to actual <b><i>slot</i></b> and
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
     * Calculation is done if <b><i>step</i></b> = <b><i>steps</i></b> and 
     * calculation has to be stopped if <b><i>doStop</i></b> = true
     * @return True if calculation has to continue. False if calculation has to be stopped or has finished
     */
    private synchronized boolean keepRunning() {
        return doStop == false && step.compareTo(steps) != 0;
    }
    
    /** 
     * Calculates result in pieces of <b><i>slot</i></b> values
     * Every <b><i>step</i></b> we check if <b><i>doStop</i></b> is true 
     * (someone wants to stop calculation) or calculation is done.
     * If another step is needed, we update <b><i>result</i></b> and <b><i>milliseconds</i></b>
     * with the calculation of interval <b>[<i>nFrom</i>, <i>nBelow</i>)</b> and
     * set new interval <b>[<i>nFrom</i>, <i>nBelow</i>)</b> and <b><i>step</i></b>
     */
    @Override
    public void run() {
        BigInteger nFrom = from;
        BigInteger nBelow = getNewBelow(nFrom);
        while (keepRunning()) {
            updateResult(nFrom, nBelow);
            nFrom = nBelow;
            nBelow = getNewBelow(nFrom);
        }
    }
}
