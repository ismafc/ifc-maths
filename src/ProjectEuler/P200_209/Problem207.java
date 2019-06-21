/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ProjectEuler.P200_209;

import java.util.ArrayList;
import Library.IFCMath;

/**
 *
 * @author ismael.flores
 */
public class Problem207 {
    /*
    Integer partition equations

    For some positive integers k, there exists an integer partition of the form   4t = 2t + k,
    where 4t, 2t, and k are all positive integers and t is a real number.

    The first two such partitions are 4^1 = 2^1 + 2 and 4^1.5849625... = 2^1.5849625... + 6.

    Partitions where t is also an integer are called perfect.
    For any m ≥ 1 let P(m) be the proportion of such partitions that are perfect with k ≤ m.
    Thus P(6) = 1/2.

    In the following table are listed some values of P(m)

       P(5) = 1/1
       P(10) = 1/2
       P(15) = 2/3
       P(20) = 1/2
       P(25) = 1/2
       P(30) = 2/5
       ...
       P(180) = 1/4
       P(185) = 3/13

    Find the smallest m for which P(m) < 1/12345
    */    
    public static void problem207(double target) {
        // x = (log(1/2 (sqrt(4 n+1)+1)))/(log(2))+(2 i pi c_1)/(log(2))
        // 4N+1 debe ser un cuadrado perfecto
        Double EPSILON = 0.0000000001;
        Double log2 = Math.log(2.0);
        Boolean found = false;
        Long num = 0L;
        Long den = 0L;
        Long N = 2L;
        Long OFFSET = 4L;
        while (!found) {
            Double x = Math.log(0.5*(Math.sqrt(4.0*N+1.0)+1))/log2;
            if (Math.abs(Math.round(x) - x) < EPSILON) {
                den++;
                num++;
            }
            else {
                den++;
            }
            if (den > 0)
                found = ((double)num / (double)den) < target;
            if (found)
                System.out.println("P(" + N + ") = " + num + "/" + den);
            N += OFFSET;
            OFFSET += 2;
        }
    }    
}
