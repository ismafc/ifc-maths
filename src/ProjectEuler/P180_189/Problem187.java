/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ProjectEuler.P180_189;

import raytracer.IFCMath;

/**
 *
 * @author Isma
 */
public class Problem187 {
    /*
    Semiprimes

    A composite is a number containing at least two prime factors. For example, 15 = 3 × 5; 9 = 3 × 3; 12 = 2 × 2 × 3.

    There are ten composites below thirty containing precisely two, not necessarily distinct, prime factors: 4, 6, 9, 10, 14, 15, 21, 22, 25, 26.

    How many composite integers, n < 10^8, have precisely two, not necessarily distinct, prime factors?
    */    
    public static void problem187(long N) {
        long count = 0;
        for (long n = 4; n < N; n++) {
            if (IFCMath.isSemiprime(n))
                count++;
        }
        System.out.println(count);        
    }    
}
