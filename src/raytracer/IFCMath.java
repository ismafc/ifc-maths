/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package raytracer;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * Implements math functions. Most of them static.
 * @author ismael.flores
 * @version 1.0
 */
public class IFCMath {
    
    /**
     * Check if 'n' is prime. 'n' must be positive (1 or more)
     * @param n value to test
     * @return TRUE if value is primer and FALSE elsewhere
     */
    public static boolean isPrime(long n) {
        if (n == 1) {
            return false;
        }
        if (n % 2 == 0) {
            return n == 2;
        }
        for (long i = 3; i <= Math.sqrt(n); i += 2) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }

    /**
     * Check if 'n' is prime.
     * @param n value to test
     * @return TRUE if value is primer and FALSE elsewhere
     */
    public static boolean isPrime(Long n) {
        return isPrime(n.longValue());
    }

    /**
     * Calculates all prime factors for 'n'
     * @param n value to factorize
     * @return Array with all prime factors for 'n'
     */
    public static ArrayList<Long> primeFactors(long n) {
        ArrayList<Long> factors = new ArrayList<>();
        for (long i = 2; i*i <= n; i++) {
            if (n % i == 0) {
                factors.add(i);
                while (n % i == 0) {
                    n /= i;
                }
            }
        }
        if (n > 1) {
            factors.add(n);
        }
        return factors;
    }

    /**
     * Calculates all prime factors for 'n'
     * @param n value to factorize
     * @param limit maximum value of a primer factor to return (if 'null' finds all prime factors)
     * @return Array with all prime factors for 'n'
     */
    public static ArrayList<BigInteger> primeFactors(BigInteger n, BigInteger limit) {
        ArrayList<BigInteger> factors = new ArrayList<>();
        BigInteger i = BigInteger.ONE.add(BigInteger.ONE);
        BigInteger i2 = i.multiply(i);
        while (i2.compareTo(n) <= 0) {
            if (limit != null && i.compareTo(limit) >= 0)
                break;
            if (n.mod(i) == BigInteger.ZERO) {
                factors.add(i);
                System.out.println(i);
                while (n.mod(i) == BigInteger.ZERO) {
                    n = n.divide(i);
                }
            }
            i = i.add(BigInteger.ONE);
            i2 = i.multiply(i);
        }
        if (n.compareTo(BigInteger.ONE) > 0) {
            factors.add(n);
        }
        return factors;
    }
    
    /**
     * Calculates factorization for 'n'
     * @param n value to factorize
     * @return HashMap cotaining factorization. Keys are prime factors and values are exponents.
     */
    public static HashMap<Long, Long> primeFactorization(long n) {
        HashMap<Long, Long> factors = new HashMap<>();
        for (long i = 2; i*i <= n; i++) {
            long occurrences = 0;
            while (n % i == 0) {
                occurrences++;
                n /= i;
            }
            if (occurrences > 0) {
                factors.put(i, occurrences);
            }
        }
        if (n > 1) {
            factors.put(n, 1L);
        }
        return factors;
    }
    
    /**
     * Calculates greater common divisor between 'n1' and 'n2'.
     * If returned value is 1, both values are prime between theirs
     * @param n1 first value to check
     * @param n2 second value to check
     * @return greater common divisor found
     */
    public static long MCD(long n1, long n2) {
        long lAux;
        if (n1 < n2) {
            lAux = n1;
            n1 = n2;
            n2 = lAux;
        }
        while (n1 % n2 != 0) {
            lAux = n1 % n2;
            n1 = n2;
            n2 = lAux;
        }
        return n2;
    }
    
    /**
     * Calculates factorial for given parameter.
     * factorial(n) = n * (n - 1) * (n - 2) * ... * 3 * 2
     * @param n value for which calculate the factorial
     * @return factorial of 'n'
     */
    public static long factorial(long n) {
        long prod = 1;
        for (long i = 2; i <= n; i++) {
            prod *= i;
        }
        return prod;
    }

}
