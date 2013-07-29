/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ProjectEuler.P170_179;

import raytracer.IFCMath;

/**
 *
 * @author Isma
 */
public class Problem179 {
    public static void problem179() {
        long count = 0;
        for (long n = 2; n < 9999999; n++) {
            if (IFCMath.divisors(n).size() == IFCMath.divisors(n + 1).size())
                count++;
        }
        System.out.println(count);        
    }
}
