/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ProjectEuler.P120_129;

import java.math.BigInteger;
import raytracer.IFCMath;

/**
 *
 * @author ismael.flores
 */
public class Problem123 {
    
    // ((Pn-1)^n + (Pn+1)^n) mod Pn^2 > 10^10
    // encontrar n (Pn es el primo n-esimo)
    /*    
    Prime square remainders

    Let pn be the nth prime: 2, 3, 5, 7, 11, ..., and let r be the remainder when (pn−1)^n + (pn+1)^n is divided by pn^2.

    For example, when n = 3, p3 = 5, and 4^3 + 6^3 = 280 ≡ 5 mod 25.

    The least value of n for which the remainder first exceeds 10^9 is 7037.

    Find the least value of n for which the remainder first exceeds 10^10.
    */
    public static int problem123() {
        BigInteger pn = new BigInteger("100001");
        BigInteger order = new BigInteger("9593"); // Del primo 100003
        BigInteger limit = new BigInteger("10000000000");
        while (true) {
            if (IFCMath.isPrime(pn.longValue())) {
                BigInteger pn_1 = pn.subtract(BigInteger.ONE).pow(order.intValue());
                BigInteger pn1 = pn.add(BigInteger.ONE).pow(order.intValue());
                BigInteger pn2 = pn.multiply(pn);
                BigInteger r = pn_1.add(pn1).mod(pn2);
                if (r.compareTo(limit) == 1) {
                    return order.intValue();
                }
                order = order.add(BigInteger.ONE);
            }
            pn = pn.add(BigInteger.ONE);
        }
    }

}
