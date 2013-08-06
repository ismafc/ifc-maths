/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ProjectEuler.P200_209;

import java.util.ArrayList;
import java.util.HashMap;
import raytracer.IFCMath;

/**
 *
 * @author ismael.flores
 */
public class Problem203 {
    
    public static ArrayList<Long> getNewPascalRow(ArrayList<Long> pascal) {
        ArrayList<Long> np = new ArrayList<Long>();
        np.add(1L);
        for (int i = 0; i < pascal.size() - 1; i++) {
            np.add(pascal.get(i) + pascal.get(i + 1));
        }
        np.add(1L);
        return np;
    }    
    
    /*
    Squarefree Binomial Coefficients

    The binomial coefficients nCk can be arranged in triangular form, Pascal's triangle, like this:
                                        1	
                                    1       1	
                                1       2       1	
                            1       3       3       1	
                        1       4       6       4       1	
                    1       5       10      10      5       1	
                1       6       15      20      15      6       1	
            1       7       21      35      35      21      7       1
                                    .........

    It can be seen that the first eight rows of Pascal's triangle contain twelve distinct numbers: 1, 2, 3, 4, 5, 6, 7, 10, 15, 20, 21 and 35.

    A positive integer n is called squarefree if no square of a prime divides n. Of the twelve distinct numbers in the first eight rows of Pascal's triangle, all except 4 and 20 are squarefree. The sum of the distinct squarefree numbers in the first eight rows is 105.

    Find the sum of the distinct squarefree numbers in the first 51 rows of Pascal's triangle.
    */    
    public static void problem203(long ROWS) {
        ArrayList<Long> pascal = new ArrayList<Long>();
        HashMap<Long, Boolean> squarefree = new HashMap<Long, Boolean>();

        long sum = 1;
        long row = 2;
        squarefree.put(1L, Boolean.TRUE);
        pascal.add(1L);
        pascal.add(1L);
        while (row < ROWS) {
            ArrayList<Long> npascalrow = getNewPascalRow(pascal);
            for (long l : npascalrow) {
                if (!squarefree.containsKey(l)) {
                    HashMap<Long, Long> pf = IFCMath.primeFactorization(l);
                    boolean sqf = true;
                    for (Long p : pf.keySet()) {
                        if (pf.get(p) >= 2) {
                            sqf = false;
                            break;
                        }
                    }
                    if (sqf)
                        sum += l;
                    squarefree.put(l, sqf);
                }
            }
            pascal = npascalrow;
            row++;
        }
        System.out.println(sum);        
    }    
}
