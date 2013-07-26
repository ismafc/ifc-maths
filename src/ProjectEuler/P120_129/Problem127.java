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
