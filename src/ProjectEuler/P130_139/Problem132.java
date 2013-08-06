/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ProjectEuler.P130_139;

import java.math.BigInteger;
import raytracer.IFCMath;

/**
 *
 * @author ismael.flores
 */
public class Problem132 {
    /*
    Large repunit factors

    A number consisting entirely of ones is called a repunit. We shall define R(k) to be a repunit of length k.

    For example, R(10) = 1111111111 = 11×41×271×9091, and the sum of these prime factors is 9414.

    Find the sum of the first forty prime factors of R(109).
    */
    public static void problem132() {
        BigInteger one = BigInteger.ONE;
        BigInteger ten = BigInteger.TEN;
        BigInteger nine = ten.subtract(one);
        for (long k2 = 1; k2 <= 9; k2++) {
            for (long k5 = 0; k5 <= 5; k5++) {
                long kk = Math.round(Math.pow(2, k2) * Math.pow(5, k5));
                BigInteger nn = ten.pow((int)kk).subtract(one).divide(nine);
                System.out.println("R(" + kk + ")");
                IFCMath.primeFactors(nn, new BigInteger("162251"));
                System.out.println("-----");
            }
        }
    }
}
