/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ProjectEuler.P230_239;

/**
 *
 * @author ismael.flores
 */
public class Problem235 {
    /*    
    An Arithmetic Geometric sequence

    Given is the arithmetic-geometric sequence u(k) = (900-3k)r^(k-1).
    Let s(n) = Σ k=1...n u(k).

    Find the value of r for which s(5000) = -600,000,000,000.

    Give your answer rounded to 12 places behind the decimal point.
    */
    public static void problem235(double N) {
        double R = 1.0023221086328;
        while (R <= 1.0023221086329) {
            double aux = 900.0 * (1 - Math.pow(R, N)) / (1 - R);
            aux = aux - 3.0 * (1 - Math.pow(R, N + 1.0)) / ((1 - R) * (1 - R));
            aux = aux + 3.0 * (N + 1.0) * Math.pow(R, N) / (1 - R);
            System.out.println("r = " + R + "; s(" + N + ") = " + aux);
            R += 0.00000000000001;
        }
    }
}
