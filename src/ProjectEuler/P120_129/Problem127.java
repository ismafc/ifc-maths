/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ProjectEuler.P120_129;

import raytracer.IFCMath;

/**
 *
 * @author ismael.flores
 */
public class Problem127 {
    
    private static long rad(long r) {
        long result = 1;
        for (Long pf : IFCMath.primeFactors(r)) {
            result *= pf;
        }
        return result;
    }

    // Es lentísimo (1 semana ejecutándose)
    /*    
    abc-hits

    The radical of n, rad(n), is the product of distinct prime factors of n. For example, 504 = 2^3 × 3^2 × 7, so rad(504) = 2 × 3 × 7 = 42.

    We shall define the triplet of positive integers (a, b, c) to be an abc-hit if:

        GCD(a, b) = GCD(a, c) = GCD(b, c) = 1
        a < b
        a + b = c
        rad(abc) < c

    For example, (5, 27, 32) is an abc-hit, because:

        GCD(5, 27) = GCD(5, 32) = GCD(27, 32) = 1
        5 < 27
        5 + 27 = 32
        rad(4320) = 30 < 32

    It turns out that abc-hits are quite rare and there are only thirty-one abc-hits for c < 1000, with ∑c = 12523.

    Find ∑c for c < 120000.
    */
    static public void ejercicio127() {
        long MAX_C = 120000;
        long sc = 0;
        long a = 1;
        while (a < MAX_C / 2) {
            long offsetb = (a % 2 == 0) ? 2 : 1;
            long b = a + 1;
            long c = a + b;
            while (c < MAX_C) {
                if (IFCMath.MCD(a, b) == 1) {
                    if (IFCMath.MCD(a, c) == 1) {
                        if (IFCMath.MCD(b, c) == 1) {
                            long r = rad(a * b * c);
                            if (r < c) {
                                System.out.println("(" + a + "," + b + "," + c + ") = " + r);
                                sc += c;
                            }
                        }         
                    }
                }
                b += offsetb;
                c = a + b;
            }
            a++;
        }
        System.out.println("Suma de c = " + sc);
    }
}
