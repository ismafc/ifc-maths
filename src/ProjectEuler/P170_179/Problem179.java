/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ProjectEuler.P170_179;

import raytracer.IFCMath;

/**
 *
 * @author Isma
 */
public class Problem179 {
    /*
    Consecutive positive divisors

    Find the number of integers 1 < n < 10^7, for which n and n + 1 have the same number of positive divisors. 
    For example, 14 has the positive divisors 1, 2, 7, 14 while 15 has 1, 3, 5, 15.
    */
    public static void problem179() {
        long count = 0;
        for (long n = 2; n < 9999999; n++) {
            if (IFCMath.divisors(n).size() == IFCMath.divisors(n + 1).size())
                count++;
        }
        System.out.println(count);        
    }
}
