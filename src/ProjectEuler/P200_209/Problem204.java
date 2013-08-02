/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ProjectEuler.P200_209;

import java.util.ArrayList;
import raytracer.IFCMath;

/**
 *
 * @author ismael.flores
 */
public class Problem204 {
    public static void problem204(long HTYPE, long LIMIT) {
        ArrayList<Long> primes = new ArrayList<Long>();
        for (long N = 2L; N <= HTYPE; N++) {
            if (IFCMath.isPrime(N))
                primes.add(N);
        }
        long count = HTYPE;
        for (long N = HTYPE + 1; N <= LIMIT; N++) {
            long NN = N;
            for (long P : primes) {
                while (NN % P == 0)
                    NN /= P;
            }
            if (NN == 1)
                count++;
        }
        System.out.println(count);
    }    
}
