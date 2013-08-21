/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ProjectEuler.P230_239;

import java.util.HashMap;
import raytracer.IFCMath;

/**
 *
 * @author ismael.flores
 */
public class Problem231 {
    private static void fusionar(HashMap<Long, Long> to, HashMap<Long, Long> from) {
        for (Long pf : from.keySet()) {
            if (to.containsKey(pf)) {
                to.put(pf, to.get(pf) + from.get(pf));
            }
            else {
                to.put(pf, from.get(pf));
            }
        }
    }

    private static void simplificar(HashMap<Long, Long> to, HashMap<Long, Long> from) {
        for (Long pf : from.keySet()) {
            if (to.containsKey(pf)) {
                long l1 = to.get(pf);
                long l2 = from.get(pf);
                long l = (l1 <= l2) ? l1 : l2;
                if (l1 - l <= 0)
                    to.remove(pf);
                else
                    to.put(pf, l1 - l);
            }
        }
    }
    
    /*
    The prime factorisation of binomial coefficients

    The binomial coefficient ^10C_3 = 120.
    120 = 2^3 × 3 × 5 = 2 × 2 × 2 × 3 × 5, and 2 + 2 + 2 + 3 + 5 = 14.
    So the sum of the terms in the prime factorisation of ^10C_3 is 14.

    Find the sum of the terms in the prime factorisation of ^20000000C_15000000.
    */
    public static void problem231(long N, long K) {
        HashMap<Long, Long> pfn = new HashMap<>();
        HashMap<Long, Long> pfk = new HashMap<>();
        long FN = K + 1;
        long TK = N - K;
        for (long nn = FN; nn <= N; nn++) {
            fusionar(pfn, IFCMath.primeFactorization(nn));
        }
        for (long kk = 1; kk <= TK; kk++) {
            fusionar(pfk, IFCMath.primeFactorization(kk));            
        }
        simplificar(pfn, pfk);
        long total = 0;
        for (Long F : pfn.keySet()) {
            total += F * pfn.get(F);
        }
        System.out.println(total);
    }
}
