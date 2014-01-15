/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ProjectEuler.P190_199;

/**
 *
 * @author ismael.flores
 */
public class Problem197 {

    /*    
    Given is the function f(x) = floor(2^30.403243784-x2) × 10^-9,
    the sequence un is defined by u0 = -1 and un+1 = f(un).

    Find un + un+1 for n = 10^12.
    Give your answer with 9 digits after the decimal point.
    */
    public static void problem197() {
        Double un = -1.0;
        Double last1 = 0.0;
        Double last2 = 0.0;
        Boolean found = false;
        while (!found) {
            Double un1 = Math.floor(Math.pow(2, 30.403243784 - un * un)) / 1000000000.0;
            if (last1.equals(un) && last2.equals(un1)) {
                found = true;
                System.out.println("Found! " + last1 + "; " + last2 + " = " + (last1+last2));
            }
            last1 = last2;
            last2 = un;
            un = un1;
        }
    }    
}
