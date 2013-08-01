/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ProjectEuler.P170_179;

/**
 *
 * @author ismael.flores
 */
public class Problem173 {
    
    public static void problem173(long N) {
        // L = Ancho del cuadrado        
        // TILES = 4 * (L - 1)
        // N = 4 * (LMAX - 1) -> LMAX = N / 4 + 1
        long count = 0;
        long LMAX = N / 4 + 1;
        for (long L = 3; L <= LMAX; L++) {
            long countL = 0;
            for (long iL = L; iL >= 3; iL -= 2) {
                countL += (4 * (iL - 1));
                if (countL <= N)
                    count++;
            }
        }
        System.out.println(count);        
    }
}
