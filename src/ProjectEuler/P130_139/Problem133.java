/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ProjectEuler.P130_139;

import java.math.BigInteger;
import java.util.HashMap;
import raytracer.IFCMath;

/**
 *
 * @author Isma
 */
public class Problem133 {
    public static void problem133() {
        HashMap<Long, Boolean> factors = new HashMap<Long, Boolean>();
        BigInteger one = BigInteger.ONE;
        BigInteger ten = BigInteger.TEN;
        BigInteger nine = ten.subtract(one);
        for (long k2 = 0; k2 <= 50; k2++) {
            for (long k5 = 0; k5 <= 50; k5++) {
                double kkl = Math.pow(2, k2) * Math.pow(5, k5);
                if (kkl != Double.NaN && kkl <= 50000000.0) {
                    long kk = Math.round(kkl);
                    System.out.println("R(" + kk + ")");
                    BigInteger nn = ten.pow((int)kk).subtract(one).divide(nine);
                    for (BigInteger pf : IFCMath.primeFactors(nn, new BigInteger("100000"))) {
                        Long pfl = pf.longValue();
                        if (!factors.containsKey(pfl))
                            factors.put(pfl, Boolean.TRUE);
                    }
                    System.out.println("-----");
                }
            }
        }
        // Estos son los que salen si dejamos acabar el bucle de arriba
/*
        factors.put(11L, Boolean.TRUE);
        factors.put(17L, Boolean.TRUE);
        factors.put(41L, Boolean.TRUE);
        factors.put(73L, Boolean.TRUE);
        factors.put(101L, Boolean.TRUE);
        factors.put(137L, Boolean.TRUE);
        factors.put(251L, Boolean.TRUE);
        factors.put(257L, Boolean.TRUE);
        factors.put(271L, Boolean.TRUE);
        factors.put(353L, Boolean.TRUE);
        factors.put(401L, Boolean.TRUE);
        factors.put(449L, Boolean.TRUE);
        factors.put(641L, Boolean.TRUE);
        factors.put(751L, Boolean.TRUE);
        factors.put(1201L, Boolean.TRUE);
        factors.put(1409L, Boolean.TRUE);
        factors.put(1601L, Boolean.TRUE);
        factors.put(3541L, Boolean.TRUE);
        factors.put(4001L, Boolean.TRUE);
        factors.put(4801L, Boolean.TRUE);
        factors.put(5051L, Boolean.TRUE);
        factors.put(9091L, Boolean.TRUE);
        factors.put(10753L, Boolean.TRUE);
        factors.put(15361L, Boolean.TRUE);
        factors.put(16001L, Boolean.TRUE);
        factors.put(19841L, Boolean.TRUE);
        factors.put(21001L, Boolean.TRUE);
        factors.put(21401L, Boolean.TRUE);
        factors.put(24001L, Boolean.TRUE);
        factors.put(25601L, Boolean.TRUE);
        factors.put(27961L, Boolean.TRUE);
        factors.put(37501L, Boolean.TRUE);
        factors.put(40961L, Boolean.TRUE);
        factors.put(43201L, Boolean.TRUE);
        factors.put(60101L, Boolean.TRUE);
        factors.put(62501L, Boolean.TRUE);
        factors.put(65537L, Boolean.TRUE);
        factors.put(69857L, Boolean.TRUE);
        factors.put(76001L, Boolean.TRUE);
        factors.put(76801L, Boolean.TRUE);*/
        long sum = 0;
        for (long kk = 2; kk < 100000; kk++) {
            if (IFCMath.isPrime(kk)) {
                if (!factors.containsKey(kk))
                    sum += kk;
            }
        }
        System.out.println(sum);
    }
    
}
