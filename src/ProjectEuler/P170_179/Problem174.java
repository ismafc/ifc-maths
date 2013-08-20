/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ProjectEuler.P170_179;

import java.util.HashMap;

/**
 *
 * @author ismael.flores
 */
public class Problem174 {
    /*
    Counting the number of "hollow" square laminae that can form one, two, three, ... distinct arrangements.

    We shall define a square lamina to be a square outline with a square "hole" so that the shape possesses vertical and horizontal symmetry.

    Given eight tiles it is possible to form a lamina in only one way: 3x3 square with a 1x1 hole in the middle. However, using thirty-two tiles it is possible to form two distinct laminae.

    If t represents the number of tiles used, we shall say that t = 8 is type L(1) and t = 32 is type L(2).

    Let N(n) be the number of t ≤ 1000000 such that t is type L(n); for example, N(15) = 832.

    What is ∑ N(n) for 1 ≤ n ≤ 10?
    */
    public static void problem174(long MAXTILES) {
        // <Tiles, Tipo>
        HashMap<Long, Long> LN = new HashMap<Long, Long>();
        long LMAX = MAXTILES / 4 + 1;
        for (long L = 3; L <= LMAX; L++) {
            long countT = 0;
            for (long iL = L; iL >= 3; iL -= 2) {
                countT += (4 * (iL - 1));
                if (countT <= MAXTILES) {
                    if (LN.containsKey(countT))
                        LN.put(countT, LN.get(countT) + 1L);
                    else
                        LN.put(countT, 1L);
                }
            }
        }
        // <#Numero de tiles del tipo, tipo>
        HashMap<Long, Long> NN = new HashMap<Long, Long>();
        for (long TILES : LN.keySet()) {
            long TIPO = LN.get(TILES);
            if (NN.containsKey(TIPO))
                NN.put(TIPO, NN.get(TIPO) + 1L);
            else
                NN.put(TIPO, 1L);
        }
        long count = 0;
        for (long TYPE : NN.keySet()) {
            if (TYPE >= 1 && TYPE <= 10) {
                count += NN.get(TYPE);
                System.out.println("N(" + TYPE + ") = " + NN.get(TYPE));
            }
        }
        System.out.println("Sum of all N(n) for n = 1 to 10 = " + count);
    }    
}
