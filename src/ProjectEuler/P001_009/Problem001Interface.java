/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ProjectEuler.P001_009;

import java.math.BigInteger;
import java.util.ArrayList;

/**
 * Interface that has to be implemented to solve Project Euler problem 001
 * in background. That is:
 * 
 * <p style="font-size:20px; color:#C83819">Multiples of 3 and 5</p>
 * 
 * <p style="font-size:14px; color:#000000">If we list all the natural numbers below 10 that are multiples of 3 or 5, we get 3, 5, 6 and 9. 
 * The sum of these multiples is 23. Find the sum of all the multiples of 3 or 5 below 1000.</p>
 * 
 * <b>set</b>: Initializes parameters of calculation<br>
 * <b>start</b>: Launch thread that resolves the problem in background<br>
 * <b>doStop</b>: Request for stop calculation<br>
 * <b>getResult</b>: Returns current calculated result (could be partial)<br>
 * <b>getMilliseconds</b>: Returns current time -aproximation- spent in calculation (could be partial)<br>
 * <b>getProgress</b>: Returns calculation progression [0..1], 0 = Nothing calculated, 1 = Calculation is done<br>
 * <b>calculationInProgress</b>: Returns if calculation is in progress or not<br>
 * <b>calculationIsDone</b>: Returns if calculation is finished<br>
 * 
 * @author ismael.flores
 */
public interface Problem001Interface extends Runnable {
    /** 
     * Initializes variables needed to make calculations. Depending on these values
     * calculates steps and slot size needed to split calculations in pieces
     * @param _values List of values to check with all numbers in range [_from, _below)
     * @param _from Lower bound (included). It defines range [_from, _below) to check with all values in _values
     * @param _below Upper bound (not included). It defines range [_from, _below) to check with all values in _values
     * @param _algorithm Algorithm we want to use to calculate the desired value
     */
    public void set(ArrayList<BigInteger> _values, BigInteger _from, BigInteger _below, Problem001.Algorithm _algorithm);
    
    /** 
     * Forces object to start calculating.
     */
    public void start();
    
    /** 
     * Forces object to stop calculating.
     */
    public void doStop();
    
    /** 
     * Returns current calculation until now (it could be partial or final).
     * @return <a href="https://docs.oracle.com/javase/10/docs/api/java/math/BigInteger.html" target="_blank"><b>BigInteger</b></a> with calculation already done
     */
    public BigInteger getResult();
    
    /** 
     * Returns current calculation time spent until now
     * @return <a href="https://docs.oracle.com/javase/10/docs/api/java/lang/Long.html" target="_blank"><b>Long</b></a> with time already spent in calculations
     */
    public long getMilliseconds();
    
    /** 
     * Calculates current progress of calculation until now in range [0..1]
     * @return <a href="https://docs.oracle.com/javase/10/docs/api/java/lang/Double.html" target="_blank"><b>Double</b></a> value in range [0..1]
     */
    public double getProgress();
    
    /** 
     * Returns boolean indicanting if calculation is in progress or not 
     * @return <a href="https://docs.oracle.com/javase/10/docs/api/java/lang/Boolean.html" target="_blank"><b>Boolean</b></a> indicating if calculation is in progress or not 
     */
    public boolean calculationInProgress();
    
    /** 
     * Returns boolean indicanting if calculation is completed or not 
     * @return <a href="https://docs.oracle.com/javase/10/docs/api/java/lang/Boolean.html" target="_blank"><b>Boolean</b></a> indicanting if calculation is completed or not 
     */
    public boolean calculationIsDone();
}
