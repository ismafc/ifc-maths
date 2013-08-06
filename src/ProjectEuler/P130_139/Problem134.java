/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ProjectEuler.P130_139;

import raytracer.IFCMath;

/**
 *
 * @author ismael.flores
 */
public class Problem134 {

    /*
    Prime pair connection

    Consider the consecutive primes p1 = 19 and p2 = 23. 
    It can be verified that 1219 is the smallest number such that the last digits are formed by p1 whilst also being divisible by p2.

    In fact, with the exception of p1 = 3 and p2 = 5, for every pair of consecutive primes, p2 > p1, 
    there exist values of n for which the last digits are formed by p1 and n is divisible by p2. Let S be the smallest of these values of n.

    Find ∑ S for every pair of consecutive primes with 5 ≤ p1 ≤ 1000000.
    */  
    public static void problem134() {
        long p1 = 5;
        long sum = 0;
        while (p1 <= 1000000) {
            long p2 = p1 + 2;
            while (!IFCMath.isPrime(p2)) {
                p2 += 2;
            }
            long module = (long)Math.pow(10, (long)Math.log10(p1) + 1);
            long s = 1;
            while ((module * s + p1) % p2 != 0)
                s++;
            sum += (module * s + p1);
            System.out.println("p1 = " + p1 + "; p2 = " + p2 + "; s = " + (module * s + p1));
            p1 = p2;
        }
        System.out.println("sum = " + sum);
    }    
}
