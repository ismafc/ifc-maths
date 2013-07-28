/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ProjectEuler.P130_139;

import java.math.BigInteger;

/**
 *
 * @author ismael.flores
 */
public class Problem137 {
    public static void problem137() {
        // a0, a1, a2, a3, ... Son la secuencia de fibonacci
        // f(x) = a0 + a1*x + a2*x^2 + a3*x^3 + ... = x / (1 - x - x^2)
        // Golden 1 = 2 (x = 2/4 = 1/2)
        // Golden 2 = 15 (x = 18/30 = 3/5)
        // Golden 3 = 104 (x = 128/208 = 8/13)
        // Golden 4 = 714 (x = 882/1428 = 21/34)
        // Golden 5 = 4895 (x = 6050/9790 = 55/89)
        // Golden 6 = 33552 (x = 41472/67104 = 144/233)
        // Golden 7 = 229970 (x = 284258/459940 = 377/610)
        // Golden 8 = 1576239 (x = 1948338/3152478 = 987/1597)
        // Golden 9 = 10803704 (x = 13354112/21607408 = 2584/4181)
        // Golden 10 = 74049690 (x = 91530450/148099380 = 6765/10946)
        // ...
        // La x sigue la fracción continua 1/(1+1/(1+1/(1+1/(...)))), o sea,
        // 1/2, 2/3, 3/5, 5/8, 8/13, ...
        
        long goldens = 0;
        BigInteger num = BigInteger.ONE;
        BigInteger den = num.add(BigInteger.ONE);
        while (goldens < 15) {
            BigInteger nd = num.multiply(den);
            BigInteger nn = num.multiply(num);
            BigInteger dd = den.multiply(den);
            BigInteger fxn = nd;
            BigInteger fxd = dd.subtract(nd).subtract(nn);
            if (fxd.compareTo(BigInteger.ZERO) == 1) {
                BigInteger fx = fxn.divide(fxd);
                BigInteger fxm = fxn.mod(fxd);
                if (fxm.equals(BigInteger.ZERO)) {
                    goldens++;
                    System.out.println("Golden " + goldens + ": x=" + num.toString() + "/" + den.toString() + " -> f(x) = " + fx.toString());
                }
            }
            den = num.add(den);
            num = den.subtract(num);
        }
    }    
}
