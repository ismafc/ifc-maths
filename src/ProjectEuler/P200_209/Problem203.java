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
