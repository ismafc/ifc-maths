/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package raytracer;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.MathContext;
import java.math.RoundingMode;
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
        if  (n != 1L)
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
     * Calculates the logarithm in provided base 'base' of 'x' with a precission
     * of 'decimals' (returned value is trunked)
     * @param base base of logarithm to calculate
     * @param x value which we want to calculate the logarithm
     * @param decimals number of decimals of the returned value
     * @return A BigDecimal with logarithm in base 'base' of 'x' with 'decimals' decimals of precission
     */
    public static BigDecimal log(int base, BigInteger x, int decimals) {
        BigDecimal result = BigDecimal.ZERO;

        BigDecimal input = new BigDecimal(x.toString());
        int scale = input.precision() + decimals + 1;

        int maxite = 10000;
        BigDecimal maxError_BigDecimal = new BigDecimal(BigInteger.ONE, decimals + 2);

        BigDecimal two_BigDecimal = new BigDecimal("2");
        BigDecimal base_BigDecimal = new BigDecimal(base);

        while (input.compareTo(base_BigDecimal) == 1) {
            result = result.add(BigDecimal.ONE);
            input = input.divide(base_BigDecimal, scale, RoundingMode.UP);
        }

        BigDecimal fraction = new BigDecimal("0.5");
        input = input.multiply(input);
        BigDecimal resultplusfraction = result.add(fraction);
        while (resultplusfraction.compareTo(result) == 1 && input.compareTo(BigDecimal.ONE) == 1 && maxite > 0) {
            if (input.compareTo(base_BigDecimal) == 1) {
                input = input.divide(base_BigDecimal, scale, RoundingMode.UP);
                result = result.add(fraction);
            }
            input = input.multiply(input);
            fraction = fraction.divide(two_BigDecimal, scale, RoundingMode.UP);
            resultplusfraction = result.add(fraction);
            if (fraction.abs().compareTo(maxError_BigDecimal) == -1)
                break;
            maxite--;
        }

        MathContext a_MathContext = new MathContext(decimals + result.precision() - result.scale(), RoundingMode.DOWN);
        return result.round(a_MathContext);
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
     * Calculates factorization for 'n' ('n' could be a big integer)
     * @param n value to factorize
     * @return HashMap cotaining factorization. Keys are prime factors and values are exponents.
     */
    public static HashMap<BigInteger, BigInteger> primeFactorization(BigInteger n) {
        HashMap<BigInteger, BigInteger> factors = new HashMap<>();
        BigInteger i = new BigInteger("2");
        BigInteger ii = i.multiply(i);
        while (ii.compareTo(n) <= 0) {
            BigInteger occurrences = BigInteger.ZERO;
            while (n.mod(i) == BigInteger.ZERO) {
                occurrences = occurrences.add(BigInteger.ONE);
                n = n.divide(i);
            }
            if (occurrences.compareTo(BigInteger.ZERO) > 0) {
                factors.put(i, occurrences);
            }
            i = i.add(BigInteger.ONE);
            ii = i.multiply(i);
        }
        if (n.compareTo(BigInteger.ONE) > 0) {
            factors.put(n, BigInteger.ONE);
        }
        return factors;
    }

    /**
     * Calculates greater common divisor between 'n1' and 'n2'. Recursive.
     * If returned value is 1, both values are prime among them
     * n1 >= n2
     * @param n1 first value to check
     * @param n2 second value to check
     * @return greater common divisor found
     */
    public static BigInteger MCD(BigInteger n1, BigInteger n2) {
        if (n2.equals(BigInteger.ZERO))
            return n1;
        return MCD(n2, n1.mod(n2));
    }

    /**
     * Calculates greater common divisor between 'n1' and 'n2'. Recursive.
     * If returned value is 1, both values are prime among them
     * n1 >= n2
     * @param n1 first value to check
     * @param n2 second value to check
     * @return greater common divisor found
     */
    public static long MCD1(long n1, long n2) {
        if (n2 == 0)
            return n1;
        return MCD1(n2, n1 % n2);
    }
    
    /**
     * Calculates greater common divisor between 'n1' and 'n2'.
     * If returned value is 1, both values are prime among them
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
     * Calculates Least common multiple between 'n1' and 'n2'.
     * If returned value is n1 * n2, both values are prime among them
     * @param n1 first value to check
     * @param n2 second value to check
     * @return Least common multiple found
     */
    public static long MCM(long n1, long n2) {
        return (n1 * n2) / MCD(n1, n2);
    }

    /**
     * Calculates Least common multiple between 'n1' and 'n2'.
     * If returned value is n1 * n2, both values are prime among them
     * @param n1 first value to check
     * @param n2 second value to check
     * @return Least common multiple found
     */
    public static long MCM1(long n1, long n2) {
        return (n1 * n2) / MCD1(Math.max(n1, n2), Math.min(n1, n2));
    }

    /**
     * Calculates Least common multiple between 'n1' and 'n2'.
     * If returned value is n1 * n2, both values are prime among them
     * @param n1 first value to check
     * @param n2 second value to check
     * @return Least common multiple found
     */
    public static BigInteger MCM(BigInteger n1, BigInteger n2) {
        return n1.multiply(n2).divide(MCD(n1.max(n2), n1.min(n2)));
    }
    
    /**
     * Calculates exponentiation 'n'^'e'
     * @param n base for exponentiation
     * @param e exponent (or index or power)
     * @return Exponentiation 'n'^'e', that is, n x n x ... x n ('e' times)
     */
    public static long lpow(long n, long e) {
        long pow = 1L;
        while (e > 0) {
            pow *= n;
            e--;
        }
        return pow;
    }

    /**
     * Calculates a new pascal row in pascal's triangle
     * @param pascalRow las known pascals's triangle row
     * @return ArrayList with new pascal row before 'pascalRow'
     */
    public static ArrayList<Long> getNewPascalRow(ArrayList<Long> pascalRow) {
        ArrayList<Long> newPascalRow = new ArrayList<>();
        newPascalRow.add(1L);
        for (int i = 0; i < pascalRow.size() - 1; i++) {
            newPascalRow.add(pascalRow.get(i) + pascalRow.get(i + 1));
        }
        newPascalRow.add(1L);
        return newPascalRow;
    }    
    
    /**
     * Calculates Euler's totient funcion (also phi function) for 'n'.
     * Is an arithmetic function that counts the positive integers 
     * less than or equal to 'n' that are relatively prime to 'n'.
     * @param n value to calculate totient
     * @return Number of positive integers less than or equal to 'n' that are relatively prime to 'n'.'
     */
    public static long totient(long n) {
        long t = 1;
        HashMap<Long, Long> primeFactorization = IFCMath.primeFactorization(n);
        if (n <= 0)
            return Long.MIN_VALUE;
        for (Long pf : primeFactorization.keySet()) {
            if (primeFactorization.size() == 1) {
                return (pf - 1) * IFCMath.lpow(pf, primeFactorization.get(pf) - 1);
            }
            t *= totient(IFCMath.lpow(pf, primeFactorization.get(pf)));
        }
        return t;
//        
//        También podriamos hacerlo aplicando phi(n) = n * Pp|n(1 - 1 / p)
//
//        double t = 1.0;
//        if (n <= 0)
//            return Long.MIN_VALUE;
//        ArrayList<Long> primeFactors = IFCMath.primeFactors(n);
//        for (Long pf : primeFactors) {
//            t *= (1.0 - 1.0/(double)pf);
//        }
//        return (long)(t * n);
//
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
     * Calculates factorial for given parameter as big as you want
     * factorial(n) = n * (n - 1) * (n - 2) * ... * 3 * 2
     * @param n value for which calculate the factorial
     * @return factorial of 'n'
     */
    public static BigInteger factorial(BigInteger n) {
        BigInteger prod = BigInteger.ONE;
        BigInteger i = new BigInteger("2");
        while (i.compareTo(n) == -1 || i.compareTo(n) == 0) {
            prod = prod.multiply(i);
            i = i.add(BigInteger.ONE);
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

    /**
     * Calculates binomial coefficient. Also, for a set of 'x' elements, 
     * number of distinct k-elements subsets of it that can be formed.
     * binomial(x, k) = x! / (k! * (x - k)!)
     * @param x biggest long (number of vaules in set)
     * @param k lowest long (power of polynomial expansion or elements of subsets)
     * @return long with coeficient of n^k term in the polynomial expansion of (1 + x)^k or,
     * also, number of distinct k-elements subsets from a x-elements subset that can be formed
     */
    public static long binomial(long x, long k) {
        if (x < k)
            return Long.MIN_VALUE;
        return IFCMath.factorial(x) / (IFCMath.factorial(k) * IFCMath.factorial(x - k));
    }

    /**
     * Calculates binomial coefficient. Also, for a set of 'x' elements, 
     * number of distinct k-elements subsets of it that can be formed.
     * binomial(x, k) = x! / (k! * (x - k)!)
     * @param x biggest BigInteger (number of vaules in set)
     * @param k lowest BigInteger (power of polynomial expansion or elements of subsets)
     * @return BigInteger with coeficient of n^k term in the polynomial expansion of (1 + x)^k or,
     * also, number of distinct k-elements subsets from a x-elements subset that can be formed
     */
    public static BigInteger binomial(BigInteger x, BigInteger k) {
        if (x.compareTo(k) == -1)
            return null;
        return IFCMath.factorial(x).divide(IFCMath.factorial(k).multiply(IFCMath.factorial(x.subtract(k))));
    }

    /**
     * Calculates first 'steps' of Mandelbrot set sequence values 
     * for a provided Complex 'c' (it doesn't matter if it is divergent or 
     * convergent -really mandelbrot set-). 
     * returns the last value calculated. Mandelbrot set is:
     * Z(0) = 'i' (tipically 0+0i)
     * Z(n+1) = Z(n)^2 + 'c'
     * @param i Complex value with initial value
     * @param c Complex value that defines Mandelbrot set
     * @param steps Number of values to calculate
     * @return Complex with 'steps' value of mandelbrot set for 'c'
     */
    public static Complex mandelbrot(Complex i, Complex c, long steps) {
        Complex aux = i;
        while (steps > 1) {
            aux = aux.multiply(aux).add(c);
            steps--;
        }
        return aux;
    }

    /**
     * Calculates if provided Complex 'c' allow to Mandelbrot set. 
     * This function explores first 'maxSteps' values and check if
     * it tends to infinity (module greater than 2) in these first values or not.
     * Z(0) = 'i' (tipically 0+0i)
     * Z(n+1) = Z(n)^2 + 'c'
     * @param i Complex value with initial value
     * @param c Complex value that defines Mandelbrot set
     * @param maxSteps Maximum number of values to check
     * @return number of values checked. If this value is equal to 'maxSteps', 
     * 'c' is an element of Mandelbrot set
     */
    public static int isMandelbrot(Complex i, Complex c, int maxSteps) {
        Complex aux = i;
        int steps = 1;
        ArrayList<Complex> values = new ArrayList<>();
        values.add(aux);
        while (aux.abs() <= 2.0 && steps < maxSteps) {
            aux = aux.multiply(aux).add(c);
            if (values.contains(aux))
                return maxSteps;
            values.add(aux);
            steps++;
        }
        return steps;
    }

    /**
     * Calculates the maximum sum of adjacent numbers in the provided array of longs
     * @param numbers array of longs where we will find
     * @return maximum sum of adjacent numbers found
     */
    public static long max_sum_adjacent_numbers(long[] numbers) {
        int i = 0;
        long max_sum = Long.MIN_VALUE;
        while (i < numbers.length) {
            // Find next value > 0
            while (i < numbers.length && numbers[i] < 0) {
                if (numbers[i] > max_sum)
                    max_sum = numbers[i];
                i++;
            }
            // Calculate next sums until it is less than 0
            long act_sum = 0;
            while (i < numbers.length && act_sum >= 0) {
                act_sum += numbers[i];
                if (act_sum > max_sum)
                    max_sum = act_sum;
                i++;
            }
        }
        return max_sum;
    }
    
}
