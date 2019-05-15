/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ProjectEuler.P001_009;

import raytracer.IFCMath;

/**
 *
 * @author ismael.flores
 */
public class Problem001 {

    /*
    Multiples of 3 and 5

    If we list all the natural numbers below 10 that are multiples of 3 or 5, 
    we get 3, 5, 6 and 9. The sum of these multiples is 23.
    Find the sum of all the multiples of 3 or 5 below 1000.
    */

    private static long solution1(long A, long B, long N) {
        long sum = 0;
        for (int i = 1; i < N; i++) {
            if (i % A == 0 || i % B == 0)
                sum += i;
        }
        return sum;
    }

    private static long solution2(long A, long B, long N) {
        long sum = 0;
        for (long i = A; i < N; i += A) {
            sum += i;
        }
        for (long i = B; i < N; i += B) {
            if (i % A != 0)
                sum += i;
        }
        return sum;
    }

    private static long solution3(long A, long B, long N) {
        long E = N - 1;
        long AB = IFCMath.MCM(A , B);
        long A1 = E / A;
        long B1 = E / B;
        long AB1 = E / AB;
        return A * (A1 * (A1 + 1)) / 2 + 
               B * (B1 * (B1 + 1)) / 2 - 
               AB * (AB1 * (AB1 + 1)) / 2;
    }
    
    public static void problem001() {
        long t = System.currentTimeMillis();
        System.out.println("Result1 = " + solution1(3, 5, 1000));
        System.out.println("Time (ms) = " + (System.currentTimeMillis() - t));

        t = System.currentTimeMillis();
        System.out.println("Result2 = " + solution2(3, 5, 1000));
        System.out.println("Time (ms) = " + (System.currentTimeMillis() - t));
        
        t = System.currentTimeMillis();
        System.out.println("Result3 = " + solution3(3, 5, 1000));
        System.out.println("Time (ms) = " + (System.currentTimeMillis() - t));
    }
    
}
