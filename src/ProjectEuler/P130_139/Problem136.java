/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ProjectEuler.P130_139;

import java.util.ArrayList;
import raytracer.IFCMath;

/**
 *
 * @author ismael.flores
 */
public class Problem136 {
    /*    
    Singleton difference

    The positive integers, x, y, and z, are consecutive terms of an arithmetic progression. Given that n is a positive integer, the equation, x^2 − y^2 − z^2 = n, has exactly one solution when n = 20:

    13^2 − 10^2 − 7^2 = 20

    In fact there are twenty-five values of n below one hundred for which the equation has a unique solution.

    How many values of n less than fifty million have exactly one solution?
    */
    public static void problem136() {
        // (A+k)^2-A^2-(A-k)^2=n => A(4k-A)=n => A divide a n
        int onesolution = 0;
        for (long n = 1; n < 100; n++) {
            ArrayList<Long> divisors = IFCMath.divisors(n);
            long solutions = 0;
            for (Long A : divisors) {
                if ((n + A * A) % (4 * A) == 0) {
                    long k = (n + A * A) / (4 * A);
                    if (A - k > 0) {
                        //System.out.println((A+k) + "^2 - " + A + "^2 - " + (A-k) + "^2 = " + n);
                        solutions++;
                    }
                }
                if (solutions > 1)
                    break;
            }
            if (solutions == 1) {
                onesolution++;
                System.out.println("n = " + n);
            }
        }
        System.out.println("1 solucion = " + onesolution);        
    }    
}
