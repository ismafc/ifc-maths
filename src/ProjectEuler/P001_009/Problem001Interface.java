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
 * <b>set</b>: Initializes parameters of calculation
 * <b>start</b>: Launch thread that resolves the problem in background
 * <b>doStop</b>: Request for stop calculation
 * <b>getResult</b>: Returns current calculated result (could be partial)
 * <b>getMilliseconds</b>: Returns current time -aproximation- spent in calculation (could be partial)
 * <b>getProgress</b>: Returns calculation progression [0..1], 0 = Nothing calculated, 1 = Calculation is done
 * <b>calculationInProgress</b>: Returns if calculation is in progress or not.
 * <b>calculationIsDone</b>: Returns if calculation is finished.
 * 
 * @author ismael.flores
 */
public interface Problem001Interface extends Runnable {
    public void set(ArrayList<BigInteger> _values, BigInteger _from, BigInteger _below, Problem001.Algorithm _algorithm);
    
    public void start();
    public void doStop();
    
    public BigInteger getResult();
    public long getMilliseconds();
    public double getProgress();
    
    public boolean calculationInProgress();
    public boolean calculationIsDone();
}
