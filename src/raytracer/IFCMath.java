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
     * @return TRUE if value is prime and FALSE elsewhere
     */
    public static boolean isPrime(Long n) {
        return isPrime(n.longValue());
    }

    /**
     * Check if 'n' is semiprime (product of two, not necessarily distinct, 
     * prime numbers).
     * @param n value to test
     * @return TRUE if value is semiprime and FALSE elsewhere
     */
    public static boolean isSemiprime(long n) {
        long occurrences = 0;
        for (long i = 2; i * i <= n; i++) {
            while (n % i == 0) {
                occurrences++;
                if (occurrences > 2)
                    return false;
                n /= i;
            }
            if (occurrences == 2 && n > 1)
                return false;
        }
        if (n > 1)
            occurrences++;
        return occurrences == 2;
    }
    
    /**
     * Calculates all divisors for 'n'.
     * @param n value to check divisors
     * @return Ordered array with all divisors of 'n'
     */
    public static ArrayList<Long> divisors(long n) {
        ArrayList<Long> l1 = new ArrayList<>();
        ArrayList<Long> l2 = new ArrayList<>();
        
        // Calculamos el límite para los divisores 'complementarios'
        long limit = (long)Math.sqrt(n);
        
        // Añadimos el 1
        l1.add(1L);
        for (long i = 2; i <= limit; i++) {
            if (n % i == 0) {
                l1.add(i);
                if (i != n / i) {
                    // No es un cuadrado perfecto
                    l2.add(0, n / i);
                }
            }
        }
        l1.addAll(l2);
        
        // Añadimos 'n'
        l1.add(n);
        return l1;
    }
    
    /**
     * Calculates the integer part of square root of 'n'
     * @param n value to calculate the square root
     * @return A BigInteger with integer part of square root of 'n'
     */
    public static BigInteger sqrt(BigInteger n) {
        BigInteger a = BigInteger.ONE;
        BigInteger b = new BigInteger(n.shiftRight(5).add(new BigInteger("8")).toString());
        while (b.compareTo(a) >= 0) {
            BigInteger mid = new BigInteger(a.add(b).shiftRight(1).toString());
            if (mid.multiply(mid).compareTo(n) > 0) {
                b = mid.subtract(BigInteger.ONE);
            }
            else {
                a = mid.add(BigInteger.ONE);
            }
        }
        return a.subtract(BigInteger.ONE);
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
     * @param limit maximum value of a prime factor to return (if 'null' finds all prime factors)
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

    /**
     * Checks if given parameter is a perfect square or not
     * @param n value for which check if it's a perfect square
     * @return True if it's a perfect square and False if not
     */
    public static boolean isPerfectSquare(long n)
    {
        if (n < 0)
            return false;

        long tst = (long)(Math.sqrt(n) + 0.5);
        return tst*tst == n;
    }
    
    /**
     * Checks if given parameter is a perfect square or not
     * @param n value for which check if it's a perfect square
     * @return True if it's a perfect square and False if not
     */
    public static boolean isPerfectSquare(BigInteger n)
    {
        BigInteger tst = IFCMath.sqrt(n);
        tst = tst.multiply(tst);
        return tst.equals(n);
    }
}
