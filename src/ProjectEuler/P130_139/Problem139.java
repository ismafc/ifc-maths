/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ProjectEuler.P130_139;

import java.util.ArrayList;
import Library.IFCMath;

/**
 *
 * @author Isma
 */
public class Problem139 {
    /*
    Pythagorean tiles

    Let (a, b, c) represent the three sides of a right angle triangle with integral length sides. It is possible to place four such triangles together to form a square with length c.

    For example, (3, 4, 5) triangles can be placed together to form a 5 by 5 square with a 1 by 1 hole in the middle and it can be seen that the 5 by 5 square can be tiled with twenty-five 1 by 1 squares.

    However, if (5, 12, 13) triangles were used then the hole would measure 7 by 7 and these could not be used to tile the 13 by 13 square.

    Given that the perimeter of the right triangle is less than one-hundred million, how many Pythagorean triangles would allow such a tiling to take place?
    */
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
