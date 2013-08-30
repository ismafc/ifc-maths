/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ProjectEuler.P210_219;

import java.util.ArrayList;
import java.util.HashMap;
import raytracer.IFCMath;

/**
 *
 * @author Isma
 */
public class Problem214 {
/*
Totient Chains
Problem 214

Let φ be Euler's totient function, i.e. for a natural number n, φ(n) is the number of k, 1 ≤ k ≤ n, for which gcd(k,n) = 1.

By iterating φ, each positive integer generates a decreasing chain of numbers ending in 1.
E.g. if we start with 5 the sequence 5,4,2,1 is generated.
Here is a listing of all chains with length 4:
5,4,2,1
7,6,2,1
8,4,2,1
9,6,2,1
10,4,2,1
12,4,2,1
14,6,2,1
18,6,2,1

Only two of these chains start with a prime, their sum is 12.

What is the sum of all primes less than 40000000 which generate a chain of length 25?
*/    
    public static void problem214(long LIMIT, long CHAINSIZE) {
        long sum = 0;
        HashMap<Long, ArrayList<Long>> chains = new HashMap<>();
        for (long l = 2; l <= LIMIT; l++) {
            if (IFCMath.isPrime(l)) {
                ArrayList<Long> chain = new ArrayList<>();
                chain.add(l);
                long totient = IFCMath.totient(l);
                while (totient > 1) {
                    if (chains.containsKey(totient)) {
                        chain.addAll(chains.get(totient));
                        break;
                    }
                    chain.add(totient);
                    totient = IFCMath.totient(totient);
                }
                if (chain.get(chain.size() - 1) != 1) {
                    chain.add(1L);
                }
                chains.put(l, chain);
                if (chain.size() == CHAINSIZE) {
                    sum += l;
                }
            }
        }
        System.out.println("Suma de cadenas de " + CHAINSIZE + " menores que " + LIMIT + " = " + sum);
    }    
}
