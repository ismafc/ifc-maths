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

    /*    
    Using up to one million tiles how many different "hollow" square laminae can be formed?

    We shall define a square lamina to be a square outline with a square "hole" so that the shape possesses vertical and horizontal symmetry. For example, using exactly thirty-two square tiles we can form two different square laminae:

    With one-hundred tiles, and not necessarily using all of the tiles at one time, it is possible to form forty-one different square laminae.

    Using up to one million tiles how many different square laminae can be formed?
    */
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
