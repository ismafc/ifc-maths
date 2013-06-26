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
public class Problem129 {
    
    public static void problem129() {
        long nn = 1000000;
        boolean found = false;
        while (!found) {
            if (IFCMath.MCD(nn, 10) == 1) {
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
