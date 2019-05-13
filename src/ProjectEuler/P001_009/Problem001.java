/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ProjectEuler.P001_009;

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
    public static void problem001() {
        long sum = 0;
        long t = System.currentTimeMillis();
        for (int i = 1; i < 1000; i++) {
            if (i % 3 == 0 || i % 5 == 0)
                sum += i;
        }
        System.out.println("Result = " + sum);
        System.out.println("Time (ms) = " + (System.currentTimeMillis() - t));

        long sum1 = 0;
        t = System.currentTimeMillis();
        for (int i = 3; i < 1000; i += 3) {
            sum1 += i;
        }
        for (int i = 5; i < 1000; i += 5) {
            if (i % 3 != 0)
                sum1 += i;
        }
        System.out.println("Result1 = " + sum1);
        System.out.println("Time (ms) = " + (System.currentTimeMillis() - t));
    }
    
}
