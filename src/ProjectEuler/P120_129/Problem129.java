/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ProjectEuler.P120_129;

import java.math.BigInteger;
import Library.IFCMath;

/**
 *
 * @author ismael.flores
 */
public class Problem129 {
    /*    
    Repunit divisibility

    A number consisting entirely of ones is called a repunit. We shall define R(k) to be a repunit of length k; for example, R(6) = 111111.

    Given that n is a positive integer and GCD(n, 10) = 1, it can be shown that there always exists a value, k, for which R(k) is divisible by n, and let A(n) be the least such value of k; for example, A(7) = 6 and A(41) = 5.

    The least value of n for which A(n) first exceeds ten is 17.

    Find the least value of n for which A(n) first exceeds one-million.
    */
    public static void problem129() {
        long nn = 1000000;
        boolean found = false;
        while (!found) {
            if (IFCMath.mcd(nn, 10) == 1) {
                int k = 1;
                BigInteger i = BigInteger.ONE;
                BigInteger kk = BigInteger.valueOf(nn);
                while (k <= 1000000) {
                    if (i.mod(kk) == BigInteger.ZERO) {
                        break;
                    }
                    i = i.multiply(BigInteger.TEN).add(BigInteger.ONE);
                    k++;
                }
                if (k > 1000000)
                    found = true;
                System.out.println("Encontrado A(" + nn + ") = " + k);
            }
            nn++;
        }        
    }

}
