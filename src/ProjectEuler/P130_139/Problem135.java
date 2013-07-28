/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ProjectEuler.P130_139;

import raytracer.IFCMath;

/**
 *
 * @author ismael.flores
 */
public class Problem135 {
    public static void problem135() {
        int tensolutions = 0;
        for (long n = 1155; n < 1000000; n++) {
            long A = 1;
            long solutions = 0;
            while (true) {
                long D = 4 * A * A + 3 * n;
                if (IFCMath.isPerfectSquare(D)) {
                    long k = -A + (long)Math.sqrt(D);
                    if (k % 3 == 0) {
                        k /= 3;
                        //System.out.println((A+2*k) + "^2 - " + (A+k) + "^2 - " + A + " = " + n);
                        solutions++;
                    }
                }
                double kd = -A + Math.sqrt(D) - n;
                if (kd > 0)
                    break;
                A++;
            }
            if (solutions == 10) {
                tensolutions++;
                //System.out.println("n = " + n);
            }
        }
        System.out.println("10 soluciones = " + tensolutions);
    }    
}
