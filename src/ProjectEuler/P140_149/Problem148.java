/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ProjectEuler.P140_149;

import java.util.ArrayList;

/**
 *
 * @author ismael.flores
 */
public class Problem148 {
    /*
    We can easily verify that none of the entries in the first seven rows of Pascal's triangle are divisible by 7:
                                                         1
                                                1 	  	 1
                                        1 	  	 2 	  	 1
                                1 	  	 3 	  	 3 	  	 1
                        1 	  	 4 	  	 6 	  	 4 	  	 1
                1 	  	 5 	  	10 	  	10 	  	 5 	  	 1
        1 	  	 6 	  	15 	  	20 	  	15 	  	 6 	  	 1

    However, if we check the first one hundred rows, we will find that only 2361 of the 5050 entries are not divisible by 7.

    Find the number of entries which are not divisible by 7 in the first one billion (109) rows of Pascal's triangle.
    */
    
    public static long chainValue(ArrayList<Long> chain) {
        long m = 1;
        for (Long c : chain)
            m *= c;
        return m;
    }
    
    public static void addChain(ArrayList<Long> chain) {
        boolean needAdd = false;
        for (int i = 0; i < chain.size(); i++) {
            if (chain.get(i) < 7) {
                chain.set(i, chain.get(i) + 1);
                needAdd = false;
                break;
            }
            else {
                chain.set(i, 1L);
                needAdd = true;
            }
        }
        if (needAdd) {
            chain.set(chain.size() - 1, chain.get(chain.size() - 1) + 1);
            chain.add(0, 1L);
        }
    }
    
    public static void problem148(Long ROWS) {
        long row = 0;
        ArrayList<Long> chain = new ArrayList<Long>();
        long dividedBy7 = 0;
        long notDividedBy7 = 0;
        long total = 0;
        chain.add(1L);
        while (row < ROWS) {
            total = total + row + 1L;
            notDividedBy7 += chainValue(chain);
            dividedBy7 = (total - notDividedBy7);
            addChain(chain);
            row++;
        }
        System.out.println("Total = " + (dividedBy7 + notDividedBy7) + " (" + dividedBy7 + " of " + notDividedBy7 + ")");
    }
}
