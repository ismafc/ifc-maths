/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ProjectEuler.P140_149;

import java.util.ArrayList;
import raytracer.IFCMath;

/**
 *
 * @author ismael.flores
 */
public class Problem147 {
    /*
    In a 3x2 cross-hatched grid, a total of 37 different rectangles could be situated within that grid as indicated in the sketch.
    There are 5 grids smaller than 3x2, vertical and horizontal dimensions being important, i.e. 1x1, 2x1, 3x1, 1x2 and 2x2.
    If each of them is cross-hatched, the following number of different rectangles could be situated within those smaller grids:

    1x1: 1
    2x1: 4
    3x1: 8
    1x2: 4
    2x2: 18

    Adding those to the 37 of the 3x2 grid, a total of 72 different rectangles could be situated within 3x2 and smaller grids.
    How many different rectangles could be situated within 47x43 and smaller grids?
    */
    public static long cross_hatched(long W, long H) {
        long sum = 0;
        
        // horizontals
        for (long w = 1L; w <= W; w++) {
            for (long h = 1L; h <= H; h++) {
                sum += (W - w + 1) * (H - h + 1);
                //System.out.println("hSuma (" + w + "x" + h + ") = " + ((W - w + 1) * (H - h + 1)));               
            }
        }
        
        // Diagonals
        for (long n = 1L; n <= Math.min(W, H) * 2; n++) {
            for (long m = 1L; m <= n; m++) {
                double ancho_alto = (n + m) / 2.0;

                // Ancho diagonal impar
                if (n % 2 == 1) {
                    // empieza en Y = 0
                    double cabenx = Math.floor(W - 0.5 - ancho_alto + 1);
                    double cabeny = Math.floor(H - ancho_alto + 1);
                    if (cabenx > 0.0 && cabeny > 0.0) {
                        sum += cabenx * cabeny * ((n != m) ? 2 : 1);
                    }                    
                    // empieza en Y = 0.5
                    cabenx = Math.floor(W - ancho_alto + 1);
                    cabeny = Math.floor(H - 0.5 - ancho_alto + 1);
                    if (cabenx > 0.0 && cabeny > 0.0) {
                        sum += cabenx * cabeny * ((n != m) ? 2 : 1);
                    }
                }
                // Ancho diagonal par
                else {
                    // Empieza en Y = 0
                    double cabenx = Math.floor(W - ancho_alto + 1);
                    double cabeny = Math.floor(H - ancho_alto + 1);
                    if (cabenx > 0.0 && cabeny > 0.0) {
                        sum += cabenx * cabeny * ((n != m) ? 2 : 1);
                    }                    
                    // Empieza en Y = 0.5
                    cabenx = Math.floor(W - 0.5 - ancho_alto + 1);
                    cabeny = Math.floor(H - 0.5 - ancho_alto + 1);
                    if (cabenx > 0.0 && cabeny > 0.0) {
                        sum += cabenx * cabeny * ((n != m) ? 2 : 1);
                    }                    
                }
            }
        }
        // Diagonals squared
        System.out.println("Suma (" + W + "x" + H + ") = " + sum);
        return sum;
    }
    
    public static void problem147(Long W, Long H) {
        long sum = 0L;
        for (long w = 1L; w <= W; w++) {
            for (long h = 1L; h <= H; h++) {
                sum += Problem147.cross_hatched(w, h);
            }
        }
        System.out.println("Suma total (" + W + "x" + H + ") = " + sum);
    }
}
