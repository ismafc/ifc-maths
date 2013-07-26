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
