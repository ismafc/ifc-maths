/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ProjectEuler.P140_149;

import java.util.ArrayList;
import Library.IFCMath;

/**
 *
 * @author ismael.flores
 */
public class Problem146 {
    /*
    The smallest positive integer n for which the numbers:
    n^2+1, n^2+3, n^2+7, n^2+9, n^2+13, and n^2+27 are consecutive primes is 10. 
    The sum of all such integers n below one-million is 1242490.
    What is the sum of all such integers n below 150 million?
    */
    public static void problem146(Long max) {
        ArrayList<Long> primes = new ArrayList<>();        
        Long sum = 0L;
        for (Long n = 3L; n < 10000L; n += 2L) {
            if (IFCMath.isPrime(n))
                primes.add(n);
        }
        for (Long n = 2L; n < max; n += 2L) {
            Long nn1 = n * n + 1;
            Long nn3 = n * n + 3;
            Long nn7 = n * n + 7;
            Long nn9 = n * n + 9;
            Long nn13 = n * n + 13;
            Long nn27 = n * n + 27;
            boolean allPosiblePrimes = true;
            for (Long p : primes) {
                if (nn1 % p == 0 && nn1 != p) {
                    allPosiblePrimes = false;
                    break;
                }
                if (nn3 % p == 0 && nn3 != p) {
                    allPosiblePrimes = false;
                    break;
                }
                if (nn7 % p == 0 && nn7 != p) {
                    allPosiblePrimes = false;
                    break;
                }
                if (nn9 % p == 0 && nn9 != p) {
                    allPosiblePrimes = false;
                    break;
                }
                if (nn13 % p == 0 && nn13 != p) {
                    allPosiblePrimes = false;
                    break;
                }
                if (nn27 % p == 0 && nn27 != p) {
                    allPosiblePrimes = false;
                    break;
                }
            }
            if (allPosiblePrimes) {
                if (IFCMath.isPrime(n * n + 1) && 
                    IFCMath.isPrime(n * n + 3)) {
                    if (!IFCMath.isPrime(n * n + 5)) {
                        if (IFCMath.isPrime(n * n + 7) &&
                            IFCMath.isPrime(n * n + 9)) {
                            if (!IFCMath.isPrime(n * n + 11)) {
                                if (IFCMath.isPrime(n * n + 13)) {
                                    if (!IFCMath.isPrime(n * n + 15) && 
                                        !IFCMath.isPrime(n * n + 17) && 
                                        !IFCMath.isPrime(n * n + 19) &&
                                        !IFCMath.isPrime(n * n + 21) && 
                                        !IFCMath.isPrime(n * n + 23) && 
                                        !IFCMath.isPrime(n * n + 25)) {
                                        if (IFCMath.isPrime(n * n + 27)) {
                                            sum += n;
                                        }
                                    }
                                }
                            }                       
                        }
                    }
                }
            }
        }
        System.out.println("Suma = " + sum);
    }    
}
