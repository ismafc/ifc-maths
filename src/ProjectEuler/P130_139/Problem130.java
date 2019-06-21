/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ProjectEuler.P130_139;

import java.math.BigInteger;
import Library.IFCMath;

/**
 *
 * @author ismael.flores
 */
public class Problem130 {
    
    /*
    Composites with prime repunit property

    A number consisting entirely of ones is called a repunit. We shall define R(k) to be a repunit of length k; for example, R(6) = 111111.

    Given that n is a positive integer and GCD(n, 10) = 1, it can be shown that there always exists a value, k, for which R(k) is divisible by n, and let A(n) be the least such value of k; for example, A(7) = 6 and A(41) = 5.

    You are given that for all primes, p > 5, that p − 1 is divisible by A(p). For example, when p = 41, A(41) = 5, and 40 is divisible by 5.

    However, there are rare composite values for which this is also true; the first five examples being 91, 259, 451, 481, and 703.

    Find the sum of the first twenty-five composite values of n for which
    GCD(n, 10) = 1 and n − 1 is divisible by A(n).
    */
    public static void problem130() {
        long n = 6;
        long sum = 0;
        long found = 0;
        while (found < 25) {
            if (!IFCMath.isPrime(n) && IFCMath.MCD(n, 10) == 1) {
                int k = 1;
                BigInteger i = BigInteger.ONE;
                BigInteger kk = BigInteger.valueOf(n);
                while (k <= n) {
                    if (i.mod(kk) == BigInteger.ZERO) {
                        break;
                    }
                    i = i.multiply(BigInteger.TEN).add(BigInteger.ONE);
                    k++;
                }
                if ((n - 1) % k == 0) {
                    found++;
                    sum += n;
                    System.out.println(found + " : Encontrado A(" + n + ") = " + k);
                }
            }
            n++;
        }
        System.out.println("Suma = " + sum);
    }
}
