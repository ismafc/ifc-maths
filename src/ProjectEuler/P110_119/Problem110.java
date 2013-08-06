/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ProjectEuler.P110_119;

/**
 *
 * @author ismael.flores
 */
public class Problem110 {

    /*
    Diophantine reciprocals II

    In the following equation x, y, and n are positive integers.
    1/x + 1/y = 1/n

    It can be verified that when n = 1260 there are 113 distinct solutions and this is the least value of n for which the total number of distinct solutions exceeds one hundred.

    What is the least value of n for which the number of distinct solutions exceeds four million?

    NOTE: This problem is a much more difficult version of problem 108 and as it is well beyond the limitations of a brute force approach it requires a clever implementation.
    */    
    public static void problem110() {
        // 1/x + 1/y = 1/n
        // Número de soluciones para un 'n' determinado (menor 'n' para el que hay más de 4 millones de solucines
        // - x > n
        // - y > n
        // n + 1 <= x <= n(n+1)
        // relacionado con la descomposición en factores
        long solutions = 0;
        //long n = 2*2*2*2*2*3*3*3*3*5*5*5*5*7*7*11;
        // 2*2=3            (4)
        // 2*3=5            (6)
        // 2*2*2=4          (8)
        // 3*3=3            (9)
        // 2*5=5            (10)
        // 2*2*3=8          (12)
        // 2*7=5            (14)
        // 3*5=5            (15)
        // 2*2*2*2=5        (16)
        // 3*3*2=8          (18)
        // 3*3*2*2=8        (36)

        long n = 2*2*2*3*3;
        long lastx = n * (n + 1);
        for (long x = n + 1; x <= lastx; x++) {
            if (x * n % (x - n) == 0) {
                //System.out.println("1/" + x + " + 1/" + (x * n / (x - n)) + " = 1/" + n);
                lastx = x * n / (x - n);
                solutions++;
            }
            else
                lastx = x * n / (x - n) + 1;
        }
        System.out.println("Solutions for n = " + n + " = " + solutions);
    }
    
}
