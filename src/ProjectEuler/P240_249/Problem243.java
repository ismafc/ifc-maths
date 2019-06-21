/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ProjectEuler.P240_249;

import java.util.ArrayList;
import Library.IFCMath;

/**
 *
 * @author ismael.flores
 */
public class Problem243 {
    
    private static void pgroups(ArrayList<Long> prods, ArrayList<Long> posibles, long prod, long g) {
        if (g > 0) {
            long nprod = prod;
            for (long d : posibles) {
                ArrayList<Long> np = new ArrayList<Long>(posibles);
                for (int i = 0; i < np.size(); i++) {
                    if (np.get(i) <= d) {
                        np.remove(i);
                        i--;
                    }
                }
                prod = nprod * d;
                pgroups(prods, np, prod, g - 1);
            }
        }
        else
            prods.add(prod);
    }
    
    /**
     * We shall define the resilience of a denominator 'd', resilence(d), 
     * to be the ratio of its proper fractions that are resilient.
     * We shall call a fraction that cannot be cancelled down a resilient fraction.
     * A positive fraction whose numerator is less than its denominator is called a proper fraction.
     * For any denominator, d, there will be d−1 proper fractions.
     * For example: resilience(12) = 4 / 11;
     * @param d denominator to check resilience
     * @return long with numerator 'n' of fraction n / (d - 1)
     */
    private static long resilience(long d) {
        long n = d - 1;
        ArrayList<Long> factors = IFCMath.primeFactors(d);
        factors.remove(1L);
        factors.remove(d);
        // We have to substract and add 
        for (long g = 1; g <= factors.size(); g++) {
            long sign = ((g % 2 == 0) ? 1 : -1);
            ArrayList<Long> prods = new ArrayList<>();
            pgroups(prods, factors, 1, g);
            for (long f : prods) {
                n = n + sign * ((d - 1) / f);
            }
        }
        return n;
    }

    /*    
    Resilience

    A positive fraction whose numerator is less than its denominator is called a proper fraction.
    For any denominator, d, there will be d−1 proper fractions; for example, with d = 12:
    1/12 , 2/12 , 3/12 , 4/12 , 5/12 , 6/12 , 7/12 , 8/12 , 9/12 , 10/12 , 11/12 .

    We shall call a fraction that cannot be cancelled down a resilient fraction.
    Furthermore we shall define the resilience of a denominator, R(d), to be the ratio of its proper fractions that are resilient; for example, R(12) = 4/11 .
    In fact, d = 12 is the smallest denominator having a resilience R(d) < 4/10 .

    Find the smallest denominator d, having a resilience R(d) < 15499/94744 .
    */
    public static void problem243() {
//        Producto de primos
//        R(2) = 1 / 1
//        R(6) = 2 / 5
//        R(30) = 8 / 29
//        R(210) = 48 / 209
//        R(2310) = 480 / 2309
//        R(30030) = 5760 / 30029
//        R(510510) = 92160 / 510509
//        R(9699690) = 1658880 / 9699689
//        R(223092870) = 36495360 / 223092869
//        R(6469693230) = 1021870080 / 6469693229

//        R(223092870) = 36495360 / 223092869
//        R(446185740) = 72990720 / 446185739
//        R(669278610) = 109486080 / 669278609
//        R(892371480) = 145981440 / 892371479
        
//        Objetivo = 15499 / 94744

        long MN = 15499;
        long MD = 94744;

        ArrayList<Long> primes = new ArrayList<Long>();
        long D = 2L;
        int index = 0;
        for (long P = 3L; P < 100L; P++) {
            if (IFCMath.isPrime(P))
                primes.add(P);
        }

/*        
        int index = 2;
        long D = 223092870L;        
        long BASE = 223092870L;
 */       
        long N = resilience(D);
        while (N * MD >= (D - 1) * MN) {
            System.out.println("R(" + D + ") = " + N + " / " + (D - 1));
            
            //D = BASE * index;
            D *= primes.get(index);
            
            N = resilience(D);
            index++;
        }
        System.out.println("R(" + D + ") = " + N + " / " + (D - 1));
    }    
}
