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

    private static long solution1(long A, long B, long M, long N) {
        long sum = 0;
        for (long i = M; i < N; i++) {
            if (i % A == 0 || i % B == 0)
                sum += i;
        }
        return sum;
    }

    private static long solution2(long A, long B, long M, long N) {
        long sum = 0;
        long M1 = (M % A == 0) ? M : M + A - M % A;
        for (long i = M1; i < N; i += A) {
            sum += i;
        }
        M1 = (M % B == 0) ? M : M + B - M % B;
        for (long i = M1; i < N; i += B) {
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
    
    private static long solution3(long A, long B, long M, long N) {
        return solution3(A, B, N) - solution3(A, B, M);
    }
    
    public static long problem001(long A, long B, long M, long N) {
        long t = System.currentTimeMillis();
        long s1 = solution1(A, B, M, N);
        System.out.println("Result1 = " + s1);
        System.out.println("Time (ms) = " + (System.currentTimeMillis() - t));

        t = System.currentTimeMillis();
        long s2 = solution2(A, B, M, N);
        System.out.println("Result2 = " + s2);
        System.out.println("Time (ms) = " + (System.currentTimeMillis() - t));
        
        t = System.currentTimeMillis();
        long s3 = solution3(A, B, M, N);
        System.out.println("Result3 = " + s3);
        System.out.println("Time (ms) = " + (System.currentTimeMillis() - t));

        return s3;
    }
    
}