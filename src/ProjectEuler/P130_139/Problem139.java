/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ProjectEuler.P130_139;

import java.util.ArrayList;
import raytracer.IFCMath;

/**
 *
 * @author Isma
 */
public class Problem139 {
    // x^2 + (x+N)^2 = h^2 -> 2h^2-N^2 cuadrado perfecto.
    // N debe ser divisor de H para que el cuadrado NxN puede rellenar el HxH
    public static void problem139(long maxPerimeter) {
        long count = 0;
        for (long H = 3L; H < maxPerimeter / 2L; H++) {
            ArrayList<Long> divisors = IFCMath.divisors(H);
            divisors.remove(H);
            for (long N : divisors) {
                long discriminant = 2 * H * H - N * N;
                if (IFCMath.isPerfectSquare(discriminant)) {
                    long x = ((long)Math.sqrt(discriminant) - N) / 2L;
                    if (x + x + N + H < maxPerimeter) {
                        System.out.println(x + "^2 + " + (x+N) + "^2 = " + H + "^2 (Hole = " + N + ")");
                        count++;
                    }
                }
            }
        }
        System.out.println(count);
    }    
}
