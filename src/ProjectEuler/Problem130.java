/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ProjectEuler;

import java.math.BigInteger;
import raytracer.IFCMath;

/**
 *
 * @author ismael.flores
 */
public class Problem130 {
    
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
