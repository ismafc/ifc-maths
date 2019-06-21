/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ProjectEuler.P140_149;

import Library.IFCMath;

/**
 *
 * @author ismael.flores
 */
public class Problem142 {
    /*
    Find the smallest x + y + z with integers x > y > z > 0 such that x + y, x − y, x + z, x − z, y + z, y − z are all perfect squares.
    */
    public static void problem142() {
        boolean found = false;
        Long iA = 6L;
        while (!found) {
            Long A = iA * iA;                           // A = x + y (El mayor cuadrado)
            
            // Desde el cuadrado mayor (A), busco el posible segundo mayor (B)
            for (Long iB = iA - 1; iB >= 5; iB--) {
                Long B =  iB * iB;                      // B = x + z (El segundo mayor cuadrado)
                
                // C = B - 2z debe ser también un cuadrado anterior
                for (Long iC = iB - 1; iC >= 4; iC--) {
                    Long C = iC * iC;
                    if ((B - C) % 2 == 0) {
                        Long z = (B - C) / 2;                // Ya tenemos la z candidata
                        Long x = B - z;                      // Ya tenemos la x candidata
                        Long y = A - x;                      // Ya tenemos la y candidata
                        if (x > y && x > z && y > z &&
                            IFCMath.isPerfectSquare(x - y) && IFCMath.isPerfectSquare(x - z) && 
                            IFCMath.isPerfectSquare(x + y) && IFCMath.isPerfectSquare(x + z) && 
                            IFCMath.isPerfectSquare(y - z) && IFCMath.isPerfectSquare(y + z)) {
                            System.out.println("x = " + x + "; y = " + y + "; z = " + z + "; x + y + z = " + (x+y+z));
                            found = true;
                        }
                    }
                }
            }
            iA++;
        }
    }    
}
