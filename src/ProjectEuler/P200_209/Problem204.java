/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ProjectEuler.P200_209;

import java.util.ArrayList;
import Library.IFCMath;

/**
 *
 * @author ismael.flores
 */
public class Problem204 {
    /*
    Generalised Hamming Numbers

    A Hamming number is a positive number which has no prime factor larger than 5.
    So the first few Hamming numbers are 1, 2, 3, 4, 5, 6, 8, 9, 10, 12, 15.
    There are 1105 Hamming numbers not exceeding 10^8.

    We will call a positive number a generalised Hamming number of type n, if it has no prime factor larger than n.
    Hence the Hamming numbers are the generalised Hamming numbers of type 5.

    How many generalised Hamming numbers of type 100 are there which don't exceed 10^9?
    */    
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
