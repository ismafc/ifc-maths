/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ProjectEuler.P130_139;

import Library.IFCMath;

/**
 *
 * @author ismael.flores
 */
public class Problem135 {
    /*
    Same differences

    Given the positive integers, x, y, and z, are consecutive terms of an arithmetic progression, the least value of the positive integer, n, 
    for which the equation, x^2 − y^2 − z^2 = n, has exactly two solutions is n = 27:

    34^2 − 27^2 − 20^2 = 12^2 − 9^2 − 6^2 = 27

    It turns out that n = 1155 is the least value which has exactly ten solutions.

    How many values of n less than one million have exactly ten distinct solutions?
    */
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
