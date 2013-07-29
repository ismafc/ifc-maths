/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ProjectEuler.P180_189;

import raytracer.IFCMath;

/**
 *
 * @author Isma
 */
public class Problem187 {
    public static void problem187(long N) {
        long count = 0;
        for (long n = 4; n < N; n++) {
            if (IFCMath.isSemiprime(n))
                count++;
        }
        System.out.println(count);        
    }    
}
