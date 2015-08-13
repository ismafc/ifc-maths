/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ProjectEuler.P350_359;

import java.util.*;
import raytracer.IFCMath;

/**
 *
 * @author ismael.flores
 */
public class Problem357 {
    
    /*    
    Prime generating integers

    Consider the divisors of 30: 1,2,3,5,6,10,15,30.
    It can be seen that for every divisor d of 30, d+30/d is prime.

    Find the sum of all positive integers n not exceeding 100 000 000
    such that for every divisor d of n, d+n/d is prime.
    */
    private static boolean allPrimes(ArrayList<Long> d, long n) {
        for (Long v : d) {
            long toCheck = v + n / v;
            if (!IFCMath.isPrime(toCheck)) {
                return false;
            }
        }
        return true;
    }
    
    public static void problem357(long max) {
        long sum = 0;
        for (long n = 1; n <= max; n++) {
            ArrayList<Long> d = IFCMath.divisors(n);
            if (allPrimes(d, n))
                sum += n;
        }
        System.out.println("sum = " + sum);        
    }
}
