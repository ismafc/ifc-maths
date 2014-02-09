/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ProjectEuler.P180_189;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.RoundingMode;
import java.util.HashMap;
import raytracer.IFCMath;

/**
 *
 * @author Isma
 */
public class Problem183 {
    /*
    Maximum product of parts
    
    Let N be a positive integer and let N be split into k equal parts, r = N/k, so that N = r + r + ... + r.
    Let P be the product of these parts, P = r × r × ... × r = rk.

    For example, if 11 is split into five equal parts, 11 = 2.2 + 2.2 + 2.2 + 2.2 + 2.2, then P = 2.25 = 51.53632.

    Let M(N) = Pmax for a given value of N.

    It turns out that the maximum for N = 11 is found by splitting eleven into four equal parts which leads to Pmax = (11/4)4; that is, M(11) = 14641/256 = 57.19140625, which is a terminating decimal.

    However, for N = 8 the maximum is achieved by splitting it into three equal parts, so M(8) = 512/27, which is a non-terminating decimal.

    Let D(N) = N if M(N) is a non-terminating decimal and D(N) = -N if M(N) is a terminating decimal.

    For example, ΣD(N) for 5 ≤ N ≤ 100 is 2438.

    Find ΣD(N) for 5 ≤ N ≤ 10000.
    */    
    public static void problem183(BigDecimal MIN, BigDecimal MAX) {
        BigInteger TWO = new BigInteger("2");
        BigInteger FIVE = new BigInteger("5");
        BigDecimal D = BigDecimal.ZERO;
        BigDecimal iparts = new BigDecimal(2);
        for (BigDecimal N = MIN; N.compareTo(MAX) <= 0; N = N.add(BigDecimal.ONE)) {
            BigDecimal max = BigDecimal.ZERO;
            BigDecimal parts = iparts;
            boolean foundmax = false;
            while (!foundmax) {
                BigDecimal nmax = N.divide(parts, 10, RoundingMode.HALF_UP).pow(parts.intValue());
                if (nmax.compareTo(max) > 0) {
                    max = nmax;
                    parts = parts.add(BigDecimal.ONE);
                }
                else {
                    foundmax = true;
                    parts = parts.subtract(BigDecimal.ONE);
                }
            }
            iparts = parts;
            HashMap<BigInteger, BigInteger> pf = IFCMath.primeFactorization(parts.toBigInteger());
            BigDecimal NN = new BigDecimal(N.toBigInteger());
            for (BigInteger bi : pf.keySet()) {
                BigDecimal bd = new BigDecimal(bi);
                while (NN.remainder(bd).equals(BigDecimal.ZERO) && parts.remainder(bd).equals(BigDecimal.ZERO)) {
                    NN = NN.divide(bd);
                    parts = parts.divide(bd);
                }
            }
            pf = IFCMath.primeFactorization(parts.toBigInteger());
            if (pf.size() > 2)
                D = D.add(N);
            else if (pf.size() == 2 && pf.containsKey(TWO) && pf.containsKey(FIVE))
                D = D.subtract(N);
            else if (pf.size() == 1 && (pf.containsKey(TWO) || pf.containsKey(FIVE)))
                D = D.subtract(N);
            else if (pf.isEmpty())
                D = D.subtract(N);
            else
                D = D.add(N);
            //System.out.println("M(" + N + ") = " + max + "(" + parts + ")");
        }
        System.out.println(D);
    }    
}
