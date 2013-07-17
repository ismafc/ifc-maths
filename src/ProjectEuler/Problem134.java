/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ProjectEuler;

import raytracer.IFCMath;

/**
 *
 * @author ismael.flores
 */
public class Problem134 {
    public static void problem134() {
        long p1 = 5;
        long sum = 0;
        while (p1 <= 1000000) {
            long p2 = p1 + 2;
            while (!IFCMath.isPrime(p2)) {
                p2 += 2;
            }
            long module = (long)Math.pow(10, (long)Math.log10(p1) + 1);
            long s = 1;
            while ((module * s + p1) % p2 != 0)
                s++;
            sum += (module * s + p1);
            System.out.println("p1 = " + p1 + "; p2 = " + p2 + "; s = " + (module * s + p1));
            p1 = p2;
        }
        System.out.println("sum = " + sum);
    }    
}
